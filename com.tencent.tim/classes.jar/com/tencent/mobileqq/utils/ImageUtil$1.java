package com.tencent.mobileqq.utils;

import anpc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class ImageUtil$1
  implements Runnable
{
  public ImageUtil$1(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    anpc.a(BaseApplication.getContext()).collectPerformance(this.val$app.getCurrentAccountUin(), this.val$tag, this.aYV, 0L, 0L, new HashMap(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ImageUtil.1
 * JD-Core Version:    0.7.0.1
 */