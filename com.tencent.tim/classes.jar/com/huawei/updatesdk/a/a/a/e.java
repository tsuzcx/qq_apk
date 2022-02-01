package com.huawei.updatesdk.a.a.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class e
  implements X509TrustManager
{
  protected List<X509TrustManager> a = new ArrayList();
  
  public e(Context paramContext)
    throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context is null");
    }
    TrustManager[] arrayOfTrustManager = null;
    localObject1 = arrayOfTrustManager;
    try
    {
      localObject2 = TrustManagerFactory.getInstance("X509");
      localObject1 = arrayOfTrustManager;
      KeyStore localKeyStore = KeyStore.getInstance("bks");
      localObject1 = arrayOfTrustManager;
      paramContext = paramContext.getAssets().open("updatesdkcas.bks");
      localObject1 = paramContext;
      paramContext.reset();
      localObject1 = paramContext;
      localKeyStore.load(paramContext, "".toCharArray());
      localObject1 = paramContext;
      ((TrustManagerFactory)localObject2).init(localKeyStore);
      localObject1 = paramContext;
      arrayOfTrustManager = ((TrustManagerFactory)localObject2).getTrustManagers();
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject2;
        int i;
        if (localObject1 != null) {}
        try
        {
          ((InputStream)localObject1).close();
          throw paramContext;
          if (paramContext != null) {}
          try
          {
            paramContext.close();
            return;
          }
          catch (IOException paramContext)
          {
            Log.e("SecureX509TrustManager", "close bks exception");
            return;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.e("SecureX509TrustManager", "close bks exception");
          }
        }
        i += 1;
      }
    }
    localObject1 = paramContext;
    if (i < arrayOfTrustManager.length)
    {
      localObject2 = arrayOfTrustManager[i];
      localObject1 = paramContext;
      if ((localObject2 instanceof X509TrustManager))
      {
        localObject1 = paramContext;
        this.a.add((X509TrustManager)localObject2);
      }
    }
    else
    {
      localObject1 = paramContext;
      if (this.a.isEmpty())
      {
        localObject1 = paramContext;
        throw new CertificateException("X509TrustManager is empty");
      }
    }
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    if (!this.a.isEmpty())
    {
      ((X509TrustManager)this.a.get(0)).checkClientTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    throw new CertificateException("checkClientTrusted CertificateException");
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {
    if (!this.a.isEmpty())
    {
      ((X509TrustManager)this.a.get(0)).checkServerTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    throw new CertificateException("checkServerTrusted CertificateException");
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(Arrays.asList(((X509TrustManager)localIterator.next()).getAcceptedIssuers()));
    }
    return (X509Certificate[])localArrayList.toArray(new X509Certificate[localArrayList.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */