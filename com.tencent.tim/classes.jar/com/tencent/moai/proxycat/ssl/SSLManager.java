package com.tencent.moai.proxycat.ssl;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.security.KeyChain;
import android.util.Log;
import com.tencent.moai.proxycat.ProxyCatManager;
import com.tencent.moai.proxycat.util.Logger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;

public class SSLManager
{
  private static final String TAG = "SSLManager";
  private static SSLManager instance = new SSLManager();
  private int appBufferMax;
  private boolean isInit;
  private KeyManagerFactory kmf;
  private KeyStore ks;
  private int netBufferMax;
  private SSLContext sslContext;
  private SSLEngine sslEngine;
  private SSLSession sslSession;
  private TrustManagerFactory tmf;
  private KeyStore ts;
  
  public static SSLManager getInstance()
  {
    return instance;
  }
  
  public Intent createInstallIntent()
    throws IOException
  {
    Object localObject = new BufferedInputStream(ProxyCatManager.getInstance().getContext().getAssets().open("client.cer"));
    byte[] arrayOfByte = new byte[((BufferedInputStream)localObject).available()];
    ((BufferedInputStream)localObject).read(arrayOfByte);
    localObject = KeyChain.createInstallIntent();
    ((Intent)localObject).putExtra("name", "ProxyCat certificate");
    ((Intent)localObject).putExtra("CERT", arrayOfByte);
    return localObject;
  }
  
  public SSLEngineResult.HandshakeStatus doTask()
  {
    for (;;)
    {
      localObject = this.sslEngine.getDelegatedTask();
      if (localObject == null) {
        break;
      }
      ((Runnable)localObject).run();
    }
    Object localObject = this.sslEngine.getHandshakeStatus();
    if (localObject == SSLEngineResult.HandshakeStatus.NEED_TASK) {
      Logger.e("SSLManager", "handshake shouldn't need additional tasks");
    }
    return localObject;
  }
  
