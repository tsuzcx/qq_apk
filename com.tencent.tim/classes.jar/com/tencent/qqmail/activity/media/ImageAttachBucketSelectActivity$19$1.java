package com.tencent.qqmail.activity.media;

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

class ImageAttachBucketSelectActivity$19$1
  implements DialogInterface.OnDismissListener
{
  ImageAttachBucketSelectActivity$19$1(ImageAttachBucketSelectActivity.19 param19, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$tag.equals(this.this$1.this$0.getString(2131690558))) {
      if (StringExtention.isNullOrEmpty(this.this$1.val$mediaInfo.getAttach().getPreview().getMyDisk()))
      {
        Toast.makeText(this.this$1.this$0.getActivity(), this.this$1.this$0.getString(2131692956), 0).show();
        DataCollector.logEvent("Event_Attach_Open_Save_Path_From_AttachDetail");
      }
    }
    do
    {
      do
      {
        return;
        IntentUtil.openAttachFileLocation(this.this$1.this$0.getActivity(), this.this$1.val$mediaInfo.getAttach().getPreview().getMyDisk());
        break;
        if (this.val$tag.equals(this.this$1.this$0.getString(2131690556)))
        {
          ImageAttachBucketSelectActivity.access$3200(this.this$1.this$0, this.this$1.val$curAttach);
          DataCollector.logEvent("Event_Attach_Open_File_From_AttachDetail");
          return;
        }
        if (this.val$tag.equals(this.this$1.this$0.getString(2131690583)))
        {
          ImageAttachBucketSelectActivity.access$1700(this.this$1.this$0, this.this$1.val$mediaInfo);
          DataCollector.logEvent("Event_Attach_Save_Photo_From_AttachDetail");
          return;
        }
      } while (this.val$tag.equals(this.this$1.this$0.getString(2131690584)));
      if (this.val$tag.equals(this.this$1.this$0.getString(2131690550)))
      {
        if ((this.this$1.val$mediaInfo != null) && (this.this$1.val$mediaInfo.getAttach() != null)) {
          AttachOperateMore.doForwardAttaches(this.this$1.this$0.getActivity(), new long[] { this.this$1.val$mediaInfo.getAttach().getHashId() });
        }
        DataCollector.logEvent("Event_Attach_Send_Email_From_AttachDetail");
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131690532)))
      {
        QMAttachManager.sharedInstance().favoriteAttach(new long[] { this.this$1.val$curAttach.getHashId() }, true);
        this.this$1.this$0.getTips().showSuccess(2131689776);
        DataCollector.logEvent("Event_Attach_Preview_AddFavorite");
        DataCollector.logEvent("Event_Attach_AddFavorite");
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131690535)))
      {
        QMAttachManager.sharedInstance().favoriteAttach(new long[] { this.this$1.val$curAttach.getHashId() }, false);
        this.this$1.this$0.getTips().showSuccess(2131691250);
        DataCollector.logEvent("Event_Attach_CancelFavorite");
        return;
      }
      if (this.val$tag.equals(this.this$1.this$0.getString(2131690586)))
      {
        new QMShareFileDialogHelper(this.this$1.this$0.getActivity(), this.this$1.this$0.getString(2131690586), this.this$1.val$filePath, QMShareFileDialogHelper.SHARE_TYPE_IMG).createDialog().show();
        DataCollector.logEvent("Event_Share_Normal_Attach_From_Favorite");
        return;
      }
    } while (!this.val$tag.equals(this.this$1.this$0.getString(2131690572)));
    ImageAttachBucketSelectActivity.access$2100(this.this$1.this$0, this.this$1.val$curAttach);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.19.1
 * JD-Core Version:    0.7.0.1
 */