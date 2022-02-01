package com.tencent.tim.teamwork;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="pad_url,type_list")
public class SharedPadInfo
  extends PadInfo
{
  public SharedPadInfo()
  {
    this.type_list = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.SharedPadInfo
 * JD-Core Version:    0.7.0.1
 */