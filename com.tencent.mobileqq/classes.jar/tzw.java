import android.os.Handler;
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

public class tzw
{
  public static ArrayList<FeedCloudCommon.Entry> a(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject2 = tzy.a("touin", paramStFeed.poster.id.get());
    FeedCloudCommon.Entry localEntry1 = tzy.a("feedid", paramStFeed.id.get());
    FeedCloudCommon.Entry localEntry2 = tzy.a("author_uin", paramStFeed.poster.id.get());
    FeedCloudCommon.Entry localEntry3 = tzy.a("video_total_time", String.valueOf(paramStFeed.video.duration.get()));
    Object localObject1;
    if (tra.c((FeedCloudMeta.StUser)paramStFeed.poster.get()))
    {
      localObject1 = "2";
      localObject1 = new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { localObject2, localEntry1, localEntry2, localEntry3, tzy.a("video_type", (String)localObject1), tzy.a("cubage", String.valueOf(paramStFeed.video.fileSize.get())), tzy.a("width", String.valueOf(paramStFeed.video.width.get())), tzy.a("height", String.valueOf(paramStFeed.video.height.get())), tzy.a("clear", String.valueOf(paramStFeed.video.videoRate.get())), tzy.a("play_id", paramStFeed.video.fileId.get()), tzy.a("vid", paramStFeed.video.fileId.get()), tzy.a("lloc", paramStFeed.cover.picId.get()), tzy.a("feed_tag", tzo.a(paramStFeed)), tzy.a("play_url", paramStFeed.video.playUrl.get()), tzy.a("video_tag", paramStFeed.video.playUrl.get()), tzy.a("pic_info", paramStFeed.cover.picUrl.get()), tzy.a("item_detail", paramStFeed.title.get() + "|" + paramStFeed.content.get()), tzy.a("acttime", String.valueOf(System.currentTimeMillis())) }));
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
        ((ArrayList)localObject1).addAll(Arrays.asList(new FeedCloudCommon.Entry[] { tzy.a("feedtype1", String.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject2).feedtype1.get())), tzy.a("feedtype2", String.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject2).feedtype2.get())), tzy.a("feedtype3", String.valueOf(((QQCircleFeedBase.StReportInfoForClient)localObject2).feedtype3.get())) }));
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException paramStFeed)
      {
        paramStFeed.printStackTrace();
        i = 0;
        continue;
      }
      if (i == 0) {
        ((ArrayList)localObject1).addAll(Arrays.asList(new FeedCloudCommon.Entry[] { tzy.a("feedtype1", "1"), tzy.a("feedtype2", "2") }));
      }
      return localObject1;
      localObject1 = "1";
      break;
      label558:
      int i = 0;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, boolean paramBoolean, String paramString, FeedCloudMeta.StFeed paramStFeed, List<FeedCloudCommon.Entry> paramList)
  {
    int i = tzy.a().a();
    int j = tzy.a().b();
    uab.a().a().post(new QCircleLpReportDc05507.1(paramList, paramInt1, paramInt2, paramInt3, i, j, paramInt4, paramLong1, paramLong2, paramBoolean, paramString, paramStFeed));
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FeedCloudMeta.StFeed paramStFeed, int paramInt5, int paramInt6, String paramString, List<FeedCloudCommon.Entry> paramList)
  {
    if (paramStFeed == null) {
      return;
    }
    a(paramStFeed.poster.id.get(), paramInt3, paramInt4, paramInt1, paramInt2, paramStFeed.id.get(), paramStFeed.poster.id.get(), paramInt5, paramInt6, tzo.a(paramStFeed), paramStFeed.video.playUrl.get(), paramStFeed.cover.picUrl.get(), paramStFeed.title.get() + "|" + paramStFeed.content.get(), paramStFeed, paramString, paramList);
  }
  
  public static void a(int paramInt1, int paramInt2, ExtraTypeInfo paramExtraTypeInfo)
  {
    if ((!(paramExtraTypeInfo instanceof ReportExtraTypeInfo)) || (((ReportExtraTypeInfo)paramExtraTypeInfo).mFeed == null))
    {
      QLog.e("QCircleReportHelper_QCircleLpReportDc05507", 1, "ExtraTypeInfo is not ReportExtraTypeInfo,actionType:" + paramInt1 + ",subActionType:" + paramInt2);
      return;
    }
    FeedCloudMeta.StFeed localStFeed = ((ReportExtraTypeInfo)paramExtraTypeInfo).mFeed;
    int[] arrayOfInt = tzo.a(localStFeed);
    a(localStFeed.poster.id.get(), arrayOfInt[0], arrayOfInt[1], paramInt1, paramInt2, localStFeed.id.get(), localStFeed.poster.id.get(), ((ReportExtraTypeInfo)paramExtraTypeInfo).mPlayScene, paramExtraTypeInfo.mDataPosition, tzo.a(localStFeed), localStFeed.video.playUrl.get(), localStFeed.cover.picUrl.get(), localStFeed.title.get() + "|" + localStFeed.content.get(), localStFeed);
  }
  
  public static void a(int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, int paramInt3, int paramInt4)
  {
    if (paramStFeed == null) {
      return;
    }
    int[] arrayOfInt = tzo.a(paramStFeed);
    a(paramInt1, paramInt2, arrayOfInt[0], arrayOfInt[1], paramStFeed, paramInt3, paramInt4, "", null);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, int paramInt5, int paramInt6, String paramString4, String paramString5, String paramString6, String paramString7, FeedCloudMeta.StFeed paramStFeed)
  {
    a(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2, paramString3, paramInt5, paramInt6, paramString4, paramString5, paramString6, paramString7, paramStFeed, "", null);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, int paramInt5, int paramInt6, String paramString4, String paramString5, String paramString6, String paramString7, FeedCloudMeta.StFeed paramStFeed, String paramString8, List<FeedCloudCommon.Entry> paramList)
  {
    int i = tzy.a().a();
    int j = tzy.a().b();
    uab.a().a().post(new QCircleLpReportDc05507.2(paramString1, paramInt3, paramInt4, paramString2, paramString3, paramInt5, i, j, paramInt6, paramString4, paramString5, paramString6, paramString7, paramString8, paramList, paramStFeed, paramInt1, paramInt2));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzw
 * JD-Core Version:    0.7.0.1
 */