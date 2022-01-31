import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView.TitilebarEventInterface;

public class dhu
  implements FileWebView.TitilebarEventInterface
{
  public dhu(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    if ((this.a.jdField_a_of_type_Boolean) || (this.a.e)) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.l = "3";
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFilePreviewDataReporter.e = System.currentTimeMillis();
    }
    this.a.runOnUiThread(new dhv(this));
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dhu
 * JD-Core Version:    0.7.0.1
 */