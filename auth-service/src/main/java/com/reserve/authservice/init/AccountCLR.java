package com.reserve.authservice.init;

import com.reserve.authservice.dao.AccountRepository;
import com.reserve.authservice.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.stream.Stream;

/**
 * Created by linxing on 29/07/2017.
 */
public class AccountCLR implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... strings) throws Exception {
        // return args -> {

            Stream.of("jlong,spring", "dsyer,cloud", "pwebb,boot", "shuai,shuai")
                    .map(x -> x.split(","))
                    .forEach(tpl -> accountRepository.save(new Account(tpl[0], tpl[1], true)));

            accountRepository.findAll().forEach(System.out::println);


        // }
    }
}
