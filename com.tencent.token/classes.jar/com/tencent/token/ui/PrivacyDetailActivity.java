package com.tencent.token.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.aay;

public class PrivacyDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131165388)
    {
      if (i != 2131165835)
      {
        if (i != 2131165850)
        {
          if (i != 2131166045) {
            return;
          }
          aay.a(this, "https://sdi.3g.qq.com/v/2021102115434511274", "软件许可协议");
          return;
        }
        aay.a(this, "https://privacy.qq.com/document/preview/72866ea2379742c1a48f6ff76a82e598", "隐私保护指引");
        return;
      }
      aay.a(this, "https://privacy.qq.com/document/preview/255f66ec5dfa4512a547dacc14935707", "收集个人信息明示清单");
      return;
    }
    aay.a(this, "https://privacy.qq.com/document/preview/a96c8aff35fb4a16bb8d821db9109a35", "儿童隐私保护声明");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296409);
    findViewById(2131165850).setOnClickListener(this);
    findViewById(2131166045).setOnClickListener(this);
    findViewById(2131165388).setOnClickListener(this);
    findViewById(2131165835).setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.PrivacyDetailActivity
 * JD-Core Version:    0.7.0.1
 */