package com.tencent.biz.pubaccount.readinjoy.common;

import awit;
import kxm;
import kya;
import nce;
import nce.a;

public final class WeishiReportUtil$4
  implements Runnable
{
  public void run()
  {
    boolean bool = kya.a(this.c);
    nce.a locala = new nce.a(null, null, null, null).a("folder_status", kya.e(this.c)).a("EnterType", kya.bj(this.aMK)).a("is_jump_to_video_content", Integer.valueOf(awit.Q(kxm.getAppRuntime())));
    if ((bool) && (this.a != null)) {
      locala.a("reddot_style", kya.a(this.a)).a("algorithm_id", kya.d(this.c));
    }
    String str2 = "0";
    String str1 = "0";
    if (bool)
    {
      str2 = kya.b(this.c);
      str1 = kya.c(this.c);
    }
    kya.j(str2, str1, "0X8009291", locala.a().toJsonString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.4
 * JD-Core Version:    0.7.0.1
 */