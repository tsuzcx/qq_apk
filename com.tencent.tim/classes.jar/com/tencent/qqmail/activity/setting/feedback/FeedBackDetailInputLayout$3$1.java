package com.tencent.qqmail.activity.setting.feedback;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qqmail.qmui.layout.QMUIFloatLayout;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import java.util.List;

class FeedBackDetailInputLayout$3$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  FeedBackDetailInputLayout$3$1(FeedBackDetailInputLayout.3 param3) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    paramInt = this.this$1.this$0.getIndexOfInfo(this.this$1.val$attachInfo);
    if (this.this$1.this$0.getResources().getString(2131692498).equals(paramString))
    {
      FeedBackDetailInputLayout.access$200(this.this$1.this$0).remove(paramInt);
      FeedBackDetailInputLayout.access$300(this.this$1.this$0).removeView(this.this$1.val$imageView);
      if (this.this$1.this$0.canAddImage()) {
        FeedBackDetailInputLayout.access$400(this.this$1.this$0).setVisibility(0);
      }
      if (FeedBackDetailInputLayout.access$000(this.this$1.this$0) != null) {
        FeedBackDetailInputLayout.access$000(this.this$1.this$0).onDelete(this.this$1.val$attachInfo);
      }
    }
    while ((!this.this$1.this$0.getResources().getString(2131697149).equals(paramString)) || (FeedBackDetailInputLayout.access$000(this.this$1.this$0) == null)) {
      return;
    }
    FeedBackDetailInputLayout.access$000(this.this$1.this$0).onPreviewImage(this.this$1.val$attachInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.FeedBackDetailInputLayout.3.1
 * JD-Core Version:    0.7.0.1
 */