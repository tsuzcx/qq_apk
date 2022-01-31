package com.tencent.qqpimsecure.taiji;

import android.content.Context;

public class KeyCreator
{
  static
  {
    System.loadLibrary("key_gen");
  }
  
  public static native byte[] create(Context paramContext, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.KeyCreator
 * JD-Core Version:    0.7.0.1
 */