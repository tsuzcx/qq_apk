package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.token.global.RqdApplication;

class ok
  implements View.OnClickListener
{
  ok(LogoActivity paramLogoActivity) {}
  
  public void onClick(View paramView)
  {
    Toast.makeText(RqdApplication.l(), "需要获得您的同意后才可继续使用QQ安全中心提供的服务", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ok
 * JD-Core Version:    0.7.0.1
 */