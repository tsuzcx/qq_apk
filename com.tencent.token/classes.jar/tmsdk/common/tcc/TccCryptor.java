package tmsdk.common.tcc;

public class TccCryptor
{
  public static int EndianSwap(int paramInt)
  {
    return paramInt << 24 | (0xFF00 & paramInt) << 8 | (0xFF0000 & paramInt) >>> 8 | paramInt >>> 24;
  }
  
  public static native void cC(int paramInt);
  
  public static native byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native int getProcBitStatus();
  
  public static native byte[] makePassword(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.tcc.TccCryptor
 * JD-Core Version:    0.7.0.1
 */