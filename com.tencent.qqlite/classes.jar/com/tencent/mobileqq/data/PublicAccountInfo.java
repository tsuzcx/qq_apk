package com.tencent.mobileqq.data;

import android.content.Context;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.EqqAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.PublicAccountInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PublicAccountInfo
  extends Entity
{
  public static final int SHOW_FLAG_INVISIBLE_BIT = 2048;
  public static final int SHOW_FLAG_NO = 2;
  public static final int SHOW_FLAG_YES = 1;
  public static final int SHOW_MSG_FLAG_TYPE = 5;
  public int accountFlag;
  public long certifiedGrade;
  public long dateTime;
  public String displayNumber;
  public long eqqAccountFlag;
  public int extendType;
  public boolean isRecvMsg;
  public boolean isRecvPush;
  public boolean isSyncLbs;
  public String logo;
  public int mComparePartInt;
  public String mCompareSpell;
  public boolean mIsAgreeSyncLbs;
  public boolean mIsSyncLbsSelected;
  public int mShowMsgFlag;
  public String name;
  public int showFlag;
  public String summary;
  @unique
  public long uin;
  @notColumn
  private String uinStr;
  
  private static void copyEqqLbsSwitch(mobileqq_mp.EqqAccountInfo paramEqqAccountInfo, PublicAccountInfo paramPublicAccountInfo)
  {
    int i;
    if ((paramEqqAccountInfo.config_group_info.has()) && (!paramEqqAccountInfo.config_group_info.isEmpty()))
    {
      paramEqqAccountInfo = paramEqqAccountInfo.config_group_info.get().iterator();
      i = 0;
      if (paramEqqAccountInfo.hasNext())
      {
        Object localObject = (mobileqq_mp.ConfigGroupInfo)paramEqqAccountInfo.next();
        if ((((mobileqq_mp.ConfigGroupInfo)localObject).config_info.has()) && (!((mobileqq_mp.ConfigGroupInfo)localObject).config_info.isEmpty()))
        {
          localObject = ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.get().iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject).next();
              if ((localConfigInfo.type.has()) && (localConfigInfo.type.get() == 2) && (localConfigInfo.state_id.has()) && (localConfigInfo.state_id.get() == 3))
              {
                paramPublicAccountInfo.isSyncLbs = true;
                if (localConfigInfo.state.has()) {
                  switch (localConfigInfo.state.get())
                  {
                  default: 
                    if (QLog.isColorLevel())
                    {
                      QLog.e("PublicAccountInfo", 2, "Error Eqq lbs state value: " + localConfigInfo.state.get());
                      i = 1;
                      label244:
                      if (i == 0) {}
                    }
                    break;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        paramPublicAccountInfo.isSyncLbs = false;
      }
      return;
      paramPublicAccountInfo.mIsSyncLbsSelected = false;
      paramPublicAccountInfo.mIsAgreeSyncLbs = false;
      i = 1;
      break label244;
      paramPublicAccountInfo.mIsSyncLbsSelected = true;
      paramPublicAccountInfo.mIsAgreeSyncLbs = true;
      i = 1;
      break label244;
      paramPublicAccountInfo.mIsSyncLbsSelected = true;
      paramPublicAccountInfo.mIsAgreeSyncLbs = false;
      i = 1;
      break label244;
      break;
      i = 1;
      break label244;
      break label244;
      continue;
      i = 0;
    }
  }
  
  public static PublicAccountInfo createLooker(Context paramContext)
  {
    PublicAccountInfo localPublicAccountInfo = new PublicAccountInfo();
    localPublicAccountInfo.uin = 0L;
    localPublicAccountInfo.name = paramContext.getString(2131363766);
    localPublicAccountInfo.displayNumber = paramContext.getString(2131363766);
    localPublicAccountInfo.summary = "";
    localPublicAccountInfo.extendType = 1;
    return localPublicAccountInfo;
  }
  
  public static PublicAccountInfo createPublicAccount(AccountDetail paramAccountDetail, long paramLong)
  {
    PublicAccountInfo localPublicAccountInfo = new PublicAccountInfo();
    localPublicAccountInfo.uinStr = paramAccountDetail.uin;
    localPublicAccountInfo.uin = Long.parseLong(paramAccountDetail.uin);
    localPublicAccountInfo.name = paramAccountDetail.name;
    localPublicAccountInfo.displayNumber = paramAccountDetail.displayNumber;
    localPublicAccountInfo.summary = paramAccountDetail.summary;
    localPublicAccountInfo.isRecvMsg = paramAccountDetail.isRecvMsg;
    localPublicAccountInfo.isRecvPush = paramAccountDetail.isRecvPush;
    localPublicAccountInfo.certifiedGrade = paramAccountDetail.certifiedGrade;
    localPublicAccountInfo.isSyncLbs = paramAccountDetail.isSyncLbs;
    localPublicAccountInfo.mIsAgreeSyncLbs = paramAccountDetail.isAgreeSyncLbs;
    localPublicAccountInfo.mShowMsgFlag = paramAccountDetail.mShowMsgFlag;
    localPublicAccountInfo.showFlag = paramAccountDetail.showFlag;
    localPublicAccountInfo.accountFlag = paramAccountDetail.accountFlag;
    localPublicAccountInfo.dateTime = paramLong;
    ContactSorter.a(localPublicAccountInfo);
    return localPublicAccountInfo;
  }
  
  public static PublicAccountInfo createPublicAccount(EqqDetail paramEqqDetail, long paramLong)
  {
    PublicAccountInfo localPublicAccountInfo = new PublicAccountInfo();
    localPublicAccountInfo.uinStr = paramEqqDetail.uin;
    try
    {
      localPublicAccountInfo.uin = Long.parseLong(paramEqqDetail.uin);
      localPublicAccountInfo.name = paramEqqDetail.name;
      localPublicAccountInfo.displayNumber = paramEqqDetail.displayNumber;
      localPublicAccountInfo.summary = paramEqqDetail.summary;
      localPublicAccountInfo.certifiedGrade = paramEqqDetail.certifiedGrade;
      localPublicAccountInfo.dateTime = paramLong;
      localPublicAccountInfo.showFlag = 1;
      localPublicAccountInfo.extendType = 2;
      localPublicAccountInfo.mShowMsgFlag = paramEqqDetail.mShowMsgFlag;
      localPublicAccountInfo.isSyncLbs = paramEqqDetail.mIsSyncLbs;
      localPublicAccountInfo.mIsAgreeSyncLbs = paramEqqDetail.mIsAgreeSyncLbs;
      localPublicAccountInfo.mIsSyncLbsSelected = paramEqqDetail.mIsSyncLbsSelected;
      localPublicAccountInfo.eqqAccountFlag = paramEqqDetail.eqqAccountFlag;
      return localPublicAccountInfo;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localPublicAccountInfo.uin = 0L;
      }
    }
  }
  
  public static PublicAccountInfo createPublicAccountInfo(mobileqq_mp.PublicAccountInfo paramPublicAccountInfo, long paramLong)
  {
    PublicAccountInfo localPublicAccountInfo = new PublicAccountInfo();
    if (paramPublicAccountInfo.uin.has()) {
      localPublicAccountInfo.uin = (paramPublicAccountInfo.uin.get() & 0xFFFFFFFF);
    }
    if (paramPublicAccountInfo.name.has()) {
      localPublicAccountInfo.name = paramPublicAccountInfo.name.get();
    }
    if (paramPublicAccountInfo.summary.has()) {
      localPublicAccountInfo.summary = paramPublicAccountInfo.summary.get();
    }
    if (paramPublicAccountInfo.is_recv_msg.has()) {
      localPublicAccountInfo.isRecvMsg = paramPublicAccountInfo.is_recv_msg.get();
    }
    if (paramPublicAccountInfo.display_number.has()) {
      localPublicAccountInfo.displayNumber = paramPublicAccountInfo.display_number.get();
    }
    if (paramPublicAccountInfo.is_recv_push.has()) {
      localPublicAccountInfo.isRecvPush = paramPublicAccountInfo.is_recv_push.get();
    }
    if (paramPublicAccountInfo.certified_grade.has()) {
      localPublicAccountInfo.certifiedGrade = paramPublicAccountInfo.certified_grade.get();
    }
    if (paramPublicAccountInfo.show_flag.has()) {
      localPublicAccountInfo.showFlag = paramPublicAccountInfo.show_flag.get();
    }
    if (paramPublicAccountInfo.account_flag.has()) {
      localPublicAccountInfo.accountFlag = paramPublicAccountInfo.account_flag.get();
    }
    localPublicAccountInfo.mShowMsgFlag = -1;
    int i;
    if (paramPublicAccountInfo.config_group_info.has())
    {
      Object localObject1 = paramPublicAccountInfo.config_group_info.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (mobileqq_mp.ConfigGroupInfo)((Iterator)localObject1).next();
          if (!((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.has()) {
            break label411;
          }
          localObject2 = ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.get().iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject2).next();
              if (localConfigInfo.state_id.get() == 5) {
                if (localConfigInfo.state.get() == 1)
                {
                  i = 1;
                  label360:
                  localPublicAccountInfo.mShowMsgFlag = i;
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    label411:
    for (;;)
    {
      if (i != 0)
      {
        if (paramPublicAccountInfo.is_sync_lbs.has()) {
          localPublicAccountInfo.mIsAgreeSyncLbs = paramPublicAccountInfo.is_sync_lbs.get();
        }
        localPublicAccountInfo.dateTime = paramLong;
        return localPublicAccountInfo;
        i = 0;
        break label360;
      }
      break;
    }
  }
  
  public static PublicAccountInfo createPublicAccountInfoFromEqq(mobileqq_mp.EqqAccountInfo paramEqqAccountInfo, long paramLong)
  {
    PublicAccountInfo localPublicAccountInfo = new PublicAccountInfo();
    if (paramEqqAccountInfo.uin.has()) {
      localPublicAccountInfo.uin = (paramEqqAccountInfo.uin.get() & 0xFFFFFFFF);
    }
    if (paramEqqAccountInfo.name.has()) {
      localPublicAccountInfo.name = paramEqqAccountInfo.name.get();
    }
    if (paramEqqAccountInfo.display_number.has()) {
      localPublicAccountInfo.displayNumber = paramEqqAccountInfo.display_number.get();
    }
    if (paramEqqAccountInfo.summary.has()) {
      localPublicAccountInfo.summary = paramEqqAccountInfo.summary.get();
    }
    if (paramEqqAccountInfo.certified_grade.has()) {
      localPublicAccountInfo.certifiedGrade = paramEqqAccountInfo.certified_grade.get();
    }
    if (paramEqqAccountInfo.logo.has()) {
      localPublicAccountInfo.logo = paramEqqAccountInfo.logo.get();
    }
    if (paramEqqAccountInfo.account_flag.has()) {
      localPublicAccountInfo.eqqAccountFlag = paramEqqAccountInfo.account_flag.get();
    }
    localPublicAccountInfo.mShowMsgFlag = -1;
    int i;
    if (paramEqqAccountInfo.config_group_info.has())
    {
      Object localObject1 = paramEqqAccountInfo.config_group_info.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (mobileqq_mp.ConfigGroupInfo)((Iterator)localObject1).next();
          if (!((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.has()) {
            break label363;
          }
          localObject2 = ((mobileqq_mp.ConfigGroupInfo)localObject2).config_info.get().iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject2).next();
              if (localConfigInfo.state_id.get() == 5) {
                if (localConfigInfo.state.get() == 1)
                {
                  i = 1;
                  label316:
                  localPublicAccountInfo.mShowMsgFlag = i;
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    label363:
    for (;;)
    {
      if (i != 0)
      {
        localPublicAccountInfo.dateTime = paramLong;
        localPublicAccountInfo.showFlag = 1;
        localPublicAccountInfo.extendType = 2;
        copyEqqLbsSwitch(paramEqqAccountInfo, localPublicAccountInfo);
        return localPublicAccountInfo;
        i = 0;
        break label316;
      }
      break;
    }
  }
  
  public static List createPublicAccountInfoList(List paramList, long paramLong)
  {
    ArrayList localArrayList = null;
    if (paramList != null)
    {
      localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(createPublicAccountInfo((mobileqq_mp.PublicAccountInfo)paramList.next(), paramLong));
      }
    }
    return localArrayList;
  }
  
  public static List createPublicAccountInfoListFromEqq(List paramList, long paramLong)
  {
    ArrayList localArrayList = null;
    if (paramList != null)
    {
      localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(createPublicAccountInfoFromEqq((mobileqq_mp.EqqAccountInfo)paramList.next(), paramLong));
      }
    }
    return localArrayList;
  }
  
  private boolean isHideInContacts()
  {
    return (this.accountFlag & 0x800) != 0;
  }
  
  public static boolean isLooker(PublicAccountInfo paramPublicAccountInfo)
  {
    return paramPublicAccountInfo.extendType == 1;
  }
  
  public String getUin()
  {
    if (this.uinStr == null) {
      this.uinStr = String.valueOf(this.uin);
    }
    return this.uinStr;
  }
  
  public boolean hasIvrAbility()
  {
    if (2 == this.extendType)
    {
      if (CrmUtils.a) {
        break label31;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("PublicAccountInfo", 4, "Don't support sharp");
      }
    }
    label31:
    while ((this.eqqAccountFlag & 0x100) != 256L) {
      return false;
    }
    return true;
  }
  
  public boolean isNeedShow()
  {
    return (1 == this.showFlag) && (!isHideInContacts());
  }
  
  public boolean isVisible()
  {
    return 1 == this.showFlag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.PublicAccountInfo
 * JD-Core Version:    0.7.0.1
 */