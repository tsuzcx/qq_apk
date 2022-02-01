package com.tencent.qqmail.activity.sdcardfileexplorer;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMUIHelper;

class SdcardFileExplorer$9
  implements View.OnClickListener
{
  SdcardFileExplorer$9(SdcardFileExplorer paramSdcardFileExplorer) {}
  
  public void onClick(View paramView)
  {
    String str = SdcardFileExplorer.access$100(this.this$0).saveDirectory();
    QMLog.log(4, "SdcardFileExplorer", "save as path:" + str);
    if (!FileUtil.canPathWritable(str)) {
      QMUIHelper.showToast(QMApplicationContext.sharedInstance(), 2131719251, "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.this$0.getIntent().getBooleanExtra("savelastDownLoadPath", false)) && (SdcardFileExplorer.access$100(this.this$0) != null) && (str != null)) {
        QMSettingManager.sharedInstance().setLastDownloadDirPath(str);
      }
      Object localObject;
      if ((this.this$0.getIntent().getIntExtra("ispreview", 0) == 1) || (this.this$0.getIntent().getIntExtra("iscomplete", 0) == 1))
      {
        localObject = (Attach)this.this$0.getIntent().getSerializableExtra("attachfile");
        if (localObject != null)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("filePath", str + ((Attach)localObject).getName());
          localIntent.putExtra("sourcePath", this.this$0.getIntent().getStringExtra("url"));
          this.this$0.setResult(0, localIntent);
          this.this$0.finish();
        }
        else
        {
          QMUIHelper.showToast(QMApplicationContext.sharedInstance(), 2131693700, "");
        }
      }
      else if (this.this$0.getIntent().getBooleanExtra("getSavePath", false))
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
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer.9
 * JD-Core Version:    0.7.0.1
 */