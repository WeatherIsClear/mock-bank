package wheatherIsClear.bank.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wheatherIsClear.bank.entity.Bank;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankRepositoryTest {

    @Autowired
    BankRepository bankRepository;
    
    /**
     *
     */
    @Test
    @DisplayName("초기화 한 은행 세개가 들어가야 함")
    void findInitializedBankTest() throws Exception
    {
        //given
        List<Bank> all = bankRepository.findAll();
        //when
        //then
        Assertions.assertThat(all.size()).isEqualTo(3);
    }
        

}