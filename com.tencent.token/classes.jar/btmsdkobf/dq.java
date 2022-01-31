package btmsdkobf;

import java.io.InputStream;

public abstract class dq
{
  public static byte[] a(InputStream paramInputStream, int paramInt1, int paramInt2, dq.a parama)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    int j = paramInt2;
    int i = 0;
    for (;;)
    {
      if ((i < paramInt2) && (j > 0))
      {
        n = paramInputStream.read(arrayOfByte, paramInt1, j);
        if (n > 0) {
          break label65;
        }
        if (parama != null) {
          parama.a(true, i, paramInt2);
        }
      }
      paramInputStream = arrayOfByte;
      if (i != paramInt2) {
        paramInputStream = null;
      }
      return paramInputStream;
      label65:
      int k = i + n;
      int m = paramInt1 + n;
      int n = j - n;
      j = n;
      i = k;
      paramInt1 = m;
      if (parama != null)
      {
        parama.a(false, k, paramInt2);
        j = n;
        i = k;
        paramInt1 = m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.dq
 * JD-Core Version:    0.7.0.1
 */