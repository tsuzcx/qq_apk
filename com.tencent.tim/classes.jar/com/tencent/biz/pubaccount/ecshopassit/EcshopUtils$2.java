package com.tencent.biz.pubaccount.ecshopassit;

import anqu;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kdm;
import kee;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tgh;
import tog;

public final class EcshopUtils$2
  implements Runnable
{
  public EcshopUtils$2(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    do
    {
      try
      {
        localObject1 = this.val$app;
        if (localObject1 == null) {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject1;
          int i;
          Object localObject3;
          Object localObject4;
          QLog.e("EcshopUtils", 1, QLog.getStackTraceString(localThrowable));
          return;
          i -= 1;
        }
      }
      finally
      {
        if (this.val$app.a() == null) {
          break label338;
        }
        this.val$app.a().h("3046055438", 1008, false);
      }
      i = this.val$app.a().A("3046055438", 1008);
      if (i != 0) {
        break;
      }
    } while (this.val$app.a() == null);
    this.val$app.a().h("3046055438", 1008, false);
    return;
    localObject1 = this.val$app.b().f("3046055438", 1008);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      i = ((List)localObject1).size() - 1;
      if (i >= 0)
      {
        localObject3 = (ChatMessage)((List)localObject1).get(i);
        localObject4 = kee.a((MessageRecord)localObject3);
        if ((localObject4 == null) || (((anqu)localObject4).dLY == 100)) {
          break label207;
        }
        localObject3 = kdm.a((ChatMessage)localObject3);
        if (localObject3 == null) {
          break label304;
        }
        tgh.a().a(new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject3));
      }
    }
    while (this.val$app.a() != null)
    {
      this.val$app.a().h("3046055438", 1008, false);
      return;
      label207:
      if (!(localObject3 instanceof MessageForArkApp)) {
        break label304;
      }
      localObject4 = kee.a((MessageRecord)localObject3);
      if ((localObject4 == null) || ("100".equals(((JSONObject)localObject4).optString("action_type")))) {
        break label304;
      }
      localObject3 = kdm.a((ChatMessage)localObject3);
      if (localObject3 == null) {
        break label304;
      }
      tgh.a().a(new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject3));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopUtils.2
 * JD-Core Version:    0.7.0.1
 */