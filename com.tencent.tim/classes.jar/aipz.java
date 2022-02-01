import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class aipz
  implements aipy
{
  private static Comparator<File> N = new aiqa();
  private static File aC;
  static aolm.a jdField_c_of_type_Aolm$a = new aiqc();
  private QQAppInterface app;
  private aolm jdField_c_of_type_Aolm;
  private aolm.b e = new aiqb(this);
  private ConcurrentHashMap<String, List<aipz.a>> fK;
  private ConcurrentHashMap<String, aoll> fL;
  
  public aipz(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.jdField_c_of_type_Aolm = paramQQAppInterface.getNetEngine(0);
    this.fK = new ConcurrentHashMap();
    this.fL = new ConcurrentHashMap();
  }
  
  private void b(MusicInfo paramMusicInfo)
  {
    if (paramMusicInfo != null) {}
    int i;
    label116:
    Object localObject1;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramMusicInfo.id))
        {
          QLog.d("ListenTogether.downloader", 1, "musicInfo or id is empty");
          return;
        }
        if (!ki(aini.a().ded)) {
          continue;
        }
        i = aini.a().dec;
        if (i <= 0)
        {
          QLog.d("ListenTogether.downloader", 2, String.format("download, maxCacheCount <= 0: %s", new Object[] { Integer.valueOf(i) }));
          dtE();
          dtD();
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label116;
        }
      }
      finally {}
      QLog.d("ListenTogether.downloader", 2, String.format("download, musicId: %s", new Object[] { paramMusicInfo.id }));
      if (nb(paramMusicInfo.id))
      {
        QLog.d("ListenTogether.downloader", 1, "download, cache file is exist");
      }
      else
      {
        localObject2 = (List)this.fK.get(paramMusicInfo.id);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label320;
        }
        localObject1 = localObject2;
        if (paramMusicInfo.CC != null)
        {
          localObject1 = localObject2;
          if (paramMusicInfo.CC.size() > 0)
          {
            localObject1 = new ArrayList();
            localObject2 = paramMusicInfo.CC.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              str = (String)((Iterator)localObject2).next();
              if (!TextUtils.isEmpty(str)) {
                ((List)localObject1).add(new aipz.a(paramMusicInfo.id, str));
              }
            }
          }
        }
        label263:
        if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
          break;
        }
        QLog.d("ListenTogether.downloader", 1, "musicReqInfoList is empty!, " + paramMusicInfo);
      }
    }
    this.fK.put(paramMusicInfo.id, localObject1);
    label320:
    Iterator localIterator = null;
    String str = null;
    Object localObject2 = localIterator;
    if (localObject1 != null)
    {
      localObject2 = localIterator;
      if (((List)localObject1).size() > 0)
      {
        localIterator = ((List)localObject1).iterator();
        localObject1 = str;
      }
    }
    label402:
    label583:
    label593:
    label595:
    for (;;)
    {
      localObject2 = localObject1;
      boolean bool;
      if (localIterator.hasNext())
      {
        localObject2 = (aipz.a)localIterator.next();
        if (((aipz.a)localObject2).status == 1)
        {
          bool = true;
          break label583;
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label593;
        }
        QLog.d("ListenTogether.downloader", 2, String.format("musicReqInfo not found, isDownloading: %s", new Object[] { Boolean.valueOf(bool) }));
        break;
        if ((((aipz.a)localObject2).status == 0) && (localObject1 == null))
        {
          localObject1 = localObject2;
          break label595;
        }
        do
        {
          if (!kj(i))
          {
            QLog.d("ListenTogether.downloader", 1, "download, over cache count");
            break;
          }
          localObject2 = new aoll();
          ((aoll)localObject2).f = this.e;
          ((aoll)localObject2).bZ = ((aipz.a)localObject1).url;
          ((aoll)localObject2).mHttpMethod = 0;
          ((aoll)localObject2).atY = ((aipz.a)localObject1).cachePath;
          ((aoll)localObject2).dPo = 1;
          ((aoll)localObject2).bw(new Object[] { paramMusicInfo, localObject1 });
          ((aoll)localObject2).a = jdField_c_of_type_Aolm$a;
          this.jdField_c_of_type_Aolm.a((aomg)localObject2);
          ((aipz.a)localObject1).status = 1;
          break;
          break label595;
          bool = false;
          localObject1 = localObject2;
          break label583;
          break label263;
          if (bool) {
            break label402;
          }
        } while (localObject1 != null);
      }
      break;
    }
  }
  
  public static void dtD()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new File(ainh.CACHE_PATH);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        int i = 0;
        if (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.isFile())
          {
            String str1 = lE(QQMusicPlayService.xa());
            String str2 = localObject2.getAbsolutePath();
            if ((TextUtils.isEmpty(str1)) || (!str1.equals(str2))) {
              break label128;
            }
            QLog.d("ListenTogether.downloader", 1, String.format("removeAllCacheFiles, %s is playing", new Object[] { str2 }));
          }
          for (;;)
          {
            i += 1;
            break;
            label128:
            localObject2.delete();
          }
        }
      }
    }
    QLog.d("ListenTogether.downloader", 1, "removeAllCacheFiles, costTime: " + (System.currentTimeMillis() - l));
  }
  
  private void dtE()
  {
    try
    {
      this.fK.clear();
      Iterator localIterator = this.fL.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (aomg)((Map.Entry)localIterator.next()).getValue();
        this.jdField_c_of_type_Aolm.b((aomg)localObject2);
        if ((localObject2 instanceof aoll))
        {
          localObject2 = (aoll)localObject2;
          if (QLog.isColorLevel()) {
            QLog.d("ListenTogether.downloader", 2, String.format("cancelAllRequests, cancel req url: %s", new Object[] { ((aoll)localObject2).bZ }));
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break label123;
      }
    }
    finally {}
    QLog.d("ListenTogether.downloader", 2, "cancelAllRequests...");
    label123:
  }
  
  private boolean ki(int paramInt)
  {
    int i = aroc.getNetType(BaseApplicationImpl.getContext());
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.downloader", 2, String.format("netTypeNeedDownload, requestNetType: %s, netType: %s, needDownload: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool) }));
      }
      return bool;
      if (paramInt == 1)
      {
        if (i == 1) {
          bool = true;
        }
      }
      else if (paramInt == 2)
      {
        if ((i == 1) || (i == 4)) {
          bool = true;
        }
      }
      else if (paramInt == 3)
      {
        if ((i == 1) || (i == 4) || (i == 3)) {
          bool = true;
        }
      }
      else if ((paramInt == 4) && ((i == 1) || (i == 4) || (i == 3) || (i == 2)))
      {
        bool = true;
        continue;
      }
      bool = false;
    }
  }
  
  private boolean kj(int paramInt)
  {
    boolean bool = false;
    String str = lE(QQMusicPlayService.xa());
    File localFile1 = new File(ainh.CACHE_PATH);
    Object localObject;
    int i;
    if (localFile1.exists())
    {
      localObject = localFile1.listFiles();
      if ((localObject == null) || (localObject.length < paramInt)) {
        return true;
      }
      localObject = Arrays.asList((Object[])localObject);
      Collections.sort((List)localObject, N);
      i = ((List)localObject).size() - paramInt + 1;
      if (i <= ((List)localObject).size()) {
        break label286;
      }
      i = ((List)localObject).size();
    }
    label286:
    for (;;)
    {
      int j = 0;
      if (j < i)
      {
        File localFile2 = (File)((List)localObject).get(j);
        if ((!TextUtils.isEmpty(str)) && (str.equals(localFile2.getAbsolutePath()))) {
          QLog.d("ListenTogether.downloader", 1, "checkCacheStorage, " + str + " is playing...");
        }
        for (;;)
        {
          j += 1;
          break;
          localFile2.delete();
          QLog.d("ListenTogether.downloader", 1, String.format("checkCacheStorage, del index: %s, file: %s", new Object[] { Integer.valueOf(j), localFile2.getAbsolutePath() }));
        }
      }
      if (localFile1.listFiles() != null) {}
      for (i = localFile1.listFiles().length;; i = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ListenTogether.downloader", 2, String.format("checkCacheCount, %s / %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) }));
        }
        if (i < paramInt) {
          bool = true;
        }
        return bool;
      }
    }
  }
  
  public static String lE(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (aC == null)
    {
      aC = new File(ainh.CACHE_PATH);
      QLog.d("ListenTogether.downloader", 1, new Object[] { "init getCacheFilePath=", aC });
    }
    if (!aC.exists())
    {
      boolean bool = aC.mkdir();
      QLog.d("ListenTogether.downloader", 1, "mkdir cache dir, result: " + bool);
    }
    return new File(ainh.CACHE_PATH, arwv.toMD5(paramString)).getAbsolutePath();
  }
  
  public static boolean nb(String paramString)
  {
    return new File(lE(paramString)).exists();
  }
  
  /* Error */
  public void cancel(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +15 -> 21
    //   9: ldc 87
    //   11: iconst_1
    //   12: ldc_w 387
    //   15: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 67	aipz:fL	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 390	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 318	aomg
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +13 -> 47
    //   37: aload_0
    //   38: getfield 60	aipz:jdField_c_of_type_Aolm	Laolm;
    //   41: aload_2
    //   42: invokeinterface 320 2 0
    //   47: aload_0
    //   48: getfield 65	aipz:fK	Ljava/util/concurrent/ConcurrentHashMap;
    //   51: aload_1
    //   52: invokevirtual 390	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq -41 -> 18
    //   62: ldc 87
    //   64: iconst_2
    //   65: new 182	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 392
    //   75: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: goto -70 -> 18
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	aipz
    //   0	96	1	paramString	String
    //   32	10	2	localaomg	aomg
    // Exception table:
    //   from	to	target	type
    //   2	18	91	finally
    //   21	33	91	finally
    //   37	47	91	finally
    //   47	88	91	finally
  }
  
  public void destroy()
  {
    dtE();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.downloader", 2, "destroy");
    }
  }
  
  public void lh(List<MusicInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.d("ListenTogether.downloader", 1, "downloadMusicRes, musicList is empty!");
    }
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        b((MusicInfo)paramList.next());
      }
    }
  }
  
  static class a
  {
    public String cachePath;
    public String id;
    public String md5;
    public int status;
    public String url;
    
    public a(String paramString1, String paramString2)
    {
      this.id = paramString1;
      this.url = paramString2;
      this.md5 = arwv.toMD5(paramString2);
      this.cachePath = aipz.lE(paramString1);
    }
    
    public String toString()
    {
      return "MusicReqInfo{id='" + this.id + '\'' + ", url='" + this.url + '\'' + ", md5='" + this.md5 + '\'' + ", status=" + this.status + ", cachePath='" + this.cachePath + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aipz
 * JD-Core Version:    0.7.0.1
 */