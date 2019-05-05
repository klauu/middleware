#ifndef BANK_ICE
#define BANK_ICE

module Bank
{
  enum AccountType { STANDARD, PREMIUM };

  enum Currency{ JPY, GBP, USD, EUR, CAN, CHF, HKD, SEK, NZD };

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
    string key;
  };

  exception BaseException{
      string msg;
    };

  exception InvalidIDException extends BaseException{
    string id;
  };

  exception InvalidCurrencyException extends BaseException{
    Currency currency;
  };

  exception AuthenticationFailedException extends BaseException{
    string id;
  };

  interface ClientFactory{
    NewClientResponse newClient(UserData data, double balance) throws InvalidIDException;
  };

  interface Standard{
    double getBalance(string id) throws InvalidIDException, AuthenticationFailedException;
  };

  interface Premium extends Standard{
    LoanResponse getLoan(LoanRequest request) throws InvalidIDException, InvalidCurrencyException, AuthenticationFailedException;
  };

};

#endif
