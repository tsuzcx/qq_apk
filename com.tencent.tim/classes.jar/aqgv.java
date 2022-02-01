import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.ContactUtils.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class aqgv
{
  private static String ctb;
  public static String ctc = "troop_mem_nick_update_target";
  public static String ctd = "uni_seq";
  public static String cte;
  public static int dZf = -1;
  public static int dZg = 1;
  public static int dZh = 2;
  public static Paint sPaint = new Paint();
  
  @NotNull
  public static String A(QQAppInterface paramQQAppInterface, String paramString)
  {
    Friends localFriends = ((acff)paramQQAppInterface.getManager(51)).e(paramString);
    paramQQAppInterface = (ajdo)paramQQAppInterface.getManager(11);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramString);
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
  
  @NotNull
  public static String B(QQAppInterface paramQQAppInterface, String paramString)
  {
    Friends localFriends = ((acff)paramQQAppInterface.getManager(51)).c(paramString);
    paramQQAppInterface = (ajdo)paramQQAppInterface.getManager(11);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramString);
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
  
  public static String BW()
  {
    return cte;
  }
  
  public static String C(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = ((acff)paramQQAppInterface.getManager(51)).e(paramString);
    paramQQAppInterface = (ajdo)paramQQAppInterface.getManager(11);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a("");
      if (paramQQAppInterface == null) {}
    }
    for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = null)
    {
      if (paramString != null) {
        return b(paramString, paramQQAppInterface);
      }
      return "";
    }
  }
  
  public static String D(QQAppInterface paramQQAppInterface, String paramString)
  {
    Friends localFriends = ((acff)paramQQAppInterface.getManager(51)).e(paramString);
    paramQQAppInterface = (ajdo)paramQQAppInterface.getManager(11);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramString);
      if (paramQQAppInterface == null) {}
    }
    for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = null)
    {
      if (localFriends != null)
      {
        if ((localFriends.remark != null) && (localFriends.remark.length() > 0)) {
          paramString = localFriends.remark;
        }
      }
      else {
        return paramString;
      }
      if ((localFriends.name != null) && (localFriends.name.length() > 0)) {
        return localFriends.name;
      }
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
        return paramQQAppInterface;
      }
      return localFriends.uin;
    }
  }
  
  public static Drawable E(int paramInt)
  {
    if (paramInt == 0) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      paramInt = 2130839752;
    }
    for (;;)
    {
      return BaseApplicationImpl.getContext().getResources().getDrawable(paramInt);
      paramInt = 2130839751;
      continue;
      paramInt = 2130839753;
    }
  }
  
  public static String E(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.equals(paramString, paramQQAppInterface.getCurrentAccountUin()))
    {
      localObject = ((acff)paramQQAppInterface.getManager(51)).e(paramString);
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(((Friends)localObject).name)) {
          paramString = ((Friends)localObject).name;
        }
        return paramString;
      }
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).bC(paramString, false);
      return paramString;
    }
    Object localObject = D(paramQQAppInterface, paramString);
    if (((String)localObject).equals(paramString)) {
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).bC(paramString, false);
    }
    return localObject;
  }
  
  public static String F(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = ((TroopManager)paramQQAppInterface.getManager(52)).jq(paramString);
    if (str == null) {
      return paramString;
    }
    return e(paramQQAppInterface, str, 1);
  }
  
  public static String G(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
    {
      localObject = "";
      return localObject;
    }
    if (TextUtils.equals(paramString, acbn.bll)) {
      return BaseApplicationImpl.getContext().getString(2131696057);
    }
    if (TextUtils.equals(paramString, acbn.blm)) {
      return BaseApplicationImpl.getContext().getString(2131696062);
    }
    long l = 0L;
    Object localObject = ((acff)paramQQAppInterface.getManager(51)).a(paramString);
    String str;
    if (localObject != null)
    {
      str = ((DateNickNameInfo)localObject).nickName;
      l = ((DateNickNameInfo)localObject).lastUpdateTime;
    }
    for (;;)
    {
      if (str != null)
      {
        localObject = str;
        if (Math.abs(System.currentTimeMillis() - l) < 86400000L) {
          break;
        }
      }
      if (str == null) {
        str = "";
      }
      for (;;)
      {
        ((acda)paramQQAppInterface.getManager(54)).a().Up(paramString);
        return str;
      }
      str = null;
    }
  }
  
  public static void Xr(int paramInt)
  {
    String str = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      cte = str;
      return;
      str = "0X80068AA";
      continue;
      str = "0X80068AB";
      continue;
      str = "0X80068AC";
      continue;
      str = "0X80068AD";
      continue;
      str = "0X80068AE";
      continue;
      str = "0X80068AF";
      continue;
      str = "0X80068B0";
      continue;
      str = "0X80068B1";
    }
  }
  
  public static int a(Friends paramFriends, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
    int i = aU(paramFriends.detalStatusFlag, paramFriends.iTermType);
    if ((i != 0) && (i != 6))
    {
      zaq localzaq = zaq.a();
      if (1 == localzaq.am(paramFriends.iTermType, 0))
      {
        if (paramQQAppInterface.aaa()) {
          return 2;
        }
        return 3;
      }
      if (2 == localzaq.am(paramFriends.iTermType, 0)) {
        return 1;
      }
      if (3 == localzaq.am(paramFriends.iTermType, 0)) {
        return 0;
      }
      if (paramQQAppInterface.aaa()) {
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
  
  public static aqgv.a a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Friends localFriends = ((acff)paramQQAppInterface.getManager(51)).b(paramString2);
    if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.remark))) {
      return new aqgv.a(localFriends.remark, false);
    }
    paramString1 = ((TroopManager)paramQQAppInterface.getManager(52)).a(paramString1, paramString2);
    boolean bool;
    if (paramString1 != null) {
      if (!TextUtils.isEmpty(paramString1.troopnick))
      {
        paramString2 = paramString1.troopnick;
        bool = false;
      }
    }
    for (;;)
    {
      return new aqgv.a(paramString2, bool);
      if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name)))
      {
        paramString2 = localFriends.name;
        bool = false;
      }
      else
      {
        if (paramString2.equals(paramQQAppInterface.getCurrentAccountUin()))
        {
          if (!TextUtils.isEmpty(paramString1.friendnick))
          {
            paramString2 = paramString1.friendnick;
            bool = false;
          }
        }
        else
        {
          if (!TextUtils.isEmpty(paramString1.autoremark))
          {
            paramString2 = paramString1.autoremark;
            bool = false;
            continue;
          }
          if (!TextUtils.isEmpty(paramString1.friendnick))
          {
            paramString2 = paramString1.friendnick;
            bool = false;
            continue;
            bool = true;
            continue;
          }
        }
        bool = false;
      }
    }
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
      paramDiscussionInfo = paramContext.getResources().getString(2131692826);
    }
    return paramDiscussionInfo;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    String str = "";
    if (paramInt == 1) {
      str = o(paramQQAppInterface, paramString1, paramString2);
    }
    while (paramInt != 3000) {
      return str;
    }
    return m(paramQQAppInterface, paramString1, paramString2);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString)
  {
    try
    {
      switch (paramSessionInfo.cZ)
      {
      }
      String str;
      for (;;)
      {
        if (paramBoolean)
        {
          return paramQQAppInterface.getCurrentNickname();
          return a(paramQQAppInterface, paramString, paramSessionInfo.aTl, 1, 0);
          return m(paramQQAppInterface, paramSessionInfo.aTl, paramString);
        }
        str = paramSessionInfo.aTn;
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
        paramQQAppInterface = a(paramQQAppInterface, paramSessionInfo.aTl, "", 0, 0);
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
        str2 = o(paramQQAppInterface, paramDiscussionMemberInfo.memberUin);
      }
      return str2;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject = (acda)paramQQAppInterface.getManager(54);
    acdu localacdu = (acdu)paramQQAppInterface.getManager(53);
    localObject = (acff)paramQQAppInterface.getManager(51);
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    if ((localObject != null) && (paramInt1 != 1) && (paramInt1 != 7) && (paramInt1 != 6) && (paramInt1 != 2) && (paramInt1 != 5)) {}
    for (localObject = ((acff)localObject).e(paramString1);; localObject = null)
    {
      switch (paramInt1)
      {
      case 5: 
      default: 
        if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
          paramQQAppInterface = ((Friends)localObject).name;
        }
        break;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramQQAppInterface))
        {
          return paramString1;
          paramQQAppInterface = a(paramInt2, paramString1, (Friends)localObject, ((ajdo)paramQQAppInterface.getManager(11)).a(paramString1));
          continue;
          paramQQAppInterface = e(paramQQAppInterface, paramString1, 1008);
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
            paramQQAppInterface = localTroopManager.getTroopMemberName(paramString2, paramString1);
            continue;
            paramQQAppInterface = m(paramQQAppInterface, paramString2, paramString1);
            continue;
            paramQQAppInterface = b(paramInt2, paramString1, (Friends)localObject, ((ajdo)paramQQAppInterface.getManager(11)).a(paramString1));
            continue;
            paramQQAppInterface = c(paramInt2, paramString1, (Friends)localObject, ((ajdo)paramQQAppInterface.getManager(11)).a(paramString1));
            continue;
            paramQQAppInterface = a(paramQQAppInterface.getApp(), localacdu.a(paramString1));
            continue;
            paramQQAppInterface = localTroopManager.b(paramString1);
            if (paramQQAppInterface == null) {
              break label358;
            }
            paramQQAppInterface = paramQQAppInterface.getTroopName();
            break;
          }
        }
        else
        {
          return paramQQAppInterface;
          label358:
          paramQQAppInterface = null;
        }
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, String paramString3, Map<String, DiscussionMemberInfo> paramMap)
  {
    if (((0x40 & paramLong) >>> 6 == 1L) && ((paramLong & 0x20000000) != 536870912L) && ((paramMap == null) || (paramMap.size() == 0))) {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "setDiscussionNameAndCompareName, info is null. disUin=" + paramString1);
      }
    }
    while (!b(paramQQAppInterface, paramLong, paramString3)) {
      return paramString3;
    }
    return a(paramQQAppInterface, paramString2, paramMap);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    String str = null;
    if (paramMessageRecord != null) {
      str = paramMessageRecord.getExtInfoFromExtStr("troop_msg_nickname");
    }
    paramMessageRecord = str;
    if (TextUtils.isEmpty(str)) {
      paramMessageRecord = m(paramQQAppInterface, paramString1, paramString2);
    }
    return paramMessageRecord;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramString1 == null) || ("".equals(paramString1)) || (paramString2 == null) || ("".equals(paramString2)) || (paramString3 == null) || ("".equals(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, aqmr.makeLogMsg(new Object[] { "getTroopNickName()", paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean), paramBundle }));
      }
      localObject1 = "";
    }
    boolean bool;
    do
    {
      return localObject1;
      localObject1 = h(paramQQAppInterface, paramString2, paramString1);
      bool = bS((String)localObject1, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, aqmr.makeLogMsg(new Object[] { "getTroopNickName()", paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean), localObject1 }));
      }
    } while (bool);
    TroopMemberInfo localTroopMemberInfo = aqgx.a().a(paramQQAppInterface, paramString2, paramString1);
    Object localObject2;
    if (localTroopMemberInfo != null)
    {
      localObject2 = localTroopMemberInfo.troopnick;
      localObject1 = localObject2;
      if (kt((String)localObject2)) {}
    }
    for (Object localObject1 = localTroopMemberInfo.friendnick;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!kt((String)localObject1))
      {
        if (paramBoolean) {
          ((acda)paramQQAppInterface.getManager(54)).a().e(paramString1, paramString2, paramString3, paramBundle);
        }
        localObject2 = paramString1;
      }
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ContactUtils", 2, aqmr.makeLogMsg(new Object[] { "getTroopNickName()", paramString1, paramString2, paramString3, Boolean.valueOf(paramBoolean), localObject2 }));
      return localObject2;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNameWithoutRemark uin is null");
      }
      return "";
    }
    TroopMemberInfo localTroopMemberInfo = localTroopManager.b(paramString1, paramString2);
    paramQQAppInterface = ((acff)paramQQAppInterface.getManager(51)).b(paramString2);
    if ((localTroopMemberInfo != null) && (paramBoolean) && (!TextUtils.isEmpty(localTroopMemberInfo.troopColorNick))) {
      paramQQAppInterface = localTroopMemberInfo.troopColorNick;
    }
    for (;;)
    {
      if ((paramQQAppInterface != null) && (paramQQAppInterface.equals(paramString2)))
      {
        paramString1 = localTroopManager.b(paramString1);
        if ((paramString1 != null) && (paramString1.isQidianPrivateTroop()))
        {
          return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
          if ((localTroopMemberInfo != null) && (!paramBoolean) && (!TextUtils.isEmpty(localTroopMemberInfo.troopnick)))
          {
            paramQQAppInterface = localTroopMemberInfo.troopnick;
            continue;
          }
          if ((paramQQAppInterface != null) && (paramQQAppInterface.isFriend()))
          {
            paramQQAppInterface = paramQQAppInterface.name;
            continue;
          }
          if ((localTroopMemberInfo == null) || (TextUtils.isEmpty(localTroopMemberInfo.friendnick))) {
            break label202;
          }
          paramQQAppInterface = localTroopMemberInfo.friendnick;
          continue;
        }
      }
      return paramQQAppInterface;
      label202:
      paramQQAppInterface = "";
    }
  }
  
  private static String a(QQAppInterface paramQQAppInterface, String paramString, Map<String, DiscussionMemberInfo> paramMap)
  {
    Object localObject = "";
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramMap == null) || (paramMap.size() == 0))
    {
      paramString = (String)localObject;
      if (QLog.isColorLevel())
      {
        QLog.i("ContactUtils", 2, " === getDiscussionCombinedName app is null or ownerUin is null or members is null or members size is 0 ====");
        paramString = (String)localObject;
      }
      return paramString;
    }
    localObject = new acdb.b(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin());
    ArrayList localArrayList = new ArrayList(paramMap.values());
    for (paramString = "";; paramString = paramMap)
    {
      if (localArrayList.size() <= 0) {
        return paramString;
      }
      paramMap = (DiscussionMemberInfo)Collections.min(localArrayList, (Comparator)localObject);
      localArrayList.remove(paramMap);
      paramMap = j(48, paramString, a(paramMap, paramQQAppInterface));
      paramString = paramMap;
      if (paramMap.length() >= 47) {
        break;
      }
    }
    return paramString;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      paramQQAppInterface = "";
    }
    do
    {
      return paramQQAppInterface;
      localObject1 = d(paramQQAppInterface, paramString, 1);
      if (!bS((String)localObject1, paramString)) {
        break;
      }
      paramQQAppInterface = (QQAppInterface)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("ContactUtils", 2, aqmr.makeLogMsg(new Object[] { "getTroopName()", paramString, Boolean.valueOf(paramBoolean) }));
    return localObject1;
    Object localObject1 = paramQQAppInterface.a().createEntityManager();
    Object localObject2 = (TroopInfo)((EntityManager)localObject1).find(TroopInfo.class, paramString);
    ((EntityManager)localObject1).close();
    if (localObject2 != null) {}
    for (localObject2 = ((TroopInfo)localObject2).getTroopName();; localObject2 = null)
    {
      localObject1 = localObject2;
      if (!kt((String)localObject2)) {
        localObject1 = aqfs.J(paramQQAppInterface.getApp(), paramString);
      }
      localObject2 = localObject1;
      if (!kt((String)localObject1))
      {
        if (paramBoolean) {
          ((acda)paramQQAppInterface.getManager(54)).a().Un(paramString);
        }
        localObject2 = paramString;
      }
      paramQQAppInterface = (QQAppInterface)localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ContactUtils", 2, aqmr.makeLogMsg(new Object[] { "getTroopName()", paramString, Boolean.valueOf(paramBoolean) }));
      return localObject2;
    }
  }
  
  public static String a(DiscussionMemberInfo paramDiscussionMemberInfo, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = ((acff)paramQQAppInterface.getManager(51)).b(paramDiscussionMemberInfo.memberUin);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.isFriend())) {}
    for (Object localObject = paramQQAppInterface.getFriendNick();; localObject = paramDiscussionMemberInfo.inteRemark)
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
  
  public static String a(PhoneContact paramPhoneContact)
  {
    String str2 = paramPhoneContact.strTermDesc;
    String str1 = str2;
    if (aU(paramPhoneContact.detalStatusFlag, paramPhoneContact.iTermType) == 4)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!b(paramPhoneContact)) {
          str1 = str2 + gg(paramPhoneContact.getNetWorkType());
        }
      }
    }
    return str1;
  }
  
  public static String a(String paramString, float paramFloat)
  {
    String str = paramString;
    int i;
    int j;
    if (d(paramString) > paramFloat)
    {
      i = Math.max(0, (int)(paramFloat - 3.0F));
      j = i;
    }
    for (;;)
    {
      if ((i >= paramString.length()) || (d(paramString.substring(0, i) + "…") > paramFloat))
      {
        str = paramString.substring(0, j) + "…";
        return str;
      }
      j = i;
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, aqgv.b paramb)
  {
    ThreadManager.post(new ContactUtils.1(paramQQAppInterface, paramString1, paramString2, paramb), 5, null, false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    return b(paramQQAppInterface, paramDiscussionInfo.DiscussionFlag, paramDiscussionInfo.discussionName);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, DiscussionInfo paramDiscussionInfo, Map<String, DiscussionMemberInfo> paramMap)
  {
    if ((paramDiscussionInfo == null) || (paramMap == null) || (paramMap.size() == 0)) {
      return false;
    }
    paramDiscussionInfo.discussionName = a(paramQQAppInterface, paramDiscussionInfo.ownerUin, paramMap);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, DiscussionInfo paramDiscussionInfo, Map<String, DiscussionMemberInfo> paramMap, boolean paramBoolean)
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
      if ((!paramDiscussionInfo.hasRenamed()) && ((paramDiscussionInfo.DiscussionFlag & 0x20000000) >>> 29 == 1L) && ((paramMap == null) || (paramMap.size() == 0)))
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
          acdb.c(paramDiscussionInfo);
          paramDiscussionInfo.DiscussionFlag &= 0xDFFFFFFF;
          return true;
        }
      }
    }
  }
  
  public static int aU(int paramInt1, int paramInt2)
  {
    int i = 4;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      if ((paramInt2 == 69378) || (paramInt2 == 73474) || (paramInt2 == 73730)) {
        i = 0;
      }
      break;
    }
    while ((paramInt1 != 0) && (paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 7) && (paramInt1 != 6) && (paramInt1 != 3) && (paramInt1 != 4) && (zaq.a().gR(paramInt2)))
    {
      return i;
      paramInt1 = 8;
      break;
      paramInt1 = 4;
      break;
      paramInt1 = 0;
      break;
      paramInt1 = 1;
      break;
      paramInt1 = 0;
      break;
      paramInt1 = 2;
      break;
      paramInt1 = 3;
      break;
      paramInt1 = 7;
      break;
      paramInt1 = 4;
      break;
      paramInt1 = 0;
      break;
    }
    return paramInt1;
  }
  
  public static boolean aa(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((acdu)paramQQAppInterface.getManager(53)).a(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.isDiscussHrMeeting();
    }
    return false;
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
  
  public static String b(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 3000) {
      return m(paramQQAppInterface, paramString1, paramString2);
    }
    if (paramInt == 1)
    {
      paramString1 = o(paramQQAppInterface, paramString1, paramString2);
      if (TextUtils.isEmpty(paramString1))
      {
        ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).bC(paramString2, false);
        return paramString2;
      }
      return paramString1;
    }
    return E(paramQQAppInterface, paramString2);
  }
  
  public static String b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = (acdu)paramQQAppInterface.getManager(53);
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.a(paramString);; paramQQAppInterface = null) {
      return a(paramContext, paramQQAppInterface);
    }
  }
  
  public static String b(QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramTroopMemberInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNamexxx uin is null");
      }
      return "";
    }
    return h(paramQQAppInterface, paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin);
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 1) {
      return o(paramQQAppInterface, paramString2, paramString1);
    }
    return m(paramQQAppInterface, paramString2, paramString1);
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = (acff)paramQQAppInterface.getManager(51);
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNameFromCache uin is null");
      }
      paramQQAppInterface = "";
      return paramQQAppInterface;
    }
    localObject = ((acff)localObject).a(paramString2);
    TroopMemberInfo localTroopMemberInfo = localTroopManager.a(paramString1, paramString2);
    if ((localTroopMemberInfo != null) && (paramBoolean) && (!TextUtils.isEmpty(localTroopMemberInfo.troopColorNick))) {
      paramQQAppInterface = localTroopMemberInfo.troopColorNick;
    }
    for (;;)
    {
      localObject = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject = paramString2;
      }
      paramQQAppInterface = (QQAppInterface)localObject;
      if (localObject == null) {
        break;
      }
      paramQQAppInterface = (QQAppInterface)localObject;
      if (!((String)localObject).equals(paramString2)) {
        break;
      }
      paramString1 = localTroopManager.b(paramString1);
      paramQQAppInterface = (QQAppInterface)localObject;
      if (paramString1 == null) {
        break;
      }
      paramQQAppInterface = (QQAppInterface)localObject;
      if (!paramString1.isQidianPrivateTroop()) {
        break;
      }
      return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
      if ((localTroopMemberInfo != null) && (!paramBoolean) && (!TextUtils.isEmpty(localTroopMemberInfo.troopnick))) {
        paramQQAppInterface = localTroopMemberInfo.troopnick;
      } else if ((localObject != null) && (((Friends)localObject).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
        paramQQAppInterface = ((Friends)localObject).remark;
      } else if ((localObject != null) && (((Friends)localObject).isFriend())) {
        paramQQAppInterface = ((Friends)localObject).name;
      } else if (localTroopMemberInfo != null)
      {
        if (paramString2.equals(paramQQAppInterface.getCurrentAccountUin())) {
          paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
        } else if (!TextUtils.isEmpty(localTroopMemberInfo.autoremark)) {
          paramQQAppInterface = localTroopMemberInfo.autoremark;
        } else {
          paramQQAppInterface = localTroopMemberInfo.friendnick;
        }
      }
      else {
        paramQQAppInterface = null;
      }
    }
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if ((paramString == null) || ("".equals(paramString))) {
      localObject = "";
    }
    String str;
    label191:
    label200:
    label209:
    label212:
    do
    {
      return localObject;
      acff localacff = (acff)paramQQAppInterface.getManager(51);
      if (localacff != null)
      {
        localObject = localacff.e(paramString);
        if (localObject != null)
        {
          if (!((Friends)localObject).isFriend()) {
            break label200;
          }
          if ((((Friends)localObject).remark == null) || ("".equals(((Friends)localObject).remark))) {
            break label191;
          }
          str = ((Friends)localObject).remark;
        }
      }
      for (;;)
      {
        localObject = str;
        if (bS(str, paramString)) {
          break;
        }
        str = s(paramQQAppInterface, paramString);
        localObject = str;
        if (bS(str, paramString)) {
          break;
        }
        if ((localacff == null) || (bS(str, paramString))) {
          break label209;
        }
        localObject = localacff.b(paramString);
        if (localObject == null) {
          break label209;
        }
        str = ((Card)localObject).strNick;
        localObject = str;
        if (!bS(str, paramString)) {
          break label212;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ContactUtils", 2, aqmr.makeLogMsg(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
        }
        return str;
        str = ((Friends)localObject).name;
        continue;
        str = ((Friends)localObject).name;
      }
      localObject = str;
      if (bS((String)localObject, paramString)) {
        break;
      }
      localObject = (acja)paramQQAppInterface.getManager(56);
      if (localObject == null) {
        break;
      }
      localObject = ((acja)localObject).c(paramString);
      if (localObject == null) {
        break;
      }
      str = ((PublicAccountInfo)localObject).name;
      if (!bS(str, paramString)) {
        break;
      }
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d("ContactUtils", 2, aqmr.makeLogMsg(new Object[] { "getBuddyName()", paramString, Boolean.valueOf(paramBoolean) }));
    return str;
    if (paramBoolean) {
      ((acda)paramQQAppInterface.getManager(54)).a().Uo(paramString);
    }
    return paramString;
  }
  
  private static String b(Friends paramFriends, String paramString)
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
    return "";
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (ctb == null) {
      ctb = paramQQAppInterface.getApp().getString(2131721540);
    }
    return (((0x40 & paramLong) >>> 6 == 1L) && ((0x20000000 & paramLong) >>> 29 == 1L)) || (paramString == null) || (paramString.matches(ctb)) || (paramString.length() == 0);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    return (a(paramQQAppInterface, paramDiscussionInfo)) || (paramDiscussionInfo.mCompareSpell == null) || (paramDiscussionInfo.mCompareSpell.length() == 0);
  }
  
  public static boolean b(PhoneContact paramPhoneContact)
  {
    return (paramPhoneContact.iTermType == 0) && (paramPhoneContact.eNetworkType == 0);
  }
  
  private static int bC(String paramString)
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
  
  public static boolean bS(String paramString1, String paramString2)
  {
    return (kt(paramString1)) && (!paramString1.equals(paramString2)) && (paramString2 != null);
  }
  
  public static int c(Friends paramFriends)
  {
    switch (aU(paramFriends.detalStatusFlag, paramFriends.iTermType))
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
  
  public static String c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = (acff)paramQQAppInterface.getManager(51);
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberName uin is null");
      }
      localObject1 = "";
      return localObject1;
    }
    Friends localFriends = ((acff)localObject1).b(paramString2);
    TroopMemberInfo localTroopMemberInfo = localTroopManager.b(paramString1, paramString2);
    if ((localTroopMemberInfo != null) && (paramBoolean) && (!TextUtils.isEmpty(localTroopMemberInfo.troopColorNick))) {
      localObject1 = localTroopMemberInfo.troopColorNick;
    }
    for (;;)
    {
      label103:
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (aprg.V(paramQQAppInterface, paramString2))
        {
          localObject2 = localObject1;
          if (localFriends != null)
          {
            localObject2 = localObject1;
            if (localFriends.isFriend())
            {
              localObject2 = localObject1;
              if (localTroopMemberInfo != null) {
                if (TextUtils.isEmpty(localTroopMemberInfo.autoremark)) {
                  break label377;
                }
              }
            }
          }
        }
      }
      label377:
      for (localObject2 = localTroopMemberInfo.autoremark;; localObject2 = localTroopMemberInfo.friendnick)
      {
        paramQQAppInterface = (QQAppInterface)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramQQAppInterface = paramString2;
        }
        localObject1 = paramQQAppInterface;
        if (paramQQAppInterface == null) {
          break;
        }
        localObject1 = paramQQAppInterface;
        if (!paramQQAppInterface.equals(paramString2)) {
          break;
        }
        paramString1 = localTroopManager.b(paramString1);
        localObject1 = paramQQAppInterface;
        if (paramString1 == null) {
          break;
        }
        localObject1 = paramQQAppInterface;
        if (!paramString1.isQidianPrivateTroop()) {
          break;
        }
        return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
        if ((localTroopMemberInfo != null) && (!paramBoolean) && (!TextUtils.isEmpty(localTroopMemberInfo.troopnick)))
        {
          localObject1 = localTroopMemberInfo.troopnick;
          break label103;
        }
        if ((localFriends != null) && (localFriends.isFriend()) && (!TextUtils.isEmpty(localFriends.remark)))
        {
          localObject1 = localFriends.remark;
          break label103;
        }
        if ((localFriends != null) && (localFriends.isFriend()))
        {
          localObject1 = localFriends.name;
          break label103;
        }
        if (localTroopMemberInfo == null) {
          break label387;
        }
        if (paramString2.equals(paramQQAppInterface.getCurrentAccountUin()))
        {
          localObject1 = paramQQAppInterface.getCurrentNickname();
          break label103;
        }
        if (!TextUtils.isEmpty(localTroopMemberInfo.autoremark))
        {
          localObject1 = localTroopMemberInfo.autoremark;
          break label103;
        }
        localObject1 = localTroopMemberInfo.friendnick;
        break label103;
      }
      label387:
      localObject1 = null;
    }
  }
  
  public static String c(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      localObject1 = "";
    }
    do
    {
      return localObject1;
      localObject1 = paramString;
    } while (paramQQAppInterface == null);
    Object localObject1 = (acff)paramQQAppInterface.getManager(51);
    if (localObject1 != null)
    {
      Object localObject2 = ((acff)localObject1).e(paramString);
      if (localObject2 != null)
      {
        localObject2 = ((Friends)localObject2).name;
        if (localObject2 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, aqmr.makeLogMsg(new Object[] { "FriendEntity getBuddyNickName()", paramString, Boolean.valueOf(paramBoolean) }));
          }
          return localObject2;
        }
      }
    }
    if (localObject1 != null) {}
    for (localObject1 = ((acff)localObject1).b(paramString);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = ((Card)localObject1).strNick;
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactUtils", 2, aqmr.makeLogMsg(new Object[] { "FriendCard getBuddyNickName()", paramString, Boolean.valueOf(paramBoolean) }));
          }
          return localObject1;
        }
      }
      if (paramBoolean) {
        ((acda)paramQQAppInterface.getManager(54)).a().Uo(paramString);
      }
      localObject1 = paramString;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ContactUtils", 2, aqmr.makeLogMsg(new Object[] { "getBuddyNickName()", paramString, Boolean.valueOf(paramBoolean) }));
      return paramString;
    }
  }
  
  @Deprecated
  public static String c(Friends paramFriends)
  {
    return paramFriends.getFriendNickWithAlias();
  }
  
  public static boolean c(Friends paramFriends)
  {
    return ((paramFriends.iTermType == 0) && (paramFriends.eNetwork == 0)) || ((aU(paramFriends.detalStatusFlag, paramFriends.iTermType) == 0) && (!TextUtils.isEmpty(paramFriends.strTermDesc)) && (paramFriends.strTermDesc.contains("TIM")));
  }
  
  public static float d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      sPaint.setTextSize(36.0F);
      return sPaint.measureText(paramString) / 36.0F;
    }
    return 1.0F;
  }
  
  public static String d(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = z(paramQQAppInterface, paramString);
    }
    do
    {
      return str;
      if (3000 == paramInt) {
        return v(paramQQAppInterface, paramString);
      }
      if (paramInt == 0) {
        break;
      }
      str = paramString;
    } while (1024 != paramInt);
    return s(paramQQAppInterface, paramString);
  }
  
  public static String d(Friends paramFriends)
  {
    Object localObject2 = null;
    int i = aU(paramFriends.detalStatusFlag, paramFriends.iTermType);
    Object localObject1 = localObject2;
    if (i == 4)
    {
      localObject1 = localObject2;
      if (!c(paramFriends)) {
        localObject1 = gg(paramFriends.getNetWorkType());
      }
    }
    String str = paramFriends.strTermDesc;
    localObject2 = str;
    if (i == 4)
    {
      localObject2 = str;
      if (aqqb.b.mE(paramFriends.customOnlineStatusType))
      {
        localObject2 = str;
        if (!TextUtils.isEmpty(paramFriends.customOnlineStatus)) {
          localObject2 = paramFriends.customOnlineStatus;
        }
      }
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
      return (String)localObject2 + (String)localObject1;
    }
    return localObject2;
  }
  
  public static String e(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject1 = (acdu)paramQQAppInterface.getManager(53);
    localObject1 = (acff)paramQQAppInterface.getManager(51);
    Object localObject2 = (acja)paramQQAppInterface.getManager(56);
    if (paramInt == 1) {
      paramQQAppInterface = z(paramQQAppInterface, paramString);
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        if (3000 == paramInt) {
          return b(paramQQAppInterface, paramQQAppInterface.getApp(), paramString);
        }
        if ((1008 != paramInt) && (1024 != paramInt)) {
          break;
        }
        if (asgx.ag(paramQQAppInterface, paramString)) {
          return asgx.H(paramQQAppInterface, paramString);
        }
        localObject1 = ((acja)localObject2).b(paramString);
        if ((localObject1 != null) && (((PublicAccountInfo)localObject1).name != null)) {
          return ((PublicAccountInfo)localObject1).name;
        }
        localObject1 = ((acja)localObject2).a(paramString);
        if ((localObject1 != null) && (((AccountDetail)localObject1).name != null)) {
          return ((AccountDetail)localObject1).name;
        }
        localObject1 = ((aced)paramQQAppInterface.getManager(69)).a(paramString);
        paramQQAppInterface = paramString;
      } while (localObject1 == null);
      paramQQAppInterface = paramString;
    } while (((EqqDetail)localObject1).name == null);
    return ((EqqDetail)localObject1).name;
    if (paramInt == 1006)
    {
      paramQQAppInterface = (ajdo)paramQQAppInterface.getManager(11);
      localObject2 = paramQQAppInterface.c(paramString);
      if (localObject2 != null) {
        return ((PhoneContact)localObject2).name;
      }
      localObject2 = paramQQAppInterface.dv(paramString);
      if (localObject2 == null) {
        break label295;
      }
      paramQQAppInterface = ((acff)localObject1).e((String)localObject2);
      if (paramQQAppInterface == null) {
        break label295;
      }
    }
    label295:
    for (localObject1 = c(paramQQAppInterface);; localObject1 = null)
    {
      paramQQAppInterface = paramString;
      if (localObject1 == null) {
        break;
      }
      paramQQAppInterface = paramString;
      if (((String)localObject1).equals(localObject2)) {
        break;
      }
      return localObject1;
      if ((paramInt == 9500) || (paramInt == 9501)) {
        return tas.a(((syw)paramQQAppInterface.getBusinessHandler(51)).a(Long.parseLong(paramString)));
      }
      return s(paramQQAppInterface, paramString);
    }
  }
  
  public static void edI()
  {
    cte = null;
  }
  
  public static String ge(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "2G在线";
    case 1: 
      return "WiFi在线";
    case 2: 
      return "2G在线";
    case 3: 
      return "3G在线";
    case 4: 
      return "4G在线";
    case 5: 
      return acfp.m(2131704484);
    case 6: 
      return acfp.m(2131704495);
    case 7: 
      return acfp.m(2131704490);
    case 8: 
      return "BMW QQ在线";
    case 9: 
      return "车载QQ在线";
    case 100: 
      return "iPhone在线";
    case 101: 
      return acfp.m(2131704492);
    case 10: 
      return "TIM在线";
    }
    return acfp.m(2131704494);
  }
  
  public static String gf(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "2G网络";
    case 1: 
      return "WIFI网络";
    case 2: 
      return "2G网络";
    case 3: 
      return "3G网络";
    case 4: 
      return "4G网络";
    case 5: 
      return acfp.m(2131704485);
    case 6: 
      return acfp.m(2131704487);
    case 7: 
      return acfp.m(2131704489);
    case 8: 
      return acfp.m(2131704488);
    case 9: 
      return acfp.m(2131704491);
    case 100: 
      return "iPhone在线";
    case 101: 
      return acfp.m(2131704486);
    }
    return "TIM在线";
  }
  
  private static String gg(int paramInt)
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
  
  public static String h(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return c(paramQQAppInterface, paramString1, paramString2, false);
  }
  
  private static String j(int paramInt, String paramString1, String paramString2)
  {
    String str;
    if (paramInt <= 0)
    {
      str = "";
      return str;
    }
    if (paramString1 != null) {}
    for (;;)
    {
      str = paramString1;
      if (TextUtils.isEmpty(paramString2)) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
      if (paramString1.length() != 0) {}
      for (str = "、";; str = "")
      {
        str = str + paramString2;
        if (bC(str) > paramInt) {
          break;
        }
        return str;
      }
      str = paramString2;
      if (paramString1.length() != 0) {
        str = "、" + paramString2;
      }
      int j = bC(paramString1);
      paramString2 = new StringBuilder();
      int i = 0;
      while (i < str.length())
      {
        int k = str.codePointAt(i);
        int m = Character.charCount(k);
        i += m;
        paramString2.appendCodePoint(k);
        if (bC(paramString2.toString()) > paramInt - j) {
          paramString2.delete(paramString2.length() - m, paramString2.length());
        }
      }
      paramString2 = paramString2.toString();
      str = paramString1;
      if (paramString2.equals("、")) {
        break;
      }
      return paramString1 + paramString2;
      paramString1 = "";
    }
  }
  
  public static int jZ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
    case 1005: 
    case 1023: 
    case 1025: 
      return 0;
    case 1008: 
    case 1024: 
      return 8;
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
    case 10002: 
    case 10004: 
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
  
  public static String k(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Friends localFriends = ((acff)paramQQAppInterface.getManager(51)).b(paramString2);
    if ((localFriends == null) || (!localFriends.isFriend()))
    {
      paramQQAppInterface = ((acdu)paramQQAppInterface.getManager(53)).a(paramString1, paramString2);
      if (paramQQAppInterface == null) {
        break label75;
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
        label75:
        paramQQAppInterface = "";
      }
    }
  }
  
  private static boolean kt(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  public static String l(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Friends localFriends = ((acff)paramQQAppInterface.getManager(51)).b(paramString2);
    if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.remark))) {
      paramString2 = localFriends.remark;
    }
    TroopMemberInfo localTroopMemberInfo;
    do
    {
      do
      {
        return paramString2;
        localTroopMemberInfo = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString1, paramString2);
        if (localTroopMemberInfo == null) {
          break label151;
        }
        if (!TextUtils.isEmpty(localTroopMemberInfo.troopnick)) {
          return localTroopMemberInfo.troopnick;
        }
        if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.name))) {
          return localFriends.name;
        }
        if (!paramString2.equals(paramQQAppInterface.getCurrentAccountUin())) {
          break;
        }
      } while (TextUtils.isEmpty(localTroopMemberInfo.friendnick));
      return localTroopMemberInfo.friendnick;
      if (!TextUtils.isEmpty(localTroopMemberInfo.autoremark)) {
        return localTroopMemberInfo.autoremark;
      }
    } while (TextUtils.isEmpty(localTroopMemberInfo.friendnick));
    return localTroopMemberInfo.friendnick;
    label151:
    ((acms)paramQQAppInterface.getBusinessHandler(20)).ac(Long.parseLong(paramString1), Long.parseLong(paramString2));
    return paramString2;
  }
  
  public static String m(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    acff localacff = (acff)paramQQAppInterface.getManager(51);
    Object localObject1 = (acdu)paramQQAppInterface.getManager(53);
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getDiscussionMemberShowName uin is null");
      }
      paramQQAppInterface = "";
      return paramQQAppInterface;
    }
    Object localObject2 = ((acdu)localObject1).a(paramString1);
    if ((localObject2 != null) && (((DiscussionInfo)localObject2).isDiscussHrMeeting())) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = localacff.b(paramString2);
      if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (!bool))
      {
        if (!TextUtils.isEmpty(((Friends)localObject2).remark)) {
          return ((Friends)localObject2).remark;
        }
        if (!TextUtils.isEmpty(((Friends)localObject2).name)) {
          return ((Friends)localObject2).name;
        }
        paramQQAppInterface = paramString2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ContactUtils", 2, "getDiscussionMemberShowName is friend but no name.");
        return paramString2;
      }
      localObject1 = ((acdu)localObject1).n(paramString1);
      if (localObject1 != null)
      {
        localObject2 = (DiscussionMemberInfo)((Map)localObject1).get(paramString2);
        if (localObject2 != null)
        {
          localObject1 = ((DiscussionMemberInfo)localObject2).inteRemark;
          localObject2 = ((DiscussionMemberInfo)localObject2).memberName;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            if (QLog.isDevelopLevel()) {
              QLog.w("ContactUtils", 1, "getDiscussionMemberShowName, discussionShowName[" + aqft.pk((String)localObject1) + "], discussionUin[" + paramString1 + "], memberUin[" + paramString2 + "], bIsDiscHrMeeting[" + bool + "]");
            }
            if (localObject1 != null)
            {
              paramString1 = (String)localObject1;
              if (((String)localObject1).trim().length() != 0) {}
            }
            else
            {
              if (!bool) {
                break label322;
              }
              paramString1 = aqjl.Ce();
            }
          }
        }
      }
      for (;;)
      {
        return paramString1;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        localObject1 = null;
        break;
        label322:
        paramString1 = localacff.e(paramString2);
        if (paramString1 != null)
        {
          paramString1 = paramString1.name;
        }
        else
        {
          ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).bC(paramString2, false);
          paramString1 = paramString2;
        }
      }
    }
  }
  
  public static boolean mH(String paramString)
  {
    return Pattern.compile("[\\u4E00-\\u9FA5]+").matcher(paramString).find();
  }
  
  public static String n(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      paramString = null;
    }
    label91:
    label94:
    for (;;)
    {
      return paramString;
      String str = paramQQAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramString);
      if (TextUtils.isEmpty(str))
      {
        paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
        if (paramQQAppInterface == null)
        {
          paramQQAppInterface = localObject;
          if (paramQQAppInterface == null) {
            break label91;
          }
        }
      }
      for (paramQQAppInterface = paramQQAppInterface.name;; paramQQAppInterface = str)
      {
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label94;
        }
        return paramQQAppInterface;
        paramQQAppInterface = paramQQAppInterface.e(paramString);
        break;
      }
    }
  }
  
  public static String n(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    paramString2 = paramQQAppInterface.jq(paramString2);
    if (paramString2 == null) {
      return paramString1;
    }
    return paramQQAppInterface.getTroopMemberName(paramString2, paramString1);
  }
  
  public static String o(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
    Object localObject = paramQQAppInterface.e(paramString);
    if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
      paramQQAppInterface = ((Friends)localObject).name;
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        localObject = paramQQAppInterface.b(paramString);
        paramQQAppInterface = paramString;
      } while (localObject == null);
      paramQQAppInterface = paramString;
    } while (TextUtils.isEmpty(((Card)localObject).strNick));
    return ((Card)localObject).strNick;
  }
  
  public static String o(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, paramString2, false);
  }
  
  public static int p(QQAppInterface paramQQAppInterface, String paramString)
  {
    acdu localacdu = (acdu)paramQQAppInterface.getManager(53);
    int i;
    if (localacdu == null)
    {
      QLog.i("ContactUtils", 1, " === dm is null or info is null ====");
      i = 0;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = localacdu.cn(paramString);
        paramQQAppInterface = jkm.a(paramQQAppInterface, paramString, 3000);
        i = j;
      } while (paramQQAppInterface == null);
      i = j;
    } while (paramQQAppInterface.size() <= 0);
    return j + paramQQAppInterface.size();
  }
  
  public static String p(QQAppInterface paramQQAppInterface, String paramString)
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
          localFriends = ((acff)paramQQAppInterface.getManager(51)).b(paramString);
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
  
  public static String p(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Friends localFriends = ((acff)paramQQAppInterface.getManager(51)).b(paramString2);
    if ((localFriends != null) && (localFriends.isFriend()) && (!TextUtils.isEmpty(localFriends.remark))) {
      return localFriends.remark;
    }
    return h(paramQQAppInterface, paramString1, paramString2);
  }
  
  public static String ps(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.trim().substring(0, 1).toUpperCase();
  }
  
  public static String pt(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() < 3);
    return paramString.substring(0, 3);
  }
  
  public static String pu(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "";
    }
    int m = paramString.length();
    int k = 0;
    int j = 0;
    char c = '\000';
    while (k < m)
    {
      int i = paramString.charAt(k);
      if (k == 0) {
        c = i;
      }
      if (k == 1) {
        j = i;
      }
      if ((i >= 19968) && (i <= 40869)) {
        return String.valueOf(i);
      }
      k += 1;
    }
    if ((c >= '!') && (c <= '~'))
    {
      if ((j >= 33) && (j <= 126)) {
        return String.valueOf(new char[] { c, j });
      }
      return String.valueOf(c);
    }
    return "?";
  }
  
  public static String q(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    Object localObject = (acff)paramQQAppInterface.getManager(51);
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberName uin is null");
      }
      localObject = "";
      return localObject;
    }
    localObject = ((acff)localObject).a(paramString2);
    TroopMemberInfo localTroopMemberInfo = localTroopManager.a(paramString1, paramString2);
    if ((localTroopMemberInfo != null) && (!TextUtils.isEmpty(localTroopMemberInfo.troopnick))) {
      paramQQAppInterface = localTroopMemberInfo.troopnick;
    }
    for (;;)
    {
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        break;
      }
      localObject = paramQQAppInterface;
      if (!paramQQAppInterface.equals(paramString2)) {
        break;
      }
      paramString1 = localTroopManager.a(paramString1);
      localObject = paramQQAppInterface;
      if (paramString1 == null) {
        break;
      }
      localObject = paramQQAppInterface;
      if (!paramString1.isQidianPrivateTroop()) {
        break;
      }
      return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
      if ((localObject != null) && (((Friends)localObject).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
        paramQQAppInterface = ((Friends)localObject).remark;
      } else if ((localObject != null) && (((Friends)localObject).isFriend())) {
        paramQQAppInterface = ((Friends)localObject).name;
      } else if (localTroopMemberInfo != null)
      {
        if (paramString2.equals(paramQQAppInterface.getCurrentAccountUin())) {
          paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
        } else if (!TextUtils.isEmpty(localTroopMemberInfo.autoremark)) {
          paramQQAppInterface = localTroopMemberInfo.autoremark;
        } else {
          paramQQAppInterface = localTroopMemberInfo.friendnick;
        }
      }
      else {
        paramQQAppInterface = null;
      }
    }
  }
  
  public static String r(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNick uin is null");
      }
      return "";
    }
    paramQQAppInterface = paramQQAppInterface.b(paramString1, paramString2);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.troopnick))) {
      return paramQQAppInterface.troopnick;
    }
    return "";
  }
  
  public static String s(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((acff)paramQQAppInterface.getManager(51)).e(paramString);
    if (paramQQAppInterface != null) {
      paramString = paramQQAppInterface.getFriendNick();
    }
    return paramString;
  }
  
  public static String s(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactUtils", 2, "getTroopMemberNick uin is null");
      }
      return "";
    }
    paramQQAppInterface = paramQQAppInterface.b(paramString1, paramString2);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.troopColorNick))) {
      return paramQQAppInterface.troopColorNick;
    }
    return "";
  }
  
  public static String t(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((acff)paramQQAppInterface.getManager(51)).e(paramString);
    if (paramQQAppInterface != null) {
      paramString = paramQQAppInterface.getFriendName();
    }
    return paramString;
  }
  
  public static String u(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((acdu)paramQQAppInterface.getManager(53)).a(paramString);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.discussionName))) {
      return paramQQAppInterface.discussionName;
    }
    return null;
  }
  
  public static String v(QQAppInterface paramQQAppInterface, String paramString)
  {
    DiscussionInfo localDiscussionInfo = ((acdu)paramQQAppInterface.getManager(53)).a(paramString);
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
  
  public static String w(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 0;
    int i = 1;
    Object localObject2 = (acdu)paramQQAppInterface.getManager(53);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ContactUtils", 2, " ===getPstnDiscussionName dm is null ====");
      }
      localObject2 = "";
      return localObject2;
    }
    Object localObject1 = ((acdu)localObject2).a(paramString);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ContactUtils", 2, " ===getPstnDiscussionName info is null ====");
      }
      i = 0;
    }
    if ((i != 0) && (((DiscussionInfo)localObject1).hasRenamed())) {
      return a(BaseApplicationImpl.getContext(), (DiscussionInfo)localObject1);
    }
    localObject2 = ((acdu)localObject2).n(paramString);
    if (i != 0) {}
    for (localObject1 = a(paramQQAppInterface, ((DiscussionInfo)localObject1).ownerUin, (Map)localObject2);; localObject1 = "")
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() >= 47) {
        break;
      }
      Object localObject3 = (ajdo)paramQQAppInterface.getManager(11);
      List localList = jkm.a(paramQQAppInterface, paramString, 3000);
      localObject2 = localObject1;
      if (localList == null) {
        break;
      }
      localObject2 = localObject1;
      if (localList.size() == 0) {
        break;
      }
      ArrayList localArrayList = new ArrayList();
      i = j;
      if (i < localList.size())
      {
        localObject2 = ((AVPhoneUserInfo)localList.get(i)).telInfo.mobile;
        paramString = ((ajdo)localObject3).b((String)localObject2);
        paramQQAppInterface = "?";
        if (paramString != null) {
          if (!TextUtils.isEmpty(paramString.name))
          {
            paramString = paramString.name;
            paramQQAppInterface = paramString;
            if (paramString.equals(localObject2)) {
              paramQQAppInterface = pt(paramString);
            }
          }
        }
        for (;;)
        {
          localArrayList.add(paramQQAppInterface);
          i += 1;
          break;
          if (!TextUtils.isEmpty(paramString.mobileNo))
          {
            paramQQAppInterface = pt(paramString.mobileNo);
            continue;
            paramQQAppInterface = pt((String)localObject2);
          }
        }
      }
      localObject3 = new acdb.c();
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (localArrayList != null)
      {
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (localArrayList.size() > 0)
        {
          paramQQAppInterface = (QQAppInterface)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.i("ContactUtils", 2, " ===getPstnDiscussionName phoneNames: " + localArrayList.toString());
            paramQQAppInterface = (QQAppInterface)localObject1;
          }
        }
      }
      do
      {
        localObject2 = paramQQAppInterface;
        if (localArrayList.size() <= 0) {
          break;
        }
        paramString = (String)Collections.min(localArrayList, (Comparator)localObject3);
        localArrayList.remove(paramString);
        paramString = j(48, paramQQAppInterface, paramString);
        paramQQAppInterface = paramString;
      } while (paramString.length() < 47);
      return paramString;
    }
  }
  
  public static void w(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals("")) || (paramString2 == null) || (paramString2.equals(""))) {
      return;
    }
    ((ajdo)paramQQAppInterface.getManager(11)).dR(paramString1, paramString2);
  }
  
  public static String x(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (ajdo)paramQQAppInterface.getManager(11);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.dv(paramString);
    }
    return "";
  }
  
  public static String y(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((ajdo)paramQQAppInterface.getManager(11)).di(paramString);
  }
  
  public static String z(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = ((HotChatManager)paramQQAppInterface.getManager(60)).a(paramString);
    if (localObject != null) {
      paramQQAppInterface = ((HotChatInfo)localObject).name + acfp.m(2131704493);
    }
    do
    {
      do
      {
        return paramQQAppInterface;
        localObject = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString);
        paramQQAppInterface = paramString;
      } while (localObject == null);
      paramQQAppInterface = paramString;
    } while (((TroopInfo)localObject).getTroopName() == null);
    return ((TroopInfo)localObject).getTroopName();
  }
  
  public static class a
  {
    public boolean cTX;
    public String name;
    
    a(String paramString, boolean paramBoolean)
    {
      this.name = paramString;
      this.cTX = paramBoolean;
    }
  }
  
  public static abstract interface b
  {
    public abstract void vt(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqgv
 * JD-Core Version:    0.7.0.1
 */