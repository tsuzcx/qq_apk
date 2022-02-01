package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.database.StoryEntry;
import com.tencent.mobileqq.persistence.EntityManager;
import psu;

public class StoryManager$2
  implements Runnable
{
  public StoryManager$2(psu parampsu, EntityManager paramEntityManager, StoryEntry paramStoryEntry, String paramString, int paramInt) {}
  
  public void run()
  {
    this.val$entityManager.remove(this.a, StoryEntry.getUidSelectionNoArg(), new String[] { String.valueOf(this.wb), String.valueOf(this.bke) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryManager.2
 * JD-Core Version:    0.7.0.1
 */