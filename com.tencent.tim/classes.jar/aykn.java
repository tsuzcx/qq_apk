import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiItem;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(9)
public class aykn
  implements psj
{
  public static final String aAy = plr.bY + "emoji";
  public final int COUNT = 50;
  public DoodleEmojiItem a;
  public volatile AtomicInteger as = new AtomicInteger(0);
  aykn.e b = null;
  public final Object bm = new Object[0];
  pub.a c = new aykr(this);
  public final ConcurrentHashMap<String, DoodleEmojiItem> ck = new ConcurrentHashMap();
  public String mCookie = "";
  public final List<DoodleEmojiItem> oL = new CopyOnWriteArrayList();
  protected List<Location> oM = new ArrayList();
  public final Queue<DoodleEmojiItem> t = new LinkedList();
  private SharedPreferences u;
  
  static
  {
    rp(aAy);
  }
  
  public aykn()
  {
    BaseApplicationImpl localBaseApplicationImpl = QQStoryContext.a().getApplication();
    if (localBaseApplicationImpl == null) {
      throw new IllegalArgumentException("Context should not be null");
    }
    this.u = localBaseApplicationImpl.getSharedPreferences("qqstory_emoji", 4);
  }
  
  private boolean Lr()
  {
    return this.as.get() == 2;
  }
  
  public static String a(aykn paramaykn, String paramString)
  {
    return paramaykn.getStringValue("emoji_pack_url_" + paramString, "");
  }
  
  private static void a(aykn paramaykn, String paramString1, String paramString2)
  {
    paramaykn.setStringValue("emoji_pack_url_" + paramString1, paramString2);
  }
  
  public static String b(aykn paramaykn, String paramString)
  {
    return paramaykn.getStringValue("emoji_pack_name_" + paramString, "");
  }
  
  private static void b(aykn paramaykn, String paramString1, String paramString2)
  {
    paramaykn.setStringValue("emoji_pack_name_" + paramString1, paramString2);
  }
  
  public static String c(aykn paramaykn, String paramString)
  {
    return paramaykn.getStringValue("emoji_pack_config_" + paramString, "");
  }
  
  private static void c(aykn paramaykn, String paramString1, String paramString2)
  {
    paramaykn.setStringValue("emoji_pack_config_" + paramString1, paramString2);
  }
  
  public static String d(aykn paramaykn, String paramString)
  {
    return paramaykn.getStringValue("emoji_pack_md5_" + paramString, "");
  }
  
  public static void d(aykn paramaykn, String paramString1, String paramString2)
  {
    paramaykn.setStringValue("emoji_pack_md5_" + paramString1, paramString2);
  }
  
  protected static String gf(@NonNull String paramString)
  {
    return aAy + File.separator + "emoji_zip_" + paramString;
  }
  
  protected static String gg(@NonNull String paramString)
  {
    return aAy + File.separator + "emoji_folder_" + paramString;
  }
  
  private static String i(@NonNull File paramFile)
  {
    return paramFile.getName().substring("emoji_folder_".length());
  }
  
  private static void rp(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      ram.w("DoodleEmojiManager", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      ram.w("DoodleEmojiManager", "create folder : " + bool);
    }
  }
  
  private static boolean u(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {}
    do
    {
      return false;
      paramFile = paramFile.listFiles(new aykt());
    } while ((paramFile == null) || (paramFile.length <= 0));
    return true;
  }
  
  public void a(int paramInt1, int paramInt2, aykn.e parame)
  {
    parame = new WeakReference(parame);
    ppv.a().a(new pyz(paramInt1, paramInt2), new ayks(this, parame));
  }
  
  public List<DoodleEmojiItem> cd()
  {
    if (!Lr())
    {
      ram.d("DoodleEmojiManager", "getCurrentEmojiPackList but not init yet");
      return Collections.EMPTY_LIST;
    }
    return this.oL;
  }
  
  public void eSq()
  {
    ram.d("DoodleEmojiManager", "initLocalPackages, doodle emoji path : " + aAy);
    if (this.as.compareAndSet(0, 1))
    {
      aykn localaykn = (aykn)psx.a(39);
      Object localObject1 = new File(aAy);
      if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
      {
        localObject1 = ((File)localObject1).listFiles(new ayko(this));
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          if (i < j)
          {
            File localFile = localObject1[i];
            Object localObject2 = localFile.listFiles(new aykp(this));
            if ((localObject2 != null) && (localObject2.length > 0))
            {
              localObject2 = i(localFile);
              Object localObject3 = b(localaykn, (String)localObject2);
              localObject3 = new DoodleEmojiItem((String)localObject2, a(localaykn, (String)localObject2), (String)localObject3, null, c(localaykn, (String)localObject2), d(localaykn, (String)localObject2));
              ((DoodleEmojiItem)localObject3).setLocalEmojiFolderPath(localFile.getPath());
              this.ck.put(localObject2, localObject3);
              ram.d("DoodleEmojiManager", "load local emoji pack : " + localObject3);
            }
            for (;;)
            {
              i += 1;
              break;
              try
              {
                rox.fA(localFile.getPath());
                ram.w("DoodleEmojiManager", "find empty local emoji folder : " + localFile.getName() + ", delete it");
              }
              catch (Exception localException)
              {
                ram.w("DoodleEmojiManager", "find empty local emoji folder : " + localFile.getName() + ", delete failed : " + localException);
              }
            }
          }
        }
      }
      else
      {
        ram.w("DoodleEmojiManager", "local emoji folder is empty");
      }
      oP(((axtd)axov.a(1)).eK());
      this.as.set(2);
    }
  }
  
  public String getStringValue(@NonNull String paramString1, @NonNull String paramString2)
  {
    return this.u.getString(paramString1, paramString2);
  }
  
  public void oP(List<DoodleEmojiItem> arg1)
  {
    if (??? == null) {
      return;
    }
    aykn localaykn = (aykn)psx.a(39);
    ArrayList localArrayList = new ArrayList(???.size());
    Iterator localIterator = ???.iterator();
    label36:
    DoodleEmojiItem localDoodleEmojiItem;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localDoodleEmojiItem = (DoodleEmojiItem)localIterator.next();
      if (localDoodleEmojiItem.type != 1) {
        break label436;
      }
      localObject2 = (DoodleEmojiItem)this.ck.get(localDoodleEmojiItem.pack_id);
      if (localObject2 == null) {
        break label436;
      }
      ??? = ((DoodleEmojiItem)localObject2).getLocalEmojiFolderPath();
      if (TextUtils.equals(((DoodleEmojiItem)localObject2).md5, localDoodleEmojiItem.md5)) {
        break label433;
      }
      ram.b("DoodleEmojiManager", "EmojiPack md5 has changed. old : %s, new : %s", ((DoodleEmojiItem)localObject2).md5, localDoodleEmojiItem.md5);
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          rox.fA(???);
          localObject2 = new aykn.a(localDoodleEmojiItem, 0, false, 0L, 0L);
          ((aykn.a)localObject2).bkR = true;
          pmi.a().dispatch((Dispatcher.Dispatchable)localObject2);
          ??? = null;
          localDoodleEmojiItem.setLocalEmojiFolderPath(???);
          a(localaykn, localDoodleEmojiItem.pack_id, localDoodleEmojiItem.icon);
          b(localaykn, localDoodleEmojiItem.pack_id, localDoodleEmojiItem.name);
          c(localaykn, localDoodleEmojiItem.pack_id, localDoodleEmojiItem.config);
          d(localaykn, localDoodleEmojiItem.pack_id, localDoodleEmojiItem.md5);
          this.ck.put(localDoodleEmojiItem.pack_id, localDoodleEmojiItem);
          if (localArrayList.contains(localDoodleEmojiItem)) {
            break label36;
          }
          localArrayList.add(localDoodleEmojiItem);
        }
        catch (Exception localException)
        {
          ram.w("DoodleEmojiManager", "remove folder : %s failed. error: %s .", new Object[] { ???, localException });
          continue;
        }
        synchronized (this.oL)
        {
          this.oL.clear();
          this.oL.addAll(localArrayList);
          if (QLog.isColorLevel()) {
            QLog.i("DoodleEmojiManager", 2, "paster config processResponse " + this.oL.size());
          }
          if (localArrayList.size() <= 0) {
            break;
          }
          ram.d("DoodleEmojiManager", "start download the first emoji pack if needed : " + ((DoodleEmojiItem)localArrayList.get(0)).pack_id);
          s(((DoodleEmojiItem)localArrayList.get(0)).pack_id, false);
          return;
        }
      }
      label433:
      continue;
      label436:
      ??? = null;
    }
  }
  
  public void onDestroy()
  {
    pub localpub = (pub)psx.a(9);
    if ((localpub != null) && (this.c != null)) {
      localpub.b(this.c);
    }
    this.b = null;
  }
  
  public void onInit() {}
  
  public boolean s(String paramString, boolean paramBoolean)
  {
    if (!Lr()) {
      ram.w("DoodleEmojiManager", "downloadEmojiPack init state = %d", new Object[] { Integer.valueOf(this.as.get()) });
    }
    if (paramString == null) {
      throw new IllegalArgumentException("pack id should not be null");
    }
    DoodleEmojiItem localDoodleEmojiItem = (DoodleEmojiItem)this.ck.get(paramString);
    if (localDoodleEmojiItem == null)
    {
      ram.w("DoodleEmojiManager", "can not find pack item by id " + paramString);
      return false;
    }
    ??? = new File(gg(localDoodleEmojiItem.pack_id));
    if ((u((File)???)) && (!paramBoolean))
    {
      ram.w("DoodleEmojiManager", "already has local emoji folder, notify download success directly");
      localDoodleEmojiItem.setLocalEmojiFolderPath(((File)???).getPath());
      pmi.a().dispatch(new aykn.a(localDoodleEmojiItem, 0, true, 0L, 0L));
      return true;
    }
    if (!TextUtils.isEmpty(localDoodleEmojiItem.getLocalEmojiFolderPath()))
    {
      ram.w("DoodleEmojiManager", "local emoji folder is missing");
      localDoodleEmojiItem.setLocalEmojiFolderPath(null);
    }
    if (TextUtils.isEmpty(localDoodleEmojiItem.download_url))
    {
      ram.w("DoodleEmojiManager", "can not start download because of empty download-url is found");
      return false;
    }
    synchronized (this.bm)
    {
      if (!this.t.contains(localDoodleEmojiItem))
      {
        this.t.offer(localDoodleEmojiItem);
        ram.d("DoodleEmojiManager", "downloadEmojiPack pack " + paramString + " enqueue");
        startDownload();
        return true;
      }
      ram.d("DoodleEmojiManager", "downloadEmojiPack pack " + paramString + " is already in pending list");
    }
  }
  
  public void setStringValue(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.u.edit().putString(paramString1, paramString2).apply();
  }
  
  protected void startDownload()
  {
    ram.d("DoodleEmojiManager", "startDownload");
    synchronized (this.bm)
    {
      if (this.a == null)
      {
        this.a = ((DoodleEmojiItem)this.t.poll());
        if (this.a != null)
        {
          ram.d("DoodleEmojiManager", "downloader startDownload : " + this.a);
          Bosses.get().postJob(new aykq(this, this.a));
        }
        return;
      }
      ram.d("DoodleEmojiManager", "can not start download because find one is still downloading : " + this.a);
    }
  }
  
  public static class a
    extends plt
  {
    public final long BZ;
    public final long Ca;
    public final boolean aBq;
    @NonNull
    public final DoodleEmojiItem b;
    public boolean bkR;
    public final int mErrorCode;
    
    public a(@NonNull DoodleEmojiItem paramDoodleEmojiItem, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      this.b = paramDoodleEmojiItem;
      this.mErrorCode = paramInt;
      this.aBq = paramBoolean;
      this.BZ = paramLong1;
      this.Ca = paramLong2;
    }
  }
  
  public static class b
    extends plt
  {}
  
  public static class c
    extends plt
  {
    public final int mErrorCode;
    @NonNull
    public final List<ptr> oN;
    
    public c(int paramInt, @NonNull List<ptr> paramList)
    {
      this.mErrorCode = paramInt;
      this.oN = new ArrayList(paramList);
    }
  }
  
  static class d
    extends SimpleJob<DoodleEmojiItem>
    implements pmp
  {
    private long Cb;
    private final DoodleEmojiItem jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
    private final pmy jdField_b_of_type_Pmy;
    protected long startDownloadTime;
    
    public d(DoodleEmojiItem paramDoodleEmojiItem)
    {
      super();
      if (paramDoodleEmojiItem == null) {
        throw new IllegalArgumentException("doodleEmojiItem should not be null");
      }
      this.jdField_b_of_type_Pmy = new pmz();
      this.jdField_b_of_type_Pmy.a(this);
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem = paramDoodleEmojiItem;
    }
    
    protected DoodleEmojiItem a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
    {
      this.jdField_b_of_type_Pmy.a(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.download_url, aykn.gf(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem.pack_id), 0L);
      return this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
    }
    
    public void be(String paramString, int paramInt)
    {
      DoodleEmojiItem localDoodleEmojiItem1 = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
      if (paramInt == 0)
      {
        paramString = aykn.gf(localDoodleEmojiItem1.pack_id);
        String str = aykn.gg(localDoodleEmojiItem1.pack_id);
        ram.d("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
        ram.d("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
        for (;;)
        {
          int i;
          try
          {
            rox.fA(str);
            i = jqp.unZipFolder(paramString, str);
            if (i == 0)
            {
              long l1 = SystemClock.uptimeMillis();
              long l2 = this.startDownloadTime;
              rar.b("edit_video", "face_download_timecost", 0, 0, new String[] { localDoodleEmojiItem1.pack_id, l1 - l2 + "" });
              rar.b("edit_video", "face_download_success", 0, 0, new String[] { localDoodleEmojiItem1.pack_id });
              ram.i("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
              localDoodleEmojiItem1.setLocalEmojiFolderPath(str);
              new File(str).setLastModified(System.currentTimeMillis());
              pmi.a().dispatch(new aykn.a(localDoodleEmojiItem1, paramInt, true, 0L, 0L));
              return;
            }
          }
          catch (Exception localException)
          {
            ram.w("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", new Object[] { str, localException });
            continue;
          }
          finally
          {
            new File(paramString).delete();
          }
          ram.w("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
          pmi.a().dispatch(new aykn.a(localDoodleEmojiItem2, i, false, 0L, 0L));
          rar.b("edit_video", "face_download_success", 0, i, new String[] { localDoodleEmojiItem2.pack_id });
        }
      }
      ram.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
      pmi.a().dispatch(new aykn.a(localDoodleEmojiItem2, paramInt, true, 0L, 0L));
      rar.b("edit_video", "face_download_success", 0, paramInt, new String[] { localDoodleEmojiItem2.pack_id });
    }
    
    public void ck(String paramString1, String paramString2)
    {
      ram.d("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
      this.startDownloadTime = SystemClock.uptimeMillis();
    }
    
    public void onProgress(String paramString, long paramLong1, long paramLong2)
    {
      DoodleEmojiItem localDoodleEmojiItem = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem;
      if (!TextUtils.equals(localDoodleEmojiItem.download_url, paramString))
      {
        ram.w("DoodleEmojiManager", "DownloadListener onProgress error : " + localDoodleEmojiItem);
        ram.w("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
      }
      while (paramLong1 <= paramLong2 / 10L + this.Cb) {
        return;
      }
      ram.v("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
      pmi.a().dispatch(new aykn.a(localDoodleEmojiItem, 0, false, paramLong2, paramLong1));
      this.Cb = paramLong1;
    }
  }
  
  public static abstract interface e
  {
    public abstract void D(int paramInt, List<ptr> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aykn
 * JD-Core Version:    0.7.0.1
 */