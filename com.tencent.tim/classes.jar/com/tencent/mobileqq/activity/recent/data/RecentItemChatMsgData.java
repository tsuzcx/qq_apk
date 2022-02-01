package com.tencent.mobileqq.activity.recent.data;

import QQService.EVIPSPEC;
import acbn;
import acff;
import acfp;
import ackn;
import acle;
import acqh;
import aean;
import ahtc;
import ajdo;
import ajnn;
import ajoh;
import ajoq;
import alkm;
import alkm.a;
import anaz;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import aofy;
import aqft;
import aqgv;
import aqiu;
import asgx;
import augo;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatManager.b;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.mail.MailPluginRecentMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jqs;
import mqq.app.MobileQQ;
import syw;
import szd;
import szy;
import tas;
import tog;
import wvo;
import xva;
import xya;

public class RecentItemChatMsgData
  extends RecentUserBaseData
{
  public int haloState;
  public int mBubbleID;
  private boolean mIsSignMsg;
  public String mQimIconUrl;
  public int mQimOnline;
  
  public RecentItemChatMsgData(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
  }
  
  private void a(Context paramContext, QQMessageFacade.Message paramMessage, MessageForStructing paramMessageForStructing)
  {
    String str1 = paramMessageForStructing.structingMsg.mMsgBrief;
    String str2 = paramContext.getString(2131700656);
    if ((!paramMessageForStructing.isread) && (!TextUtils.isEmpty(str1))) {}
    for (this.mMsgExtroInfo = str2;; this.mMsgExtroInfo = "")
    {
      paramMessage.msg = str1;
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167463);
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage)
  {
    if (d(paramMessage))
    {
      paramQQAppInterface = (FeedsManager)paramQQAppInterface.getManager(275);
      paramMessage = paramQQAppInterface.getSummary(qx());
      if (!TextUtils.isEmpty(paramMessage))
      {
        this.msgSummary.strContent = paramMessage;
        this.mMsgExtroInfo = acfp.m(2131713673);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167383);
        if (!FeedsManager.isShowStatus(qx())) {
          FeedsManager.showStatus(qx());
        }
        paramQQAppInterface.reportExposeStatus(qx());
      }
    }
    else
    {
      return;
    }
    FeedsManager.hideStatus(qx());
  }
  
  private boolean a(acff paramacff, String paramString)
  {
    if ((paramacff == null) || (TextUtils.isEmpty(paramString))) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return false;
        paramacff = paramacff.b(paramString);
      } while ((paramacff == null) || (!paramacff.isFriend()));
      bool1 = paramacff.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      bool2 = paramacff.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  private boolean d(QQMessageFacade.Message paramMessage)
  {
    return (this.mUser.getType() == 0) && (TextUtils.isEmpty(this.mMsgExtroInfo)) && (wU() <= 0) && (this.mStatus == 0) && (this.msgSummary.nState == 0) && ((paramMessage == null) || (paramMessage.msgtype != -5040)) && (this.msgSummary.suffix == null) && (this.msgSummary.strPrefix == null);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade paramQQMessageFacade, QQMessageFacade.Message paramMessage) {}
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.c(paramQQAppInterface, paramContext);
    this.mIsSignMsg = false;
    QQMessageFacade.Message localMessage = null;
    Object localObject4 = paramQQAppInterface.b();
    if (localObject4 != null) {
      localMessage = ((QQMessageFacade)localObject4).a(this.mUser.uin, this.mUser.getType());
    }
    Object localObject1 = paramQQAppInterface.a();
    label115:
    MsgSummary localMsgSummary;
    Object localObject2;
    if ((localObject1 != null) && (localMessage != null))
    {
      this.mUnreadNum = ((tog)localObject1).A(localMessage.frienduin, localMessage.istroop);
      if (this.mUnreadNum <= 0) {
        break label724;
      }
      this.mBubbleID = ((acle)paramQQAppInterface.getBusinessHandler(13)).j(localMessage);
      if (localMessage != null)
      {
        localObject1 = alkm.a(paramQQAppInterface, localMessage.frienduin, localMessage.istroop, this.mUnreadNum, localMessage);
        this.mUnreadNum += ((alkm.a)localObject1).HF();
        if (((alkm.a)localObject1).HF() > 0)
        {
          this.mMsgExtroInfo = ((alkm.a)localObject1).xZ();
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
        }
      }
      FeedsManager.hideStatus(qx());
      localMsgSummary = a();
      localObject2 = null;
    }
    label464:
    Object localObject3;
    label510:
    int i;
    switch (this.mUser.getType())
    {
    default: 
      localObject1 = localObject2;
    case 9501: 
    case 1008: 
    case 8001: 
      for (;;)
      {
        bI(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        if ((!localMsgSummary.bShowDraft) || (!this.mIsSignMsg)) {
          break label3932;
        }
        localMsgSummary.strContent = "";
        this.mMsgExtroInfo = "";
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (!AppSetting.enableTalkBack) {
          break label4043;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.mTitleName).append(",");
        if (this.mUnreadNum != 0) {
          break label3943;
        }
        if (this.mMsgExtroInfo != null) {
          ((StringBuilder)localObject3).append(this.mMsgExtroInfo + ",");
        }
        localObject2 = aofy.og(this.mLastMsg.toString());
        paramContext = (Context)localObject2;
        if (localMessage != null)
        {
          paramContext = (Context)localObject2;
          if (localMessage.msgtype == -5040)
          {
            paramContext = (Context)localObject2;
            if (ajoq.b(paramQQAppInterface, localMessage)) {
              paramContext = ajoq.mo((String)localObject2);
            }
          }
        }
        ((StringBuilder)localObject3).append(paramContext).append(",").append(this.mShowTime);
        if ((this.mUser.getType() != 0) || (!((acff)localObject1).isFriend(this.mUser.uin))) {
          break label4034;
        }
        paramQQAppInterface = ajnn.a(paramQQAppInterface, this.mUser.uin, false, 5);
        if (paramQQAppInterface == null) {
          break label4034;
        }
        paramQQAppInterface = paramQQAppInterface.iterator();
        for (;;)
        {
          if (!paramQQAppInterface.hasNext()) {
            break label4034;
          }
          paramContext = (ajoh)paramQQAppInterface.next();
          if (TextUtils.isEmpty(paramContext.aSQ)) {
            break;
          }
          ((StringBuilder)localObject3).append(paramContext.aSQ).append(",");
        }
        this.mUnreadNum = 0;
        break;
        this.mBubbleID = 0;
        break label115;
        localObject1 = localObject2;
        if (localMessage != null)
        {
          localMsgSummary.strContent = localMessage.msg;
          this.mDisplayTime = localMessage.time;
          this.mAuthenIconId = 0;
          if ((localMessage.msgtype == -4502) && (localMessage.frienduin.equals(acbn.bkv))) {
            this.mTitleName = "QQ物联";
          }
          for (;;)
          {
            if ((localMsgSummary.strContent == null) || (localMsgSummary.strContent.length() == 0)) {
              localMsgSummary.strContent = this.mTitleName;
            }
            this.mMenuFlag = 1;
            if (localMessage.msgtype != -4500) {
              break label954;
            }
            localObject3 = new MessageForDeviceFile();
            ((MessageForDeviceFile)localObject3).msgData = localMessage.msgData;
            ((MessageForDeviceFile)localObject3).parse();
            if (((MessageForDeviceFile)localObject3).msgStatus != 1) {
              break label928;
            }
            localMsgSummary.nState = 2;
            localObject1 = localObject2;
            break;
            localObject1 = ((syw)paramQQAppInterface.getBusinessHandler(51)).a(Long.parseLong(localMessage.frienduin));
            if (localObject1 != null) {
              this.mTitleName = tas.a((DeviceInfo)localObject1);
            }
          }
          localObject1 = localObject2;
          if (((MessageForDeviceFile)localObject3).msgStatus == 2)
          {
            localMsgSummary.nState = 1;
            localObject1 = localObject2;
            continue;
            if (localMessage.msgtype == -4501)
            {
              localObject1 = new MessageForDevPtt();
              ((MessageForDevPtt)localObject1).msgData = localMessage.msgData;
              ((MessageForDevPtt)localObject1).parse();
              if (((MessageForDevPtt)localObject1).fileSize == -1L)
              {
                localMsgSummary.nState = 2;
                localObject1 = localObject2;
                if (!"device_groupchat".equals(localMessage.extStr)) {
                  continue;
                }
                if (!localMessage.isSend()) {
                  break label1099;
                }
              }
              for (localMessage.nickName = paramQQAppInterface.getApp().getString(2131696176);; localMessage.nickName = aqgv.b(paramQQAppInterface, localMessage.senderuin, true))
              {
                aqiu.a(paramContext, paramQQAppInterface, localMessage, this.mUser.getType(), localMsgSummary, localMessage.nickName, true, false);
                localObject1 = localObject2;
                break;
                if (((MessageForDevPtt)localObject1).fileSize != -3L) {
                  break label1007;
                }
                localMsgSummary.nState = 1;
                break label1007;
              }
            }
            else if (localMessage.msgtype == -4503)
            {
              localObject3 = new MessageForDevShortVideo();
              ((MessageForDevShortVideo)localObject3).msgData = localMessage.msgData;
              ((MessageForDevShortVideo)localObject3).parse();
              if (((MessageForDevShortVideo)localObject3).videoFileStatus == 1005)
              {
                localMsgSummary.nState = 2;
                localObject1 = localObject2;
              }
              else
              {
                localObject1 = localObject2;
                if (((MessageForDevShortVideo)localObject3).videoFileStatus == 1002)
                {
                  localObject1 = ((szy)paramQQAppInterface.getBusinessHandler(49)).a();
                  if (localObject1 != null)
                  {
                    i = 1;
                    if (((szd)localObject1).bp(localMessage.uniseq)) {
                      break label1253;
                    }
                  }
                  for (int j = 1;; j = 0)
                  {
                    if ((i & j) == 0) {
                      break label1259;
                    }
                    localMsgSummary.nState = 2;
                    localObject1 = localObject2;
                    break;
                    i = 0;
                    break label1212;
                  }
                  localMsgSummary.nState = 1;
                  localObject1 = localObject2;
                }
              }
            }
            else if (localMessage.msgtype == -4509)
            {
              localObject3 = new MessageForDevLittleVideo();
              ((MessageForDevLittleVideo)localObject3).msgData = localMessage.msgData;
              ((MessageForDevLittleVideo)localObject3).parse();
              if (((MessageForDevLittleVideo)localObject3).videoFileStatus == 1005)
              {
                localMsgSummary.nState = 2;
                localObject1 = localObject2;
              }
              else
              {
                localObject1 = localObject2;
                if (((MessageForDevLittleVideo)localObject3).videoFileStatus == 1002)
                {
                  localObject1 = ((szy)paramQQAppInterface.getBusinessHandler(49)).a();
                  if (!xya.N((MessageRecord)localObject3)) {
                    if (localObject1 == null) {
                      break label1403;
                    }
                  }
                  for (i = 1;; i = 0)
                  {
                    if ((i & ((szd)localObject1).bp(localMessage.uniseq)) == 0) {
                      break label1408;
                    }
                    localMsgSummary.nState = 1;
                    localObject1 = localObject2;
                    break;
                  }
                  label1408:
                  localMsgSummary.nState = 2;
                  localObject1 = localObject2;
                }
              }
            }
            else
            {
              localObject1 = localObject2;
              if (localMessage.msgtype == -4508)
              {
                if ("device_groupchat".equals(localMessage.extStr))
                {
                  if (localMessage.isSend()) {}
                  for (localMessage.nickName = paramQQAppInterface.getApp().getString(2131696176);; localMessage.nickName = aqgv.b(paramQQAppInterface, localMessage.senderuin, true))
                  {
                    aqiu.a(paramContext, paramQQAppInterface, localMessage, this.mUser.getType(), localMsgSummary, localMessage.nickName, true, false);
                    localObject1 = localObject2;
                    break;
                  }
                }
                aqiu.a(paramContext, paramQQAppInterface, localMessage, this.mUser.getType(), localMsgSummary, null, true, false);
                localObject1 = localObject2;
                continue;
                a(paramQQAppInterface, paramContext, (QQMessageFacade)localObject4, localMessage);
                localObject1 = localObject2;
                continue;
                this.mTitleName = paramContext.getString(2131695619);
                localObject1 = ((augo)paramQQAppInterface.getManager(374)).a();
                if (localObject1 != null)
                {
                  localMsgSummary.strContent = ((MailPluginRecentMsg)localObject1).getDigest(paramContext.getResources());
                  this.mDisplayTime = ((MailPluginRecentMsg)localObject1).time;
                  localObject1 = localObject2;
                }
                else
                {
                  localMsgSummary.strContent = paramContext.getString(2131695633);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    case 1006: 
      label668:
      label724:
      label1007:
      label1403:
      localObject3 = aqgv.x(paramQQAppInterface, this.mUser.uin);
      label928:
      label954:
      label1099:
      label1253:
      label1259:
      localObject1 = (ajdo)paramQQAppInterface.getManager(11);
      label1212:
      if (localObject1 == null) {
        break;
      }
    }
    for (localObject1 = ((ajdo)localObject1).c(this.mUser.uin);; localObject1 = null)
    {
      if (localObject1 != null) {
        this.mTitleName = ((PhoneContact)localObject1).name;
      }
      for (;;)
      {
        a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
        if ((localMessage == null) || ((localMessage.getMessageText() == null) && ((localMessage.msgtype != -2011) || (localMessage.msgData == null)))) {
          break label1801;
        }
        this.mDisplayTime = localMessage.time;
        localObject1 = localObject2;
        break;
        if (localObject3 != null) {
          this.mTitleName = aqgv.b(paramQQAppInterface, (String)localObject3, true);
        } else {
          this.mTitleName = this.mUser.uin;
        }
      }
      label1801:
      this.mDisplayTime = 0L;
      localObject1 = localObject2;
      break;
      this.mTitleName = aqgv.b(paramQQAppInterface, this.mUser.uin, true);
      a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
      if ((localMessage != null) && ((localMessage.getMessageText() != null) || ((localMessage.msgtype == -2011) && (localMessage.msgData != null))))
      {
        this.mDisplayTime = localMessage.time;
        localObject1 = localObject2;
        break;
      }
      this.mDisplayTime = 0L;
      localObject1 = localObject2;
      break;
      boolean bool1 = aean.a(paramQQAppInterface).lp(this.mUser.uin);
      if ((this.mUnreadNum > 0) && (bool1))
      {
        this.mMsgExtroInfo = paramContext.getString(2131717472);
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
      }
      if (0 == 0) {}
      for (localObject1 = (acff)paramQQAppInterface.getManager(51);; localObject1 = null)
      {
        if ((this.mUser.getType() == 0) && (((acff)localObject1).isFriend(this.mUser.uin)))
        {
          if (xva.a().q(paramQQAppInterface) != 1) {
            break label2850;
          }
          i = 1;
          label2011:
          this.mQimOnline = 0;
          if ((i != 0) && (xva.a().SR()))
          {
            localObject2 = ((acff)localObject1).e(this.mUser.uin);
            if ((localObject2 != null) && (((Friends)localObject2).netTypeIconId == 11))
            {
              this.mQimOnline = 1;
              ThreadManager.post(new RecentItemChatMsgData.1(this, paramQQAppInterface), 5, null, true);
            }
          }
        }
        label2099:
        boolean bool2;
        if (a((acff)localObject1, this.mUser.uin))
        {
          this.mUnreadFlag = 4;
          if (FriendsStatusUtil.g(this.mUser.uin, paramQQAppInterface)) {
            this.mUnreadFlag = 3;
          }
          bool2 = wvo.a(this.mUser.uin, this.mUser.getType(), paramQQAppInterface);
          if ((!bool2) || (acqh.e(paramQQAppInterface.getCurrentUin(), paramContext))) {
            break label2863;
          }
          this.mUnreadFlag = 0;
          label2159:
          if ((localMessage == null) || ((localMessage.getMessageText() == null) && (localMessage.msgData == null) && ((localMessage.msgtype != -2011) || (this.mUser.getType() != 0)))) {
            break label2936;
          }
          this.mDisplayTime = localMessage.time;
          if (this.mDisplayTime == 0L) {
            this.mDisplayTime = this.mUser.opTime;
          }
          if (localMessage.msgtype != -2011) {
            break label2947;
          }
          long l = paramQQAppInterface.getApplication().getSharedPreferences("now_msg_sp" + paramQQAppInterface.getCurrentAccountUin(), 0).getLong("uid" + localMessage.frienduin, 0L);
          localObject2 = ((QQMessageFacade)localObject4).d(this.mUser.uin, this.mUser.getType());
          if ((localObject2 == null) || (!(localObject2 instanceof MessageForStructing))) {
            break label4065;
          }
          localObject3 = (MessageForStructing)localObject2;
          if (((MessageForStructing)localObject3).structingMsg == null) {
            ((MessageForStructing)localObject3).parse();
          }
          if (((MessageForStructing)localObject3).structingMsg == null) {
            break label4065;
          }
          if ((l != localMessage.msgUid) || (((MessageForStructing)localObject3).structingMsg.mMsgServiceID != 76)) {
            break label2892;
          }
          localObject3 = ((MessageForStructing)localObject3).structingMsg.mMsgBrief;
          localObject4 = paramContext.getString(2131699872);
          if ((((MessageRecord)localObject2).isread) || (TextUtils.isEmpty((CharSequence)localObject3)) || (!((String)localObject3).startsWith((String)localObject4))) {
            break label2876;
          }
          this.mMsgExtroInfo = ((CharSequence)localObject4);
          localMessage.msg = ((String)localObject3).substring(((String)localObject4).length());
          label2456:
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167383);
          i = 0;
        }
        for (;;)
        {
          label2471:
          a(localMessage, this.mUser.getType(), paramQQAppInterface, paramContext, localMsgSummary);
          if ((i != 0) && (this.mUnreadNum > 0) && ((this.mUser.msg instanceof MessageRecord)) && (!((MessageRecord)this.mUser.msg).isread)) {
            localMsgSummary.suffix = "";
          }
          if ((i == 0) && ((this.mUser.msg instanceof MessageForStructing)) && (localMessage != null) && (localMessage.msgtype != -1034))
          {
            localObject2 = (MessageForStructing)this.mUser.msg;
            if ((!((MessageForStructing)localObject2).isread) && (((MessageForStructing)localObject2).structingMsg.mMsgServiceID == 107)) {
              a(paramContext, localMessage, (MessageForStructing)localObject2);
            }
          }
          if ((localMessage != null) && (localMessage.msgtype == -1034))
          {
            localObject2 = new MessageForRichState();
            ((MessageForRichState)localObject2).msg = localMessage.msg;
            ((MessageForRichState)localObject2).mIsParsed = false;
            ((MessageForRichState)localObject2).parse();
            if (paramQQAppInterface.a().aE(localMessage.frienduin) < ((MessageForRichState)localObject2).time)
            {
              this.mMsgExtroInfo = acfp.m(2131713693);
              this.mExtraInfoColor = paramContext.getResources().getColor(2131167383);
              label2700:
              this.mIsSignMsg = true;
            }
          }
          else
          {
            if ((localMessage != null) && (localMessage.msgtype == -2074))
            {
              localObject2 = new MessageForAIOStoryVideo();
              ((MessageForAIOStoryVideo)localObject2).msg = localMessage.msg;
              ((MessageForAIOStoryVideo)localObject2).mIsParsed = false;
              ((MessageForAIOStoryVideo)localObject2).parse();
              this.mMsgExtroInfo = acfp.m(2131713669);
              this.mExtraInfoColor = paramContext.getResources().getColor(2131167379);
            }
            if (!acbn.bkG.equals(this.mUser.uin)) {
              break label2979;
            }
            this.mTitleName = paramContext.getString(2131720682);
          }
          for (;;)
          {
            if ((localMessage == null) || (localMessage.msgtype != -2040)) {
              break label3232;
            }
            localObject2 = new MessageForApproval();
            ((MessageForApproval)localObject2).msgData = localMessage.msgData;
            localMsgSummary.strContent = ((MessageForApproval)localObject2).getFullTitle();
            break;
            label2850:
            i = 0;
            break label2011;
            this.mUnreadFlag = 1;
            break label2099;
            label2863:
            if (!bool2) {
              break label2159;
            }
            this.mUnreadFlag = 3;
            break label2159;
            label2876:
            this.mMsgExtroInfo = "";
            localMessage.msg = ((String)localObject3);
            break label2456;
            label2892:
            if ((((MessageForStructing)localObject3).structingMsg.mMsgServiceID != 107) || (bool1)) {
              break label4065;
            }
            a(paramContext, localMessage, (MessageForStructing)localObject2);
            this.mUser.msg = localObject3;
            i = 1;
            break label2471;
            label2936:
            this.mDisplayTime = this.mUser.opTime;
            label2947:
            i = 0;
            break label2471;
            this.mMsgExtroInfo = acfp.m(2131713692);
            this.mExtraInfoColor = paramContext.getResources().getColor(2131167379);
            break label2700;
            label2979:
            if (acbn.bkB.equals(this.mUser.uin))
            {
              this.mTitleName = paramContext.getString(2131720758);
              if ((localMessage != null) && (localMessage.msg != null)) {
                localMsgSummary.strContent = localMessage.msg;
              }
            }
            else if (this.mUser.getType() == 1000)
            {
              localObject2 = (TroopManager)paramQQAppInterface.getManager(52);
              if (localObject2 != null)
              {
                localObject2 = ((TroopManager)localObject2).jp(this.mUser.troopUin);
                this.mTitleName = aqgv.a(paramQQAppInterface, this.mUser.uin, (String)localObject2, this.mUser.troopUin, true, null);
              }
            }
            else if (this.mUser.getType() == 1004)
            {
              this.mTitleName = aqgv.m(paramQQAppInterface, this.mUser.troopUin, this.mUser.uin);
              if ((this.mTitleName != null) && (this.mTitleName.equals(this.mUser.uin))) {
                this.mTitleName = aqgv.b(paramQQAppInterface, this.mUser.uin, true);
              }
            }
            else if (this.mUser.getType() == 10007)
            {
              this.mTitleName = ahtc.d(this.mUser.uin, paramQQAppInterface);
            }
            else
            {
              this.mTitleName = aqgv.b(paramQQAppInterface, this.mUser.uin, true);
            }
          }
          label3232:
          if ((localMessage != null) && (localMessage.msgtype == -2041))
          {
            localObject2 = paramContext.getString(2131690449);
            localObject3 = paramContext.getString(2131690446);
            localMsgSummary.strContent = ((String)localObject2 + " " + (String)localObject3);
            break;
          }
          if ((localMessage != null) && (localMessage.msgtype == -2025))
          {
            if (this.mUnreadNum <= 0) {
              break label3565;
            }
            localObject3 = paramContext.getString(2131694637);
            localObject4 = localMessage.msg;
            if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (((String)localObject4).startsWith((String)localObject3)))
            {
              this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
              if (!TextUtils.isEmpty(this.mMsgExtroInfo)) {
                break label3538;
              }
              localObject2 = localObject3;
              label3384:
              this.mMsgExtroInfo = ((CharSequence)localObject2);
              localMsgSummary.strContent = ((String)localObject4).replace((CharSequence)localObject3, "");
            }
          }
          for (;;)
          {
            if ((localMessage != null) && (localMessage.msgtype == -2061)) {
              localMsgSummary.strContent = "";
            }
            if ((this.mUser.getType() == 1024) && (!asgx.ag(paramQQAppInterface, this.mUser.uin))) {
              this.mAuthenIconId = jqs.a(paramQQAppInterface, this.mUser.uin);
            }
            if (aqft.rj(this.mUser.uin)) {
              this.mAuthenIconId = 2130842599;
            }
            if ((this.mUser.getType() != 0) || (((acff)localObject1).co(this.mUser.uin) != 1)) {
              break label4062;
            }
            this.mQimIconUrl = ((FlashChatManager)paramQQAppInterface.getManager(217)).a.icon;
            break;
            label3538:
            localObject2 = this.mMsgExtroInfo + (String)localObject3;
            break label3384;
            label3565:
            this.mMsgExtroInfo = "";
          }
          this.mTitleName = paramContext.getString(2131698717);
          localObject3 = "";
          localObject1 = null;
          if (localObject4 != null) {
            localObject1 = ((QQMessageFacade)localObject4).k(acbn.bkA, 4000);
          }
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
            if (((MessageRecord)localObject1).msg != null) {
              if (((MessageRecord)localObject1).msgtype == -1033)
              {
                localObject1 = ((MessageRecord)localObject1).msg;
                localObject1 = acfp.m(2131713675) + (String)localObject1;
              }
            }
          }
          for (;;)
          {
            localMsgSummary.strContent = ((CharSequence)localObject1);
            if ((localMessage != null) && (localMessage.getMessageText() != null))
            {
              this.mDisplayTime = localMessage.time;
              localObject1 = localObject2;
              break;
              if (((MessageRecord)localObject1).msgtype == -1030)
              {
                if ((ajdo)paramQQAppInterface.getManager(11) != null) {}
                localObject1 = acfp.m(2131713678) + "";
                continue;
              }
              if (((MessageRecord)localObject1).msgtype == -1039)
              {
                localObject1 = (ackn)paramQQAppInterface.getManager(22);
                if (localObject1 == null) {
                  break label4055;
                }
                localObject1 = paramContext.getResources().getString(2131698719) + ((ackn)localObject1).rM();
                continue;
              }
              if (((MessageRecord)localObject1).msgtype != -1040) {
                break label4048;
              }
              localObject4 = (ackn)paramQQAppInterface.getManager(22);
              localObject1 = localObject3;
              if (localObject4 != null) {
                localObject1 = ((ackn)localObject4).rM();
              }
              continue;
            }
            this.mDisplayTime = 0L;
            localObject1 = localObject2;
            break;
            this.mTitleName = acfp.m(2131713695);
            localMsgSummary.strContent = "可连接ArkIDE进行真机调试";
            this.mUnreadNum = 0;
            localObject1 = localObject2;
            break;
            label3932:
            a(paramQQAppInterface, paramContext, localMessage);
            break label464;
            label3943:
            if (this.mUnreadNum == 1)
            {
              ((StringBuilder)localObject3).append("有一条未读");
              break label510;
            }
            if (this.mUnreadNum == 2)
            {
              ((StringBuilder)localObject3).append("有两条未读");
              break label510;
            }
            if (this.mUnreadNum <= 0) {
              break label510;
            }
            ((StringBuilder)localObject3).append("有").append(this.mUnreadNum).append("条未读,");
            break label510;
            ((StringBuilder)localObject3).append(paramContext.name).append(",");
            break label668;
            label4034:
            this.mContentDesc = ((StringBuilder)localObject3).toString();
            label4043:
            cvo();
            return;
            label4048:
            localObject1 = "";
            continue;
            label4055:
            localObject1 = "";
          }
          label4062:
          break;
          label4065:
          i = 0;
        }
      }
    }
  }
  
  public long eK()
  {
    return super.eK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData
 * JD-Core Version:    0.7.0.1
 */