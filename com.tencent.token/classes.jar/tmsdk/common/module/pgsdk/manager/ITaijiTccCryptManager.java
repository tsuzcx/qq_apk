package tmsdk.common.module.pgsdk.manager;

public abstract interface ITaijiTccCryptManager
{
  public abstract byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract byte[] makePassword(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.manager.ITaijiTccCryptManager
 * JD-Core Version:    0.7.0.1
 */