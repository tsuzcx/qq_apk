package com.tencent.mobileqq.wxapi;

import android.app.Activity;
import android.os.Bundle;

public class WXEntryActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    try
    {
      WXShareHelper.a().a(getIntent());
      label21:
      finish();
      return;
    }
    catch (Exception paramBundle)
    {
      break label21;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXEntryActivity
 * JD-Core Version:    0.7.0.1
 */