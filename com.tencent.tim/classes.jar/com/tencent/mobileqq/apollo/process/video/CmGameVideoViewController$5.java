package com.tencent.mobileqq.apollo.process.video;

import abqk;
import abql;
import abyq;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;

public class CmGameVideoViewController$5
  implements Runnable
{
  public void run()
  {
    if ((abql.a(this.this$0) == null) || (TextUtils.isEmpty(abql.a(this.this$0).exposureUrl))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(abql.a(this.this$0).exposureUrl);
    String str3 = "";
    String str1 = str3;
    switch (this.val$type)
    {
    default: 
      str1 = str3;
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameVideoViewController", 2, new Object[] { "[cm_ad_report], type:", Integer.valueOf(this.val$type), ",time:", Long.valueOf(this.val$time) });
        }
        if (!TextUtils.isEmpty(str1)) {
          localStringBuilder.append("&video=").append(URLEncoder.encode(str1, "UTF-8"));
        }
        abyq.a(localStringBuilder.toString(), null, null);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameVideoViewController", 1, localThrowable, new Object[0]);
        return;
      }
      if ((abql.a(this.this$0) & 0x1) == 1) {
        break;
      }
      String str2 = abql.a(this.this$0, 0L, 0L, 1L, 0L);
      abql.a(this.this$0, abql.a(this.this$0) | 0x1);
      continue;
      if ((abql.a(this.this$0) & 0x2) == 2) {
        break;
      }
      str2 = "";
      abql.a(this.this$0, abql.a(this.this$0) | 0x2);
      continue;
      if ((abql.a(this.this$0) & 0x4) == 4) {
        break;
      }
      str2 = abql.a(this.this$0, 0L, this.val$time, 1L, 0L);
      abql.a(this.this$0, abql.a(this.this$0) | 0x4);
      continue;
      if ((abql.a(this.this$0) & 0x8) == 8) {
        break;
      }
      str2 = abql.a(this.this$0, 0L, this.val$time, 1L, 1L);
      abql.a(this.this$0, abql.a(this.this$0) | 0x8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameVideoViewController.5
 * JD-Core Version:    0.7.0.1
 */