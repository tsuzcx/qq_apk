package com.tencent.biz.pubaccount.readinjoy.engine;

import acbn;
import acxw;
import anbi;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import anre;
import awit;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.DailyFloatingWindowData;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Calendar;
import kbp;
import kgw;
import kxm;
import lbn;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import ocp;
import org.json.JSONException;
import org.json.JSONObject;

public class KandianDailyManager
  implements Manager
{
  DailySetTopInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo;
  KandianRedDotInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
  QQAppInterface app;
  ReadInJoyUserInfoModule.a b = new lbn(this);
  
  public KandianDailyManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    paramQQAppInterface = kxm.a(paramQQAppInterface, "readinjoy_daily_settop_info_key", true);
    if ((paramQQAppInterface instanceof DailySetTopInfo))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo = ((DailySetTopInfo)paramQQAppInterface);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo = new DailySetTopInfo();
  }
  
  private MessageRecord a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)anbi.d(-2011);
    localMessageForStructing.msgtype = -2011;
    localMessageForStructing.structingMsg = anre.a();
    localMessageForStructing.structingMsg.mMsgServiceID = 142;
    localMessageForStructing.structingMsg.mMsgBrief = paramString2;
    localMessageForStructing.structingMsg.mOrangeWord = paramString1;
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("puinName", paramString3);
      localMessageForStructing.structingMsg.mExtraData = paramString1.toString();
      localMessageForStructing.selfuin = this.app.getCurrentUin();
      localMessageForStructing.frienduin = acbn.blP;
      localMessageForStructing.senderuin = acbn.blP;
      localMessageForStructing.istroop = 1008;
      localMessageForStructing.issend = 0;
      localMessageForStructing.isread = true;
      localMessageForStructing.extLong = 0;
      localMessageForStructing.time = paramLong;
      localMessageForStructing.createMessageUniseq();
      localMessageForStructing.saveExtInfoToExtStr("puin", paramString4);
      localMessageForStructing.doPrewrite();
      return localMessageForStructing;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static String a(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.msgtype != -2011)) {
      return "";
    }
    MessageForStructing localMessageForStructing2 = (MessageForStructing)paramMessage.lastMsg;
    MessageForStructing localMessageForStructing1 = localMessageForStructing2;
    if (localMessageForStructing2 == null)
    {
      localMessageForStructing1 = localMessageForStructing2;
      if (paramMessage.msgData != null)
      {
        localMessageForStructing1 = localMessageForStructing2;
        if (paramMessage.msgData.length > 0)
        {
          localMessageForStructing1 = new MessageForStructing();
          localMessageForStructing1.msgData = paramMessage.msgData;
        }
      }
    }
    return f(localMessageForStructing1);
  }
  
  public static void a(Context paramContext, boolean paramBoolean, Bundle paramBundle, int paramInt)
  {
    Object localObject1 = (QQAppInterface)kxm.getAppRuntime();
    kxm.b(acbn.blP, (QQAppInterface)kxm.getAppRuntime());
    KandianRedDotInfo localKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(((QQAppInterface)localObject1).b().d(acbn.blP, 1008), "kandian_daily_red_pnt");
    localObject1 = paramBundle;
    if (localKandianRedDotInfo != null)
    {
      localObject1 = paramBundle;
      if (localKandianRedDotInfo.hasArticleID())
      {
        localObject1 = paramBundle;
        if (paramBundle == null) {
          localObject1 = new Bundle();
        }
        ((Bundle)localObject1).putSerializable("kandian_feeds_red_pnt_info", localKandianRedDotInfo);
      }
    }
    QLog.d("KandianDailyManager", 1, "launch daily feeds, redPnt : " + localKandianRedDotInfo);
    paramBundle = (Bundle)localObject1;
    if (localKandianRedDotInfo != null)
    {
      paramBundle = (Bundle)localObject1;
      if (localKandianRedDotInfo.floatingWinData != null)
      {
        paramBundle = (Bundle)localObject1;
        if (localKandianRedDotInfo.floatingWinData.type != 0)
        {
          paramBundle = "";
          Object localObject2 = paramBundle;
          try
          {
            if (localKandianRedDotInfo.cookie != null)
            {
              JSONObject localJSONObject = new JSONObject(localKandianRedDotInfo.cookie);
              localObject2 = paramBundle;
              if (localJSONObject != null) {
                localObject2 = localJSONObject.optString("push_rowkey");
              }
            }
          }
          catch (JSONException localJSONException)
          {
            Bundle localBundle;
            for (;;)
            {
              QLog.d("KandianDailyManager", 2, localJSONException.getMessage());
              localBundle = paramBundle;
            }
            int i = localKandianRedDotInfo.floatingWinData.type;
            paramBundle = (Bundle)localObject1;
            if (localObject1 != null) {
              break label251;
            }
            paramBundle = new Bundle();
            paramBundle.putString("floating_window_rowkey", localBundle);
            paramBundle.putString("float_layer_article_url", localKandianRedDotInfo.floatingWinData.url);
            paramBundle.putString("float_layer_topic_id", localKandianRedDotInfo.floatingWinData.topicID);
            paramBundle.putInt("floating_window_scene", 1);
            paramBundle.putBoolean("open_floating_window", true);
            paramBundle.putInt("floating_window_business", i);
            localKandianRedDotInfo.floatingWinData.clear();
          }
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            QLog.d("KandianDailyManager", 1, "launchKandianDaily floating layer rowkey is null");
            return;
          }
        }
      }
    }
    label251:
    QLog.d("KandianDailyManager", 1, "launch daily feeds by default mode ; bundle " + paramBundle);
    kgw.a(paramContext, paramInt, paramBundle, paramBoolean);
  }
  
  public static void bV(Context paramContext)
  {
    a(paramContext, false, null, 5);
  }
  
  public static String f(MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing == null) {
      return "";
    }
    if (!paramMessageForStructing.mIsParsed) {
      paramMessageForStructing.parse();
    }
    if ((paramMessageForStructing.structingMsg == null) || (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mExtraData))) {
      return "";
    }
    try
    {
      paramMessageForStructing = new JSONObject(paramMessageForStructing.structingMsg.mExtraData).optString("puinName", "");
      return paramMessageForStructing;
    }
    catch (JSONException paramMessageForStructing)
    {
      paramMessageForStructing.printStackTrace();
    }
    return "";
  }
  
  public static String jc()
  {
    MessageRecord localMessageRecord = ((QQAppInterface)kxm.getAppRuntime()).b().d(acbn.blP, 1008);
    if ((localMessageRecord instanceof MessageForStructing)) {
      return f((MessageForStructing)localMessageRecord);
    }
    return "";
  }
  
  public KandianRedDotInfo a()
  {
    return KandianRedDotInfo.createRedDotFromMessageRecord(this.app.b().d(acbn.blP, 1008), "kandian_daily_red_pnt");
  }
  
  public MessageRecord a()
  {
    MessageRecord localMessageRecord = this.app.b().d(acbn.blP, 1008);
    if (kxm.e(localMessageRecord)) {
      return localMessageRecord;
    }
    return null;
  }
  
  public void aIu()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianDailyManager$DailySetTopInfo != null) {
      ThreadManager.executeOnSubThread(new KandianDailyManager.1(this));
    }
  }
  
  public KandianRedDotInfo b()
  {
    KandianRedDotInfo localKandianRedDotInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = null;
    return localKandianRedDotInfo;
  }
  
  public void h(ArticleInfo paramArticleInfo)
  {
    String str = ocp.a(paramArticleInfo, this.b);
    if (paramArticleInfo.msgBoxBriefPreFixType == 2) {}
    for (paramArticleInfo = paramArticleInfo.msgBoxBriefPreFix;; paramArticleInfo = null)
    {
      paramArticleInfo = a("", str, jc(), NetConnInfoCenter.getServerTime(), paramArticleInfo);
      kxm.b(acbn.blP, this.app);
      this.app.b().b(paramArticleInfo, this.app.getCurrentUin());
      return;
    }
  }
  
  public void k(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    paramMessageRecord.frienduin = acbn.blP;
    l(paramMessageRecord);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo = KandianRedDotInfo.createRedDotFromMessageRecord(paramMessageRecord, "kandian_daily_red_pnt");
    QLog.d("KandianDailyManager", 1, "receive lock screen msg : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo);
    ThreadManager.post(new KandianDailyManager.3(this), 8, null, false);
  }
  
  public void l(MessageRecord paramMessageRecord)
  {
    if (!(paramMessageRecord instanceof MessageForStructing)) {
      QLog.e("KandianDailyManager", 1, new Object[] { "receive new msg but not struct msg. type : ", paramMessageRecord.msgtype + ", msg : " + paramMessageRecord });
    }
    label202:
    do
    {
      return;
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if (!paramMessageRecord.mIsParsed) {
        paramMessageRecord.parse();
      }
      if (paramMessageRecord != null) {}
      try
      {
        if (paramMessageRecord.structingMsg != null)
        {
          Object localObject2 = new JSONObject(paramMessageRecord.structingMsg.mExtraData);
          localObject1 = ((JSONObject)localObject2).optString("cmd", "");
          String str = ((JSONObject)localObject2).optString("refreshMode", "");
          localObject2 = ((JSONObject)localObject2).optString("channelID", "");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            awit.abM((String)localObject1);
          }
          if (!TextUtils.isEmpty(str)) {
            awit.H("readinjoy_daily_mode_refresh_mode", str);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            QLog.d("KandianDailyManager", 1, "channelId: " + (String)localObject2);
            awit.H("readinjoy_daily_mode_channel_id", Integer.valueOf((String)localObject2));
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        break label202;
      }
    } while (paramMessageRecord.structingMsg == null);
    localObject1 = new StringBuilder("receive new msg : ");
    ((StringBuilder)localObject1).append("orange : ").append(paramMessageRecord.structingMsg.mOrangeWord).append(", ");
    ((StringBuilder)localObject1).append("brief  : ").append(paramMessageRecord.structingMsg.mMsgBrief).append(", ");
    ((StringBuilder)localObject1).append("actionData : ").append(paramMessageRecord.structingMsg.mMsgActionData).append(", ");
    ((StringBuilder)localObject1).append("extraData : ").append(paramMessageRecord.structingMsg.mExtraData);
    QLog.d("KandianDailyManager", 1, ((StringBuilder)localObject1).toString());
  }
  
  public void onDestroy() {}
  
  public static class DailySetTopInfo
    implements Serializable
  {
    public static long settopOffset = -1L;
    private long lastSetTopMsgTime;
    private long lastSetTopMsgUniseq = -1L;
    
    private boolean Bu()
    {
      if ((System.currentTimeMillis() / 1000L - ct() > settopOffset) && (settopOffset > 0L))
      {
        if (ct() > this.lastSetTopMsgTime)
        {
          QLog.d("KandianDailyManager", 1, "allow settop lastTime : " + this.lastSetTopMsgTime + ", offset : " + settopOffset);
          return true;
        }
        QLog.d("KandianDailyManager", 2, "one day only allow settop one ! " + this);
        return false;
      }
      QLog.d("KandianDailyManager", 2, "not reach time offset, give up ! " + this);
      return false;
    }
    
    private long ct()
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      return localCalendar.getTimeInMillis() / 1000L;
    }
    
    public String toString()
    {
      return "DailySetTopInfo{lastSetTopMsgUniseq=" + this.lastSetTopMsgUniseq + ", lastSetTopMsgTime=" + this.lastSetTopMsgTime + ", offset=" + settopOffset + '}';
    }
    
    public void trySetTopMsgNode(QQAppInterface paramQQAppInterface)
    {
      if (paramQQAppInterface == null) {}
      MessageRecord localMessageRecord;
      long l;
      acxw localacxw;
      RecentUser localRecentUser;
      do
      {
        do
        {
          do
          {
            return;
          } while (!Bu());
          localMessageRecord = paramQQAppInterface.b().d(acbn.blP, 1008);
          if ((localMessageRecord == null) || (localMessageRecord.isread) || (kxm.dB(acbn.blP)) || (localMessageRecord.uniseq == this.lastSetTopMsgUniseq)) {
            break;
          }
          l = NetConnInfoCenter.getServerTime();
          localacxw = paramQQAppInterface.a().a();
        } while (localacxw == null);
        localRecentUser = localacxw.b(acbn.blP, 1008);
      } while (localRecentUser == null);
      localRecentUser.lastmsgtime = l;
      paramQQAppInterface.b().a(acbn.blP, 1008, localMessageRecord.uniseq, "time", Long.valueOf(l));
      localacxw.e(localRecentUser);
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1009);
      }
      this.lastSetTopMsgUniseq = localMessageRecord.uniseq;
      this.lastSetTopMsgTime = ct();
      kxm.b("readinjoy_daily_settop_info_key", this, true);
      kbp.b(null, "CliOper", "", "", "0X8007927", "0X8007927", 0, 0, "", "", "", "");
      QLog.d("KandianDailyManager", 2, "successful setTop !  " + this);
      return;
      QLog.d("KandianDailyManager", 2, "give up setTop!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager
 * JD-Core Version:    0.7.0.1
 */