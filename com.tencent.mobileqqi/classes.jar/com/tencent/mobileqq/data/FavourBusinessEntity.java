package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class FavourBusinessEntity
  extends Entity
{
  public long add2favour_time;
  @unique
  public int bid;
  public String logo;
  public String name;
  public String qlife_url;
  public long readTime;
  public int source_id;
  public long updateTime;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.FavourBusinessEntity
 * JD-Core Version:    0.7.0.1
 */