package com.tencent.mm.a;

import android.util.Base64;
import javax.crypto.Cipher;

public final class a
{
  private Cipher a;
  
  public final String a(String paramString)
  {
    try
    {
      Object localObject = Base64.decode(paramString, 0);
      localObject = new String(this.a.doFinal((byte[])localObject), "UTF8");
      return localObject;
    }
    catch (Exception localException)
    {
      return "[des]" + paramString + "|" + localException.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.a.a
 * JD-Core Version:    0.7.0.1
 */