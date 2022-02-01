package com.tencent.mobileqq.search.searchengine;

import amog;
import amvd;
import amwd;
import amwe;
import amwt;
import android.text.TextUtils;
import atgi;
import atkw;
import atky;
import aull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.PadInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CloudRecentSearchEngine
  implements amwd<amog>
{
  private SearchRunnable a = new SearchRunnable(null);
  private QQAppInterface app;
  private amwe<amog> e;
  
  public CloudRecentSearchEngine(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private atkw a(PadInfo paramPadInfo)
  {
    atky localatky = new atky();
    localatky.fileName = paramPadInfo.title;
    localatky.relatedType = 7;
    localatky.fQ = paramPadInfo;
    localatky.lastTime = Math.max(paramPadInfo.lastEditTime, paramPadInfo.currentUserBrowseTime);
    return localatky;
  }
  
  private List<atkw> l(List<atkw> paramList1, List<atkw> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramList1);
    localArrayList.addAll(paramList2);
    return localArrayList;
  }
  
  public List<amog> a(amwt paramamwt)
  {
    if ((paramamwt == null) || (TextUtils.isEmpty(paramamwt.keyword))) {}
    ArrayList localArrayList;
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("CloudRecentSearchEngine", 2, "CloudRecentSearchEngine search | " + paramamwt.keyword);
      }
      this.a.a = paramamwt;
      localArrayList = new ArrayList();
      Object localObject1 = new ArrayList();
      ??? = (aull)this.app.getManager(372);
      Object localObject3 = new ArrayList();
      ((ArrayList)localObject3).addAll(((aull)???).hp());
      ??? = new HashMap();
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        PadInfo localPadInfo1 = (PadInfo)((Iterator)localObject3).next();
        if (localPadInfo1 != null)
        {
          if (((HashMap)???).containsKey(localPadInfo1.pad_url))
          {
            PadInfo localPadInfo2 = (PadInfo)((HashMap)???).get(localPadInfo1.pad_url);
            if (localPadInfo1.currentUserBrowseTime < localPadInfo2.currentUserBrowseTime) {
              localPadInfo1.currentUserBrowseTime = localPadInfo2.currentUserBrowseTime;
            }
            if (localPadInfo1.lastEditTime < localPadInfo2.lastEditTime)
            {
              localPadInfo1.lastEditTime = localPadInfo2.lastEditTime;
              localPadInfo1.lastEditorUin = localPadInfo2.lastEditorUin;
              localPadInfo1.lastEditorNick = localPadInfo2.lastEditorNick;
            }
          }
          if ((!TextUtils.isEmpty(paramamwt.keyword)) && (localPadInfo1 != null) && (!TextUtils.isEmpty(localPadInfo1.title)) && (localPadInfo1.title.toLowerCase().contains(paramamwt.keyword))) {
            ((HashMap)???).put(localPadInfo1.pad_url, localPadInfo1);
          }
        }
      }
      ??? = ((HashMap)???).values().iterator();
      while (((Iterator)???).hasNext()) {
        localArrayList.add(a((PadInfo)((Iterator)???).next()));
      }
      synchronized (new Object())
      {
        atgi.a().a(paramamwt.keyword, 200, new amvd(this, ???, (List)localObject1));
        try
        {
          ???.wait();
          localObject1 = l((List)localObject1, localArrayList);
          localArrayList = new ArrayList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (atkw)((Iterator)localObject1).next();
            if (??? != null)
            {
              localObject3 = new amog(this.app);
              ((amog)localObject3).a((atkw)???);
              ((amog)localObject3).keyword = paramamwt.keyword;
              localArrayList.add(localObject3);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    } while (this.e == null);
    this.e.s(localArrayList, 1);
    return null;
  }
  
  public void a(amwt paramamwt, amwe paramamwe)
  {
    if ((paramamwt == null) || (TextUtils.isEmpty(paramamwt.keyword))) {
      return;
    }
    synchronized (this.a)
    {
      this.e = paramamwe;
      this.a.a = paramamwt;
      ThreadManager.remove(this.a);
      ThreadManager.postImmediately(this.a, null, false);
      return;
    }
  }
  
  public void cancel()
  {
    synchronized (this.a)
    {
      this.a.a = null;
      ThreadManager.remove(this.a);
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
      amwt localamwt = this.a;
      CloudRecentSearchEngine.this.a(localamwt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.CloudRecentSearchEngine
 * JD-Core Version:    0.7.0.1
 */