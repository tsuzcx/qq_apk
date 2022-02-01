package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.token.ajr;
import com.tencent.token.tt;
import com.tmsdk.TMSDKContext;

public class PrivacyManagerActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131165847: 
      startActivity(new Intent(this, PrivacyDetailActivity.class));
      TMSDKContext.saveActionData(1150194);
      return;
    case 2131165838: 
      startActivity(new Intent(this, PersonalQueryActivity.class));
      TMSDKContext.saveActionData(1150191);
      return;
    case 2131165837: 
      if (tt.a().k.a() == 0)
      {
        Toast.makeText(this, "需要先登录后，才能进行个人信息下载", 0).show();
        return;
      }
      startActivity(new Intent(this, DownloadPersonalInfoActivity.class));
      TMSDKContext.saveActionData(1150193);
      return;
    case 2131165829: 
      startActivity(new Intent(this, PermissionActivity.class));
      TMSDKContext.saveActionData(1150195);
      return;
    }
    startActivity(new Intent(this, DeviceInfo2Activity.class));
    TMSDKContext.saveActionData(1150192);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296410);
    findViewById(2131165838).setOnClickListener(this);
    findViewById(2131165449).setOnClickListener(this);
    findViewById(2131165837).setOnClickListener(this);
    findViewById(2131165847).setOnClickListener(this);
    findViewById(2131165829).setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.PrivacyManagerActivity
 * JD-Core Version:    0.7.0.1
 */