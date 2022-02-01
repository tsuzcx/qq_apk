import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class xik
  extends JobSegment<String, String>
{
  private xik(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    this.a.jdField_a_of_type_Xjm.a(null);
    this.a.jdField_a_of_type_Xjm.a(null);
    this.a.jdField_a_of_type_Xjm.a(null);
    this.a.jdField_a_of_type_Xjm.a(null);
    this.a.jdField_a_of_type_Xjm.a(null);
    if (VideoViewVideoHolder.f(this.a) == 0)
    {
      ykq.d(this.a.jdField_a_of_type_JavaLangString, "VideoIdleSegment. already idle state");
      notifyResult(paramString);
      return;
    }
    if (VideoViewVideoHolder.f(this.a) < 7)
    {
      ykq.d(this.a.jdField_a_of_type_JavaLangString, "VideoIdleSegment. change to idle directly");
      VideoViewVideoHolder.a(this.a, 0);
      notifyResult(paramString);
      return;
    }
    ykq.b(this.a.jdField_a_of_type_JavaLangString, "VideoIdleSegment. stop video view");
    this.a.jdField_a_of_type_Xjm.a();
    VideoViewVideoHolder.a(this.a, 0);
    notifyResult(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xik
 * JD-Core Version:    0.7.0.1
 */