package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;

public class CouponBusiness
  extends Entity
{
  public static final int BUSINESS_TYPE_ENTERTAINMENT = 2;
  public static final int BUSINESS_TYPE_FOOD = 1;
  public static final int BUSINESS_TYPE_SERVICE = 3;
  public long add2favour_time;
  public int bid;
  @notColumn
  public CouponBusiness.BusinessInfo businessInfo;
  public String city;
  public String cname;
  public String contact;
  public String detail;
  @unique
  public long key;
  public String logo;
  public long mt;
  public String name;
  public String qlife_url;
  public int source_id;
  public String tag;
  public String tel;
  public int type;
  public int update_count;
  
  public CouponBusiness() {}
  
  public CouponBusiness(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong1, String paramString8, int paramInt3, String paramString9, int paramInt4, long paramLong2)
  {
    this.key = ((paramInt1 << 32) + paramInt4);
    this.bid = paramInt1;
    this.name = paramString1;
    this.detail = paramString2;
    this.type = paramInt2;
    this.city = paramString3;
    this.tag = paramString4;
    this.contact = paramString5;
    this.tel = paramString6;
    this.logo = paramString7;
    this.mt = paramLong1;
    this.cname = paramString8;
    this.update_count = paramInt3;
    this.qlife_url = paramString9;
    this.source_id = paramInt4;
    this.add2favour_time = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.CouponBusiness
 * JD-Core Version:    0.7.0.1
 */