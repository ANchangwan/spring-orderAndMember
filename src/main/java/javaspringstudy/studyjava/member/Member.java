package javaspringstudy.studyjava.member;


import lombok.*;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long id;
    private String name;
    private Enum grade;
}
