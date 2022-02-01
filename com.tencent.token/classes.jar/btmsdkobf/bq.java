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
    bo.k("RoachManager-RoachManager-NEST_IDS:[" + Arrays.toString(gp) + "]");
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
    //   9: ifnonnull +30 -> 39
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
    //   39: ldc 2
    //   41: monitorexit
    //   42: getstatic 41	btmsdkobf/bq:gx	Lbtmsdkobf/bq;
    //   45: astore_0
    //   46: ldc 2
    //   48: monitorexit
    //   49: aload_0
    //   50: areturn
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    //   57: astore_0
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    //   63: astore_0
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   45	5	0	localbq	bq
    //   51	5	0	localObject1	Object
    //   57	5	0	localObject2	Object
    //   63	5	0	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	36	51	finally
    //   36	39	51	finally
    //   52	55	51	finally
    //   6	15	57	finally
    //   39	42	57	finally
    //   55	57	57	finally
    //   58	61	57	finally
    //   3	6	63	finally
    //   42	46	63	finally
    //   61	63	63	finally
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
          if (paramAnonymousMessage.what == 259)
          {
            paramAnonymousMessage = (br)paramAnonymousMessage.obj;
            if ((paramAnonymousMessage != null) && (paramAnonymousMessage.gz != null)) {}
          }
          label193:
          label216:
          label247:
          do
          {
            for (;;)
            {
              return;
              Object localObject = bq.a(bq.this).i(paramAnonymousMessage.gz.gH);
              if (localObject != null) {
                if (paramAnonymousMessage.gz.gI >= ((br)localObject).gz.gI)
                {
                  if (paramAnonymousMessage.gA != 1) {
                    break label247;
                  }
                  if (((br)localObject).gB != 3) {
                    break label216;
                  }
                  if (paramAnonymousMessage.gz.gI != ((br)localObject).gz.gI) {
                    break label193;
                  }
                  bq.a(bq.this, (br)localObject, 1);
                }
              }
              for (;;)
              {
                bq.this.gu.removeMessages(260);
                bq.this.gu.sendEmptyMessage(260);
                bq.this.gu.removeMessages(258);
                bq.this.gu.sendEmptyMessage(258);
                bq.this.gu.removeMessages(262);
                bq.this.gu.sendEmptyMessage(262);
                return;
                bq.a(bq.this, (br)localObject, true);
                bq.a(bq.this).e(paramAnonymousMessage);
                continue;
                if (paramAnonymousMessage.gz.gI > ((br)localObject).gz.gI)
                {
                  bq.a(bq.this).d(paramAnonymousMessage);
                  continue;
                  if (paramAnonymousMessage.gA == 2)
                  {
                    bq.a(bq.this, (br)localObject, true);
                    continue;
                    if (paramAnonymousMessage.gA == 1) {
                      bq.a(bq.this).e(paramAnonymousMessage);
                    } else if (paramAnonymousMessage.gA == 2) {
                      bq.a(bq.this, paramAnonymousMessage, true);
                    }
                  }
                }
              }
              if (paramAnonymousMessage.what == 257)
              {
                paramAnonymousMessage = bq.a(bq.this).ag();
                if ((paramAnonymousMessage != null) && (paramAnonymousMessage.size() > 0))
                {
                  paramAnonymousMessage = paramAnonymousMessage.iterator();
                  while (paramAnonymousMessage.hasNext())
                  {
                    localObject = (br)paramAnonymousMessage.next();
                    if ((((br)localObject).gB == 3) && (((br)localObject).gA == 1) && (((br)localObject).gz != null) && (((br)localObject).gz.gL >= System.currentTimeMillis()) && (new File(((br)localObject).aa() + File.separator + ((br)localObject).Z()).exists())) {
                      bq.a(bq.this, (br)localObject, 1);
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
                    localObject = (br)paramAnonymousMessage.next();
                    bq.a(bq.this, (br)localObject);
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
                    localObject = (br)paramAnonymousMessage.next();
                    bq.a(bq.this, (br)localObject, true);
                  }
                }
              }
              else if (paramAnonymousMessage.what == 261)
              {
                paramAnonymousMessage = (ActionI)paramAnonymousMessage.obj;
                if (paramAnonymousMessage == null) {
                  continue;
                }
                try
                {
                  localObject = bq.this.gs.keySet().iterator();
                  bt localbt;
                  do
                  {
                    if (!((Iterator)localObject).hasNext()) {
                      break;
                    }
                    localbt = (bt)((Iterator)localObject).next();
                  } while ((ActionI)bq.this.gs.get(localbt) != paramAnonymousMessage);
                  bq.this.gs.remove(localbt);
                  return;
                }
                catch (Throwable paramAnonymousMessage)
                {
                  return;
                }
              }
            }
          } while (paramAnonymousMessage.what != 262);
          bq.d(bq.this);
        }
      };
    }
  }
  
  private void V()
  {
    if (this.gt != null) {
      if ((this.gu.hasMessages(257)) || (this.gu.hasMessages(258)) || (this.gu.hasMessages(259)) || (this.gu.hasMessages(260)) || (this.gu.hasMessages(261)))
      {
        this.gu.removeMessages(262);
        this.gu.sendEmptyMessage(262);
      }
    }
    while (this.gw == null)
    {
      return;
      if (this.gw.getCount() <= 0) {
        Q().a(Boolean.valueOf(false));
      }
      this.gt.quit();
      this.gt = null;
      this.gu = null;
    }
    this.gw.ad();
    this.gw = null;
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
    if ((parambr == null) || (parambr.gz == null)) {
      return;
    }
    U();
    Message.obtain(this.gu, 259, parambr).sendToTarget();
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
    //   18: astore 6
    //   20: aload 6
    //   22: invokeinterface 231 1 0
    //   27: ifeq +90 -> 117
    //   30: aload 6
    //   32: invokeinterface 235 1 0
    //   37: checkcast 237	btmsdkobf/bt
    //   40: astore 7
    //   42: aload 7
    //   44: getfield 241	btmsdkobf/bt:gH	I
    //   47: aload 9
    //   49: getfield 241	btmsdkobf/bt:gH	I
    //   52: if_icmpne -32 -> 20
    //   55: aload_0
    //   56: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   59: aload 7
    //   61: invokevirtual 245	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: checkcast 247	tmsdk/common/roach/nest/ActionI
    //   67: astore 5
    //   69: aload 9
    //   71: getfield 250	btmsdkobf/bt:gI	I
    //   74: aload 7
    //   76: getfield 250	btmsdkobf/bt:gI	I
    //   79: if_icmple +211 -> 290
    //   82: aload 5
    //   84: invokevirtual 253	tmsdk/common/roach/nest/ActionI:onStop	()V
    //   87: aload 5
    //   89: invokevirtual 256	tmsdk/common/roach/nest/ActionI:clean	()V
    //   92: aload_0
    //   93: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   96: aload 7
    //   98: invokevirtual 259	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   101: pop
    //   102: aload_0
    //   103: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   106: aload 7
    //   108: invokevirtual 259	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   111: pop
    //   112: iload_2
    //   113: iconst_1
    //   114: if_icmpne +170 -> 284
    //   117: aload_0
    //   118: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   121: invokevirtual 220	java/util/HashMap:keySet	()Ljava/util/Set;
    //   124: invokeinterface 226 1 0
    //   129: astore 6
    //   131: aload 6
    //   133: invokeinterface 231 1 0
    //   138: ifeq +78 -> 216
    //   141: aload 6
    //   143: invokeinterface 235 1 0
    //   148: checkcast 237	btmsdkobf/bt
    //   151: astore 5
    //   153: aload 5
    //   155: getfield 241	btmsdkobf/bt:gH	I
    //   158: aload 9
    //   160: getfield 241	btmsdkobf/bt:gH	I
    //   163: if_icmpne -32 -> 131
    //   166: aload 9
    //   168: getfield 250	btmsdkobf/bt:gI	I
    //   171: aload 5
    //   173: getfield 250	btmsdkobf/bt:gI	I
    //   176: if_icmple +246 -> 422
    //   179: aload_0
    //   180: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   183: aload 5
    //   185: invokevirtual 245	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   188: checkcast 261	java/lang/Class
    //   191: iconst_0
    //   192: anewarray 261	java/lang/Class
    //   195: invokevirtual 265	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   198: iconst_0
    //   199: anewarray 4	java/lang/Object
    //   202: invokevirtual 271	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   205: checkcast 247	tmsdk/common/roach/nest/ActionI
    //   208: invokevirtual 256	tmsdk/common/roach/nest/ActionI:clean	()V
    //   211: iload_2
    //   212: iconst_1
    //   213: if_icmpne +203 -> 416
    //   216: new 62	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   223: aload_1
    //   224: invokevirtual 274	btmsdkobf/br:aa	()Ljava/lang/String;
    //   227: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: getstatic 280	java/io/File:separator	Ljava/lang/String;
    //   233: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_1
    //   237: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   240: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: astore 10
    //   248: new 276	java/io/File
    //   251: dup
    //   252: aload 10
    //   254: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   257: astore 11
    //   259: aload 11
    //   261: invokevirtual 288	java/io/File:exists	()Z
    //   264: istore 4
    //   266: iload 4
    //   268: ifne +337 -> 605
    //   271: iconst_0
    //   272: ifeq +11 -> 283
    //   275: new 290	java/lang/NullPointerException
    //   278: dup
    //   279: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   282: athrow
    //   283: return
    //   284: iload_2
    //   285: iconst_2
    //   286: if_icmpne -266 -> 20
    //   289: return
    //   290: aload 9
    //   292: getfield 250	btmsdkobf/bt:gI	I
    //   295: aload 7
    //   297: getfield 250	btmsdkobf/bt:gI	I
    //   300: if_icmpne -17 -> 283
    //   303: iload_2
    //   304: iconst_1
    //   305: if_icmpeq -22 -> 283
    //   308: iload_2
    //   309: iconst_2
    //   310: if_icmpne -290 -> 20
    //   313: aload 5
    //   315: invokevirtual 253	tmsdk/common/roach/nest/ActionI:onStop	()V
    //   318: aload 5
    //   320: invokevirtual 256	tmsdk/common/roach/nest/ActionI:clean	()V
    //   323: aload_0
    //   324: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   327: aload 7
    //   329: invokevirtual 259	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   332: pop
    //   333: aload_0
    //   334: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   337: aload 7
    //   339: invokevirtual 259	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   342: pop
    //   343: return
    //   344: astore 5
    //   346: iload_2
    //   347: iconst_1
    //   348: if_icmpne +33 -> 381
    //   351: ldc_w 292
    //   354: new 62	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   361: ldc_w 294
    //   364: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_1
    //   368: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   371: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   380: return
    //   381: iload_2
    //   382: iconst_2
    //   383: if_icmpne -100 -> 283
    //   386: ldc_w 292
    //   389: new 62	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   396: ldc_w 302
    //   399: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_1
    //   403: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   406: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   415: return
    //   416: iload_2
    //   417: iconst_2
    //   418: if_icmpne -287 -> 131
    //   421: return
    //   422: aload 5
    //   424: getfield 250	btmsdkobf/bt:gI	I
    //   427: aload 9
    //   429: getfield 250	btmsdkobf/bt:gI	I
    //   432: if_icmpne -149 -> 283
    //   435: aload_0
    //   436: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   439: aload 5
    //   441: invokevirtual 245	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   444: checkcast 261	java/lang/Class
    //   447: iconst_0
    //   448: anewarray 261	java/lang/Class
    //   451: invokevirtual 265	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   454: iconst_0
    //   455: anewarray 4	java/lang/Object
    //   458: invokevirtual 271	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   461: checkcast 247	tmsdk/common/roach/nest/ActionI
    //   464: astore 6
    //   466: iload_2
    //   467: iconst_1
    //   468: if_icmpne +81 -> 549
    //   471: new 304	android/os/Bundle
    //   474: dup
    //   475: invokespecial 305	android/os/Bundle:<init>	()V
    //   478: astore 7
    //   480: aload 7
    //   482: ldc_w 307
    //   485: aload_1
    //   486: invokevirtual 274	btmsdkobf/br:aa	()Ljava/lang/String;
    //   489: invokevirtual 311	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: aload 6
    //   494: aload 7
    //   496: invokevirtual 315	tmsdk/common/roach/nest/ActionI:onStart	(Landroid/os/Bundle;)V
    //   499: aload_0
    //   500: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   503: aload 5
    //   505: aload 6
    //   507: invokevirtual 319	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   510: pop
    //   511: return
    //   512: astore 5
    //   514: iload_2
    //   515: iconst_1
    //   516: if_icmpne +54 -> 570
    //   519: ldc_w 292
    //   522: new 62	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   529: ldc_w 294
    //   532: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload_1
    //   536: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   539: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   548: return
    //   549: iload_2
    //   550: iconst_2
    //   551: if_icmpne -268 -> 283
    //   554: aload 6
    //   556: invokevirtual 256	tmsdk/common/roach/nest/ActionI:clean	()V
    //   559: aload_0
    //   560: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   563: aload 5
    //   565: invokevirtual 259	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   568: pop
    //   569: return
    //   570: iload_2
    //   571: iconst_2
    //   572: if_icmpne -289 -> 283
    //   575: ldc_w 292
    //   578: new 62	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   585: ldc_w 302
    //   588: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: aload_1
    //   592: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   595: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   604: return
    //   605: aload_0
    //   606: aload 10
    //   608: aload 10
    //   610: iconst_0
    //   611: invokespecial 322	btmsdkobf/bq:a	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   614: ifne +52 -> 666
    //   617: ldc_w 323
    //   620: new 62	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   627: ldc_w 325
    //   630: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: aload_1
    //   634: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   637: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   646: aload_0
    //   647: aload_1
    //   648: iconst_0
    //   649: invokespecial 195	btmsdkobf/bq:a	(Lbtmsdkobf/br;Z)V
    //   652: iconst_0
    //   653: ifeq -370 -> 283
    //   656: new 290	java/lang/NullPointerException
    //   659: dup
    //   660: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   663: athrow
    //   664: astore_1
    //   665: return
    //   666: ldc_w 327
    //   669: astore 5
    //   671: invokestatic 332	tmsdk/common/tcc/b:cP	()Z
    //   674: ifeq +8 -> 682
    //   677: ldc_w 334
    //   680: astore 5
    //   682: aload 5
    //   684: astore 6
    //   686: new 336	java/util/zip/ZipFile
    //   689: dup
    //   690: aload 11
    //   692: invokespecial 339	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   695: astore 5
    //   697: aload 5
    //   699: invokevirtual 343	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   702: astore 12
    //   704: aload 12
    //   706: invokeinterface 348 1 0
    //   711: ifeq +369 -> 1080
    //   714: aload 12
    //   716: invokeinterface 351 1 0
    //   721: checkcast 353	java/util/zip/ZipEntry
    //   724: astore 13
    //   726: aload 13
    //   728: ifnull -24 -> 704
    //   731: aload 13
    //   733: invokevirtual 356	java/util/zip/ZipEntry:isDirectory	()Z
    //   736: ifne -32 -> 704
    //   739: aload 13
    //   741: invokevirtual 359	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   744: ldc_w 361
    //   747: invokevirtual 365	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   750: ifne -46 -> 704
    //   753: aload 13
    //   755: invokevirtual 359	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   758: astore 7
    //   760: new 62	java/lang/StringBuilder
    //   763: dup
    //   764: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   767: ldc_w 367
    //   770: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: aload 7
    //   775: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: ldc 77
    //   780: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   786: invokestatic 86	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   789: aload 7
    //   791: invokestatic 372	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   794: ifne -90 -> 704
    //   797: aload 7
    //   799: aload 6
    //   801: invokevirtual 365	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   804: ifeq -100 -> 704
    //   807: aload 7
    //   809: aload 7
    //   811: ldc_w 374
    //   814: invokevirtual 378	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   817: iconst_1
    //   818: iadd
    //   819: invokevirtual 382	java/lang/String:substring	(I)Ljava/lang/String;
    //   822: astore 8
    //   824: aload 8
    //   826: ldc_w 384
    //   829: invokevirtual 378	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   832: istore_3
    //   833: aload 8
    //   835: astore 7
    //   837: iload_3
    //   838: ifle +31 -> 869
    //   841: new 62	java/lang/StringBuilder
    //   844: dup
    //   845: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   848: aload 8
    //   850: iconst_0
    //   851: iload_3
    //   852: invokevirtual 387	java/lang/String:substring	(II)Ljava/lang/String;
    //   855: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: ldc_w 389
    //   861: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: astore 7
    //   869: new 276	java/io/File
    //   872: dup
    //   873: new 62	java/lang/StringBuilder
    //   876: dup
    //   877: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   880: aload_1
    //   881: invokevirtual 274	btmsdkobf/br:aa	()Ljava/lang/String;
    //   884: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: getstatic 280	java/io/File:separator	Ljava/lang/String;
    //   890: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: aload 7
    //   895: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   901: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   904: astore 8
    //   906: aload 8
    //   908: invokevirtual 288	java/io/File:exists	()Z
    //   911: ifeq +23 -> 934
    //   914: aload 8
    //   916: invokevirtual 393	java/io/File:length	()J
    //   919: aload 13
    //   921: invokevirtual 396	java/util/zip/ZipEntry:getSize	()J
    //   924: lcmp
    //   925: ifeq -221 -> 704
    //   928: aload 8
    //   930: invokevirtual 399	java/io/File:delete	()Z
    //   933: pop
    //   934: new 401	java/io/BufferedInputStream
    //   937: dup
    //   938: aload 5
    //   940: aload 13
    //   942: invokevirtual 405	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   945: invokespecial 408	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   948: astore 7
    //   950: new 410	java/io/FileOutputStream
    //   953: dup
    //   954: aload 8
    //   956: invokespecial 411	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   959: astore 8
    //   961: sipush 8192
    //   964: newarray byte
    //   966: astore 13
    //   968: aload 7
    //   970: aload 13
    //   972: invokevirtual 415	java/io/BufferedInputStream:read	([B)I
    //   975: istore_3
    //   976: iload_3
    //   977: ifle +80 -> 1057
    //   980: aload 8
    //   982: aload 13
    //   984: iconst_0
    //   985: iload_3
    //   986: invokevirtual 419	java/io/FileOutputStream:write	([BII)V
    //   989: goto -21 -> 968
    //   992: astore 6
    //   994: iload_2
    //   995: iconst_1
    //   996: if_icmpne +809 -> 1805
    //   999: ldc_w 292
    //   1002: new 62	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1009: ldc_w 294
    //   1012: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: aload_1
    //   1016: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   1019: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1025: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   1028: aload_0
    //   1029: aload_1
    //   1030: iconst_0
    //   1031: invokespecial 195	btmsdkobf/bq:a	(Lbtmsdkobf/br;Z)V
    //   1034: aload 5
    //   1036: ifnull -753 -> 283
    //   1039: aload 5
    //   1041: invokevirtual 422	java/util/zip/ZipFile:close	()V
    //   1044: return
    //   1045: astore_1
    //   1046: return
    //   1047: astore 5
    //   1049: ldc_w 327
    //   1052: astore 6
    //   1054: goto -368 -> 686
    //   1057: aload 8
    //   1059: invokevirtual 425	java/io/FileOutputStream:flush	()V
    //   1062: aload 7
    //   1064: invokevirtual 426	java/io/BufferedInputStream:close	()V
    //   1067: aload 8
    //   1069: invokevirtual 427	java/io/FileOutputStream:close	()V
    //   1072: goto -368 -> 704
    //   1075: astore 7
    //   1077: goto -373 -> 704
    //   1080: aload 11
    //   1082: invokevirtual 430	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1085: astore 6
    //   1087: aload 11
    //   1089: invokevirtual 430	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1092: ldc_w 384
    //   1095: invokevirtual 378	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1098: istore_3
    //   1099: iload_3
    //   1100: ifle +15 -> 1115
    //   1103: aload 11
    //   1105: invokevirtual 430	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1108: iconst_0
    //   1109: iload_3
    //   1110: invokevirtual 387	java/lang/String:substring	(II)Ljava/lang/String;
    //   1113: astore 6
    //   1115: new 276	java/io/File
    //   1118: dup
    //   1119: new 62	java/lang/StringBuilder
    //   1122: dup
    //   1123: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1126: aload 6
    //   1128: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: new 33	java/lang/String
    //   1134: dup
    //   1135: iconst_4
    //   1136: newarray byte
    //   1138: dup
    //   1139: iconst_0
    //   1140: ldc_w 431
    //   1143: bastore
    //   1144: dup
    //   1145: iconst_1
    //   1146: ldc_w 432
    //   1149: bastore
    //   1150: dup
    //   1151: iconst_2
    //   1152: ldc_w 433
    //   1155: bastore
    //   1156: dup
    //   1157: iconst_3
    //   1158: ldc_w 434
    //   1161: bastore
    //   1162: invokespecial 437	java/lang/String:<init>	([B)V
    //   1165: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1171: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   1174: astore 7
    //   1176: aload 11
    //   1178: aload 7
    //   1180: invokevirtual 441	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1183: pop
    //   1184: new 33	java/lang/String
    //   1187: dup
    //   1188: bipush 28
    //   1190: newarray byte
    //   1192: dup
    //   1193: iconst_0
    //   1194: ldc_w 442
    //   1197: bastore
    //   1198: dup
    //   1199: iconst_1
    //   1200: ldc_w 432
    //   1203: bastore
    //   1204: dup
    //   1205: iconst_2
    //   1206: ldc_w 443
    //   1209: bastore
    //   1210: dup
    //   1211: iconst_3
    //   1212: ldc_w 444
    //   1215: bastore
    //   1216: dup
    //   1217: iconst_4
    //   1218: ldc_w 445
    //   1221: bastore
    //   1222: dup
    //   1223: iconst_5
    //   1224: ldc_w 434
    //   1227: bastore
    //   1228: dup
    //   1229: bipush 6
    //   1231: ldc_w 431
    //   1234: bastore
    //   1235: dup
    //   1236: bipush 7
    //   1238: ldc_w 446
    //   1241: bastore
    //   1242: dup
    //   1243: bipush 8
    //   1245: ldc_w 447
    //   1248: bastore
    //   1249: dup
    //   1250: bipush 9
    //   1252: ldc_w 446
    //   1255: bastore
    //   1256: dup
    //   1257: bipush 10
    //   1259: ldc_w 448
    //   1262: bastore
    //   1263: dup
    //   1264: bipush 11
    //   1266: ldc_w 449
    //   1269: bastore
    //   1270: dup
    //   1271: bipush 12
    //   1273: ldc_w 450
    //   1276: bastore
    //   1277: dup
    //   1278: bipush 13
    //   1280: ldc_w 431
    //   1283: bastore
    //   1284: dup
    //   1285: bipush 14
    //   1287: ldc_w 451
    //   1290: bastore
    //   1291: dup
    //   1292: bipush 15
    //   1294: ldc_w 449
    //   1297: bastore
    //   1298: dup
    //   1299: bipush 16
    //   1301: ldc_w 452
    //   1304: bastore
    //   1305: dup
    //   1306: bipush 17
    //   1308: ldc_w 453
    //   1311: bastore
    //   1312: dup
    //   1313: bipush 18
    //   1315: ldc_w 443
    //   1318: bastore
    //   1319: dup
    //   1320: bipush 19
    //   1322: ldc_w 432
    //   1325: bastore
    //   1326: dup
    //   1327: bipush 20
    //   1329: ldc_w 446
    //   1332: bastore
    //   1333: dup
    //   1334: bipush 21
    //   1336: ldc_w 446
    //   1339: bastore
    //   1340: dup
    //   1341: bipush 22
    //   1343: ldc_w 454
    //   1346: bastore
    //   1347: dup
    //   1348: bipush 23
    //   1350: ldc_w 455
    //   1353: bastore
    //   1354: dup
    //   1355: bipush 24
    //   1357: ldc_w 432
    //   1360: bastore
    //   1361: dup
    //   1362: bipush 25
    //   1364: ldc_w 442
    //   1367: bastore
    //   1368: dup
    //   1369: bipush 26
    //   1371: ldc_w 449
    //   1374: bastore
    //   1375: dup
    //   1376: bipush 27
    //   1378: ldc_w 456
    //   1381: bastore
    //   1382: invokespecial 437	java/lang/String:<init>	([B)V
    //   1385: invokestatic 460	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1388: astore 8
    //   1390: aload 8
    //   1392: iconst_4
    //   1393: anewarray 261	java/lang/Class
    //   1396: dup
    //   1397: iconst_0
    //   1398: ldc 33
    //   1400: aastore
    //   1401: dup
    //   1402: iconst_1
    //   1403: ldc 33
    //   1405: aastore
    //   1406: dup
    //   1407: iconst_2
    //   1408: ldc 33
    //   1410: aastore
    //   1411: dup
    //   1412: iconst_3
    //   1413: ldc_w 462
    //   1416: aastore
    //   1417: invokevirtual 265	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   1420: iconst_4
    //   1421: anewarray 4	java/lang/Object
    //   1424: dup
    //   1425: iconst_0
    //   1426: aload 7
    //   1428: invokevirtual 430	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1431: aastore
    //   1432: dup
    //   1433: iconst_1
    //   1434: aload_1
    //   1435: invokevirtual 465	btmsdkobf/br:ab	()Ljava/lang/String;
    //   1438: aastore
    //   1439: dup
    //   1440: iconst_2
    //   1441: aconst_null
    //   1442: aastore
    //   1443: dup
    //   1444: iconst_3
    //   1445: ldc 165
    //   1447: invokevirtual 469	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   1450: aastore
    //   1451: invokevirtual 271	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   1454: astore 6
    //   1456: aload 8
    //   1458: new 33	java/lang/String
    //   1461: dup
    //   1462: bipush 9
    //   1464: newarray byte
    //   1466: dup
    //   1467: iconst_0
    //   1468: ldc_w 443
    //   1471: bastore
    //   1472: dup
    //   1473: iconst_1
    //   1474: ldc_w 455
    //   1477: bastore
    //   1478: dup
    //   1479: iconst_2
    //   1480: ldc_w 432
    //   1483: bastore
    //   1484: dup
    //   1485: iconst_3
    //   1486: ldc_w 442
    //   1489: bastore
    //   1490: dup
    //   1491: iconst_4
    //   1492: ldc_w 453
    //   1495: bastore
    //   1496: dup
    //   1497: iconst_5
    //   1498: ldc_w 443
    //   1501: bastore
    //   1502: dup
    //   1503: bipush 6
    //   1505: ldc_w 432
    //   1508: bastore
    //   1509: dup
    //   1510: bipush 7
    //   1512: ldc_w 446
    //   1515: bastore
    //   1516: dup
    //   1517: bipush 8
    //   1519: ldc_w 446
    //   1522: bastore
    //   1523: invokespecial 437	java/lang/String:<init>	([B)V
    //   1526: iconst_1
    //   1527: anewarray 261	java/lang/Class
    //   1530: dup
    //   1531: iconst_0
    //   1532: ldc 33
    //   1534: aastore
    //   1535: invokevirtual 473	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1538: astore 8
    //   1540: aload_1
    //   1541: invokevirtual 465	btmsdkobf/br:ab	()Ljava/lang/String;
    //   1544: invokestatic 479	btmsdkobf/dz:H	(Ljava/lang/String;)Z
    //   1547: pop
    //   1548: aload 7
    //   1550: aload 11
    //   1552: invokevirtual 441	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1555: pop
    //   1556: aload_0
    //   1557: aload 10
    //   1559: aload 10
    //   1561: iconst_1
    //   1562: invokespecial 322	btmsdkobf/bq:a	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   1565: ifne +38 -> 1603
    //   1568: ldc_w 323
    //   1571: new 62	java/lang/StringBuilder
    //   1574: dup
    //   1575: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1578: ldc_w 481
    //   1581: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1584: aload_1
    //   1585: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   1588: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1591: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1594: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   1597: aload_0
    //   1598: aload_1
    //   1599: iconst_0
    //   1600: invokespecial 195	btmsdkobf/bq:a	(Lbtmsdkobf/br;Z)V
    //   1603: aload 8
    //   1605: ifnull +129 -> 1734
    //   1608: aload 8
    //   1610: iconst_1
    //   1611: invokevirtual 487	java/lang/reflect/Method:setAccessible	(Z)V
    //   1614: aload 8
    //   1616: aload 6
    //   1618: iconst_1
    //   1619: anewarray 4	java/lang/Object
    //   1622: dup
    //   1623: iconst_0
    //   1624: ldc_w 489
    //   1627: aastore
    //   1628: invokevirtual 493	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1631: checkcast 261	java/lang/Class
    //   1634: astore 8
    //   1636: aload 8
    //   1638: iconst_0
    //   1639: anewarray 261	java/lang/Class
    //   1642: invokevirtual 265	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   1645: iconst_0
    //   1646: anewarray 4	java/lang/Object
    //   1649: invokevirtual 271	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   1652: checkcast 247	tmsdk/common/roach/nest/ActionI
    //   1655: astore 7
    //   1657: iload_2
    //   1658: iconst_1
    //   1659: if_icmpne +120 -> 1779
    //   1662: new 304	android/os/Bundle
    //   1665: dup
    //   1666: ldc 2
    //   1668: invokevirtual 469	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   1671: invokespecial 496	android/os/Bundle:<init>	(Ljava/lang/ClassLoader;)V
    //   1674: astore 6
    //   1676: aload 6
    //   1678: ldc_w 307
    //   1681: aload_1
    //   1682: invokevirtual 274	btmsdkobf/br:aa	()Ljava/lang/String;
    //   1685: invokevirtual 311	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1688: aload 7
    //   1690: aload 6
    //   1692: invokevirtual 315	tmsdk/common/roach/nest/ActionI:onStart	(Landroid/os/Bundle;)V
    //   1695: aload_0
    //   1696: getfield 50	btmsdkobf/bq:gr	Ljava/util/HashMap;
    //   1699: aload 9
    //   1701: aload 8
    //   1703: invokevirtual 319	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1706: pop
    //   1707: aload_0
    //   1708: getfield 52	btmsdkobf/bq:gs	Ljava/util/HashMap;
    //   1711: aload 9
    //   1713: aload 7
    //   1715: invokevirtual 319	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1718: pop
    //   1719: aload 9
    //   1721: getfield 499	btmsdkobf/bt:gK	I
    //   1724: iconst_2
    //   1725: if_icmpne +9 -> 1734
    //   1728: aload_0
    //   1729: aload_1
    //   1730: iconst_1
    //   1731: invokespecial 195	btmsdkobf/bq:a	(Lbtmsdkobf/br;Z)V
    //   1734: aload 5
    //   1736: ifnull +8 -> 1744
    //   1739: aload 5
    //   1741: invokevirtual 422	java/util/zip/ZipFile:close	()V
    //   1744: iload_2
    //   1745: iconst_1
    //   1746: if_icmpne -1463 -> 283
    //   1749: ldc_w 292
    //   1752: new 62	java/lang/StringBuilder
    //   1755: dup
    //   1756: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1759: ldc_w 501
    //   1762: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1765: aload_1
    //   1766: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   1769: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1772: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1775: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   1778: return
    //   1779: iload_2
    //   1780: iconst_2
    //   1781: if_icmpne -47 -> 1734
    //   1784: aload 7
    //   1786: invokevirtual 256	tmsdk/common/roach/nest/ActionI:clean	()V
    //   1789: goto -55 -> 1734
    //   1792: astore_1
    //   1793: aload 5
    //   1795: ifnull +8 -> 1803
    //   1798: aload 5
    //   1800: invokevirtual 422	java/util/zip/ZipFile:close	()V
    //   1803: aload_1
    //   1804: athrow
    //   1805: iload_2
    //   1806: iconst_2
    //   1807: if_icmpne -779 -> 1028
    //   1810: ldc_w 292
    //   1813: new 62	java/lang/StringBuilder
    //   1816: dup
    //   1817: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1820: ldc_w 302
    //   1823: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1826: aload_1
    //   1827: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   1830: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1833: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1836: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   1839: goto -811 -> 1028
    //   1842: astore_1
    //   1843: goto -50 -> 1793
    //   1846: astore_1
    //   1847: return
    //   1848: astore 7
    //   1850: goto -783 -> 1067
    //   1853: astore 5
    //   1855: goto -111 -> 1744
    //   1858: astore 5
    //   1860: goto -57 -> 1803
    //   1863: astore_1
    //   1864: aconst_null
    //   1865: astore 5
    //   1867: goto -74 -> 1793
    //   1870: astore 5
    //   1872: aconst_null
    //   1873: astore 5
    //   1875: goto -881 -> 994
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1878	0	this	bq
    //   0	1878	1	parambr	br
    //   0	1878	2	paramInt	int
    //   832	278	3	i	int
    //   264	3	4	bool	boolean
    //   67	252	5	localObject1	Object
    //   344	160	5	localThrowable1	Throwable
    //   512	52	5	localThrowable2	Throwable
    //   669	371	5	localObject2	Object
    //   1047	752	5	localThrowable3	Throwable
    //   1853	1	5	localThrowable4	Throwable
    //   1858	1	5	localThrowable5	Throwable
    //   1865	1	5	localObject3	Object
    //   1870	1	5	localThrowable6	Throwable
    //   1873	1	5	localObject4	Object
    //   18	782	6	localObject5	Object
    //   992	1	6	localThrowable7	Throwable
    //   1052	639	6	localObject6	Object
    //   40	1023	7	localObject7	Object
    //   1075	1	7	localIOException1	java.io.IOException
    //   1174	611	7	localObject8	Object
    //   1848	1	7	localIOException2	java.io.IOException
    //   822	880	8	localObject9	Object
    //   4	1716	9	localbt	bt
    //   246	1314	10	str	String
    //   257	1294	11	localFile	File
    //   702	13	12	localEnumeration	java.util.Enumeration
    //   724	259	13	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   69	112	344	java/lang/Throwable
    //   290	303	344	java/lang/Throwable
    //   313	343	344	java/lang/Throwable
    //   166	211	512	java/lang/Throwable
    //   422	466	512	java/lang/Throwable
    //   471	511	512	java/lang/Throwable
    //   554	569	512	java/lang/Throwable
    //   656	664	664	java/lang/Throwable
    //   697	704	992	java/lang/Throwable
    //   704	726	992	java/lang/Throwable
    //   731	833	992	java/lang/Throwable
    //   841	869	992	java/lang/Throwable
    //   869	934	992	java/lang/Throwable
    //   934	968	992	java/lang/Throwable
    //   968	976	992	java/lang/Throwable
    //   980	989	992	java/lang/Throwable
    //   1057	1062	992	java/lang/Throwable
    //   1062	1067	992	java/lang/Throwable
    //   1067	1072	992	java/lang/Throwable
    //   1080	1099	992	java/lang/Throwable
    //   1103	1115	992	java/lang/Throwable
    //   1115	1603	992	java/lang/Throwable
    //   1608	1657	992	java/lang/Throwable
    //   1662	1734	992	java/lang/Throwable
    //   1784	1789	992	java/lang/Throwable
    //   1039	1044	1045	java/lang/Throwable
    //   671	677	1047	java/lang/Throwable
    //   1067	1072	1075	java/io/IOException
    //   697	704	1792	finally
    //   704	726	1792	finally
    //   731	833	1792	finally
    //   841	869	1792	finally
    //   869	934	1792	finally
    //   934	968	1792	finally
    //   968	976	1792	finally
    //   980	989	1792	finally
    //   1057	1062	1792	finally
    //   1062	1067	1792	finally
    //   1067	1072	1792	finally
    //   1080	1099	1792	finally
    //   1103	1115	1792	finally
    //   1115	1603	1792	finally
    //   1608	1657	1792	finally
    //   1662	1734	1792	finally
    //   1784	1789	1792	finally
    //   999	1028	1842	finally
    //   1028	1034	1842	finally
    //   1810	1839	1842	finally
    //   275	283	1846	java/lang/Throwable
    //   1062	1067	1848	java/io/IOException
    //   1739	1744	1853	java/lang/Throwable
    //   1798	1803	1858	java/lang/Throwable
    //   216	266	1863	finally
    //   605	652	1863	finally
    //   671	677	1863	finally
    //   686	697	1863	finally
    //   216	266	1870	java/lang/Throwable
    //   605	652	1870	java/lang/Throwable
    //   686	697	1870	java/lang/Throwable
  }
  
  private void a(br parambr, boolean paramBoolean)
  {
    if ((parambr == null) || (parambr.gz == null)) {
      return;
    }
    if (paramBoolean) {}
    try
    {
      a(parambr, 2);
      dz.H(parambr.aa());
      dz.H(parambr.ab());
      this.gw.j(parambr.gz.gH);
      be.SaveStringData(1320043, "1;;" + parambr.Z());
      return;
    }
    catch (Throwable localThrowable)
    {
      be.SaveStringData(1320043, "0;1019;" + parambr.Z());
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
    //   9: new 276	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 393	java/io/File:length	()J
    //   20: lstore 7
    //   22: lload 7
    //   24: lconst_0
    //   25: lcmp
    //   26: ifgt +32 -> 58
    //   29: iconst_0
    //   30: ifeq +11 -> 41
    //   33: new 290	java/lang/NullPointerException
    //   36: dup
    //   37: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   40: athrow
    //   41: iload 6
    //   43: istore_3
    //   44: iconst_0
    //   45: ifeq +11 -> 56
    //   48: new 290	java/lang/NullPointerException
    //   51: dup
    //   52: invokespecial 291	java/lang/NullPointerException:<init>	()V
    //   55: athrow
    //   56: iload_3
    //   57: ireturn
    //   58: lload 7
    //   60: l2i
    //   61: istore 4
    //   63: iload 4
    //   65: newarray byte
    //   67: astore 11
    //   69: new 401	java/io/BufferedInputStream
    //   72: dup
    //   73: new 509	java/io/FileInputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 510	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   81: invokespecial 408	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore_1
    //   85: sipush 8192
    //   88: newarray byte
    //   90: astore 12
    //   92: iconst_0
    //   93: istore 4
    //   95: aload_1
    //   96: aload 12
    //   98: invokevirtual 415	java/io/BufferedInputStream:read	([B)I
    //   101: istore 5
    //   103: iload 5
    //   105: iconst_m1
    //   106: if_icmpeq +25 -> 131
    //   109: aload 12
    //   111: iconst_0
    //   112: aload 11
    //   114: iload 4
    //   116: iload 5
    //   118: invokestatic 516	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   121: iload 4
    //   123: iload 5
    //   125: iadd
    //   126: istore 4
    //   128: goto -33 -> 95
    //   131: new 410	java/io/FileOutputStream
    //   134: dup
    //   135: aload_2
    //   136: invokespecial 517	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   139: astore_2
    //   140: iload_3
    //   141: ifeq +40 -> 181
    //   144: aload_2
    //   145: aload 11
    //   147: aconst_null
    //   148: invokestatic 521	tmsdk/common/tcc/b:encrypt	([B[B)[B
    //   151: invokevirtual 523	java/io/FileOutputStream:write	([B)V
    //   154: aload_2
    //   155: invokevirtual 425	java/io/FileOutputStream:flush	()V
    //   158: iconst_1
    //   159: istore_3
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 426	java/io/BufferedInputStream:close	()V
    //   168: aload_2
    //   169: ifnull -113 -> 56
    //   172: aload_2
    //   173: invokevirtual 427	java/io/FileOutputStream:close	()V
    //   176: iconst_1
    //   177: ireturn
    //   178: astore_1
    //   179: iconst_1
    //   180: ireturn
    //   181: aload_2
    //   182: aload 11
    //   184: aconst_null
    //   185: invokestatic 526	tmsdk/common/tcc/b:decrypt	([B[B)[B
    //   188: invokevirtual 523	java/io/FileOutputStream:write	([B)V
    //   191: goto -37 -> 154
    //   194: astore 9
    //   196: aload_1
    //   197: ifnull +7 -> 204
    //   200: aload_1
    //   201: invokevirtual 426	java/io/BufferedInputStream:close	()V
    //   204: iload 6
    //   206: istore_3
    //   207: aload_2
    //   208: ifnull -152 -> 56
    //   211: aload_2
    //   212: invokevirtual 427	java/io/FileOutputStream:close	()V
    //   215: iconst_0
    //   216: ireturn
    //   217: astore_1
    //   218: iconst_0
    //   219: ireturn
    //   220: astore_2
    //   221: aconst_null
    //   222: astore_1
    //   223: aload_1
    //   224: ifnull +7 -> 231
    //   227: aload_1
    //   228: invokevirtual 426	java/io/BufferedInputStream:close	()V
    //   231: aload 9
    //   233: ifnull +8 -> 241
    //   236: aload 9
    //   238: invokevirtual 427	java/io/FileOutputStream:close	()V
    //   241: aload_2
    //   242: athrow
    //   243: astore_1
    //   244: goto -203 -> 41
    //   247: astore_1
    //   248: iconst_0
    //   249: ireturn
    //   250: astore_1
    //   251: goto -83 -> 168
    //   254: astore_1
    //   255: goto -51 -> 204
    //   258: astore_1
    //   259: goto -28 -> 231
    //   262: astore_1
    //   263: goto -22 -> 241
    //   266: astore_2
    //   267: goto -44 -> 223
    //   270: astore 10
    //   272: aload_2
    //   273: astore 9
    //   275: aload 10
    //   277: astore_2
    //   278: goto -55 -> 223
    //   281: astore_1
    //   282: aconst_null
    //   283: astore_1
    //   284: aload 10
    //   286: astore_2
    //   287: goto -91 -> 196
    //   290: astore_2
    //   291: aload 10
    //   293: astore_2
    //   294: goto -98 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	bq
    //   0	297	1	paramString1	String
    //   0	297	2	paramString2	String
    //   0	297	3	paramBoolean	boolean
    //   61	66	4	i	int
    //   101	25	5	j	int
    //   1	204	6	bool	boolean
    //   20	39	7	l	long
    //   4	1	9	localObject1	Object
    //   194	43	9	localThrowable	Throwable
    //   273	1	9	str	String
    //   7	1	10	localObject2	Object
    //   270	22	10	localObject3	Object
    //   67	116	11	arrayOfByte1	byte[]
    //   90	20	12	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   172	176	178	java/lang/Throwable
    //   144	154	194	java/lang/Throwable
    //   154	158	194	java/lang/Throwable
    //   181	191	194	java/lang/Throwable
    //   211	215	217	java/lang/Throwable
    //   9	22	220	finally
    //   63	85	220	finally
    //   33	41	243	java/lang/Throwable
    //   48	56	247	java/lang/Throwable
    //   164	168	250	java/lang/Throwable
    //   200	204	254	java/lang/Throwable
    //   227	231	258	java/lang/Throwable
    //   236	241	262	java/lang/Throwable
    //   85	92	266	finally
    //   95	103	266	finally
    //   109	121	266	finally
    //   131	140	266	finally
    //   144	154	270	finally
    //   154	158	270	finally
    //   181	191	270	finally
    //   9	22	281	java/lang/Throwable
    //   63	85	281	java/lang/Throwable
    //   85	92	290	java/lang/Throwable
    //   95	103	290	java/lang/Throwable
    //   109	121	290	java/lang/Throwable
    //   131	140	290	java/lang/Throwable
  }
  
  /* Error */
  private boolean b(br parambr)
  {
    // Byte code:
    //   0: getstatic 534	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 26
    //   5: if_icmple +5 -> 10
    //   8: iconst_1
    //   9: ireturn
    //   10: aload_1
    //   11: ifnull +10 -> 21
    //   14: aload_1
    //   15: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   18: ifnonnull +5 -> 23
    //   21: iconst_0
    //   22: ireturn
    //   23: new 62	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   30: aload_1
    //   31: invokevirtual 274	btmsdkobf/br:aa	()Ljava/lang/String;
    //   34: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: getstatic 280	java/io/File:separator	Ljava/lang/String;
    //   40: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   47: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore 4
    //   55: new 276	java/io/File
    //   58: dup
    //   59: aload 4
    //   61: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore_3
    //   65: aload_3
    //   66: invokevirtual 288	java/io/File:exists	()Z
    //   69: ifne +34 -> 103
    //   72: ldc_w 323
    //   75: new 62	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 536
    //   85: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_1
    //   89: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   92: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   101: iconst_0
    //   102: ireturn
    //   103: aload_3
    //   104: invokevirtual 393	java/io/File:length	()J
    //   107: aload_1
    //   108: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   111: getfield 539	btmsdkobf/bt:gM	I
    //   114: i2l
    //   115: lcmp
    //   116: ifeq +34 -> 150
    //   119: ldc_w 323
    //   122: new 62	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 541
    //   132: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_1
    //   136: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   139: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   148: iconst_0
    //   149: ireturn
    //   150: new 276	java/io/File
    //   153: dup
    //   154: aload 4
    //   156: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   159: invokestatic 544	btmsdkobf/dz:a	(Ljava/io/File;)Ljava/lang/String;
    //   162: aload_1
    //   163: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   166: getfield 547	btmsdkobf/bt:gN	Ljava/lang/String;
    //   169: invokevirtual 550	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   172: ifeq +34 -> 206
    //   175: ldc_w 323
    //   178: new 62	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 552
    //   188: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_1
    //   192: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   195: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   204: iconst_0
    //   205: ireturn
    //   206: aconst_null
    //   207: astore_3
    //   208: ldc_w 554
    //   211: invokevirtual 556	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   214: checkcast 554	android/content/res/AssetManager
    //   217: astore 5
    //   219: ldc_w 554
    //   222: ldc_w 558
    //   225: iconst_1
    //   226: anewarray 261	java/lang/Class
    //   229: dup
    //   230: iconst_0
    //   231: ldc 33
    //   233: aastore
    //   234: invokevirtual 561	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   237: astore 6
    //   239: aload 6
    //   241: iconst_1
    //   242: invokevirtual 487	java/lang/reflect/Method:setAccessible	(Z)V
    //   245: aload 6
    //   247: aload 5
    //   249: iconst_1
    //   250: anewarray 4	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: aload 4
    //   257: aastore
    //   258: invokevirtual 493	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   261: pop
    //   262: aload 5
    //   264: ldc_w 563
    //   267: iconst_1
    //   268: invokevirtual 567	android/content/res/AssetManager:open	(Ljava/lang/String;I)Ljava/io/InputStream;
    //   271: astore 4
    //   273: aload 4
    //   275: astore_3
    //   276: invokestatic 573	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   279: astore 5
    //   281: aload 4
    //   283: astore_3
    //   284: aload 5
    //   286: aload 4
    //   288: ldc_w 575
    //   291: invokeinterface 581 3 0
    //   296: aload 4
    //   298: astore_3
    //   299: aload 5
    //   301: invokeinterface 584 1 0
    //   306: istore_2
    //   307: goto +515 -> 822
    //   310: aload 4
    //   312: astore_3
    //   313: aload 5
    //   315: invokeinterface 586 1 0
    //   320: istore_2
    //   321: goto +501 -> 822
    //   324: aload 4
    //   326: astore_3
    //   327: aload 5
    //   329: invokeinterface 587 1 0
    //   334: astore 6
    //   336: aload 4
    //   338: astore_3
    //   339: aload 6
    //   341: ldc_w 589
    //   344: invokevirtual 592	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   347: ifne +73 -> 420
    //   350: aload 4
    //   352: astore_3
    //   353: aload 5
    //   355: invokeinterface 595 1 0
    //   360: invokestatic 600	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   363: invokevirtual 603	java/lang/Integer:intValue	()I
    //   366: aload_1
    //   367: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   370: getfield 241	btmsdkobf/bt:gH	I
    //   373: if_icmpeq -63 -> 310
    //   376: aload 4
    //   378: astore_3
    //   379: ldc_w 323
    //   382: new 62	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   389: ldc_w 605
    //   392: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_1
    //   396: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   399: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   408: aload 4
    //   410: ifnull +8 -> 418
    //   413: aload 4
    //   415: invokevirtual 608	java/io/InputStream:close	()V
    //   418: iconst_0
    //   419: ireturn
    //   420: aload 4
    //   422: astore_3
    //   423: aload 6
    //   425: ldc_w 610
    //   428: invokevirtual 592	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   431: ifne +73 -> 504
    //   434: aload 4
    //   436: astore_3
    //   437: aload 5
    //   439: invokeinterface 595 1 0
    //   444: invokestatic 600	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   447: invokevirtual 603	java/lang/Integer:intValue	()I
    //   450: aload_1
    //   451: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   454: getfield 250	btmsdkobf/bt:gI	I
    //   457: if_icmpeq -147 -> 310
    //   460: aload 4
    //   462: astore_3
    //   463: ldc_w 323
    //   466: new 62	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 612
    //   476: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload_1
    //   480: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   483: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   492: aload 4
    //   494: ifnull +8 -> 502
    //   497: aload 4
    //   499: invokevirtual 608	java/io/InputStream:close	()V
    //   502: iconst_0
    //   503: ireturn
    //   504: aload 4
    //   506: astore_3
    //   507: aload 6
    //   509: ldc_w 614
    //   512: invokevirtual 592	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   515: ifne +73 -> 588
    //   518: aload 4
    //   520: astore_3
    //   521: aload 5
    //   523: invokeinterface 595 1 0
    //   528: invokestatic 600	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   531: invokevirtual 603	java/lang/Integer:intValue	()I
    //   534: aload_1
    //   535: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   538: getfield 617	btmsdkobf/bt:gJ	I
    //   541: if_icmpeq -231 -> 310
    //   544: aload 4
    //   546: astore_3
    //   547: ldc_w 323
    //   550: new 62	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   557: ldc_w 619
    //   560: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload_1
    //   564: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   567: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   576: aload 4
    //   578: ifnull +8 -> 586
    //   581: aload 4
    //   583: invokevirtual 608	java/io/InputStream:close	()V
    //   586: iconst_0
    //   587: ireturn
    //   588: aload 4
    //   590: astore_3
    //   591: aload 6
    //   593: ldc_w 621
    //   596: invokevirtual 592	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   599: ifne -289 -> 310
    //   602: aload 4
    //   604: astore_3
    //   605: aload 5
    //   607: invokeinterface 595 1 0
    //   612: invokestatic 600	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   615: invokevirtual 603	java/lang/Integer:intValue	()I
    //   618: aload_1
    //   619: getfield 201	btmsdkobf/br:gz	Lbtmsdkobf/bt;
    //   622: getfield 499	btmsdkobf/bt:gK	I
    //   625: if_icmpeq -315 -> 310
    //   628: aload 4
    //   630: astore_3
    //   631: ldc_w 323
    //   634: new 62	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   641: ldc_w 623
    //   644: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: aload_1
    //   648: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   651: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   660: aload 4
    //   662: ifnull +8 -> 670
    //   665: aload 4
    //   667: invokevirtual 608	java/io/InputStream:close	()V
    //   670: iconst_0
    //   671: ireturn
    //   672: aload 4
    //   674: astore_3
    //   675: aload 5
    //   677: invokeinterface 587 1 0
    //   682: pop
    //   683: goto -373 -> 310
    //   686: astore_3
    //   687: aload 4
    //   689: astore_3
    //   690: ldc_w 323
    //   693: new 62	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   700: ldc_w 625
    //   703: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload_1
    //   707: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   710: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   719: aload 4
    //   721: ifnull +8 -> 729
    //   724: aload 4
    //   726: invokevirtual 608	java/io/InputStream:close	()V
    //   729: iconst_0
    //   730: ireturn
    //   731: aload 4
    //   733: ifnull +8 -> 741
    //   736: aload 4
    //   738: invokevirtual 608	java/io/InputStream:close	()V
    //   741: ldc_w 323
    //   744: new 62	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   751: ldc_w 501
    //   754: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload_1
    //   758: invokevirtual 283	btmsdkobf/br:Z	()Ljava/lang/String;
    //   761: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokestatic 300	btmsdkobf/be:SaveStringData	(ILjava/lang/String;)V
    //   770: iconst_1
    //   771: ireturn
    //   772: astore_1
    //   773: aload_3
    //   774: ifnull +7 -> 781
    //   777: aload_3
    //   778: invokevirtual 608	java/io/InputStream:close	()V
    //   781: aload_1
    //   782: athrow
    //   783: astore_1
    //   784: goto -366 -> 418
    //   787: astore_1
    //   788: goto -286 -> 502
    //   791: astore_1
    //   792: goto -206 -> 586
    //   795: astore_1
    //   796: goto -126 -> 670
    //   799: astore_3
    //   800: goto -59 -> 741
    //   803: astore_1
    //   804: goto -75 -> 729
    //   807: astore_3
    //   808: goto -27 -> 781
    //   811: astore_1
    //   812: goto -39 -> 773
    //   815: astore_3
    //   816: aconst_null
    //   817: astore 4
    //   819: goto -132 -> 687
    //   822: iload_2
    //   823: iconst_1
    //   824: if_icmpeq -93 -> 731
    //   827: iload_2
    //   828: tableswitch	default:+32 -> 860, 0:+-518->310, 1:+-518->310, 2:+-504->324, 3:+-156->672
    //   861: <illegal opcode>
    //   862: <illegal opcode>
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	863	0	this	bq
    //   0	863	1	parambr	br
    //   306	522	2	i	int
    //   64	611	3	localObject1	Object
    //   686	1	3	localThrowable1	Throwable
    //   689	89	3	localObject2	Object
    //   799	1	3	localIOException1	java.io.IOException
    //   807	1	3	localIOException2	java.io.IOException
    //   815	1	3	localThrowable2	Throwable
    //   53	765	4	localObject3	Object
    //   217	459	5	localObject4	Object
    //   237	355	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   276	281	686	java/lang/Throwable
    //   284	296	686	java/lang/Throwable
    //   299	307	686	java/lang/Throwable
    //   313	321	686	java/lang/Throwable
    //   327	336	686	java/lang/Throwable
    //   339	350	686	java/lang/Throwable
    //   353	376	686	java/lang/Throwable
    //   379	408	686	java/lang/Throwable
    //   423	434	686	java/lang/Throwable
    //   437	460	686	java/lang/Throwable
    //   463	492	686	java/lang/Throwable
    //   507	518	686	java/lang/Throwable
    //   521	544	686	java/lang/Throwable
    //   547	576	686	java/lang/Throwable
    //   591	602	686	java/lang/Throwable
    //   605	628	686	java/lang/Throwable
    //   631	660	686	java/lang/Throwable
    //   675	683	686	java/lang/Throwable
    //   208	273	772	finally
    //   413	418	783	java/io/IOException
    //   497	502	787	java/io/IOException
    //   581	586	791	java/io/IOException
    //   665	670	795	java/io/IOException
    //   736	741	799	java/io/IOException
    //   724	729	803	java/io/IOException
    //   777	781	807	java/io/IOException
    //   276	281	811	finally
    //   284	296	811	finally
    //   299	307	811	finally
    //   313	321	811	finally
    //   327	336	811	finally
    //   339	350	811	finally
    //   353	376	811	finally
    //   379	408	811	finally
    //   423	434	811	finally
    //   437	460	811	finally
    //   463	492	811	finally
    //   507	518	811	finally
    //   521	544	811	finally
    //   547	576	811	finally
    //   591	602	811	finally
    //   605	628	811	finally
    //   631	660	811	finally
    //   675	683	811	finally
    //   690	719	811	finally
    //   208	273	815	java/lang/Throwable
  }
  
  private void c(br parambr)
  {
    int i;
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
      Object localObject = new File(parambr.aa());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      parambr.gB = 2;
      this.gw.d(parambr);
      localObject = new HttpGetFile(bc.n());
      ((HttpGetFile)localObject).setSavePath(parambr.aa());
      ((HttpGetFile)localObject).setSaveName(parambr.Z());
      do
      {
        i = ((HttpGetFile)localObject).doGetFile(null, parambr.gz.gO, false, null);
      } while (i == -7);
      if (this.gw.i(parambr.gz.gH) == null)
      {
        a(parambr, false);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      be.SaveStringData(1320036, "0;1004;" + parambr.Z());
      parambr.gB = 1;
      this.gw.e(parambr);
      W();
      return;
    }
    if (i == 0)
    {
      be.SaveStringData(1320036, "1;;" + parambr.Z());
      if (!b(parambr))
      {
        a(parambr, false);
        return;
      }
      String str = parambr.aa() + File.separator + parambr.Z();
      if (!a(str, str, true))
      {
        be.SaveStringData(1320038, "0;1015;" + parambr.Z());
        a(parambr, false);
        return;
      }
      parambr.gB = 3;
      this.gw.d(parambr);
      a(parambr, 1);
      return;
    }
    be.SaveStringData(1320036, "0;1004;" + parambr.Z());
    parambr.gB = 1;
    this.gw.d(parambr);
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
  
  /* Error */
  public void T()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 60	btmsdkobf/bq:gw	Lbtmsdkobf/bs;
    //   6: ifnonnull +10 -> 16
    //   9: aload_0
    //   10: invokestatic 98	btmsdkobf/bs:ac	()Lbtmsdkobf/bs;
    //   13: putfield 60	btmsdkobf/bq:gw	Lbtmsdkobf/bs;
    //   16: aload_0
    //   17: getfield 60	btmsdkobf/bq:gw	Lbtmsdkobf/bs;
    //   20: invokevirtual 681	btmsdkobf/bs:af	()Ljava/util/List;
    //   23: ifnonnull +10 -> 33
    //   26: aload_0
    //   27: invokespecial 627	btmsdkobf/bq:X	()V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: aload_0
    //   34: invokespecial 203	btmsdkobf/bq:U	()V
    //   37: aload_0
    //   38: getfield 56	btmsdkobf/bq:gu	Landroid/os/Handler;
    //   41: sipush 258
    //   44: invokevirtual 133	android/os/Handler:removeMessages	(I)V
    //   47: aload_0
    //   48: getfield 56	btmsdkobf/bq:gu	Landroid/os/Handler;
    //   51: sipush 258
    //   54: invokevirtual 136	android/os/Handler:sendEmptyMessage	(I)Z
    //   57: pop
    //   58: aload_0
    //   59: getfield 56	btmsdkobf/bq:gu	Landroid/os/Handler;
    //   62: sipush 262
    //   65: invokevirtual 133	android/os/Handler:removeMessages	(I)V
    //   68: aload_0
    //   69: getfield 56	btmsdkobf/bq:gu	Landroid/os/Handler;
    //   72: sipush 262
    //   75: invokevirtual 136	android/os/Handler:sendEmptyMessage	(I)Z
    //   78: pop
    //   79: goto -49 -> 30
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	bq
    //   82	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	82	finally
    //   16	30	82	finally
    //   33	79	82	finally
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
    br localbr;
    try
    {
      bo.k("onRecvPush-[" + paramConchPushInfo + "]");
      localbr = new br();
      localbr.gz = new bt();
      try
      {
        ad localad;
        long l;
        if (R() == paramConchPushInfo.mConch.cmdId)
        {
          localad = (ad)cp.a(paramConchPushInfo.mConch.aZ, new ad(), false);
          l = paramConchPushInfo.mConch.bb.validEndTime * 1000L;
          if (l >= System.currentTimeMillis()) {
            break label121;
          }
          bo.l("config item expired");
        }
        for (;;)
        {
          return;
          label121:
          Calendar.getInstance().setTimeInMillis(l);
          localbr.gA = ConvertUtil.stringToInt((String)localad.bm.get(0));
          localbr.gz.gH = ConvertUtil.stringToInt((String)localad.bm.get(1));
          localbr.gz.gI = ConvertUtil.stringToInt((String)localad.bm.get(2));
          localbr.gz.gJ = ConvertUtil.stringToInt((String)localad.bm.get(3));
          localbr.gz.gK = ConvertUtil.stringToInt((String)localad.bm.get(4));
          localbr.gz.gM = ConvertUtil.stringToInt((String)localad.bm.get(5));
          localbr.gz.gN = ((String)localad.bm.get(6));
          localbr.gz.gO = ((String)localad.bm.get(7));
          localbr.gz.gL = l;
          localbr.gB = 1;
          if ((localbr.gA == 1) || (localbr.gA == 2)) {
            break;
          }
          bo.l("config item op error:[" + localbr.gA + "]");
          be.SaveStringData(1320035, "0;1000;" + localbr.Z());
        }
      }
      catch (Throwable paramConchPushInfo)
      {
        for (;;)
        {
          be.SaveStringData(1320035, "0;1003;" + localbr.Z());
          bo.l("e:[" + paramConchPushInfo + "]");
        }
      }
      bo.k("push config item:[" + localbr + "]");
    }
    finally {}
    int i = 0;
    for (;;)
    {
      if ((i >= gp.length) || (localbr.gz.gJ == gp[i]))
      {
        if (i >= gp.length)
        {
          bo.l("current nest not support, roach nest id:[" + localbr.gz.gJ + "]");
          be.SaveStringData(1320035, "0;1001;" + localbr.Z());
          break;
        }
        be.SaveStringData(1320035, "1;;" + localbr.Z());
        Q().a(Boolean.valueOf(true));
        a(localbr);
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bq
 * JD-Core Version:    0.7.0.1
 */