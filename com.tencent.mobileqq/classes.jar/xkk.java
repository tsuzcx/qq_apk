import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.qphone.base.util.QLog;

public class xkk
  implements Runnable
{
  public xkk(EditLocalVideoActivity paramEditLocalVideoActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      if ((EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).isPlaying()) && (EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity))) {
        EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).pause();
      }
      if (EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity) == 0) {
        EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).setPlayDuration(this.jdField_a_of_type_Int, this.b - this.jdField_a_of_type_Int);
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.w("EditLocalVideoActivity", 2, "Illegal state: onFramesClipChanged");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xkk
 * JD-Core Version:    0.7.0.1
 */