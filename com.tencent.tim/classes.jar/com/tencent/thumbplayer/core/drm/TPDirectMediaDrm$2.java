package com.tencent.thumbplayer.core.drm;

import android.media.MediaDrm;
import android.media.MediaDrm.KeyStatus;
import android.media.MediaDrm.OnKeyStatusChangeListener;
import androidx.annotation.NonNull;
import java.util.List;

class TPDirectMediaDrm$2
  implements MediaDrm.OnKeyStatusChangeListener
{
  TPDirectMediaDrm$2(TPDirectMediaDrm paramTPDirectMediaDrm) {}
  
  public void onKeyStatusChange(@NonNull MediaDrm paramMediaDrm, @NonNull byte[] paramArrayOfByte, @NonNull List<MediaDrm.KeyStatus> paramList, boolean paramBoolean)
  {
    paramMediaDrm = TPDirectMediaDrm.access$100(this.this$0);
    if (paramMediaDrm != null) {
      paramMediaDrm.onKeyStatusChange(this.this$0, paramArrayOfByte, paramList, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.TPDirectMediaDrm.2
 * JD-Core Version:    0.7.0.1
 */