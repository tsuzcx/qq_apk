package com.tencent.mobileqq.data;

public class PrecoverResourceBusiness
  extends PrecoverResource
{
  public PrecoverResourceBusiness() {}
  
  public PrecoverResourceBusiness(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramString1, paramString2, paramString3, paramString4);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PrecoverResourceBusiness:pk=").append(this.pk);
    localStringBuilder.append(",businessId=").append(this.businessId);
    localStringBuilder.append(",resId=").append(this.resId);
    localStringBuilder.append(",url=").append(this.url);
    localStringBuilder.append(",md5=").append(this.md5);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PrecoverResourceBusiness
 * JD-Core Version:    0.7.0.1
 */