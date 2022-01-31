import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class xui
  implements Runnable
{
  xui(xuh paramxuh) {}
  
  public void run()
  {
    if (!FileUtils.d(EditLocalVideoActivity.f(this.a.jdField_a_of_type_Xug.a))) {
      QLog.d("EditLocalVideoActivity", 2, "delete origin final mp4 failed!" + EditLocalVideoActivity.f(this.a.jdField_a_of_type_Xug.a));
    }
    for (;;)
    {
      EditLocalVideoActivity.f(this.a.jdField_a_of_type_Xug.a, this.a.jdField_a_of_type_JavaLangString);
      return;
      QLog.d("EditLocalVideoActivity", 2, "delete origin final mp4 success!" + EditLocalVideoActivity.f(this.a.jdField_a_of_type_Xug.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xui
 * JD-Core Version:    0.7.0.1
 */