package com.tencent.token.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class UtilsMbInfoFeedbackMobileUsingSuccActivity
  extends BaseActivity
{
  private void initUI()
  {
    findViewById(2131165489).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UtilsMbInfoFeedbackMobileUsingSuccActivity.this.finish();
      }
    });
    this.mBackArrow.setVisibility(4);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296474);
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsMbInfoFeedbackMobileUsingSuccActivity
 * JD-Core Version:    0.7.0.1
 */