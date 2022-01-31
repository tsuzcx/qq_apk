package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
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
  private long y;
  
  @SuppressLint({"DefaultLocale"})
  public SearchableTroopMember(Context paramContext, QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo = paramTroopMemberInfo;
    this.y = paramLong1;
    this.w = paramLong2;
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
    return BaseApplicationImpl.getContext().getString(2131559289);
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    long l2 = 562949953421312L;
    int k = -1;
    paramString = paramString.toLowerCase();
    this.v = -9223372036854775808L;
    int i;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0) && ((this.jdField_a_of_type_JavaLangString.equals(paramString)) || ((this.b != null) && (this.b.equals(paramString))) || ((this.c != null) && (this.c.equals(paramString)))))
    {
      l1 = this.y;
      if ((this.b == null) || (this.b.length() <= 0)) {
        break label1497;
      }
      i = this.b.charAt(0);
      l1 = l1 | 0x0 | i;
      if (l1 > this.v)
      {
        this.v = l1;
        this.f = 4;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick.length() > 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick.equals(paramString)) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_troopnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_troopnick.equals(paramString))) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_troopnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_troopnick.equals(paramString)))))
    {
      l1 = this.y;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_troopnick == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_troopnick.length() <= 0)) {
        break label1502;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_troopnick.charAt(0);
      label274:
      l1 = l1 | 0x0 | i;
      if (l1 > this.v)
      {
        this.v = l1;
        this.f = 3;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark.length() > 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark.equals(paramString)) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_autoremark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_autoremark.equals(paramString))) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_autoremark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_autoremark.equals(paramString)))))
    {
      l1 = this.y;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_autoremark == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_autoremark.length() <= 0)) {
        break label1507;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_autoremark.charAt(0);
      label432:
      l1 = l1 | 0x0 | i;
      if (l1 > this.v)
      {
        this.v = l1;
        this.f = 2;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick.length() > 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick.equals(paramString)) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_friendnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_friendnick.equals(paramString))) || ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_friendnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_friendnick.equals(paramString)))))
    {
      l1 = this.y;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_friendnick == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_friendnick.length() <= 0)) {
        break label1512;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_friendnick.charAt(0);
      label590:
      l1 = l1 | 0x0 | i;
      if (l1 > this.v)
      {
        this.v = l1;
        this.f = 1;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin.equals(paramString)))
    {
      l1 = this.y | 0x0 | this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin.charAt(0);
      if (l1 > this.v)
      {
        this.v = l1;
        this.f = 0;
      }
    }
    int m;
    label733:
    int j;
    label749:
    long l3;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
    {
      m = this.jdField_a_of_type_JavaLangString.indexOf(paramString);
      if (this.b == null) {
        break label1517;
      }
      i = this.b.indexOf(paramString);
      if (this.c == null) {
        break label1522;
      }
      j = this.c.indexOf(paramString);
      if ((m >= 0) || (i >= 0) || (j >= 0))
      {
        if ((m != 0) && (i != 0) && (j != 0)) {
          break label1527;
        }
        l1 = 562949953421312L;
        label780:
        l3 = this.y;
        if ((this.b == null) || (this.b.length() <= 0)) {
          break label1535;
        }
        i = this.b.charAt(0);
        label812:
        l1 |= l3 | i;
        if (l1 > this.v)
        {
          this.v = l1;
          this.f = 4;
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick.length() > 0))
    {
      m = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick.indexOf(paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_troopnick == null) {
        break label1540;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_troopnick.indexOf(paramString);
      label901:
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_troopnick == null) {
        break label1545;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_troopnick.indexOf(paramString);
      label923:
      if ((m >= 0) || (i >= 0) || (j >= 0))
      {
        if ((m != 0) && (i != 0) && (j != 0)) {
          break label1550;
        }
        l1 = 562949953421312L;
        label954:
        l3 = this.y;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_troopnick == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_troopnick.length() <= 0)) {
          break label1558;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_troopnick.charAt(0);
        label995:
        l1 |= l3 | i;
        if (l1 > this.v)
        {
          this.v = l1;
          this.f = 3;
        }
      }
    }
    label1178:
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark.length() > 0))
    {
      m = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark.indexOf(paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_autoremark == null) {
        break label1563;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_autoremark.indexOf(paramString);
      label1084:
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_autoremark == null) {
        break label1568;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_autoremark.indexOf(paramString);
      label1106:
      if ((m >= 0) || (i >= 0) || (j >= 0))
      {
        if ((m != 0) && (i != 0) && (j != 0)) {
          break label1573;
        }
        l1 = 562949953421312L;
        label1137:
        l3 = this.y;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_autoremark == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_autoremark.length() <= 0)) {
          break label1581;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_autoremark.charAt(0);
        l1 |= l3 | i;
        if (l1 > this.v)
        {
          this.v = l1;
          this.f = 2;
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick.length() > 0))
    {
      m = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick.indexOf(paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_friendnick == null) {
        break label1586;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_friendnick.indexOf(paramString);
      label1267:
      j = k;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_friendnick != null) {
        j = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyFirst_friendnick.indexOf(paramString);
      }
      if ((m >= 0) || (i >= 0) || (j >= 0))
      {
        if ((m != 0) && (i != 0) && (j != 0)) {
          break label1591;
        }
        l1 = 562949953421312L;
        label1323:
        l3 = this.y;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_friendnick == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_friendnick.length() <= 0)) {
          break label1599;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.pyAll_friendnick.charAt(0);
        label1364:
        l1 |= l3 | i;
        if (l1 > this.v)
        {
          this.v = l1;
          this.f = 1;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin.indexOf(paramString);
      if (i >= 0) {
        if (i != 0) {
          break label1604;
        }
      }
    }
    label1540:
    label1545:
    label1550:
    label1558:
    label1563:
    label1568:
    label1573:
    label1581:
    label1586:
    label1591:
    label1599:
    label1604:
    for (long l1 = l2;; l1 = 281474976710656L)
    {
      l1 = this.y | l1 | this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin.charAt(0);
      if (l1 > this.v)
      {
        this.v = l1;
        this.f = 0;
      }
      if (this.v != -9223372036854775808L) {
        this.v += this.w;
      }
      return;
      label1497:
      i = 0;
      break;
      label1502:
      i = 0;
      break label274;
      label1507:
      i = 0;
      break label432;
      label1512:
      i = 0;
      break label590;
      label1517:
      i = -1;
      break label733;
      label1522:
      j = -1;
      break label749;
      label1527:
      l1 = 281474976710656L;
      break label780;
      label1535:
      i = 0;
      break label812;
      i = -1;
      break label901;
      j = -1;
      break label923;
      l1 = 281474976710656L;
      break label954;
      i = 0;
      break label995;
      i = -1;
      break label1084;
      j = -1;
      break label1106;
      l1 = 281474976710656L;
      break label1137;
      i = 0;
      break label1178;
      i = -1;
      break label1267;
      l1 = 281474976710656L;
      break label1323;
      i = 0;
      break label1364;
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    if (this.d != null) {
      return String.format("(%s)", new Object[] { this.d });
    }
    return null;
  }
  
  public String c()
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
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchableTroopMember
 * JD-Core Version:    0.7.0.1
 */