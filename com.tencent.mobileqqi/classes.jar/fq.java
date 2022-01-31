import com.google.zxing.ReaderException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.Version;

public final class fq
{
  private final BitMatrix jdField_a_of_type_ComGoogleZxingCommonBitMatrix;
  private Version jdField_a_of_type_ComGoogleZxingQrcodeDecoderVersion;
  private gd jdField_a_of_type_Gd;
  
  public fq(BitMatrix paramBitMatrix)
  {
    int i = paramBitMatrix.b();
    if ((i < 21) || ((i & 0x3) != 1)) {
      throw ReaderException.getInstance();
    }
    this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = paramBitMatrix;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a(paramInt1, paramInt2)) {
      return paramInt3 << 1 | 0x1;
    }
    return paramInt3 << 1;
  }
  
  public Version a()
  {
    if (this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderVersion != null) {
      return this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderVersion;
    }
    int m = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.b();
    int i = m - 17 >> 2;
    if (i <= 6) {
      return Version.b(i);
    }
    int n = m - 11;
    i = 5;
    int j = 0;
    int k;
    while (i >= 0)
    {
      k = m - 9;
      while (k >= n)
      {
        j = a(k, i, j);
        k -= 1;
      }
      i -= 1;
    }
    Version localVersion = Version.c(j);
    if ((localVersion != null) && (localVersion.c() == m))
    {
      this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderVersion = localVersion;
      return localVersion;
    }
    j = 0;
    i = 5;
    while (i >= 0)
    {
      k = m - 9;
      while (k >= n)
      {
        j = a(i, k, j);
        k -= 1;
      }
      i -= 1;
    }
    localVersion = Version.c(j);
    if ((localVersion != null) && (localVersion.c() == m))
    {
      this.jdField_a_of_type_ComGoogleZxingQrcodeDecoderVersion = localVersion;
      return localVersion;
    }
    throw ReaderException.getInstance();
  }
  
  public gd a()
  {
    int k = 0;
    if (this.jdField_a_of_type_Gd != null) {
      return this.jdField_a_of_type_Gd;
    }
    int i = 0;
    int j = 0;
    while (i < 6)
    {
      j = a(i, 8, j);
      i += 1;
    }
    j = a(8, 7, a(8, 8, a(7, 8, j)));
    i = 5;
    while (i >= 0)
    {
      j = a(8, i, j);
      i -= 1;
    }
    int n = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.b();
    int m = n - 1;
    i = k;
    k = m;
    while (k >= n - 7)
    {
      i = a(8, k, i);
      k -= 1;
    }
    m = n - 8;
    k = i;
    i = m;
    while (i < n)
    {
      k = a(i, 8, k);
      i += 1;
    }
    this.jdField_a_of_type_Gd = gd.a(j, k);
    if (this.jdField_a_of_type_Gd != null) {
      return this.jdField_a_of_type_Gd;
    }
    throw ReaderException.getInstance();
  }
  
  public byte[] a()
  {
    Object localObject = a();
    Version localVersion = a();
    localObject = fs.a(((gd)localObject).a());
    int i7 = this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.b();
    ((fs)localObject).a(this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix, i7);
    localObject = localVersion.a();
    byte[] arrayOfByte = new byte[localVersion.b()];
    int i = i7 - 1;
    int j = 0;
    int k = 0;
    int i4 = 0;
    int n = 1;
    while (i > 0)
    {
      int i1 = i;
      if (i == 6) {
        i1 = i - 1;
      }
      i = 0;
      while (i < i7)
      {
        if (n != 0) {}
        int m;
        int i6;
        for (int i2 = i7 - 1 - i;; i2 = i)
        {
          int i3 = 0;
          m = k;
          i6 = j;
          while (i3 < 2)
          {
            k = i6;
            j = m;
            int i5 = i4;
            if (!((BitMatrix)localObject).a(i1 - i3, i2))
            {
              i6 += 1;
              j = m << 1;
              m = j;
              if (this.jdField_a_of_type_ComGoogleZxingCommonBitMatrix.a(i1 - i3, i2)) {
                m = j | 0x1;
              }
              k = i6;
              j = m;
              i5 = i4;
              if (i6 == 8)
              {
                arrayOfByte[i4] = ((byte)m);
                j = 0;
                i5 = i4 + 1;
                k = 0;
              }
            }
            i3 += 1;
            i6 = k;
            m = j;
            i4 = i5;
          }
        }
        i += 1;
        j = i6;
        k = m;
      }
      i = i1 - 2;
      n ^= 0x1;
    }
    if (i4 != localVersion.b()) {
      throw ReaderException.getInstance();
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fq
 * JD-Core Version:    0.7.0.1
 */