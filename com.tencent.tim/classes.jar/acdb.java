import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;

public class acdb
{
  public static Comparator<Entity> K = new acdc();
  
  public static int A(String paramString1, String paramString2)
  {
    int k = 1;
    int i;
    int j;
    if (paramString1 != null)
    {
      i = paramString1.length();
      if (paramString2 == null) {
        break label40;
      }
      j = paramString2.length();
      label21:
      if ((i != 0) && (j != 0)) {
        break label45;
      }
      i -= j;
    }
    label40:
    label45:
    char[] arrayOfChar1;
    char[] arrayOfChar2;
    label175:
    label180:
    label233:
    do
    {
      do
      {
        do
        {
          return i;
          i = 0;
          break;
          j = 0;
          break label21;
          arrayOfChar1 = ChnToSpell.aJ(paramString1, 1).toCharArray();
          arrayOfChar2 = ChnToSpell.aJ(paramString2, 1).toCharArray();
          j = c(arrayOfChar1[0]);
          m = c(arrayOfChar2[0]);
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
          break label175;
        }
      }
      for (j = 1;; j = 0)
      {
        if ((i ^ j) == 0) {
          break label180;
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
          break label233;
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
  
  public static int B(String paramString1, String paramString2)
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
  
  public static int a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (paramInt1 > paramInt2) {
      return 1;
    }
    if (paramInt1 < paramInt2) {
      return -1;
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    return str.compareTo(paramString1);
  }
  
  public static String a(DiscussionInfo paramDiscussionInfo)
  {
    return paramDiscussionInfo.discussionName + "-" + paramDiscussionInfo.uin;
  }
  
  public static String a(Friends paramFriends)
  {
    String str = paramFriends.getFriendNick();
    return str + "-" + paramFriends.uin;
  }
  
  public static String a(PublicAccountInfo paramPublicAccountInfo)
  {
    return paramPublicAccountInfo.name + "-" + paramPublicAccountInfo.uin;
  }
  
  public static String a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo.hasSetTroopName()) || (TextUtils.isEmpty(paramTroopInfo.newTroopName))) {
      return paramTroopInfo.troopname + "-" + paramTroopInfo.troopcode;
    }
    return paramTroopInfo.getTroopName() + "-" + paramTroopInfo.troopcode;
  }
  
  public static ArrayList<Entity> a(ArrayList<Entity> paramArrayList, Entity paramEntity)
  {
    if (paramArrayList == null) {
      return null;
    }
    paramArrayList = (ArrayList)paramArrayList.clone();
    if (paramArrayList.size() == 0)
    {
      paramArrayList.add(paramEntity);
      return paramArrayList;
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
    return paramArrayList;
  }
  
  public static void b(PublicAccountInfo paramPublicAccountInfo)
  {
    String str = a(paramPublicAccountInfo);
    paramPublicAccountInfo.mCompareSpell = ChnToSpell.aJ(str, 1);
    paramPublicAccountInfo.mComparePartInt = B(str, paramPublicAccountInfo.mCompareSpell);
  }
  
  private static int c(char paramChar)
  {
    if (((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'))) {
      return 1;
    }
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return 10;
    }
    return 5;
  }
  
  public static void c(DiscussionInfo paramDiscussionInfo)
  {
    String str = a(paramDiscussionInfo);
    paramDiscussionInfo.mCompareSpell = ChnToSpell.aJ(str, 1);
    paramDiscussionInfo.mComparePartInt = B(str, paramDiscussionInfo.mCompareSpell);
  }
  
  public static void d(Friends paramFriends)
  {
    String str = a(paramFriends);
    paramFriends.mCompareSpell = ChnToSpell.aJ(str, 1);
    paramFriends.mComparePartInt = B(str, paramFriends.mCompareSpell);
  }
  
  public static void g(TroopInfo paramTroopInfo)
  {
    String str = a(paramTroopInfo);
    paramTroopInfo.mCompareSpell = ChnToSpell.aJ(str, 1);
    paramTroopInfo.mComparePartInt = B(str, paramTroopInfo.mCompareSpell);
  }
  
  public static class a
    implements Comparator<DiscussionMemberInfo>
  {
    public int a(DiscussionMemberInfo paramDiscussionMemberInfo1, DiscussionMemberInfo paramDiscussionMemberInfo2)
    {
      if ((paramDiscussionMemberInfo1 != null) && (paramDiscussionMemberInfo2 != null))
      {
        paramDiscussionMemberInfo1 = Long.valueOf(Long.parseLong(paramDiscussionMemberInfo1.memberUin));
        paramDiscussionMemberInfo2 = Long.valueOf(Long.parseLong(paramDiscussionMemberInfo2.memberUin));
        if (paramDiscussionMemberInfo1.longValue() <= paramDiscussionMemberInfo2.longValue()) {}
      }
      while (paramDiscussionMemberInfo1 != null)
      {
        return 1;
        if (paramDiscussionMemberInfo1.longValue() < paramDiscussionMemberInfo2.longValue()) {
          return -1;
        }
        return 0;
      }
      if (paramDiscussionMemberInfo2 != null) {
        return -1;
      }
      return 0;
    }
  }
  
  public static class b
    implements Comparator<DiscussionMemberInfo>
  {
    private String boa;
    private QQAppInterface e;
    private boolean ni;
    
    public b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
    {
      this.e = paramQQAppInterface;
      this.boa = paramString1;
      this.ni = paramString2.equals(paramString1);
    }
    
    public int a(DiscussionMemberInfo paramDiscussionMemberInfo1, DiscussionMemberInfo paramDiscussionMemberInfo2)
    {
      int i = -1;
      if (paramDiscussionMemberInfo1.memberUin.equals(this.boa)) {
        if (!this.ni) {}
      }
      String str1;
      String str2;
      do
      {
        do
        {
          return 1;
          return -1;
          if (paramDiscussionMemberInfo2.memberUin.equals(this.boa))
          {
            if (this.ni) {}
            for (;;)
            {
              return i;
              i = 1;
            }
          }
          paramDiscussionMemberInfo1 = aqgv.a(paramDiscussionMemberInfo1, this.e);
          paramDiscussionMemberInfo2 = aqgv.a(paramDiscussionMemberInfo2, this.e);
          if ((paramDiscussionMemberInfo1 == null) || (paramDiscussionMemberInfo1.length() == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ContactUtils", 2, "lhsName is null");
            }
            throw new NullPointerException("com.tencent.mobileqq.utils.ContactUtils int compare lhsName is null for check ");
          }
          if ((paramDiscussionMemberInfo2 == null) || (paramDiscussionMemberInfo2.length() == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ContactUtils", 2, "rhsName is null");
            }
            throw new NullPointerException("com.tencent.mobileqq.utils.ContactUtils  int compare rhsName is null for check ");
          }
          if ((!Character.isDigit(paramDiscussionMemberInfo1.charAt(0))) && (!Character.isDigit(paramDiscussionMemberInfo2.charAt(0)))) {
            break;
          }
          if ((Character.isDigit(paramDiscussionMemberInfo1.charAt(0))) && (Character.isDigit(paramDiscussionMemberInfo2.charAt(0)))) {
            return paramDiscussionMemberInfo1.charAt(0) - paramDiscussionMemberInfo2.charAt(0);
          }
        } while (Character.isDigit(paramDiscussionMemberInfo1.charAt(0)));
        return -1;
        str1 = ChnToSpell.aJ(paramDiscussionMemberInfo1, 1);
        str2 = ChnToSpell.aJ(paramDiscussionMemberInfo2, 1);
        if ((str1.length() == 0) || (str2.length() == 0)) {
          return -str1.compareTo(str2);
        }
        if (str1.charAt(0) != str2.charAt(0)) {
          break;
        }
        if ((aqmr.isAsciiAlpha(paramDiscussionMemberInfo1.charAt(0))) && (aqmr.isAsciiAlpha(paramDiscussionMemberInfo2.charAt(0)))) {
          return paramDiscussionMemberInfo1.charAt(0) - paramDiscussionMemberInfo2.charAt(0);
        }
      } while (Character.isLetter(paramDiscussionMemberInfo1.charAt(0)));
      if (Character.isLetter(paramDiscussionMemberInfo2.charAt(0))) {
        return -1;
      }
      return str1.compareTo(str2);
      return str1.charAt(0) - str2.charAt(0);
    }
  }
  
  public static class c
    implements Comparator<String>
  {
    public int compare(String paramString1, String paramString2)
    {
      int i = 1;
      if ((paramString1 == null) || (paramString1.length() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ContactUtils.PhoneNameComparator", 2, "lhsName is null");
        }
        throw new NullPointerException("com.tencent.mobileqq.utils.ContactUtils int compare lhsName is null for check ");
      }
      if ((paramString2 == null) || (paramString2.length() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ContactUtils.PhoneNameComparator", 2, "rhsName is null");
        }
        throw new NullPointerException("com.tencent.mobileqq.utils.ContactUtils  int compare rhsName is null for check ");
      }
      if ((Character.isDigit(paramString1.charAt(0))) || (Character.isDigit(paramString2.charAt(0)))) {
        if ((Character.isDigit(paramString1.charAt(0))) && (Character.isDigit(paramString2.charAt(0)))) {
          i = paramString1.charAt(0) - paramString2.charAt(0);
        }
      }
      String str1;
      String str2;
      do
      {
        do
        {
          return i;
        } while (Character.isDigit(paramString1.charAt(0)));
        return -1;
        str1 = ChnToSpell.aJ(paramString1, 1);
        str2 = ChnToSpell.aJ(paramString2, 1);
        if ((str1.length() == 0) || (str2.length() == 0)) {
          return -str1.compareTo(str2);
        }
        if (str1.charAt(0) != str2.charAt(0)) {
          break;
        }
        if ((aqmr.isAsciiAlpha(paramString1.charAt(0))) && (aqmr.isAsciiAlpha(paramString2.charAt(0)))) {
          return paramString1.charAt(0) - paramString2.charAt(0);
        }
      } while (Character.isLetter(paramString1.charAt(0)));
      if (Character.isLetter(paramString2.charAt(0))) {
        return -1;
      }
      return str1.compareTo(str2);
      return str1.charAt(0) - str2.charAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acdb
 * JD-Core Version:    0.7.0.1
 */