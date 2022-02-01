package com.huawei.hms.update.b;

import android.content.Context;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class c
{
  public static void a(HttpsURLConnection paramHttpsURLConnection, Context paramContext)
  {
    paramContext = f.a(paramContext);
    if ((paramContext instanceof SSLSocketFactory)) {
      paramHttpsURLConnection.setSSLSocketFactory((SSLSocketFactory)paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.b.c
 * JD-Core Version:    0.7.0.1
 */