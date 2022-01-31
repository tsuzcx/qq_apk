package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.List;

public class CircleGroup
  extends Entity
{
  public int buddyCount;
  @notColumn
  public List buddyList;
  @unique
  public int groupId;
  public String groupName;
  public int showIndex;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.CircleGroup
 * JD-Core Version:    0.7.0.1
 */