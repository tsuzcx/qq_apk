package com.tencent.mobileqq.activity.recent.data;

import acfp;
import aekv;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import aofk;
import aqiu;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kdm;
import wna;

public class RecentItemEcShopAssitant
  extends RecentUserBaseData
{
  static final String TAG = "RecentItemEcShopAssitant";
  long newStrTime;
  
  public RecentItemEcShopAssitant(RecentUser paramRecentUser)
    throws NullPointerException
  {
    super(paramRecentUser);
  }
  
  private void cvm()
  {
    if ((this.mExtraInfo != null) && (acfp.m(2131713677).equalsIgnoreCase(this.mExtraInfo.toString()))) {
      this.mExtraInfo = "";
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    EcShopData localEcShopData = null;
    this.mStatus = 0;
    if (paramMsgSummary != null)
    {
      paramMsgSummary.bShowDraft = false;
      paramMsgSummary.mDraft = null;
    }
    Object localObject = paramQQAppInterface.b();
    if (localObject == null) {}
    do
    {
      kdm localkdm;
      do
      {
        do
        {
          return;
          localkdm = (kdm)paramQQAppInterface.getManager(88);
          if (localkdm != null) {
            localEcShopData = localkdm.a();
          }
        } while ((localEcShopData == null) || (TextUtils.isEmpty(localEcShopData.mUin)) || (this.mDisplayTime >= localEcShopData.mLastDraftTime) || (this.newStrTime > localEcShopData.mLastDraftTime));
        this.mStatus = 4;
        localObject = ((QQMessageFacade)localObject).a(localEcShopData.mUin, 1008);
      } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
      this.mDisplayTime = ((DraftSummaryInfo)localObject).getTime();
      localObject = ((DraftSummaryInfo)localObject).getSummary();
      paramQQAppInterface = localkdm.getNickName(paramQQAppInterface, localEcShopData.mUin);
    } while (paramMsgSummary == null);
    paramMsgSummary.bShowDraft = true;
    paramMsgSummary.mDraft = new aofk(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.c(paramQQAppInterface, paramContext);
    label30:
    Object localObject2;
    kdm localkdm;
    Object localObject3;
    Object localObject1;
    int i;
    if (aekv.W("MiniAppEcShopNumMsgEnable", 1) == 1)
    {
      this.mUnreadFlag = 1;
      if (TextUtils.isEmpty(this.mTitleName)) {
        this.mTitleName = paramContext.getString(2131692998);
      }
      if (!TextUtils.isEmpty(kdm.Yn)) {
        this.mTitleName = kdm.Yn;
      }
      localObject2 = null;
      localkdm = (kdm)paramQQAppInterface.getManager(88);
      localObject3 = paramQQAppInterface.b();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        EcShopData localEcShopData = localkdm.a();
        localObject1 = localObject2;
        if (localEcShopData != null) {
          localObject1 = ((QQMessageFacade)localObject3).a(localEcShopData.mUin, 1008);
        }
      }
      localObject3 = super.a();
      if (localObject1 == null) {
        break label970;
      }
      this.mUnreadNum = localkdm.b(paramQQAppInterface);
      this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
      localObject2 = localkdm.getNickName(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).frienduin);
      if (localObject1 != null)
      {
        aqiu.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject1, this.mUser.getType(), (MsgSummary)localObject3, (String)localObject2, true, false);
        i = ((QQMessageFacade.Message)localObject1).msgtype;
        if ((i == -3006) || (i == -5004))
        {
          ((MsgSummary)localObject3).suffix = "";
          ((MsgSummary)localObject3).strContent = "";
          localObject2 = wna.a((MessageRecord)localObject1);
          if ((localObject2 != null) && (((PAMessage)localObject2).items != null) && (((PAMessage)localObject2).items.size() != 0)) {
            break label854;
          }
          a((QQMessageFacade.Message)localObject1, this.mUser.getType(), paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        }
      }
      label276:
      localObject2 = paramQQAppInterface.getCurrentAccountUin();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "noLogin";
      }
      localObject1 = paramContext.getSharedPreferences("ecshop_sp" + (String)localObject1, 0);
      i = ((SharedPreferences)localObject1).getInt("last_show_time1", 0);
      localkdm.aep = false;
      if ((i <= this.mDisplayTime) && ((!TextUtils.isEmpty(((MsgSummary)localObject3).strContent)) || (!TextUtils.isEmpty(((MsgSummary)localObject3).suffix)))) {
        break label1088;
      }
      long l = i;
      this.mDisplayTime = l;
      this.newStrTime = l;
      if (this.mUser != null) {
        this.mUser.lastmsgtime = this.mDisplayTime;
      }
      localObject2 = ((SharedPreferences)localObject1).getString("str_ecshop_diy", null);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label983;
      }
      localkdm.aep = true;
      ((MsgSummary)localObject3).strContent = ((CharSequence)localObject2);
      ((MsgSummary)localObject3).suffix = null;
      ((MsgSummary)localObject3).strPrefix = null;
      label453:
      this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
      if (!((SharedPreferences)localObject1).contains("PUSH_TYPE_COLOR")) {}
    }
    label1153:
    for (;;)
    {
      try
      {
        this.mExtraInfoColor = Color.parseColor(((SharedPreferences)localObject1).getString("PUSH_TYPE_COLOR", ""));
        if (((SharedPreferences)localObject1).getBoolean("folder_reddot", false))
        {
          int j = ((SharedPreferences)localObject1).getInt("last_show_time1", 0);
          int k = ((SharedPreferences)localObject1).getInt("reddot_start", 0);
          int m = ((SharedPreferences)localObject1).getInt("reddot_end", 0);
          int n = ((SharedPreferences)localObject1).getInt("max_reddot_time", 0);
          int i1 = (int)(System.currentTimeMillis() / 1000L);
          if ((i1 != 0) && (k != 0) && (m != 0) && (n != 0))
          {
            if ((i1 >= k) && (i1 <= m) && (i1 - j < n))
            {
              localkdm.aeq = true;
              if (i > this.mDisplayTime) {
                this.mDisplayTime = i;
              }
              this.mMsgExtroInfo = ((SharedPreferences)localObject1).getString("PUSH_TYPE_NAME", "");
            }
          }
          else
          {
            cvm();
            a(paramQQAppInterface, (MsgSummary)localObject3);
            a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
            if ((this.mUnreadNum == 0) && (localkdm.aeq)) {
              this.mUnreadNum = 1;
            }
            if (AppSetting.enableTalkBack)
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append(this.mTitleName).append(",");
              if (this.mUnreadNum > 0)
              {
                i = localkdm.ne();
                if ((i != 0) && (!localkdm.aeq)) {
                  break label1096;
                }
              }
              if (this.mMsgExtroInfo != null) {
                paramQQAppInterface.append(this.mMsgExtroInfo + ",");
              }
              if (this.mUnreadNum <= 0) {
                break label1153;
              }
              paramQQAppInterface.append(this.mShowTime);
              this.mContentDesc = paramQQAppInterface.toString();
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("EcShop", 2, "first string to show:" + ((MsgSummary)localObject3).strPrefix);
            return;
            this.mUnreadFlag = 2;
            break label30;
            label854:
            localObject1 = ((PAMessage.Item)((PAMessage)localObject2).items.get(0)).title;
            if ((((PAMessage.Item)((PAMessage)localObject2).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList != null))
            {
              localObject1 = (String)localObject1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList.get(0);
              ((MsgSummary)localObject3).strContent = ((CharSequence)localObject1);
              break label276;
            }
            continue;
            label970:
            this.mUnreadNum = 0;
            this.mDisplayTime = 0L;
            break label276;
            label983:
            if (!TextUtils.isEmpty(((MsgSummary)localObject3).suffix)) {
              break label453;
            }
            ((MsgSummary)localObject3).strContent = paramContext.getString(2131692995);
            ((MsgSummary)localObject3).strPrefix = null;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("RecentItemEcShopAssitant", 1, "parse color exception.");
        this.mExtraInfoColor = paramContext.getResources().getColor(2131167410);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("EcShopAssistantActivity", 2, "reddot out of date!");
        }
        localkdm.aeq = false;
        this.mUnreadNum = 0;
        this.mMsgExtroInfo = "";
        continue;
        this.mMsgExtroInfo = "";
        continue;
      }
      label1088:
      dx(paramContext);
      continue;
      label1096:
      if (i == 1)
      {
        paramQQAppInterface.append("有一条未读");
      }
      else if (i == 2)
      {
        paramQQAppInterface.append("有两条未读");
      }
      else if (i > 0)
      {
        paramQQAppInterface.append("有").append(i).append("条未读,");
        continue;
        paramQQAppInterface.append(this.mLastMsg).append(",").append(this.mShowTime);
      }
    }
  }
  
  public void dx(Context paramContext)
  {
    this.mMsgExtroInfo = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant
 * JD-Core Version:    0.7.0.1
 */