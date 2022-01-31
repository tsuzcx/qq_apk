package tmsdkdual;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tmsdk.dual.sharkcpp.callback.SharkCallbackPhoneNumber;
import dualsim.common.PhoneGetResult;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  private static boolean k = false;
  
  private boolean b(int paramInt)
  {
    if (paramInt == -1) {}
    for (;;)
    {
      return false;
      Object localObject = a.b().g.getString("PN_CTR_FAIL_RESULT_SET_CLOUD", null);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!"off".equals(localObject))) {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("#");
          if ((localObject == null) || (localObject.length <= 0)) {
            break label123;
          }
        }
      }
      try
      {
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            int m = Integer.parseInt(localObject[i]);
            if (m == paramInt) {
              break;
            }
            i += 1;
            continue;
            if ((paramInt == -20006) || (paramInt == -20005) || (paramInt == -20013)) {
              break;
            }
          }
        }
      }
      catch (Exception localException)
      {
        label123:
        break label123;
      }
    }
    return true;
  }
  
  public PhoneGetResult d()
  {
    try
    {
      if (!n.t()) {
        return new PhoneGetResult(-20009);
      }
      if (TextUtils.isEmpty(a.b().g.getString("CLOUD_MNC_FILTER", null)))
      {
        Object localObject1 = n.getNetworkName();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).startsWith("ct")) || (((String)localObject1).startsWith("cm"))))
        {
          localObject1 = new PhoneGetResult(-20011);
          return localObject1;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      return new PhoneGetResult(-20001);
    }
    long l3 = System.currentTimeMillis();
    long l4 = a.b().g.getLong("PN_LAST_FETCH_TIME", 0L);
    int i = a.b().g.getInt("PN_LAST_FATCH_RESULT", -1);
    Object localObject2 = a.b().g.getString("NET_GET_NUMBER_CACHE", null);
    long l2;
    PhoneGetResult localPhoneGetResult;
    if ((i == 0) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      l2 = a.b().g.getLong("PN_CTR_FETCH_SUC_NOT_ADAPTER_INTERVAL_CLOUD", -1L);
      l1 = l2;
      if (l2 == -1L) {
        l1 = a.b().g.getLong("PN_CTR_FETCH_SUC_NOT_ADAPTER_INTERVAL", 1800L);
      }
      if (l3 - l4 < l1 * 1000L)
      {
        m.b("NetPhoneObtainer", " === Not Adapter get phone number from cache..");
        localPhoneGetResult = new PhoneGetResult(0);
        localPhoneGetResult.phoneNumber = ((String)localObject2);
        localPhoneGetResult.source = 1;
        return localPhoneGetResult;
      }
    }
    if (((i == 0) && (TextUtils.isEmpty((CharSequence)localObject2))) || ((i != 0) && (b(i))))
    {
      l2 = a.b().g.getLong("PN_CTR_FETCH_FAIL_INTERVAL_CLOUD", -1L);
      l1 = l2;
      if (l2 == -1L) {
        l1 = a.b().g.getLong("PN_CTR_FETCH_FAIL_INTERVAL", 1800L);
      }
      if (l3 - l4 < l1 * 1000L)
      {
        localObject2 = new PhoneGetResult(-20012);
        ((PhoneGetResult)localObject2).subErrCode = i;
        return localObject2;
      }
    }
    long l1 = a.b().g.getLong("PN_CTR_TOTAL_INTERVAL_CLOUD", -1L);
    if ((l1 != -1L) && (l3 - l4 < l1 * 1000L))
    {
      if ((i == 0) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        localPhoneGetResult = new PhoneGetResult(0);
        localPhoneGetResult.phoneNumber = ((String)localObject2);
        localPhoneGetResult.source = 1;
        return localPhoneGetResult;
      }
      localObject2 = new PhoneGetResult(-20012);
      ((PhoneGetResult)localObject2).subErrCode = i;
      return localObject2;
    }
    localObject2 = e();
    m.b("NetPhoneObtainer", " === get phone number now!");
    a.b().a("PN_LAST_FETCH_TIME", System.currentTimeMillis());
    a.b().a("PN_LAST_FATCH_RESULT", ((PhoneGetResult)localObject2).errorCode);
    a.b().a("NET_GET_NUMBER_CACHE", ((PhoneGetResult)localObject2).phoneNumber);
    a.b().a("NET_GET_LAST_IMSI", null);
    return localObject2;
  }
  
  /* Error */
  public PhoneGetResult e()
  {
    // Byte code:
    //   0: invokestatic 177	tmsdkdual/n:getLocalIp	()Ljava/lang/String;
    //   3: astore 9
    //   5: ldc 124
    //   7: new 179	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   14: ldc 182
    //   16: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload 9
    //   21: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 131	tmsdkdual/m:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   30: aload 9
    //   32: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +74 -> 109
    //   38: getstatic 12	tmsdkdual/b:k	Z
    //   41: ifne +57 -> 98
    //   44: invokestatic 193	tmsdkdual/n:u	()Ljava/util/List;
    //   47: astore 4
    //   49: new 75	dualsim/common/PhoneGetResult
    //   52: dup
    //   53: iconst_0
    //   54: invokespecial 78	dualsim/common/PhoneGetResult:<init>	(I)V
    //   57: astore 5
    //   59: aload 5
    //   61: sipush -20008
    //   64: putfield 196	dualsim/common/PhoneGetResult:result	I
    //   67: aload 4
    //   69: ifnull +13 -> 82
    //   72: aload 5
    //   74: aload 4
    //   76: invokevirtual 197	java/lang/Object:toString	()Ljava/lang/String;
    //   79: putfield 200	dualsim/common/PhoneGetResult:extraInfo	Ljava/lang/String;
    //   82: new 202	tmsdkdual/e
    //   85: dup
    //   86: invokespecial 203	tmsdkdual/e:<init>	()V
    //   89: aload 5
    //   91: invokevirtual 206	tmsdkdual/e:a	(Ldualsim/common/PhoneGetResult;)V
    //   94: iconst_1
    //   95: putstatic 12	tmsdkdual/b:k	Z
    //   98: new 75	dualsim/common/PhoneGetResult
    //   101: dup
    //   102: sipush -20008
    //   105: invokespecial 78	dualsim/common/PhoneGetResult:<init>	(I)V
    //   108: areturn
    //   109: new 208	java/util/concurrent/atomic/AtomicInteger
    //   112: dup
    //   113: invokespecial 209	java/util/concurrent/atomic/AtomicInteger:<init>	()V
    //   116: astore 5
    //   118: new 208	java/util/concurrent/atomic/AtomicInteger
    //   121: dup
    //   122: invokespecial 209	java/util/concurrent/atomic/AtomicInteger:<init>	()V
    //   125: astore 6
    //   127: new 179	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   134: astore 7
    //   136: new 208	java/util/concurrent/atomic/AtomicInteger
    //   139: dup
    //   140: invokespecial 209	java/util/concurrent/atomic/AtomicInteger:<init>	()V
    //   143: astore 4
    //   145: aload 5
    //   147: sipush -20006
    //   150: invokevirtual 212	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   153: new 214	java/util/concurrent/CountDownLatch
    //   156: dup
    //   157: iconst_1
    //   158: invokespecial 215	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   161: astore 8
    //   163: aload 9
    //   165: new 6	tmsdkdual/b$1
    //   168: dup
    //   169: aload_0
    //   170: aload 5
    //   172: aload 6
    //   174: aload 7
    //   176: aload 4
    //   178: aload 8
    //   180: invokespecial 218	tmsdkdual/b$1:<init>	(Ltmsdkdual/b;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/lang/StringBuilder;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/CountDownLatch;)V
    //   183: invokestatic 224	com/tmsdk/dual/sharkcpp/SharkCppProxy:getPhoneNumberAsy	(Ljava/lang/String;Lcom/tmsdk/dual/sharkcpp/callback/SharkCallbackPhoneNumber;)V
    //   186: aload 8
    //   188: ldc2_w 225
    //   191: getstatic 232	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   194: invokevirtual 236	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   197: pop
    //   198: aload 5
    //   200: invokevirtual 240	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   203: ifeq +98 -> 301
    //   206: new 75	dualsim/common/PhoneGetResult
    //   209: dup
    //   210: aload 5
    //   212: invokevirtual 240	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   215: invokespecial 78	dualsim/common/PhoneGetResult:<init>	(I)V
    //   218: astore 5
    //   220: aload 5
    //   222: aload 4
    //   224: invokevirtual 240	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   227: putfield 243	dualsim/common/PhoneGetResult:networkCode	I
    //   230: aload 5
    //   232: areturn
    //   233: astore 4
    //   235: aload 4
    //   237: invokevirtual 246	org/json/JSONException:printStackTrace	()V
    //   240: new 75	dualsim/common/PhoneGetResult
    //   243: dup
    //   244: sipush -20007
    //   247: invokespecial 78	dualsim/common/PhoneGetResult:<init>	(I)V
    //   250: areturn
    //   251: astore 4
    //   253: aload 8
    //   255: invokevirtual 249	java/util/concurrent/CountDownLatch:countDown	()V
    //   258: new 75	dualsim/common/PhoneGetResult
    //   261: dup
    //   262: sipush -20006
    //   265: invokespecial 78	dualsim/common/PhoneGetResult:<init>	(I)V
    //   268: astore 4
    //   270: aload 4
    //   272: areturn
    //   273: astore 4
    //   275: aload 4
    //   277: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   280: new 75	dualsim/common/PhoneGetResult
    //   283: dup
    //   284: sipush -20001
    //   287: invokespecial 78	dualsim/common/PhoneGetResult:<init>	(I)V
    //   290: areturn
    //   291: astore 8
    //   293: aload 8
    //   295: invokevirtual 251	java/lang/InterruptedException:printStackTrace	()V
    //   298: goto -100 -> 198
    //   301: aload 7
    //   303: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   309: ifeq +14 -> 323
    //   312: new 75	dualsim/common/PhoneGetResult
    //   315: dup
    //   316: sipush -20010
    //   319: invokespecial 78	dualsim/common/PhoneGetResult:<init>	(I)V
    //   322: areturn
    //   323: aload 6
    //   325: invokevirtual 240	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   328: bipush 254
    //   330: if_icmpne +14 -> 344
    //   333: new 75	dualsim/common/PhoneGetResult
    //   336: dup
    //   337: sipush -20014
    //   340: invokespecial 78	dualsim/common/PhoneGetResult:<init>	(I)V
    //   343: areturn
    //   344: aload 6
    //   346: invokevirtual 240	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   349: ifeq +14 -> 363
    //   352: new 75	dualsim/common/PhoneGetResult
    //   355: dup
    //   356: sipush -20010
    //   359: invokespecial 78	dualsim/common/PhoneGetResult:<init>	(I)V
    //   362: areturn
    //   363: aload 7
    //   365: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: astore 4
    //   370: ldc 124
    //   372: new 179	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   379: ldc 253
    //   381: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload 4
    //   386: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 131	tmsdkdual/m:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   395: new 255	org/json/JSONObject
    //   398: dup
    //   399: aload 4
    //   401: invokespecial 258	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   404: astore 5
    //   406: aload 5
    //   408: ldc_w 259
    //   411: invokevirtual 261	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   414: istore_1
    //   415: aload 5
    //   417: ldc_w 263
    //   420: invokevirtual 261	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   423: istore_2
    //   424: aload 5
    //   426: ldc_w 265
    //   429: invokevirtual 261	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   432: istore_3
    //   433: aconst_null
    //   434: astore 4
    //   436: aload 5
    //   438: ldc_w 267
    //   441: invokevirtual 270	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   444: ifne +13 -> 457
    //   447: aload 5
    //   449: ldc_w 267
    //   452: invokevirtual 273	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   455: astore 4
    //   457: aload 4
    //   459: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   462: ifne +119 -> 581
    //   465: aload 4
    //   467: invokevirtual 276	java/lang/String:length	()I
    //   470: iconst_2
    //   471: if_icmple +110 -> 581
    //   474: aload 4
    //   476: ldc_w 278
    //   479: invokevirtual 90	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   482: ifeq +99 -> 581
    //   485: aload 4
    //   487: iconst_2
    //   488: invokevirtual 282	java/lang/String:substring	(I)Ljava/lang/String;
    //   491: astore 4
    //   493: new 75	dualsim/common/PhoneGetResult
    //   496: dup
    //   497: iconst_0
    //   498: invokespecial 78	dualsim/common/PhoneGetResult:<init>	(I)V
    //   501: astore 5
    //   503: aload 5
    //   505: aload 4
    //   507: putfield 285	dualsim/common/PhoneGetResult:innerPhoneNumber	Ljava/lang/String;
    //   510: aload 5
    //   512: iload_1
    //   513: putfield 196	dualsim/common/PhoneGetResult:result	I
    //   516: aload 5
    //   518: iload_2
    //   519: putfield 288	dualsim/common/PhoneGetResult:respType	I
    //   522: aload 5
    //   524: iload_3
    //   525: putfield 291	dualsim/common/PhoneGetResult:respCode	I
    //   528: aload 5
    //   530: iconst_2
    //   531: putfield 294	dualsim/common/PhoneGetResult:queryType	I
    //   534: new 202	tmsdkdual/e
    //   537: dup
    //   538: invokespecial 203	tmsdkdual/e:<init>	()V
    //   541: aload 5
    //   543: invokevirtual 206	tmsdkdual/e:a	(Ldualsim/common/PhoneGetResult;)V
    //   546: iload_1
    //   547: ifeq +14 -> 561
    //   550: new 75	dualsim/common/PhoneGetResult
    //   553: dup
    //   554: sipush -20015
    //   557: invokespecial 78	dualsim/common/PhoneGetResult:<init>	(I)V
    //   560: areturn
    //   561: new 75	dualsim/common/PhoneGetResult
    //   564: dup
    //   565: iconst_0
    //   566: invokespecial 78	dualsim/common/PhoneGetResult:<init>	(I)V
    //   569: astore 5
    //   571: aload 5
    //   573: aload 4
    //   575: putfield 135	dualsim/common/PhoneGetResult:phoneNumber	Ljava/lang/String;
    //   578: aload 5
    //   580: areturn
    //   581: goto -88 -> 493
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	584	0	this	b
    //   414	133	1	i	int
    //   423	96	2	j	int
    //   432	93	3	m	int
    //   47	176	4	localObject1	Object
    //   233	3	4	localJSONException	org.json.JSONException
    //   251	1	4	localThrowable	Throwable
    //   268	3	4	localPhoneGetResult	PhoneGetResult
    //   273	3	4	localException	Exception
    //   368	206	4	str1	String
    //   57	522	5	localObject2	Object
    //   125	220	6	localAtomicInteger	AtomicInteger
    //   134	230	7	localStringBuilder	StringBuilder
    //   161	93	8	localCountDownLatch	CountDownLatch
    //   291	3	8	localInterruptedException	java.lang.InterruptedException
    //   3	161	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   30	67	233	org/json/JSONException
    //   72	82	233	org/json/JSONException
    //   82	98	233	org/json/JSONException
    //   98	109	233	org/json/JSONException
    //   109	163	233	org/json/JSONException
    //   163	186	233	org/json/JSONException
    //   186	198	233	org/json/JSONException
    //   198	230	233	org/json/JSONException
    //   253	270	233	org/json/JSONException
    //   293	298	233	org/json/JSONException
    //   301	323	233	org/json/JSONException
    //   323	344	233	org/json/JSONException
    //   344	363	233	org/json/JSONException
    //   363	433	233	org/json/JSONException
    //   436	457	233	org/json/JSONException
    //   457	493	233	org/json/JSONException
    //   493	546	233	org/json/JSONException
    //   550	561	233	org/json/JSONException
    //   561	578	233	org/json/JSONException
    //   163	186	251	java/lang/Throwable
    //   30	67	273	java/lang/Exception
    //   72	82	273	java/lang/Exception
    //   82	98	273	java/lang/Exception
    //   98	109	273	java/lang/Exception
    //   109	163	273	java/lang/Exception
    //   163	186	273	java/lang/Exception
    //   186	198	273	java/lang/Exception
    //   198	230	273	java/lang/Exception
    //   253	270	273	java/lang/Exception
    //   293	298	273	java/lang/Exception
    //   301	323	273	java/lang/Exception
    //   323	344	273	java/lang/Exception
    //   344	363	273	java/lang/Exception
    //   363	433	273	java/lang/Exception
    //   436	457	273	java/lang/Exception
    //   457	493	273	java/lang/Exception
    //   493	546	273	java/lang/Exception
    //   550	561	273	java/lang/Exception
    //   561	578	273	java/lang/Exception
    //   186	198	291	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     tmsdkdual.b
 * JD-Core Version:    0.7.0.1
 */