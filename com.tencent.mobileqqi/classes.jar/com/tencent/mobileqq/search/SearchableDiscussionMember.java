package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
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
  private long y;
  
  @SuppressLint({"DefaultLocale"})
  public SearchableDiscussionMember(Context paramContext, QQAppInterface paramQQAppInterface, DiscussionMemberInfo paramDiscussionMemberInfo, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo = paramDiscussionMemberInfo;
    this.y = paramLong1;
    this.w = paramLong2;
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
  }
  
  public int a()
  {
    return 0;
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
    return BaseApplicationImpl.getContext().getString(2131559288);
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    paramString = paramString.toLowerCase();
    this.v = -9223372036854775808L;
    long l1;
    int i;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0)) {
      if ((this.jdField_a_of_type_JavaLangString.equals(paramString)) || ((this.b != null) && (this.b.equals(paramString))) || ((this.c != null) && (this.c.equals(paramString))))
      {
        l1 = this.y;
        if ((this.b != null) && (this.b.length() > 0))
        {
          i = this.b.charAt(0);
          l1 = 0x0 | l1 | i;
          if (l1 > this.v)
          {
            if ((this.jdField_a_of_type_JavaLangString.equals(paramString)) || (this.jdField_a_of_type_JavaLangString.equals(this.b))) {
              break label207;
            }
            l1 += 4503599627370496L;
            label162:
            this.v = (l1 + 144115188075855872L);
            this.jdField_e_of_type_Int = 3;
          }
          label177:
          if (this.v == -9223372036854775808L) {
            break label422;
          }
          this.v += this.w;
        }
      }
    }
    label207:
    label244:
    label632:
    label1018:
    do
    {
      return;
      i = 0;
      break;
      l1 += 9007199254740992L;
      break label162;
      int k = this.jdField_a_of_type_JavaLangString.indexOf(paramString);
      int j;
      long l2;
      if (this.b != null)
      {
        i = this.b.indexOf(paramString);
        if (this.c == null) {
          break label393;
        }
        j = this.c.indexOf(paramString);
        if ((k < 0) && (i < 0) && (j < 0)) {
          break label396;
        }
        if ((k != 0) && (i != 0) && (j != 0)) {
          break label398;
        }
        l1 = 562949953421312L;
        l2 = this.y;
        if ((this.b == null) || (this.b.length() <= 0)) {
          break label406;
        }
        i = this.b.charAt(0);
        l1 |= l2 | i;
        if (l1 <= this.v) {
          break label177;
        }
        if ((k >= 0) || (this.jdField_a_of_type_JavaLangString.equals(this.b))) {
          break label411;
        }
      }
      for (l1 += 4503599627370496L;; l1 += 9007199254740992L)
      {
        this.v = (l1 + 144115188075855872L);
        this.jdField_e_of_type_Int = 3;
        break;
        i = -1;
        break label244;
        j = -1;
        break label260;
        break;
        l1 = 281474976710656L;
        break label291;
        i = 0;
        break label323;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.length() > 0))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.equals(paramString)) || ((this.d != null) && (this.d.equals(paramString))) || ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.equals(paramString))))
        {
          l1 = this.y;
          if ((this.d != null) && (this.d.length() > 0))
          {
            i = this.d.charAt(0);
            l1 = 0x0 | l1 | i;
            if (l1 > this.v)
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.equals(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.equals(this.d))) {
                break label632;
              }
              l1 += 4503599627370496L;
              this.v = (l1 + 144115188075855872L);
              this.jdField_e_of_type_Int = 2;
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
            l1 += 9007199254740992L;
            break label587;
            k = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.indexOf(paramString);
            if (this.d != null)
            {
              i = this.d.indexOf(paramString);
              if (this.jdField_e_of_type_JavaLangString == null) {
                break label824;
              }
              j = this.jdField_e_of_type_JavaLangString.indexOf(paramString);
              if ((k < 0) && (i < 0) && (j < 0)) {
                break label827;
              }
              if ((k != 0) && (i != 0) && (j != 0)) {
                break label829;
              }
              l1 = 562949953421312L;
              l2 = this.y;
              if ((this.d == null) || (this.d.length() <= 0)) {
                break label837;
              }
              i = this.d.charAt(0);
              l1 |= l2 | i;
              if (l1 <= this.v) {
                continue;
              }
              if ((k >= 0) || (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark.equals(this.d))) {
                break label842;
              }
            }
            for (l1 += 4503599627370496L;; l1 += 9007199254740992L)
            {
              this.v = (l1 + 144115188075855872L);
              this.jdField_e_of_type_Int = 2;
              break;
              i = -1;
              break label672;
              j = -1;
              break label688;
              break;
              l1 = 281474976710656L;
              break label719;
              i = 0;
              break label751;
            }
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName != null) && (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName.length() > 0))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName.equals(paramString)) || ((this.f != null) && (this.f.equals(paramString))) || ((this.g != null) && (this.g.equals(paramString))))
        {
          l1 = this.y;
          if ((this.f != null) && (this.f.length() > 0))
          {
            i = this.f.charAt(0);
            l1 = 0x0 | l1 | i;
            if (l1 > this.v)
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName.equals(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName.equals(this.f))) {
                break label1086;
              }
              l1 += 4503599627370496L;
              if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark))) {
                break label1097;
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
            l1 += 9007199254740992L;
            break label1018;
            this.v = (l1 + 72057594037927936L);
            break label1051;
            k = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName.indexOf(paramString);
            if (this.f != null)
            {
              i = this.f.indexOf(paramString);
              if (this.g == null) {
                break label1314;
              }
              j = this.g.indexOf(paramString);
              if ((k < 0) && (i < 0) && (j < 0)) {
                break label1317;
              }
              if ((k != 0) && (i != 0) && (j != 0)) {
                break label1319;
              }
              l1 = 562949953421312L;
              l2 = this.y;
              if ((this.f == null) || (this.f.length() <= 0)) {
                break label1327;
              }
              i = this.f.charAt(0);
              l1 |= l2 | i;
              if (l1 <= this.v) {
                continue;
              }
              if ((k >= 0) || (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName.equals(this.f))) {
                break label1332;
              }
              l1 += 4503599627370496L;
              if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark))) {
                break label1343;
              }
            }
            for (this.v = (l1 + 144115188075855872L);; this.v = (l1 + 72057594037927936L))
            {
              this.jdField_e_of_type_Int = 1;
              break;
              i = -1;
              break label1139;
              j = -1;
              break label1155;
              break;
              l1 = 281474976710656L;
              break label1186;
              i = 0;
              break label1218;
              l1 += 9007199254740992L;
              break label1268;
            }
          }
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin == null);
    label260:
    label291:
    label323:
    label587:
    label719:
    label751:
    label1139:
    label1268:
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin.equals(paramString))
    {
      l1 = 0x0 | this.y | this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin.charAt(0);
      if (l1 > this.v)
      {
        l1 += 9007199254740992L;
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName))) {
          break label1497;
        }
        this.v = (l1 + 144115188075855872L);
        this.jdField_e_of_type_Int = 0;
      }
    }
    label393:
    label396:
    label398:
    label406:
    label411:
    label422:
    label688:
    label824:
    label827:
    label829:
    label837:
    label1097:
    for (;;)
    {
      label842:
      if (this.v != -9223372036854775808L)
      {
        this.v += this.w;
        return;
        label1497:
        this.v = (l1 + 72057594037927936L);
        break;
        i = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin.indexOf(paramString);
        if (i >= 0)
        {
          if (i != 0) {
            break label1629;
          }
          l1 = 562949953421312L;
          label1535:
          l1 = l1 | this.y | this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin.charAt(0);
          if (l1 > this.v)
          {
            l1 += 9007199254740992L;
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName))) {
              break label1637;
            }
          }
        }
      }
    }
    label672:
    label1086:
    label1218:
    label1629:
    label1637:
    for (this.v = (l1 + 144115188075855872L);; this.v = (l1 + 72057594037927936L))
    {
      this.jdField_e_of_type_Int = 0;
      break label1472;
      break;
      l1 = 281474976710656L;
      break label1535;
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    if (this.h != null) {
      return String.format("(%s)", new Object[] { this.h });
    }
    return null;
  }
  
  public String c()
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
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchableDiscussionMember
 * JD-Core Version:    0.7.0.1
 */