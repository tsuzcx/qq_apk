package com.huawei.hms.framework.network.grs.c.b;

import android.content.Context;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLSocketFactory;

public class a
{
  public static SSLSocketFactory a(Context paramContext)
  {
    try
    {
      paramContext = c.a(paramContext, "grs_sp.bks");
      return paramContext;
    }
    catch (IOException paramContext)
    {
      throw new AssertionError(paramContext);
    }
    catch (CertificateException paramContext)
    {
      throw new AssertionError(paramContext);
    }
    catch (NoSuchAlgorithmException paramContext)
    {
      throw new AssertionError(paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new AssertionError(paramContext);
    }
    catch (KeyStoreException paramContext)
    {
      throw new AssertionError(paramContext);
    }
    catch (KeyManagementException paramContext)
    {
      throw new AssertionError(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.b.a
 * JD-Core Version:    0.7.0.1
 */