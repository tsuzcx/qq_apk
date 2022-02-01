package com.tencent.upload.uinterface;

import android.content.Context;
import android.content.Intent;
import com.tencent.upload.common.UploadConfiguration;
import java.util.StringTokenizer;

public class Utility
{
  private static final String MAGIC_CLASS_NAME = "126%138%136%73%143%128%137%126%128%137%143%73%146%137%142%73%128%147%139%138%141%143%73%96%136%139%143%148%110%128%141%145%132%126%128%";
  private static final String MAGIC_PACKAGE_NAME = "126%138%136%73%140%149%138%137%128%";
  
  public static final boolean clearUploadTempCache(Context paramContext)
  {
    return UploadServiceBuilder.getInstance().clearCacheWhenIdle(paramContext);
  }
  
  public static String decrypt(String paramString)
  {
    try
    {
      String str = new String();
      StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "%");
      int i;
      for (paramString = str; localStringTokenizer.hasMoreElements(); paramString = paramString + (char)(i - 27)) {
        i = Integer.parseInt((String)localStringTokenizer.nextElement());
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static final long getCurrentUploadServerTime()
  {
    long[] arrayOfLong = UploadConfiguration.getUploadServerTimePair();
    if ((arrayOfLong == null) || (arrayOfLong.length != 2) || (arrayOfLong[0] <= 0L) || (arrayOfLong[1] <= 0L)) {
      return System.currentTimeMillis() / 1000L;
    }
    return arrayOfLong[0] + System.currentTimeMillis() / 1000L - arrayOfLong[1];
  }
  
  public static final void keepLongConnection(Context paramContext, Long paramLong, String paramString)
  {
    keepLongConnection(paramContext, paramLong, paramString, "126%138%136%73%140%149%138%137%128%", "126%138%136%73%143%128%137%126%128%137%143%73%146%137%142%73%128%147%139%138%141%143%73%96%136%139%143%148%110%128%141%145%132%126%128%");
  }
  
  public static final void keepLongConnection(Context paramContext, Long paramLong, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_from", 0);
    localIntent.putExtra("param_uin", paramLong);
    localIntent.putExtra("param_scene", 2);
    localIntent.putExtra("param_push_data", paramString1);
    localIntent.setClassName(decrypt(paramString2), decrypt(paramString3));
    paramContext.startService(localIntent);
  }
  
  public static final boolean needCompress2Webp(int paramInt1, int paramInt2)
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
    public static final int ALBUM_KING = 24;
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
    public static final int ALBUM_SHARE = 23;
    public static final int ALBUM_SHARE_OLD = 21;
    public static final int ALBUM_SYSTEM = 22;
    public static final int ALBUM_WEAPP = 25;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.uinterface.Utility
 * JD-Core Version:    0.7.0.1
 */