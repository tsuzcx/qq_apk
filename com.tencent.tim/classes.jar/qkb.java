import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.e;

public class qkb
  extends qjh
{
  public qkb(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void onDestroy()
  {
    super.onDestroy();
    VideoViewVideoHolder.a(this.this$0).removeCallbacksAndMessages(null);
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$e.destroy();
    this.this$0.c(0, true, "onDestroy");
    this.this$0.jdField_a_of_type_Qlb.stopPlayback();
    this.this$0.jdField_a_of_type_Qlb.destroy();
    qef localqef = VideoViewVideoHolder.a(this.this$0);
    VideoViewVideoHolder.a(this.this$0, null);
    if (localqef != null) {
      localqef.destroy();
    }
    if (VideoViewVideoHolder.a(this.this$0) != null)
    {
      VideoViewVideoHolder.a(this.this$0).recycle();
      VideoViewVideoHolder.a(this.this$0, null);
    }
    if ((this.this$0.jdField_a_of_type_Rrq != null) && (this.this$0.jdField_a_of_type_Rrq.isShowing())) {
      this.this$0.jdField_a_of_type_Rrq.dismiss();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    VideoViewVideoHolder.a(this.this$0, false);
    ram.w(this.this$0.TAG, "onPause, current state = %s", new Object[] { VideoViewVideoHolder.bU[VideoViewVideoHolder.f(this.this$0)] });
    this.this$0.c(0, true, "onPause");
  }
  
  public void onResume()
  {
    boolean bool = false;
    super.onResume();
    String str1 = this.this$0.TAG;
    String str2 = VideoViewVideoHolder.bU[VideoViewVideoHolder.f(this.this$0)];
    if (this.this$0.au().getVisibility() == 0) {
      bool = true;
    }
    ram.w(str1, "onResume, current state = %s, startBtn show = %s", new Object[] { str2, Boolean.valueOf(bool) });
    if (this.this$0.isSelected()) {
      this.this$0.aK(10, "onResume");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qkb
 * JD-Core Version:    0.7.0.1
 */