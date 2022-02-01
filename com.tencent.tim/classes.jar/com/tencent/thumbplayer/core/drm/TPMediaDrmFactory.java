package com.tencent.thumbplayer.core.drm;

import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.media.UnsupportedSchemeException;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.drm.reuse.TPNotMatchedUUIDException;
import com.tencent.thumbplayer.core.drm.reuse.TPReuseMediaDrm;
import java.util.UUID;

@RequiresApi(api=18)
public class TPMediaDrmFactory
{
  public static ITPMediaDrm createTPMediaDrm(@NonNull UUID paramUUID)
    throws UnsupportedSchemeException
  {
    return new TPDirectMediaDrm(new MediaDrm(paramUUID));
  }
  
  public static ITPMediaDrm createTPReuseMediaDrm(@NonNull UUID paramUUID)
    throws UnsupportedSchemeException, ResourceBusyException, NotProvisionedException, TPNotMatchedUUIDException
  {
    return new TPReuseMediaDrm(paramUUID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.TPMediaDrmFactory
 * JD-Core Version:    0.7.0.1
 */