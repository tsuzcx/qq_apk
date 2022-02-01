package com.tencent.qqmail.activity.setting.feedback;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.setting.SettingHelpActivity;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import java.util.Iterator;
import java.util.List;

class SettingFeedbackDetailActivity$4
  implements View.OnClickListener
{
  SettingFeedbackDetailActivity$4(SettingFeedbackDetailActivity paramSettingFeedbackDetailActivity) {}
  
  private boolean isHasCheckedQuestion()
  {
    Iterator localIterator = SettingFeedbackDetailActivity.access$500(this.this$0).iterator();
    while (localIterator.hasNext()) {
      if (((UITableItemView)localIterator.next()).isChecked()) {
        return true;
      }
    }
    return false;
  }
  
  private void showError(int paramInt)
  {
    this.this$0.getTips().showError(paramInt, 1500L);
  }
  
  public void onClick(View paramView)
  {
    if (!isHasCheckedQuestion()) {
      showError(2131719841);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((SettingFeedbackDetailActivity.access$600(this.this$0) > 0) && (SettingFeedbackDetailActivity.access$000(this.this$0).getInputContent().length() == 0))
      {
        showError(2131719836);
      }
      else if ((((SettingFeedbackDetailActivity.Question)SettingFeedbackDetailActivity.access$800(this.this$0).get(SettingFeedbackDetailActivity.access$700(this.this$0))).mandatoryPic > 0) && (SettingFeedbackDetailActivity.access$000(this.this$0).getImageCountAdded() == 0))
      {
        showError(2131719833);
      }
      else if (!SettingFeedbackDetailActivity.access$900(this.this$0))
      {
        QMLog.log(4, "SettingFeedbackDetailActivity", "return cause has not Finish Compress FeedbackFile");
      }
      else
      {
        SettingFeedbackDetailActivity.access$1000(this.this$0, paramView);
        if (!this.this$0.getIntent().getBooleanExtra("ARG_FROM_LOGIG", false))
        {
          Intent localIntent = SettingHelpActivity.createIntent("https://kf.qq.com/touch/product/mail_app.html?scene_id=kf1866");
          this.this$0.startActivity(localIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.SettingFeedbackDetailActivity.4
 * JD-Core Version:    0.7.0.1
 */