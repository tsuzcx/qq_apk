package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.global.h;

public class TakeIDPhotoComfirmActivity
  extends BaseActivity
{
  private int mFlag;
  
  private void init()
  {
    String str = getIntent().getStringExtra("data");
    if (TextUtils.isEmpty(str))
    {
      h.a("data is null");
      finish();
      return;
    }
    Object localObject = (TextView)findViewById(2131558848);
    if (this.mFlag == 2) {
      ((TextView)localObject).setText(2131231342);
    }
    localObject = (ImageView)findViewById(2131558845);
    ((ImageView)localObject).postDelayed(new aar(this, str, (ImageView)localObject), 100L);
    ((TextView)findViewById(2131558847)).setOnClickListener(new aas(this));
    ((TextView)findViewById(2131558649)).setOnClickListener(new aat(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    h.a("TakeIDPhotoComfirmActivity");
    this.mFlag = getIntent().getIntExtra("flag", -1);
    setContentView(2130968648);
    init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.TakeIDPhotoComfirmActivity
 * JD-Core Version:    0.7.0.1
 */