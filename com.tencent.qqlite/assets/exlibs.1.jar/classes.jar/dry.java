import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.widget.ActionSheet;

public final class dry
  implements View.OnClickListener
{
  public dry(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, int paramInt, Activity paramActivity, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = new FileManagerReporter.fileAssistantReportData();
    ((FileManagerReporter.fileAssistantReportData)localObject1).b = "file_forward";
    ((FileManagerReporter.fileAssistantReportData)localObject1).jdField_a_of_type_Int = 71;
    ((FileManagerReporter.fileAssistantReportData)localObject1).jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    ((FileManagerReporter.fileAssistantReportData)localObject1).c = FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    ((FileManagerReporter.fileAssistantReportData)localObject1).d = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject1);
    Object localObject2 = new ForwardFileInfo();
    ((ForwardFileInfo)localObject2).a(this.jdField_a_of_type_Int);
    ((ForwardFileInfo)localObject2).c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType);
    ((ForwardFileInfo)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    ((ForwardFileInfo)localObject2).d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    ((ForwardFileInfo)localObject2).c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
    ((ForwardFileInfo)localObject2).c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId);
    ((ForwardFileInfo)localObject2).d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    ((ForwardFileInfo)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
    ((ForwardFileInfo)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin != 0L) {
      ((ForwardFileInfo)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin);
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("forward_type", 0);
    ((Bundle)localObject1).putParcelable("fileinfo", (Parcelable)localObject2);
    ((Bundle)localObject1).putBoolean("not_forward", true);
    localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    ((Intent)localObject2).putExtra("destroy_last_activity", true);
    ((Intent)localObject2).putExtra("forward_type", 0);
    ((Intent)localObject2).putExtra("forward_filepath", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
    ((Intent)localObject2).putExtra("forward_text", "已选择" + FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) + "。");
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 6) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 7)) {
      ((Intent)localObject2).putExtra("isFromShare", true);
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject2, 103);
    if ((paramView.getTag() instanceof HorizontalListViewAdapter.HlistViewHolder))
    {
      paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView.getTag();
      if (paramView.a.isShowing()) {
        paramView.a.dismiss();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dry
 * JD-Core Version:    0.7.0.1
 */