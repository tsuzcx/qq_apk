package com.google.android.exoplayer2.extractor.mp4;

import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.util.Assertions;

public final class TrackEncryptionBox
{
  private static final String TAG = "TrackEncryptionBox";
  public final TrackOutput.CryptoData cryptoData;
  public final byte[] defaultInitializationVector;
  public final int initializationVectorSize;
  public final boolean isEncrypted;
  @Nullable
  public final String schemeType;
  
  public TrackEncryptionBox(boolean paramBoolean, @Nullable String paramString, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, @Nullable byte[] paramArrayOfByte2)
  {
    int i;
    if (paramInt1 == 0)
    {
      i = 1;
      if (paramArrayOfByte2 != null) {
        break label76;
      }
    }
    for (;;)
    {
      Assertions.checkArgument(j ^ i);
      this.isEncrypted = paramBoolean;
      this.schemeType = paramString;
      this.initializationVectorSize = paramInt1;
      this.defaultInitializationVector = paramArrayOfByte2;
      this.cryptoData = new TrackOutput.CryptoData(schemeToCryptoMode(paramString), paramArrayOfByte1, paramInt2, paramInt3);
      return;
      i = 0;
      break;
      label76:
      j = 0;
    }
  }
  
  private static int schemeToCryptoMode(@Nullable String paramString)
  {
    if (paramString == null) {
      return 1;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      case 0: 
      case 1: 
      default: 
        Log.w("TrackEncryptionBox", "Unsupported protection scheme type '" + paramString + "'. Assuming AES-CTR crypto mode.");
        return 1;
        if (paramString.equals("cenc"))
        {
          i = 0;
          continue;
          if (paramString.equals("cens"))
          {
            i = 1;
            continue;
            if (paramString.equals("cbc1"))
            {
              i = 2;
              continue;
              if (paramString.equals("cbcs")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox
 * JD-Core Version:    0.7.0.1
 */