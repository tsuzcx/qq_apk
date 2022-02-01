package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

final class FuturesGetChecked$1
  implements Function<Constructor<?>, Boolean>
{
  public Boolean apply(Constructor<?> paramConstructor)
  {
    return Boolean.valueOf(Arrays.asList(paramConstructor.getParameterTypes()).contains(String.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.FuturesGetChecked.1
 * JD-Core Version:    0.7.0.1
 */