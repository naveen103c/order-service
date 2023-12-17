package com.naveen.orderservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Document
public class Order {

    @Id
    private String id;

    @NotEmpty(message = "Order Date is Mandatory")
    private Date orderDate;

}
