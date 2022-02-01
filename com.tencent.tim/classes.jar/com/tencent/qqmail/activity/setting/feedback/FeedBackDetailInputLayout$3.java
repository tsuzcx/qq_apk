package com.tencent.qqmail.activity.setting.feedback;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.utilities.ui.PressableImageView;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;

class FeedBackDetailInputLayout$3
  implements View.OnClickListener
{
  FeedBackDetailInputLayout$3(FeedBackDetailInputLayout paramFeedBackDetailInputLayout, AttachInfo paramAttachInfo, PressableImageView paramPressableImageView) {}
  
  public void onClick(View paramView)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(FeedBackDetailInputLayout.access$100(this.this$0));
    localBottomListSheetBuilder.setTitle(this.val$attachInfo.getAttachName());
    localBottomListSheetBuilder.addItem(this.this$0.getResources().getString(2131692498));
    localBottomListSheetBuilder.addItem(this.this$0.getResources().getString(2131697149));
    localBottomListSheetBuilder.setOnSheetItemClickListener(new FeedBackDetailInputLayout.3.1(this));
    localBottomListSheetBuilder.build().show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.FeedBackDetailInputLayout.3
 * JD-Core Version:    0.7.0.1
 */