package com.tencent.thumbplayer.core.drm.reuse;

import android.media.MediaDrm.KeyStatus;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.drm.ITPMediaDrm;
import com.tencent.thumbplayer.core.drm.ITPMediaDrm.OnKeyStatusChangeListener;
import java.util.List;

class TPReuseMediaDrm$3
  implements ITPMediaDrm.OnKeyStatusChangeListener
{
  TPReuseMediaDrm$3(TPReuseMediaDrm paramTPReuseMediaDrm) {}
  
  public void onKeyStatusChange(@NonNull ITPMediaDrm paramITPMediaDrm, @NonNull byte[] paramArrayOfByte, @NonNull List<MediaDrm.KeyStatus> paramList, boolean paramBoolean)
  {
    paramITPMediaDrm = TPReuseMediaDrm.access$100(this.this$0);
    if (paramITPMediaDrm != null) {
      paramITPMediaDrm.onKeyStatusChange(this.this$0, paramArrayOfByte, paramList, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.reuse.TPReuseMediaDrm.3
 * JD-Core Version:    0.7.0.1
 */