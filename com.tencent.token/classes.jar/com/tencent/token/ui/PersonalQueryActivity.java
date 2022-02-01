package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class PersonalQueryActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this, AccountInfoActivity.class);
    int i = paramView.getId();
    if (i != 2131165449) {
      switch (i)
      {
      default: 
        paramView = localIntent;
        break;
      case 2131165221: 
        localIntent.putExtra("sp", 3);
        localIntent.putExtra("st", "动态密码（手机令牌）");
        paramView = localIntent;
        break;
      case 2131165220: 
        localIntent.putExtra("sp", 2);
        localIntent.putExtra("st", "帐号状态");
        paramView = localIntent;
        break;
      case 2131165219: 
        localIntent.putExtra("sp", 1);
        localIntent.putExtra("st", "帐号资料");
        paramView = localIntent;
        break;
      }
    } else {
      paramView = new Intent(this, DeviceInfo1Activity.class);
    }
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296408);
    findViewById(2131165219).setOnClickListener(this);
    findViewById(2131165220).setOnClickListener(this);
    findViewById(2131165221).setOnClickListener(this);
    findViewById(2131165449).setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.PersonalQueryActivity
 * JD-Core Version:    0.7.0.1
 */