import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class vqp
  extends JobSegment<String, String>
{
  private vqp(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    this.a.jdField_a_of_type_Vrr.a(null);
    this.a.jdField_a_of_type_Vrr.a(null);
    this.a.jdField_a_of_type_Vrr.a(null);
    this.a.jdField_a_of_type_Vrr.a(null);
    this.a.jdField_a_of_type_Vrr.a(null);
    if (VideoViewVideoHolder.f(this.a) == 0)
    {
      wsv.d(this.a.jdField_a_of_type_JavaLangString, "VideoIdleSegment. already idle state");
      notifyResult(paramString);
      return;
    }
    if (VideoViewVideoHolder.f(this.a) < 7)
    {
      wsv.d(this.a.jdField_a_of_type_JavaLangString, "VideoIdleSegment. change to idle directly");
      VideoViewVideoHolder.a(this.a, 0);
      notifyResult(paramString);
      return;
    }
    wsv.b(this.a.jdField_a_of_type_JavaLangString, "VideoIdleSegment. stop video view");
    this.a.jdField_a_of_type_Vrr.a();
    VideoViewVideoHolder.a(this.a, 0);
    notifyResult(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqp
 * JD-Core Version:    0.7.0.1
 */