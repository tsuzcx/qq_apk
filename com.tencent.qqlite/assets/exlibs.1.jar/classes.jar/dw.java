import com.google.zxing.qrcode.encoder.ByteMatrix;

public final class dw
{
  private static final int a = 3;
  private static final int b = 3;
  private static final int c = 40;
  private static final int d = 10;
  
  public static int a(ByteMatrix paramByteMatrix)
  {
    return a(paramByteMatrix, true) + a(paramByteMatrix, false);
  }
  
  private static int a(ByteMatrix paramByteMatrix, boolean paramBoolean)
  {
    int m;
    int n;
    label20:
    int i1;
    if (paramBoolean)
    {
      m = paramByteMatrix.a();
      if (!paramBoolean) {
        break label99;
      }
      n = paramByteMatrix.b();
      paramByteMatrix = paramByteMatrix.a();
      i1 = 0;
    }
    int j;
    for (int i = 0;; i = j)
    {
      if (i1 >= m) {
        return i;
      }
      j = -1;
      int i2 = 0;
      int i3 = 0;
      label45:
      if (i2 < n)
      {
        if (paramBoolean)
        {
          k = paramByteMatrix[i1][i2];
          label65:
          if (k != j) {
            break label120;
          }
        }
        for (int k = i3 + 1;; k = i3)
        {
          i2 += 1;
          i3 = k;
          break label45;
          m = paramByteMatrix.b();
          break;
          label99:
          n = paramByteMatrix.a();
          break label20;
          k = paramByteMatrix[i2][i1];
          break label65;
          label120:
          j = i;
          if (i3 >= 5) {
            j = i + (i3 - 5 + 3);
          }
          i3 = 1;
          i = j;
          j = k;
        }
      }
      j = i;
      if (i3 > 5) {
        j = i + (i3 - 5 + 3);
      }
      i1 += 1;
    }
    return i;
  }
  
