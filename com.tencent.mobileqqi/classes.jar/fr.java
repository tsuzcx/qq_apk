import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.decoder.Version.ECB;
import com.google.zxing.qrcode.decoder.Version.ECBlocks;

public final class fr
{
  private final int jdField_a_of_type_Int;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  
  private fr(int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public static fr[] a(byte[] paramArrayOfByte, Version paramVersion, ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    if (paramArrayOfByte.length != paramVersion.b()) {
      throw new IllegalArgumentException();
    }
    paramVersion = paramVersion.a(paramErrorCorrectionLevel);
    paramErrorCorrectionLevel = paramVersion.a();
    int k = paramErrorCorrectionLevel.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramErrorCorrectionLevel[i].a();
      i += 1;
    }
    fr[] arrayOffr = new fr[j];
    int m = paramErrorCorrectionLevel.length;
    k = 0;
    int n;
    for (j = 0; k < m; j = i)
    {
      Object localObject = paramErrorCorrectionLevel[k];
      i = j;
      j = 0;
      while (j < localObject.a())
      {
        n = localObject.b();
        arrayOffr[i] = new fr(n, new byte[paramVersion.a() + n]);
        j += 1;
        i += 1;
      }
      k += 1;
    }
    k = arrayOffr[0].jdField_a_of_type_ArrayOfByte.length;
    i = arrayOffr.length - 1;
    int i1;
    if ((i < 0) || (arrayOffr[i].jdField_a_of_type_ArrayOfByte.length == k))
    {
      i1 = i + 1;
      n = k - paramVersion.a();
      k = 0;
      i = 0;
    }
    for (;;)
    {
      if (k >= n) {
        break label273;
      }
      m = 0;
      for (;;)
      {
        if (m < j)
        {
          arrayOffr[m].jdField_a_of_type_ArrayOfByte[k] = paramArrayOfByte[i];
          m += 1;
          i += 1;
          continue;
          i -= 1;
          break;
        }
      }
      k += 1;
    }
    label273:
    m = i1;
    k = i;
    while (m < j)
    {
      arrayOffr[m].jdField_a_of_type_ArrayOfByte[n] = paramArrayOfByte[k];
      m += 1;
      k += 1;
    }
    int i2 = arrayOffr[0].jdField_a_of_type_ArrayOfByte.length;
    i = n;
    while (i < i2)
    {
      m = 0;
      if (m < j)
      {
        if (m < i1) {}
        for (n = i;; n = i + 1)
        {
          arrayOffr[m].jdField_a_of_type_ArrayOfByte[n] = paramArrayOfByte[k];
          m += 1;
          k += 1;
          break;
        }
      }
      i += 1;
    }
    return arrayOffr;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fr
 * JD-Core Version:    0.7.0.1
 */