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
  private long y;
  
  public ContactSearchablePublicAccount(QQAppInterface paramQQAppInterface, PublicAccountInfo paramPublicAccountInfo, String paramString, long paramLong)
  {
    this(paramQQAppInterface, paramPublicAccountInfo, paramString, 131072L, paramLong);
  }
  
  public ContactSearchablePublicAccount(QQAppInterface paramQQAppInterface, PublicAccountInfo paramPublicAccountInfo, String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.w = paramLong2;
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = paramPublicAccountInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.y = paramLong1;
    ChnToSpell.a(paramQQAppInterface.a());
    this.b = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name, 1).toLowerCase();
    this.c = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name, 2).toLowerCase();
  }
  
  private long a(String paramString1, String paramString2, String paramString3)
  {
    int k = 0;
    int j = 0;
    if (paramString1 != null)
    {
      int i = paramString1.indexOf(paramString2);
      long l;
      if (i == 0)
      {
        l = this.y;
        i = j;
        if (paramString3 != null)
        {
          i = j;
          if (paramString3.length() > 0) {
            i = paramString3.charAt(0);
          }
        }
        return 0x0 | l | i;
      }
      if (i > 0)
      {
        l = this.y;
        i = k;
        if (paramString3 != null)
        {
          i = k;
          if (paramString3.length() > 0) {
            i = paramString3.charAt(0);
          }
        }
        return 0x0 | l | i;
      }
    }
    return -9223372036854775808L;
  }
  
  private long b(String paramString1, String paramString2, String paramString3)
  {
    int k = 0;
    int j = 0;
    if (paramString1 != null)
    {
      int i = paramString1.indexOf(paramString2.toLowerCase());
      long l;
      if (i == 0)
      {
        l = this.y;
        i = j;
        if (paramString3 != null)
        {
          i = j;
          if (paramString3.length() > 0) {
            i = paramString3.charAt(0);
          }
        }
        return 0x0 | l | i;
      }
      if (i > 0)
      {
        l = this.y;
        i = k;
        if (paramString3 != null)
        {
          i = k;
          if (paramString3.length() > 0) {
            i = paramString3.charAt(0);
          }
        }
        return 0x0 | l | i;
      }
    }
    return -9223372036854775808L;
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
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDrawable(2130838179);
  }
  
  public PublicAccountInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    this.v = -9223372036854775808L;
    if (((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name.equalsIgnoreCase(paramString))) || ((this.b != null) && (this.b.equalsIgnoreCase(paramString))) || ((this.c != null) && (this.c.equalsIgnoreCase(paramString))))
    {
      this.v = (0x0 | this.y);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name.equals(paramString)) && (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name.equals(this.b)))
      {
        this.v += 4503599627370496L;
        this.v = (0x0 | this.y);
        label144:
        if (this.v == -9223372036854775808L) {
          break label325;
        }
        this.v += this.w + 144115188075855872L;
      }
    }
    long l1;
    label325:
    String str;
    do
    {
      return;
      this.v += 9007199254740992L;
      break;
      l1 = a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name, paramString, this.b);
      long l2 = b(this.b, paramString, this.b);
      long l3 = b(this.c, paramString, this.b);
      this.v = Math.max(l1, l2);
      this.v = Math.max(this.v, l3);
      if (this.v == -9223372036854775808L) {
        break label144;
      }
      if ((this.v != l1) && (!this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name.equals(this.b)))
      {
        this.v += 4503599627370496L;
        break label144;
      }
      this.v += 9007199254740992L;
      break label144;
      str = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.displayNumber;
    } while ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType != 2));
    if (str.equals(paramString)) {
      if ((0x0 | this.y | str.charAt(0)) > this.v) {
        this.v += 9007199254740992L;
      }
    }
    label398:
    label483:
    label488:
    for (;;)
    {
      if (this.v != -9223372036854775808L)
      {
        this.v += this.w + 144115188075855872L;
        return;
        int i = str.indexOf(paramString);
        if (i < 0) {
          continue;
        }
        if (i != 0) {
          break label483;
        }
      }
      for (l1 = 562949953421312L;; l1 = 281474976710656L)
      {
        if ((l1 | this.y | str.charAt(0)) <= this.v) {
          break label488;
        }
        this.v += 9007199254740992L;
        break label398;
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
    return null;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2) {
      return String.format("%s(%s)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.displayNumber) });
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
  }
  
  public String d()
  {
    return String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchablePublicAccount
 * JD-Core Version:    0.7.0.1
 */