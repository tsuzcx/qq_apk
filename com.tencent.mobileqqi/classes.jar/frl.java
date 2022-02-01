import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMRecentFileActivity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter.ItemHolder;

class frl
  implements DialogInterface.OnClickListener
{
  frl(frk paramfrk, RecentFileAdapter.ItemHolder paramItemHolder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Frk.a.b.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter$ItemHolder.a.nSessionId);
    FMRecentFileActivity.a(this.jdField_a_of_type_Frk.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     frl
 * JD-Core Version:    0.7.0.1
 */