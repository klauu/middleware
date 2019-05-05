# middleware

slice2java --output-dir generated slice\bank.ice

protoc.exe -I=. --java_out=generated --plugin=ptoroc-gen-grpc-java=protoc-gen-grpc-java.exe --grpc-java_out=generated Currency.proto

@javax.annotation.processing.Generated

