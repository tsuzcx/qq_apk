package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.videoplatform.util.LoadSoUtil;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.thumbplayer.api.ITPModuleLoader;

class VideoPlaySDKManager$3
  implements ITPModuleLoader
{
  VideoPlaySDKManager$3(VideoPlaySDKManager paramVideoPlaySDKManager) {}
  
  public void loadLibrary(String paramString1, String paramString2)
    throws Throwable
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatForm]VideoPlaySDKManager", 2, "loadLibrary, libName = " + paramString1 + " , apkSoVer = " + paramString2);
    }
    if ((!LoadSoUtil.isTPCoreLoad()) && (paramString1.equals("TPCore-master")) && (!LoadSoUtil.loadTPCoreSync())) {
      throw new Throwable("LoadSoUtil.loadTPCoreSync error.");
    }
    if ((!LoadSoUtil.isDownProxyLoad()) && (paramString1.equals("DownloadProxy")) && (!LoadSoUtil.loadDownProxySync())) {
      throw new Throwable("LoadSoUtil.loadDownProxySync error.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlaySDKManager.3
 * JD-Core Version:    0.7.0.1
 */