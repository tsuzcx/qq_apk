package com.tencent.map.sdk.a;

import java.io.IOException;

final class fc$29
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
      short s = (short)paramfe.n();
      return Short.valueOf(s);
    }
    catch (NumberFormatException paramfe)
    {
      throw new eb(paramfe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc.29
 * JD-Core Version:    0.7.0.1
 */