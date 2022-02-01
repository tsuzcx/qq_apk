package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;

class AddFriendVerifyActivity$5$1
  implements Runnable
{
  AddFriendVerifyActivity$5$1(AddFriendVerifyActivity.5 param5, String paramString) {}
  
  public void run()
  {
    TextView localTextView;
    if (AddFriendVerifyActivity.a(this.a.this$0).isShown())
    {
      localTextView = AddFriendVerifyActivity.a(this.a.this$0);
      if (!TextUtils.isEmpty(this.a.val$name)) {
        break label91;
      }
      str = this.aKM;
      localTextView.setText(str);
      if (AppSetting.enableTalkBack)
      {
        localTextView = AddFriendVerifyActivity.a(this.a.this$0);
        if (!TextUtils.isEmpty(this.a.val$name)) {
          break label102;
        }
      }
    }
    label91:
    label102:
    for (String str = this.aKM;; str = this.a.val$name)
    {
      localTextView.setContentDescription(str);
      return;
      str = this.a.val$name;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.5.1
 * JD-Core Version:    0.7.0.1
 */