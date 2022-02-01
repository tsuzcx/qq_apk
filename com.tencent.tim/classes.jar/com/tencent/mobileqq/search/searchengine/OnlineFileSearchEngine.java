package com.tencent.mobileqq.search.searchengine;

import amqx;
import amwd;
import amwe;
import amwl;
import amwm;
import amwn;
import amwt;
import android.text.TextUtils;
import atgi;
import aull;
import com.tencent.cloudfile.CloudSearchReq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.PadInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class OnlineFileSearchEngine
  implements amwd<amqx>
{
  public CloudFileGroupSearchEngine.a a;
  private SearchRunnable a;
  private Comparator<amqx> ac = new amwn(this);
  public QQAppInterface app;
  private boolean cEm;
  private Comparator<a> comparator = new amwm(this);
  public amwe<amqx> e;
  int mFromType;
  
  public OnlineFileSearchEngine(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineOnlineFileSearchEngine$SearchRunnable = new SearchRunnable(null);
    this.app = paramQQAppInterface;
    this.mFromType = paramInt;
    this.cEm = paramBoolean;
  }
  
  private List<PadInfo> e(HashMap<String, PadInfo> paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    Object localObject = new ArrayList();
    paramHashMap = paramHashMap.values().iterator();
    while (paramHashMap.hasNext())
    {
      PadInfo localPadInfo = (PadInfo)paramHashMap.next();
      long l = Math.max(localPadInfo.lastEditTime, localPadInfo.currentUserBrowseTime);
      a locala = new a(null);
      locala.opTime = l;
      locala.a = localPadInfo;
      ((List)localObject).add(locala);
    }
    if (!((List)localObject).isEmpty()) {
      Collections.sort((List)localObject, this.comparator);
    }
    paramHashMap = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramHashMap.add(((a)((Iterator)localObject).next()).a);
    }
    return paramHashMap;
  }
  
  public List<amqx> a(amwt paramamwt)
  {
    if (paramamwt != null) {}
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      PadInfo localPadInfo;
      Object localObject3;
      try
      {
        if (TextUtils.isEmpty(paramamwt.keyword))
        {
          boolean bool = this.cEm;
          if (!bool)
          {
            paramamwt = null;
            return paramamwt;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("OnlineFileSearchEngine", 2, "OnlineFileSearchEngine search | " + paramamwt.keyword);
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineOnlineFileSearchEngine$SearchRunnable.a = paramamwt;
        localObject1 = (aull)this.app.getManager(372);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll(((aull)localObject1).hp());
        ((ArrayList)localObject2).addAll(((aull)localObject1).ho());
        localObject1 = new HashMap();
        localObject2 = ((ArrayList)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label587;
        }
        localPadInfo = (PadInfo)((Iterator)localObject2).next();
        if (localPadInfo == null) {
          continue;
        }
        if (((HashMap)localObject1).containsKey(localPadInfo.pad_url))
        {
          localObject3 = (PadInfo)((HashMap)localObject1).get(localPadInfo.pad_url);
          if (localPadInfo.currentUserBrowseTime < ((PadInfo)localObject3).currentUserBrowseTime) {
            localPadInfo.currentUserBrowseTime = ((PadInfo)localObject3).currentUserBrowseTime;
          }
          if (localPadInfo.lastEditTime < ((PadInfo)localObject3).lastEditTime)
          {
            localPadInfo.lastEditTime = ((PadInfo)localObject3).lastEditTime;
            localPadInfo.lastEditorUin = ((PadInfo)localObject3).lastEditorUin;
            localPadInfo.lastEditorNick = ((PadInfo)localObject3).lastEditorNick;
          }
        }
        if ((this.cEm) && (TextUtils.isEmpty(paramamwt.keyword)))
        {
          ((HashMap)localObject1).put(localPadInfo.pad_url, localPadInfo);
          continue;
        }
        if (TextUtils.isEmpty(paramamwt.keyword)) {
          continue;
        }
      }
      finally {}
      if (localPadInfo != null) {
        if ((!TextUtils.isEmpty(localPadInfo.title)) && (localPadInfo.title.toLowerCase().contains(paramamwt.keyword.toLowerCase())))
        {
          ((HashMap)localObject1).put(localPadInfo.pad_url, localPadInfo);
        }
        else if ((!TextUtils.isEmpty(this.app.getCurrentUin())) && (!this.app.getCurrentUin().equals(String.valueOf(localPadInfo.creatorUin))) && (!TextUtils.isEmpty(localPadInfo.creatorNick)) && (localPadInfo.creatorNick.toLowerCase().contains(paramamwt.keyword.toLowerCase())))
        {
          ((HashMap)localObject1).put(localPadInfo.pad_url, localPadInfo);
        }
        else
        {
          int i = localPadInfo.type_list;
          long l = 0L;
          if (localPadInfo.isCloudFile) {
            l = localPadInfo.iCloudFileCreateTime;
          }
          if (i == 3) {}
          for (l = Math.max(l, localPadInfo.lastEditTime);; l = Math.max(Math.max(l, localPadInfo.lastEditTime), localPadInfo.currentUserBrowseTime))
          {
            if ((l != localPadInfo.lastEditTime) || (TextUtils.isEmpty(this.app.getCurrentUin())) || (this.app.getCurrentUin().equals(String.valueOf(localPadInfo.lastEditorUin))) || (!localPadInfo.lastEditorNick.toLowerCase().contains(paramamwt.keyword.toLowerCase()))) {
              break label585;
            }
            ((HashMap)localObject1).put(localPadInfo.pad_url, localPadInfo);
            break;
          }
          label585:
          continue;
          label587:
          localObject2 = e((HashMap)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("OnlineFileSearchEngine", 2, "duplicate map size = " + ((HashMap)localObject1).size() + ", padInfoList.size = " + ((List)localObject2).size());
          }
          localObject1 = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localPadInfo = (PadInfo)((Iterator)localObject2).next();
            if (localPadInfo != null)
            {
              localObject3 = new amqx(this.app);
              ((amqx)localObject3).a = localPadInfo;
              ((amqx)localObject3).keyword = paramamwt.keyword;
              ((List)localObject1).add(localObject3);
            }
          }
          paramamwt = (amwt)localObject1;
        }
      }
    }
  }
  
  public void a(amwt paramamwt)
  {
    if (paramamwt != null) {}
    for (;;)
    {
      CloudSearchReq localCloudSearchReq;
      try
      {
        if (TextUtils.isEmpty(paramamwt.keyword))
        {
          boolean bool = this.cEm;
          if (!bool) {
            return;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("OnlineFileSearchEngine", 2, "OnlineFileSearchEngine searchInnerForCloudOnlineFile search | " + paramamwt.keyword);
        }
        List localList = a(paramamwt);
        localCloudSearchReq = new CloudSearchReq();
        localCloudSearchReq.strKeywords = paramamwt.keyword;
        if (this.mFromType == 27)
        {
          localCloudSearchReq.count = 4;
          localCloudSearchReq.fileTypeFilter = 63;
          localCloudSearchReq.searchStoreBizTypeFileter = 2;
          localCloudSearchReq.modelTypeFilter = 2;
          paramamwt = new amwl(this, paramamwt, localList);
          atgi.a().a(localCloudSearchReq, paramamwt);
          continue;
        }
        if (this.mFromType != 27) {
          continue;
        }
      }
      finally {}
      localCloudSearchReq.count = -1;
    }
  }
  
  public void a(amwt paramamwt, amwe<amqx> paramamwe)
  {
    if (((paramamwt == null) || (TextUtils.isEmpty(paramamwt.keyword))) && (!this.cEm)) {
      return;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineOnlineFileSearchEngine$SearchRunnable)
    {
      this.e = paramamwe;
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineOnlineFileSearchEngine$SearchRunnable.a = paramamwt;
      ThreadManager.remove(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineOnlineFileSearchEngine$SearchRunnable);
      ThreadManager.postImmediately(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineOnlineFileSearchEngine$SearchRunnable, null, false);
      return;
    }
  }
  
  public void a(CloudFileGroupSearchEngine.a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCloudFileGroupSearchEngine$a = parama;
  }
  
  public void cancel()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineOnlineFileSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineOnlineFileSearchEngine$SearchRunnable.a = null;
      ThreadManager.remove(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineOnlineFileSearchEngine$SearchRunnable);
      return;
    }
  }
  
  public void destroy() {}
  
  public void init()
  {
    ((aull)this.app.getManager(372)).qh();
  }
  
  public void pause() {}
  
  public void resume() {}
  
  class SearchRunnable
    implements Runnable
  {
    amwt a;
    
    private SearchRunnable() {}
    
    public void run()
    {
      amwt localamwt1 = this.a;
      if (OnlineFileSearchEngine.this.mFromType == 35)
      {
        List localList = OnlineFileSearchEngine.this.a(localamwt1);
        try
        {
          if ((OnlineFileSearchEngine.this.e != null) && (localamwt1 == this.a)) {
            OnlineFileSearchEngine.this.e.s(localList, 1);
          }
          return;
        }
        finally {}
      }
      if ((OnlineFileSearchEngine.this.mFromType == 27) || (OnlineFileSearchEngine.this.mFromType == 42)) {
        OnlineFileSearchEngine.this.a(localamwt2);
      }
    }
  }
  
  public class a
  {
    PadInfo a;
    public long opTime;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.OnlineFileSearchEngine
 * JD-Core Version:    0.7.0.1
 */