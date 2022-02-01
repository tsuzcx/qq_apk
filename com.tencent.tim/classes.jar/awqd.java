import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;
import com.tencent.weiyun.transmission.utils.ThreadPoolWrapper;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.utils.DualHashMap;
import com.tencent.weiyun.utils.IOUtils;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import cooperation.weiyun.sdk.download.DownloadType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class awqd
  implements aolm.b, awqo.a, awqp.a, awqq.a
{
  private static final AtomicInteger FLOW_ID = new AtomicInteger(0);
  static aolm.a b = new awqf();
  private static Singleton<awqd, Void> sInstance = new awqe();
  private final awqc jdField_a_of_type_Awqc = new awqc();
  private awqd.d jdField_a_of_type_Awqd$d;
  private awqo jdField_a_of_type_Awqo;
  private awqp jdField_a_of_type_Awqp;
  private awqq jdField_a_of_type_Awqq;
  private LinkedList<Long> at = new LinkedList();
  private LinkedList<Long> au = new LinkedList();
  private aolm c;
  private Object gk = new Object();
  private aolm h;
  private Context mContext;
  private final HashSet<Long> mFailedJobs = new HashSet();
  private final DualHashMap<Long, String> mFlowIds = new DualHashMap();
  private final HashMap<Long, awqb> mJobs = new HashMap();
  private List<awqd.c> mListeners;
  private final ThreadPoolWrapper mThreadPool = new ThreadPoolWrapper("WyDownloader");
  private final HashSet<Long> mWaitNetJobs = new HashSet();
  private Map<Long, aomg> qt = new HashMap();
  private Map<String, aoll> qu = new HashMap();
  
  private awqd()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.mContext, new awqg(this));
  }
  
  public static awqd a()
  {
    return (awqd)sInstance.get(null);
  }
  
  private void a(long paramLong, aomg paramaomg)
  {
    if (paramaomg == null) {
      return;
    }
    synchronized (this.gk)
    {
      this.at.add(Long.valueOf(paramLong));
      this.qt.put(Long.valueOf(paramLong), paramaomg);
      eEN();
      eEO();
      return;
    }
  }
  
  private String cA(String paramString1, String paramString2)
  {
    return paramString1 + "." + paramString2 + ".tmp";
  }
  
  private void eEN()
  {
    Iterator localIterator = this.au.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      if (localObject == null)
      {
        localIterator.remove();
      }
      else
      {
        localObject = (awqb)this.mJobs.get(localObject);
        if ((localObject == null) || (((awqb)localObject).isCanceled())) {
          localIterator.remove();
        }
      }
    }
  }
  
  private void eEO()
  {
    if (this.at.size() > 0) {
      if (this.au.size() >= 2) {
        break label62;
      }
    }
    Long localLong;
    aomg localaomg;
    label62:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localLong = (Long)this.at.remove(0);
        localaomg = (aomg)this.qt.remove(localLong);
        if (localaomg != null) {
          break;
        }
        eEO();
      }
      return;
    }
    awqb localawqb = (awqb)this.mJobs.get(localLong);
    if ((localawqb == null) || (!isNetAvailable(localawqb.isIgnoreNetLimit())) || (localawqb.isCanceled()))
    {
      eEO();
      return;
    }
    this.au.add(localLong);
    if (this.c == null) {
      this.c = awqs.a();
    }
    this.mThreadPool.submit(new awqk(this, localLong, localaomg));
  }
  
  /* Error */
  private static boolean f(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokevirtual 269	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   7: invokestatic 274	awri:Hp	()Ljava/lang/String;
    //   10: invokevirtual 280	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13: ifne +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_1
    //   19: invokevirtual 283	java/io/File:getName	()Ljava/lang/String;
    //   22: astore_3
    //   23: aload_3
    //   24: invokestatic 289	ahav:getFileType	(Ljava/lang/String;)I
    //   27: istore_2
    //   28: iload_2
    //   29: ifeq +13 -> 42
    //   32: iload_2
    //   33: iconst_2
    //   34: if_icmpeq +8 -> 42
    //   37: iload_2
    //   38: iconst_1
    //   39: if_icmpne -23 -> 16
    //   42: aload_0
    //   43: aload_3
    //   44: invokestatic 295	aopl:F	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 6
    //   49: new 297	android/content/ContentValues
    //   52: dup
    //   53: invokespecial 298	android/content/ContentValues:<init>	()V
    //   56: astore 5
    //   58: aload 5
    //   60: ldc_w 300
    //   63: aload_3
    //   64: invokevirtual 303	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload 5
    //   69: ldc_w 305
    //   72: aload_3
    //   73: invokevirtual 303	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload 5
    //   78: ldc_w 307
    //   81: aload_1
    //   82: invokevirtual 311	java/io/File:lastModified	()J
    //   85: ldc2_w 312
    //   88: ldiv
    //   89: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: invokevirtual 316	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   95: aload 5
    //   97: ldc_w 318
    //   100: aload 6
    //   102: invokevirtual 303	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload 5
    //   107: ldc_w 320
    //   110: aload_1
    //   111: invokevirtual 323	java/io/File:length	()J
    //   114: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   117: invokevirtual 316	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   120: iload_2
    //   121: ifne +142 -> 263
    //   124: aload 5
    //   126: ldc_w 325
    //   129: invokestatic 330	java/lang/System:currentTimeMillis	()J
    //   132: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   135: invokevirtual 316	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   138: getstatic 336	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   141: astore_3
    //   142: aload_0
    //   143: invokevirtual 342	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   146: astore_0
    //   147: aload_0
    //   148: aload_3
    //   149: aload 5
    //   151: invokevirtual 348	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   154: astore_3
    //   155: aload_3
    //   156: ifnull -140 -> 16
    //   159: aload_0
    //   160: aload_3
    //   161: ldc_w 350
    //   164: invokevirtual 354	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   167: astore_3
    //   168: aload_3
    //   169: ifnull -153 -> 16
    //   172: new 356	java/io/BufferedInputStream
    //   175: dup
    //   176: new 358	java/io/FileInputStream
    //   179: dup
    //   180: aload_1
    //   181: invokespecial 361	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   184: invokespecial 364	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   187: astore_0
    //   188: new 366	java/io/BufferedOutputStream
    //   191: dup
    //   192: new 368	java/io/FileOutputStream
    //   195: dup
    //   196: aload_3
    //   197: invokevirtual 374	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   200: invokespecial 377	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   203: invokespecial 380	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   206: astore_1
    //   207: sipush 8192
    //   210: newarray byte
    //   212: astore_3
    //   213: aload_0
    //   214: aload_3
    //   215: invokevirtual 386	java/io/InputStream:read	([B)I
    //   218: istore_2
    //   219: iload_2
    //   220: ifle +76 -> 296
    //   223: aload_1
    //   224: aload_3
    //   225: iconst_0
    //   226: iload_2
    //   227: invokevirtual 392	java/io/OutputStream:write	([BII)V
    //   230: goto -17 -> 213
    //   233: astore 4
    //   235: aload_0
    //   236: astore_3
    //   237: aload 4
    //   239: astore_0
    //   240: aload_3
    //   241: invokestatic 398	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   244: aload_1
    //   245: invokestatic 398	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   248: aload_0
    //   249: athrow
    //   250: astore_0
    //   251: ldc 115
    //   253: iconst_2
    //   254: ldc_w 400
    //   257: aload_0
    //   258: invokestatic 406	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   261: iconst_0
    //   262: ireturn
    //   263: iload_2
    //   264: iconst_2
    //   265: if_icmpne +24 -> 289
    //   268: aload 5
    //   270: ldc_w 325
    //   273: invokestatic 330	java/lang/System:currentTimeMillis	()J
    //   276: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   279: invokevirtual 316	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   282: getstatic 409	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   285: astore_3
    //   286: goto -144 -> 142
    //   289: getstatic 412	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   292: astore_3
    //   293: goto -151 -> 142
    //   296: aload_1
    //   297: invokevirtual 415	java/io/OutputStream:flush	()V
    //   300: aload_0
    //   301: invokestatic 398	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   304: aload_1
    //   305: invokestatic 398	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   308: iconst_1
    //   309: ireturn
    //   310: astore_0
    //   311: aconst_null
    //   312: astore_1
    //   313: aload 4
    //   315: astore_3
    //   316: goto -76 -> 240
    //   319: astore 4
    //   321: aconst_null
    //   322: astore_1
    //   323: aload_0
    //   324: astore_3
    //   325: aload 4
    //   327: astore_0
    //   328: goto -88 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramContext	Context
    //   0	331	1	paramFile	File
    //   27	239	2	i	int
    //   22	303	3	localObject1	Object
    //   1	1	4	localObject2	Object
    //   233	81	4	localObject3	Object
    //   319	7	4	localObject4	Object
    //   56	213	5	localContentValues	android.content.ContentValues
    //   47	54	6	str	String
    // Exception table:
    //   from	to	target	type
    //   207	213	233	finally
    //   213	219	233	finally
    //   223	230	233	finally
    //   296	300	233	finally
    //   23	28	250	java/lang/Throwable
    //   42	120	250	java/lang/Throwable
    //   124	142	250	java/lang/Throwable
    //   142	155	250	java/lang/Throwable
    //   159	168	250	java/lang/Throwable
    //   240	250	250	java/lang/Throwable
    //   268	286	250	java/lang/Throwable
    //   289	293	250	java/lang/Throwable
    //   300	308	250	java/lang/Throwable
    //   172	188	310	finally
    //   188	207	319	finally
  }
  
  private void nV(long paramLong)
  {
    for (;;)
    {
      synchronized (this.gk)
      {
        if (this.at.remove(Long.valueOf(paramLong)))
        {
          this.qt.remove(Long.valueOf(paramLong));
          return;
        }
        if (this.au.remove(Long.valueOf(paramLong))) {
          eEO();
        }
      }
      eEN();
      eEO();
    }
  }
  
  private boolean restartJobInner(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    synchronized (this.mJobs)
    {
      awqb localawqb1 = (awqb)this.mJobs.get(Long.valueOf(paramLong));
      if (localawqb1 == null)
      {
        nV(paramLong);
        return false;
      }
    }
    if (paramBoolean1) {
      localawqb2.setPriority(paramBoolean2);
    }
    if (paramBoolean3) {
      localawqb2.setIgnoreNetLimit(paramBoolean4);
    }
    a(localawqb2, 1, 0, null);
    return true;
  }
  
  public int Qs()
  {
    ??? = this.jdField_a_of_type_Awqc.a();
    int i = ((awqc)???).failed;
    int j = ((awqc)???).suspend;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mJobs)
    {
      localArrayList.addAll(this.mJobs.keySet());
      if (!localArrayList.isEmpty()) {
        this.mThreadPool.submit(new awql(this, localArrayList));
      }
      return j + i;
    }
  }
  
  public awqb a(long paramLong)
  {
    synchronized (this.mJobs)
    {
      awqb localawqb = (awqb)this.mJobs.get(Long.valueOf(paramLong));
      if (localawqb == null) {
        return null;
      }
    }
    return awqb.a(localObject.uid(), localObject.b().a(), localObject.Hm(), localObject.a().c());
  }
  
  public String a(awpy paramawpy, String paramString, awqd.c paramc)
  {
    return b(paramawpy, paramString, true, paramc);
  }
  
  public String a(awpy paramawpy, String paramString, boolean paramBoolean, awqd.c paramc)
  {
    return b(paramawpy, paramString, paramBoolean, paramc);
  }
  
  public String a(String paramString1, String paramString2, String paramString3, String paramString4, awqd.c paramc)
  {
    int i = FLOW_ID.getAndIncrement();
    a(paramString1, paramString2, paramString3, paramString4, new awqh(this, paramc, i), Integer.toString(i));
    return Integer.toString(i);
  }
  
  void a(int paramInt, awqb paramawqb)
  {
    if (paramawqb == null) {}
    do
    {
      return;
      synchronized (this.mFlowIds)
      {
        this.mFlowIds.put(Long.valueOf(paramawqb.dbId()), Integer.toString(paramInt));
        ??? = this.mListeners.iterator();
        while (((Iterator)???).hasNext())
        {
          awqd.c localc = (awqd.c)((Iterator)???).next();
          if (localc != null) {
            localc.IJ(Integer.toString(paramInt));
          }
        }
      }
    } while (paramawqb.a() == null);
    paramawqb.a().IJ(Integer.toString(paramInt));
  }
  
  public void a(int paramInt, awqb paramawqb, String paramString)
  {
    for (;;)
    {
      awqb localawqb;
      synchronized (this.mJobs)
      {
        long l = paramawqb.dbId();
        localawqb = (awqb)this.mJobs.get(Long.valueOf(l));
        if (localawqb == null)
        {
          this.mJobs.put(Long.valueOf(l), paramawqb);
          i = 1;
          a(paramInt, paramawqb);
          if (i != 0)
          {
            paramawqb.abZ(paramString);
            if (i == 0) {
              break label175;
            }
            a(paramawqb, 1, 0, null);
          }
        }
        else
        {
          if (!localawqb.a().canRestart()) {
            break label181;
          }
          paramawqb.a().state = localawqb.a().state;
          paramawqb.a().errorCode = localawqb.a().errorCode;
          this.mJobs.put(Long.valueOf(l), paramawqb);
          i = 1;
        }
      }
      localawqb.setPriority(paramawqb.isPriority());
      localawqb.setIgnoreNetLimit(paramawqb.isIgnoreNetLimit());
      continue;
      label175:
      paramawqb = localawqb;
      continue;
      label181:
      int i = 0;
    }
  }
  
  public void a(long paramLong, awpy.a parama)
  {
    awqb localawqb;
    synchronized (this.mJobs)
    {
      localawqb = (awqb)this.mJobs.get(Long.valueOf(paramLong));
      if (localawqb == null) {
        return;
      }
    }
    if (!localawqb.isCanceled())
    {
      if ((parama == null) || (TextUtils.isEmpty(parama.downloadUrl)))
      {
        a(localawqb, 5, 1829002, null);
        return;
      }
      if (!isNetAvailable(localawqb.isIgnoreNetLimit()))
      {
        a(localawqb, 5, 1810004, null);
        return;
      }
      ??? = awqb.a(localawqb, parama.downloadUrl, localawqb.Hn(), parama.cookie, b, this, cA(localawqb.Hn(), localawqb.b().fileId));
      localawqb.b((aoll)???);
      localawqb.setFileVersion(parama.fileVersion);
      localawqb.a().fileVersion = parama.fileVersion;
      a(paramLong, (aomg)???);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, awqb.a parama, boolean paramBoolean2)
  {
    synchronized (this.mJobs)
    {
      awqb localawqb = (awqb)this.mJobs.get(Long.valueOf(paramLong));
      ??? = localawqb;
      if (localawqb != null) {
        break label66;
      }
      if (parama == null) {
        parama = null;
      }
    }
    parama = parama.a;
    label66:
    do
    {
      a((awqb)???, paramBoolean2);
      return;
      ??? = parama;
    } while (parama != null);
  }
  
  public void a(long paramLong, boolean paramBoolean, awqb paramawqb)
  {
    synchronized (this.mJobs)
    {
      awqb localawqb = (awqb)this.mJobs.get(Long.valueOf(paramLong));
      if (localawqb != null) {
        a(localawqb, 5, 1810002, null);
      }
      if (paramawqb != null)
      {
        paramawqb.a().state = 0;
        paramawqb.a().errorCode = 1810002;
        a(paramawqb, true);
      }
      return;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    awqb localawqb;
    synchronized (this.mJobs)
    {
      localawqb = (awqb)this.mJobs.get(Long.valueOf(paramLong));
      if (localawqb == null) {
        return;
      }
    }
    if (!localawqb.isCanceled())
    {
      localawqb.abZ(paramString);
      if (paramBoolean1)
      {
        a(localawqb, 4, 0, null);
        return;
      }
      if (paramBoolean2)
      {
        a(localawqb, 5, 1810008, null);
        return;
      }
      if (paramBoolean3)
      {
        a(localawqb, 5, 1810031, null);
        return;
      }
      if (!isNetAvailable(localawqb.isIgnoreNetLimit()))
      {
        a(localawqb, 5, 1810004, null);
        return;
      }
      this.jdField_a_of_type_Awqq.a(localawqb, DownloadType.FILE_ORDINARY.ordinal());
    }
  }
  
  void a(awqb paramawqb, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Awqc.a();
    this.jdField_a_of_type_Awqc.a(paramawqb, paramInt1, paramInt2);
  }
  
  void a(awqb paramawqb, int paramInt1, int paramInt2, String paramString)
  {
    if (paramawqb == null) {}
    boolean bool;
    label47:
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        bool = true;
      }
    } while (!bool);
    int i = paramawqb.a().state;
    paramawqb.a().state = paramInt1;
    paramawqb.a().errorCode = paramInt2;
    paramawqb.a().errorMsg = awqa.convertErrorMessage(paramInt2, paramString);
    this.jdField_a_of_type_Awqo.b(paramawqb, true);
    a(paramawqb, i, paramInt1);
    return;
    nV(paramawqb.dbId());
    i = 1;
    paramInt1 = 1;
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            if ((i != 0) || (paramawqb.a().canRestart()))
            {
              bool = true;
              label139:
              if (!bool) {
                break label793;
              }
              synchronized (this.mWaitNetJobs)
              {
                this.mWaitNetJobs.remove(Long.valueOf(paramawqb.dbId()));
              }
            }
            synchronized (this.mFailedJobs)
            {
              this.mFailedJobs.remove(Long.valueOf(paramawqb.dbId()));
              paramawqb.setCanceled(false);
              this.jdField_a_of_type_Awqp.a(paramawqb);
              break;
              bool = false;
              break label139;
              paramawqb = finally;
              throw paramawqb;
            }
          }
          bool = paramawqb.a().canRunning();
          break;
          bool = paramawqb.a().canSuspend();
          if (!bool) {
            break label790;
          }
          synchronized (this.mWaitNetJobs)
          {
            this.mWaitNetJobs.remove(Long.valueOf(paramawqb.dbId()));
            paramawqb.setCanceled(true);
            paramawqb.setIgnoreNetLimit(false);
            if (this.c == null) {
              this.c = awqs.a();
            }
            this.c.b(paramawqb.b());
            nV(paramawqb.dbId());
          }
        }
        if (paramInt2 == 1810002) {
          synchronized (this.mJobs)
          {
            this.mJobs.remove(Long.valueOf(paramawqb.dbId()));
            synchronized (this.mFlowIds)
            {
              this.mFlowIds.removeByKey(Long.valueOf(paramawqb.dbId()));
              synchronized (this.mWaitNetJobs)
              {
                this.mWaitNetJobs.remove(Long.valueOf(paramawqb.dbId()));
              }
            }
          }
        }
        for (;;)
        {
          synchronized (this.mFailedJobs)
          {
            this.mFailedJobs.remove(Long.valueOf(paramawqb.dbId()));
            paramawqb.setCanceled(true);
            if (this.c == null) {
              this.c = awqs.a();
            }
            this.c.b(paramawqb.b());
            paramInt1 = 0;
            nV(paramawqb.dbId());
            bool = true;
            break;
            paramawqb = finally;
            throw paramawqb;
            paramawqb = finally;
            throw paramawqb;
            paramawqb = finally;
            throw paramawqb;
          }
          if ((paramInt2 == 1810003) || (paramInt2 == 1810004)) {
            synchronized (this.mWaitNetJobs)
            {
              this.mWaitNetJobs.add(Long.valueOf(paramawqb.dbId()));
              paramInt1 = 1;
            }
          }
          synchronized (this.mFailedJobs)
          {
            this.mFailedJobs.add(Long.valueOf(paramawqb.dbId()));
          }
        }
        synchronized (this.mJobs)
        {
          this.mJobs.remove(Long.valueOf(paramawqb.dbId()));
          synchronized (this.mFlowIds)
          {
            this.mFlowIds.removeByKey(Long.valueOf(paramawqb.dbId()));
            synchronized (this.mWaitNetJobs)
            {
              this.mWaitNetJobs.remove(Long.valueOf(paramawqb.dbId()));
            }
          }
        }
        synchronized (this.mFailedJobs)
        {
          this.mFailedJobs.remove(Long.valueOf(paramawqb.dbId()));
          paramawqb.a().filePath = paramawqb.Hn();
          paramawqb.a().currSize = paramawqb.a().totalSize;
          paramawqb.a().a = paramawqb;
          nV(paramawqb.dbId());
          break;
          paramawqb = finally;
          throw paramawqb;
          paramawqb = finally;
          throw paramawqb;
          paramawqb = finally;
          throw paramawqb;
        }
      }
      label790:
      break label47;
      label793:
      break label47;
      i = 0;
    }
  }
  
  void a(awqb paramawqb, boolean paramBoolean)
  {
    if (paramawqb == null) {}
    do
    {
      return;
      Iterator localIterator = new ArrayList(this.mListeners).iterator();
      while (localIterator.hasNext())
      {
        awqd.c localc = (awqd.c)localIterator.next();
        if (localc != null) {
          localc.a(paramawqb.uid(), paramawqb.dbId(), paramawqb.b(), paramBoolean);
        }
      }
    } while (paramawqb.a() == null);
    paramawqb.a().a(paramawqb.uid(), paramawqb.dbId(), paramawqb.b(), paramBoolean);
  }
  
  public void a(awqd.d paramd, Context paramContext)
  {
    this.jdField_a_of_type_Awqd$d = paramd;
    if (this.jdField_a_of_type_Awqd$d == null) {
      throw new NullPointerException("IFetchListener can not be null!");
    }
    this.mListeners = new ArrayList();
    paramd = new ReleaseLooperHandler("weiyun_download-work-thread");
    this.jdField_a_of_type_Awqo = new awqo(this, paramd);
    this.jdField_a_of_type_Awqp = new awqp(this, paramd);
    this.jdField_a_of_type_Awqq = new awqq(this, this.jdField_a_of_type_Awqd$d, paramd);
    this.mContext = paramContext;
    this.jdField_a_of_type_Awqo.restoreInfo(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, awqd.b paramb)
  {
    a(paramString1, paramString2, null, paramString3, paramb, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, awqd.b paramb, String paramString5)
  {
    paramString1 = awqb.a(paramString4, paramString1, paramString2, paramString3, b, new awqi(this, paramb, paramString4, paramString2));
    if (this.h == null) {
      this.h = awqs.d();
    }
    this.mThreadPool.submit(new awqj(this, paramString1));
    if (paramString5 != null) {
      this.qu.put(paramString5, paramString1);
    }
  }
  
  public awqc b()
  {
    return this.jdField_a_of_type_Awqc.a();
  }
  
  String b(awpy paramawpy, String paramString, boolean paramBoolean, awqd.c paramc)
  {
    int i = FLOW_ID.getAndIncrement();
    paramString = awqb.a(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid(), paramawpy, paramString, new awqb.a());
    paramString.setIgnoreNetLimit(paramBoolean);
    paramString.a().fileId = paramawpy.fileId;
    paramString.a(paramc);
    this.jdField_a_of_type_Awqo.b(i, paramString);
    return Integer.toString(i);
  }
  
  public void b(awqd.c paramc)
  {
    this.mListeners.add(paramc);
  }
  
  public void c(awqd.c paramc)
  {
    if (this.mListeners.contains(paramc)) {
      this.mListeners.remove(paramc);
    }
  }
  
  void cM(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      ArrayList localArrayList = new ArrayList();
      synchronized (this.mWaitNetJobs)
      {
        localArrayList.addAll(this.mWaitNetJobs);
        ??? = localArrayList.iterator();
        if (!((Iterator)???).hasNext()) {
          return;
        }
        restartJobInner(((Long)((Iterator)???).next()).longValue(), false, false, false, false);
      }
    }
    for (;;)
    {
      awqb localawqb;
      synchronized (this.mJobs)
      {
        Iterator localIterator = this.mJobs.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localawqb = (awqb)((Map.Entry)localIterator.next()).getValue();
        if ((!localawqb.isIgnoreNetLimit()) || (!paramBoolean2))
        {
          if (!localawqb.a().canSuspend()) {
            continue;
          }
          localawqb.setCanceled(true);
          if (this.c != null) {
            this.c.b(localawqb.b());
          }
          a(localawqb, 5, 1810004, null);
        }
      }
      if ((localawqb.isIgnoreNetLimit()) && (paramBoolean2) && (localawqb.a().waitingNet())) {
        restartJobInner(localawqb.dbId(), false, false, false, false);
      }
    }
  }
  
  public boolean canSuspendAll()
  {
    awqc localawqc = this.jdField_a_of_type_Awqc.a();
    int i = localawqc.wait;
    return localawqc.running + i > 0;
  }
  
  boolean isNetAvailable(boolean paramBoolean)
  {
    Context localContext = WeiyunTransmissionGlobal.getInstance().getContext();
    boolean bool = WeiyunTransmissionStatus.getInstance().isTranOnlyWifi();
    if ((paramBoolean) || (!bool)) {
      return NetworkUtils.isNetworkAvailable(localContext);
    }
    return NetworkUtils.isWifiAvailable(localContext);
  }
  
  public void onFetchError(long paramLong, int paramInt, String paramString)
  {
    awqb localawqb;
    synchronized (this.mJobs)
    {
      localawqb = (awqb)this.mJobs.get(Long.valueOf(paramLong));
      if (localawqb == null) {
        return;
      }
    }
    if (!localawqb.isCanceled())
    {
      if (!aqiw.isNetworkAvailable(this.mContext))
      {
        a(localawqb, 5, 1810004, null);
        return;
      }
      a(localawqb, 5, paramInt, paramString);
    }
  }
  
  public void onInfoRestored(String arg1, List<awqb> paramList)
  {
    if ((!TextUtils.equals(???, WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid())) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    for (;;)
    {
      awqb localawqb;
      synchronized (this.mJobs)
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label199;
        }
        localawqb = (awqb)paramList.next();
        long l = localawqb.dbId();
        int i = localawqb.a().state;
        localawqb.a().state = 0;
        this.mJobs.put(Long.valueOf(l), localawqb);
        switch (i)
        {
        case 0: 
        case 1: 
        case 2: 
          a(localawqb, 1, 0, null);
        }
      }
      a(localawqb, 3, 0, null);
      continue;
      a(localawqb, 5, localawqb.a().errorCode, localawqb.a().errorMsg);
      continue;
      label199:
      return;
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mResult == 3) {}
    int j;
    label125:
    do
    {
      return;
      if (paramaomh.mResult == 0) {}
      for (int i = 1;; i = 0)
      {
        j = paramaomh.mErrCode;
        paramaomh = ((aoll)paramaomh.b).U();
        if ((paramaomh == null) || (!(paramaomh instanceof awqb))) {
          break;
        }
        paramaomh = (awqb)paramaomh;
        if ((paramaomh == null) || (paramaomh.isCanceled())) {
          break;
        }
        if (i == 0) {
          break label136;
        }
        File localFile = new File(paramaomh.Hn());
        if (!localFile.exists()) {
          break label125;
        }
        if (!f(WeiyunTransmissionGlobal.getInstance().getContext(), localFile)) {
          IOUtils.scan2MediaStore(WeiyunTransmissionGlobal.getInstance().getContext(), localFile);
        }
        a(paramaomh, 4, 0, null);
        return;
      }
      a(paramaomh, 5, 1810031, null);
      return;
    } while (paramaomh.isCanceled());
    label136:
    if (awqa.shouldRetry(j))
    {
      a(paramaomh, 0, j, null);
      return;
    }
    a(paramaomh, 5, j, null);
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    paramaomg = paramaomg.U();
    if ((paramaomg != null) && ((paramaomg instanceof awqb)))
    {
      paramaomg = (awqb)paramaomg;
      if (paramaomg != null) {
        break label26;
      }
    }
    label26:
    while (paramaomg.isCanceled()) {
      return;
    }
    if (paramaomg.a().canRunning()) {
      a(paramaomg, 2, 0, null);
    }
    paramaomg.a().totalSize = paramLong2;
    awqb.a locala = paramaomg.a();
    if (paramLong1 < paramLong2) {}
    for (;;)
    {
      locala.currSize = paramLong1;
      a(paramaomg, false);
      return;
      paramLong1 = paramLong2;
    }
  }
  
  public int removeAllFailed()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mFailedJobs)
    {
      int i = this.mFailedJobs.size();
      localArrayList.addAll(this.mFailedJobs);
      if (!localArrayList.isEmpty()) {
        this.mThreadPool.submit(new awqn(this, localArrayList));
      }
      return i;
    }
  }
  
  public boolean removeJob(long paramLong)
  {
    this.jdField_a_of_type_Awqo.removeInfo(paramLong, true);
    return true;
  }
  
  public boolean removeJob(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.h != null)
    {
      ??? = (aoll)this.qu.get(paramString);
      if (??? != null) {
        this.h.b((aomg)???);
      }
    }
    synchronized (this.mFlowIds)
    {
      paramString = (Long)this.mFlowIds.getByValue(paramString);
      if (paramString == null) {
        return false;
      }
    }
    this.jdField_a_of_type_Awqo.removeInfo(paramString.longValue(), true);
    return true;
  }
  
  public boolean restartJob(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    synchronized (this.mJobs)
    {
      awqb localawqb1 = (awqb)this.mJobs.get(Long.valueOf(paramLong));
      if (localawqb1 == null)
      {
        nV(paramLong);
        return false;
      }
    }
    if (paramBoolean1)
    {
      localawqb2.setPriority(paramBoolean2);
      localawqb2.setIgnoreNetLimit(paramBoolean3);
    }
    a(localawqb2, 1, 0, null);
    return true;
  }
  
  public int suspendAll()
  {
    ??? = this.jdField_a_of_type_Awqc.a();
    int i = ((awqc)???).failed;
    int j = ((awqc)???).wait;
    int k = ((awqc)???).running;
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mJobs)
    {
      localArrayList.addAll(this.mJobs.keySet());
      if (!localArrayList.isEmpty()) {
        this.mThreadPool.submit(new awqm(this, localArrayList));
      }
      return k + (i + j);
    }
  }
  
  public boolean suspendJob(long paramLong)
  {
    synchronized (this.mJobs)
    {
      awqb localawqb1 = (awqb)this.mJobs.get(Long.valueOf(paramLong));
      if (localawqb1 == null)
      {
        nV(paramLong);
        return false;
      }
    }
    a(localawqb2, 3, 0, null);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(awpy paramawpy, boolean paramBoolean, int paramInt, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt);
    
    public abstract void onDownloadProgress(String paramString, long paramLong, float paramFloat);
  }
  
  public static abstract interface c
  {
    public abstract void IJ(String paramString);
    
    public abstract void a(String paramString, long paramLong, awqb.a parama, boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void a(awpy paramawpy, DownloadType paramDownloadType, awqd.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqd
 * JD-Core Version:    0.7.0.1
 */