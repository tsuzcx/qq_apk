package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import mqq.app.AppActivity;

public class ShortcutGuideActivity
  extends AppActivity
{
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    try
    {
      paramBundle = getIntent();
      paramBundle.putExtra("shotcut_forward", ChatActivity.class.getName());
      paramBundle.setClassName(this, ShortcutRouterActivity.class.getName());
      startActivity(paramBundle);
      label39:
      finish();
      return true;
    }
    catch (Exception paramBundle)
    {
      break label39;
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShortcutGuideActivity
 * JD-Core Version:    0.7.0.1
 */