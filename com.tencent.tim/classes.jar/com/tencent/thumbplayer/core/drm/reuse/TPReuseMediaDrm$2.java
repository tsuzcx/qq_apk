package com.tencent.thumbplayer.core.drm.reuse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.core.drm.ITPMediaDrm;
import com.tencent.thumbplayer.core.drm.ITPMediaDrm.OnEventListener;

class TPReuseMediaDrm$2
  implements ITPMediaDrm.OnEventListener
{
  TPReuseMediaDrm$2(TPReuseMediaDrm paramTPReuseMediaDrm) {}
  
  public void onEvent(@NonNull ITPMediaDrm paramITPMediaDrm, @Nullable byte[] paramArrayOfByte1, int paramInt1, int paramInt2, @Nullable byte[] paramArrayOfByte2)
  {
    paramITPMediaDrm = TPReuseMediaDrm.access$000(this.this$0);
    if (paramITPMediaDrm != null) {
      paramITPMediaDrm.onEvent(this.this$0, paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.reuse.TPReuseMediaDrm.2
 * JD-Core Version:    0.7.0.1
 */