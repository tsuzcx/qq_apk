package com.tencent.token;

import com.tencent.turingfd.sdk.base.Guava;
import java.util.Comparator;

public final class aei
  implements Comparator<Guava>
{
  public final int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (Guava)paramObject1;
    paramObject2 = (Guava)paramObject2;
    return (int)(paramObject1.Mc - paramObject2.Mc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aei
 * JD-Core Version:    0.7.0.1
 */