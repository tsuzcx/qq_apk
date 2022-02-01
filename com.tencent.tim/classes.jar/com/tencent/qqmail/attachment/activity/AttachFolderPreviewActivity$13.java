package com.tencent.qqmail.attachment.activity;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class AttachFolderPreviewActivity$13
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  AttachFolderPreviewActivity$13(AttachFolderPreviewActivity paramAttachFolderPreviewActivity) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new AttachFolderPreviewActivity.13.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderPreviewActivity.13
 * JD-Core Version:    0.7.0.1
 */