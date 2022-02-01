package com.tencent.qqmail.attachment.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.Toast;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.util.AttachOperateMore;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper;
import com.tencent.qqmail.utilities.ui.QMTips;

class AttachFolderPreviewActivity$13$1
  implements DialogInterface.OnDismissListener
{
  AttachFolderPreviewActivity$13$1(AttachFolderPreviewActivity.13 param13, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$tag.equals(this.this$1.this$0.getString(2131690550)))
    {
      AttachOperateMore.doForwardAttaches(this.this$1.this$0.getActivity(), new long[] { AttachFolderPreviewActivity.access$1000(this.this$1.this$0).getHashId() });
      DataCollector.logEvent("Event_Attach_Send_Email_From_AttachDetail");
    }
    do
    {
      return;
      if (this.val$tag.equals(this.this$1.this$0.getString(2131690582)))
      {
        AttachFolderPreviewActivity.access$2000(this.this$1.this$0);
        DataCollector.logEvent("Event_Click_SaveAs_From_AttachDetail");
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131690558)))
      {
        if (StringExtention.isNullOrEmpty(AttachFolderPreviewActivity.access$1000(this.this$1.this$0).getPreview().getMyDisk())) {
          Toast.makeText(this.this$1.this$0.getActivity(), this.this$1.this$0.getString(2131692956), 0).show();
        }
        for (;;)
        {
          DataCollector.logEvent("Event_Attach_Open_Save_Path_From_AttachDetail");
          return;
          IntentUtil.openAttachFileLocation(this.this$1.this$0.getActivity(), AttachFolderPreviewActivity.access$1000(this.this$1.this$0).getPreview().getMyDisk());
        }
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131690532)))
      {
        QMAttachManager.sharedInstance().favoriteAttach(new long[] { AttachFolderPreviewActivity.access$1000(this.this$1.this$0).getHashId() }, true);
        this.this$1.this$0.getTips().showSuccess(2131689776);
        DataCollector.logEvent("Event_Attach_Preview_AddFavorite");
        DataCollector.logEvent("Event_Attach_AddFavorite");
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131690535)))
      {
        QMAttachManager.sharedInstance().favoriteAttach(new long[] { AttachFolderPreviewActivity.access$1000(this.this$1.this$0).getHashId() }, false);
        this.this$1.this$0.getTips().showSuccess(2131691250);
        DataCollector.logEvent("Event_Attach_CancelFavorite");
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131690586)))
      {
        paramDialogInterface = AttachFolderPreviewActivity.access$1000(this.this$1.this$0).getPreview().getMyDisk();
        new QMShareFileDialogHelper(this.this$1.this$0.getActivity(), this.this$1.this$0.getString(2131690586), paramDialogInterface, QMShareFileDialogHelper.SHARE_TYPE_NORMAL_ATT).createDialog().show();
        DataCollector.logEvent("Event_Share_Normal_Attach_From_Favorite");
        return;
      }
    } while (!this.val$tag.equals(this.this$1.this$0.getString(2131690572)));
    AttachFolderPreviewActivity.access$2100(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderPreviewActivity.13.1
 * JD-Core Version:    0.7.0.1
 */