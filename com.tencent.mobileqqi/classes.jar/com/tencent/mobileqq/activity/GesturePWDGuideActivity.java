package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import cve;

public class GesturePWDGuideActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 999;
  private Button a;
  
  private void d()
  {
    setTitle(2131562589);
    this.a = ((Button)findViewById(2131231741));
    this.a.setOnClickListener(new cve(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 999))
    {
      setResult(-1);
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903240);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDGuideActivity
 * JD-Core Version:    0.7.0.1
 */