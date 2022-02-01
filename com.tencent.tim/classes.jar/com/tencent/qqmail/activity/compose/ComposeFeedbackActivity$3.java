package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.validate.ValidateEmail;

class ComposeFeedbackActivity$3
  implements View.OnFocusChangeListener
{
  ComposeFeedbackActivity$3(ComposeFeedbackActivity paramComposeFeedbackActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      paramView = ComposeFeedbackActivity.access$200(this.this$0).getText().toString().trim();
      if ((ValidateEmail.verifyQQMailFormat(paramView) != 0) || (paramView.split("@")[0].length() > 18) || (paramView.split("@")[0].length() < 3)) {
        break label105;
      }
      if ((!paramView.contains("@")) && (!paramView.isEmpty())) {
        ComposeFeedbackActivity.access$200(this.this$0).setText(paramView + "@qq.com");
      }
    }
    return;
    label105:
    QMLog.log(4, "ComposeFeedbackActivity", "Contact info is not a qq mail address!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeFeedbackActivity.3
 * JD-Core Version:    0.7.0.1
 */