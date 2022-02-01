package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.validate.ValidateEmail;

class ComposeFeedbackActivity$2
  implements View.OnClickListener
{
  ComposeFeedbackActivity$2(ComposeFeedbackActivity paramComposeFeedbackActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.hasFinishCompressFeedbackFile) {
      QMLog.log(4, "ComposeFeedbackActivity", "return cause has not Finish Compress FeedbackFile");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ComposeFeedbackActivity.access$100(this.this$0))
      {
        String str = ComposeFeedbackActivity.access$200(this.this$0).getText().toString().trim();
        if ((ValidateEmail.verifyQQMailFormat(str) == 0) && (str.split("@")[0].length() <= 18) && (str.split("@")[0].length() >= 3) && (!str.contains("@")) && (!str.isEmpty())) {
          ComposeFeedbackActivity.access$200(this.this$0).setText(str + "@qq.com");
        }
        str = ComposeFeedbackActivity.access$200(this.this$0).getText().toString().trim();
        if ((!ValidateEmail.isMailAddressVerified(str)) || (str.split("@")[0].length() > 18) || (str.split("@")[0].length() < 3) || (!str.split("@")[1].equals("qq.com")))
        {
          ComposeFeedbackActivity.access$300(this.this$0);
          continue;
        }
      }
      this.this$0.sendFeedBack(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeFeedbackActivity.2
 * JD-Core Version:    0.7.0.1
 */