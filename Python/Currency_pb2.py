# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: Currency.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='Currency.proto',
  package='',
  syntax='proto3',
  serialized_options=None,
  serialized_pb=_b('\n\x0e\x43urrency.proto\"l\n\x0cRatesRequest\x12#\n\x03\x63ur\x18\x01 \x01(\x0e\x32\x16.RatesRequest.Currency\"7\n\x08\x43urrency\x12\x07\n\x03PLN\x10\x00\x12\x07\n\x03USD\x10\x01\x12\x07\n\x03HUF\x10\x02\x12\x07\n\x03\x45UR\x10\x03\x12\x07\n\x03GBP\x10\x04\"\x1d\n\x0cRatesRespond\x12\r\n\x05value\x18\x01 \x01(\x01\x32K\n\x13\x43urrencyRatesStream\x12\x34\n\x10GetCurrencyRates\x12\r.RatesRequest\x1a\r.RatesRespond\"\x00\x30\x01\x62\x06proto3')
)



_RATESREQUEST_CURRENCY = _descriptor.EnumDescriptor(
  name='Currency',
  full_name='RatesRequest.Currency',
  filename=None,
  file=DESCRIPTOR,
  values=[
    _descriptor.EnumValueDescriptor(
      name='PLN', index=0, number=0,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='USD', index=1, number=1,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='HUF', index=2, number=2,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='EUR', index=3, number=3,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='GBP', index=4, number=4,
      serialized_options=None,
      type=None),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=71,
  serialized_end=126,
)
_sym_db.RegisterEnumDescriptor(_RATESREQUEST_CURRENCY)


_RATESREQUEST = _descriptor.Descriptor(
  name='RatesRequest',
  full_name='RatesRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='cur', full_name='RatesRequest.cur', index=0,
      number=1, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
    _RATESREQUEST_CURRENCY,
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=18,
  serialized_end=126,
)


_RATESRESPOND = _descriptor.Descriptor(
  name='RatesRespond',
  full_name='RatesRespond',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='value', full_name='RatesRespond.value', index=0,
      number=1, type=1, cpp_type=5, label=1,
      has_default_value=False, default_value=float(0),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=128,
  serialized_end=157,
)

_RATESREQUEST.fields_by_name['cur'].enum_type = _RATESREQUEST_CURRENCY
_RATESREQUEST_CURRENCY.containing_type = _RATESREQUEST
DESCRIPTOR.message_types_by_name['RatesRequest'] = _RATESREQUEST
DESCRIPTOR.message_types_by_name['RatesRespond'] = _RATESRESPOND
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

RatesRequest = _reflection.GeneratedProtocolMessageType('RatesRequest', (_message.Message,), dict(
  DESCRIPTOR = _RATESREQUEST,
  __module__ = 'Currency_pb2'
  # @@protoc_insertion_point(class_scope:RatesRequest)
  ))
_sym_db.RegisterMessage(RatesRequest)

RatesRespond = _reflection.GeneratedProtocolMessageType('RatesRespond', (_message.Message,), dict(
  DESCRIPTOR = _RATESRESPOND,
  __module__ = 'Currency_pb2'
  # @@protoc_insertion_point(class_scope:RatesRespond)
  ))
_sym_db.RegisterMessage(RatesRespond)



_CURRENCYRATESSTREAM = _descriptor.ServiceDescriptor(
  name='CurrencyRatesStream',
  full_name='CurrencyRatesStream',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  serialized_start=159,
  serialized_end=234,
  methods=[
  _descriptor.MethodDescriptor(
    name='GetCurrencyRates',
    full_name='CurrencyRatesStream.GetCurrencyRates',
    index=0,
    containing_service=None,
    input_type=_RATESREQUEST,
    output_type=_RATESRESPOND,
    serialized_options=None,
  ),
])
_sym_db.RegisterServiceDescriptor(_CURRENCYRATESSTREAM)

DESCRIPTOR.services_by_name['CurrencyRatesStream'] = _CURRENCYRATESSTREAM

# @@protoc_insertion_point(module_scope)
