package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;

public class ContactsSearchableRecentUser
  extends IContactSearchable
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public RecentUser a;
  private FriendManager jdField_a_of_type_ComTencentMobileqqModelFriendManager;
  public String a;
  public String b;
  private String c;
  private String d;
  private long y;
  
  public ContactsSearchableRecentUser(Context paramContext, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, long paramLong)
  {
    this(paramContext, paramQQAppInterface, paramRecentUser, 131072L, paramLong);
  }
  
  @SuppressLint({"DefaultLocale"})
  public ContactsSearchableRecentUser(Context paramContext, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.w = paramLong2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.y = paramLong1;
    this.jdField_a_of_type_JavaLangString = paramRecentUser.displayName;
    a(paramRecentUser);
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    this.b = this.jdField_a_of_type_JavaLangString;
    ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.toLowerCase();
    this.c = ChnToSpell.a(this.jdField_a_of_type_JavaLangString, 1).toLowerCase();
    this.d = ChnToSpell.a(this.jdField_a_of_type_JavaLangString, 2).toLowerCase();
  }
  
  private void a(RecentUser paramRecentUser)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataRecentUser = paramRecentUser;
    this.jdField_a_of_type_ComTencentMobileqqModelFriendManager = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8));
    if (this.jdField_a_of_type_ComTencentMobileqqModelFriendManager == null) {}
    Object localObject1;
    Object localObject2;
    label537:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              int i;
              do
              {
                do
                {
                  return;
                  localObject1 = paramRecentUser.uin;
                  i = paramRecentUser.type;
                  switch (i)
                  {
                  default: 
                    return;
                  case 0: 
                  case 1000: 
                  case 1001: 
                  case 1003: 
                  case 1004: 
                  case 1005: 
                  case 1009: 
                  case 1020: 
                  case 1023: 
                  case 1024: 
                    localObject2 = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c((String)localObject1);
                    if (!String.valueOf(AppConstants.U).equals(localObject1)) {
                      break;
                    }
                    this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131562249);
                    return;
                  case 6000: 
                    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131558496);
                    return;
                  case 1008: 
                    paramRecentUser = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                  }
                } while (paramRecentUser == null);
                paramRecentUser = paramRecentUser.a((String)localObject1);
              } while (paramRecentUser == null);
              this.jdField_a_of_type_JavaLangString = paramRecentUser.name;
              return;
              paramRecentUser = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
              localObject1 = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).f((String)localObject1);
              if (localObject1 != null)
              {
                this.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).name;
                return;
              }
              if (paramRecentUser != null)
              {
                this.jdField_a_of_type_JavaLangString = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, true);
                return;
              }
              this.jdField_a_of_type_JavaLangString = "";
              return;
              if (String.valueOf(AppConstants.W).equals(localObject1))
              {
                this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131562677);
                return;
              }
              if (String.valueOf(AppConstants.V).equals(localObject1))
              {
                this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131562371);
                return;
              }
              if (String.valueOf(AppConstants.N).equals(localObject1))
              {
                this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131562365);
                return;
              }
              if (AppConstants.S.equals(localObject1))
              {
                this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131563212);
                return;
              }
              if (i == 1000)
              {
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.g(paramRecentUser.troopUin);
                this.jdField_a_of_type_JavaLangString = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, (String)localObject2, paramRecentUser.troopUin, true);
                return;
              }
              if (localObject2 != null) {
                if (!TextUtils.isEmpty(((Friends)localObject2).remark)) {
                  paramRecentUser = ((Friends)localObject2).remark;
                }
              }
              for (this.jdField_a_of_type_JavaLangString = paramRecentUser; (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangString.equals(localObject1)); this.jdField_a_of_type_JavaLangString = paramRecentUser.displayName)
              {
                this.jdField_a_of_type_JavaLangString = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
                return;
                paramRecentUser = ((Friends)localObject2).name;
                break label537;
              }
              paramRecentUser = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a((String)localObject1);
            } while (paramRecentUser == null);
            this.jdField_a_of_type_JavaLangString = paramRecentUser.troopname;
            return;
            paramRecentUser = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a((String)localObject1);
            this.jdField_a_of_type_JavaLangString = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
          } while ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals("")));
          this.jdField_a_of_type_JavaLangString = ContactUtils.a(this.jdField_a_of_type_AndroidContentContext, paramRecentUser);
          return;
        } while (!String.valueOf(AppConstants.R).equals(localObject1));
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131562458);
        return;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131562182);
        return;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131560553);
        return;
      } while (!String.valueOf(AppConstants.O).equals(localObject1));
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131561706);
      localObject1 = SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    paramRecentUser = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c((String)localObject1);
    if (paramRecentUser != null) {
      if (!TextUtils.isEmpty(paramRecentUser.remark)) {
        paramRecentUser = paramRecentUser.remark;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramRecentUser))
      {
        localObject2 = paramRecentUser;
        if (!paramRecentUser.equals(localObject1)) {}
      }
      else
      {
        localObject2 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d);
        paramRecentUser = (RecentUser)localObject1;
        if (localObject2 != null)
        {
          paramRecentUser = (RecentUser)localObject1;
          if (((String)localObject2).length() > 0) {
            paramRecentUser = (RecentUser)localObject2;
          }
        }
        localObject2 = paramRecentUser;
      }
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + " ( " + (String)localObject2 + " ) ");
      return;
      paramRecentUser = paramRecentUser.name;
      continue;
      paramRecentUser = (RecentUser)localObject1;
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public RecentUser a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser;
  }
  
  public String a()
  {
    return BaseApplicationImpl.getContext().getString(2131559286);
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    paramString = paramString.toLowerCase();
    this.v = -9223372036854775808L;
    long l1;
    int i;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() != 0))
    {
      if ((!this.jdField_a_of_type_JavaLangString.equals(paramString)) && ((this.c == null) || (!this.c.equals(paramString))) && ((this.d == null) || (!this.d.equals(paramString)))) {
        break label211;
      }
      l1 = this.y;
      if ((this.c == null) || (this.c.length() <= 0)) {
        break label193;
      }
      i = this.c.charAt(0);
      l1 = 0x0 | l1 | i;
      if (l1 > this.v)
      {
        if ((this.jdField_a_of_type_JavaLangString.equals(paramString)) || (this.jdField_a_of_type_JavaLangString.equals(this.c))) {
          break label198;
        }
        this.v = (4503599627370496L + l1);
      }
    }
    for (;;)
    {
      if (this.v != -9223372036854775808L) {
        this.v += this.w + 144115188075855872L;
      }
      return;
      label193:
      i = 0;
      break;
      label198:
      this.v = (9007199254740992L + l1);
      continue;
      label211:
      int k = this.jdField_a_of_type_JavaLangString.indexOf(paramString);
      label237:
      int j;
      label253:
      long l2;
      if (this.c != null)
      {
        i = this.c.indexOf(paramString);
        if (this.d == null) {
          break label373;
        }
        j = this.d.indexOf(paramString);
        if ((k < 0) && (i < 0) && (j < 0)) {
          break label376;
        }
        if ((k != 0) && (i != 0) && (j != 0)) {
          break label378;
        }
        l1 = 562949953421312L;
        label284:
        l2 = this.y;
        if ((this.c == null) || (this.c.length() <= 0)) {
          break label386;
        }
      }
      label386:
      for (i = this.c.charAt(0);; i = 0)
      {
        l1 |= l2 | i;
        if (l1 <= this.v) {
          break;
        }
        if ((k >= 0) || (this.jdField_a_of_type_JavaLangString.equals(this.c))) {
          break label391;
        }
        this.v = (l1 + 4503599627370496L);
        break;
        i = -1;
        break label237;
        label373:
        j = -1;
        break label253;
        label376:
        break;
        label378:
        l1 = 281474976710656L;
        break label284;
      }
      label391:
      this.v = (l1 + 9007199254740992L);
    }
  }
  
  public int b()
  {
    return ((Integer)RecentFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin).first).intValue();
  }
  
  public String b()
  {
    return null;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactsSearchableRecentUser
 * JD-Core Version:    0.7.0.1
 */