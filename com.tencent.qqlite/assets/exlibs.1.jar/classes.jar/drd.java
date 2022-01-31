import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;

class drd
  implements DialogInterface.OnClickListener
{
  drd(drc paramdrc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
    if (paramDialogInterface != null) {
      paramDialogInterface.setPaused(false);
    }
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
      BaseActionBarDataLineFile.a(this.a.a);
    }
    for (;;)
    {
      this.a.a.h();
      return;
      BaseActionBarDataLineFile.b(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     drd
 * JD-Core Version:    0.7.0.1
 */