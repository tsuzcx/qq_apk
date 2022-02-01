package com.tencent.mobileqq.activity;

import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import vpf;

public class QQSettingCleanActivity$2$1
  implements Runnable
{
  public QQSettingCleanActivity$2$1(vpf paramvpf) {}
  
  public void run()
  {
    anot.a(this.a.this$0.app, "dc00898", "", "", "0X8007914", "0X8007914", 0, 0, this.a.this$0.app.getCurrentAccountUin(), "", "", "");
    HttpDownloadUtil.a("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean", this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity.2.1
 * JD-Core Version:    0.7.0.1
 */