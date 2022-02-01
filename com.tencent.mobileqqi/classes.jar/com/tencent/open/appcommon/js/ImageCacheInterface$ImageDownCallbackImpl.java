package com.tencent.open.appcommon.js;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.appcommon.CallBackEvent;
import com.tencent.open.appcommon.CallBackEvent.CallBackEventListener;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.img.ImageDownCallback;
import com.tencent.smtt.sdk.WebView;
import hla;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ImageCacheInterface$ImageDownCallbackImpl
  implements CallBackEvent.CallBackEventListener, ImageDownCallback
{
  protected String a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ImageCacheInterface$ImageDownCallbackImpl(ImageCacheInterface paramImageCacheInterface, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    CallBackEvent.a().a(this);
  }
  
  public void a(String arg1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler == null) {}
    Message localMessage;
    do
    {
      return;
      localMessage = this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler.obtainMessage(0);
      hla localhla = new hla();
      localhla.jdField_a_of_type_ComTencentSmttSdkWebView = ((WebView)this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.webviewRef.get());
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
      for (localhla.jdField_a_of_type_JavaLangString = ("javascript:QzoneApp.fire('loadImg','" + ??? + "','" + paramString2 + "','" + paramString3 + "');void(0);");; localhla.jdField_a_of_type_JavaLangString = ("javascript:" + this.jdField_a_of_type_JavaLangString + "('" + ??? + "','" + paramString2 + "','" + paramString3 + "');void(0);"))
      {
        LogUtility.c("ImageCacheInterface", "imgDownloaded " + localhla.jdField_a_of_type_JavaLangString);
        if (CallBackEvent.a().a()) {
          break;
        }
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_JavaUtilList.add(localhla.jdField_a_of_type_JavaLangString);
          return;
        }
      }
      localMessage.obj = localhla;
      localMessage.arg1 = 1;
    } while (this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler == null);
    this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler.sendMessage(localMessage);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          String[] arrayOfString = new String[this.jdField_a_of_type_JavaUtilList.size()];
          this.jdField_a_of_type_JavaUtilList.toArray(arrayOfString);
          if (arrayOfString != null)
          {
            int j = arrayOfString.length;
            int i = 0;
            if (i < j)
            {
              ??? = arrayOfString[i];
              Message localMessage = this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler.obtainMessage(0);
              hla localhla = new hla();
              localhla.jdField_a_of_type_ComTencentSmttSdkWebView = ((WebView)this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.webviewRef.get());
              localhla.jdField_a_of_type_JavaLangString = ???;
              localMessage.obj = localhla;
              localMessage.arg1 = 1;
              this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler.sendMessage(localMessage);
              i += 1;
            }
          }
        }
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void b(String arg1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler == null) {}
    Message localMessage;
    do
    {
      return;
      localMessage = this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler.obtainMessage(0);
      hla localhla = new hla();
      localhla.jdField_a_of_type_ComTencentSmttSdkWebView = ((WebView)this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.webviewRef.get());
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
      for (localhla.jdField_a_of_type_JavaLangString = ("javascript:QzoneApp.fire('loadImg','" + ??? + "','" + paramString2 + "','','" + paramString3 + "');void(0);");; localhla.jdField_a_of_type_JavaLangString = ("javascript:" + this.jdField_a_of_type_JavaLangString + "('" + ??? + "','" + paramString2 + "','','" + paramString3 + "');void(0);"))
      {
        LogUtility.c("ImageCacheInterface", "imgDownloaded " + localhla.jdField_a_of_type_JavaLangString);
        if (CallBackEvent.a().a()) {
          break;
        }
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_JavaUtilList.add(localhla.jdField_a_of_type_JavaLangString);
          return;
        }
      }
      localMessage.obj = localhla;
      localMessage.arg1 = 1;
    } while (this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler == null);
    this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.js.ImageCacheInterface.ImageDownCallbackImpl
 * JD-Core Version:    0.7.0.1
 */