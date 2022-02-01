package com.tencent.mobileqq.search.searchengine;

import amou;
import amvl;
import amwd;
import amwe;
import amwt;
import android.text.TextUtils;
import atgc;
import atgi;
import com.tencent.cloudfile.CloudSearchReq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FolderSearchEngine
  implements amwd<amou>
{
  public CloudFileGroupSearchEngine.a a;
  private SearchRunnable a;
  public QQAppInterface app;
  int bYo;
  public amwe<amou> e;
  
  public FolderSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineFolderSearchEngine$SearchRunnable = new SearchRunnable(null);
    this.app = paramQQAppInterface;
    this.bYo = paramInt;
  }
  
  private void a(String paramString, amwt paramamwt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    CloudSearchReq localCloudSearchReq = new CloudSearchReq();
    localCloudSearchReq.strKeywords = paramString;
    if (this.bYo == 27) {}
    for (localCloudSearchReq.count = 4;; localCloudSearchReq.count = -1)
    {
      localCloudSearchReq.modelTypeFilter = 1;
      localCloudSearchReq.fileTypeFilter = 63;
      paramString = new amvl(this, paramString, paramamwt);
      atgi.a().a(localCloudSearchReq, paramString);
      return;
    }
  }
  
  public List<amou> a(amwt paramamwt)
  {
    if ((paramamwt == null) || (TextUtils.isEmpty(paramamwt.keyword))) {
      return null;
    }
    atgc localatgc = (atgc)this.app.getManager(373);
    if (QLog.isColorLevel()) {
      QLog.i("FolderSearchEngine", 2, "FolderSearchEngine search | " + paramamwt.keyword);
    }
    a(paramamwt.keyword, paramamwt);
    return null;
  }
  
  public void a(amwt paramamwt, amwe<amou> paramamwe)
  {
    if ((paramamwt == null) || (TextUtils.isEmpty(paramamwt.keyword))) {
      return;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineFolderSearchEngine$SearchRunnable)
    {
      this.e = paramamwe;
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineFolderSearchEngine$SearchRunnable.a = paramamwt;
      ThreadManager.remove(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineFolderSearchEngine$SearchRunnable);
      ThreadManager.postImmediately(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineFolderSearchEngine$SearchRunnable, null, false);
      return;
    }
  }
  
  public void a(CloudFileGroupSearchEngine.a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCloudFileGroupSearchEngine$a = parama;
  }
  
  public void cancel()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineFolderSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineFolderSearchEngine$SearchRunnable.a = null;
      ThreadManager.remove(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineFolderSearchEngine$SearchRunnable);
      return;
    }
  }
  
  public void destroy() {}
  
  public void init() {}
  
  public void pause() {}
  
  public void resume() {}
  
  class SearchRunnable
    implements Runnable
  {
    amwt a;
    
    private SearchRunnable() {}
    
    public void run()
    {
      amwt localamwt = this.a;
      FolderSearchEngine.this.a(localamwt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.FolderSearchEngine
 * JD-Core Version:    0.7.0.1
 */