package com.tencent.thumbplayer.core.drm;

import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm.KeyRequest;
import android.media.MediaDrm.ProvisionRequest;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.drm.reuse.TPNotMatchedUUIDException;
import java.util.UUID;

@TargetApi(18)
public class TPMediaDrmProxy
{
  private static final String TAG = "[PlayerCore][TPMediaDrmProxy]";
  private static boolean mReuseEnable = false;
  private ITPMediaDrm mMediaDrm;
  private long mNativeContext;
  private UUID mUUID;
  
  private TPMediaDrmProxy(@NonNull UUID paramUUID)
    throws UnsupportedSchemeException
  {
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    if (mReuseEnable) {}
    for (;;)
    {
      try
      {
        localITPMediaDrm = TPMediaDrmFactory.createTPReuseMediaDrm(paramUUID);
        localObject4 = localITPMediaDrm;
        localObject5 = localITPMediaDrm;
        localObject6 = localITPMediaDrm;
        TPNativeLog.printLog(2, "[PlayerCore][TPMediaDrmProxy]", "create reuse MediaDrm.");
      }
      catch (NotProvisionedException localNotProvisionedException)
      {
        ITPMediaDrm localITPMediaDrm;
        TPNativeLog.printLog(3, localNotProvisionedException.getMessage());
        Object localObject1 = localObject4;
        continue;
      }
      catch (Exception localException)
      {
        TPNativeLog.printLog(3, localException.getMessage());
        Object localObject2 = localObject5;
        continue;
      }
      catch (TPNotMatchedUUIDException localTPNotMatchedUUIDException)
      {
        localObject4 = localObject6;
        continue;
      }
      localObject4 = localITPMediaDrm;
      if (localITPMediaDrm == null)
      {
        localObject4 = TPMediaDrmFactory.createTPMediaDrm(paramUUID);
        TPNativeLog.printLog(2, "[PlayerCore][TPMediaDrmProxy]", "create direct MediaDrm.");
      }
      ((ITPMediaDrm)localObject4).setOnEventListener(new TPMediaDrmProxy.1(this));
      this.mMediaDrm = ((ITPMediaDrm)localObject4);
      this.mUUID = paramUUID;
      return;
      Object localObject3 = null;
    }
  }
  
  public static TPMediaDrmProxy createMediaDrmProxyByUUID(String paramString)
  {
    if (paramString == null)
    {
      TPNativeLog.printLog(4, "illegal argument.");
      return null;
    }
    if (Build.VERSION.SDK_INT < 18) {
      return null;
    }
    try
    {
      paramString = new TPMediaDrmProxy(UUID.fromString(paramString));
      return paramString;
    }
    catch (UnsupportedSchemeException paramString)
    {
      TPNativeLog.printLog(4, paramString.getMessage());
      return null;
    }
    catch (IllegalArgumentException paramString)
    {
      label37:
      break label37;
    }
  }
  
  /* Error */
  public static boolean isCryptoSchemeSupported(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +11 -> 12
    //   4: iconst_2
    //   5: ldc 121
    //   7: invokestatic 87	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   10: iconst_0
    //   11: ireturn
    //   12: aload_0
    //   13: invokestatic 115	java/util/UUID:fromString	(Ljava/lang/String;)Ljava/util/UUID;
    //   16: astore_0
    //   17: iconst_2
    //   18: ldc 123
    //   20: invokestatic 87	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   23: new 125	android/media/MediaDrm
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 126	android/media/MediaDrm:<init>	(Ljava/util/UUID;)V
    //   31: astore_2
    //   32: getstatic 109	android/os/Build$VERSION:SDK_INT	I
    //   35: bipush 28
    //   37: if_icmplt +65 -> 102
    //   40: aload_2
    //   41: invokevirtual 129	android/media/MediaDrm:close	()V
    //   44: iconst_2
    //   45: ldc 131
    //   47: invokestatic 87	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   50: aload_0
    //   51: invokestatic 134	android/media/MediaDrm:isCryptoSchemeSupported	(Ljava/util/UUID;)Z
    //   54: istore_1
    //   55: iconst_2
    //   56: new 136	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   63: ldc 139
    //   65: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_1
    //   69: invokevirtual 146	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   72: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 87	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   78: iload_1
    //   79: ireturn
    //   80: astore_0
    //   81: iconst_4
    //   82: aload_0
    //   83: invokevirtual 150	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   86: invokestatic 87	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   89: iconst_0
    //   90: ireturn
    //   91: astore_0
    //   92: iconst_4
    //   93: aload_0
    //   94: invokevirtual 151	android/media/UnsupportedSchemeException:getMessage	()Ljava/lang/String;
    //   97: invokestatic 87	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   100: iconst_0
    //   101: ireturn
    //   102: aload_2
    //   103: invokevirtual 154	android/media/MediaDrm:release	()V
    //   106: goto -62 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramString	String
    //   54	25	1	bool	boolean
    //   31	72	2	localMediaDrm	android.media.MediaDrm
    // Exception table:
    //   from	to	target	type
    //   12	17	80	java/lang/IllegalArgumentException
    //   23	32	91	android/media/UnsupportedSchemeException
  }
  
