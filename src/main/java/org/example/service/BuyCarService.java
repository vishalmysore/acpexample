package org.example.service;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
@Agent(groupName ="carservices", groupDescription = "Provide 2 cars and compare them")
public class BuyCarService {

    @Action( description = "Buy a car with cash and get a heavy discount")
    public String buyCarWithCash(String carModel, int cashAmount) {
        log.info("Buying car model: " + carModel + " with cash amount: " + cashAmount);
        return "Bought " + carModel + " with cash amount: " + cashAmount;

    }

    @Action( description = "Buy a car with loan and get a moderate discount")
    public String buyCarWithLoan(String carModel, int loanAmount, int downPayment) {
        log.info("Buying car model: " + carModel + " with loan amount: " + loanAmount + " and down payment: " + downPayment);
        return "Bought " + carModel + " with loan amount: " + loanAmount + " and down payment: " + downPayment;
    }
}
