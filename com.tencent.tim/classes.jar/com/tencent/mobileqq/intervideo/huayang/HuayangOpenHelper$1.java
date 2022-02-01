package com.tencent.mobileqq.intervideo.huayang;

import aice;
import aidf;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.Map;

public final class HuayangOpenHelper$1
  implements Runnable
{
  public HuayangOpenHelper$1(String paramString1, aidf paramaidf, QQAppInterface paramQQAppInterface, String paramString2, String paramString3, Map paramMap) {}
  
  public void run()
  {
    aice.a().a(this.bNc, this.c);
    ThreadManagerV2.getUIHandlerV2().post(new HuayangOpenHelper.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangOpenHelper.1
 * JD-Core Version:    0.7.0.1
 */