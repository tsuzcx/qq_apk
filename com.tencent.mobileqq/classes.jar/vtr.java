import android.os.Handler;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.report.QCircleLpReportDc05507.1;
import com.tencent.biz.qqcircle.report.QCircleLpReportDc05507.2;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleFeedBase.StReportInfoForClient;

public class vtr
{
  public static ArrayList<FeedCloudCommon.Entry> a(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject2 = vtt.a("touin", paramStFeed.poster.id.get());
    FeedCloudCommon.Entry localEntry1 = vtt.a("feedid", paramStFeed.id.get());
    FeedCloudCommon.Entry localEntry2 = vtt.a("author_uin", paramStFeed.poster.id.get());
    FeedCloudCommon.Entry localEntry3 = vtt.a("video_total_time", String.valueOf(paramStFeed.video.duration.get()));
    Object localObject1;
    if (uzg.c((FeedCloudMeta.StUser)paramStFeed.poster.get()))
    {
      localObject1 = "2";
      localObject1 = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { localObject2, localEntry1, localEntry2, localEntry3, vtt.a("video_type", (String)localObject1), vtt.a("cubage", String.valueOf(paramStFeed.video.fileSize.get())), vtt.a("width", String.valueOf(paramStFeed.video.width.get())), vtt.a("height", String.valueOf(paramStFeed.video.height.get())), vtt.a("clear", String.valueOf(paramStFeed.video.videoRate.get())), vtt.a("play_id", paramStFeed.video.fileId.get()), vtt.a("vid", paramStFeed.video.fileId.get()), vtt.a("lloc", paramStFeed.cover.picId.get()), vtt.a("feed_tag", vur.a(paramStFeed)), vtt.a("play_url", paramStFeed.video.playUrl.get()), vtt.a("video_tag", paramStFeed.video.playUrl.get()), vtt.a("pic_info", paramStFeed.cover.picUrl.get()), vtt.a("item_detail", paramStFeed.title.get() + "|" + paramStFeed.content.get()), vtt.a("acttime", String.valueOf(System.currentTimeMillis())) }));
      if (!paramStFeed.reportInfoForClient.has()) {
        break label558;
      }
      localObject2 = new QQCircleFeedBase.StReportInfoForClient();
    }
    for (;;)
    {
      try
      {
        ((QQCircleFeedBase.StReportInfoForClient)localObject2).mergeFrom(paramStFeed.reportInfoForClient.get().toByteArray());
        ((ArrayList)localObject1).addAll(Arrays.asList(new FeedCloudCommon.Entry[] { vtt.a("feedtype1", String.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject2).feedtype1.get())), vtt.a("feedtype2", String.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject2).feedtype2.get())), vtt.a("feedtype3", String.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject2).feedtype3.get())) }));
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException paramStFeed)
      {
        paramStFeed.printStackTrace();
        i = 0;
        continue;
      }
      if (i == 0) {
        ((ArrayList)localObject1).addAll(Arrays.asList(new FeedCloudCommon.Entry[] { vtt.a("feedtype1", "1"), vtt.a("feedtype2", "2") }));
      }
      return localObject1;
      localObject1 = "1";
      break;
      label558:
      int i = 0;
    }
  }
  
  private static void a(int paramInt1, int paramInt2) {}
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, boolean paramBoolean, String paramString, FeedCloudMeta.StFeed paramStFeed, List<FeedCloudCommon.Entry> paramList, int paramInt5)
  {
    if (paramInt5 <= 0)
    {
      QLog.e("QCircleReportBean_QCircleLpReportDc05507", 1, "report invalid pageId," + paramInt5 + ",actionType:" + paramInt1 + ",subActionType:" + paramInt2);
      a(paramInt1, paramInt2);
    }
    vtw.a().a().post(new QCircleLpReportDc05507.1(paramList, paramInt1, paramInt2, paramInt3, paramInt5, paramInt4, paramLong1, paramLong2, paramBoolean, paramString, paramStFeed));
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FeedCloudMeta.StFeed paramStFeed, int paramInt5, int paramInt6, String paramString, List<FeedCloudCommon.Entry> paramList, int paramInt7)
  {
    if (paramStFeed == null) {
      return;
    }
    a(paramStFeed.poster.id.get(), paramInt3, paramInt4, paramInt1, paramInt2, paramStFeed.id.get(), paramStFeed.poster.id.get(), paramInt5, paramInt6, vur.a(paramStFeed), paramStFeed.video.playUrl.get(), paramStFeed.cover.picUrl.get(), paramStFeed.title.get() + "|" + paramStFeed.content.get(), paramStFeed, paramString, paramList, paramInt7, -1);
  }
  
  public static void a(int paramInt1, int paramInt2, ExtraTypeInfo paramExtraTypeInfo, int paramInt3)
  {
    a(paramInt1, paramInt2, paramExtraTypeInfo, paramInt3, null);
  }
  
  public static void a(int paramInt1, int paramInt2, ExtraTypeInfo paramExtraTypeInfo, int paramInt3, String paramString)
  {
    if ((!(paramExtraTypeInfo instanceof ReportExtraTypeInfo)) || (((ReportExtraTypeInfo)paramExtraTypeInfo).mFeed == null))
    {
      QLog.e("QCircleReportHelper_QCircleLpReportDc05507", 1, "ExtraTypeInfo is not ReportExtraTypeInfo,actionType:" + paramInt1 + ",subActionType:" + paramInt2);
      return;
    }
    FeedCloudMeta.StFeed localStFeed = ((ReportExtraTypeInfo)paramExtraTypeInfo).mFeed;
    int[] arrayOfInt = vur.a(localStFeed);
    if (TextUtils.isEmpty(paramString)) {
      paramString = localStFeed.poster.id.get();
    }
    for (;;)
    {
      a(paramString, arrayOfInt[0], arrayOfInt[1], paramInt1, paramInt2, localStFeed.id.get(), localStFeed.poster.id.get(), ((ReportExtraTypeInfo)paramExtraTypeInfo).mPlayScene, paramExtraTypeInfo.mDataPosition, vur.a(localStFeed), localStFeed.video.playUrl.get(), localStFeed.cover.picUrl.get(), localStFeed.title.get() + "|" + localStFeed.content.get(), localStFeed, paramInt3, -1);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, ExtraTypeInfo paramExtraTypeInfo, List<FeedCloudCommon.Entry> paramList, int paramInt3)
  {
    if ((!(paramExtraTypeInfo instanceof ReportExtraTypeInfo)) || (((ReportExtraTypeInfo)paramExtraTypeInfo).mFeed == null))
    {
      QLog.e("QCircleReportHelper_QCircleLpReportDc05507", 1, "ExtraTypeInfo is not ReportExtraTypeInfo,actionType:" + paramInt1 + ",subActionType:" + paramInt2);
      return;
    }
    FeedCloudMeta.StFeed localStFeed = ((ReportExtraTypeInfo)paramExtraTypeInfo).mFeed;
    int[] arrayOfInt = vur.a(localStFeed);
    a(localStFeed.poster.id.get(), arrayOfInt[0], arrayOfInt[1], paramInt1, paramInt2, localStFeed.id.get(), localStFeed.poster.id.get(), ((ReportExtraTypeInfo)paramExtraTypeInfo).mPlayScene, paramExtraTypeInfo.mDataPosition, vur.a(localStFeed), localStFeed.video.playUrl.get(), localStFeed.cover.picUrl.get(), localStFeed.title.get() + "|" + localStFeed.content.get(), localStFeed, "", paramList, paramInt3, -1);
  }
  
  public static void a(int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramStFeed == null) {
      return;
    }
    int[] arrayOfInt = vur.a(paramStFeed);
    a(paramInt1, paramInt2, arrayOfInt[0], arrayOfInt[1], paramStFeed, paramInt3, paramInt4, "", null, paramInt5);
  }
  
  public static void a(int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, int paramInt3, int paramInt4, List<FeedCloudCommon.Entry> paramList, int paramInt5)
  {
    if (paramStFeed == null) {
      return;
    }
    int[] arrayOfInt = vur.a(paramStFeed);
    a(paramInt1, paramInt2, arrayOfInt[0], arrayOfInt[1], paramStFeed, paramInt3, paramInt4, "", paramList, paramInt5);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, int paramInt5, int paramInt6, String paramString4, String paramString5, String paramString6, String paramString7, FeedCloudMeta.StFeed paramStFeed, int paramInt7, int paramInt8)
  {
    a(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2, paramString3, paramInt5, paramInt6, paramString4, paramString5, paramString6, paramString7, paramStFeed, "", null, paramInt7, paramInt8);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, int paramInt5, int paramInt6, String paramString4, String paramString5, String paramString6, String paramString7, FeedCloudMeta.StFeed paramStFeed, String paramString8, List<FeedCloudCommon.Entry> paramList, int paramInt7, int paramInt8)
  {
    if (paramInt7 <= 0)
    {
      QLog.e("QCircleReportBean_QCircleLpReportDc05507", 1, "report invalid pageId," + paramInt7 + ",actionType:" + paramInt3 + ",subActionType:" + paramInt4);
      a(paramInt3, paramInt4);
    }
    vtw.a().a().post(new QCircleLpReportDc05507.2(paramString1, paramInt3, paramInt4, paramString2, paramString3, paramInt5, paramInt6, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt7, paramInt8, paramList, paramStFeed, paramInt1, paramInt2));
  }
  
  private static int b()
  {
    return 5507;
  }
  
  private static boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 1) || (paramInt1 == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtr
 * JD-Core Version:    0.7.0.1
 */