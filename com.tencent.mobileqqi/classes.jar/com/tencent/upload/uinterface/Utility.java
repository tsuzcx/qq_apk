package com.tencent.upload.uinterface;

import android.content.Context;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.route.UploadRoute;

public class Utility
{
  public static volatile String CUSTOM_IP = "119.147.14.28";
  public static volatile int CUSTOM_PORT = 19994;
  public static final String DEBUG_IP = "119.147.14.28";
  public static final int DEBUG_PORT = 19994;
  public static final String PREISSUE_IP = "113.108.67.20";
  public static final int PREISSUE_PORT = 19995;
  public static final String TEST_IP = "113.108.76.228";
  public static final int TEST_PORT = 8080;
  
  public static final boolean clearUploadTempCache(Context paramContext)
  {
    return IUploadService.UploadServiceCreator.getInstance().clearCacheWhenIdle(paramContext);
  }
  
  public static final long getCurrentUploadServerTime()
  {
    long[] arrayOfLong = UploadConfiguration.getUploadServerTimePair();
    if ((arrayOfLong == null) || (arrayOfLong.length != 2) || (arrayOfLong[0] <= 0L) || (arrayOfLong[1] <= 0L)) {
      return System.currentTimeMillis() / 1000L;
    }
    return arrayOfLong[0] + System.currentTimeMillis() / 1000L - arrayOfLong[1];
  }
  
  public static final boolean isCompressToWebp(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 2) && ((paramInt1 & 0x10) == 16)) {}
    while ((paramInt2 != 2) && (paramInt2 != 3) && ((paramInt1 & 0x1) == 1)) {
      return true;
    }
    return false;
  }
  
  public static class AlbumTypeID
  {
    public static final int ALBUM_BLOG = 2;
    public static final int ALBUM_BLOGFACE = 9;
    public static final int ALBUM_CAMPUS = 5;
    public static final int ALBUM_COMMON = 0;
    public static final int ALBUM_MICRO = 11;
    public static final int ALBUM_MOBILE = 1;
    public static final int ALBUM_OLDMICRO = 12;
    public static final int ALBUM_OLDPYHEAD = 18;
    public static final int ALBUM_OLDQPAI = 14;
    public static final int ALBUM_OLDQPAI_SYNC = 16;
    public static final int ALBUM_OLDQZONEAPP = 20;
    public static final int ALBUM_PPT = 10;
    public static final int ALBUM_PRIVBLOG = 7;
    public static final int ALBUM_PYHEAD = 17;
    public static final int ALBUM_QPAI = 13;
    public static final int ALBUM_QPAI_SYNC = 15;
    public static final int ALBUM_QQSHOW = 4;
    public static final int ALBUM_QZONEAPP = 19;
  }
  
  public static final class ServerCategory
  {
    private static final int BEGINE_BASE = -1;
    public static final int OTHER = 1;
    public static final int PICTURE = 0;
    public static final int TOTAL_COUNT = 2;
    
    public static final String print(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "SUnknown";
      case 0: 
        return "SPic";
      }
      return "SOther";
    }
  }
  
  public static final class TestServerCategory
  {
    public static final int CUSTOM = 4;
    public static final int DEBUG = 3;
    public static final int NORMAL = 0;
    public static final int PREISSUE = 1;
    public static final int TEST = 2;
    
    public static final UploadRoute getTestRoute(int paramInt1, int paramInt2)
    {
      String str;
      switch (paramInt2)
      {
      default: 
        str = "113.108.67.20";
        paramInt1 = 19995;
      }
      for (;;)
      {
        return new UploadRoute(str, paramInt1, 1, 3);
        str = "113.108.76.228";
        paramInt1 = 8080;
        continue;
        str = "119.147.14.28";
        paramInt1 = 19994;
        continue;
        str = Utility.CUSTOM_IP;
        paramInt1 = Utility.CUSTOM_PORT;
      }
    }
    
    public static final String getTestServerInfo(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "上传正式环境";
      case 2: 
        return "上传测试环境(113.108.76.228:8080)";
      case 3: 
        return "上传调试环境 (119.147.14.28:19994)";
      case 1: 
        return "上传DB环境(113.108.67.20:19995)";
      }
      return "上传自定义环境";
    }
    
    public static final String print(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "unknownServer";
      case 0: 
        return "normalServer";
      case 1: 
        return "perissueServer";
      case 2: 
        return "testServer";
      case 3: 
        return "debugServer";
      }
      return "customServer";
    }
    
    public static final boolean useTestServer(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return false;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.uinterface.Utility
 * JD-Core Version:    0.7.0.1
 */