package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;

public class SearchableDiscussionMember
  extends IContactSearchable
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int jdField_b_of_type_Int = 1;
  private static final int jdField_c_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DiscussionMemberInfo jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo;
  private String jdField_a_of_type_JavaLangString;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  private String g;
  private String h;
  
  @SuppressLint({"DefaultLocale"})
  public SearchableDiscussionMember(Context paramContext, QQAppInterface paramQQAppInterface, DiscussionMemberInfo paramDiscussionMemberInfo, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo = paramDiscussionMemberInfo;
    this.A = paramLong2;
    ChnToSpell.a(paramContext);
    paramContext = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (paramContext != null)
    {
      paramContext = paramContext.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin);
      if ((paramContext != null) && (paramContext.isFriend()) && (paramContext.remark != null) && (paramContext.remark.length() > 0))
      {
        this.jdField_a_of_type_JavaLangString = paramContext.remark;
        this.b = ChnToSpell.a(paramContext.remark, 1).toLowerCase();
        this.c = ChnToSpell.a(paramContext.remark, 2).toLowerCase();
      }
    }
    if ((this.jdField_a_of_type_JavaLangString == null) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.length() > 0))
    {
      this.d = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark, 1).toLowerCase();
      this.jdField_e_of_type_JavaLangString = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark, 2).toLowerCase();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName != null) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName.length() > 0))
    {
      this.f = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, 1).toLowerCase();
      this.g = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, 2).toLowerCase();
    }
    a();
  }
  
  public int a()
  {
    return 0;
  }
  
  protected long a()
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, 1004);
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
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo;
  }
  
  public String a()
  {
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      return null;
    case 0: 
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        str = this.jdField_a_of_type_JavaLangString;
        this.h = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
        return str;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.length() > 0))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark;
        this.h = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
        return str;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName != null) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName.length() > 0))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
        this.h = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
        return str;
      }
      return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
    case 1: 
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        str = this.jdField_a_of_type_JavaLangString;
        this.h = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
        return str;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.length() > 0))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark;
        this.h = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
        return str;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
      this.h = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
      return str;
    case 2: 
      str = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark;
      this.h = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
      return str;
    }
    String str = this.jdField_a_of_type_JavaLangString;
    this.h = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
    return str;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    paramString = paramString.toLowerCase();
    this.z = -9223372036854775808L;
    long l;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0)) {
      if ((this.jdField_a_of_type_JavaLangString.equals(paramString)) || ((this.b != null) && (this.b.equals(paramString))) || ((this.c != null) && (this.c.equals(paramString)))) {
        if (1125899906842624L > this.z)
        {
          if ((!this.jdField_a_of_type_JavaLangString.equals(paramString)) && (!this.jdField_a_of_type_JavaLangString.equals(this.b)))
          {
            l = 1125899906842624L + 4503599627370496L;
            this.z = (l + 0L);
            this.jdField_e_of_type_Int = 3;
          }
        }
        else
        {
          if (this.z == -9223372036854775808L) {
            break label326;
          }
          this.z += this.A;
        }
      }
    }
    int i;
    label197:
    label213:
    label244:
    label637:
    do
    {
      return;
      l = 1125899906842624L + 9007199254740992L;
      break;
      int k = this.jdField_a_of_type_JavaLangString.indexOf(paramString);
      int j;
      if (this.b != null)
      {
        i = this.b.indexOf(paramString);
        if (this.c == null) {
          break label302;
        }
        j = this.c.indexOf(paramString);
        if ((k < 0) && (i < 0) && (j < 0)) {
          break label305;
        }
        if ((k != 0) && (i != 0) && (j != 0)) {
          break label307;
        }
        l = 562949953421312L;
        if (l <= this.z) {
          break label313;
        }
        if ((k >= 0) || (this.jdField_a_of_type_JavaLangString.equals(this.b))) {
          break label315;
        }
      }
      for (l += 4503599627370496L;; l += 9007199254740992L)
      {
        this.z = (l + 0L);
        this.jdField_e_of_type_Int = 3;
        break;
        i = -1;
        break label197;
        j = -1;
        break label213;
        break;
        l = 281474976710656L;
        break label244;
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.length() > 0))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.equals(paramString)) || ((this.d != null) && (this.d.equals(paramString))) || ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.equals(paramString))))
        {
          if (1125899906842624L > this.z) {
            if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.equals(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.equals(this.d))) {
              break label488;
            }
          }
          for (l = 1125899906842624L + 4503599627370496L;; l = 1125899906842624L + 9007199254740992L)
          {
            this.z = (l + 0L);
            this.jdField_e_of_type_Int = 2;
            if (this.z == -9223372036854775808L) {
              break;
            }
            this.z += this.A;
            return;
          }
        }
        k = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.indexOf(paramString);
        if (this.d != null)
        {
          i = this.d.indexOf(paramString);
          if (this.jdField_e_of_type_JavaLangString == null) {
            break label637;
          }
          j = this.jdField_e_of_type_JavaLangString.indexOf(paramString);
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label640;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label642;
          }
          l = 562949953421312L;
          if (l <= this.z) {
            break label648;
          }
          if ((k >= 0) || (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.equals(this.d))) {
            break label650;
          }
        }
        for (l += 4503599627370496L;; l += 9007199254740992L)
        {
          this.z = (l + 0L);
          this.jdField_e_of_type_Int = 2;
          break;
          i = -1;
          break label529;
          j = -1;
          break label545;
          break;
          l = 281474976710656L;
          break label576;
          break;
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName != null) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName.length() > 0))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName.equals(paramString)) || ((this.f != null) && (this.f.equals(paramString))) || ((this.g != null) && (this.g.equals(paramString))))
        {
          if (1125899906842624L > this.z)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName.equals(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName.equals(this.f))) {
              break label846;
            }
            l = 1125899906842624L + 4503599627370496L;
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark))) {
              break label858;
            }
          }
          for (this.z = (l + 0L);; this.z = (l + 0L))
          {
            this.jdField_e_of_type_Int = 1;
            if (this.z == -9223372036854775808L) {
              break label1064;
            }
            this.z += this.A;
            return;
            l = 1125899906842624L + 9007199254740992L;
            break;
          }
        }
        k = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName.indexOf(paramString);
        if (this.f != null)
        {
          i = this.f.indexOf(paramString);
          if (this.g == null) {
            break label1029;
          }
          j = this.g.indexOf(paramString);
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label1032;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label1034;
          }
          l = 562949953421312L;
          if (l <= this.z) {
            break label1040;
          }
          if ((k >= 0) || (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName.equals(this.f))) {
            break label1042;
          }
          l += 4503599627370496L;
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark))) {
            break label1053;
          }
        }
        for (this.z = (l + 0L);; this.z = (l + 0L))
        {
          this.jdField_e_of_type_Int = 1;
          break;
          i = -1;
          break label898;
          j = -1;
          break label914;
          break;
          l = 281474976710656L;
          break label945;
          break;
          l += 9007199254740992L;
          break label985;
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin == null);
    label302:
    label305:
    label307:
    label313:
    label315:
    label326:
    label488:
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin.equals(paramString)) {
      if (1125899906842624L > this.z)
      {
        l = 1125899906842624L + 9007199254740992L;
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName))) {
          break label1182;
        }
        this.z = (l + 0L);
        this.jdField_e_of_type_Int = 0;
      }
    }
    label529:
    label545:
    label576:
    label846:
    label985:
    for (;;)
    {
      label858:
      if (this.z != -9223372036854775808L)
      {
        this.z += this.A;
        return;
        this.z = (l + 0L);
        break;
        i = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin.indexOf(paramString);
        if (i >= 0)
        {
          if (i != 0) {
            break label1288;
          }
          l = 562949953421312L;
          if (l <= this.z) {
            break label1294;
          }
          l += 9007199254740992L;
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName))) {
            break label1296;
          }
        }
      }
    }
    label640:
    label642:
    label648:
    label650:
    label914:
    label945:
    label1218:
    for (this.z = (l + 0L);; this.z = (l + 0L))
    {
      this.jdField_e_of_type_Int = 0;
      break label1157;
      break;
      l = 281474976710656L;
      break label1218;
      break label1157;
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    return "讨论组成员";
  }
  
  public String c()
  {
    if (this.h != null) {
      return String.format("(%s)", new Object[] { this.h });
    }
    return null;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchableDiscussionMember
 * JD-Core Version:    0.7.0.1
 */