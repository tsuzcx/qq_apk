package com.tencent.qqmail.movemail;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.folderlist.QMFolderManager.FolderNameValidationErrorCode;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;
import org.apache.commons.lang3.StringUtils;

class ManageFolderActivity$3
  implements View.OnClickListener
{
  ManageFolderActivity$3(ManageFolderActivity paramManageFolderActivity) {}
  
  public void onClick(View paramView)
  {
    if (!ManageFolderActivity.access$200(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = StringUtils.trim(ManageFolderActivity.access$300(this.this$0).getText().toString());
      if ((str != null) && (str.length() != 0)) {
        if (str.equals(ManageFolderActivity.access$400(this.this$0)))
        {
          this.this$0.finishWithNoCheck();
          this.this$0.overridePendingTransition(0, 2130772402);
        }
        else
        {
          QMFolderManager.FolderNameValidationErrorCode localFolderNameValidationErrorCode = QMFolderManager.sharedInstance().validateFolderName(ManageFolderActivity.access$500(this.this$0), str, ManageFolderActivity.access$600(this.this$0));
          if (localFolderNameValidationErrorCode == QMFolderManager.FolderNameValidationErrorCode.VALID)
          {
            QMLog.log(4, "ManageFolderActivity", "foldername is valid: " + str);
            if (ManageFolderActivity.access$700(this.this$0)) {
              if ((ManageFolderActivity.access$800(this.this$0) != null) && (ManageFolderActivity.access$800(this.this$0).length > 0) && (ManageFolderActivity.access$900(this.this$0))) {
                ManageFolderActivity.access$1100(this.this$0, new ManageFolderActivity.3.1(this, str), new ManageFolderActivity.3.2(this, str));
              }
            }
            for (;;)
            {
              if ((ManageFolderActivity.access$700(this.this$0)) && (ManageFolderActivity.access$800(this.this$0) != null)) {
                break label274;
              }
              ManageFolderActivity.access$000(this.this$0).setCallback(new ManageFolderActivity.3.3(this));
              ManageFolderActivity.access$000(this.this$0).showLoading("");
              break;
              ManageFolderActivity.access$1000(this.this$0, str, false);
              continue;
              ManageFolderActivity.access$1200(this.this$0, str);
            }
          }
          else
          {
            label274:
            QMLog.log(4, "ManageFolderActivity", "foldername is invalid: " + str + ", because: " + localFolderNameValidationErrorCode.getReason());
            ManageFolderActivity.access$1300(this.this$0, localFolderNameValidationErrorCode.getReason(), localFolderNameValidationErrorCode.getMessage(), new ManageFolderActivity.3.4(this));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.3
 * JD-Core Version:    0.7.0.1
 */