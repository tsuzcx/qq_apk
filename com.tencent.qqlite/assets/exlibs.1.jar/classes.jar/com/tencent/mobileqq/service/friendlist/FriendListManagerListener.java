package com.tencent.mobileqq.service.friendlist;

import com.tencent.mobileqq.service.friendlist.remote.FriendGroupListInfo;
import com.tencent.mobileqq.service.friendlist.remote.FriendListInfo;

public abstract interface FriendListManagerListener
{
  public abstract void a(String paramString, FriendListInfo paramFriendListInfo, FriendGroupListInfo paramFriendGroupListInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.friendlist.FriendListManagerListener
 * JD-Core Version:    0.7.0.1
 */