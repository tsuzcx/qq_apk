package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.ArrayList;
import java.util.List;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="shid,bid,source_id")
public class CouponShop
  extends Entity
{
  public String addr;
  public String area;
  public int bid;
  @notColumn
  private List cidList;
  public String city;
  public String cname;
  public String contact;
  public String couponids;
  public String detail;
  public int maplat;
  public int maplng;
  public long mt;
  public String name;
  public String qlife_url;
  public String region;
  public int shid;
  public int source_id;
  public String tag;
  public String tel;
  
  public CouponShop() {}
  
  public CouponShop(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt3, int paramInt4, long paramLong, List paramList, String paramString10, String paramString11, int paramInt5)
  {
    this.shid = paramInt1;
    this.bid = paramInt2;
    this.name = paramString1;
    this.addr = paramString2;
    this.detail = paramString3;
    this.city = paramString4;
    this.region = paramString5;
    this.area = paramString6;
    this.tag = paramString7;
    this.contact = paramString8;
    this.tel = paramString9;
    this.maplng = paramInt3;
    this.maplat = paramInt4;
    this.mt = paramLong;
    this.cidList = paramList;
    this.couponids = TextUtils.join(",", paramList);
    this.cname = paramString10;
    this.qlife_url = paramString11;
    this.source_id = paramInt5;
  }
  
  public List getCouponList()
  {
    if (this.cidList == null)
    {
      this.cidList = new ArrayList();
      if (!TextUtils.isEmpty(this.couponids))
      {
        String[] arrayOfString = this.couponids.split("\\,");
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          this.cidList.add(Integer.valueOf(Integer.parseInt(str)));
          i += 1;
        }
      }
    }
    return this.cidList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.CouponShop
 * JD-Core Version:    0.7.0.1
 */