package com.tencent.turingfd.sdk.base;

import java.io.File;
import java.util.Comparator;

public class bp
  implements Comparator<File>
{
  public bp(bn parambn) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (File)paramObject1;
    paramObject2 = (File)paramObject2;
    long l = bn.a(paramObject1);
    return (int)(bn.a(paramObject2) - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bp
 * JD-Core Version:    0.7.0.1
 */