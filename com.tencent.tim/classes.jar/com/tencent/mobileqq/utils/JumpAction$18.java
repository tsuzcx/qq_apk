package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import aqgo;
import aqhq;
import aqhv;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class JumpAction$18
  implements Runnable
{
  public void run()
  {
    String str = aqhq.l(this.this$0.context, this.val$filePath, "opensdk_tmp");
    try
    {
      str = new String(aqgo.encode(str.getBytes("UTF-8"), 0));
      if (!TextUtils.isEmpty(str)) {
        this.this$0.attrs.put("videoPath", str);
      }
      aqhv.a(this.this$0, false);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QLog.e("JumpAction", 1, "gotoQzonePublishMoodCheck exception:", localUnsupportedEncodingException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.18
 * JD-Core Version:    0.7.0.1
 */