package com.tencent.qqmini.sdk.ui;

import android.view.KeyEvent;
import com.tencent.qqmini.sdk.launcher.ui.MiniActivity;

public class InternalMiniActivity
  extends MiniActivity
{
  public void onBackPressed()
  {
    finish();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.InternalMiniActivity
 * JD-Core Version:    0.7.0.1
 */