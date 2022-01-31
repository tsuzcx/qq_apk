import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

public class tol
  extends tnm
{
  public tol(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void d()
  {
    boolean bool = false;
    super.d();
    String str1 = this.a.jdField_a_of_type_JavaLangString;
    String str2 = VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[VideoViewVideoHolder.f(this.a)];
    if (this.a.a().getVisibility() == 0) {
      bool = true;
    }
    urk.d(str1, "onResume, current state = %s, startBtn show = %s", new Object[] { str2, Boolean.valueOf(bool) });
    if (this.a.c()) {
      this.a.a(10, "onResume");
    }
  }
  
  public void e()
  {
    super.e();
    VideoViewVideoHolder.a(this.a, false);
    urk.d(this.a.jdField_a_of_type_JavaLangString, "onPause, current state = %s", new Object[] { VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[VideoViewVideoHolder.f(this.a)] });
    this.a.a(0, true, "onPause");
  }
  
  public void g()
  {
    super.g();
    VideoViewVideoHolder.a(this.a).removeCallbacksAndMessages(null);
    this.a.jdField_a_of_type_Tpc.a();
    this.a.a(0, true, "onDestroy");
    this.a.jdField_a_of_type_Tqg.a();
    this.a.jdField_a_of_type_Tqg.e();
    tfp localtfp = VideoViewVideoHolder.a(this.a);
    VideoViewVideoHolder.a(this.a, null);
    if (localtfp != null) {
      localtfp.a();
    }
    if (VideoViewVideoHolder.a(this.a) != null)
    {
      VideoViewVideoHolder.a(this.a).recycle();
      VideoViewVideoHolder.a(this.a, null);
    }
    if ((this.a.jdField_a_of_type_Vpd != null) && (this.a.jdField_a_of_type_Vpd.isShowing())) {
      this.a.jdField_a_of_type_Vpd.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tol
 * JD-Core Version:    0.7.0.1
 */