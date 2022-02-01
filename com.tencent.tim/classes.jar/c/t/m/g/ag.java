package c.t.m.g;

import java.util.Random;

public final class ag
{
  private static final Random a = new Random();
  private static final a b = new a();
  
  public static void a(byte[] paramArrayOfByte, String paramString)
  {
    ai.a(3, "EncRsaAesUtil", "setPubKey version ".concat(String.valueOf(paramString)), null);
    b.a(paramArrayOfByte, paramString);
  }
  
  public static byte[] a()
  {
    byte[] arrayOfByte = new byte[16];
    a.nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  public static final class a
  {
    private ak a = new ak();
    private String b = "";
    private boolean c = false;
    
    public a()
    {
      a();
    }
    
    private void a()
    {
      a(ac.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDMi0gKCzapHg05OXTOlWf9sT20tJJ8C+h41HJZI+nGU2h4sdirRTUB7wdwRR1w604QZJmn55p4S9xBRVCZWIXX2kWmekr90vvvpQow55PYk1JyGXKz7a+yzQxmyEIsD4mtw+M7G76YQrgrjD42EcGH453xTUTdJGwjrn/eCJng6QIDAQAB"), "0000");
    }
    
    public final void a(byte[] paramArrayOfByte, String paramString)
    {
      ai.a(3, "RsaAes", "setPublicKey:" + paramArrayOfByte.length + "," + paramString + ", ignored:false", null);
      if ((paramString.length() != 4) || (ai.b(paramArrayOfByte)))
      {
        a();
        return;
      }
      this.b = paramString;
      this.a.a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.ag
 * JD-Core Version:    0.7.0.1
 */