package com.tencent.mobileqq.activity.voip;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import fbn;
import fbo;

public class VoipQCallTimeOutActivity
  extends BaseActivity
{
  private VoipContact a;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904061);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("friendUin");
    paramBundle = ((FriendManager)this.b.getManager(8)).c(str);
    if (paramBundle.length() == 0) {
      paramBundle = str;
    }
    for (;;)
    {
      ((Button)findViewById(2131234709)).setOnClickListener(new fbn(this, localIntent, paramBundle));
      ((TextView)findViewById(2131234707)).setText(paramBundle);
      ((Button)findViewById(2131234710)).setOnClickListener(new fbo(this, str));
      ((ImageView)findViewById(2131234706)).setImageDrawable(this.b.c(str));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipQCallTimeOutActivity
 * JD-Core Version:    0.7.0.1
 */