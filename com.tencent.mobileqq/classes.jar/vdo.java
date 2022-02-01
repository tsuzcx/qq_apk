import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import feedcloud.FeedCloudWrite.StDelFeedRsp;

class vdo
  implements zxa<FeedCloudWrite.StDelFeedRsp>
{
  vdo(vdn paramvdn, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L))
    {
      QLog.e("QCircleSharePart", 1, "deleteFeed  error");
      return;
    }
    QLog.d("QCircleSharePart", 1, "deleteFeed  success");
    zwp.a().a(new QCircleFeedEvent(this.jdField_a_of_type_JavaLangString, 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdo
 * JD-Core Version:    0.7.0.1
 */