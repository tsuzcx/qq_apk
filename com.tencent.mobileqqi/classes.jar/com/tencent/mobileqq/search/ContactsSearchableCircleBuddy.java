package com.tencent.mobileqq.search;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.utils.ChnToSpell;

public class ContactsSearchableCircleBuddy
  extends IContactSearchable
{
  public static final int a = 0;
  public static boolean a = false;
  public static final int b = 1;
  public static boolean b = false;
  public static final int c = 2;
  private static final int jdField_d_of_type_Int = 0;
  private static final int jdField_e_of_type_Int = 1;
  private static final int jdField_f_of_type_Int = 2;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CircleBuddy jdField_a_of_type_ComTencentMobileqqDataCircleBuddy;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String jdField_d_of_type_JavaLangString;
  private String jdField_e_of_type_JavaLangString;
  private String jdField_f_of_type_JavaLangString;
  private int g;
  private int h;
  private long y;
  
  public ContactsSearchableCircleBuddy(Context paramContext, QQAppInterface paramQQAppInterface, CircleBuddy paramCircleBuddy, long paramLong, int paramInt, String paramString)
  {
    this(paramContext, paramQQAppInterface, paramCircleBuddy, 131072L, paramLong, paramInt, paramString);
  }
  
  public ContactsSearchableCircleBuddy(Context paramContext, QQAppInterface paramQQAppInterface, CircleBuddy paramCircleBuddy, long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy = paramCircleBuddy;
    this.w = this.w;
    this.y = paramLong1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.h = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    ChnToSpell.a(paramContext);
    if ((paramCircleBuddy.remark != null) && (paramCircleBuddy.remark.length() != 0))
    {
      this.jdField_b_of_type_JavaLangString = ChnToSpell.a(paramCircleBuddy.remark, 1);
      this.c = ChnToSpell.a(paramCircleBuddy.remark, 2);
    }
    if ((paramCircleBuddy.nickName != null) && (paramCircleBuddy.nickName.length() != 0))
    {
      this.d = ChnToSpell.a(paramCircleBuddy.nickName, 1);
      this.e = ChnToSpell.a(paramCircleBuddy.nickName, 2);
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
  
  public CircleBuddy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy;
  }
  
  public String a()
  {
    String str = BaseApplicationImpl.getContext().getString(2131559285);
    switch (this.h)
    {
    default: 
      return str;
    case 0: 
      return BaseApplicationImpl.getContext().getString(2131559285);
    case 1: 
      return this.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a(String paramString)
  {
    String str1;
    String str2;
    label44:
    String str3;
    String str4;
    String str5;
    String str6;
    long l2;
    long l1;
    long l4;
    long l3;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.remark != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.remark.toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.nickName == null) {
        break label235;
      }
      str2 = this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.nickName.toLowerCase();
      String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin);
      str3 = this.jdField_b_of_type_JavaLangString;
      str4 = this.c;
      str5 = this.d;
      str6 = this.e;
      paramString = paramString.toLowerCase();
      l2 = -9223372036854775808L;
      this.v = -9223372036854775808L;
      l1 = 0L;
      l4 = l1;
      l3 = l2;
      if (str1 == null) {
        break label495;
      }
      l4 = l1;
      l3 = l2;
      if (str1.length() == 0) {
        break label495;
      }
      if (!str1.equals(paramString)) {
        break label246;
      }
      l1 = this.y;
      if ((str3 == null) || (str3.length() <= 0)) {
        break label241;
      }
      i = str3.charAt(0);
      label163:
      l2 = 0x0 | l1 | i;
      l1 = 9007199254740992L;
    }
    label235:
    label241:
    label246:
    int k;
    label334:
    label362:
    int j;
    for (;;)
    {
      l4 = l1;
      l3 = l2;
      if (l2 <= this.v) {
        break label495;
      }
      this.v = (144115188075855872L + l2 + l1 + this.w);
      jdField_a_of_type_Boolean = true;
      jdField_b_of_type_Boolean = true;
      this.g = 2;
      return;
      str1 = null;
      break;
      str2 = null;
      break label44;
      i = 0;
      break label163;
      if (((str3 != null) && (str3.equals(paramString))) || ((str4 != null) && (str4.equals(paramString))))
      {
        l1 = this.y;
        if ((str3 != null) && (str3.length() > 0)) {}
        for (i = str3.charAt(0);; i = 0)
        {
          l2 = 0x0 | l1 | i;
          if (str1.equals(str3)) {
            break label334;
          }
          l1 = 4503599627370496L;
          break;
        }
        l1 = 9007199254740992L;
      }
      else
      {
        k = str1.indexOf(paramString);
        if (str3 != null)
        {
          i = str3.indexOf(paramString);
          if (str4 == null) {
            break label469;
          }
          j = str4.indexOf(paramString);
          label374:
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label472;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label474;
          }
          l1 = 562949953421312L;
          label405:
          l2 = this.y;
          if ((str3 == null) || (str3.length() <= 0)) {
            break label482;
          }
        }
        label469:
        label472:
        label474:
        label482:
        for (i = str3.charAt(0);; i = 0)
        {
          l2 = l2 | i | l1;
          if ((k >= 0) || (str1.equals(str3))) {
            break label487;
          }
          l1 = 4503599627370496L;
          break;
          i = -1;
          break label362;
          j = -1;
          break label374;
          break;
          l1 = 281474976710656L;
          break label405;
        }
        label487:
        l1 = 9007199254740992L;
      }
    }
    label495:
    if ((str2 != null) && (str2.length() != 0))
    {
      if (!str2.equals(paramString)) {
        break label641;
      }
      l1 = this.y;
      if ((str5 == null) || (str5.length() == 0)) {
        break label636;
      }
      i = str5.charAt(0);
      l2 = 0x0 | l1 | i;
      l1 = 9007199254740992L;
    }
    for (;;)
    {
      label543:
      label559:
      if (l2 > this.v) {
        if (!TextUtils.isEmpty(str1)) {
          break label880;
        }
      }
      label641:
      label719:
      label747:
      label880:
      for (this.v = (l2 + 144115188075855872L);; this.v = (l2 + 72057594037927936L))
      {
        this.v += l1;
        this.g = 1;
        if (this.v == -9223372036854775808L) {
          break;
        }
        this.v += this.w;
        jdField_a_of_type_Boolean = true;
        jdField_b_of_type_Boolean = true;
        return;
        label636:
        i = 0;
        break label543;
        if ((str5.equals(paramString)) || (str6.equals(paramString)))
        {
          l1 = this.y;
          if ((str5 != null) && (str5.length() != 0)) {}
          for (i = str5.charAt(0);; i = 0)
          {
            l2 = 0x0 | l1 | i;
            if (str2.equals(str5)) {
              break label719;
            }
            l1 = 4503599627370496L;
            break;
          }
          l1 = 9007199254740992L;
          break label559;
        }
        k = str2.indexOf(paramString);
        if (str5 != null)
        {
          i = str5.indexOf(paramString);
          if (str6 == null) {
            break label854;
          }
          j = str6.indexOf(paramString);
          label759:
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label893;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label859;
          }
          l1 = 562949953421312L;
          l2 = this.y;
          if ((str5 == null) || (str5.length() <= 0)) {
            break label867;
          }
        }
        for (i = str5.charAt(0);; i = 0)
        {
          l2 = l1 | l2 | i;
          if ((k >= 0) || (str2.equals(str5))) {
            break label872;
          }
          l1 = 4503599627370496L;
          break;
          i = -1;
          break label747;
          j = -1;
          break label759;
          l1 = 281474976710656L;
          break label790;
        }
        l1 = 9007199254740992L;
        break label559;
      }
      label790:
      label854:
      label859:
      label867:
      label872:
      label893:
      l1 = l4;
      l2 = l3;
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    if (!TextUtils.isEmpty(this.f)) {
      return String.format("(%s)", new Object[] { this.f });
    }
    return null;
  }
  
  public String c()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.remark;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.nickName;
    if (TextUtils.isEmpty(str1))
    {
      this.f = null;
      return str2;
    }
    this.f = str2;
    return str1;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactsSearchableCircleBuddy
 * JD-Core Version:    0.7.0.1
 */