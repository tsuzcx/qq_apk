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
    try
    {
      WXPayHelper.getInstance().handleIntent(getIntent());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXPayEntryActivity
 * JD-Core Version:    0.7.0.1
 */