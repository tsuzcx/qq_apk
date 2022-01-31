import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;

public class drn
  implements View.OnClickListener
{
  public drn(BaseActionBarDataLineFile paramBaseActionBarDataLineFile) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e((BaseActivity)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity()))
    {
      BaseActionBarDataLineFile.a(this.a, System.currentTimeMillis());
      FMToastUtil.a(2131363450);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize == 0L)
    {
      BaseActionBarDataLineFile.a(this.a, System.currentTimeMillis());
      FMToastUtil.a("'" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "'" + BaseApplication.getContext().getResources().getString(2131361872));
      return;
    }
    if (((RegisterProxySvcPackHandler)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(9)).a() == 0)
    {
      BaseActionBarDataLineFile.a(this.a, System.currentTimeMillis());
      FMToastUtil.a(2131361908);
      return;
    }
    BaseActionBarDataLineFile.a(this.a, true);
    BaseActionBarDataLineFile.e(this.a);
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    BaseActionBarDataLineFile.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     drn
 * JD-Core Version:    0.7.0.1
 */