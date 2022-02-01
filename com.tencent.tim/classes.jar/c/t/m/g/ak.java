package c.t.m.g;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public final class ak
{
  private byte[] a = new byte[0];
  private PublicKey b;
  
  @Deprecated
  @SuppressLint({"MissingPermission"})
  public static a a()
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)an.a("connectivity");
      if (localConnectivityManager == null) {}
      for (Object localObject = null; (localObject == null) || (!((NetworkInfo)localObject).isConnected()); localObject = localConnectivityManager.getActiveNetworkInfo()) {
        return a.a;
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (localConnectivityManager.isActiveNetworkMetered()) {
          return a.b;
        }
        return a.c;
      }
      if (1 == ((NetworkInfo)localObject).getType()) {
        return a.c;
      }
      localObject = a.b;
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return a.a;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    synchronized (this.a)
    {
      try
      {
        this.b = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramArrayOfByte));
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          ai.a("EncryptRsa", "set pk error.", paramArrayOfByte);
        }
      }
    }
  }
  
  public static enum a
  {
    static
    {
      a locala = a;
      locala = b;
      locala = c;
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.ak
 * JD-Core Version:    0.7.0.1
 */