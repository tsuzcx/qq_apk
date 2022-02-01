package com.tencent.mobileqq.util;

import aqes;
import aqet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;

public class QQAvatarFHDDecoder$1$2
  implements Runnable
{
  public QQAvatarFHDDecoder$1$2(aqet paramaqet, String paramString) {}
  
  public void run()
  {
    if (aqes.a(this.a.this$0)) {
      return;
    }
    Setting localSetting = aqes.a(this.a.this$0).b(this.val$uin);
    this.a.this$0.e(localSetting);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQAvatarFHDDecoder.1.2
 * JD-Core Version:    0.7.0.1
 */