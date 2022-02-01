import com.tencent.qphone.base.util.QLog;

public class ajxt
{
  protected static long abu;
  protected static long adA;
  protected static long adB;
  protected static long adC;
  protected static long adz;
  protected static int cdN = 0;
  protected static int dlE;
  protected static long mStartPlayTime;
  protected static String networktype = "";
  
  public static void RB(int paramInt)
  {
    cdN = paramInt;
    abu = 0L;
    adz = 0L;
    adA = 0L;
    adC = 0L;
    mStartPlayTime = 0L;
    dlE = 0;
    networktype = jqc.getNetWorkType() + "";
    abu = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportEntryTime,time = " + abu);
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    if (cdN == 2) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, " reportVideoSurportPlayOnline,time =  feedid = " + paramString1 + " reportType=" + paramInt + " downloadProgress=" + paramString2 + " videoSize=" + paramString3 + "downloadedSize=" + paramString4 + "waitTime=" + (System.currentTimeMillis() - abu) + " isPlaying = " + paramBoolean + " startPlayTime =  " + mStartPlayTime);
    }
    int i;
    if (paramBoolean)
    {
      i = 1;
      paramString5 = new StringBuilder().append(System.currentTimeMillis() - abu).append("|");
      if (mStartPlayTime != 0L) {
        break label212;
      }
    }
    label212:
    for (int j = 1;; j = 2)
    {
      anot.a(null, "dc02676", "grp_lbs", paramString1, "video_quality", "play_support_online", paramInt, i, paramString2, paramString3, paramString4, j + "|" + paramString1 + "|||" + networktype);
      return;
      i = 0;
      break;
    }
  }
  
  public static void dzP()
  {
    adz = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportStartGetVideoInfoTime,time = " + adz);
    }
  }
  
  public static void dzQ()
  {
    adA = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportFinisGetVideoInfoTime,time = " + adA);
    }
  }
  
  public static void dzR()
  {
    adB = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportUIInitFinishTime,time = " + adB);
    }
  }
  
  public static void dzS()
  {
    adC = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportInitToPlayTime,time = " + adC);
    }
  }
  
  public static void dzT()
  {
    mStartPlayTime = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportStartPlayTime,time = " + mStartPlayTime);
    }
  }
  
  public static void fq(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportVideoLoad,time =  feedid = " + paramString + " loadingTime =" + dlE);
    }
    anot.a(null, "dc02676", "grp_lbs", paramString, "video_quality", "play_load_again", paramInt, 0, String.valueOf(dlE), "", "", "||" + paramString + "|||" + networktype);
  }
  
  public static long gs()
  {
    return mStartPlayTime - abu;
  }
  
  public static long gt()
  {
    return mStartPlayTime - adC;
  }
  
  public static void j(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportVideoPlayResult,time = feedid = " + paramString1 + " playType=" + paramInt + " errCode=" + paramString2 + " subErrCode=" + paramString3);
    }
    anot.a(null, "dc02676", "grp_lbs", paramString1, "video_quality", "play_result", paramInt, 0, paramString2, paramString3, "", "||" + paramString1 + "|||" + networktype);
  }
  
  public static void r(String paramString, int paramInt, boolean paramBoolean)
  {
    if (cdN != 0) {
      return;
    }
    long l1 = mStartPlayTime - adC;
    long l2 = adA - adz;
    long l3 = adB - abu;
    long l4 = mStartPlayTime - abu;
    if (QLog.isColorLevel()) {
      QLog.i("QualityReporter", 2, "reportVideoPlayLoadTime,videoLoadTime = " + l1 + " getVideoInfoTime = " + l2 + " initVideoListUITime =" + l3 + " allTimeConsume=" + l4 + " feedsid=" + paramString + " playType=" + paramInt + " isUrlProvide=" + paramBoolean);
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      anot.a(null, "dc02676", "grp_lbs", paramString, "video_quality", "play_loading_time", paramInt, i, String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(l4) + "||" + paramString + "|||" + networktype);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxt
 * JD-Core Version:    0.7.0.1
 */