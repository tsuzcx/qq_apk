package com.tencent.android.tpns.mqtt.internal.security;

import com.tencent.android.tpns.mqtt.MqttSecurityException;
import com.tencent.android.tpns.mqtt.logging.Logger;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class SSLSocketFactoryFactory
{
  public static final String CIPHERSUITES = "com.ibm.ssl.enabledCipherSuites";
  private static final String CLASS_NAME = "com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory";
  public static final String CLIENTAUTH = "com.ibm.ssl.clientAuthentication";
  public static final String DEFAULT_PROTOCOL = "TLS";
  public static final String JSSEPROVIDER = "com.ibm.ssl.contextProvider";
  public static final String KEYSTORE = "com.ibm.ssl.keyStore";
  public static final String KEYSTOREMGR = "com.ibm.ssl.keyManager";
  public static final String KEYSTOREPROVIDER = "com.ibm.ssl.keyStoreProvider";
  public static final String KEYSTOREPWD = "com.ibm.ssl.keyStorePassword";
  public static final String KEYSTORETYPE = "com.ibm.ssl.keyStoreType";
  public static final String SSLPROTOCOL = "com.ibm.ssl.protocol";
  public static final String SYSKEYMGRALGO = "ssl.KeyManagerFactory.algorithm";
  public static final String SYSKEYSTORE = "javax.net.ssl.keyStore";
  public static final String SYSKEYSTOREPWD = "javax.net.ssl.keyStorePassword";
  public static final String SYSKEYSTORETYPE = "javax.net.ssl.keyStoreType";
  public static final String SYSTRUSTMGRALGO = "ssl.TrustManagerFactory.algorithm";
  public static final String SYSTRUSTSTORE = "javax.net.ssl.trustStore";
  public static final String SYSTRUSTSTOREPWD = "javax.net.ssl.trustStorePassword";
  public static final String SYSTRUSTSTORETYPE = "javax.net.ssl.trustStoreType";
  public static final String TRUSTSTORE = "com.ibm.ssl.trustStore";
  public static final String TRUSTSTOREMGR = "com.ibm.ssl.trustManager";
  public static final String TRUSTSTOREPROVIDER = "com.ibm.ssl.trustStoreProvider";
  public static final String TRUSTSTOREPWD = "com.ibm.ssl.trustStorePassword";
  public static final String TRUSTSTORETYPE = "com.ibm.ssl.trustStoreType";
  private static final byte[] key = { -99, -89, -39, -128, 5, -72, -119, -100 };
  private static final String[] propertyKeys = { "com.ibm.ssl.protocol", "com.ibm.ssl.contextProvider", "com.ibm.ssl.keyStore", "com.ibm.ssl.keyStorePassword", "com.ibm.ssl.keyStoreType", "com.ibm.ssl.keyStoreProvider", "com.ibm.ssl.keyManager", "com.ibm.ssl.trustStore", "com.ibm.ssl.trustStorePassword", "com.ibm.ssl.trustStoreType", "com.ibm.ssl.trustStoreProvider", "com.ibm.ssl.trustManager", "com.ibm.ssl.enabledCipherSuites", "com.ibm.ssl.clientAuthentication" };
  private static final String xorTag = "{xor}";
  private Hashtable configs = new Hashtable();
  private Properties defaultProperties;
  private Logger logger = null;
  
  public SSLSocketFactoryFactory() {}
  
  public SSLSocketFactoryFactory(Logger paramLogger)
  {
    this();
    this.logger = paramLogger;
  }
  
  private void checkPropertyKeys(Properties paramProperties)
    throws IllegalArgumentException
  {
    paramProperties = paramProperties.keySet().iterator();
    while (paramProperties.hasNext())
    {
      String str = (String)paramProperties.next();
      if (!keyValid(str)) {
        throw new IllegalArgumentException(str + " is not a valid IBM SSL property key.");
      }
    }
  }
  
  private void convertPassword(Properties paramProperties)
  {
    String str = paramProperties.getProperty("com.ibm.ssl.keyStorePassword");
    if ((str != null) && (!str.startsWith("{xor}"))) {
      paramProperties.put("com.ibm.ssl.keyStorePassword", obfuscate(str.toCharArray()));
    }
    str = paramProperties.getProperty("com.ibm.ssl.trustStorePassword");
    if ((str != null) && (!str.startsWith("{xor}"))) {
      paramProperties.put("com.ibm.ssl.trustStorePassword", obfuscate(str.toCharArray()));
    }
  }
  
  public static char[] deObfuscate(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = SimpleBase64Encoder.decode(paramString.substring("{xor}".length()));
      int i = 0;
      while (i < paramString.length)
      {
        paramString[i] = ((byte)((paramString[i] ^ key[(i % key.length)]) & 0xFF));
        i += 1;
      }
      return toChar(paramString);
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  /* Error */
  private javax.net.ssl.KeyManager[] getKeyManagersForSSLContext(String paramString)
    throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException, MqttSecurityException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: aload_1
    //   5: ldc 23
    //   7: aconst_null
    //   8: invokespecial 229	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getProperty	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_3
    //   12: iconst_0
    //   13: ifne +610 -> 623
    //   16: aload_3
    //   17: astore_2
    //   18: aload_3
    //   19: ifnonnull +13 -> 32
    //   22: aload_0
    //   23: aload_1
    //   24: ldc 23
    //   26: ldc 44
    //   28: invokespecial 229	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getProperty	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   36: ifnull +48 -> 84
    //   39: aload_0
    //   40: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   43: astore 5
    //   45: aload_1
    //   46: ifnull +387 -> 433
    //   49: aload_1
    //   50: astore_3
    //   51: aload_2
    //   52: ifnull +388 -> 440
    //   55: aload_2
    //   56: astore 4
    //   58: aload 5
    //   60: ldc 11
    //   62: ldc 230
    //   64: ldc 232
    //   66: iconst_2
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload_3
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload 4
    //   78: aastore
    //   79: invokeinterface 238 5 0
    //   84: aload_0
    //   85: aload_1
    //   86: invokevirtual 241	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getKeyStorePassword	(Ljava/lang/String;)[C
    //   89: astore 7
    //   91: aload_0
    //   92: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   95: ifnull +53 -> 148
    //   98: aload_0
    //   99: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   102: astore 5
    //   104: aload_1
    //   105: ifnull +343 -> 448
    //   108: aload_1
    //   109: astore_3
    //   110: aload 7
    //   112: ifnull +343 -> 455
    //   115: aload 7
    //   117: invokestatic 182	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:obfuscate	([C)Ljava/lang/String;
    //   120: astore 4
    //   122: aload 5
    //   124: ldc 11
    //   126: ldc 230
    //   128: ldc 243
    //   130: iconst_2
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_3
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: aload 4
    //   142: aastore
    //   143: invokeinterface 238 5 0
    //   148: aload_0
    //   149: aload_1
    //   150: invokevirtual 246	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getKeyStoreType	(Ljava/lang/String;)Ljava/lang/String;
    //   153: astore 4
    //   155: aload 4
    //   157: astore_3
    //   158: aload 4
    //   160: ifnonnull +7 -> 167
    //   163: invokestatic 251	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   166: astore_3
    //   167: aload_0
    //   168: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   171: ifnull +50 -> 221
    //   174: aload_0
    //   175: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   178: astore 8
    //   180: aload_1
    //   181: ifnull +282 -> 463
    //   184: aload_1
    //   185: astore 4
    //   187: aload_3
    //   188: ifnull +283 -> 471
    //   191: aload_3
    //   192: astore 5
    //   194: aload 8
    //   196: ldc 11
    //   198: ldc 230
    //   200: ldc 253
    //   202: iconst_2
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload 4
    //   210: aastore
    //   211: dup
    //   212: iconst_1
    //   213: aload 5
    //   215: aastore
    //   216: invokeinterface 238 5 0
    //   221: invokestatic 258	javax/net/ssl/KeyManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   224: astore 4
    //   226: aload_0
    //   227: aload_1
    //   228: invokevirtual 261	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getKeyStoreProvider	(Ljava/lang/String;)Ljava/lang/String;
    //   231: astore 9
    //   233: aload_0
    //   234: aload_1
    //   235: invokevirtual 264	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getKeyManager	(Ljava/lang/String;)Ljava/lang/String;
    //   238: astore 5
    //   240: aload 5
    //   242: ifnull +7 -> 249
    //   245: aload 5
    //   247: astore 4
    //   249: aload_2
    //   250: ifnull +373 -> 623
    //   253: aload_3
    //   254: ifnull +369 -> 623
    //   257: aload 4
    //   259: ifnull +364 -> 623
    //   262: aload_3
    //   263: invokestatic 268	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   266: astore 8
    //   268: new 270	java/io/FileInputStream
    //   271: dup
    //   272: aload_2
    //   273: invokespecial 271	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   276: astore_2
    //   277: aload_2
    //   278: astore_3
    //   279: aload 8
    //   281: aload_2
    //   282: aload 7
    //   284: invokevirtual 275	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   287: aload 9
    //   289: ifnull +190 -> 479
    //   292: aload_2
    //   293: astore_3
    //   294: aload 4
    //   296: aload 9
    //   298: invokestatic 278	javax/net/ssl/KeyManagerFactory:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/KeyManagerFactory;
    //   301: astore 5
    //   303: aload_2
    //   304: astore_3
    //   305: aload_0
    //   306: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   309: ifnull +95 -> 404
    //   312: aload_2
    //   313: astore_3
    //   314: aload_0
    //   315: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   318: astore 9
    //   320: aload_1
    //   321: ifnull +304 -> 625
    //   324: aload_1
    //   325: astore 6
    //   327: aload_2
    //   328: astore_3
    //   329: aload 9
    //   331: ldc 11
    //   333: ldc 230
    //   335: ldc_w 280
    //   338: iconst_2
    //   339: anewarray 4	java/lang/Object
    //   342: dup
    //   343: iconst_0
    //   344: aload 6
    //   346: aastore
    //   347: dup
    //   348: iconst_1
    //   349: aload 4
    //   351: aastore
    //   352: invokeinterface 238 5 0
    //   357: aload_2
    //   358: astore_3
    //   359: aload_0
    //   360: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   363: astore 4
    //   365: aload_1
    //   366: ifnull +125 -> 491
    //   369: aload_2
    //   370: astore_3
    //   371: aload 4
    //   373: ldc 11
    //   375: ldc 230
    //   377: ldc_w 282
    //   380: iconst_2
    //   381: anewarray 4	java/lang/Object
    //   384: dup
    //   385: iconst_0
    //   386: aload_1
    //   387: aastore
    //   388: dup
    //   389: iconst_1
    //   390: aload 5
    //   392: invokevirtual 286	javax/net/ssl/KeyManagerFactory:getProvider	()Ljava/security/Provider;
    //   395: invokevirtual 291	java/security/Provider:getName	()Ljava/lang/String;
    //   398: aastore
    //   399: invokeinterface 238 5 0
    //   404: aload_2
    //   405: astore_3
    //   406: aload 5
    //   408: aload 8
    //   410: aload 7
    //   412: invokevirtual 295	javax/net/ssl/KeyManagerFactory:init	(Ljava/security/KeyStore;[C)V
    //   415: aload_2
    //   416: astore_3
    //   417: aload 5
    //   419: invokevirtual 299	javax/net/ssl/KeyManagerFactory:getKeyManagers	()[Ljavax/net/ssl/KeyManager;
    //   422: astore_1
    //   423: aload_2
    //   424: ifnull +7 -> 431
    //   427: aload_2
    //   428: invokevirtual 302	java/io/FileInputStream:close	()V
    //   431: aload_1
    //   432: areturn
    //   433: ldc_w 304
    //   436: astore_3
    //   437: goto -386 -> 51
    //   440: ldc_w 306
    //   443: astore 4
    //   445: goto -387 -> 58
    //   448: ldc_w 304
    //   451: astore_3
    //   452: goto -342 -> 110
    //   455: ldc_w 306
    //   458: astore 4
    //   460: goto -338 -> 122
    //   463: ldc_w 304
    //   466: astore 4
    //   468: goto -281 -> 187
    //   471: ldc_w 306
    //   474: astore 5
    //   476: goto -282 -> 194
    //   479: aload_2
    //   480: astore_3
    //   481: aload 4
    //   483: invokestatic 309	javax/net/ssl/KeyManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/KeyManagerFactory;
    //   486: astore 5
    //   488: goto -185 -> 303
    //   491: ldc_w 304
    //   494: astore_1
    //   495: goto -126 -> 369
    //   498: astore_1
    //   499: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   502: dup
    //   503: aload_1
    //   504: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   507: athrow
    //   508: astore_2
    //   509: aload 6
    //   511: astore_1
    //   512: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   515: dup
    //   516: aload_2
    //   517: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   520: athrow
    //   521: astore_2
    //   522: aload_1
    //   523: astore_3
    //   524: aload_2
    //   525: astore_1
    //   526: aload_3
    //   527: ifnull +7 -> 534
    //   530: aload_3
    //   531: invokevirtual 302	java/io/FileInputStream:close	()V
    //   534: aload_1
    //   535: athrow
    //   536: astore_1
    //   537: aconst_null
    //   538: astore_2
    //   539: aload_2
    //   540: astore_3
    //   541: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   544: dup
    //   545: aload_1
    //   546: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   549: athrow
    //   550: aload_2
    //   551: astore_3
    //   552: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   555: dup
    //   556: aload_1
    //   557: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   560: athrow
    //   561: aload_2
    //   562: astore_3
    //   563: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   566: dup
    //   567: aload_1
    //   568: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   571: athrow
    //   572: aload_2
    //   573: astore_3
    //   574: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   577: dup
    //   578: aload_1
    //   579: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   582: athrow
    //   583: astore_1
    //   584: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   587: dup
    //   588: aload_1
    //   589: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   592: athrow
    //   593: astore_1
    //   594: aconst_null
    //   595: astore_3
    //   596: goto -70 -> 526
    //   599: astore_1
    //   600: goto -28 -> 572
    //   603: astore_1
    //   604: goto -43 -> 561
    //   607: astore_1
    //   608: goto -58 -> 550
    //   611: astore_1
    //   612: goto -73 -> 539
    //   615: astore_3
    //   616: aload_2
    //   617: astore_1
    //   618: aload_3
    //   619: astore_2
    //   620: goto -108 -> 512
    //   623: aconst_null
    //   624: areturn
    //   625: ldc_w 304
    //   628: astore 6
    //   630: goto -303 -> 327
    //   633: astore_1
    //   634: goto -108 -> 526
    //   637: astore_1
    //   638: aconst_null
    //   639: astore_2
    //   640: goto -90 -> 550
    //   643: astore_1
    //   644: aconst_null
    //   645: astore_2
    //   646: goto -85 -> 561
    //   649: astore_1
    //   650: aconst_null
    //   651: astore_2
    //   652: goto -80 -> 572
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	655	0	this	SSLSocketFactoryFactory
    //   0	655	1	paramString	String
    //   17	463	2	localObject1	Object
    //   508	9	2	localKeyStoreException1	java.security.KeyStoreException
    //   521	4	2	localObject2	Object
    //   538	114	2	localKeyStoreException2	java.security.KeyStoreException
    //   11	585	3	localObject3	Object
    //   615	4	3	localKeyStoreException3	java.security.KeyStoreException
    //   56	426	4	localObject4	Object
    //   43	444	5	localObject5	Object
    //   1	628	6	str	String
    //   89	322	7	arrayOfChar	char[]
    //   178	231	8	localObject6	Object
    //   231	99	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   427	431	498	java/io/IOException
    //   262	277	508	java/security/KeyStoreException
    //   512	521	521	finally
    //   262	277	536	java/security/cert/CertificateException
    //   530	534	583	java/io/IOException
    //   262	277	593	finally
    //   279	287	599	java/security/UnrecoverableKeyException
    //   294	303	599	java/security/UnrecoverableKeyException
    //   305	312	599	java/security/UnrecoverableKeyException
    //   314	320	599	java/security/UnrecoverableKeyException
    //   329	357	599	java/security/UnrecoverableKeyException
    //   359	365	599	java/security/UnrecoverableKeyException
    //   371	404	599	java/security/UnrecoverableKeyException
    //   406	415	599	java/security/UnrecoverableKeyException
    //   417	423	599	java/security/UnrecoverableKeyException
    //   481	488	599	java/security/UnrecoverableKeyException
    //   279	287	603	java/io/IOException
    //   294	303	603	java/io/IOException
    //   305	312	603	java/io/IOException
    //   314	320	603	java/io/IOException
    //   329	357	603	java/io/IOException
    //   359	365	603	java/io/IOException
    //   371	404	603	java/io/IOException
    //   406	415	603	java/io/IOException
    //   417	423	603	java/io/IOException
    //   481	488	603	java/io/IOException
    //   279	287	607	java/io/FileNotFoundException
    //   294	303	607	java/io/FileNotFoundException
    //   305	312	607	java/io/FileNotFoundException
    //   314	320	607	java/io/FileNotFoundException
    //   329	357	607	java/io/FileNotFoundException
    //   359	365	607	java/io/FileNotFoundException
    //   371	404	607	java/io/FileNotFoundException
    //   406	415	607	java/io/FileNotFoundException
    //   417	423	607	java/io/FileNotFoundException
    //   481	488	607	java/io/FileNotFoundException
    //   279	287	611	java/security/cert/CertificateException
    //   294	303	611	java/security/cert/CertificateException
    //   305	312	611	java/security/cert/CertificateException
    //   314	320	611	java/security/cert/CertificateException
    //   329	357	611	java/security/cert/CertificateException
    //   359	365	611	java/security/cert/CertificateException
    //   371	404	611	java/security/cert/CertificateException
    //   406	415	611	java/security/cert/CertificateException
    //   417	423	611	java/security/cert/CertificateException
    //   481	488	611	java/security/cert/CertificateException
    //   279	287	615	java/security/KeyStoreException
    //   294	303	615	java/security/KeyStoreException
    //   305	312	615	java/security/KeyStoreException
    //   314	320	615	java/security/KeyStoreException
    //   329	357	615	java/security/KeyStoreException
    //   359	365	615	java/security/KeyStoreException
    //   371	404	615	java/security/KeyStoreException
    //   406	415	615	java/security/KeyStoreException
    //   417	423	615	java/security/KeyStoreException
    //   481	488	615	java/security/KeyStoreException
    //   279	287	633	finally
    //   294	303	633	finally
    //   305	312	633	finally
    //   314	320	633	finally
    //   329	357	633	finally
    //   359	365	633	finally
    //   371	404	633	finally
    //   406	415	633	finally
    //   417	423	633	finally
    //   481	488	633	finally
    //   541	550	633	finally
    //   552	561	633	finally
    //   563	572	633	finally
    //   574	583	633	finally
    //   262	277	637	java/io/FileNotFoundException
    //   262	277	643	java/io/IOException
    //   262	277	649	java/security/UnrecoverableKeyException
  }
  
  private String getProperty(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = getPropertyFromConfig(paramString1, paramString2);
    if (paramString1 != null) {}
    while (paramString3 == null) {
      return paramString1;
    }
    return System.getProperty(paramString3);
  }
  
  private String getPropertyFromConfig(String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (paramString1 = (Properties)this.configs.get(paramString1);; paramString1 = null)
    {
      Object localObject;
      if (paramString1 != null)
      {
        localObject = paramString1.getProperty(paramString2);
        paramString1 = (String)localObject;
        if (localObject == null) {
          break label38;
        }
        paramString1 = (String)localObject;
      }
      label38:
      do
      {
        do
        {
          return paramString1;
          paramString1 = null;
          localObject = this.defaultProperties;
        } while (localObject == null);
        paramString2 = ((Properties)localObject).getProperty(paramString2);
        paramString1 = paramString2;
      } while (paramString2 == null);
      return paramString2;
    }
  }
  
  /* Error */
  private SSLContext getSSLContext(String paramString)
    throws MqttSecurityException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 332	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getSSLProtocol	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_3
    //   6: aload_3
    //   7: astore_2
    //   8: aload_3
    //   9: ifnonnull +6 -> 15
    //   12: ldc 17
    //   14: astore_2
    //   15: aload_0
    //   16: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   19: ifnull +42 -> 61
    //   22: aload_0
    //   23: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   26: astore 4
    //   28: aload_1
    //   29: ifnull +116 -> 145
    //   32: aload_1
    //   33: astore_3
    //   34: aload 4
    //   36: ldc 11
    //   38: ldc_w 333
    //   41: ldc_w 335
    //   44: iconst_2
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_3
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: aload_2
    //   55: aastore
    //   56: invokeinterface 238 5 0
    //   61: aload_0
    //   62: aload_1
    //   63: invokevirtual 338	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getJSSEProvider	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_3
    //   67: aload_3
    //   68: ifnonnull +84 -> 152
    //   71: aload_2
    //   72: invokestatic 342	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   75: astore_2
    //   76: aload_0
    //   77: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   80: ifnull +48 -> 128
    //   83: aload_0
    //   84: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   87: astore 4
    //   89: aload_1
    //   90: ifnull +71 -> 161
    //   93: aload_1
    //   94: astore_3
    //   95: aload 4
    //   97: ldc 11
    //   99: ldc_w 333
    //   102: ldc_w 344
    //   105: iconst_2
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload_3
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: aload_2
    //   116: invokevirtual 345	javax/net/ssl/SSLContext:getProvider	()Ljava/security/Provider;
    //   119: invokevirtual 291	java/security/Provider:getName	()Ljava/lang/String;
    //   122: aastore
    //   123: invokeinterface 238 5 0
    //   128: aload_2
    //   129: aload_0
    //   130: aload_1
    //   131: invokespecial 347	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getKeyManagersForSSLContext	(Ljava/lang/String;)[Ljavax/net/ssl/KeyManager;
    //   134: aload_0
    //   135: aload_1
    //   136: invokespecial 351	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getTrustManagersForSSLContext	(Ljava/lang/String;)[Ljavax/net/ssl/TrustManager;
    //   139: aconst_null
    //   140: invokevirtual 354	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   143: aload_2
    //   144: areturn
    //   145: ldc_w 304
    //   148: astore_3
    //   149: goto -115 -> 34
    //   152: aload_2
    //   153: aload_3
    //   154: invokestatic 357	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   157: astore_2
    //   158: goto -82 -> 76
    //   161: ldc_w 304
    //   164: astore_3
    //   165: goto -70 -> 95
    //   168: astore_1
    //   169: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   172: dup
    //   173: aload_1
    //   174: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   177: athrow
    //   178: astore_1
    //   179: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   182: dup
    //   183: aload_1
    //   184: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   187: athrow
    //   188: astore_1
    //   189: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   192: dup
    //   193: aload_1
    //   194: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	SSLSocketFactoryFactory
    //   0	198	1	paramString	String
    //   7	151	2	localObject	Object
    //   5	160	3	str	String
    //   26	70	4	localLogger	Logger
    // Exception table:
    //   from	to	target	type
    //   71	76	168	java/security/NoSuchAlgorithmException
    //   76	89	168	java/security/NoSuchAlgorithmException
    //   95	128	168	java/security/NoSuchAlgorithmException
    //   128	143	168	java/security/NoSuchAlgorithmException
    //   152	158	168	java/security/NoSuchAlgorithmException
    //   71	76	178	java/security/NoSuchProviderException
    //   76	89	178	java/security/NoSuchProviderException
    //   95	128	178	java/security/NoSuchProviderException
    //   128	143	178	java/security/NoSuchProviderException
    //   152	158	178	java/security/NoSuchProviderException
    //   71	76	188	java/security/KeyManagementException
    //   76	89	188	java/security/KeyManagementException
    //   95	128	188	java/security/KeyManagementException
    //   128	143	188	java/security/KeyManagementException
    //   152	158	188	java/security/KeyManagementException
  }
  
  /* Error */
  private javax.net.ssl.TrustManager[] getTrustManagersForSSLContext(String paramString)
    throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException, MqttSecurityException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 360	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getTrustStore	(Ljava/lang/String;)Ljava/lang/String;
    //   8: astore 6
    //   10: aload_0
    //   11: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   14: ifnull +50 -> 64
    //   17: aload_0
    //   18: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   21: astore 4
    //   23: aload_1
    //   24: ifnull +385 -> 409
    //   27: aload_1
    //   28: astore_2
    //   29: aload 6
    //   31: ifnull +385 -> 416
    //   34: aload 6
    //   36: astore_3
    //   37: aload 4
    //   39: ldc 11
    //   41: ldc_w 361
    //   44: ldc_w 363
    //   47: iconst_2
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload_2
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: aload_3
    //   58: aastore
    //   59: invokeinterface 238 5 0
    //   64: aload_0
    //   65: aload_1
    //   66: invokevirtual 366	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getTrustStorePassword	(Ljava/lang/String;)[C
    //   69: astore 7
    //   71: aload_0
    //   72: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   75: ifnull +53 -> 128
    //   78: aload_0
    //   79: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   82: astore 4
    //   84: aload_1
    //   85: ifnull +338 -> 423
    //   88: aload_1
    //   89: astore_2
    //   90: aload 7
    //   92: ifnull +338 -> 430
    //   95: aload 7
    //   97: invokestatic 182	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:obfuscate	([C)Ljava/lang/String;
    //   100: astore_3
    //   101: aload 4
    //   103: ldc 11
    //   105: ldc_w 361
    //   108: ldc_w 368
    //   111: iconst_2
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload_2
    //   118: aastore
    //   119: dup
    //   120: iconst_1
    //   121: aload_3
    //   122: aastore
    //   123: invokeinterface 238 5 0
    //   128: aload_0
    //   129: aload_1
    //   130: invokevirtual 371	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getTrustStoreType	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_3
    //   134: aload_3
    //   135: astore_2
    //   136: aload_3
    //   137: ifnonnull +7 -> 144
    //   140: invokestatic 251	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   143: astore_2
    //   144: aload_0
    //   145: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   148: ifnull +50 -> 198
    //   151: aload_0
    //   152: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   155: astore 8
    //   157: aload_1
    //   158: ifnull +279 -> 437
    //   161: aload_1
    //   162: astore_3
    //   163: aload_2
    //   164: ifnull +280 -> 444
    //   167: aload_2
    //   168: astore 4
    //   170: aload 8
    //   172: ldc 11
    //   174: ldc_w 361
    //   177: ldc_w 373
    //   180: iconst_2
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: aload_3
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: aload 4
    //   192: aastore
    //   193: invokeinterface 238 5 0
    //   198: invokestatic 376	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   201: astore 4
    //   203: aload_0
    //   204: aload_1
    //   205: invokevirtual 379	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getTrustStoreProvider	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 9
    //   210: aload_0
    //   211: aload_1
    //   212: invokevirtual 382	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getTrustManager	(Ljava/lang/String;)Ljava/lang/String;
    //   215: astore_3
    //   216: aload_3
    //   217: ifnull +6 -> 223
    //   220: aload_3
    //   221: astore 4
    //   223: aload 6
    //   225: ifnull +356 -> 581
    //   228: aload_2
    //   229: ifnull +352 -> 581
    //   232: aload 4
    //   234: ifnull +347 -> 581
    //   237: aload_2
    //   238: invokestatic 268	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   241: astore 8
    //   243: new 270	java/io/FileInputStream
    //   246: dup
    //   247: aload 6
    //   249: invokespecial 271	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   252: astore_2
    //   253: aload_2
    //   254: astore_3
    //   255: aload 8
    //   257: aload_2
    //   258: aload 7
    //   260: invokevirtual 275	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   263: aload 9
    //   265: ifnull +187 -> 452
    //   268: aload_2
    //   269: astore_3
    //   270: aload 4
    //   272: aload 9
    //   274: invokestatic 385	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   277: astore 5
    //   279: aload_2
    //   280: astore_3
    //   281: aload_0
    //   282: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   285: ifnull +97 -> 382
    //   288: aload_2
    //   289: astore_3
    //   290: aload_0
    //   291: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   294: astore 7
    //   296: aload_1
    //   297: ifnull +286 -> 583
    //   300: aload_1
    //   301: astore 6
    //   303: aload_2
    //   304: astore_3
    //   305: aload 7
    //   307: ldc 11
    //   309: ldc_w 361
    //   312: ldc_w 387
    //   315: iconst_2
    //   316: anewarray 4	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: aload 6
    //   323: aastore
    //   324: dup
    //   325: iconst_1
    //   326: aload 4
    //   328: aastore
    //   329: invokeinterface 238 5 0
    //   334: aload_2
    //   335: astore_3
    //   336: aload_0
    //   337: getfield 112	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:logger	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   340: astore 4
    //   342: aload_1
    //   343: ifnull +121 -> 464
    //   346: aload_2
    //   347: astore_3
    //   348: aload 4
    //   350: ldc 11
    //   352: ldc_w 361
    //   355: ldc_w 389
    //   358: iconst_2
    //   359: anewarray 4	java/lang/Object
    //   362: dup
    //   363: iconst_0
    //   364: aload_1
    //   365: aastore
    //   366: dup
    //   367: iconst_1
    //   368: aload 5
    //   370: invokevirtual 390	javax/net/ssl/TrustManagerFactory:getProvider	()Ljava/security/Provider;
    //   373: invokevirtual 291	java/security/Provider:getName	()Ljava/lang/String;
    //   376: aastore
    //   377: invokeinterface 238 5 0
    //   382: aload_2
    //   383: astore_3
    //   384: aload 5
    //   386: aload 8
    //   388: invokevirtual 393	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   391: aload_2
    //   392: astore_3
    //   393: aload 5
    //   395: invokevirtual 397	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   398: astore_1
    //   399: aload_2
    //   400: ifnull +7 -> 407
    //   403: aload_2
    //   404: invokevirtual 302	java/io/FileInputStream:close	()V
    //   407: aload_1
    //   408: areturn
    //   409: ldc_w 304
    //   412: astore_2
    //   413: goto -384 -> 29
    //   416: ldc_w 306
    //   419: astore_3
    //   420: goto -383 -> 37
    //   423: ldc_w 304
    //   426: astore_2
    //   427: goto -337 -> 90
    //   430: ldc_w 306
    //   433: astore_3
    //   434: goto -333 -> 101
    //   437: ldc_w 304
    //   440: astore_3
    //   441: goto -278 -> 163
    //   444: ldc_w 306
    //   447: astore 4
    //   449: goto -279 -> 170
    //   452: aload_2
    //   453: astore_3
    //   454: aload 4
    //   456: invokestatic 400	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   459: astore 5
    //   461: goto -182 -> 279
    //   464: ldc_w 304
    //   467: astore_1
    //   468: goto -122 -> 346
    //   471: astore_1
    //   472: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   475: dup
    //   476: aload_1
    //   477: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   480: athrow
    //   481: astore_2
    //   482: aload 5
    //   484: astore_1
    //   485: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   488: dup
    //   489: aload_2
    //   490: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   493: athrow
    //   494: astore_2
    //   495: aload_1
    //   496: astore_3
    //   497: aload_2
    //   498: astore_1
    //   499: aload_3
    //   500: ifnull +7 -> 507
    //   503: aload_3
    //   504: invokevirtual 302	java/io/FileInputStream:close	()V
    //   507: aload_1
    //   508: athrow
    //   509: astore_1
    //   510: aconst_null
    //   511: astore_2
    //   512: aload_2
    //   513: astore_3
    //   514: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   517: dup
    //   518: aload_1
    //   519: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   522: athrow
    //   523: aload_2
    //   524: astore_3
    //   525: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   528: dup
    //   529: aload_1
    //   530: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   533: athrow
    //   534: aload_2
    //   535: astore_3
    //   536: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   539: dup
    //   540: aload_1
    //   541: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   544: athrow
    //   545: astore_1
    //   546: new 216	com/tencent/android/tpns/mqtt/MqttSecurityException
    //   549: dup
    //   550: aload_1
    //   551: invokespecial 312	com/tencent/android/tpns/mqtt/MqttSecurityException:<init>	(Ljava/lang/Throwable;)V
    //   554: athrow
    //   555: astore_1
    //   556: aconst_null
    //   557: astore_3
    //   558: goto -59 -> 499
    //   561: astore_1
    //   562: goto -28 -> 534
    //   565: astore_1
    //   566: goto -43 -> 523
    //   569: astore_1
    //   570: goto -58 -> 512
    //   573: astore_3
    //   574: aload_2
    //   575: astore_1
    //   576: aload_3
    //   577: astore_2
    //   578: goto -93 -> 485
    //   581: aconst_null
    //   582: areturn
    //   583: ldc_w 304
    //   586: astore 6
    //   588: goto -285 -> 303
    //   591: astore_1
    //   592: goto -93 -> 499
    //   595: astore_1
    //   596: aconst_null
    //   597: astore_2
    //   598: goto -75 -> 523
    //   601: astore_1
    //   602: aconst_null
    //   603: astore_2
    //   604: goto -70 -> 534
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	607	0	this	SSLSocketFactoryFactory
    //   0	607	1	paramString	String
    //   28	425	2	localObject1	Object
    //   481	9	2	localKeyStoreException1	java.security.KeyStoreException
    //   494	4	2	localObject2	Object
    //   511	93	2	localObject3	Object
    //   36	522	3	localObject4	Object
    //   573	4	3	localKeyStoreException2	java.security.KeyStoreException
    //   21	434	4	localObject5	Object
    //   1	482	5	localTrustManagerFactory	javax.net.ssl.TrustManagerFactory
    //   8	579	6	str1	String
    //   69	237	7	localObject6	Object
    //   155	232	8	localObject7	Object
    //   208	65	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   403	407	471	java/io/IOException
    //   237	253	481	java/security/KeyStoreException
    //   485	494	494	finally
    //   237	253	509	java/security/cert/CertificateException
    //   503	507	545	java/io/IOException
    //   237	253	555	finally
    //   255	263	561	java/io/IOException
    //   270	279	561	java/io/IOException
    //   281	288	561	java/io/IOException
    //   290	296	561	java/io/IOException
    //   305	334	561	java/io/IOException
    //   336	342	561	java/io/IOException
    //   348	382	561	java/io/IOException
    //   384	391	561	java/io/IOException
    //   393	399	561	java/io/IOException
    //   454	461	561	java/io/IOException
    //   255	263	565	java/io/FileNotFoundException
    //   270	279	565	java/io/FileNotFoundException
    //   281	288	565	java/io/FileNotFoundException
    //   290	296	565	java/io/FileNotFoundException
    //   305	334	565	java/io/FileNotFoundException
    //   336	342	565	java/io/FileNotFoundException
    //   348	382	565	java/io/FileNotFoundException
    //   384	391	565	java/io/FileNotFoundException
    //   393	399	565	java/io/FileNotFoundException
    //   454	461	565	java/io/FileNotFoundException
    //   255	263	569	java/security/cert/CertificateException
    //   270	279	569	java/security/cert/CertificateException
    //   281	288	569	java/security/cert/CertificateException
    //   290	296	569	java/security/cert/CertificateException
    //   305	334	569	java/security/cert/CertificateException
    //   336	342	569	java/security/cert/CertificateException
    //   348	382	569	java/security/cert/CertificateException
    //   384	391	569	java/security/cert/CertificateException
    //   393	399	569	java/security/cert/CertificateException
    //   454	461	569	java/security/cert/CertificateException
    //   255	263	573	java/security/KeyStoreException
    //   270	279	573	java/security/KeyStoreException
    //   281	288	573	java/security/KeyStoreException
    //   290	296	573	java/security/KeyStoreException
    //   305	334	573	java/security/KeyStoreException
    //   336	342	573	java/security/KeyStoreException
    //   348	382	573	java/security/KeyStoreException
    //   384	391	573	java/security/KeyStoreException
    //   393	399	573	java/security/KeyStoreException
    //   454	461	573	java/security/KeyStoreException
    //   255	263	591	finally
    //   270	279	591	finally
    //   281	288	591	finally
    //   290	296	591	finally
    //   305	334	591	finally
    //   336	342	591	finally
    //   348	382	591	finally
    //   384	391	591	finally
    //   393	399	591	finally
    //   454	461	591	finally
    //   514	523	591	finally
    //   525	534	591	finally
    //   536	545	591	finally
    //   237	253	595	java/io/FileNotFoundException
    //   237	253	601	java/io/IOException
  }
  
  public static boolean isSupportedOnJVM()
    throws LinkageError, ExceptionInInitializerError
  {
    try
    {
      Class.forName("javax.net.ssl.SSLServerSocketFactory");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  private boolean keyValid(String paramString)
  {
    boolean bool = false;
    int i = 0;
    for (;;)
    {
      if ((i >= propertyKeys.length) || (propertyKeys[i].equals(paramString)))
      {
        if (i < propertyKeys.length) {
          bool = true;
        }
        return bool;
      }
      i += 1;
    }
  }
  
  public static String obfuscate(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    paramArrayOfChar = toByte(paramArrayOfChar);
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      paramArrayOfChar[i] = ((byte)((paramArrayOfChar[i] ^ key[(i % key.length)]) & 0xFF));
      i += 1;
    }
    return "{xor}" + new String(SimpleBase64Encoder.encode(paramArrayOfChar));
  }
  
  public static String packCipherSuites(String[] paramArrayOfString)
  {
    Object localObject = null;
    if (paramArrayOfString != null)
    {
      localObject = new StringBuffer();
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        ((StringBuffer)localObject).append(paramArrayOfString[i]);
        if (i < paramArrayOfString.length - 1) {
          ((StringBuffer)localObject).append(',');
        }
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
    }
    return localObject;
  }
  
  public static byte[] toByte(char[] paramArrayOfChar)
  {
    int i = 0;
    if (paramArrayOfChar == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfChar.length * 2];
    int k;
    for (int j = 0; i < paramArrayOfChar.length; j = k + 1)
    {
      k = j + 1;
      arrayOfByte[j] = ((byte)(paramArrayOfChar[i] & 0xFF));
      arrayOfByte[k] = ((byte)(paramArrayOfChar[i] >> '\b' & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static char[] toChar(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length / 2];
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      int k = j + 1;
      int m = paramArrayOfByte[j];
      j = k + 1;
      arrayOfChar[i] = ((char)(((paramArrayOfByte[k] & 0xFF) << 8) + (m & 0xFF)));
      i += 1;
    }
    return arrayOfChar;
  }
  
  public static String[] unpackCipherSuites(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Vector localVector = new Vector();
    int j = paramString.indexOf(',');
    int i = 0;
    while (j > -1)
    {
      localVector.add(paramString.substring(i, j));
      i = j + 1;
      j = paramString.indexOf(',', i);
    }
    localVector.add(paramString.substring(i));
    paramString = new String[localVector.size()];
    localVector.toArray(paramString);
    return paramString;
  }
  
  public SSLSocketFactory createSocketFactory(String paramString)
    throws MqttSecurityException
  {
    SSLContext localSSLContext = getSSLContext(paramString);
    Logger localLogger;
    String str;
    if (this.logger != null)
    {
      localLogger = this.logger;
      if (paramString == null) {
        break label74;
      }
      str = paramString;
      if (getEnabledCipherSuites(paramString) == null) {
        break label81;
      }
    }
    label74:
    label81:
    for (paramString = getProperty(paramString, "com.ibm.ssl.enabledCipherSuites", null);; paramString = "null (using platform-enabled cipher suites)")
    {
      localLogger.fine("com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory", "createSocketFactory", "12020", new Object[] { str, paramString });
      return localSSLContext.getSocketFactory();
      str = "null (broker defaults)";
      break;
    }
  }
  
  public boolean getClientAuthentication(String paramString)
  {
    paramString = getProperty(paramString, "com.ibm.ssl.clientAuthentication", null);
    boolean bool = false;
    if (paramString != null) {
      bool = Boolean.valueOf(paramString).booleanValue();
    }
    return bool;
  }
  
  public Properties getConfiguration(String paramString)
  {
    if (paramString == null) {}
    for (paramString = this.defaultProperties;; paramString = this.configs.get(paramString)) {
      return (Properties)paramString;
    }
  }
  
  public String[] getEnabledCipherSuites(String paramString)
  {
    return unpackCipherSuites(getProperty(paramString, "com.ibm.ssl.enabledCipherSuites", null));
  }
  
  public String getJSSEProvider(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.contextProvider", null);
  }
  
  public String getKeyManager(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.keyManager", "ssl.KeyManagerFactory.algorithm");
  }
  
  public String getKeyStore(String paramString)
  {
    paramString = getPropertyFromConfig(paramString, "com.ibm.ssl.keyStore");
    if (paramString != null) {}
    while ("javax.net.ssl.keyStore" == null) {
      return paramString;
    }
    return System.getProperty("javax.net.ssl.keyStore");
  }
  
  public char[] getKeyStorePassword(String paramString)
  {
    String str = getProperty(paramString, "com.ibm.ssl.keyStorePassword", "javax.net.ssl.keyStorePassword");
    paramString = null;
    if (str != null)
    {
      if (str.startsWith("{xor}")) {
        paramString = deObfuscate(str);
      }
    }
    else {
      return paramString;
    }
    return str.toCharArray();
  }
  
  public String getKeyStoreProvider(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.keyStoreProvider", null);
  }
  
  public String getKeyStoreType(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.keyStoreType", "javax.net.ssl.keyStoreType");
  }
  
  public String getSSLProtocol(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.protocol", null);
  }
  
  public String getTrustManager(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.trustManager", "ssl.TrustManagerFactory.algorithm");
  }
  
  public String getTrustStore(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.trustStore", "javax.net.ssl.trustStore");
  }
  
  public char[] getTrustStorePassword(String paramString)
  {
    String str = getProperty(paramString, "com.ibm.ssl.trustStorePassword", "javax.net.ssl.trustStorePassword");
    paramString = null;
    if (str != null)
    {
      if (str.startsWith("{xor}")) {
        paramString = deObfuscate(str);
      }
    }
    else {
      return paramString;
    }
    return str.toCharArray();
  }
  
  public String getTrustStoreProvider(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.trustStoreProvider", null);
  }
  
  public String getTrustStoreType(String paramString)
  {
    return getProperty(paramString, "com.ibm.ssl.trustStoreType", null);
  }
  
  public void initialize(Properties paramProperties, String paramString)
    throws IllegalArgumentException
  {
    checkPropertyKeys(paramProperties);
    Properties localProperties = new Properties();
    localProperties.putAll(paramProperties);
    convertPassword(localProperties);
    if (paramString != null)
    {
      this.configs.put(paramString, localProperties);
      return;
    }
    this.defaultProperties = localProperties;
  }
  
  public void merge(Properties paramProperties, String paramString)
    throws IllegalArgumentException
  {
    checkPropertyKeys(paramProperties);
    Properties localProperties1 = this.defaultProperties;
    if (paramString != null) {
      localProperties1 = (Properties)this.configs.get(paramString);
    }
    Properties localProperties2 = localProperties1;
    if (localProperties1 == null) {
      localProperties2 = new Properties();
    }
    convertPassword(paramProperties);
    localProperties2.putAll(paramProperties);
    if (paramString != null)
    {
      this.configs.put(paramString, localProperties2);
      return;
    }
    this.defaultProperties = localProperties2;
  }
  
  public boolean remove(String paramString)
  {
    if (paramString != null) {
      return this.configs.remove(paramString) != null;
    }
    if (this.defaultProperties != null)
    {
      this.defaultProperties = null;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory
 * JD-Core Version:    0.7.0.1
 */