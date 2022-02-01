package com.tencent.oskplayer.util;

import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VideoSpeedReport
{
  private static final String DOUBLE_ARROW_SEP = "<->";
  public static final String LOG_TAG = "VideoSpeedReport";
  private static final int MIN_REFRESH_INTERVAL = 30000;
  public static final ReportPoint POINT_UPDATE_VIDEOVIEW = new ReportPoint("video_on_prepared<->update_videoview", false);
  public static final ReportPoint POINT_VIDEO_LIST_IDLE;
  public static final ReportPoint POINT_VIDEO_PREPARE_ASYNC;
  public static final ReportPoint POINT_VIDEO_VISIBLE = new ReportPoint("video_list_idle<->update_videoview", false);
  public static boolean isLaunchReported = false;
  private ReportType currentLaunchType = null;
  private ReportType currentReportType = null;
  private long launchStartTime;
  private final List<ReportPoint> mReportPoints = Collections.synchronizedList(new ArrayList());
  private long reportStartTime = 0L;
  
  static
  {
    POINT_VIDEO_LIST_IDLE = new ReportPoint("video_list_idle<->set_datasource", false);
    POINT_VIDEO_PREPARE_ASYNC = new ReportPoint("video_prepare_async<->mediaplayer_onprepared", false);
  }
  
  private void cleanReport()
  {
    this.reportStartTime = 0L;
    this.currentReportType = null;
    synchronized (this.mReportPoints)
    {
      Iterator localIterator = this.mReportPoints.iterator();
      while (localIterator.hasNext())
      {
        ReportPoint localReportPoint = (ReportPoint)localIterator.next();
        if (!localReportPoint.isLaunchPoint) {
          localReportPoint.clean();
        }
      }
    }
  }
  
  private void collectReport(ReportType paramReportType)
  {
    if (paramReportType == null) {}
    String str;
    do
    {
      return;
      str = paramReportType.getReportStr();
    } while (TextUtils.isEmpty(str));
    PlayerUtils.log(4, "VideoSpeedReport", "reportType: " + paramReportType.tag + ", reportStr: " + str);
  }
  
  public static VideoSpeedReport g()
  {
    return SpeedReportInstance.instance;
  }
  
  public void cancelStartupReport()
  {
    isLaunchReported = true;
  }
  
  public void cleanBrokenPoints() {}
  
  public void end(ReportPoint paramReportPoint)
  {
    if ((paramReportPoint.isEndTimeSet) || ((paramReportPoint.isLaunchPoint) && (isLaunchReported)) || ((!paramReportPoint.isLaunchPoint) && ((paramReportPoint.getEndTime() != 0L) || (this.reportStartTime == 0L))))
    {
      PlayerUtils.log(5, "VideoSpeedReport", "end point failed " + paramReportPoint.hashCode());
      return;
    }
    long l2 = System.currentTimeMillis();
    if (paramReportPoint.isLaunchPoint) {}
    for (long l1 = this.launchStartTime;; l1 = this.reportStartTime)
    {
      paramReportPoint.setEndTime(l2 - l1);
      ReportPoint.access$402(paramReportPoint, true);
      return;
    }
  }
  
  public boolean isLaunchTypeSet()
  {
    return this.currentLaunchType != null;
  }
  
  public void launchEnd()
  {
    if (isLaunchReported) {
      return;
    }
    collectReport(this.currentLaunchType);
    isLaunchReported = true;
  }
  
  public void launchStart()
  {
    this.launchStartTime = System.currentTimeMillis();
  }
  
  /* Error */
  public void reportEnd(ReportType paramReportType)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aload_0
    //   4: getfield 70	com/tencent/oskplayer/util/VideoSpeedReport:currentReportType	Lcom/tencent/oskplayer/util/VideoSpeedReport$ReportType;
    //   7: invokevirtual 193	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +14 -> 24
    //   13: aload_0
    //   14: getfield 72	com/tencent/oskplayer/util/VideoSpeedReport:reportStartTime	J
    //   17: lstore_2
    //   18: lload_2
    //   19: lconst_0
    //   20: lcmp
    //   21: ifne +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 70	com/tencent/oskplayer/util/VideoSpeedReport:currentReportType	Lcom/tencent/oskplayer/util/VideoSpeedReport$ReportType;
    //   32: invokespecial 187	com/tencent/oskplayer/util/VideoSpeedReport:collectReport	(Lcom/tencent/oskplayer/util/VideoSpeedReport$ReportType;)V
    //   35: aload_0
    //   36: invokespecial 195	com/tencent/oskplayer/util/VideoSpeedReport:cleanReport	()V
    //   39: goto -15 -> 24
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	VideoSpeedReport
    //   0	47	1	paramReportType	ReportType
    //   17	2	2	l	long
    // Exception table:
    //   from	to	target	type
    //   2	18	42	finally
    //   27	39	42	finally
  }
  
  /* Error */
  public void reportStart()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 72	com/tencent/oskplayer/util/VideoSpeedReport:reportStartTime	J
    //   10: lstore_3
    //   11: lload_1
    //   12: lload_3
    //   13: lsub
    //   14: ldc2_w 197
    //   17: lcmp
    //   18: ifge +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: invokespecial 195	com/tencent/oskplayer/util/VideoSpeedReport:cleanReport	()V
    //   28: aload_0
    //   29: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   32: putfield 72	com/tencent/oskplayer/util/VideoSpeedReport:reportStartTime	J
    //   35: goto -14 -> 21
    //   38: astore 5
    //   40: aload_0
    //   41: monitorexit
    //   42: aload 5
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	VideoSpeedReport
    //   5	7	1	l1	long
    //   10	3	3	l2	long
    //   38	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	38	finally
    //   24	35	38	finally
  }
  
  public void setReportType(ReportType paramReportType)
  {
    if (paramReportType.isLaunchType()) {
      this.currentLaunchType = paramReportType;
    }
    while (this.currentReportType != null) {
      return;
    }
    this.currentReportType = paramReportType;
  }
  
  public void start(ReportPoint paramReportPoint)
  {
    long l2 = 0L;
    label206:
    for (;;)
    {
      try
      {
        if ((paramReportPoint.isStartTimeSet) || ((paramReportPoint.isLaunchPoint) && (isLaunchReported)) || ((!paramReportPoint.isLaunchPoint) && ((paramReportPoint.getStartTime() != 0L) || (this.reportStartTime == 0L))))
        {
          PlayerUtils.log(5, "VideoSpeedReport", "start point failed " + paramReportPoint.hashCode());
          return;
        }
        long l3 = System.currentTimeMillis();
        if (paramReportPoint.isLaunchPoint)
        {
          l1 = this.launchStartTime;
          l1 = l3 - l1;
          if ((paramReportPoint.upperLimit <= 0) || (l1 < paramReportPoint.upperLimit) || (!paramReportPoint.isLaunchPoint) || (this.launchStartTime == 0L)) {
            break label206;
          }
          this.launchStartTime = System.currentTimeMillis();
          cleanBrokenPoints();
          l1 = l2;
          paramReportPoint.setStartTime(l1);
          ReportPoint.access$102(paramReportPoint, true);
          synchronized (this.mReportPoints)
          {
            this.mReportPoints.add(paramReportPoint);
          }
        }
        long l1 = this.reportStartTime;
      }
      finally {}
    }
  }
  
  public static class ReportPoint
  {
    public static final String HTTP_OPEN = "http_open_start<->http_open_end";
    private long endTime = 0L;
    private String extraInfo;
    private boolean isEndTimeSet = false;
    private boolean isLaunchPoint = true;
    private boolean isStartTimeSet = false;
    private String name;
    private long startTime = 0L;
    private int upperLimit = 0;
    
    public ReportPoint(String paramString)
    {
      this.name = paramString;
    }
    
    public ReportPoint(String paramString, boolean paramBoolean)
    {
      this(paramString);
      this.isLaunchPoint = paramBoolean;
    }
    
    public ReportPoint(String paramString, boolean paramBoolean, int paramInt)
    {
      this(paramString, paramBoolean, null);
      this.upperLimit = paramInt;
    }
    
    public ReportPoint(String paramString1, boolean paramBoolean, String paramString2)
    {
      this(paramString1);
      this.isLaunchPoint = paramBoolean;
      this.extraInfo = paramString2;
    }
    
    public void clean()
    {
      this.startTime = 0L;
      this.endTime = 0L;
      this.isStartTimeSet = false;
      this.isEndTimeSet = false;
    }
    
    public long getEndTime()
    {
      return this.endTime;
    }
    
    public String getExtraInfo()
    {
      return this.extraInfo;
    }
    
    public String getName()
    {
      return this.name;
    }
    
    public long getStartTime()
    {
      return this.startTime;
    }
    
    public void setEndTime(long paramLong)
    {
      this.endTime = paramLong;
    }
    
    public void setStartTime(long paramLong)
    {
      this.startTime = paramLong;
    }
  }
  
  public static class ReportType
  {
    public static final String TYPE_VIDEO_PLAY = "videoplay";
    private static Map<String, ReportType> sReportTypeMap = new HashMap(5, 0.75F);
    private List<VideoSpeedReport.ReportPoint> reportPoints;
    private String tag;
    
    public ReportType(String paramString, List<VideoSpeedReport.ReportPoint> paramList)
    {
      this.tag = paramString;
      this.reportPoints = paramList;
    }
    
    public static void addToVideoReportType(String paramString, VideoSpeedReport.ReportPoint paramReportPoint)
    {
      try
      {
        paramString = getVideoReportType(paramString);
        if (paramString != null)
        {
          paramString = paramString.getReportPoints();
          if (paramString != null) {
            paramString.add(paramReportPoint);
          }
        }
        return;
      }
      finally {}
    }
    
    private List<VideoSpeedReport.ReportPoint> getReportPoints()
    {
      return this.reportPoints;
    }
    
    public static ReportType getVideoReportType(String paramString)
    {
      if (paramString == null) {}
      for (paramString = null;; paramString = (ReportType)sReportTypeMap.get(paramString)) {
        for (;;)
        {
          return paramString;
          try
          {
            if (sReportTypeMap.get(paramString) == null)
            {
              ReportType localReportType = new ReportType(paramString, new ArrayList());
              sReportTypeMap.put(paramString, localReportType);
              paramString = localReportType;
            }
          }
          finally {}
        }
      }
    }
    
    public static void removeVideoReportType(String paramString)
    {
      if (paramString == null) {}
      for (;;)
      {
        return;
        try
        {
          sReportTypeMap.remove(paramString);
        }
        finally {}
      }
    }
    
    public String getReportStr()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < this.reportPoints.size())
      {
        VideoSpeedReport.ReportPoint localReportPoint = (VideoSpeedReport.ReportPoint)this.reportPoints.get(i);
        if ((localReportPoint.getEndTime() - localReportPoint.getStartTime() < 0L) && (PlayerConfig.g().isDebugVersion())) {
          PlayerUtils.log(3, "VideoSpeedReport", localReportPoint.getName() + "(" + localReportPoint.hashCode() + ") 错误：结束时间小于开始时间 " + localReportPoint.getStartTime() + "," + localReportPoint.getEndTime());
        }
        if ((localReportPoint.getStartTime() > 10000000L) || (localReportPoint.getEndTime() > 10000000L)) {
          if (PlayerConfig.g().isDebugVersion()) {
            PlayerUtils.log(3, "VideoSpeedReport", localReportPoint.getName() + "(" + localReportPoint.hashCode() + ") 错误：开始或结束时间大于最大值" + localReportPoint.getStartTime() + "," + localReportPoint.getEndTime());
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if ((localReportPoint.getStartTime() != 0L) || (localReportPoint.getEndTime() != 0L)) {
            break label324;
          }
          if (PlayerConfig.g().isDebugVersion()) {
            PlayerUtils.log(3, "VideoSpeedReport", localReportPoint.getName() + "(" + localReportPoint.hashCode() + ") 丢弃：开始时间、结束时间都为0" + localReportPoint.getStartTime() + "," + localReportPoint.getEndTime());
          }
        }
        label324:
        if (localStringBuilder.length() != 0) {}
        for (str = ";\n";; str = "\n")
        {
          localStringBuilder.append(str);
          localStringBuilder.append(localReportPoint.getName() + ":");
          localStringBuilder.append(localReportPoint.getStartTime() + ",");
          localStringBuilder.append(localReportPoint.getEndTime() + ",");
          if (localReportPoint.getExtraInfo() == null) {
            break;
          }
          localStringBuilder.append(localReportPoint.getExtraInfo());
          break;
        }
      }
      String str = localStringBuilder.toString();
      localStringBuilder.delete(0, localStringBuilder.length());
      return str;
    }
    
    public String getTag()
    {
      return this.tag;
    }
    
    public boolean isLaunchType()
    {
      return this.tag.contains("startupSpeed_");
    }
  }
  
  static class SpeedReportInstance
  {
    private static final VideoSpeedReport instance = new VideoSpeedReport();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.VideoSpeedReport
 * JD-Core Version:    0.7.0.1
 */