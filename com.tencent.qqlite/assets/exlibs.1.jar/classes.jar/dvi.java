import android.app.Activity;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.mobileqq.filemanager.widget.FileWebView.TitilebarEventInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class dvi
  implements FileWebView.TitilebarEventInterface
{
  long jdField_a_of_type_Long = 0L;
  
  public dvi(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void a()
  {
    PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, true);
    if (PreviewingOfflineFileViewBase.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) != null) {
      PreviewingOfflineFileViewBase.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).c(PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase));
    }
    PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, 20);
  }
  
  public void a(boolean paramBoolean)
  {
    PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, false);
    if (PreviewingOfflineFileViewBase.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) != null) {
      PreviewingOfflineFileViewBase.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).c(PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase));
    }
    PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, 140);
  }
  
  public void b()
  {
    if ((PreviewingOfflineFileViewBase.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase)) || (PreviewingOfflineFileViewBase.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase))) {}
    do
    {
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Long < 1000L);
      this.jdField_a_of_type_Long = l;
      if (PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) != null)
      {
        PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).l = "3";
        PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).e = System.currentTimeMillis();
      }
      if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
      {
        PreviewingOfflineFileViewBase.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase);
        PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, false, 2L, "no network");
        PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, 5000);
        return;
      }
      PreviewingOfflineFileViewBase.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase);
    } while (PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) == null);
    try
    {
      PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).loadUrl("javascript:add_more_page()");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PreviewingOfflineFileViewBase<FileAssistant>", 1, localException.toString());
    }
  }
  
  public void c()
  {
    PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, 200);
  }
  
  public void d()
  {
    PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).postDelayed(new dvj(this), 3000L);
  }
  
  public void e()
  {
    PreviewingOfflineFileViewBase.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).runOnUiThread(new dvk(this));
  }
  
  public void f()
  {
    PreviewingOfflineFileViewBase localPreviewingOfflineFileViewBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase;
    boolean bool;
    if (!PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase))
    {
      bool = true;
      PreviewingOfflineFileViewBase.b(localPreviewingOfflineFileViewBase, bool);
      if (!PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase)) {
        break label77;
      }
      PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, 20);
    }
    for (;;)
    {
      if (PreviewingOfflineFileViewBase.h(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase) != null) {
        PreviewingOfflineFileViewBase.i(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase).c(PreviewingOfflineFileViewBase.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase));
      }
      return;
      bool = false;
      break;
      label77:
      PreviewingOfflineFileViewBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileViewBase, 140);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dvi
 * JD-Core Version:    0.7.0.1
 */