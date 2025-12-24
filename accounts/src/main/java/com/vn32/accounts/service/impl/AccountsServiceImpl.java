package com.vn32.accounts.service.impl;

import com.vn32.accounts.constants.AccountsConstants;
import com.vn32.accounts.dto.AccountsDto;
import com.vn32.accounts.dto.CustomerDto;
import com.vn32.accounts.entity.Accounts;
import com.vn32.accounts.entity.Customer;
import com.vn32.accounts.exception.CustomerAlreadyExistException;
import com.vn32.accounts.exception.ResourceNotFoundException;
import com.vn32.accounts.mapper.AccountsMapper;
import com.vn32.accounts.mapper.CustomerMapper;
import com.vn32.accounts.repository.AccountsRepository;
import com.vn32.accounts.repository.CustomerRepository;
import com.vn32.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private CustomerRepository customerRepository;
    private AccountsRepository accountsRepository;

    /**
     * @param customerDto
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        //change to entity class
        Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());
        //check mobile number already exist or not
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistException("Customer already exist with given mobile number "+customerDto.getMobileNumber());
        }
        //save customer first
       Customer savedCustomer = customerRepository.save(customer);
       //create account
       accountsRepository.save(createNewAccount(savedCustomer));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);//generate 10 digit unique id
        newAccount.setAccountNumber(String.valueOf(randomAccNumber));
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }
    /**
     *
     * @param mobileNumber - input mobile number
     * @return Accounts details based on mobile number
     */
    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        //fetch customer by mobile number
       Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Customer","mobileNumber",mobileNumber)
        );
       //if customer found then find the account details
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                ()-> new ResourceNotFoundException("Accounts","customerId",customer.getCustomerId().toString())
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer,new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts,new AccountsDto()));
        return customerDto;
    }

    /**
     *
     * @param customerDto - customer details for which update required
     * @return boolean if update of customer details successful or not, account number update not allowed
     */
    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto accountsDto = customerDto.getAccountsDto();
        if(accountsDto !=null ){
            Accounts accounts = accountsRepository.findById(Long.valueOf(accountsDto.getAccountNumber())).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString()));
            AccountsMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountsRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString()));
            CustomerMapper.mapToCustomer(customerDto,customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return  isUpdated;
    }

    /**
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of Account details is successful or not
     */
    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }

}
