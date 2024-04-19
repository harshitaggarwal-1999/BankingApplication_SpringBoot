package net.finance.banking.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AccountDto {
    private long id;
    private String AccountHolderName;
    private double balance;

}
