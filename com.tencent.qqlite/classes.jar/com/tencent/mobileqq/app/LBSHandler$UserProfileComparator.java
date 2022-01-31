package com.tencent.mobileqq.app;

import QQService.UserProfile;
import java.util.Comparator;

public class LBSHandler$UserProfileComparator
  implements Comparator
{
  public int a(UserProfile paramUserProfile1, UserProfile paramUserProfile2)
  {
    return paramUserProfile2.lTime - paramUserProfile1.lTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.LBSHandler.UserProfileComparator
 * JD-Core Version:    0.7.0.1
 */