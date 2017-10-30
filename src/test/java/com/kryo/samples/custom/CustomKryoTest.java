package com.kryo.samples.custom;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class CustomKryoTest {
  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock
  private CustomKryoPool customKryoPool;

  @Test
  public void confirmReleaseIsCalledWhenUsedWithTryWithResources() throws Exception {
    CustomKryo customKryo;
    try (CustomKryo kryo = new CustomKryo(customKryoPool)) {
      customKryo = kryo;
    }
    verify(customKryoPool).release(customKryo);
  }

  @Test
  public void confirmNoCallToReleaseWithOutTryWithResources() throws Exception {
    CustomKryo kryo = new CustomKryo(customKryoPool);
    verifyNoMoreInteractions(customKryoPool);
  }
}