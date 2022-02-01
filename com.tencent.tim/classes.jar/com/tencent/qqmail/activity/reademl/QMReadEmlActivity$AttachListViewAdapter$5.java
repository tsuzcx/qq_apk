package com.tencent.qqmail.activity.reademl;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import java.util.ArrayList;
import moai.oss.KvHelper;

class QMReadEmlActivity$AttachListViewAdapter$5
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  QMReadEmlActivity$AttachListViewAdapter$5(QMReadEmlActivity.AttachListViewAdapter paramAttachListViewAdapter, Attach paramAttach, int paramInt1, int paramInt2) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    QMLog.log(4, "QMReadEmlActivity", "click attach more action:" + paramString);
    if (paramString.equals(this.this$1.this$0.getString(2131690550)))
    {
      KvHelper.eventEmlClickAttachSendTo(new double[0]);
      QMReadEmlActivity.access$4500(this.this$1.this$0, this.val$selectAttach);
      paramQMBottomDialog.dismiss();
    }
    do
    {
      return;
      if (paramString.equals(this.this$1.this$0.getString(2131690582)))
      {
        KvHelper.eventEmlClickAttachSaveAs(new double[0]);
        QMReadEmlActivity.access$5100(this.this$1.this$0, this.val$attachIndex);
        paramQMBottomDialog.dismiss();
        return;
      }
      if (paramString.equals(this.this$1.this$0.getString(2131690583)))
      {
        KvHelper.eventEmlClickAttachSaveAs(new double[0]);
        QMReadEmlActivity.access$5202(this.this$1.this$0, true);
        paramView = new Intent(QMApplicationContext.sharedInstance(), SdcardFileExplorer.class);
        paramView.putExtra("type", 1);
        paramView.putExtra("getSavePath", true);
        paramView.putExtra("savelastDownLoadPath", true);
        paramView.putExtra("position", this.val$attachIndex);
        this.this$1.this$0.startActivityForResult(paramView, 102);
        paramQMBottomDialog.dismiss();
        return;
      }
      if (paramString.equals(this.this$1.this$0.getString(2131690584)))
      {
        KvHelper.eventEmlClickAttachAllSaveAs(new double[0]);
        QMReadEmlActivity.access$5202(this.this$1.this$0, false);
        paramView = new Intent(this.this$1.this$0.getActivity(), SdcardFileExplorer.class);
        paramView.putExtra("type", 1);
        paramView.putExtra("getSavePath", true);
        paramView.putExtra("savelastDownLoadPath", true);
        paramView.putExtra("position", this.val$attachIndex);
        this.this$1.this$0.startActivityForResult(paramView, 103);
        paramQMBottomDialog.dismiss();
        return;
      }
      if (paramString.equals(this.this$1.this$0.getString(2131690570)))
      {
        KvHelper.eventEmlClickAttachSaveToFtn(new double[0]);
        paramView = (MailBigAttach)QMReadEmlActivity.AttachListViewAdapter.access$5300(this.this$1).get(this.val$attachIndex - this.val$attachCount);
        QMReadEmlActivity.access$4400(this.this$1.this$0, paramView, false);
        paramQMBottomDialog.dismiss();
        return;
      }
      if (paramString.equals(this.this$1.this$0.getString(2131690566)))
      {
        KvHelper.eventEmlClickAttachSaveToFtn(new double[0]);
        paramView = (MailBigAttach)QMReadEmlActivity.AttachListViewAdapter.access$5300(this.this$1).get(this.val$attachIndex - this.val$attachCount);
        QMReadEmlActivity.access$4400(this.this$1.this$0, paramView, true);
        paramQMBottomDialog.dismiss();
        return;
      }
      if (paramString.equals(this.this$1.this$0.getString(2131690586)))
      {
        KvHelper.eventEmlClickAttachShare(new double[0]);
        QMReadEmlActivity.access$1800(this.this$1.this$0, this.val$attachIndex);
        paramQMBottomDialog.dismiss();
        return;
      }
      if (paramString.equals(this.this$1.this$0.getString(2131690572)))
      {
        paramQMBottomDialog.dismiss();
        if (StringExtention.sizeStrToLong(this.val$selectAttach.getSize()) >= 1073741824L)
        {
          ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$1.this$0.getActivity()).setTitle(2131690553)).setMessage(2131690575).addAction(2131696547, new QMReadEmlActivity.AttachListViewAdapter.5.1(this))).create().show();
          return;
        }
        paramQMBottomDialog = AttachSaveToWeiYunActivity.createIntent(this.val$selectAttach, QMReadEmlActivity.access$3000(this.this$1.this$0).getStatus().isGroupMail(), QMReadEmlActivity.access$3200(this.this$1.this$0), false, false, true);
        this.this$1.this$0.startActivity(paramQMBottomDialog);
        this.this$1.this$0.getActivity().overridePendingTransition(2130772401, 2130772430);
        return;
      }
    } while (!paramString.startsWith("qrcode_recognize"));
    QMReadEmlActivity.access$5400(this.this$1.this$0, this.val$selectAttach);
    paramQMBottomDialog.dismiss();
    DataCollector.logEvent("Event_Attach_IButton_Bar_Recognize_Trigger");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.AttachListViewAdapter.5
 * JD-Core Version:    0.7.0.1
 */