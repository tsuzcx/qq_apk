package com.tencent.qqmail.activity.setting.feedback;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.qqmail.activity.compose.ComposeFeedbackActivity;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.io.Serializable;
import java.util.List;

class SettingFeedbackSceneActivity$2
  implements UITableView.ClickListener
{
  SettingFeedbackSceneActivity$2(SettingFeedbackSceneActivity paramSettingFeedbackSceneActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramInt - 1 < SettingFeedbackSceneActivity.access$000(this.this$0).size())
    {
      paramUITableItemView = SettingFeedbackDetailActivity.createIntent((Serializable)SettingFeedbackSceneActivity.access$000(this.this$0).get(paramInt - 1), paramUITableItemView.getTitleView().getText().toString());
      paramUITableItemView.putExtra("animationType", 2);
      this.this$0.startActivity(paramUITableItemView);
      return;
    }
    paramUITableItemView = new ComposeMailUI();
    paramUITableItemView.setType(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FEED_BACK);
    paramUITableItemView = ComposeFeedbackActivity.createIntent(paramUITableItemView, "setting");
    paramUITableItemView.putExtra("arg_from_setting_feedback", true);
    paramUITableItemView.putExtra("animationType", 1);
    this.this$0.startActivity(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.SettingFeedbackSceneActivity.2
 * JD-Core Version:    0.7.0.1
 */