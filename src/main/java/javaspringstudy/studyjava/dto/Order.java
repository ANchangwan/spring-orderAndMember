package javaspringstudy.studyjava.dto;


import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;




}
