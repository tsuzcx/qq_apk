package com.pay.googlewalletsdk.util;

import org.json.JSONException;
import org.json.JSONObject;

public class Purchase
{
  String mDeveloperPayload;
  String mItemType;
  String mOrderId;
  String mOriginalJson;
  String mPackageName;
  int mPurchaseState;
  long mPurchaseTime;
  String mSignature;
  String mSku;
  String mToken;
  
  public Purchase(String paramString1, String paramString2, String paramString3)
    throws JSONException
  {
    this.mItemType = paramString1;
    this.mOriginalJson = paramString2;
    paramString1 = new JSONObject(this.mOriginalJson);
    this.mOrderId = paramString1.optString("orderId");
    this.mPackageName = paramString1.optString("packageName");
    this.mSku = paramString1.optString("productId");
    this.mPurchaseTime = paramString1.optLong("purchaseTime");
    this.mPurchaseState = paramString1.optInt("purchaseState");
    this.mDeveloperPayload = paramString1.optString("developerPayload");
    this.mToken = paramString1.optString("token", paramString1.optString("purchaseToken"));
    this.mSignature = paramString3;
  }
  
  public String getDeveloperPayload()
  {
    return this.mDeveloperPayload;
  }
  
  public String getItemType()
  {
    return this.mItemType;
  }
  
  public String getOrderId()
  {
    return this.mOrderId;
  }
  
  public String getOriginalJson()
  {
    return this.mOriginalJson;
  }
  
  public String getPackageName()
  {
    return this.mPackageName;
  }
  
  public int getPurchaseState()
  {
    return this.mPurchaseState;
  }
  
  public long getPurchaseTime()
  {
    return this.mPurchaseTime;
  }
  
  public String getSignature()
  {
    return this.mSignature;
  }
  
  public String getSku()
  {
    return this.mSku;
  }
  
  public String getToken()
  {
    return this.mToken;
  }
  
  public String toString()
  {
    return "PurchaseInfo(type:" + this.mItemType + "):" + this.mOriginalJson;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.util.Purchase
 * JD-Core Version:    0.7.0.1
 */