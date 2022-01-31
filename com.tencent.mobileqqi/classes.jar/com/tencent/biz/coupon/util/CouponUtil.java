package com.tencent.biz.coupon.util;

public class CouponUtil
{
  public static String a(int paramInt)
  {
    int i = 1;
    if (paramInt < 1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramInt << 2);
    localStringBuilder.append("?");
    while (i < paramInt)
    {
      localStringBuilder.append(",?");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.coupon.util.CouponUtil
 * JD-Core Version:    0.7.0.1
 */