package com.tencent.thumbplayer.core.drm.reuse;

import androidx.annotation.NonNull;
import java.util.UUID;

class TPMediaDrmPool$1
  implements TPDoubleQueueCachedPool.ITPCachePoolListener
{
  TPMediaDrmPool$1(TPMediaDrmPool paramTPMediaDrmPool, UUID paramUUID) {}
  
  @NonNull
  public Object createTPMediaDrm(TPDoubleQueueCachedPool paramTPDoubleQueueCachedPool)
    throws Exception
  {
    try
    {
      paramTPDoubleQueueCachedPool = TPMediaDrmPool.access$000(this.this$0).createTPMediaDrm(this.val$uuid);
      return paramTPDoubleQueueCachedPool;
    }
    catch (Exception paramTPDoubleQueueCachedPool)
    {
      throw paramTPDoubleQueueCachedPool;
    }
  }
  
  public void releaseTPMediaDrm(TPDoubleQueueCachedPool paramTPDoubleQueueCachedPool, @NonNull Object paramObject)
  {
    TPMediaDrmPool.access$000(this.this$0).releaseTPMediaDrm(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.reuse.TPMediaDrmPool.1
 * JD-Core Version:    0.7.0.1
 */