package hello.aop.exam;

import hello.aop.exam.annotation.Retry;
import hello.aop.exam.annotation.Trace;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ExamRepository {
    private static int seq = 0;
    /**
     * 5번에 1번 실패하는 요청
     */
    @Trace // annotaion 기반으로 aop 작동
    @Retry(value = 4) // value 생략 가능
    public String save(String itemId) {
        seq++;
        if (seq % 5 == 0) {
            throw new IllegalStateException("예외 발생");
        }
        return "ok";
    }
}