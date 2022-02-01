package com.tencent.qqmail.activity.sdcardfileexplorer;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMUIHelper;

class SdcardFileExplorer$11
  implements View.OnClickListener
{
  SdcardFileExplorer$11(SdcardFileExplorer paramSdcardFileExplorer) {}
  
  public void onClick(View paramView)
  {
    String str = SdcardFileExplorer.access$100(this.this$0).saveDirectory();
    Object localObject = FileUtil.getAttachDownloadDir();
    QMLog.log(4, "SdcardFileExplorer", "old path:" + (String)localObject + ", new path:" + str);
    if (!FileUtil.canPathWritable(str)) {
      QMUIHelper.showToast(QMApplicationContext.sharedInstance(), 2131719252, "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!str.equals(localObject))
      {
        ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0).setTitle(2131719844)).setMessage(2131719845).addAction(2131691246, new SdcardFileExplorer.11.2(this))).addAction(2131696547, new SdcardFileExplorer.11.1(this, str))).create().show();
      }
      else
      {
        localObject = this.this$0.getIntent();
        ((Intent)localObject).putExtra("savePath", str);
        this.this$0.setResult(0, (Intent)localObject);
        this.this$0.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer.11
 * JD-Core Version:    0.7.0.1
 */