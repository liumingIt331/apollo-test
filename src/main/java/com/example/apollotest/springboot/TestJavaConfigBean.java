package com.example.apollotest.springboot;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class TestJavaConfigBean {
    @Value("${timeout:100}")
    private int timeout;

    @Value("${batch:100}")
    private int batch;
}
