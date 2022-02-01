package com.tencent.map.sdk.a;

import java.io.IOException;
import java.math.BigInteger;

final class fc$7
  extends ee<BigInteger>
{
  private static BigInteger b(fe paramfe)
    throws IOException
  {
    if (paramfe.f() == ff.i)
    {
      paramfe.k();
      return null;
    }
    try
    {
      paramfe = new BigInteger(paramfe.i());
      return paramfe;
    }
    catch (NumberFormatException paramfe)
    {
      throw new eb(paramfe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc.7
 * JD-Core Version:    0.7.0.1
 */