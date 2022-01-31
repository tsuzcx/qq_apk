package com.pay.googlewaletsdk.entity;

import com.pay.googlewalletsdk.util.Purchase;

public class RequestInfo
  extends DownloadInfo
{
  public String amt;
  public String appid;
  public String billno;
  public changkeyType changeKey;
  public String currencyType;
  public String from;
  public boolean isChangeKey;
  public boolean isDepostGameCoin;
  public keytype keyType;
  public String openid;
  public String openkey;
  public String payItem;
  public String pf;
  public String pfkey;
  public String productID;
  public productType productType;
  public Purchase purchase;
  public int quantity;
  public String session_id;
  public String session_type;
  public String varItem;
  public String zoneid;
  
  public static enum changkeyType
  {
    Nonmal,  Resort;
  }
  
  public static enum keytype
  {
    BaseKey,  Secretkey;
  }
  
  public static enum productType
  {
    Consumable,  Non_Consumable,  Subscription;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewaletsdk.entity.RequestInfo
 * JD-Core Version:    0.7.0.1
 */