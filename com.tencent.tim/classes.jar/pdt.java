import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StImageUrl;
import java.util.Iterator;
import java.util.List;

public class pdt
{
  public static void b(FeedCloudMeta.StFeed paramStFeed, int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdt
 * JD-Core Version:    0.7.0.1
 */