  private native void native_mediaDrmOnEvent(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, @NonNull byte[] paramArrayOfByte2);
  
  public static void setMediaDrmReuseEnable(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setMediaDrmReuseEnable, reuse:");
    if (paramBoolean) {}
    for (String str = "true";; str = "false")
    {
      TPNativeLog.printLog(2, "[PlayerCore][TPMediaDrmProxy]", str);
      mReuseEnable = paramBoolean;
      if (paramBoolean) {}
      try
      {
        TPMediaDrmFactory.createTPReuseMediaDrm(UUID.randomUUID()).close();
        return;
      }
      catch (NotProvisionedException localNotProvisionedException)
      {
        TPNativeLog.printLog(3, localNotProvisionedException.getMessage());
        return;
      }
      catch (Exception localException)
      {
        TPNativeLog.printLog(3, localException.getMessage());
        return;
      }
      catch (TPNotMatchedUUIDException localTPNotMatchedUUIDException)
      {
        break;
      }
    }
  }
  
  public void closeSession(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.mMediaDrm.closeSession(paramArrayOfByte);
  }
  
  public KeyRequest getKeyRequest(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        paramArrayOfByte1 = this.mMediaDrm.getKeyRequest(paramArrayOfByte1, paramArrayOfByte2, paramString, paramInt, null);
        if (Build.VERSION.SDK_INT >= 23)
        {
          paramInt = paramArrayOfByte1.getRequestType();
          return new KeyRequest(paramInt, paramArrayOfByte1.getData(), 0);
        }
      }
      catch (NotProvisionedException paramArrayOfByte1)
      {
        return new KeyRequest(-1, null, -1);
      }
      paramInt = 0;
    }
  }
  
  public MediaCrypto getMediaCrypto(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new MediaCrypto(this.mUUID, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (MediaCryptoException paramArrayOfByte) {}
    return null;
  }
  
  public String getPropertyString(String paramString)
  {
    return this.mMediaDrm.getPropertyString(paramString);
  }
  
  public ProvisionRequest getProvisionRequest()
  {
    MediaDrm.ProvisionRequest localProvisionRequest = this.mMediaDrm.getProvisionRequest();
    return new ProvisionRequest(localProvisionRequest.getDefaultUrl(), localProvisionRequest.getData());
  }
  
  public DrmSessionId openSession()
  {
    Object localObject = null;
    i = 0;
    try
    {
      byte[] arrayOfByte = this.mMediaDrm.openSession();
      localObject = arrayOfByte;
    }
    catch (NotProvisionedException localNotProvisionedException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = -2;
      }
    }
    return new DrmSessionId(i, localObject);
  }
  
  public int provideKeyResponse(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      this.mMediaDrm.provideKeyResponse(paramArrayOfByte1, paramArrayOfByte2);
      return 0;
    }
    catch (NotProvisionedException paramArrayOfByte1)
    {
      return -1;
    }
    catch (DeniedByServerException paramArrayOfByte1) {}
    return -2;
  }
  
  public int provideProvisionResponse(byte[] paramArrayOfByte)
  {
    try
    {
      this.mMediaDrm.provideProvisionResponse(paramArrayOfByte);
      return 0;
    }
    catch (DeniedByServerException paramArrayOfByte) {}
    return -1;
  }
  
  public void release()
  {
    this.mMediaDrm.close();
  }
  
  public void setPropertyString(String paramString1, String paramString2)
  {
    this.mMediaDrm.setPropertyString(paramString1, paramString2);
  }
  
  public static final class DrmSessionId
  {
    byte[] mSessionId;
    int mStatus;
    
    DrmSessionId(int paramInt, byte[] paramArrayOfByte)
    {
      this.mStatus = paramInt;
      this.mSessionId = paramArrayOfByte;
    }
  }
  
  public static final class KeyRequest
  {
    byte[] mData;
    int mRequestType;
    int mStatus;
    
    KeyRequest(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    {
      this.mRequestType = paramInt1;
      this.mData = paramArrayOfByte;
      this.mStatus = paramInt2;
    }
  }
  
  public static final class ProvisionRequest
  {
    byte[] mData;
    String mDefaultUrl;
    
    ProvisionRequest(String paramString, byte[] paramArrayOfByte)
    {
      this.mDefaultUrl = paramString;
      this.mData = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.TPMediaDrmProxy
 * JD-Core Version:    0.7.0.1
 */