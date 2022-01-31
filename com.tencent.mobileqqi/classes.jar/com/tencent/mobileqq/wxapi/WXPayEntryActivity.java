package com.tencent.mobileqq.wxapi;

import android.app.Activity;
import android.os.Bundle;

public class WXPayEntryActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    WXPayHelper.getInstance().handleIntent(getIntent());
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXPayEntryActivity
 * JD-Core Version:    0.7.0.1
 */