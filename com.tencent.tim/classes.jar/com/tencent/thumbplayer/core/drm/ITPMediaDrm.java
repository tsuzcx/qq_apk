package com.tencent.thumbplayer.core.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm.KeyRequest;
import android.media.MediaDrm.KeyStatus;
import android.media.MediaDrm.ProvisionRequest;
import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.List;

public abstract interface ITPMediaDrm
{
  public abstract void close();
  
  public abstract void closeSession(@NonNull byte[] paramArrayOfByte);
  
  @NonNull
  public abstract MediaDrm.KeyRequest getKeyRequest(@NonNull byte[] paramArrayOfByte1, @Nullable byte[] paramArrayOfByte2, @Nullable String paramString, int paramInt, @Nullable HashMap<String, String> paramHashMap)
    throws NotProvisionedException;
  
  @NonNull
  public abstract String getPropertyString(@NonNull String paramString);
  
  public abstract MediaDrm.ProvisionRequest getProvisionRequest();
  
  @NonNull
  public abstract byte[] openSession()
    throws NotProvisionedException, ResourceBusyException;
  
  @Nullable
  public abstract byte[] provideKeyResponse(@NonNull byte[] paramArrayOfByte1, @NonNull byte[] paramArrayOfByte2)
    throws NotProvisionedException, DeniedByServerException;
  
  public abstract void provideProvisionResponse(@NonNull byte[] paramArrayOfByte)
    throws DeniedByServerException;
  
  @NonNull
  public abstract HashMap<String, String> queryKeyStatus(@NonNull byte[] paramArrayOfByte);
  
  public abstract void removeKeys(@NonNull byte[] paramArrayOfByte);
  
  public abstract void restoreKeys(@NonNull byte[] paramArrayOfByte1, @NonNull byte[] paramArrayOfByte2);
  
  public abstract void setOnEventListener(@Nullable OnEventListener paramOnEventListener);
  
  public abstract void setOnExpirationUpdateListener(@Nullable OnExpirationUpdateListener paramOnExpirationUpdateListener, @Nullable Handler paramHandler);
  
  public abstract void setOnKeyStatusChangeListener(@Nullable OnKeyStatusChangeListener paramOnKeyStatusChangeListener, @Nullable Handler paramHandler);
  
  public abstract void setPropertyString(@NonNull String paramString1, @NonNull String paramString2);
  
  public static abstract interface OnEventListener
  {
    public abstract void onEvent(@NonNull ITPMediaDrm paramITPMediaDrm, @Nullable byte[] paramArrayOfByte1, int paramInt1, int paramInt2, @Nullable byte[] paramArrayOfByte2);
  }
  
  public static abstract interface OnExpirationUpdateListener
  {
    public abstract void onExpirationUpdate(@NonNull ITPMediaDrm paramITPMediaDrm, @NonNull byte[] paramArrayOfByte, long paramLong);
  }
  
  public static abstract interface OnKeyStatusChangeListener
  {
    public abstract void onKeyStatusChange(@NonNull ITPMediaDrm paramITPMediaDrm, @NonNull byte[] paramArrayOfByte, @NonNull List<MediaDrm.KeyStatus> paramList, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.ITPMediaDrm
 * JD-Core Version:    0.7.0.1
 */