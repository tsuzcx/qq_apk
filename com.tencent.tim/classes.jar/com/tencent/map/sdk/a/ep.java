package com.tencent.map.sdk.a;

import java.io.EOFException;
import java.io.IOException;

public final class ep
{
  public static dt a(fe paramfe)
    throws dx
  {
    int i = 1;
    try
    {
      paramfe.f();
      i = 0;
      paramfe = (dt)fc.P.a(paramfe);
      return paramfe;
    }
    catch (EOFException paramfe)
    {
      if (i != 0) {
        return dv.a;
      }
      throw new eb(paramfe);
    }
    catch (fh paramfe)
    {
      throw new eb(paramfe);
    }
    catch (IOException paramfe)
    {
      throw new du(paramfe);
    }
    catch (NumberFormatException paramfe)
    {
      throw new eb(paramfe);
    }
  }
  
  public static void a(dt paramdt, fg paramfg)
    throws IOException
  {
    fc.P.a(paramfg, paramdt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ep
 * JD-Core Version:    0.7.0.1
 */