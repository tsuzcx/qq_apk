package com.tencent.thumbplayer.core.drm.reuse;

import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.media.UnsupportedSchemeException;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.drm.ITPMediaDrm;
import com.tencent.thumbplayer.core.drm.TPDirectMediaDrm;
import java.util.UUID;

final class TPReuseMediaDrm$1
  implements TPMediaDrmPool.ITPMediaDrmPoolListener
{
  public Object createTPMediaDrm(@NonNull UUID paramUUID)
    throws UnsupportedSchemeException, ResourceBusyException, NotProvisionedException
  {
    paramUUID = new TPDirectMediaDrm(new MediaDrm(paramUUID));
    return new TPReuseMediaDrm.TPMediaDrmInfo(paramUUID, paramUUID.openSession());
  }
  
  public void releaseTPMediaDrm(Object paramObject)
  {
    if ((paramObject instanceof TPReuseMediaDrm.TPMediaDrmInfo)) {
      ((TPReuseMediaDrm.TPMediaDrmInfo)paramObject).tpMediaDrm.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.reuse.TPReuseMediaDrm.1
 * JD-Core Version:    0.7.0.1
 */