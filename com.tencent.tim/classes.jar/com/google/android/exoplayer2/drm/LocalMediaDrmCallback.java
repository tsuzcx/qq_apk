package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.UUID;

public final class LocalMediaDrmCallback
  implements MediaDrmCallback
{
  private final byte[] keyResponse;
  
  public LocalMediaDrmCallback(byte[] paramArrayOfByte)
  {
    this.keyResponse = ((byte[])Assertions.checkNotNull(paramArrayOfByte));
  }
  
  public byte[] executeKeyRequest(UUID paramUUID, ExoMediaDrm.KeyRequest paramKeyRequest)
    throws Exception
  {
    return this.keyResponse;
  }
  
  public byte[] executeProvisionRequest(UUID paramUUID, ExoMediaDrm.ProvisionRequest paramProvisionRequest)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.LocalMediaDrmCallback
 * JD-Core Version:    0.7.0.1
 */