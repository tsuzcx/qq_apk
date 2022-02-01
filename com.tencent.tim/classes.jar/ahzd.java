import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicManager.1;
import com.tencent.mobileqq.hotpic.HotPicManager.2;
import com.tencent.mobileqq.hotpic.HotPicManager.5;
import com.tencent.mobileqq.hotpic.HotPicSendData;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.pb.hotpicmsg.HotPicMsg.GetImgInfoReq;
import com.tencent.pb.hotpicmsg.HotPicMsg.GetVideoInfoReq;
import com.tencent.pb.hotpicmsg.HotPicMsg.ReqBody;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;

public class ahzd
  implements Handler.Callback, Manager
{
  private List<HotPicTagInfo> Co = new ArrayList();
  private List<HotPicTagInfo> Cp = new ArrayList();
  private LinkedList<HotPicSendData> U = new LinkedList();
  ahzd.b jdField_a_of_type_Ahzd$b;
  private aiaa jdField_a_of_type_Aiaa;
  private SparseArray<ArrayList<HotPicData>> cJ = new SparseArray();
  private SparseArray<ArrayList<HotPicData>> cK = new SparseArray();
  public boolean cjg = false;
  boolean cjh = false;
  boolean cji = false;
  boolean cjj = false;
  private boolean cjk;
  private boolean cjl;
  Set<Integer> cz = new HashSet();
  public int dcz;
  Object ea = new Object();
  private EntityManager em;
  private auru i = new auru(ThreadManager.getFileThreadLooper(), this);
  public QQAppInterface mApp;
  volatile boolean mInited = false;
  
  public ahzd(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public static int P(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("sp_hotpic_" + paramQQAppInterface.getCurrentUin(), 0).getInt("k_hotlist_config_v", 0);
  }
  
  private void W(List<HotPicTagInfo> paramList, int paramInt)
  {
    HotPicTagInfo localHotPicTagInfo = new HotPicTagInfo();
    localHotPicTagInfo.tagName = this.mApp.getApp().getString(2131701269);
    localHotPicTagInfo.version = paramInt;
    localHotPicTagInfo.tagId = 2;
    localHotPicTagInfo.tagType = 1;
    localHotPicTagInfo.position = 0;
    paramList.add(localHotPicTagInfo);
    localHotPicTagInfo = new HotPicTagInfo();
    localHotPicTagInfo.tagName = this.mApp.getApp().getString(2131701270);
    localHotPicTagInfo.version = paramInt;
    localHotPicTagInfo.tagId = -20;
    localHotPicTagInfo.tagType = 255;
    localHotPicTagInfo.position = 1;
    paramList.add(localHotPicTagInfo);
  }
  
  public static ahzd a(QQAppInterface paramQQAppInterface)
  {
    return (ahzd)paramQQAppInterface.getManager(206);
  }
  
  public static ArrayList<HotVideoData> ai(ArrayList<HotPicData> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      HotPicData localHotPicData = (HotPicData)paramArrayList.next();
      if (localHotPicData.getDataType() == 2) {
        localArrayList.add((HotVideoData)localHotPicData);
      }
    }
    return localArrayList;
  }
  
  private void ar(List<HotVideoData> paramList, boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotPicManager", 2, "updateHotVideoData " + paramBoolean);
      }
      if (paramBoolean) {
        this.em.drop(HotVideoData.class);
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        HotPicData localHotPicData = (HotPicData)localIterator.next();
        this.em.persistOrReplace(localHotPicData);
        if (QLog.isColorLevel()) {
          QLog.i("HotPicManager", 2, "updateHotVideoData " + localHotPicData.toString());
        }
      }
      if (!QLog.isColorLevel()) {
        break label162;
      }
    }
    finally {}
    QLog.i("HotPicManager", 2, "updateHotVideoData size:" + paramList.size());
    label162:
  }
  
  /* Error */
  private void as(List<HotPicData> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 228
    //   10: iconst_2
    //   11: new 115	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 262
    //   21: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 236	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: iload_2
    //   35: ifeq +13 -> 48
    //   38: aload_0
    //   39: getfield 193	ahzd:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   42: ldc 211
    //   44: invokevirtual 242	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   47: pop
    //   48: aload_0
    //   49: getfield 193	ahzd:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   52: invokevirtual 266	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   55: astore_3
    //   56: aload_3
    //   57: invokevirtual 271	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   60: aload_1
    //   61: invokeinterface 243 1 0
    //   66: astore_1
    //   67: aload_1
    //   68: invokeinterface 205 1 0
    //   73: ifeq +38 -> 111
    //   76: aload_1
    //   77: invokeinterface 209 1 0
    //   82: checkcast 211	com/tencent/mobileqq/hotpic/HotPicData
    //   85: astore 4
    //   87: aload_0
    //   88: getfield 193	ahzd:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   91: aload 4
    //   93: invokevirtual 247	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   96: goto -29 -> 67
    //   99: astore_1
    //   100: aload_1
    //   101: invokevirtual 274	java/lang/Exception:printStackTrace	()V
    //   104: aload_3
    //   105: invokevirtual 277	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   108: aload_0
    //   109: monitorexit
    //   110: return
    //   111: aload_3
    //   112: invokevirtual 280	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   115: aload_3
    //   116: invokevirtual 277	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   119: goto -11 -> 108
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    //   127: astore_1
    //   128: aload_3
    //   129: invokevirtual 277	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	ahzd
    //   0	134	1	paramList	List<HotPicData>
    //   0	134	2	paramBoolean	boolean
    //   55	74	3	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   85	7	4	localHotPicData	HotPicData
    // Exception table:
    //   from	to	target	type
    //   56	67	99	java/lang/Exception
    //   67	96	99	java/lang/Exception
    //   111	115	99	java/lang/Exception
    //   2	34	122	finally
    //   38	48	122	finally
    //   48	56	122	finally
    //   104	108	122	finally
    //   115	119	122	finally
    //   128	134	122	finally
    //   56	67	127	finally
    //   67	96	127	finally
    //   100	104	127	finally
    //   111	115	127	finally
  }
  
  /* Error */
  private void drg()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 100	ahzd:cjj	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 100	ahzd:cjj	Z
    //   19: new 284	java/io/File
    //   22: dup
    //   23: getstatic 289	ahyv:bMr	Ljava/lang/String;
    //   26: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore 4
    //   31: aload 4
    //   33: invokevirtual 296	java/io/File:listFiles	()[Ljava/io/File;
    //   36: astore_3
    //   37: aload 4
    //   39: invokevirtual 299	java/io/File:exists	()Z
    //   42: ifeq -31 -> 11
    //   45: aload 4
    //   47: invokevirtual 302	java/io/File:isDirectory	()Z
    //   50: ifeq -39 -> 11
    //   53: aload_3
    //   54: arraylength
    //   55: istore_1
    //   56: iload_1
    //   57: sipush 500
    //   60: if_icmple -49 -> 11
    //   63: aload_3
    //   64: new 10	ahzd$a
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 305	ahzd$a:<init>	(Lahzd;)V
    //   72: invokestatic 311	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
    //   75: new 59	java/util/HashSet
    //   78: dup
    //   79: invokespecial 60	java/util/HashSet:<init>	()V
    //   82: astore 4
    //   84: aload_0
    //   85: getfield 98	ahzd:U	Ljava/util/LinkedList;
    //   88: invokevirtual 314	java/util/LinkedList:clone	()Ljava/lang/Object;
    //   91: checkcast 95	java/util/LinkedList
    //   94: invokeinterface 243 1 0
    //   99: astore 5
    //   101: aload 5
    //   103: invokeinterface 205 1 0
    //   108: ifeq +64 -> 172
    //   111: aload 5
    //   113: invokeinterface 209 1 0
    //   118: checkcast 211	com/tencent/mobileqq/hotpic/HotPicData
    //   121: getfield 317	com/tencent/mobileqq/hotpic/HotPicData:url	Ljava/lang/String;
    //   124: invokestatic 321	ahyv:f	(Ljava/lang/String;)Ljava/io/File;
    //   127: astore 6
    //   129: aload 6
    //   131: ifnull -30 -> 101
    //   134: aload 4
    //   136: aload 6
    //   138: invokeinterface 324 2 0
    //   143: pop
    //   144: goto -43 -> 101
    //   147: astore_3
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_3
    //   151: athrow
    //   152: astore 4
    //   154: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq -82 -> 75
    //   160: ldc 228
    //   162: iconst_2
    //   163: ldc_w 326
    //   166: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: goto -94 -> 75
    //   172: new 88	java/util/ArrayList
    //   175: dup
    //   176: invokespecial 89	java/util/ArrayList:<init>	()V
    //   179: astore 5
    //   181: sipush 500
    //   184: istore_1
    //   185: iload_1
    //   186: aload_3
    //   187: arraylength
    //   188: if_icmpge +46 -> 234
    //   191: aload_3
    //   192: iload_1
    //   193: aaload
    //   194: astore 6
    //   196: aload 4
    //   198: aload 6
    //   200: invokeinterface 332 2 0
    //   205: ifeq +16 -> 221
    //   208: aload 4
    //   210: aload 6
    //   212: invokeinterface 335 2 0
    //   217: pop
    //   218: goto +87 -> 305
    //   221: aload 5
    //   223: aload 6
    //   225: invokeinterface 181 2 0
    //   230: pop
    //   231: goto +74 -> 305
    //   234: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +35 -> 272
    //   240: ldc 228
    //   242: iconst_2
    //   243: new 115	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 337
    //   253: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload 5
    //   258: invokeinterface 253 1 0
    //   263: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload 5
    //   274: invokeinterface 243 1 0
    //   279: astore_3
    //   280: aload_3
    //   281: invokeinterface 205 1 0
    //   286: ifeq -275 -> 11
    //   289: aload_3
    //   290: invokeinterface 209 1 0
    //   295: checkcast 284	java/io/File
    //   298: invokevirtual 340	java/io/File:delete	()Z
    //   301: pop
    //   302: goto -22 -> 280
    //   305: iload_1
    //   306: iconst_1
    //   307: iadd
    //   308: istore_1
    //   309: goto -124 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	ahzd
    //   55	254	1	j	int
    //   6	2	2	bool	boolean
    //   36	28	3	arrayOfFile	File[]
    //   147	45	3	localObject1	Object
    //   279	11	3	localIterator	Iterator
    //   29	106	4	localObject2	Object
    //   152	57	4	localException	Exception
    //   99	174	5	localObject3	Object
    //   127	97	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   2	7	147	finally
    //   14	56	147	finally
    //   63	75	147	finally
    //   75	101	147	finally
    //   101	129	147	finally
    //   134	144	147	finally
    //   154	169	147	finally
    //   172	181	147	finally
    //   185	191	147	finally
    //   196	218	147	finally
    //   221	231	147	finally
    //   234	272	147	finally
    //   272	280	147	finally
    //   280	302	147	finally
    //   63	75	152	java/lang/Exception
  }
  
  private void ew(ArrayList<HotPicTagInfo> paramArrayList)
  {
    try
    {
      this.em.drop(HotPicTagInfo.class);
      paramArrayList = ((ArrayList)paramArrayList.clone()).iterator();
      while (paramArrayList.hasNext())
      {
        HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)paramArrayList.next();
        this.em.persistOrReplace(localHotPicTagInfo);
      }
    }
    finally {}
  }
  
  public int Fs()
  {
    return this.mApp.getApplication().getSharedPreferences("sp_hotpic_" + this.mApp.getCurrentUin(), 0).getInt("hot_pic_last_click", -1);
  }
  
  public int Ft()
  {
    synchronized (this.ea)
    {
      Iterator localIterator = this.Co.iterator();
      while (localIterator.hasNext())
      {
        int j = ((HotPicTagInfo)localIterator.next()).version;
        if (j != 0) {
          return j;
        }
      }
      return 0;
    }
  }
  
  public void KK(boolean paramBoolean)
  {
    this.cjk = paramBoolean;
  }
  
  /* Error */
  public void PA(int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 104	ahzd:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: invokevirtual 113	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   11: new 115	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   18: ldc 118
    //   20: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 104	ahzd:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 126	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   30: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: iconst_0
    //   37: invokevirtual 135	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   40: astore 4
    //   42: aload 4
    //   44: ldc_w 356
    //   47: iconst_0
    //   48: invokeinterface 360 3 0
    //   53: istore_3
    //   54: iload_1
    //   55: iconst_1
    //   56: if_icmpne +88 -> 144
    //   59: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +39 -> 101
    //   65: ldc 228
    //   67: iconst_1
    //   68: new 115	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 362
    //   78: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: iload_2
    //   82: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   85: ldc_w 364
    //   88: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: iload_3
    //   92: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   95: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 236	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: iload_2
    //   102: iload_3
    //   103: if_icmpeq +38 -> 141
    //   106: aload_0
    //   107: iload_2
    //   108: putfield 64	ahzd:cjh	Z
    //   111: aload 4
    //   113: invokeinterface 368 1 0
    //   118: ldc_w 370
    //   121: iload_2
    //   122: invokeinterface 376 3 0
    //   127: invokeinterface 378 1 0
    //   132: pop
    //   133: iload_2
    //   134: ifeq +7 -> 141
    //   137: aload_0
    //   138: invokevirtual 381	ahzd:drc	()V
    //   141: aload_0
    //   142: monitorexit
    //   143: return
    //   144: iconst_0
    //   145: istore_2
    //   146: goto -87 -> 59
    //   149: astore 4
    //   151: aload_0
    //   152: monitorexit
    //   153: aload 4
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	ahzd
    //   0	156	1	paramInt	int
    //   1	145	2	bool1	boolean
    //   53	51	3	bool2	boolean
    //   40	72	4	localSharedPreferences	SharedPreferences
    //   149	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	54	149	finally
    //   59	101	149	finally
    //   106	133	149	finally
    //   137	141	149	finally
  }
  
  public void Pz(int paramInt)
  {
    Iterator localIterator = this.Co.iterator();
    HotPicTagInfo localHotPicTagInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
    } while ((localHotPicTagInfo.tagId != paramInt) || (localHotPicTagInfo.tagType != 2));
    for (int j = 10003;; j = 10002)
    {
      ip(j, paramInt);
      return;
    }
  }
  
  public LinkedList<HotPicSendData> a()
  {
    return this.U;
  }
  
  public void a(ahzd.b paramb)
  {
    this.jdField_a_of_type_Ahzd$b = paramb;
  }
  
  public boolean aoA()
  {
    boolean bool = false;
    int j;
    if (this.Cp.size() > 0)
    {
      synchronized (this.ea)
      {
        this.Co.clear();
        this.cJ.clear();
        Iterator localIterator = this.Cp.iterator();
        if (localIterator.hasNext())
        {
          Object localObject1 = (HotPicTagInfo)localIterator.next();
          j = ((HotPicTagInfo)localObject1).tagId;
          this.Co.add(localObject1);
          ArrayList localArrayList = (ArrayList)this.cK.get(j);
          SparseArray localSparseArray = this.cJ;
          localObject1 = localArrayList;
          if (localArrayList == null) {
            localObject1 = new ArrayList();
          }
          localSparseArray.put(j, localObject1);
        }
      }
      if (QLog.isColorLevel()) {
        if ("update NewVersionTagInfo" + this.Cp.get(0) != null) {
          break label232;
        }
      }
    }
    for (Object localObject3 = "null";; localObject3 = Integer.valueOf(j))
    {
      QLog.d("HotPicManager", 2, new Object[] { localObject3 });
      this.cK.clear();
      this.Cp.clear();
      this.cjj = true;
      this.i.sendEmptyMessage(101);
      bool = true;
      return bool;
      label232:
      j = ((HotPicTagInfo)this.Cp.get(0)).version;
    }
  }
  
  public boolean aoB()
  {
    if ((!this.cjh) && (!this.cji))
    {
      this.cjh = this.mApp.getApplication().getSharedPreferences("sp_hotpic_" + this.mApp.getCurrentUin(), 0).getBoolean("k_hotlist_s_e", false);
      this.cji = true;
    }
    return this.cjh;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    int k = 1;
    int j = 1;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager", 2, "requestHotPicList " + paramInt1 + "-" + paramInt2 + " version= " + paramInt3 + " tag= " + paramInt4 + " checkUpdate" + paramBoolean + " reqType= " + paramInt5);
        }
        Object localObject1 = new HotPicMsg.ReqBody();
        if (paramInt5 == 10003)
        {
          localObject3 = new HotPicMsg.GetVideoInfoReq();
          ((HotPicMsg.ReqBody)localObject1).setHasFlag(true);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint64_src_uin.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_src_term.set(3);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_start_video_index.set(paramInt1);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_end_video_index.set(paramInt2);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_build_ver.set(paramInt3);
          ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_tag_id.set(paramInt4);
          ((HotPicMsg.GetVideoInfoReq)localObject3).bytes_client_ver.set(ByteStringMicro.copyFromUtf8("3.4.4"));
          localObject4 = ((HotPicMsg.GetVideoInfoReq)localObject3).uint32_need_update;
          if (paramBoolean)
          {
            paramInt1 = j;
            ((PBUInt32Field)localObject4).set(paramInt1);
            localObject4 = this.mApp.getCurrentAccountUin() + SystemClock.uptimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("HotPicManager", 2, "sessionId:" + (String)localObject4);
            }
            ((HotPicMsg.GetVideoInfoReq)localObject3).bytes_session_id.set(ByteStringMicro.copyFromUtf8((String)localObject4));
            ((HotPicMsg.ReqBody)localObject1).msg_get_videoinfo_req.set((MessageMicro)localObject3);
            localObject1 = ((HotPicMsg.ReqBody)localObject1).toByteArray();
            localObject3 = ByteBuffer.allocate(localObject1.length + 4);
            ((ByteBuffer)localObject3).putInt(localObject1.length + 4).put((byte[])localObject1);
            localObject1 = ((ByteBuffer)localObject3).array();
            localObject3 = new NewIntent(this.mApp.getApp(), ahzm.class);
            ((NewIntent)localObject3).putExtra("key_body", (byte[])localObject1);
            ((NewIntent)localObject3).putExtra("key_cmd", "ImagePopular.GetInfo");
            ((NewIntent)localObject3).putExtra("REQUEST_CHECK_UPDATE", paramBoolean);
            ((NewIntent)localObject3).putExtra("REQUEST_TAG", paramInt4);
            if (paramBoolean) {
              paramInt5 = 10001;
            }
            ((NewIntent)localObject3).putExtra("REQUEST_TYPE", paramInt5);
            ((NewIntent)localObject3).putExtra("REQUEST_VERSION", paramInt3);
            this.mApp.startServlet((NewIntent)localObject3);
            return;
          }
          paramInt1 = 0;
          continue;
        }
        Object localObject3 = new HotPicMsg.GetImgInfoReq();
        ((HotPicMsg.ReqBody)localObject1).setHasFlag(true);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint64_src_uin.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_src_term.set(3);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_start_pic_index.set(paramInt1);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_end_pic_index.set(paramInt2);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_build_ver.set(paramInt3);
        ((HotPicMsg.GetImgInfoReq)localObject3).uint32_pic_tag.set(paramInt4);
        ((HotPicMsg.GetImgInfoReq)localObject3).bytes_client_ver.set(ByteStringMicro.copyFromUtf8("3.4.4"));
        Object localObject4 = ((HotPicMsg.GetImgInfoReq)localObject3).uint32_need_update;
        if (paramBoolean)
        {
          paramInt1 = k;
          ((PBUInt32Field)localObject4).set(paramInt1);
          localObject4 = this.mApp.getCurrentAccountUin() + SystemClock.uptimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("HotPicManager", 2, "sessionId:" + (String)localObject4);
          }
          ((HotPicMsg.GetImgInfoReq)localObject3).bytes_session_id.set(ByteStringMicro.copyFromUtf8((String)localObject4));
          ((HotPicMsg.ReqBody)localObject1).msg_get_imginfo_req.set((MessageMicro)localObject3);
        }
        else
        {
          paramInt1 = 0;
        }
      }
      finally {}
    }
  }
  
  public void b(HotPicTagInfo paramHotPicTagInfo)
  {
    int j = paramHotPicTagInfo.tagId;
    if ((aoA()) || (this.cjl))
    {
      this.cjl = false;
      if (j != -20) {
        ip(10001, paramHotPicTagInfo.tagId);
      }
    }
    this.dcz = j;
    ThreadManager.post(new HotPicManager.5(this, j), 5, null, false);
  }
  
  public void d(HotPicData paramHotPicData)
  {
    int j = 0;
    if (j < this.U.size()) {
      if (!((HotPicSendData)this.U.get(j)).md5.equals(paramHotPicData.md5)) {}
    }
    for (;;)
    {
      if (j >= 0) {
        this.U.remove(j);
      }
      HotPicSendData localHotPicSendData1;
      if ((paramHotPicData instanceof HotPicSendData))
      {
        localHotPicSendData1 = (HotPicSendData)paramHotPicData;
        label62:
        localHotPicSendData1.sendTime = NetConnInfoCenter.getServerTime();
        this.U.addFirst(localHotPicSendData1);
        if (this.U.size() <= 500) {
          break label173;
        }
      }
      label173:
      for (HotPicSendData localHotPicSendData2 = (HotPicSendData)this.U.removeLast();; localHotPicSendData2 = null)
      {
        if (this.jdField_a_of_type_Ahzd$b != null) {
          this.jdField_a_of_type_Ahzd$b.aQ(8, -20, 0);
        }
        ThreadManager.post(new HotPicManager.1(this, localHotPicSendData1, localHotPicSendData2), 5, null, false);
        if (this.jdField_a_of_type_Aiaa != null) {
          this.jdField_a_of_type_Aiaa.a(paramHotPicData);
        }
        return;
        j += 1;
        break;
        localHotPicSendData1 = HotPicSendData.build(paramHotPicData);
        break label62;
      }
      j = -1;
    }
  }
  
  public ArrayList<HotPicTagInfo> di()
  {
    return (ArrayList)this.Co;
  }
  
  public void drb()
  {
    for (;;)
    {
      int k;
      try
      {
        if (!this.mInited)
        {
          this.mInited = true;
          Object localObject1 = this.mApp.getApplication().getSharedPreferences("sp_hotpic_" + this.mApp.getCurrentUin(), 0);
          this.cjg = ((SharedPreferences)localObject1).getBoolean("k_hotlist_f", true);
          this.cjh = ((SharedPreferences)localObject1).getBoolean("k_hotlist_s_e", false);
          this.em = this.mApp.a().createEntityManager();
          try
          {
            this.Co = ((ArrayList)this.em.query(HotPicTagInfo.class, true, null, null, null, null, "position asc", null));
            if (this.Co == null)
            {
              this.Co = new ArrayList();
              W(this.Co, 0);
            }
            Iterator localIterator = this.Co.iterator();
            if (!localIterator.hasNext()) {
              break label416;
            }
            HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
            int j = localHotPicTagInfo.tagType;
            if (j == 255) {
              continue;
            }
            k = localHotPicTagInfo.tagId;
            localObject1 = new String[1];
            localObject1[0] = String.valueOf(k);
            if (j != 2) {
              continue;
            }
            localArrayList2 = (ArrayList)this.em.query(HotVideoData.class, true, "tag = ?", (String[])localObject1, null, null, "picIndex asc", null);
            localObject1 = localArrayList2;
            if (localArrayList2 == null) {
              localObject1 = new ArrayList();
            }
            localArrayList2 = new ArrayList();
            localArrayList2.addAll((Collection)localObject1);
            this.cJ.put(k, localArrayList2);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("HotPicManager", 2, "makesureInit localTagInfo name is " + localHotPicTagInfo.tagName);
            continue;
            if (localObject2 == null) {
              continue;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            localObject2 = null;
          }
          Collections.sort((List)localObject2, Collections.reverseOrder());
          this.U.addAll((Collection)localObject2);
          this.dcz = Fs();
        }
        return;
      }
      finally {}
      ArrayList localArrayList2 = (ArrayList)this.em.query(HotPicData.class, true, "tag = ?", (String[])localObject2, null, null, "picIndex asc", null);
      Object localObject2 = localArrayList2;
      if (localArrayList2 == null) {
        localObject2 = new ArrayList();
      }
      this.cJ.put(k, localObject2);
      continue;
      label416:
      ArrayList localArrayList1 = (ArrayList)this.em.query(HotPicSendData.class, true, null, null, null, null, null, null);
    }
  }
  
  public void drc()
  {
    if (!this.cjh) {}
    do
    {
      return;
      drb();
      if (this.dcz != -1)
      {
        if (this.dcz != -20)
        {
          ip(10001, this.dcz);
          return;
        }
        ip(10001, 2);
        return;
      }
    } while (!this.cjg);
    ip(10001, 2);
  }
  
  public void drd()
  {
    this.cz.clear();
    this.i.sendEmptyMessage(102);
    this.i.sendEmptyMessageDelayed(103, 10000L);
  }
  
  /* Error */
  public void dre()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 611	ahzd:aoA	()Z
    //   6: ifne +31 -> 37
    //   9: aload_0
    //   10: getfield 352	ahzd:cjk	Z
    //   13: ifne +12 -> 25
    //   16: aload_0
    //   17: invokevirtual 381	ahzd:drc	()V
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 352	ahzd:cjk	Z
    //   25: aload_0
    //   26: getfield 79	ahzd:i	Lauru;
    //   29: bipush 103
    //   31: invokevirtual 734	auru:removeMessages	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 613	ahzd:cjl	Z
    //   42: goto -17 -> 25
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	ahzd
    //   45	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	45	finally
    //   25	34	45	finally
    //   37	42	45	finally
  }
  
  public void drf()
  {
    if (this.cjg)
    {
      this.cjg = false;
      this.mApp.getApplication().getSharedPreferences("sp_hotpic_" + this.mApp.getCurrentUin(), 0).edit().putBoolean("k_hotlist_f", false).commit();
    }
  }
  
  List<HotPicData> fl()
  {
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    if (j < this.cJ.size())
    {
      if (kb(this.cJ.keyAt(j))) {}
      for (;;)
      {
        j += 1;
        break;
        ArrayList localArrayList2 = (ArrayList)this.cJ.valueAt(j);
        if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
          localArrayList1.addAll(localArrayList2);
        }
      }
    }
    return localArrayList1;
  }
  
  List<HotVideoData> fm()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Co.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (HotPicTagInfo)localIterator.next();
      if (((HotPicTagInfo)localObject).tagType == 2)
      {
        localObject = (ArrayList)this.cJ.get(((HotPicTagInfo)localObject).tagId);
        if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
          localArrayList.addAll(ai((ArrayList)localObject));
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (HotVideoData)localIterator.next();
        QLog.d("HotPicManager", 2, "getAllHotVideoDatas item:" + ((HotVideoData)localObject).toString());
      }
      QLog.d("HotPicManager", 2, "getAllHotVideoDatas size:" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    if (j == 101)
    {
      ew(di());
      as(fl(), true);
      ar(fm(), true);
      return true;
    }
    if (j == 104)
    {
      ew(di());
      return false;
    }
    if (j == 102)
    {
      drg();
      return false;
    }
    if ((j == 103) && (this.jdField_a_of_type_Ahzd$b == null)) {
      paramMessage = fl().iterator();
    }
    for (;;)
    {
      Object localObject;
      if (paramMessage.hasNext())
      {
        localObject = (HotPicData)paramMessage.next();
        if (this.jdField_a_of_type_Ahzd$b == null) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager", 2, "clear urldrawable cache");
        }
        return false;
      }
      try
      {
        if (((HotPicData)localObject).getDataType() == 2)
        {
          localObject = ahzs.a((HotVideoData)localObject);
          if (localObject != null) {
            URLDrawable.removeMemoryCacheByUrl(((URL)localObject).toString());
          }
        }
        else
        {
          URLDrawable.removeMemoryCacheByUrl(ahyv.getURL(((HotPicData)localObject).url).toString());
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void ip(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new HotPicManager.2(this, paramInt1, paramInt2), 8, null, false);
  }
  
  public boolean kb(int paramInt)
  {
    if (this.Co == null) {
      return false;
    }
    Iterator localIterator = this.Co.iterator();
    HotPicTagInfo localHotPicTagInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localHotPicTagInfo = (HotPicTagInfo)localIterator.next();
    } while ((localHotPicTagInfo.tagId != paramInt) || (localHotPicTagInfo.tagType != 2));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  /* Error */
  public boolean kc(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 84	ahzd:cJ	Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual 400	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   10: checkcast 88	java/util/ArrayList
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +18 -> 33
    //   18: aload_3
    //   19: invokevirtual 749	java/util/ArrayList:size	()I
    //   22: istore_1
    //   23: iload_1
    //   24: ifle +9 -> 33
    //   27: iconst_1
    //   28: istore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_2
    //   35: goto -6 -> 29
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	ahzd
    //   0	43	1	paramInt	int
    //   28	7	2	bool	boolean
    //   13	6	3	localArrayList	ArrayList
    //   38	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	38	finally
    //   18	23	38	finally
  }
  
  public boolean kd(int paramInt)
  {
    return this.cz.contains(Integer.valueOf(paramInt));
  }
  
  public void onDestroy()
  {
    if (this.em != null) {
      this.em.close();
    }
  }
  
  public ArrayList<HotPicData> r(int paramInt)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        Object localObject1 = (ArrayList)this.cJ.get(paramInt);
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          return localObject1;
        }
        localArrayList = (ArrayList)((ArrayList)localObject1).clone();
        localObject1 = localArrayList;
        if (!kb(paramInt)) {
          continue;
        }
        localObject1 = localArrayList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          HotPicData localHotPicData = (HotPicData)((Iterator)localObject1).next();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("HotPicManager", 2, "getHotPics IsVideo " + localHotPicData.toString());
          continue;
        }
        localObject3 = localArrayList;
      }
      finally {}
      Object localObject3;
      if (QLog.isColorLevel())
      {
        QLog.d("HotPicManager", 2, "getHotPics IsVideo size:" + localArrayList.size());
        localObject3 = localArrayList;
      }
    }
  }
  
  /* Error */
  public void r(android.content.Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 13
    //   5: aload_1
    //   6: ldc_w 581
    //   9: iconst_m1
    //   10: invokevirtual 825	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   13: istore 4
    //   15: aload_1
    //   16: ldc_w 574
    //   19: iconst_m1
    //   20: invokevirtual 825	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   23: istore 8
    //   25: aload_0
    //   26: invokevirtual 827	ahzd:Ft	()I
    //   29: istore_3
    //   30: aload_1
    //   31: ldc_w 569
    //   34: iconst_0
    //   35: invokevirtual 830	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   38: istore 10
    //   40: aload_1
    //   41: ldc_w 579
    //   44: iconst_m1
    //   45: invokevirtual 825	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   48: istore 5
    //   50: iload 5
    //   52: sipush 10003
    //   55: if_icmpne +844 -> 899
    //   58: iconst_1
    //   59: istore 9
    //   61: iload 5
    //   63: sipush 10001
    //   66: if_icmpne +2558 -> 2624
    //   69: aload_0
    //   70: iload 8
    //   72: invokevirtual 745	ahzd:kb	(I)Z
    //   75: istore 9
    //   77: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +73 -> 153
    //   83: ldc 228
    //   85: iconst_2
    //   86: new 115	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 832
    //   96: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: iload 4
    //   101: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: ldc_w 834
    //   107: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload 8
    //   112: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: ldc_w 836
    //   118: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_3
    //   122: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: ldc_w 838
    //   128: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: iload 10
    //   133: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   136: ldc_w 840
    //   139: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: iload 5
    //   144: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_2
    //   154: invokevirtual 845	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   157: sipush 1000
    //   160: if_icmpne +1803 -> 1963
    //   163: aload_2
    //   164: invokevirtual 848	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   167: arraylength
    //   168: iconst_4
    //   169: isub
    //   170: istore 5
    //   172: iload 5
    //   174: newarray byte
    //   176: astore_1
    //   177: aload_1
    //   178: iconst_0
    //   179: aload_2
    //   180: invokevirtual 848	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   183: iconst_4
    //   184: iload 5
    //   186: invokestatic 854	aqoj:copyData	([BI[BII)V
    //   189: aload_2
    //   190: aload_1
    //   191: invokevirtual 858	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   194: aload_2
    //   195: invokevirtual 848	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   198: astore_1
    //   199: new 860	com/tencent/pb/hotpicmsg/HotPicMsg$RspBody
    //   202: dup
    //   203: invokespecial 861	com/tencent/pb/hotpicmsg/HotPicMsg$RspBody:<init>	()V
    //   206: astore_2
    //   207: aload_2
    //   208: aload_1
    //   209: invokevirtual 865	com/tencent/pb/hotpicmsg/HotPicMsg$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   212: pop
    //   213: iload 9
    //   215: ifeq +690 -> 905
    //   218: aload_2
    //   219: getfield 869	com/tencent/pb/hotpicmsg/HotPicMsg$RspBody:msg_get_videoinfo_rsp	Lcom/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp;
    //   222: invokevirtual 874	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   225: checkcast 871	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp
    //   228: astore 11
    //   230: aconst_null
    //   231: astore 12
    //   233: aload 12
    //   235: ifnull +27 -> 262
    //   238: aload 12
    //   240: getfield 880	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:int32_result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   243: invokevirtual 884	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   246: ifeq +45 -> 291
    //   249: aload 12
    //   251: getfield 880	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:int32_result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   254: invokevirtual 884	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   257: bipush 251
    //   259: if_icmpeq +32 -> 291
    //   262: aload 11
    //   264: ifnull +1584 -> 1848
    //   267: aload 11
    //   269: getfield 885	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:int32_result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   272: invokevirtual 884	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   275: ifeq +16 -> 291
    //   278: aload 11
    //   280: getfield 885	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:int32_result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   283: invokevirtual 884	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   286: bipush 251
    //   288: if_icmpne +1560 -> 1848
    //   291: aconst_null
    //   292: astore_2
    //   293: aconst_null
    //   294: astore_1
    //   295: iload 9
    //   297: ifeq +626 -> 923
    //   300: aload 11
    //   302: getfield 886	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:uint32_build_ver	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   305: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   308: istore 5
    //   310: iload 5
    //   312: istore 4
    //   314: iload 4
    //   316: istore 6
    //   318: iload_3
    //   319: istore 7
    //   321: aload 11
    //   323: getfield 891	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:rpt_msg_tag_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   326: invokevirtual 896	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   329: ifeq +19 -> 348
    //   332: iload 4
    //   334: istore 6
    //   336: iload_3
    //   337: istore 7
    //   339: aload 11
    //   341: getfield 891	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:rpt_msg_tag_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   344: invokevirtual 898	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   347: astore_1
    //   348: iload 4
    //   350: istore 6
    //   352: iload_3
    //   353: istore 7
    //   355: aload_1
    //   356: astore_2
    //   357: iload 4
    //   359: istore 5
    //   361: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq +685 -> 1049
    //   367: iload 4
    //   369: istore 6
    //   371: iload_3
    //   372: istore 7
    //   374: ldc 228
    //   376: iconst_2
    //   377: new 115	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 900
    //   387: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: iload 4
    //   392: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: ldc_w 902
    //   398: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload 11
    //   403: getfield 885	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:int32_result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   406: invokevirtual 884	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   409: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   412: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: iload_3
    //   419: istore 5
    //   421: iload 10
    //   423: ifeq +683 -> 1106
    //   426: iload_3
    //   427: istore 5
    //   429: aload_1
    //   430: ifnull +676 -> 1106
    //   433: iload 4
    //   435: istore 6
    //   437: iload_3
    //   438: istore 7
    //   440: iload_3
    //   441: istore 5
    //   443: aload_1
    //   444: invokeinterface 253 1 0
    //   449: ifle +657 -> 1106
    //   452: iload 4
    //   454: istore 6
    //   456: iload_3
    //   457: istore 7
    //   459: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq +62 -> 524
    //   465: iload 4
    //   467: istore 6
    //   469: iload_3
    //   470: istore 7
    //   472: ldc 228
    //   474: iconst_2
    //   475: new 115	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   482: ldc_w 904
    //   485: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: iload_3
    //   489: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   492: ldc_w 906
    //   495: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: iload 4
    //   500: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: ldc_w 908
    //   506: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload_1
    //   510: invokeinterface 253 1 0
    //   515: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   518: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: iload 4
    //   526: istore 6
    //   528: iload_3
    //   529: istore 7
    //   531: aload_0
    //   532: getfield 102	ahzd:ea	Ljava/lang/Object;
    //   535: astore 14
    //   537: iload 4
    //   539: istore 6
    //   541: iload_3
    //   542: istore 7
    //   544: aload 14
    //   546: monitorenter
    //   547: iload_3
    //   548: ifne +510 -> 1058
    //   551: iload_3
    //   552: istore 7
    //   554: aload_0
    //   555: getfield 91	ahzd:Co	Ljava/util/List;
    //   558: astore_2
    //   559: iconst_1
    //   560: istore 6
    //   562: iload 4
    //   564: istore_3
    //   565: iload_3
    //   566: istore 7
    //   568: aload_2
    //   569: invokeinterface 395 1 0
    //   574: iload_3
    //   575: istore 7
    //   577: aload_0
    //   578: aload_2
    //   579: iload 4
    //   581: invokespecial 696	ahzd:W	(Ljava/util/List;I)V
    //   584: iload_3
    //   585: istore 7
    //   587: aload_1
    //   588: invokeinterface 243 1 0
    //   593: astore_1
    //   594: iload_3
    //   595: istore 7
    //   597: aload_1
    //   598: invokeinterface 205 1 0
    //   603: ifeq +469 -> 1072
    //   606: iload_3
    //   607: istore 7
    //   609: aload_1
    //   610: invokeinterface 209 1 0
    //   615: checkcast 910	com/tencent/pb/hotpicmsg/HotPicMsg$TagInfo
    //   618: astore 15
    //   620: iload_3
    //   621: istore 7
    //   623: new 147	com/tencent/mobileqq/hotpic/HotPicTagInfo
    //   626: dup
    //   627: invokespecial 148	com/tencent/mobileqq/hotpic/HotPicTagInfo:<init>	()V
    //   630: astore 16
    //   632: iload_3
    //   633: istore 7
    //   635: aload 16
    //   637: aload 15
    //   639: getfield 913	com/tencent/pb/hotpicmsg/HotPicMsg$TagInfo:uint32_tag_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   642: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   645: putfield 172	com/tencent/mobileqq/hotpic/HotPicTagInfo:tagType	I
    //   648: iload_3
    //   649: istore 7
    //   651: aload 16
    //   653: aload 15
    //   655: getfield 914	com/tencent/pb/hotpicmsg/HotPicMsg$TagInfo:uint32_tag_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   658: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   661: putfield 169	com/tencent/mobileqq/hotpic/HotPicTagInfo:tagId	I
    //   664: iload_3
    //   665: istore 7
    //   667: aload 16
    //   669: getfield 169	com/tencent/mobileqq/hotpic/HotPicTagInfo:tagId	I
    //   672: iconst_2
    //   673: if_icmpeq -79 -> 594
    //   676: iload_3
    //   677: istore 7
    //   679: aload 16
    //   681: aload_2
    //   682: invokeinterface 253 1 0
    //   687: putfield 175	com/tencent/mobileqq/hotpic/HotPicTagInfo:position	I
    //   690: iload_3
    //   691: istore 7
    //   693: aload 16
    //   695: aload 15
    //   697: getfield 917	com/tencent/pb/hotpicmsg/HotPicMsg$TagInfo:bytes_tag_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   700: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   703: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   706: putfield 163	com/tencent/mobileqq/hotpic/HotPicTagInfo:tagName	Ljava/lang/String;
    //   709: iload_3
    //   710: istore 7
    //   712: aload 16
    //   714: iload 4
    //   716: putfield 166	com/tencent/mobileqq/hotpic/HotPicTagInfo:version	I
    //   719: iload_3
    //   720: istore 7
    //   722: aload_2
    //   723: aload 16
    //   725: invokeinterface 181 2 0
    //   730: pop
    //   731: iload_3
    //   732: istore 7
    //   734: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   737: ifeq -143 -> 594
    //   740: iload_3
    //   741: istore 7
    //   743: ldc 228
    //   745: iconst_2
    //   746: new 115	java/lang/StringBuilder
    //   749: dup
    //   750: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   753: ldc_w 925
    //   756: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload 16
    //   761: getfield 163	com/tencent/mobileqq/hotpic/HotPicTagInfo:tagName	Ljava/lang/String;
    //   764: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: ldc_w 927
    //   770: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: aload 16
    //   775: getfield 175	com/tencent/mobileqq/hotpic/HotPicTagInfo:position	I
    //   778: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   781: ldc_w 929
    //   784: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: aload 16
    //   789: getfield 169	com/tencent/mobileqq/hotpic/HotPicTagInfo:tagId	I
    //   792: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   795: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   801: goto -207 -> 594
    //   804: astore_1
    //   805: aload 14
    //   807: monitorexit
    //   808: iload 4
    //   810: istore 6
    //   812: aload_1
    //   813: athrow
    //   814: astore_1
    //   815: iload 6
    //   817: istore 4
    //   819: iload 7
    //   821: istore_3
    //   822: aload_1
    //   823: invokevirtual 930	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   826: aload 13
    //   828: astore_1
    //   829: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   832: ifeq +1235 -> 2067
    //   835: aload_1
    //   836: ifnull +1231 -> 2067
    //   839: aload_1
    //   840: invokevirtual 199	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   843: astore_2
    //   844: aload_2
    //   845: invokeinterface 205 1 0
    //   850: ifeq +1188 -> 2038
    //   853: aload_2
    //   854: invokeinterface 209 1 0
    //   859: checkcast 211	com/tencent/mobileqq/hotpic/HotPicData
    //   862: astore 11
    //   864: ldc 228
    //   866: iconst_2
    //   867: new 115	java/lang/StringBuilder
    //   870: dup
    //   871: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   874: ldc_w 932
    //   877: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: aload 11
    //   882: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   885: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   888: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   891: goto -47 -> 844
    //   894: astore_1
    //   895: aload_0
    //   896: monitorexit
    //   897: aload_1
    //   898: athrow
    //   899: iconst_0
    //   900: istore 9
    //   902: goto -841 -> 61
    //   905: aload_2
    //   906: getfield 936	com/tencent/pb/hotpicmsg/HotPicMsg$RspBody:msg_get_imginfo_rsp	Lcom/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp;
    //   909: invokevirtual 937	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   912: checkcast 876	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp
    //   915: astore 12
    //   917: aconst_null
    //   918: astore 11
    //   920: goto -687 -> 233
    //   923: aload 12
    //   925: getfield 938	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:uint32_build_ver	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   928: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   931: istore 5
    //   933: iload 5
    //   935: istore 4
    //   937: iload 4
    //   939: istore 6
    //   941: iload_3
    //   942: istore 7
    //   944: aload_2
    //   945: astore_1
    //   946: aload 12
    //   948: getfield 939	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:rpt_msg_tag_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   951: invokevirtual 896	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   954: ifeq +19 -> 973
    //   957: iload 4
    //   959: istore 6
    //   961: iload_3
    //   962: istore 7
    //   964: aload 12
    //   966: getfield 939	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:rpt_msg_tag_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   969: invokevirtual 898	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   972: astore_1
    //   973: iload 4
    //   975: istore 6
    //   977: iload_3
    //   978: istore 7
    //   980: aload_1
    //   981: astore_2
    //   982: iload 4
    //   984: istore 5
    //   986: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   989: ifeq +60 -> 1049
    //   992: iload 4
    //   994: istore 6
    //   996: iload_3
    //   997: istore 7
    //   999: ldc 228
    //   1001: iconst_2
    //   1002: new 115	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1009: ldc_w 941
    //   1012: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: iload 4
    //   1017: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1020: ldc_w 902
    //   1023: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: aload 12
    //   1028: getfield 880	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:int32_result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1031: invokevirtual 884	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1034: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1037: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1040: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1043: iload 4
    //   1045: istore 5
    //   1047: aload_1
    //   1048: astore_2
    //   1049: aload_2
    //   1050: astore_1
    //   1051: iload 5
    //   1053: istore 4
    //   1055: goto -637 -> 418
    //   1058: iload_3
    //   1059: istore 7
    //   1061: aload_0
    //   1062: getfield 93	ahzd:Cp	Ljava/util/List;
    //   1065: astore_2
    //   1066: iconst_0
    //   1067: istore 6
    //   1069: goto -504 -> 565
    //   1072: iload_3
    //   1073: istore 7
    //   1075: aload 14
    //   1077: monitorexit
    //   1078: iload_3
    //   1079: istore 5
    //   1081: iload 6
    //   1083: ifeq +23 -> 1106
    //   1086: iload 4
    //   1088: istore 6
    //   1090: iload_3
    //   1091: istore 7
    //   1093: aload_0
    //   1094: getfield 79	ahzd:i	Lauru;
    //   1097: bipush 104
    //   1099: invokevirtual 419	auru:sendEmptyMessage	(I)Z
    //   1102: pop
    //   1103: iload_3
    //   1104: istore 5
    //   1106: aconst_null
    //   1107: astore_2
    //   1108: iload 9
    //   1110: ifeq +374 -> 1484
    //   1113: aload 11
    //   1115: getfield 944	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:rpt_msg_video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1118: invokevirtual 898	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1121: astore 12
    //   1123: aload_2
    //   1124: astore_1
    //   1125: aload 12
    //   1127: ifnull +715 -> 1842
    //   1130: aload_2
    //   1131: astore_1
    //   1132: aload 12
    //   1134: invokeinterface 253 1 0
    //   1139: ifle +703 -> 1842
    //   1142: new 88	java/util/ArrayList
    //   1145: dup
    //   1146: invokespecial 89	java/util/ArrayList:<init>	()V
    //   1149: astore_1
    //   1150: aload 12
    //   1152: invokeinterface 243 1 0
    //   1157: astore_2
    //   1158: aload_2
    //   1159: invokeinterface 205 1 0
    //   1164: ifeq +1457 -> 2621
    //   1167: aload_2
    //   1168: invokeinterface 209 1 0
    //   1173: checkcast 946	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo
    //   1176: astore 12
    //   1178: new 217	com/tencent/mobileqq/hotpic/HotVideoData
    //   1181: dup
    //   1182: invokespecial 947	com/tencent/mobileqq/hotpic/HotVideoData:<init>	()V
    //   1185: astore 14
    //   1187: aload 14
    //   1189: aload 12
    //   1191: getfield 950	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_preview_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1194: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1197: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1200: invokevirtual 953	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1203: putfield 954	com/tencent/mobileqq/hotpic/HotVideoData:md5	Ljava/lang/String;
    //   1206: aload 14
    //   1208: aload 12
    //   1210: getfield 957	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint32_preview_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1213: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1216: putfield 960	com/tencent/mobileqq/hotpic/HotVideoData:width	I
    //   1219: aload 14
    //   1221: aload 12
    //   1223: getfield 963	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint32_preview_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1226: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1229: putfield 966	com/tencent/mobileqq/hotpic/HotVideoData:height	I
    //   1232: aload 14
    //   1234: aload 12
    //   1236: getfield 969	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_preview_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1239: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1242: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1245: putfield 972	com/tencent/mobileqq/hotpic/HotVideoData:mPreviewUUID	Ljava/lang/String;
    //   1248: aload 14
    //   1250: aload 12
    //   1252: getfield 975	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint64_preview_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1255: invokevirtual 977	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1258: putfield 980	com/tencent/mobileqq/hotpic/HotVideoData:fileSize	J
    //   1261: aload 14
    //   1263: aload 12
    //   1265: getfield 983	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint64_video_length	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1268: invokevirtual 977	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1271: putfield 986	com/tencent/mobileqq/hotpic/HotVideoData:videoLength	J
    //   1274: aload 14
    //   1276: aload 12
    //   1278: getfield 989	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_jump_icon	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1281: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1284: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1287: putfield 992	com/tencent/mobileqq/hotpic/HotVideoData:iconUrl	Ljava/lang/String;
    //   1290: aload 14
    //   1292: aload 12
    //   1294: getfield 995	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1297: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1300: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1303: putfield 998	com/tencent/mobileqq/hotpic/HotVideoData:jumpUrl	Ljava/lang/String;
    //   1306: aload 14
    //   1308: aload 12
    //   1310: getfield 1001	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint32_video_index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1313: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1316: putfield 1004	com/tencent/mobileqq/hotpic/HotVideoData:picIndex	I
    //   1319: aload 14
    //   1321: aload 12
    //   1323: getfield 1007	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_video_source	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1326: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1329: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1332: putfield 1010	com/tencent/mobileqq/hotpic/HotVideoData:videoSource	Ljava/lang/String;
    //   1335: aload 14
    //   1337: aload 12
    //   1339: getfield 1013	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_video_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1342: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1345: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1348: putfield 1016	com/tencent/mobileqq/hotpic/HotVideoData:name	Ljava/lang/String;
    //   1351: aload 14
    //   1353: aload 12
    //   1355: getfield 1019	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint32_video_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1358: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1361: putfield 1022	com/tencent/mobileqq/hotpic/HotVideoData:originalWidth	I
    //   1364: aload 14
    //   1366: aload 12
    //   1368: getfield 1025	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint32_video_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1371: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1374: putfield 1028	com/tencent/mobileqq/hotpic/HotVideoData:originalHeight	I
    //   1377: aload 14
    //   1379: aload 12
    //   1381: getfield 1031	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_video_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1384: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1387: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1390: putfield 1034	com/tencent/mobileqq/hotpic/HotVideoData:mVideoUUID	Ljava/lang/String;
    //   1393: aload 14
    //   1395: aload 12
    //   1397: getfield 1037	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_video_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1400: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1403: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1406: putfield 1040	com/tencent/mobileqq/hotpic/HotVideoData:originalMD5	Ljava/lang/String;
    //   1409: aload 14
    //   1411: aload 12
    //   1413: getfield 1043	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:bytes_certificated_icon	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1416: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1419: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1422: putfield 1046	com/tencent/mobileqq/hotpic/HotVideoData:mCertificatedIcon	Ljava/lang/String;
    //   1425: aload 14
    //   1427: aload 12
    //   1429: getfield 1049	com/tencent/pb/hotpicmsg/HotPicMsg$VideoInfo:uint64_video_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1432: invokevirtual 977	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1435: putfield 1052	com/tencent/mobileqq/hotpic/HotVideoData:oringinalSize	J
    //   1438: aload 14
    //   1440: aload 11
    //   1442: getfield 1053	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:uint32_tag_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1445: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1448: putfield 1056	com/tencent/mobileqq/hotpic/HotVideoData:tag	I
    //   1451: aload 14
    //   1453: iload 4
    //   1455: putfield 1057	com/tencent/mobileqq/hotpic/HotVideoData:version	I
    //   1458: aload 14
    //   1460: ldc_w 1059
    //   1463: putfield 1060	com/tencent/mobileqq/hotpic/HotVideoData:url	Ljava/lang/String;
    //   1466: aload 14
    //   1468: ldc_w 1059
    //   1471: putfield 1063	com/tencent/mobileqq/hotpic/HotVideoData:originalUrl	Ljava/lang/String;
    //   1474: aload_1
    //   1475: aload 14
    //   1477: invokevirtual 218	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1480: pop
    //   1481: goto -323 -> 1158
    //   1484: aload 12
    //   1486: getfield 1066	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:rpt_msg_img_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1489: invokevirtual 898	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1492: astore_2
    //   1493: aload_2
    //   1494: ifnull +1122 -> 2616
    //   1497: aload_2
    //   1498: invokeinterface 253 1 0
    //   1503: ifle +1113 -> 2616
    //   1506: new 88	java/util/ArrayList
    //   1509: dup
    //   1510: invokespecial 89	java/util/ArrayList:<init>	()V
    //   1513: astore_1
    //   1514: iconst_0
    //   1515: istore_3
    //   1516: iload_3
    //   1517: aload_2
    //   1518: invokeinterface 253 1 0
    //   1523: if_icmpge +319 -> 1842
    //   1526: aload_2
    //   1527: iload_3
    //   1528: invokeinterface 407 2 0
    //   1533: checkcast 1068	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo
    //   1536: astore 12
    //   1538: new 211	com/tencent/mobileqq/hotpic/HotPicData
    //   1541: dup
    //   1542: invokespecial 1069	com/tencent/mobileqq/hotpic/HotPicData:<init>	()V
    //   1545: astore 11
    //   1547: aload 11
    //   1549: iload 4
    //   1551: putfield 1070	com/tencent/mobileqq/hotpic/HotPicData:version	I
    //   1554: aload 11
    //   1556: aload 12
    //   1558: getfield 1073	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint32_pic_index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1561: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1564: putfield 1074	com/tencent/mobileqq/hotpic/HotPicData:picIndex	I
    //   1567: aload 11
    //   1569: aload 12
    //   1571: getfield 1077	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1574: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1577: putfield 1080	com/tencent/mobileqq/hotpic/HotPicData:fileType	I
    //   1580: aload 11
    //   1582: aload 12
    //   1584: getfield 1083	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint32_source_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1587: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1590: putfield 1086	com/tencent/mobileqq/hotpic/HotPicData:sourceType	I
    //   1593: aload 11
    //   1595: aload 12
    //   1597: getfield 1089	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint32_thumb_file_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1600: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1603: putfield 1090	com/tencent/mobileqq/hotpic/HotPicData:height	I
    //   1606: aload 11
    //   1608: aload 12
    //   1610: getfield 1093	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint32_thumb_file_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1613: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1616: putfield 1094	com/tencent/mobileqq/hotpic/HotPicData:width	I
    //   1619: aload 11
    //   1621: aload 12
    //   1623: getfield 1097	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:bytes_thumb_down_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1626: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1629: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1632: putfield 317	com/tencent/mobileqq/hotpic/HotPicData:url	Ljava/lang/String;
    //   1635: aload 11
    //   1637: aload 12
    //   1639: getfield 1100	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1642: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1645: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1648: invokevirtual 953	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1651: putfield 633	com/tencent/mobileqq/hotpic/HotPicData:md5	Ljava/lang/String;
    //   1654: aload 11
    //   1656: aload 12
    //   1658: getfield 1103	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint64_thumb_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1661: invokevirtual 977	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1664: putfield 1104	com/tencent/mobileqq/hotpic/HotPicData:fileSize	J
    //   1667: aload 11
    //   1669: aload 12
    //   1671: getfield 1107	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1674: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1677: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1680: invokevirtual 953	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1683: putfield 1108	com/tencent/mobileqq/hotpic/HotPicData:originalMD5	Ljava/lang/String;
    //   1686: aload 11
    //   1688: aload 12
    //   1690: getfield 1111	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:bytes_pic_down_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1693: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1696: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1699: putfield 1112	com/tencent/mobileqq/hotpic/HotPicData:originalUrl	Ljava/lang/String;
    //   1702: aload 11
    //   1704: aload 12
    //   1706: getfield 1115	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint32_file_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1709: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1712: putfield 1116	com/tencent/mobileqq/hotpic/HotPicData:originalHeight	I
    //   1715: aload 11
    //   1717: aload 12
    //   1719: getfield 1119	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint32_file_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1722: invokevirtual 887	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1725: putfield 1120	com/tencent/mobileqq/hotpic/HotPicData:originalWidth	I
    //   1728: aload 11
    //   1730: aload 12
    //   1732: getfield 1123	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1735: invokevirtual 977	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1738: putfield 1124	com/tencent/mobileqq/hotpic/HotPicData:oringinalSize	J
    //   1741: aload 11
    //   1743: iload 8
    //   1745: putfield 1125	com/tencent/mobileqq/hotpic/HotPicData:tag	I
    //   1748: aload 11
    //   1750: getfield 1086	com/tencent/mobileqq/hotpic/HotPicData:sourceType	I
    //   1753: iconst_3
    //   1754: if_icmpne +74 -> 1828
    //   1757: aload 12
    //   1759: getfield 1129	com/tencent/pb/hotpicmsg/HotPicMsg$ImgInfo:msg_third_party_info	Lcom/tencent/pb/hotpicmsg/HotPicMsg$ThirdPartyInfo;
    //   1762: astore 12
    //   1764: aload 11
    //   1766: aload 12
    //   1768: getfield 1134	com/tencent/pb/hotpicmsg/HotPicMsg$ThirdPartyInfo:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1771: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1774: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1777: putfield 1135	com/tencent/mobileqq/hotpic/HotPicData:iconUrl	Ljava/lang/String;
    //   1780: aload 11
    //   1782: aload 12
    //   1784: getfield 1138	com/tencent/pb/hotpicmsg/HotPicMsg$ThirdPartyInfo:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1787: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1790: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1793: putfield 1139	com/tencent/mobileqq/hotpic/HotPicData:name	Ljava/lang/String;
    //   1796: aload 11
    //   1798: aload 12
    //   1800: getfield 1140	com/tencent/pb/hotpicmsg/HotPicMsg$ThirdPartyInfo:bytes_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1803: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1806: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1809: putfield 1141	com/tencent/mobileqq/hotpic/HotPicData:jumpUrl	Ljava/lang/String;
    //   1812: aload 11
    //   1814: aload 12
    //   1816: getfield 1144	com/tencent/pb/hotpicmsg/HotPicMsg$ThirdPartyInfo:bytes_appid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1819: invokevirtual 920	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1822: invokevirtual 923	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1825: putfield 1147	com/tencent/mobileqq/hotpic/HotPicData:appid	Ljava/lang/String;
    //   1828: aload_1
    //   1829: aload 11
    //   1831: invokevirtual 218	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1834: pop
    //   1835: iload_3
    //   1836: iconst_1
    //   1837: iadd
    //   1838: istore_3
    //   1839: goto -323 -> 1516
    //   1842: iload 5
    //   1844: istore_3
    //   1845: goto -1016 -> 829
    //   1848: iload 9
    //   1850: ifeq +67 -> 1917
    //   1853: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1856: ifeq +36 -> 1892
    //   1859: ldc 228
    //   1861: iconst_2
    //   1862: new 115	java/lang/StringBuilder
    //   1865: dup
    //   1866: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1869: ldc_w 1149
    //   1872: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1875: aload 11
    //   1877: getfield 885	com/tencent/pb/hotpicmsg/HotPicMsg$GetVideoInfoRsp:int32_result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1880: invokevirtual 884	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1883: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1886: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1889: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1892: invokestatic 1152	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1895: invokestatic 1157	anpc:a	(Landroid/content/Context;)Lanpc;
    //   1898: aconst_null
    //   1899: ldc_w 1159
    //   1902: iconst_1
    //   1903: lconst_0
    //   1904: lconst_0
    //   1905: aconst_null
    //   1906: ldc_w 1059
    //   1909: invokevirtual 1163	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1912: aconst_null
    //   1913: astore_1
    //   1914: goto -69 -> 1845
    //   1917: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1920: ifeq -28 -> 1892
    //   1923: ldc 228
    //   1925: iconst_2
    //   1926: new 115	java/lang/StringBuilder
    //   1929: dup
    //   1930: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1933: ldc_w 1165
    //   1936: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1939: aload 12
    //   1941: getfield 880	com/tencent/pb/hotpicmsg/HotPicMsg$GetImgInfoRsp:int32_result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1944: invokevirtual 884	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1947: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1950: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1953: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1956: goto -64 -> 1892
    //   1959: astore_1
    //   1960: goto -1138 -> 822
    //   1963: aload_0
    //   1964: getfield 62	ahzd:cz	Ljava/util/Set;
    //   1967: iload 8
    //   1969: invokestatic 425	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1972: invokeinterface 324 2 0
    //   1977: pop
    //   1978: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1981: ifeq +32 -> 2013
    //   1984: ldc 228
    //   1986: iconst_2
    //   1987: new 115	java/lang/StringBuilder
    //   1990: dup
    //   1991: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   1994: ldc_w 1167
    //   1997: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2000: aload_2
    //   2001: invokevirtual 845	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   2004: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2007: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2010: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2013: aload_0
    //   2014: getfield 391	ahzd:jdField_a_of_type_Ahzd$b	Lahzd$b;
    //   2017: ifnull +18 -> 2035
    //   2020: aload_0
    //   2021: getfield 391	ahzd:jdField_a_of_type_Ahzd$b	Lahzd$b;
    //   2024: bipush 6
    //   2026: iload 8
    //   2028: iload 4
    //   2030: invokeinterface 660 4 0
    //   2035: aload_0
    //   2036: monitorexit
    //   2037: return
    //   2038: ldc 228
    //   2040: iconst_2
    //   2041: new 115	java/lang/StringBuilder
    //   2044: dup
    //   2045: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   2048: ldc_w 1169
    //   2051: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2054: aload_1
    //   2055: invokevirtual 749	java/util/ArrayList:size	()I
    //   2058: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2061: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2064: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2067: aload_1
    //   2068: ifnull +10 -> 2078
    //   2071: aload_1
    //   2072: invokevirtual 749	java/util/ArrayList:size	()I
    //   2075: ifgt +167 -> 2242
    //   2078: iload_3
    //   2079: ifne +101 -> 2180
    //   2082: iconst_5
    //   2083: istore_3
    //   2084: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2087: ifeq +526 -> 2613
    //   2090: ldc 228
    //   2092: iconst_2
    //   2093: ldc_w 1171
    //   2096: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2099: iconst_5
    //   2100: istore_3
    //   2101: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2104: ifeq +52 -> 2156
    //   2107: new 115	java/lang/StringBuilder
    //   2110: dup
    //   2111: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   2114: ldc_w 1173
    //   2117: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2120: iload_3
    //   2121: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2124: ldc_w 1175
    //   2127: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2130: astore_1
    //   2131: aload_0
    //   2132: getfield 391	ahzd:jdField_a_of_type_Ahzd$b	Lahzd$b;
    //   2135: ifnull +509 -> 2644
    //   2138: iconst_1
    //   2139: istore 9
    //   2141: ldc 228
    //   2143: iconst_2
    //   2144: aload_1
    //   2145: iload 9
    //   2147: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2150: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2153: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2156: aload_0
    //   2157: getfield 391	ahzd:jdField_a_of_type_Ahzd$b	Lahzd$b;
    //   2160: ifnull +435 -> 2595
    //   2163: aload_0
    //   2164: getfield 391	ahzd:jdField_a_of_type_Ahzd$b	Lahzd$b;
    //   2167: iload_3
    //   2168: iload 8
    //   2170: iload 4
    //   2172: invokeinterface 660 4 0
    //   2177: goto -142 -> 2035
    //   2180: iload 10
    //   2182: ifeq +21 -> 2203
    //   2185: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2188: ifeq -153 -> 2035
    //   2191: ldc 228
    //   2193: iconst_2
    //   2194: ldc_w 1177
    //   2197: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2200: goto -165 -> 2035
    //   2203: bipush 6
    //   2205: istore_3
    //   2206: aload_0
    //   2207: getfield 62	ahzd:cz	Ljava/util/Set;
    //   2210: iload 8
    //   2212: invokestatic 425	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2215: invokeinterface 324 2 0
    //   2220: pop
    //   2221: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2224: ifeq +389 -> 2613
    //   2227: ldc 228
    //   2229: iconst_2
    //   2230: ldc_w 1179
    //   2233: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2236: bipush 6
    //   2238: istore_3
    //   2239: goto -138 -> 2101
    //   2242: aload_0
    //   2243: getfield 84	ahzd:cJ	Landroid/util/SparseArray;
    //   2246: iload 8
    //   2248: invokevirtual 400	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   2251: checkcast 88	java/util/ArrayList
    //   2254: astore_2
    //   2255: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2258: ifeq +40 -> 2298
    //   2261: ldc 228
    //   2263: iconst_2
    //   2264: new 115	java/lang/StringBuilder
    //   2267: dup
    //   2268: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   2271: ldc_w 1181
    //   2274: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2277: iload 4
    //   2279: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2282: ldc_w 1183
    //   2285: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2288: iload_3
    //   2289: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2292: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2295: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2298: iload_3
    //   2299: iload 4
    //   2301: if_icmpeq +93 -> 2394
    //   2304: iload 10
    //   2306: ifeq -271 -> 2035
    //   2309: aload_0
    //   2310: getfield 86	ahzd:cK	Landroid/util/SparseArray;
    //   2313: invokevirtual 396	android/util/SparseArray:clear	()V
    //   2316: aload_0
    //   2317: getfield 86	ahzd:cK	Landroid/util/SparseArray;
    //   2320: iload 8
    //   2322: aload_1
    //   2323: invokevirtual 404	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   2326: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2329: ifeq +40 -> 2369
    //   2332: ldc 228
    //   2334: iconst_2
    //   2335: new 115	java/lang/StringBuilder
    //   2338: dup
    //   2339: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   2342: ldc_w 1181
    //   2345: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2348: iload 4
    //   2350: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2353: ldc_w 1183
    //   2356: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2359: iload_3
    //   2360: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2363: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2366: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2369: aload_0
    //   2370: getfield 391	ahzd:jdField_a_of_type_Ahzd$b	Lahzd$b;
    //   2373: ifnonnull -338 -> 2035
    //   2376: invokestatic 1187	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   2379: new 1189	com/tencent/mobileqq/hotpic/HotPicManager$3
    //   2382: dup
    //   2383: aload_0
    //   2384: invokespecial 1190	com/tencent/mobileqq/hotpic/HotPicManager$3:<init>	(Lahzd;)V
    //   2387: invokevirtual 1195	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   2390: pop
    //   2391: goto -356 -> 2035
    //   2394: aload_2
    //   2395: invokevirtual 749	java/util/ArrayList:size	()I
    //   2398: ifne +38 -> 2436
    //   2401: aload_2
    //   2402: aload_1
    //   2403: invokevirtual 706	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2406: pop
    //   2407: bipush 7
    //   2409: istore_3
    //   2410: iload 9
    //   2412: ifeq +15 -> 2427
    //   2415: aload_0
    //   2416: aload_1
    //   2417: invokestatic 753	ahzd:ai	(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   2420: iconst_0
    //   2421: invokespecial 778	ahzd:ar	(Ljava/util/List;Z)V
    //   2424: goto -323 -> 2101
    //   2427: aload_0
    //   2428: aload_2
    //   2429: iconst_0
    //   2430: invokespecial 774	ahzd:as	(Ljava/util/List;Z)V
    //   2433: goto -332 -> 2101
    //   2436: iload_3
    //   2437: ifeq +202 -> 2639
    //   2440: aload_1
    //   2441: iconst_0
    //   2442: invokevirtual 1196	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2445: checkcast 211	com/tencent/mobileqq/hotpic/HotPicData
    //   2448: getfield 1074	com/tencent/mobileqq/hotpic/HotPicData:picIndex	I
    //   2451: aload_2
    //   2452: invokevirtual 749	java/util/ArrayList:size	()I
    //   2455: if_icmpne +77 -> 2532
    //   2458: iload 9
    //   2460: ifeq +39 -> 2499
    //   2463: new 88	java/util/ArrayList
    //   2466: dup
    //   2467: invokespecial 89	java/util/ArrayList:<init>	()V
    //   2470: astore 11
    //   2472: aload 11
    //   2474: aload_1
    //   2475: invokestatic 753	ahzd:ai	(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   2478: invokevirtual 706	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2481: pop
    //   2482: aload_2
    //   2483: aload 11
    //   2485: invokevirtual 706	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2488: pop
    //   2489: aload_0
    //   2490: aload 11
    //   2492: iconst_0
    //   2493: invokespecial 778	ahzd:ar	(Ljava/util/List;Z)V
    //   2496: goto +138 -> 2634
    //   2499: new 88	java/util/ArrayList
    //   2502: dup
    //   2503: invokespecial 89	java/util/ArrayList:<init>	()V
    //   2506: astore 11
    //   2508: aload 11
    //   2510: aload_1
    //   2511: invokevirtual 706	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2514: pop
    //   2515: aload_2
    //   2516: aload 11
    //   2518: invokevirtual 706	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2521: pop
    //   2522: aload_0
    //   2523: aload 11
    //   2525: iconst_0
    //   2526: invokespecial 774	ahzd:as	(Ljava/util/List;Z)V
    //   2529: goto +105 -> 2634
    //   2532: ldc 228
    //   2534: iconst_1
    //   2535: new 115	java/lang/StringBuilder
    //   2538: dup
    //   2539: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   2542: ldc_w 1198
    //   2545: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2548: aload_1
    //   2549: iconst_0
    //   2550: invokevirtual 1196	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2553: checkcast 211	com/tencent/mobileqq/hotpic/HotPicData
    //   2556: getfield 1074	com/tencent/mobileqq/hotpic/HotPicData:picIndex	I
    //   2559: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2562: ldc_w 1200
    //   2565: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2568: aload_2
    //   2569: invokevirtual 749	java/util/ArrayList:size	()I
    //   2572: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2575: ldc_w 1202
    //   2578: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2581: iload 8
    //   2583: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2586: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2589: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2592: goto -557 -> 2035
    //   2595: invokestatic 1187	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   2598: new 1204	com/tencent/mobileqq/hotpic/HotPicManager$4
    //   2601: dup
    //   2602: aload_0
    //   2603: invokespecial 1205	com/tencent/mobileqq/hotpic/HotPicManager$4:<init>	(Lahzd;)V
    //   2606: invokevirtual 1195	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   2609: pop
    //   2610: goto -575 -> 2035
    //   2613: goto -512 -> 2101
    //   2616: aconst_null
    //   2617: astore_1
    //   2618: goto -776 -> 1842
    //   2621: goto -779 -> 1842
    //   2624: goto -2547 -> 77
    //   2627: astore_1
    //   2628: iload 5
    //   2630: istore_3
    //   2631: goto -1809 -> 822
    //   2634: iconst_3
    //   2635: istore_3
    //   2636: goto -535 -> 2101
    //   2639: iconst_5
    //   2640: istore_3
    //   2641: goto -540 -> 2101
    //   2644: iconst_0
    //   2645: istore 9
    //   2647: goto -506 -> 2141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2650	0	this	ahzd
    //   0	2650	1	paramIntent	android.content.Intent
    //   0	2650	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   29	2612	3	j	int
    //   13	2336	4	k	int
    //   48	2581	5	m	int
    //   316	773	6	n	int
    //   319	773	7	i1	int
    //   23	2559	8	i2	int
    //   59	2587	9	bool1	boolean
    //   38	2267	10	bool2	boolean
    //   228	2296	11	localObject1	Object
    //   231	1709	12	localObject2	Object
    //   3	824	13	localObject3	Object
    //   535	941	14	localObject4	Object
    //   618	78	15	localTagInfo	com.tencent.pb.hotpicmsg.HotPicMsg.TagInfo
    //   630	158	16	localHotPicTagInfo	HotPicTagInfo
    // Exception table:
    //   from	to	target	type
    //   554	559	804	finally
    //   568	574	804	finally
    //   577	584	804	finally
    //   587	594	804	finally
    //   597	606	804	finally
    //   609	620	804	finally
    //   623	632	804	finally
    //   635	648	804	finally
    //   651	664	804	finally
    //   667	676	804	finally
    //   679	690	804	finally
    //   693	709	804	finally
    //   712	719	804	finally
    //   722	731	804	finally
    //   734	740	804	finally
    //   743	801	804	finally
    //   805	808	804	finally
    //   1061	1066	804	finally
    //   1075	1078	804	finally
    //   321	332	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   339	348	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   361	367	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   374	418	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   443	452	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   459	465	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   472	524	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   531	537	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   544	547	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   812	814	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   946	957	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   964	973	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   986	992	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   999	1043	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1093	1103	814	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5	50	894	finally
    //   69	77	894	finally
    //   77	153	894	finally
    //   153	194	894	finally
    //   194	213	894	finally
    //   218	230	894	finally
    //   238	262	894	finally
    //   267	291	894	finally
    //   300	310	894	finally
    //   321	332	894	finally
    //   339	348	894	finally
    //   361	367	894	finally
    //   374	418	894	finally
    //   443	452	894	finally
    //   459	465	894	finally
    //   472	524	894	finally
    //   531	537	894	finally
    //   544	547	894	finally
    //   812	814	894	finally
    //   822	826	894	finally
    //   829	835	894	finally
    //   839	844	894	finally
    //   844	891	894	finally
    //   905	917	894	finally
    //   923	933	894	finally
    //   946	957	894	finally
    //   964	973	894	finally
    //   986	992	894	finally
    //   999	1043	894	finally
    //   1093	1103	894	finally
    //   1113	1123	894	finally
    //   1132	1158	894	finally
    //   1158	1481	894	finally
    //   1484	1493	894	finally
    //   1497	1514	894	finally
    //   1516	1828	894	finally
    //   1828	1835	894	finally
    //   1853	1892	894	finally
    //   1892	1912	894	finally
    //   1917	1956	894	finally
    //   1963	2013	894	finally
    //   2013	2035	894	finally
    //   2038	2067	894	finally
    //   2071	2078	894	finally
    //   2084	2099	894	finally
    //   2101	2138	894	finally
    //   2141	2156	894	finally
    //   2156	2177	894	finally
    //   2185	2200	894	finally
    //   2206	2221	894	finally
    //   2221	2236	894	finally
    //   2242	2298	894	finally
    //   2309	2369	894	finally
    //   2369	2391	894	finally
    //   2394	2407	894	finally
    //   2415	2424	894	finally
    //   2427	2433	894	finally
    //   2440	2458	894	finally
    //   2463	2496	894	finally
    //   2499	2529	894	finally
    //   2532	2592	894	finally
    //   2595	2610	894	finally
    //   194	213	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   218	230	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   238	262	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   267	291	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   300	310	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   905	917	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   923	933	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1853	1892	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1892	1912	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1917	1956	1959	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1113	1123	2627	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1132	1158	2627	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1158	1481	2627	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1484	1493	2627	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1497	1514	2627	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1516	1828	2627	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1828	1835	2627	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void setPublicAccountGifListener(aiaa paramaiaa)
  {
    this.jdField_a_of_type_Aiaa = paramaiaa;
  }
  
  class a
    implements Comparator<File>
  {
    a() {}
    
    public int compare(File paramFile1, File paramFile2)
    {
      if (paramFile1.lastModified() > paramFile2.lastModified()) {}
      do
      {
        return -1;
        if (paramFile1.lastModified() != paramFile2.lastModified()) {
          break;
        }
        if (paramFile1.length() > paramFile2.length()) {
          return 1;
        }
      } while (paramFile1.length() < paramFile2.length());
      return 0;
      return 1;
    }
  }
  
  public static abstract interface b
  {
    public abstract void aQ(int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzd
 * JD-Core Version:    0.7.0.1
 */