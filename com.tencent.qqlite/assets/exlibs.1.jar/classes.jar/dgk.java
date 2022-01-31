import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;

class dgk
  implements Runnable
{
  dgk(dgh paramdgh) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    String str = (String)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.getText();
    if ((str == null) || (str.length() == 0)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.clearAnimation();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dgk
 * JD-Core Version:    0.7.0.1
 */