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
    internal_static_CurrencyPackage_RatesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CurrencyPackage_RatesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CurrencyPackage_RatesRespond_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CurrencyPackage_RatesRespond_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016Currency.proto\022\017CurrencyPackage\"\033\n\014Rat" +
      "esRequest\022\013\n\003cur\030\001 \001(\t\"*\n\014RatesRespond\022\013" +
      "\n\003cur\030\001 \001(\t\022\r\n\005value\030\002 \001(\0012k\n\023CurrencyRa" +
      "tesStream\022T\n\020GetCurrencyRates\022\035.Currency" +
      "Package.RatesRequest\032\035.CurrencyPackage.R" +
      "atesRespond\"\0000\001B\027B\rCurrencyProtoP\001\242\002\003HLW" +
      "b\006proto3"
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
    internal_static_CurrencyPackage_RatesRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_CurrencyPackage_RatesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CurrencyPackage_RatesRequest_descriptor,
        new java.lang.String[] { "Cur", });
    internal_static_CurrencyPackage_RatesRespond_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_CurrencyPackage_RatesRespond_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CurrencyPackage_RatesRespond_descriptor,
        new java.lang.String[] { "Cur", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}