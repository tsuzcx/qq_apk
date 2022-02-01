package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import aqgo;
import aqhq;
import aqhv;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;

public class JumpAction$20
  implements Runnable
{
  public JumpAction$20(aqhv paramaqhv, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = new StringBuffer();
    String[] arrayOfString = this.ctx.split(";");
    int i = 0;
    while (i < arrayOfString.length)
    {
      String str = URLDecoder.decode(arrayOfString[i]);
      if (!TextUtils.isEmpty(str))
      {
        str = aqhq.l(this.this$0.context, str, "opensdk_tmp");
        if (!TextUtils.isEmpty(str))
        {
          ((StringBuffer)localObject).append(URLEncoder.encode(str));
          if (i != arrayOfString.length - 1) {
            ((StringBuffer)localObject).append(";");
          }
        }
      }
      i += 1;
    }
    try
    {
      localObject = new String(aqgo.encode(((StringBuffer)localObject).toString().getBytes("UTF-8"), 0));
      this.this$0.attrs.put("image_url", localObject);
      aqhv.a(this.this$0, this.cty, false);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QLog.i("JumpAction", 1, "gotoShareMsgCheck put exception:", localUnsupportedEncodingException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.20
 * JD-Core Version:    0.7.0.1
 */