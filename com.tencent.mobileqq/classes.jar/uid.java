import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.DownloadingUrlEntry;
import com.tencent.biz.qqstory.database.VideoUrlEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class uid
  extends uqn
{
  private LruCache<String, List<VideoUrlEntry>> jdField_a_of_type_AndroidUtilLruCache = new LruCache(100);
  private final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private LruCache<String, DownloadingUrlEntry> b = new LruCache(300);
  private LruCache<String, uil> c = new LruCache(200);
  
  private DownloadingUrlEntry a(String paramString, int paramInt)
  {
    Object localObject = (DownloadingUrlEntry)this.b.get(DownloadingUrlEntry.makeKey(paramString, paramInt));
    if (localObject != null) {
      return localObject;
    }
    localObject = uro.a(QQStoryContext.a().a().createEntityManager(), DownloadingUrlEntry.class, DownloadingUrlEntry.class.getSimpleName(), "key=?", new String[] { DownloadingUrlEntry.makeKey(paramString, paramInt) });
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (DownloadingUrlEntry)((List)localObject).get(0);
      this.b.put(DownloadingUrlEntry.makeKey(paramString, paramInt), localObject);
      return localObject;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    try
    {
      String str = new URL(paramString).getHost();
      if (!TextUtils.isEmpty(str))
      {
        str = bavf.a().a(str, 1012);
        return str;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      wsv.d("Q.qqstory.DownloadUrlManager", "getIpOfDomain url: %s", new Object[] { paramString });
    }
    return null;
  }
  
  private void a(@NonNull String paramString, @NonNull uim paramuim)
  {
    wsv.b("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary , vid = %s", paramString);
    Bosses.get().postJob(new uii(this, "Q.qqstory.DownloadUrlManager", paramString, paramuim));
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_5
    //   1: invokestatic 162	urr:a	(I)Luqz;
    //   4: checkcast 71	uro
    //   7: aload_1
    //   8: invokevirtual 165	uro:a	(Ljava/lang/String;)Lcom/tencent/biz/qqstory/model/item/StoryVideoItem;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull +11 -> 24
    //   16: ldc 167
    //   18: aload_1
    //   19: invokestatic 171	wsv:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_3
    //   25: getfield 177	com/tencent/biz/qqstory/model/item/StoryVideoItem:videoUrlExpireTime	J
    //   28: lconst_0
    //   29: lcmp
    //   30: ifgt +5 -> 35
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_3
    //   36: getfield 177	com/tencent/biz/qqstory/model/item/StoryVideoItem:videoUrlExpireTime	J
    //   39: invokestatic 183	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   42: lsub
    //   43: ldc2_w 184
    //   46: lcmp
    //   47: ifle +5 -> 52
    //   50: iconst_0
    //   51: ireturn
    //   52: ldc 116
    //   54: new 187	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   61: aload_3
    //   62: getfield 192	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVid	Ljava/lang/String;
    //   65: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 198
    //   70: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_3
    //   74: getfield 177	com/tencent/biz/qqstory/model/item/StoryVideoItem:videoUrlExpireTime	J
    //   77: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 206	wsv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: new 208	vby
    //   89: dup
    //   90: invokespecial 209	vby:<init>	()V
    //   93: astore 4
    //   95: aload 4
    //   97: new 211	java/util/ArrayList
    //   100: dup
    //   101: iconst_1
    //   102: invokespecial 212	java/util/ArrayList:<init>	(I)V
    //   105: putfield 215	vby:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   108: aload 4
    //   110: getfield 215	vby:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   113: aload_1
    //   114: invokeinterface 219 2 0
    //   119: pop
    //   120: aload 4
    //   122: ldc2_w 220
    //   125: putfield 223	vby:jdField_a_of_type_Long	J
    //   128: new 120	java/lang/Object
    //   131: dup
    //   132: invokespecial 224	java/lang/Object:<init>	()V
    //   135: astore_2
    //   136: new 226	java/util/concurrent/atomic/AtomicBoolean
    //   139: dup
    //   140: iconst_0
    //   141: invokespecial 229	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   144: astore 5
    //   146: new 226	java/util/concurrent/atomic/AtomicBoolean
    //   149: dup
    //   150: iconst_0
    //   151: invokespecial 229	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   154: astore 6
    //   156: new 231	uik
    //   159: dup
    //   160: aload_0
    //   161: aload_1
    //   162: aload_2
    //   163: aload 5
    //   165: aload 6
    //   167: invokespecial 234	uik:<init>	(Luid;Ljava/lang/String;Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   170: astore_1
    //   171: invokestatic 239	ung:a	()Lung;
    //   174: aload 4
    //   176: aload_1
    //   177: invokevirtual 242	ung:a	(Lunk;Luni;)V
    //   180: aload_3
    //   181: getfield 177	com/tencent/biz/qqstory/model/item/StoryVideoItem:videoUrlExpireTime	J
    //   184: invokestatic 183	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   187: lcmp
    //   188: ifle +12 -> 200
    //   191: ldc 116
    //   193: ldc 244
    //   195: invokestatic 206	wsv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: iconst_0
    //   199: ireturn
    //   200: aload_2
    //   201: monitorenter
    //   202: ldc 116
    //   204: ldc 246
    //   206: invokestatic 206	wsv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: aload 5
    //   211: invokevirtual 249	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   214: ifne +16 -> 230
    //   217: aload 6
    //   219: iconst_1
    //   220: invokevirtual 252	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   223: aload_2
    //   224: ldc2_w 253
    //   227: invokevirtual 258	java/lang/Object:wait	(J)V
    //   230: aload_2
    //   231: monitorexit
    //   232: iconst_1
    //   233: ireturn
    //   234: astore_1
    //   235: aload_1
    //   236: invokevirtual 261	java/lang/InterruptedException:printStackTrace	()V
    //   239: goto -9 -> 230
    //   242: astore_1
    //   243: aload_2
    //   244: monitorexit
    //   245: aload_1
    //   246: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	uid
    //   0	247	1	paramString	String
    //   135	109	2	localObject	Object
    //   11	170	3	localStoryVideoItem	StoryVideoItem
    //   93	82	4	localvby	vby
    //   144	66	5	localAtomicBoolean1	java.util.concurrent.atomic.AtomicBoolean
    //   154	64	6	localAtomicBoolean2	java.util.concurrent.atomic.AtomicBoolean
    // Exception table:
    //   from	to	target	type
    //   209	230	234	java/lang/InterruptedException
    //   202	209	242	finally
    //   209	230	242	finally
    //   230	232	242	finally
    //   235	239	242	finally
    //   243	245	242	finally
  }
  
  private uil b(String paramString, int paramInt)
  {
    paramString = DownloadingUrlEntry.makeKey(paramString, paramInt);
    paramString = (uil)this.c.get(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.jdField_b_of_type_JavaLangString)) && (Math.abs(System.currentTimeMillis() - paramString.jdField_a_of_type_Long) <= 300000L)) {
      return paramString;
    }
    return null;
  }
  
  @Deprecated
  private void b(@NonNull String paramString, @NonNull uim paramuim)
  {
    wsv.b("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessaryInner , vid = %s", paramString);
    Object localObject = ((uro)urr.a(5)).a(paramString);
    if (localObject == null)
    {
      wsv.e("Q.qqstory.DownloadUrlManager", "DownloadUrlQueryResult:: error video is null");
      paramuim.a(false);
      return;
    }
    if (((StoryVideoItem)localObject).videoUrlExpireTime <= 0L)
    {
      paramuim.a(false);
      return;
    }
    if (((StoryVideoItem)localObject).videoUrlExpireTime - NetConnInfoCenter.getServerTimeMillis() > 0L)
    {
      paramuim.a(false);
      return;
    }
    wsv.d("Q.qqstory.DownloadUrlManager", ((StoryVideoItem)localObject).mVid + " request video url is expire :" + ((StoryVideoItem)localObject).videoUrlExpireTime);
    localObject = new vby();
    ((vby)localObject).jdField_a_of_type_JavaUtilList = new ArrayList(1);
    ((vby)localObject).jdField_a_of_type_JavaUtilList.add(paramString);
    ((vby)localObject).jdField_a_of_type_Long = 10000L;
    paramString = new uij(this, paramuim, paramString);
    ung.a().a((unk)localObject, paramString);
  }
  
  public List<VideoUrlEntry> a(String paramString)
  {
    Object localObject = (List)this.jdField_a_of_type_AndroidUtilLruCache.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    List localList = uro.a(QQStoryContext.a().a().createEntityManager(), VideoUrlEntry.class, VideoUrlEntry.class.getSimpleName(), "vid=?", new String[] { paramString });
    localObject = localList;
    if (localList == null) {
      localObject = new ArrayList(0);
    }
    this.jdField_a_of_type_AndroidUtilLruCache.put(paramString, localObject);
    return localObject;
  }
  
  public uil a(String paramString, int paramInt)
  {
    xmh.b();
    uil localuil = new uil();
    localuil.jdField_a_of_type_JavaLangString = paramString;
    localuil.jdField_a_of_type_Int = paramInt;
    uro localuro = (uro)urr.a(5);
    label644:
    label647:
    for (;;)
    {
      int i;
      Object localObject2;
      Object localObject1;
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
        if ((paramInt == 0) && (a(paramString)))
        {
          i = 1;
          localuil.jdField_a_of_type_Boolean = true;
          localObject2 = null;
          localObject1 = localObject2;
          if (paramInt == 0)
          {
            localObject1 = localObject2;
            if (a())
            {
              List localList = a(paramString);
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
                  localuil.jdField_b_of_type_Int = 2;
                  localuil.jdField_b_of_type_JavaLangString = ((DownloadingUrlEntry)localObject1).url;
                  localuil.c = ((VideoUrlEntry)localObject2).videoUrlLevel;
                }
              }
            }
          }
          if (localuil.jdField_b_of_type_Int != -1) {
            break label644;
          }
          localObject2 = localuro.a(paramString);
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
            localuil.jdField_b_of_type_Int = 3;
            localuil.jdField_b_of_type_JavaLangString = ((DownloadingUrlEntry)localObject1).url;
            if ((localObject1 != null) && (!TextUtils.isEmpty(((DownloadingUrlEntry)localObject1).url)))
            {
              localObject2 = ujb.a(paramString, paramInt, false, false);
              if ((localObject2 == null) || (!((File)localObject2).exists()))
              {
                ((DownloadingUrlEntry)localObject1).updatedMs = System.currentTimeMillis();
                this.b.put(DownloadingUrlEntry.makeKey(paramString, paramInt), localObject1);
                QQStoryContext.a().a().createEntityManager().b((awbv)localObject1);
              }
            }
            if (i != 0)
            {
              wsv.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: video url have expire,so we need to handle the temOrphan~~");
              paramString = a(paramString, paramInt);
              if ((paramString == null) || (!TextUtils.equals(paramString.url, localuil.jdField_b_of_type_JavaLangString))) {
                break label598;
              }
              wsv.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: set isTmpOrphan false,cache entry url=" + paramString.url + " result url=" + localuil.jdField_b_of_type_JavaLangString);
              localuil.jdField_a_of_type_Boolean = false;
            }
            return localuil;
          }
        }
        else
        {
          localObject1 = a(paramString, paramInt);
          if ((localObject1 == null) || (((DownloadingUrlEntry)localObject1).bIsDownloadCompleted != 0)) {
            break label647;
          }
          localuil.jdField_b_of_type_Int = 0;
          localuil.jdField_b_of_type_JavaLangString = ((DownloadingUrlEntry)localObject1).url;
          localuil.c = ((DownloadingUrlEntry)localObject1).compressLevel;
          return localuil;
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
        localuil.a();
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      ((DownloadingUrlEntry)localObject1).url = ((StoryVideoItem)localObject2).getThumbUrl();
      continue;
      label598:
      if (paramString == null)
      {
        wsv.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: set isTmpOrphan true,cache entry url");
      }
      else
      {
        wsv.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: set isTmpOrphan true,cache entry url :" + paramString.url);
        continue;
        continue;
        i = 0;
      }
    }
  }
  
  public uil a(String paramString, int paramInt, boolean paramBoolean)
  {
    xmh.b();
    String str = DownloadingUrlEntry.makeKey(paramString, paramInt);
    uil localuil = new uil();
    localuil.jdField_a_of_type_JavaLangString = paramString;
    localuil.jdField_a_of_type_Int = paramInt;
    uro localuro = (uro)urr.a(5);
    label651:
    label697:
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
        localObject1 = a(paramString, paramInt);
        if ((localObject1 != null) && (((DownloadingUrlEntry)localObject1).bIsDownloadCompleted == 0))
        {
          localuil.jdField_b_of_type_Int = 0;
          localuil.jdField_b_of_type_JavaLangString = ((DownloadingUrlEntry)localObject1).url;
          localuil.c = ((DownloadingUrlEntry)localObject1).compressLevel;
          return localuil;
        }
        localuil.jdField_a_of_type_Boolean = true;
        localObject2 = null;
        localObject1 = localObject2;
        if (paramInt == 0)
        {
          localObject1 = localObject2;
          if (a())
          {
            List localList = a(paramString);
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
                localuil.jdField_b_of_type_Int = 2;
                localuil.jdField_b_of_type_JavaLangString = ((DownloadingUrlEntry)localObject1).url;
                localuil.c = ((VideoUrlEntry)localObject2).videoUrlLevel;
              }
            }
          }
        }
        if (localuil.jdField_b_of_type_Int != -1) {
          break label697;
        }
        localObject2 = localuro.a(paramString);
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
          localuil.jdField_b_of_type_Int = 3;
          localuil.jdField_b_of_type_JavaLangString = ((DownloadingUrlEntry)localObject1).url;
          if ((localObject1 != null) && (!TextUtils.isEmpty(((DownloadingUrlEntry)localObject1).url)))
          {
            localObject2 = ujb.a(paramString, paramInt, false, false);
            if ((localObject2 == null) || (!((File)localObject2).exists()))
            {
              ((DownloadingUrlEntry)localObject1).updatedMs = System.currentTimeMillis();
              this.b.put(DownloadingUrlEntry.makeKey(paramString, paramInt), localObject1);
              QQStoryContext.a().a().createEntityManager().b((awbv)localObject1);
            }
          }
          if (paramBoolean)
          {
            wsv.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: video url have expire,so we need to handle the temOrphan~~");
            paramString = a(paramString, paramInt);
            if ((paramString == null) || (!TextUtils.equals(paramString.url, localuil.jdField_b_of_type_JavaLangString))) {
              break label651;
            }
            wsv.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: set isTmpOrphan false,cache entry url=" + paramString.url + " result url=" + localuil.jdField_b_of_type_JavaLangString);
            localuil.jdField_a_of_type_Boolean = false;
          }
          return localuil;
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
        localuil.a();
        localuil.jdField_a_of_type_Long = System.currentTimeMillis();
        this.c.put(str, localuil);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      ((DownloadingUrlEntry)localObject1).url = ((StoryVideoItem)localObject2).getThumbUrl();
      continue;
      if (paramString == null) {
        wsv.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: set isTmpOrphan true,cache entry url");
      } else {
        wsv.d("Q.qqstory.DownloadUrlManager", "pullNewVideoInfoIfNecessary: set isTmpOrphan true,cache entry url :" + paramString.url);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramInt != 0) || (xlh.a(paramString))) {
      return;
    }
    Bosses.get().postJob(new uig(this, "Q.qqstory.DownloadUrlManager", paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt, uin paramuin)
  {
    uil localuil = b(paramString, paramInt);
    if (localuil != null)
    {
      paramuin.a(localuil);
      return;
    }
    if (paramInt == 0)
    {
      a(paramString, new uie(this, paramString, paramInt, paramuin));
      return;
    }
    Bosses.get().postJob(new uif(this, "Q.qqstory.DownloadUrlManager", paramString, paramInt, paramuin));
  }
  
  public void a(List<List<VideoUrlEntry>> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    wsv.a("Q.qqstory.DownloadUrlManager", "update video url:%s", paramList);
    awbw localawbw = QQStoryContext.a().a().createEntityManager();
    for (;;)
    {
      List localList;
      VideoUrlEntry localVideoUrlEntry1;
      try
      {
        localawbw.a().a();
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
        localawbw.a(localVideoUrlEntry1, "vid=?", new String[] { localVideoUrlEntry1.vid });
        Iterator localIterator = localList.iterator();
        if (!localIterator.hasNext()) {
          break label218;
        }
        VideoUrlEntry localVideoUrlEntry2 = (VideoUrlEntry)localIterator.next();
        if (TextUtils.isEmpty(localVideoUrlEntry2.videoUrl))
        {
          localIterator.remove();
          wsv.d("Q.qqstory.DownloadUrlManager", "%s url error!", new Object[] { localVideoUrlEntry2.vid });
          continue;
        }
        localawbw.b(localVideoUrlEntry2);
      }
      finally
      {
        localawbw.a().b();
      }
      continue;
      label218:
      this.jdField_a_of_type_AndroidUtilLruCache.put(localVideoUrlEntry1.vid, localList);
    }
    localawbw.a().c();
    localawbw.a().b();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String[] a(String paramString)
  {
    wsv.a("Q.qqstory.DownloadUrlManager", "replaceDomain2Ip domain - url: %s", paramString);
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
          Object localObject = bavf.a().a(str3, 1012);
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
                wsv.a("Q.qqstory.DownloadUrlManager", "replaceDomain2Ip ip - url: %s", str1);
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
        wsv.b("Q.qqstory.DownloadUrlManager", "replaceDomain2Ip MalformedURLException: %s", localMalformedURLException);
      }
      return new String[] { paramString };
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    Bosses.get().postJob(new uih(this, "Q.qqstory.DownloadUrlManager", paramString, paramInt));
  }
  
  public void b(List<VideoUrlEntry> paramList)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramList);
    a(localArrayList);
  }
  
  public void c(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      Object localObject = DownloadingUrlEntry.makeKey(paramString, paramInt);
      this.b.remove(localObject);
      localObject = QQStoryContext.a().a().createEntityManager();
      paramString = uro.a((awbw)localObject, DownloadingUrlEntry.class, DownloadingUrlEntry.class.getSimpleName(), "key=?", new String[] { DownloadingUrlEntry.makeKey(paramString, paramInt) });
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = (DownloadingUrlEntry)paramString.get(0);
        paramString.setStatus(1001);
        ((awbw)localObject).b(paramString);
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uid
 * JD-Core Version:    0.7.0.1
 */