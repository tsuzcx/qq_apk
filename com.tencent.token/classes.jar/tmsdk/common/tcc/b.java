package tmsdk.common.tcc;

import android.text.TextUtils;
import btmsdkobf.bc;
import btmsdkobf.eg;
import com.tmsdk.base.AbsTMSBaseConfig;

public class b
{
  private static volatile boolean nA = false;
  
  public static boolean cO()
  {
    if (nA) {
      return true;
    }
    try
    {
      String str = bc.o().getTccSoName();
      eg.e("TccUtil", "loadLibraryIfNot libraryName:[" + str + "]");
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      System.loadLibrary(str);
      nA = true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eg.h("TccUtil", "loadLibraryIfNot e:[" + localThrowable.getMessage() + "]");
        localThrowable.printStackTrace();
        nA = false;
      }
    }
    return nA;
  }
  
  public static boolean cP()
  {
    if (bc.o().isJavaTCC()) {}
    while (TccCryptor.getProcBitStatus() == 109) {
      return true;
    }
    return false;
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (bc.o().isJavaTCC()) {
      return a.decrypt(paramArrayOfByte1, paramArrayOfByte2);
    }
    return TccCryptor.decrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (bc.o().isJavaTCC()) {
      return a.encrypt(paramArrayOfByte1, paramArrayOfByte2);
    }
    return TccCryptor.encrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.tcc.b
 * JD-Core Version:    0.7.0.1
 */