import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

public class xrl
  extends xqm
{
  public xrl(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void d()
  {
    boolean bool = false;
    super.d();
    String str1 = this.a.jdField_a_of_type_JavaLangString;
    String str2 = VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[VideoViewVideoHolder.f(this.a)];
    if (this.a.a().getVisibility() == 0) {
      bool = true;
    }
    yuk.d(str1, "onResume, current state = %s, startBtn show = %s", new Object[] { str2, Boolean.valueOf(bool) });
    if (this.a.c()) {
      this.a.a(10, "onResume");
    }
  }
  
  public void e()
  {
    super.e();
    VideoViewVideoHolder.a(this.a, false);
    yuk.d(this.a.jdField_a_of_type_JavaLangString, "onPause, current state = %s", new Object[] { VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[VideoViewVideoHolder.f(this.a)] });
    this.a.a(0, true, "onPause");
  }
  
  public void g()
  {
    super.g();
    VideoViewVideoHolder.a(this.a).removeCallbacksAndMessages(null);
    this.a.jdField_a_of_type_Xsc.a();
    this.a.a(0, true, "onDestroy");
    this.a.jdField_a_of_type_Xtg.a();
    this.a.jdField_a_of_type_Xtg.e();
    xiq localxiq = VideoViewVideoHolder.a(this.a);
    VideoViewVideoHolder.a(this.a, null);
    if (localxiq != null) {
      localxiq.a();
    }
    if (VideoViewVideoHolder.a(this.a) != null)
    {
      VideoViewVideoHolder.a(this.a).recycle();
      VideoViewVideoHolder.a(this.a, null);
    }
    if ((this.a.jdField_a_of_type_Zsd != null) && (this.a.jdField_a_of_type_Zsd.isShowing())) {
      this.a.jdField_a_of_type_Zsd.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrl
 * JD-Core Version:    0.7.0.1
 */