package com.tencent.token.global.taiji;

import tmsdk.common.module.pgsdk.manager.ITaijiTccCryptManager;
import tmsdk.common.tcc.TccCryptor;

class w
  implements ITaijiTccCryptManager
{
  w(u paramu) {}
  
  public byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return TccCryptor.decrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return TccCryptor.encrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public byte[] makePassword(byte[] paramArrayOfByte)
  {
    return TccCryptor.makePassword(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.w
 * JD-Core Version:    0.7.0.1
 */