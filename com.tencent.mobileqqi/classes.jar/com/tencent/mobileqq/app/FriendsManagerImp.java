package com.tencent.mobileqq.app;

import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.widget.TraceUtils;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FriendsManagerImp
  implements FriendManager
{
  private QvipSpecialCareManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager;
  private DiscussionManager jdField_a_of_type_ComTencentMobileqqAppDiscussionManager;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopManager a;
  
  public FriendsManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(46));
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)paramQQAppInterface.getManager(48));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(47));
  }
  
  private void k(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = new QvipSpecialCareManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.b(paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.b(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.c(paramString);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a();
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
  }
  
  public Card a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
  }
  
  public ContactCard a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
  }
  
  public DiscussionInfo a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(paramString);
  }
  
  public DiscussionMemberInfo a(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(paramString1, paramString2);
  }
  
  public DiscussionMemberInfo a(byte[] paramArrayOfByte, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      paramString1 = null;
    }
    do
    {
      do
      {
        return paramString1;
        paramString2 = a(paramString1, paramString2);
        paramString1 = paramString2;
      } while (paramString2 == null);
      paramArrayOfByte = new String(paramArrayOfByte);
      if (paramString2.inteRemark == null) {
        break;
      }
      paramString1 = paramString2;
    } while (paramString2.inteRemark.equals(paramArrayOfByte));
    paramString2.inteRemark = paramArrayOfByte;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.equals(paramString2.memberName))) {}
    for (paramString2.inteRemarkSource = 129L;; paramString2.inteRemarkSource = 128L)
    {
      paramString1 = paramString2;
      if (!paramBoolean) {
        break;
      }
      a(paramString2);
      return paramString2;
    }
  }
  
  public ExtensionInfo a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
  }
  
  public Friends a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
  }
  
  public Friends a(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString1, paramString2);
  }
  
  public Friends a(String paramString1, String paramString2, byte paramByte)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramString1, paramString2);
  }
  
  public Friends a(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString, paramArrayOfByte, paramLong);
  }
  
  public Groups a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
  }
  
  public OpenTroopInfo a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString);
  }
  
  public TroopInfo a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString);
  }
  
  protected TroopInfo a(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString1, paramString2);
  }
  
  public EntityTransaction a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a();
  }
  
  public String a(TroopMemberInfo paramTroopMemberInfo)
  {
    return ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopMemberInfo);
  }
  
  public String a(String paramString)
  {
    return ContactUtils.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  public String a(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString1, paramString2);
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a();
  }
  
  public ArrayList a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramInt);
  }
  
  public ArrayList a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(paramString);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a();
  }
  
  public List a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a();
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramInt);
  }
  
  public void a(long paramLong)
  {
    if (!Friends.isValidUin(paramLong)) {}
    String str;
    do
    {
      return;
      str = String.valueOf(paramLong);
    } while ((a(str) != 20) && (a(str) > 0));
    b(str, 10);
  }
  
  public void a(long paramLong, byte paramByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramLong, paramByte);
  }
  
  public void a(Card paramCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramCard);
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(paramDiscussionInfo);
  }
  
  public void a(DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(paramDiscussionMemberInfo);
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramExtensionInfo);
  }
  
  public void a(Friends paramFriends)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramFriends);
    ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    RecentUser localRecentUser = localProxyManager.a().a(paramFriends.uin, 0);
    if (localRecentUser.getStatus() == 1001) {
      if (paramFriends.remark == null) {
        break label65;
      }
    }
    label65:
    for (paramFriends = paramFriends.remark;; paramFriends = paramFriends.name)
    {
      localRecentUser.displayName = paramFriends;
      localProxyManager.a().a(localRecentUser);
      return;
    }
  }
  
  public void a(Groups paramGroups)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramGroups);
  }
  
  public void a(OpenTroopInfo paramOpenTroopInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramOpenTroopInfo, paramBoolean);
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramTroopInfo);
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
  }
  
  protected void a(String paramString, byte paramByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString, paramByte);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString, paramInt);
  }
  
  void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString, paramGetOnlineInfoResp);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString1, paramString2);
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(paramString, paramArrayList);
  }
  
  public void a(String paramString, Set paramSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(paramString, paramSet);
  }
  
  public void a(String paramString1, short paramShort, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString1, paramShort, paramString2, paramString3);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString, paramBoolean);
  }
  
  protected void a(String paramString, byte[] paramArrayOfByte, short paramShort)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString, paramArrayOfByte, paramShort);
  }
  
  void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramArrayList);
  }
  
  void a(ArrayList paramArrayList, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramArrayList, paramLong);
  }
  
  public void a(List paramList)
  {
    TraceUtils.a("preloadFriends");
    TraceUtils.a("splitRecents");
    ArrayList localArrayList1 = new ArrayList(4);
    ArrayList localArrayList2 = new ArrayList(4);
    ArrayList localArrayList3 = new ArrayList(4);
    localArrayList1.add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      switch (localRecentUser.type)
      {
      default: 
        break;
      case 0: 
        localArrayList1.add(localRecentUser.uin);
        break;
      case 1: 
        localArrayList2.add(localRecentUser.uin);
        break;
      case 3000: 
        localArrayList3.add(localRecentUser.uin);
      }
    }
    TraceUtils.a();
    TraceUtils.a("queryFriends_" + localArrayList1.size());
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localArrayList1);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(localArrayList3);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(localArrayList2);
    TraceUtils.a();
    TraceUtils.a();
  }
  
  public void a(Map paramMap)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramMap);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramArrayOfByte);
  }
  
  void a(Friends[] paramArrayOfFriends, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramArrayOfFriends, paramLong, paramBoolean);
  }
  
  void a(Groups[] paramArrayOfGroups)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramArrayOfGroups);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a();
  }
  
  public boolean a(Friends paramFriends)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramFriends);
  }
  
  public boolean a(Entity paramEntity)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramEntity);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString, paramInt);
  }
  
  public boolean a(String paramString, long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString, paramLong);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString1, paramString2);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramByte, paramLong2);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2);
  }
  
  boolean a(ArrayList paramArrayList, long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(paramArrayList, paramLong);
  }
  
  public boolean a(List paramList)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramList);
  }
  
  public boolean a(Friends[] paramArrayOfFriends, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramArrayOfFriends, paramInt);
  }
  
  public int b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramString);
  }
  
  Card b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramString);
  }
  
  public Friends b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramString);
  }
  
  public String b(String paramString)
  {
    return ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  public String b(String paramString1, String paramString2)
  {
    return ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
  }
  
  public ArrayList b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b();
  }
  
  public List b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b();
  }
  
  public List b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b();
  }
  
  public void b(TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramTroopInfo);
  }
  
  protected void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramString);
  }
  
  void b(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramString, paramInt);
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.b(paramString1, paramString2);
  }
  
  void b(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramArrayList);
  }
  
  void b(ArrayList paramArrayList, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramArrayList, paramLong);
  }
  
  void b(List paramList) {}
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c();
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramString);
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString1, paramString2);
  }
  
  public int c(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(paramString);
  }
  
  public Friends c(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(paramString);
  }
  
  public String c(String paramString)
  {
    return ContactUtils.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  public String c(String paramString1, String paramString2)
  {
    return ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
  }
  
  public ArrayList c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b();
  }
  
  void c(TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramTroopInfo);
  }
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(paramString);
  }
  
  public void c(String paramString, int paramInt) {}
  
  public void c(List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.b(paramList);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a();
  }
  
  public boolean c(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(paramString);
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(paramString1, paramString2);
  }
  
  public String d(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramString);
  }
  
  public String d(String paramString1, String paramString2)
  {
    return ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
  }
  
  public ArrayList d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a();
  }
  
  void d() {}
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d(paramString);
    k(paramString);
  }
  
  public void d(List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramList);
  }
  
  public boolean d(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(paramString);
  }
  
  public String e(String paramString)
  {
    return ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c();
  }
  
  public void e(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString);
  }
  
  public boolean e(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d(paramString);
  }
  
  public String f(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(paramString);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d();
  }
  
  public void f(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(paramString);
  }
  
  public boolean f(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString);
  }
  
  public String g(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString);
  }
  
  public void g(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString);
  }
  
  public boolean g(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e(paramString);
  }
  
  public String h(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramString);
  }
  
  public void h(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramString);
  }
  
  public boolean h(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(paramString);
  }
  
  public void i(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(paramString);
  }
  
  public boolean i(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramString);
  }
  
  public void j(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.e(paramString);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendsManagerImp
 * JD-Core Version:    0.7.0.1
 */