package com.tencent.weiyun.cmd;

import android.text.TextUtils;
import com.tencent.weiyun.data.DirItem;
import com.tencent.weiyun.data.FileItem;
import com.tencent.weiyun.data.PoiItem;
import com.tencent.weiyun.utils.WyLog;

class WeiyunNative
{
  private static final String TAG = "WeiyunNative";
  protected static boolean sIsLoaded = false;
  
  static
  {
    loadLibrary(null);
  }
  
  protected static boolean loadLibrary(String paramString)
  {
    bool2 = true;
    bool3 = true;
    bool1 = true;
    if (sIsLoaded) {
      return true;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          System.loadLibrary("wlc_data_cmd_qq_v1.0.1");
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        bool1 = false;
        WyLog.e("WeiyunNative", "System.loadLibrary failed..", localUnsatisfiedLinkError1);
        continue;
      }
      catch (Exception localException1)
      {
        bool1 = false;
        WyLog.e("WeiyunNative", "System.loadLibrary failed..", localException1);
        continue;
      }
      try
      {
        WyLog.v("WeiyunNative", "System.loadLibrary wlc_data_cmd_qq_v1.0.1 finish.");
        WyLog.i("WeiyunNative", "loadLibrary libwlc_data_cmd_qq_v1.0.1.so result " + bool1 + ", path=" + paramString);
        sIsLoaded = bool1;
        return bool1;
      }
      catch (Exception localException2)
      {
        bool1 = bool3;
        continue;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        bool1 = bool2;
        continue;
      }
      System.load(paramString);
    }
  }
  
  protected native void nativeCheckShareFile(DirItem[] paramArrayOfDirItem, FileItem[] paramArrayOfFileItem, String[] paramArrayOfString, long paramLong);
  
  protected native void nativeDeleteDirFile(DirItem[] paramArrayOfDirItem, FileItem[] paramArrayOfFileItem, long paramLong);
  
  protected native void nativeFetchFileList(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, long paramLong);
  
  protected native void nativeFetchFileListRecursively(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
  
  protected native void nativeFetchPOI(PoiItem[] paramArrayOfPoiItem, long paramLong);
  
  protected native void nativeFetchPicVideoInfo(long paramLong);
  
  protected native void nativeFetchUserInfo(long paramLong);
  
  protected native void nativeModifyFile(FileItem paramFileItem1, FileItem paramFileItem2, long paramLong);
  
  protected native void nativeRegisterContext(WeiyunSDKContext paramWeiyunSDKContext);
  
  protected native void nativeReset();
  
  protected native String nativeVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.cmd.WeiyunNative
 * JD-Core Version:    0.7.0.1
 */