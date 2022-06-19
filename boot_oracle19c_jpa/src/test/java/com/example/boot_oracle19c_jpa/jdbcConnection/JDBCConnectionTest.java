package com.example.boot_oracle19c_jpa.jdbcConnection;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootTest
@Transactional
@Log4j2
public class JDBCConnectionTest {

    private static final String DRIVER = "oracle.jdbc.OracleDriver"; //Connection을 구현한 클래스의 이름
    private static final String URL = "jdbc:log4jdbc:oracle:thin:@192.168.111.132:1521:DB19"; //mysql 서버 주소
    private static final String USER = "aki"; //계정
    private static final String PW = "111111"; // 비밀번호

    @Test //jUnit이 테스트함
    public void testConnection() throws Exception{
        Class.forName(DRIVER); //DRIVER라는 이름을 가진 클래스를 찾음

        //DB 계정과 연결된 객체를 Connection 클래스의 인스턴스인 con에 담음
        try(Connection con = DriverManager.getConnection(URL,USER,PW)){
            System.out.println(con); //연결된 계정 출력
        }catch(Exception e) { //연결이 되지 않은 예외처리
            e.printStackTrace();
        }
    }


}
