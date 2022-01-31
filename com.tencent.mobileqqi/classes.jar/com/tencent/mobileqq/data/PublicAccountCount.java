package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class PublicAccountCount
  extends Entity
{
  public int count;
  @unique
  public String uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.PublicAccountCount
 * JD-Core Version:    0.7.0.1
 */