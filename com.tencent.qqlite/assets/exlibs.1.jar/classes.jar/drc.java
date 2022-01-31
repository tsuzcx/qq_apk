import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;

public class drc
  implements View.OnClickListener
{
  public drc(BaseActionBarDataLineFile paramBaseActionBarDataLineFile) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity()))
    {
      BaseActionBarDataLineFile.a(this.a, System.currentTimeMillis());
      FMToastUtil.a(2131363449);
      return;
    }
    dre localdre;
    int j;
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 6) {
      if ((FileManagerUtil.a()) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 5242880L))
      {
        paramView = new drd(this);
        localdre = new dre(this);
        if (!this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
          break label402;
        }
        j = 2131361828;
      }
    }
    for (int i = 2131362019;; i = 2131362020)
    {
      String str = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(i);
      DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 230, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(j), str, 2131362790, 2131361835, paramView, localdre).show();
      return;
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      if (paramView != null) {
        paramView.setPaused(false);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
        BaseActionBarDataLineFile.a(this.a);
      }
      for (;;)
      {
        this.a.h();
        return;
        BaseActionBarDataLineFile.b(this.a);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 7) {
        break;
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
        FMToastUtil.a(2131361909);
        return;
      }
      BaseActionBarDataLineFile.c(this.a);
      this.a.h();
      return;
      label402:
      j = 2131361831;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     drc
 * JD-Core Version:    0.7.0.1
 */