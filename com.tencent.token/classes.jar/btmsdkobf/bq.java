package btmsdkobf;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.token.aso;
import com.tmsdk.base.utils.HttpGetFile;
import com.tmsdk.base.utils.NetworkUtil;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class bq
{
  static final int[] gp = { 202 };
  static final String[] gq = { "00B1208638DE0FCD3E920886D658DAF6", "7CC749CFC0FB5677E6ABA342EDBDBA5A" };
  static bq gx = null;
  HashMap<bt, Class<?>> gr = new HashMap();
  HashMap<bt, aso> gs = new HashMap();
  HandlerThread gt = null;
  Handler gu = null;
  eb.a gv = null;
  private bs gw = null;
  
  private bq()
  {
    StringBuilder localStringBuilder = new StringBuilder("RoachManager-RoachManager-NEST_IDS:[");
    localStringBuilder.append(Arrays.toString(gp));
    localStringBuilder.append("]");
    bo.k(localStringBuilder.toString());
  }
  
  /* Error */
  public static bq Q()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 2
    //   5: monitorenter
    //   6: getstatic 41	btmsdkobf/bq:gx	Lbtmsdkobf/bq;
    //   9: ifnonnull +39 -> 48
    //   12: ldc 2
    //   14: monitorenter
    //   15: getstatic 41	btmsdkobf/bq:gx	Lbtmsdkobf/bq;
    //   18: ifnonnull +18 -> 36
    //   21: ldc 91
    //   23: invokestatic 87	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   26: new 2	btmsdkobf/bq
    //   29: dup
    //   30: invokespecial 92	btmsdkobf/bq:<init>	()V
    //   33: putstatic 41	btmsdkobf/bq:gx	Lbtmsdkobf/bq;
    //   36: ldc 2
    //   38: monitorexit
    //   39: goto +9 -> 48
    //   42: astore_0
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    //   48: ldc 2
    //   50: monitorexit
    //   51: getstatic 41	btmsdkobf/bq:gx	Lbtmsdkobf/bq;
    //   54: astore_0
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload_0
    //   59: areturn
    //   60: astore_0
    //   61: ldc 2
    //   63: monitorexit
    //   64: aload_0
    //   65: athrow
    //   66: astore_0
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_0
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	5	0	localObject1	Object
    //   54	5	0	localbq	bq
    //   60	5	0	localObject2	Object
    //   66	5	0	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	36	42	finally
    //   36	39	42	finally
    //   43	46	42	finally
    //   6	15	60	finally
    //   46	48	60	finally
    //   48	51	60	finally
    //   61	64	60	finally
    //   3	6	66	finally
    //   51	55	66	finally
    //   64	66	66	finally
  }
  
  private void U()
  {
    if (this.gw == null) {
      this.gw = bs.ac();
    }
    if (this.gt == null)
    {
      this.gt = ee.cT().L("m_d");
      this.gt.start();
      this.gu = new Handler(this.gt.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          Object localObject1;
          if (paramAnonymousMessage.what == 259)
          {
            paramAnonymousMessage = (br)paramAnonymousMessage.obj;
            if (paramAnonymousMessage != null)
            {
              if (paramAnonymousMessage.gz == null) {
                return;
              }
              localObject1 = bq.a(bq.this).i(paramAnonymousMessage.gz.gH);
              if (localObject1 != null)
              {
                if (paramAnonymousMessage.gz.gI < ((br)localObject1).gz.gI) {
                  break label216;
                }
                if (paramAnonymousMessage.gA == 1)
                {
                  if (((br)localObject1).gB == 3)
                  {
                    if (paramAnonymousMessage.gz.gI == ((br)localObject1).gz.gI)
                    {
                      bq.a(bq.this, (br)localObject1, 1);
                      break label216;
                    }
                    bq.a(bq.this, (br)localObject1, true);
                  }
                  else
                  {
                    if (paramAnonymousMessage.gz.gI <= ((br)localObject1).gz.gI) {
                      break label216;
                    }
                    bq.a(bq.this).d(paramAnonymousMessage);
                    break label216;
                  }
                }
                else
                {
                  if (paramAnonymousMessage.gA != 2) {
                    break label216;
                  }
                  bq.a(bq.this, (br)localObject1, true);
                  break label216;
                }
              }
              else
              {
                if (paramAnonymousMessage.gA != 1) {
                  break label199;
                }
              }
              bq.a(bq.this).e(paramAnonymousMessage);
              break label216;
              label199:
              if (paramAnonymousMessage.gA == 2) {
                bq.a(bq.this, paramAnonymousMessage, true);
              }
              label216:
              bq.this.gu.removeMessages(260);
              bq.this.gu.sendEmptyMessage(260);
              bq.this.gu.removeMessages(258);
              bq.this.gu.sendEmptyMessage(258);
              bq.this.gu.removeMessages(262);
              bq.this.gu.sendEmptyMessage(262);
            }
            return;
          }
          Object localObject2;
          if (paramAnonymousMessage.what == 257)
          {
            paramAnonymousMessage = bq.a(bq.this).ag();
            if ((paramAnonymousMessage != null) && (paramAnonymousMessage.size() > 0))
            {
              paramAnonymousMessage = paramAnonymousMessage.iterator();
              while (paramAnonymousMessage.hasNext())
              {
                localObject1 = (br)paramAnonymousMessage.next();
                if ((((br)localObject1).gB == 3) && (((br)localObject1).gA == 1) && (((br)localObject1).gz != null) && (((br)localObject1).gz.gL >= System.currentTimeMillis()))
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(((br)localObject1).aa());
                  ((StringBuilder)localObject2).append(File.separator);
                  ((StringBuilder)localObject2).append(((br)localObject1).Z());
                  if (new File(((StringBuilder)localObject2).toString()).exists()) {
                    bq.a(bq.this, (br)localObject1, 1);
                  }
                }
              }
            }
            return;
          }
          if (paramAnonymousMessage.what == 258)
          {
            paramAnonymousMessage = bq.a(bq.this).af();
            if (paramAnonymousMessage != null)
            {
              paramAnonymousMessage = paramAnonymousMessage.iterator();
              while (paramAnonymousMessage.hasNext())
              {
                localObject1 = (br)paramAnonymousMessage.next();
                bq.a(bq.this, (br)localObject1);
              }
              if (bq.a(bq.this).af() != null)
              {
                bq.b(bq.this);
                return;
              }
              bq.c(bq.this);
            }
            return;
          }
          if (paramAnonymousMessage.what == 260)
          {
            paramAnonymousMessage = bq.a(bq.this).ae();
            if (paramAnonymousMessage != null)
            {
              paramAnonymousMessage = paramAnonymousMessage.iterator();
              while (paramAnonymousMessage.hasNext())
              {
                localObject1 = (br)paramAnonymousMessage.next();
                bq.a(bq.this, (br)localObject1, true);
              }
            }
            return;
          }
          if (paramAnonymousMessage.what == 261)
          {
            paramAnonymousMessage = (aso)paramAnonymousMessage.obj;
            if (paramAnonymousMessage == null) {
              return;
            }
          }
          try
          {
            localObject1 = bq.this.gs.keySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (bt)((Iterator)localObject1).next();
              if ((aso)bq.this.gs.get(localObject2) == paramAnonymousMessage) {
                bq.this.gs.remove(localObject2);
              }
            }
            return;
          }
          catch (Throwable paramAnonymousMessage) {}
          if (paramAnonymousMessage.what == 262) {
            bq.d(bq.this);
          }
          return;
        }
      };
    }
  }
  
  private void V()
  {
    if (this.gt != null) {
      if ((!this.gu.hasMessages(257)) && (!this.gu.hasMessages(258)) && (!this.gu.hasMessages(259)) && (!this.gu.hasMessages(260)) && (!this.gu.hasMessages(261)))
      {
        if (this.gw.getCount() <= 0) {
          Q().a(Boolean.FALSE);
        }
        this.gt.quit();
        this.gt = null;
        this.gu = null;
      }
      else
      {
        this.gu.removeMessages(262);
        this.gu.sendEmptyMessage(262);
        return;
      }
    }
    bs localbs = this.gw;
    if (localbs != null)
    {
      localbs.ad();
      this.gw = null;
    }
  }
  
  private void W()
  {
    if (this.gv == null)
    {
      this.gv = new eb.a()
      {
        public final void O()
        {
          bq.this.T();
        }
        
        public final void P() {}
      };
      eb.k(bc.n()).a(this.gv);
    }
  }
  
  private void X()
  {
    if (this.gv != null)
    {
      eb.k(bc.n()).b(this.gv);
      this.gv = null;
    }
  }
  
  private void a(br parambr)
  {
    if (parambr != null)
    {
      if (parambr.gz == null) {
        return;
      }
      U();
      Message.obtain(this.gu, 259, parambr).sendToTarget();
    }
  }
  
  /* Error */
  private void a(br parambr, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   4: astore 9
    //   6: aload_0
    //   7: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   10: invokevirtual 221	java/util/HashMap:keySet	()Ljava/util/Set;
    //   13: invokeinterface 227 1 0
    //   18: astore 5
    //   20: aload 5
    //   22: invokeinterface 232 1 0
    //   27: ifeq +201 -> 228
    //   30: aload 5
    //   32: invokeinterface 236 1 0
    //   37: checkcast 238	btmsdkobf/bt
    //   40: astore 6
    //   42: aload 6
    //   44: getfield 242	btmsdkobf/bt:gH	I
    //   47: aload 9
    //   49: getfield 242	btmsdkobf/bt:gH	I
    //   52: if_icmpne -32 -> 20
    //   55: aload_0
    //   56: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   59: aload 6
    //   61: invokevirtual 246	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: pop
    //   65: aload 9
    //   67: getfield 249	btmsdkobf/bt:gI	I
    //   70: aload 6
    //   72: getfield 249	btmsdkobf/bt:gI	I
    //   75: if_icmple +31 -> 106
    //   78: aload_0
    //   79: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   82: aload 6
    //   84: invokevirtual 252	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_0
    //   89: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   92: aload 6
    //   94: invokevirtual 252	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   97: pop
    //   98: iload_2
    //   99: iconst_1
    //   100: if_icmpne +1718 -> 1818
    //   103: goto +125 -> 228
    //   106: aload 9
    //   108: getfield 249	btmsdkobf/bt:gI	I
    //   111: aload 6
    //   113: getfield 249	btmsdkobf/bt:gI	I
    //   116: if_icmpne +34 -> 150
    //   119: iload_2
    //   120: iconst_1
    //   121: if_icmpne +4 -> 125
    //   124: return
    //   125: iload_2
    //   126: iconst_2
    //   127: if_icmpne -107 -> 20
    //   130: aload_0
    //   131: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   134: aload 6
    //   136: invokevirtual 252	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: pop
    //   140: aload_0
    //   141: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   144: aload 6
    //   146: invokevirtual 252	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   149: pop
    //   150: return
    //   151: iload_2
    //   152: iconst_1
    //   153: if_icmpne +36 -> 189
    //   156: new 62	java/lang/StringBuilder
    //   159: dup
    //   160: ldc 254
    //   162: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: astore 5
    //   167: aload 5
    //   169: aload_1
    //   170: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   173: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc_w 258
    //   180: aload 5
    //   182: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   188: return
    //   189: iload_2
    //   190: iconst_2
    //   191: if_icmpne +36 -> 227
    //   194: new 62	java/lang/StringBuilder
    //   197: dup
    //   198: ldc_w 266
    //   201: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: astore 5
    //   206: aload 5
    //   208: aload_1
    //   209: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   212: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: ldc_w 258
    //   219: aload 5
    //   221: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   227: return
    //   228: aload_0
    //   229: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   232: invokevirtual 221	java/util/HashMap:keySet	()Ljava/util/Set;
    //   235: invokeinterface 227 1 0
    //   240: astore 6
    //   242: aload 6
    //   244: invokeinterface 232 1 0
    //   249: ifeq +229 -> 478
    //   252: aload 6
    //   254: invokeinterface 236 1 0
    //   259: checkcast 238	btmsdkobf/bt
    //   262: astore 5
    //   264: aload 5
    //   266: getfield 242	btmsdkobf/bt:gH	I
    //   269: aload 9
    //   271: getfield 242	btmsdkobf/bt:gH	I
    //   274: if_icmpne -32 -> 242
    //   277: aload 9
    //   279: getfield 249	btmsdkobf/bt:gI	I
    //   282: aload 5
    //   284: getfield 249	btmsdkobf/bt:gI	I
    //   287: if_icmple +38 -> 325
    //   290: aload_0
    //   291: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   294: aload 5
    //   296: invokevirtual 246	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   299: checkcast 268	java/lang/Class
    //   302: iconst_0
    //   303: anewarray 268	java/lang/Class
    //   306: invokevirtual 272	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   309: iconst_0
    //   310: anewarray 4	java/lang/Object
    //   313: invokevirtual 278	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   316: pop
    //   317: iload_2
    //   318: iconst_1
    //   319: if_icmpne +1505 -> 1824
    //   322: goto +156 -> 478
    //   325: aload 5
    //   327: getfield 249	btmsdkobf/bt:gI	I
    //   330: aload 9
    //   332: getfield 249	btmsdkobf/bt:gI	I
    //   335: if_icmpne +84 -> 419
    //   338: aload_0
    //   339: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   342: aload 5
    //   344: invokevirtual 246	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   347: checkcast 268	java/lang/Class
    //   350: iconst_0
    //   351: anewarray 268	java/lang/Class
    //   354: invokevirtual 272	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   357: iconst_0
    //   358: anewarray 4	java/lang/Object
    //   361: invokevirtual 278	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   364: checkcast 280	com/tencent/token/aso
    //   367: astore 6
    //   369: iload_2
    //   370: iconst_1
    //   371: if_icmpne +33 -> 404
    //   374: new 282	android/os/Bundle
    //   377: dup
    //   378: invokespecial 283	android/os/Bundle:<init>	()V
    //   381: ldc_w 285
    //   384: aload_1
    //   385: invokevirtual 288	btmsdkobf/br:aa	()Ljava/lang/String;
    //   388: invokevirtual 292	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: aload_0
    //   392: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   395: aload 5
    //   397: aload 6
    //   399: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   402: pop
    //   403: return
    //   404: iload_2
    //   405: iconst_2
    //   406: if_icmpne +13 -> 419
    //   409: aload_0
    //   410: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   413: aload 5
    //   415: invokevirtual 252	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   418: pop
    //   419: return
    //   420: iload_2
    //   421: iconst_1
    //   422: if_icmpne +17 -> 439
    //   425: new 62	java/lang/StringBuilder
    //   428: dup
    //   429: ldc 254
    //   431: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   434: astore 5
    //   436: goto -269 -> 167
    //   439: iload_2
    //   440: iconst_2
    //   441: if_icmpne +36 -> 477
    //   444: new 62	java/lang/StringBuilder
    //   447: dup
    //   448: ldc_w 266
    //   451: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   454: astore 5
    //   456: aload 5
    //   458: aload_1
    //   459: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   462: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: ldc_w 258
    //   469: aload 5
    //   471: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   477: return
    //   478: new 62	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   485: astore 5
    //   487: aload 5
    //   489: aload_1
    //   490: invokevirtual 288	btmsdkobf/br:aa	()Ljava/lang/String;
    //   493: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload 5
    //   499: getstatic 303	java/io/File:separator	Ljava/lang/String;
    //   502: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload 5
    //   508: aload_1
    //   509: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   512: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 5
    //   518: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: astore 10
    //   523: new 299	java/io/File
    //   526: dup
    //   527: aload 10
    //   529: invokespecial 304	java/io/File:<init>	(Ljava/lang/String;)V
    //   532: astore 11
    //   534: aload 11
    //   536: invokevirtual 307	java/io/File:exists	()Z
    //   539: ifne +4 -> 543
    //   542: return
    //   543: aload_0
    //   544: aload 10
    //   546: aload 10
    //   548: iconst_0
    //   549: invokespecial 310	btmsdkobf/bq:a	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   552: istore 4
    //   554: iload 4
    //   556: ifne +50 -> 606
    //   559: new 62	java/lang/StringBuilder
    //   562: dup
    //   563: ldc_w 312
    //   566: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   569: astore 5
    //   571: aload 5
    //   573: aload_1
    //   574: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   577: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: ldc_w 313
    //   584: aload 5
    //   586: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   592: aload_0
    //   593: aload_1
    //   594: iconst_0
    //   595: invokespecial 196	btmsdkobf/bq:a	(Lbtmsdkobf/br;Z)V
    //   598: return
    //   599: astore_1
    //   600: aconst_null
    //   601: astore 5
    //   603: goto +1152 -> 1755
    //   606: ldc_w 315
    //   609: astore 5
    //   611: aload 5
    //   613: astore 6
    //   615: invokestatic 319	com/tencent/token/asr:b	()Z
    //   618: ifeq +8 -> 626
    //   621: ldc_w 321
    //   624: astore 6
    //   626: new 323	java/util/zip/ZipFile
    //   629: dup
    //   630: aload 11
    //   632: invokespecial 326	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   635: astore 5
    //   637: aload 5
    //   639: invokevirtual 330	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   642: astore 12
    //   644: aload 12
    //   646: invokeinterface 335 1 0
    //   651: ifeq +329 -> 980
    //   654: aload 12
    //   656: invokeinterface 338 1 0
    //   661: checkcast 340	java/util/zip/ZipEntry
    //   664: astore 13
    //   666: aload 13
    //   668: ifnull -24 -> 644
    //   671: aload 13
    //   673: invokevirtual 343	java/util/zip/ZipEntry:isDirectory	()Z
    //   676: ifne -32 -> 644
    //   679: aload 13
    //   681: invokevirtual 346	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   684: ldc_w 348
    //   687: invokevirtual 352	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   690: ifne +287 -> 977
    //   693: aload 13
    //   695: invokevirtual 346	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   698: astore 7
    //   700: new 62	java/lang/StringBuilder
    //   703: dup
    //   704: ldc_w 354
    //   707: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   710: astore 8
    //   712: aload 8
    //   714: aload 7
    //   716: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: aload 8
    //   722: ldc 79
    //   724: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload 8
    //   730: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokestatic 87	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   736: aload 7
    //   738: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   741: ifne +236 -> 977
    //   744: aload 7
    //   746: aload 6
    //   748: invokevirtual 352	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   751: ifeq +226 -> 977
    //   754: aload 7
    //   756: aload 7
    //   758: ldc_w 361
    //   761: invokevirtual 365	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   764: iconst_1
    //   765: iadd
    //   766: invokevirtual 369	java/lang/String:substring	(I)Ljava/lang/String;
    //   769: astore 8
    //   771: aload 8
    //   773: ldc_w 371
    //   776: invokevirtual 365	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   779: istore_3
    //   780: aload 8
    //   782: astore 7
    //   784: iload_3
    //   785: ifle +41 -> 826
    //   788: new 62	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   795: astore 7
    //   797: aload 7
    //   799: aload 8
    //   801: iconst_0
    //   802: iload_3
    //   803: invokevirtual 374	java/lang/String:substring	(II)Ljava/lang/String;
    //   806: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload 7
    //   812: ldc_w 376
    //   815: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload 7
    //   821: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   824: astore 7
    //   826: new 62	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   833: astore 8
    //   835: aload 8
    //   837: aload_1
    //   838: invokevirtual 288	btmsdkobf/br:aa	()Ljava/lang/String;
    //   841: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload 8
    //   847: getstatic 303	java/io/File:separator	Ljava/lang/String;
    //   850: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: pop
    //   854: aload 8
    //   856: aload 7
    //   858: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: pop
    //   862: new 299	java/io/File
    //   865: dup
    //   866: aload 8
    //   868: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: invokespecial 304	java/io/File:<init>	(Ljava/lang/String;)V
    //   874: astore 8
    //   876: aload 8
    //   878: invokevirtual 307	java/io/File:exists	()Z
    //   881: ifeq +23 -> 904
    //   884: aload 8
    //   886: invokevirtual 380	java/io/File:length	()J
    //   889: aload 13
    //   891: invokevirtual 383	java/util/zip/ZipEntry:getSize	()J
    //   894: lcmp
    //   895: ifeq +82 -> 977
    //   898: aload 8
    //   900: invokevirtual 386	java/io/File:delete	()Z
    //   903: pop
    //   904: new 388	java/io/BufferedInputStream
    //   907: dup
    //   908: aload 5
    //   910: aload 13
    //   912: invokevirtual 392	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   915: invokespecial 395	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   918: astore 7
    //   920: new 397	java/io/FileOutputStream
    //   923: dup
    //   924: aload 8
    //   926: invokespecial 398	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   929: astore 8
    //   931: sipush 8192
    //   934: newarray byte
    //   936: astore 13
    //   938: aload 7
    //   940: aload 13
    //   942: invokevirtual 402	java/io/BufferedInputStream:read	([B)I
    //   945: istore_3
    //   946: iload_3
    //   947: ifle +15 -> 962
    //   950: aload 8
    //   952: aload 13
    //   954: iconst_0
    //   955: iload_3
    //   956: invokevirtual 406	java/io/FileOutputStream:write	([BII)V
    //   959: goto -21 -> 938
    //   962: aload 8
    //   964: invokevirtual 409	java/io/FileOutputStream:flush	()V
    //   967: aload 7
    //   969: invokevirtual 412	java/io/BufferedInputStream:close	()V
    //   972: aload 8
    //   974: invokevirtual 413	java/io/FileOutputStream:close	()V
    //   977: goto -333 -> 644
    //   980: aload 11
    //   982: invokevirtual 416	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   985: astore 6
    //   987: aload 11
    //   989: invokevirtual 416	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   992: ldc_w 371
    //   995: invokevirtual 365	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   998: istore_3
    //   999: iload_3
    //   1000: ifle +15 -> 1015
    //   1003: aload 11
    //   1005: invokevirtual 416	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1008: iconst_0
    //   1009: iload_3
    //   1010: invokevirtual 374	java/lang/String:substring	(II)Ljava/lang/String;
    //   1013: astore 6
    //   1015: new 62	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   1022: astore 7
    //   1024: aload 7
    //   1026: aload 6
    //   1028: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: pop
    //   1032: aload 7
    //   1034: new 33	java/lang/String
    //   1037: dup
    //   1038: iconst_4
    //   1039: newarray byte
    //   1041: dup
    //   1042: iconst_0
    //   1043: bipush 46
    //   1045: bastore
    //   1046: dup
    //   1047: iconst_1
    //   1048: bipush 97
    //   1050: bastore
    //   1051: dup
    //   1052: iconst_2
    //   1053: bipush 112
    //   1055: bastore
    //   1056: dup
    //   1057: iconst_3
    //   1058: bipush 107
    //   1060: bastore
    //   1061: invokespecial 419	java/lang/String:<init>	([B)V
    //   1064: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: pop
    //   1068: new 299	java/io/File
    //   1071: dup
    //   1072: aload 7
    //   1074: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1077: invokespecial 304	java/io/File:<init>	(Ljava/lang/String;)V
    //   1080: astore 7
    //   1082: aload 11
    //   1084: aload 7
    //   1086: invokevirtual 423	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1089: pop
    //   1090: new 33	java/lang/String
    //   1093: dup
    //   1094: bipush 28
    //   1096: newarray byte
    //   1098: dup
    //   1099: iconst_0
    //   1100: bipush 100
    //   1102: bastore
    //   1103: dup
    //   1104: iconst_1
    //   1105: bipush 97
    //   1107: bastore
    //   1108: dup
    //   1109: iconst_2
    //   1110: bipush 108
    //   1112: bastore
    //   1113: dup
    //   1114: iconst_3
    //   1115: bipush 118
    //   1117: bastore
    //   1118: dup
    //   1119: iconst_4
    //   1120: bipush 105
    //   1122: bastore
    //   1123: dup
    //   1124: iconst_5
    //   1125: bipush 107
    //   1127: bastore
    //   1128: dup
    //   1129: bipush 6
    //   1131: bipush 46
    //   1133: bastore
    //   1134: dup
    //   1135: bipush 7
    //   1137: bipush 115
    //   1139: bastore
    //   1140: dup
    //   1141: bipush 8
    //   1143: bipush 121
    //   1145: bastore
    //   1146: dup
    //   1147: bipush 9
    //   1149: bipush 115
    //   1151: bastore
    //   1152: dup
    //   1153: bipush 10
    //   1155: bipush 116
    //   1157: bastore
    //   1158: dup
    //   1159: bipush 11
    //   1161: bipush 101
    //   1163: bastore
    //   1164: dup
    //   1165: bipush 12
    //   1167: bipush 109
    //   1169: bastore
    //   1170: dup
    //   1171: bipush 13
    //   1173: bipush 46
    //   1175: bastore
    //   1176: dup
    //   1177: bipush 14
    //   1179: bipush 68
    //   1181: bastore
    //   1182: dup
    //   1183: bipush 15
    //   1185: bipush 101
    //   1187: bastore
    //   1188: dup
    //   1189: bipush 16
    //   1191: bipush 120
    //   1193: bastore
    //   1194: dup
    //   1195: bipush 17
    //   1197: bipush 67
    //   1199: bastore
    //   1200: dup
    //   1201: bipush 18
    //   1203: bipush 108
    //   1205: bastore
    //   1206: dup
    //   1207: bipush 19
    //   1209: bipush 97
    //   1211: bastore
    //   1212: dup
    //   1213: bipush 20
    //   1215: bipush 115
    //   1217: bastore
    //   1218: dup
    //   1219: bipush 21
    //   1221: bipush 115
    //   1223: bastore
    //   1224: dup
    //   1225: bipush 22
    //   1227: bipush 76
    //   1229: bastore
    //   1230: dup
    //   1231: bipush 23
    //   1233: bipush 111
    //   1235: bastore
    //   1236: dup
    //   1237: bipush 24
    //   1239: bipush 97
    //   1241: bastore
    //   1242: dup
    //   1243: bipush 25
    //   1245: bipush 100
    //   1247: bastore
    //   1248: dup
    //   1249: bipush 26
    //   1251: bipush 101
    //   1253: bastore
    //   1254: dup
    //   1255: bipush 27
    //   1257: bipush 114
    //   1259: bastore
    //   1260: invokespecial 419	java/lang/String:<init>	([B)V
    //   1263: invokestatic 427	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1266: astore 8
    //   1268: aload 8
    //   1270: iconst_4
    //   1271: anewarray 268	java/lang/Class
    //   1274: dup
    //   1275: iconst_0
    //   1276: ldc 33
    //   1278: aastore
    //   1279: dup
    //   1280: iconst_1
    //   1281: ldc 33
    //   1283: aastore
    //   1284: dup
    //   1285: iconst_2
    //   1286: ldc 33
    //   1288: aastore
    //   1289: dup
    //   1290: iconst_3
    //   1291: ldc_w 429
    //   1294: aastore
    //   1295: invokevirtual 272	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   1298: iconst_4
    //   1299: anewarray 4	java/lang/Object
    //   1302: dup
    //   1303: iconst_0
    //   1304: aload 7
    //   1306: invokevirtual 416	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1309: aastore
    //   1310: dup
    //   1311: iconst_1
    //   1312: aload_1
    //   1313: invokevirtual 432	btmsdkobf/br:ab	()Ljava/lang/String;
    //   1316: aastore
    //   1317: dup
    //   1318: iconst_2
    //   1319: aconst_null
    //   1320: aastore
    //   1321: dup
    //   1322: iconst_3
    //   1323: ldc 166
    //   1325: invokevirtual 436	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   1328: aastore
    //   1329: invokevirtual 278	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   1332: astore 6
    //   1334: aload 8
    //   1336: new 33	java/lang/String
    //   1339: dup
    //   1340: bipush 9
    //   1342: newarray byte
    //   1344: dup
    //   1345: iconst_0
    //   1346: bipush 108
    //   1348: bastore
    //   1349: dup
    //   1350: iconst_1
    //   1351: bipush 111
    //   1353: bastore
    //   1354: dup
    //   1355: iconst_2
    //   1356: bipush 97
    //   1358: bastore
    //   1359: dup
    //   1360: iconst_3
    //   1361: bipush 100
    //   1363: bastore
    //   1364: dup
    //   1365: iconst_4
    //   1366: bipush 67
    //   1368: bastore
    //   1369: dup
    //   1370: iconst_5
    //   1371: bipush 108
    //   1373: bastore
    //   1374: dup
    //   1375: bipush 6
    //   1377: bipush 97
    //   1379: bastore
    //   1380: dup
    //   1381: bipush 7
    //   1383: bipush 115
    //   1385: bastore
    //   1386: dup
    //   1387: bipush 8
    //   1389: bipush 115
    //   1391: bastore
    //   1392: invokespecial 419	java/lang/String:<init>	([B)V
    //   1395: iconst_1
    //   1396: anewarray 268	java/lang/Class
    //   1399: dup
    //   1400: iconst_0
    //   1401: ldc 33
    //   1403: aastore
    //   1404: invokevirtual 440	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1407: astore 8
    //   1409: aload_1
    //   1410: invokevirtual 432	btmsdkobf/br:ab	()Ljava/lang/String;
    //   1413: invokestatic 446	btmsdkobf/dz:H	(Ljava/lang/String;)Z
    //   1416: pop
    //   1417: aload 7
    //   1419: aload 11
    //   1421: invokevirtual 423	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1424: pop
    //   1425: aload_0
    //   1426: aload 10
    //   1428: aload 10
    //   1430: iconst_1
    //   1431: invokespecial 310	btmsdkobf/bq:a	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   1434: ifne +42 -> 1476
    //   1437: new 62	java/lang/StringBuilder
    //   1440: dup
    //   1441: ldc_w 448
    //   1444: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1447: astore 7
    //   1449: aload 7
    //   1451: aload_1
    //   1452: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   1455: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: pop
    //   1459: ldc_w 313
    //   1462: aload 7
    //   1464: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1467: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   1470: aload_0
    //   1471: aload_1
    //   1472: iconst_0
    //   1473: invokespecial 196	btmsdkobf/bq:a	(Lbtmsdkobf/br;Z)V
    //   1476: aload 8
    //   1478: ifnull +118 -> 1596
    //   1481: aload 8
    //   1483: iconst_1
    //   1484: invokevirtual 454	java/lang/reflect/Method:setAccessible	(Z)V
    //   1487: aload 8
    //   1489: aload 6
    //   1491: iconst_1
    //   1492: anewarray 4	java/lang/Object
    //   1495: dup
    //   1496: iconst_0
    //   1497: ldc_w 456
    //   1500: aastore
    //   1501: invokevirtual 460	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1504: checkcast 268	java/lang/Class
    //   1507: astore 6
    //   1509: aload 6
    //   1511: iconst_0
    //   1512: anewarray 268	java/lang/Class
    //   1515: invokevirtual 272	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   1518: iconst_0
    //   1519: anewarray 4	java/lang/Object
    //   1522: invokevirtual 278	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   1525: checkcast 280	com/tencent/token/aso
    //   1528: astore 7
    //   1530: iload_2
    //   1531: iconst_1
    //   1532: if_icmpne +64 -> 1596
    //   1535: new 282	android/os/Bundle
    //   1538: dup
    //   1539: ldc 2
    //   1541: invokevirtual 436	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   1544: invokespecial 463	android/os/Bundle:<init>	(Ljava/lang/ClassLoader;)V
    //   1547: ldc_w 285
    //   1550: aload_1
    //   1551: invokevirtual 288	btmsdkobf/br:aa	()Ljava/lang/String;
    //   1554: invokevirtual 292	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1557: aload_0
    //   1558: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   1561: aload 9
    //   1563: aload 6
    //   1565: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1568: pop
    //   1569: aload_0
    //   1570: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   1573: aload 9
    //   1575: aload 7
    //   1577: invokevirtual 296	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1580: pop
    //   1581: aload 9
    //   1583: getfield 466	btmsdkobf/bt:gK	I
    //   1586: iconst_2
    //   1587: if_icmpne +9 -> 1596
    //   1590: aload_0
    //   1591: aload_1
    //   1592: iconst_1
    //   1593: invokespecial 196	btmsdkobf/bq:a	(Lbtmsdkobf/br;Z)V
    //   1596: aload 5
    //   1598: invokevirtual 467	java/util/zip/ZipFile:close	()V
    //   1601: iload_2
    //   1602: iconst_1
    //   1603: if_icmpne +36 -> 1639
    //   1606: new 62	java/lang/StringBuilder
    //   1609: dup
    //   1610: ldc_w 469
    //   1613: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1616: astore 5
    //   1618: aload 5
    //   1620: aload_1
    //   1621: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   1624: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: pop
    //   1628: ldc_w 258
    //   1631: aload 5
    //   1633: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1636: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   1639: return
    //   1640: astore_1
    //   1641: goto +114 -> 1755
    //   1644: goto +13 -> 1657
    //   1647: astore_1
    //   1648: aconst_null
    //   1649: astore 5
    //   1651: goto +104 -> 1755
    //   1654: aconst_null
    //   1655: astore 5
    //   1657: iload_2
    //   1658: iconst_1
    //   1659: if_icmpne +42 -> 1701
    //   1662: new 62	java/lang/StringBuilder
    //   1665: dup
    //   1666: ldc 254
    //   1668: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1671: astore 6
    //   1673: aload 6
    //   1675: aload_1
    //   1676: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   1679: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: pop
    //   1683: aload 6
    //   1685: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1688: astore 6
    //   1690: ldc_w 258
    //   1693: aload 6
    //   1695: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   1698: goto +40 -> 1738
    //   1701: iload_2
    //   1702: iconst_2
    //   1703: if_icmpne +35 -> 1738
    //   1706: new 62	java/lang/StringBuilder
    //   1709: dup
    //   1710: ldc_w 266
    //   1713: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1716: astore 6
    //   1718: aload 6
    //   1720: aload_1
    //   1721: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   1724: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1727: pop
    //   1728: aload 6
    //   1730: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1733: astore 6
    //   1735: goto -45 -> 1690
    //   1738: aload_0
    //   1739: aload_1
    //   1740: iconst_0
    //   1741: invokespecial 196	btmsdkobf/bq:a	(Lbtmsdkobf/br;Z)V
    //   1744: aload 5
    //   1746: ifnull +8 -> 1754
    //   1749: aload 5
    //   1751: invokevirtual 467	java/util/zip/ZipFile:close	()V
    //   1754: return
    //   1755: aload 5
    //   1757: ifnull +8 -> 1765
    //   1760: aload 5
    //   1762: invokevirtual 467	java/util/zip/ZipFile:close	()V
    //   1765: aload_1
    //   1766: athrow
    //   1767: astore 5
    //   1769: goto -1618 -> 151
    //   1772: astore 5
    //   1774: goto -1354 -> 420
    //   1777: astore 5
    //   1779: goto -125 -> 1654
    //   1782: astore 6
    //   1784: aload 5
    //   1786: astore 6
    //   1788: goto -1162 -> 626
    //   1791: astore 6
    //   1793: goto -149 -> 1644
    //   1796: astore 7
    //   1798: goto -826 -> 972
    //   1801: astore 7
    //   1803: goto -826 -> 977
    //   1806: astore 5
    //   1808: goto -207 -> 1601
    //   1811: astore_1
    //   1812: return
    //   1813: astore 5
    //   1815: goto -50 -> 1765
    //   1818: iload_2
    //   1819: iconst_2
    //   1820: if_icmpne -1800 -> 20
    //   1823: return
    //   1824: iload_2
    //   1825: iconst_2
    //   1826: if_icmpne -1584 -> 242
    //   1829: return
    //   1830: astore_1
    //   1831: goto -76 -> 1755
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1834	0	this	bq
    //   0	1834	1	parambr	br
    //   0	1834	2	paramInt	int
    //   779	231	3	i	int
    //   552	3	4	bool	boolean
    //   18	1743	5	localObject1	Object
    //   1767	1	5	localThrowable1	Throwable
    //   1772	1	5	localThrowable2	Throwable
    //   1777	8	5	localThrowable3	Throwable
    //   1806	1	5	localThrowable4	Throwable
    //   1813	1	5	localThrowable5	Throwable
    //   40	1694	6	localObject2	Object
    //   1782	1	6	localThrowable6	Throwable
    //   1786	1	6	localThrowable7	Throwable
    //   1791	1	6	localThrowable8	Throwable
    //   698	878	7	localObject3	Object
    //   1796	1	7	localIOException1	java.io.IOException
    //   1801	1	7	localIOException2	java.io.IOException
    //   710	778	8	localObject4	Object
    //   4	1578	9	localbt	bt
    //   521	908	10	str	String
    //   532	888	11	localFile	File
    //   642	13	12	localEnumeration	java.util.Enumeration
    //   664	289	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   559	598	599	finally
    //   615	621	599	finally
    //   637	644	1640	finally
    //   644	666	1640	finally
    //   671	780	1640	finally
    //   788	826	1640	finally
    //   826	904	1640	finally
    //   904	938	1640	finally
    //   938	946	1640	finally
    //   950	959	1640	finally
    //   962	967	1640	finally
    //   967	972	1640	finally
    //   972	977	1640	finally
    //   980	999	1640	finally
    //   1003	1015	1640	finally
    //   1015	1476	1640	finally
    //   1481	1530	1640	finally
    //   1535	1596	1640	finally
    //   478	542	1647	finally
    //   543	554	1647	finally
    //   626	637	1647	finally
    //   65	98	1767	java/lang/Throwable
    //   106	119	1767	java/lang/Throwable
    //   130	150	1767	java/lang/Throwable
    //   277	317	1772	java/lang/Throwable
    //   325	369	1772	java/lang/Throwable
    //   374	403	1772	java/lang/Throwable
    //   409	419	1772	java/lang/Throwable
    //   478	542	1777	java/lang/Throwable
    //   543	554	1777	java/lang/Throwable
    //   559	598	1777	java/lang/Throwable
    //   626	637	1777	java/lang/Throwable
    //   615	621	1782	java/lang/Throwable
    //   637	644	1791	java/lang/Throwable
    //   644	666	1791	java/lang/Throwable
    //   671	780	1791	java/lang/Throwable
    //   788	826	1791	java/lang/Throwable
    //   826	904	1791	java/lang/Throwable
    //   904	938	1791	java/lang/Throwable
    //   938	946	1791	java/lang/Throwable
    //   950	959	1791	java/lang/Throwable
    //   962	967	1791	java/lang/Throwable
    //   967	972	1791	java/lang/Throwable
    //   972	977	1791	java/lang/Throwable
    //   980	999	1791	java/lang/Throwable
    //   1003	1015	1791	java/lang/Throwable
    //   1015	1476	1791	java/lang/Throwable
    //   1481	1530	1791	java/lang/Throwable
    //   1535	1596	1791	java/lang/Throwable
    //   967	972	1796	java/io/IOException
    //   972	977	1801	java/io/IOException
    //   1596	1601	1806	java/lang/Throwable
    //   1749	1754	1811	java/lang/Throwable
    //   1760	1765	1813	java/lang/Throwable
    //   1662	1690	1830	finally
    //   1690	1698	1830	finally
    //   1706	1735	1830	finally
    //   1738	1744	1830	finally
  }
  
  private void a(br parambr, boolean paramBoolean)
  {
    if (parambr != null)
    {
      if (parambr.gz == null) {
        return;
      }
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          a(parambr, 2);
          dz.H(parambr.aa());
          dz.H(parambr.ab());
          this.gw.j(parambr.gz.gH);
          localStringBuilder = new StringBuilder("1;;");
          localStringBuilder.append(parambr.Z());
          be.SaveStringData(1320043, localStringBuilder.toString());
          return;
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder;
          continue;
        }
        localStringBuilder = new StringBuilder("0;1019;");
      }
    }
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: iconst_0
    //   7: istore 6
    //   9: new 299	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 304	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 380	java/io/File:length	()J
    //   20: lstore 7
    //   22: lload 7
    //   24: lconst_0
    //   25: lcmp
    //   26: ifgt +5 -> 31
    //   29: iconst_0
    //   30: ireturn
    //   31: lload 7
    //   33: l2i
    //   34: newarray byte
    //   36: astore 11
    //   38: new 388	java/io/BufferedInputStream
    //   41: dup
    //   42: new 477	java/io/FileInputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 478	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   50: invokespecial 395	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: astore_1
    //   54: sipush 8192
    //   57: newarray byte
    //   59: astore 12
    //   61: iconst_0
    //   62: istore 4
    //   64: aload_1
    //   65: aload 12
    //   67: invokevirtual 402	java/io/BufferedInputStream:read	([B)I
    //   70: istore 5
    //   72: iload 5
    //   74: iconst_m1
    //   75: if_icmpeq +25 -> 100
    //   78: aload 12
    //   80: iconst_0
    //   81: aload 11
    //   83: iload 4
    //   85: iload 5
    //   87: invokestatic 484	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   90: iload 4
    //   92: iload 5
    //   94: iadd
    //   95: istore 4
    //   97: goto -33 -> 64
    //   100: new 397	java/io/FileOutputStream
    //   103: dup
    //   104: aload_2
    //   105: invokespecial 485	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   108: astore_2
    //   109: iload_3
    //   110: ifeq +20 -> 130
    //   113: aload 11
    //   115: aconst_null
    //   116: invokestatic 488	com/tencent/token/asr:a	([B[B)[B
    //   119: astore 9
    //   121: aload_2
    //   122: aload 9
    //   124: invokevirtual 490	java/io/FileOutputStream:write	([B)V
    //   127: goto +14 -> 141
    //   130: aload 11
    //   132: aconst_null
    //   133: invokestatic 492	com/tencent/token/asr:b	([B[B)[B
    //   136: astore 9
    //   138: goto -17 -> 121
    //   141: aload_2
    //   142: invokevirtual 409	java/io/FileOutputStream:flush	()V
    //   145: iconst_1
    //   146: istore_3
    //   147: aload_1
    //   148: invokevirtual 412	java/io/BufferedInputStream:close	()V
    //   151: aload_2
    //   152: invokevirtual 413	java/io/FileOutputStream:close	()V
    //   155: iconst_1
    //   156: ireturn
    //   157: astore 10
    //   159: aload_1
    //   160: astore 9
    //   162: aload 10
    //   164: astore_1
    //   165: goto +33 -> 198
    //   168: goto +58 -> 226
    //   171: astore 11
    //   173: aload 10
    //   175: astore_2
    //   176: aload_1
    //   177: astore 9
    //   179: aload 11
    //   181: astore_1
    //   182: goto +16 -> 198
    //   185: aload 9
    //   187: astore_2
    //   188: goto +38 -> 226
    //   191: astore_1
    //   192: aconst_null
    //   193: astore 9
    //   195: aload 10
    //   197: astore_2
    //   198: aload 9
    //   200: ifnull +11 -> 211
    //   203: aload 9
    //   205: invokevirtual 412	java/io/BufferedInputStream:close	()V
    //   208: goto +3 -> 211
    //   211: aload_2
    //   212: ifnull +7 -> 219
    //   215: aload_2
    //   216: invokevirtual 413	java/io/FileOutputStream:close	()V
    //   219: aload_1
    //   220: athrow
    //   221: aconst_null
    //   222: astore_1
    //   223: aload 9
    //   225: astore_2
    //   226: aload_1
    //   227: ifnull +10 -> 237
    //   230: aload_1
    //   231: invokevirtual 412	java/io/BufferedInputStream:close	()V
    //   234: goto +3 -> 237
    //   237: aload_2
    //   238: ifnull +10 -> 248
    //   241: iload 6
    //   243: istore_3
    //   244: aload_2
    //   245: invokevirtual 413	java/io/FileOutputStream:close	()V
    //   248: iconst_0
    //   249: ireturn
    //   250: astore_1
    //   251: goto -30 -> 221
    //   254: astore_2
    //   255: goto -70 -> 185
    //   258: astore 9
    //   260: goto -92 -> 168
    //   263: astore_1
    //   264: goto -113 -> 151
    //   267: astore_1
    //   268: iload_3
    //   269: ireturn
    //   270: astore 9
    //   272: goto -61 -> 211
    //   275: astore_2
    //   276: goto -57 -> 219
    //   279: astore_1
    //   280: goto -43 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	bq
    //   0	283	1	paramString1	String
    //   0	283	2	paramString2	String
    //   0	283	3	paramBoolean	boolean
    //   62	34	4	i	int
    //   70	25	5	j	int
    //   7	235	6	bool	boolean
    //   20	12	7	l	long
    //   1	223	9	localObject1	Object
    //   258	1	9	localThrowable1	Throwable
    //   270	1	9	localThrowable2	Throwable
    //   4	1	10	localObject2	Object
    //   157	39	10	localObject3	Object
    //   36	95	11	arrayOfByte1	byte[]
    //   171	9	11	localObject4	Object
    //   59	20	12	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   113	121	157	finally
    //   121	127	157	finally
    //   130	138	157	finally
    //   141	145	157	finally
    //   54	61	171	finally
    //   64	72	171	finally
    //   78	90	171	finally
    //   100	109	171	finally
    //   9	22	191	finally
    //   31	54	191	finally
    //   9	22	250	java/lang/Throwable
    //   31	54	250	java/lang/Throwable
    //   54	61	254	java/lang/Throwable
    //   64	72	254	java/lang/Throwable
    //   78	90	254	java/lang/Throwable
    //   100	109	254	java/lang/Throwable
    //   113	121	258	java/lang/Throwable
    //   121	127	258	java/lang/Throwable
    //   130	138	258	java/lang/Throwable
    //   141	145	258	java/lang/Throwable
    //   147	151	263	java/lang/Throwable
    //   151	155	267	java/lang/Throwable
    //   244	248	267	java/lang/Throwable
    //   203	208	270	java/lang/Throwable
    //   215	219	275	java/lang/Throwable
    //   230	234	279	java/lang/Throwable
  }
  
  /* Error */
  private boolean b(br parambr)
  {
    // Byte code:
    //   0: getstatic 500	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 26
    //   5: if_icmple +5 -> 10
    //   8: iconst_1
    //   9: ireturn
    //   10: aload_1
    //   11: ifnull +943 -> 954
    //   14: aload_1
    //   15: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   18: ifnonnull +5 -> 23
    //   21: iconst_0
    //   22: ireturn
    //   23: new 62	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   30: astore_3
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 288	btmsdkobf/br:aa	()Ljava/lang/String;
    //   36: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: getstatic 303	java/io/File:separator	Ljava/lang/String;
    //   44: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: aload_1
    //   50: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   53: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 7
    //   63: new 299	java/io/File
    //   66: dup
    //   67: aload 7
    //   69: invokespecial 304	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore_3
    //   73: aload_3
    //   74: invokevirtual 307	java/io/File:exists	()Z
    //   77: ifne +35 -> 112
    //   80: new 62	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 502
    //   87: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: astore_3
    //   91: aload_3
    //   92: aload_1
    //   93: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   96: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: ldc_w 313
    //   103: aload_3
    //   104: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   110: iconst_0
    //   111: ireturn
    //   112: aload_3
    //   113: invokevirtual 380	java/io/File:length	()J
    //   116: aload_1
    //   117: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   120: getfield 505	btmsdkobf/bt:gM	I
    //   123: i2l
    //   124: lcmp
    //   125: ifeq +17 -> 142
    //   128: new 62	java/lang/StringBuilder
    //   131: dup
    //   132: ldc_w 507
    //   135: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   138: astore_3
    //   139: goto -48 -> 91
    //   142: new 299	java/io/File
    //   145: dup
    //   146: aload 7
    //   148: invokespecial 304	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: invokestatic 510	btmsdkobf/dz:a	(Ljava/io/File;)Ljava/lang/String;
    //   154: aload_1
    //   155: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   158: getfield 513	btmsdkobf/bt:gN	Ljava/lang/String;
    //   161: invokevirtual 516	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   164: ifeq +17 -> 181
    //   167: new 62	java/lang/StringBuilder
    //   170: dup
    //   171: ldc_w 518
    //   174: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   177: astore_3
    //   178: goto -87 -> 91
    //   181: aconst_null
    //   182: astore 6
    //   184: aconst_null
    //   185: astore 5
    //   187: aload 5
    //   189: astore_3
    //   190: aload 6
    //   192: astore 4
    //   194: ldc_w 520
    //   197: invokevirtual 522	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   200: checkcast 520	android/content/res/AssetManager
    //   203: astore 8
    //   205: aload 5
    //   207: astore_3
    //   208: aload 6
    //   210: astore 4
    //   212: ldc_w 520
    //   215: ldc_w 524
    //   218: iconst_1
    //   219: anewarray 268	java/lang/Class
    //   222: dup
    //   223: iconst_0
    //   224: ldc 33
    //   226: aastore
    //   227: invokevirtual 527	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   230: astore 9
    //   232: aload 5
    //   234: astore_3
    //   235: aload 6
    //   237: astore 4
    //   239: aload 9
    //   241: iconst_1
    //   242: invokevirtual 454	java/lang/reflect/Method:setAccessible	(Z)V
    //   245: aload 5
    //   247: astore_3
    //   248: aload 6
    //   250: astore 4
    //   252: aload 9
    //   254: aload 8
    //   256: iconst_1
    //   257: anewarray 4	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: aload 7
    //   264: aastore
    //   265: invokevirtual 460	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   268: pop
    //   269: aload 5
    //   271: astore_3
    //   272: aload 6
    //   274: astore 4
    //   276: aload 8
    //   278: ldc_w 529
    //   281: iconst_1
    //   282: invokevirtual 533	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   285: astore 5
    //   287: aload 5
    //   289: astore_3
    //   290: aload 5
    //   292: astore 4
    //   294: invokestatic 539	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   297: astore 6
    //   299: aload 5
    //   301: astore_3
    //   302: aload 5
    //   304: astore 4
    //   306: aload 6
    //   308: aload 5
    //   310: ldc_w 541
    //   313: invokeinterface 547 3 0
    //   318: aload 5
    //   320: astore_3
    //   321: aload 5
    //   323: astore 4
    //   325: aload 6
    //   327: invokeinterface 550 1 0
    //   332: istore_2
    //   333: goto +650 -> 983
    //   336: aload 5
    //   338: astore_3
    //   339: aload 5
    //   341: astore 4
    //   343: aload 6
    //   345: invokeinterface 551 1 0
    //   350: pop
    //   351: goto +475 -> 826
    //   354: aload 5
    //   356: astore_3
    //   357: aload 5
    //   359: astore 4
    //   361: aload 6
    //   363: invokeinterface 551 1 0
    //   368: astore 7
    //   370: aload 5
    //   372: astore_3
    //   373: aload 5
    //   375: astore 4
    //   377: aload 7
    //   379: ldc_w 553
    //   382: invokevirtual 556	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   385: ifne +99 -> 484
    //   388: aload 5
    //   390: astore_3
    //   391: aload 5
    //   393: astore 4
    //   395: aload 6
    //   397: invokeinterface 559 1 0
    //   402: invokestatic 565	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   405: invokevirtual 568	java/lang/Integer:intValue	()I
    //   408: aload_1
    //   409: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   412: getfield 242	btmsdkobf/bt:gH	I
    //   415: if_icmpeq +411 -> 826
    //   418: aload 5
    //   420: astore_3
    //   421: aload 5
    //   423: astore 4
    //   425: new 62	java/lang/StringBuilder
    //   428: dup
    //   429: ldc_w 570
    //   432: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   435: astore 6
    //   437: aload 5
    //   439: astore_3
    //   440: aload 5
    //   442: astore 4
    //   444: aload 6
    //   446: aload_1
    //   447: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   450: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload 5
    //   456: astore_3
    //   457: aload 5
    //   459: astore 4
    //   461: ldc_w 313
    //   464: aload 6
    //   466: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   472: aload 5
    //   474: ifnull +8 -> 482
    //   477: aload 5
    //   479: invokevirtual 573	java/io/InputStream:close	()V
    //   482: iconst_0
    //   483: ireturn
    //   484: aload 5
    //   486: astore_3
    //   487: aload 5
    //   489: astore 4
    //   491: aload 7
    //   493: ldc_w 575
    //   496: invokevirtual 556	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   499: ifne +99 -> 598
    //   502: aload 5
    //   504: astore_3
    //   505: aload 5
    //   507: astore 4
    //   509: aload 6
    //   511: invokeinterface 559 1 0
    //   516: invokestatic 565	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   519: invokevirtual 568	java/lang/Integer:intValue	()I
    //   522: aload_1
    //   523: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   526: getfield 249	btmsdkobf/bt:gI	I
    //   529: if_icmpeq +297 -> 826
    //   532: aload 5
    //   534: astore_3
    //   535: aload 5
    //   537: astore 4
    //   539: new 62	java/lang/StringBuilder
    //   542: dup
    //   543: ldc_w 577
    //   546: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   549: astore 6
    //   551: aload 5
    //   553: astore_3
    //   554: aload 5
    //   556: astore 4
    //   558: aload 6
    //   560: aload_1
    //   561: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   564: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload 5
    //   570: astore_3
    //   571: aload 5
    //   573: astore 4
    //   575: ldc_w 313
    //   578: aload 6
    //   580: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   586: aload 5
    //   588: ifnull +8 -> 596
    //   591: aload 5
    //   593: invokevirtual 573	java/io/InputStream:close	()V
    //   596: iconst_0
    //   597: ireturn
    //   598: aload 5
    //   600: astore_3
    //   601: aload 5
    //   603: astore 4
    //   605: aload 7
    //   607: ldc_w 579
    //   610: invokevirtual 556	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   613: ifne +99 -> 712
    //   616: aload 5
    //   618: astore_3
    //   619: aload 5
    //   621: astore 4
    //   623: aload 6
    //   625: invokeinterface 559 1 0
    //   630: invokestatic 565	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   633: invokevirtual 568	java/lang/Integer:intValue	()I
    //   636: aload_1
    //   637: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   640: getfield 582	btmsdkobf/bt:gJ	I
    //   643: if_icmpeq +183 -> 826
    //   646: aload 5
    //   648: astore_3
    //   649: aload 5
    //   651: astore 4
    //   653: new 62	java/lang/StringBuilder
    //   656: dup
    //   657: ldc_w 584
    //   660: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   663: astore 6
    //   665: aload 5
    //   667: astore_3
    //   668: aload 5
    //   670: astore 4
    //   672: aload 6
    //   674: aload_1
    //   675: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   678: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: aload 5
    //   684: astore_3
    //   685: aload 5
    //   687: astore 4
    //   689: ldc_w 313
    //   692: aload 6
    //   694: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   700: aload 5
    //   702: ifnull +8 -> 710
    //   705: aload 5
    //   707: invokevirtual 573	java/io/InputStream:close	()V
    //   710: iconst_0
    //   711: ireturn
    //   712: aload 5
    //   714: astore_3
    //   715: aload 5
    //   717: astore 4
    //   719: aload 7
    //   721: ldc_w 586
    //   724: invokevirtual 556	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   727: ifne +99 -> 826
    //   730: aload 5
    //   732: astore_3
    //   733: aload 5
    //   735: astore 4
    //   737: aload 6
    //   739: invokeinterface 559 1 0
    //   744: invokestatic 565	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   747: invokevirtual 568	java/lang/Integer:intValue	()I
    //   750: aload_1
    //   751: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   754: getfield 466	btmsdkobf/bt:gK	I
    //   757: if_icmpeq +69 -> 826
    //   760: aload 5
    //   762: astore_3
    //   763: aload 5
    //   765: astore 4
    //   767: new 62	java/lang/StringBuilder
    //   770: dup
    //   771: ldc_w 588
    //   774: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   777: astore 6
    //   779: aload 5
    //   781: astore_3
    //   782: aload 5
    //   784: astore 4
    //   786: aload 6
    //   788: aload_1
    //   789: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   792: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload 5
    //   798: astore_3
    //   799: aload 5
    //   801: astore 4
    //   803: ldc_w 313
    //   806: aload 6
    //   808: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   814: aload 5
    //   816: ifnull +8 -> 824
    //   819: aload 5
    //   821: invokevirtual 573	java/io/InputStream:close	()V
    //   824: iconst_0
    //   825: ireturn
    //   826: aload 5
    //   828: astore_3
    //   829: aload 5
    //   831: astore 4
    //   833: aload 6
    //   835: invokeinterface 590 1 0
    //   840: istore_2
    //   841: goto +142 -> 983
    //   844: aload 5
    //   846: ifnull +8 -> 854
    //   849: aload 5
    //   851: invokevirtual 573	java/io/InputStream:close	()V
    //   854: new 62	java/lang/StringBuilder
    //   857: dup
    //   858: ldc_w 469
    //   861: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   864: astore_3
    //   865: aload_3
    //   866: aload_1
    //   867: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   870: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: pop
    //   874: ldc_w 313
    //   877: aload_3
    //   878: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   884: iconst_1
    //   885: ireturn
    //   886: astore_1
    //   887: goto +57 -> 944
    //   890: aload 4
    //   892: astore_3
    //   893: new 62	java/lang/StringBuilder
    //   896: dup
    //   897: ldc_w 592
    //   900: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   903: astore 5
    //   905: aload 4
    //   907: astore_3
    //   908: aload 5
    //   910: aload_1
    //   911: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   914: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: pop
    //   918: aload 4
    //   920: astore_3
    //   921: ldc_w 313
    //   924: aload 5
    //   926: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   929: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   932: aload 4
    //   934: ifnull +8 -> 942
    //   937: aload 4
    //   939: invokevirtual 573	java/io/InputStream:close	()V
    //   942: iconst_0
    //   943: ireturn
    //   944: aload_3
    //   945: ifnull +7 -> 952
    //   948: aload_3
    //   949: invokevirtual 573	java/io/InputStream:close	()V
    //   952: aload_1
    //   953: athrow
    //   954: iconst_0
    //   955: ireturn
    //   956: astore_3
    //   957: goto -67 -> 890
    //   960: astore_1
    //   961: iconst_0
    //   962: ireturn
    //   963: astore_1
    //   964: iconst_0
    //   965: ireturn
    //   966: astore_1
    //   967: iconst_0
    //   968: ireturn
    //   969: astore_1
    //   970: iconst_0
    //   971: ireturn
    //   972: astore_3
    //   973: goto -119 -> 854
    //   976: astore_1
    //   977: iconst_0
    //   978: ireturn
    //   979: astore_3
    //   980: goto -28 -> 952
    //   983: iload_2
    //   984: iconst_1
    //   985: if_icmpeq -141 -> 844
    //   988: iload_2
    //   989: ifeq -163 -> 826
    //   992: iload_2
    //   993: tableswitch	default:+23 -> 1016, 2:+-639->354, 3:+-657->336
    //   1017: impdep2
    //   1018: lstore_3
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1019	0	this	bq
    //   0	1019	1	parambr	br
    //   332	661	2	i	int
    //   30	919	3	localObject1	Object
    //   956	1	3	localThrowable	Throwable
    //   972	1	3	localIOException1	java.io.IOException
    //   979	1	3	localIOException2	java.io.IOException
    //   192	746	4	localObject2	Object
    //   185	740	5	localObject3	Object
    //   182	652	6	localObject4	Object
    //   61	659	7	str	String
    //   203	74	8	localAssetManager	android.content.res.AssetManager
    //   230	23	9	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   194	205	886	finally
    //   212	232	886	finally
    //   239	245	886	finally
    //   252	269	886	finally
    //   276	287	886	finally
    //   294	299	886	finally
    //   306	318	886	finally
    //   325	333	886	finally
    //   343	351	886	finally
    //   361	370	886	finally
    //   377	388	886	finally
    //   395	418	886	finally
    //   425	437	886	finally
    //   444	454	886	finally
    //   461	472	886	finally
    //   491	502	886	finally
    //   509	532	886	finally
    //   539	551	886	finally
    //   558	568	886	finally
    //   575	586	886	finally
    //   605	616	886	finally
    //   623	646	886	finally
    //   653	665	886	finally
    //   672	682	886	finally
    //   689	700	886	finally
    //   719	730	886	finally
    //   737	760	886	finally
    //   767	779	886	finally
    //   786	796	886	finally
    //   803	814	886	finally
    //   833	841	886	finally
    //   893	905	886	finally
    //   908	918	886	finally
    //   921	932	886	finally
    //   194	205	956	java/lang/Throwable
    //   212	232	956	java/lang/Throwable
    //   239	245	956	java/lang/Throwable
    //   252	269	956	java/lang/Throwable
    //   276	287	956	java/lang/Throwable
    //   294	299	956	java/lang/Throwable
    //   306	318	956	java/lang/Throwable
    //   325	333	956	java/lang/Throwable
    //   343	351	956	java/lang/Throwable
    //   361	370	956	java/lang/Throwable
    //   377	388	956	java/lang/Throwable
    //   395	418	956	java/lang/Throwable
    //   425	437	956	java/lang/Throwable
    //   444	454	956	java/lang/Throwable
    //   461	472	956	java/lang/Throwable
    //   491	502	956	java/lang/Throwable
    //   509	532	956	java/lang/Throwable
    //   539	551	956	java/lang/Throwable
    //   558	568	956	java/lang/Throwable
    //   575	586	956	java/lang/Throwable
    //   605	616	956	java/lang/Throwable
    //   623	646	956	java/lang/Throwable
    //   653	665	956	java/lang/Throwable
    //   672	682	956	java/lang/Throwable
    //   689	700	956	java/lang/Throwable
    //   719	730	956	java/lang/Throwable
    //   737	760	956	java/lang/Throwable
    //   767	779	956	java/lang/Throwable
    //   786	796	956	java/lang/Throwable
    //   803	814	956	java/lang/Throwable
    //   833	841	956	java/lang/Throwable
    //   477	482	960	java/io/IOException
    //   591	596	963	java/io/IOException
    //   705	710	966	java/io/IOException
    //   819	824	969	java/io/IOException
    //   849	854	972	java/io/IOException
    //   937	942	976	java/io/IOException
    //   948	952	979	java/io/IOException
  }
  
  private void c(br parambr)
  {
    try
    {
      if (this.gw.i(parambr.gz.gH) == null)
      {
        a(parambr, false);
        return;
      }
      if ((parambr.gz.gM > 51200) && (!NetworkUtil.isWifiConnected())) {
        return;
      }
      localObject = new File(parambr.aa());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      parambr.gB = 2;
      this.gw.d(parambr);
      localObject = new HttpGetFile(bc.n());
      ((HttpGetFile)localObject).setSavePath(parambr.aa());
      ((HttpGetFile)localObject).setSaveName(parambr.Z());
      int i;
      do
      {
        i = ((HttpGetFile)localObject).doGetFile(null, parambr.gz.gO, false, null);
      } while (i == -7);
      if (this.gw.i(parambr.gz.gH) == null)
      {
        a(parambr, false);
        return;
      }
      if (i == 0)
      {
        localObject = new StringBuilder("1;;");
        ((StringBuilder)localObject).append(parambr.Z());
        be.SaveStringData(1320036, ((StringBuilder)localObject).toString());
        if (!b(parambr))
        {
          a(parambr, false);
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(parambr.aa());
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(parambr.Z());
        localObject = ((StringBuilder)localObject).toString();
        if (!a((String)localObject, (String)localObject, true))
        {
          localObject = new StringBuilder("0;1015;");
          ((StringBuilder)localObject).append(parambr.Z());
          be.SaveStringData(1320038, ((StringBuilder)localObject).toString());
          a(parambr, false);
          return;
        }
        parambr.gB = 3;
        this.gw.d(parambr);
        a(parambr, 1);
        return;
      }
      localObject = new StringBuilder("0;1004;");
      ((StringBuilder)localObject).append(parambr.Z());
      be.SaveStringData(1320036, ((StringBuilder)localObject).toString());
      parambr.gB = 1;
      this.gw.d(parambr);
      W();
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label356:
      break label356;
    }
    localObject = new StringBuilder("0;1004;");
    ((StringBuilder)localObject).append(parambr.Z());
    be.SaveStringData(1320036, ((StringBuilder)localObject).toString());
    parambr.gB = 1;
    this.gw.e(parambr);
    W();
  }
  
  public int R()
  {
    return 519;
  }
  
  public void S()
  {
    try
    {
      U();
      this.gu.removeMessages(260);
      this.gu.sendEmptyMessage(260);
      this.gu.removeMessages(257);
      this.gu.sendEmptyMessage(257);
      this.gu.removeMessages(258);
      this.gu.sendEmptyMessage(258);
      this.gu.removeMessages(262);
      this.gu.sendEmptyMessage(262);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void T()
  {
    try
    {
      if (this.gw == null) {
        this.gw = bs.ac();
      }
      if (this.gw.af() == null)
      {
        X();
        return;
      }
      U();
      this.gu.removeMessages(258);
      this.gu.sendEmptyMessage(258);
      this.gu.removeMessages(262);
      this.gu.sendEmptyMessage(262);
      return;
    }
    finally {}
  }
  
  public Boolean Y()
  {
    return Boolean.valueOf(ec.cS().getBoolean("r_e", false));
  }
  
  public void a(aso paramaso)
  {
    try
    {
      U();
      Message.obtain(this.gu, 261, paramaso).sendToTarget();
      this.gu.sendEmptyMessage(262);
      return;
    }
    finally
    {
      paramaso = finally;
      throw paramaso;
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    ec.cS().putBoolean("r_e", paramBoolean.booleanValue());
  }
  
  /* Error */
  public void onRecvPush(com.tmsdk.base.conch.ConchService.ConchPushInfo paramConchPushInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 62	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 677
    //   9: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: astore 5
    //   14: aload 5
    //   16: aload_1
    //   17: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 5
    //   23: ldc 79
    //   25: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 5
    //   31: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 87	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   37: new 198	btmsdkobf/br
    //   40: dup
    //   41: invokespecial 681	btmsdkobf/br:<init>	()V
    //   44: astore 5
    //   46: aload 5
    //   48: new 238	btmsdkobf/bt
    //   51: dup
    //   52: invokespecial 682	btmsdkobf/bt:<init>	()V
    //   55: putfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   58: aload_0
    //   59: invokevirtual 684	btmsdkobf/bq:R	()I
    //   62: aload_1
    //   63: getfield 690	com/tmsdk/base/conch/ConchService$ConchPushInfo:mConch	Lbtmsdkobf/z;
    //   66: getfield 695	btmsdkobf/z:cmdId	I
    //   69: if_icmpne +544 -> 613
    //   72: aload_1
    //   73: getfield 690	com/tmsdk/base/conch/ConchService$ConchPushInfo:mConch	Lbtmsdkobf/z;
    //   76: getfield 699	btmsdkobf/z:aZ	[B
    //   79: astore 6
    //   81: new 701	btmsdkobf/ad
    //   84: dup
    //   85: invokespecial 702	btmsdkobf/ad:<init>	()V
    //   88: astore 7
    //   90: iconst_0
    //   91: istore_2
    //   92: aload 6
    //   94: aload 7
    //   96: iconst_0
    //   97: invokestatic 707	btmsdkobf/cp:a	([BLcom/qq/taf/jce/JceStruct;Z)Lcom/qq/taf/jce/JceStruct;
    //   100: checkcast 701	btmsdkobf/ad
    //   103: astore 6
    //   105: aload_1
    //   106: getfield 690	com/tmsdk/base/conch/ConchService$ConchPushInfo:mConch	Lbtmsdkobf/z;
    //   109: getfield 711	btmsdkobf/z:bb	Lbtmsdkobf/ai;
    //   112: getfield 716	btmsdkobf/ai:validEndTime	I
    //   115: i2l
    //   116: ldc2_w 717
    //   119: lmul
    //   120: lstore_3
    //   121: lload_3
    //   122: invokestatic 721	java/lang/System:currentTimeMillis	()J
    //   125: lcmp
    //   126: ifge +12 -> 138
    //   129: ldc_w 723
    //   132: invokestatic 726	btmsdkobf/bo:l	(Ljava/lang/String;)V
    //   135: aload_0
    //   136: monitorexit
    //   137: return
    //   138: invokestatic 732	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   141: lload_3
    //   142: invokevirtual 736	java/util/Calendar:setTimeInMillis	(J)V
    //   145: aload 5
    //   147: aload 6
    //   149: getfield 740	btmsdkobf/ad:bm	Ljava/util/ArrayList;
    //   152: iconst_0
    //   153: invokevirtual 745	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   156: checkcast 33	java/lang/String
    //   159: invokestatic 750	com/tmsdk/base/utils/ConvertUtil:stringToInt	(Ljava/lang/String;)I
    //   162: putfield 753	btmsdkobf/br:gA	I
    //   165: aload 5
    //   167: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   170: aload 6
    //   172: getfield 740	btmsdkobf/ad:bm	Ljava/util/ArrayList;
    //   175: iconst_1
    //   176: invokevirtual 745	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   179: checkcast 33	java/lang/String
    //   182: invokestatic 750	com/tmsdk/base/utils/ConvertUtil:stringToInt	(Ljava/lang/String;)I
    //   185: putfield 242	btmsdkobf/bt:gH	I
    //   188: aload 5
    //   190: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   193: aload 6
    //   195: getfield 740	btmsdkobf/ad:bm	Ljava/util/ArrayList;
    //   198: iconst_2
    //   199: invokevirtual 745	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   202: checkcast 33	java/lang/String
    //   205: invokestatic 750	com/tmsdk/base/utils/ConvertUtil:stringToInt	(Ljava/lang/String;)I
    //   208: putfield 249	btmsdkobf/bt:gI	I
    //   211: aload 5
    //   213: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   216: aload 6
    //   218: getfield 740	btmsdkobf/ad:bm	Ljava/util/ArrayList;
    //   221: iconst_3
    //   222: invokevirtual 745	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   225: checkcast 33	java/lang/String
    //   228: invokestatic 750	com/tmsdk/base/utils/ConvertUtil:stringToInt	(Ljava/lang/String;)I
    //   231: putfield 582	btmsdkobf/bt:gJ	I
    //   234: aload 5
    //   236: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   239: aload 6
    //   241: getfield 740	btmsdkobf/ad:bm	Ljava/util/ArrayList;
    //   244: iconst_4
    //   245: invokevirtual 745	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   248: checkcast 33	java/lang/String
    //   251: invokestatic 750	com/tmsdk/base/utils/ConvertUtil:stringToInt	(Ljava/lang/String;)I
    //   254: putfield 466	btmsdkobf/bt:gK	I
    //   257: aload 5
    //   259: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   262: aload 6
    //   264: getfield 740	btmsdkobf/ad:bm	Ljava/util/ArrayList;
    //   267: iconst_5
    //   268: invokevirtual 745	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   271: checkcast 33	java/lang/String
    //   274: invokestatic 750	com/tmsdk/base/utils/ConvertUtil:stringToInt	(Ljava/lang/String;)I
    //   277: putfield 505	btmsdkobf/bt:gM	I
    //   280: aload 5
    //   282: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   285: aload 6
    //   287: getfield 740	btmsdkobf/ad:bm	Ljava/util/ArrayList;
    //   290: bipush 6
    //   292: invokevirtual 745	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   295: checkcast 33	java/lang/String
    //   298: putfield 513	btmsdkobf/bt:gN	Ljava/lang/String;
    //   301: aload 5
    //   303: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   306: aload 6
    //   308: getfield 740	btmsdkobf/ad:bm	Ljava/util/ArrayList;
    //   311: bipush 7
    //   313: invokevirtual 745	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   316: checkcast 33	java/lang/String
    //   319: putfield 627	btmsdkobf/bt:gO	Ljava/lang/String;
    //   322: aload 5
    //   324: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   327: lload_3
    //   328: putfield 757	btmsdkobf/bt:gL	J
    //   331: aload 5
    //   333: iconst_1
    //   334: putfield 610	btmsdkobf/br:gB	I
    //   337: aload 5
    //   339: getfield 753	btmsdkobf/br:gA	I
    //   342: iconst_1
    //   343: if_icmpeq +81 -> 424
    //   346: aload 5
    //   348: getfield 753	btmsdkobf/br:gA	I
    //   351: iconst_2
    //   352: if_icmpeq +72 -> 424
    //   355: new 62	java/lang/StringBuilder
    //   358: dup
    //   359: ldc_w 759
    //   362: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   365: astore_1
    //   366: aload_1
    //   367: aload 5
    //   369: getfield 753	btmsdkobf/br:gA	I
    //   372: invokevirtual 762	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_1
    //   377: ldc 79
    //   379: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload_1
    //   384: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 726	btmsdkobf/bo:l	(Ljava/lang/String;)V
    //   390: new 62	java/lang/StringBuilder
    //   393: dup
    //   394: ldc_w 764
    //   397: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   400: astore_1
    //   401: aload_1
    //   402: aload 5
    //   404: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   407: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: ldc_w 765
    //   414: aload_1
    //   415: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   421: aload_0
    //   422: monitorexit
    //   423: return
    //   424: new 62	java/lang/StringBuilder
    //   427: dup
    //   428: ldc_w 767
    //   431: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   434: astore_1
    //   435: aload_1
    //   436: aload 5
    //   438: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload_1
    //   443: ldc 79
    //   445: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload_1
    //   450: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 87	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   456: iload_2
    //   457: getstatic 31	btmsdkobf/bq:gp	[I
    //   460: arraylength
    //   461: if_icmpge +26 -> 487
    //   464: aload 5
    //   466: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   469: getfield 582	btmsdkobf/bt:gJ	I
    //   472: getstatic 31	btmsdkobf/bq:gp	[I
    //   475: iload_2
    //   476: iaload
    //   477: if_icmpeq +10 -> 487
    //   480: iload_2
    //   481: iconst_1
    //   482: iadd
    //   483: istore_2
    //   484: goto -28 -> 456
    //   487: iload_2
    //   488: getstatic 31	btmsdkobf/bq:gp	[I
    //   491: arraylength
    //   492: if_icmplt +75 -> 567
    //   495: new 62	java/lang/StringBuilder
    //   498: dup
    //   499: ldc_w 769
    //   502: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   505: astore_1
    //   506: aload_1
    //   507: aload 5
    //   509: getfield 202	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   512: getfield 582	btmsdkobf/bt:gJ	I
    //   515: invokevirtual 762	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_1
    //   520: ldc 79
    //   522: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload_1
    //   527: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 726	btmsdkobf/bo:l	(Ljava/lang/String;)V
    //   533: new 62	java/lang/StringBuilder
    //   536: dup
    //   537: ldc_w 771
    //   540: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   543: astore_1
    //   544: aload_1
    //   545: aload 5
    //   547: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   550: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: ldc_w 765
    //   557: aload_1
    //   558: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   564: aload_0
    //   565: monitorexit
    //   566: return
    //   567: new 62	java/lang/StringBuilder
    //   570: dup
    //   571: ldc_w 469
    //   574: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   577: astore_1
    //   578: aload_1
    //   579: aload 5
    //   581: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   584: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: ldc_w 765
    //   591: aload_1
    //   592: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   598: invokestatic 136	btmsdkobf/bq:Q	()Lbtmsdkobf/bq;
    //   601: getstatic 774	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   604: invokevirtual 146	btmsdkobf/bq:a	(Ljava/lang/Boolean;)V
    //   607: aload_0
    //   608: aload 5
    //   610: invokespecial 776	btmsdkobf/bq:a	(Lbtmsdkobf/br;)V
    //   613: aload_0
    //   614: monitorexit
    //   615: return
    //   616: astore_1
    //   617: new 62	java/lang/StringBuilder
    //   620: dup
    //   621: ldc_w 778
    //   624: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   627: astore 6
    //   629: aload 6
    //   631: aload 5
    //   633: invokevirtual 257	btmsdkobf/br:Z	()Ljava/lang/String;
    //   636: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: ldc_w 765
    //   643: aload 6
    //   645: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 264	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   651: new 62	java/lang/StringBuilder
    //   654: dup
    //   655: ldc_w 780
    //   658: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   661: astore 5
    //   663: aload 5
    //   665: aload_1
    //   666: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: aload 5
    //   672: ldc 79
    //   674: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: aload 5
    //   680: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 726	btmsdkobf/bo:l	(Ljava/lang/String;)V
    //   686: aload_0
    //   687: monitorexit
    //   688: return
    //   689: astore_1
    //   690: aload_0
    //   691: monitorexit
    //   692: aload_1
    //   693: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	694	0	this	bq
    //   0	694	1	paramConchPushInfo	com.tmsdk.base.conch.ConchService.ConchPushInfo
    //   91	402	2	i	int
    //   120	208	3	l	long
    //   12	667	5	localObject1	Object
    //   79	565	6	localObject2	Object
    //   88	7	7	localad	ad
    // Exception table:
    //   from	to	target	type
    //   58	90	616	java/lang/Throwable
    //   92	135	616	java/lang/Throwable
    //   138	421	616	java/lang/Throwable
    //   424	456	616	java/lang/Throwable
    //   456	480	616	java/lang/Throwable
    //   487	564	616	java/lang/Throwable
    //   567	613	616	java/lang/Throwable
    //   2	58	689	finally
    //   58	90	689	finally
    //   92	135	689	finally
    //   138	421	689	finally
    //   424	456	689	finally
    //   456	480	689	finally
    //   487	564	689	finally
    //   567	613	689	finally
    //   617	686	689	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bq
 * JD-Core Version:    0.7.0.1
 */