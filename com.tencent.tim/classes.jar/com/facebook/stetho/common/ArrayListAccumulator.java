package com.facebook.stetho.common;

import java.util.ArrayList;

public final class ArrayListAccumulator<E>
  extends ArrayList<E>
  implements Accumulator<E>
{
  public void store(E paramE)
  {
    add(paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.ArrayListAccumulator
 * JD-Core Version:    0.7.0.1
 */