package com.tencent.mobileqq.wxapi;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMusicObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class WXShareHelper
  implements IWXAPIEventHandler
{
  private static WXShareHelper jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper = null;
  private static final String jdField_a_of_type_JavaLangString = "WXShareHelper";
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static final String b = "wxf0a80d0ac2e82aa7";
  private IWXAPI jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI = WXAPIFactory.createWXAPI(BaseApplicationImpl.a(), "wxf0a80d0ac2e82aa7", true);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  
  private WXShareHelper()
  {
    a();
  }
  
  public static WXShareHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper == null) {
        jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper = new WXShareHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.registerApp("wxf0a80d0ac2e82aa7");
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.handleIntent(paramIntent, this);
  }
  
  public void a(WXShareHelper.WXShareListener paramWXShareListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramWXShareListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramWXShareListener);
      }
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    paramString4 = new WXMediaMessage(new WXWebpageObject(paramString4));
    paramString4.description = paramString3;
    paramString4.title = paramString2;
    paramString4.setThumbImage(paramBitmap);
    paramString2 = new SendMessageToWX.Req();
    paramString2.transaction = paramString1;
    paramString2.message = paramString4;
    paramString2.scene = 1;
    this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.sendReq(paramString2);
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
  {
    WXMediaMessage localWXMediaMessage = new WXMediaMessage(new WXWebpageObject(paramString4));
    localWXMediaMessage.description = paramString3;
    localWXMediaMessage.title = paramString2;
    localWXMediaMessage.setThumbImage(paramBitmap);
    paramBitmap = new SendMessageToWX.Req();
    paramBitmap.transaction = paramString1;
    paramBitmap.message = localWXMediaMessage;
    paramBitmap.scene = paramInt;
    this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.sendReq(paramBitmap);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder().append("shareWebPage.transaction: ").append(paramString1).append(" title:").append(paramString2).append(" description:").append(paramString3).append(" webPageUrl:").append(paramString4).append(" scene:");
      if (paramInt != 0) {
        break label153;
      }
    }
    label153:
    for (paramString1 = "Friend";; paramString1 = "FriendCircle")
    {
      QLog.i("WXShareHelper", 2, paramString1);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    WXMusicObject localWXMusicObject = new WXMusicObject();
    localWXMusicObject.musicLowBandUrl = paramString4;
    localWXMusicObject.musicUrl = paramString4;
    localWXMusicObject.musicDataUrl = paramString5;
    localWXMusicObject.musicLowBandDataUrl = paramString5;
    paramString4 = new WXMediaMessage(localWXMusicObject);
    paramString4.description = paramString3;
    paramString4.title = paramString2;
    paramString4.setThumbImage(paramBitmap);
    paramString2 = new SendMessageToWX.Req();
    paramString2.transaction = paramString1;
    paramString2.message = paramString4;
    paramString2.scene = paramInt;
    this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.sendReq(paramString2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.isWXAppInstalled();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.unregisterApp();
  }
  
  public void b(WXShareHelper.WXShareListener paramWXShareListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramWXShareListener)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramWXShareListener);
      }
      return;
    }
  }
  
  public void b(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    paramString4 = new WXMediaMessage(new WXWebpageObject(paramString4));
    paramString4.description = paramString3;
    paramString4.title = paramString2;
    paramString4.setThumbImage(paramBitmap);
    paramString2 = new SendMessageToWX.Req();
    paramString2.transaction = paramString1;
    paramString2.message = paramString4;
    paramString2.scene = 0;
    this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.sendReq(paramString2);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMmSdkOpenapiIWXAPI.isWXAppSupportAPI();
  }
  
  public void c(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramBitmap, paramString3, paramString4, 1);
  }
  
  public void d(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramBitmap, paramString3, paramString4, 0);
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        ((WXShareHelper.WXShareListener)localIterator.next()).a(paramBaseResp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXShareHelper
 * JD-Core Version:    0.7.0.1
 */