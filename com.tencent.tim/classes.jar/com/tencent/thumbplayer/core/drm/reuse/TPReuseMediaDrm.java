package com.tencent.thumbplayer.core.drm.reuse;

import android.media.DeniedByServerException;
import android.media.MediaDrm.KeyRequest;
import android.media.MediaDrm.ProvisionRequest;
import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.drm.ITPMediaDrm;
import com.tencent.thumbplayer.core.drm.ITPMediaDrm.OnEventListener;
import com.tencent.thumbplayer.core.drm.ITPMediaDrm.OnExpirationUpdateListener;
import com.tencent.thumbplayer.core.drm.ITPMediaDrm.OnKeyStatusChangeListener;
import java.util.HashMap;
import java.util.UUID;

@RequiresApi(api=18)
public class TPReuseMediaDrm
  implements ITPMediaDrm
{
  private static final int KEEP_POOL_SIZE = 2;
  public static final UUID WIDEVINE_UUID = new UUID(-1301668207276963122L, -6645017420763422227L);
  private static TPMediaDrmPool mTPMediaDrmPool;
  private static TPMediaDrmPool.ITPMediaDrmPoolListener mTPMediaPoolListener = new TPReuseMediaDrm.1();
  private ITPMediaDrm.OnEventListener mOnEventListener;
  private ITPMediaDrm.OnExpirationUpdateListener mOnExpirationUpdateListener;
  private ITPMediaDrm.OnKeyStatusChangeListener mOnKeyStatusChangeListener;
  private final ITPMediaDrm mTPMediaDrm;
  private boolean mTPMediaDrmError = false;
  private final TPMediaDrmInfo mTPMediaDrmInfo;
  private final UUID mUUID;
  
  public TPReuseMediaDrm(@NonNull UUID paramUUID)
    throws UnsupportedSchemeException, ResourceBusyException, NotProvisionedException, TPNotMatchedUUIDException
  {
    try
    {
      if (mTPMediaDrmPool == null)
      {
        UUID localUUID = WIDEVINE_UUID;
        TPMediaDrmPool.ITPMediaDrmPoolListener localITPMediaDrmPoolListener = mTPMediaPoolListener;
        mTPMediaDrmPool = new TPMediaDrmPool(new UUID[] { localUUID }, 2, localITPMediaDrmPoolListener);
      }
      this.mTPMediaDrmInfo = ((TPMediaDrmInfo)mTPMediaDrmPool.allocTPMediaDrm(paramUUID));
      this.mTPMediaDrm = this.mTPMediaDrmInfo.tpMediaDrm;
      this.mUUID = paramUUID;
      return;
    }
    finally {}
  }
  
  public void close()
  {
    this.mTPMediaDrm.setOnEventListener(null);
    this.mOnEventListener = null;
    this.mTPMediaDrm.setOnExpirationUpdateListener(null, null);
    this.mOnExpirationUpdateListener = null;
    this.mTPMediaDrm.setOnKeyStatusChangeListener(null, null);
    this.mOnKeyStatusChangeListener = null;
    TPMediaDrmPool localTPMediaDrmPool = mTPMediaDrmPool;
    UUID localUUID = this.mUUID;
    TPMediaDrmInfo localTPMediaDrmInfo = this.mTPMediaDrmInfo;
    if (!this.mTPMediaDrmError) {}
    for (boolean bool = true;; bool = false)
    {
      localTPMediaDrmPool.freeTPMediaDrm(localUUID, localTPMediaDrmInfo, bool);
      return;
    }
  }
  
  /* Error */
  public void closeSession(@NonNull byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aload_0
    //   4: getfield 81	com/tencent/thumbplayer/core/drm/reuse/TPReuseMediaDrm:mTPMediaDrmInfo	Lcom/tencent/thumbplayer/core/drm/reuse/TPReuseMediaDrm$TPMediaDrmInfo;
    //   7: getfield 127	com/tencent/thumbplayer/core/drm/reuse/TPReuseMediaDrm$TPMediaDrmInfo:sessionId	[B
    //   10: invokestatic 133	java/util/Arrays:equals	([B[B)Z
    //   13: ifne +11 -> 24
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 68	com/tencent/thumbplayer/core/drm/reuse/TPReuseMediaDrm:mTPMediaDrmError	Z
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 86	com/tencent/thumbplayer/core/drm/reuse/TPReuseMediaDrm:mTPMediaDrm	Lcom/tencent/thumbplayer/core/drm/ITPMediaDrm;
    //   28: aload_1
    //   29: invokeinterface 135 2 0
    //   34: aload_0
    //   35: getfield 81	com/tencent/thumbplayer/core/drm/reuse/TPReuseMediaDrm:mTPMediaDrmInfo	Lcom/tencent/thumbplayer/core/drm/reuse/TPReuseMediaDrm$TPMediaDrmInfo;
    //   38: aload_0
    //   39: getfield 86	com/tencent/thumbplayer/core/drm/reuse/TPReuseMediaDrm:mTPMediaDrm	Lcom/tencent/thumbplayer/core/drm/ITPMediaDrm;
    //   42: invokeinterface 139 1 0
    //   47: putfield 127	com/tencent/thumbplayer/core/drm/reuse/TPReuseMediaDrm$TPMediaDrmInfo:sessionId	[B
    //   50: goto -29 -> 21
    //   53: astore_1
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield 68	com/tencent/thumbplayer/core/drm/reuse/TPReuseMediaDrm:mTPMediaDrmError	Z
    //   59: iconst_3
    //   60: aload_1
    //   61: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   64: invokestatic 149	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   67: goto -46 -> 21
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	TPReuseMediaDrm
    //   0	75	1	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   34	50	53	java/lang/Exception
    //   2	21	70	finally
    //   24	34	70	finally
    //   34	50	70	finally
    //   54	67	70	finally
  }
  
  @NonNull
  public MediaDrm.KeyRequest getKeyRequest(@NonNull byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2, @Nullable String paramString, int paramInt, @Nullable HashMap<String, String> paramHashMap)
    throws NotProvisionedException
  {
    return this.mTPMediaDrm.getKeyRequest(paramArrayOfByte1, paramArrayOfByte2, paramString, paramInt, paramHashMap);
  }
  
  @NonNull
  public String getPropertyString(@NonNull String paramString)
  {
    return this.mTPMediaDrm.getPropertyString(paramString);
  }
  
  public MediaDrm.ProvisionRequest getProvisionRequest()
  {
    return this.mTPMediaDrm.getProvisionRequest();
  }
  
  @NonNull
  public byte[] openSession()
    throws NotProvisionedException, ResourceBusyException
  {
    try
    {
      byte[] arrayOfByte = this.mTPMediaDrmInfo.sessionId;
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Nullable
  public byte[] provideKeyResponse(@NonNull byte[] paramArrayOfByte1, @NonNull byte[] paramArrayOfByte2)
    throws NotProvisionedException, DeniedByServerException
  {
    return this.mTPMediaDrm.provideKeyResponse(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public void provideProvisionResponse(@NonNull byte[] paramArrayOfByte)
    throws DeniedByServerException
  {
    this.mTPMediaDrm.provideProvisionResponse(paramArrayOfByte);
  }
  
  @NonNull
  public HashMap<String, String> queryKeyStatus(@NonNull byte[] paramArrayOfByte)
  {
    return this.mTPMediaDrm.queryKeyStatus(paramArrayOfByte);
  }
  
  public void removeKeys(@NonNull byte[] paramArrayOfByte)
  {
    this.mTPMediaDrm.removeKeys(paramArrayOfByte);
  }
  
  public void restoreKeys(@NonNull byte[] paramArrayOfByte1, @NonNull byte[] paramArrayOfByte2)
  {
    this.mTPMediaDrm.restoreKeys(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public void setOnEventListener(@Nullable ITPMediaDrm.OnEventListener paramOnEventListener)
  {
    this.mOnEventListener = paramOnEventListener;
    this.mTPMediaDrm.setOnEventListener(new TPReuseMediaDrm.2(this));
  }
  
  public void setOnExpirationUpdateListener(@Nullable ITPMediaDrm.OnExpirationUpdateListener paramOnExpirationUpdateListener, @Nullable Handler paramHandler)
  {
    this.mOnExpirationUpdateListener = paramOnExpirationUpdateListener;
    this.mTPMediaDrm.setOnExpirationUpdateListener(new TPReuseMediaDrm.4(this), paramHandler);
  }
  
  public void setOnKeyStatusChangeListener(@Nullable ITPMediaDrm.OnKeyStatusChangeListener paramOnKeyStatusChangeListener, @Nullable Handler paramHandler)
  {
    this.mOnKeyStatusChangeListener = paramOnKeyStatusChangeListener;
    this.mTPMediaDrm.setOnKeyStatusChangeListener(new TPReuseMediaDrm.3(this), paramHandler);
  }
  
  public void setPropertyString(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.mTPMediaDrm.setPropertyString(paramString1, paramString2);
  }
  
  static class TPMediaDrmInfo
  {
    @NonNull
    byte[] sessionId;
    @NonNull
    final ITPMediaDrm tpMediaDrm;
    
    TPMediaDrmInfo(@NonNull ITPMediaDrm paramITPMediaDrm, @NonNull byte[] paramArrayOfByte)
    {
      this.tpMediaDrm = paramITPMediaDrm;
      this.sessionId = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.reuse.TPReuseMediaDrm
 * JD-Core Version:    0.7.0.1
 */