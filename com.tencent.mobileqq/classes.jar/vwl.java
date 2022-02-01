import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StImageUrl;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Iterator;
import java.util.List;

public class vwl
{
  public static void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    if (paramStFeed == null) {
      QLog.d("QCircleProtoUtil", 1, "adjustFeedPicUrl stFeed is null");
    }
    for (;;)
    {
      return;
      if (paramStFeed.images.size() > 0)
      {
        paramStFeed = (FeedCloudMeta.StImage)paramStFeed.images.get(0);
        if ((paramStFeed == null) || (paramStFeed.vecImageUrl.size() <= 0)) {
          break;
        }
        Iterator localIterator = paramStFeed.vecImageUrl.get().iterator();
        while (localIterator.hasNext())
        {
          FeedCloudMeta.StImageUrl localStImageUrl = (FeedCloudMeta.StImageUrl)localIterator.next();
          if (localStImageUrl.levelType.get() == paramInt)
          {
            QLog.d("QCircleProtoUtil", 1, "setPic levelType:" + paramInt + "   url:" + localStImageUrl.url.get());
            paramStFeed.picUrl.set(localStImageUrl.url.get());
          }
        }
      }
    }
  }
  
  public static void a(FeedCloudMeta.StPushList paramStPushList, int paramInt)
  {
    int j = paramInt - paramStPushList.hasClickCount.get();
    Object localObject = paramStPushList.status;
    if (paramInt > 0) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      if (j >= 0) {
        break;
      }
      QLog.d("QCircleProtoUtil", 1, "updateTotalPushTimeAndStatus error State");
      return;
    }
    localObject = paramStPushList.vecUser.get();
    if ((paramInt > 0) && ((((List)localObject).size() <= 0) || (!((FeedCloudMeta.StUser)((List)localObject).get(0)).id.get().equals(uyn.a()))))
    {
      QLog.d("QCircleProtoUtil", 1, "is not in pushList add user");
      ((List)localObject).add(0, uyn.a());
      paramStPushList.count.set(paramStPushList.count.get() + 1);
    }
    paramStPushList.totalClickCount.set(paramStPushList.totalClickCount.get() + j);
    paramStPushList.hasClickCount.set(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwl
 * JD-Core Version:    0.7.0.1
 */