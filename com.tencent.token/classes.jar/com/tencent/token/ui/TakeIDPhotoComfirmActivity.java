package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.global.e;

public class TakeIDPhotoComfirmActivity
  extends BaseActivity
{
  private int mFlag;
  
  private void init()
  {
    String str = getIntent().getStringExtra("data");
    if (TextUtils.isEmpty(str))
    {
      e.a("data is null");
      finish();
      return;
    }
    Object localObject = (TextView)findViewById(2131296561);
    if (this.mFlag == 2) {
      ((TextView)localObject).setText(2131362667);
    }
    localObject = (ImageView)findViewById(2131296559);
    ((ImageView)localObject).postDelayed(new ach(this, str, (ImageView)localObject), 100L);
    ((TextView)findViewById(2131296560)).setOnClickListener(new aci(this));
    ((TextView)findViewById(2131296398)).setOnClickListener(new acj(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    e.a("TakeIDPhotoComfirmActivity");
    this.mFlag = getIntent().getIntExtra("flag", -1);
    setContentView(2130903082);
    init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.TakeIDPhotoComfirmActivity
 * JD-Core Version:    0.7.0.1
 */