import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class aszd
{
  private List<aszd.b> Kh;
  private asyv jdField_a_of_type_Asyv;
  private asyx jdField_a_of_type_Asyx;
  private boolean dgH;
  private boolean dgI;
  private final String[] iB = { "libhobi.so" };
  private final String[] iC = { "2.1.3" };
  private ConcurrentHashMap<Integer, aszd.b> jG;
  private Handler mHandler;
  private final int[] pu = { 0, 1, 2, 2 };
  private CopyOnWriteArrayList<aszd.a> t = new CopyOnWriteArrayList();
  
  public aszd(asyv paramasyv)
  {
    this.jdField_a_of_type_Asyv = paramasyv;
    this.Kh = new LinkedList();
    this.jdField_a_of_type_Asyx = new asyx();
    this.jG = new ConcurrentHashMap();
    this.mHandler = new aszd.c(ThreadManager.getFileThreadLooper());
    this.jdField_a_of_type_Asyv.a(new asze(this));
  }
  
  private String Eu()
  {
    return BaseApplication.getContext().getApplicationInfo().nativeLibraryDir;
  }
  
  private aszd.b a(asyx.a parama)
  {
    aszd.b localb = new aszd.b(null);
    localb.eok = parama.eok;
    localb.mLibType = parama.mLibType;
    localb.eol = parama.eol;
    localb.cGk = parama.cGk;
    localb.mVer = parama.cGj;
    localb.eoo = 4;
    return localb;
  }
  
  private void a(aszd.a parama)
  {
    Iterator localIterator = this.jG.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((aszd.b)localEntry.getValue()).eoo == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QSec", 2, String.format("Notify listener [%d:%d]", new Object[] { Integer.valueOf(1), localEntry.getKey() }));
        }
        parama.kK(1, ((Integer)localEntry.getKey()).intValue());
      }
    }
  }
  
  private void a(aszd.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QSec", 2, String.format("Prepare to unload: %d,%d,%d,%d,%s,%s", new Object[] { Integer.valueOf(paramb.eok), Integer.valueOf(paramb.mLibType), Integer.valueOf(paramb.eol), Integer.valueOf(paramb.eoo), paramb.mVer, paramb.cGk }));
    }
    if ((paramb.eol & 0x1) == 0) {}
    while (paramb.eoo != 1) {
      return;
    }
    paramb.eoo = 3;
    paramb.a.esL();
    int i = QSecFramework.b(3L, paramb.eok, 0L, 0L, null, null, null, null);
    if (QLog.isColorLevel()) {
      QLog.d("QQProtect.QSec", 2, new Object[] { "Unload ret: %d", Integer.valueOf(i) });
    }
    if (i == 0)
    {
      paramb.eoo = 4;
      kL(2, paramb.eok);
      return;
    }
    paramb.eoo = 5;
    paramb.eon = i;
  }
  
  private void a(aszd.b paramb, String paramString1, String paramString2)
  {
    a(paramb);
    if (paramb.eoo == 4)
    {
      if ((paramb.cGk != null) && (!paramb.cGk.equals(paramString2)))
      {
        FileUtils.delete(paramb.cGk);
        paramb.cGk = paramString2;
      }
      if ((paramb.mVer != null) && (!paramb.mVer.equals(paramString1))) {
        paramb.mVer = paramString1;
      }
      paramb.eop = 0;
      c(paramb);
      d(paramb);
    }
  }
  
  private void b(aszd.b paramb)
  {
    asxz localasxz = new asxz();
    localasxz.a(paramb.eok).a(paramb.mVer).a(paramb.eon);
    asxw.gL(localasxz.toString(), 104);
  }
  
  private void c(aszd.b paramb)
  {
    paramb.eoo = 2;
    Object localObject = new aszf(this);
    ((aszf)localObject).a = paramb;
    new asyj(String.format("Lib%d_%s", new Object[] { Integer.valueOf(paramb.eok), paramb.mVer }), 43200000L).a((asyj.a)localObject);
    if (QLog.isColorLevel())
    {
      if (paramb.cGk == null)
      {
        localObject = "null";
        QLog.d("QQProtect.QSec", 2, String.format("load: %s ver: %s error: %08X", new Object[] { localObject, asxv.gz(paramb.eop), Integer.valueOf(paramb.eon) }));
      }
    }
    else {
      if (paramb.eon != 0) {
        break label140;
      }
    }
    label140:
    for (int i = 1;; i = 4)
    {
      paramb.eoo = i;
      return;
      localObject = paramb.cGk;
      break;
    }
  }
  
  private void d(aszd.b paramb)
  {
    this.Kh.add(paramb);
  }
  
  private void e(aszd.b paramb)
  {
    c(paramb);
    if (paramb.eon == 0)
    {
      this.jG.put(Integer.valueOf(paramb.eok), paramb);
      kL(1, paramb.eok);
    }
    d(paramb);
  }
  
  private void esB()
  {
    if (!this.dgH)
    {
      this.dgI = true;
      return;
    }
    this.dgI = false;
    new aszd.d(new aszg(this)).ZX(1);
  }
  
  /* Error */
  private void esC()
  {
    // Byte code:
    //   0: invokestatic 109	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: ldc_w 367
    //   6: iconst_0
    //   7: invokevirtual 371	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10: astore 11
    //   12: aload 11
    //   14: invokeinterface 377 1 0
    //   19: astore 10
    //   21: ldc2_w 378
    //   24: lstore_3
    //   25: lload_3
    //   26: lstore 5
    //   28: getstatic 385	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   31: aconst_null
    //   32: invokevirtual 389	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   35: checkcast 391	com/tencent/mobileqq/app/QQAppInterface
    //   38: astore 9
    //   40: aload 9
    //   42: ifnull +496 -> 538
    //   45: lload_3
    //   46: lstore 5
    //   48: aload 9
    //   50: invokevirtual 394	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   53: astore 12
    //   55: aload 12
    //   57: ifnull +481 -> 538
    //   60: lload_3
    //   61: lstore 5
    //   63: aload 9
    //   65: invokevirtual 394	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   68: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   71: istore_1
    //   72: lload_3
    //   73: lstore 5
    //   75: aload_0
    //   76: getfield 69	aszd:Kh	Ljava/util/List;
    //   79: invokeinterface 399 1 0
    //   84: astore 12
    //   86: lload_3
    //   87: lstore 5
    //   89: aload 12
    //   91: invokeinterface 175 1 0
    //   96: ifeq +436 -> 532
    //   99: lload_3
    //   100: lstore 5
    //   102: aload 12
    //   104: invokeinterface 179 1 0
    //   109: checkcast 9	aszd$b
    //   112: astore 13
    //   114: lload_3
    //   115: lstore 5
    //   117: aload 13
    //   119: getfield 151	aszd$b:mVer	Ljava/lang/String;
    //   122: astore 9
    //   124: lload_3
    //   125: lstore 5
    //   127: aload 13
    //   129: getfield 262	aszd$b:eop	I
    //   132: ifeq +16 -> 148
    //   135: lload_3
    //   136: lstore 5
    //   138: aload 13
    //   140: getfield 262	aszd$b:eop	I
    //   143: invokestatic 332	asxv:gz	(I)Ljava/lang/String;
    //   146: astore 9
    //   148: iload_1
    //   149: ldc_w 400
    //   152: ixor
    //   153: istore_2
    //   154: lload_3
    //   155: lstore 5
    //   157: ldc_w 402
    //   160: iconst_3
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload 13
    //   168: getfield 133	aszd$b:eok	I
    //   171: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: iload_2
    //   178: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: aastore
    //   182: dup
    //   183: iconst_2
    //   184: aload 9
    //   186: aastore
    //   187: invokestatic 206	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   190: astore 14
    //   192: lload_3
    //   193: lstore 5
    //   195: ldc_w 404
    //   198: iconst_3
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload 13
    //   206: getfield 133	aszd$b:eok	I
    //   209: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: iload_2
    //   216: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: aastore
    //   220: dup
    //   221: iconst_2
    //   222: aload 9
    //   224: aastore
    //   225: invokestatic 206	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   228: astore 15
    //   230: lload_3
    //   231: lstore 5
    //   233: aload 11
    //   235: aload 14
    //   237: iconst_m1
    //   238: invokeinterface 408 3 0
    //   243: istore_1
    //   244: lload_3
    //   245: lstore 5
    //   247: aload 11
    //   249: aload 15
    //   251: lconst_0
    //   252: invokeinterface 412 4 0
    //   257: lstore 7
    //   259: lload_3
    //   260: lstore 5
    //   262: new 414	java/util/Date
    //   265: dup
    //   266: invokespecial 415	java/util/Date:<init>	()V
    //   269: invokevirtual 419	java/util/Date:getTime	()J
    //   272: lload 7
    //   274: lsub
    //   275: lstore 7
    //   277: lload 7
    //   279: ldc2_w 378
    //   282: lcmp
    //   283: ifge +73 -> 356
    //   286: lload_3
    //   287: lstore 5
    //   289: aload 13
    //   291: getfield 246	aszd$b:eon	I
    //   294: iload_1
    //   295: if_icmpne +61 -> 356
    //   298: lload_3
    //   299: lstore 5
    //   301: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +239 -> 543
    //   307: lload_3
    //   308: lstore 5
    //   310: ldc 191
    //   312: iconst_2
    //   313: ldc_w 421
    //   316: iconst_3
    //   317: anewarray 4	java/lang/Object
    //   320: dup
    //   321: iconst_0
    //   322: aload 13
    //   324: getfield 133	aszd$b:eok	I
    //   327: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   330: aastore
    //   331: dup
    //   332: iconst_1
    //   333: aload 13
    //   335: getfield 246	aszd$b:eon	I
    //   338: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: aastore
    //   342: dup
    //   343: iconst_2
    //   344: aload 9
    //   346: aastore
    //   347: invokestatic 206	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   350: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: goto +190 -> 543
    //   356: lload_3
    //   357: lstore 5
    //   359: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +49 -> 411
    //   365: lload_3
    //   366: lstore 5
    //   368: ldc 191
    //   370: iconst_2
    //   371: ldc_w 423
    //   374: iconst_3
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: aload 13
    //   382: getfield 133	aszd$b:eok	I
    //   385: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: aastore
    //   389: dup
    //   390: iconst_1
    //   391: aload 13
    //   393: getfield 246	aszd$b:eon	I
    //   396: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   399: aastore
    //   400: dup
    //   401: iconst_2
    //   402: aload 9
    //   404: aastore
    //   405: invokestatic 206	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   408: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: lload_3
    //   412: lstore 5
    //   414: aload 10
    //   416: aload 14
    //   418: aload 13
    //   420: getfield 246	aszd$b:eon	I
    //   423: invokeinterface 429 3 0
    //   428: pop
    //   429: lload_3
    //   430: lstore 5
    //   432: aload 10
    //   434: aload 15
    //   436: new 414	java/util/Date
    //   439: dup
    //   440: invokespecial 415	java/util/Date:<init>	()V
    //   443: invokevirtual 419	java/util/Date:getTime	()J
    //   446: invokeinterface 433 4 0
    //   451: pop
    //   452: lload_3
    //   453: lstore 5
    //   455: aload_0
    //   456: aload 13
    //   458: invokespecial 435	aszd:b	(Laszd$b;)V
    //   461: iload_2
    //   462: istore_1
    //   463: goto -377 -> 86
    //   466: astore 9
    //   468: aload 9
    //   470: invokevirtual 438	java/lang/Exception:printStackTrace	()V
    //   473: aload 10
    //   475: invokeinterface 441 1 0
    //   480: pop
    //   481: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +30 -> 514
    //   487: ldc 191
    //   489: iconst_2
    //   490: new 443	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 444	java/lang/StringBuilder:<init>	()V
    //   497: ldc_w 446
    //   500: invokevirtual 450	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: lload 5
    //   505: invokevirtual 453	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   508: invokevirtual 454	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: invokestatic 458	com/tencent/qqprotect/qsec/QSecFramework:C	()Landroid/os/Handler;
    //   517: new 460	com/tencent/qqprotect/qsec/QSecLibMgr$3
    //   520: dup
    //   521: aload_0
    //   522: invokespecial 461	com/tencent/qqprotect/qsec/QSecLibMgr$3:<init>	(Laszd;)V
    //   525: lload 5
    //   527: invokevirtual 467	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   530: pop
    //   531: return
    //   532: lload_3
    //   533: lstore 5
    //   535: goto -62 -> 473
    //   538: iconst_0
    //   539: istore_1
    //   540: goto -468 -> 72
    //   543: iload_2
    //   544: istore_1
    //   545: lload_3
    //   546: ldc2_w 378
    //   549: lload 7
    //   551: lsub
    //   552: lcmp
    //   553: ifle -467 -> 86
    //   556: ldc2_w 378
    //   559: lload 7
    //   561: lsub
    //   562: lstore_3
    //   563: iload_2
    //   564: istore_1
    //   565: goto -479 -> 86
    //   568: astore 9
    //   570: iconst_0
    //   571: istore_1
    //   572: goto -500 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	this	aszd
    //   71	501	1	i	int
    //   153	411	2	j	int
    //   24	539	3	l1	long
    //   26	508	5	l2	long
    //   257	303	7	l3	long
    //   38	365	9	localObject1	Object
    //   466	3	9	localException	Exception
    //   568	1	9	localNumberFormatException	java.lang.NumberFormatException
    //   19	455	10	localEditor	android.content.SharedPreferences.Editor
    //   10	238	11	localSharedPreferences	android.content.SharedPreferences
    //   53	50	12	localObject2	Object
    //   112	345	13	localb	aszd.b
    //   190	227	14	str1	String
    //   228	207	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   28	40	466	java/lang/Exception
    //   48	55	466	java/lang/Exception
    //   63	72	466	java/lang/Exception
    //   75	86	466	java/lang/Exception
    //   89	99	466	java/lang/Exception
    //   102	114	466	java/lang/Exception
    //   117	124	466	java/lang/Exception
    //   127	135	466	java/lang/Exception
    //   138	148	466	java/lang/Exception
    //   157	192	466	java/lang/Exception
    //   195	230	466	java/lang/Exception
    //   233	244	466	java/lang/Exception
    //   247	259	466	java/lang/Exception
    //   262	277	466	java/lang/Exception
    //   289	298	466	java/lang/Exception
    //   301	307	466	java/lang/Exception
    //   310	353	466	java/lang/Exception
    //   359	365	466	java/lang/Exception
    //   368	411	466	java/lang/Exception
    //   414	429	466	java/lang/Exception
    //   432	452	466	java/lang/Exception
    //   455	461	466	java/lang/Exception
    //   63	72	568	java/lang/NumberFormatException
  }
  
  private void esD()
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
  }
  
  private void esE()
  {
    Object localObject1 = this.jdField_a_of_type_Asyx.hc();
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (asyx.a)localIterator.next();
      byte b = this.jdField_a_of_type_Asyv.f(((asyx.a)localObject2).eok);
      int i;
      int j;
      int k;
      String str;
      if (QLog.isColorLevel())
      {
        i = ((asyx.a)localObject2).eok;
        j = ((asyx.a)localObject2).mLibType;
        k = ((asyx.a)localObject2).eol;
        str = ((asyx.a)localObject2).cGj;
        if (((asyx.a)localObject2).cGk != null) {
          break label201;
        }
      }
      label201:
      for (localObject1 = "null";; localObject1 = ((asyx.a)localObject2).cGk)
      {
        QLog.d("QQProtect.QSec", 2, String.format("%d,%d,%d,%s,%s,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), str, localObject1, Byte.valueOf(b) }));
        if (b == 0) {
          break;
        }
        if (2 != b) {
          break label211;
        }
        localLinkedList.add(localObject2);
        break;
      }
      label211:
      if (1 == b)
      {
        localObject1 = a((asyx.a)localObject2);
        e((aszd.b)localObject1);
        if (((aszd.b)localObject1).eon != 0)
        {
          i = kV(((aszd.b)localObject1).eok);
          if (i != -1)
          {
            localObject2 = Eu() + File.separator + this.iB[this.pu[i]];
            if ((((aszd.b)localObject1).cGk == null) || (!((String)localObject2).equals(((aszd.b)localObject1).cGk)))
            {
              ((aszd.b)localObject1).cGk = ((String)localObject2);
              ((aszd.b)localObject1).mLibType = this.pu[(i + 2)];
              ((aszd.b)localObject1).eol = this.pu[(i + 3)];
              ((aszd.b)localObject1).mVer = this.iC[this.pu[i]];
              ((aszd.b)localObject1).eop = 0;
              e((aszd.b)localObject1);
            }
          }
        }
      }
      else if (-1 == b)
      {
        i = kV(((asyx.a)localObject2).eok);
        if (i != -1)
        {
          localObject1 = a((asyx.a)localObject2);
          ((aszd.b)localObject1).cGk = (Eu() + File.separator + this.iB[this.pu[i]]);
          e((aszd.b)localObject1);
        }
      }
    }
    if (!localLinkedList.isEmpty()) {
      nv(localLinkedList);
    }
    esD();
  }
  
  private void esF()
  {
    new aszd.d(new aszd.e(null)).ZX(1);
  }
  
  private void esG()
  {
    int i = 0;
    int j = 0;
    while (i < this.pu.length)
    {
      int k = this.pu[(i + 1)];
      if (this.jdField_a_of_type_Asyx.b(k) == null)
      {
        asyx.a locala = new asyx.a();
        locala.eok = k;
        locala.mLibType = this.pu[(i + 2)];
        locala.eol = this.pu[(i + 3)];
        locala.cGk = (Eu() + File.separator + this.iB[this.pu[i]]);
        locala.cGj = this.iC[this.pu[i]];
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QSec", 2, String.format("Add buildin: %d,%d,%d,%s", new Object[] { Integer.valueOf(locala.eok), Integer.valueOf(locala.mLibType), Integer.valueOf(locala.eol), locala.cGk }));
        }
        this.jdField_a_of_type_Asyx.a(locala, false);
        j = 1;
      }
      i += 4;
    }
    if (j != 0) {
      this.jdField_a_of_type_Asyx.aIO();
    }
  }
  
  private void esH()
  {
    if (this.dgH) {}
    do
    {
      return;
      this.dgH = true;
      esG();
      esF();
      esE();
    } while (!this.dgI);
    esI();
  }
  
  private void kL(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext())
    {
      aszd.a locala = (aszd.a)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Notify listener [%d:%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      locala.kK(paramInt1, paramInt2);
    }
  }
  
  private int kV(int paramInt)
  {
    int i = 0;
    while (i < this.pu.length)
    {
      if (paramInt == this.pu[(i + 1)]) {
        return i / 4;
      }
      i += 4;
    }
    return -1;
  }
  
  private void nu(List<Pair<Integer, Byte>> paramList)
  {
    if ((paramList == null) || (!this.dgH)) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (Pair)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("cb changed: id(%d), cb(%d)", new Object[] { ((Pair)localObject1).first, ((Pair)localObject1).second }));
      }
      Object localObject2 = (aszd.b)this.jG.get(((Pair)localObject1).first);
      if (localObject2 == null)
      {
        localObject2 = this.jdField_a_of_type_Asyx.b(((Integer)((Pair)localObject1).first).intValue());
        if (localObject2 != null) {
          if (((Byte)((Pair)localObject1).second).byteValue() == 1) {
            e(a((asyx.a)localObject2));
          } else if (((Byte)((Pair)localObject1).second).byteValue() == 2) {
            localLinkedList.add(localObject2);
          }
        }
      }
      else if (((Byte)((Pair)localObject1).second).byteValue() == 1)
      {
        if (((aszd.b)localObject2).eoo == 4)
        {
          c((aszd.b)localObject2);
          if (((aszd.b)localObject2).eon != 0) {
            this.jG.remove(Integer.valueOf(((aszd.b)localObject2).eok));
          }
          d((aszd.b)localObject2);
        }
      }
      else if ((((Byte)((Pair)localObject1).second).byteValue() == 2) && (((aszd.b)localObject2).eoo == 4))
      {
        this.jG.remove(((Pair)localObject1).first);
        localObject1 = this.jdField_a_of_type_Asyx.b(((Integer)((Pair)localObject1).first).intValue());
        if (localObject1 != null) {
          localLinkedList.add(localObject1);
        }
      }
    }
    if (!localLinkedList.isEmpty()) {
      nv(localLinkedList);
    }
    esD();
  }
  
  private void nv(List<asyx.a> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      asyx.a locala = (asyx.a)paramList.next();
      this.jdField_a_of_type_Asyx.cj(locala.eok, false);
      if (locala.cGk != null)
      {
        int i = kV(locala.eok);
        if (i != -1)
        {
          String str = Eu() + File.separator + this.iB[this.pu[i]];
          if (locala.cGk.equals(str)) {}
        }
        else
        {
          FileUtils.delete(locala.cGk);
        }
      }
    }
    this.jdField_a_of_type_Asyx.aIO();
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    aszd.b localb = (aszd.b)this.jG.get(Integer.valueOf(paramInt1));
    if (localb == null) {
      if (this.jdField_a_of_type_Asyx.b(paramInt1) == null) {
        paramInt2 = 4;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("dispatch to id: %d, cmd: %d, err: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) }));
      }
      return paramInt2;
      paramInt2 = 17;
      continue;
      if ((paramInt2 != 0) && (paramInt2 != localb.eop))
      {
        paramInt2 = 32;
      }
      else if (localb.eok != paramInt1)
      {
        paramInt2 = 5;
      }
      else
      {
        int i = this.jdField_a_of_type_Asyv.f(paramInt1);
        if ((1 != i) && ((i != -1) || (kV(paramInt1) == -1)))
        {
          paramInt2 = 6;
        }
        else if (localb.eoo != 1)
        {
          paramInt2 = 7;
        }
        else if (!localb.a.aIQ())
        {
          paramInt2 = 7;
        }
        else
        {
          paramInt2 = QSecFramework.b(4L, localb.eok, paramInt2, paramInt3, null, null, paramArrayOfObject1, paramArrayOfObject2);
          localb.a.release();
        }
      }
    }
  }
  
  public void b(aszd.a parama)
  {
    this.t.add(parama);
    this.mHandler.sendMessage(this.mHandler.obtainMessage(5, parama));
  }
  
  public void c(aszd.a parama)
  {
    this.t.remove(parama);
  }
  
  public void esI()
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
  }
  
  public void esJ()
  {
    if (!this.dgH) {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }
  }
  
  public static abstract interface a
  {
    public abstract void kK(int paramInt1, int paramInt2);
  }
  
  static class b
  {
    public aszn a;
    public String cGk = "";
    public int eok;
    public int eol;
    public int eon = -1;
    public int eoo;
    public int eop;
    public int mLibType;
    public String mVer = "";
  }
  
  class c
    extends Handler
  {
    public c(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          return;
          aszd.a(aszd.this);
          return;
        } while (paramMessage.obj == null);
        aszd.a(aszd.this, (List)paramMessage.obj);
        return;
        aszd.b(aszd.this);
        return;
        aszd.c(aszd.this);
        return;
      } while (paramMessage.obj == null);
      aszd.a(aszd.this, (aszd.a)paramMessage.obj);
    }
  }
  
  static class d
  {
    private aszd.e a;
    
    public d(aszd.e parame)
    {
      this.a = parame;
    }
    
    public void ZX(int paramInt)
    {
      label348:
      try
      {
        localObject1 = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject1 == null) {
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        Iterator localIterator1;
        localException.printStackTrace();
        return;
        return;
      }
      finally
      {
        if (this.a == null) {
          break label348;
        }
        this.a.esK();
      }
      localObject1 = new aszt((QQAppInterface)localObject1).l(1L);
      if (localObject1 != null)
      {
        localIterator1 = ((List)localObject1).iterator();
        while (localIterator1.hasNext())
        {
          localObject1 = (aszv.b)localIterator1.next();
          if ((((aszv.b)localObject1).businessId == paramInt) && (((aszv.b)localObject1).Ki != null))
          {
            Iterator localIterator2 = ((aszv.b)localObject1).Ki.iterator();
            while (localIterator2.hasNext())
            {
              Object localObject3 = (aszv.a)localIterator2.next();
              if (!TextUtils.isEmpty(((aszv.a)localObject3).extraInfo))
              {
                localObject1 = ((aszv.a)localObject3).cGr;
                if (!TextUtils.isEmpty(((aszv.a)localObject3).cGs)) {
                  localObject1 = ((aszv.a)localObject3).cGs;
                }
                if (localObject1 != null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("QQProtect.QSec", 2, String.format("ExtraInfo: %s path: %s", new Object[] { ((aszv.a)localObject3).extraInfo, localObject1 }));
                  }
                  localObject3 = new JSONObject(((aszv.a)localObject3).extraInfo);
                  int i = ((JSONObject)localObject3).getInt("id");
                  int j = ((JSONObject)localObject3).getInt("type");
                  int k = ((JSONObject)localObject3).getInt("flag");
                  int m = ((JSONObject)localObject3).getInt("mode");
                  localObject3 = ((JSONObject)localObject3).getString("ver");
                  if (this.a != null) {
                    this.a.b((String)localObject1, (String)localObject3, i, j, k, m);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  class e
  {
    protected boolean dgK;
    
    private e() {}
    
    public void b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (TextUtils.isEmpty(paramString2)) {}
      asyx.a locala2;
      do
      {
        return;
        locala2 = aszd.a(aszd.this).b(paramInt1);
      } while ((locala2 != null) && (paramString1.equals(locala2.cGk)) && (paramString2.equals(locala2.cGj)) && (paramInt2 == locala2.mLibType) && (paramInt3 == locala2.eol));
      asyx.a locala1;
      if (locala2 == null) {
        locala1 = new asyx.a();
      }
      for (;;)
      {
        locala1.eok = paramInt1;
        locala1.mLibType = paramInt2;
        locala1.eol = paramInt3;
        locala1.cGk = paramString1;
        locala1.cGj = paramString2;
        if (QLog.isColorLevel()) {
          QLog.d("QQProtect.QSec", 2, String.format("Add lost lib: %d,%d,%d,%s", new Object[] { Integer.valueOf(locala1.eok), Integer.valueOf(locala1.mLibType), Integer.valueOf(locala1.eol), locala1.cGk }));
        }
        aszd.a(aszd.this).a(locala1, false);
        this.dgK = true;
        return;
        aszd.a(aszd.this).cj(paramInt1, false);
        locala1 = locala2;
        if (QLog.isColorLevel())
        {
          QLog.d("QQProtect.QSec", 2, String.format("Database info mismatch for lib: %d", new Object[] { Integer.valueOf(paramInt1) }));
          locala1 = locala2;
        }
      }
    }
    
    public void esK()
    {
      if (this.dgK) {
        aszd.a(aszd.this).aIO();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aszd
 * JD-Core Version:    0.7.0.1
 */