package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.utils.x;

public class CopyFaceToOtherUinActivity
  extends BaseActivity
{
  private Handler mHandler = new ct(this);
  private String mUinInfo;
  
  private void init()
  {
    if ((getIntent() == null) || (getIntent().getExtras() == null))
    {
      finish();
      return;
    }
    Object localObject = (TextView)findViewById(2131558761);
    this.mUinInfo = getIntent().getExtras().getString("nofaceuinlists");
    ((TextView)localObject).setText(x.a(getResources().getString(2131230982) + this.mUinInfo + getResources().getString(2131230983), getResources().getDimension(2131296403), (int)(getWindowManager().getDefaultDisplay().getWidth() - 34.0F * IndexActivity.S_DENSITY)));
    localObject = (Button)findViewById(2131558760);
    ((Button)findViewById(2131558762)).setOnClickListener(new cv(this));
    ((Button)localObject).setOnClickListener(new cw(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968631);
    showOrangeToast(2131231017, 2130838018);
    AccountPageActivity.mNeedRefreshEval = true;
    init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.CopyFaceToOtherUinActivity
 * JD-Core Version:    0.7.0.1
 */