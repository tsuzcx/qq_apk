package com.tencent.map.sdk.a;

import java.io.IOException;

final class fc$31
  extends ee<Number>
{
  private static Number b(fe paramfe)
    throws IOException
  {
    if (paramfe.f() == ff.i)
    {
      paramfe.k();
      return null;
    }
    try
    {
      long l = paramfe.m();
      return Long.valueOf(l);
    }
    catch (NumberFormatException paramfe)
    {
      throw new eb(paramfe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc.31
 * JD-Core Version:    0.7.0.1
 */