package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.OnlineStatusIconHelper;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.ContactSorter.NamePriorityComparator;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;

public class ContactUtils
{
  private static final int A = 0;
  private static final int B = 1;
  private static final int C = 2;
  private static final int D = 20;
  private static final int E = 5;
  public static final int a = -1;
  public static final long a = 64L;
  private static final String a = "ContactUtils";
  public static final int b = 0;
  public static final long b = 536870912L;
  private static String b = null;
  public static final int c = 1;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 5;
  public static final int j = 6;
  public static final int k = 7;
  public static final int l = 8;
  public static final int m = -1;
  public static final int n = 0;
  public static final int o = 1;
  public static final int p = 2;
  public static final int q = 3;
  public static final int r = 4;
  public static final int s = 6;
  public static final int t = 7;
  public static final int u = 0;
  public static final int v = 3;
  private static final int w = 0;
  private static final int x = 1;
  private static final int y = 2;
  private static final int z = 3;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 2130840283;
    case 1: 
      return 2130840296;
    case 3: 
      return 2130840284;
    case 4: 
      return 2130840285;
    case 5: 
      return 2130840294;
    case 6: 
      return 2130840292;
    case 100: 
      return 2130840287;
    }
    return 2130840290;
  }
  
  public static int a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    switch (paramInt2)
    {
    default: 
      paramInt1 = 0;
    }
    while (paramInt4 == 69378)
    {
      return 0;
      paramInt1 = 8;
      continue;
      paramInt1 = 4;
      continue;
      paramInt1 = 0;
      continue;
      paramInt1 = 1;
      continue;
      paramInt1 = 0;
      continue;
      paramInt1 = 2;
      continue;
      paramInt1 = 3;
      continue;
      paramInt1 = 7;
      continue;
      paramInt1 = 4;
      continue;
      paramInt1 = 0;
    }
    if ((paramInt1 != 0) && (paramInt1 != 6) && (paramInt1 != 4) && (OnlineStatusIconHelper.a().a(paramInt4))) {
      return 4;
    }
    return paramInt1;
  }
  
  public static int a(Friends paramFriends)
  {
    switch (a(paramFriends.status, paramFriends.detalStatusFlag, paramFriends.isMqqOnLine, paramFriends.sqqOnLineState, paramFriends.iTermType))
    {
    case 5: 
    case 6: 
    default: 
      return (int)paramFriends.getLastLoginType() + 20;
    case 1: 
      return 2;
    case 2: 
    case 7: 
      return 1;
    }
    return 0;
  }
  
  public static int a(Friends paramFriends, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    int i1 = a(paramFriends.status, paramFriends.detalStatusFlag, paramFriends.isMqqOnLine, paramFriends.sqqOnLineState, paramFriends.iTermType);
    if ((i1 != 0) && (i1 != 6))
    {
      OnlineStatusIconHelper localOnlineStatusIconHelper = OnlineStatusIconHelper.a();
      if (1 == localOnlineStatusIconHelper.a(paramFriends.iTermType, 0))
      {
        if (paramQQAppInterface.c()) {
          return 2;
        }
        return 3;
      }
      if (2 == localOnlineStatusIconHelper.a(paramFriends.iTermType, 0)) {
        return 1;
      }
      if (3 == localOnlineStatusIconHelper.a(paramFriends.iTermType, 0)) {
        return 0;
      }
      if (paramQQAppInterface.c()) {
        return 2;
      }
      return 3;
    }
    if (paramFriends.showLoginClient == 1L) {
      return 2;
    }
    if (paramFriends.showLoginClient == 3L) {
      return 0;
    }
    if (paramFriends.showLoginClient == 2L) {
      return 1;
    }
    return 3;
  }
  
  private static int a(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramString = paramString.getBytes("utf-8");
      return paramString.length;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = arrayOfByte;
      }
    }
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 2: 
      return " - 2G";
    case 3: 
      return " - 3G";
    case 4: 
      return " - 4G";
    }
    return " - WiFi";
  }
  
  private static String a(int paramInt, String paramString, Friends paramFriends, PhoneContact paramPhoneContact)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return "";
    }
    if (paramFriends != null)
    {
      if (!TextUtils.isEmpty(paramFriends.remark)) {
        return paramFriends.remark;
      }
      return paramFriends.name;
    }
    return paramString;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    int i1 = 4;
    switch (paramInt)
    {
    case 95: 
    case 100: 
    case 101: 
    default: 
      i1 = 0;
    }
    for (;;)
    {
      switch (i1)
      {
      case 5: 
      case 6: 
      default: 
        return paramContext.getString(2131562533);
        i1 = 0;
        continue;
        i1 = 1;
        continue;
        i1 = 0;
        continue;
        i1 = 2;
        continue;
        i1 = 3;
        continue;
        i1 = 7;
      }
    }
    return paramContext.getString(2131561688);
    return paramContext.getString(2131561723);
    return paramContext.getString(2131562556);
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5)
  {
    return a(paramContext, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, paramInt4, paramInt5, false);
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3)
  {
    switch (a(paramInt1, paramInt2, paramBoolean1, paramInt3, paramInt4))
    {
    case 5: 
    case 6: 
    default: 
      return null;
    case 1: 
      return paramContext.getString(2131561688);
    case 2: 
      return paramContext.getString(2131561723);
    case 3: 
      return paramContext.getString(2131562556);
    case 4: 
      OnlineStatusIconHelper localOnlineStatusIconHelper = OnlineStatusIconHelper.a();
      if (68361 == paramInt4)
      {
        if (paramInt5 == 0) {
          return paramContext.getString(2131562556);
        }
        return paramContext.getString(2131562556);
      }
      if ((68104 == paramInt4) || (65805 == paramInt4)) {
        return paramContext.getString(2131562556);
      }
      if (3 == localOnlineStatusIconHelper.a(paramInt4, 0)) {
        return paramContext.getString(2131562556);
      }
      if (2 == localOnlineStatusIconHelper.a(paramInt4, 0)) {
        return paramContext.getString(2131562556);
      }
      return paramContext.getString(2131562556);
    }
    return paramContext.getString(2131561723);
  }
  
  public static String a(Context paramContext, DiscussionInfo paramDiscussionInfo)
  {
    String str = "";
    if (paramDiscussionInfo != null) {
      str = paramDiscussionInfo.discussionName;
    }
    if (str != null)
    {
      paramDiscussionInfo = str;
      if (str.length() != 0) {}
    }
    else
    {
      paramDiscussionInfo = paramContext.getResources().getString(2131562504);
    }
    return paramDiscussionInfo;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = (DiscussionManager)paramQQAppInterface.getManager(48);
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.a(paramString);; paramQQAppInterface = null) {
      return a(paramContext, paramQQAppInterface);
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString)
  {
    try
    {
      switch (paramSessionInfo.jdField_a_of_type_Int)
      {
      }
      String str;
      for (;;)
      {
        if (paramBoolean)
        {
          return paramQQAppInterface.e();
          return a(paramQQAppInterface, paramString, paramSessionInfo.jdField_a_of_type_JavaLangString, 1, 0);
          return b(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString);
        }
        str = paramSessionInfo.d;
        if (str == null) {}
      }
      return str;
    }
    catch (Exception paramQQAppInterface)
    {
      try
      {
        if (str.length() != 0) {
          break label107;
        }
        paramQQAppInterface = a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, "", 0, 0);
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface)
      {
        return str;
      }
      paramQQAppInterface = paramQQAppInterface;
      return paramString;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    String str1 = paramDiscussionMemberInfo.memberUin;
    if (!TextUtils.isEmpty(paramDiscussionMemberInfo.inteRemark)) {}
    for (str1 = paramDiscussionMemberInfo.inteRemark;; str1 = paramDiscussionMemberInfo.memberName)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = h(paramQQAppInterface, paramDiscussionMemberInfo.memberUin);
      }
      return str2;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(46);
    Object localObject;
    if (paramTroopMemberInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNamexxx uin is null");
      }
      localObject = "";
      return localObject;
    }
    paramQQAppInterface = paramQQAppInterface.a(paramTroopMemberInfo.memberuin);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.isFriend()) && (!TextUtils.isEmpty(paramQQAppInterface.remark))) {
      paramQQAppInterface = paramQQAppInterface.remark;
    }
    for (;;)
    {
      localObject = paramQQAppInterface;
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        break;
      }
      return paramTroopMemberInfo.memberuin;
      if (!TextUtils.isEmpty(paramTroopMemberInfo.troopnick)) {
        paramQQAppInterface = paramTroopMemberInfo.troopnick;
      } else if ((paramQQAppInterface != null) && (paramQQAppInterface.isFriend())) {
        paramQQAppInterface = paramQQAppInterface.name;
      } else if (paramTroopMemberInfo != null)
      {
        if (!TextUtils.isEmpty(paramTroopMemberInfo.autoremark)) {
          paramQQAppInterface = paramTroopMemberInfo.autoremark;
        } else {
          paramQQAppInterface = paramTroopMemberInfo.friendnick;
        }
      }
      else {
        paramQQAppInterface = null;
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(46)).c(paramString);
    if (paramQQAppInterface != null) {
      paramString = paramQQAppInterface.getFriendNick();
    }
    return paramString;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = f(paramQQAppInterface, paramString);
    }
    do
    {
      return str;
      if (3000 == paramInt) {
        return c(paramQQAppInterface, paramString);
      }
      str = paramString;
    } while (paramInt != 0);
    return a(paramQQAppInterface, paramString);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = (FriendManager)paramQQAppInterface.getManager(8);
    Friends localFriends = paramQQAppInterface.c(paramString2);
    if ((localFriends == null) || (!localFriends.isFriend()))
    {
      paramQQAppInterface = paramQQAppInterface.a(paramString1, paramString2);
      if (paramQQAppInterface == null) {
        break label73;
      }
      paramQQAppInterface = paramQQAppInterface.inteRemark;
    }
    for (;;)
    {
      if ((paramQQAppInterface == null) || (paramQQAppInterface.trim().length() == 0))
      {
        return paramString2;
        paramQQAppInterface = localFriends.name;
      }
      else
      {
        return paramQQAppInterface;
        label73:
        paramQQAppInterface = "";
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = (ContactFacade)paramQQAppInterface.getManager(49);
    DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(48);
    FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)paramQQAppInterface.getManager(8);
    if ((localFriendsManagerImp != null) && (paramInt1 != 1) && (paramInt1 != 7) && (paramInt1 != 6) && (paramInt1 != 2) && (paramInt1 != 5)) {}
    for (localObject1 = localFriendsManagerImp.c(paramString1);; localObject1 = null)
    {
      switch (paramInt1)
      {
      default: 
        paramQQAppInterface = localObject2;
        if (localObject1 != null)
        {
          paramQQAppInterface = localObject2;
          if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
            paramQQAppInterface = ((Friends)localObject1).name;
          }
        }
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
        for (;;)
        {
          if (TextUtils.isEmpty(paramQQAppInterface))
          {
            return paramString1;
            paramQQAppInterface = a(paramInt2, paramString1, (Friends)localObject1, ((PhoneContactManager)paramQQAppInterface.getManager(10)).d(paramString1));
            continue;
            switch (paramInt2)
            {
            case 1: 
            case 2: 
            default: 
              paramQQAppInterface = paramString1;
              break;
            case 0: 
            case 3: 
              paramQQAppInterface = localFriendsManagerImp.b(paramString2, paramString1);
              continue;
              paramQQAppInterface = b(paramQQAppInterface, paramString2, paramString1);
              continue;
              paramQQAppInterface = b(paramInt2, paramString1, (Friends)localObject1, ((PhoneContactManager)paramQQAppInterface.getManager(10)).d(paramString1));
              continue;
              paramQQAppInterface = c(paramInt2, paramString1, (Friends)localObject1, ((PhoneContactManager)paramQQAppInterface.getManager(10)).d(paramString1));
              continue;
              paramQQAppInterface = (CircleManager)paramQQAppInterface.getManager(33);
              if (paramQQAppInterface == null) {
                break label401;
              }
              paramString2 = paramQQAppInterface.a(paramString1);
              paramQQAppInterface = paramString2;
              if (TextUtils.isEmpty(paramString2))
              {
                paramQQAppInterface = paramString2;
                if (localFriendsManagerImp != null)
                {
                  localObject1 = localFriendsManagerImp.c(paramString1);
                  paramQQAppInterface = paramString2;
                  if (localObject1 == null) {}
                }
              }
              break;
            }
          }
        }
      }
      label401:
      for (paramQQAppInterface = ((Friends)localObject1).name;; paramQQAppInterface = null)
      {
        break;
        paramQQAppInterface = a(paramQQAppInterface.a(), localDiscussionManager.a(paramString1));
        break;
        paramString2 = localFriendsManagerImp.a(paramString1);
        paramQQAppInterface = localObject2;
        if (paramString2 == null) {
          break;
        }
        paramQQAppInterface = paramString2.troopname;
        break;
        return paramQQAppInterface;
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, String paramString3, Map paramMap)
  {
    if (((0x40 & paramLong) >>> 6 == 1L) && ((paramLong & 0x20000000) != 536870912L) && ((paramMap == null) || (paramMap.size() == 0))) {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName, info is null. disUin=" + paramString1);
      }
    }
    while (!a(paramQQAppInterface, paramLong, paramString3)) {
      return paramString3;
    }
    return a(paramQQAppInterface, paramString1, paramString2, paramMap);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramString1 == null) || ("".equals(paramString1)) || (paramString2 == null) || ("".equals(paramString2)) || (paramString3 == null) || ("".equals(paramString3))) {
      paramQQAppInterface = "";
    }
    do
    {
      return paramQQAppInterface;
      localObject1 = f(paramQQAppInterface, paramString2, paramString1);
      if (!a((String)localObject1, paramString1)) {
        break;
      }
      paramQQAppInterface = (QQAppInterface)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getTroopNickName()", paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean) }));
    return localObject1;
    TroopMemberInfo localTroopMemberInfo = DBUtils.a().a(paramQQAppInterface, paramString2, paramString1);
    Object localObject2;
    if (localTroopMemberInfo != null)
    {
      localObject2 = localTroopMemberInfo.troopnick;
      localObject1 = localObject2;
      if (a((String)localObject2)) {}
    }
    for (Object localObject1 = localTroopMemberInfo.friendnick;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!a((String)localObject1))
      {
        if (paramBoolean) {
          ((ContactFacade)paramQQAppInterface.getManager(49)).a().a(paramString1, paramString2, paramString3);
        }
        localObject2 = paramString1;
      }
      paramQQAppInterface = (QQAppInterface)localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getTroopNickName()", paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean) }));
      return localObject2;
    }
  }
  
  private static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Map paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      paramString2 = "";
    }
    ContactSorter.NamePriorityComparator localNamePriorityComparator;
    ArrayList localArrayList;
    do
    {
      return paramString2;
      localNamePriorityComparator = new ContactSorter.NamePriorityComparator(paramQQAppInterface, paramString2, paramQQAppInterface.a());
      localArrayList = new ArrayList(paramMap.values());
      paramString1 = "";
      paramString2 = paramString1;
    } while (localArrayList.size() <= 0);
    paramString2 = (DiscussionMemberInfo)Collections.min(localArrayList, localNamePriorityComparator);
    localArrayList.remove(paramString2);
    paramMap = a(paramString2, paramQQAppInterface);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (paramString1.length() != 0) {}
    for (paramString2 = "、";; paramString2 = "")
    {
      paramString2 = paramString2 + paramMap;
      if (a(paramString2) > 48) {
        break label143;
      }
      paramString1 = paramString2;
      break;
    }
    label143:
    if (paramString1.length() != 0) {}
    for (paramQQAppInterface = "、" + paramMap;; paramQQAppInterface = paramMap)
    {
      int i2 = a(paramString1);
      paramString2 = new StringBuilder();
      int i1 = 0;
      while (i1 < paramQQAppInterface.length())
      {
        int i3 = paramQQAppInterface.codePointAt(i1);
        int i4 = Character.charCount(i3);
        i1 += i4;
        paramString2.appendCodePoint(i3);
        if (a(paramString2.toString()) > 48 - i2) {
          paramString2.delete(paramString2.length() - i4, paramString2.length());
        }
      }
      paramQQAppInterface = paramString2.toString();
      paramString2 = paramString1;
      if (paramQQAppInterface.equals("、")) {
        break;
      }
      return paramString1 + paramQQAppInterface;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      paramQQAppInterface = "";
    }
    do
    {
      return paramQQAppInterface;
      localObject1 = a(paramQQAppInterface, paramString, 1);
      if (!a((String)localObject1, paramString)) {
        break;
      }
      paramQQAppInterface = (QQAppInterface)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getTroopName()", paramString, Boolean.valueOf(paramBoolean) }));
    return localObject1;
    Object localObject1 = paramQQAppInterface.a().createEntityManager();
    Object localObject2 = (TroopInfo)((EntityManager)localObject1).a(TroopInfo.class, paramString);
    ((EntityManager)localObject1).a();
    if (localObject2 != null) {}
    for (localObject2 = ((TroopInfo)localObject2).troopname;; localObject2 = null)
    {
      localObject1 = localObject2;
      if (!a((String)localObject2)) {
        localObject1 = TroopSystemMsgUtil.a(paramQQAppInterface.a(), paramString);
      }
      localObject2 = localObject1;
      if (!a((String)localObject1))
      {
        if (paramBoolean) {
          ((ContactFacade)paramQQAppInterface.getManager(49)).a().a(paramString);
        }
        localObject2 = paramString;
      }
      paramQQAppInterface = (QQAppInterface)localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getTroopName()", paramString, Boolean.valueOf(paramBoolean) }));
      return localObject2;
    }
  }
  
  public static String a(DiscussionMemberInfo paramDiscussionMemberInfo, QQAppInterface paramQQAppInterface)
  {
    Object localObject = ((FriendsManagerImp)paramQQAppInterface.getManager(8)).c(paramDiscussionMemberInfo.memberUin);
    if ((localObject != null) && (((Friends)localObject).isFriend())) {}
    for (localObject = a(paramQQAppInterface, paramDiscussionMemberInfo.memberUin);; localObject = paramDiscussionMemberInfo.inteRemark)
    {
      paramQQAppInterface = (QQAppInterface)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramQQAppInterface = paramDiscussionMemberInfo.memberName;
      }
      localObject = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject = paramDiscussionMemberInfo.memberUin;
      }
      return localObject;
    }
  }
  
  @Deprecated
  public static String a(Friends paramFriends)
  {
    return paramFriends.getFriendNickWithAlias();
  }
  
  private static String a(Friends paramFriends, String paramString)
  {
    String str;
    if ((paramFriends.remark != null) && (paramFriends.remark.length() > 0)) {
      str = paramFriends.remark;
    }
    do
    {
      return str;
      if (paramString == null) {
        break;
      }
      str = paramString;
    } while (paramString.length() > 0);
    if ((paramFriends.name != null) && (paramFriends.name.length() > 0)) {
      return paramFriends.name;
    }
    return paramFriends.uin;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    String str;
    if (paramString1 == null) {
      str = "";
    }
    byte[] arrayOfByte;
    do
    {
      do
      {
        return str;
        arrayOfByte = paramString1.getBytes();
        str = paramString1;
      } while (paramInt >= arrayOfByte.length);
      str = paramString1;
    } while (paramInt < 1);
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < paramInt; i2 = i3)
    {
      i3 = i2;
      if (arrayOfByte[i1] < 0) {
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    if (i2 % 3 != 0) {
      if (paramInt == 1) {
        paramInt += 2;
      }
    }
    for (;;)
    {
      return new String(arrayOfByte, 0, paramInt) + paramString2.trim();
      paramInt -= i2 % 3;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = paramQQAppInterface.getApplication().getSharedPreferences(paramQQAppInterface.a(), 0);
    paramQQAppInterface = a(paramQQAppInterface, (SharedPreferences)localObject);
    if (paramLong != -1L) {
      paramQQAppInterface[0] = String.valueOf(paramLong);
    }
    if (paramInt1 != -1) {
      paramQQAppInterface[1] = String.valueOf(paramInt1);
    }
    if (paramInt2 != -1) {
      paramQQAppInterface[2] = String.valueOf(paramInt2);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ContactUtils", 2, "saveBindNumberFlags alertDate=" + paramQQAppInterface[0] + ", " + "alertTimes= " + paramQQAppInterface[1] + ", succFlag=" + paramQQAppInterface[2]);
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("contact_bind_flags", paramQQAppInterface[0] + "," + paramQQAppInterface[1] + "," + paramQQAppInterface[2]);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals("")) || (paramString2 == null) || (paramString2.equals(""))) {
      return;
    }
    ((PhoneContactManager)paramQQAppInterface.getManager(10)).d(paramString1, paramString2);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (b == null) {
      b = paramQQAppInterface.a().getString(2131563131);
    }
    return (((0x40 & paramLong) >>> 6 == 1L) && ((0x20000000 & paramLong) >>> 29 == 1L)) || (paramString == null) || (paramString.matches(b)) || (paramString.length() == 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    return a(paramQQAppInterface, paramDiscussionInfo.DiscussionFlag, paramDiscussionInfo.discussionName);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, DiscussionInfo paramDiscussionInfo, Map paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return false;
    }
    paramDiscussionInfo.discussionName = a(paramQQAppInterface, paramString, paramDiscussionInfo.ownerUin, paramMap);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, DiscussionInfo paramDiscussionInfo, Map paramMap, boolean paramBoolean)
  {
    if (paramDiscussionInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName, info is null. disUin=" + paramString);
      }
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName, Flag =" + paramDiscussionInfo.DiscussionFlag + " disUin=" + paramString);
      }
      if (((paramDiscussionInfo.DiscussionFlag & 0x40) >>> 6 == 1L) && ((paramDiscussionInfo.DiscussionFlag & 0x20000000) >>> 29 == 1L) && ((paramMap == null) || (paramMap.size() == 0)))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName no need disUin=" + paramString);
          return false;
        }
      }
      else
      {
        if (a(paramQQAppInterface, paramDiscussionInfo)) {}
        for (boolean bool = a(paramQQAppInterface, paramString, paramDiscussionInfo, paramMap); (paramBoolean) || (bool) || (paramDiscussionInfo.mCompareSpell == null) || (paramDiscussionInfo.mCompareSpell.length() == 0); bool = false)
        {
          ContactSorter.a(paramDiscussionInfo);
          paramDiscussionInfo.DiscussionFlag &= 0xDFFFFFFF;
          return true;
        }
      }
    }
  }
  
  public static boolean a(PhoneContactManager paramPhoneContactManager, QQAppInterface paramQQAppInterface)
  {
    int i2 = paramPhoneContactManager.b();
    if (QLog.isColorLevel()) {
      QLog.d("ContactUtils", 2, "bindState = " + i2);
    }
    int i1 = 0;
    switch (i2)
    {
    }
    while (i1 == 0)
    {
      return false;
      i1 = 1;
    }
    paramPhoneContactManager = a(paramQQAppInterface, null);
    long l2 = Long.valueOf(paramPhoneContactManager[0]).longValue();
    long l3 = System.currentTimeMillis();
    i2 = Integer.valueOf(paramPhoneContactManager[1]).intValue();
    int i3 = Integer.valueOf(paramPhoneContactManager[2]).intValue();
    if (QLog.isColorLevel()) {
      QLog.i("ContactUtils", 2, "before currDate= " + l3 + ", alertDate=" + l2 + ", " + "alertTimes= " + i2 + ", succFlag=" + i3 + ", isAlert=" + false);
    }
    if ((l3 > l2) && (l3 - l2 >= 2592000000L) && (i2 <= 3) && (i3 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      i1 = 0;
      long l1 = l2;
      if (l3 < l2)
      {
        l1 = System.currentTimeMillis();
        i1 = 1;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ContactUtils", 2, "after currDate= " + l3 + ", alertDate=" + l1 + ", " + "alertTimes= " + i2 + ", succFlag=" + i3 + ", isAlert=" + bool);
      }
      if (i1 != 0) {
        a(paramQQAppInterface, l1, i2, i3);
      }
      return bool;
    }
  }
  
  private static boolean a(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return (a(paramString1)) && (!paramString1.equals(paramString2)) && (paramString2 != null);
  }
  
  public static String[] a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    SharedPreferences localSharedPreferences = paramSharedPreferences;
    if (paramSharedPreferences == null) {
      localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences(paramQQAppInterface.a(), 0);
    }
    return localSharedPreferences.getString("contact_bind_flags", "0,0,0").split(",");
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
    case 1005: 
    case 1008: 
    case 1023: 
    case 1024: 
      return 0;
    case 3: 
    case 4: 
    case 1006: 
      return 3;
    case 2: 
    case 1000: 
    case 1020: 
      return 1;
    case 1001: 
    case 1002: 
    case 1003: 
    case 1009: 
      return 4;
    case 1021: 
      return 5;
    case 1004: 
      return 2;
    case 1: 
      return 6;
    }
    return 7;
  }
  
  private static String b(int paramInt, String paramString, Friends paramFriends, PhoneContact paramPhoneContact)
  {
    String str;
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      str = "";
    }
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString;
        } while (paramPhoneContact == null);
        return paramPhoneContact.name;
        if ((paramFriends != null) && (paramFriends.isFriend()))
        {
          if (!TextUtils.isEmpty(paramFriends.remark)) {}
          for (paramString = paramFriends.remark;; paramString = paramFriends.name) {
            return paramString;
          }
        }
        if (paramPhoneContact != null) {
          return paramPhoneContact.name;
        }
        str = paramString;
      } while (paramFriends == null);
      str = paramString;
    } while (TextUtils.isEmpty(paramFriends.name));
    return paramFriends.name;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((DiscussionManager)paramQQAppInterface.getManager(48)).a(paramString);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.discussionName))) {
      return paramQQAppInterface.discussionName;
    }
    return null;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = (DiscussionManager)paramQQAppInterface.getManager(48);
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(46);
    localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(51);
    if (paramInt == 1) {
      paramQQAppInterface = f(paramQQAppInterface, paramString);
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        if (3000 == paramInt) {
          return c(paramQQAppInterface, paramString);
        }
        if (1008 != paramInt) {
          break;
        }
        localObject = ((PublicAccountDataManager)localObject).a(paramString);
        paramQQAppInterface = paramString;
      } while (localObject == null);
      paramQQAppInterface = paramString;
    } while (((PublicAccountInfo)localObject).name == null);
    return ((PublicAccountInfo)localObject).name;
    String str;
    if (paramInt == 1006)
    {
      paramQQAppInterface = (PhoneContactManager)paramQQAppInterface.getManager(10);
      localObject = paramQQAppInterface.f(paramString);
      if (localObject != null) {
        return ((PhoneContact)localObject).name;
      }
      str = paramQQAppInterface.b(paramString);
      if (str == null) {
        break label232;
      }
      paramQQAppInterface = localFriendsManager.c(str);
      if (paramQQAppInterface == null) {
        break label232;
      }
    }
    label227:
    label232:
    for (localObject = a(paramQQAppInterface);; localObject = null)
    {
      paramQQAppInterface = paramString;
      if (localObject == null) {
        break;
      }
      paramQQAppInterface = paramString;
      if (((String)localObject).equals(str)) {
        break;
      }
      return localObject;
      if (paramInt == 1021)
      {
        localObject = ((CircleManager)paramQQAppInterface.getManager(33)).a(paramString);
        if ((!((String)localObject).equals("")) || (localFriendsManager.c(paramString) == null)) {
          break label227;
        }
      }
      for (paramQQAppInterface = a(paramQQAppInterface, paramString);; paramQQAppInterface = (QQAppInterface)localObject)
      {
        return paramQQAppInterface;
        return a(paramQQAppInterface, paramString);
      }
    }
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Object localObject = (FriendsManager)paramQQAppInterface.getManager(46);
    paramQQAppInterface = (DiscussionManager)paramQQAppInterface.getManager(48);
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getDiscussionMemberShowName uin is null");
      }
      paramQQAppInterface = "";
    }
    do
    {
      return paramQQAppInterface;
      localObject = ((FriendsManager)localObject).a(paramString2);
      if ((localObject == null) || (!((Friends)localObject).isFriend())) {
        break;
      }
      if (!TextUtils.isEmpty(((Friends)localObject).remark)) {
        return ((Friends)localObject).remark;
      }
      if (!TextUtils.isEmpty(((Friends)localObject).name)) {
        return ((Friends)localObject).name;
      }
      paramQQAppInterface = paramString2;
    } while (!QLog.isColorLevel());
    QLog.d("ContactUtils", 2, "getDiscussionMemberShowName is friend but no name.");
    return paramString2;
    paramQQAppInterface = paramQQAppInterface.a(paramString1);
    if (paramQQAppInterface != null)
    {
      localObject = (DiscussionMemberInfo)paramQQAppInterface.get(paramString2);
      if (localObject != null)
      {
        paramQQAppInterface = ((DiscussionMemberInfo)localObject).inteRemark;
        localObject = ((DiscussionMemberInfo)localObject).memberName;
        if (!TextUtils.isEmpty(paramQQAppInterface))
        {
          label152:
          localObject = paramQQAppInterface;
          if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, "discussionMemberInfoList disUin=" + paramString1 + " memberUin=" + paramString2 + " showName=" + Utils.a(paramQQAppInterface));
          }
        }
      }
    }
    for (localObject = paramQQAppInterface;; localObject = null)
    {
      if ((localObject == null) || (((String)localObject).trim().length() == 0))
      {
        paramQQAppInterface = paramString2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ContactUtils", 2, "getDiscussionMemberShowName no name. disUin=" + paramString1 + " memberUin=" + paramString2);
        return paramString2;
        paramQQAppInterface = (QQAppInterface)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label152;
        }
        paramQQAppInterface = null;
        break label152;
      }
      return localObject;
    }
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      paramQQAppInterface = "";
    }
    Object localObject1;
    label138:
    do
    {
      Object localObject2;
      do
      {
        do
        {
          return paramQQAppInterface;
          localObject3 = (FriendManager)paramQQAppInterface.getManager(8);
          if (localObject3 != null)
          {
            localObject1 = ((FriendManager)localObject3).c(paramString);
            if (localObject1 != null)
            {
              if (((Friends)localObject1).isFriend()) {
                if ((((Friends)localObject1).remark != null) && (!"".equals(((Friends)localObject1).remark))) {
                  localObject1 = ((Friends)localObject1).remark;
                }
              }
              for (;;)
              {
                if (localObject1 == null) {
                  break label138;
                }
                paramQQAppInterface = (QQAppInterface)localObject1;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
                return localObject1;
                localObject1 = ((Friends)localObject1).name;
                continue;
                localObject1 = ((Friends)localObject1).name;
              }
            }
          }
          localObject2 = a(paramQQAppInterface, paramString);
          if (!a((String)localObject2, paramString)) {
            break;
          }
          paramQQAppInterface = (QQAppInterface)localObject2;
        } while (!QLog.isColorLevel());
        QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
        return localObject2;
        localObject1 = localObject2;
        if (!a((String)localObject2, paramString))
        {
          localObject3 = ((FriendManager)localObject3).a(paramString);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = ((Card)localObject3).strNick;
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
              }
              return localObject1;
            }
          }
        }
        localObject2 = localObject1;
        if (a((String)localObject1, paramString)) {
          break;
        }
        Object localObject3 = (PublicAccountDataManager)paramQQAppInterface.getManager(51);
        localObject2 = localObject1;
        if (localObject3 == null) {
          break;
        }
        localObject3 = ((PublicAccountDataManager)localObject3).b(paramString);
        localObject2 = localObject1;
        if (localObject3 == null) {
          break;
        }
        localObject1 = ((PublicAccountInfo)localObject3).name;
        localObject2 = localObject1;
        if (localObject1 == null) {
          break;
        }
        paramQQAppInterface = (QQAppInterface)localObject1;
      } while (!QLog.isColorLevel());
      QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
      return localObject1;
      localObject1 = localObject2;
      if (!a((String)localObject2, paramString))
      {
        if (paramBoolean) {
          ((ContactFacade)paramQQAppInterface.getManager(49)).a().b(paramString);
        }
        localObject1 = paramString;
      }
      paramQQAppInterface = (QQAppInterface)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
    return localObject1;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    return (a(paramQQAppInterface, paramDiscussionInfo)) || (paramDiscussionInfo.mCompareSpell == null) || (paramDiscussionInfo.mCompareSpell.length() == 0);
  }
  
  private static boolean b(String paramString)
  {
    if (paramString != null)
    {
      int i1 = 0;
      while (i1 < paramString.length())
      {
        if (!Character.isSpaceChar(paramString.charAt(i1))) {
          return false;
        }
        i1 += 1;
      }
    }
    return true;
  }
  
  private static String c(int paramInt, String paramString, Friends paramFriends, PhoneContact paramPhoneContact)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return "";
    }
    if ((paramFriends != null) && (paramFriends.isFriend()))
    {
      if (!TextUtils.isEmpty(paramFriends.remark)) {
        return paramFriends.remark;
      }
      return paramFriends.name;
    }
    if (paramPhoneContact != null) {
      return paramPhoneContact.name;
    }
    if ((paramFriends != null) && (!TextUtils.isEmpty(paramFriends.name))) {
      return paramFriends.name;
    }
    return paramString;
  }
  
  public static String c(QQAppInterface paramQQAppInterface, String paramString)
  {
    DiscussionInfo localDiscussionInfo = ((DiscussionManager)paramQQAppInterface.getManager(48)).a(paramString);
    paramQQAppInterface = paramString;
    if (localDiscussionInfo != null)
    {
      paramQQAppInterface = paramString;
      if (!TextUtils.isEmpty(localDiscussionInfo.discussionName)) {
        paramQQAppInterface = localDiscussionInfo.discussionName;
      }
    }
    return paramQQAppInterface;
  }
  
  public static String c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = (FriendsManagerImp)paramQQAppInterface.getManager(8);
    paramString2 = paramQQAppInterface.f(paramString2);
    if (paramString2 == null) {
      return paramString1;
    }
    return paramQQAppInterface.b(paramString2, paramString1);
  }
  
  public static String c(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      paramQQAppInterface = "";
    }
    Object localObject1;
    do
    {
      Object localObject2;
      do
      {
        do
        {
          do
          {
            return paramQQAppInterface;
            localObject2 = a(paramQQAppInterface, paramString, 0);
            if (!a((String)localObject2, paramString)) {
              break;
            }
            paramQQAppInterface = (QQAppInterface)localObject2;
          } while (!QLog.isColorLevel());
          QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
          return localObject2;
          localObject3 = (FriendManager)paramQQAppInterface.getManager(8);
          localObject1 = localObject2;
          if (localObject3 == null) {
            break;
          }
          Friends localFriends = ((FriendManager)localObject3).c(paramString);
          localObject1 = localObject2;
          if (localFriends == null) {
            break;
          }
          localObject2 = localFriends.name;
          localObject1 = localObject2;
          if (localObject2 == null) {
            break;
          }
          paramQQAppInterface = (QQAppInterface)localObject2;
        } while (!QLog.isColorLevel());
        QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
        return localObject2;
        localObject2 = localObject1;
        if (a((String)localObject1, paramString)) {
          break;
        }
        Object localObject3 = ((FriendManager)localObject3).a(paramString);
        localObject2 = localObject1;
        if (localObject3 == null) {
          break;
        }
        localObject1 = ((Card)localObject3).strNick;
        localObject2 = localObject1;
        if (localObject1 == null) {
          break;
        }
        paramQQAppInterface = (QQAppInterface)localObject1;
      } while (!QLog.isColorLevel());
      QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
      return localObject1;
      localObject1 = localObject2;
      if (!a((String)localObject2, paramString))
      {
        if (paramBoolean) {
          ((ContactFacade)paramQQAppInterface.getManager(49)).a().b(paramString);
        }
        localObject1 = paramString;
      }
      paramQQAppInterface = (QQAppInterface)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("ContactUtils", 2, StringUtil.a(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
    return localObject1;
  }
  
  public static String d(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.b(paramString);
    }
    return "";
  }
  
  public static String d(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(47);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNick uin is null");
      }
      paramString2 = "";
    }
    do
    {
      return paramString2;
      paramQQAppInterface = paramQQAppInterface.a(paramString1, paramString2);
      if (paramQQAppInterface == null) {
        break;
      }
      if (!TextUtils.isEmpty(paramQQAppInterface.troopnick)) {
        return paramQQAppInterface.troopnick;
      }
    } while (TextUtils.isEmpty(paramQQAppInterface.friendnick));
    return paramQQAppInterface.friendnick;
    return "";
  }
  
  public static String e(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((PhoneContactManager)paramQQAppInterface.getManager(10)).c(paramString);
  }
  
  public static String e(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(47);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNameWithoutRemark uin is null");
      }
      return "";
    }
    paramString1 = localTroopManager.a(paramString1, paramString2);
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(46)).a(paramString2);
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.troopnick))) {
      return paramString1.troopnick;
    }
    if ((paramQQAppInterface != null) && (paramQQAppInterface.isFriend())) {
      return paramQQAppInterface.name;
    }
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.friendnick))) {
      return paramString1.friendnick;
    }
    return "";
  }
  
  public static String f(QQAppInterface paramQQAppInterface, String paramString)
  {
    TroopInfo localTroopInfo = ((FriendsManagerImp)paramQQAppInterface.getManager(8)).a(paramString);
    paramQQAppInterface = paramString;
    if (localTroopInfo != null)
    {
      paramQQAppInterface = paramString;
      if (localTroopInfo.troopname != null) {
        paramQQAppInterface = localTroopInfo.troopname;
      }
    }
    return paramQQAppInterface;
  }
  
  public static String f(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Object localObject = (FriendsManager)paramQQAppInterface.getManager(46);
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(47);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberName uin is null");
      }
      paramString2 = "";
    }
    for (;;)
    {
      return paramString2;
      localObject = ((FriendsManager)localObject).a(paramString2);
      if ((localObject != null) && (((Friends)localObject).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
        paramQQAppInterface = ((Friends)localObject).remark;
      }
      while (!TextUtils.isEmpty(paramQQAppInterface))
      {
        return paramQQAppInterface;
        paramQQAppInterface = paramQQAppInterface.a(paramString1, paramString2);
        if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.troopnick)))
        {
          paramString1 = paramQQAppInterface.troopnick;
          paramQQAppInterface = paramString1;
          if (paramString2.equals("1000000"))
          {
            paramQQAppInterface = paramString1;
            if (paramString1.equals("系统消息")) {
              paramQQAppInterface = BaseApplicationImpl.getContext().getString(2131559910);
            }
          }
        }
        else if ((localObject != null) && (((Friends)localObject).isFriend()))
        {
          paramQQAppInterface = ((Friends)localObject).name;
        }
        else if (paramQQAppInterface != null)
        {
          if (!TextUtils.isEmpty(paramQQAppInterface.autoremark)) {
            paramQQAppInterface = paramQQAppInterface.autoremark;
          } else {
            paramQQAppInterface = paramQQAppInterface.friendnick;
          }
        }
        else
        {
          paramQQAppInterface = null;
        }
      }
    }
  }
  
  public static String g(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      paramString = null;
    }
    label93:
    label96:
    for (;;)
    {
      return paramString;
      String str = paramQQAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramString);
      if (TextUtils.isEmpty(str))
      {
        paramQQAppInterface = (FriendManager)paramQQAppInterface.getManager(8);
        if (paramQQAppInterface == null)
        {
          paramQQAppInterface = localObject;
          if (paramQQAppInterface == null) {
            break label93;
          }
        }
      }
      for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = str)
      {
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label96;
        }
        return paramQQAppInterface;
        paramQQAppInterface = paramQQAppInterface.c(paramString);
        break;
      }
    }
  }
  
  public static String g(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(47);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNick uin is null");
      }
      return "";
    }
    paramQQAppInterface = paramQQAppInterface.a(paramString1, paramString2);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.troopnick))) {
      return paramQQAppInterface.troopnick;
    }
    return "";
  }
  
  public static String h(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(46);
    Object localObject = paramQQAppInterface.c(paramString);
    if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
      paramQQAppInterface = ((Friends)localObject).name;
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        localObject = paramQQAppInterface.a(paramString);
        paramQQAppInterface = paramString;
      } while (localObject == null);
      paramQQAppInterface = paramString;
    } while (TextUtils.isEmpty(((Card)localObject).strNick));
    return ((Card)localObject).strNick;
  }
  
  public static String i(QQAppInterface paramQQAppInterface, String paramString)
  {
    Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(46)).c(paramString);
    paramQQAppInterface = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.d(paramString);
      if (paramQQAppInterface == null) {}
    }
    for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = null)
    {
      if (localFriends != null) {
        paramString = a(localFriends, paramQQAppInterface);
      }
      return paramString;
    }
  }
  
  public static String j(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = ((FriendsManagerImp)paramQQAppInterface.getManager(8)).f(paramString);
    if (str == null) {
      return paramString;
    }
    return b(paramQQAppInterface, str, 1);
  }
  
  public static String k(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramQQAppInterface = "";
    }
    Friends localFriends;
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          localFriends = ((FriendsManager)paramQQAppInterface.getManager(46)).a(paramString);
          paramQQAppInterface = paramString;
        } while (localFriends == null);
        paramQQAppInterface = paramString;
      } while (!localFriends.isFriend());
      if (!TextUtils.isEmpty(localFriends.remark)) {
        return localFriends.remark;
      }
      paramQQAppInterface = paramString;
    } while (TextUtils.isEmpty(localFriends.name));
    return localFriends.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ContactUtils
 * JD-Core Version:    0.7.0.1
 */