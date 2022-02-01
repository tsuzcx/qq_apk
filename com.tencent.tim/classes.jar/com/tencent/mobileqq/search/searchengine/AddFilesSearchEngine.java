package com.tencent.mobileqq.search.searchengine;

import ampx;
import amuw;
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

public class AddFilesSearchEngine
  implements amwd<ampx>
{
  private SearchRunnable a;
  public CloudFileGroupSearchEngine.a a;
  public QQAppInterface app;
  byte[] cA;
  private boolean cEm;
  public amwe<ampx> e;
  int mFromType;
  
  public AddFilesSearchEngine(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAddFilesSearchEngine$SearchRunnable = new SearchRunnable(null);
    this.app = paramQQAppInterface;
    this.mFromType = paramInt;
    this.cEm = paramBoolean;
  }
  
  public AddFilesSearchEngine(QQAppInterface paramQQAppInterface, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAddFilesSearchEngine$SearchRunnable = new SearchRunnable(null);
    this.app = paramQQAppInterface;
    this.mFromType = paramInt;
    this.cA = paramArrayOfByte;
    this.cEm = paramBoolean;
  }
  
  private void a(byte[] paramArrayOfByte, String paramString, amwt paramamwt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    while ((TextUtils.isEmpty(paramString)) && (!this.cEm)) {
      return;
    }
    CloudSearchReq localCloudSearchReq = new CloudSearchReq();
    if ((this.mFromType == 34) || (this.mFromType == 43))
    {
      localCloudSearchReq.pDirKey = this.cA;
      localCloudSearchReq.modelTypeFilter = 3;
      localCloudSearchReq.strKeywords = paramString;
      if ((this.mFromType != 27) && (this.mFromType != 28) && (this.mFromType != 29) && (this.mFromType != 30)) {
        break label419;
      }
      localCloudSearchReq.count = 4;
      label114:
      if ((this.mFromType != 27) && (this.mFromType != 36)) {
        break label428;
      }
      localCloudSearchReq.searchStoreBizTypeFileter = 1;
      label138:
      switch (this.mFromType)
      {
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
      default: 
        localCloudSearchReq.fileTypeFilter = 63;
      }
    }
    for (;;)
    {
      paramArrayOfByte = new amuw(this, paramString, paramamwt);
      atgi.a().a(localCloudSearchReq, paramArrayOfByte);
      return;
      if ((this.mFromType == 27) || (this.mFromType == 36) || (this.mFromType == 28) || (this.mFromType == 46) || (this.mFromType == 29) || (this.mFromType == 47) || (this.mFromType == 30) || (this.mFromType == 48))
      {
        localCloudSearchReq.pDirKeyExclude = paramArrayOfByte;
        localCloudSearchReq.modelTypeFilter = 2;
        break;
      }
      if ((this.mFromType != 37) && (this.mFromType != 38) && (this.mFromType != 39) && (this.mFromType != 40) && (this.mFromType != 41)) {
        break;
      }
      localCloudSearchReq.pDirKey = this.cA;
      localCloudSearchReq.modelTypeFilter = 2;
      break;
      label419:
      localCloudSearchReq.count = -1;
      break label114;
      label428:
      if ((this.mFromType != 34) && (this.mFromType != 43)) {
        break label138;
      }
      localCloudSearchReq.searchStoreBizTypeFileter = 3;
      break label138;
      localCloudSearchReq.searchStoreBizTypeFileter = 1;
      localCloudSearchReq.fileTypeFilter = 1;
      continue;
      localCloudSearchReq.searchStoreBizTypeFileter = 1;
      localCloudSearchReq.fileTypeFilter = 8;
      continue;
      localCloudSearchReq.searchStoreBizTypeFileter = 1;
      localCloudSearchReq.fileTypeFilter = 2;
      continue;
      localCloudSearchReq.searchStoreBizTypeFileter = 1;
      localCloudSearchReq.fileTypeFilter = 32;
      continue;
      localCloudSearchReq.fileTypeFilter = 63;
      localCloudSearchReq.searchStoreBizTypeFileter = 2;
    }
  }
  
  public List<ampx> a(amwt paramamwt)
  {
    if (((paramamwt == null) || (TextUtils.isEmpty(paramamwt.keyword))) && (!this.cEm)) {
      return null;
    }
    byte[] arrayOfByte = ((atgc)this.app.getManager(373)).aF();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("AddFilesSearchEngine search | ").append(paramamwt.keyword).append(" ");
      if (arrayOfByte != null) {
        break label118;
      }
    }
    label118:
    for (String str = "pDirKeyExclude == null";; str = arrayOfByte.toString())
    {
      QLog.i("AddFilesSearchEngine", 2, str + " mFromType : " + this.mFromType);
      a(arrayOfByte, paramamwt.keyword, paramamwt);
      return null;
    }
  }
  
  public void a(amwt paramamwt, amwe<ampx> paramamwe)
  {
    if (((paramamwt == null) || (TextUtils.isEmpty(paramamwt.keyword))) && (!this.cEm)) {
      return;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAddFilesSearchEngine$SearchRunnable)
    {
      this.e = paramamwe;
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAddFilesSearchEngine$SearchRunnable.a = paramamwt;
      ThreadManager.remove(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAddFilesSearchEngine$SearchRunnable);
      ThreadManager.postImmediately(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAddFilesSearchEngine$SearchRunnable, null, false);
      return;
    }
  }
  
  public void a(CloudFileGroupSearchEngine.a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCloudFileGroupSearchEngine$a = parama;
  }
  
  public void cancel()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAddFilesSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAddFilesSearchEngine$SearchRunnable.a = null;
      ThreadManager.remove(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAddFilesSearchEngine$SearchRunnable);
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
      AddFilesSearchEngine.this.a(localamwt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.AddFilesSearchEngine
 * JD-Core Version:    0.7.0.1
 */