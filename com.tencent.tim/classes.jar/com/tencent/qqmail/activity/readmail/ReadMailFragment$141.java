package com.tencent.qqmail.activity.readmail;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.mail.loader.MailContentLoader;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailEditAttach;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.paintpad.MailPaintPadActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.QMReadMailView;
import java.util.ArrayList;
import moai.fragment.app.FragmentActivity;
import moai.oss.KvHelper;

class ReadMailFragment$141
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadMailFragment$141(ReadMailFragment paramReadMailFragment, int paramInt1, int paramInt2, int paramInt3, Attach paramAttach) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    Object localObject = null;
    boolean bool = true;
    QMLog.log(4, "ReadMailFragment", "click attach more action:" + paramString);
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    ArrayList localArrayList4;
    if (paramString.equals(this.this$0.getString(2131690550)))
    {
      paramString = SendMailHelper.getComposeMail(ReadMailFragment.access$000(this.this$0).getInformation().getId(), ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_COMPOSE);
      paramView = paramString.getInformation();
      paramView.setToList(null);
      paramView.setCcList(null);
      paramView.setSendContact(null);
      paramString.setContent(new MailContent());
      ArrayList localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      localArrayList4 = ReadMailFragment.access$000(this.this$0).getInformation().getAttachListNoInlineImg();
      if (ReadMailFragment.access$22300(this.this$0))
      {
        paramView = localObject;
        if (localArrayList4 != null)
        {
          paramView = localObject;
          if (this.val$attachIndex >= 0)
          {
            paramView = localObject;
            if (this.val$attachIndex < localArrayList4.size())
            {
              paramView = (Attach)localArrayList4.get(this.val$attachIndex);
              localArrayList1.add(paramView);
              paramString.getInformation().setSubject(paramView.getName());
            }
          }
        }
        paramString.getInformation().setAttachList(localArrayList1);
        paramString.getInformation().setBigAttachList(localArrayList2);
        paramString.getInformation().setEditAttachList(localArrayList3);
        if (paramView == null) {
          break label495;
        }
        label254:
        ValidateHelper.assertInDebug("", bool);
        paramView = ComposeMailActivity.createIntentForFwdAttach(paramView.getHashId(), ReadMailFragment.access$000(this.this$0).getInformation().getId(), ReadMailFragment.access$200(this.this$0), getClass().getName());
        this.this$0.startActivity(paramView);
        paramQMBottomDialog.dismiss();
        DataCollector.logEvent("Event_Attach_Send_Email");
      }
    }
    label495:
    do
    {
      return;
      if (ReadMailFragment.access$22400(this.this$0))
      {
        localArrayList4 = ReadMailFragment.access$000(this.this$0).getInformation().getBigAttachList();
        paramView = localObject;
        if (localArrayList4 == null) {
          break;
        }
        paramView = localObject;
        if (this.val$attachIndex < 0) {
          break;
        }
        paramView = localObject;
        if (this.val$attachIndex - this.val$attachCount >= this.val$bigAttachCount) {
          break;
        }
        paramView = (MailBigAttach)localArrayList4.get(this.val$attachIndex - this.val$attachCount);
        localArrayList2.add(paramView);
        paramString.getInformation().setSubject(paramView.getName());
        break;
      }
      localArrayList4 = ReadMailFragment.access$000(this.this$0).getInformation().getEditAttachList();
      paramView = localObject;
      if (localArrayList4 == null) {
        break;
      }
      paramView = localObject;
      if (localArrayList4.size() <= 0) {
        break;
      }
      paramView = (MailEditAttach)localArrayList4.get(this.val$attachIndex - this.val$attachCount - this.val$bigAttachCount);
      localArrayList3.add(paramView);
      paramString.getInformation().setSubject(paramView.getName());
      break;
      bool = false;
      break label254;
      if (paramString.equals(this.this$0.getString(2131690532)))
      {
        QMAttachManager.sharedInstance().favoriteAttach(new long[] { this.val$selectAttach.getHashId() }, true);
        this.this$0.getTips().showSuccess(2131689776);
        paramQMBottomDialog.dismiss();
        DataCollector.logEvent("Event_Attach_Readmail_AddFavorite");
        DataCollector.logEvent("Event_Attach_AddFavorite");
        return;
      }
      if (paramString.equals(this.this$0.getString(2131690535)))
      {
        QMAttachManager.sharedInstance().favoriteAttach(new long[] { this.val$selectAttach.getHashId() }, false);
        this.this$0.getTips().showSuccess(2131691250);
        paramQMBottomDialog.dismiss();
        DataCollector.logEvent("Event_Attach_CancelFavorite");
        return;
      }
      if (paramString.equals(this.this$0.getString(2131690582)))
      {
        ReadMailFragment.access$21800(this.this$0, this.val$attachIndex);
        paramQMBottomDialog.dismiss();
        DataCollector.logEvent("Event_Click_SaveAs");
        return;
      }
      if (paramString.equals(this.this$0.getString(2131690583)))
      {
        ReadMailFragment.access$8602(this.this$0, true);
        paramView = new Intent(QMApplicationContext.sharedInstance(), SdcardFileExplorer.class);
        paramView.putExtra("type", 1);
        paramView.putExtra("getSavePath", true);
        paramView.putExtra("savelastDownLoadPath", true);
        paramView.putExtra("position", this.val$attachIndex);
        this.this$0.startActivityForResult(paramView, 102);
        paramQMBottomDialog.dismiss();
        DataCollector.logEvent("Event_Attach_Save_Photo");
        return;
      }
      if (paramString.equals(this.this$0.getString(2131690584)))
      {
        ReadMailFragment.access$8602(this.this$0, false);
        paramView = new Intent(this.this$0.getActivity(), SdcardFileExplorer.class);
        paramView.putExtra("type", 1);
        paramView.putExtra("getSavePath", true);
        paramView.putExtra("savelastDownLoadPath", true);
        paramView.putExtra("position", this.val$attachIndex);
        this.this$0.startActivityForResult(paramView, 103);
        paramQMBottomDialog.dismiss();
        DataCollector.logEvent("Event_Attach_Save_All_Photo");
        return;
      }
      if (paramString.equals(this.this$0.getString(2131690570)))
      {
        ReadMailFragment.access$22500(this.this$0, this.val$attachIndex - this.val$attachCount, false);
        paramQMBottomDialog.dismiss();
        DataCollector.logEvent("Event_Attach_Save_To_Ftn");
        return;
      }
      if (paramString.equals(this.this$0.getString(2131690566)))
      {
        ReadMailFragment.access$22500(this.this$0, this.val$attachIndex - this.val$attachCount, true);
        paramQMBottomDialog.dismiss();
        DataCollector.logEvent("Event_Attach_Save_All_To_Ftn");
        return;
      }
      if (paramString.equals(this.this$0.getString(2131690586)))
      {
        ReadMailFragment.access$8800(this.this$0, this.val$attachIndex);
        paramQMBottomDialog.dismiss();
        return;
      }
      if (paramString.equals(this.this$0.getString(2131690572)))
      {
        paramQMBottomDialog.dismiss();
        if (StringExtention.sizeStrToLong(this.val$selectAttach.getSize()) >= 1073741824L)
        {
          ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setTitle(2131690553)).setMessage(2131690575).addAction(2131696547, new ReadMailFragment.141.1(this))).create().show();
          return;
        }
        paramQMBottomDialog = AttachSaveToWeiYunActivity.createIntent(this.val$selectAttach, ReadMailFragment.access$000(this.this$0).getStatus().isGroupMail(), ReadMailFragment.access$200(this.this$0), false, false, true);
        this.this$0.startActivity(paramQMBottomDialog);
        this.this$0.getActivity().overridePendingTransition(2130772401, 2130772430);
        return;
      }
      if (paramString.startsWith("qrcode_recognize"))
      {
        ReadMailFragment.access$22600(this.this$0, this.val$selectAttach);
        paramQMBottomDialog.dismiss();
        DataCollector.logEvent("Event_Attach_IButton_Bar_Recognize_Trigger");
        return;
      }
    } while (!paramString.equals(this.this$0.getString(2131690587)));
    KvHelper.eventPaintpadFromReadmail(new double[0]);
    paramQMBottomDialog = ReadMailFragment.access$22600(this.this$0, this.val$selectAttach);
    ReadMailFragment.access$000(this.this$0).getInformation().setAccountId(ReadMailFragment.access$200(this.this$0));
    MailPaintPadActivity.extra_maildata = ReadMailFragment.access$000(this.this$0);
    paramInt = ReadMailFragment.access$2400(this.this$0).getMailType();
    if ((ReadMailFragment.access$2300(this.this$0) != null) && (ReadMailFragment.access$2300(this.this$0).getResourceLoader() != null) && (ReadMailFragment.access$2300(this.this$0).getResourceLoader().isAllImageCached())) {}
    for (bool = true;; bool = false)
    {
      paramQMBottomDialog = Uri.parse(paramQMBottomDialog);
      paramQMBottomDialog = MailPaintPadActivity.createIntentForScreenShot(this.this$0.getActivity(), paramQMBottomDialog, ReadMailFragment.access$000(this.this$0), ReadMailFragment.access$200(this.this$0), bool, ReadMailFragment.access$2500(this.this$0), paramInt);
      this.this$0.startActivity(paramQMBottomDialog);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.141
 * JD-Core Version:    0.7.0.1
 */