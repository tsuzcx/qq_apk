public class awxa
{
  private static final char[] C = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final char h = (char)Integer.parseInt("00000011", 2);
  private static final char i = (char)Integer.parseInt("00001111", 2);
  private static final char j = (char)Integer.parseInt("00111111", 2);
  private static final char k = (char)Integer.parseInt("11111100", 2);
  private static final char l = (char)Integer.parseInt("11110000", 2);
  private static final char m = (char)Integer.parseInt("11000000", 2);
  
  public static String encode(byte[] paramArrayOfByte)
  {
    int i2 = 0;
    StringBuilder localStringBuilder = new StringBuilder((int)(paramArrayOfByte.length * 1.34D) + 3);
    int n = 0;
    int i1 = 0;
    while (i2 < paramArrayOfByte.length)
    {
      i1 %= 8;
      int i3 = n;
      if (i1 < 8)
      {
        n = i3;
        switch (i1)
        {
        default: 
          n = i3;
        }
        for (;;)
        {
          localStringBuilder.append(C[n]);
          i1 += 6;
          i3 = n;
          break;
          n = (char)((char)(paramArrayOfByte[i2] & k) >>> '\002');
          continue;
          n = (char)(paramArrayOfByte[i2] & j);
          continue;
          i3 = (char)((char)(paramArrayOfByte[i2] & i) << '\002');
          n = i3;
          if (i2 + 1 < paramArrayOfByte.length)
          {
            n = (char)(i3 | (paramArrayOfByte[(i2 + 1)] & m) >>> 6);
            continue;
            i3 = (char)((char)(paramArrayOfByte[i2] & h) << '\004');
            n = i3;
            if (i2 + 1 < paramArrayOfByte.length) {
              n = (char)(i3 | (paramArrayOfByte[(i2 + 1)] & l) >>> 4);
            }
          }
        }
      }
      i2 += 1;
      n = i3;
    }
    if (localStringBuilder.length() % 4 != 0)
    {
      n = 4 - localStringBuilder.length() % 4;
      while (n > 0)
      {
        localStringBuilder.append("=");
        n -= 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awxa
 * JD-Core Version:    0.7.0.1
 */