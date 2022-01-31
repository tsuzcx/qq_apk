package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;

public class ContactsSearchablePhoneContact
  extends IContactSearchable
{
  private Context jdField_a_of_type_AndroidContentContext;
  public PhoneContact a;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private long y;
  
  public ContactsSearchablePhoneContact(Context paramContext, QQAppInterface paramQQAppInterface, PhoneContact paramPhoneContact, long paramLong)
  {
    this(paramContext, paramQQAppInterface, paramPhoneContact, 65536L, paramLong);
  }
  
  @SuppressLint({"DefaultLocale"})
  public ContactsSearchablePhoneContact(Context paramContext, QQAppInterface paramQQAppInterface, PhoneContact paramPhoneContact, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.w = paramLong2;
    this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
    this.jdField_a_of_type_JavaLangString = paramPhoneContact.name;
    if (this.jdField_a_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.toLowerCase();
    }
    this.b = paramPhoneContact.mobileNo;
    this.c = paramPhoneContact.pinyinAll.toLowerCase();
    this.d = paramPhoneContact.pinyinInitial.toLowerCase();
  }
  
  public int a()
  {
    return 0;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public PhoneContact a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getString(2131562601);
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    paramString = paramString.toLowerCase();
    this.v = -9223372036854775808L;
    long l1;
    int i;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() != 0)) {
      if (this.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        l1 = this.y;
        if ((this.c != null) && (this.c.length() > 0))
        {
          i = this.c.charAt(0);
          l1 = (0x0 | l1 | i) + 9007199254740992L;
        }
      }
    }
    for (;;)
    {
      if (l1 > this.v)
      {
        this.v = (l1 + 144115188075855872L + this.w);
        return;
        i = 0;
        break;
        if (((this.c != null) && (this.c.equals(paramString))) || ((this.d != null) && (this.d.equals(paramString))))
        {
          l1 = this.y;
          if ((this.c != null) && (this.c.length() > 0)) {}
          for (i = this.c.charAt(0);; i = 0)
          {
            l1 = 0x0 | l1 | i;
            if (this.jdField_a_of_type_JavaLangString.equals(this.c)) {
              break label227;
            }
            l1 += 4503599627370496L;
            break;
          }
          label227:
          l1 += 9007199254740992L;
          continue;
        }
        int k = this.jdField_a_of_type_JavaLangString.indexOf(paramString);
        label264:
        int j;
        label280:
        label311:
        long l2;
        if (this.c != null)
        {
          i = this.c.indexOf(paramString);
          if (this.d == null) {
            break label402;
          }
          j = this.d.indexOf(paramString);
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label594;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label407;
          }
          l1 = 562949953421312L;
          l2 = this.y;
          if ((this.c == null) || (this.c.length() <= 0)) {
            break label415;
          }
        }
        label402:
        label407:
        label415:
        for (i = this.c.charAt(0);; i = 0)
        {
          l2 = l1 | i | l2;
          l1 = l2;
          if (l2 <= this.v) {
            break;
          }
          if ((k >= 0) || (this.jdField_a_of_type_JavaLangString.equals(this.c))) {
            break label420;
          }
          l1 = l2 + 4503599627370496L;
          break;
          i = -1;
          break label264;
          j = -1;
          break label280;
          l1 = 281474976710656L;
          break label311;
        }
        label420:
        l1 = l2 + 9007199254740992L;
        continue;
      }
      if (this.b != null)
      {
        if (!this.b.equals(paramString)) {
          break label518;
        }
        l1 = 0x0 | this.y | this.b.charAt(0);
        if (l1 > this.v) {
          this.v = (l1 + 9007199254740992L + 72057594037927936L);
        }
      }
      label493:
      while (this.v != -9223372036854775808L)
      {
        this.v += this.w;
        return;
        i = this.b.indexOf(paramString);
        if (i >= 0) {
          if (i != 0) {
            break label586;
          }
        }
      }
      label518:
      label586:
      for (l1 = 562949953421312L;; l1 = 281474976710656L)
      {
        l1 = l1 | this.y | this.b.charAt(0);
        if (l1 <= this.v) {
          break label493;
        }
        this.v = (l1 + 9007199254740992L + 72057594037927936L);
        break label493;
        break;
      }
      label594:
      l1 = -9223372036854775808L;
    }
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin == null) || (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin.equals("0"))) {
      return 11;
    }
    return 1;
  }
  
  public String b()
  {
    return String.format("(%s)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo });
  }
  
  public String c()
  {
    return String.format("%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name });
  }
  
  public String d()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!str2.equals("0")) {}
    }
    else
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.lookupID;
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactsSearchablePhoneContact
 * JD-Core Version:    0.7.0.1
 */