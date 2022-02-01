package com.tencent.token;

import com.tencent.turingfd.sdk.qps.Filbert;
import java.util.Comparator;

public final class aga
  implements Comparator<Filbert>
{
  public final int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (Filbert)paramObject1;
    paramObject2 = (Filbert)paramObject2;
    return (int)(paramObject1.c - paramObject2.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aga
 * JD-Core Version:    0.7.0.1
 */