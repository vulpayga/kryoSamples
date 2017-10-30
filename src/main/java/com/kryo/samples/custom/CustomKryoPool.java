package com.kryo.samples.custom;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.pool.KryoPool;

// CustomKryoPool provides pooling for CustomKryo and auto release for try-with-resources.
public class CustomKryoPool {

  private final KryoPool kryoPool;

  public CustomKryoPool() {
    this.kryoPool =  new KryoPool.Builder(new CustomKryoFactory(this)).softReferences().build();
  }

  public CustomKryo borrow() {
    return (CustomKryo) kryoPool.borrow();
  }

  public void release(Kryo kryo) {
    kryoPool.release(kryo);
  }
}
