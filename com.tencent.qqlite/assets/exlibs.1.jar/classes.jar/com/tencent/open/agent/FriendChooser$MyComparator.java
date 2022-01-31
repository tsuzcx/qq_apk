package com.tencent.open.agent;

import com.tencent.open.agent.datamodel.Friend;
import java.util.Comparator;

public class FriendChooser$MyComparator
  implements Comparator
{
  protected FriendChooser$MyComparator(FriendChooser paramFriendChooser) {}
  
  public int a(Friend paramFriend1, Friend paramFriend2)
  {
    return paramFriend1.f.compareToIgnoreCase(paramFriend2.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser.MyComparator
 * JD-Core Version:    0.7.0.1
 */