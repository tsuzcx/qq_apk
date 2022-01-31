import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import feedcloud.FeedCloudWrite.StDelFeedRsp;

class ttq
  implements zac<FeedCloudWrite.StDelFeedRsp>
{
  ttq(ttp paramttp, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L))
    {
      QLog.e("QCircleSharePart", 1, "deleteFeed  error");
      return;
    }
    QLog.d("QCircleSharePart", 1, "deleteFeed  success");
    yiw.a().a(new QCircleFeedEvent(this.jdField_a_of_type_JavaLangString, 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ttq
 * JD-Core Version:    0.7.0.1
 */