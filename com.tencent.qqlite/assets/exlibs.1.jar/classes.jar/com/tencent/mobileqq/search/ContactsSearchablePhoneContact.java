package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.PhoneContact;

public class ContactsSearchablePhoneContact
  extends IContactSearchable
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public PhoneContact a;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  
  public ContactsSearchablePhoneContact(Context paramContext, QQAppInterface paramQQAppInterface, PhoneContact paramPhoneContact, long paramLong)
  {
    this(paramContext, paramQQAppInterface, paramPhoneContact, 0L, paramLong);
  }
  
  @SuppressLint({"DefaultLocale"})
  public ContactsSearchablePhoneContact(Context paramContext, QQAppInterface paramQQAppInterface, PhoneContact paramPhoneContact, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.y = paramLong2;
    this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
    this.jdField_a_of_type_JavaLangString = paramPhoneContact.name;
    if (this.jdField_a_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.toLowerCase();
    }
    this.b = paramPhoneContact.mobileNo;
    this.c = paramPhoneContact.pinyinAll.toLowerCase();
    this.d = paramPhoneContact.pinyinInitial.toLowerCase();
    a();
  }
  
  public int a()
  {
    return 0;
  }
  
  protected long a()
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nationCode + this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileCode, 1);
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
  
  public PhoneContact a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
  }
  
  public String a()
  {
    return String.format("%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name });
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    int j = -1;
    paramString = paramString.toLowerCase();
    this.x = -9223372036854775808L;
    long l1;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() != 0)) {
      if (this.jdField_a_of_type_JavaLangString.equals(paramString)) {
        l1 = 1125899906842624L + 9007199254740992L;
      }
    }
    for (;;)
    {
      int i;
      if (l1 > this.x)
      {
        this.x = (l1 + 0L + this.y);
        return;
        if (((this.c != null) && (this.c.equals(paramString))) || ((this.d != null) && (this.d.equals(paramString))))
        {
          if (!this.jdField_a_of_type_JavaLangString.equals(this.c))
          {
            l1 = 4503599627370496L + 1125899906842624L;
            continue;
          }
          l1 = 1125899906842624L + 9007199254740992L;
          continue;
        }
        int k = this.jdField_a_of_type_JavaLangString.indexOf(paramString);
        if (this.c != null)
        {
          i = this.c.indexOf(paramString);
          label175:
          if (this.d != null) {
            j = this.d.indexOf(paramString);
          }
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label412;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label271;
          }
        }
        label271:
        for (long l2 = 562949953421312L;; l2 = 281474976710656L)
        {
          l1 = l2;
          if (l2 <= this.x) {
            break;
          }
          if ((k >= 0) || (this.jdField_a_of_type_JavaLangString.equals(this.c))) {
            break label279;
          }
          l1 = l2 + 4503599627370496L;
          break;
          i = -1;
          break label175;
        }
        label279:
        l1 = l2 + 9007199254740992L;
      }
      else
      {
        if (this.b != null)
        {
          if (!this.b.equals(paramString)) {
            break label357;
          }
          if (1125899906842624L > this.x) {
            this.x = (1125899906842624L + 9007199254740992L + 0L);
          }
        }
        label404:
        label410:
        for (;;)
        {
          label332:
          if (this.x != -9223372036854775808L)
          {
            this.x += this.y;
            return;
            label357:
            i = this.b.indexOf(paramString);
            if (i < 0) {
              continue;
            }
            if (i != 0) {
              break label404;
            }
          }
          for (l1 = 562949953421312L;; l1 = 281474976710656L)
          {
            if (l1 <= this.x) {
              break label410;
            }
            this.x = (l1 + 9007199254740992L + 0L);
            break label332;
            break;
          }
        }
      }
      label412:
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
    return this.jdField_a_of_type_AndroidContentContext.getString(2131364184);
  }
  
  public String c()
  {
    return String.format("(%s)", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo });
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
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nationCode + this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileCode;
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactsSearchablePhoneContact
 * JD-Core Version:    0.7.0.1
 */