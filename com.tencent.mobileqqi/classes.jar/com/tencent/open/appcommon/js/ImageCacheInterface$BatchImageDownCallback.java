package com.tencent.open.appcommon.js;

import android.os.Handler;
import android.os.Message;
import com.tencent.open.appcommon.CallBackEvent;
import com.tencent.open.appcommon.CallBackEvent.CallBackEventListener;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.img.ImageDownCallback;
import com.tencent.smtt.sdk.WebView;
import hla;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageCacheInterface$BatchImageDownCallback
  implements CallBackEvent.CallBackEventListener, ImageDownCallback
{
  protected int a;
  protected long a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  protected volatile JSONArray a;
  protected int b;
  protected long b;
  
  public ImageCacheInterface$BatchImageDownCallback(ImageCacheInterface paramImageCacheInterface, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Int = paramInt2;
    CallBackEvent.a().a(this);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString1, String arg2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler == null) {}
    do
    {
      return;
      paramString1 = new JSONObject();
      try
      {
        paramString1.put("path", ???);
        paramString1.put("localUrl", paramString3);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramString1);
        LogUtility.b("ImageCacheInterface", "imgDownloaded time:" + (System.currentTimeMillis() - this.jdField_b_of_type_Long) + " size:" + this.jdField_a_of_type_OrgJsonJSONArray.length() + " remain:" + this.jdField_b_of_type_Int + " url=" + paramString3);
        if ((System.currentTimeMillis() - this.jdField_b_of_type_Long <= this.jdField_a_of_type_Long) && (this.jdField_a_of_type_OrgJsonJSONArray.length() <= this.jdField_a_of_type_Int) && (this.jdField_a_of_type_OrgJsonJSONArray.length() < this.jdField_b_of_type_Int)) {
          break;
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        paramString1 = new hla();
        paramString1.jdField_a_of_type_ComTencentSmttSdkWebView = ((WebView)this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.webviewRef.get());
        paramString1.jdField_a_of_type_JavaLangString = ("javascript:QzoneApp.fire('loadImg','" + this.jdField_a_of_type_OrgJsonJSONArray.toString() + "');void(0);");
        this.jdField_b_of_type_Int -= this.jdField_a_of_type_OrgJsonJSONArray.length();
        this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
        LogUtility.b("ImageCacheInterface", "imgDownloaded " + paramString1.jdField_a_of_type_JavaLangString);
        if (!CallBackEvent.a().a()) {
          synchronized (this.jdField_a_of_type_JavaUtilList)
          {
            this.jdField_a_of_type_JavaUtilList.add(paramString1.jdField_a_of_type_JavaLangString);
            return;
          }
        }
      }
      catch (JSONException ???)
      {
        for (;;)
        {
          ???.printStackTrace();
        }
        ??? = this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler.obtainMessage(0);
        ???.obj = paramString1;
        ???.arg1 = 1;
      }
    } while (this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler == null);
    this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler.sendMessage(???);
    return;
    LogUtility.b(BaseInterface.TAG, "imgDownloaded batch url=" + paramString3);
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
  
  public void b(String paramString1, String arg2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler == null) {}
    do
    {
      for (;;)
      {
        return;
        paramString1 = new JSONObject();
        try
        {
          paramString1.put("path", ???);
          paramString1.put("localUrl", "");
          paramString1.put("imgUrl", paramString3);
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramString1);
          LogUtility.b("ImageCacheInterface", "downloaded:" + (System.currentTimeMillis() - this.jdField_b_of_type_Long) + " size:" + this.jdField_a_of_type_OrgJsonJSONArray.length() + " remain:" + this.jdField_b_of_type_Int);
          if ((System.currentTimeMillis() - this.jdField_b_of_type_Long > this.jdField_a_of_type_Long) || (this.jdField_a_of_type_OrgJsonJSONArray.length() > this.jdField_a_of_type_Int) || (this.jdField_a_of_type_OrgJsonJSONArray.length() >= this.jdField_b_of_type_Int))
          {
            this.jdField_b_of_type_Long = System.currentTimeMillis();
            paramString1 = new hla();
            paramString1.jdField_a_of_type_ComTencentSmttSdkWebView = ((WebView)this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.webviewRef.get());
            paramString1.jdField_a_of_type_JavaLangString = ("javascript:QzoneApp.fire('loadImg','" + this.jdField_a_of_type_OrgJsonJSONArray + "');void(0);");
            this.jdField_b_of_type_Int -= this.jdField_a_of_type_OrgJsonJSONArray.length();
            this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
            LogUtility.c("ImageCacheInterface", "imgDownloaded " + paramString1.jdField_a_of_type_JavaLangString);
            if (!CallBackEvent.a().a()) {
              synchronized (this.jdField_a_of_type_JavaUtilList)
              {
                this.jdField_a_of_type_JavaUtilList.add(paramString1.jdField_a_of_type_JavaLangString);
                return;
              }
            }
          }
        }
        catch (JSONException ???)
        {
          for (;;)
          {
            ???.printStackTrace();
          }
          ??? = this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler.obtainMessage(0);
          ???.obj = paramString1;
          ???.arg1 = 1;
        }
      }
    } while (this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler == null);
    this.jdField_a_of_type_ComTencentOpenAppcommonJsImageCacheInterface.mHandler.sendMessage(???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.js.ImageCacheInterface.BatchImageDownCallback
 * JD-Core Version:    0.7.0.1
 */