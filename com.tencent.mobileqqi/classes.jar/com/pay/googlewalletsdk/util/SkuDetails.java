package com.pay.googlewalletsdk.util;

import org.json.JSONException;
import org.json.JSONObject;

public class SkuDetails
{
  String mDescription;
  public String mItemType;
  String mJson;
  String mPrice;
  String mSku;
  String mTitle;
  String mType;
  
  public SkuDetails(String paramString)
    throws JSONException
  {
    this("inapp", paramString);
  }
  
  public SkuDetails(String paramString1, String paramString2)
    throws JSONException
  {
    this.mItemType = paramString1;
    this.mJson = paramString2;
    paramString1 = new JSONObject(this.mJson);
    this.mSku = paramString1.optString("productId");
    this.mType = paramString1.optString("type");
    this.mPrice = paramString1.optString("price");
    this.mTitle = paramString1.optString("title");
    this.mDescription = paramString1.optString("description");
  }
  
  public String getDescription()
  {
    return this.mDescription;
  }
  
  public String getPrice()
  {
    return this.mPrice;
  }
  
  public String getSku()
  {
    return this.mSku;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public String getType()
  {
    return this.mType;
  }
  
  public String toString()
  {
    return "SkuDetails:" + this.mJson;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.util.SkuDetails
 * JD-Core Version:    0.7.0.1
 */