package com.tencent.av.compat;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import igv;
import iiv;
import imb;
import mqq.app.BaseActivity;

public class AVCallCompactHelper$1
  implements Runnable
{
  public AVCallCompactHelper$1(imb paramimb, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    Object localObject = null;
    Intent localIntent = imb.a(this.this$0, imb.access$000());
    String str1;
    int i;
    if ((this.a.isResume()) && (localIntent != null))
    {
      int j = igv.a().kv();
      String str2 = imb.a(imb.access$000(), localIntent);
      iiv localiiv = igv.a().c(str2);
      localObject = localiiv;
      str1 = str2;
      i = j;
      if (j >= 2)
      {
        localObject = localiiv;
        str1 = str2;
        i = j;
        if (localiiv != null)
        {
          localObject = localiiv;
          str1 = str2;
          i = j;
          if (localiiv.tc())
          {
            this.a.startActivity(localIntent);
            i = j;
            str1 = str2;
            localObject = localiiv;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CompatModeTag", 2, "checkThirdCallIntent, isResume[" + this.a.isResume() + "], count[" + i + "], session[" + str1 + "], info[" + localObject + "]");
      }
      return;
      i = 0;
      str1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.compat.AVCallCompactHelper.1
 * JD-Core Version:    0.7.0.1
 */