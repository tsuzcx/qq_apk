package com.pay.googlewalletsdk;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.pay.googlewaletsdk.entity.RequestInfo;
import com.pay.googlewaletsdk.entity.RequestInfo.changkeyType;
import com.pay.googlewaletsdk.entity.RequestInfo.keytype;
import com.pay.googlewaletsdk.entity.RequestInfo.productType;
import com.pay.googlewaletsdk.tool.PayUtil;
import com.pay.googlewalletsdk.config.BaseConfig;
import com.pay.googlewalletsdk.http.BaseHttpResolve;
import com.pay.googlewalletsdk.http.HttpClientHandle;
import com.pay.googlewalletsdk.http.HttpRequestHelper;
import com.pay.googlewalletsdk.http.IHttpResolveObserver;
import com.pay.googlewalletsdk.module.changekey.HttpChangeKeyResovle;
import com.pay.googlewalletsdk.module.order.HttpOrderResovle;
import com.pay.googlewalletsdk.util.IabException;
import com.pay.googlewalletsdk.util.IabHelper;
import com.pay.googlewalletsdk.util.IabHelper.OnConsumeFinishedListener;
import com.pay.googlewalletsdk.util.IabHelper.OnIabPurchaseFinishedListener;
import com.pay.googlewalletsdk.util.IabHelper.OnIabSetupFinishedListener;
import com.pay.googlewalletsdk.util.IabHelper.QueryInventoryFinishedListener;
import com.pay.googlewalletsdk.util.IabResult;
import com.pay.googlewalletsdk.util.Inventory;
import com.pay.googlewalletsdk.util.Purchase;
import com.pay.googlewalletsdk.util.SkuDetails;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GoogleWalletPayHelper
  implements IabHelper.OnIabSetupFinishedListener, IabHelper.OnIabPurchaseFinishedListener, IabHelper.QueryInventoryFinishedListener, IabHelper.OnConsumeFinishedListener, IHttpResolveObserver
{
  private static Object lock = new Object();
  private static GoogleWalletPayHelper payHelper;
  private Activity activity;
  boolean isConfirm;
  boolean isrestore;
  private IabHelper mHelper;
  private RequestInfo payInfo;
  private IPayListener payListener;
  private String restorProductid;
  
  private RequestInfo creatRequestInfo()
  {
    return new RequestInfo();
  }
  
  public static GoogleWalletPayHelper getInstance()
  {
    if (payHelper == null) {}
    synchronized (lock)
    {
      if (payHelper == null) {
        payHelper = new GoogleWalletPayHelper();
      }
      return payHelper;
    }
  }
  
  private void queryProduct(String paramString, ArrayList<String> paramArrayList)
    throws IabException
  {
    paramString = this.mHelper.queryInventory(true, paramArrayList);
    if (paramString != null)
    {
      System.out.println("inventory is not null");
      if (paramString.mSkuMap.size() > 0)
      {
        paramArrayList = paramString.mSkuMap.keySet().iterator();
        if (paramArrayList.hasNext()) {}
      }
    }
    while (this.payListener == null)
    {
      do
      {
        Object localObject;
        do
        {
          return;
          localObject = (String)paramArrayList.next();
          localObject = (SkuDetails)paramString.mSkuMap.get(localObject);
        } while (!((SkuDetails)localObject).getSku().equals(this.payInfo.productID));
        paramString = PayUtil.cutCoinType(((SkuDetails)localObject).getPrice());
        this.payInfo.currencyType = paramString[0];
        this.payInfo.amt = paramString[1];
        if (BaseConfig.appKey.equals(""))
        {
          this.payInfo.setKey("changekey");
          this.payInfo.isChangeKey = false;
          paramString = this.activity.getSharedPreferences("key", 0).getString("secretkey", "");
          BaseConfig.sercretKey = paramString;
          if (paramString.equals("")) {
            this.payInfo.keyType = RequestInfo.keytype.BaseKey;
          }
        }
        for (;;)
        {
          HttpRequestHelper.getIntanceHttpRequestHelper().startRequestInfo(this.payInfo);
          return;
          this.payInfo.keyType = RequestInfo.keytype.Secretkey;
          continue;
          System.out.println("Google wallet order");
          this.payInfo.setKey("order");
        }
      } while (this.payListener == null);
      this.payListener.onQueryProductInfoFailure(this.payInfo);
      return;
    }
    this.payListener.onQueryProductInfoFailure(this.payInfo);
  }
  
  public void dispose()
  {
    HttpClientHandle.getIntanceHandel().unregister(this);
    HttpRequestHelper.getIntanceHttpRequestHelper().dispose();
    this.mHelper.dispose();
    this.mHelper = null;
    payHelper = null;
    this.payListener = null;
    this.activity = null;
  }
  
  public boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    System.out.println("google wallet payHelper handleActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    return this.mHelper.handleActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void init(Activity paramActivity, String paramString, IPayListener paramIPayListener)
  {
    if (this.mHelper == null) {
      this.mHelper = new IabHelper(paramActivity, paramString);
    }
    HttpClientHandle.getIntanceHandel().register(this);
    if (this.mHelper != null) {
      this.mHelper.startSetup(this);
    }
    this.payListener = paramIPayListener;
    this.activity = paramActivity;
    this.isrestore = false;
    this.isConfirm = false;
  }
  
  public void onConsumeFinished(Purchase paramPurchase, IabResult paramIabResult)
  {
    this.isConfirm = false;
    System.out.println("purchase=" + paramPurchase + "  result=" + paramIabResult.isSuccess() + " code=" + paramIabResult.getResponse());
  }
  
  public void onDownLoading(byte[] paramArrayOfByte, int paramInt, long paramLong, BaseHttpResolve paramBaseHttpResolve) {}
  
  public void onError(BaseHttpResolve paramBaseHttpResolve)
  {
    paramBaseHttpResolve = (RequestInfo)paramBaseHttpResolve.getDownloadInfo();
    String str = paramBaseHttpResolve.getKey();
    System.out.println("Google wallet payHelper onError cmdKey:" + str);
    if ((str.equals("changekey")) && (this.payListener != null))
    {
      if (paramBaseHttpResolve.changeKey != RequestInfo.changkeyType.Resort) {
        break label157;
      }
      this.payListener.onNetWorkEorror(paramBaseHttpResolve, 3);
    }
    for (;;)
    {
      if ((str.equals("order")) && (this.payListener != null)) {
        this.payListener.onNetWorkEorror(paramBaseHttpResolve, 1);
      }
      if ((str.equals("provide")) && (this.payListener != null)) {
        this.payListener.onNetWorkEorror(paramBaseHttpResolve, 3);
      }
      if ((str.equals("restorprovide")) && (this.payListener != null)) {
        this.payListener.onNetWorkEorror(paramBaseHttpResolve, 4);
      }
      return;
      label157:
      this.payListener.onNetWorkEorror(paramBaseHttpResolve, 1);
    }
  }
  
  public void onFinish(BaseHttpResolve paramBaseHttpResolve)
  {
    RequestInfo localRequestInfo = (RequestInfo)paramBaseHttpResolve.getDownloadInfo();
    String str1 = localRequestInfo.getKey();
    System.out.println("Google wallet payHelper onFinish cmdKey:" + str1 + "ret:" + paramBaseHttpResolve.getErrorCode());
    if (paramBaseHttpResolve.isError()) {
      if ((paramBaseHttpResolve.getErrorCode() == 1002) || (paramBaseHttpResolve.getErrorCode() == 1018)) {
        if (this.payListener != null) {
          this.payListener.onLoginExpiry(localRequestInfo);
        }
      }
    }
    label145:
    label315:
    label343:
    label881:
    for (;;)
    {
      return;
      if (str1.equals("changekey"))
      {
        if (localRequestInfo.keyType != RequestInfo.keytype.Secretkey) {
          break label315;
        }
        if (!localRequestInfo.isChangeKey)
        {
          localRequestInfo.keyType = RequestInfo.keytype.BaseKey;
          localRequestInfo.setKey("changekey");
          HttpRequestHelper.getIntanceHttpRequestHelper().startRequestInfo(localRequestInfo);
          localRequestInfo.isChangeKey = true;
        }
      }
      else
      {
        if (str1.equals("order"))
        {
          System.out.println("Google wallet payHelper order error");
          if (this.payListener != null) {
            this.payListener.onOrderFinishFailuer(localRequestInfo, paramBaseHttpResolve.getErrorMessage(), paramBaseHttpResolve.getErrorCode());
          }
        }
        if (str1.equals("provide"))
        {
          System.out.println("Google wallet payHelper provider error");
          if (paramBaseHttpResolve.getErrorCode() == 5004) {
            break label343;
          }
          if (this.payListener != null) {
            this.payListener.onDeliverFinishFailuer(localRequestInfo, paramBaseHttpResolve.getErrorMessage(), paramBaseHttpResolve.getErrorCode());
          }
        }
      }
      for (;;)
      {
        if (!str1.equals("restorprovide")) {
          break label398;
        }
        System.out.println("Google wallet payHelper reprovider");
        if (this.payListener == null) {
          break;
        }
        this.payListener.onDeliverFinishFailuer(localRequestInfo, paramBaseHttpResolve.getErrorMessage(), paramBaseHttpResolve.getErrorCode());
        return;
        if (this.payListener == null) {
          break label145;
        }
        this.payListener.onOrderFinishFailuer(localRequestInfo, paramBaseHttpResolve.getErrorMessage(), paramBaseHttpResolve.getErrorCode());
        break label145;
        if (this.payListener == null) {
          break label145;
        }
        this.payListener.onOrderFinishFailuer(localRequestInfo, paramBaseHttpResolve.getErrorMessage(), paramBaseHttpResolve.getErrorCode());
        break label145;
        if ((localRequestInfo.productType != RequestInfo.productType.Subscription) && (!this.isConfirm))
        {
          this.isConfirm = true;
          this.mHelper.consumeAsync(localRequestInfo.purchase, this);
        }
        if (this.payListener != null) {
          this.payListener.onDeliverFinishSucess(this.payInfo);
        }
      }
      continue;
      Object localObject;
      RequestInfo.productType localproductType;
      StringBuffer localStringBuffer;
      if (str1.equals("order"))
      {
        System.out.println("Google wallet payHelper order succ");
        localObject = ((HttpOrderResovle)paramBaseHttpResolve).getBillno();
        String str2 = localRequestInfo.openid;
        localproductType = localRequestInfo.productType;
        localStringBuffer = new StringBuffer();
        localStringBuffer.append("billno=" + (String)localObject);
        localStringBuffer.append("&openid=" + str2);
        if (localproductType != RequestInfo.productType.Consumable) {
          break label779;
        }
        localStringBuffer.append("&producttype=0");
        localStringBuffer.append("&session_id=" + localRequestInfo.session_id);
        localStringBuffer.append("&version=1.0.2");
        if (this.payInfo.productType != RequestInfo.productType.Subscription) {
          break label811;
        }
        this.mHelper.launchSubscriptionPurchaseFlow(this.activity, this.payInfo.productID, 10001, this, localStringBuffer.toString());
        if (this.payListener != null) {
          this.payListener.onOrderFinishSucess(this.payInfo);
        }
      }
      if (str1.equals("changekey"))
      {
        if (localRequestInfo.keyType != RequestInfo.keytype.BaseKey) {
          break label841;
        }
        paramBaseHttpResolve = ((HttpChangeKeyResovle)paramBaseHttpResolve).getRealkey();
        localObject = this.activity.getSharedPreferences("key", 0).edit();
        ((SharedPreferences.Editor)localObject).putString("secretkey", paramBaseHttpResolve);
        ((SharedPreferences.Editor)localObject).commit();
        BaseConfig.sercretKey = paramBaseHttpResolve;
        this.payInfo.keyType = RequestInfo.keytype.Secretkey;
        this.payInfo.setKey("changekey");
        HttpRequestHelper.getIntanceHttpRequestHelper().startRequestInfo(this.payInfo);
      }
      for (;;)
      {
        if ((!str1.equals("provide")) && (!str1.equals("restorprovide"))) {
          break label881;
        }
        if ((localRequestInfo.productType != RequestInfo.productType.Subscription) && (!this.isConfirm))
        {
          this.isConfirm = true;
          this.mHelper.consumeAsync(localRequestInfo.purchase, this);
        }
        if (this.payListener == null) {
          break;
        }
        this.payListener.onDeliverFinishSucess(this.payInfo);
        return;
        if (localproductType == RequestInfo.productType.Non_Consumable)
        {
          localStringBuffer.append("&producttype=1");
          break label513;
        }
        localStringBuffer.append("&producttype=2");
        break label513;
        this.mHelper.launchPurchaseFlow(this.activity, this.payInfo.productID, 10001, this, localStringBuffer.toString());
        break label588;
        if (localRequestInfo.keyType == RequestInfo.keytype.Secretkey)
        {
          BaseConfig.appKey = ((HttpChangeKeyResovle)paramBaseHttpResolve).getRealkey();
          this.payInfo.setKey("order");
          HttpRequestHelper.getIntanceHttpRequestHelper().startRequestInfo(this.payInfo);
        }
      }
    }
  }
  
  public void onIabPurchaseFinished(IabResult paramIabResult, Purchase paramPurchase)
  {
    System.out.println("Google wallet payHelper onIabPurchaseFinished Response:" + paramIabResult.getResponse());
    if (paramIabResult.isFailure())
    {
      System.out.println("Google wallet payHelper onIabPurchaseFinished isFailure");
      if (this.payListener != null)
      {
        if (paramIabResult.getResponse() != -1001) {
          break label74;
        }
        this.payListener.onNetWorkEorror(this.payInfo, 2);
      }
    }
    label74:
    do
    {
      return;
      this.payListener.onPurchaseFinishFailuer(this.payInfo, paramIabResult.getMessage(), paramIabResult.getResponse());
      return;
      this.payInfo.purchase = paramPurchase;
      System.out.println("Google wallet payHelper onIabPurchaseFinished succ to provider");
      this.payInfo.setKey("provide");
      HttpRequestHelper.getIntanceHttpRequestHelper().startRequestInfo(this.payInfo);
    } while (this.payListener == null);
    this.payListener.onPurchaseFinishSucess(this.payInfo);
  }
  
  public void onIabSetupFinished(IabResult paramIabResult)
  {
    if (!paramIabResult.isSuccess())
    {
      System.out.println("set up is not sucess");
      if (this.payListener != null) {
        this.payListener.onSetUpFinishFailure(this.payInfo, paramIabResult.getMessage(), paramIabResult.getResponse());
      }
    }
    do
    {
      return;
      System.out.println("set up is sucess");
    } while (this.payListener == null);
    this.payListener.onSetUpFinishSucess();
  }
  
  public void onPause(BaseHttpResolve paramBaseHttpResolve) {}
  
  public void onQueryInventoryFinished(IabResult paramIabResult, Inventory paramInventory)
  {
    this.isrestore = false;
    if (paramIabResult.isFailure()) {
      if (this.payListener != null) {
        this.payListener.onRestoreFinishFailue(paramIabResult.getMessage(), paramIabResult.getResponse());
      }
    }
    label184:
    for (;;)
    {
      return;
      paramIabResult = paramInventory.mPurchaseMap.keySet().iterator();
      int i = 0;
      if (!paramIabResult.hasNext()) {}
      for (;;)
      {
        if ((i != 0) || (this.payListener == null)) {
          break label184;
        }
        this.payListener.onRestoreFinishFailue("没有指定的恢复商品", -1);
        return;
        String str = (String)paramIabResult.next();
        System.out.println("productid=" + str);
        if (!str.equals(this.restorProductid)) {
          break;
        }
        i = 1;
        paramIabResult = (Purchase)paramInventory.mPurchaseMap.get(str);
        paramInventory = creatRequestInfo();
        paramInventory.purchase = paramIabResult;
        paramInventory.setKey("restorprovide");
        paramInventory.changeKey = RequestInfo.changkeyType.Resort;
        HttpRequestHelper.getIntanceHttpRequestHelper().startRequestInfo(paramInventory);
      }
    }
  }
  
  public void onReady(BaseHttpResolve paramBaseHttpResolve) {}
  
  public void onStart(BaseHttpResolve paramBaseHttpResolve) {}
  
  public void onStop(BaseHttpResolve paramBaseHttpResolve) {}
  
  public void pay(RequestInfo paramRequestInfo)
  {
    this.payInfo = paramRequestInfo;
    if (this.mHelper.mSetupDone)
    {
      paramRequestInfo = "inapp";
      if (this.payInfo.productType == RequestInfo.productType.Subscription) {
        paramRequestInfo = "subs";
      }
      localArrayList = new ArrayList();
      localArrayList.add(this.payInfo.productID);
    }
    while (this.payListener == null) {
      try
      {
        ArrayList localArrayList;
        queryProduct(paramRequestInfo, localArrayList);
        return;
      }
      catch (Exception paramRequestInfo)
      {
        while (this.payListener == null) {}
        this.payListener.onQueryProductInfoFailure(this.payInfo);
        return;
      }
    }
    this.payListener.onSetUpFinishFailure(this.payInfo, "set up ʧ��", -1);
  }
  
  public Map<String, SkuDetails> queryProductDetail(String paramString, ArrayList<String> paramArrayList)
  {
    try
    {
      if (paramString.equals("inapp")) {}
      for (paramString = this.mHelper.queryInventory(true, paramArrayList); paramString != null; paramString = this.mHelper.queryInventory(true, null, paramArrayList)) {
        return paramString.mSkuMap;
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  public void restorPay(String paramString)
  {
    if (this.mHelper != null)
    {
      if (!this.mHelper.mSetupDone) {
        break label43;
      }
      if (!this.isrestore)
      {
        this.isrestore = true;
        this.restorProductid = paramString;
        this.mHelper.queryInventoryAsync(this);
      }
    }
    label43:
    while (this.payListener == null) {
      return;
    }
    this.payListener.onSetUpFinishFailure(this.payInfo, "set up Failure", -1);
  }
  
  public void setDebugLog(boolean paramBoolean)
  {
    if (this.mHelper != null) {
      this.mHelper.enableDebugLogging(paramBoolean);
    }
  }
  
  public void setEnv(String paramString)
  {
    BaseConfig.env = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.GoogleWalletPayHelper
 * JD-Core Version:    0.7.0.1
 */