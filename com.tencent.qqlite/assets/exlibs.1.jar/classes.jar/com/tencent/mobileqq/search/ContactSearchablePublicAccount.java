package com.tencent.mobileqq.search;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.BaseApplication;

public class ContactSearchablePublicAccount
  extends IContactSearchable
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PublicAccountInfo jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public ContactSearchablePublicAccount(QQAppInterface paramQQAppInterface, PublicAccountInfo paramPublicAccountInfo, String paramString, long paramLong)
  {
    this(paramQQAppInterface, paramPublicAccountInfo, paramString, 0L, paramLong);
  }
  
  public ContactSearchablePublicAccount(QQAppInterface paramQQAppInterface, PublicAccountInfo paramPublicAccountInfo, String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.y = paramLong2;
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = paramPublicAccountInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
    ChnToSpell.a(paramQQAppInterface.a());
    this.b = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name, 1).toLowerCase();
    this.c = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name, 2).toLowerCase();
    a();
  }
  
  private long a(String paramString1, String paramString2, String paramString3)
  {
    long l2 = -9223372036854775808L;
    long l1 = l2;
    int i;
    if (paramString1 != null)
    {
      i = paramString1.indexOf(paramString2);
      if (i != 0) {
        break label33;
      }
      l1 = 562949953421312L;
    }
    label33:
    do
    {
      return l1;
      l1 = l2;
    } while (i <= 0);
    return 281474976710656L;
  }
  
  private long b(String paramString1, String paramString2, String paramString3)
  {
    long l2 = -9223372036854775808L;
    long l1 = l2;
    int i;
    if (paramString1 != null)
    {
      i = paramString1.indexOf(paramString2.toLowerCase());
      if (i != 0) {
        break label36;
      }
      l1 = 562949953421312L;
    }
    label36:
    do
    {
      return l1;
      l1 = l2;
    } while (i <= 0);
    return 281474976710656L;
  }
  
  public int a()
  {
    return 0;
  }
  
  public Drawable a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.certifiedGrade <= 0L) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDrawable(2130838183);
  }
  
  public PublicAccountInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2) {
      return String.format("%s(%s)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.displayNumber) });
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
  }
  
  public void a(String paramString)
  {
    this.x = -9223372036854775808L;
    if (((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name.equalsIgnoreCase(paramString))) || ((this.b != null) && (this.b.equalsIgnoreCase(paramString))) || ((this.c != null) && (this.c.equalsIgnoreCase(paramString))))
    {
      this.x = 1125899906842624L;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name.equals(paramString)) && (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name.equals(this.b)))
      {
        this.x += 4503599627370496L;
        this.x = 1125899906842624L;
        label134:
        if (this.x == -9223372036854775808L) {
          break label313;
        }
        this.x += this.y + 0L;
      }
    }
    long l1;
    label313:
    String str;
    do
    {
      return;
      this.x += 9007199254740992L;
      break;
      l1 = a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name, paramString, this.b);
      long l2 = b(this.b, paramString, this.b);
      long l3 = b(this.c, paramString, this.b);
      this.x = Math.max(l1, l2);
      this.x = Math.max(this.x, l3);
      if (this.x == -9223372036854775808L) {
        break label134;
      }
      if ((this.x != l1) && (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name.equals(this.b)))
      {
        this.x += 4503599627370496L;
        break label134;
      }
      this.x += 9007199254740992L;
      break label134;
      str = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.displayNumber;
    } while ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType != 2));
    if (str.equals(paramString)) {
      if (1125899906842624L > this.x) {
        this.x += 9007199254740992L;
      }
    }
    label443:
    label448:
    for (;;)
    {
      label373:
      if (this.x != -9223372036854775808L)
      {
        this.x += this.y + 0L;
        return;
        int i = str.indexOf(paramString);
        if (i < 0) {
          continue;
        }
        if (i != 0) {
          break label443;
        }
      }
      for (l1 = 562949953421312L;; l1 = 281474976710656L)
      {
        if (l1 <= this.x) {
          break label448;
        }
        this.x += 9007199254740992L;
        break label373;
        break;
      }
    }
  }
  
  public int b()
  {
    return 1;
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
    return String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchablePublicAccount
 * JD-Core Version:    0.7.0.1
 */