package com.tencent.mobileqq.service.friendlist;

import com.tencent.mobileqq.service.friendlist.remote.FriendGroupListInfo;
import com.tencent.mobileqq.service.friendlist.remote.FriendListInfo;
import com.tencent.mobileqq.service.friendlist.remote.FriendSingleInfo;
import java.util.HashMap;
import java.util.List;

public class FriendListManager
{
  private static FriendListManager jdField_a_of_type_ComTencentMobileqqServiceFriendlistFriendListManager;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap b = new HashMap();
  
  public static FriendListManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqServiceFriendlistFriendListManager == null) {
      jdField_a_of_type_ComTencentMobileqqServiceFriendlistFriendListManager = new FriendListManager();
    }
    return jdField_a_of_type_ComTencentMobileqqServiceFriendlistFriendListManager;
  }
  
  public FriendGroupListInfo a(String paramString)
  {
    return (FriendGroupListInfo)this.b.get(paramString);
  }
  
  public FriendListInfo a(String paramString)
  {
    return (FriendListInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public FriendSingleInfo a(String paramString1, String paramString2)
  {
    FriendListInfo localFriendListInfo = (FriendListInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    if (localFriendListInfo == null)
    {
      paramString1 = null;
      return paramString1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= localFriendListInfo.a.size()) {
        break label76;
      }
      FriendSingleInfo localFriendSingleInfo = (FriendSingleInfo)localFriendListInfo.a.get(i);
      paramString1 = localFriendSingleInfo;
      if (localFriendSingleInfo.b.equals(paramString2)) {
        break;
      }
      i += 1;
    }
    label76:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.friendlist.FriendListManager
 * JD-Core Version:    0.7.0.1
 */