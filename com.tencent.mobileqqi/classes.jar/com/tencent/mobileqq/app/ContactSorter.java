package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ChnToSpell;
import fap;
import faq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ContactSorter
{
  private static final String jdField_a_of_type_JavaLangString = "ContactSorter";
  private static Comparator jdField_a_of_type_JavaUtilComparator;
  private static final String jdField_b_of_type_JavaLangString = "-";
  private static Comparator jdField_b_of_type_JavaUtilComparator;
  
  static
  {
    a = new fap();
    b = new faq();
  }
  
  private static int a(char paramChar)
  {
    if (((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'))) {
      return 1;
    }
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return 10;
    }
    return 5;
  }
  
  public static int a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if ((paramInt1 > paramInt2) || (paramString2 == null)) {}
    label76:
    do
    {
      return 1;
      if ((paramInt1 < paramInt2) || (paramString1 == null)) {
        return -1;
      }
      paramInt2 = Math.min(paramString1.length(), paramString2.length());
      paramInt1 = 1;
      for (;;)
      {
        if (paramInt1 >= paramInt2) {
          break label76;
        }
        if (paramString1.charAt(paramInt1) > paramString2.charAt(paramInt1)) {
          break;
        }
        if (paramString1.charAt(paramInt1) < paramString2.charAt(paramInt1)) {
          return -1;
        }
        paramInt1 += 1;
      }
    } while (paramString1.length() > paramString2.length());
    if (paramString1.length() < paramString2.length()) {
      return -1;
    }
    return 0;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int k = 1;
    int i;
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      i = -1;
    }
    char[] arrayOfChar1;
    char[] arrayOfChar2;
    label165:
    label170:
    label223:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
              i = k;
            } while (paramString2 == null);
            i = k;
          } while (paramString2.length() == 0);
          arrayOfChar1 = ChnToSpell.a(paramString1, 1).toCharArray();
          arrayOfChar2 = ChnToSpell.a(paramString2, 1).toCharArray();
          j = a(arrayOfChar1[0]);
          m = a(arrayOfChar2[0]);
          i = k;
        } while (j > m);
        if (j < m) {
          return -1;
        }
        i = k;
      } while (arrayOfChar1[0] > arrayOfChar2[0]);
      if (arrayOfChar1[0] < arrayOfChar2[0]) {
        return -1;
      }
      if (paramString1.charAt(0) < 'ÿ')
      {
        i = 1;
        if (paramString2.charAt(0) >= 'ÿ') {
          break label165;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i ^ j) == 0) {
          break label170;
        }
        return paramString1.charAt(0) - paramString2.charAt(0);
        i = 0;
        break;
      }
      int m = Math.min(arrayOfChar1.length, arrayOfChar2.length);
      j = 1;
      for (;;)
      {
        if (j >= m) {
          break label223;
        }
        i = k;
        if (arrayOfChar1[j] > arrayOfChar2[j]) {
          break;
        }
        if (arrayOfChar1[j] < arrayOfChar2[j]) {
          return -1;
        }
        j += 1;
      }
      i = k;
    } while (arrayOfChar1.length > arrayOfChar2.length);
    if (arrayOfChar1.length < arrayOfChar2.length) {
      return -1;
    }
    return 0;
  }
  
  public static String a(DiscussionInfo paramDiscussionInfo)
  {
    return paramDiscussionInfo.discussionName + "-" + paramDiscussionInfo.uin;
  }
  
  public static String a(Friends paramFriends)
  {
    return paramFriends.getFriendNick();
  }
  
  public static String a(PublicAccountInfo paramPublicAccountInfo)
  {
    return paramPublicAccountInfo.name + "-" + paramPublicAccountInfo.uin;
  }
  
  public static String a(TroopInfo paramTroopInfo)
  {
    return paramTroopInfo.troopname + "-" + paramTroopInfo.troopcode;
  }
  
  public static void a(DiscussionInfo paramDiscussionInfo)
  {
    String str = a(paramDiscussionInfo);
    paramDiscussionInfo.mCompareSpell = ChnToSpell.a(str, 1);
    paramDiscussionInfo.mComparePartInt = b(str, paramDiscussionInfo.mCompareSpell);
  }
  
  public static void a(Friends paramFriends)
  {
    String str = b(paramFriends);
    paramFriends.mCompareSpell = ChnToSpell.a(str, 1);
    paramFriends.mComparePartInt = b(str, paramFriends.mCompareSpell);
  }
  
  public static void a(PublicAccountInfo paramPublicAccountInfo)
  {
    String str = a(paramPublicAccountInfo);
    paramPublicAccountInfo.mCompareSpell = ChnToSpell.a(str, 1);
    paramPublicAccountInfo.mComparePartInt = b(str, paramPublicAccountInfo.mCompareSpell);
  }
  
  public static void a(TroopInfo paramTroopInfo)
  {
    String str = a(paramTroopInfo);
    paramTroopInfo.mCompareSpell = ChnToSpell.a(str, 1);
    paramTroopInfo.mComparePartInt = b(str, paramTroopInfo.mCompareSpell);
  }
  
  public static void a(ArrayList paramArrayList)
  {
    Collections.sort(paramArrayList, a);
  }
  
  public static void a(ArrayList paramArrayList, Entity paramEntity)
  {
    if (paramArrayList.size() == 0)
    {
      paramArrayList.add(paramEntity);
      return;
    }
    Groups localGroups1 = (Groups)paramEntity;
    int j = 0;
    int i = paramArrayList.size() - 1;
    if (j <= i)
    {
      int k = (j + i) / 2;
      Groups localGroups2 = (Groups)paramArrayList.get(k);
      if (localGroups1.seqid > localGroups2.seqid) {
        j = k + 1;
      }
      for (;;)
      {
        break;
        i = k - 1;
      }
    }
    paramArrayList.add(i + 1, paramEntity);
  }
  
  private static int b(Groups paramGroups1, Groups paramGroups2)
  {
    return paramGroups1.seqid - paramGroups2.seqid;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    int k = paramString2.charAt(0);
    int i;
    if (((k >= 65) && (k <= 90)) || ((k >= 97) && (k <= 122)))
    {
      i = 65536;
      if (paramString1.charAt(0) < 'ÿ') {
        break label89;
      }
    }
    label89:
    for (int j = 1;; j = 0)
    {
      return j | k << 8 | i | 0x0;
      if ((k >= 48) && (k <= 57))
      {
        i = 262144;
        break;
      }
      i = 131072;
      break;
    }
  }
  
  public static String b(Friends paramFriends)
  {
    String str = a(paramFriends);
    return str + "-" + paramFriends.uin;
  }
  
  public static void b(ArrayList paramArrayList)
  {
    Collections.sort(paramArrayList, b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ContactSorter
 * JD-Core Version:    0.7.0.1
 */