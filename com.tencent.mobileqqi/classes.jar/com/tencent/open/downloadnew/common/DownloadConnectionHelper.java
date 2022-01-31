package com.tencent.open.downloadnew.common;

import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadConnectionHelper
{
  protected static final String a = DownloadConnectionHelper.class.getName();
  
  public static HttpURLConnection a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean3)
  {
    Object localObject4 = null;
    Object localObject1 = localObject4;
    int i;
    Object localObject2;
    for (;;)
    {
      try
      {
        boolean bool = APNUtil.a(CommonDataAdapter.a().a());
        localObject1 = localObject4;
        LogUtility.a("onNetworkConnect", ">>>>RUN>>>>DownloadManager.getHttpConnection>>useProxy=" + bool);
        localObject1 = localObject4;
        LogUtility.b(a, "download url:" + paramString1 + ",proxy:" + bool);
        if (bool)
        {
          localObject1 = localObject4;
          i = "http://".length();
          localObject1 = localObject4;
          String str1 = APNUtil.c(CommonDataAdapter.a().a());
          localObject1 = localObject4;
          String str2 = APNUtil.d(CommonDataAdapter.a().a());
          localObject1 = localObject4;
          j = paramString1.indexOf('/', i);
          if (j < 0)
          {
            localObject1 = localObject4;
            localObject2 = paramString1.substring(i);
            localObject3 = "";
            localObject1 = localObject4;
            LogUtility.b(a, ">>host=" + (String)localObject2 + " path=" + (String)localObject3);
            localObject1 = localObject4;
            localObject3 = new URL("http://" + str1 + ":" + str2 + (String)localObject3);
            localObject1 = localObject4;
            LogUtility.a("onNetworkConnect", ">>>>RUN>>>>DownloadManager.getHttpConnection>>u=" + localObject3);
            localObject1 = localObject4;
            localObject3 = (HttpURLConnection)((URL)localObject3).openConnection();
            localObject1 = localObject3;
          }
        }
      }
      catch (Exception paramString1)
      {
        int j;
        Object localObject3;
        label682:
        continue;
      }
      try
      {
        ((HttpURLConnection)localObject3).setRequestProperty("X-Online-Host", (String)localObject2);
        localObject2 = localObject3;
        localObject1 = localObject2;
        ((HttpURLConnection)localObject2).setInstanceFollowRedirects(false);
        localObject1 = localObject2;
        ((HttpURLConnection)localObject2).setRequestProperty("Accept-Encoding", "deflate");
        localObject1 = localObject2;
        ((HttpURLConnection)localObject2).setRequestMethod("GET");
        localObject1 = localObject2;
        ((HttpURLConnection)localObject2).setDoInput(paramBoolean1);
        localObject1 = localObject2;
        ((HttpURLConnection)localObject2).setAllowUserInteraction(paramBoolean2);
        localObject1 = localObject2;
        ((HttpURLConnection)localObject2).setConnectTimeout(paramInt1);
        localObject1 = localObject2;
        ((HttpURLConnection)localObject2).setReadTimeout(paramInt2);
        if (paramString2 != null)
        {
          localObject1 = localObject2;
          ((HttpURLConnection)localObject2).setRequestProperty("Range", paramString2);
        }
        localObject1 = localObject2;
        ((HttpURLConnection)localObject2).setConnectTimeout(120000);
        localObject1 = localObject2;
        i = ((HttpURLConnection)localObject2).getResponseCode();
        localObject1 = localObject2;
        LogUtility.a("onNetworkConnect", ">>>>RUN>>>>DownloadManager.getHttpConnection>>reponseCode=" + i);
        if ((i != 302) && (i != 301)) {
          break label914;
        }
        localObject1 = localObject2;
        paramString1 = ((HttpURLConnection)localObject2).getHeaderField("Location");
        localObject1 = localObject2;
        LogUtility.a("onNetworkConnect", ">>>>RUN>>>>DownloadManager.getHttpConnection>>MOVE,loc=" + paramString1);
        localObject1 = localObject2;
        a((HttpURLConnection)localObject2);
        localObject1 = null;
        if (paramString1 == null) {
          break label912;
        }
        return a(paramString1, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramString2, false);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        LogUtility.a("onNetworkConnect", ">>>>RUN>>>>DownloadManager.getHttpConnection>>Exception=" + paramString1.getMessage(), paramString1);
        a((HttpURLConnection)localObject1);
        return null;
      }
      localObject1 = localObject4;
      localObject2 = paramString1.substring(i, j);
      localObject1 = localObject4;
      localObject3 = paramString1.substring(j);
      continue;
      localObject1 = localObject4;
      localObject2 = new URL(paramString1);
      localObject1 = localObject4;
      LogUtility.a("onNetworkConnect", ">>>>RUN>>>>[useProxy=false]DownloadManager.getHttpConnection>>u=" + localObject2);
      localObject1 = localObject4;
      localObject2 = (HttpURLConnection)((URL)localObject2).openConnection();
      continue;
      localObject1 = localObject2;
      localObject3 = ((HttpURLConnection)localObject2).getContentType();
      localObject1 = localObject2;
      LogUtility.a("onNetworkConnect", ">>>>RUN>>>>DownloadManager.getHttpConnection>>OK,contentType=" + (String)localObject3);
      if (localObject3 == null)
      {
        localObject3 = "";
        localObject1 = localObject2;
        LogUtility.a("onNetworkConnect", ">>>>RUN>>>>DownloadManager.getHttpConnection>>OK,contentType=" + (String)localObject3);
        localObject1 = localObject2;
        if (((String)localObject3).indexOf("text/vnd.wap.wml") != -1) {
          break label933;
        }
        localObject1 = localObject2;
        if (((String)localObject3).indexOf("application/vnd.wap.wmlc") == -1) {
          break label939;
        }
        break label933;
      }
    }
    for (;;)
    {
      if ((i != 0) && (paramBoolean3))
      {
        localObject1 = localObject2;
        LogUtility.a("onNetworkConnect", ">>toRetry:" + paramBoolean3);
        localObject1 = localObject2;
        paramString1 = a(paramString1, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramString2, false);
        localObject1 = paramString1;
        LogUtility.a("onNetworkConnect", ">>toRetry,uc=" + paramString1);
        return paramString1;
        localObject1 = localObject2;
        localObject3 = ((String)localObject3).toLowerCase();
        break label682;
      }
      label912:
      label914:
      do
      {
        localObject1 = localObject2;
        LogUtility.a("onNetworkConnect", ">>>>RUN>>>>DownloadManager.getHttpConnection>>else");
        localObject1 = localObject2;
        a((HttpURLConnection)localObject2);
        return null;
        return localObject2;
        return null;
        if (i == 200) {
          break;
        }
      } while (i != 206);
      break;
      label933:
      i = 1;
      continue;
      label939:
      i = 0;
    }
  }
  
  protected static void a(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      LogUtility.a("onNetworkConnect", ">>>>disConnect, " + paramHttpURLConnection);
      if (paramHttpURLConnection != null) {
        paramHttpURLConnection.disconnect();
      }
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      paramHttpURLConnection.printStackTrace();
      LogUtility.e(a, "" + paramHttpURLConnection.getMessage());
      LogUtility.a("onNetworkConnect", ">>>>disConnect, " + paramHttpURLConnection.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.DownloadConnectionHelper
 * JD-Core Version:    0.7.0.1
 */