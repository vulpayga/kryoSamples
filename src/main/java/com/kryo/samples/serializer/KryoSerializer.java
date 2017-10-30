package com.kryo.samples.serializer;


public class KryoSerializer implements Serializer {

  @Override
  public byte[] serialize(Object object) {
    return new byte[0];
  }

  @Override
  public Object deserialize(byte[] bytes) {
    return null;
  }
}
