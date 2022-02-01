package com.huawei.hianalytics.ab.bc.ab;

import java.nio.charset.Charset;

public final class bc
{
  public static final Charset ab = Charset.forName("UTF-8");
  private static bc bc;
  private fg cd;
  
  public static bc ab()
  {
    if (bc == null) {
      bc();
    }
    return bc;
  }
  
  private static void bc()
  {
    try
    {
      if (bc == null) {
        bc = new bc();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public fg ab(ab paramab)
  {
    switch (bc.1.ab[paramab.ordinal()])
    {
    default: 
      com.huawei.hianalytics.ab.bc.ef.ab.bc("CryptFactory", "crypt type is other");
    }
    for (;;)
    {
      return this.cd;
      this.cd = new ab();
      continue;
      this.cd = new ef();
      continue;
      this.cd = new gh();
    }
  }
  
  public String ab(String paramString)
  {
    return cd.ab(paramString);
  }
  
  public String ab(char[] paramArrayOfChar, byte[] paramArrayOfByte)
  {
    return cd.ab(paramArrayOfChar, paramArrayOfByte);
  }
  
  public String bc(ab paramab)
  {
    return de.ab(paramab.ab());
  }
  
  public byte[] bc(String paramString)
  {
    return de.ab(paramString);
  }
  
  public static enum ab
  {
    private int ef;
    
    private ab(int paramInt)
    {
      this.ef = paramInt;
    }
    
    public int ab()
    {
      return this.ef;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.ab.bc
 * JD-Core Version:    0.7.0.1
 */