package com.tencent.mobileqq.apollo.activity;

import abxk;
import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import anot;
import aptr;
import apuh;
import apuk;
import aqgv;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import jof;
import tog;

public class RecentHotchatItem
  extends RecentBaseData
{
  private static final String TAG = "RecentHotchatItem";
  private static RecentHotchatItem sDivider;
  private AioPushData mGameData;
  private HotChatItemData mOriginalData;
  public int mType = 3;
  
  public RecentHotchatItem(HotChatItemData paramHotChatItemData)
  {
    this.mOriginalData = paramHotChatItemData;
    if (getGameId() > 0) {}
    for (int i = 2;; i = 1)
    {
      this.mType = i;
      return;
    }
  }
  
  public static RecentHotchatItem a()
  {
    if (sDivider == null)
    {
      sDivider = new RecentHotchatItem(null);
      sDivider.mType = 4;
    }
    return sDivider;
  }
  
  public boolean Yt()
  {
    return (this.mOriginalData != null) && (this.mGameData != null) && (!this.mGameData.isShow);
  }
  
  public boolean Yu()
  {
    return this.mGameData != null;
  }
  
  public AioPushData a()
  {
    return this.mGameData;
  }
  
  public void bX(QQAppInterface paramQQAppInterface)
  {
    if ((this.mOriginalData != null) && (this.mOriginalData.mGameId <= 0) && (!TextUtils.isEmpty(this.mOriginalData.mHotChatCode)) && (paramQQAppInterface != null))
    {
      Object localObject = (abxk)paramQQAppInterface.getManager(155);
      if (localObject != null)
      {
        localObject = ((abxk)localObject).a(this.mOriginalData.mHotChatCode);
        if (localObject != null) {
          this.mOriginalData.mGameId = ((ApolloGameData)localObject).gameId;
        }
      }
    }
    if ((paramQQAppInterface != null) && (getGameId() > 0))
    {
      paramQQAppInterface = (abxk)paramQQAppInterface.getManager(155);
      if (paramQQAppInterface != null) {
        this.mGameData = paramQQAppInterface.a(ra(), getGameId());
      }
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    bX(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("RecentHotchatItem", 2, "[update] " + ra() + " " + qx() + " " + ng() + " " + Yt());
    }
    QQMessageFacade.Message localMessage = null;
    Object localObject4 = qx();
    int i = ng();
    Object localObject1 = paramQQAppInterface.b();
    if (localObject1 != null) {
      localMessage = ((QQMessageFacade)localObject1).a((String)localObject4, i);
    }
    label163:
    int j;
    if (localMessage != null)
    {
      this.mDisplayTime = localMessage.time;
      localObject1 = paramQQAppInterface.a();
      if (localObject1 != null)
      {
        this.mUnreadNum = ((tog)localObject1).A(localMessage.frienduin, localMessage.istroop);
        if ((aptr.qV((String)localObject4)) || (aptr.qX((String)localObject4)))
        {
          this.mMsgExtroInfo = BaseApplicationImpl.getContext().getString(2131721137);
          this.mExtraInfoColor = paramContext.getResources().getColor(2131167383);
        }
        j = this.mMenuFlag;
        localObject1 = (TroopManager)paramQQAppInterface.getManager(52);
        if (localObject1 == null) {
          break label1204;
        }
      }
    }
    label287:
    label676:
    label758:
    label763:
    Object localObject2;
    label408:
    label1204:
    for (localObject1 = ((TroopManager)localObject1).b((String)localObject4);; localObject2 = null)
    {
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = ((TroopInfo)localObject1).troopname;
        localObject1 = ((TroopInfo)localObject1).troopmemo;
      }
      for (;;)
      {
        this.mMenuFlag = (j & 0xFFFFF0FF | 0x100);
        long l1;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          this.mTitleName = aqgv.a(paramQQAppInterface, (String)localObject4, true);
          localObject4 = a();
          if ((localMessage != null) && (TextUtils.isEmpty(localMessage.nickName))) {
            localMessage.nickName = localMessage.senderuin;
          }
          a(localMessage, i, paramQQAppInterface, paramContext, (MsgSummary)localObject4);
          if ((TextUtils.isEmpty(((MsgSummary)localObject4).strContent)) && (TextUtils.isEmpty(((MsgSummary)localObject4).suffix)))
          {
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = "";
            }
            ((MsgSummary)localObject4).strContent = ((CharSequence)localObject3);
          }
          bI(paramQQAppInterface);
          a(paramQQAppInterface, (MsgSummary)localObject4);
          a(paramQQAppInterface, paramContext, (MsgSummary)localObject4);
          l1 = 0L;
        }
        try
        {
          long l2 = Long.parseLong(qx());
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          boolean bool;
          break label408;
        }
        this.mIsGroupVideo = paramQQAppInterface.a().au(l1);
        bool = this.mIsGroupVideoNotify;
        this.mIsGroupVideoNotify = paramQQAppInterface.a().at(l1);
        if (this.mIsGroupVideoNotify)
        {
          localObject1 = (apuk)paramQQAppInterface.getManager(164);
          if ((localObject1 != null) && (((apuk)localObject1).eV(qx()) == 2)) {
            this.mIsGroupVideoNotify = false;
          }
        }
        if ((this.mIsGroupVideoNotify) && (TextUtils.isEmpty(this.mMsgExtroInfo)))
        {
          this.mMsgExtroInfo = paramQQAppInterface.getApp().getString(2131700021);
          this.mExtraInfoColor = paramQQAppInterface.getApp().getResources().getColor(2131167410);
        }
        if ((this.mIsGroupVideoNotify) && (!bool))
        {
          localObject1 = String.valueOf(l1);
          anot.a(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject1, "" + apuh.n(paramQQAppInterface, (String)localObject1), "", "");
        }
        if ((TextUtils.isEmpty(this.mMsgExtroInfo)) && (localMessage != null) && (localObject4 != null) && (jof.a(localMessage))) {
          this.mLastMsg = ((MsgSummary)localObject4).a(paramContext, paramContext.getResources().getString(2131699453), -1);
        }
        this.mMenuFlag &= 0xFFFFFF0F;
        j = this.mMenuFlag;
        if (isTop())
        {
          i = 32;
          this.mMenuFlag = (i | j);
          if (this.mOriginalData.mState != 1) {
            break label1017;
          }
          if ((Yt()) && ((!Yt()) || (!this.mOriginalData.mIsRead4List))) {
            break label896;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecentHotchatItem", 2, "[update] kicked out");
          }
          paramQQAppInterface = acfp.m(2131713666);
          ((MsgSummary)localObject4).reset();
          this.mLastMsg = ((MsgSummary)localObject4).a(paramContext, paramQQAppInterface, -1);
          this.mUnreadFlag = 0;
          if (!AppSetting.enableTalkBack) {
            break label1119;
          }
          paramQQAppInterface = new StringBuilder(24);
          paramQQAppInterface.append(this.mTitleName);
          if (this.mUnreadNum != 0) {
            break label1121;
          }
        }
        for (;;)
        {
          if (this.mMsgExtroInfo != null) {
            paramQQAppInterface.append(this.mMsgExtroInfo + ",");
          }
          paramQQAppInterface.append(this.mLastMsg).append(' ').append(this.mShowTime);
          this.mContentDesc = paramQQAppInterface.toString();
          return;
          this.mUnreadNum = 0;
          break label163;
          this.mDisplayTime = 0L;
          this.mUnreadNum = 0;
          break label163;
          this.mTitleName = ((String)localObject3);
          break label287;
          i = 16;
          break label676;
          if ((!Yu()) || (isRead())) {
            break label758;
          }
          this.mMsgExtroInfo = "";
          this.mExtraInfoColor = paramQQAppInterface.getApp().getResources().getColor(2131167410);
          localObject1 = this.mGameData.wording;
          ((MsgSummary)localObject4).reset();
          this.mLastMsg = ((MsgSummary)localObject4).a(paramContext, (String)localObject1, -1);
          paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(13);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.Yc(100);
          }
          if (!QLog.isColorLevel()) {
            break label758;
          }
          QLog.d("RecentHotchatItem", 2, "[update] " + this.mGameData);
          break label758;
          label1017:
          if ((Yu()) && (!isRead()))
          {
            this.mMsgExtroInfo = "";
            this.mExtraInfoColor = paramQQAppInterface.getApp().getResources().getColor(2131167410);
            paramQQAppInterface = this.mGameData.wording;
            ((MsgSummary)localObject4).reset();
            this.mLastMsg = ((MsgSummary)localObject4).a(paramContext, paramQQAppInterface, -1);
            if (QLog.isColorLevel()) {
              QLog.d("RecentHotchatItem", 2, "[update] " + this.mGameData);
            }
          }
          this.mUnreadFlag = 3;
          break label763;
          label1119:
          break;
          label1121:
          if (this.mUnreadNum == 1) {
            paramQQAppInterface.append("有一条未读");
          } else if (this.mUnreadNum == 2) {
            paramQQAppInterface.append("有两条未读");
          } else if (this.mUnreadNum > 0) {
            paramQQAppInterface.append("有").append(this.mUnreadNum).append("条未读");
          }
        }
        localObject2 = null;
        localObject3 = null;
      }
    }
  }
  
  public long eI()
  {
    if (this.mOriginalData == null) {
      return 0L;
    }
    return this.mOriginalData.mLatestMsgSec;
  }
  
  public long eJ()
  {
    if (this.mOriginalData == null) {
      return 0L;
    }
    return this.mOriginalData.mDraftSec;
  }
  
  public int getGameId()
  {
    if (this.mOriginalData == null) {
      return -1;
    }
    return this.mOriginalData.mGameId;
  }
  
  public boolean isRead()
  {
    return (this.mOriginalData != null) && (this.mOriginalData.mIsRead4List);
  }
  
  public boolean isTop()
  {
    return (this.mOriginalData != null) && (this.mOriginalData.mIsMakeTop);
  }
  
  public int ng()
  {
    return 1;
  }
  
  public String qx()
  {
    if (this.mOriginalData == null) {
      return "";
    }
    return this.mOriginalData.mTroopUin;
  }
  
  public String ra()
  {
    if (this.mOriginalData == null) {
      return "";
    }
    return this.mOriginalData.mHotChatCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.activity.RecentHotchatItem
 * JD-Core Version:    0.7.0.1
 */