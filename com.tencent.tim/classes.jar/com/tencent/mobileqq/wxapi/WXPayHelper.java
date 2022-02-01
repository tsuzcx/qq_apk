package com.tencent.mobileqq.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.ArrayList;
import java.util.Iterator;

public class WXPayHelper
  implements IWXAPIEventHandler
{
  private static WXPayHelper jdField_a_of_type_ComTencentMobileqqWxapiWXPayHelper;
  private static byte[] lock = new byte[0];
  private IWXAPI jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI = WXAPIFactory.createWXAPI(BaseApplicationImpl.getApplication().getApplicationContext(), "wx4c9797ab3fd1e003", true);
  private ArrayList<Handler> kp = new ArrayList(1);
  
  private WXPayHelper()
  {
    registerApp();
  }
  
  public static WXPayHelper getInstance()
  {
    if (jdField_a_of_type_ComTencentMobileqqWxapiWXPayHelper == null) {}
    synchronized (lock)
    {
      if (jdField_a_of_type_ComTencentMobileqqWxapiWXPayHelper == null) {
        jdField_a_of_type_ComTencentMobileqqWxapiWXPayHelper = new WXPayHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqWxapiWXPayHelper;
    }
  }
  
  public void addObserver(Handler paramHandler)
  {
    synchronized (this.kp)
    {
      if (!this.kp.contains(paramHandler)) {
        this.kp.add(paramHandler);
      }
      return;
    }
  }
  
  public int getWXAppSupportAPI()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.getWXAppSupportAPI();
  }
  
  public void handleIntent(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.handleIntent(paramIntent, this);
  }
  
  public boolean isWXinstalled()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.isWXAppInstalled();
  }
  
  public boolean isWXsupportApi()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.getWXAppSupportAPI() >= 553779201;
  }
  
  public boolean isWXsupportPayApi()
  {
    return this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.getWXAppSupportAPI() >= 570425345;
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp)
  {
    synchronized (this.kp)
    {
      Iterator localIterator = this.kp.iterator();
      if (localIterator.hasNext())
      {
        Handler localHandler = (Handler)localIterator.next();
        Message localMessage = new Message();
        localMessage.what = 10;
        Bundle localBundle = new Bundle();
        localBundle.putInt("errCode", paramBaseResp.errCode);
        localBundle.putString("errStr", paramBaseResp.errStr);
        localBundle.putString("openId", paramBaseResp.openId);
        localBundle.putString("transaction", paramBaseResp.transaction);
        localMessage.setData(localBundle);
        localHandler.sendMessage(localMessage);
      }
    }
  }
  
  public void registerApp()
  {
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.registerApp("wx4c9797ab3fd1e003");
  }
  
  public void removeObserver(Handler paramHandler)
  {
    synchronized (this.kp)
    {
      if (this.kp.contains(paramHandler)) {
        this.kp.remove(paramHandler);
      }
      return;
    }
  }
  
  public void sendReq(Bundle paramBundle)
  {
    PayReq localPayReq = new PayReq();
    localPayReq.appId = "wx4c9797ab3fd1e003";
    localPayReq.partnerId = paramBundle.getString("partnerid");
    localPayReq.prepayId = paramBundle.getString("prepayid");
    localPayReq.nonceStr = paramBundle.getString("noncestr");
    localPayReq.timeStamp = paramBundle.getString("timestamp");
    localPayReq.packageValue = paramBundle.getString("package");
    localPayReq.sign = paramBundle.getString("sign");
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.sendReq(localPayReq);
  }
  
  public void unRegisterApp()
  {
    this.jdField_a_of_type_ComTencentMmOpensdkOpenapiIWXAPI.unregisterApp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXPayHelper
 * JD-Core Version:    0.7.0.1
 */