package com.tencent.thumbplayer.core.drm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class TPMediaDrmProxy$1
  implements ITPMediaDrm.OnEventListener
{
  TPMediaDrmProxy$1(TPMediaDrmProxy paramTPMediaDrmProxy) {}
  
  public void onEvent(@NonNull ITPMediaDrm paramITPMediaDrm, @Nullable byte[] paramArrayOfByte1, int paramInt1, int paramInt2, @Nullable byte[] paramArrayOfByte2)
  {
    if (paramITPMediaDrm == TPMediaDrmProxy.access$000(this.this$0)) {
      TPMediaDrmProxy.access$100(this.this$0, paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.TPMediaDrmProxy.1
 * JD-Core Version:    0.7.0.1
 */