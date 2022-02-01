package com.tencent.biz.pubaccount.readinjoy.common;

import awit;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import kxm;
import kya;
import nce;
import nce.a;

public final class WeishiReportUtil$3
  implements Runnable
{
  public WeishiReportUtil$3(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, RecentBaseData paramRecentBaseData, int paramInt) {}
  
  public void run()
  {
    this.val$app.b().a(this.c.frienduin, this.c.istroop, this.c.uniseq, "extLong", Integer.valueOf(this.c.extLong));
    if (this.c.structingMsg == null) {
      this.c.parse();
    }
    String str = new nce.a(null, null, null, null).a("folder_status", kya.e(this.c)).a("algorithm_id", kya.d(this.c)).a("reddot_style", kya.a(this.a)).a("is_jump_to_video_content", Integer.valueOf(awit.Q(kxm.getAppRuntime()))).a("EnterType", kya.bj(this.aMK)).a().toJsonString();
    kya.j(kya.b(this.c), kya.c(this.c), "0X8009290", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.3
 * JD-Core Version:    0.7.0.1
 */