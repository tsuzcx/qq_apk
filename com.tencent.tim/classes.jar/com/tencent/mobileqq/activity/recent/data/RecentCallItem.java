package com.tencent.mobileqq.activity.recent.data;

import aale;
import acbn;
import acdt;
import acdu;
import acff;
import acfp;
import acja;
import ajdo;
import aljw;
import alkd;
import alkf;
import android.content.Context;
import android.text.TextUtils;
import aqgv;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.call.qcall.PstnSessionInfo;
import jll;

public class RecentCallItem
  extends RecentBaseData
{
  public static final int CALL_STATE_CALLIN = 1;
  public static final int CALL_STATE_CALLING = 3;
  public static final int CALL_STATE_CALLOUT = 2;
  public static final int CALL_STATE_DOUBLE_CHATING = 5;
  public static final int CALL_STATE_DOUBLE_INVITING = 4;
  public static final int CALL_STATE_DOUBLE_OTHER_TER_CHATING = 6;
  public static final int CALL_STATE_MISSED_CALLIN = 0;
  public static final int CALL_STATE_PSTN_DOUBLE_CHATING = 7;
  private static final String TAG = "RecentCallItem";
  protected QCallRecent call;
  public boolean isPstnDiscussionCall;
  public long mCallMemberNum;
  
  public RecentCallItem(QCallRecent paramQCallRecent)
    throws NullPointerException
  {
    if (paramQCallRecent == null) {
      throw new NullPointerException("call is null");
    }
    this.call = paramQCallRecent;
  }
  
  private void e(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    ajdo localajdo = null;
    String str1 = null;
    String str2 = this.call.uin;
    Object localObject1 = (acff)paramQQAppInterface.getManager(51);
    acdu localacdu = (acdu)paramQQAppInterface.getManager(53);
    if (localObject1 == null) {
      localObject1 = null;
    }
    int i;
    switch (this.call.type)
    {
    default: 
      this.mTitleName = aqgv.b(paramQQAppInterface, str2, true);
    case 1008: 
    case 1006: 
      for (;;)
      {
        this.mLastMsg = this.call.lastCallMsg;
        if (localObject1 == null) {
          break label1214;
        }
        i = ((Friends)localObject1).getNetWorkType();
        this.mStatus = i;
        if (localObject1 == null) {
          break label1219;
        }
        this.mOnlineStatus = aqgv.aU(((Friends)localObject1).detalStatusFlag, ((Friends)localObject1).iTermType);
        return;
        localObject1 = ((acff)localObject1).e(str2);
        break;
        paramContext = (acja)paramQQAppInterface.getManager(56);
        paramQQAppInterface = str1;
        if (paramContext != null) {
          paramQQAppInterface = paramContext.b(str2);
        }
        if (paramQQAppInterface != null)
        {
          this.mTitleName = paramQQAppInterface.name;
        }
        else if (this.mTitleName == null)
        {
          this.mTitleName = str2;
          continue;
          str1 = aqgv.x(paramQQAppInterface, str2);
          localajdo = (ajdo)paramQQAppInterface.getManager(11);
          paramContext = (Context)localObject2;
          if (localajdo != null) {
            paramContext = localajdo.c(str2);
          }
          if (paramContext != null) {
            this.mTitleName = paramContext.name;
          } else if (str1 != null) {
            this.mTitleName = aqgv.b(paramQQAppInterface, str1, true);
          } else {
            this.mTitleName = str2;
          }
        }
      }
    case 0: 
    case 8: 
    case 1000: 
    case 1001: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1009: 
    case 1020: 
    case 1022: 
    case 1023: 
    case 1024: 
    case 1025: 
      label261:
      if (this.call.type == 8)
      {
        this.mExtraType = this.call.extraType;
        this.mBindId = this.call.bindId;
        this.mBindType = this.call.bindType;
        this.mPhoneNumber = this.call.phoneNumber;
        if (this.mExtraType == 25)
        {
          localObject2 = (ajdo)paramQQAppInterface.getManager(11);
          if ((localObject2 == null) || (this.call.phoneNumber == null)) {
            break label1225;
          }
        }
      }
      break;
    }
    label679:
    label1214:
    label1219:
    label1225:
    for (localObject2 = ((ajdo)localObject2).c(this.call.phoneNumber);; localObject2 = null)
    {
      for (;;)
      {
        if (localObject2 != null)
        {
          this.mTitleName = ((PhoneContact)localObject2).name;
          if (QLog.isColorLevel()) {
            QLog.d("RecentCallItem", 2, "UNBINDQQ update contact = " + this.mTitleName);
          }
        }
        for (;;)
        {
          if (!acbn.bkD.equals(str2)) {
            break label679;
          }
          this.mTitleName = paramContext.getString(2131720683);
          break;
          localObject2 = ((alkf)paramQQAppInterface.getManager(140)).a(str2);
          if (localObject2 == null) {
            ((alkd)paramQQAppInterface.getBusinessHandler(79)).On(str2);
          } else if ((localObject2 != null) && (((QCallCardInfo)localObject2).nickname != null)) {
            this.mTitleName = ((QCallCardInfo)localObject2).nickname;
          }
        }
        if (acbn.bkG.equals(str2))
        {
          this.mTitleName = paramContext.getString(2131720682);
          break;
        }
        if (acbn.bkE.equals(str2))
        {
          this.mTitleName = paramContext.getString(2131694588);
          break;
        }
        if (acbn.bkt.equals(str2))
        {
          this.mTitleName = paramContext.getString(2131718916);
          break;
        }
        if (acbn.bkB.equals(str2))
        {
          this.mTitleName = paramContext.getString(2131720758);
          break;
        }
        if (this.call.type == 1000)
        {
          paramContext = (TroopManager)paramQQAppInterface.getManager(52);
          if (paramContext == null) {
            break;
          }
          this.mTitleName = aqgv.a(paramQQAppInterface, str2, paramContext.jp(this.call.troopUin), this.call.troopUin, true, null);
          break;
        }
        if (localObject1 != null) {
          if (!TextUtils.isEmpty(((Friends)localObject1).remark)) {
            paramContext = ((Friends)localObject1).remark;
          }
        }
        label857:
        for (this.mTitleName = paramContext; (TextUtils.isEmpty(this.mTitleName)) || (this.mTitleName.equals(str2)); this.mTitleName = "")
        {
          this.mTitleName = aqgv.b(paramQQAppInterface, str2, true);
          break;
          paramContext = ((Friends)localObject1).name;
          break label857;
        }
        this.mTitleName = paramContext.getString(2131698717);
        break;
        this.mTitleName = aqgv.u(paramQQAppInterface, str2);
        if (TextUtils.isEmpty(this.mTitleName))
        {
          localObject2 = localObject3;
          if (localacdu != null) {
            localObject2 = localacdu.a(str2);
          }
          if (localObject2 != null) {}
        }
        try
        {
          for (;;)
          {
            ((acdt)paramQQAppInterface.getBusinessHandler(6)).hk(Long.valueOf(str2).longValue());
            this.mTitleName = aqgv.a(paramContext, (DiscussionInfo)localObject2);
            localObject2 = "";
            paramContext = (Context)localObject2;
            if (localacdu != null)
            {
              i = localacdu.cn(str2);
              paramContext = (Context)localObject2;
              if (i > 0) {
                paramContext = "(" + i + ")";
              }
            }
            this.mExtraInfo = paramContext;
            try
            {
              this.mCallMemberNum = paramQQAppInterface.a().d(jll.cL(this.call.type), Long.parseLong(str2));
            }
            catch (NumberFormatException paramQQAppInterface)
            {
              paramQQAppInterface.printStackTrace();
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecentCallItem", 2, "discussionHandler exception:" + localException.getMessage());
            }
          }
        }
      }
      paramContext = (ajdo)paramQQAppInterface.getManager(11);
      paramQQAppInterface = localajdo;
      if (paramContext != null) {
        paramQQAppInterface = paramContext.b(str2);
      }
      if (paramQQAppInterface != null)
      {
        this.mTitleName = paramQQAppInterface.name;
        break;
      }
      this.mTitleName = str2;
      break;
      this.mTitleName = str2;
      break;
      this.mTitleName = aljw.m(paramQQAppInterface, str2);
      break;
      i = 0;
      break label261;
      this.mOnlineStatus = -1;
      return;
    }
  }
  
  public boolean WD()
  {
    return false;
  }
  
  public QCallRecent a()
  {
    return this.call;
  }
  
  public void a(QCallRecent paramQCallRecent)
  {
    if ((paramQCallRecent != null) && (paramQCallRecent.uin.equals(this.call.uin))) {
      this.call = paramQCallRecent;
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    int i = 1;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    this.mTitleName = "123123123";
    this.mLastMsg = this.call.lastCallMsg;
    this.mStatus = 0;
    this.mOnlineStatus = 4;
    e(paramQQAppInterface, paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallItemBuilder", 2, "call.type = " + this.call.type + ", call.getState(app) = " + this.call.getState(paramQQAppInterface) + ", displayName:" + this.call.displayName);
    }
    if (this.call.type == 3000) {
      switch (this.call.getState(paramQQAppInterface))
      {
      case 5: 
      case 6: 
      case 7: 
      default: 
        if ((this.call.time > 0L) && (!this.call.isSend()))
        {
          this.mAuthenIconId = i;
          this.mDisplayTime = this.call.lastCallTime;
          if ((this.mDisplayTime == 0L) && (QLog.isColorLevel())) {
            QLog.d("RecentCallItem", 2, "zsw RecentCallItem| mDisplayTime = " + this.mDisplayTime);
          }
          this.mShowTime = "0";
          if ((this.mDisplayTime > 0L) && (this.mDisplayTime != 9223372036854775806L)) {
            this.mShowTime = aale.a().t(qx(), this.mDisplayTime);
          }
          this.mUnreadNum = 0;
          i = this.mMenuFlag & 0xFFFF0FFF;
          if (!this.call.isVideo()) {
            break label563;
          }
          i |= 0x3000;
        }
        break;
      }
    }
    for (;;)
    {
      this.mMenuFlag = i;
      this.mCallingText = acfp.m(2131713659);
      return;
      i = 3;
      break;
      i = 0;
      break;
      if ((this.call.time > 0L) && (!this.call.isSend())) {
        break;
      }
      i = 2;
      break;
      i = 2;
      break;
      i = 2;
      break;
      int j = paramQQAppInterface.a().a().epd;
      paramContext = paramQQAppInterface.a().a().cGF;
      if (((j == 1) || (j == 2)) && (paramContext.equals(this.call.uin)))
      {
        i = 7;
        break;
      }
      if (this.call.getState(paramQQAppInterface) == 5)
      {
        i = 4;
        break;
      }
      if (this.call.getState(paramQQAppInterface) == 6)
      {
        i = 5;
        break;
      }
      if (this.call.getState(paramQQAppInterface) == 7)
      {
        i = 6;
        break;
      }
      if (((this.call.isMissedCall()) || (this.call.isLastCallRealMissed)) && (!this.call.isSend()))
      {
        i = 0;
        break;
      }
      if (!this.call.isSend()) {
        break;
      }
      i = 2;
      break;
      label563:
      i |= 0x4000;
    }
  }
  
  public long eI()
  {
    return this.call.lastCallTime;
  }
  
  public long eJ()
  {
    return 0L;
  }
  
  public int getNetWorkType()
  {
    return this.mStatus;
  }
  
  public int ng()
  {
    return this.call.type;
  }
  
  public String qx()
  {
    return this.call.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentCallItem
 * JD-Core Version:    0.7.0.1
 */