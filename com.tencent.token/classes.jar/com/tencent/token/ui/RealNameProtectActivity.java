package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.token.core.bean.RealNameStatusResult;

public class RealNameProtectActivity
  extends BaseActivity
{
  private RealNameStatusResult mResult;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mResult = ((RealNameStatusResult)getIntent().getSerializableExtra("realname_result"));
    if (this.mResult == null)
    {
      finish();
      return;
    }
    setContentView(2130903166);
    findViewById(2131296965).setOnClickListener(new vr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameProtectActivity
 * JD-Core Version:    0.7.0.1
 */