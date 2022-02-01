package com.tencent.biz.pubaccount.readinjoy.common;

import acbn;
import android.text.TextUtils;
import awit;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import kbp;
import kct;
import kxm;
import lka;
import org.json.JSONException;
import org.json.JSONObject;

public final class ReadInJoyUtils$17
  implements Runnable
{
  public ReadInJoyUtils$17(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    int i;
    String str4;
    label26:
    Object localObject2;
    Object localObject1;
    if (this.a == null)
    {
      i = 1;
      if (i != 3) {
        break label73;
      }
      str4 = this.a.red_content.get();
      localObject2 = "";
      if (awit.aMH()) {
        break label826;
      }
      localObject1 = this.val$app.b();
      if (localObject1 != null) {
        break label80;
      }
    }
    label901:
    for (;;)
    {
      return;
      if (this.a.red_type.get() == 5)
      {
        i = 3;
        break;
      }
      i = 2;
      break;
      label73:
      str4 = "0";
      break label26;
      label80:
      localObject2 = ((QQMessageFacade)localObject1).d(acbn.blx, 7220);
      if (localObject2 != null)
      {
        if ((kxm.a.c != null) && (kxm.a.c.time >= ((MessageRecord)localObject2).time)) {
          localObject2 = kxm.a.c;
        }
        for (;;)
        {
          if ((((MessageRecord)localObject2).isread) || ((((MessageRecord)localObject2).extInt != 1) && (((MessageRecord)localObject2).extInt != 2) && (((MessageRecord)localObject2).extInt != 5) && (((MessageRecord)localObject2).extInt != 6)) || ((((MessageRecord)localObject2).extLong & 0x1) == 0)) {
            break label901;
          }
          ((MessageRecord)localObject2).extLong ^= 0x1;
          try
          {
            if (TextUtils.isEmpty(((MessageRecord)localObject2).extStr)) {
              break label793;
            }
            localObject1 = new JSONObject(((MessageRecord)localObject2).extStr);
            label223:
            ((JSONObject)localObject1).put("sp_last_kadnian_red_pnt_exposure_time_key", NetConnInfoCenter.getServerTime());
            ((MessageRecord)localObject2).extStr = ((JSONObject)localObject1).toString();
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
            }
          }
          this.val$app.b().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, "extLong", Integer.valueOf(((MessageRecord)localObject2).extLong));
          this.val$app.b().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, "extStr", ((MessageRecord)localObject2).extStr);
          kxm.a(this.val$app, (MessageRecord)localObject2);
          String str3;
          if (((MessageRecord)localObject2).extInt == 5)
          {
            localObject1 = ((KandianMergeManager)this.val$app.getManager(162)).a();
            if (localObject1 != null)
            {
              str3 = String.valueOf(((KandianMsgBoxRedPntInfo)localObject1).mMsgType);
              localObject1 = String.valueOf(((KandianMsgBoxRedPntInfo)localObject1).mUin);
            }
          }
          for (;;)
          {
            Object localObject4 = ((MessageRecord)localObject2).senderuin;
            try
            {
              JSONObject localJSONObject2 = new JSONObject(((MessageRecord)localObject2).extStr);
              localObject2 = localObject4;
              if (localJSONObject2.has("kdUin")) {
                localObject2 = localJSONObject2.getString("kdUin");
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                localException3.printStackTrace();
                localObject3 = localObject4;
              }
            }
            if (kxm.a.aRV == 1) {
              break;
            }
            kxm.mD(String.valueOf(System.currentTimeMillis()));
            kxm.ta = System.currentTimeMillis() / 1000L;
            for (;;)
            {
              try
              {
                localObject4 = new JSONObject();
                ((JSONObject)localObject4).put("folder_status", kxm.a.aRV);
                ((JSONObject)localObject4).put("algorithm_id", kxm.a.aeN);
                ((JSONObject)localObject4).put("strategy_id", kxm.a.ahf);
                ((JSONObject)localObject4).put("time", System.currentTimeMillis());
                if (kxm.a.aRV == 6)
                {
                  ((JSONObject)localObject4).put("id", str3);
                  ((JSONObject)localObject4).put("social_uin", localObject1);
                }
                if (!kxm.AM()) {
                  continue;
                }
                j = 1;
                ((JSONObject)localObject4).put("message_status", j);
                if (awit.N(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
                  continue;
                }
                j = 1;
                ((JSONObject)localObject4).put("reddot_style", j);
                ((JSONObject)localObject4).put("tab_status", i);
                ((JSONObject)localObject4).put("kandian_mode_new", kct.nd());
                if (i == 3) {
                  ((JSONObject)localObject4).put("reddot_num", str4);
                }
                kbp.a(null, "CliOper", "", (String)localObject2, "0X80091DC", "0X80091DC", 0, 0, "0", kxm.ey(kxm.a.Wz), kxm.a.ahf, ((JSONObject)localObject4).toString(), false);
                if (awit.Vs()) {
                  kxm.a(20, kxm.ey(kxm.a.Wz), kxm.a.ahf, kxm.a.aeN, (String)localObject2, kxm.a.aRV);
                }
                ((KandianMergeManager)this.val$app.getManager(162)).aIB();
                if (kxm.a.aRV != 6) {
                  continue;
                }
                QLog.d("ReadInJoyUtils", 1, "feedsPreload, social num red point, do not preload.");
              }
              catch (JSONException localJSONException)
              {
                int j;
                label793:
                JSONObject localJSONObject1;
                Object localObject3;
                label826:
                String str1;
                localJSONException.printStackTrace();
                QLog.d("ReadInJoyUtils", 1, "red point expose, e = ", localJSONException);
                continue;
              }
              if (this.a == null) {
                break;
              }
              try
              {
                localObject1 = kxm.v();
                ((JSONObject)localObject1).put("kandian_mode", kxm.nR());
                ((JSONObject)localObject1).put("tab_source", kxm.nQ());
                kbp.a(null, "CliOper", "", null, "0X80081C6", "0X80081C6", 0, 1, null, null, null, ((JSONObject)localObject1).toString(), false);
                return;
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
                return;
              }
              localJSONObject1 = new JSONObject();
              break label223;
              if (i == 1) {
                break;
              }
              str1 = "";
              str3 = "";
              continue;
              j = 0;
              continue;
              j = 0;
              continue;
              QLog.d("ReadInJoyUtils", 1, "feedsPreload, small red point exposed.");
              lka.a().nD(true);
            }
            String str2 = "";
            str3 = "";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.17
 * JD-Core Version:    0.7.0.1
 */