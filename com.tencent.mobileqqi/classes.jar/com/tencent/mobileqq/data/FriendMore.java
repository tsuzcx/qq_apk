package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.PrimaryKeyJoinColumn;
import com.tencent.mobileqq.persistence.unique;

@PrimaryKeyJoinColumn(a="uin")
public class FriendMore
  extends Entity
{
  public String signature;
  @unique
  public String uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.FriendMore
 * JD-Core Version:    0.7.0.1
 */