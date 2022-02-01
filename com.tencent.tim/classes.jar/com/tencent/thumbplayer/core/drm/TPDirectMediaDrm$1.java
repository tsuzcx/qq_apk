package com.tencent.thumbplayer.core.drm;

import android.media.MediaDrm;
import android.media.MediaDrm.OnEventListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class TPDirectMediaDrm$1
  implements MediaDrm.OnEventListener
{
  TPDirectMediaDrm$1(TPDirectMediaDrm paramTPDirectMediaDrm) {}
  
  public void onEvent(@NonNull MediaDrm paramMediaDrm, @Nullable byte[] paramArrayOfByte1, int paramInt1, int paramInt2, @Nullable byte[] paramArrayOfByte2)
  {
    paramMediaDrm = TPDirectMediaDrm.access$000(this.this$0);
    if (paramMediaDrm != null) {
      paramMediaDrm.onEvent(this.this$0, paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.TPDirectMediaDrm.1
 * JD-Core Version:    0.7.0.1
 */