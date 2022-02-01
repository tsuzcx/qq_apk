package com.tencent.qqmail.activity.setting;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;

class SettingQmDefaultNickActivity$3
  implements UITableView.ClickListener
{
  SettingQmDefaultNickActivity$3(SettingQmDefaultNickActivity paramSettingQmDefaultNickActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    ((InputMethodManager)SettingQmDefaultNickActivity.access$300(this.this$0).getContext().getSystemService("input_method")).hideSoftInputFromWindow(SettingQmDefaultNickActivity.access$300(this.this$0).getWindowToken(), 0);
    Log.d("imm", "height:" + SettingQmDefaultNickActivity.access$400(this.this$0).getHeight());
    Intent localIntent = new Intent(this.this$0, SettingIndependentNickActivity.class);
    localIntent.putExtra("alias", paramUITableItemView.getTitleView().getText());
    localIntent.putExtra("accountId", SettingQmDefaultNickActivity.access$000(this.this$0).getId());
    this.this$0.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingQmDefaultNickActivity.3
 * JD-Core Version:    0.7.0.1
 */