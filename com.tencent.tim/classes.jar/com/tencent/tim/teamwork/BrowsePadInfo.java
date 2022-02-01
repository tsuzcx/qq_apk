package com.tencent.tim.teamwork;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="pad_url,type_list")
public class BrowsePadInfo
  extends PadInfo
{
  public BrowsePadInfo()
  {
    this.type_list = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.BrowsePadInfo
 * JD-Core Version:    0.7.0.1
 */