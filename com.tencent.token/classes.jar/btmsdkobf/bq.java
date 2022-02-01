package btmsdkobf;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tmsdk.base.conch.ConchService.ConchPushInfo;
import com.tmsdk.base.utils.ConvertUtil;
import com.tmsdk.base.utils.HttpGetFile;
import com.tmsdk.base.utils.NetworkUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tmsdk.common.roach.nest.ActionI;

public class bq
{
  static final int[] gp = { 202 };
  static final String[] gq = { "00B1208638DE0FCD3E920886D658DAF6", "7CC749CFC0FB5677E6ABA342EDBDBA5A" };
  static bq gx = null;
  HashMap<bt, Class<?>> gr = new HashMap();
  HashMap<bt, ActionI> gs = new HashMap();
  HandlerThread gt = null;
  Handler gu = null;
  eb.a gv = null;
  private bs gw = null;
  
  private bq()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RoachManager-RoachManager-NEST_IDS:[");
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
    //   21: ldc 90
    //   23: invokestatic 86	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   26: new 2	btmsdkobf/bq
    //   29: dup
    //   30: invokespecial 91	btmsdkobf/bq:<init>	()V
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
        public void handleMessage(Message paramAnonymousMessage)
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
              return;
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
          }
          else if (paramAnonymousMessage.what == 258)
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
          }
          else if (paramAnonymousMessage.what == 260)
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
          }
          else if (paramAnonymousMessage.what == 261)
          {
            paramAnonymousMessage = (ActionI)paramAnonymousMessage.obj;
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
              if ((ActionI)bq.this.gs.get(localObject2) == paramAnonymousMessage)
              {
                bq.this.gs.remove(localObject2);
                return;
                if (paramAnonymousMessage.what == 262) {
                  bq.d(bq.this);
                }
              }
            }
            return;
          }
          catch (Throwable paramAnonymousMessage) {}
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
          Q().a(Boolean.valueOf(false));
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
        public void O()
        {
          bq.this.T();
        }
        
        public void P() {}
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
    //   1: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   4: astore 9
    //   6: aload_0
    //   7: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   10: invokevirtual 220	java/util/HashMap:keySet	()Ljava/util/Set;
    //   13: invokeinterface 226 1 0
    //   18: astore 5
    //   20: aload 5
    //   22: invokeinterface 231 1 0
    //   27: ifeq +220 -> 247
    //   30: aload 5
    //   32: invokeinterface 235 1 0
    //   37: checkcast 237	btmsdkobf/bt
    //   40: astore 6
    //   42: aload 6
    //   44: getfield 241	btmsdkobf/bt:gH	I
    //   47: aload 9
    //   49: getfield 241	btmsdkobf/bt:gH	I
    //   52: if_icmpne -32 -> 20
    //   55: aload_0
    //   56: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   59: aload 6
    //   61: invokevirtual 245	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: checkcast 247	tmsdk/common/roach/nest/ActionI
    //   67: astore 7
    //   69: aload 9
    //   71: getfield 250	btmsdkobf/bt:gI	I
    //   74: aload 6
    //   76: getfield 250	btmsdkobf/bt:gI	I
    //   79: if_icmple +41 -> 120
    //   82: aload 7
    //   84: invokevirtual 253	tmsdk/common/roach/nest/ActionI:onStop	()V
    //   87: aload 7
    //   89: invokevirtual 256	tmsdk/common/roach/nest/ActionI:clean	()V
    //   92: aload_0
    //   93: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   96: aload 6
    //   98: invokevirtual 259	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   101: pop
    //   102: aload_0
    //   103: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   106: aload 6
    //   108: invokevirtual 259	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   111: pop
    //   112: iload_2
    //   113: iconst_1
    //   114: if_icmpne +1839 -> 1953
    //   117: goto +130 -> 247
    //   120: aload 9
    //   122: getfield 250	btmsdkobf/bt:gI	I
    //   125: aload 6
    //   127: getfield 250	btmsdkobf/bt:gI	I
    //   130: if_icmpne +44 -> 174
    //   133: iload_2
    //   134: iconst_1
    //   135: if_icmpne +4 -> 139
    //   138: return
    //   139: iload_2
    //   140: iconst_2
    //   141: if_icmpne -121 -> 20
    //   144: aload 7
    //   146: invokevirtual 253	tmsdk/common/roach/nest/ActionI:onStop	()V
    //   149: aload 7
    //   151: invokevirtual 256	tmsdk/common/roach/nest/ActionI:clean	()V
    //   154: aload_0
    //   155: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   158: aload 6
    //   160: invokevirtual 259	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   163: pop
    //   164: aload_0
    //   165: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   168: aload 6
    //   170: invokevirtual 259	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   173: pop
    //   174: return
    //   175: iload_2
    //   176: iconst_1
    //   177: if_icmpne +47 -> 224
    //   180: new 62	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   187: astore 5
    //   189: ldc_w 261
    //   192: astore 6
    //   194: aload 5
    //   196: aload 6
    //   198: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 5
    //   204: aload_1
    //   205: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   208: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: ldc_w 265
    //   215: aload 5
    //   217: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 271	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   223: return
    //   224: iload_2
    //   225: iconst_2
    //   226: if_icmpne +20 -> 246
    //   229: new 62	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   236: astore 5
    //   238: ldc_w 273
    //   241: astore 6
    //   243: goto -49 -> 194
    //   246: return
    //   247: aload_0
    //   248: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   251: invokevirtual 220	java/util/HashMap:keySet	()Ljava/util/Set;
    //   254: invokeinterface 226 1 0
    //   259: astore 6
    //   261: aload 6
    //   263: invokeinterface 231 1 0
    //   268: ifeq +264 -> 532
    //   271: aload 6
    //   273: invokeinterface 235 1 0
    //   278: checkcast 237	btmsdkobf/bt
    //   281: astore 5
    //   283: aload 5
    //   285: getfield 241	btmsdkobf/bt:gH	I
    //   288: aload 9
    //   290: getfield 241	btmsdkobf/bt:gH	I
    //   293: if_icmpne -32 -> 261
    //   296: aload 9
    //   298: getfield 250	btmsdkobf/bt:gI	I
    //   301: aload 5
    //   303: getfield 250	btmsdkobf/bt:gI	I
    //   306: if_icmple +43 -> 349
    //   309: aload_0
    //   310: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   313: aload 5
    //   315: invokevirtual 245	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   318: checkcast 275	java/lang/Class
    //   321: iconst_0
    //   322: anewarray 275	java/lang/Class
    //   325: invokevirtual 279	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   328: iconst_0
    //   329: anewarray 4	java/lang/Object
    //   332: invokevirtual 285	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   335: checkcast 247	tmsdk/common/roach/nest/ActionI
    //   338: invokevirtual 256	tmsdk/common/roach/nest/ActionI:clean	()V
    //   341: iload_2
    //   342: iconst_1
    //   343: if_icmpne +1616 -> 1959
    //   346: goto +186 -> 532
    //   349: aload 5
    //   351: getfield 250	btmsdkobf/bt:gI	I
    //   354: aload 9
    //   356: getfield 250	btmsdkobf/bt:gI	I
    //   359: if_icmpne +100 -> 459
    //   362: aload_0
    //   363: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   366: aload 5
    //   368: invokevirtual 245	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   371: checkcast 275	java/lang/Class
    //   374: iconst_0
    //   375: anewarray 275	java/lang/Class
    //   378: invokevirtual 279	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   381: iconst_0
    //   382: anewarray 4	java/lang/Object
    //   385: invokevirtual 285	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   388: checkcast 247	tmsdk/common/roach/nest/ActionI
    //   391: astore 6
    //   393: iload_2
    //   394: iconst_1
    //   395: if_icmpne +44 -> 439
    //   398: new 287	android/os/Bundle
    //   401: dup
    //   402: invokespecial 288	android/os/Bundle:<init>	()V
    //   405: astore 7
    //   407: aload 7
    //   409: ldc_w 290
    //   412: aload_1
    //   413: invokevirtual 293	btmsdkobf/br:aa	()Ljava/lang/String;
    //   416: invokevirtual 297	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: aload 6
    //   421: aload 7
    //   423: invokevirtual 301	tmsdk/common/roach/nest/ActionI:onStart	(Landroid/os/Bundle;)V
    //   426: aload_0
    //   427: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   430: aload 5
    //   432: aload 6
    //   434: invokevirtual 305	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   437: pop
    //   438: return
    //   439: iload_2
    //   440: iconst_2
    //   441: if_icmpne +18 -> 459
    //   444: aload 6
    //   446: invokevirtual 256	tmsdk/common/roach/nest/ActionI:clean	()V
    //   449: aload_0
    //   450: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   453: aload 5
    //   455: invokevirtual 259	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   458: pop
    //   459: return
    //   460: iload_2
    //   461: iconst_1
    //   462: if_icmpne +47 -> 509
    //   465: new 62	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   472: astore 5
    //   474: ldc_w 261
    //   477: astore 6
    //   479: aload 5
    //   481: aload 6
    //   483: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 5
    //   489: aload_1
    //   490: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   493: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: ldc_w 265
    //   500: aload 5
    //   502: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 271	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   508: return
    //   509: iload_2
    //   510: iconst_2
    //   511: if_icmpne +20 -> 531
    //   514: new 62	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   521: astore 5
    //   523: ldc_w 273
    //   526: astore 6
    //   528: goto -49 -> 479
    //   531: return
    //   532: new 62	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   539: astore 5
    //   541: aload 5
    //   543: aload_1
    //   544: invokevirtual 293	btmsdkobf/br:aa	()Ljava/lang/String;
    //   547: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 5
    //   553: getstatic 311	java/io/File:separator	Ljava/lang/String;
    //   556: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload 5
    //   562: aload_1
    //   563: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   566: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 5
    //   572: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: astore 10
    //   577: new 307	java/io/File
    //   580: dup
    //   581: aload 10
    //   583: invokespecial 313	java/io/File:<init>	(Ljava/lang/String;)V
    //   586: astore 11
    //   588: aload 11
    //   590: invokevirtual 316	java/io/File:exists	()Z
    //   593: ifne +4 -> 597
    //   596: return
    //   597: aload_0
    //   598: aload 10
    //   600: aload 10
    //   602: iconst_0
    //   603: invokespecial 319	btmsdkobf/bq:a	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   606: istore 4
    //   608: iload 4
    //   610: ifne +62 -> 672
    //   613: new 62	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   620: astore 5
    //   622: aload 5
    //   624: ldc_w 321
    //   627: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: aload 5
    //   633: aload_1
    //   634: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   637: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: ldc_w 322
    //   644: aload 5
    //   646: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokestatic 271	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   652: aload_0
    //   653: aload_1
    //   654: iconst_0
    //   655: invokespecial 195	btmsdkobf/bq:a	(Lbtmsdkobf/br;Z)V
    //   658: return
    //   659: astore_1
    //   660: aconst_null
    //   661: astore 5
    //   663: goto +1222 -> 1885
    //   666: aconst_null
    //   667: astore 5
    //   669: goto +1105 -> 1774
    //   672: ldc_w 324
    //   675: astore 5
    //   677: aload 5
    //   679: astore 6
    //   681: invokestatic 329	tmsdk/common/tcc/b:cP	()Z
    //   684: ifeq +8 -> 692
    //   687: ldc_w 331
    //   690: astore 6
    //   692: new 333	java/util/zip/ZipFile
    //   695: dup
    //   696: aload 11
    //   698: invokespecial 336	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   701: astore 5
    //   703: aload 5
    //   705: invokevirtual 340	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   708: astore 12
    //   710: aload 12
    //   712: invokeinterface 345 1 0
    //   717: ifeq +344 -> 1061
    //   720: aload 12
    //   722: invokeinterface 348 1 0
    //   727: checkcast 350	java/util/zip/ZipEntry
    //   730: astore 13
    //   732: aload 13
    //   734: ifnull -24 -> 710
    //   737: aload 13
    //   739: invokevirtual 353	java/util/zip/ZipEntry:isDirectory	()Z
    //   742: ifne -32 -> 710
    //   745: aload 13
    //   747: invokevirtual 356	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   750: ldc_w 358
    //   753: invokevirtual 362	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   756: ifeq +6 -> 762
    //   759: goto +1206 -> 1965
    //   762: aload 13
    //   764: invokevirtual 356	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   767: astore 7
    //   769: new 62	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   776: astore 8
    //   778: aload 8
    //   780: ldc_w 364
    //   783: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload 8
    //   789: aload 7
    //   791: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: aload 8
    //   797: ldc 77
    //   799: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload 8
    //   805: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: invokestatic 86	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   811: aload 7
    //   813: invokestatic 369	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   816: ifne +1149 -> 1965
    //   819: aload 7
    //   821: aload 6
    //   823: invokevirtual 362	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   826: ifne +6 -> 832
    //   829: goto +1136 -> 1965
    //   832: aload 7
    //   834: aload 7
    //   836: ldc_w 371
    //   839: invokevirtual 375	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   842: iconst_1
    //   843: iadd
    //   844: invokevirtual 379	java/lang/String:substring	(I)Ljava/lang/String;
    //   847: astore 8
    //   849: aload 8
    //   851: ldc_w 381
    //   854: invokevirtual 375	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   857: istore_3
    //   858: aload 8
    //   860: astore 7
    //   862: iload_3
    //   863: ifle +41 -> 904
    //   866: new 62	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   873: astore 7
    //   875: aload 7
    //   877: aload 8
    //   879: iconst_0
    //   880: iload_3
    //   881: invokevirtual 384	java/lang/String:substring	(II)Ljava/lang/String;
    //   884: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: aload 7
    //   890: ldc_w 386
    //   893: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload 7
    //   899: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: astore 7
    //   904: new 62	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   911: astore 8
    //   913: aload 8
    //   915: aload_1
    //   916: invokevirtual 293	btmsdkobf/br:aa	()Ljava/lang/String;
    //   919: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: pop
    //   923: aload 8
    //   925: getstatic 311	java/io/File:separator	Ljava/lang/String;
    //   928: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: pop
    //   932: aload 8
    //   934: aload 7
    //   936: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: pop
    //   940: new 307	java/io/File
    //   943: dup
    //   944: aload 8
    //   946: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   949: invokespecial 313	java/io/File:<init>	(Ljava/lang/String;)V
    //   952: astore 8
    //   954: aload 8
    //   956: invokevirtual 316	java/io/File:exists	()Z
    //   959: ifeq +26 -> 985
    //   962: aload 8
    //   964: invokevirtual 390	java/io/File:length	()J
    //   967: aload 13
    //   969: invokevirtual 393	java/util/zip/ZipEntry:getSize	()J
    //   972: lcmp
    //   973: ifne +6 -> 979
    //   976: goto +989 -> 1965
    //   979: aload 8
    //   981: invokevirtual 396	java/io/File:delete	()Z
    //   984: pop
    //   985: new 398	java/io/BufferedInputStream
    //   988: dup
    //   989: aload 5
    //   991: aload 13
    //   993: invokevirtual 402	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   996: invokespecial 405	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   999: astore 7
    //   1001: new 407	java/io/FileOutputStream
    //   1004: dup
    //   1005: aload 8
    //   1007: invokespecial 408	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1010: astore 8
    //   1012: sipush 8192
    //   1015: newarray byte
    //   1017: astore 13
    //   1019: aload 7
    //   1021: aload 13
    //   1023: invokevirtual 412	java/io/BufferedInputStream:read	([B)I
    //   1026: istore_3
    //   1027: iload_3
    //   1028: ifle +15 -> 1043
    //   1031: aload 8
    //   1033: aload 13
    //   1035: iconst_0
    //   1036: iload_3
    //   1037: invokevirtual 416	java/io/FileOutputStream:write	([BII)V
    //   1040: goto -21 -> 1019
    //   1043: aload 8
    //   1045: invokevirtual 419	java/io/FileOutputStream:flush	()V
    //   1048: aload 7
    //   1050: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   1053: aload 8
    //   1055: invokevirtual 423	java/io/FileOutputStream:close	()V
    //   1058: goto +907 -> 1965
    //   1061: aload 11
    //   1063: invokevirtual 426	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1066: astore 6
    //   1068: aload 11
    //   1070: invokevirtual 426	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1073: ldc_w 381
    //   1076: invokevirtual 375	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1079: istore_3
    //   1080: iload_3
    //   1081: ifle +15 -> 1096
    //   1084: aload 11
    //   1086: invokevirtual 426	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1089: iconst_0
    //   1090: iload_3
    //   1091: invokevirtual 384	java/lang/String:substring	(II)Ljava/lang/String;
    //   1094: astore 6
    //   1096: new 62	java/lang/StringBuilder
    //   1099: dup
    //   1100: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1103: astore 7
    //   1105: aload 7
    //   1107: aload 6
    //   1109: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: pop
    //   1113: aload 7
    //   1115: new 33	java/lang/String
    //   1118: dup
    //   1119: iconst_4
    //   1120: newarray byte
    //   1122: dup
    //   1123: iconst_0
    //   1124: bipush 46
    //   1126: bastore
    //   1127: dup
    //   1128: iconst_1
    //   1129: bipush 97
    //   1131: bastore
    //   1132: dup
    //   1133: iconst_2
    //   1134: bipush 112
    //   1136: bastore
    //   1137: dup
    //   1138: iconst_3
    //   1139: bipush 107
    //   1141: bastore
    //   1142: invokespecial 429	java/lang/String:<init>	([B)V
    //   1145: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: pop
    //   1149: new 307	java/io/File
    //   1152: dup
    //   1153: aload 7
    //   1155: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1158: invokespecial 313	java/io/File:<init>	(Ljava/lang/String;)V
    //   1161: astore 7
    //   1163: aload 11
    //   1165: aload 7
    //   1167: invokevirtual 433	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1170: pop
    //   1171: new 33	java/lang/String
    //   1174: dup
    //   1175: bipush 28
    //   1177: newarray byte
    //   1179: dup
    //   1180: iconst_0
    //   1181: bipush 100
    //   1183: bastore
    //   1184: dup
    //   1185: iconst_1
    //   1186: bipush 97
    //   1188: bastore
    //   1189: dup
    //   1190: iconst_2
    //   1191: bipush 108
    //   1193: bastore
    //   1194: dup
    //   1195: iconst_3
    //   1196: bipush 118
    //   1198: bastore
    //   1199: dup
    //   1200: iconst_4
    //   1201: bipush 105
    //   1203: bastore
    //   1204: dup
    //   1205: iconst_5
    //   1206: bipush 107
    //   1208: bastore
    //   1209: dup
    //   1210: bipush 6
    //   1212: bipush 46
    //   1214: bastore
    //   1215: dup
    //   1216: bipush 7
    //   1218: bipush 115
    //   1220: bastore
    //   1221: dup
    //   1222: bipush 8
    //   1224: bipush 121
    //   1226: bastore
    //   1227: dup
    //   1228: bipush 9
    //   1230: bipush 115
    //   1232: bastore
    //   1233: dup
    //   1234: bipush 10
    //   1236: bipush 116
    //   1238: bastore
    //   1239: dup
    //   1240: bipush 11
    //   1242: bipush 101
    //   1244: bastore
    //   1245: dup
    //   1246: bipush 12
    //   1248: bipush 109
    //   1250: bastore
    //   1251: dup
    //   1252: bipush 13
    //   1254: bipush 46
    //   1256: bastore
    //   1257: dup
    //   1258: bipush 14
    //   1260: bipush 68
    //   1262: bastore
    //   1263: dup
    //   1264: bipush 15
    //   1266: bipush 101
    //   1268: bastore
    //   1269: dup
    //   1270: bipush 16
    //   1272: bipush 120
    //   1274: bastore
    //   1275: dup
    //   1276: bipush 17
    //   1278: bipush 67
    //   1280: bastore
    //   1281: dup
    //   1282: bipush 18
    //   1284: bipush 108
    //   1286: bastore
    //   1287: dup
    //   1288: bipush 19
    //   1290: bipush 97
    //   1292: bastore
    //   1293: dup
    //   1294: bipush 20
    //   1296: bipush 115
    //   1298: bastore
    //   1299: dup
    //   1300: bipush 21
    //   1302: bipush 115
    //   1304: bastore
    //   1305: dup
    //   1306: bipush 22
    //   1308: bipush 76
    //   1310: bastore
    //   1311: dup
    //   1312: bipush 23
    //   1314: bipush 111
    //   1316: bastore
    //   1317: dup
    //   1318: bipush 24
    //   1320: bipush 97
    //   1322: bastore
    //   1323: dup
    //   1324: bipush 25
    //   1326: bipush 100
    //   1328: bastore
    //   1329: dup
    //   1330: bipush 26
    //   1332: bipush 101
    //   1334: bastore
    //   1335: dup
    //   1336: bipush 27
    //   1338: bipush 114
    //   1340: bastore
    //   1341: invokespecial 429	java/lang/String:<init>	([B)V
    //   1344: invokestatic 437	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1347: astore 8
    //   1349: aload 8
    //   1351: iconst_4
    //   1352: anewarray 275	java/lang/Class
    //   1355: dup
    //   1356: iconst_0
    //   1357: ldc 33
    //   1359: aastore
    //   1360: dup
    //   1361: iconst_1
    //   1362: ldc 33
    //   1364: aastore
    //   1365: dup
    //   1366: iconst_2
    //   1367: ldc 33
    //   1369: aastore
    //   1370: dup
    //   1371: iconst_3
    //   1372: ldc_w 439
    //   1375: aastore
    //   1376: invokevirtual 279	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   1379: iconst_4
    //   1380: anewarray 4	java/lang/Object
    //   1383: dup
    //   1384: iconst_0
    //   1385: aload 7
    //   1387: invokevirtual 426	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1390: aastore
    //   1391: dup
    //   1392: iconst_1
    //   1393: aload_1
    //   1394: invokevirtual 442	btmsdkobf/br:ab	()Ljava/lang/String;
    //   1397: aastore
    //   1398: dup
    //   1399: iconst_2
    //   1400: aconst_null
    //   1401: aastore
    //   1402: dup
    //   1403: iconst_3
    //   1404: ldc 165
    //   1406: invokevirtual 446	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   1409: aastore
    //   1410: invokevirtual 285	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   1413: astore 6
    //   1415: aload 8
    //   1417: new 33	java/lang/String
    //   1420: dup
    //   1421: bipush 9
    //   1423: newarray byte
    //   1425: dup
    //   1426: iconst_0
    //   1427: bipush 108
    //   1429: bastore
    //   1430: dup
    //   1431: iconst_1
    //   1432: bipush 111
    //   1434: bastore
    //   1435: dup
    //   1436: iconst_2
    //   1437: bipush 97
    //   1439: bastore
    //   1440: dup
    //   1441: iconst_3
    //   1442: bipush 100
    //   1444: bastore
    //   1445: dup
    //   1446: iconst_4
    //   1447: bipush 67
    //   1449: bastore
    //   1450: dup
    //   1451: iconst_5
    //   1452: bipush 108
    //   1454: bastore
    //   1455: dup
    //   1456: bipush 6
    //   1458: bipush 97
    //   1460: bastore
    //   1461: dup
    //   1462: bipush 7
    //   1464: bipush 115
    //   1466: bastore
    //   1467: dup
    //   1468: bipush 8
    //   1470: bipush 115
    //   1472: bastore
    //   1473: invokespecial 429	java/lang/String:<init>	([B)V
    //   1476: iconst_1
    //   1477: anewarray 275	java/lang/Class
    //   1480: dup
    //   1481: iconst_0
    //   1482: ldc 33
    //   1484: aastore
    //   1485: invokevirtual 450	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1488: astore 8
    //   1490: aload_1
    //   1491: invokevirtual 442	btmsdkobf/br:ab	()Ljava/lang/String;
    //   1494: invokestatic 456	btmsdkobf/dz:H	(Ljava/lang/String;)Z
    //   1497: pop
    //   1498: aload 7
    //   1500: aload 11
    //   1502: invokevirtual 433	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1505: pop
    //   1506: aload_0
    //   1507: aload 10
    //   1509: aload 10
    //   1511: iconst_1
    //   1512: invokespecial 319	btmsdkobf/bq:a	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   1515: ifne +48 -> 1563
    //   1518: new 62	java/lang/StringBuilder
    //   1521: dup
    //   1522: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1525: astore 7
    //   1527: aload 7
    //   1529: ldc_w 458
    //   1532: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: pop
    //   1536: aload 7
    //   1538: aload_1
    //   1539: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   1542: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1545: pop
    //   1546: ldc_w 322
    //   1549: aload 7
    //   1551: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1554: invokestatic 271	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   1557: aload_0
    //   1558: aload_1
    //   1559: iconst_0
    //   1560: invokespecial 195	btmsdkobf/bq:a	(Lbtmsdkobf/br;Z)V
    //   1563: aload 8
    //   1565: ifnull +142 -> 1707
    //   1568: aload 8
    //   1570: iconst_1
    //   1571: invokevirtual 464	java/lang/reflect/Method:setAccessible	(Z)V
    //   1574: aload 8
    //   1576: aload 6
    //   1578: iconst_1
    //   1579: anewarray 4	java/lang/Object
    //   1582: dup
    //   1583: iconst_0
    //   1584: ldc_w 466
    //   1587: aastore
    //   1588: invokevirtual 470	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1591: checkcast 275	java/lang/Class
    //   1594: astore 6
    //   1596: aload 6
    //   1598: iconst_0
    //   1599: anewarray 275	java/lang/Class
    //   1602: invokevirtual 279	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   1605: iconst_0
    //   1606: anewarray 4	java/lang/Object
    //   1609: invokevirtual 285	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   1612: checkcast 247	tmsdk/common/roach/nest/ActionI
    //   1615: astore 7
    //   1617: iload_2
    //   1618: iconst_1
    //   1619: if_icmpne +78 -> 1697
    //   1622: new 287	android/os/Bundle
    //   1625: dup
    //   1626: ldc 2
    //   1628: invokevirtual 446	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   1631: invokespecial 473	android/os/Bundle:<init>	(Ljava/lang/ClassLoader;)V
    //   1634: astore 8
    //   1636: aload 8
    //   1638: ldc_w 290
    //   1641: aload_1
    //   1642: invokevirtual 293	btmsdkobf/br:aa	()Ljava/lang/String;
    //   1645: invokevirtual 297	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1648: aload 7
    //   1650: aload 8
    //   1652: invokevirtual 301	tmsdk/common/roach/nest/ActionI:onStart	(Landroid/os/Bundle;)V
    //   1655: aload_0
    //   1656: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   1659: aload 9
    //   1661: aload 6
    //   1663: invokevirtual 305	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1666: pop
    //   1667: aload_0
    //   1668: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   1671: aload 9
    //   1673: aload 7
    //   1675: invokevirtual 305	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1678: pop
    //   1679: aload 9
    //   1681: getfield 476	btmsdkobf/bt:gK	I
    //   1684: iconst_2
    //   1685: if_icmpne +22 -> 1707
    //   1688: aload_0
    //   1689: aload_1
    //   1690: iconst_1
    //   1691: invokespecial 195	btmsdkobf/bq:a	(Lbtmsdkobf/br;Z)V
    //   1694: goto +13 -> 1707
    //   1697: iload_2
    //   1698: iconst_2
    //   1699: if_icmpne +8 -> 1707
    //   1702: aload 7
    //   1704: invokevirtual 256	tmsdk/common/roach/nest/ActionI:clean	()V
    //   1707: aload 5
    //   1709: invokevirtual 477	java/util/zip/ZipFile:close	()V
    //   1712: iload_2
    //   1713: iconst_1
    //   1714: if_icmpne +42 -> 1756
    //   1717: new 62	java/lang/StringBuilder
    //   1720: dup
    //   1721: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1724: astore 5
    //   1726: aload 5
    //   1728: ldc_w 479
    //   1731: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1734: pop
    //   1735: aload 5
    //   1737: aload_1
    //   1738: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   1741: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: pop
    //   1745: ldc_w 265
    //   1748: aload 5
    //   1750: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1753: invokestatic 271	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   1756: return
    //   1757: astore_1
    //   1758: goto +127 -> 1885
    //   1761: goto +13 -> 1774
    //   1764: astore_1
    //   1765: aconst_null
    //   1766: astore 5
    //   1768: goto +117 -> 1885
    //   1771: aconst_null
    //   1772: astore 5
    //   1774: iload_2
    //   1775: iconst_1
    //   1776: if_icmpne +49 -> 1825
    //   1779: new 62	java/lang/StringBuilder
    //   1782: dup
    //   1783: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1786: astore 6
    //   1788: aload 6
    //   1790: ldc_w 261
    //   1793: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1796: pop
    //   1797: aload 6
    //   1799: aload_1
    //   1800: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   1803: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: pop
    //   1807: aload 6
    //   1809: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1812: astore 6
    //   1814: ldc_w 265
    //   1817: aload 6
    //   1819: invokestatic 271	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   1822: goto +46 -> 1868
    //   1825: iload_2
    //   1826: iconst_2
    //   1827: if_icmpne +41 -> 1868
    //   1830: new 62	java/lang/StringBuilder
    //   1833: dup
    //   1834: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1837: astore 6
    //   1839: aload 6
    //   1841: ldc_w 273
    //   1844: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1847: pop
    //   1848: aload 6
    //   1850: aload_1
    //   1851: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   1854: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1857: pop
    //   1858: aload 6
    //   1860: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1863: astore 6
    //   1865: goto -51 -> 1814
    //   1868: aload_0
    //   1869: aload_1
    //   1870: iconst_0
    //   1871: invokespecial 195	btmsdkobf/bq:a	(Lbtmsdkobf/br;Z)V
    //   1874: aload 5
    //   1876: ifnull +8 -> 1884
    //   1879: aload 5
    //   1881: invokevirtual 477	java/util/zip/ZipFile:close	()V
    //   1884: return
    //   1885: aload 5
    //   1887: ifnull +8 -> 1895
    //   1890: aload 5
    //   1892: invokevirtual 477	java/util/zip/ZipFile:close	()V
    //   1895: aload_1
    //   1896: athrow
    //   1897: astore 5
    //   1899: goto -1724 -> 175
    //   1902: astore 5
    //   1904: goto -1444 -> 460
    //   1907: astore 5
    //   1909: goto -138 -> 1771
    //   1912: astore 5
    //   1914: goto -1248 -> 666
    //   1917: astore 6
    //   1919: aload 5
    //   1921: astore 6
    //   1923: goto -1231 -> 692
    //   1926: astore 6
    //   1928: goto -167 -> 1761
    //   1931: astore 7
    //   1933: goto -880 -> 1053
    //   1936: astore 7
    //   1938: goto +27 -> 1965
    //   1941: astore 5
    //   1943: goto -231 -> 1712
    //   1946: astore_1
    //   1947: return
    //   1948: astore 5
    //   1950: goto -55 -> 1895
    //   1953: iload_2
    //   1954: iconst_2
    //   1955: if_icmpne -1935 -> 20
    //   1958: return
    //   1959: iload_2
    //   1960: iconst_2
    //   1961: if_icmpne -1700 -> 261
    //   1964: return
    //   1965: goto -1255 -> 710
    //   1968: astore_1
    //   1969: goto -84 -> 1885
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1972	0	this	bq
    //   0	1972	1	parambr	br
    //   0	1972	2	paramInt	int
    //   857	234	3	i	int
    //   606	3	4	bool	boolean
    //   18	1873	5	localObject1	Object
    //   1897	1	5	localThrowable1	Throwable
    //   1902	1	5	localThrowable2	Throwable
    //   1907	1	5	localThrowable3	Throwable
    //   1912	8	5	localThrowable4	Throwable
    //   1941	1	5	localThrowable5	Throwable
    //   1948	1	5	localThrowable6	Throwable
    //   40	1824	6	localObject2	Object
    //   1917	1	6	localThrowable7	Throwable
    //   1921	1	6	localThrowable8	Throwable
    //   1926	1	6	localThrowable9	Throwable
    //   67	1636	7	localObject3	Object
    //   1931	1	7	localIOException1	java.io.IOException
    //   1936	1	7	localIOException2	java.io.IOException
    //   776	875	8	localObject4	Object
    //   4	1676	9	localbt	bt
    //   575	935	10	str	String
    //   586	915	11	localFile	File
    //   708	13	12	localEnumeration	java.util.Enumeration
    //   730	304	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   613	658	659	finally
    //   681	687	659	finally
    //   703	710	1757	finally
    //   710	732	1757	finally
    //   737	759	1757	finally
    //   762	829	1757	finally
    //   832	858	1757	finally
    //   866	904	1757	finally
    //   904	976	1757	finally
    //   979	985	1757	finally
    //   985	1019	1757	finally
    //   1019	1027	1757	finally
    //   1031	1040	1757	finally
    //   1043	1048	1757	finally
    //   1048	1053	1757	finally
    //   1053	1058	1757	finally
    //   1061	1080	1757	finally
    //   1084	1096	1757	finally
    //   1096	1563	1757	finally
    //   1568	1617	1757	finally
    //   1622	1694	1757	finally
    //   1702	1707	1757	finally
    //   532	596	1764	finally
    //   597	608	1764	finally
    //   692	703	1764	finally
    //   69	112	1897	java/lang/Throwable
    //   120	133	1897	java/lang/Throwable
    //   144	174	1897	java/lang/Throwable
    //   296	341	1902	java/lang/Throwable
    //   349	393	1902	java/lang/Throwable
    //   398	438	1902	java/lang/Throwable
    //   444	459	1902	java/lang/Throwable
    //   532	596	1907	java/lang/Throwable
    //   597	608	1907	java/lang/Throwable
    //   692	703	1907	java/lang/Throwable
    //   613	658	1912	java/lang/Throwable
    //   681	687	1917	java/lang/Throwable
    //   703	710	1926	java/lang/Throwable
    //   710	732	1926	java/lang/Throwable
    //   737	759	1926	java/lang/Throwable
    //   762	829	1926	java/lang/Throwable
    //   832	858	1926	java/lang/Throwable
    //   866	904	1926	java/lang/Throwable
    //   904	976	1926	java/lang/Throwable
    //   979	985	1926	java/lang/Throwable
    //   985	1019	1926	java/lang/Throwable
    //   1019	1027	1926	java/lang/Throwable
    //   1031	1040	1926	java/lang/Throwable
    //   1043	1048	1926	java/lang/Throwable
    //   1048	1053	1926	java/lang/Throwable
    //   1053	1058	1926	java/lang/Throwable
    //   1061	1080	1926	java/lang/Throwable
    //   1084	1096	1926	java/lang/Throwable
    //   1096	1563	1926	java/lang/Throwable
    //   1568	1617	1926	java/lang/Throwable
    //   1622	1694	1926	java/lang/Throwable
    //   1702	1707	1926	java/lang/Throwable
    //   1048	1053	1931	java/io/IOException
    //   1053	1058	1936	java/io/IOException
    //   1707	1712	1941	java/lang/Throwable
    //   1879	1884	1946	java/lang/Throwable
    //   1890	1895	1948	java/lang/Throwable
    //   1779	1814	1968	finally
    //   1814	1822	1968	finally
    //   1830	1865	1968	finally
    //   1868	1874	1968	finally
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
          localStringBuilder = new StringBuilder();
          str = "1;;";
          localStringBuilder.append(str);
          localStringBuilder.append(parambr.Z());
          be.SaveStringData(1320043, localStringBuilder.toString());
          return;
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder;
          String str;
          continue;
        }
        localStringBuilder = new StringBuilder();
        str = "0;1019;";
      }
    }
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: new 307	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 313	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 390	java/io/File:length	()J
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
    //   38: new 398	java/io/BufferedInputStream
    //   41: dup
    //   42: new 487	java/io/FileInputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 488	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   50: invokespecial 405	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: astore_1
    //   54: sipush 8192
    //   57: newarray byte
    //   59: astore 12
    //   61: iconst_0
    //   62: istore 4
    //   64: aload_1
    //   65: aload 12
    //   67: invokevirtual 412	java/io/BufferedInputStream:read	([B)I
    //   70: istore 5
    //   72: iload 5
    //   74: iconst_m1
    //   75: if_icmpeq +25 -> 100
    //   78: aload 12
    //   80: iconst_0
    //   81: aload 11
    //   83: iload 4
    //   85: iload 5
    //   87: invokestatic 494	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   90: iload 4
    //   92: iload 5
    //   94: iadd
    //   95: istore 4
    //   97: goto -33 -> 64
    //   100: new 407	java/io/FileOutputStream
    //   103: dup
    //   104: aload_2
    //   105: invokespecial 495	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   108: astore_2
    //   109: iload_3
    //   110: ifeq +20 -> 130
    //   113: aload 11
    //   115: aconst_null
    //   116: invokestatic 499	tmsdk/common/tcc/b:encrypt	([B[B)[B
    //   119: astore 9
    //   121: aload_2
    //   122: aload 9
    //   124: invokevirtual 501	java/io/FileOutputStream:write	([B)V
    //   127: goto +14 -> 141
    //   130: aload 11
    //   132: aconst_null
    //   133: invokestatic 504	tmsdk/common/tcc/b:decrypt	([B[B)[B
    //   136: astore 9
    //   138: goto -17 -> 121
    //   141: aload_2
    //   142: invokevirtual 419	java/io/FileOutputStream:flush	()V
    //   145: iconst_1
    //   146: istore_3
    //   147: aload_1
    //   148: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   151: aload_2
    //   152: invokevirtual 423	java/io/FileOutputStream:close	()V
    //   155: iconst_1
    //   156: ireturn
    //   157: astore 10
    //   159: aload_1
    //   160: astore 9
    //   162: aload 10
    //   164: astore_1
    //   165: goto +33 -> 198
    //   168: goto +55 -> 223
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
    //   188: goto +35 -> 223
    //   191: astore_1
    //   192: aconst_null
    //   193: astore 9
    //   195: aload 10
    //   197: astore_2
    //   198: aload 9
    //   200: ifnull +8 -> 208
    //   203: aload 9
    //   205: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   208: aload_2
    //   209: ifnull +7 -> 216
    //   212: aload_2
    //   213: invokevirtual 423	java/io/FileOutputStream:close	()V
    //   216: aload_1
    //   217: athrow
    //   218: aconst_null
    //   219: astore_1
    //   220: aload 9
    //   222: astore_2
    //   223: aload_1
    //   224: ifnull +7 -> 231
    //   227: aload_1
    //   228: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   231: aload_2
    //   232: ifnull +10 -> 242
    //   235: iload 6
    //   237: istore_3
    //   238: aload_2
    //   239: invokevirtual 423	java/io/FileOutputStream:close	()V
    //   242: iconst_0
    //   243: ireturn
    //   244: astore_1
    //   245: goto -27 -> 218
    //   248: astore_2
    //   249: goto -64 -> 185
    //   252: astore 9
    //   254: goto -86 -> 168
    //   257: astore_1
    //   258: goto -107 -> 151
    //   261: astore_1
    //   262: iload_3
    //   263: ireturn
    //   264: astore 9
    //   266: goto -58 -> 208
    //   269: astore_2
    //   270: goto -54 -> 216
    //   273: astore_1
    //   274: goto -43 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	bq
    //   0	277	1	paramString1	String
    //   0	277	2	paramString2	String
    //   0	277	3	paramBoolean	boolean
    //   62	34	4	i	int
    //   70	25	5	j	int
    //   1	235	6	bool	boolean
    //   20	12	7	l	long
    //   4	217	9	localObject1	Object
    //   252	1	9	localThrowable1	Throwable
    //   264	1	9	localThrowable2	Throwable
    //   7	1	10	localObject2	Object
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
    //   9	22	244	java/lang/Throwable
    //   31	54	244	java/lang/Throwable
    //   54	61	248	java/lang/Throwable
    //   64	72	248	java/lang/Throwable
    //   78	90	248	java/lang/Throwable
    //   100	109	248	java/lang/Throwable
    //   113	121	252	java/lang/Throwable
    //   121	127	252	java/lang/Throwable
    //   130	138	252	java/lang/Throwable
    //   141	145	252	java/lang/Throwable
    //   147	151	257	java/lang/Throwable
    //   151	155	261	java/lang/Throwable
    //   238	242	261	java/lang/Throwable
    //   203	208	264	java/lang/Throwable
    //   212	216	269	java/lang/Throwable
    //   227	231	273	java/lang/Throwable
  }
  
  /* Error */
  private boolean b(br parambr)
  {
    // Byte code:
    //   0: getstatic 512	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 26
    //   5: if_icmple +5 -> 10
    //   8: iconst_1
    //   9: ireturn
    //   10: aload_1
    //   11: ifnull +1022 -> 1033
    //   14: aload_1
    //   15: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   18: ifnonnull +5 -> 23
    //   21: iconst_0
    //   22: ireturn
    //   23: new 62	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   30: astore_3
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 293	btmsdkobf/br:aa	()Ljava/lang/String;
    //   36: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: getstatic 311	java/io/File:separator	Ljava/lang/String;
    //   44: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: aload_1
    //   50: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   53: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 7
    //   63: new 307	java/io/File
    //   66: dup
    //   67: aload 7
    //   69: invokespecial 313	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore_3
    //   73: aload_3
    //   74: invokevirtual 316	java/io/File:exists	()Z
    //   77: ifne +44 -> 121
    //   80: new 62	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   87: astore_3
    //   88: ldc_w 514
    //   91: astore 4
    //   93: aload_3
    //   94: aload 4
    //   96: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_3
    //   101: aload_1
    //   102: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   105: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: ldc_w 322
    //   112: aload_3
    //   113: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 271	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   119: iconst_0
    //   120: ireturn
    //   121: aload_3
    //   122: invokevirtual 390	java/io/File:length	()J
    //   125: aload_1
    //   126: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   129: getfield 517	btmsdkobf/bt:gM	I
    //   132: i2l
    //   133: lcmp
    //   134: ifeq +19 -> 153
    //   137: new 62	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   144: astore_3
    //   145: ldc_w 519
    //   148: astore 4
    //   150: goto -57 -> 93
    //   153: new 307	java/io/File
    //   156: dup
    //   157: aload 7
    //   159: invokespecial 313	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: invokestatic 522	btmsdkobf/dz:a	(Ljava/io/File;)Ljava/lang/String;
    //   165: aload_1
    //   166: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   169: getfield 525	btmsdkobf/bt:gN	Ljava/lang/String;
    //   172: invokevirtual 528	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   175: ifeq +19 -> 194
    //   178: new 62	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   185: astore_3
    //   186: ldc_w 530
    //   189: astore 4
    //   191: goto -98 -> 93
    //   194: aconst_null
    //   195: astore 6
    //   197: aconst_null
    //   198: astore 5
    //   200: aload 5
    //   202: astore_3
    //   203: aload 6
    //   205: astore 4
    //   207: ldc_w 532
    //   210: invokevirtual 534	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   213: checkcast 532	android/content/res/AssetManager
    //   216: astore 8
    //   218: aload 5
    //   220: astore_3
    //   221: aload 6
    //   223: astore 4
    //   225: ldc_w 532
    //   228: ldc_w 536
    //   231: iconst_1
    //   232: anewarray 275	java/lang/Class
    //   235: dup
    //   236: iconst_0
    //   237: ldc 33
    //   239: aastore
    //   240: invokevirtual 539	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   243: astore 9
    //   245: aload 5
    //   247: astore_3
    //   248: aload 6
    //   250: astore 4
    //   252: aload 9
    //   254: iconst_1
    //   255: invokevirtual 464	java/lang/reflect/Method:setAccessible	(Z)V
    //   258: aload 5
    //   260: astore_3
    //   261: aload 6
    //   263: astore 4
    //   265: aload 9
    //   267: aload 8
    //   269: iconst_1
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload 7
    //   277: aastore
    //   278: invokevirtual 470	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   281: pop
    //   282: aload 5
    //   284: astore_3
    //   285: aload 6
    //   287: astore 4
    //   289: aload 8
    //   291: ldc_w 541
    //   294: iconst_1
    //   295: invokevirtual 545	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   298: astore 5
    //   300: aload 5
    //   302: astore_3
    //   303: aload 5
    //   305: astore 4
    //   307: invokestatic 551	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   310: astore 6
    //   312: aload 5
    //   314: astore_3
    //   315: aload 5
    //   317: astore 4
    //   319: aload 6
    //   321: aload 5
    //   323: ldc_w 553
    //   326: invokeinterface 559 3 0
    //   331: aload 5
    //   333: astore_3
    //   334: aload 5
    //   336: astore 4
    //   338: aload 6
    //   340: invokeinterface 562 1 0
    //   345: istore_2
    //   346: goto +716 -> 1062
    //   349: aload 5
    //   351: astore_3
    //   352: aload 5
    //   354: astore 4
    //   356: aload 6
    //   358: invokeinterface 563 1 0
    //   363: pop
    //   364: goto +527 -> 891
    //   367: aload 5
    //   369: astore_3
    //   370: aload 5
    //   372: astore 4
    //   374: aload 6
    //   376: invokeinterface 563 1 0
    //   381: astore 7
    //   383: aload 5
    //   385: astore_3
    //   386: aload 5
    //   388: astore 4
    //   390: aload 7
    //   392: ldc_w 565
    //   395: invokevirtual 568	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   398: ifne +112 -> 510
    //   401: aload 5
    //   403: astore_3
    //   404: aload 5
    //   406: astore 4
    //   408: aload 6
    //   410: invokeinterface 571 1 0
    //   415: invokestatic 576	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   418: invokevirtual 579	java/lang/Integer:intValue	()I
    //   421: aload_1
    //   422: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   425: getfield 241	btmsdkobf/bt:gH	I
    //   428: if_icmpeq +463 -> 891
    //   431: aload 5
    //   433: astore_3
    //   434: aload 5
    //   436: astore 4
    //   438: new 62	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   445: astore 6
    //   447: aload 5
    //   449: astore_3
    //   450: aload 5
    //   452: astore 4
    //   454: aload 6
    //   456: ldc_w 581
    //   459: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload 5
    //   465: astore_3
    //   466: aload 5
    //   468: astore 4
    //   470: aload 6
    //   472: aload_1
    //   473: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   476: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload 5
    //   482: astore_3
    //   483: aload 5
    //   485: astore 4
    //   487: ldc_w 322
    //   490: aload 6
    //   492: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 271	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   498: aload 5
    //   500: ifnull +8 -> 508
    //   503: aload 5
    //   505: invokevirtual 584	java/io/InputStream:close	()V
    //   508: iconst_0
    //   509: ireturn
    //   510: aload 5
    //   512: astore_3
    //   513: aload 5
    //   515: astore 4
    //   517: aload 7
    //   519: ldc_w 586
    //   522: invokevirtual 568	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   525: ifne +112 -> 637
    //   528: aload 5
    //   530: astore_3
    //   531: aload 5
    //   533: astore 4
    //   535: aload 6
    //   537: invokeinterface 571 1 0
    //   542: invokestatic 576	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   545: invokevirtual 579	java/lang/Integer:intValue	()I
    //   548: aload_1
    //   549: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   552: getfield 250	btmsdkobf/bt:gI	I
    //   555: if_icmpeq +336 -> 891
    //   558: aload 5
    //   560: astore_3
    //   561: aload 5
    //   563: astore 4
    //   565: new 62	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   572: astore 6
    //   574: aload 5
    //   576: astore_3
    //   577: aload 5
    //   579: astore 4
    //   581: aload 6
    //   583: ldc_w 588
    //   586: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload 5
    //   592: astore_3
    //   593: aload 5
    //   595: astore 4
    //   597: aload 6
    //   599: aload_1
    //   600: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   603: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload 5
    //   609: astore_3
    //   610: aload 5
    //   612: astore 4
    //   614: ldc_w 322
    //   617: aload 6
    //   619: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokestatic 271	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   625: aload 5
    //   627: ifnull +8 -> 635
    //   630: aload 5
    //   632: invokevirtual 584	java/io/InputStream:close	()V
    //   635: iconst_0
    //   636: ireturn
    //   637: aload 5
    //   639: astore_3
    //   640: aload 5
    //   642: astore 4
    //   644: aload 7
    //   646: ldc_w 590
    //   649: invokevirtual 568	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   652: ifne +112 -> 764
    //   655: aload 5
    //   657: astore_3
    //   658: aload 5
    //   660: astore 4
    //   662: aload 6
    //   664: invokeinterface 571 1 0
    //   669: invokestatic 576	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   672: invokevirtual 579	java/lang/Integer:intValue	()I
    //   675: aload_1
    //   676: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   679: getfield 593	btmsdkobf/bt:gJ	I
    //   682: if_icmpeq +209 -> 891
    //   685: aload 5
    //   687: astore_3
    //   688: aload 5
    //   690: astore 4
    //   692: new 62	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   699: astore 6
    //   701: aload 5
    //   703: astore_3
    //   704: aload 5
    //   706: astore 4
    //   708: aload 6
    //   710: ldc_w 595
    //   713: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: pop
    //   717: aload 5
    //   719: astore_3
    //   720: aload 5
    //   722: astore 4
    //   724: aload 6
    //   726: aload_1
    //   727: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   730: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: aload 5
    //   736: astore_3
    //   737: aload 5
    //   739: astore 4
    //   741: ldc_w 322
    //   744: aload 6
    //   746: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: invokestatic 271	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   752: aload 5
    //   754: ifnull +8 -> 762
    //   757: aload 5
    //   759: invokevirtual 584	java/io/InputStream:close	()V
    //   762: iconst_0
    //   763: ireturn
    //   764: aload 5
    //   766: astore_3
    //   767: aload 5
    //   769: astore 4
    //   771: aload 7
    //   773: ldc_w 597
    //   776: invokevirtual 568	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   779: ifne +112 -> 891
    //   782: aload 5
    //   784: astore_3
    //   785: aload 5
    //   787: astore 4
    //   789: aload 6
    //   791: invokeinterface 571 1 0
    //   796: invokestatic 576	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   799: invokevirtual 579	java/lang/Integer:intValue	()I
    //   802: aload_1
    //   803: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   806: getfield 476	btmsdkobf/bt:gK	I
    //   809: if_icmpeq +82 -> 891
    //   812: aload 5
    //   814: astore_3
    //   815: aload 5
    //   817: astore 4
    //   819: new 62	java/lang/StringBuilder
    //   822: dup
    //   823: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   826: astore 6
    //   828: aload 5
    //   830: astore_3
    //   831: aload 5
    //   833: astore 4
    //   835: aload 6
    //   837: ldc_w 599
    //   840: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: pop
    //   844: aload 5
    //   846: astore_3
    //   847: aload 5
    //   849: astore 4
    //   851: aload 6
    //   853: aload_1
    //   854: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   857: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: pop
    //   861: aload 5
    //   863: astore_3
    //   864: aload 5
    //   866: astore 4
    //   868: ldc_w 322
    //   871: aload 6
    //   873: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: invokestatic 271	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   879: aload 5
    //   881: ifnull +8 -> 889
    //   884: aload 5
    //   886: invokevirtual 584	java/io/InputStream:close	()V
    //   889: iconst_0
    //   890: ireturn
    //   891: aload 5
    //   893: astore_3
    //   894: aload 5
    //   896: astore 4
    //   898: aload 6
    //   900: invokeinterface 601 1 0
    //   905: istore_2
    //   906: goto +156 -> 1062
    //   909: aload 5
    //   911: ifnull +8 -> 919
    //   914: aload 5
    //   916: invokevirtual 584	java/io/InputStream:close	()V
    //   919: new 62	java/lang/StringBuilder
    //   922: dup
    //   923: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   926: astore_3
    //   927: aload_3
    //   928: ldc_w 479
    //   931: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: pop
    //   935: aload_3
    //   936: aload_1
    //   937: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   940: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: pop
    //   944: ldc_w 322
    //   947: aload_3
    //   948: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: invokestatic 271	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   954: iconst_1
    //   955: ireturn
    //   956: astore_1
    //   957: goto +66 -> 1023
    //   960: aload 4
    //   962: astore_3
    //   963: new 62	java/lang/StringBuilder
    //   966: dup
    //   967: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   970: astore 5
    //   972: aload 4
    //   974: astore_3
    //   975: aload 5
    //   977: ldc_w 603
    //   980: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: pop
    //   984: aload 4
    //   986: astore_3
    //   987: aload 5
    //   989: aload_1
    //   990: invokevirtual 264	btmsdkobf/br:Z	()Ljava/lang/String;
    //   993: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: aload 4
    //   999: astore_3
    //   1000: ldc_w 322
    //   1003: aload 5
    //   1005: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokestatic 271	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   1011: aload 4
    //   1013: ifnull +8 -> 1021
    //   1016: aload 4
    //   1018: invokevirtual 584	java/io/InputStream:close	()V
    //   1021: iconst_0
    //   1022: ireturn
    //   1023: aload_3
    //   1024: ifnull +7 -> 1031
    //   1027: aload_3
    //   1028: invokevirtual 584	java/io/InputStream:close	()V
    //   1031: aload_1
    //   1032: athrow
    //   1033: iconst_0
    //   1034: ireturn
    //   1035: astore_3
    //   1036: goto -76 -> 960
    //   1039: astore_1
    //   1040: iconst_0
    //   1041: ireturn
    //   1042: astore_1
    //   1043: iconst_0
    //   1044: ireturn
    //   1045: astore_1
    //   1046: iconst_0
    //   1047: ireturn
    //   1048: astore_1
    //   1049: iconst_0
    //   1050: ireturn
    //   1051: astore_3
    //   1052: goto -133 -> 919
    //   1055: astore_1
    //   1056: iconst_0
    //   1057: ireturn
    //   1058: astore_3
    //   1059: goto -28 -> 1031
    //   1062: iload_2
    //   1063: iconst_1
    //   1064: if_icmpeq -155 -> 909
    //   1067: iload_2
    //   1068: ifeq -177 -> 891
    //   1071: iload_2
    //   1072: tableswitch	default:+24 -> 1096, 2:+-705->367, 3:+-723->349
    //   1097: impdep2
    //   1098: baload
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1099	0	this	bq
    //   0	1099	1	parambr	br
    //   345	727	2	i	int
    //   30	998	3	localObject1	Object
    //   1035	1	3	localThrowable	Throwable
    //   1051	1	3	localIOException1	java.io.IOException
    //   1058	1	3	localIOException2	java.io.IOException
    //   91	926	4	localObject2	Object
    //   198	806	5	localObject3	Object
    //   195	704	6	localObject4	Object
    //   61	711	7	str	String
    //   216	74	8	localAssetManager	android.content.res.AssetManager
    //   243	23	9	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   207	218	956	finally
    //   225	245	956	finally
    //   252	258	956	finally
    //   265	282	956	finally
    //   289	300	956	finally
    //   307	312	956	finally
    //   319	331	956	finally
    //   338	346	956	finally
    //   356	364	956	finally
    //   374	383	956	finally
    //   390	401	956	finally
    //   408	431	956	finally
    //   438	447	956	finally
    //   454	463	956	finally
    //   470	480	956	finally
    //   487	498	956	finally
    //   517	528	956	finally
    //   535	558	956	finally
    //   565	574	956	finally
    //   581	590	956	finally
    //   597	607	956	finally
    //   614	625	956	finally
    //   644	655	956	finally
    //   662	685	956	finally
    //   692	701	956	finally
    //   708	717	956	finally
    //   724	734	956	finally
    //   741	752	956	finally
    //   771	782	956	finally
    //   789	812	956	finally
    //   819	828	956	finally
    //   835	844	956	finally
    //   851	861	956	finally
    //   868	879	956	finally
    //   898	906	956	finally
    //   963	972	956	finally
    //   975	984	956	finally
    //   987	997	956	finally
    //   1000	1011	956	finally
    //   207	218	1035	java/lang/Throwable
    //   225	245	1035	java/lang/Throwable
    //   252	258	1035	java/lang/Throwable
    //   265	282	1035	java/lang/Throwable
    //   289	300	1035	java/lang/Throwable
    //   307	312	1035	java/lang/Throwable
    //   319	331	1035	java/lang/Throwable
    //   338	346	1035	java/lang/Throwable
    //   356	364	1035	java/lang/Throwable
    //   374	383	1035	java/lang/Throwable
    //   390	401	1035	java/lang/Throwable
    //   408	431	1035	java/lang/Throwable
    //   438	447	1035	java/lang/Throwable
    //   454	463	1035	java/lang/Throwable
    //   470	480	1035	java/lang/Throwable
    //   487	498	1035	java/lang/Throwable
    //   517	528	1035	java/lang/Throwable
    //   535	558	1035	java/lang/Throwable
    //   565	574	1035	java/lang/Throwable
    //   581	590	1035	java/lang/Throwable
    //   597	607	1035	java/lang/Throwable
    //   614	625	1035	java/lang/Throwable
    //   644	655	1035	java/lang/Throwable
    //   662	685	1035	java/lang/Throwable
    //   692	701	1035	java/lang/Throwable
    //   708	717	1035	java/lang/Throwable
    //   724	734	1035	java/lang/Throwable
    //   741	752	1035	java/lang/Throwable
    //   771	782	1035	java/lang/Throwable
    //   789	812	1035	java/lang/Throwable
    //   819	828	1035	java/lang/Throwable
    //   835	844	1035	java/lang/Throwable
    //   851	861	1035	java/lang/Throwable
    //   868	879	1035	java/lang/Throwable
    //   898	906	1035	java/lang/Throwable
    //   503	508	1039	java/io/IOException
    //   630	635	1042	java/io/IOException
    //   757	762	1045	java/io/IOException
    //   884	889	1048	java/io/IOException
    //   914	919	1051	java/io/IOException
    //   1016	1021	1055	java/io/IOException
    //   1027	1031	1058	java/io/IOException
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("1;;");
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
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("0;1015;");
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0;1004;");
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
      label374:
      break label374;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("0;1004;");
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
  
  public void a(Boolean paramBoolean)
  {
    ec.cS().putBoolean("r_e", paramBoolean.booleanValue());
  }
  
  public void a(ActionI paramActionI)
  {
    try
    {
      U();
      Message.obtain(this.gu, 261, paramActionI).sendToTarget();
      this.gu.sendEmptyMessage(262);
      return;
    }
    finally
    {
      paramActionI = finally;
      throw paramActionI;
    }
  }
  
  public void onRecvPush(ConchService.ConchPushInfo paramConchPushInfo)
  {
    label739:
    for (;;)
    {
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onRecvPush-[");
        ((StringBuilder)localObject1).append(paramConchPushInfo);
        ((StringBuilder)localObject1).append("]");
        bo.k(((StringBuilder)localObject1).toString());
        localObject1 = new br();
        ((br)localObject1).gz = new bt();
        int i;
        try
        {
          if (R() == paramConchPushInfo.mConch.cmdId)
          {
            localObject2 = paramConchPushInfo.mConch.aZ;
            ad localad = new ad();
            i = 0;
            localObject2 = (ad)cp.a((byte[])localObject2, localad, false);
            long l = paramConchPushInfo.mConch.bb.validEndTime * 1000L;
            if (l < System.currentTimeMillis())
            {
              bo.l("config item expired");
              return;
            }
            Calendar.getInstance().setTimeInMillis(l);
            ((br)localObject1).gA = ConvertUtil.stringToInt((String)((ad)localObject2).bm.get(0));
            ((br)localObject1).gz.gH = ConvertUtil.stringToInt((String)((ad)localObject2).bm.get(1));
            ((br)localObject1).gz.gI = ConvertUtil.stringToInt((String)((ad)localObject2).bm.get(2));
            ((br)localObject1).gz.gJ = ConvertUtil.stringToInt((String)((ad)localObject2).bm.get(3));
            ((br)localObject1).gz.gK = ConvertUtil.stringToInt((String)((ad)localObject2).bm.get(4));
            ((br)localObject1).gz.gM = ConvertUtil.stringToInt((String)((ad)localObject2).bm.get(5));
            ((br)localObject1).gz.gN = ((String)((ad)localObject2).bm.get(6));
            ((br)localObject1).gz.gO = ((String)((ad)localObject2).bm.get(7));
            ((br)localObject1).gz.gL = l;
            ((br)localObject1).gB = 1;
            if ((((br)localObject1).gA != 1) && (((br)localObject1).gA != 2))
            {
              paramConchPushInfo = new StringBuilder();
              paramConchPushInfo.append("config item op error:[");
              paramConchPushInfo.append(((br)localObject1).gA);
              paramConchPushInfo.append("]");
              bo.l(paramConchPushInfo.toString());
              paramConchPushInfo = new StringBuilder();
              paramConchPushInfo.append("0;1000;");
              paramConchPushInfo.append(((br)localObject1).Z());
              be.SaveStringData(1320035, paramConchPushInfo.toString());
              return;
            }
            paramConchPushInfo = new StringBuilder();
            paramConchPushInfo.append("push config item:[");
            paramConchPushInfo.append(localObject1);
            paramConchPushInfo.append("]");
            bo.k(paramConchPushInfo.toString());
            if (i < gp.length) {
              if (((br)localObject1).gz.gJ != gp[i]) {
                break label739;
              }
            }
            if (i >= gp.length)
            {
              paramConchPushInfo = new StringBuilder();
              paramConchPushInfo.append("current nest not support, roach nest id:[");
              paramConchPushInfo.append(((br)localObject1).gz.gJ);
              paramConchPushInfo.append("]");
              bo.l(paramConchPushInfo.toString());
              paramConchPushInfo = new StringBuilder();
              paramConchPushInfo.append("0;1001;");
              paramConchPushInfo.append(((br)localObject1).Z());
              be.SaveStringData(1320035, paramConchPushInfo.toString());
              return;
            }
            paramConchPushInfo = new StringBuilder();
            paramConchPushInfo.append("1;;");
            paramConchPushInfo.append(((br)localObject1).Z());
            be.SaveStringData(1320035, paramConchPushInfo.toString());
            Q().a(Boolean.valueOf(true));
            a((br)localObject1);
          }
          else
          {
            return;
          }
        }
        catch (Throwable paramConchPushInfo)
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("0;1003;");
          ((StringBuilder)localObject2).append(((br)localObject1).Z());
          be.SaveStringData(1320035, ((StringBuilder)localObject2).toString());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("e:[");
          ((StringBuilder)localObject1).append(paramConchPushInfo);
          ((StringBuilder)localObject1).append("]");
          bo.l(((StringBuilder)localObject1).toString());
          return;
        }
        i += 1;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bq
 * JD-Core Version:    0.7.0.1
 */