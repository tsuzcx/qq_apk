import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.mobileqq.widget.QQToast;
import feedcloud.FeedCloudWrite.StDelFeedRsp;

class ttb
  implements yvn<FeedCloudWrite.StDelFeedRsp>
{
  ttb(tta paramtta, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L))
    {
      QQToast.a(this.jdField_a_of_type_Tta.a.a(), 1, alpo.a(2131715028), 0).a();
      return;
    }
    yej.a().a(new QCircleFeedEvent(this.jdField_a_of_type_JavaLangString, 3));
    QQToast.a(this.jdField_a_of_type_Tta.a.a(), alpo.a(2131715024), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ttb
 * JD-Core Version:    0.7.0.1
 */