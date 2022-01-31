package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class ContactSearchableDiscussion
  extends IContactSearchable
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int jdField_b_of_type_Int = 1;
  private static final int jdField_c_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DiscussionInfo jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
  private FriendManager jdField_a_of_type_ComTencentMobileqqModelFriendManager;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private int f = 0;
  private long y;
  
  public ContactSearchableDiscussion(Context paramContext, QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo, int paramInt, long paramLong)
  {
    this(paramContext, paramQQAppInterface, paramDiscussionInfo, paramInt, 65536L, paramLong, 2);
  }
  
  @SuppressLint({"DefaultLocale"})
  public ContactSearchableDiscussion(Context paramContext, QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.w = paramLong2;
    this.jdField_e_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramDiscussionInfo;
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131561955);
    this.b = String.format("(%d)", new Object[] { Integer.valueOf(paramInt1) });
    this.y = paramLong1;
    ChnToSpell.a(paramContext);
    if ((paramDiscussionInfo.discussionName != null) && (paramDiscussionInfo.discussionName.length() != 0))
    {
      this.c = ChnToSpell.a(paramDiscussionInfo.discussionName, 1).toLowerCase();
      this.d = ChnToSpell.a(paramDiscussionInfo.discussionName, 2).toLowerCase();
    }
    this.jdField_a_of_type_ComTencentMobileqqModelFriendManager = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8));
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin);
  }
  
  @SuppressLint({"DefaultLocale"})
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    label24:
    Object localObject;
    String str1;
    long l1;
    int i;
    label222:
    int k;
    int j;
    label265:
    label296:
    label322:
    label593:
    label636:
    do
    {
      String str2;
      do
      {
        do
        {
          String str3;
          do
          {
            return;
            break label24;
            break label24;
            Iterator localIterator;
            while (!localIterator.hasNext())
            {
              ChnToSpell.a(this.jdField_a_of_type_AndroidContentContext);
              localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            }
            localObject = (DiscussionMemberInfo)localIterator.next();
            str1 = ((DiscussionMemberInfo)localObject).inteRemark;
            str2 = ChnToSpell.a(str1, 1).toLowerCase();
            str3 = ChnToSpell.a(str1, 2).toLowerCase();
            if ((str1 != null) && (str1.length() != 0)) {
              if ((str1.equals(paramString)) || ((str2 != null) && (str2.equals(paramString))) || ((str3 != null) && (str3.equals(paramString))))
              {
                l1 = this.y;
                if ((str2 != null) && (str2.length() > 0))
                {
                  i = str2.charAt(0);
                  l1 = 0x0 | l1 | i;
                  if (l1 <= this.v) {
                    break label417;
                  }
                  if ((str1.equals(paramString)) || (str1.equals(str2))) {
                    break label222;
                  }
                }
                for (l1 += 76561193665298432L;; l1 += 81064793292668928L)
                {
                  this.v = l1;
                  this.f = 2;
                  this.jdField_e_of_type_JavaLangString = str1;
                  return;
                  i = 0;
                  break;
                }
              }
              else
              {
                k = str1.indexOf(paramString);
                if (str2 != null)
                {
                  i = str2.indexOf(paramString);
                  if (str3 == null) {
                    break label388;
                  }
                  j = str3.indexOf(paramString);
                  if ((k < 0) && (i < 0) && (j < 0)) {
                    break label417;
                  }
                  if ((k != 0) && (i != 0) && (j != 0)) {
                    break label393;
                  }
                  l1 = 562949953421312L;
                  l2 = this.y;
                  if ((str2 == null) || (str2.length() <= 0)) {
                    break label401;
                  }
                  i = str2.charAt(0);
                  l1 |= l2 | i;
                  if (l1 <= this.v) {
                    break label417;
                  }
                  if ((k >= 0) || (str1.equals(str2))) {
                    break label406;
                  }
                }
                for (l1 += 76561193665298432L;; l1 += 81064793292668928L)
                {
                  this.v = l1;
                  this.f = 2;
                  this.jdField_e_of_type_JavaLangString = str1;
                  return;
                  i = -1;
                  break;
                  j = -1;
                  break label265;
                  l1 = 281474976710656L;
                  break label296;
                  i = 0;
                  break label322;
                }
              }
            }
            str1 = ((DiscussionMemberInfo)localObject).memberName;
            str2 = ChnToSpell.a(str1, 1).toLowerCase();
            str3 = ChnToSpell.a(str1, 2).toLowerCase();
            if ((str1 != null) && (str1.length() != 0)) {
              if ((str1.equals(paramString)) || ((str2 != null) && (str2.equals(paramString))) || ((str3 != null) && (str3.equals(paramString))))
              {
                l1 = this.y;
                if ((str2 != null) && (str2.length() > 0))
                {
                  i = str2.charAt(0);
                  l1 = 0x0 | l1 | i;
                  if (l1 <= this.v) {
                    break label788;
                  }
                  if ((str1.equals(paramString)) || (str1.equals(str2))) {
                    break label593;
                  }
                }
                for (l1 += 76561193665298432L;; l1 += 81064793292668928L)
                {
                  this.v = l1;
                  this.f = 2;
                  this.jdField_e_of_type_JavaLangString = str1;
                  return;
                  i = 0;
                  break;
                }
              }
              else
              {
                k = str1.indexOf(paramString);
                if (str2 != null)
                {
                  i = str2.indexOf(paramString);
                  if (str3 == null) {
                    break label759;
                  }
                  j = str3.indexOf(paramString);
                  if ((k < 0) && (i < 0) && (j < 0)) {
                    break label788;
                  }
                  if ((k != 0) && (i != 0) && (j != 0)) {
                    break label764;
                  }
                  l1 = 562949953421312L;
                  l2 = this.y;
                  if ((str2 == null) || (str2.length() <= 0)) {
                    break label772;
                  }
                  i = str2.charAt(0);
                  l1 |= l2 | i;
                  if (l1 <= this.v) {
                    break label788;
                  }
                  if ((k >= 0) || (str1.equals(str2))) {
                    break label777;
                  }
                }
                for (l1 += 76561193665298432L;; l1 += 81064793292668928L)
                {
                  this.v = l1;
                  this.f = 2;
                  this.jdField_e_of_type_JavaLangString = str1;
                  return;
                  i = -1;
                  break;
                  j = -1;
                  break label636;
                  l1 = 281474976710656L;
                  break label667;
                  i = 0;
                  break label693;
                }
              }
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a(((DiscussionMemberInfo)localObject).memberUin);
          } while ((localObject == null) || (!((Friends)localObject).isFriend()));
          if (!TextUtils.isEmpty(((Friends)localObject).remark))
          {
            str1 = ((Friends)localObject).remark;
            str2 = ChnToSpell.a(str1, 1).toLowerCase();
            str3 = ChnToSpell.a(str1, 2).toLowerCase();
            if ((str1.equals(paramString)) || ((str2 != null) && (str2.equals(paramString))) || ((str3 != null) && (str3.equals(paramString))))
            {
              l1 = this.y;
              if ((str2 != null) && (str2.length() > 0))
              {
                i = str2.charAt(0);
                l1 = 0x0 | l1 | i;
                if (l1 <= this.v) {
                  continue;
                }
                if ((str1.equals(paramString)) || (str1.equals(str2))) {
                  break label991;
                }
              }
              for (l1 += 76561193665298432L;; l1 += 81064793292668928L)
              {
                this.v = l1;
                this.f = 2;
                this.jdField_e_of_type_JavaLangString = str1;
                return;
                i = 0;
                break;
              }
            }
            else
            {
              k = str1.indexOf(paramString);
              if (str2 != null)
              {
                i = str2.indexOf(paramString);
                if (str3 == null) {
                  break label1157;
                }
                j = str3.indexOf(paramString);
                if ((k < 0) && (i < 0) && (j < 0)) {
                  continue;
                }
                if ((k != 0) && (i != 0) && (j != 0)) {
                  break label1162;
                }
                l1 = 562949953421312L;
                l2 = this.y;
                if ((str2 == null) || (str2.length() <= 0)) {
                  break label1170;
                }
                i = str2.charAt(0);
                l1 |= l2 | i;
                if (l1 <= this.v) {
                  continue;
                }
                if ((k >= 0) || (str1.equals(str2))) {
                  break label1175;
                }
              }
              for (l1 += 76561193665298432L;; l1 += 81064793292668928L)
              {
                this.v = l1;
                this.f = 2;
                this.jdField_e_of_type_JavaLangString = str1;
                return;
                i = -1;
                break;
                j = -1;
                break label1034;
                l1 = 281474976710656L;
                break label1065;
                i = 0;
                break label1091;
              }
            }
          }
        } while (TextUtils.isEmpty(((Friends)localObject).name));
        localObject = ((Friends)localObject).name;
        str1 = ChnToSpell.a((String)localObject, 1).toLowerCase();
        str2 = ChnToSpell.a((String)localObject, 2).toLowerCase();
        if ((!((String)localObject).equals(paramString)) && ((str1 == null) || (!str1.equals(paramString))) && ((str2 == null) || (!str2.equals(paramString)))) {
          break label1371;
        }
        l1 = this.y;
        if ((str1 == null) || (str1.length() <= 0)) {
          break;
        }
        i = str1.charAt(0);
        l1 = 0x0 | l1 | i;
      } while (l1 <= this.v);
      if ((!((String)localObject).equals(paramString)) && (!((String)localObject).equals(str1))) {}
      for (l1 += 76561193665298432L;; l1 += 81064793292668928L)
      {
        this.v = l1;
        this.f = 2;
        this.jdField_e_of_type_JavaLangString = ((String)localObject);
        return;
        i = 0;
        break;
      }
      k = ((String)localObject).indexOf(paramString);
      if (str1 == null) {
        break;
      }
      i = str1.indexOf(paramString);
      if (str2 == null) {
        break label1526;
      }
      j = str2.indexOf(paramString);
      if ((k < 0) && (i < 0) && (j < 0)) {
        break label1529;
      }
      if ((k != 0) && (i != 0) && (j != 0)) {
        break label1531;
      }
      l1 = 562949953421312L;
      long l2 = this.y;
      if ((str1 == null) || (str1.length() <= 0)) {
        break label1539;
      }
      i = str1.charAt(0);
      l1 |= l2 | i;
    } while (l1 <= this.v);
    label388:
    label393:
    label401:
    label406:
    label417:
    label693:
    label759:
    label764:
    if ((k < 0) && (!((String)localObject).equals(str1))) {}
    label667:
    label991:
    label1391:
    label1403:
    for (l1 += 76561193665298432L;; l1 += 81064793292668928L)
    {
      this.v = l1;
      this.f = 2;
      this.jdField_e_of_type_JavaLangString = ((String)localObject);
      return;
      i = -1;
      break label1391;
      j = -1;
      break label1403;
      break;
      l1 = 281474976710656L;
      break label1434;
      i = 0;
      break label1460;
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  private void c(String paramString)
  {
    if (this.v != -9223372036854775808L) {}
    label294:
    label686:
    for (;;)
    {
      return;
      paramString = paramString.trim().split("\\s+");
      if ((paramString.length >= 2) && (this.jdField_a_of_type_JavaUtilArrayList != null))
      {
        int k = paramString.length;
        int j = 0;
        long l1 = 0L;
        label64:
        long l2;
        if (j < k)
        {
          String str1 = paramString[j];
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            Object localObject = (DiscussionMemberInfo)localIterator.next();
            String str2 = ((DiscussionMemberInfo)localObject).inteRemark;
            String str3 = ChnToSpell.a(str2, 1).toLowerCase();
            String str4 = ChnToSpell.a(str2, 2).toLowerCase();
            if (!TextUtils.isEmpty(str2))
            {
              i = str2.indexOf(str1);
              int m = str3.indexOf(str1);
              int n = str4.indexOf(str1);
              if ((i >= 0) || (m >= 0) || (n >= 0)) {
                if ((i == 0) || (m == 0) || (n == 0))
                {
                  l2 = 562949953421312L;
                  label182:
                  l1 = l2 + l1;
                  i = 1;
                  label191:
                  if (i != 0) {
                    break label670;
                  }
                  str2 = ((DiscussionMemberInfo)localObject).memberName;
                  str3 = ChnToSpell.a(str2, 1).toLowerCase();
                  str4 = ChnToSpell.a(str2, 2).toLowerCase();
                  if (TextUtils.isEmpty(str2)) {
                    break label670;
                  }
                  m = str2.indexOf(str1);
                  n = str3.indexOf(str1);
                  int i1 = str4.indexOf(str1);
                  if ((m < 0) && (n < 0) && (i1 < 0)) {
                    break label670;
                  }
                  if ((m != 0) && (n != 0) && (i1 != 0)) {
                    break label627;
                  }
                  l2 = 562949953421312L;
                  l1 += l2;
                  i = 1;
                  label303:
                  if (i != 0) {
                    break label667;
                  }
                  localObject = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a(((DiscussionMemberInfo)localObject).memberUin);
                  if ((localObject == null) || (!((Friends)localObject).isFriend())) {
                    break label667;
                  }
                  if (TextUtils.isEmpty(((Friends)localObject).remark)) {
                    break label664;
                  }
                  str2 = ((Friends)localObject).remark;
                  str3 = ChnToSpell.a(str2, 1).toLowerCase();
                  str4 = ChnToSpell.a(str2, 2).toLowerCase();
                  if (TextUtils.isEmpty(str2)) {
                    break label664;
                  }
                  m = str2.indexOf(str1);
                  n = str3.indexOf(str1);
                  i1 = str4.indexOf(str1);
                  if ((m < 0) && (n < 0) && (i1 < 0)) {
                    break label664;
                  }
                  if ((m != 0) && (n != 0) && (i1 != 0)) {
                    break label635;
                  }
                  l2 = 562949953421312L;
                  label446:
                  l1 += l2;
                  i = 1;
                  label455:
                  if ((i != 0) || (TextUtils.isEmpty(((Friends)localObject).name))) {
                    break label661;
                  }
                  localObject = ((Friends)localObject).name;
                  str2 = ChnToSpell.a((String)localObject, 1).toLowerCase();
                  str3 = ChnToSpell.a((String)localObject, 2).toLowerCase();
                  if (TextUtils.isEmpty((CharSequence)localObject)) {
                    break label661;
                  }
                  m = ((String)localObject).indexOf(str1);
                  n = str2.indexOf(str1);
                  i1 = str3.indexOf(str1);
                  if ((m < 0) && (n < 0) && (i1 < 0)) {
                    break label661;
                  }
                  if ((m != 0) && (n != 0) && (i1 != 0)) {
                    break label643;
                  }
                  l2 = 562949953421312L;
                  label569:
                  l1 += l2;
                  i = 1;
                  label578:
                  if (i == 0) {
                    break label651;
                  }
                  i = 1;
                  label584:
                  if (i != 0) {
                    break label654;
                  }
                }
              }
            }
          }
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label686;
          }
          this.v = (l1 + 144115188075855872L + 9007199254740992L + this.w);
          this.f = 3;
          return;
          l2 = 281474976710656L;
          break label182;
          label627:
          l2 = 281474976710656L;
          break label294;
          label635:
          l2 = 281474976710656L;
          break label446;
          l2 = 281474976710656L;
          break label569;
          break label64;
          j += 1;
          break;
          break label578;
          break label455;
          break label578;
          break label303;
          i = 0;
          break label191;
          i = 0;
          break label584;
        }
      }
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
  
  public DiscussionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    String str1 = paramString.toLowerCase();
    String str2;
    String str3;
    long l1;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName != null)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName.toLowerCase();
      str2 = this.c;
      str3 = this.d;
      if ((paramString == null) || (paramString.length() == 0)) {
        break label387;
      }
      if ((!paramString.equals(str1)) && ((str2 == null) || (!str2.equals(str1))) && ((str3 == null) || (!str3.equals(str1)))) {
        break label209;
      }
      l1 = this.y;
      if ((str2 == null) || (str2.length() <= 0)) {
        break label193;
      }
      i = str2.charAt(0);
      label115:
      l1 = 0x0 | l1 | i;
      if ((paramString.equals(str1)) || (paramString.equals(str2))) {
        break label198;
      }
      l1 += 148618787703226368L;
      label152:
      this.f = 1;
    }
    for (;;)
    {
      this.v = l1;
      if (this.v != -9223372036854775808L)
      {
        this.v += this.w;
        return;
        paramString = null;
        break;
        label193:
        i = 0;
        break label115;
        label198:
        l1 += 153122387330596864L;
        break label152;
        label209:
        int k = paramString.indexOf(str1);
        label230:
        int j;
        if (str2 != null)
        {
          i = str2.indexOf(str1);
          if (str3 == null) {
            break label345;
          }
          j = str3.indexOf(str1);
          label243:
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label387;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label350;
          }
          l1 = 562949953421312L;
          label274:
          long l2 = this.y;
          if ((str2 == null) || (str2.length() <= 0)) {
            break label358;
          }
          i = str2.charAt(0);
          label300:
          l1 |= i | l2;
          if ((k >= 0) || (paramString.equals(str2))) {
            break label363;
          }
        }
        label345:
        label350:
        label358:
        label363:
        for (l1 += 148618787703226368L;; l1 += 153122387330596864L)
        {
          this.f = 1;
          break;
          i = -1;
          break label230;
          j = -1;
          break label243;
          l1 = 281474976710656L;
          break label274;
          i = 0;
          break label300;
        }
      }
      b(str1);
      c(str1);
      return;
      label387:
      l1 = -9223372036854775808L;
    }
  }
  
  public int b()
  {
    return 101;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
    Object localObject = str;
    if (this.f == 2)
    {
      localObject = new StringBuilder(str);
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_JavaLangString);
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchableDiscussion
 * JD-Core Version:    0.7.0.1
 */