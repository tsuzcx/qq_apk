package com.tencent.mobileqq.profile;

import aldl;
import android.os.Handler;
import android.os.Message;
import anpc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import java.util.HashMap;

public class VipProfileCardBaseActivity$2$1
  implements Runnable
{
  public VipProfileCardBaseActivity$2$1(aldl paramaldl, Card paramCard, HashMap paramHashMap, String paramString) {}
  
  public void run()
  {
    boolean bool = this.a.this$0.a((int)this.c.lCurrentStyleId, (int)this.c.lCurrentBgId, this.c.backgroundUrl, (int)this.c.backgroundColor, this.c.templateRet);
    HashMap localHashMap = this.ms;
    if (bool) {}
    for (Object localObject = "0";; localObject = "-102")
    {
      localHashMap.put("param_FailCode", localObject);
      if (bool != true) {
        break;
      }
      anpc.a(this.a.this$0.app.getApp()).collectPerformance(this.val$uin, "profileCardSet", true, 0L, 0L, this.ms, "", false);
      localObject = this.a.this$0.mHandler.obtainMessage(5);
      this.a.this$0.mHandler.sendMessage((Message)localObject);
      return;
    }
    anpc.a(this.a.this$0.app.getApp()).collectPerformance(this.val$uin, "profileCardSet", false, 0L, 0L, this.ms, "", false);
    localObject = this.a.this$0.mHandler.obtainMessage(6);
    this.a.this$0.mHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardBaseActivity.2.1
 * JD-Core Version:    0.7.0.1
 */