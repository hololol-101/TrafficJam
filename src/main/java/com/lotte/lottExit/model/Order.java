package com.lotte.lottExit.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int ono;
    private int cno;
    private int pno;
    private int cnt;

    private String status;

    public Order(int ono, int cno, int pno, int cnt, String status) {
        this.ono = ono;
        this.cno = cno;
        this.pno = pno;
        this.cnt = cnt;

        this.status = status;
    }

}
