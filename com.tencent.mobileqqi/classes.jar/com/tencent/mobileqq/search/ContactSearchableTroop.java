package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;

public class ContactSearchableTroop
  extends IContactSearchable
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int jdField_b_of_type_Int = 1;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private String jdField_a_of_type_JavaLangString;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private long y;
  
  public ContactSearchableTroop(Context paramContext, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, long paramLong)
  {
    this(paramContext, paramQQAppInterface, paramTroopInfo, 0L, paramLong);
  }
  
  @SuppressLint({"DefaultLocale"})
  public ContactSearchableTroop(Context paramContext, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.w = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131562205);
    this.y = paramLong1;
    ChnToSpell.a(paramContext);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname.length() != 0))
    {
      this.b = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname, 1).toLowerCase();
      this.jdField_c_of_type_JavaLangString = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname, 2).toLowerCase();
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin) != 3) {
      return 0;
    }
    return 2130840235;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public TroopInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    String str1;
    String str2;
    label41:
    String str3;
    String str4;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname.toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin == null) {
        break label235;
      }
      str2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
      str3 = this.b;
      str4 = this.jdField_c_of_type_JavaLangString;
      paramString = paramString.toLowerCase();
      this.v = -9223372036854775808L;
      if ((str1 == null) || (str1.length() == 0)) {
        break label441;
      }
      if ((!str1.equals(paramString)) && ((str3 == null) || (!str3.equals(paramString))) && ((str4 == null) || (!str4.equals(paramString)))) {
        break label257;
      }
      l1 = this.y;
      if ((str3 == null) || (str3.length() <= 0)) {
        break label241;
      }
      i = str3.charAt(0);
      label141:
      l1 = 0x0 | l1 | i;
      if (l1 > this.v)
      {
        if ((str1.equals(paramString)) || (str1.equals(str3))) {
          break label246;
        }
        l1 += 4503599627370496L;
        label189:
        this.v = (l1 + 144115188075855872L);
        this.jdField_c_of_type_Int = 1;
      }
      label204:
      if (this.v == -9223372036854775808L) {
        break label441;
      }
      this.v += this.w;
    }
    label235:
    label241:
    label246:
    long l2;
    label257:
    label277:
    label289:
    label320:
    label346:
    while (str2 == null)
    {
      return;
      str1 = null;
      break;
      str2 = null;
      break label41;
      i = 0;
      break label141;
      l1 += 9007199254740992L;
      break label189;
      int k = str1.indexOf(paramString);
      int j;
      if (str3 != null)
      {
        i = str3.indexOf(paramString);
        if (str4 == null) {
          break label412;
        }
        j = str4.indexOf(paramString);
        if ((k < 0) && (i < 0) && (j < 0)) {
          break label415;
        }
        if ((k != 0) && (i != 0) && (j != 0)) {
          break label417;
        }
        l1 = 562949953421312L;
        l2 = this.y;
        if ((str3 == null) || (str3.length() <= 0)) {
          break label425;
        }
        i = str3.charAt(0);
        l1 |= l2 | i;
        if (l1 <= this.v) {
          break label204;
        }
        if ((k >= 0) || (str1.equals(str3))) {
          break label430;
        }
      }
      for (l1 += 4503599627370496L;; l1 += 9007199254740992L)
      {
        this.v = (l1 + 144115188075855872L);
        this.jdField_c_of_type_Int = 1;
        break;
        i = -1;
        break label277;
        j = -1;
        break label289;
        break;
        l1 = 281474976710656L;
        break label320;
        i = 0;
        break label346;
      }
    }
    label412:
    label415:
    label417:
    label425:
    label430:
    label441:
    if (str2.equals(paramString))
    {
      l1 = this.y;
      l1 = str2.charAt(0) | 0x0 | l1;
      if (l1 > this.v)
      {
        this.v = (l1 + 9007199254740992L + 72057594037927936L);
        this.jdField_c_of_type_Int = 0;
      }
    }
    label506:
    while (this.v != -9223372036854775808L)
    {
      this.v += this.w;
      return;
      i = str2.indexOf(paramString);
      if (i >= 0) {
        if (i != 0) {
          break label604;
        }
      }
    }
    label604:
    for (long l1 = 562949953421312L;; l1 = 281474976710656L)
    {
      l2 = this.y;
      l1 = str2.charAt(0) | l1 | l2;
      if (l1 <= this.v) {
        break label506;
      }
      this.v = (l1 + 9007199254740992L + 72057594037927936L);
      this.jdField_c_of_type_Int = 0;
      break label506;
      break;
    }
  }
  
  public int b()
  {
    return 4;
  }
  
  public String b()
  {
    return null;
  }
  
  public String c()
  {
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return null;
    case 0: 
      return String.format("%s(%s)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin });
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchableTroop
 * JD-Core Version:    0.7.0.1
 */