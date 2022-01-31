import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

class xoa
  implements Runnable
{
  xoa(xnz paramxnz, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 0) && (EditLocalVideoActivity.a(this.jdField_a_of_type_Xnz.a) != null))
    {
      QLog.d("EditLocalVideoActivity", 2, "ret = " + this.jdField_a_of_type_Int);
      EditLocalVideoActivity.a(this.jdField_a_of_type_Xnz.a).setVideoPath(this.jdField_a_of_type_JavaLangString);
      EditLocalVideoActivity.a(this.jdField_a_of_type_Xnz.a).seekTo(EditLocalVideoActivity.a(this.jdField_a_of_type_Xnz.a));
      EditLocalVideoActivity.a(this.jdField_a_of_type_Xnz.a).start();
      if ((!TextUtils.equals(EditLocalVideoActivity.f(this.jdField_a_of_type_Xnz.a), EditLocalVideoActivity.h())) && (!TextUtils.equals(EditLocalVideoActivity.f(this.jdField_a_of_type_Xnz.a), EditLocalVideoActivity.a(this.jdField_a_of_type_Xnz.a)))) {
        QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new xob(this));
      }
      for (;;)
      {
        EditLocalVideoActivity.d(this.jdField_a_of_type_Xnz.a, true);
        return;
        EditLocalVideoActivity.f(this.jdField_a_of_type_Xnz.a, this.jdField_a_of_type_JavaLangString);
      }
    }
    QQToast.a(this.jdField_a_of_type_Xnz.a, "音乐合成失败，请稍后重试", 1).a();
    QLog.d("EditLocalVideoActivity", 2, "mixMusicToLocalVideo error ret = " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xoa
 * JD-Core Version:    0.7.0.1
 */