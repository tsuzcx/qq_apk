package com.tencent.mobileqq.gamecenter.web;

import adak;
import ahtz;
import ahua;
import android.text.TextUtils;
import anqu;
import anqv;
import ansr;
import anug;
import anux;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.gamecenter.data.FullPopData;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import obj;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGameMsgInfo
  implements Serializable
{
  public static final int MSG_TYPE_ARK = 1;
  public static final int MSG_TYPE_IMGHEADER = 2;
  public static final int MSG_TYPE_TEXTHEADER = 3;
  public String actionUrl;
  public String advId;
  public String arkAppConfig;
  public String arkAppMinVersion;
  public String arkAppName;
  public String arkAppView;
  public String arkMetaList;
  public String contentText;
  public String coverUrl;
  public String dateTitle;
  public String extJson;
  public String frienduin;
  public FullPopData fullPopData;
  public String gameAppId;
  public String limitText;
  public long msgTime;
  public int msgType;
  public String paMsgid;
  public String sortedConfigs;
  public String taskId;
  public String title;
  public long uniseq;
  public String url;
  
  private static void a(MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo)
  {
    paramQQGameMsgInfo.msgType = 3;
    if (!(paramMessageRecord instanceof MessageForStructing)) {}
    do
    {
      return;
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
    } while (!(paramMessageRecord.structingMsg instanceof StructMsgForGeneralShare));
    paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord.structingMsg;
    anug localanug = (anug)((ArrayList)paramMessageRecord.getStructMsgItemLists()).get(1);
    paramQQGameMsgInfo.url = paramMessageRecord.mMsgUrl;
    paramQQGameMsgInfo.title = ((anux)localanug.rz.get(1)).text;
    paramQQGameMsgInfo.dateTitle = ((anux)localanug.rz.get(0)).text;
    paramQQGameMsgInfo.contentText = ((anux)localanug.rz.get(2)).text;
    paramQQGameMsgInfo.limitText = ((anux)localanug.rz.get(3)).text;
  }
  
  private static void b(MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo)
  {
    paramQQGameMsgInfo.msgType = 2;
    if (!(paramMessageRecord instanceof MessageForStructing)) {}
    label40:
    label181:
    label222:
    do
    {
      return;
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        paramMessageRecord = (ArrayList)((StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg).getStructMsgItemLists();
        int m = 0;
        ArrayList localArrayList;
        int n;
        int j;
        if (m < paramMessageRecord.size()) {
          if ((paramMessageRecord.get(m) instanceof anqv))
          {
            localArrayList = ((anqv)paramMessageRecord.get(m)).rz;
            n = 0;
            j = 0;
          }
        }
        int k;
        for (int i = 0;; i = k)
        {
          int i1 = j;
          k = i;
          if (n < localArrayList.size())
          {
            if (!(localArrayList.get(n) instanceof StructMsgItemTitle)) {
              break label181;
            }
            paramQQGameMsgInfo.title = ((StructMsgItemTitle)localArrayList.get(n)).text;
            k = 1;
          }
          for (;;)
          {
            if ((k == 0) || (j == 0)) {
              break label222;
            }
            i1 = j;
            paramQQGameMsgInfo.url = ((anqu)paramMessageRecord.get(m)).ku;
            if ((k != 0) && (i1 != 0)) {
              break;
            }
            m += 1;
            break label40;
            break;
            k = i;
            if ((localArrayList.get(n) instanceof ansr))
            {
              paramQQGameMsgInfo.coverUrl = ((ansr)localArrayList.get(n)).aNt;
              j = 1;
              k = i;
            }
          }
          n += 1;
        }
      }
    } while (!(paramMessageRecord instanceof MessageForPubAccount));
    paramMessageRecord = (MessageForPubAccount)paramMessageRecord;
    paramMessageRecord.mPAMessage = obj.a(paramMessageRecord.msgData);
    paramQQGameMsgInfo.coverUrl = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).cover;
    paramQQGameMsgInfo.title = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).title;
    paramQQGameMsgInfo.url = ((PAMessage.Item)paramMessageRecord.mPAMessage.items.get(0)).url;
  }
  
  private static void c(MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo)
  {
    paramQQGameMsgInfo.msgType = 1;
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
    }
    try
    {
      paramQQGameMsgInfo.arkAppMinVersion = paramMessageRecord.ark_app_message.appMinVersion;
      paramQQGameMsgInfo.arkAppName = paramMessageRecord.ark_app_message.appName;
      paramQQGameMsgInfo.arkAppView = paramMessageRecord.ark_app_message.appView;
      paramQQGameMsgInfo.arkMetaList = paramMessageRecord.ark_app_message.metaList;
      return;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.e("QQGameMsgInfo", 1, "MessageForArkApp error =" + paramMessageRecord.toString());
    }
  }
  
  public static QQGameMsgInfo parseMessageRecord(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameMsgInfo", 1, "parseMessageRecord-->record is null");
      }
      return null;
    }
    QQGameMsgInfo localQQGameMsgInfo = new QQGameMsgInfo();
    localQQGameMsgInfo.uniseq = paramMessageRecord.uniseq;
    localQQGameMsgInfo.frienduin = paramMessageRecord.frienduin;
    localQQGameMsgInfo.msgTime = paramMessageRecord.time;
    parseQGameInfo(paramMessageRecord, localQQGameMsgInfo);
    localQQGameMsgInfo.fullPopData = ahua.a(paramMessageRecord);
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      c(paramMessageRecord, localQQGameMsgInfo);
      return localQQGameMsgInfo;
    }
    if ((paramMessageRecord instanceof MessageForStructing)) {}
    for (;;)
    {
      int n;
      int i1;
      try
      {
        localArrayList1 = (ArrayList)((StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg).getStructMsgItemLists();
        if (localArrayList1 != null) {
          break label306;
        }
        return null;
      }
      catch (Throwable paramMessageRecord)
      {
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        QLog.e("QQGameMsgInfo", 1, "createHeader failed structMsg error=" + paramMessageRecord.toString());
      }
      if (n < localArrayList1.size())
      {
        if (!(localArrayList1.get(n) instanceof anqv)) {
          break label327;
        }
        localArrayList2 = ((anqv)localArrayList1.get(n)).rz;
        k = i;
        i = j;
        i1 = 0;
        j = k;
        k = j;
        m = i;
        if (i1 >= localArrayList2.size()) {
          break label332;
        }
        if ((localArrayList2.get(i1) instanceof StructMsgItemTitle))
        {
          k = 1;
          if ((k != 0) && (j != 0))
          {
            b(paramMessageRecord, localQQGameMsgInfo);
            return localQQGameMsgInfo;
          }
        }
        else
        {
          k = i;
          if (!(localArrayList2.get(i1) instanceof ansr)) {
            continue;
          }
          j = 1;
          k = i;
          continue;
        }
      }
      else
      {
        if (localArrayList1.size() == 2)
        {
          a(paramMessageRecord, localQQGameMsgInfo);
          return localQQGameMsgInfo;
        }
        return localQQGameMsgInfo;
        if ((paramMessageRecord instanceof MessageForPubAccount))
        {
          b(paramMessageRecord, localQQGameMsgInfo);
          return localQQGameMsgInfo;
        }
        return null;
        label306:
        n = 0;
        i = 0;
        j = 0;
        continue;
      }
      i1 += 1;
      int i = k;
      continue;
      label327:
      int m = j;
      int k = i;
      label332:
      n += 1;
      int j = m;
      i = k;
    }
  }
  
  public static void parseQGameInfo(MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo)
  {
    Object localObject2 = paramMessageRecord.extStr;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramMessageRecord.mExJsonObject.toString();
    }
    paramQQGameMsgInfo.paMsgid = ahtz.t(paramMessageRecord);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    do
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1).optString("report_key_bytes_oac_msg_extend", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramQQGameMsgInfo.advId = adak.jI((String)localObject1);
          localObject1 = new JSONObject((String)localObject1).optString("game_extra", "");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = new JSONObject((String)localObject1);
            localObject2 = ((JSONObject)localObject1).optJSONArray("sorted_configs");
            if (localObject2 != null)
            {
              paramQQGameMsgInfo.sortedConfigs = ((JSONArray)localObject2).toString();
              paramQQGameMsgInfo.gameAppId = ((JSONArray)localObject2).optJSONObject(0).optString("app_id", "");
              paramQQGameMsgInfo.taskId = ((JSONArray)localObject2).optJSONObject(1).optString("task_id", "");
            }
            paramQQGameMsgInfo.extJson = ((JSONObject)localObject1).optString("ext_json", "");
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("QQGameMsgInfo", 1, "get getGameMsgInfoByMsg  msg err= " + localThrowable.getMessage());
        }
      }
      if ((paramMessageRecord instanceof MessageForArkApp))
      {
        paramMessageRecord = (MessageForArkApp)paramMessageRecord;
        try
        {
          paramQQGameMsgInfo.gameAppId = paramMessageRecord.ark_app_message.mSourceName;
          paramQQGameMsgInfo.arkAppMinVersion = paramMessageRecord.ark_app_message.appMinVersion;
          paramQQGameMsgInfo.arkAppName = paramMessageRecord.ark_app_message.appName;
          paramQQGameMsgInfo.arkAppView = paramMessageRecord.ark_app_message.appView;
          paramQQGameMsgInfo.arkMetaList = paramMessageRecord.ark_app_message.metaList;
          paramQQGameMsgInfo.arkAppConfig = paramMessageRecord.ark_app_message.config;
          return;
        }
        catch (Throwable paramMessageRecord)
        {
          QLog.e("QQGameMsgInfo", 1, "MessageForArkApp error =" + paramMessageRecord.toString());
          return;
        }
      }
    } while (!(paramMessageRecord instanceof MessageForStructing));
    for (;;)
    {
      ArrayList localArrayList;
      int n;
      int j;
      int i;
      int i1;
      int m;
      try
      {
        paramMessageRecord = (StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg;
        localArrayList = (ArrayList)paramMessageRecord.getStructMsgItemLists();
        if (localArrayList == null) {
          break;
        }
        n = 0;
        j = 0;
        i = 0;
        if (n >= localArrayList.size()) {
          break label548;
        }
        if (!(localArrayList.get(n) instanceof anqv)) {
          break label581;
        }
        localObject2 = ((anqv)localArrayList.get(n)).rz;
        i1 = 0;
        k = j;
        m = i;
        if (i1 >= ((ArrayList)localObject2).size()) {
          break label587;
        }
        if ((((ArrayList)localObject2).get(i1) instanceof StructMsgItemTitle))
        {
          k = 1;
          if ((k == 0) || (j == 0)) {
            break label569;
          }
          paramQQGameMsgInfo.gameAppId = ahtz.lr(((anqu)localArrayList.get(n)).ku);
          return;
        }
      }
      catch (Throwable paramMessageRecord)
      {
        QLog.e("QQGameMsgInfo", 1, "createHeader failed structMsg error=" + paramMessageRecord.toString());
        return;
      }
      int k = i;
      if ((((ArrayList)localObject2).get(i1) instanceof ansr))
      {
        j = 1;
        k = i;
        continue;
        label548:
        if (localArrayList.size() != 2) {
          break;
        }
        paramQQGameMsgInfo.gameAppId = ahtz.lr(paramMessageRecord.mMsgUrl);
        return;
        label569:
        i1 += 1;
        i = k;
        continue;
        label581:
        m = i;
        k = j;
        label587:
        n += 1;
        i = m;
        j = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo
 * JD-Core Version:    0.7.0.1
 */