  static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("Invalid mask pattern: " + paramInt1);
    case 0: 
      paramInt1 = paramInt3 + paramInt2 & 0x1;
    }
    while (paramInt1 == 0)
    {
      return true;
      paramInt1 = paramInt3 & 0x1;
      continue;
      paramInt1 = paramInt2 % 3;
      continue;
      paramInt1 = (paramInt3 + paramInt2) % 3;
      continue;
      paramInt1 = (paramInt3 >>> 1) + paramInt2 / 3 & 0x1;
      continue;
      paramInt1 = paramInt3 * paramInt2;
      paramInt1 = paramInt1 % 3 + (paramInt1 & 0x1);
      continue;
      paramInt1 = paramInt3 * paramInt2;
      paramInt1 = paramInt1 % 3 + (paramInt1 & 0x1) & 0x1;
      continue;
      paramInt1 = paramInt3 * paramInt2 % 3 + (paramInt3 + paramInt2 & 0x1) & 0x1;
    }
    return false;
  }
  
  public static int b(ByteMatrix paramByteMatrix)
  {
    byte[][] arrayOfByte = paramByteMatrix.a();
    int n = paramByteMatrix.b();
    int i1 = paramByteMatrix.a();
    int i = 0;
    int j = 0;
    while (i < i1 - 1)
    {
      int k = 0;
      while (k < n - 1)
      {
        int i2 = arrayOfByte[i][k];
        int m = j;
        if (i2 == arrayOfByte[i][(k + 1)])
        {
          m = j;
          if (i2 == arrayOfByte[(i + 1)][k])
          {
            m = j;
            if (i2 == arrayOfByte[(i + 1)][(k + 1)]) {
              m = j + 1;
            }
          }
        }
        k += 1;
        j = m;
      }
      i += 1;
    }
    return j * 3;
  }
  
  public static int c(ByteMatrix paramByteMatrix)
  {
    byte[][] arrayOfByte = paramByteMatrix.a();
    int n = paramByteMatrix.b();
    int i1 = paramByteMatrix.a();
    int k = 0;
    int i = 0;
    while (k < i1)
    {
      int m = 0;
      while (m < n)
      {
        int j = i;
        if (m + 6 < n)
        {
          j = i;
          if (arrayOfByte[k][m] == 1)
          {
            j = i;
            if (arrayOfByte[k][(m + 1)] == 0)
            {
              j = i;
              if (arrayOfByte[k][(m + 2)] == 1)
              {
                j = i;
                if (arrayOfByte[k][(m + 3)] == 1)
                {
                  j = i;
                  if (arrayOfByte[k][(m + 4)] == 1)
                  {
                    j = i;
                    if (arrayOfByte[k][(m + 5)] == 0)
                    {
                      j = i;
                      if (arrayOfByte[k][(m + 6)] == 1) {
                        if ((m + 10 >= n) || (arrayOfByte[k][(m + 7)] != 0) || (arrayOfByte[k][(m + 8)] != 0) || (arrayOfByte[k][(m + 9)] != 0) || (arrayOfByte[k][(m + 10)] != 0))
                        {
                          j = i;
                          if (m - 4 >= 0)
                          {
                            j = i;
                            if (arrayOfByte[k][(m - 1)] == 0)
                            {
                              j = i;
                              if (arrayOfByte[k][(m - 2)] == 0)
                              {
                                j = i;
                                if (arrayOfByte[k][(m - 3)] == 0)
                                {
                                  j = i;
                                  if (arrayOfByte[k][(m - 4)] != 0) {}
                                }
                              }
                            }
                          }
                        }
                        else
                        {
                          j = i + 40;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        i = j;
        if (k + 6 < i1)
        {
          i = j;
          if (arrayOfByte[k][m] == 1)
          {
            i = j;
            if (arrayOfByte[(k + 1)][m] == 0)
            {
              i = j;
              if (arrayOfByte[(k + 2)][m] == 1)
              {
                i = j;
                if (arrayOfByte[(k + 3)][m] == 1)
                {
                  i = j;
                  if (arrayOfByte[(k + 4)][m] == 1)
                  {
                    i = j;
                    if (arrayOfByte[(k + 5)][m] == 0)
                    {
                      i = j;
                      if (arrayOfByte[(k + 6)][m] == 1) {
                        if ((k + 10 >= i1) || (arrayOfByte[(k + 7)][m] != 0) || (arrayOfByte[(k + 8)][m] != 0) || (arrayOfByte[(k + 9)][m] != 0) || (arrayOfByte[(k + 10)][m] != 0))
                        {
                          i = j;
                          if (k - 4 >= 0)
                          {
                            i = j;
                            if (arrayOfByte[(k - 1)][m] == 0)
                            {
                              i = j;
                              if (arrayOfByte[(k - 2)][m] == 0)
                              {
                                i = j;
                                if (arrayOfByte[(k - 3)][m] == 0)
                                {
                                  i = j;
                                  if (arrayOfByte[(k - 4)][m] != 0) {}
                                }
                              }
                            }
                          }
                        }
                        else
                        {
                          i = j + 40;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        m += 1;
      }
      k += 1;
    }
    return i;
  }
  
  public static int d(ByteMatrix paramByteMatrix)
  {
    byte[][] arrayOfByte = paramByteMatrix.a();
    int n = paramByteMatrix.b();
    int i1 = paramByteMatrix.a();
    int i = 0;
    int j = 0;
    while (i < i1)
    {
      byte[] arrayOfByte1 = arrayOfByte[i];
      k = 0;
      while (k < n)
      {
        int m = j;
        if (arrayOfByte1[k] == 1) {
          m = j + 1;
        }
        k += 1;
        j = m;
      }
      i += 1;
    }
    i = paramByteMatrix.a();
    int k = paramByteMatrix.b();
    return (int)(Math.abs(j / (i * k) - 0.5D) * 20.0D) * 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dw
 * JD-Core Version:    0.7.0.1
 */