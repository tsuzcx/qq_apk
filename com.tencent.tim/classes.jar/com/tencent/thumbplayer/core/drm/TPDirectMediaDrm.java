package com.tencent.thumbplayer.core.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrm.KeyRequest;
import android.media.MediaDrm.ProvisionRequest;
import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.os.Build.VERSION;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.HashMap;

@RequiresApi(api=18)
public class TPDirectMediaDrm
  implements ITPMediaDrm
{
  private final MediaDrm mMediaDrm;
  private ITPMediaDrm.OnEventListener mOnEventListener;
  private ITPMediaDrm.OnExpirationUpdateListener mOnExpirationUpdateListener;
  private ITPMediaDrm.OnKeyStatusChangeListener mOnKeyStatusChangeListener;
  
  public TPDirectMediaDrm(@NonNull MediaDrm paramMediaDrm)
  {
    this.mMediaDrm = paramMediaDrm;
  }
  
  public void close()
  {
    this.mMediaDrm.setOnEventListener(null);
    this.mOnEventListener = null;
    if (Build.VERSION.SDK_INT >= 23) {
      this.mMediaDrm.setOnExpirationUpdateListener(null, null);
    }
    this.mOnExpirationUpdateListener = null;
    if (Build.VERSION.SDK_INT >= 23) {
      this.mMediaDrm.setOnKeyStatusChangeListener(null, null);
    }
    this.mOnKeyStatusChangeListener = null;
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.mMediaDrm.close();
      return;
    }
    this.mMediaDrm.release();
  }
  
  public void closeSession(@NonNull byte[] paramArrayOfByte)
  {
    this.mMediaDrm.closeSession(paramArrayOfByte);
  }
  
  @NonNull
  public MediaDrm.KeyRequest getKeyRequest(@NonNull byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2, @Nullable String paramString, int paramInt, @Nullable HashMap<String, String> paramHashMap)
    throws NotProvisionedException
  {
    return this.mMediaDrm.getKeyRequest(paramArrayOfByte1, paramArrayOfByte2, paramString, paramInt, paramHashMap);
  }
  
  @NonNull
  public String getPropertyString(@NonNull String paramString)
  {
    return this.mMediaDrm.getPropertyString(paramString);
  }
  
  public MediaDrm.ProvisionRequest getProvisionRequest()
  {
    return this.mMediaDrm.getProvisionRequest();
  }
  
  @NonNull
  public byte[] openSession()
    throws NotProvisionedException, ResourceBusyException
  {
    return this.mMediaDrm.openSession();
  }
  
  @Nullable
  public byte[] provideKeyResponse(@NonNull byte[] paramArrayOfByte1, @NonNull byte[] paramArrayOfByte2)
    throws NotProvisionedException, DeniedByServerException
  {
    return this.mMediaDrm.provideKeyResponse(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public void provideProvisionResponse(@NonNull byte[] paramArrayOfByte)
    throws DeniedByServerException
  {
    this.mMediaDrm.provideProvisionResponse(paramArrayOfByte);
  }
  
  @NonNull
  public HashMap<String, String> queryKeyStatus(@NonNull byte[] paramArrayOfByte)
  {
    return this.mMediaDrm.queryKeyStatus(paramArrayOfByte);
  }
  
  public void removeKeys(@NonNull byte[] paramArrayOfByte)
  {
    this.mMediaDrm.removeKeys(paramArrayOfByte);
  }
  
  public void restoreKeys(@NonNull byte[] paramArrayOfByte1, @NonNull byte[] paramArrayOfByte2)
  {
    this.mMediaDrm.restoreKeys(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public void setOnEventListener(@Nullable ITPMediaDrm.OnEventListener paramOnEventListener)
  {
    this.mOnEventListener = paramOnEventListener;
    this.mMediaDrm.setOnEventListener(new TPDirectMediaDrm.1(this));
  }
  
  @RequiresApi(api=23)
  public void setOnExpirationUpdateListener(@Nullable ITPMediaDrm.OnExpirationUpdateListener paramOnExpirationUpdateListener, @Nullable Handler paramHandler)
  {
    this.mOnExpirationUpdateListener = paramOnExpirationUpdateListener;
    this.mMediaDrm.setOnExpirationUpdateListener(new TPDirectMediaDrm.3(this), paramHandler);
  }
  
  @RequiresApi(api=23)
  public void setOnKeyStatusChangeListener(@Nullable ITPMediaDrm.OnKeyStatusChangeListener paramOnKeyStatusChangeListener, @Nullable Handler paramHandler)
  {
    this.mOnKeyStatusChangeListener = paramOnKeyStatusChangeListener;
    this.mMediaDrm.setOnKeyStatusChangeListener(new TPDirectMediaDrm.2(this), paramHandler);
  }
  
  public void setPropertyString(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.mMediaDrm.setPropertyString(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.TPDirectMediaDrm
 * JD-Core Version:    0.7.0.1
 */