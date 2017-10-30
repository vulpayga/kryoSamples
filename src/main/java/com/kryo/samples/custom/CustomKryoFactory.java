package com.kryo.samples.custom;

import com.esotericsoftware.kryo.pool.KryoFactory;

public class CustomKryoFactory implements KryoFactory {

  private final CustomKryoPool customKryoPool;

  public CustomKryoFactory(CustomKryoPool customKryoPool) {
    this.customKryoPool = customKryoPool;
  }

  @Override
  public CustomKryo create() {
    return new CustomKryo(customKryoPool);
  }

}
