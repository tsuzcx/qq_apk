import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import feedcloud.FeedCloudWrite.StDelFeedRsp;

class oxn
  implements rxc.a<FeedCloudWrite.StDelFeedRsp>
{
  oxn(oxm paramoxm, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L))
    {
      QLog.e("QCircleSharePart", 1, "deleteFeed  error");
      return;
    }
    QLog.d("QCircleSharePart", 1, "deleteFeed  success");
    rwv.a().a(new QCircleFeedEvent(this.dL, 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxn
 * JD-Core Version:    0.7.0.1
 */