package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;

public class SearchableTroopMember
  extends IContactSearchable
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int jdField_b_of_type_Int = 1;
  private static final int jdField_c_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 3;
  private static final int e = 4;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo;
  private String jdField_a_of_type_JavaLangString;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private String jdField_d_of_type_JavaLangString;
  private int f;
  
  @SuppressLint({"DefaultLocale"})
  public SearchableTroopMember(Context paramContext, QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo = paramTroopMemberInfo;
    this.A = paramLong2;
    ChnToSpell.a(paramContext);
    paramContext = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (paramContext != null)
    {
      paramContext = paramContext.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin);
      if ((paramContext != null) && (paramContext.isFriend()) && (paramContext.remark != null) && (paramContext.remark.length() > 0))
      {
        this.jdField_a_of_type_JavaLangString = paramContext.remark;
        this.b = ChnToSpell.a(paramContext.remark, 1).toLowerCase();
        this.c = ChnToSpell.a(paramContext.remark, 2).toLowerCase();
      }
    }
    a();
  }
  
  public int a()
  {
    return 0;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo;
  }
  
  public String a()
  {
    switch (this.f)
    {
    default: 
      return null;
    case 0: 
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        str = this.jdField_a_of_type_JavaLangString;
        this.d = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
        return str;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick.length() > 0))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick;
        this.d = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
        return str;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick.length() > 0))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick;
        this.d = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
        return str;
      }
      return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
    case 1: 
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        str = this.jdField_a_of_type_JavaLangString;
        this.d = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick;
        return str;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick.length() > 0))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick;
        this.d = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick;
        return str;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick;
      this.d = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
      return str;
    case 2: 
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark;
      this.d = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
      return str;
    case 3: 
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        str = this.jdField_a_of_type_JavaLangString;
        this.d = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick;
        return str;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick;
      this.d = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
      return str;
    }
    String str = this.jdField_a_of_type_JavaLangString;
    this.d = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
    return str;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    long l2 = 562949953421312L;
    int k = -1;
    paramString = paramString.toLowerCase();
    this.z = -9223372036854775808L;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0) && ((this.jdField_a_of_type_JavaLangString.equals(paramString)) || ((this.b != null) && (this.b.equals(paramString))) || ((this.c != null) && (this.c.equals(paramString)))) && (1125899906842624L > this.z))
    {
      this.z = 1125899906842624L;
      this.f = 4;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick.length() > 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick.equals(paramString)) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_troopnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_troopnick.equals(paramString))) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_troopnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_troopnick.equals(paramString)))) && (1125899906842624L > this.z))
    {
      this.z = 1125899906842624L;
      this.f = 3;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark.length() > 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark.equals(paramString)) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_autoremark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_autoremark.equals(paramString))) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_autoremark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_autoremark.equals(paramString)))) && (1125899906842624L > this.z))
    {
      this.z = 1125899906842624L;
      this.f = 2;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick.length() > 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick.equals(paramString)) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_friendnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_friendnick.equals(paramString))) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_friendnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_friendnick.equals(paramString)))) && (1125899906842624L > this.z))
    {
      this.z = 1125899906842624L;
      this.f = 1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin.equals(paramString)) && (1125899906842624L > this.z))
    {
      this.z = 1125899906842624L;
      this.f = 0;
    }
    int m;
    int i;
    int j;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
    {
      m = this.jdField_a_of_type_JavaLangString.indexOf(paramString);
      if (this.b == null) {
        break label1068;
      }
      i = this.b.indexOf(paramString);
      if (this.c == null) {
        break label1073;
      }
      j = this.c.indexOf(paramString);
      label537:
      if ((m >= 0) || (i >= 0) || (j >= 0))
      {
        if ((m != 0) && (i != 0) && (j != 0)) {
          break label1078;
        }
        l1 = 562949953421312L;
        label568:
        if (l1 > this.z)
        {
          this.z = l1;
          this.f = 4;
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick.length() > 0))
    {
      m = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick.indexOf(paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_troopnick == null) {
        break label1086;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_troopnick.indexOf(paramString);
      label647:
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_troopnick == null) {
        break label1091;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_troopnick.indexOf(paramString);
      label669:
      if ((m >= 0) || (i >= 0) || (j >= 0))
      {
        if ((m != 0) && (i != 0) && (j != 0)) {
          break label1096;
        }
        l1 = 562949953421312L;
        label700:
        if (l1 > this.z)
        {
          this.z = l1;
          this.f = 3;
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark.length() > 0))
    {
      m = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark.indexOf(paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_autoremark == null) {
        break label1104;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_autoremark.indexOf(paramString);
      label779:
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_autoremark == null) {
        break label1109;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_autoremark.indexOf(paramString);
      label801:
      if ((m >= 0) || (i >= 0) || (j >= 0))
      {
        if ((m != 0) && (i != 0) && (j != 0)) {
          break label1114;
        }
        l1 = 562949953421312L;
        label832:
        if (l1 > this.z)
        {
          this.z = l1;
          this.f = 2;
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick.length() > 0))
    {
      m = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick.indexOf(paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_friendnick == null) {
        break label1122;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_friendnick.indexOf(paramString);
      label911:
      j = k;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_friendnick != null) {
        j = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_friendnick.indexOf(paramString);
      }
      if ((m >= 0) || (i >= 0) || (j >= 0))
      {
        if ((m != 0) && (i != 0) && (j != 0)) {
          break label1127;
        }
        l1 = 562949953421312L;
        label967:
        if (l1 > this.z)
        {
          this.z = l1;
          this.f = 1;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin.indexOf(paramString);
      if (i >= 0) {
        if (i != 0) {
          break label1135;
        }
      }
    }
    label1068:
    label1073:
    label1078:
    label1086:
    label1091:
    label1096:
    label1104:
    label1109:
    label1114:
    label1122:
    label1127:
    label1135:
    for (long l1 = l2;; l1 = 281474976710656L)
    {
      if (l1 > this.z)
      {
        this.z = l1;
        this.f = 0;
      }
      if (this.z != -9223372036854775808L) {
        this.z += this.A;
      }
      return;
      i = -1;
      break;
      j = -1;
      break label537;
      l1 = 281474976710656L;
      break label568;
      i = -1;
      break label647;
      j = -1;
      break label669;
      l1 = 281474976710656L;
      break label700;
      i = -1;
      break label779;
      j = -1;
      break label801;
      l1 = 281474976710656L;
      break label832;
      i = -1;
      break label911;
      l1 = 281474976710656L;
      break label967;
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    return "群成员";
  }
  
  public String c()
  {
    if (this.d != null) {
      return String.format("(%s)", new Object[] { this.d });
    }
    return null;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchableTroopMember
 * JD-Core Version:    0.7.0.1
 */