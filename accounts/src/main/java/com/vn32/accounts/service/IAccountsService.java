package com.vn32.accounts.service;

import com.vn32.accounts.dto.CustomerDto;
import org.springframework.data.repository.query.Param;

public interface IAccountsService {

    /**
     * @param customerDto - to create the customer account
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber
     * @return customer details based on the linked mobile number
     */
    public CustomerDto fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDto - customer details for which update required
     * @return boolean if update of customer details successful or not, account number update not allowed
     */
    boolean updateAccount(CustomerDto customerDto);


    /**
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of Account details is successful or not
     */
    boolean deleteAccount(String mobileNumber);

}
