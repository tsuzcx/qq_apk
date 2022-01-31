package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="troopuin,memberuin")
public class TroopMemberInfo
  extends Entity
{
  public long active_point;
  public byte age;
  public String alias;
  public String autoremark;
  public long credit_level;
  public long datetime;
  @notColumn
  public String displayedNamePinyinFirst;
  public int distance = 0;
  public short faceid;
  public String friendnick;
  public long gagTimeStamp;
  public boolean isTroopFollowed;
  public long join_time;
  public long last_active_time;
  public int level;
  public String memberuin;
  public long msgseq = -100L;
  public String pyAll_autoremark;
  public String pyAll_friendnick;
  public String pyAll_troopnick;
  public String pyFirst_autoremark;
  public String pyFirst_friendnick;
  public String pyFirst_troopnick;
  public int qqVipInfo = 0;
  public byte sex;
  public byte status;
  public int superQqInfo = 0;
  public int superVipInfo = 0;
  public String troopnick;
  public String troopremark;
  public String troopuin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopMemberInfo
 * JD-Core Version:    0.7.0.1
 */