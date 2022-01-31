package com.tencent.mobileqq.activity.voip;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import ewz;
import exa;

public class VoipQCallTimeOutActivity
  extends BaseActivity
{
  private VoipContact a;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904063);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("friendUin");
    paramBundle = ((FriendManager)this.b.getManager(8)).c(str);
    if (paramBundle.length() == 0) {
      paramBundle = str;
    }
    for (;;)
    {
      ((Button)findViewById(2131234711)).setOnClickListener(new ewz(this, localIntent, paramBundle));
      ((TextView)findViewById(2131234709)).setText(paramBundle);
      ((Button)findViewById(2131234712)).setOnClickListener(new exa(this, str));
      ((ImageView)findViewById(2131234708)).setImageDrawable(this.b.c(str));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipQCallTimeOutActivity
 * JD-Core Version:    0.7.0.1
 */