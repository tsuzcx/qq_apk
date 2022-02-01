package com.tencent.map.sdk.a;

import java.io.IOException;

final class fc$30
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
      int i = paramfe.n();
      return Integer.valueOf(i);
    }
    catch (NumberFormatException paramfe)
    {
      throw new eb(paramfe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc.30
 * JD-Core Version:    0.7.0.1
 */