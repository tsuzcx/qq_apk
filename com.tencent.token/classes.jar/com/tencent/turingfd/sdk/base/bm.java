package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class bm
{
  public static bm a = new bm();
  public static long b = TimeUnit.MINUTES.toMillis(30L);
  public en c;
  public Handler d;
  public boolean e = false;
  public bp f;
  public bg g;
  public AtomicReference h = new AtomicReference(Boolean.valueOf(false));
  public ak i = new ak(10);
  
  public static bm a()
  {
    return a;
  }
  
  public final bg a(Context paramContext)
  {
    label201:
    for (;;)
    {
      try
      {
        if (this.g == null) {
          this.g = this.f.b(paramContext);
        }
        bg localbg = this.g;
        int j;
        if (localbg.d != 0)
        {
          j = 2;
          if (j == 1)
          {
            paramContext = this.g;
            return paramContext;
          }
        }
        else
        {
          if (System.currentTimeMillis() / 1000L < localbg.c) {
            break label201;
          }
          j = 3;
          continue;
        }
        if (j == 2)
        {
          if ("main".equals(Thread.currentThread().getName()))
          {
            if (!((Boolean)this.h.get()).booleanValue())
            {
              this.h.set(Boolean.valueOf(true));
              this.d.sendEmptyMessage(2);
            }
            paramContext = bg.a(-10008);
          }
          else
          {
            this.g = a(paramContext, false);
            paramContext = this.g;
          }
        }
        else if ((j == 3) && (!((Boolean)this.h.get()).booleanValue()))
        {
          this.h.set(Boolean.valueOf(true));
          this.d.sendEmptyMessage(2);
          continue;
          j = 1;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public final bg a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 45	java/lang/Object:<init>	()V
    //   7: astore_3
    //   8: new 49	java/util/concurrent/atomic/AtomicReference
    //   11: dup
    //   12: invokespecial 149	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   15: astore 4
    //   17: new 49	java/util/concurrent/atomic/AtomicReference
    //   20: dup
    //   21: invokespecial 149	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: iconst_0
    //   29: invokestatic 55	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   32: invokevirtual 133	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   35: aload 4
    //   37: sipush -10004
    //   40: invokestatic 144	com/tencent/turingfd/sdk/base/bg:a	(I)Lcom/tencent/turingfd/sdk/base/bg;
    //   43: invokevirtual 133	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   46: aload_0
    //   47: getfield 135	com/tencent/turingfd/sdk/base/bm:d	Landroid/os/Handler;
    //   50: new 151	com/tencent/turingfd/sdk/base/bj
    //   53: dup
    //   54: aload_0
    //   55: aload_1
    //   56: iload_2
    //   57: aload 4
    //   59: aload 5
    //   61: aload_3
    //   62: invokespecial 154	com/tencent/turingfd/sdk/base/bj:<init>	(Lcom/tencent/turingfd/sdk/base/bm;Landroid/content/Context;ZLjava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   65: invokevirtual 158	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   68: pop
    //   69: aload_3
    //   70: monitorenter
    //   71: aload_3
    //   72: aload_0
    //   73: getfield 82	com/tencent/turingfd/sdk/base/bm:c	Lcom/tencent/turingfd/sdk/base/en;
    //   76: getfield 162	com/tencent/turingfd/sdk/base/en:c	I
    //   79: i2l
    //   80: invokevirtual 166	java/lang/Object:wait	(J)V
    //   83: aload_3
    //   84: monitorexit
    //   85: aload 5
    //   87: iconst_1
    //   88: invokestatic 55	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   91: invokevirtual 133	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   94: aload 4
    //   96: invokevirtual 126	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   99: checkcast 91	com/tencent/turingfd/sdk/base/bg
    //   102: areturn
    //   103: astore_1
    //   104: aload_3
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: goto -26 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	bm
    //   0	112	1	paramContext	Context
    //   0	112	2	paramBoolean	boolean
    //   7	98	3	localObject	Object
    //   15	80	4	localAtomicReference1	AtomicReference
    //   24	62	5	localAtomicReference2	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   71	83	103	finally
    //   83	85	103	finally
    //   104	106	103	finally
    //   71	83	108	java/lang/InterruptedException
  }
  
  /* Error */
  public final bg b(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 170
    //   3: invokevirtual 176	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 178	android/net/ConnectivityManager
    //   9: astore 10
    //   11: aload 10
    //   13: ifnonnull +16 -> 29
    //   16: iconst_0
    //   17: istore_3
    //   18: iload_3
    //   19: ifne +90 -> 109
    //   22: sipush -10012
    //   25: invokestatic 144	com/tencent/turingfd/sdk/base/bg:a	(I)Lcom/tencent/turingfd/sdk/base/bg;
    //   28: areturn
    //   29: aload 10
    //   31: invokevirtual 182	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   34: astore 10
    //   36: aload 10
    //   38: ifnull +20 -> 58
    //   41: aload 10
    //   43: invokevirtual 187	android/net/NetworkInfo:isConnected	()Z
    //   46: istore 5
    //   48: iload 5
    //   50: ifeq +8 -> 58
    //   53: iconst_1
    //   54: istore_3
    //   55: goto -37 -> 18
    //   58: iconst_0
    //   59: istore_3
    //   60: goto -42 -> 18
    //   63: astore 10
    //   65: invokestatic 192	com/tencent/turingfd/sdk/base/bu:a	()Lcom/tencent/turingfd/sdk/base/bu;
    //   68: aload 10
    //   70: invokevirtual 195	com/tencent/turingfd/sdk/base/bu:a	(Ljava/lang/Throwable;)V
    //   73: aload 10
    //   75: invokevirtual 198	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   78: astore 10
    //   80: iconst_0
    //   81: istore 4
    //   83: iload 4
    //   85: istore_3
    //   86: aload 10
    //   88: ifnull -70 -> 18
    //   91: iload 4
    //   93: istore_3
    //   94: aload 10
    //   96: ldc 200
    //   98: invokevirtual 204	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq -83 -> 18
    //   104: iconst_1
    //   105: istore_3
    //   106: goto -88 -> 18
    //   109: aload_0
    //   110: getfield 67	com/tencent/turingfd/sdk/base/bm:i	Lcom/tencent/turingfd/sdk/base/ak;
    //   113: invokevirtual 206	com/tencent/turingfd/sdk/base/ak:a	()Ljava/lang/Object;
    //   116: astore 10
    //   118: aload 10
    //   120: ifnonnull +16 -> 136
    //   123: iconst_1
    //   124: istore_3
    //   125: iload_3
    //   126: ifne +58 -> 184
    //   129: sipush -10011
    //   132: invokestatic 144	com/tencent/turingfd/sdk/base/bg:a	(I)Lcom/tencent/turingfd/sdk/base/bg;
    //   135: areturn
    //   136: aload 10
    //   138: checkcast 208	java/lang/Long
    //   141: astore 10
    //   143: aload_0
    //   144: getfield 67	com/tencent/turingfd/sdk/base/bm:i	Lcom/tencent/turingfd/sdk/base/ak;
    //   147: invokevirtual 211	com/tencent/turingfd/sdk/base/ak:b	()I
    //   150: aload_0
    //   151: getfield 67	com/tencent/turingfd/sdk/base/bm:i	Lcom/tencent/turingfd/sdk/base/ak;
    //   154: getfield 213	com/tencent/turingfd/sdk/base/ak:a	I
    //   157: if_icmplt -34 -> 123
    //   160: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   163: aload 10
    //   165: invokevirtual 216	java/lang/Long:longValue	()J
    //   168: lsub
    //   169: invokestatic 221	java/lang/Math:abs	(J)J
    //   172: getstatic 43	com/tencent/turingfd/sdk/base/bm:b	J
    //   175: lcmp
    //   176: ifge -53 -> 123
    //   179: iconst_0
    //   180: istore_3
    //   181: goto -56 -> 125
    //   184: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   187: lstore 6
    //   189: aload_1
    //   190: invokestatic 226	com/tencent/turingfd/sdk/base/ed:g	(Landroid/content/Context;)I
    //   193: bipush 10
    //   195: if_icmplt +43 -> 238
    //   198: iconst_1
    //   199: istore_3
    //   200: iload_3
    //   201: ifeq +42 -> 243
    //   204: sipush -10005
    //   207: invokestatic 144	com/tencent/turingfd/sdk/base/bg:a	(I)Lcom/tencent/turingfd/sdk/base/bg;
    //   210: astore 10
    //   212: aload 10
    //   214: getfield 94	com/tencent/turingfd/sdk/base/bg:d	I
    //   217: ifeq +1255 -> 1472
    //   220: aload 10
    //   222: astore_1
    //   223: aload_0
    //   224: getfield 67	com/tencent/turingfd/sdk/base/bm:i	Lcom/tencent/turingfd/sdk/base/ak;
    //   227: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   230: invokestatic 229	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   233: invokevirtual 231	com/tencent/turingfd/sdk/base/ak:a	(Ljava/lang/Object;)V
    //   236: aload_1
    //   237: areturn
    //   238: iconst_0
    //   239: istore_3
    //   240: goto -40 -> 200
    //   243: new 233	java/util/HashMap
    //   246: dup
    //   247: invokespecial 234	java/util/HashMap:<init>	()V
    //   250: astore 12
    //   252: getstatic 239	com/tencent/turingfd/sdk/base/ca:b	Lcom/tencent/turingfd/sdk/base/cc;
    //   255: astore 10
    //   257: aload 10
    //   259: ifnull +762 -> 1021
    //   262: aload 10
    //   264: getfield 243	com/tencent/turingfd/sdk/base/cc:b	I
    //   267: ifeq +754 -> 1021
    //   270: aload 12
    //   272: ldc 245
    //   274: aload 10
    //   276: getfield 248	com/tencent/turingfd/sdk/base/cc:a	Ljava/lang/String;
    //   279: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   282: pop
    //   283: aload 12
    //   285: ldc 254
    //   287: aload_0
    //   288: getfield 82	com/tencent/turingfd/sdk/base/bm:c	Lcom/tencent/turingfd/sdk/base/en;
    //   291: getfield 256	com/tencent/turingfd/sdk/base/en:e	Ljava/lang/String;
    //   294: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   297: pop
    //   298: aload 12
    //   300: ldc_w 258
    //   303: aload_1
    //   304: invokestatic 263	com/tencent/turingfd/sdk/base/d:b	(Landroid/content/Context;)Ljava/lang/String;
    //   307: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   310: pop
    //   311: aload 12
    //   313: ldc_w 265
    //   316: aload_0
    //   317: getfield 85	com/tencent/turingfd/sdk/base/bm:f	Lcom/tencent/turingfd/sdk/base/bp;
    //   320: aload_1
    //   321: invokevirtual 89	com/tencent/turingfd/sdk/base/bp:b	(Landroid/content/Context;)Lcom/tencent/turingfd/sdk/base/bg;
    //   324: getfield 267	com/tencent/turingfd/sdk/base/bg:b	Ljava/lang/String;
    //   327: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   330: pop
    //   331: aload 12
    //   333: ldc_w 269
    //   336: aload_0
    //   337: getfield 82	com/tencent/turingfd/sdk/base/bm:c	Lcom/tencent/turingfd/sdk/base/en;
    //   340: getfield 270	com/tencent/turingfd/sdk/base/en:b	Ljava/lang/String;
    //   343: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   346: pop
    //   347: aload 12
    //   349: ldc_w 272
    //   352: aload_1
    //   353: iload_2
    //   354: invokestatic 277	com/tencent/turingfd/sdk/base/bw:a	(Landroid/content/Context;Z)Ljava/lang/String;
    //   357: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   360: pop
    //   361: aload_1
    //   362: invokestatic 279	com/tencent/turingfd/sdk/base/ed:c	(Landroid/content/Context;)Ljava/lang/String;
    //   365: astore 11
    //   367: aload 11
    //   369: astore 10
    //   371: aload 11
    //   373: ifnonnull +8 -> 381
    //   376: ldc_w 281
    //   379: astore 10
    //   381: aload 12
    //   383: ldc_w 283
    //   386: aload 10
    //   388: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: pop
    //   392: aload_1
    //   393: invokestatic 287	com/tencent/turingfd/sdk/base/l:b	(Landroid/content/Context;)I
    //   396: ifle +735 -> 1131
    //   399: ldc_w 289
    //   402: astore 10
    //   404: aload 12
    //   406: ldc_w 291
    //   409: aload 10
    //   411: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   414: pop
    //   415: aload_1
    //   416: invokevirtual 295	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   419: astore 10
    //   421: aload 10
    //   423: ldc_w 297
    //   426: iconst_0
    //   427: invokestatic 303	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   430: istore_3
    //   431: iload_3
    //   432: ifeq +709 -> 1141
    //   435: iconst_1
    //   436: istore_3
    //   437: iload_3
    //   438: ifeq +708 -> 1146
    //   441: ldc_w 289
    //   444: astore 10
    //   446: aload 12
    //   448: ldc_w 305
    //   451: aload 10
    //   453: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   456: pop
    //   457: new 307	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   464: ldc_w 281
    //   467: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: astore 10
    //   472: getstatic 317	android/os/Build$VERSION:SDK_INT	I
    //   475: bipush 24
    //   477: if_icmplt +677 -> 1154
    //   480: iconst_0
    //   481: istore_3
    //   482: aload 12
    //   484: ldc_w 319
    //   487: aload 10
    //   489: iload_3
    //   490: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   493: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   499: pop
    //   500: new 307	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   507: ldc_w 281
    //   510: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: astore 11
    //   515: new 327	android/content/IntentFilter
    //   518: dup
    //   519: ldc_w 329
    //   522: invokespecial 332	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   525: astore 10
    //   527: aload_1
    //   528: aconst_null
    //   529: aload 10
    //   531: invokevirtual 336	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   534: astore 10
    //   536: aload 10
    //   538: ifnonnull +733 -> 1271
    //   541: iconst_0
    //   542: istore_3
    //   543: aload 12
    //   545: ldc_w 338
    //   548: aload 11
    //   550: iload_3
    //   551: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   554: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   560: pop
    //   561: aload 12
    //   563: ldc_w 340
    //   566: new 307	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   573: ldc_w 281
    //   576: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: aload_1
    //   580: invokestatic 344	com/tencent/turingfd/sdk/base/c:a	(Landroid/content/Context;)I
    //   583: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   586: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   592: pop
    //   593: invokestatic 349	com/tencent/turingfd/sdk/base/h:a	()Ljava/util/List;
    //   596: invokeinterface 355 1 0
    //   601: astore 10
    //   603: aload 10
    //   605: invokeinterface 360 1 0
    //   610: ifeq +727 -> 1337
    //   613: aload 10
    //   615: invokeinterface 363 1 0
    //   620: checkcast 365	com/tencent/turingfd/sdk/base/Fig
    //   623: astore 11
    //   625: aload 11
    //   627: getfield 368	com/tencent/turingfd/sdk/base/Fig:vc	Ljava/lang/String;
    //   630: getstatic 372	com/tencent/turingfd/sdk/base/dk:h	Ljava/lang/String;
    //   633: invokevirtual 204	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   636: ifeq -33 -> 603
    //   639: aload 11
    //   641: getfield 375	com/tencent/turingfd/sdk/base/Fig:wc	Ljava/lang/String;
    //   644: astore 10
    //   646: aload 10
    //   648: astore 11
    //   650: aload 10
    //   652: ifnonnull +8 -> 660
    //   655: ldc_w 281
    //   658: astore 11
    //   660: aload 12
    //   662: ldc_w 377
    //   665: aload 11
    //   667: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   670: pop
    //   671: aload_1
    //   672: invokestatic 382	com/tencent/turingfd/sdk/base/k:b	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   675: astore 10
    //   677: aload 10
    //   679: invokeinterface 385 1 0
    //   684: ifeq +661 -> 1345
    //   687: aload 10
    //   689: iconst_0
    //   690: invokeinterface 388 2 0
    //   695: checkcast 365	com/tencent/turingfd/sdk/base/Fig
    //   698: getfield 375	com/tencent/turingfd/sdk/base/Fig:wc	Ljava/lang/String;
    //   701: astore 10
    //   703: aload 10
    //   705: astore 11
    //   707: aload 10
    //   709: ifnonnull +8 -> 717
    //   712: ldc_w 281
    //   715: astore 11
    //   717: aload 12
    //   719: ldc_w 390
    //   722: aload 11
    //   724: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   727: pop
    //   728: aload 12
    //   730: ldc_w 392
    //   733: aload_0
    //   734: getfield 85	com/tencent/turingfd/sdk/base/bm:f	Lcom/tencent/turingfd/sdk/base/bp;
    //   737: aload_1
    //   738: invokevirtual 394	com/tencent/turingfd/sdk/base/bp:e	(Landroid/content/Context;)Ljava/lang/String;
    //   741: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   744: pop
    //   745: aload 12
    //   747: ldc_w 396
    //   750: aload_0
    //   751: getfield 85	com/tencent/turingfd/sdk/base/bm:f	Lcom/tencent/turingfd/sdk/base/bp;
    //   754: aload_1
    //   755: invokevirtual 398	com/tencent/turingfd/sdk/base/bp:d	(Landroid/content/Context;)Ljava/lang/String;
    //   758: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   761: pop
    //   762: aload 12
    //   764: ldc_w 400
    //   767: aload_0
    //   768: getfield 85	com/tencent/turingfd/sdk/base/bm:f	Lcom/tencent/turingfd/sdk/base/bp;
    //   771: aload_1
    //   772: invokevirtual 401	com/tencent/turingfd/sdk/base/bp:c	(Landroid/content/Context;)Ljava/lang/String;
    //   775: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   778: pop
    //   779: aload 12
    //   781: ldc_w 403
    //   784: invokestatic 405	com/tencent/turingfd/sdk/base/d:b	()Ljava/lang/String;
    //   787: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   790: pop
    //   791: new 307	java/lang/StringBuilder
    //   794: dup
    //   795: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   798: ldc_w 281
    //   801: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: astore 10
    //   806: aload_1
    //   807: ldc 170
    //   809: invokevirtual 176	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   812: checkcast 178	android/net/ConnectivityManager
    //   815: invokevirtual 182	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   818: astore 11
    //   820: aload 11
    //   822: ifnull +33 -> 855
    //   825: aload 11
    //   827: invokevirtual 409	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   830: getstatic 415	android/net/NetworkInfo$State:CONNECTING	Landroid/net/NetworkInfo$State;
    //   833: if_acmpeq +520 -> 1353
    //   836: aload 11
    //   838: invokevirtual 409	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   841: astore 13
    //   843: getstatic 418	android/net/NetworkInfo$State:CONNECTED	Landroid/net/NetworkInfo$State;
    //   846: astore 14
    //   848: aload 13
    //   850: aload 14
    //   852: if_acmpeq +501 -> 1353
    //   855: iconst_m1
    //   856: istore_3
    //   857: aload 12
    //   859: ldc_w 420
    //   862: aload 10
    //   864: iload_3
    //   865: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   868: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   874: pop
    //   875: iload_2
    //   876: ifeq +15 -> 891
    //   879: aload 12
    //   881: ldc_w 422
    //   884: ldc_w 289
    //   887: invokevirtual 252	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   890: pop
    //   891: aload_1
    //   892: ldc_w 424
    //   895: aload_1
    //   896: ldc_w 426
    //   899: iconst_0
    //   900: invokevirtual 430	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   903: ldc_w 424
    //   906: iconst_0
    //   907: invokeinterface 435 3 0
    //   912: invokestatic 438	com/tencent/turingfd/sdk/base/ed:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   915: invokestatic 441	com/tencent/turingfd/sdk/base/ed:d	()Landroid/util/SparseArray;
    //   918: aload_1
    //   919: aload 12
    //   921: iconst_1
    //   922: invokestatic 446	com/tencent/turingfd/sdk/base/TuringDIDService$aa:a	(Landroid/util/SparseArray;Landroid/content/Context;Ljava/util/Map;I)Landroid/util/SparseArray;
    //   925: astore 10
    //   927: aload_1
    //   928: ldc_w 424
    //   931: iconst_0
    //   932: invokestatic 438	com/tencent/turingfd/sdk/base/ed:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   935: aload_0
    //   936: getfield 85	com/tencent/turingfd/sdk/base/bm:f	Lcom/tencent/turingfd/sdk/base/bp;
    //   939: aload_1
    //   940: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   943: lload 6
    //   945: lsub
    //   946: invokevirtual 449	com/tencent/turingfd/sdk/base/bp:c	(Landroid/content/Context;J)V
    //   949: aload 10
    //   951: invokestatic 452	com/tencent/turingfd/sdk/base/ed:a	(Landroid/util/SparseArray;)I
    //   954: istore_3
    //   955: aload 10
    //   957: iconst_1
    //   958: ldc_w 454
    //   961: invokestatic 457	com/tencent/turingfd/sdk/base/ed:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   964: checkcast 454	[B
    //   967: astore 11
    //   969: aload 11
    //   971: astore 10
    //   973: aload 11
    //   975: ifnonnull +8 -> 983
    //   978: iconst_0
    //   979: newarray byte
    //   981: astore 10
    //   983: aload_0
    //   984: getfield 85	com/tencent/turingfd/sdk/base/bm:f	Lcom/tencent/turingfd/sdk/base/bp;
    //   987: aload_1
    //   988: aload 10
    //   990: arraylength
    //   991: i2l
    //   992: invokevirtual 459	com/tencent/turingfd/sdk/base/bp:b	(Landroid/content/Context;J)V
    //   995: aload_0
    //   996: getfield 82	com/tencent/turingfd/sdk/base/bm:c	Lcom/tencent/turingfd/sdk/base/en;
    //   999: invokevirtual 461	com/tencent/turingfd/sdk/base/en:a	()V
    //   1002: iload_3
    //   1003: ifne +439 -> 1442
    //   1006: new 91	com/tencent/turingfd/sdk/base/bg
    //   1009: dup
    //   1010: iconst_0
    //   1011: aload 10
    //   1013: invokespecial 464	com/tencent/turingfd/sdk/base/bg:<init>	(I[B)V
    //   1016: astore 10
    //   1018: goto -806 -> 212
    //   1021: getstatic 467	com/tencent/turingfd/sdk/base/ca:a	Ljava/util/Map;
    //   1024: getstatic 469	com/tencent/turingfd/sdk/base/ca:c	Ljava/lang/String;
    //   1027: invokeinterface 474 2 0
    //   1032: ifne +13 -> 1045
    //   1035: bipush 246
    //   1037: invokestatic 477	com/tencent/turingfd/sdk/base/cc:a	(I)Lcom/tencent/turingfd/sdk/base/cc;
    //   1040: astore 10
    //   1042: goto -772 -> 270
    //   1045: ldc 106
    //   1047: invokestatic 112	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1050: invokevirtual 116	java/lang/Thread:getName	()Ljava/lang/String;
    //   1053: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1056: ifeq +13 -> 1069
    //   1059: bipush 245
    //   1061: invokestatic 477	com/tencent/turingfd/sdk/base/cc:a	(I)Lcom/tencent/turingfd/sdk/base/cc;
    //   1064: astore 10
    //   1066: goto -796 -> 270
    //   1069: getstatic 467	com/tencent/turingfd/sdk/base/ca:a	Ljava/util/Map;
    //   1072: getstatic 469	com/tencent/turingfd/sdk/base/ca:c	Ljava/lang/String;
    //   1075: invokeinterface 480 2 0
    //   1080: checkcast 482	com/tencent/turingfd/sdk/base/cb
    //   1083: astore 10
    //   1085: aload 10
    //   1087: ifnull +36 -> 1123
    //   1090: aload 10
    //   1092: getfield 483	com/tencent/turingfd/sdk/base/cb:b	I
    //   1095: istore_3
    //   1096: iload_3
    //   1097: iconst_3
    //   1098: if_icmpgt +25 -> 1123
    //   1101: aload 10
    //   1103: iload_3
    //   1104: iconst_1
    //   1105: iadd
    //   1106: putfield 483	com/tencent/turingfd/sdk/base/cb:b	I
    //   1109: aload 10
    //   1111: invokestatic 486	com/tencent/turingfd/sdk/base/cb:a	(Lcom/tencent/turingfd/sdk/base/cb;)Lcom/tencent/turingfd/sdk/base/bx;
    //   1114: aload_1
    //   1115: invokeinterface 491 2 0
    //   1120: putstatic 239	com/tencent/turingfd/sdk/base/ca:b	Lcom/tencent/turingfd/sdk/base/cc;
    //   1123: getstatic 239	com/tencent/turingfd/sdk/base/ca:b	Lcom/tencent/turingfd/sdk/base/cc;
    //   1126: astore 10
    //   1128: goto -858 -> 270
    //   1131: ldc_w 493
    //   1134: astore 10
    //   1136: goto -732 -> 404
    //   1139: astore 10
    //   1141: iconst_0
    //   1142: istore_3
    //   1143: goto -706 -> 437
    //   1146: ldc_w 493
    //   1149: astore 10
    //   1151: goto -705 -> 446
    //   1154: new 495	java/io/File
    //   1157: dup
    //   1158: getstatic 501	com/tencent/turingfd/sdk/base/db:aj	[I
    //   1161: invokestatic 504	com/tencent/turingfd/sdk/base/db:a	([I)Ljava/lang/String;
    //   1164: invokespecial 505	java/io/File:<init>	(Ljava/lang/String;)V
    //   1167: invokestatic 508	com/tencent/turingfd/sdk/base/ed:a	(Ljava/io/File;)Ljava/lang/String;
    //   1170: astore 11
    //   1172: aload 11
    //   1174: invokestatic 513	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1177: ifne -697 -> 480
    //   1180: ldc_w 515
    //   1183: aload 11
    //   1185: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1188: ifeq +43 -> 1231
    //   1191: iconst_0
    //   1192: istore_3
    //   1193: aload_1
    //   1194: invokevirtual 295	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1197: astore 11
    //   1199: aload 11
    //   1201: ldc_w 517
    //   1204: iconst_0
    //   1205: invokestatic 303	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   1208: istore 4
    //   1210: iload 4
    //   1212: ifle +14 -> 1226
    //   1215: iconst_1
    //   1216: istore_3
    //   1217: iload_3
    //   1218: ifeq +40 -> 1258
    //   1221: iconst_1
    //   1222: istore_3
    //   1223: goto -741 -> 482
    //   1226: iconst_0
    //   1227: istore_3
    //   1228: goto -11 -> 1217
    //   1231: ldc_w 519
    //   1234: aload 11
    //   1236: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1239: ifeq +8 -> 1247
    //   1242: iconst_2
    //   1243: istore_3
    //   1244: goto -762 -> 482
    //   1247: ldc_w 520
    //   1250: aload 11
    //   1252: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1255: ifeq -775 -> 480
    //   1258: iconst_3
    //   1259: istore_3
    //   1260: goto -778 -> 482
    //   1263: astore 10
    //   1265: aconst_null
    //   1266: astore 10
    //   1268: goto -732 -> 536
    //   1271: aload 10
    //   1273: ldc_w 522
    //   1276: iconst_m1
    //   1277: invokevirtual 527	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1280: istore_3
    //   1281: iload_3
    //   1282: iconst_2
    //   1283: if_icmpeq +8 -> 1291
    //   1286: iload_3
    //   1287: iconst_5
    //   1288: if_icmpne +14 -> 1302
    //   1291: iconst_1
    //   1292: istore_3
    //   1293: iload_3
    //   1294: ifne +13 -> 1307
    //   1297: iconst_1
    //   1298: istore_3
    //   1299: goto -756 -> 543
    //   1302: iconst_0
    //   1303: istore_3
    //   1304: goto -11 -> 1293
    //   1307: aload 10
    //   1309: ldc_w 529
    //   1312: iconst_m1
    //   1313: invokevirtual 527	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1316: istore_3
    //   1317: iload_3
    //   1318: iconst_2
    //   1319: if_icmpne +8 -> 1327
    //   1322: iconst_3
    //   1323: istore_3
    //   1324: goto -781 -> 543
    //   1327: iload_3
    //   1328: iconst_1
    //   1329: if_icmpne -788 -> 541
    //   1332: iconst_2
    //   1333: istore_3
    //   1334: goto -791 -> 543
    //   1337: ldc_w 281
    //   1340: astore 10
    //   1342: goto -696 -> 646
    //   1345: ldc_w 281
    //   1348: astore 10
    //   1350: goto -647 -> 703
    //   1353: aload 11
    //   1355: invokevirtual 532	android/net/NetworkInfo:getType	()I
    //   1358: iconst_1
    //   1359: if_icmpne +8 -> 1367
    //   1362: iconst_0
    //   1363: istore_3
    //   1364: goto -507 -> 857
    //   1367: aload 11
    //   1369: invokevirtual 532	android/net/NetworkInfo:getType	()I
    //   1372: ifne -517 -> 855
    //   1375: invokestatic 537	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   1378: ifnonnull +14 -> 1392
    //   1381: aload_1
    //   1382: invokestatic 540	android/net/Proxy:getHost	(Landroid/content/Context;)Ljava/lang/String;
    //   1385: astore 11
    //   1387: aload 11
    //   1389: ifnull +8 -> 1397
    //   1392: iconst_2
    //   1393: istore_3
    //   1394: goto -537 -> 857
    //   1397: iconst_1
    //   1398: istore_3
    //   1399: goto -542 -> 857
    //   1402: astore 11
    //   1404: aload 11
    //   1406: invokevirtual 198	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1409: astore 11
    //   1411: bipush 253
    //   1413: istore 4
    //   1415: iload 4
    //   1417: istore_3
    //   1418: aload 11
    //   1420: ifnull -563 -> 857
    //   1423: iload 4
    //   1425: istore_3
    //   1426: aload 11
    //   1428: ldc 200
    //   1430: invokevirtual 204	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1433: ifeq -576 -> 857
    //   1436: bipush 254
    //   1438: istore_3
    //   1439: goto -582 -> 857
    //   1442: iload_3
    //   1443: invokestatic 144	com/tencent/turingfd/sdk/base/bg:a	(I)Lcom/tencent/turingfd/sdk/base/bg;
    //   1446: astore 10
    //   1448: goto -1236 -> 212
    //   1451: astore 10
    //   1453: invokestatic 192	com/tencent/turingfd/sdk/base/bu:a	()Lcom/tencent/turingfd/sdk/base/bu;
    //   1456: aload 10
    //   1458: invokevirtual 542	com/tencent/turingfd/sdk/base/bu:b	(Ljava/lang/Throwable;)V
    //   1461: sipush -10006
    //   1464: invokestatic 144	com/tencent/turingfd/sdk/base/bg:a	(I)Lcom/tencent/turingfd/sdk/base/bg;
    //   1467: astore 10
    //   1469: goto -1257 -> 212
    //   1472: aload 10
    //   1474: getfield 544	com/tencent/turingfd/sdk/base/bg:e	[B
    //   1477: astore 11
    //   1479: aload 11
    //   1481: ifnull +9 -> 1490
    //   1484: aload 11
    //   1486: arraylength
    //   1487: ifne +13 -> 1500
    //   1490: sipush -10003
    //   1493: invokestatic 144	com/tencent/turingfd/sdk/base/bg:a	(I)Lcom/tencent/turingfd/sdk/base/bg;
    //   1496: astore_1
    //   1497: goto -1274 -> 223
    //   1500: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   1503: lstore 6
    //   1505: aload_0
    //   1506: getfield 82	com/tencent/turingfd/sdk/base/bm:c	Lcom/tencent/turingfd/sdk/base/en;
    //   1509: invokevirtual 547	com/tencent/turingfd/sdk/base/en:b	()Lcom/tencent/turingfd/sdk/base/dg;
    //   1512: astore 11
    //   1514: aload 10
    //   1516: getfield 544	com/tencent/turingfd/sdk/base/bg:e	[B
    //   1519: astore 10
    //   1521: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   1524: pop2
    //   1525: aload 11
    //   1527: checkcast 549	com/tencent/turingfd/sdk/base/o
    //   1530: astore 11
    //   1532: aload 11
    //   1534: iconst_1
    //   1535: aload 10
    //   1537: invokevirtual 552	com/tencent/turingfd/sdk/base/o:a	(I[B)Lcom/tencent/turingfd/sdk/base/dh;
    //   1540: astore 10
    //   1542: aload 10
    //   1544: getfield 555	com/tencent/turingfd/sdk/base/dh:a	I
    //   1547: ifeq +37 -> 1584
    //   1550: aload 10
    //   1552: getfield 555	com/tencent/turingfd/sdk/base/dh:a	I
    //   1555: sipush 20000
    //   1558: isub
    //   1559: invokestatic 560	com/tencent/turingfd/sdk/base/bq:a	(I)Lcom/tencent/turingfd/sdk/base/bq;
    //   1562: astore 10
    //   1564: aload 10
    //   1566: invokevirtual 562	com/tencent/turingfd/sdk/base/bq:a	()I
    //   1569: ifeq +46 -> 1615
    //   1572: aload 10
    //   1574: invokevirtual 562	com/tencent/turingfd/sdk/base/bq:a	()I
    //   1577: invokestatic 144	com/tencent/turingfd/sdk/base/bg:a	(I)Lcom/tencent/turingfd/sdk/base/bg;
    //   1580: astore_1
    //   1581: goto -1358 -> 223
    //   1584: new 557	com/tencent/turingfd/sdk/base/bq
    //   1587: dup
    //   1588: iconst_0
    //   1589: aload 10
    //   1591: getfield 564	com/tencent/turingfd/sdk/base/dh:b	[B
    //   1594: invokespecial 565	com/tencent/turingfd/sdk/base/bq:<init>	(I[B)V
    //   1597: astore 10
    //   1599: goto -35 -> 1564
    //   1602: astore 10
    //   1604: sipush -20000
    //   1607: invokestatic 560	com/tencent/turingfd/sdk/base/bq:a	(I)Lcom/tencent/turingfd/sdk/base/bq;
    //   1610: astore 10
    //   1612: goto -48 -> 1564
    //   1615: aload_1
    //   1616: ldc 170
    //   1618: invokevirtual 176	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1621: checkcast 178	android/net/ConnectivityManager
    //   1624: invokevirtual 182	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   1627: astore 11
    //   1629: aload 11
    //   1631: ifnull +33 -> 1664
    //   1634: aload 11
    //   1636: invokevirtual 409	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   1639: getstatic 415	android/net/NetworkInfo$State:CONNECTING	Landroid/net/NetworkInfo$State;
    //   1642: if_acmpeq +71 -> 1713
    //   1645: aload 11
    //   1647: invokevirtual 409	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   1650: astore 12
    //   1652: getstatic 418	android/net/NetworkInfo$State:CONNECTED	Landroid/net/NetworkInfo$State;
    //   1655: astore 13
    //   1657: aload 12
    //   1659: aload 13
    //   1661: if_acmpeq +52 -> 1713
    //   1664: iconst_m1
    //   1665: istore_3
    //   1666: aload_0
    //   1667: getfield 85	com/tencent/turingfd/sdk/base/bm:f	Lcom/tencent/turingfd/sdk/base/bp;
    //   1670: aload_1
    //   1671: iload_3
    //   1672: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   1675: lload 6
    //   1677: lsub
    //   1678: invokevirtual 568	com/tencent/turingfd/sdk/base/bp:a	(Landroid/content/Context;IJ)V
    //   1681: invokestatic 441	com/tencent/turingfd/sdk/base/ed:d	()Landroid/util/SparseArray;
    //   1684: aload 10
    //   1686: getfield 570	com/tencent/turingfd/sdk/base/bq:c	[B
    //   1689: iconst_1
    //   1690: invokestatic 573	com/tencent/turingfd/sdk/base/TuringDIDService$aa:b	(Landroid/util/SparseArray;[BI)Landroid/util/SparseArray;
    //   1693: astore 14
    //   1695: aload 14
    //   1697: invokestatic 452	com/tencent/turingfd/sdk/base/ed:a	(Landroid/util/SparseArray;)I
    //   1700: istore_3
    //   1701: iload_3
    //   1702: ifeq +100 -> 1802
    //   1705: iload_3
    //   1706: invokestatic 144	com/tencent/turingfd/sdk/base/bg:a	(I)Lcom/tencent/turingfd/sdk/base/bg;
    //   1709: astore_1
    //   1710: goto -1487 -> 223
    //   1713: aload 11
    //   1715: invokevirtual 532	android/net/NetworkInfo:getType	()I
    //   1718: iconst_1
    //   1719: if_icmpne +6 -> 1725
    //   1722: goto +390 -> 2112
    //   1725: aload 11
    //   1727: invokevirtual 532	android/net/NetworkInfo:getType	()I
    //   1730: ifne -66 -> 1664
    //   1733: invokestatic 537	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   1736: ifnonnull +14 -> 1750
    //   1739: aload_1
    //   1740: invokestatic 540	android/net/Proxy:getHost	(Landroid/content/Context;)Ljava/lang/String;
    //   1743: astore 11
    //   1745: aload 11
    //   1747: ifnull +8 -> 1755
    //   1750: iconst_2
    //   1751: istore_3
    //   1752: goto -86 -> 1666
    //   1755: iconst_1
    //   1756: istore_3
    //   1757: goto -91 -> 1666
    //   1760: astore 11
    //   1762: aload 11
    //   1764: invokevirtual 198	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1767: astore 11
    //   1769: iconst_0
    //   1770: istore 4
    //   1772: iload 4
    //   1774: istore_3
    //   1775: aload 11
    //   1777: ifnull +18 -> 1795
    //   1780: iload 4
    //   1782: istore_3
    //   1783: aload 11
    //   1785: ldc 200
    //   1787: invokevirtual 204	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1790: ifeq +5 -> 1795
    //   1793: iconst_1
    //   1794: istore_3
    //   1795: iload_3
    //   1796: ifeq -132 -> 1664
    //   1799: goto +313 -> 2112
    //   1802: aload 14
    //   1804: bipush 102
    //   1806: ldc_w 575
    //   1809: invokestatic 457	com/tencent/turingfd/sdk/base/ed:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   1812: checkcast 575	java/lang/Integer
    //   1815: astore 12
    //   1817: aload 12
    //   1819: ifnonnull +13 -> 1832
    //   1822: sipush -30000
    //   1825: invokestatic 144	com/tencent/turingfd/sdk/base/bg:a	(I)Lcom/tencent/turingfd/sdk/base/bg;
    //   1828: astore_1
    //   1829: goto -1606 -> 223
    //   1832: aload 12
    //   1834: invokevirtual 578	java/lang/Integer:intValue	()I
    //   1837: ifge +19 -> 1856
    //   1840: aload 12
    //   1842: invokevirtual 578	java/lang/Integer:intValue	()I
    //   1845: sipush 30000
    //   1848: isub
    //   1849: invokestatic 144	com/tencent/turingfd/sdk/base/bg:a	(I)Lcom/tencent/turingfd/sdk/base/bg;
    //   1852: astore_1
    //   1853: goto -1630 -> 223
    //   1856: aload 14
    //   1858: bipush 101
    //   1860: ldc 118
    //   1862: invokestatic 457	com/tencent/turingfd/sdk/base/ed:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   1865: checkcast 118	java/lang/String
    //   1868: astore 11
    //   1870: aload 11
    //   1872: astore 10
    //   1874: aload 11
    //   1876: ifnonnull +8 -> 1884
    //   1879: ldc_w 281
    //   1882: astore 10
    //   1884: aload 10
    //   1886: invokestatic 513	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1889: ifeq +19 -> 1908
    //   1892: aload 12
    //   1894: invokevirtual 578	java/lang/Integer:intValue	()I
    //   1897: sipush 10010
    //   1900: isub
    //   1901: invokestatic 144	com/tencent/turingfd/sdk/base/bg:a	(I)Lcom/tencent/turingfd/sdk/base/bg;
    //   1904: astore_1
    //   1905: goto -1682 -> 223
    //   1908: aload 14
    //   1910: bipush 104
    //   1912: ldc 118
    //   1914: invokestatic 457	com/tencent/turingfd/sdk/base/ed:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   1917: checkcast 118	java/lang/String
    //   1920: astore 11
    //   1922: aload 11
    //   1924: ifnonnull +185 -> 2109
    //   1927: ldc_w 281
    //   1930: astore 11
    //   1932: aload 14
    //   1934: bipush 105
    //   1936: ldc 118
    //   1938: invokestatic 457	com/tencent/turingfd/sdk/base/ed:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   1941: checkcast 118	java/lang/String
    //   1944: astore 12
    //   1946: aload 12
    //   1948: ifnonnull +158 -> 2106
    //   1951: ldc_w 281
    //   1954: astore 12
    //   1956: aload 14
    //   1958: bipush 106
    //   1960: ldc 118
    //   1962: invokestatic 457	com/tencent/turingfd/sdk/base/ed:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   1965: checkcast 118	java/lang/String
    //   1968: astore 13
    //   1970: aload 13
    //   1972: ifnonnull +131 -> 2103
    //   1975: ldc_w 281
    //   1978: astore 13
    //   1980: aload 14
    //   1982: bipush 107
    //   1984: ldc_w 575
    //   1987: invokestatic 457	com/tencent/turingfd/sdk/base/ed:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   1990: checkcast 575	java/lang/Integer
    //   1993: astore 15
    //   1995: aload 15
    //   1997: astore 14
    //   1999: aload 15
    //   2001: ifnonnull +11 -> 2012
    //   2004: sipush 3600
    //   2007: invokestatic 581	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2010: astore 14
    //   2012: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   2015: ldc2_w 101
    //   2018: ldiv
    //   2019: lstore 6
    //   2021: aload 14
    //   2023: invokevirtual 578	java/lang/Integer:intValue	()I
    //   2026: i2l
    //   2027: lstore 8
    //   2029: iconst_0
    //   2030: invokestatic 584	com/tencent/turingfd/sdk/base/bg:b	(I)Lcom/tencent/turingfd/sdk/base/bh;
    //   2033: lload 6
    //   2035: lload 8
    //   2037: ladd
    //   2038: invokevirtual 589	com/tencent/turingfd/sdk/base/bh:a	(J)Lcom/tencent/turingfd/sdk/base/bh;
    //   2041: aload 10
    //   2043: invokevirtual 592	com/tencent/turingfd/sdk/base/bh:a	(Ljava/lang/String;)Lcom/tencent/turingfd/sdk/base/bh;
    //   2046: aload 11
    //   2048: invokevirtual 594	com/tencent/turingfd/sdk/base/bh:b	(Ljava/lang/String;)Lcom/tencent/turingfd/sdk/base/bh;
    //   2051: aload 12
    //   2053: invokevirtual 596	com/tencent/turingfd/sdk/base/bh:c	(Ljava/lang/String;)Lcom/tencent/turingfd/sdk/base/bh;
    //   2056: aload 13
    //   2058: invokevirtual 598	com/tencent/turingfd/sdk/base/bh:d	(Ljava/lang/String;)Lcom/tencent/turingfd/sdk/base/bh;
    //   2061: invokevirtual 601	com/tencent/turingfd/sdk/base/bh:a	()Lcom/tencent/turingfd/sdk/base/bg;
    //   2064: astore 10
    //   2066: aload_0
    //   2067: getfield 85	com/tencent/turingfd/sdk/base/bm:f	Lcom/tencent/turingfd/sdk/base/bp;
    //   2070: aload_1
    //   2071: aload 10
    //   2073: invokevirtual 604	com/tencent/turingfd/sdk/base/bp:a	(Landroid/content/Context;Lcom/tencent/turingfd/sdk/base/bg;)V
    //   2076: aload 10
    //   2078: astore_1
    //   2079: goto -1856 -> 223
    //   2082: astore_1
    //   2083: sipush -10007
    //   2086: invokestatic 144	com/tencent/turingfd/sdk/base/bg:a	(I)Lcom/tencent/turingfd/sdk/base/bg;
    //   2089: astore_1
    //   2090: goto -1867 -> 223
    //   2093: astore 11
    //   2095: goto -878 -> 1217
    //   2098: astore 10
    //   2100: goto -1977 -> 123
    //   2103: goto -123 -> 1980
    //   2106: goto -150 -> 1956
    //   2109: goto -177 -> 1932
    //   2112: iconst_0
    //   2113: istore_3
    //   2114: goto -448 -> 1666
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2117	0	this	bm
    //   0	2117	1	paramContext	Context
    //   0	2117	2	paramBoolean	boolean
    //   17	2097	3	j	int
    //   81	1700	4	k	int
    //   46	3	5	bool	boolean
    //   187	1847	6	l1	long
    //   2027	9	8	l2	long
    //   9	33	10	localObject1	Object
    //   63	11	10	localThrowable1	java.lang.Throwable
    //   78	1057	10	localObject2	Object
    //   1139	1	10	localThrowable2	java.lang.Throwable
    //   1149	1	10	str1	String
    //   1263	1	10	localThrowable3	java.lang.Throwable
    //   1266	181	10	localObject3	Object
    //   1451	6	10	localThrowable4	java.lang.Throwable
    //   1467	131	10	localObject4	Object
    //   1602	1	10	localThrowable5	java.lang.Throwable
    //   1610	467	10	localObject5	Object
    //   2098	1	10	localThrowable6	java.lang.Throwable
    //   365	1023	11	localObject6	Object
    //   1402	3	11	localThrowable7	java.lang.Throwable
    //   1409	337	11	localObject7	Object
    //   1760	3	11	localThrowable8	java.lang.Throwable
    //   1767	280	11	str2	String
    //   2093	1	11	localThrowable9	java.lang.Throwable
    //   250	1802	12	localObject8	Object
    //   841	1216	13	localObject9	Object
    //   846	1176	14	localObject10	Object
    //   1993	7	15	localInteger	java.lang.Integer
    // Exception table:
    //   from	to	target	type
    //   0	11	63	java/lang/Throwable
    //   29	36	63	java/lang/Throwable
    //   41	48	63	java/lang/Throwable
    //   415	421	1139	java/lang/Throwable
    //   421	431	1139	java/lang/Throwable
    //   527	536	1263	java/lang/Throwable
    //   806	820	1402	java/lang/Throwable
    //   825	848	1402	java/lang/Throwable
    //   1353	1362	1402	java/lang/Throwable
    //   1367	1387	1402	java/lang/Throwable
    //   915	927	1451	java/lang/Throwable
    //   1521	1525	1602	java/lang/Throwable
    //   1532	1564	1602	java/lang/Throwable
    //   1584	1599	1602	java/lang/Throwable
    //   1615	1629	1760	java/lang/Throwable
    //   1634	1657	1760	java/lang/Throwable
    //   1713	1722	1760	java/lang/Throwable
    //   1725	1745	1760	java/lang/Throwable
    //   1681	1695	2082	java/lang/Throwable
    //   1193	1199	2093	java/lang/Throwable
    //   1199	1210	2093	java/lang/Throwable
    //   109	118	2098	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bm
 * JD-Core Version:    0.7.0.1
 */