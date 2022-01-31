import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

class xuh
  implements Runnable
{
  xuh(xug paramxug, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 0) && (EditLocalVideoActivity.a(this.jdField_a_of_type_Xug.a) != null))
    {
      QLog.d("EditLocalVideoActivity", 2, "ret = " + this.jdField_a_of_type_Int);
      EditLocalVideoActivity.a(this.jdField_a_of_type_Xug.a).setVideoPath(this.jdField_a_of_type_JavaLangString);
      EditLocalVideoActivity.a(this.jdField_a_of_type_Xug.a).seekTo(EditLocalVideoActivity.a(this.jdField_a_of_type_Xug.a));
      EditLocalVideoActivity.a(this.jdField_a_of_type_Xug.a).start();
      if ((!TextUtils.equals(EditLocalVideoActivity.f(this.jdField_a_of_type_Xug.a), EditLocalVideoActivity.h())) && (!TextUtils.equals(EditLocalVideoActivity.f(this.jdField_a_of_type_Xug.a), EditLocalVideoActivity.a(this.jdField_a_of_type_Xug.a)))) {
        QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new xui(this));
      }
      for (;;)
      {
        EditLocalVideoActivity.d(this.jdField_a_of_type_Xug.a, true);
        return;
        EditLocalVideoActivity.f(this.jdField_a_of_type_Xug.a, this.jdField_a_of_type_JavaLangString);
      }
    }
    QQToast.a(this.jdField_a_of_type_Xug.a, "音乐合成失败，请稍后重试", 1).a();
    QLog.d("EditLocalVideoActivity", 2, "mixMusicToLocalVideo error ret = " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xuh
 * JD-Core Version:    0.7.0.1
 */