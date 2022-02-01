package com.tencent.thumbplayer.core.drm.reuse;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.drm.ITPMediaDrm;
import com.tencent.thumbplayer.core.drm.ITPMediaDrm.OnExpirationUpdateListener;

class TPReuseMediaDrm$4
  implements ITPMediaDrm.OnExpirationUpdateListener
{
  TPReuseMediaDrm$4(TPReuseMediaDrm paramTPReuseMediaDrm) {}
  
  public void onExpirationUpdate(@NonNull ITPMediaDrm paramITPMediaDrm, @NonNull byte[] paramArrayOfByte, long paramLong)
  {
    paramITPMediaDrm = TPReuseMediaDrm.access$200(this.this$0);
    if (paramITPMediaDrm != null) {
      paramITPMediaDrm.onExpirationUpdate(this.this$0, paramArrayOfByte, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.reuse.TPReuseMediaDrm.4
 * JD-Core Version:    0.7.0.1
 */