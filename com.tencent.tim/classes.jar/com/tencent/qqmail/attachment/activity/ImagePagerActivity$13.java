package com.tencent.qqmail.attachment.activity;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class ImagePagerActivity$13
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ImagePagerActivity$13(ImagePagerActivity paramImagePagerActivity, String paramString1, String paramString2) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new ImagePagerActivity.13.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.13
 * JD-Core Version:    0.7.0.1
 */