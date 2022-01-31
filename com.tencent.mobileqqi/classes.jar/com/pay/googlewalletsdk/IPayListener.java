package com.pay.googlewalletsdk;

import com.pay.googlewaletsdk.entity.RequestInfo;

public abstract interface IPayListener
{
  public abstract void onDeliverFinishFailuer(RequestInfo paramRequestInfo, String paramString, int paramInt);
  
  public abstract void onDeliverFinishSucess(RequestInfo paramRequestInfo);
  
  public abstract void onLoginExpiry(RequestInfo paramRequestInfo);
  
  public abstract void onNetWorkEorror(RequestInfo paramRequestInfo, int paramInt);
  
  public abstract void onOrderFinishFailuer(RequestInfo paramRequestInfo, String paramString, int paramInt);
  
  public abstract void onOrderFinishSucess(RequestInfo paramRequestInfo);
  
  public abstract void onPurchaseFinishFailuer(RequestInfo paramRequestInfo, String paramString, int paramInt);
  
  public abstract void onPurchaseFinishSucess(RequestInfo paramRequestInfo);
  
  public abstract void onQueryProductInfoFailure(RequestInfo paramRequestInfo);
  
  public abstract void onRestoreFinishFailue(String paramString, int paramInt);
  
  public abstract void onSetUpFinishFailure(RequestInfo paramRequestInfo, String paramString, int paramInt);
  
  public abstract void onSetUpFinishSucess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.IPayListener
 * JD-Core Version:    0.7.0.1
 */