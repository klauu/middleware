// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Currency.proto

package CurrencyPackage;

public final class CurrencyProto {
  private CurrencyProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Currency_RatesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Currency_RatesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Currency_RatesRespond_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Currency_RatesRespond_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016Currency.proto\022\010Currency\"\033\n\014RatesReque" +
      "st\022\013\n\003cur\030\001 \001(\t\"\035\n\014RatesRespond\022\r\n\005value" +
      "\030\001 \001(\0012]\n\023CurrencyRatesStream\022F\n\020GetCurr" +
      "encyRates\022\026.Currency.RatesRequest\032\026.Curr" +
      "ency.RatesRespond\"\0000\001B\027B\rCurrencyProtoP\001" +
      "\242\002\003HLWb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Currency_RatesRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Currency_RatesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Currency_RatesRequest_descriptor,
        new java.lang.String[] { "Cur", });
    internal_static_Currency_RatesRespond_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Currency_RatesRespond_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Currency_RatesRespond_descriptor,
        new java.lang.String[] { "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}