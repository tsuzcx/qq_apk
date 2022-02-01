package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.internal.ConnectActionListener;
import com.tencent.android.tpns.mqtt.internal.DisconnectedMessageBuffer;
import com.tencent.android.tpns.mqtt.internal.ExceptionHelper;
import com.tencent.android.tpns.mqtt.internal.NetworkModule;
import com.tencent.android.tpns.mqtt.internal.Token;
import com.tencent.android.tpns.mqtt.internal.wire.MqttDisconnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPingReq;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.internal.wire.MqttSubscribe;
import com.tencent.android.tpns.mqtt.internal.wire.MqttUnsubscribe;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.android.tpns.mqtt.persist.MemoryPersistence;
import com.tencent.android.tpns.mqtt.persist.MqttDefaultFilePersistence;
import com.tencent.android.tpns.mqtt.util.Debug;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class MqttAsyncClient
  implements IMqttAsyncClient
{
  private static final String CLASS_NAME = "MqttAsyncClient";
  private static final String CLIENT_ID_PREFIX = "paho";
  private static final long DISCONNECT_TIMEOUT = 10000L;
  private static final char MAX_HIGH_SURROGATE = 'í¯¿';
  private static final char MIN_HIGH_SURROGATE = 'í €';
  private static final long QUIESCE_TIMEOUT = 30000L;
  private static final String TAG = "MqttAsyncClient";
  private static Object clientLock = new Object();
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "MqttAsyncClient");
  private static int reconnectDelay = 1000;
  private String clientId;
  protected ClientComms comms;
  private MqttConnectOptions connOpts;
  private ScheduledExecutorService executorService;
  private MqttCallback mqttCallback;
  private MqttClientPersistence persistence;
  private Timer reconnectTimer;
  private boolean reconnecting = false;
  private String serverURI;
  private Hashtable topics;
  private Object userContext;
  
  public MqttAsyncClient(String paramString1, String paramString2)
    throws MqttException
  {
    this(paramString1, paramString2, new MqttDefaultFilePersistence());
  }
  
  public MqttAsyncClient(String paramString1, String paramString2, MqttClientPersistence paramMqttClientPersistence)
    throws MqttException
  {
    this(paramString1, paramString2, paramMqttClientPersistence, new TimerPingSender());
  }
  
  public MqttAsyncClient(String paramString1, String paramString2, MqttClientPersistence paramMqttClientPersistence, MqttPingSender paramMqttPingSender)
    throws MqttException
  {
    this(paramString1, paramString2, paramMqttClientPersistence, paramMqttPingSender, null);
  }
  
  public MqttAsyncClient(String paramString1, String paramString2, MqttClientPersistence paramMqttClientPersistence, MqttPingSender paramMqttPingSender, ScheduledExecutorService paramScheduledExecutorService)
    throws MqttException
  {
    TBaseLogger.d("MqttAsyncClient", "init MqttAsyncClient");
    log.setResourceName(paramString2);
    if (paramString2 == null) {
      throw new IllegalArgumentException("Null clientId");
    }
    int i = 0;
    int j = 0;
    while (i < paramString2.length() - 1)
    {
      int k = i;
      if (Character_isHighSurrogate(paramString2.charAt(i))) {
        k = i + 1;
      }
      j += 1;
      i = k + 1;
    }
    if (j > 65535) {
      throw new IllegalArgumentException("ClientId longer than 65535 characters");
    }
    MqttConnectOptions.validateURI(paramString1);
    this.serverURI = paramString1;
    this.clientId = paramString2;
    this.persistence = paramMqttClientPersistence;
    if (this.persistence == null) {
      this.persistence = new MemoryPersistence();
    }
    this.executorService = paramScheduledExecutorService;
    if (this.executorService == null) {
      this.executorService = Executors.newScheduledThreadPool(10);
    }
    log.fine("MqttAsyncClient", "MqttAsyncClient", "101", new Object[] { paramString2, paramString1, paramMqttClientPersistence });
    this.persistence.open(paramString2, paramString1);
    this.comms = new ClientComms(this, this.persistence, paramMqttPingSender, this.executorService);
    this.persistence.close();
    this.topics = new Hashtable();
  }
  
  protected static boolean Character_isHighSurrogate(char paramChar)
  {
    return (paramChar >= 55296) && (paramChar <= 56319);
  }
  
  private void attemptReconnect()
  {
    log.fine("MqttAsyncClient", "attemptReconnect", "500", new Object[] { this.clientId });
    try
    {
      connect(this.connOpts, this.userContext, new MqttReconnectActionListener("attemptReconnect"));
      return;
    }
    catch (MqttSecurityException localMqttSecurityException)
    {
      log.fine("MqttAsyncClient", "attemptReconnect", "804", null, localMqttSecurityException);
      return;
    }
    catch (MqttException localMqttException)
    {
      TBaseLogger.e("MqttAsyncClient", "attemptReconnect", localMqttException);
    }
  }
  
  /* Error */
  private NetworkModule createNetworkModule(String paramString, MqttConnectOptions paramMqttConnectOptions)
    throws MqttException, MqttSecurityException
  {
    // Byte code:
    //   0: getstatic 72	com/tencent/android/tpns/mqtt/MqttAsyncClient:log	Lcom/tencent/android/tpns/mqtt/logging/Logger;
    //   3: ldc 19
    //   5: ldc 252
    //   7: ldc 254
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: invokeinterface 166 5 0
    //   22: aload_2
    //   23: invokevirtual 258	com/tencent/android/tpns/mqtt/MqttConnectOptions:getSocketFactory	()Ljavax/net/SocketFactory;
    //   26: astore 6
    //   28: aload_1
    //   29: invokestatic 143	com/tencent/android/tpns/mqtt/MqttConnectOptions:validateURI	(Ljava/lang/String;)I
    //   32: istore 4
    //   34: new 260	java/net/URI
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 261	java/net/URI:<init>	(Ljava/lang/String;)V
    //   42: astore 7
    //   44: aload 7
    //   46: invokevirtual 265	java/net/URI:getHost	()Ljava/lang/String;
    //   49: ifnonnull +59 -> 108
    //   52: aload_1
    //   53: ldc_w 267
    //   56: invokevirtual 271	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   59: istore 5
    //   61: iload 5
    //   63: ifeq +45 -> 108
    //   66: ldc_w 260
    //   69: ldc_w 273
    //   72: invokevirtual 279	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   75: astore 8
    //   77: aload 8
    //   79: iconst_1
    //   80: invokevirtual 285	java/lang/reflect/Field:setAccessible	(Z)V
    //   83: aload 8
    //   85: aload 7
    //   87: aload_0
    //   88: aload_1
    //   89: aload 7
    //   91: invokevirtual 288	java/net/URI:getScheme	()Ljava/lang/String;
    //   94: invokevirtual 126	java/lang/String:length	()I
    //   97: iconst_3
    //   98: iadd
    //   99: invokevirtual 292	java/lang/String:substring	(I)Ljava/lang/String;
    //   102: invokespecial 296	com/tencent/android/tpns/mqtt/MqttAsyncClient:getHostName	(Ljava/lang/String;)Ljava/lang/String;
    //   105: invokevirtual 300	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   108: aload 7
    //   110: invokevirtual 265	java/net/URI:getHost	()Ljava/lang/String;
    //   113: astore 9
    //   115: aload 7
    //   117: invokevirtual 303	java/net/URI:getPort	()I
    //   120: istore_3
    //   121: iload 4
    //   123: tableswitch	default:+33 -> 156, 0:+111->234, 1:+181->304, 2:+33->156, 3:+325->448, 4:+394->517
    //   157: nop
    //   158: dstore_1
    //   159: ldc 19
    //   161: ldc 252
    //   163: ldc_w 305
    //   166: iconst_1
    //   167: anewarray 4	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload_1
    //   173: aastore
    //   174: invokeinterface 166 5 0
    //   179: aconst_null
    //   180: astore_2
    //   181: aload_2
    //   182: areturn
    //   183: astore_2
    //   184: aload_2
    //   185: invokevirtual 311	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   188: invokestatic 317	com/tencent/android/tpns/mqtt/internal/ExceptionHelper:createMqttException	(Ljava/lang/Throwable;)Lcom/tencent/android/tpns/mqtt/MqttException;
    //   191: athrow
    //   192: astore_2
    //   193: new 116	java/lang/IllegalArgumentException
    //   196: dup
    //   197: new 319	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 322
    //   207: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_1
    //   211: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 328
    //   217: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_2
    //   221: invokevirtual 331	java/net/URISyntaxException:getMessage	()Ljava/lang/String;
    //   224: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokespecial 120	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   233: athrow
    //   234: iload_3
    //   235: istore 4
    //   237: iload_3
    //   238: iconst_m1
    //   239: if_icmpne +8 -> 247
    //   242: sipush 1883
    //   245: istore 4
    //   247: aload 6
    //   249: ifnonnull +37 -> 286
    //   252: invokestatic 339	javax/net/SocketFactory:getDefault	()Ljavax/net/SocketFactory;
    //   255: astore_1
    //   256: new 341	com/tencent/android/tpns/mqtt/internal/TCPNetworkModule
    //   259: dup
    //   260: aload_1
    //   261: aload 9
    //   263: iload 4
    //   265: aload_0
    //   266: getfield 147	com/tencent/android/tpns/mqtt/MqttAsyncClient:clientId	Ljava/lang/String;
    //   269: invokespecial 344	com/tencent/android/tpns/mqtt/internal/TCPNetworkModule:<init>	(Ljavax/net/SocketFactory;Ljava/lang/String;ILjava/lang/String;)V
    //   272: astore_1
    //   273: aload_1
    //   274: checkcast 341	com/tencent/android/tpns/mqtt/internal/TCPNetworkModule
    //   277: aload_2
    //   278: invokevirtual 347	com/tencent/android/tpns/mqtt/MqttConnectOptions:getConnectionTimeout	()I
    //   281: invokevirtual 351	com/tencent/android/tpns/mqtt/internal/TCPNetworkModule:setConnectTimeout	(I)V
    //   284: aload_1
    //   285: areturn
    //   286: aload 6
    //   288: astore_1
    //   289: aload 6
    //   291: instanceof 353
    //   294: ifeq -38 -> 256
    //   297: sipush 32105
    //   300: invokestatic 356	com/tencent/android/tpns/mqtt/internal/ExceptionHelper:createMqttException	(I)Lcom/tencent/android/tpns/mqtt/MqttException;
    //   303: athrow
    //   304: iload_3
    //   305: istore 4
    //   307: iload_3
    //   308: iconst_m1
    //   309: if_icmpne +8 -> 317
    //   312: sipush 8883
    //   315: istore 4
    //   317: aload 6
    //   319: ifnonnull +114 -> 433
    //   322: new 358	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory
    //   325: dup
    //   326: invokespecial 359	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:<init>	()V
    //   329: astore_1
    //   330: aload_2
    //   331: invokevirtual 363	com/tencent/android/tpns/mqtt/MqttConnectOptions:getSSLProperties	()Ljava/util/Properties;
    //   334: astore 6
    //   336: aload 6
    //   338: ifnull +10 -> 348
    //   341: aload_1
    //   342: aload 6
    //   344: aconst_null
    //   345: invokevirtual 367	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:initialize	(Ljava/util/Properties;Ljava/lang/String;)V
    //   348: aload_1
    //   349: aconst_null
    //   350: invokevirtual 371	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:createSocketFactory	(Ljava/lang/String;)Ljavax/net/ssl/SSLSocketFactory;
    //   353: astore 6
    //   355: new 373	com/tencent/android/tpns/mqtt/internal/SSLNetworkModule
    //   358: dup
    //   359: aload 6
    //   361: checkcast 353	javax/net/ssl/SSLSocketFactory
    //   364: aload 9
    //   366: iload 4
    //   368: aload_0
    //   369: getfield 147	com/tencent/android/tpns/mqtt/MqttAsyncClient:clientId	Ljava/lang/String;
    //   372: invokespecial 376	com/tencent/android/tpns/mqtt/internal/SSLNetworkModule:<init>	(Ljavax/net/ssl/SSLSocketFactory;Ljava/lang/String;ILjava/lang/String;)V
    //   375: astore 6
    //   377: aload 6
    //   379: checkcast 373	com/tencent/android/tpns/mqtt/internal/SSLNetworkModule
    //   382: aload_2
    //   383: invokevirtual 347	com/tencent/android/tpns/mqtt/MqttConnectOptions:getConnectionTimeout	()I
    //   386: invokevirtual 379	com/tencent/android/tpns/mqtt/internal/SSLNetworkModule:setSSLhandshakeTimeout	(I)V
    //   389: aload 6
    //   391: checkcast 373	com/tencent/android/tpns/mqtt/internal/SSLNetworkModule
    //   394: aload_2
    //   395: invokevirtual 383	com/tencent/android/tpns/mqtt/MqttConnectOptions:getSSLHostnameVerifier	()Ljavax/net/ssl/HostnameVerifier;
    //   398: invokevirtual 387	com/tencent/android/tpns/mqtt/internal/SSLNetworkModule:setSSLHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   401: aload 6
    //   403: astore_2
    //   404: aload_1
    //   405: ifnull -224 -> 181
    //   408: aload_1
    //   409: aconst_null
    //   410: invokevirtual 391	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getEnabledCipherSuites	(Ljava/lang/String;)[Ljava/lang/String;
    //   413: astore_1
    //   414: aload 6
    //   416: astore_2
    //   417: aload_1
    //   418: ifnull -237 -> 181
    //   421: aload 6
    //   423: checkcast 373	com/tencent/android/tpns/mqtt/internal/SSLNetworkModule
    //   426: aload_1
    //   427: invokevirtual 395	com/tencent/android/tpns/mqtt/internal/SSLNetworkModule:setEnabledCiphers	([Ljava/lang/String;)V
    //   430: aload 6
    //   432: areturn
    //   433: aload 6
    //   435: instanceof 353
    //   438: ifne +238 -> 676
    //   441: sipush 32105
    //   444: invokestatic 356	com/tencent/android/tpns/mqtt/internal/ExceptionHelper:createMqttException	(I)Lcom/tencent/android/tpns/mqtt/MqttException;
    //   447: athrow
    //   448: iload_3
    //   449: istore 4
    //   451: iload_3
    //   452: iconst_m1
    //   453: if_icmpne +7 -> 460
    //   456: bipush 80
    //   458: istore 4
    //   460: aload 6
    //   462: ifnonnull +40 -> 502
    //   465: invokestatic 339	javax/net/SocketFactory:getDefault	()Ljavax/net/SocketFactory;
    //   468: astore 6
    //   470: new 397	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketNetworkModule
    //   473: dup
    //   474: aload 6
    //   476: aload_1
    //   477: aload 9
    //   479: iload 4
    //   481: aload_0
    //   482: getfield 147	com/tencent/android/tpns/mqtt/MqttAsyncClient:clientId	Ljava/lang/String;
    //   485: invokespecial 400	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketNetworkModule:<init>	(Ljavax/net/SocketFactory;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   488: astore_1
    //   489: aload_1
    //   490: checkcast 397	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketNetworkModule
    //   493: aload_2
    //   494: invokevirtual 347	com/tencent/android/tpns/mqtt/MqttConnectOptions:getConnectionTimeout	()I
    //   497: invokevirtual 401	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketNetworkModule:setConnectTimeout	(I)V
    //   500: aload_1
    //   501: areturn
    //   502: aload 6
    //   504: instanceof 353
    //   507: ifeq +166 -> 673
    //   510: sipush 32105
    //   513: invokestatic 356	com/tencent/android/tpns/mqtt/internal/ExceptionHelper:createMqttException	(I)Lcom/tencent/android/tpns/mqtt/MqttException;
    //   516: athrow
    //   517: iload_3
    //   518: istore 4
    //   520: iload_3
    //   521: iconst_m1
    //   522: if_icmpne +8 -> 530
    //   525: sipush 443
    //   528: istore 4
    //   530: aload 6
    //   532: ifnonnull +98 -> 630
    //   535: new 358	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory
    //   538: dup
    //   539: invokespecial 359	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:<init>	()V
    //   542: astore 6
    //   544: aload_2
    //   545: invokevirtual 363	com/tencent/android/tpns/mqtt/MqttConnectOptions:getSSLProperties	()Ljava/util/Properties;
    //   548: astore 7
    //   550: aload 7
    //   552: ifnull +11 -> 563
    //   555: aload 6
    //   557: aload 7
    //   559: aconst_null
    //   560: invokevirtual 367	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:initialize	(Ljava/util/Properties;Ljava/lang/String;)V
    //   563: aload 6
    //   565: aconst_null
    //   566: invokevirtual 371	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:createSocketFactory	(Ljava/lang/String;)Ljavax/net/ssl/SSLSocketFactory;
    //   569: astore 7
    //   571: new 403	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketSecureNetworkModule
    //   574: dup
    //   575: aload 7
    //   577: checkcast 353	javax/net/ssl/SSLSocketFactory
    //   580: aload_1
    //   581: aload 9
    //   583: iload 4
    //   585: aload_0
    //   586: getfield 147	com/tencent/android/tpns/mqtt/MqttAsyncClient:clientId	Ljava/lang/String;
    //   589: invokespecial 406	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketSecureNetworkModule:<init>	(Ljavax/net/ssl/SSLSocketFactory;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   592: astore_1
    //   593: aload_1
    //   594: checkcast 403	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketSecureNetworkModule
    //   597: aload_2
    //   598: invokevirtual 347	com/tencent/android/tpns/mqtt/MqttConnectOptions:getConnectionTimeout	()I
    //   601: invokevirtual 407	com/tencent/android/tpns/mqtt/internal/websocket/WebSocketSecureNetworkModule:setSSLhandshakeTimeout	(I)V
    //   604: aload 6
    //   606: ifnull +51 -> 657
    //   609: aload 6
    //   611: aconst_null
    //   612: invokevirtual 391	com/tencent/android/tpns/mqtt/internal/security/SSLSocketFactoryFactory:getEnabledCipherSuites	(Ljava/lang/String;)[Ljava/lang/String;
    //   615: astore_2
    //   616: aload_2
    //   617: ifnull +11 -> 628
    //   620: aload_1
    //   621: checkcast 373	com/tencent/android/tpns/mqtt/internal/SSLNetworkModule
    //   624: aload_2
    //   625: invokevirtual 395	com/tencent/android/tpns/mqtt/internal/SSLNetworkModule:setEnabledCiphers	([Ljava/lang/String;)V
    //   628: aload_1
    //   629: areturn
    //   630: aload 6
    //   632: instanceof 353
    //   635: ifne +24 -> 659
    //   638: sipush 32105
    //   641: invokestatic 356	com/tencent/android/tpns/mqtt/internal/ExceptionHelper:createMqttException	(I)Lcom/tencent/android/tpns/mqtt/MqttException;
    //   644: athrow
    //   645: astore_2
    //   646: goto -462 -> 184
    //   649: astore_2
    //   650: goto -466 -> 184
    //   653: astore_2
    //   654: goto -470 -> 184
    //   657: aload_1
    //   658: areturn
    //   659: aconst_null
    //   660: astore 8
    //   662: aload 6
    //   664: astore 7
    //   666: aload 8
    //   668: astore 6
    //   670: goto -99 -> 571
    //   673: goto -203 -> 470
    //   676: aconst_null
    //   677: astore_1
    //   678: goto -323 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	681	0	this	MqttAsyncClient
    //   0	681	1	paramString	String
    //   0	681	2	paramMqttConnectOptions	MqttConnectOptions
    //   120	403	3	i	int
    //   32	552	4	j	int
    //   59	3	5	bool	boolean
    //   26	643	6	localObject1	Object
    //   42	623	7	localObject2	Object
    //   75	592	8	localField	java.lang.reflect.Field
    //   113	469	9	str	String
    // Exception table:
    //   from	to	target	type
    //   66	108	183	java/lang/NoSuchFieldException
    //   34	61	192	java/net/URISyntaxException
    //   66	108	192	java/net/URISyntaxException
    //   184	192	192	java/net/URISyntaxException
    //   66	108	645	java/lang/IllegalAccessException
    //   66	108	649	java/lang/IllegalArgumentException
    //   66	108	653	java/lang/SecurityException
  }
  
  public static String generateClientId()
  {
    return "paho" + System.nanoTime();
  }
  
  private String getHostName(String paramString)
  {
    int j = paramString.indexOf(':');
    int i = j;
    if (j == -1) {
      i = paramString.indexOf('/');
    }
    j = i;
    if (i == -1) {
      j = paramString.length();
    }
    return paramString.substring(0, j);
  }
  
  private void startReconnectCycle()
  {
    log.fine("MqttAsyncClient", "startReconnectCycle", "503", new Object[] { this.clientId, new Long(reconnectDelay) });
    this.reconnectTimer = new Timer("MQTT Reconnect: " + this.clientId);
    this.reconnectTimer.schedule(new ReconnectTask(null), reconnectDelay);
  }
  
  private void stopReconnectCycle()
  {
    log.fine("MqttAsyncClient", "stopReconnectCycle", "504", new Object[] { this.clientId });
    synchronized (clientLock)
    {
      if (this.connOpts.isAutomaticReconnect())
      {
        if (this.reconnectTimer != null)
        {
          this.reconnectTimer.cancel();
          this.reconnectTimer = null;
        }
        reconnectDelay = 1000;
      }
      return;
    }
  }
  
  public IMqttToken checkPing(Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    log.fine("MqttAsyncClient", "ping", "117");
    return null;
  }
  
  public void close()
    throws MqttException
  {
    close(false);
  }
  
  public void close(boolean paramBoolean)
    throws MqttException
  {
    log.fine("MqttAsyncClient", "close", "113");
    this.comms.close(paramBoolean);
    log.fine("MqttAsyncClient", "close", "114");
  }
  
  public IMqttToken connect()
    throws MqttException, MqttSecurityException
  {
    return connect(null, null);
  }
  
  public IMqttToken connect(MqttConnectOptions paramMqttConnectOptions)
    throws MqttException, MqttSecurityException
  {
    return connect(paramMqttConnectOptions, null, null);
  }
  
  public IMqttToken connect(MqttConnectOptions paramMqttConnectOptions, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttSecurityException
  {
    if (this.comms.isConnected()) {
      throw ExceptionHelper.createMqttException(32100);
    }
    if (this.comms.isConnecting()) {
      throw new MqttException(32110);
    }
    if (this.comms.isDisconnecting()) {
      throw new MqttException(32102);
    }
    if (this.comms.isClosed()) {
      throw new MqttException(32111);
    }
    if (paramMqttConnectOptions == null) {
      paramMqttConnectOptions = new MqttConnectOptions();
    }
    for (;;)
    {
      this.connOpts = paramMqttConnectOptions;
      this.userContext = paramObject;
      boolean bool1 = paramMqttConnectOptions.isAutomaticReconnect();
      Logger localLogger = log;
      boolean bool2 = paramMqttConnectOptions.isCleanSession();
      Integer localInteger1 = new Integer(paramMqttConnectOptions.getConnectionTimeout());
      Integer localInteger2 = new Integer(paramMqttConnectOptions.getKeepAliveInterval());
      String str2 = paramMqttConnectOptions.getUserName();
      Object localObject;
      if (paramMqttConnectOptions.getPassword() == null)
      {
        localObject = "[null]";
        if (paramMqttConnectOptions.getWillMessage() != null) {
          break label366;
        }
      }
      label366:
      for (String str1 = "[null]";; str1 = "[notnull]")
      {
        localLogger.fine("MqttAsyncClient", "connect", "103", new Object[] { Boolean.valueOf(bool2), localInteger1, localInteger2, str2, localObject, str1, paramObject, paramIMqttActionListener });
        this.comms.setNetworkModules(createNetworkModules(this.serverURI, paramMqttConnectOptions));
        this.comms.setReconnectCallback(new MqttReconnectCallback(bool1));
        localObject = new MqttToken(getClientId());
        paramMqttConnectOptions = new ConnectActionListener(this, this.persistence, this.comms, paramMqttConnectOptions, (MqttToken)localObject, paramObject, paramIMqttActionListener, this.reconnecting);
        ((MqttToken)localObject).setActionCallback(paramMqttConnectOptions);
        ((MqttToken)localObject).setUserContext(this);
        if ((this.mqttCallback instanceof MqttCallbackExtended)) {
          paramMqttConnectOptions.setMqttCallbackExtended((MqttCallbackExtended)this.mqttCallback);
        }
        this.comms.setNetworkModuleIndex(0);
        paramMqttConnectOptions.connect();
        return localObject;
        localObject = "[notnull]";
        break;
      }
    }
  }
  
  public IMqttToken connect(Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttSecurityException
  {
    return connect(new MqttConnectOptions(), paramObject, paramIMqttActionListener);
  }
  
  protected NetworkModule[] createNetworkModules(String paramString, MqttConnectOptions paramMqttConnectOptions)
    throws MqttException, MqttSecurityException
  {
    int i = 0;
    log.fine("MqttAsyncClient", "createNetworkModules", "116", new Object[] { paramString });
    String[] arrayOfString2 = paramMqttConnectOptions.getServerURIs();
    String[] arrayOfString1;
    if (arrayOfString2 == null)
    {
      arrayOfString1 = new String[1];
      arrayOfString1[0] = paramString;
    }
    for (;;)
    {
      paramString = new NetworkModule[arrayOfString1.length];
      while (i < arrayOfString1.length)
      {
        paramString[i] = createNetworkModule(arrayOfString1[i], paramMqttConnectOptions);
        i += 1;
      }
      arrayOfString1 = arrayOfString2;
      if (arrayOfString2.length == 0)
      {
        arrayOfString1 = new String[1];
        arrayOfString1[0] = paramString;
      }
    }
    log.fine("MqttAsyncClient", "createNetworkModules", "108");
    return paramString;
  }
  
  public void deleteBufferedMessage(int paramInt)
  {
    this.comms.deleteBufferedMessage(paramInt);
  }
  
  public void destroy()
    throws MqttException
  {
    close(true);
  }
  
  public IMqttToken disconnect()
    throws MqttException
  {
    return disconnect(null, null);
  }
  
  public IMqttToken disconnect(long paramLong)
    throws MqttException
  {
    return disconnect(paramLong, null, null);
  }
  
  public IMqttToken disconnect(long paramLong, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    MqttToken localMqttToken = new MqttToken(getClientId());
    localMqttToken.setActionCallback(paramIMqttActionListener);
    localMqttToken.setUserContext(paramObject);
    paramObject = new MqttDisconnect();
    try
    {
      this.comms.disconnect(paramObject, paramLong, localMqttToken);
      log.fine("MqttAsyncClient", "disconnect", "108");
      return localMqttToken;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
  
  public IMqttToken disconnect(Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    return disconnect(30000L, paramObject, paramIMqttActionListener);
  }
  
  public void disconnectForcibly()
    throws MqttException
  {
    disconnectForcibly(30000L, 10000L);
  }
  
  public void disconnectForcibly(long paramLong)
    throws MqttException
  {
    disconnectForcibly(30000L, paramLong);
  }
  
  public void disconnectForcibly(long paramLong1, long paramLong2)
    throws MqttException
  {
    this.comms.disconnectForcibly(paramLong1, paramLong2);
  }
  
  public void disconnectForcibly(long paramLong1, long paramLong2, boolean paramBoolean)
    throws MqttException
  {
    this.comms.disconnectForcibly(paramLong1, paramLong2, paramBoolean);
  }
  
  public MqttMessage getBufferedMessage(int paramInt)
  {
    return this.comms.getBufferedMessage(paramInt);
  }
  
  public int getBufferedMessageCount()
  {
    return this.comms.getBufferedMessageCount();
  }
  
  public String getClientId()
  {
    return this.clientId;
  }
  
  public String getCurrentServerURI()
  {
    return this.comms.getNetworkModules()[this.comms.getNetworkModuleIndex()].getServerURI();
  }
  
  public Debug getDebug()
  {
    return new Debug(this.clientId, this.comms);
  }
  
  public int getInFlightMessageCount()
  {
    return this.comms.getActualInFlight();
  }
  
  public IMqttDeliveryToken[] getPendingDeliveryTokens()
  {
    return this.comms.getPendingDeliveryTokens();
  }
  
  public String getServerURI()
  {
    return this.serverURI;
  }
  
  protected MqttTopic getTopic(String paramString)
  {
    MqttTopic.validate(paramString, false);
    MqttTopic localMqttTopic2 = (MqttTopic)this.topics.get(paramString);
    MqttTopic localMqttTopic1 = localMqttTopic2;
    if (localMqttTopic2 == null)
    {
      localMqttTopic1 = new MqttTopic(paramString, this.comms);
      this.topics.put(paramString, localMqttTopic1);
    }
    return localMqttTopic1;
  }
  
  public boolean isConnected()
  {
    return this.comms.isConnected();
  }
  
  public boolean isConnecting()
  {
    return this.comms.isConnecting();
  }
  
  public void messageArrivedComplete(int paramInt1, int paramInt2)
    throws MqttException
  {
    this.comms.messageArrivedComplete(paramInt1, paramInt2);
  }
  
  public MqttToken ping(IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    MqttToken localMqttToken = new MqttToken(getClientId());
    localMqttToken.setActionCallback(paramIMqttActionListener);
    paramIMqttActionListener = new MqttPingReq();
    this.comms.sendNoWait(paramIMqttActionListener, localMqttToken);
    return localMqttToken;
  }
  
  public IMqttDeliveryToken publish(String paramString, MqttMessage paramMqttMessage)
    throws MqttException, MqttPersistenceException
  {
    return publish(paramString, paramMqttMessage, null, null);
  }
  
  public IMqttDeliveryToken publish(String paramString, MqttMessage paramMqttMessage, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttPersistenceException
  {
    log.fine("MqttAsyncClient", "publish", "111", new Object[] { paramString, paramObject, paramIMqttActionListener });
    MqttTopic.validate(paramString, false);
    MqttDeliveryToken localMqttDeliveryToken = new MqttDeliveryToken(getClientId());
    localMqttDeliveryToken.setActionCallback(paramIMqttActionListener);
    localMqttDeliveryToken.setUserContext(paramObject);
    localMqttDeliveryToken.setMessage(paramMqttMessage);
    localMqttDeliveryToken.internalTok.setTopics(new String[] { paramString });
    paramString = new MqttPublish(paramString, paramMqttMessage);
    TBaseLogger.d("MqttAsyncClient", "action - publish, message is MqttPublish");
    this.comms.sendNoWait(paramString, localMqttDeliveryToken);
    log.fine("MqttAsyncClient", "publish", "112");
    return localMqttDeliveryToken;
  }
  
  public IMqttDeliveryToken publish(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws MqttException, MqttPersistenceException
  {
    return publish(paramString, paramArrayOfByte, paramInt, paramBoolean, null, null);
  }
  
  public IMqttDeliveryToken publish(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttPersistenceException
  {
    paramArrayOfByte = new MqttMessage(paramArrayOfByte);
    paramArrayOfByte.setQos(paramInt);
    paramArrayOfByte.setRetained(paramBoolean);
    return publish(paramString, paramArrayOfByte, paramObject, paramIMqttActionListener);
  }
  
  public void reconnect()
    throws MqttException
  {
    log.fine("MqttAsyncClient", "reconnect", "500", new Object[] { this.clientId });
    if (this.comms.isConnected()) {
      throw ExceptionHelper.createMqttException(32100);
    }
    if (this.comms.isConnecting()) {
      throw new MqttException(32110);
    }
    if (this.comms.isDisconnecting()) {
      throw new MqttException(32102);
    }
    if (this.comms.isClosed()) {
      throw new MqttException(32111);
    }
    stopReconnectCycle();
    attemptReconnect();
  }
  
  public void setBufferOpts(DisconnectedBufferOptions paramDisconnectedBufferOptions)
  {
    this.comms.setDisconnectedMessageBuffer(new DisconnectedMessageBuffer(paramDisconnectedBufferOptions));
  }
  
  public void setCallback(MqttCallback paramMqttCallback)
  {
    this.mqttCallback = paramMqttCallback;
    this.comms.setCallback(paramMqttCallback);
  }
  
  public void setManualAcks(boolean paramBoolean)
  {
    this.comms.setManualAcks(paramBoolean);
  }
  
  public IMqttToken subscribe(String paramString, int paramInt)
    throws MqttException
  {
    return subscribe(new String[] { paramString }, new int[] { paramInt }, null, null);
  }
  
  public IMqttToken subscribe(String paramString, int paramInt, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException
  {
    return subscribe(new String[] { paramString }, new int[] { paramInt }, null, null, new IMqttMessageListener[] { paramIMqttMessageListener });
  }
  
  public IMqttToken subscribe(String paramString, int paramInt, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    return subscribe(new String[] { paramString }, new int[] { paramInt }, paramObject, paramIMqttActionListener);
  }
  
  public IMqttToken subscribe(String paramString, int paramInt, Object paramObject, IMqttActionListener paramIMqttActionListener, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException
  {
    return subscribe(new String[] { paramString }, new int[] { paramInt }, paramObject, paramIMqttActionListener, new IMqttMessageListener[] { paramIMqttMessageListener });
  }
  
  public IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt)
    throws MqttException
  {
    return subscribe(paramArrayOfString, paramArrayOfInt, null, null);
  }
  
  public IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    TBaseLogger.d("MqttAsyncClient", "action - subscribe");
    if (paramArrayOfString.length != paramArrayOfInt.length) {
      throw new IllegalArgumentException();
    }
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      this.comms.removeMessageListener(paramArrayOfString[i]);
      i += 1;
    }
    if (log.isLoggable(5))
    {
      localObject = new StringBuffer();
      i = 0;
      while (i < paramArrayOfString.length)
      {
        if (i > 0) {
          ((StringBuffer)localObject).append(", ");
        }
        ((StringBuffer)localObject).append("topic=").append(paramArrayOfString[i]).append(" qos=").append(paramArrayOfInt[i]);
        MqttTopic.validate(paramArrayOfString[i], true);
        i += 1;
      }
      log.fine("MqttAsyncClient", "subscribe", "106", new Object[] { ((StringBuffer)localObject).toString(), paramObject, paramIMqttActionListener });
    }
    Object localObject = new MqttToken(getClientId());
    ((MqttToken)localObject).setActionCallback(paramIMqttActionListener);
    ((MqttToken)localObject).setUserContext(paramObject);
    ((MqttToken)localObject).internalTok.setTopics(paramArrayOfString);
    paramArrayOfString = new MqttSubscribe(paramArrayOfString, paramArrayOfInt);
    this.comms.sendNoWait(paramArrayOfString, (MqttToken)localObject);
    log.fine("MqttAsyncClient", "subscribe", "109");
    return localObject;
  }
  
  public IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt, Object paramObject, IMqttActionListener paramIMqttActionListener, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException
  {
    if ((paramArrayOfIMqttMessageListener.length != paramArrayOfInt.length) || (paramArrayOfInt.length != paramArrayOfString.length)) {
      throw new IllegalArgumentException();
    }
    paramArrayOfInt = subscribe(paramArrayOfString, paramArrayOfInt, paramObject, paramIMqttActionListener);
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      this.comms.setMessageListener(paramArrayOfString[i], paramArrayOfIMqttMessageListener[i]);
      i += 1;
    }
    return paramArrayOfInt;
  }
  
  public IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException
  {
    return subscribe(paramArrayOfString, paramArrayOfInt, null, null, paramArrayOfIMqttMessageListener);
  }
  
  public IMqttToken unsubscribe(String paramString)
    throws MqttException
  {
    return unsubscribe(new String[] { paramString }, null, null);
  }
  
  public IMqttToken unsubscribe(String paramString, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    return unsubscribe(new String[] { paramString }, paramObject, paramIMqttActionListener);
  }
  
  public IMqttToken unsubscribe(String[] paramArrayOfString)
    throws MqttException
  {
    return unsubscribe(paramArrayOfString, null, null);
  }
  
  public IMqttToken unsubscribe(String[] paramArrayOfString, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    int k = 0;
    if (log.isLoggable(5))
    {
      localObject1 = "";
      i = 0;
      while (i < paramArrayOfString.length)
      {
        Object localObject2 = localObject1;
        if (i > 0) {
          localObject2 = (String)localObject1 + ", ";
        }
        localObject1 = (String)localObject2 + paramArrayOfString[i];
        i += 1;
      }
      log.fine("MqttAsyncClient", "unsubscribe", "107", new Object[] { localObject1, paramObject, paramIMqttActionListener });
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramArrayOfString.length) {
        break;
      }
      MqttTopic.validate(paramArrayOfString[i], true);
      i += 1;
    }
    while (j < paramArrayOfString.length)
    {
      this.comms.removeMessageListener(paramArrayOfString[j]);
      j += 1;
    }
    Object localObject1 = new MqttToken(getClientId());
    ((MqttToken)localObject1).setActionCallback(paramIMqttActionListener);
    ((MqttToken)localObject1).setUserContext(paramObject);
    ((MqttToken)localObject1).internalTok.setTopics(paramArrayOfString);
    paramArrayOfString = new MqttUnsubscribe(paramArrayOfString);
    this.comms.sendNoWait(paramArrayOfString, (MqttToken)localObject1);
    log.fine("MqttAsyncClient", "unsubscribe", "110");
    return localObject1;
  }
  
  class MqttReconnectActionListener
    implements IMqttActionListener
  {
    final String methodName;
    
    MqttReconnectActionListener(String paramString)
    {
      this.methodName = paramString;
    }
    
    private void rescheduleReconnectCycle(int paramInt)
    {
      ??? = this.methodName + ":rescheduleReconnectCycle";
      MqttAsyncClient.log.fine("MqttAsyncClient", (String)???, "505", new Object[] { MqttAsyncClient.this.clientId, String.valueOf(MqttAsyncClient.reconnectDelay) });
      synchronized (MqttAsyncClient.clientLock)
      {
        if (MqttAsyncClient.this.connOpts.isAutomaticReconnect())
        {
          if (MqttAsyncClient.this.reconnectTimer != null) {
            MqttAsyncClient.this.reconnectTimer.schedule(new MqttAsyncClient.ReconnectTask(MqttAsyncClient.this, null), paramInt);
          }
        }
        else {
          return;
        }
        MqttAsyncClient.access$602(paramInt);
        MqttAsyncClient.this.startReconnectCycle();
      }
    }
    
    public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
    {
      MqttAsyncClient.log.fine("MqttAsyncClient", this.methodName, "502", new Object[] { paramIMqttToken.getClient().getClientId() });
      if (MqttAsyncClient.reconnectDelay < 128000) {
        MqttAsyncClient.access$602(MqttAsyncClient.reconnectDelay * 2);
      }
      rescheduleReconnectCycle(MqttAsyncClient.reconnectDelay);
    }
    
    public void onSuccess(IMqttToken paramIMqttToken)
    {
      MqttAsyncClient.log.fine("MqttAsyncClient", this.methodName, "501", new Object[] { paramIMqttToken.getClient().getClientId() });
      MqttAsyncClient.this.comms.setRestingState(false);
      MqttAsyncClient.this.stopReconnectCycle();
    }
  }
  
  class MqttReconnectCallback
    implements MqttCallbackExtended
  {
    final boolean automaticReconnect;
    
    MqttReconnectCallback(boolean paramBoolean)
    {
      this.automaticReconnect = paramBoolean;
    }
    
    public void connectComplete(boolean paramBoolean, String paramString) {}
    
    public void connectionLost(Throwable paramThrowable)
    {
      if (this.automaticReconnect)
      {
        MqttAsyncClient.this.comms.setRestingState(true);
        MqttAsyncClient.access$302(MqttAsyncClient.this, true);
        MqttAsyncClient.this.startReconnectCycle();
      }
    }
    
    public void deliveryComplete(IMqttDeliveryToken paramIMqttDeliveryToken) {}
    
    public void messageArrived(String paramString, MqttMessage paramMqttMessage)
      throws Exception
    {}
  }
  
  class ReconnectTask
    extends TimerTask
  {
    private static final String methodName = "ReconnectTask.run";
    
    private ReconnectTask() {}
    
    public void run()
    {
      MqttAsyncClient.log.fine("MqttAsyncClient", "ReconnectTask.run", "506");
      MqttAsyncClient.this.attemptReconnect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.MqttAsyncClient
 * JD-Core Version:    0.7.0.1
 */