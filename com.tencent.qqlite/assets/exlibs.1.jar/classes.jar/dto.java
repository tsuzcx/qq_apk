import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileViewBase.IControllProxyInterface;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;

public class dto
  implements PhotoFileViewBase.IControllProxyInterface
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  
  public dto(PhotoFileView paramPhotoFileView, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new dtp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public void a(IFileViewerAdapter paramIFileViewerAdapter)
  {
    if (1 == paramIFileViewerAdapter.c()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramIFileViewerAdapter.d(), 5, paramIFileViewerAdapter.c(), paramIFileViewerAdapter);
    }
    while (2 != paramIFileViewerAdapter.c()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramIFileViewerAdapter.e(), paramIFileViewerAdapter.a(), 5, paramIFileViewerAdapter);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dto
 * JD-Core Version:    0.7.0.1
 */