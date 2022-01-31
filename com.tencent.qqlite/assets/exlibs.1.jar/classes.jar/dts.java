import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase.IControllProxyInterface;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;

public class dts
  implements PreviewingOfflineFileViewBase.IControllProxyInterface
{
  private int jdField_a_of_type_Int;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public dts(PreviewingOfflineFileView paramPreviewingOfflineFileView, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((paramString1 != null) && (paramString1.length() > 0)) {}
    for (this.jdField_a_of_type_JavaLangString = paramString1;; this.jdField_a_of_type_JavaLangString = paramString2)
    {
      this.b = paramString3;
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
  }
  
  public int a()
  {
    if (3000 == PreviewingOfflineFileView.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).b()) {
      return 2;
    }
    return 1;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.c = FMConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, PreviewingOfflineFileView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).a(), "FileType");
    if (3000 == PreviewingOfflineFileView.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).b())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(PreviewingOfflineFileView.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).g(), PreviewingOfflineFileView.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).d());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(PreviewingOfflineFileView.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).d());
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
    }
  }
  
  public String c()
  {
    String str = FMConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, PreviewingOfflineFileView.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewPreviewingOfflineFileView).a(), "InterfacePage");
    return "http://" + this.jdField_a_of_type_JavaLangString + ":" + this.jdField_a_of_type_Int + "/ftn_doc_previewer/" + str;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new dtt(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public String d()
  {
    return "javascript:init('" + this.jdField_a_of_type_JavaLangString + "','" + this.jdField_a_of_type_Int + "','" + this.b + "','" + this.c + "')";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dts
 * JD-Core Version:    0.7.0.1
 */