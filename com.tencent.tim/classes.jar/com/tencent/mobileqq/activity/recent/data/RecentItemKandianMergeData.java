package com.tencent.mobileqq.activity.recent.data;

import acbn;
import acja;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import anqu;
import anqv;
import awit;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kbp;
import kxm;
import kys;
import lbz;
import lcd;
import mqq.app.AppRuntime;
import obt;
import ocp;
import org.json.JSONObject;
import wna;

public class RecentItemKandianMergeData
  extends RecentUserBaseData
{
  public static final int NEW_EXPOSURE_BIT = 536870912;
  public static final int OLD_EXPOSURE_BIT = 1;
  private static String TAG = "RecentItemKandianMergeData";
  
  public RecentItemKandianMergeData(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
    if (awit.N(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
    for (this.mUnreadFlag = 1;; this.mUnreadFlag = 2)
    {
      this.mExtraInfoColor = BaseApplicationImpl.getApplication().getResources().getColor(2131167410);
      return;
    }
  }
  
  private void d(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (!awit.T(paramQQAppInterface)) {}
    while ((paramMessageRecord.isread) || ((paramMessageRecord.extLong & 0x20000000) == 0)) {
      return;
    }
    long l = NetConnInfoCenter.getServerTime();
    this.mUser.lastmsgtime = l;
    ThreadManager.executeOnSubThread(new RecentItemKandianMergeData.1(this, paramQQAppInterface, paramMessageRecord, l));
    kbp.a(null, "CliOper", "", "", "", "0X80089F5", 0, 0, String.valueOf(this.mPosition + 1), "", "", "", false);
    QLog.d(TAG, 2, "no real exposure, try to setTopForUnExposureRedPnt!");
  }
  
  private void g(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = ((lcd)paramAppRuntime.getManager(163)).b();
    paramAppRuntime.qr(0);
    paramAppRuntime.qr(56);
    paramAppRuntime.qs(40677);
    if (kys.du(kys.getChannelId())) {
      lbz.a().qr(kys.getChannelId());
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    Object localObject1;
    QQMessageFacade.Message localMessage;
    MessageRecord localMessageRecord;
    do
    {
      do
      {
        do
        {
          return;
          super.c(paramQQAppInterface, paramContext);
          localObject1 = paramQQAppInterface.b();
        } while (localObject1 == null);
        localMessage = ((QQMessageFacade)localObject1).a(this.mUser.uin, this.mUser.getType());
      } while (localMessage == null);
      localMessageRecord = ((QQMessageFacade)localObject1).d(this.mUser.uin, this.mUser.getType());
    } while (localMessageRecord == null);
    if ((localMessageRecord instanceof MessageForStructing))
    {
      localObject1 = (MessageForStructing)localMessageRecord;
      if (((MessageForStructing)localObject1).structingMsg == null) {
        ((MessageForStructing)localObject1).parse();
      }
    }
    for (;;)
    {
      this.mAuthenIconId = 0;
      MsgSummary localMsgSummary;
      if (awit.N(BaseApplicationImpl.getApplication().getRuntime()) == 1)
      {
        this.mUnreadFlag = 1;
        this.mTitleName = obt.c(paramQQAppInterface, paramContext);
        localMsgSummary = a();
        localMsgSummary.strContent = "";
        if ((localMessageRecord.extInt != 1) && (localMessageRecord.extInt != 3)) {
          break label791;
        }
        if (localObject1 == null) {
          break label778;
        }
        if (((MessageForStructing)localObject1).structingMsg == null) {
          break label765;
        }
        localMsgSummary.strContent = ((MessageForStructing)localObject1).structingMsg.mMsgBrief;
      }
      for (;;)
      {
        this.mUnreadNum = 0;
        if ((localMessageRecord.extInt != 1) || (localMessageRecord.isread)) {
          break label1359;
        }
        this.mUnreadNum = 1;
        label222:
        this.mMsgExtroInfo = "";
        if (this.mUnreadNum <= 0) {
          break label1643;
        }
        if (localMessageRecord.extInt != 1) {
          break label1444;
        }
        if (localObject1 == null) {
          break label1435;
        }
        if ((((MessageForStructing)localObject1).structingMsg == null) || (TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mOrangeWord))) {
          break label1426;
        }
        this.mMsgExtroInfo = ("[" + ((MessageForStructing)localObject1).structingMsg.mOrangeWord + "] ");
        label306:
        if ((awit.N(BaseApplicationImpl.getApplication().getRuntime()) == 1) && (this.mUnreadNum == 1))
        {
          if (!TextUtils.isEmpty(localMsgSummary.strPrefix)) {
            break label1652;
          }
          localMsgSummary.strContent = TextUtils.concat(new CharSequence[] { this.mMsgExtroInfo, localMsgSummary.strContent });
          label365:
          this.mMsgExtroInfo = "";
        }
        d(localMessageRecord, paramQQAppInterface);
        this.mDisplayTime = this.mUser.lastmsgtime;
        if ((TextUtils.isEmpty(localMsgSummary.strContent)) && (TextUtils.isEmpty(localMsgSummary.strPrefix)) && (TextUtils.isEmpty(localMsgSummary.suffix)) && (TextUtils.isEmpty(this.mMsgExtroInfo)))
        {
          if (QLog.isColorLevel())
          {
            QLog.i(TAG, 2, localMessage.getBaseInfoString() + ",isread:" + localMessage.isread + ",issend:" + localMessage.issend + ",extInt:" + localMessage.extInt + ",extLong:" + localMessage.extLong);
            QLog.i(TAG, 2, localMessageRecord.getBaseInfoString() + ",isread:" + localMessageRecord.isread + ",issend:" + localMessageRecord.issend + ",extInt:" + localMessageRecord.extInt + ",extLong:" + localMessageRecord.extLong);
          }
          localMsgSummary.strContent = paramQQAppInterface.getApp().getResources().getString(2131697442);
        }
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (AppSetting.enableTalkBack)
        {
          paramContext = new StringBuilder();
          paramContext.append(this.mTitleName).append(",");
          if (!TextUtils.isEmpty(this.mMsgExtroInfo)) {
            paramContext.append(this.mMsgExtroInfo).append(",");
          }
          if (!TextUtils.isEmpty(this.mLastMsg)) {
            paramContext.append(this.mLastMsg).append(",");
          }
          if (!TextUtils.isEmpty(this.mShowTime)) {
            paramContext.append(this.mShowTime);
          }
          this.mContentDesc = paramContext.toString();
        }
        g(paramQQAppInterface);
        return;
        if (localMessageRecord.vipBubbleID == -1000L) {}
        for (i = 1;; i = 2)
        {
          this.mUnreadFlag = i;
          break;
        }
        label765:
        QLog.w(TAG, 2, "KANDIAN_REAL_MSG or KANDIAN_FAKE_MSG, structing.structingMsg null");
        continue;
        label778:
        localMsgSummary.strContent = localMessageRecord.msg;
        continue;
        label791:
        if ((localMessageRecord.extInt == 5) || (localMessageRecord.extInt == 6) || ((localMessageRecord.extInt == 2) && (TextUtils.equals(localMessageRecord.senderuin, acbn.blw))))
        {
          localMsgSummary.strContent = localMessageRecord.msg;
        }
        else
        {
          if (!ocp.f(paramQQAppInterface, localMessageRecord.senderuin, localMessage.msgtype)) {
            break label880;
          }
          localMsgSummary.strContent = "";
          localMsgSummary.suffix = "";
        }
      }
      label880:
      a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
      int i = localMessage.msgtype;
      Object localObject4;
      Object localObject3;
      if ((i == -3006) || (i == -5004))
      {
        localMsgSummary.suffix = "";
        localMsgSummary.strContent = "";
        localObject4 = wna.a(localMessage);
        if ((localObject4 != null) && (((PAMessage)localObject4).items != null) && (((PAMessage)localObject4).items.size() != 0))
        {
          localObject3 = ((PAMessage.Item)((PAMessage)localObject4).items.get(0)).title;
          if ((((PAMessage.Item)((PAMessage)localObject4).items.get(0)).cover != null) || (((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList == null)) {
            break label1335;
          }
          localObject3 = (String)localObject3 + "：" + (String)((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList.get(0);
          label1065:
          localMsgSummary.strContent = ((CharSequence)localObject3);
        }
      }
      label1168:
      if (((TextUtils.isEmpty(localMsgSummary.strContent)) && (TextUtils.isEmpty(localMsgSummary.suffix))) || (TextUtils.equals(localMsgSummary.a(paramContext), AbsStructMsg.PA_DEFAULT_MSG_BRIEF)))
      {
        i = 1;
        label1111:
        if ((i != 0) && (localObject1 != null) && (((MessageForStructing)localObject1).structingMsg != null) && ((((MessageForStructing)localObject1).structingMsg instanceof AbsStructMsg)))
        {
          localObject3 = ((AbsShareMsg)((MessageForStructing)localObject1).structingMsg).getStructMsgItemLists();
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            i = 0;
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (anqu)((Iterator)localObject3).next();
              if (!(localObject4 instanceof anqv)) {
                break label1682;
              }
              localObject4 = ((anqv)localObject4).rz.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                anqu localanqu = (anqu)((Iterator)localObject4).next();
                if ((localanqu instanceof StructMsgItemTitle))
                {
                  localMsgSummary.strContent = ((StructMsgItemTitle)localanqu).getText();
                  localMsgSummary.suffix = "";
                  i = 1;
                }
              }
            }
          }
        }
      }
      label1682:
      for (;;)
      {
        if (i != 0)
        {
          if ((localMessageRecord.extInt != 2) || (TextUtils.isEmpty(localMessageRecord.senderuin))) {
            break;
          }
          localObject3 = ((acja)paramQQAppInterface.getManager(56)).b(localMessageRecord.senderuin);
          if ((localObject3 == null) || (TextUtils.isEmpty(((PublicAccountInfo)localObject3).name))) {
            break label1346;
          }
          localMsgSummary.strPrefix = ((PublicAccountInfo)localObject3).name;
          break;
          label1335:
          break label1065;
          i = 0;
          break label1111;
        }
        break label1168;
        label1346:
        localMsgSummary.strPrefix = localMessageRecord.senderuin;
        break;
        label1359:
        if (localMessageRecord.extInt == 2)
        {
          if (localMessageRecord.isread) {}
          for (i = 0;; i = 1)
          {
            this.mUnreadNum = i;
            break;
          }
        }
        if (((localMessageRecord.extInt != 5) && (localMessageRecord.extInt != 6)) || (localMessageRecord.isread)) {
          break label222;
        }
        this.mUnreadNum = 1;
        break label222;
        label1426:
        this.mMsgExtroInfo = "";
        break label306;
        label1435:
        this.mMsgExtroInfo = "";
        break label306;
        label1444:
        if ((localMessageRecord.extInt == 2) && (!TextUtils.equals(localMessageRecord.senderuin, acbn.blw)))
        {
          if (!ocp.f(paramQQAppInterface, localMessage.senderuin, localMessage.msgtype)) {}
          this.mMsgExtroInfo = "";
          break label306;
        }
        if ((localMessageRecord.extInt != 5) && (localMessageRecord.extInt != 6) && ((localMessageRecord.extInt != 2) || (!TextUtils.equals(localMessageRecord.senderuin, acbn.blw)) || (TextUtils.isEmpty(localMessageRecord.extStr)))) {
          break label306;
        }
        localObject3 = null;
        try
        {
          localObject4 = new JSONObject(localMessage.extStr);
          localObject1 = localObject3;
          if (((JSONObject)localObject4).has(KandianMergeManager.aek)) {
            localObject1 = ((JSONObject)localObject4).getString(KandianMergeManager.aek);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            localObject2 = localObject3;
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label306;
        }
        this.mMsgExtroInfo = ("[" + (String)localObject1 + "]");
        break label306;
        label1643:
        this.mMsgExtroInfo = "";
        break label306;
        label1652:
        localMsgSummary.strPrefix = TextUtils.concat(new CharSequence[] { this.mMsgExtroInfo, localMsgSummary.strPrefix });
        break label365;
      }
      continue;
      Object localObject2 = null;
    }
  }
  
  public long eK()
  {
    Object localObject = (QQAppInterface)kxm.getAppRuntime();
    if (localObject == null) {
      return super.eK();
    }
    localObject = ((QQAppInterface)localObject).b();
    if (localObject != null)
    {
      localObject = ((QQMessageFacade)localObject).d(this.mUser.uin, this.mUser.getType());
      if (localObject == null) {
        return super.eK();
      }
      if ((localObject instanceof MessageForStructing))
      {
        localObject = (MessageForStructing)localObject;
        if (((MessageForStructing)localObject).structingMsg == null) {
          ((MessageForStructing)localObject).parse();
        }
      }
      kxm.aMx = kxm.nO();
    }
    return super.eK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData
 * JD-Core Version:    0.7.0.1
 */