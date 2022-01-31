package com.tencent.mobileqq.app.proxy;

import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.ReSortGroupResp;
import friendlist.RenameGroupResp;

public class GroupActionResp
{
  public static final int a = 0;
  public static final int b = 16;
  public static final int c = 17;
  public static final int d = 21;
  public static final int e = 64;
  public static final int f = 66;
  public static final int g = 19;
  public static final int h = 20;
  public static final int i = 80;
  public static final int j = 18;
  public static final int k = 23;
  public static final int l = 24;
  public static final int m = 33;
  public static final int n = 65;
  public GroupActionResp.GroupActionType a;
  public AddGroupResp a;
  public DelGroupResp a;
  public ReSortGroupResp a;
  public RenameGroupResp a;
  public String a;
  public int o;
  
  public GroupActionResp(int paramInt, String paramString, AddGroupResp paramAddGroupResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyGroupActionResp$GroupActionType = GroupActionResp.GroupActionType.EAddGroup;
    this.o = paramInt;
    this.jdField_a_of_type_FriendlistAddGroupResp = paramAddGroupResp;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public GroupActionResp(int paramInt, String paramString, DelGroupResp paramDelGroupResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyGroupActionResp$GroupActionType = GroupActionResp.GroupActionType.EDeleteGroup;
    this.o = paramInt;
    this.jdField_a_of_type_FriendlistDelGroupResp = paramDelGroupResp;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public GroupActionResp(int paramInt, String paramString, ReSortGroupResp paramReSortGroupResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyGroupActionResp$GroupActionType = GroupActionResp.GroupActionType.EResortGroup;
    this.o = paramInt;
    this.jdField_a_of_type_FriendlistReSortGroupResp = paramReSortGroupResp;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public GroupActionResp(int paramInt, String paramString, RenameGroupResp paramRenameGroupResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyGroupActionResp$GroupActionType = GroupActionResp.GroupActionType.ERenameGroup;
    this.o = paramInt;
    this.jdField_a_of_type_FriendlistRenameGroupResp = paramRenameGroupResp;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.GroupActionResp
 * JD-Core Version:    0.7.0.1
 */