  public SSLEngineResult.HandshakeStatus doUnwrap(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws IOException
  {
    SSLEngineResult.HandshakeStatus localHandshakeStatus;
    do
    {
      this.sslEngine.unwrap(paramByteBuffer1, paramByteBuffer2);
      localHandshakeStatus = doTask();
    } while ((localHandshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) && (paramByteBuffer1.hasRemaining()));
    return localHandshakeStatus;
  }
  
  public SSLEngineResult.HandshakeStatus doWrap(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws IOException
  {
    SSLEngineResult.HandshakeStatus localHandshakeStatus;
    do
    {
      this.sslEngine.wrap(paramByteBuffer1, paramByteBuffer2);
      localHandshakeStatus = doTask();
    } while ((localHandshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) && (paramByteBuffer1.hasRemaining()));
    return localHandshakeStatus;
  }
  
  public int getAppBufferMax()
  {
    return this.appBufferMax;
  }
  
  public int getNetBufferMax()
  {
    return this.netBufferMax;
  }
  
  public void handShake(HandShakeCallBack paramHandShakeCallBack)
  {
    label181:
    label182:
    for (;;)
    {
      try
      {
        this.sslEngine.beginHandshake();
        localHandshakeStatus = this.sslEngine.getHandshakeStatus();
        i = 0;
        if (i != 0) {
          break label181;
        }
        switch (SSLManager.1.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[localHandshakeStatus.ordinal()])
        {
        case 1: 
          Logger.d("SSLManager", "status finish");
          if (paramHandShakeCallBack == null) {
            break label182;
          }
          localHandshakeStatus = paramHandShakeCallBack.onFinished();
        }
      }
      catch (IOException paramHandShakeCallBack)
      {
        SSLEngineResult.HandshakeStatus localHandshakeStatus;
        int i;
        Logger.e("SSLManager", Log.getStackTraceString(paramHandShakeCallBack));
      }
      Logger.d("SSLManager", "status need task");
      if (paramHandShakeCallBack != null)
      {
        localHandshakeStatus = paramHandShakeCallBack.onNeedTask();
        break label182;
        Logger.d("SSLManager", "status need unwrap");
        if (paramHandShakeCallBack != null)
        {
          localHandshakeStatus = paramHandShakeCallBack.onNeedUnwrap();
          break label182;
          Logger.d("SSLManager", "status need wrap");
          if (paramHandShakeCallBack != null)
          {
            localHandshakeStatus = paramHandShakeCallBack.onNeedWrap();
            break label182;
            Logger.d("SSLManager", "status no handshaking");
            if (paramHandShakeCallBack != null) {
              localHandshakeStatus = paramHandShakeCallBack.onNotHandShaking();
            }
            i = 1;
            break label182;
            return;
          }
        }
      }
    }
  }
  
  /* Error */
  public void initSSL()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 222
    //   3: invokestatic 227	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   6: putfield 229	com/tencent/moai/proxycat/ssl/SSLManager:ks	Ljava/security/KeyStore;
    //   9: aload_0
    //   10: ldc 222
    //   12: invokestatic 227	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   15: putfield 231	com/tencent/moai/proxycat/ssl/SSLManager:ts	Ljava/security/KeyStore;
    //   18: invokestatic 53	com/tencent/moai/proxycat/ProxyCatManager:getInstance	()Lcom/tencent/moai/proxycat/ProxyCatManager;
    //   21: invokevirtual 57	com/tencent/moai/proxycat/ProxyCatManager:getContext	()Landroid/content/Context;
    //   24: invokevirtual 63	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   27: astore_1
    //   28: ldc 233
    //   30: invokevirtual 239	java/lang/String:toCharArray	()[C
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 229	com/tencent/moai/proxycat/ssl/SSLManager:ks	Ljava/security/KeyStore;
    //   38: aload_1
    //   39: ldc 241
    //   41: invokevirtual 71	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   44: aload_2
    //   45: invokevirtual 245	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   48: aload_0
    //   49: getfield 231	com/tencent/moai/proxycat/ssl/SSLManager:ts	Ljava/security/KeyStore;
    //   52: aload_1
    //   53: ldc 247
    //   55: invokevirtual 71	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   58: aload_2
    //   59: invokevirtual 245	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   62: aload_0
    //   63: invokestatic 253	javax/net/ssl/KeyManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   66: invokestatic 256	javax/net/ssl/KeyManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/KeyManagerFactory;
    //   69: putfield 258	com/tencent/moai/proxycat/ssl/SSLManager:kmf	Ljavax/net/ssl/KeyManagerFactory;
    //   72: aload_0
    //   73: getfield 258	com/tencent/moai/proxycat/ssl/SSLManager:kmf	Ljavax/net/ssl/KeyManagerFactory;
    //   76: aload_0
    //   77: getfield 229	com/tencent/moai/proxycat/ssl/SSLManager:ks	Ljava/security/KeyStore;
    //   80: aload_2
    //   81: invokevirtual 262	javax/net/ssl/KeyManagerFactory:init	(Ljava/security/KeyStore;[C)V
    //   84: aload_0
    //   85: invokestatic 253	javax/net/ssl/KeyManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   88: invokestatic 267	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   91: putfield 269	com/tencent/moai/proxycat/ssl/SSLManager:tmf	Ljavax/net/ssl/TrustManagerFactory;
    //   94: aload_0
    //   95: getfield 269	com/tencent/moai/proxycat/ssl/SSLManager:tmf	Ljavax/net/ssl/TrustManagerFactory;
    //   98: aload_0
    //   99: getfield 231	com/tencent/moai/proxycat/ssl/SSLManager:ts	Ljava/security/KeyStore;
    //   102: invokevirtual 272	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   105: aload_0
    //   106: ldc_w 274
    //   109: invokestatic 279	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   112: putfield 281	com/tencent/moai/proxycat/ssl/SSLManager:sslContext	Ljavax/net/ssl/SSLContext;
    //   115: aload_0
    //   116: getfield 281	com/tencent/moai/proxycat/ssl/SSLManager:sslContext	Ljavax/net/ssl/SSLContext;
    //   119: aload_0
    //   120: getfield 258	com/tencent/moai/proxycat/ssl/SSLManager:kmf	Ljavax/net/ssl/KeyManagerFactory;
    //   123: invokevirtual 285	javax/net/ssl/KeyManagerFactory:getKeyManagers	()[Ljavax/net/ssl/KeyManager;
    //   126: aload_0
    //   127: getfield 269	com/tencent/moai/proxycat/ssl/SSLManager:tmf	Ljavax/net/ssl/TrustManagerFactory;
    //   130: invokevirtual 289	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   133: aconst_null
    //   134: invokevirtual 292	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 281	com/tencent/moai/proxycat/ssl/SSLManager:sslContext	Ljavax/net/ssl/SSLContext;
    //   142: invokevirtual 296	javax/net/ssl/SSLContext:createSSLEngine	()Ljavax/net/ssl/SSLEngine;
    //   145: putfield 106	com/tencent/moai/proxycat/ssl/SSLManager:sslEngine	Ljavax/net/ssl/SSLEngine;
    //   148: aload_0
    //   149: getfield 106	com/tencent/moai/proxycat/ssl/SSLManager:sslEngine	Ljavax/net/ssl/SSLEngine;
    //   152: iconst_0
    //   153: invokevirtual 300	javax/net/ssl/SSLEngine:setUseClientMode	(Z)V
    //   156: aload_0
    //   157: getfield 106	com/tencent/moai/proxycat/ssl/SSLManager:sslEngine	Ljavax/net/ssl/SSLEngine;
    //   160: iconst_1
    //   161: invokevirtual 303	javax/net/ssl/SSLEngine:setNeedClientAuth	(Z)V
    //   164: aload_0
    //   165: aload_0
    //   166: getfield 106	com/tencent/moai/proxycat/ssl/SSLManager:sslEngine	Ljavax/net/ssl/SSLEngine;
    //   169: invokevirtual 307	javax/net/ssl/SSLEngine:getSession	()Ljavax/net/ssl/SSLSession;
    //   172: putfield 309	com/tencent/moai/proxycat/ssl/SSLManager:sslSession	Ljavax/net/ssl/SSLSession;
    //   175: aload_0
    //   176: aload_0
    //   177: getfield 309	com/tencent/moai/proxycat/ssl/SSLManager:sslSession	Ljavax/net/ssl/SSLSession;
    //   180: invokeinterface 314 1 0
    //   185: putfield 158	com/tencent/moai/proxycat/ssl/SSLManager:appBufferMax	I
    //   188: aload_0
    //   189: aload_0
    //   190: getfield 309	com/tencent/moai/proxycat/ssl/SSLManager:sslSession	Ljavax/net/ssl/SSLSession;
    //   193: invokeinterface 317 1 0
    //   198: putfield 161	com/tencent/moai/proxycat/ssl/SSLManager:netBufferMax	I
    //   201: aload_0
    //   202: iconst_1
    //   203: putfield 319	com/tencent/moai/proxycat/ssl/SSLManager:isInit	Z
    //   206: return
    //   207: astore_1
    //   208: ldc 11
    //   210: aload_1
    //   211: invokestatic 209	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   214: invokestatic 134	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: return
    //   218: astore_1
    //   219: ldc 11
    //   221: aload_1
    //   222: invokestatic 209	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   225: invokestatic 134	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: return
    //   229: astore_1
    //   230: ldc 11
    //   232: aload_1
    //   233: invokestatic 209	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   236: invokestatic 134	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: return
    //   240: astore_1
    //   241: ldc 11
    //   243: aload_1
    //   244: invokestatic 209	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   247: invokestatic 134	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: return
    //   251: astore_1
    //   252: ldc 11
    //   254: aload_1
    //   255: invokestatic 209	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   258: invokestatic 134	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: return
    //   262: astore_1
    //   263: ldc 11
    //   265: aload_1
    //   266: invokestatic 209	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   269: invokestatic 134	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: return
    //   273: astore_1
    //   274: ldc 11
    //   276: aload_1
    //   277: invokestatic 209	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   280: invokestatic 134	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: return
    //   284: astore_1
    //   285: ldc 11
    //   287: aload_1
    //   288: invokestatic 209	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   291: invokestatic 134	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: return
    //   295: astore_1
    //   296: ldc 11
    //   298: aload_1
    //   299: invokestatic 209	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   302: invokestatic 134	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	SSLManager
    //   27	26	1	localAssetManager	AssetManager
    //   207	4	1	localKeyStoreException1	java.security.KeyStoreException
    //   218	4	1	localIOException	IOException
    //   229	4	1	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   240	4	1	localCertificateException	java.security.cert.CertificateException
    //   251	4	1	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   262	4	1	localKeyStoreException2	java.security.KeyStoreException
    //   273	4	1	localUnrecoverableKeyException	java.security.UnrecoverableKeyException
    //   284	4	1	localNoSuchAlgorithmException3	java.security.NoSuchAlgorithmException
    //   295	4	1	localKeyManagementException	java.security.KeyManagementException
    //   33	48	2	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   0	18	207	java/security/KeyStoreException
    //   34	62	218	java/io/IOException
    //   34	62	229	java/security/NoSuchAlgorithmException
    //   34	62	240	java/security/cert/CertificateException
    //   62	105	251	java/security/NoSuchAlgorithmException
    //   62	105	262	java/security/KeyStoreException
    //   62	105	273	java/security/UnrecoverableKeyException
    //   105	137	284	java/security/NoSuchAlgorithmException
    //   105	137	295	java/security/KeyManagementException
  }
  
  public boolean isInit()
  {
    return this.isInit;
  }
  
  /* Error */
  public void printCertificateInfo()
  {
    // Byte code:
    //   0: new 326	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: invokestatic 53	com/tencent/moai/proxycat/ProxyCatManager:getInstance	()Lcom/tencent/moai/proxycat/ProxyCatManager;
    //   11: invokevirtual 57	com/tencent/moai/proxycat/ProxyCatManager:getContext	()Landroid/content/Context;
    //   14: ldc 90
    //   16: invokestatic 331	android/security/KeyChain:getCertificateChain	(Landroid/content/Context;Ljava/lang/String;)[Ljava/security/cert/X509Certificate;
    //   19: astore 4
    //   21: aload 4
    //   23: ifnull +59 -> 82
    //   26: aload 4
    //   28: arraylength
    //   29: ifle +53 -> 82
    //   32: aload 4
    //   34: arraylength
    //   35: istore_2
    //   36: iconst_0
    //   37: istore_1
    //   38: iload_1
    //   39: iload_2
    //   40: if_icmpge +42 -> 82
    //   43: aload_3
    //   44: aload 4
    //   46: iload_1
    //   47: aaload
    //   48: invokevirtual 337	java/security/cert/X509Certificate:getIssuerDN	()Ljava/security/Principal;
    //   51: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: ldc_w 343
    //   59: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: iload_1
    //   64: iconst_1
    //   65: iadd
    //   66: istore_1
    //   67: goto -29 -> 38
    //   70: astore 4
    //   72: ldc 11
    //   74: aload 4
    //   76: invokestatic 209	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   79: invokestatic 134	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: ldc 11
    //   84: new 326	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 348
    //   94: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_3
    //   98: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 180	com/tencent/moai/proxycat/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: return
    //   111: astore 4
    //   113: ldc 11
    //   115: aload 4
    //   117: invokestatic 209	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   120: invokestatic 134	com/tencent/moai/proxycat/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: goto -41 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	SSLManager
    //   37	30	1	i	int
    //   35	6	2	j	int
    //   7	91	3	localStringBuilder	java.lang.StringBuilder
    //   19	26	4	arrayOfX509Certificate	java.security.cert.X509Certificate[]
    //   70	5	4	localKeyChainException	android.security.KeyChainException
    //   111	5	4	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   8	21	70	android/security/KeyChainException
    //   26	36	70	android/security/KeyChainException
    //   43	63	70	android/security/KeyChainException
    //   8	21	111	java/lang/InterruptedException
    //   26	36	111	java/lang/InterruptedException
    //   43	63	111	java/lang/InterruptedException
  }
  
  public static abstract interface HandShakeCallBack
  {
    public abstract SSLEngineResult.HandshakeStatus onFinished();
    
    public abstract SSLEngineResult.HandshakeStatus onNeedTask();
    
    public abstract SSLEngineResult.HandshakeStatus onNeedUnwrap()
      throws IOException;
    
    public abstract SSLEngineResult.HandshakeStatus onNeedWrap()
      throws IOException;
    
    public abstract SSLEngineResult.HandshakeStatus onNotHandShaking();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.ssl.SSLManager
 * JD-Core Version:    0.7.0.1
 */