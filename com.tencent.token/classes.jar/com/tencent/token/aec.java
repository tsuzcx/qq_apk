package com.tencent.token;

import java.io.File;
import java.util.Comparator;

public final class aec
  implements Comparator<File>
{
  public final int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (File)paramObject1;
    paramObject2 = (File)paramObject2;
    long l = aea.a(paramObject1);
    return (int)(aea.a(paramObject2) - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aec
 * JD-Core Version:    0.7.0.1
 */