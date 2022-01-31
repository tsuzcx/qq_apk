package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
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
  private long y;
  
  public ContactSearchableFriend(Context paramContext, QQAppInterface paramQQAppInterface, Friends paramFriends, String paramString, long paramLong)
  {
    this(paramContext, paramQQAppInterface, paramFriends, paramString, 131072L, paramLong);
  }
  
  @SuppressLint({"DefaultLocale"})
  public ContactSearchableFriend(Context paramContext, QQAppInterface paramQQAppInterface, Friends paramFriends, String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = paramFriends;
    this.w = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.y = paramLong1;
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
    return this.jdField_a_of_type_JavaLangString;
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
    long l1;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark.toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.name == null) {
        break label288;
      }
      str2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin == null) {
        break label294;
      }
      str3 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias == null) {
        break label300;
      }
      str4 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
      str5 = this.b;
      str6 = this.c;
      str7 = this.d;
      str8 = this.jdField_e_of_type_JavaLangString;
      paramString = paramString.toLowerCase();
      this.v = -9223372036854775808L;
      if ((str1 == null) || (str1.length() == 0)) {
        break label506;
      }
      if ((!str1.equals(paramString)) && ((str5 == null) || (!str5.equals(paramString))) && ((str6 == null) || (!str6.equals(paramString)))) {
        break label322;
      }
      l1 = this.y;
      if ((str5 == null) || (str5.length() <= 0)) {
        break label306;
      }
      i = str5.charAt(0);
      label194:
      l1 = 0x0 | l1 | i;
      if (l1 > this.v)
      {
        if ((str1.equals(paramString)) || (str1.equals(str5))) {
          break label311;
        }
        l1 += 4503599627370496L;
        label242:
        this.v = (l1 + 144115188075855872L);
        this.jdField_e_of_type_Int = 2;
      }
      label257:
      if (this.v == -9223372036854775808L) {
        break label506;
      }
      this.v += this.w;
    }
    label288:
    label294:
    label300:
    label306:
    label311:
    label322:
    label342:
    label354:
    label490:
    label495:
    label506:
    label893:
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
      i = 0;
      break label194;
      l1 += 9007199254740992L;
      break label242;
      int k = str1.indexOf(paramString);
      int j;
      long l2;
      if (str5 != null)
      {
        i = str5.indexOf(paramString);
        if (str6 == null) {
          break label477;
        }
        j = str6.indexOf(paramString);
        if ((k < 0) && (i < 0) && (j < 0)) {
          break label480;
        }
        if ((k != 0) && (i != 0) && (j != 0)) {
          break label482;
        }
        l1 = 562949953421312L;
        l2 = this.y;
        if ((str5 == null) || (str5.length() <= 0)) {
          break label490;
        }
        i = str5.charAt(0);
        l1 |= l2 | i;
        if (l1 <= this.v) {
          break label257;
        }
        if ((k >= 0) || (str1.equals(str5))) {
          break label495;
        }
      }
      for (l1 += 4503599627370496L;; l1 += 9007199254740992L)
      {
        this.v = (l1 + 144115188075855872L);
        this.jdField_e_of_type_Int = 2;
        break;
        i = -1;
        break label342;
        j = -1;
        break label354;
        break;
        l1 = 281474976710656L;
        break label385;
        i = 0;
        break label411;
      }
      if ((str2 != null) && (str2.length() != 0))
      {
        if ((str2.equals(paramString)) || ((str7 != null) && (str7.equals(paramString))) || ((str8 != null) && (str8.equals(paramString))))
        {
          l1 = this.y;
          if ((str7 != null) && (str7.length() > 0))
          {
            i = str7.charAt(0);
            l1 = 0x0 | l1 | i;
            if (l1 > this.v)
            {
              if ((str2.equals(paramString)) || (str2.equals(str7))) {
                break label688;
              }
              l1 = 4503599627370496L + l1;
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
                break label699;
              }
              this.v = (l1 + 144115188075855872L);
              this.jdField_e_of_type_Int = 1;
            }
          }
        }
        for (;;)
        {
          if (this.v != -9223372036854775808L)
          {
            this.v += this.w;
            return;
            i = 0;
            break;
            l1 = 9007199254740992L + l1;
            break label630;
            this.v = (l1 + 72057594037927936L);
            break label653;
            k = str2.indexOf(paramString);
            if (str7 != null)
            {
              i = str7.indexOf(paramString);
              if (str8 == null) {
                break label880;
              }
              j = str8.indexOf(paramString);
              if ((k < 0) && (i < 0) && (j < 0)) {
                break label883;
              }
              if ((k != 0) && (i != 0) && (j != 0)) {
                break label885;
              }
              l1 = 562949953421312L;
              l2 = this.y;
              if ((str7 == null) || (str7.length() <= 0)) {
                break label893;
              }
              i = str7.charAt(0);
              l1 |= l2 | i;
              if (l1 <= this.v) {
                continue;
              }
              if ((k >= 0) || (str2.equals(str7))) {
                break label898;
              }
              l1 = 4503599627370496L + l1;
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
                break label909;
              }
            }
            for (this.v = (l1 + 144115188075855872L);; this.v = (l1 + 72057594037927936L))
            {
              this.jdField_e_of_type_Int = 1;
              break;
              i = -1;
              break label732;
              j = -1;
              break label744;
              break;
              l1 = 281474976710656L;
              break label775;
              i = 0;
              break label801;
              l1 = 9007199254740992L + l1;
              break label844;
            }
          }
        }
      }
      if ((str4 != null) && (str4.length() != 0))
      {
        if (str4.equals(paramString))
        {
          l1 = 0x0 | this.y | str4.charAt(0);
          if (l1 > this.v)
          {
            l1 += 9007199254740992L;
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
              break label1046;
            }
            this.v = (l1 + 144115188075855872L);
            this.jdField_e_of_type_Int = 3;
          }
        }
        for (;;)
        {
          if (this.v != -9223372036854775808L)
          {
            this.v += this.w;
            return;
            this.v = (l1 + 72057594037927936L);
            break;
            if (str4.indexOf(paramString) >= 0)
            {
              l1 = 0x0 | this.y | str4.charAt(0);
              if (l1 > this.v)
              {
                l1 += 9007199254740992L;
                if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {}
                for (this.v = (l1 + 144115188075855872L);; this.v = (l1 + 72057594037927936L))
                {
                  this.jdField_e_of_type_Int = 3;
                  break;
                }
              }
            }
          }
        }
      }
    } while (1 == this.jdField_a_of_type_ComTencentMobileqqDataFriends.cSpecialFlag);
    label385:
    label411:
    label477:
    label480:
    label482:
    label630:
    if (str3 != null)
    {
      if (!str3.equals(paramString)) {
        break label1301;
      }
      l1 = 0x0 | this.y | str3.charAt(0);
      if (l1 > this.v)
      {
        l1 += 9007199254740992L;
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
          break label1288;
        }
        this.v = (l1 + 144115188075855872L);
        this.jdField_e_of_type_Int = 0;
      }
    }
    label653:
    label688:
    label699:
    label732:
    label744:
    label1263:
    for (;;)
    {
      label880:
      label883:
      label885:
      if (this.v != -9223372036854775808L)
      {
        this.v += this.w;
        return;
        this.v = (l1 + 72057594037927936L);
        break;
        i = str3.indexOf(paramString);
        if (i >= 0)
        {
          if (i != 0) {
            break label1400;
          }
          l1 = 562949953421312L;
          l1 = l1 | this.y | str3.charAt(0);
          if (l1 > this.v)
          {
            l1 += 9007199254740992L;
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
              break label1408;
            }
          }
        }
      }
    }
    label775:
    label801:
    label844:
    for (this.v = (l1 + 144115188075855872L);; this.v = (l1 + 72057594037927936L))
    {
      this.jdField_e_of_type_Int = 0;
      break label1263;
      break;
      label1400:
      l1 = 281474976710656L;
      break label1321;
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    if (this.f != null) {
      return String.format("(%s)", new Object[] { this.f });
    }
    return null;
  }
  
  public String c()
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
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchableFriend
 * JD-Core Version:    0.7.0.1
 */