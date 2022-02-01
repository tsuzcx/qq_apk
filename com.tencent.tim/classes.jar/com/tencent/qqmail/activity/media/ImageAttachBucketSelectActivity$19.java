package com.tencent.qqmail.activity.media;

import android.view.View;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ImageAttachBucketSelectActivity$19
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ImageAttachBucketSelectActivity$19(ImageAttachBucketSelectActivity paramImageAttachBucketSelectActivity, MediaItemInfo paramMediaItemInfo, Attach paramAttach, String paramString) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new ImageAttachBucketSelectActivity.19.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.19
 * JD-Core Version:    0.7.0.1
 */