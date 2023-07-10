package com.kkot.blog.test;

import com.kkot.blog.model.RoleType;
import com.kkot.blog.model.User;
import com.kkot.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class DummyControllerTest {
    @Autowired // DI, 의존성 주입
    private UserRepository userRepository;

    @DeleteMapping("dummy/user/{id}")
    public String deleteUser(@PathVariable int id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return "삭제에 실패하였습니다. 데이터 베이스에 없는 id: " + id;
        }
        return "삭제되었습니다. id: " + id;
    }

    // password, email
    @Transactional // save 함수를 호출하지 않아도 update가 된다.
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser) { // @RequestBody: json 데이터를 받을 수 있음
        System.out.println("id: " + id);
        System.out.println("password: " + requestUser.getPassword());
        System.out.println("email: " + requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("수정에 실패했습니다.");
        });
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

//        userRepository.save(user);
        // 더티 체킹: 영송석 컨텍스트 내의 객체에 대해 변경을 감지하여 flush 시 적용
        return user;
    }

    @GetMapping("/dummy/user/all")
    public List<User> list() {
        return userRepository.findAll();
    }

    // JPA의 페이징 기능
    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> pagingUsers = userRepository.findAll(pageable);
        List<User> users = pagingUsers.getContent();

        if(pagingUsers.isFirst()){
            // 어쩌구...
        }
        
        return users;
    }

//    @GetMapping("/dummy/user")
//    public List<User> pageList(@PageableDefault(size = 1, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
//        List<User> users = userRepository.findAll(pageable).getContent();
//        return users;
//    }

    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        // DB에서 find에 실패하면 null이 반환
        // 프로그램에 문제가 생김
        // Optinal로 User 객체를 감싸서 반환 -> null인지 아닌지 판단해서 사용!
        
        // orElseGet 메서드: 함수의 반환값이 null일 경우 반환할 값을 정의함
//        User user = userRepository.findById(id).orElseGet(new Supplier<User>() { // 인터페이스 Supplier의 익명 클래스 생성
//            @Override
//            public User get() {
//                return new User();
//            }
//        });

        // orElseThrow 메서드
//        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
//            @Override
//            public IllegalArgumentException get() {
//                return new IllegalArgumentException("해당 유저는 없습니다. id: " + id);
//            }
//        });
        // => 람다식으로 바꾸면
        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("해당 유저는 없습니다. id: " + id);
        });
        // 요청: 웹브라우저
        // user 객체 == 자바 객체
        // => 웹브라우저는 자바 객체를 이해하지 못함
        // => 웹브라우저가 이해할 수 있는 데이터(json)으로 변환
        // 컨트롤러 응답 시 스프링부트의 MassageConverter가 작동:  Jackson 라이브러리를 호출해서 자바 오브젝트를 json으로 변환
        return user;
    }
    @PostMapping("/dummy/join")
    public String join(User user) { // 클래스로 파라미터를 받기 위해서는 해당 클래스에 setter가 생성돼있어야 한다.
        System.out.println("-----------------");
        System.out.println("INSERT: ");
        System.out.println(user);
        System.out.println("-----------------");
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
