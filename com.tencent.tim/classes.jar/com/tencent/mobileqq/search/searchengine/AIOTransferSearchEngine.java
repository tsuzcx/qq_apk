package com.tencent.mobileqq.search.searchengine;

import acdu;
import acff;
import amoc;
import amuv;
import amwd;
import amwe;
import amwt;
import android.text.TextUtils;
import atgc;
import atgi;
import com.tencent.cloudfile.CloudSearchReq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AIOTransferSearchEngine
  implements amwd<amoc>
{
  private SearchRunnable a;
  public CloudFileGroupSearchEngine.a a;
  public QQAppInterface app;
  private boolean cEm;
  public amwe<amoc> e;
  int mFromType;
  
  public AIOTransferSearchEngine(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAIOTransferSearchEngine$SearchRunnable = new SearchRunnable(null);
    this.app = paramQQAppInterface;
    this.mFromType = paramInt;
    this.cEm = paramBoolean;
  }
  
  private void a(byte[] paramArrayOfByte, String paramString, amwt paramamwt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    while ((TextUtils.isEmpty(paramString)) && (!this.cEm)) {
      return;
    }
    CloudSearchReq localCloudSearchReq = new CloudSearchReq();
    localCloudSearchReq.pDirKey = paramArrayOfByte;
    localCloudSearchReq.strKeywords = paramString;
    paramArrayOfByte = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject1 = ((acff)this.app.getManager(51)).cq();
      Object localObject2;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Friends)((Iterator)localObject1).next();
          if (((!TextUtils.isEmpty(((Friends)localObject2).name)) && (((Friends)localObject2).name.toLowerCase().contains(paramString.toLowerCase()))) || ((!TextUtils.isEmpty(((Friends)localObject2).remark)) && (((Friends)localObject2).remark.toLowerCase().contains(paramString.toLowerCase())))) {
            paramArrayOfByte.add(Long.valueOf(Long.parseLong(((Friends)localObject2).uin)));
          }
        }
      }
      localObject1 = ((acdu)this.app.getManager(53)).getDiscussList();
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
          if ((!TextUtils.isEmpty(((DiscussionInfo)localObject2).discussionName)) && (((DiscussionInfo)localObject2).discussionName.toLowerCase().contains(paramString.toLowerCase()))) {
            paramArrayOfByte.add(Long.valueOf(Long.parseLong(((DiscussionInfo)localObject2).uin)));
          }
        }
      }
    }
    if (!paramArrayOfByte.isEmpty()) {
      localCloudSearchReq.searchUinList = paramArrayOfByte;
    }
    if ((this.mFromType == 27) || (this.mFromType == 28) || (this.mFromType == 29) || (this.mFromType == 30))
    {
      localCloudSearchReq.count = 4;
      localCloudSearchReq.modelTypeFilter = 2;
      switch (this.mFromType)
      {
      default: 
        localCloudSearchReq.fileTypeFilter = 63;
        label451:
        if (this.mFromType == 32) {
          localCloudSearchReq.searchTransferTypeFilter = 2;
        }
        break;
      }
    }
    for (;;)
    {
      paramArrayOfByte = new amuv(this, paramString, paramamwt);
      atgi.a().a(localCloudSearchReq, paramArrayOfByte);
      return;
      localCloudSearchReq.count = -1;
      break;
      localCloudSearchReq.fileTypeFilter = 1;
      break label451;
      localCloudSearchReq.fileTypeFilter = 8;
      break label451;
      localCloudSearchReq.fileTypeFilter = 2;
      break label451;
      if (this.mFromType == 33) {
        localCloudSearchReq.searchTransferTypeFilter = 1;
      } else {
        localCloudSearchReq.searchTransferTypeFilter = 7;
      }
    }
  }
  
  public List<amoc> a(amwt paramamwt)
  {
    if (((paramamwt == null) || (TextUtils.isEmpty(paramamwt.keyword))) && (!this.cEm)) {
      return null;
    }
    byte[] arrayOfByte = ((atgc)this.app.getManager(373)).aF();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("AIOTransferSearchEngine search | ").append(paramamwt.keyword).append(" ");
      if (arrayOfByte != null) {
        break label118;
      }
    }
    label118:
    for (String str = "dirKey == null";; str = arrayOfByte.toString())
    {
      QLog.i("AIOTransferSearchEngine", 2, str + " mFromType : " + this.mFromType);
      a(arrayOfByte, paramamwt.keyword, paramamwt);
      return null;
    }
  }
  
  public void a(amwt paramamwt, amwe<amoc> paramamwe)
  {
    if (((paramamwt == null) || (TextUtils.isEmpty(paramamwt.keyword))) && (!this.cEm)) {
      return;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAIOTransferSearchEngine$SearchRunnable)
    {
      this.e = paramamwe;
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAIOTransferSearchEngine$SearchRunnable.a = paramamwt;
      ThreadManager.remove(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAIOTransferSearchEngine$SearchRunnable);
      ThreadManager.postImmediately(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAIOTransferSearchEngine$SearchRunnable, null, false);
      return;
    }
  }
  
  public void a(CloudFileGroupSearchEngine.a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCloudFileGroupSearchEngine$a = parama;
  }
  
  public void cancel()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAIOTransferSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAIOTransferSearchEngine$SearchRunnable.a = null;
      ThreadManager.remove(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineAIOTransferSearchEngine$SearchRunnable);
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
      AIOTransferSearchEngine.this.a(localamwt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.AIOTransferSearchEngine
 * JD-Core Version:    0.7.0.1
 */