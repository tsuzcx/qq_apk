package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jzk;
import kxm;
import kxv;
import myj;
import myj.a;
import myl;
import mym;
import myn;
import nbn;
import nbo;
import nbs;
import nbs.a;
import nbt;

public class VideoPreDownloadMgr
  implements myj.a
{
  private static String TAG = "Q.readinjoy.video.VideoPreDownloadMgr";
  private static Set<String> aj = new HashSet();
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr$a;
  private myj jdField_a_of_type_Myj;
  public myn a;
  private nbo jdField_a_of_type_Nbo;
  private nbt jdField_a_of_type_Nbt;
  private Set<String> ah;
  private Set<String> ai;
  private String akQ;
  private List<b> jI;
  public Context mContext;
  
  public VideoPreDownloadMgr() {}
  
  public VideoPreDownloadMgr(Context paramContext)
  {
    this();
    init(paramContext);
  }
  
  private nbt a(String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null) {
      return new nbt(1, paramString2);
    }
    if (1 == paramInt) {}
    for (paramInt = 104;; paramInt = 101) {
      return new nbt(paramInt, paramString2, new String[] { paramString1 });
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "innerDoPreDownload() 正式开始预下载 vid=" + paramString2 + ", url=" + paramString1 + ", urlType=" + paramInt1 + ", duration=" + paramInt2);
    }
    if (this.jdField_a_of_type_Nbo == null) {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "innerDoPreDownload() start preload ERROR cacheMgr == null!");
      }
    }
    do
    {
      return;
      String str = paramString2;
      if (paramString1 != null) {
        if (paramString2 != null)
        {
          str = paramString2;
          if (!paramString1.equals(paramString2)) {}
        }
        else
        {
          str = jzk.eb(paramString1);
        }
      }
      this.jdField_a_of_type_Nbt = a(paramString1, str, paramInt1);
      this.jdField_a_of_type_Nbo.a(this.jdField_a_of_type_Nbt, paramInt2, 2000L);
    } while ((!paramBoolean) || (this.jdField_a_of_type_Myn == null));
    paramString1 = this.jdField_a_of_type_Myn;
    paramString1.aWh += 1;
  }
  
  private void aTW()
  {
    if (this.jdField_a_of_type_Nbo == null) {
      return;
    }
    this.ah = new HashSet();
    this.jI = new ArrayList();
    this.ai = new HashSet();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "initSerialPreDownload() 设置mCacheMgr回调");
    }
    this.jdField_a_of_type_Nbo.a(new myl(this));
  }
  
  private void aTX()
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "releaseSerialPredownload()");
    }
    if (this.jdField_a_of_type_Nbo != null)
    {
      this.jdField_a_of_type_Nbo.a(null);
      this.jdField_a_of_type_Nbo.destory();
    }
  }
  
  private void aTY()
  {
    List localList = this.jI;
    if ((localList != null) && (localList.size() > 0)) {}
    label64:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        try
        {
          localb1 = (b)localList.get(0);
          localb2 = localb1;
        }
        catch (Exception localException1)
        {
          try
          {
            localList.remove(0);
            localb2 = localb1;
            if ((localb2 != null) && (!TextUtils.isEmpty(localb2.videoVid))) {
              break;
            }
            aTY();
            return;
          }
          catch (Exception localException2)
          {
            b localb1;
            b localb2;
            int i;
            break label64;
          }
          localException1 = localException1;
          localb1 = null;
        }
        if (QLog.isColorLevel())
        {
          QLog.e(TAG, 2, "preDownloadVideoNotAlreadyList.remove(0) ERROR = " + localException1.getMessage());
          localb2 = localb1;
        }
      }
      this.akQ = localb2.videoVid;
      i = localb2.duration;
      if (2 == localb2.aDs)
      {
        kxv.a().a(localb2.videoVid, "PubAccountArticleCenter.GetUrlByVid", new mym(this, i));
        return;
      }
      if (5 == localb2.aDs)
      {
        if (I(localb2.videoVid, localb2.videoVid))
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + localb2.videoVid);
          }
          this.akQ = null;
          aTY();
          return;
        }
        c(localb2.videoVid, localb2.videoVid, 0, i);
        return;
      }
      if (I(null, localb2.videoVid))
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "innerDoPreDownload() 缓冲已存在，跳过, vid=" + localb2.videoVid);
        }
        this.akQ = null;
        aTY();
        return;
      }
      c(null, localb2.videoVid, 0, i);
      return;
    }
    QLog.i(TAG, 2, "已完成预下载，队列为空");
  }
  
  private void c(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramInt1, paramInt2, true);
  }
  
  private void cT(List<b> paramList)
  {
    ThreadManager.post(new PreDownloadSerialTask(paramList), 5, null, true);
  }
  
  public boolean I(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Nbo == null) {}
    String str;
    do
    {
      return false;
      str = paramString2;
      if (paramString1 != null) {
        if (paramString2 != null)
        {
          str = paramString2;
          if (!paramString1.equals(paramString2)) {}
        }
        else
        {
          str = jzk.eb(paramString1);
        }
      }
      paramString1 = a(paramString1, str, 101);
      try
      {
        i = this.jdField_a_of_type_Nbo.a(paramString1);
        if ((i == 2) || (i == 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, str + " checkIsVideoCached(), cacheStatus = " + i + ", return TRUE");
          }
          return true;
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, str + " checkIsVideoCached() cacheMgr.isVideoCached Exception = " + paramString1.getMessage());
          }
          int i = 0;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, str + " checkIsVideoCached() return FALSE");
    return false;
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr$a = parama;
  }
  
  public void aTV()
  {
    this.jdField_a_of_type_Nbo = nbs.a.a().a();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "VideoPreDownloadController initCacheMgr mCacheMgr=" + this.jdField_a_of_type_Nbo);
    }
    if (this.jdField_a_of_type_Nbo == null) {}
  }
  
  public void aTZ()
  {
    if ((this.jdField_a_of_type_Nbo != null) && (this.jdField_a_of_type_Nbt != null)) {
      this.jdField_a_of_type_Nbo.aTZ();
    }
    this.akQ = null;
    this.jdField_a_of_type_Nbt = null;
  }
  
  public void ad(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr$a == null) {}
    do
    {
      List localList;
      do
      {
        return;
        if (this.jdField_a_of_type_Nbo == null) {
          break;
        }
        localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr$a.a(paramInt, paramBoolean);
      } while ((localList == null) || (localList.size() <= 0));
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "requestPreDownload() 外部触发预下载逻辑 size = " + localList.size());
      }
      cT(localList);
      return;
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "requestPreDownload() is off or mCacheMgr is null, return;");
  }
  
  public void ak(String paramString, boolean paramBoolean)
  {
    myn localmyn = this.jdField_a_of_type_Myn;
    if (localmyn == null) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      localmyn.hitCount += 1;
      if ((this.ah != null) && (this.ah.contains(paramString)))
      {
        localmyn.aWi += 1;
        if ((this.ai != null) && (!this.ai.contains(paramString)))
        {
          this.ai.add(paramString);
          localmyn.aWj += 1;
        }
      }
    } while (!aj.contains(paramString));
    localmyn.aWk += 1;
    return;
    localmyn.aWg += 1;
  }
  
  public void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramInt1, paramInt2, false);
  }
  
  public void destroy()
  {
    destroy(true);
  }
  
  public void destroy(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "destroy()");
    }
    ThreadManager.post(new VideoPreDownloadMgr.1(this), 5, null, true);
    if ((paramBoolean) && (this.jdField_a_of_type_Myn != null))
    {
      kxm.b(BaseApplication.getContext(), kxm.getAccount(), true, this.jdField_a_of_type_Myn.u());
      this.jdField_a_of_type_Myn = null;
    }
    if (this.jdField_a_of_type_Myj != null)
    {
      this.jdField_a_of_type_Myj.destroy();
      this.jdField_a_of_type_Myj = null;
    }
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_Myj = new myj();
    this.jdField_a_of_type_Myj.a(this);
    if (!this.jdField_a_of_type_Myj.EU())
    {
      this.jdField_a_of_type_Myj.installPlugin();
      return;
    }
    aTV();
    aTW();
  }
  
  public void ns(boolean paramBoolean)
  {
    aTV();
    aTW();
  }
  
  public void resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "resume()");
    }
    aTV();
    aTW();
  }
  
  public void sN(int paramInt)
  {
    ad(paramInt, true);
  }
  
  public class PreDownloadNotAlreadyVideoTask
    implements Runnable
  {
    private boolean mIsSuccess;
    
    public PreDownloadNotAlreadyVideoTask(boolean paramBoolean)
    {
      this.mIsSuccess = paramBoolean;
    }
    
    public void run()
    {
      if (this.mIsSuccess)
      {
        if (VideoPreDownloadMgr.a(VideoPreDownloadMgr.this) != null) {
          VideoPreDownloadMgr.a(VideoPreDownloadMgr.this).add(VideoPreDownloadMgr.a(VideoPreDownloadMgr.this));
        }
        if (VideoPreDownloadMgr.r() != null) {
          VideoPreDownloadMgr.r().add(VideoPreDownloadMgr.a(VideoPreDownloadMgr.this));
        }
      }
      VideoPreDownloadMgr.a(VideoPreDownloadMgr.this, null);
      VideoPreDownloadMgr.a(VideoPreDownloadMgr.this, null);
      VideoPreDownloadMgr.c(VideoPreDownloadMgr.this);
    }
  }
  
  class PreDownloadSerialTask
    implements Runnable
  {
    private List<VideoPreDownloadMgr.b> jJ;
    
    public PreDownloadSerialTask()
    {
      Object localObject;
      this.jJ = localObject;
    }
    
    public void run()
    {
      if ((VideoPreDownloadMgr.a(VideoPreDownloadMgr.this) == null) || (this.jJ == null) || (this.jJ.size() == 0) || (VideoPreDownloadMgr.a(VideoPreDownloadMgr.this) == null)) {}
      do
      {
        return;
        int j;
        for (int i = 0; i < this.jJ.size(); i = j + 1)
        {
          localObject1 = (VideoPreDownloadMgr.b)this.jJ.get(i);
          j = i;
          if (VideoPreDownloadMgr.a(VideoPreDownloadMgr.this).contains(((VideoPreDownloadMgr.b)localObject1).videoVid))
          {
            this.jJ.remove(i);
            j = i - 1;
          }
        }
        if (!VideoPreDownloadMgr.a(VideoPreDownloadMgr.this).Eb()) {
          for (i = 0; i < this.jJ.size(); i = j + 1)
          {
            j = i;
            if (!((VideoPreDownloadMgr.b)this.jJ.get(i)).aqv)
            {
              this.jJ.remove(i);
              j = i - 1;
            }
          }
        }
        if (QLog.isColorLevel())
        {
          localObject2 = this.jJ.iterator();
          VideoPreDownloadMgr.b localb;
          for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + localb.videoVid + " | ") {
            localb = (VideoPreDownloadMgr.b)((Iterator)localObject2).next();
          }
          QLog.i(VideoPreDownloadMgr.access$300(), 2, "当前预下载列表: " + (String)localObject1);
        }
      } while (this.jJ.size() == 0);
      Object localObject1 = (VideoPreDownloadMgr.b)this.jJ.get(0);
      Object localObject2 = VideoPreDownloadMgr.a(VideoPreDownloadMgr.this);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(VideoPreDownloadMgr.access$300(), 2, "当前没有做预下载，启动预下载");
        }
        VideoPreDownloadMgr.a(VideoPreDownloadMgr.this, this.jJ);
        VideoPreDownloadMgr.c(VideoPreDownloadMgr.this);
        return;
      }
      if (((String)localObject2).equals(((VideoPreDownloadMgr.b)localObject1).videoVid))
      {
        if (QLog.isColorLevel()) {
          QLog.i(VideoPreDownloadMgr.access$300(), 2, "当前预下载与list第一项一致");
        }
        this.jJ.remove(0);
        VideoPreDownloadMgr.a(VideoPreDownloadMgr.this, this.jJ);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i(VideoPreDownloadMgr.access$300(), 2, "当前预下载与list第一项不一致，暂停预下载任务，重新启动预下载");
      }
      VideoPreDownloadMgr.a(VideoPreDownloadMgr.this, this.jJ);
      VideoPreDownloadMgr.this.aTZ();
      VideoPreDownloadMgr.c(VideoPreDownloadMgr.this);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean Eb();
    
    public abstract List<VideoPreDownloadMgr.b> a(int paramInt, boolean paramBoolean);
  }
  
  public static class b
  {
    public String Wz;
    public int aDs;
    public boolean aqv;
    public int duration;
    public String videoVid;
    
    public b(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      this.videoVid = paramString1;
      this.Wz = paramString2;
      this.aDs = paramInt1;
      this.duration = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr
 * JD-Core Version:    0.7.0.1
 */