import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;

public class vua
  implements Runnable
{
  public vua(PhotoListPanel paramPhotoListPanel, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a.edit().putBoolean(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vua
 * JD-Core Version:    0.7.0.1
 */