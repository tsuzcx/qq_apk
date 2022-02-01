package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import aqgo;
import aqhq;
import aqhv;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class JumpAction$7
  implements Runnable
{
  public JumpAction$7(aqhv paramaqhv, String paramString1, long paramLong, String paramString2, String paramString3, Runnable paramRunnable) {}
  
  public void run()
  {
    String str = aqhq.l(this.this$0.context, this.bNd, "opensdk_tmp");
    QLog.d("JumpAction", 1, new Object[] { "-->executeOnSubThread shareFilePath=", str, ", cost=", Long.valueOf(System.currentTimeMillis() - this.val$start) });
    this.this$0.attrs.remove(this.ctz);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      str = new String(aqgo.encode(str.getBytes("UTF-8"), 0));
      this.this$0.attrs.put(this.ctA, str);
      this.val$callback.run();
      if ((!this.this$0.cUe) && ((this.this$0.context instanceof JumpActivity))) {
        ((JumpActivity)this.this$0.context).finish();
      }
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QLog.i("JumpAction", 1, "executeOnSubThread put exception:", localUnsupportedEncodingException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.7
 * JD-Core Version:    0.7.0.1
 */