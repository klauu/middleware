#python currency server

class CurrencyServer(Currency_pb2_grpc.CurrencyRatesStreamServicer):


  def GetCurrencyRates(self, request, context):
    cur = request.cur
    print(cur)
    resp = RatesRespond 
    resp.value = 4.55
    while true:
      yield resp
      sleep(3)
    