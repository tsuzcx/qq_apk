import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.1;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.2;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.DummyCallback.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class npm
{
  private static AtomicInteger ab = new AtomicInteger(1000);
  private String bid;
  private String localPath;
  
  public npm(String paramString1, String paramString2)
  {
    this.bid = paramString1;
    this.localPath = paramString2;
  }
  
  private void aZX()
  {
    ThreadManager.getUIHandler().post(new StyleLoaderHelper.1(this));
  }
  
  private InputStream b(Context paramContext, String paramString1, String paramString2)
    throws IOException
  {
    return new npn(paramContext, paramString1).a(paramString2);
  }
  
  private Set<String> b(String paramString)
  {
    QLog.d("TemplateFactory", 2, "getAladdinKeysByService | localPath " + paramString);
    Object localObject = new HashSet();
    if (TextUtils.isEmpty(paramString)) {
      return localObject;
    }
    if (paramString.contains("default_feeds"))
    {
      paramString = kzf.l();
      QLog.d("TemplateFactory", 2, "getAladdinKeysByService | SERVICE_KEY_DEFAULT_FEEDS ");
    }
    for (;;)
    {
      localObject = new StringBuilder();
      Iterator localIterator = paramString.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ((StringBuilder)localObject).append((String)localIterator.next() + "\n");
          continue;
          if (paramString.contains("native_article"))
          {
            paramString = kzh.p();
            QLog.d("TemplateFactory", 2, "getAladdinKeysByService | SERVICE_KEY_NATIVE_ARTICLE ");
            break;
          }
          if (!paramString.contains("comment_feeds")) {
            break label200;
          }
          paramString = kzg.n();
          QLog.d("TemplateFactory", 2, "getAladdinKeysByService | SERVICE_KEY_COMMENT_FEEDS ");
          break;
        }
      }
      QLog.d("TemplateFactory", 1, "getAladdinKeysByService | aladdinKeys: " + ((StringBuilder)localObject).toString());
      return paramString;
      label200:
      paramString = (String)localObject;
    }
  }
  
  public static void ow(String paramString)
  {
    npt.a(paramString, true);
  }
  
  public static int qO()
  {
    return ab.incrementAndGet();
  }
  
  /* Error */
  public npi a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 67
    //   2: iconst_1
    //   3: new 69	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   10: ldc 171
    //   12: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aload_0
    //   26: getfield 28	npm:bid	Ljava/lang/String;
    //   29: ifnull +15 -> 44
    //   32: ldc 176
    //   34: aload_0
    //   35: getfield 28	npm:bid	Ljava/lang/String;
    //   38: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +34 -> 75
    //   44: ldc 67
    //   46: iconst_2
    //   47: new 69	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   54: ldc 182
    //   56: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aconst_null
    //   70: astore 4
    //   72: aload 4
    //   74: areturn
    //   75: aload_0
    //   76: getfield 28	npm:bid	Ljava/lang/String;
    //   79: invokestatic 187	npv:a	(Ljava/lang/String;)Lnpi;
    //   82: astore 5
    //   84: aload 5
    //   86: astore 4
    //   88: aload 5
    //   90: ifnonnull -18 -> 72
    //   93: aload_0
    //   94: getfield 28	npm:bid	Ljava/lang/String;
    //   97: invokestatic 190	npv:a	(Ljava/lang/String;)Lnpv$a;
    //   100: astore 5
    //   102: aload 5
    //   104: getfield 196	npv$a:isValid	Z
    //   107: ifne +80 -> 187
    //   110: aload 5
    //   112: getfield 200	npv$a:errorCode	I
    //   115: sipush 1001
    //   118: if_icmpne +38 -> 156
    //   121: ldc 67
    //   123: iconst_1
    //   124: new 69	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   131: ldc 202
    //   133: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_0
    //   137: getfield 28	npm:bid	Ljava/lang/String;
    //   140: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc 204
    //   145: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aconst_null
    //   155: areturn
    //   156: ldc 67
    //   158: iconst_1
    //   159: new 69	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   166: ldc 202
    //   168: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_0
    //   172: getfield 28	npm:bid	Ljava/lang/String;
    //   175: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: goto -30 -> 154
    //   187: new 209	npi
    //   190: dup
    //   191: invokespecial 210	npi:<init>	()V
    //   194: astore 4
    //   196: aload 4
    //   198: iconst_2
    //   199: invokevirtual 213	npi:setId	(I)V
    //   202: aload 4
    //   204: aload_0
    //   205: getfield 28	npm:bid	Ljava/lang/String;
    //   208: invokevirtual 216	npi:or	(Ljava/lang/String;)V
    //   211: aload 4
    //   213: aload 5
    //   215: invokevirtual 219	npi:a	(Lnpv$a;)V
    //   218: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   221: lstore_2
    //   222: aload_0
    //   223: getfield 28	npm:bid	Ljava/lang/String;
    //   226: invokestatic 231	jpe:dO	(Ljava/lang/String;)Ljava/lang/String;
    //   229: astore 5
    //   231: ldc 67
    //   233: iconst_2
    //   234: new 69	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   241: ldc 233
    //   243: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 5
    //   248: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload 5
    //   259: ifnonnull +38 -> 297
    //   262: ldc 67
    //   264: iconst_1
    //   265: new 69	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   272: ldc 233
    //   274: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_0
    //   278: getfield 28	npm:bid	Ljava/lang/String;
    //   281: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 235
    //   286: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aconst_null
    //   296: areturn
    //   297: new 69	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   304: aload 5
    //   306: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload_0
    //   310: getfield 28	npm:bid	Ljava/lang/String;
    //   313: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: astore 7
    //   321: aload 7
    //   323: aload_0
    //   324: getfield 28	npm:bid	Ljava/lang/String;
    //   327: invokestatic 241	jqj:D	(Ljava/lang/String;Ljava/lang/String;)Z
    //   330: ifne +38 -> 368
    //   333: ldc 67
    //   335: iconst_1
    //   336: new 69	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   343: ldc 243
    //   345: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload_0
    //   349: getfield 28	npm:bid	Ljava/lang/String;
    //   352: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: ldc 245
    //   357: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: aconst_null
    //   367: areturn
    //   368: new 69	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   375: aload 7
    //   377: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: ldc 247
    //   382: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: ldc 249
    //   387: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: astore 5
    //   395: new 69	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   402: aload_0
    //   403: getfield 30	npm:localPath	Ljava/lang/String;
    //   406: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc 247
    //   411: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc 249
    //   416: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: astore 6
    //   424: new 251	npp
    //   427: dup
    //   428: aload_1
    //   429: aload 7
    //   431: aload_0
    //   432: getfield 30	npm:localPath	Ljava/lang/String;
    //   435: invokespecial 254	npp:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   438: astore 7
    //   440: new 251	npp
    //   443: dup
    //   444: aload_1
    //   445: aload 5
    //   447: aload 6
    //   449: invokespecial 254	npp:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   452: astore_1
    //   453: new 256	npk
    //   456: dup
    //   457: aload_1
    //   458: invokespecial 259	npk:<init>	(Lnpo;)V
    //   461: astore 5
    //   463: aload_1
    //   464: invokeinterface 265 1 0
    //   469: astore 8
    //   471: aload 8
    //   473: ifnull +331 -> 804
    //   476: new 267	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser
    //   479: dup
    //   480: invokespecial 268	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:<init>	()V
    //   483: astore 6
    //   485: aload 6
    //   487: ldc_w 270
    //   490: invokevirtual 273	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:setVersion	(Ljava/lang/String;)V
    //   493: aload 6
    //   495: aload_0
    //   496: aload_0
    //   497: getfield 30	npm:localPath	Ljava/lang/String;
    //   500: invokespecial 275	npm:b	(Ljava/lang/String;)Ljava/util/Set;
    //   503: invokevirtual 279	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:setAladdinKey	(Ljava/util/Set;)V
    //   506: aload 7
    //   508: ldc_w 281
    //   511: invokeinterface 282 2 0
    //   516: astore 7
    //   518: aload 7
    //   520: ifnull +13 -> 533
    //   523: aload 6
    //   525: aload 7
    //   527: invokestatic 286	npv:readInputStreamAsString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   530: invokevirtual 289	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:parseDataMap	(Ljava/lang/String;)V
    //   533: aload 8
    //   535: invokeinterface 292 1 0
    //   540: astore 8
    //   542: aload 8
    //   544: invokeinterface 122 1 0
    //   549: ifeq +192 -> 741
    //   552: aload 8
    //   554: invokeinterface 126 1 0
    //   559: checkcast 99	java/lang/String
    //   562: astore 7
    //   564: ldc 67
    //   566: iconst_2
    //   567: new 69	java/lang/StringBuilder
    //   570: dup
    //   571: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   574: ldc_w 294
    //   577: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: aload 7
    //   582: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: aload 7
    //   593: ldc_w 296
    //   596: invokevirtual 300	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   599: ifeq -57 -> 542
    //   602: ldc 67
    //   604: iconst_1
    //   605: new 69	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   612: ldc_w 302
    //   615: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload 7
    //   620: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   629: aload 6
    //   631: aload 4
    //   633: aload_1
    //   634: aload 7
    //   636: invokeinterface 282 2 0
    //   641: invokestatic 286	npv:readInputStreamAsString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   644: aload 5
    //   646: invokevirtual 306	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:createViewTemplate	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;)V
    //   649: goto -107 -> 542
    //   652: astore_1
    //   653: ldc 67
    //   655: iconst_1
    //   656: new 69	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   663: ldc_w 308
    //   666: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: aload 7
    //   671: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   677: aload_1
    //   678: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   681: aload_1
    //   682: athrow
    //   683: astore_1
    //   684: ldc 67
    //   686: iconst_1
    //   687: ldc_w 313
    //   690: aload_1
    //   691: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   694: aconst_null
    //   695: areturn
    //   696: astore 7
    //   698: ldc 67
    //   700: iconst_1
    //   701: new 69	java/lang/StringBuilder
    //   704: dup
    //   705: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   708: ldc_w 315
    //   711: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: aload 7
    //   716: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   719: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   722: invokestatic 318	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   725: goto -192 -> 533
    //   728: astore_1
    //   729: ldc 67
    //   731: iconst_1
    //   732: ldc_w 320
    //   735: aload_1
    //   736: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   739: aconst_null
    //   740: areturn
    //   741: ldc 67
    //   743: iconst_2
    //   744: new 69	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   751: ldc_w 322
    //   754: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   760: lload_2
    //   761: lsub
    //   762: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   765: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   768: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   771: ldc 67
    //   773: iconst_1
    //   774: ldc_w 327
    //   777: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   780: aload_0
    //   781: getfield 28	npm:bid	Ljava/lang/String;
    //   784: aload 4
    //   786: invokestatic 330	npv:a	(Ljava/lang/String;Lnpi;)V
    //   789: aload_0
    //   790: invokespecial 332	npm:aZX	()V
    //   793: iconst_3
    //   794: aload_0
    //   795: getfield 28	npm:bid	Ljava/lang/String;
    //   798: invokestatic 338	obr:aE	(ILjava/lang/String;)V
    //   801: aload 4
    //   803: areturn
    //   804: ldc 67
    //   806: iconst_1
    //   807: ldc_w 340
    //   810: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   813: aconst_null
    //   814: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	815	0	this	npm
    //   0	815	1	paramContext	Context
    //   221	540	2	l	long
    //   70	732	4	localObject1	Object
    //   82	563	5	localObject2	Object
    //   422	208	6	localObject3	Object
    //   319	351	7	localObject4	Object
    //   696	19	7	localIOException	IOException
    //   469	84	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   591	649	652	org/json/JSONException
    //   368	471	683	java/lang/OutOfMemoryError
    //   476	506	683	java/lang/OutOfMemoryError
    //   506	518	683	java/lang/OutOfMemoryError
    //   523	533	683	java/lang/OutOfMemoryError
    //   533	542	683	java/lang/OutOfMemoryError
    //   542	591	683	java/lang/OutOfMemoryError
    //   591	649	683	java/lang/OutOfMemoryError
    //   653	683	683	java/lang/OutOfMemoryError
    //   698	725	683	java/lang/OutOfMemoryError
    //   741	771	683	java/lang/OutOfMemoryError
    //   804	813	683	java/lang/OutOfMemoryError
    //   506	518	696	java/io/IOException
    //   523	533	696	java/io/IOException
    //   368	471	728	java/lang/Exception
    //   476	506	728	java/lang/Exception
    //   506	518	728	java/lang/Exception
    //   523	533	728	java/lang/Exception
    //   533	542	728	java/lang/Exception
    //   542	591	728	java/lang/Exception
    //   591	649	728	java/lang/Exception
    //   653	683	728	java/lang/Exception
    //   698	725	728	java/lang/Exception
    //   741	771	728	java/lang/Exception
    //   804	813	728	java/lang/Exception
  }
  
  /* Error */
  public npi b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	npm:localPath	Ljava/lang/String;
    //   4: ifnonnull +35 -> 39
    //   7: ldc 67
    //   9: iconst_2
    //   10: new 69	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 342
    //   20: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aconst_null
    //   34: astore 4
    //   36: aload 4
    //   38: areturn
    //   39: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   42: lstore_2
    //   43: aload_0
    //   44: getfield 30	npm:localPath	Ljava/lang/String;
    //   47: invokestatic 187	npv:a	(Ljava/lang/String;)Lnpi;
    //   50: astore 5
    //   52: aload 5
    //   54: astore 4
    //   56: aload 5
    //   58: ifnonnull -22 -> 36
    //   61: new 209	npi
    //   64: dup
    //   65: invokespecial 210	npi:<init>	()V
    //   68: astore 7
    //   70: aload 7
    //   72: iconst_1
    //   73: invokevirtual 213	npi:setId	(I)V
    //   76: aload 7
    //   78: ldc 176
    //   80: invokevirtual 216	npi:or	(Ljava/lang/String;)V
    //   83: aload_1
    //   84: invokevirtual 348	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   87: astore 8
    //   89: new 69	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   96: aload_0
    //   97: getfield 30	npm:localPath	Ljava/lang/String;
    //   100: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 247
    //   105: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 249
    //   110: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore 9
    //   118: new 57	npn
    //   121: dup
    //   122: aload_1
    //   123: aload 9
    //   125: invokespecial 60	npn:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   128: astore 10
    //   130: aload 10
    //   132: invokeinterface 265 1 0
    //   137: astore 5
    //   139: aload 5
    //   141: ifnull +613 -> 754
    //   144: ldc 67
    //   146: iconst_1
    //   147: new 69	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 350
    //   157: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 5
    //   162: invokeinterface 353 1 0
    //   167: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: ldc_w 358
    //   173: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 30	npm:localPath	Ljava/lang/String;
    //   180: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: new 267	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser
    //   192: dup
    //   193: invokespecial 268	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:<init>	()V
    //   196: astore 4
    //   198: aload 4
    //   200: aload_0
    //   201: aload_0
    //   202: getfield 30	npm:localPath	Ljava/lang/String;
    //   205: invokespecial 275	npm:b	(Ljava/lang/String;)Ljava/util/Set;
    //   208: invokevirtual 279	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:setAladdinKey	(Ljava/util/Set;)V
    //   211: invokestatic 364	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   214: invokevirtual 367	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:isSupportHotReload	()Z
    //   217: ifeq +548 -> 765
    //   220: invokestatic 364	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   223: astore 4
    //   225: aload 4
    //   227: aload_0
    //   228: aload_1
    //   229: aload_0
    //   230: getfield 30	npm:localPath	Ljava/lang/String;
    //   233: ldc_w 281
    //   236: invokespecial 369	npm:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    //   239: invokestatic 286	npv:readInputStreamAsString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   242: invokevirtual 289	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:parseDataMap	(Ljava/lang/String;)V
    //   245: new 371	npj
    //   248: dup
    //   249: aload_1
    //   250: aload 9
    //   252: invokespecial 372	npj:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   255: astore 11
    //   257: aload 5
    //   259: invokeinterface 292 1 0
    //   264: astore 12
    //   266: aload 12
    //   268: invokeinterface 122 1 0
    //   273: ifeq +319 -> 592
    //   276: aload 12
    //   278: invokeinterface 126 1 0
    //   283: checkcast 99	java/lang/String
    //   286: astore 13
    //   288: aload 13
    //   290: ldc_w 296
    //   293: invokevirtual 300	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   296: ifeq -30 -> 266
    //   299: ldc 67
    //   301: iconst_2
    //   302: new 69	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 374
    //   312: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 13
    //   317: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: invokestatic 364	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   329: invokevirtual 367	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:isSupportHotReload	()Z
    //   332: ifeq +143 -> 475
    //   335: invokestatic 364	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:getInstance	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload;
    //   338: aload_1
    //   339: aload 7
    //   341: aload 11
    //   343: new 69	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   350: aload 9
    //   352: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: ldc 247
    //   357: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 13
    //   362: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: aload 9
    //   370: new 69	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   377: aload_0
    //   378: getfield 30	npm:localPath	Ljava/lang/String;
    //   381: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc_w 376
    //   387: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokevirtual 380	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParserWithHotReload:createViewTempFromAssets	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   396: goto -130 -> 266
    //   399: astore 5
    //   401: ldc 67
    //   403: iconst_1
    //   404: new 69	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 382
    //   414: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 13
    //   419: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: aload 5
    //   427: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   430: goto -164 -> 266
    //   433: astore_1
    //   434: ldc 67
    //   436: iconst_1
    //   437: ldc_w 384
    //   440: aload_1
    //   441: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   444: aconst_null
    //   445: areturn
    //   446: astore 6
    //   448: ldc 67
    //   450: iconst_2
    //   451: ldc_w 386
    //   454: aload 6
    //   456: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   459: goto -214 -> 245
    //   462: astore_1
    //   463: ldc 67
    //   465: iconst_1
    //   466: ldc_w 386
    //   469: aload_1
    //   470: invokestatic 311	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   473: aconst_null
    //   474: areturn
    //   475: aload 10
    //   477: aload 13
    //   479: invokeinterface 282 2 0
    //   484: astore 6
    //   486: aload 6
    //   488: astore 5
    //   490: aload 6
    //   492: ifnonnull +78 -> 570
    //   495: aload 8
    //   497: new 69	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   504: aload 9
    //   506: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc 247
    //   511: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload 13
    //   516: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokevirtual 391	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   525: astore 5
    //   527: ldc 67
    //   529: iconst_1
    //   530: new 69	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   537: ldc_w 393
    //   540: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 9
    //   545: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: ldc 247
    //   550: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 13
    //   555: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: ldc_w 395
    //   561: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: aload 4
    //   572: aload 7
    //   574: aload 5
    //   576: invokestatic 286	npv:readInputStreamAsString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   579: aload 11
    //   581: invokevirtual 306	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/ProteusParser:createViewTemplate	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/parse/loaders/ComplementFileStringLoader;)V
    //   584: aload 5
    //   586: invokevirtual 400	java/io/InputStream:close	()V
    //   589: goto -323 -> 266
    //   592: aload 7
    //   594: invokevirtual 404	npi:getNameTemplateMap	()Ljava/util/Map;
    //   597: astore 4
    //   599: new 69	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   606: astore_1
    //   607: aload 4
    //   609: invokeinterface 409 1 0
    //   614: invokeinterface 116 1 0
    //   619: astore 4
    //   621: aload 4
    //   623: invokeinterface 122 1 0
    //   628: ifeq +51 -> 679
    //   631: aload 4
    //   633: invokeinterface 126 1 0
    //   638: checkcast 411	java/util/Map$Entry
    //   641: astore 5
    //   643: aload_1
    //   644: new 69	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   651: aload 5
    //   653: invokeinterface 414 1 0
    //   658: checkcast 99	java/lang/String
    //   661: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: ldc 128
    //   666: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: goto -55 -> 621
    //   679: ldc 67
    //   681: iconst_2
    //   682: new 69	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   689: ldc_w 416
    //   692: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: aload_1
    //   696: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: ldc 67
    //   710: iconst_1
    //   711: new 69	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   718: ldc_w 418
    //   721: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   727: lload_2
    //   728: lsub
    //   729: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   732: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   738: aload_0
    //   739: getfield 30	npm:localPath	Ljava/lang/String;
    //   742: aload 7
    //   744: invokestatic 330	npv:a	(Ljava/lang/String;Lnpi;)V
    //   747: aload_0
    //   748: invokespecial 332	npm:aZX	()V
    //   751: aload 7
    //   753: areturn
    //   754: ldc 67
    //   756: iconst_1
    //   757: ldc_w 420
    //   760: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   763: aconst_null
    //   764: areturn
    //   765: goto -540 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	768	0	this	npm
    //   0	768	1	paramContext	Context
    //   42	686	2	l	long
    //   34	598	4	localObject1	Object
    //   50	208	5	localObject2	Object
    //   399	27	5	localException1	Exception
    //   488	164	5	localObject3	Object
    //   446	9	6	localException2	Exception
    //   484	7	6	localInputStream	InputStream
    //   68	684	7	localnpi	npi
    //   87	409	8	localAssetManager	android.content.res.AssetManager
    //   116	428	9	str1	String
    //   128	348	10	localnpn	npn
    //   255	325	11	localnpj	npj
    //   264	13	12	localIterator	Iterator
    //   286	268	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   326	396	399	java/lang/Exception
    //   475	486	399	java/lang/Exception
    //   495	570	399	java/lang/Exception
    //   570	589	399	java/lang/Exception
    //   118	139	433	java/lang/OutOfMemoryError
    //   144	225	433	java/lang/OutOfMemoryError
    //   225	245	433	java/lang/OutOfMemoryError
    //   245	266	433	java/lang/OutOfMemoryError
    //   266	326	433	java/lang/OutOfMemoryError
    //   326	396	433	java/lang/OutOfMemoryError
    //   401	430	433	java/lang/OutOfMemoryError
    //   448	459	433	java/lang/OutOfMemoryError
    //   475	486	433	java/lang/OutOfMemoryError
    //   495	570	433	java/lang/OutOfMemoryError
    //   570	589	433	java/lang/OutOfMemoryError
    //   592	621	433	java/lang/OutOfMemoryError
    //   621	676	433	java/lang/OutOfMemoryError
    //   679	708	433	java/lang/OutOfMemoryError
    //   754	763	433	java/lang/OutOfMemoryError
    //   225	245	446	java/lang/Exception
    //   118	139	462	java/lang/Exception
    //   144	225	462	java/lang/Exception
    //   245	266	462	java/lang/Exception
    //   266	326	462	java/lang/Exception
    //   401	430	462	java/lang/Exception
    //   448	459	462	java/lang/Exception
    //   592	621	462	java/lang/Exception
    //   621	676	462	java/lang/Exception
    //   679	708	462	java/lang/Exception
    //   754	763	462	java/lang/Exception
  }
  
  public void checkUpdate()
  {
    if ((this.bid == null) || ("0".equals(this.bid))) {
      return;
    }
    ThreadManager.executeOnFileThread(new StyleLoaderHelper.2(this));
  }
  
  public String toString()
  {
    return " bid :" + this.bid + " localPath: " + this.localPath + " config: " + jpa.b(this.bid);
  }
  
  public class a
    implements jox
  {
    private final String ank;
    private final String localPath;
    
    public a(String paramString1, String paramString2)
    {
      this.ank = paramString1;
      this.localPath = paramString2;
    }
    
    public void aS(String paramString, int paramInt)
    {
      QLog.d("TemplateFactory", 2, "loaded: bid : " + this.ank + " param " + paramString + " code : " + paramInt);
      if (paramInt == 0)
      {
        if (paramString == null) {}
        try
        {
          QLog.d("TemplateFactory", 2, "下载离线样式包完成 : " + this.ank);
          npv.oy(npm.a(npm.this));
          if ((paramString == null) && (npv.a(this.ank).isValid))
          {
            QLog.d("TemplateFactory", 2, "加载离线包 : " + this.ank);
            obr.aE(2, npm.a(npm.this));
            paramString = npm.this.a(BaseApplicationImpl.getApplication());
            if (paramString == null)
            {
              QLog.d("TemplateFactory", 2, "templateFactory == null  bid : " + this.ank + " code : " + paramInt);
              return;
            }
            paramString.setId(npm.ab.incrementAndGet());
            npv.a(this.ank, paramString);
            npi.reset();
            return;
          }
        }
        catch (Exception paramString)
        {
          QLog.e("TemplateFactory", 1, "loaded: bid : " + this.ank, paramString);
        }
      }
    }
    
    public void loaded(String paramString, int paramInt)
    {
      ThreadManager.getFileThreadHandler().post(new StyleLoaderHelper.DummyCallback.1(this, paramString, paramInt));
    }
    
    public void progress(int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npm
 * JD-Core Version:    0.7.0.1
 */