package com.tencent.biz.publicAccountImageCollection;

import acbn;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import anpc;
import aqhq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ac.ArticleComment.GetPhotoCollectionInfoResponse;
import com.tencent.mobileqq.ac.ArticleComment.PhotoFirstItemInfo;
import com.tencent.mobileqq.ac.ArticleComment.PhotoItemInfo;
import com.tencent.mobileqq.ac.ArticleComment.RetInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jzu;
import jzv;
import mqq.app.AppRuntime;
import oty;
import oub.a;
import oub.b;
import oub.c;

public class PublicAccountImageCollectionPreloadManager
{
  private static String TAG = "PublicAccountImageCollectionPreloadManager";
  private static PublicAccountImageCollectionPreloadManager a;
  int aHN = 0;
  int aHO = 0;
  int aHP = 0;
  private Object aV = new Object();
  volatile boolean ays;
  private jzv b;
  private jzv c;
  public HashMap<String, String> eF = new HashMap();
  public MQLruCache<String, oub.a> g = new MQLruCache(30);
  private List<String> kS = new CopyOnWriteArrayList();
  Object lock = new Object();
  Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
  private List<String> waitingList = new CopyOnWriteArrayList();
  
  private boolean Hq()
  {
    int i = NetworkState.getNetworkType();
    boolean bool2 = false;
    boolean bool1;
    if (this.aHO == 1) {
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 4) {}
      }
      else
      {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "canPreloadImage is " + bool1);
      }
      return bool1;
      bool1 = bool2;
      if (this.aHO == 2)
      {
        bool1 = bool2;
        if (i == 1) {
          bool1 = true;
        }
      }
    }
  }
  
  public static PublicAccountImageCollectionPreloadManager a()
  {
    if (a == null) {
      a = new PublicAccountImageCollectionPreloadManager();
    }
    return a;
  }
  
  private oub.a a(ArticleComment.GetPhotoCollectionInfoResponse paramGetPhotoCollectionInfoResponse, String paramString)
  {
    oub.a locala = new oub.a();
    if (paramGetPhotoCollectionInfoResponse.ret.has())
    {
      if (paramGetPhotoCollectionInfoResponse.article_share_url.has()) {
        locala.articleUrl = paramGetPhotoCollectionInfoResponse.article_share_url.get().toStringUtf8();
      }
      if (paramGetPhotoCollectionInfoResponse.puin.has()) {
        locala.puin = (paramGetPhotoCollectionInfoResponse.puin.get() + "");
      }
      if (paramGetPhotoCollectionInfoResponse.article_img_url.has()) {
        locala.imgUrl = paramGetPhotoCollectionInfoResponse.article_img_url.get().toStringUtf8();
      }
      if (paramGetPhotoCollectionInfoResponse.article_title.has()) {
        locala.title = paramGetPhotoCollectionInfoResponse.article_title.get().toStringUtf8();
      }
      if (paramGetPhotoCollectionInfoResponse.enable_comment.has()) {
        locala.enable = paramGetPhotoCollectionInfoResponse.enable_comment.get();
      }
      if (paramGetPhotoCollectionInfoResponse.comment_url.has()) {
        locala.ari = paramGetPhotoCollectionInfoResponse.comment_url.get().toStringUtf8();
      }
      if (paramGetPhotoCollectionInfoResponse.firstItem.has())
      {
        locala.a = new oub.b();
        locala.a.url = paramGetPhotoCollectionInfoResponse.firstItem.url.get().toStringUtf8();
        locala.a.arl = paramGetPhotoCollectionInfoResponse.firstItem.photo_author_name.get().toStringUtf8();
        locala.a.ark = paramGetPhotoCollectionInfoResponse.firstItem.photo_time.get().toStringUtf8();
        locala.a.arj = paramGetPhotoCollectionInfoResponse.firstItem.publicaccount_name.get().toStringUtf8();
      }
      if ((paramGetPhotoCollectionInfoResponse.item.has()) && (paramGetPhotoCollectionInfoResponse.item.get().size() > 0))
      {
        locala.infos = new ArrayList();
        int j = paramGetPhotoCollectionInfoResponse.item.get().size();
        int i = 0;
        while (i < j)
        {
          oub.c localc = new oub.c();
          localc.url = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).url.get().toStringUtf8();
          localc.content = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).content.get().toStringUtf8();
          localc.arm = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).static_url.get().toStringUtf8();
          localc.width = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).width.get();
          localc.height = ((ArticleComment.PhotoItemInfo)paramGetPhotoCollectionInfoResponse.item.get(i)).height.get();
          locala.infos.add(localc);
          i += 1;
        }
      }
      locala.articleId = paramString;
    }
    return locala;
  }
  
  private void bdi()
  {
    this.kS.addAll(this.waitingList);
    this.waitingList.clear();
    this.ays = true;
    bhs();
  }
  
  private void dC(List<String> paramList)
  {
    ThreadManager.post(new PublicAccountImageCollectionPreloadManager.5(this, paramList), 5, null, true);
  }
  
  private void f(String paramString, byte[] paramArrayOfByte)
  {
    ThreadManager.postImmediately(new PublicAccountImageCollectionPreloadManager.4(this, paramString, paramArrayOfByte), null, true);
  }
  
  private void qa(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (aqhq.fileExistsAndNotEmpty(acbn.bnD + paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "loadPhotoCollectionInfo file exist");
      }
      qb(paramString);
      return;
    }
    qc(paramString);
  }
  
  private void qb(String paramString)
  {
    ThreadManager.executeOnFileThread(new ReadFileThread(paramString));
  }
  
  private void qc(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "loadPhotoCollectionInfoFromServer articleId = " + paramString);
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      jzu localjzu = (jzu)((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(93);
      if (this.b == null)
      {
        this.b = new oty(this, l);
        localjzu.a(this.b);
      }
      ThreadManager.executeOnSubThread(new PublicAccountImageCollectionPreloadManager.3(this, localjzu, paramString));
    }
  }
  
  public boolean Hp()
  {
    if (NetworkState.isNetSupport())
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + ((QQAppInterface)localObject).getCurrentAccountUin(), 0);
      this.aHN = ((SharedPreferences)localObject).getInt("album_predown_enable", 0);
      this.aHO = ((SharedPreferences)localObject).getInt("album_predown_photo_rule", 0);
      this.aHP = ((SharedPreferences)localObject).getInt("album_predown_slide_photocounts", 0);
      if (this.aHN != 1) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "canPreload is " + bool);
      }
      return bool;
    }
  }
  
  public oub.a a(String paramString)
  {
    paramString = (oub.a)this.g.get(paramString);
    if (paramString != null) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getPhotoCollectionInfoFromCache articleId =" + paramString.articleId);
      }
    }
    while (!QLog.isColorLevel()) {
      return paramString;
    }
    QLog.d(TAG, 2, "getPhotoCollectionInfoFromCache info is null");
    return paramString;
  }
  
  public void a(String paramString, jzv paramjzv)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getPhotoCollectionInfoFromFile");
    }
    this.c = paramjzv;
    qb(paramString);
  }
  
  public void a(oub.a parama, byte[] paramArrayOfByte)
  {
    this.g.put(parama.articleId, parama);
    f(parama.articleId, paramArrayOfByte);
  }
  
  public void aa(boolean paramBoolean, int paramInt)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("photo_index", String.valueOf(paramInt));
    anpc.a(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "eventPAAlbumCacheHitStatics", paramBoolean, 0L, 0L, (HashMap)localObject, "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("\n");
      ((StringBuilder)localObject).append("doStatisticReportForImageHit-->success = ").append(paramBoolean).append(" ,photoIndex = ").append(paramInt);
      QLog.d(TAG, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(jzv paramjzv)
  {
    this.b = paramjzv;
  }
  
  public void bdj()
  {
    ThreadManager.post(new PublicAccountImageCollectionPreloadManager.6(this), 5, null, false);
  }
  
  public void bdm()
  {
    synchronized (this.aV)
    {
      this.waitingList.clear();
      this.kS.clear();
      this.eF.clear();
      return;
    }
  }
  
  public void bhs()
  {
    ThreadManager.executeOnSubThread(new PreloadProtoThread());
  }
  
  void c(oub.a parama)
  {
    this.mMainThreadHandler.post(new PublicAccountImageCollectionPreloadManager.1(this, parama));
  }
  
  public void d(oub.a parama)
  {
    if (!Hq()) {}
    for (;;)
    {
      return;
      LinkedList localLinkedList = new LinkedList();
      if (this.eF.get(parama.articleId) == null) {}
      synchronized (this.aV)
      {
        oub.b localb = parama.a;
        if ((localb != null) && (localb.url != null) && (!TextUtils.isEmpty(localb.url)))
        {
          this.eF.put(parama.articleId, localb.url);
          localLinkedList.add(localb.url);
        }
        if (localLinkedList == null) {
          continue;
        }
        dC(localLinkedList);
        return;
      }
    }
  }
  
  public void oZ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "add Task articleID:" + paramString);
    }
    ??? = a(paramString);
    if (??? != null)
    {
      d((oub.a)???);
      return;
    }
    synchronized (this.lock)
    {
      if (!this.waitingList.contains(paramString))
      {
        this.waitingList.add(paramString);
        if (!this.ays) {
          bdi();
        }
      }
      return;
    }
  }
  
  public int rT()
  {
    return this.aHP;
  }
  
  public void rd(boolean paramBoolean)
  {
    anpc.a(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "eventPAAlbumRequestAlbumHitStatics", paramBoolean, 0L, 0L, null, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("\n");
      localStringBuilder.append("doStatisticReportForProtoHit-->success = ").append(paramBoolean);
      QLog.d(TAG, 2, localStringBuilder.toString());
    }
  }
  
  public void removeObserver()
  {
    this.b = null;
  }
  
  public void v(boolean paramBoolean, long paramLong)
  {
    paramLong = NetConnInfoCenter.getServerTimeMillis() - paramLong;
    anpc.a(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "eventPAAlbumRequestAlbumTime", paramBoolean, paramLong, 0L, null, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("\n");
      localStringBuilder.append("doStatisticReportForProtoTime-->success = ").append(paramBoolean).append(" ,costTime = " + paramLong);
      QLog.d(TAG, 2, localStringBuilder.toString());
    }
  }
  
  public void w(boolean paramBoolean, long paramLong)
  {
    paramLong = NetConnInfoCenter.getServerTimeMillis() - paramLong;
    anpc.a(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "eventPAAlbumPreDownPhotoTime", paramBoolean, paramLong, 0L, null, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("\n");
      localStringBuilder.append("doStatisticReportForImageTime-->success = ").append(paramBoolean).append(" ,costTime = " + paramLong);
      QLog.d(TAG, 2, localStringBuilder.toString());
    }
  }
  
  class PreloadProtoThread
    implements Runnable
  {
    PreloadProtoThread() {}
    
    public void run()
    {
      ??? = PublicAccountImageCollectionPreloadManager.a(PublicAccountImageCollectionPreloadManager.this).iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        PublicAccountImageCollectionPreloadManager.a(PublicAccountImageCollectionPreloadManager.this, str);
      }
      synchronized (PublicAccountImageCollectionPreloadManager.this.lock)
      {
        PublicAccountImageCollectionPreloadManager.a(PublicAccountImageCollectionPreloadManager.this).clear();
        if (PublicAccountImageCollectionPreloadManager.b(PublicAccountImageCollectionPreloadManager.this).size() > 0)
        {
          PublicAccountImageCollectionPreloadManager.a(PublicAccountImageCollectionPreloadManager.this);
          return;
        }
        PublicAccountImageCollectionPreloadManager.this.ays = false;
      }
    }
  }
  
  class ReadFileThread
    implements Runnable
  {
    String articleId;
    
    public ReadFileThread(String paramString)
    {
      this.articleId = paramString;
    }
    
    public void run()
    {
      for (;;)
      {
        try
        {
          localFileInputStream = new FileInputStream(acbn.bnD + this.articleId);
          localObject1 = null;
        }
        catch (Exception localException1)
        {
          FileInputStream localFileInputStream;
          Object localObject1;
          Object localObject2;
          int i;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(PublicAccountImageCollectionPreloadManager.TAG, 2, "read Exception " + localException1);
        }
        try
        {
          localObject2 = new byte[localFileInputStream.available()];
          localObject1 = localObject2;
          localFileInputStream.read((byte[])localObject2);
          localObject1 = localObject2;
          i = 1;
        }
        catch (Exception localException2)
        {
          i = 0;
        }
      }
      localFileInputStream.close();
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(PublicAccountImageCollectionPreloadManager.TAG, 2, "preloadFileToCache");
        }
        localObject2 = new ArticleComment.GetPhotoCollectionInfoResponse();
        ((ArticleComment.GetPhotoCollectionInfoResponse)localObject2).mergeFrom((byte[])localObject1);
        localObject1 = PublicAccountImageCollectionPreloadManager.a(PublicAccountImageCollectionPreloadManager.this, (ArticleComment.GetPhotoCollectionInfoResponse)localObject2, this.articleId);
        PublicAccountImageCollectionPreloadManager.this.g.put(this.articleId, localObject1);
        PublicAccountImageCollectionPreloadManager.this.c((oub.a)localObject1);
        PublicAccountImageCollectionPreloadManager.this.d((oub.a)localObject1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager
 * JD-Core Version:    0.7.0.1
 */