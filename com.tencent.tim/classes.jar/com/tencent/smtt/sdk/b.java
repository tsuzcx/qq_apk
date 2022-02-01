package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.smtt.sdk.stat.MttLoader;

class b
  implements com.tencent.smtt.export.external.interfaces.DownloadListener
{
  private DownloadListener a;
  private WebView b;
  
  public b(WebView paramWebView, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    this.a = paramDownloadListener;
    this.b = paramWebView;
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    onDownloadStart(paramString1, null, null, paramString2, paramString3, paramString4, paramLong, null, null);
  }
  
  public void onDownloadStart(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7)
  {
    if (this.a == null)
    {
      paramString2 = this.b.getContext().getApplicationInfo();
      if ((paramString2 == null) || (!"com.tencent.mm".equals(paramString2.packageName))) {
        MttLoader.loadUrl(this.b.getContext(), paramString1, null, null);
      }
      return;
    }
    this.a.onDownloadStart(paramString1, paramString3, paramString4, paramString5, paramLong);
  }
  
  public void onDownloadVideo(String paramString, long paramLong, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.b
 * JD-Core Version:    0.7.0.1
 */