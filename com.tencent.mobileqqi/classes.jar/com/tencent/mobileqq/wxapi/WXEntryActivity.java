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
    WXShareHelper.a().a(getIntent());
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXEntryActivity
 * JD-Core Version:    0.7.0.1
 */