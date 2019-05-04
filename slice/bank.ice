#ifndef BANK_ICE
#define BANK_ICE

module Bank
{
  enum AccountType { STANDARD, PREMIUM };

  enum Currency{ PLN, GBD, USD };

  struct UserData {
    string name;
    string surname;
    string id;
    double monthlyIncome;
  };

  struct Client{
    UserData data;
    AccountType type;
    double balance;
  };

  struct LoanRequest{
    string id;
    Currency cur;
    double amount;
    int time;
  };

  struct LoanResponse{
      bool agreed;
      double ForeignCurrency;
      double NativeCurrency;
    };

  struct NewClientResponse{
    AccountType type;
    int key;
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
    Client newClient(UserData data, double balance) throws InvalidIDException;
  };

  interface Standard{
    double getBalance(string id) throws InvalidIDException;
  };

  interface Premium extends Standard{
    LoanResponse getLoan(LoanRequest request) throws InvalidIDException, InvalidCurrencyException;
  };

};

#endif
