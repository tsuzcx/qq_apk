package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import npe;

public class NativeBitmap
{
  static boolean atK = true;
  
  static
  {
    try
    {
      atK = SoLoadUtil.loadNativeLibrary(BaseApplicationImpl.getApplication(), "readinjoybitmaps", 0, true);
      return;
    }
    catch (Exception localException)
    {
      atK = false;
      if (QLog.isColorLevel()) {
        npe.log("NativeBitmap", "load so fail");
      }
      if (BaseApplicationImpl.sProcessId == 1)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("model", Build.MODEL);
        localHashMap.put("androidVersion", Build.VERSION.SDK);
        localHashMap.put("brand", Build.BRAND);
        anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "readinjoy.loadso", false, 0L, 0L, localHashMap, null);
      }
      return;
    }
    finally
    {
      if (QLog.isColorLevel()) {
        npe.log("NativeBitmap", "canUseNativeBitmap:" + atK);
      }
    }
  }
  
  public static native void nativePinBitmap(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.NativeBitmap
 * JD-Core Version:    0.7.0.1
 */