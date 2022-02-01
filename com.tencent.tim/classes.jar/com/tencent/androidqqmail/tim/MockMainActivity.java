package com.tencent.androidqqmail.tim;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.wetest.WeTestConfig;

public class MockMainActivity
  extends Activity
{
  public static final String TAG = "MainActivity";
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (AccountManager.shareInstance().getAccountList().size() == 0)
    {
      if (WeTestConfig.autoLoginQQ())
      {
        startActivity(LoginFragmentActivity.createIntentToAddAccount(AccountType.qqmail.name()));
        return;
      }
      if (WeTestConfig.autoLoginProtocol())
      {
        startActivity(LoginFragmentActivity.createIntentToAddAccount(AccountType.other.name()));
        return;
      }
    }
    paramBundle = new LinearLayout(this);
    paramBundle.setOrientation(1);
    setContentView(paramBundle);
    Button localButton = new Button(this);
    localButton.setText("进入QQ邮箱");
    paramBundle.addView(localButton);
    localButton.setOnClickListener(new MockMainActivity.1(this));
    localButton = new Button(this);
    localButton.setText("模拟Tim登录");
    paramBundle.addView(localButton);
    localButton.setOnClickListener(new MockMainActivity.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.MockMainActivity
 * JD-Core Version:    0.7.0.1
 */