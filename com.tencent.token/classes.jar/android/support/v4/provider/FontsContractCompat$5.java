package android.support.v4.provider;

import java.util.Comparator;

final class FontsContractCompat$5
  implements Comparator
{
  public int compare(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int k = 0;
    int i;
    if (paramArrayOfByte1.length != paramArrayOfByte2.length)
    {
      i = paramArrayOfByte1.length - paramArrayOfByte2.length;
      return i;
    }
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= paramArrayOfByte1.length) {
        break;
      }
      if (paramArrayOfByte1[j] != paramArrayOfByte2[j]) {
        return paramArrayOfByte1[j] - paramArrayOfByte2[j];
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.provider.FontsContractCompat.5
 * JD-Core Version:    0.7.0.1
 */