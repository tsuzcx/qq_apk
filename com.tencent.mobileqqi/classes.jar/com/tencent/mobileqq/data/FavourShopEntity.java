package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class FavourShopEntity
  extends Entity
{
  @unique
  public int bid;
  public String logo;
  public int mt;
  public String name;
  public String qlife_url;
  public int readTime;
  public int source_id;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.FavourShopEntity
 * JD-Core Version:    0.7.0.1
 */