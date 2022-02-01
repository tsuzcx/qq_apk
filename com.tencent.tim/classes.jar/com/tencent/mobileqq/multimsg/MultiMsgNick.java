package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="uin,uniseq")
public class MultiMsgNick
  extends Entity
{
  public String nick;
  public String uin;
  public long uniseq;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgNick
 * JD-Core Version:    0.7.0.1
 */