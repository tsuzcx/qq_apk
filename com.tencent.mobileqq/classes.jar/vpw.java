import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;

public class vpw
  extends vox
{
  public vpw(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void d()
  {
    boolean bool = false;
    super.d();
    String str1 = this.a.jdField_a_of_type_JavaLangString;
    String str2 = VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[VideoViewVideoHolder.f(this.a)];
    if (this.a.a().getVisibility() == 0) {
      bool = true;
    }
    wsv.d(str1, "onResume, current state = %s, startBtn show = %s", new Object[] { str2, Boolean.valueOf(bool) });
    if (this.a.c()) {
      this.a.a(10, "onResume");
    }
  }
  
  public void e()
  {
    super.e();
    VideoViewVideoHolder.a(this.a, false);
    wsv.d(this.a.jdField_a_of_type_JavaLangString, "onPause, current state = %s", new Object[] { VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[VideoViewVideoHolder.f(this.a)] });
    this.a.a(0, true, "onPause");
  }
  
  public void g()
  {
    super.g();
    VideoViewVideoHolder.a(this.a).removeCallbacksAndMessages(null);
    this.a.jdField_a_of_type_Vqn.a();
    this.a.a(0, true, "onDestroy");
    this.a.jdField_a_of_type_Vrr.a();
    this.a.jdField_a_of_type_Vrr.e();
    vha localvha = VideoViewVideoHolder.a(this.a);
    VideoViewVideoHolder.a(this.a, null);
    if (localvha != null) {
      localvha.a();
    }
    if (VideoViewVideoHolder.a(this.a) != null)
    {
      VideoViewVideoHolder.a(this.a).recycle();
      VideoViewVideoHolder.a(this.a, null);
    }
    if ((this.a.jdField_a_of_type_Xqo != null) && (this.a.jdField_a_of_type_Xqo.isShowing())) {
      this.a.jdField_a_of_type_Xqo.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpw
 * JD-Core Version:    0.7.0.1
 */