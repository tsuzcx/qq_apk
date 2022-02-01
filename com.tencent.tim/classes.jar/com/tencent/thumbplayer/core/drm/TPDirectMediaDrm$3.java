package com.tencent.thumbplayer.core.drm;

import android.media.MediaDrm;
import android.media.MediaDrm.OnExpirationUpdateListener;
import androidx.annotation.NonNull;

class TPDirectMediaDrm$3
  implements MediaDrm.OnExpirationUpdateListener
{
  TPDirectMediaDrm$3(TPDirectMediaDrm paramTPDirectMediaDrm) {}
  
  public void onExpirationUpdate(@NonNull MediaDrm paramMediaDrm, @NonNull byte[] paramArrayOfByte, long paramLong)
  {
    paramMediaDrm = TPDirectMediaDrm.access$200(this.this$0);
    if (paramMediaDrm != null) {
      paramMediaDrm.onExpirationUpdate(this.this$0, paramArrayOfByte, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.TPDirectMediaDrm.3
 * JD-Core Version:    0.7.0.1
 */