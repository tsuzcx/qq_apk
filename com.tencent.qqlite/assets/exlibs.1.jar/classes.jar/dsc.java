import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerFacade;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.widget.ActionSheet;
import java.io.FileNotFoundException;

public final class dsc
  implements View.OnClickListener
{
  public dsc(IFileBrowser paramIFileBrowser, QQAppInterface paramQQAppInterface, String paramString, Activity paramActivity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent) {}
  
  public void onClick(View paramView)
  {
    FileManagerEntity localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a();
    if (localFileManagerEntity2 == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString);
    }
    FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
    if (localFileManagerEntity2 == null) {}
    try
    {
      localFileManagerEntity1 = FileManagerUtil.a(new FileInfo(this.jdField_a_of_type_JavaLangString));
      FileViewerFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity1.nSessionId);
      if ((paramView.getTag() instanceof HorizontalListViewAdapter.HlistViewHolder))
      {
        paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView.getTag();
        if (paramView.a.isShowing()) {
          paramView.a.dismiss();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.h();
      }
      return;
    }
    catch (FileNotFoundException paramView)
    {
      paramView.printStackTrace();
      FMToastUtil.a(2131361995);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dsc
 * JD-Core Version:    0.7.0.1
 */