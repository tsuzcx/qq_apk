import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

class dgg
  implements Runnable
{
  dgg(dgf paramdgf, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    QLog.e("<FileAssistant>FilePreviewActivity", 1, "load url[" + this.jdField_a_of_type_JavaLangString + "] error! errCode[" + String.valueOf(this.jdField_a_of_type_Int) + "],description[" + String.valueOf(this.b) + "]");
    FilePreviewActivity.d(this.jdField_a_of_type_Dgf.a);
    this.jdField_a_of_type_Dgf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.setVisibility(4);
    this.jdField_a_of_type_Dgf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetFileWebView.stopLoading();
    this.jdField_a_of_type_Dgf.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_Dgf.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_Dgf.a.jdField_b_of_type_AndroidWidgetTextView.setText(2131361982);
    FilePreviewActivity.a(this.jdField_a_of_type_Dgf.a);
    this.jdField_a_of_type_Dgf.a.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_Dgf.a.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_Dgf.a.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (this.jdField_a_of_type_Dgf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
    {
      this.jdField_a_of_type_Dgf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.e = String.valueOf(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Dgf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.i = this.b;
      this.jdField_a_of_type_Dgf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Dgf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.d = (System.currentTimeMillis() - this.jdField_a_of_type_Dgf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
      this.jdField_a_of_type_Dgf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dgg
 * JD-Core Version:    0.7.0.1
 */