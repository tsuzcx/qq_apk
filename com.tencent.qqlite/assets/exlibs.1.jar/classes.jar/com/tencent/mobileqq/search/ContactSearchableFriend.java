package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;

public class ContactSearchableFriend
  extends IContactSearchable
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int jdField_b_of_type_Int = 1;
  private static final int jdField_c_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  private String jdField_a_of_type_JavaLangString;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  
  public ContactSearchableFriend(Context paramContext, QQAppInterface paramQQAppInterface, Friends paramFriends, String paramString, long paramLong)
  {
    this(paramContext, paramQQAppInterface, paramFriends, paramString, 0L, paramLong);
  }
  
  @SuppressLint({"DefaultLocale"})
  public ContactSearchableFriend(Context paramContext, QQAppInterface paramQQAppInterface, Friends paramFriends, String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = paramFriends;
    this.y = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ChnToSpell.a(paramContext);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark.length() != 0))
    {
      this.b = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, 1).toLowerCase();
      this.c = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, 2).toLowerCase();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.name != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.length() != 0))
    {
      this.d = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, 1).toLowerCase();
      this.jdField_e_of_type_JavaLangString = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, 2).toLowerCase();
    }
    a();
  }
  
  private String e()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
  
  public int a()
  {
    return 0;
  }
  
  protected long a()
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 0);
    if (localMessage != null) {
      return localMessage.time;
    }
    return 0L;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public Friends a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends;
  }
  
  public String a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
    String str1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      localObject2 = null;
    case 0: 
    case 2: 
      do
      {
        do
        {
          return localObject2;
          if (((str1 != null) && (str1.length() != 0)) || ((localObject1 != null) && (((String)localObject1).length() != 0)))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject1 = str1;
            }
            for (;;)
            {
              localObject1 = String.format("%s", new Object[] { localObject1 });
              this.f = e();
              return localObject1;
            }
          }
          return str2;
          localObject2 = localObject1;
        } while (str1 == null);
        localObject2 = localObject1;
      } while (str1.length() == 0);
      localObject1 = String.format("%s", new Object[] { localObject1 });
      this.f = str1;
      return localObject1;
    case 1: 
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        localObject1 = String.format("%s", new Object[] { localObject1 });
        this.f = str1;
        return localObject1;
      }
      localObject1 = String.format("%s", new Object[] { str1 });
      this.f = e();
      return localObject1;
    }
    if (((str1 != null) && (str1.length() != 0)) || ((localObject1 != null) && (((String)localObject1).length() != 0)))
    {
      localObject1 = String.format("%s", new Object[] { ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends) });
      this.f = ((String)localObject2);
      return localObject1;
    }
    return localObject2;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    String str1;
    String str2;
    label44:
    String str3;
    label63:
    String str4;
    label82:
    String str5;
    String str6;
    String str7;
    String str8;
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark.toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.name == null) {
        break label251;
      }
      str2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin == null) {
        break label257;
      }
      str3 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias == null) {
        break label263;
      }
      str4 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
      str5 = this.b;
      str6 = this.c;
      str7 = this.d;
      str8 = this.jdField_e_of_type_JavaLangString;
      paramString = paramString.toLowerCase();
      this.x = -9223372036854775808L;
      if ((str1 == null) || (str1.length() == 0)) {
        break label422;
      }
      if ((!str1.equals(paramString)) && ((str5 == null) || (!str5.equals(paramString))) && ((str6 == null) || (!str6.equals(paramString)))) {
        break label281;
      }
      if (1125899906842624L > this.x)
      {
        if ((str1.equals(paramString)) || (str1.equals(str5))) {
          break label269;
        }
        l = 1125899906842624L + 4503599627370496L;
        label207:
        this.x = (l + 0L);
        this.jdField_e_of_type_Int = 2;
      }
      if (this.x == -9223372036854775808L) {
        break label422;
      }
      this.x += this.y;
    }
    label251:
    int i;
    label257:
    label263:
    label269:
    label281:
    label301:
    label313:
    label344:
    label605:
    label617:
    label750:
    do
    {
      return;
      str1 = null;
      break;
      str2 = null;
      break label44;
      str3 = null;
      break label63;
      str4 = null;
      break label82;
      l = 1125899906842624L + 9007199254740992L;
      break label207;
      int k = str1.indexOf(paramString);
      int j;
      if (str5 != null)
      {
        i = str5.indexOf(paramString);
        if (str6 == null) {
          break label398;
        }
        j = str6.indexOf(paramString);
        if ((k < 0) && (i < 0) && (j < 0)) {
          break label401;
        }
        if ((k != 0) && (i != 0) && (j != 0)) {
          break label403;
        }
        l = 562949953421312L;
        if (l <= this.x) {
          break label409;
        }
        if ((k >= 0) || (str1.equals(str5))) {
          break label411;
        }
      }
      for (l += 4503599627370496L;; l += 9007199254740992L)
      {
        this.x = (l + 0L);
        this.jdField_e_of_type_Int = 2;
        break;
        i = -1;
        break label301;
        j = -1;
        break label313;
        break;
        l = 281474976710656L;
        break label344;
        break;
      }
      if ((str2 != null) && (str2.length() != 0))
      {
        if ((str2.equals(paramString)) || ((str7 != null) && (str7.equals(paramString))) || ((str8 != null) && (str8.equals(paramString))))
        {
          if (1125899906842624L > this.x)
          {
            if ((str2.equals(paramString)) || (str2.equals(str7))) {
              break label562;
            }
            l = 4503599627370496L + 1125899906842624L;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
              break label574;
            }
          }
          for (this.x = (l + 0L);; this.x = (l + 0L))
          {
            this.jdField_e_of_type_Int = 1;
            if (this.x == -9223372036854775808L) {
              break label750;
            }
            this.x += this.y;
            return;
            l = 9007199254740992L + 1125899906842624L;
            break;
          }
        }
        k = str2.indexOf(paramString);
        if (str7 != null)
        {
          i = str7.indexOf(paramString);
          if (str8 == null) {
            break label715;
          }
          j = str8.indexOf(paramString);
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label718;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label720;
          }
          l = 562949953421312L;
          if (l <= this.x) {
            break label726;
          }
          if ((k >= 0) || (str2.equals(str7))) {
            break label728;
          }
          l = 4503599627370496L + l;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
            break label739;
          }
        }
        for (this.x = (l + 0L);; this.x = (l + 0L))
        {
          this.jdField_e_of_type_Int = 1;
          break;
          i = -1;
          break label605;
          j = -1;
          break label617;
          break;
          l = 281474976710656L;
          break label648;
          break;
          l = 9007199254740992L + l;
          break label681;
        }
      }
      if ((str4 != null) && (str4.length() != 0))
      {
        if (str4.equals(paramString)) {
          if (1125899906842624L > this.x)
          {
            l = 1125899906842624L + 9007199254740992L;
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
              break label856;
            }
            this.x = (l + 0L);
            this.jdField_e_of_type_Int = 3;
          }
        }
        for (;;)
        {
          if (this.x != -9223372036854775808L)
          {
            this.x += this.y;
            return;
            this.x = (l + 0L);
            break;
            if ((str4.indexOf(paramString) >= 0) && (281474976710656L > this.x))
            {
              l = 281474976710656L + 9007199254740992L;
              if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {}
              for (this.x = (l + 0L);; this.x = (l + 0L))
              {
                this.jdField_e_of_type_Int = 3;
                break;
              }
            }
          }
        }
      }
    } while (1 == this.jdField_a_of_type_ComTencentMobileqqDataFriends.cSpecialFlag);
    label398:
    label401:
    label403:
    label409:
    label411:
    label422:
    label562:
    label574:
    label715:
    label718:
    label720:
    label726:
    label728:
    label739:
    if (str3 != null)
    {
      if (!str3.equals(paramString)) {
        break label1069;
      }
      if (1125899906842624L > this.x)
      {
        l = 1125899906842624L + 9007199254740992L;
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
          break label1058;
        }
        this.x = (l + 0L);
        this.jdField_e_of_type_Int = 0;
      }
    }
    label648:
    label681:
    label1069:
    label1089:
    for (;;)
    {
      label856:
      if (this.x != -9223372036854775808L)
      {
        this.x += this.y;
        return;
        this.x = (l + 0L);
        break;
        i = str3.indexOf(paramString);
        if (i >= 0)
        {
          if (i != 0) {
            break label1149;
          }
          l = 562949953421312L;
          if (l <= this.x) {
            break label1155;
          }
          l += 9007199254740992L;
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
            break label1157;
          }
        }
      }
    }
    label1033:
    label1058:
    for (this.x = (l + 0L);; this.x = (l + 0L))
    {
      this.jdField_e_of_type_Int = 0;
      break label1033;
      break;
      label1149:
      l = 281474976710656L;
      break label1089;
      break label1033;
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
    if (this.f != null) {
      return String.format("(%s)", new Object[] { this.f });
    }
    return null;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchableFriend
 * JD-Core Version:    0.7.0.1
 */