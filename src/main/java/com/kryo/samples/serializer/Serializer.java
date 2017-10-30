package com.kryo.samples.serializer;

public interface Serializer {

  byte[] serialize(Object object);

  Object deserialize(byte[] bytes);

}
