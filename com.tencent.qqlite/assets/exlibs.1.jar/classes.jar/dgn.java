import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.widget.FileWebView.TitilebarEventInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class dgn
  implements FileWebView.TitilebarEventInterface
{
  long jdField_a_of_type_Long = 0L;
  
  public dgn(FilePreviewActivity paramFilePreviewActivity, Handler paramHandler) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.f();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.g();
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {}
    do
    {
      return;
      this.jdField_a_of_type_Long = l;
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.e)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.g();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.l = "3";
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long = System.currentTimeMillis();
    }
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.getActivity()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.c.setText(2131363570);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.c.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.c = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.f - this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_e_of_type_JavaLangString = "2";
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.d = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a(5000);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.h();
    new Handler().postDelayed(new dgo(this), 1500L);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a(1000);
  }
  
  public void d()
  {
    dgp localdgp = new dgp(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(localdgp, 3000L);
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "postDelayed(newRunnable, 3000)");
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.runOnUiThread(new dgq(this));
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.runOnUiThread(new dgr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dgn
 * JD-Core Version:    0.7.0.1
 */