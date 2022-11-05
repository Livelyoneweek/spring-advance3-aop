package hello.aop.internalcall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

/**
 * ObjectProvider(Provider), ApplicationContext를 사용해서 지연(LAZY) 조회
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CallServiceV2 {

    // private final ApplicationContext applicationContext;
    private final ObjectProvider<CallServiceV2> callServiceProvider; //빈 지연조회로 (어플리케이션컨텍스트에서) 꺼낼 때 사용
    //순환 사이클 안생김

    public void external() {
        log.info("call external");
        // CallServiceV2 callServiceV2 = applicationContext.getBean(CallServiceV2.class);
        CallServiceV2 callServiceV2 = callServiceProvider.getObject();
        callServiceV2.internal(); //외부 메서드 호출
    }

    public void internal() {
        log.info("call internal");
    }
}
