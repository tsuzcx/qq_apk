package com.tencent.open.appcommon.js;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.open.appcommon.CallBackEvent;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.img.ImageCache;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageCacheInterface
  extends BaseInterface
{
  protected static final int DEFCALLBACKCOUNT = 5;
  protected static final long DEFCALLBACKMILLIS = 1000L;
  protected static final String LOG_TAG = "ImageCacheInterface";
  protected ArrayList mCallbackImpls = new ArrayList();
  protected Handler mHandler = new WebviewHandler();
  protected WeakReference webviewRef;
  
  public ImageCacheInterface(WebView paramWebView)
  {
    this.webviewRef = new WeakReference(paramWebView);
  }
  
  public int clearImage(String paramString1, String paramString2, String paramString3)
  {
    if (!Common.a())
    {
      LogUtility.c("ImageCacheInterface", "clearImage no sdcard");
      return -1;
    }
    paramString1 = Common.b() + ImageCache.b + paramString2 + File.separator + FileUtils.a(paramString3);
    paramString2 = new File(paramString1);
    if ((paramString2.exists()) && (!paramString2.isDirectory())) {
      try
      {
        paramString2.delete();
        LogUtility.b("ImageCacheInterface", "real clear imgFilePath=" + paramString1 + " url=" + paramString3);
        return 0;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return -2;
  }
  
  public void destroy()
  {
    CallBackEvent.a().a(this.mCallbackImpls);
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    this.mCallbackImpls.clear();
    super.destroy();
  }
  
  public void downloadImage(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    LogUtility.c("ImageCacheInterface", "downloadImage start");
    paramString1 = null;
    if (paramString4 != null)
    {
      paramString1 = new ImageCacheInterface.ImageDownCallbackImpl(this, paramString4);
      this.mCallbackImpls.add(paramString1);
    }
    ImageCache.a(paramString2, paramString3, paramString1);
  }
  
  public void downloadImageBatch(String paramString1, String paramString2, String paramString3)
  {
    LogUtility.c("ImageCacheInterface", ">>downloadImg jsonArray:" + paramString1);
    LogUtility.c("ImageCacheInterface", "intv_millis:" + paramString2 + "  count:" + paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    try
    {
      paramString1 = new JSONArray(paramString1);
      long l1 = 1000L;
      int i = 5;
      try
      {
        long l2 = Long.parseLong(paramString2);
        l1 = l2;
        j = Integer.parseInt(paramString3);
        i = j;
        l1 = l2;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          int j;
          int k;
          LogUtility.b("ImageCacheInterface", "parse num err:", paramString2);
          continue;
          String str1 = ((JSONObject)localObject).optString("path");
          String str2 = ((JSONObject)localObject).optString("url");
          Object localObject = ((JSONObject)localObject).optString("del");
          if (paramString3.contains(str2))
          {
            LogUtility.b(TAG, "querySet.contains(url)");
            i -= 1;
          }
          else
          {
            if ("1".equals(localObject)) {
              clearImage("", str1, str2);
            }
            this.mCallbackImpls.add(paramString2);
            ImageCache.a(str1, str2, paramString2);
          }
        }
        paramString2.a(i);
        return;
      }
      j = paramString1.length();
      paramString2 = new ImageCacheInterface.BatchImageDownCallback(this, l1, i, j);
      paramString3 = new HashSet();
      k = 0;
      i = j;
      j = k;
      for (;;)
      {
        if (j >= paramString1.length()) {
          break label299;
        }
        localObject = paramString1.optJSONObject(j);
        if (localObject != null) {
          break;
        }
        LogUtility.b(TAG, "jsonObject == null");
        i -= 1;
        j += 1;
      }
      label299:
      return;
    }
    catch (JSONException paramString1) {}
  }
  
  public String getImageRootPath()
  {
    LogUtility.c("ImageCacheInterface", "getImageRootPath");
    return Common.b() + ImageCache.b;
  }
  
  public String getInterfaceName()
  {
    return "qzone_imageCache";
  }
  
  public int sdIsMounted()
  {
    if (Common.a()) {
      return 0;
    }
    return -1;
  }
  
  public void updateImage(String paramString1, String paramString2, String paramString3)
  {
    LogUtility.c("ImageCacheInterface", "updateImage");
    ImageCache.a(paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.js.ImageCacheInterface
 * JD-Core Version:    0.7.0.1
 */