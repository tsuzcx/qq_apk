package com.tencent.qqmail.activity.setting;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.qqmail.model.alias.QMAliasManager;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingIndependentNickActivity$3
  implements UITableView.ClickListener
{
  SettingIndependentNickActivity$3(SettingIndependentNickActivity paramSettingIndependentNickActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool = true;
    if (paramUITableItemView == SettingIndependentNickActivity.access$800(this.this$0)) {
      if (!paramUITableItemView.isChecked())
      {
        paramUITableItemView.setChecked(bool);
        SettingIndependentNickActivity.access$902(this.this$0, paramUITableItemView.isChecked());
        if (!SettingIndependentNickActivity.access$900(this.this$0)) {
          ((InputMethodManager)this.this$0.getSystemService("input_method")).hideSoftInputFromWindow(SettingIndependentNickActivity.access$200(this.this$0).getWindowToken(), 0);
        }
        QMComposeDataManager.sharedInstance().setQMAliasIndep(SettingIndependentNickActivity.access$500(this.this$0), SettingIndependentNickActivity.access$600(this.this$0), SettingIndependentNickActivity.access$900(this.this$0));
        paramUITableItemView = new QMCallback();
        paramUITableItemView.setOnSuccess(new SettingIndependentNickActivity.3.1(this));
        paramUITableItemView.setOnError(new SettingIndependentNickActivity.3.2(this));
        QMAliasManager.shareInstance().syncQMAliasIndep(SettingIndependentNickActivity.access$600(this.this$0), SettingIndependentNickActivity.access$500(this.this$0), SettingIndependentNickActivity.access$900(this.this$0), paramUITableItemView);
        this.this$0.refreshData();
        this.this$0.render();
      }
    }
    while (paramUITableItemView != SettingIndependentNickActivity.access$300(this.this$0)) {
      for (;;)
      {
        return;
        bool = false;
      }
    }
    SettingIndependentNickActivity.access$400(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingIndependentNickActivity.3
 * JD-Core Version:    0.7.0.1
 */