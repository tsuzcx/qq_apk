public class aqcs
{
  public static aqcs a;
  private static byte[] gA = new byte[256];
  private static char[] s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  
  protected aqcs()
  {
    init();
  }
  
  public static aqcs a()
  {
    if (a == null) {}
    try
    {
      a = new aqcs();
      return a;
    }
    finally {}
  }
  
  public StringBuffer a(byte[] paramArrayOfByte)
  {
    int k = 0;
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    int j = 0;
    char c;
    while (k < paramArrayOfByte.length)
    {
      i = i << 8 | paramArrayOfByte[k] & 0xFF;
      j += 8;
      if (j > 5)
      {
        Object localObject = s;
        j -= 6;
        c = localObject[(i >> j)];
        if (c == 'i') {
          localObject = "ia";
        }
        for (;;)
        {
          localStringBuffer.append(localObject);
          i &= (1 << j) - 1;
          break;
          if (c == '+') {
            localObject = "ib";
          } else if (c == '/') {
            localObject = "ic";
          } else {
            localObject = Character.valueOf(c);
          }
        }
      }
      k += 1;
    }
    if (j > 0)
    {
      c = s[(i << 6 - j)];
      if (c != 'i') {
        break label185;
      }
      paramArrayOfByte = "ia";
    }
    for (;;)
    {
      localStringBuffer.append(paramArrayOfByte);
      return localStringBuffer;
      label185:
      if (c == '+') {
        paramArrayOfByte = "ib";
      } else if (c == '/') {
        paramArrayOfByte = "ic";
      } else {
        paramArrayOfByte = Character.valueOf(c);
      }
    }
  }
  
  protected void init()
  {
    int i = 0;
    while (i < s.length)
    {
      gA[s[i]] = ((byte)i);
      i += 1;
    }
  }
  
  public String pd(String paramString)
  {
    return a(paramString.getBytes()).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqcs
 * JD-Core Version:    0.7.0.1
 */