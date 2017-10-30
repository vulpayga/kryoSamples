package com.kryo.samples.custom;

import com.esotericsoftware.kryo.Kryo;

// CustomKryo is an AutoCloseable version of Kryo, always use with try-with-resources
public class CustomKryo extends Kryo implements AutoCloseable {

  private final CustomKryoPool customKryoPool;

  public CustomKryo(CustomKryoPool customKryoPool) {
    this.customKryoPool = customKryoPool;
  }

  @Override
  public void close() throws Exception {
    customKryoPool.release(this);
  }
}
