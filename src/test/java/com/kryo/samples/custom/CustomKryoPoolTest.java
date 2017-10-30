package com.kryo.samples.custom;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class CustomKryoPoolTest {
  @Test
  public void confirmReleaseIsCalledWhenUsedWithTryWithResources() throws Exception {
    CustomKryoPool customKryoPool = Mockito.spy(CustomKryoPool.class);
    CustomKryo customKryo;
    try (CustomKryo kryo = customKryoPool.borrow()) {
      customKryo = kryo;
    }
    verify(customKryoPool).release(customKryo);
  }
}