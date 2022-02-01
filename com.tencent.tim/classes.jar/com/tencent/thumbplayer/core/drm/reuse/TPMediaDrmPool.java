package com.tencent.thumbplayer.core.drm.reuse;

import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.media.UnsupportedSchemeException;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

@RequiresApi(api=18)
public final class TPMediaDrmPool
{
  private static final String TAG = "[PlayerCore][TPMediaDrmPool]";
  private final Map<UUID, TPDoubleQueueCachedPool> mMediaDrmCachedPoolMap = new HashMap();
  private ITPMediaDrmPoolListener mTPMediaDrmPoolListener;
  
  public TPMediaDrmPool(@NonNull UUID[] paramArrayOfUUID, int paramInt, @NonNull ITPMediaDrmPoolListener paramITPMediaDrmPoolListener)
  {
    TPNativeLog.printLog(2, "[PlayerCore][TPMediaDrmPool]", "create TPMediaDrmPool instance.");
    this.mTPMediaDrmPoolListener = paramITPMediaDrmPoolListener;
    int j = paramArrayOfUUID.length;
    int i = 0;
    if (i < j)
    {
      paramITPMediaDrmPoolListener = paramArrayOfUUID[i];
      if (paramITPMediaDrmPoolListener == null) {}
      for (;;)
      {
        i += 1;
        break;
        this.mMediaDrmCachedPoolMap.put(paramITPMediaDrmPoolListener, new TPDoubleQueueCachedPool(paramInt, new TPMediaDrmPool.1(this, paramITPMediaDrmPoolListener)));
      }
    }
    TPNativeLog.printLog(2, "[PlayerCore][TPMediaDrmPool]", "create TPMediaDrmPool instance ok.");
  }
  
  @NonNull
  public Object allocTPMediaDrm(@NonNull UUID paramUUID)
    throws UnsupportedSchemeException, ResourceBusyException, NotProvisionedException, TPNotMatchedUUIDException
  {
    paramUUID = (TPDoubleQueueCachedPool)this.mMediaDrmCachedPoolMap.get(paramUUID);
    if (paramUUID == null) {
      throw new TPNotMatchedUUIDException("UUID mistake.");
    }
    try
    {
      paramUUID = paramUUID.allocObject();
      return paramUUID;
    }
    catch (Exception paramUUID)
    {
      if ((Build.VERSION.SDK_INT >= 19) && ((paramUUID instanceof ResourceBusyException))) {
        throw new ResourceBusyException(paramUUID.getMessage());
      }
      if ((paramUUID instanceof NotProvisionedException)) {
        throw new NotProvisionedException(paramUUID.getMessage());
      }
      throw new UnsupportedSchemeException(paramUUID.getMessage());
    }
  }
  
  public void freeTPMediaDrm(@NonNull UUID paramUUID, @NonNull Object paramObject, boolean paramBoolean)
  {
    paramUUID = (TPDoubleQueueCachedPool)this.mMediaDrmCachedPoolMap.get(paramUUID);
    if (paramUUID == null)
    {
      TPNativeLog.printLog(3, "UUID mistake.");
      this.mTPMediaDrmPoolListener.releaseTPMediaDrm(paramObject);
      return;
    }
    paramUUID.freeObject(paramObject, paramBoolean);
  }
  
  public void release()
  {
    Iterator localIterator = this.mMediaDrmCachedPoolMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ((TPDoubleQueueCachedPool)((Map.Entry)localIterator.next()).getValue()).release();
      localIterator.remove();
    }
    this.mTPMediaDrmPoolListener = null;
  }
  
  static abstract interface ITPMediaDrmPoolListener
  {
    public abstract Object createTPMediaDrm(@NonNull UUID paramUUID)
      throws UnsupportedSchemeException, ResourceBusyException, NotProvisionedException;
    
    public abstract void releaseTPMediaDrm(@NonNull Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.reuse.TPMediaDrmPool
 * JD-Core Version:    0.7.0.1
 */