package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;

public class InAppMessageActivity
  extends Activity
{
  private Context a;
  private Handler b;
  private c c;
  private Intent d;
  
  private void a(String paramString)
  {
    TLogger.i("InAppMessageActivity", "InAppMsg parseData :" + paramString);
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    CommonWorkingThread.getInstance().execute(new InAppMessageActivity.1(this, paramString));
  }
  
  private boolean a(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.hasExtra("inapp_protect"))
      {
        paramIntent = paramIntent.getStringExtra("inapp_protect");
        bool1 = bool2;
        if (!i.b(paramIntent)) {
          paramIntent = Rijndael.decrypt(paramIntent);
        }
      }
    }
    try
    {
      paramIntent = Long.valueOf(paramIntent);
      bool1 = bool2;
      if (paramIntent.longValue() > 0L)
      {
        long l1 = System.currentTimeMillis();
        long l2 = paramIntent.longValue();
        bool1 = bool2;
        if (l1 >= l2) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (NumberFormatException paramIntent)
    {
      TLogger.e("InAppMessageActivity", "InAppMsg checkIntent :" + paramIntent.toString());
    }
    return false;
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      this.a = this;
      this.b = new Handler();
      this.d = getIntent();
      if (a(this.d))
      {
        paramBundle = this.d.getStringExtra("inAppMsg");
        this.d.putExtra("pushChannel", 100);
        a(paramBundle);
        return;
      }
      finish();
      return;
    }
    catch (Throwable paramBundle)
    {
      TLogger.e("InAppMessageActivity", "InAppMsg start InAppMessageActivity :" + paramBundle.toString());
      try
      {
        finish();
        return;
      }
      catch (Throwable paramBundle)
      {
        TLogger.e("InAppMessageActivity", "InAppMsg finish InAppMessageActivity :" + paramBundle.toString());
      }
    }
  }
  
  protected void onDestroy()
  {
    if (this.c != null) {
      this.c.dismiss();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.inappmessage.InAppMessageActivity
 * JD-Core Version:    0.7.0.1
 */