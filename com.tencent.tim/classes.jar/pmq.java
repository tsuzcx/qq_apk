import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.DownloadingUrlEntry;
import com.tencent.biz.qqstory.database.VideoUrlEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class pmq
  extends prz
{
  private LruCache<String, List<VideoUrlEntry>> e = new LruCache(100);
  private LruCache<String, DownloadingUrlEntry> f = new LruCache(300);
  private LruCache<String, pmq.a> g = new LruCache(200);
  private final ReentrantLock l = new ReentrantLock();
  
  private DownloadingUrlEntry a(String paramString, int paramInt)
  {
    Object localObject = (DownloadingUrlEntry)this.f.get(DownloadingUrlEntry.makeKey(paramString, paramInt));
    if (localObject != null) {
      return localObject;
    }
    localObject = psu.a(QQStoryContext.a().getEntityManagerFactory().createEntityManager(), DownloadingUrlEntry.class, DownloadingUrlEntry.class.getSimpleName(), "key=?", new String[] { DownloadingUrlEntry.makeKey(paramString, paramInt) });
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (DownloadingUrlEntry)((List)localObject).get(0);
      this.f.put(DownloadingUrlEntry.makeKey(paramString, paramInt), localObject);
      return localObject;
    }
    return null;
  }
  
  private pmq.a a(String paramString, int paramInt)
  {
    paramString = DownloadingUrlEntry.makeKey(paramString, paramInt);
    paramString = (pmq.a)this.g.get(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.url)) && (Math.abs(System.currentTimeMillis() - paramString.Ae) <= 300000L)) {
      return paramString;
    }
    return null;
  }
  
  private void a(@NonNull String paramString, @NonNull pmq.b paramb)
  {
    ram.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary , vid = %s", paramString);
    Bosses.get().postJob(new pmv(this, "Q.qqstory.DownloadUrlManager", paramString, paramb));
  }
  
  @Deprecated
  private void b(@NonNull String paramString, @NonNull pmq.b paramb)
  {
    ram.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessaryInner , vid = %s", paramString);
    Object localObject = ((psu)psx.a(5)).a(paramString);
    if (localObject == null)
    {
      ram.e("Q.qqstory.DownloadUrlManager", "DownloadUrlQueryResult:: error video is null");
      paramb.aD(false);
      return;
    }
    if (((StoryVideoItem)localObject).videoUrlExpireTime <= 0L)
    {
      paramb.aD(false);
      return;
    }
    if (((StoryVideoItem)localObject).videoUrlExpireTime - NetConnInfoCenter.getServerTimeMillis() > 0L)
    {
      paramb.aD(false);
      return;
    }
    ram.w("Q.qqstory.DownloadUrlManager", ((StoryVideoItem)localObject).mVid + " request video url is expire :" + ((StoryVideoItem)localObject).videoUrlExpireTime);
    localObject = new pzl();
    ((pzl)localObject).nv = new ArrayList(1);
    ((pzl)localObject).nv.add(paramString);
    ((pzl)localObject).timeOut = 10000L;
    paramString = new pmw(this, paramb, paramString);
    ppv.a().a((ppw)localObject, paramString);
  }
  
  /* Error */
  private boolean eW(String paramString)
  {
    // Byte code:
    //   0: iconst_5
    //   1: invokestatic 171	psx:a	(I)Lpsj;
    //   4: checkcast 82	psu
    //   7: aload_1
    //   8: invokevirtual 174	psu:a	(Ljava/lang/String;)Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull +11 -> 24
    //   16: ldc 253
    //   18: aload_1
    //   19: invokestatic 179	ram:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_3
    //   25: getfield 188	com/tencent/biz/qqstory/model/item/StoryVideoItem:videoUrlExpireTime	J
    //   28: lconst_0
    //   29: lcmp
    //   30: ifgt +5 -> 35
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_3
    //   36: getfield 188	com/tencent/biz/qqstory/model/item/StoryVideoItem:videoUrlExpireTime	J
    //   39: invokestatic 193	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   42: lsub
    //   43: ldc2_w 254
    //   46: lcmp
    //   47: ifle +5 -> 52
    //   50: iconst_0
    //   51: ireturn
    //   52: ldc 135
    //   54: new 195	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   61: aload_3
    //   62: getfield 199	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVid	Ljava/lang/String;
    //   65: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 205
    //   70: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_3
    //   74: getfield 188	com/tencent/biz/qqstory/model/item/StoryVideoItem:videoUrlExpireTime	J
    //   77: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 214	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: new 216	pzl
    //   89: dup
    //   90: invokespecial 217	pzl:<init>	()V
    //   93: astore 4
    //   95: aload 4
    //   97: new 219	java/util/ArrayList
    //   100: dup
    //   101: iconst_1
    //   102: invokespecial 220	java/util/ArrayList:<init>	(I)V
    //   105: putfield 224	pzl:nv	Ljava/util/List;
    //   108: aload 4
    //   110: getfield 224	pzl:nv	Ljava/util/List;
    //   113: aload_1
    //   114: invokeinterface 228 2 0
    //   119: pop
    //   120: aload 4
    //   122: ldc2_w 229
    //   125: putfield 233	pzl:timeOut	J
    //   128: new 257	java/lang/Object
    //   131: dup
    //   132: invokespecial 258	java/lang/Object:<init>	()V
    //   135: astore_2
    //   136: new 260	java/util/concurrent/atomic/AtomicBoolean
    //   139: dup
    //   140: iconst_0
    //   141: invokespecial 262	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   144: astore 5
    //   146: new 260	java/util/concurrent/atomic/AtomicBoolean
    //   149: dup
    //   150: iconst_0
    //   151: invokespecial 262	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   154: astore 6
    //   156: new 264	pmx
    //   159: dup
    //   160: aload_0
    //   161: aload_1
    //   162: aload_2
    //   163: aload 5
    //   165: aload 6
    //   167: invokespecial 267	pmx:<init>	(Lpmq;Ljava/lang/String;Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   170: astore_1
    //   171: invokestatic 243	ppv:a	()Lppv;
    //   174: aload 4
    //   176: aload_1
    //   177: invokevirtual 246	ppv:a	(Lppw;Lppv$b;)V
    //   180: aload_3
    //   181: getfield 188	com/tencent/biz/qqstory/model/item/StoryVideoItem:videoUrlExpireTime	J
    //   184: invokestatic 193	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   187: lcmp
    //   188: ifle +13 -> 201
    //   191: ldc 135
    //   193: ldc_w 269
    //   196: invokestatic 214	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: iconst_0
    //   200: ireturn
    //   201: aload_2
    //   202: monitorenter
    //   203: ldc 135
    //   205: ldc_w 271
    //   208: invokestatic 214	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 5
    //   213: invokevirtual 274	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   216: ifne +16 -> 232
    //   219: aload 6
    //   221: iconst_1
    //   222: invokevirtual 277	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   225: aload_2
    //   226: ldc2_w 278
    //   229: invokevirtual 283	java/lang/Object:wait	(J)V
    //   232: aload_2
    //   233: monitorexit
    //   234: iconst_1
    //   235: ireturn
    //   236: astore_1
    //   237: aload_1
    //   238: invokevirtual 286	java/lang/InterruptedException:printStackTrace	()V
    //   241: goto -9 -> 232
    //   244: astore_1
    //   245: aload_2
    //   246: monitorexit
    //   247: aload_1
    //   248: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	pmq
    //   0	249	1	paramString	String
    //   135	111	2	localObject	Object
    //   11	170	3	localStoryVideoItem	StoryVideoItem
    //   93	82	4	localpzl	pzl
    //   144	68	5	localAtomicBoolean1	java.util.concurrent.atomic.AtomicBoolean
    //   154	66	6	localAtomicBoolean2	java.util.concurrent.atomic.AtomicBoolean
    // Exception table:
    //   from	to	target	type
    //   211	232	236	java/lang/InterruptedException
    //   203	211	244	finally
    //   211	232	244	finally
    //   232	234	244	finally
    //   237	241	244	finally
    //   245	247	244	finally
  }
  
  public static String fL(String paramString)
  {
    try
    {
      String str = new URL(paramString).getHost();
      if (!TextUtils.isEmpty(str))
      {
        str = aopd.a().aC(str, 1012);
        return str;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      ram.w("Q.qqstory.DownloadUrlManager", "getIpOfDomain url: %s", new Object[] { paramString });
    }
    return null;
  }
  
  public boolean Iv()
  {
    return true;
  }
  
  public List<VideoUrlEntry> L(String paramString)
  {
    Object localObject = (List)this.e.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    List localList = psu.a(QQStoryContext.a().getEntityManagerFactory().createEntityManager(), VideoUrlEntry.class, VideoUrlEntry.class.getSimpleName(), "vid=?", new String[] { paramString });
    localObject = localList;
    if (localList == null) {
      localObject = new ArrayList(0);
    }
    this.e.put(paramString, localObject);
    return localObject;
  }
  
  public pmq.a a(String paramString, int paramInt, boolean paramBoolean)
  {
    rom.bvL();
    String str = DownloadingUrlEntry.makeKey(paramString, paramInt);
    pmq.a locala = new pmq.a();
    locala.vid = paramString;
    locala.fileType = paramInt;
    psu localpsu = (psu)psx.a(5);
    label651:
    label697:
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        this.l.lock();
        localObject1 = a(paramString, paramInt);
        if ((localObject1 != null) && (((DownloadingUrlEntry)localObject1).bIsDownloadCompleted == 0))
        {
          locala.bjs = 0;
          locala.url = ((DownloadingUrlEntry)localObject1).url;
          locala.compressLevel = ((DownloadingUrlEntry)localObject1).compressLevel;
          return locala;
        }
        locala.aAJ = true;
        localObject2 = null;
        localObject1 = localObject2;
        if (paramInt == 0)
        {
          localObject1 = localObject2;
          if (Iv())
          {
            List localList = L(paramString);
            localObject1 = localObject2;
            if (localList != null)
            {
              localObject1 = localObject2;
              if (localList.size() > 0)
              {
                localObject2 = (VideoUrlEntry)localList.get(0);
                localObject1 = new DownloadingUrlEntry();
                ((DownloadingUrlEntry)localObject1).vid = ((VideoUrlEntry)localObject2).vid;
                ((DownloadingUrlEntry)localObject1).url = ((VideoUrlEntry)localObject2).videoUrl;
                ((DownloadingUrlEntry)localObject1).fileType = 0;
                ((DownloadingUrlEntry)localObject1).compressLevel = ((VideoUrlEntry)localObject2).videoUrlLevel;
                ((DownloadingUrlEntry)localObject1).key = DownloadingUrlEntry.makeKey(((DownloadingUrlEntry)localObject1).vid, ((DownloadingUrlEntry)localObject1).fileType);
                locala.bjs = 2;
                locala.url = ((DownloadingUrlEntry)localObject1).url;
                locala.compressLevel = ((VideoUrlEntry)localObject2).videoUrlLevel;
              }
            }
          }
        }
        if (locala.bjs != -1) {
          break label697;
        }
        localObject2 = localpsu.a(paramString);
        if (localObject2 == null) {
          break label697;
        }
        localObject1 = new DownloadingUrlEntry();
        ((DownloadingUrlEntry)localObject1).vid = ((StoryVideoItem)localObject2).mVid;
        ((DownloadingUrlEntry)localObject1).fileType = paramInt;
        if (paramInt == 0)
        {
          ((DownloadingUrlEntry)localObject1).url = ((StoryVideoItem)localObject2).getVideoUrl();
          ((DownloadingUrlEntry)localObject1).key = DownloadingUrlEntry.makeKey(((DownloadingUrlEntry)localObject1).vid, ((DownloadingUrlEntry)localObject1).fileType);
          locala.bjs = 3;
          locala.url = ((DownloadingUrlEntry)localObject1).url;
          if ((localObject1 != null) && (!TextUtils.isEmpty(((DownloadingUrlEntry)localObject1).url)))
          {
            localObject2 = pnh.a(paramString, paramInt, false, false);
            if ((localObject2 == null) || (!((File)localObject2).exists()))
            {
              ((DownloadingUrlEntry)localObject1).updatedMs = System.currentTimeMillis();
              this.f.put(DownloadingUrlEntry.makeKey(paramString, paramInt), localObject1);
              QQStoryContext.a().getEntityManagerFactory().createEntityManager().persistOrReplace((Entity)localObject1);
            }
          }
          if (paramBoolean)
          {
            ram.w("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: video url have expire,so we need to handle the temOrphan~~");
            paramString = a(paramString, paramInt);
            if ((paramString == null) || (!TextUtils.equals(paramString.url, locala.url))) {
              break label651;
            }
            ram.w("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: set isTmpOrphan false,cache entry url=" + paramString.url + " result url=" + locala.url);
            locala.aAJ = false;
          }
          return locala;
        }
        if (paramInt == 1)
        {
          ((DownloadingUrlEntry)localObject1).url = ((StoryVideoItem)localObject2).getDownloadMaskUrl();
          continue;
        }
        if (paramInt != 2) {
          continue;
        }
      }
      finally
      {
        locala.dump();
        locala.Ae = System.currentTimeMillis();
        this.g.put(str, locala);
        this.l.unlock();
      }
      ((DownloadingUrlEntry)localObject1).url = ((StoryVideoItem)localObject2).getThumbUrl();
      continue;
      if (paramString == null) {
        ram.w("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: set isTmpOrphan true,cache entry url");
      } else {
        ram.w("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: set isTmpOrphan true,cache entry url :" + paramString.url);
      }
    }
  }
  
  public void a(String paramString, int paramInt, pmq.c paramc)
  {
    pmq.a locala = a(paramString, paramInt);
    if (locala != null)
    {
      paramc.a(locala);
      return;
    }
    if (paramInt == 0)
    {
      a(paramString, new pmr(this, paramString, paramInt, paramc));
      return;
    }
    Bosses.get().postJob(new pms(this, "Q.qqstory.DownloadUrlManager", paramString, paramInt, paramc));
  }
  
  public pmq.a b(String paramString, int paramInt)
  {
    rom.bvL();
    pmq.a locala = new pmq.a();
    locala.vid = paramString;
    locala.fileType = paramInt;
    psu localpsu = (psu)psx.a(5);
    label644:
    label647:
    for (;;)
    {
      int i;
      Object localObject2;
      Object localObject1;
      try
      {
        this.l.lock();
        if ((paramInt == 0) && (eW(paramString)))
        {
          i = 1;
          locala.aAJ = true;
          localObject2 = null;
          localObject1 = localObject2;
          if (paramInt == 0)
          {
            localObject1 = localObject2;
            if (Iv())
            {
              List localList = L(paramString);
              localObject1 = localObject2;
              if (localList != null)
              {
                localObject1 = localObject2;
                if (localList.size() > 0)
                {
                  localObject2 = (VideoUrlEntry)localList.get(0);
                  localObject1 = new DownloadingUrlEntry();
                  ((DownloadingUrlEntry)localObject1).vid = ((VideoUrlEntry)localObject2).vid;
                  ((DownloadingUrlEntry)localObject1).url = ((VideoUrlEntry)localObject2).videoUrl;
                  ((DownloadingUrlEntry)localObject1).fileType = 0;
                  ((DownloadingUrlEntry)localObject1).compressLevel = ((VideoUrlEntry)localObject2).videoUrlLevel;
                  ((DownloadingUrlEntry)localObject1).key = DownloadingUrlEntry.makeKey(((DownloadingUrlEntry)localObject1).vid, ((DownloadingUrlEntry)localObject1).fileType);
                  locala.bjs = 2;
                  locala.url = ((DownloadingUrlEntry)localObject1).url;
                  locala.compressLevel = ((VideoUrlEntry)localObject2).videoUrlLevel;
                }
              }
            }
          }
          if (locala.bjs != -1) {
            break label644;
          }
          localObject2 = localpsu.a(paramString);
          if (localObject2 == null) {
            break label644;
          }
          localObject1 = new DownloadingUrlEntry();
          ((DownloadingUrlEntry)localObject1).vid = ((StoryVideoItem)localObject2).mVid;
          ((DownloadingUrlEntry)localObject1).fileType = paramInt;
          if (paramInt == 0)
          {
            ((DownloadingUrlEntry)localObject1).url = ((StoryVideoItem)localObject2).getVideoUrl();
            ((DownloadingUrlEntry)localObject1).key = DownloadingUrlEntry.makeKey(((DownloadingUrlEntry)localObject1).vid, ((DownloadingUrlEntry)localObject1).fileType);
            locala.bjs = 3;
            locala.url = ((DownloadingUrlEntry)localObject1).url;
            if ((localObject1 != null) && (!TextUtils.isEmpty(((DownloadingUrlEntry)localObject1).url)))
            {
              localObject2 = pnh.a(paramString, paramInt, false, false);
              if ((localObject2 == null) || (!((File)localObject2).exists()))
              {
                ((DownloadingUrlEntry)localObject1).updatedMs = System.currentTimeMillis();
                this.f.put(DownloadingUrlEntry.makeKey(paramString, paramInt), localObject1);
                QQStoryContext.a().getEntityManagerFactory().createEntityManager().persistOrReplace((Entity)localObject1);
              }
            }
            if (i != 0)
            {
              ram.w("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: video url have expire,so we need to handle the temOrphan~~");
              paramString = a(paramString, paramInt);
              if ((paramString == null) || (!TextUtils.equals(paramString.url, locala.url))) {
                break label598;
              }
              ram.w("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: set isTmpOrphan false,cache entry url=" + paramString.url + " result url=" + locala.url);
              locala.aAJ = false;
            }
            return locala;
          }
        }
        else
        {
          localObject1 = a(paramString, paramInt);
          if ((localObject1 == null) || (((DownloadingUrlEntry)localObject1).bIsDownloadCompleted != 0)) {
            break label647;
          }
          locala.bjs = 0;
          locala.url = ((DownloadingUrlEntry)localObject1).url;
          locala.compressLevel = ((DownloadingUrlEntry)localObject1).compressLevel;
          return locala;
        }
        if (paramInt == 1)
        {
          ((DownloadingUrlEntry)localObject1).url = ((StoryVideoItem)localObject2).getDownloadMaskUrl();
          continue;
        }
        if (paramInt != 2) {
          continue;
        }
      }
      finally
      {
        locala.dump();
        this.l.unlock();
      }
      ((DownloadingUrlEntry)localObject1).url = ((StoryVideoItem)localObject2).getThumbUrl();
      continue;
      label598:
      if (paramString == null)
      {
        ram.w("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: set isTmpOrphan true,cache entry url");
      }
      else
      {
        ram.w("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: set isTmpOrphan true,cache entry url :" + paramString.url);
        continue;
        continue;
        i = 0;
      }
    }
  }
  
  public void bf(String paramString, int paramInt)
  {
    if ((paramInt != 0) || (rnw.fy(paramString))) {
      return;
    }
    Bosses.get().postJob(new pmt(this, "Q.qqstory.DownloadUrlManager", paramString, paramInt));
  }
  
  public void bg(String paramString, int paramInt)
  {
    Bosses.get().postJob(new pmu(this, "Q.qqstory.DownloadUrlManager", paramString, paramInt));
  }
  
  public void bh(String paramString, int paramInt)
  {
    try
    {
      this.l.lock();
      Object localObject = DownloadingUrlEntry.makeKey(paramString, paramInt);
      this.f.remove(localObject);
      localObject = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
      paramString = psu.a((EntityManager)localObject, DownloadingUrlEntry.class, DownloadingUrlEntry.class.getSimpleName(), "key=?", new String[] { DownloadingUrlEntry.makeKey(paramString, paramInt) });
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = (DownloadingUrlEntry)paramString.get(0);
        paramString.setStatus(1001);
        ((EntityManager)localObject).remove(paramString);
      }
      return;
    }
    finally
    {
      this.l.unlock();
    }
  }
  
  public void dT(List<VideoUrlEntry> paramList)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramList);
    updateList(localArrayList);
  }
  
  public String[] e(String paramString)
  {
    ram.b("Q.qqstory.DownloadUrlManager", "replaceDomain2Ip domain - url: %s", paramString);
    if (!TextUtils.isEmpty(paramString)) {}
    label306:
    for (;;)
    {
      try
      {
        URL localURL = new URL(paramString);
        String str3 = localURL.getHost();
        if (!TextUtils.isEmpty(str3))
        {
          Object localObject = aopd.a().a(str3, 1012);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            if (((List)localObject).size() <= 2) {
              break label306;
            }
            localObject = ((List)localObject).subList(0, 2);
            String[] arrayOfString = new String[((List)localObject).size() + 1];
            int i = 0;
            if (i < ((List)localObject).size())
            {
              String str2 = localURL.getProtocol() + "://" + (String)((List)localObject).get(i) + "/" + localURL.getFile();
              String str1 = str2;
              if (!str2.contains("txhost="))
              {
                if (!str2.contains("&")) {
                  str1 = str2 + "?txhost=" + str3;
                }
              }
              else
              {
                arrayOfString[i] = str1;
                ram.b("Q.qqstory.DownloadUrlManager", "replaceDomain2Ip ip - url: %s", str1);
                i += 1;
                continue;
              }
              str1 = str2 + "&txhost=" + str3;
              continue;
            }
            arrayOfString[(arrayOfString.length - 1)] = paramString;
            return arrayOfString;
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        ram.w("Q.qqstory.DownloadUrlManager", "replaceDomain2Ip MalformedURLException: %s", localMalformedURLException);
      }
      return new String[] { paramString };
    }
  }
  
  public void updateList(List<List<VideoUrlEntry>> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    ram.b("Q.qqstory.DownloadUrlManager", "update video url:%s", paramList);
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    for (;;)
    {
      List localList;
      VideoUrlEntry localVideoUrlEntry1;
      try
      {
        localEntityManager.getTransaction().begin();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        localList = (List)paramList.next();
        if (localList.isEmpty()) {
          continue;
        }
        localVideoUrlEntry1 = new VideoUrlEntry();
        localVideoUrlEntry1.vid = ((VideoUrlEntry)localList.get(0)).vid;
        localVideoUrlEntry1.setStatus(1001);
        localEntityManager.remove(localVideoUrlEntry1, "vid=?", new String[] { localVideoUrlEntry1.vid });
        Iterator localIterator = localList.iterator();
        if (!localIterator.hasNext()) {
          break label218;
        }
        VideoUrlEntry localVideoUrlEntry2 = (VideoUrlEntry)localIterator.next();
        if (TextUtils.isEmpty(localVideoUrlEntry2.videoUrl))
        {
          localIterator.remove();
          ram.w("Q.qqstory.DownloadUrlManager", "%s url error!", new Object[] { localVideoUrlEntry2.vid });
          continue;
        }
        localEntityManager.persistOrReplace(localVideoUrlEntry2);
      }
      finally
      {
        localEntityManager.getTransaction().end();
      }
      continue;
      label218:
      this.e.put(localVideoUrlEntry1.vid, localList);
    }
    localEntityManager.getTransaction().commit();
    localEntityManager.getTransaction().end();
  }
  
  public static class a
  {
    public long Ae;
    public boolean aAJ;
    public int bjs = -1;
    public int compressLevel;
    public int fileType;
    public String url;
    public String vid;
    
    public void dump() {}
  }
  
  static abstract interface b
  {
    public abstract void aD(boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void a(pmq.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pmq
 * JD-Core Version:    0.7.0.1
 */