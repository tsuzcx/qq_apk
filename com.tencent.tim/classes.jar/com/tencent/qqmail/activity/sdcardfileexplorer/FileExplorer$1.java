package com.tencent.qqmail.activity.sdcardfileexplorer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMListItemView;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

class FileExplorer$1
  implements AdapterView.OnItemClickListener
{
  FileExplorer$1(FileExplorer paramFileExplorer, int paramInt, Activity paramActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((!FileExplorer.access$000(this.this$0)) && (paramInt == 0)) {
      FileExplorer.access$100(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      int i = paramInt;
      if (!FileExplorer.access$000(this.this$0))
      {
        i = paramInt;
        if (paramInt > 0) {
          i = paramInt - 1;
        }
      }
      if ((this.val$getFile == 0) && (FileExplorer.access$200(this.this$0)[i].isFile()))
      {
        Object localObject;
        Bundle localBundle;
        if (!FileExplorer.access$300(this.this$0))
        {
          localObject = new Intent();
          localBundle = new Bundle();
        }
        for (;;)
        {
          try
          {
            localBundle.putString("filePath", FileExplorer.access$200(this.this$0)[i].getCanonicalPath());
            ((Intent)localObject).putExtras(localBundle);
            this.val$context.setResult(-1, (Intent)localObject);
            this.val$context.finish();
            QMSettingManager.sharedInstance().setLastUploadDirPath(FileExplorer.access$600(this.this$0).getAbsolutePath() + "/", FileExplorer.access$700(this.this$0));
            paramInt = i;
          }
          catch (IOException localIOException3)
          {
            localIOException3.printStackTrace();
            continue;
          }
          try
          {
            localObject = FileExplorer.access$200(this.this$0)[i].getCanonicalPath();
            if (localObject != null) {
              ((QMListItemView)paramView).setChecked(FileExplorer.access$400(this.this$0, (String)localObject));
            }
            if (FileExplorer.access$500(this.this$0) != null) {
              FileExplorer.access$500(this.this$0).selectUpdate();
            }
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
          }
        }
      }
      if ((this.val$getFile != 0) && (FileExplorer.access$200(this.this$0)[i].isFile()))
      {
        if (!IntentUtil.openLocalFile(this.val$context, FileExplorer.access$200(this.this$0)[i].getAbsolutePath())) {
          Toast.makeText(QMApplicationContext.sharedInstance(), 2131693654, 0).show();
        }
        paramInt = i;
        continue;
      }
      try
      {
        FileExplorer.access$802(this.this$0, FileExplorer.access$200(this.this$0)[i].getCanonicalPath());
        File[] arrayOfFile = FileExplorer.access$900(this.this$0, FileExplorer.access$200(this.this$0)[i]);
        if (arrayOfFile == null) {
          paramInt = i;
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
          FileExplorer.access$802(this.this$0, FileUtil.getExternalQQMailDirPath() + "/attachment");
          continue;
          if (FileExplorer.access$600(this.this$0) == null)
          {
            QMLog.log(5, "FileExplorer", "currentParent is null");
            QMUIHelper.showToast(this.val$context, 2131693719, "");
            paramInt = i;
            break;
          }
          FileExplorer.access$1000(this.this$0).put(FileExplorer.access$600(this.this$0), new FileExplorer.ScrollPosition(this.this$0));
          FileExplorer.access$1100(this.this$0).push(FileExplorer.access$600(this.this$0).getAbsolutePath());
          FileExplorer.access$602(this.this$0, FileExplorer.access$200(this.this$0)[i]);
          FileExplorer.access$202(this.this$0, localIOException2);
          this.this$0.inflate();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.FileExplorer.1
 * JD-Core Version:    0.7.0.1
 */