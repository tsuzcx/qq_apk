package com.tencent.mobileqq.managers;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class DiscussionMemberManager$1
  extends LinkedHashMap
{
  DiscussionMemberManager$1(DiscussionMemberManager paramDiscussionMemberManager, int paramInt, float paramFloat, boolean paramBoolean)
  {
    super(paramInt, paramFloat, paramBoolean);
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.managers.DiscussionMemberManager.1
 * JD-Core Version:    0.7.0.1
 */