import com.tencent.mobileqq.activity.photo.SendWebPicActivity;
import com.tencent.util.MqqWeakReferenceHandler;

public class wvt
  implements Runnable
{
  public wvt(SendWebPicActivity paramSendWebPicActivity, String paramString) {}
  
  public void run()
  {
    SendWebPicActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendWebPicActivity).sendEmptyMessage(1002);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendWebPicActivity.c(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvt
 * JD-Core Version:    0.7.0.1
 */