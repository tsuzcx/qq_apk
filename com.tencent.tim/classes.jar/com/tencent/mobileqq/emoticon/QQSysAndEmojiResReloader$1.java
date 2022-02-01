package com.tencent.mobileqq.emoticon;

import afkv;
import afkw;
import com.tencent.qphone.base.util.QLog;

public class QQSysAndEmojiResReloader$1
  implements Runnable
{
  public QQSysAndEmojiResReloader$1(afkw paramafkw) {}
  
  public void run()
  {
    if (afkv.a() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSysAndEmojiResReloader", 2, "trigger downloadEmoticonRes");
      }
      afkv.a().daa();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader.1
 * JD-Core Version:    0.7.0.1
 */