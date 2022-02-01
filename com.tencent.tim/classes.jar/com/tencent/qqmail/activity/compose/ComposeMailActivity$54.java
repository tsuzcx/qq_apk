package com.tencent.qqmail.activity.compose;

import android.view.View;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.sendmail.SendMailTaskFtnInfo;
import com.tencent.qqmail.model.task.QMSendMailDownloadAttachTask;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.task.QMTaskSQLiteHelper;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import moai.oss.KvHelper;

class ComposeMailActivity$54
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ComposeMailActivity$54(ComposeMailActivity paramComposeMailActivity, QMComposeAttachItem paramQMComposeAttachItem, AttachInfo paramAttachInfo) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.getString(2131691538)))
    {
      paramQMBottomDialog.dismiss();
      this.this$0.removeAttach(this.val$item);
      paramView = (Attach)this.val$info.getAttach();
      if (paramView != null)
      {
        paramQMBottomDialog = Boolean.valueOf(paramView.isInline());
        if (paramView == null) {
          break label190;
        }
        paramView = paramView.getRemoteId();
        label64:
        paramQMBottomDialog = String.format("inline:%s;mailid:%s;attachname:%s", new Object[] { paramQMBottomDialog, paramView, this.val$info.getAttachName() });
        if (ComposeMailActivity.access$5900(this.this$0) != 0)
        {
          paramView = QMTaskManager.sharedInstance(1).getSQLite().getSendMailTaskFtnInfos(ComposeMailActivity.access$5900(this.this$0), this.val$info.getHashId());
          if (paramView != null)
          {
            paramString = FtnManager.sharedInstance();
            if (paramString != null)
            {
              paramString.abortAndRemoveRequest(paramView.getFid());
              paramString.removeUploadData(paramView.getFid());
              paramString.deleteUploadInfo(paramView.getRid());
            }
          }
        }
        DataCollector.logDetailEvent("DetailEvent_Compose_Delete_Attach", ComposeMailActivity.access$6000(this.this$0), 0L, paramQMBottomDialog);
      }
    }
    label190:
    do
    {
      return;
      paramQMBottomDialog = "";
      break;
      paramView = "";
      break label64;
      if (paramString.equals(this.this$0.getString(2131691540)))
      {
        paramQMBottomDialog.dismiss();
        this.val$info.setProcessed(false);
        paramQMBottomDialog = new QMSendMailDownloadAttachTask(this.val$info.getHashId() + "", SendMailHelper.generateOriginMail(this.this$0.composeMail), (Attach)this.val$info.getAttach());
        paramQMBottomDialog.bindDownloadAttachListener(ComposeMailActivity.access$6100(this.this$0), true);
        Threads.runInBackground(new ComposeMailActivity.54.1(this, paramQMBottomDialog));
        ComposeMailActivity.access$6200(this.this$0, new ComposeMailActivity.54.2(this));
        return;
      }
      if (paramString.equals(this.this$0.getString(2131691537)))
      {
        paramQMBottomDialog.dismiss();
        if (!VersionUtils.hasKitKat()) {
          KvHelper.eventAddImageToContentBelowKitkat(new double[0]);
        }
        KvHelper.eventAddImageToContent(new double[0]);
        ComposeMailActivity.access$6300(this.this$0, this.val$info);
        return;
      }
      if (paramString.equals(this.this$0.getString(2131691539)))
      {
        Threads.runOnMainThread(new ComposeMailActivity.54.3(this), 180L);
        paramQMBottomDialog.dismiss();
        return;
      }
    } while (!paramString.equals(this.this$0.getString(2131691541)));
    paramQMBottomDialog.dismiss();
    this.this$0.renameLocalAttach(this.val$item);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.54
 * JD-Core Version:    0.7.0.1
 */