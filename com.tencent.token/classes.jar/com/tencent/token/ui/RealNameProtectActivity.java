package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
    setContentView(2131296423);
    findViewById(2131165915).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(RealNameProtectActivity.this, RealNameActivity.class);
        paramAnonymousView.putExtra("realname_result", RealNameProtectActivity.this.mResult);
        RealNameProtectActivity.this.startActivity(paramAnonymousView);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameProtectActivity
 * JD-Core Version:    0.7.0.1
 */