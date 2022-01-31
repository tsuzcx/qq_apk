package com.tencent.smtt.sdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

class DownLoadListenerAdapter
  implements com.tencent.smtt.export.external.interfaces.DownloadListener
{
  private DownloadListener mListener;
  private WebView mWebView;
  
  public DownLoadListenerAdapter(WebView paramWebView, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    this.mListener = paramDownloadListener;
    this.mWebView = paramWebView;
  }
  
  public void onDownloadStart(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7)
  {
    if (this.mListener == null)
    {
      if (QbSdk.canOpenMimeFileType(this.mWebView.getContext(), paramString5))
      {
        paramString2 = new Intent("com.tencent.QQBrowser.action.sdk.document");
        paramString2.setFlags(268435456);
        paramString2.putExtra("key_reader_sdk_url", paramString1);
        paramString2.putExtra("key_reader_sdk_type", 1);
        paramString2.setData(Uri.parse(paramString1));
        this.mWebView.getContext().startActivity(paramString2);
        return;
      }
      paramString1 = new Intent("com.tencent.QQBrowser.action.SHOWDOWNLOAD", Uri.parse(paramString1));
      paramString1.addCategory("android.intent.category.DEFAULT");
      paramString1.putExtra("method", paramString2);
      paramString1.putExtra("postData", paramArrayOfByte);
      paramString1.putExtra("userAgent", paramString3);
      paramString1.putExtra("contentDisposition", paramString4);
      paramString1.putExtra("mimetype", paramString5);
      paramString1.putExtra("contentLength", paramLong);
      paramString1.putExtra("referer", paramString6);
      paramString1.putExtra("urlBeforeRedirect", paramString7);
      try
      {
        this.mWebView.getContext().startActivity(paramString1);
        return;
      }
      catch (ActivityNotFoundException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    this.mListener.onDownloadStart(paramString1, paramString3, paramString4, paramString5, paramLong);
  }
  
  public void onDownloadVideo(String paramString, long paramLong, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.DownLoadListenerAdapter
 * JD-Core Version:    0.7.0.1
 */