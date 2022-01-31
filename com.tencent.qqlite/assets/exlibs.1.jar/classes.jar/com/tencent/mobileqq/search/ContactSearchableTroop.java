package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
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
  
  public ContactSearchableTroop(Context paramContext, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, long paramLong)
  {
    this(paramContext, paramQQAppInterface, paramTroopInfo, 0L, paramLong);
  }
  
  @SuppressLint({"DefaultLocale"})
  public ContactSearchableTroop(Context paramContext, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.y = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131362944);
    ChnToSpell.a(paramContext);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname.length() != 0))
    {
      this.b = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname, 1).toLowerCase();
      this.jdField_c_of_type_JavaLangString = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname, 2).toLowerCase();
    }
    a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin) != 3) {
      return 0;
    }
    return 2130839359;
  }
  
  protected long a()
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.uin, 1);
    long l = 0L;
    if (localMessage != null) {
      l = localMessage.time;
    }
    return l;
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
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return null;
    case 0: 
      return String.format("%s(%s)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin });
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    String str1;
    String str2;
    label41:
    String str3;
    String str4;
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname.toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin == null) {
        break label198;
      }
      str2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
      str3 = this.b;
      str4 = this.jdField_c_of_type_JavaLangString;
      paramString = paramString.toLowerCase();
      this.x = -9223372036854775808L;
      if ((str1 == null) || (str1.length() == 0)) {
        break label357;
      }
      if ((!str1.equals(paramString)) && ((str3 == null) || (!str3.equals(paramString))) && ((str4 == null) || (!str4.equals(paramString)))) {
        break label216;
      }
      if (1125899906842624L > this.x)
      {
        if ((str1.equals(paramString)) || (str1.equals(str3))) {
          break label204;
        }
        l = 1125899906842624L + 4503599627370496L;
        label154:
        this.x = (l + 0L);
        this.jdField_c_of_type_Int = 1;
      }
      if (this.x == -9223372036854775808L) {
        break label357;
      }
      this.x += this.y;
    }
    label198:
    label204:
    label216:
    int i;
    label236:
    label248:
    while (str2 == null)
    {
      return;
      str1 = null;
      break;
      str2 = null;
      break label41;
      l = 1125899906842624L + 9007199254740992L;
      break label154;
      int k = str1.indexOf(paramString);
      int j;
      if (str3 != null)
      {
        i = str3.indexOf(paramString);
        if (str4 == null) {
          break label333;
        }
        j = str4.indexOf(paramString);
        if ((k < 0) && (i < 0) && (j < 0)) {
          break label336;
        }
        if ((k != 0) && (i != 0) && (j != 0)) {
          break label338;
        }
        l = 562949953421312L;
        if (l <= this.x) {
          break label344;
        }
        if ((k >= 0) || (str1.equals(str3))) {
          break label346;
        }
      }
      for (l += 4503599627370496L;; l += 9007199254740992L)
      {
        this.x = (l + 0L);
        this.jdField_c_of_type_Int = 1;
        break;
        i = -1;
        break label236;
        j = -1;
        break label248;
        break;
        l = 281474976710656L;
        break label279;
        break;
      }
    }
    label279:
    label333:
    label336:
    label338:
    label344:
    label346:
    label357:
    if (str2.equals(paramString)) {
      if (1125899906842624L > this.x)
      {
        this.x = (1125899906842624L + 9007199254740992L + 0L);
        this.jdField_c_of_type_Int = 0;
      }
    }
    label400:
    label475:
    label481:
    for (;;)
    {
      if (this.x != -9223372036854775808L)
      {
        this.x += this.y;
        return;
        i = str2.indexOf(paramString);
        if (i < 0) {
          continue;
        }
        if (i != 0) {
          break label475;
        }
      }
      for (l = 562949953421312L;; l = 281474976710656L)
      {
        if (l <= this.x) {
          break label481;
        }
        this.x = (l + 9007199254740992L + 0L);
        this.jdField_c_of_type_Int = 0;
        break label400;
        break;
      }
    }
  }
  
  public int b()
  {
    return 4;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String c()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchableTroop
 * JD-Core Version:    0.7.0.1
 */