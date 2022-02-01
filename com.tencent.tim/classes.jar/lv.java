import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

final class lv
{
  private static final int[][] c;
  private static final int[][] e;
  private static final int[][] i;
  private static final int[][] j;
  
  static
  {
    int[] arrayOfInt1 = { 1, 0, 0, 0, 0, 0, 1 };
    int[] arrayOfInt2 = { 1, 0, 1, 1, 1, 0, 1 };
    c = new int[][] { { 1, 1, 1, 1, 1, 1, 1 }, arrayOfInt1, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, arrayOfInt2, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
    e = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
    arrayOfInt1 = new int[] { -1, -1, -1, -1, -1, -1, -1 };
    arrayOfInt2 = new int[] { 6, 22, -1, -1, -1, -1, -1 };
    int[] arrayOfInt3 = { 6, 30, -1, -1, -1, -1, -1 };
    int[] arrayOfInt4 = { 6, 22, 38, -1, -1, -1, -1 };
    int[] arrayOfInt5 = { 6, 24, 42, -1, -1, -1, -1 };
    int[] arrayOfInt6 = { 6, 28, 50, -1, -1, -1, -1 };
    int[] arrayOfInt7 = { 6, 30, 54, -1, -1, -1, -1 };
    int[] arrayOfInt8 = { 6, 32, 58, -1, -1, -1, -1 };
    int[] arrayOfInt9 = { 6, 34, 62, -1, -1, -1, -1 };
    int[] arrayOfInt10 = { 6, 26, 46, 66, -1, -1, -1 };
    int[] arrayOfInt11 = { 6, 26, 48, 70, -1, -1, -1 };
    int[] arrayOfInt12 = { 6, 26, 50, 74, -1, -1, -1 };
    int[] arrayOfInt13 = { 6, 30, 54, 78, -1, -1, -1 };
    int[] arrayOfInt14 = { 6, 30, 56, 82, -1, -1, -1 };
    int[] arrayOfInt15 = { 6, 30, 58, 86, -1, -1, -1 };
    int[] arrayOfInt16 = { 6, 28, 50, 72, 94, -1, -1 };
    int[] arrayOfInt17 = { 6, 30, 54, 78, 102, -1, -1 };
    int[] arrayOfInt18 = { 6, 28, 54, 80, 106, -1, -1 };
    int[] arrayOfInt19 = { 6, 32, 58, 84, 110, -1, -1 };
    int[] arrayOfInt20 = { 6, 30, 58, 86, 114, -1, -1 };
    int[] arrayOfInt21 = { 6, 34, 62, 90, 118, -1, -1 };
    int[] arrayOfInt22 = { 6, 26, 50, 74, 98, 122, -1 };
    int[] arrayOfInt23 = { 6, 30, 54, 78, 102, 126, -1 };
    int[] arrayOfInt24 = { 6, 30, 56, 82, 108, 134, -1 };
    int[] arrayOfInt25 = { 6, 30, 58, 86, 114, 142, -1 };
    int[] arrayOfInt26 = { 6, 34, 62, 90, 118, 146, -1 };
    int[] arrayOfInt27 = { 6, 24, 50, 76, 102, 128, 154 };
    int[] arrayOfInt28 = { 6, 28, 54, 80, 106, 132, 158 };
    int[] arrayOfInt29 = { 6, 32, 58, 84, 110, 136, 162 };
    int[] arrayOfInt30 = { 6, 26, 54, 82, 110, 138, 166 };
    int[] arrayOfInt31 = { 6, 30, 58, 86, 114, 142, 170 };
    i = new int[][] { arrayOfInt1, { 6, 18, -1, -1, -1, -1, -1 }, arrayOfInt2, { 6, 26, -1, -1, -1, -1, -1 }, arrayOfInt3, { 6, 34, -1, -1, -1, -1, -1 }, arrayOfInt4, arrayOfInt5, { 6, 26, 46, -1, -1, -1, -1 }, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11, arrayOfInt12, arrayOfInt13, arrayOfInt14, arrayOfInt15, { 6, 34, 62, 90, -1, -1, -1 }, arrayOfInt16, { 6, 26, 50, 74, 98, -1, -1 }, arrayOfInt17, arrayOfInt18, arrayOfInt19, arrayOfInt20, arrayOfInt21, arrayOfInt22, arrayOfInt23, { 6, 26, 52, 78, 104, 130, -1 }, arrayOfInt24, { 6, 34, 60, 86, 112, 138, -1 }, arrayOfInt25, arrayOfInt26, { 6, 30, 54, 78, 102, 126, 150 }, arrayOfInt27, arrayOfInt28, arrayOfInt29, arrayOfInt30, arrayOfInt31 };
    arrayOfInt1 = new int[] { 8, 0 };
    arrayOfInt2 = new int[] { 8, 1 };
    arrayOfInt3 = new int[] { 8, 3 };
    arrayOfInt4 = new int[] { 8, 4 };
    arrayOfInt5 = new int[] { 8, 5 };
    arrayOfInt6 = new int[] { 8, 7 };
    arrayOfInt7 = new int[] { 8, 8 };
    arrayOfInt8 = new int[] { 7, 8 };
    arrayOfInt9 = new int[] { 5, 8 };
    arrayOfInt10 = new int[] { 4, 8 };
    arrayOfInt11 = new int[] { 1, 8 };
    j = new int[][] { arrayOfInt1, arrayOfInt2, { 8, 2 }, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10, { 3, 8 }, { 2, 8 }, arrayOfInt11, { 0, 8 } };
  }
  
  static int H(int paramInt)
  {
    int m = 0;
    int k = paramInt;
    paramInt = m;
    while (k != 0)
    {
      k >>>= 1;
      paramInt += 1;
    }
    return paramInt;
  }
  
  private static void a(int paramInt1, int paramInt2, lr paramlr)
    throws WriterException
  {
    int k = 0;
    while (k < 8)
    {
      if (!y(paramlr.a(paramInt1 + k, paramInt2))) {
        throw new WriterException();
      }
      paramlr.set(paramInt1 + k, paramInt2, 0);
      k += 1;
    }
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, lj paramlj)
    throws WriterException
  {
    if (!lw.z(paramInt)) {
      throw new WriterException("Invalid mask pattern");
    }
    paramInt = paramErrorCorrectionLevel.getBits() << 3 | paramInt;
    paramlj.appendBits(paramInt, 5);
    paramlj.appendBits(l(paramInt, 1335), 10);
    paramErrorCorrectionLevel = new lj();
    paramErrorCorrectionLevel.appendBits(21522, 15);
    paramlj.b(paramErrorCorrectionLevel);
    if (paramlj.getSize() != 15) {
      throw new WriterException("should not happen but we got: " + paramlj.getSize());
    }
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, lr paramlr)
    throws WriterException
  {
    lj locallj = new lj();
    a(paramErrorCorrectionLevel, paramInt, locallj);
    paramInt = 0;
    if (paramInt < locallj.getSize())
    {
      boolean bool = locallj.get(locallj.getSize() - 1 - paramInt);
      paramlr.set(j[paramInt][0], j[paramInt][1], bool);
      if (paramInt < 8) {
        paramlr.set(paramlr.getWidth() - paramInt - 1, 8, bool);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramlr.set(8, paramlr.getHeight() - 7 + (paramInt - 8), bool);
      }
    }
  }
  
  static void a(lj paramlj, int paramInt, lr paramlr)
    throws WriterException
  {
    int n = paramlr.getWidth() - 1;
    int m = paramlr.getHeight() - 1;
    int i1 = -1;
    int k = 0;
    if (n > 0)
    {
      if (n != 6) {
        break label247;
      }
      n -= 1;
    }
    label111:
    label247:
    for (;;)
    {
      if ((m >= 0) && (m < paramlr.getHeight()))
      {
        int i2 = 0;
        while (i2 < 2)
        {
          int i3 = n - i2;
          if (!y(paramlr.a(i3, m)))
          {
            i2 += 1;
          }
          else
          {
            boolean bool1;
            if (k < paramlj.getSize())
            {
              bool1 = paramlj.get(k);
              k += 1;
              bool2 = bool1;
              if (paramInt != -1)
              {
                bool2 = bool1;
                if (lu.b(paramInt, i3, m)) {
                  if (bool1) {
                    break label162;
                  }
                }
              }
            }
            for (boolean bool2 = true;; bool2 = false)
            {
              paramlr.set(i3, m, bool2);
              break;
              bool1 = false;
              break label111;
            }
          }
        }
        m += i1;
      }
      else
      {
        i1 = -i1;
        n -= 2;
        m += i1;
        break;
        if (k != paramlj.getSize()) {
          throw new WriterException("Not all bits consumed: " + k + '/' + paramlj.getSize());
        }
        return;
      }
    }
  }
  
  static void a(lj paramlj, ErrorCorrectionLevel paramErrorCorrectionLevel, lp paramlp, int paramInt, lr paramlr)
    throws WriterException
  {
    a(paramlr);
    a(paramlp, paramlr);
    a(paramErrorCorrectionLevel, paramInt, paramlr);
    b(paramlp, paramlr);
    a(paramlj, paramInt, paramlr);
  }
  
  static void a(lp paramlp, lj paramlj)
    throws WriterException
  {
    paramlj.appendBits(paramlp.aH(), 6);
    paramlj.appendBits(l(paramlp.aH(), 7973), 12);
    if (paramlj.getSize() != 18) {
      throw new WriterException("should not happen but we got: " + paramlj.getSize());
    }
  }
  
  static void a(lp paramlp, lr paramlr)
    throws WriterException
  {
    d(paramlr);
    c(paramlr);
    c(paramlp, paramlr);
    b(paramlr);
  }
  
  static void a(lr paramlr)
  {
    paramlr.b((byte)-1);
  }
  
  private static void b(int paramInt1, int paramInt2, lr paramlr)
    throws WriterException
  {
    int k = 0;
    while (k < 7)
    {
      if (!y(paramlr.a(paramInt1, paramInt2 + k))) {
        throw new WriterException();
      }
      paramlr.set(paramInt1, paramInt2 + k, 0);
      k += 1;
    }
  }
  
  static void b(lp paramlp, lr paramlr)
    throws WriterException
  {
    if (paramlp.aH() < 7) {}
    for (;;)
    {
      return;
      lj locallj = new lj();
      a(paramlp, locallj);
      int k = 17;
      int m = 0;
      while (m < 6)
      {
        int n = 0;
        while (n < 3)
        {
          boolean bool = locallj.get(k);
          k -= 1;
          paramlr.set(m, paramlr.getHeight() - 11 + n, bool);
          paramlr.set(paramlr.getHeight() - 11 + n, m, bool);
          n += 1;
        }
        m += 1;
      }
    }
  }
  
  private static void b(lr paramlr)
  {
    int k = 8;
    while (k < paramlr.getWidth() - 8)
    {
      int m = (k + 1) % 2;
      if (y(paramlr.a(k, 6))) {
        paramlr.set(k, 6, m);
      }
      if (y(paramlr.a(6, k))) {
        paramlr.set(6, k, m);
      }
      k += 1;
    }
  }
  
  private static void c(int paramInt1, int paramInt2, lr paramlr)
  {
    int k = 0;
    while (k < 5)
    {
      int m = 0;
      while (m < 5)
      {
        paramlr.set(paramInt1 + m, paramInt2 + k, e[k][m]);
        m += 1;
      }
      k += 1;
    }
  }
  
  private static void c(lp paramlp, lr paramlr)
  {
    if (paramlp.aH() < 2) {}
    for (;;)
    {
      return;
      int k = paramlp.aH() - 1;
      paramlp = i[k];
      int n = i[k].length;
      k = 0;
      while (k < n)
      {
        int m = 0;
        if (m < n)
        {
          int i1 = paramlp[k];
          int i2 = paramlp[m];
          if ((i2 == -1) || (i1 == -1)) {}
          for (;;)
          {
            m += 1;
            break;
            if (y(paramlr.a(i2, i1))) {
              c(i2 - 2, i1 - 2, paramlr);
            }
          }
        }
        k += 1;
      }
    }
  }
  
  private static void c(lr paramlr)
    throws WriterException
  {
    if (paramlr.a(8, paramlr.getHeight() - 8) == 0) {
      throw new WriterException();
    }
    paramlr.set(8, paramlr.getHeight() - 8, 1);
  }
  
  private static void d(int paramInt1, int paramInt2, lr paramlr)
  {
    int k = 0;
    while (k < 7)
    {
      int m = 0;
      while (m < 7)
      {
        paramlr.set(paramInt1 + m, paramInt2 + k, c[k][m]);
        m += 1;
      }
      k += 1;
    }
  }
  
  private static void d(lr paramlr)
    throws WriterException
  {
    int k = c[0].length;
    d(0, 0, paramlr);
    d(paramlr.getWidth() - k, 0, paramlr);
    d(0, paramlr.getWidth() - k, paramlr);
    a(0, 7, paramlr);
    a(paramlr.getWidth() - 8, 7, paramlr);
    a(0, paramlr.getWidth() - 8, paramlr);
    b(7, 0, paramlr);
    b(paramlr.getHeight() - 7 - 1, 0, paramlr);
    b(7, paramlr.getHeight() - 7, paramlr);
  }
  
  static int l(int paramInt1, int paramInt2)
  {
    int k = H(paramInt2);
    paramInt1 <<= k - 1;
    while (H(paramInt1) >= k) {
      paramInt1 ^= paramInt2 << H(paramInt1) - k;
    }
    return paramInt1;
  }
  
  private static boolean y(int paramInt)
  {
    return paramInt == -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     lv
 * JD-Core Version:    0.7.0.1
 */