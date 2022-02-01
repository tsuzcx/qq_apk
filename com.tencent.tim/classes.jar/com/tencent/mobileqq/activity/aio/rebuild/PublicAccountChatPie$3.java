package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import anqu;
import antz;
import anub;
import anvf;
import aqmr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kdm;
import kds;
import kds.a;
import kec;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import tlb;
import ycd;

public class PublicAccountChatPie$3
  implements Runnable
{
  public PublicAccountChatPie$3(ycd paramycd) {}
  
  public void run()
  {
    if (this.this$0.blA) {}
    kec localkec;
    do
    {
      return;
      this.this$0.blA = true;
      localkec = (kec)this.this$0.app.getBusinessHandler(88);
      localObject1 = this.this$0.app.b().f(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()) || (localkec == null));
    Object localObject1 = (ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1);
    Object localObject3 = ((ChatMessage)localObject1).getExtInfoFromExtStr("public_account_msg_id");
    Object localObject4 = ((ChatMessage)localObject1).getExtInfoFromExtStr("is_AdArrive_Msg");
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "enter qqgouwu aio msgId = " + (String)localObject3 + " hasAdver: " + (String)localObject4);
    }
    if ("1".equals(localObject4))
    {
      localObject3 = new kds.a();
      ((kds.a)localObject3).aId = 2;
      localObject3 = kds.a((kds.a)localObject3, (MessageRecord)localObject1);
      ((kds)this.this$0.app.getBusinessHandler(139)).a((kds.a)localObject3, null);
      if ((localObject1 instanceof MessageForStructing))
      {
        localObject1 = ((MessageForStructing)localObject1).structingMsg;
        if ((localObject1 instanceof StructMsgForGeneralShare))
        {
          localObject1 = ((StructMsgForGeneralShare)localObject1).mStructMsgItemLists;
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            localObject1 = ((List)localObject1).iterator();
            for (;;)
            {
              if (((Iterator)localObject1).hasNext())
              {
                localObject3 = (anqu)((Iterator)localObject1).next();
                if ((localObject3 instanceof antz))
                {
                  localObject3 = ((antz)localObject3).rz;
                  if ((localObject3 == null) || (((ArrayList)localObject3).isEmpty())) {
                    continue;
                  }
                  localObject3 = ((ArrayList)localObject3).iterator();
                  if (!((Iterator)localObject3).hasNext()) {
                    continue;
                  }
                  localObject4 = (anqu)((Iterator)localObject3).next();
                  if (!(localObject4 instanceof anvf)) {
                    break;
                  }
                  try
                  {
                    tlb.a(1, 2, kdm.a((anqu)localObject4));
                  }
                  catch (Throwable localThrowable2)
                  {
                    QLog.e(this.this$0.TAG, 1, localThrowable2, new Object[0]);
                  }
                  continue;
                }
                if ((localThrowable2 instanceof anub)) {
                  localObject1 = (anub)localThrowable2;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        tlb.a(1, 2, kdm.a((anqu)localObject1));
        int i = this.this$0.mActivity.getIntent().getIntExtra("jump_from", 4);
        if (i != 2) {
          break;
        }
        localkec.a(134243865, this.this$0.sessionInfo.aTl, null, null, null, i, false);
        return;
      }
      catch (Throwable localThrowable1)
      {
        QLog.e(this.this$0.TAG, 1, localThrowable1, new Object[0]);
        continue;
      }
      if ((localThrowable1 instanceof MessageForArkApp))
      {
        JSONObject localJSONObject;
        try
        {
          Object localObject2 = ((MessageForArkApp)localThrowable1).ark_app_message;
          if (localObject2 == null) {
            continue;
          }
          localObject2 = ((ArkAppMessage)localObject2).metaList;
          if (aqmr.isEmpty((String)localObject2)) {
            continue;
          }
          localJSONObject = new JSONObject((String)localObject2).optJSONObject("gdt");
          localObject2 = new qq_ad_get.QQAdGetRsp.AdInfo();
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).report_info.trace_info.aid.set(Long.parseLong(localJSONObject.optString("aid")));
          localJSONObject = localJSONObject.optJSONObject("thirdparty_monitor_urls");
          if (localJSONObject == null) {
            continue;
          }
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).report_info.thirdparty_monitor_urls.api_click_monitor_url.set(kec.jsonArrayToList(localJSONObject.optJSONArray("api_click_monitor_url")));
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(kec.jsonArrayToList(localJSONObject.optJSONArray("api_exposure_monitor_url")));
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).report_info.thirdparty_monitor_urls.sdk_click_monitor_url.set(kec.jsonArrayToList(localJSONObject.optJSONArray("sdk_click_monitor_url")));
          ((qq_ad_get.QQAdGetRsp.AdInfo)localObject2).report_info.thirdparty_monitor_urls.sdk_exposure_monitor_url.set(kec.jsonArrayToList(localJSONObject.optJSONArray("sdk_exposure_monitor_url")));
          tlb.a(1, 2, (qq_ad_get.QQAdGetRsp.AdInfo)localObject2);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        continue;
        if ((localException instanceof MessageForArkApp)) {
          localkec.a(134243863, localException.senderuin, localJSONObject, null, null, 0L, false);
        } else {
          localkec.a(134243857, localException.senderuin, localJSONObject, null, null, 0L, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.3
 * JD-Core Version:    0.7.0.1
 */