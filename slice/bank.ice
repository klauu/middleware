#ifndef BANK_ICE
#define BANK_ICE

module Bank
{
  enum AccountType { STANDARD, PREMIUM };

  enum Currency{ PLN, GBD, USD };

  struct Money{
    double val;
  };

  struct UserData {
    string name;
    string surname;
    string id;
    Money monthlyIncome;
  };

  struct Client{
    UserData data;
    AccountType type;
    Money balance;
  };

  struct LoanRequest{
    string id;
    Currency cur;
    Money amount;
    int time;
  };

  struct LoanResponse{
      bool agreed;
      Money ForeignCurrency;
      Money NativeCurrency;
    };

  exception InvalidIDException{
    string id;
    string msg;
  };

  exception InvalidCurrencyException{
    string id;
    string msg;
   };

  interface ClientFactory{
    Client newClient(UserData data, Money balance) throws InvalidIDException;
  };

  interface Standard{
    Money getBalance(string id) throws InvalidIDException;
  };

  interface Premium extends Standard{
    LoanResponse getLoan(LoanRequest request) throws InvalidIDException, InvalidCurrencyException;
  };

};

#endif
