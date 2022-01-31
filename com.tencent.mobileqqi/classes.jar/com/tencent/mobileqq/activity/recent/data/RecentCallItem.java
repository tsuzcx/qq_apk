package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentCallItem
  extends RecentBaseData
{
  public static final int G = 0;
  public static final int H = 1;
  public static final int I = 2;
  public static final int J = 3;
  private static final String f = RecentCallItem.class.getSimpleName();
  protected QCallRecent a;
  public long b;
  
  public RecentCallItem(QCallRecent paramQCallRecent)
  {
    this.jdField_b_of_type_Long = 0L;
    if (paramQCallRecent == null) {
      throw new NullPointerException("call is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent = paramQCallRecent;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.lastCallTime;
  }
  
  public QCallRecent a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin;
    FriendManager localFriendManager = (FriendManager)paramQQAppInterface.getManager(8);
    Friends localFriends;
    if (localFriendManager == null) {
      localFriends = null;
    }
    label46:
    int i;
    switch (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type)
    {
    default: 
      this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, str, true);
    case 1008: 
    case 1006: 
    case 1021: 
    case 0: 
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
    case 4000: 
      for (;;)
      {
        this.jdField_b_of_type_JavaLangCharSequence = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.lastCallMsg;
        if (localFriends == null) {
          break label1148;
        }
        i = localFriends.getNetWorkType();
        label225:
        this.y = i;
        if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type != 3000) {
          break label1200;
        }
        switch (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.getState(paramQQAppInterface))
        {
        default: 
          i = -1;
          label282:
          this.B = i;
          this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.lastCallTime;
          if ((this.jdField_a_of_type_Long == 0L) && (QLog.isColorLevel())) {
            QLog.d(f, 2, "zsw RecentCallItem| mDisplayTime = " + this.jdField_a_of_type_Long);
          }
          if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long != 9223372036854775806L)) {
            this.jdField_b_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type != 3000) {
            this.A = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.missedCallCount;
          }
          if (QLog.isDevelopLevel()) {
            QLog.i(f, 4, "update mAuthenIconId=" + this.B + ";mUnreadNum=" + this.A + ";mStatus=" + this.y);
          }
          i = this.F & 0xFFFF0FFF;
          if (!this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isVideo()) {
            break label1245;
          }
          i |= 0x3000;
          label487:
          this.F = i;
          paramQQAppInterface = new StringBuilder();
          if ((!this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isMissedCall()) || (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend())) {
            break label1254;
          }
          paramQQAppInterface.append(paramContext.getString(2131559000, new Object[] { this.jdField_a_of_type_JavaLangString }));
          label542:
          if (!this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isVideo()) {
            break label1316;
          }
          paramQQAppInterface.append(paramContext.getString(2131559003));
          label563:
          this.c = paramQQAppInterface.toString();
          return;
          localFriends = localFriendManager.c(str);
          break label46;
          localObject3 = (PublicAccountDataManager)paramQQAppInterface.getManager(51);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((PublicAccountDataManager)localObject3).a(str);
          }
          if (localObject1 != null)
          {
            this.jdField_a_of_type_JavaLangString = ((PublicAccountInfo)localObject1).name;
            continue;
            localObject2 = ContactUtils.d(paramQQAppInterface, str);
            localObject3 = (PhoneContactManager)paramQQAppInterface.getManager(10);
            if (localObject3 != null) {
              localObject1 = ((PhoneContactManager)localObject3).f(str);
            }
            if (localObject1 != null)
            {
              this.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).name;
            }
            else if (localObject2 != null)
            {
              this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, (String)localObject2, true);
            }
            else
            {
              this.jdField_a_of_type_JavaLangString = str;
              continue;
              localObject1 = (CircleManager)paramQQAppInterface.getManager(33);
              localObject2 = ((CircleManager)localObject1).a(str);
              if ((localObject1 != null) && (localObject2 != null))
              {
                this.jdField_a_of_type_JavaLangString = ((CircleManager)localObject1).a((CircleBuddy)localObject2);
              }
              else
              {
                this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, str, true);
                continue;
                if (AppConstants.U.equals(str))
                {
                  this.jdField_a_of_type_JavaLangString = paramContext.getString(2131562249);
                }
                else if (AppConstants.W.equals(str))
                {
                  this.jdField_a_of_type_JavaLangString = paramContext.getString(2131562677);
                }
                else if (AppConstants.V.equals(str))
                {
                  this.jdField_a_of_type_JavaLangString = paramContext.getString(2131562371);
                }
                else if (AppConstants.N.equals(str))
                {
                  this.jdField_a_of_type_JavaLangString = paramContext.getString(2131562365);
                }
                else if (AppConstants.S.equals(str))
                {
                  this.jdField_a_of_type_JavaLangString = paramContext.getString(2131563212);
                }
                else if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type == 1000)
                {
                  if (localFriendManager != null) {
                    this.jdField_a_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, str, localFriendManager.g(this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.troopUin), this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.troopUin, true);
                  }
                }
                else
                {
                  if (localFriends != null) {
                    if (!TextUtils.isEmpty(localFriends.remark)) {
                      localObject1 = localFriends.remark;
                    }
                  }
                  label966:
                  for (this.jdField_a_of_type_JavaLangString = ((String)localObject1); (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangString.equals(str)); this.jdField_a_of_type_JavaLangString = "")
                  {
                    this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, str, true);
                    break;
                    localObject1 = localFriends.name;
                    break label966;
                  }
                  this.jdField_a_of_type_JavaLangString = paramContext.getString(2131560604);
                }
              }
            }
          }
          break;
        }
      }
    }
    this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, str);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject1 = localObject3;
      if (localFriendManager != null) {
        localObject1 = localFriendManager.a(str);
      }
      this.jdField_a_of_type_JavaLangString = ContactUtils.a(paramContext, (DiscussionInfo)localObject1);
    }
    if (localFriendManager != null)
    {
      i = localFriendManager.c(str);
      if (i <= 0) {}
    }
    for (localObject1 = "(" + i + ")";; localObject1 = "")
    {
      this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      break;
      label1148:
      i = 0;
      break label225;
      i = 3;
      break label282;
      i = 0;
      break label282;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.time > 0L) && (!this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend()))
      {
        i = 1;
        break label282;
      }
      i = 2;
      break label282;
      i = 2;
      break label282;
      label1200:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isMissedCall()) && (!this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend()))
      {
        i = 0;
        break label282;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend())
      {
        i = 2;
        break label282;
      }
      i = 1;
      break label282;
      label1245:
      i |= 0x4000;
      break label487;
      label1254:
      if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend())
      {
        paramQQAppInterface.append(paramContext.getString(2131559001, new Object[] { this.jdField_a_of_type_JavaLangString }));
        break label542;
      }
      paramQQAppInterface.append(paramContext.getString(2131559002, new Object[] { this.jdField_a_of_type_JavaLangString }));
      break label542;
      label1316:
      paramQQAppInterface.append(paramContext.getString(2131559004));
      break label563;
    }
  }
  
  public void a(QCallRecent paramQCallRecent)
  {
    if ((paramQCallRecent != null) && (paramQCallRecent.uin.equals(this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin))) {
      this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent = paramQCallRecent;
    }
  }
  
  public long b()
  {
    return 0L;
  }
  
  public int c()
  {
    return this.y;
  }
  
  public int d()
  {
    return this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentCallItem
 * JD-Core Version:    0.7.0.1
 */