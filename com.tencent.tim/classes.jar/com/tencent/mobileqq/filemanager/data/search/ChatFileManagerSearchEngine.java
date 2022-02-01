package com.tencent.mobileqq.filemanager.data.search;

import agkf;
import agne;
import agnp;
import amwd;
import amwe;
import amwt;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChatFileManagerSearchEngine
  implements amwd<agnp>
{
  private SearchRunnable a = new SearchRunnable(null);
  private Bundle aY;
  private int cdG = 1;
  private QQAppInterface mApp;
  private int mFromType = 0;
  
  public ChatFileManagerSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.mApp = paramQQAppInterface;
    this.mFromType = paramInt;
  }
  
  private List<Integer> ae(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 3)
    {
      localArrayList.add(Integer.valueOf(9));
      localArrayList.add(Integer.valueOf(7));
      localArrayList.add(Integer.valueOf(6));
      localArrayList.add(Integer.valueOf(3));
      return localArrayList;
    }
    localArrayList.add(Integer.valueOf(paramInt));
    return localArrayList;
  }
  
  public void G(int paramInt, Bundle paramBundle)
  {
    this.cdG = paramInt;
    this.aY = paramBundle;
  }
  
  public List<agnp> a(amwt paramamwt)
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    agnp localagnp;
    if (this.cdG == 1)
    {
      localObject1 = this.mApp.a().p(paramamwt.keyword);
      localObject2 = ((Map)localObject1).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localagnp = new agnp();
        localagnp.Br.addAll((Collection)((Map)localObject1).get(localObject3));
        localagnp.keyword = paramamwt.keyword;
        localagnp.fromType = this.mFromType;
        if (this.aY != null) {
          localagnp.mUin = this.aY.getString("qfile_search_param_uin", "");
        }
        localArrayList1.add(localagnp);
      }
    }
    ArrayList localArrayList2;
    if (this.cdG == 4)
    {
      if (this.aY != null)
      {
        int i = this.aY.getInt("qfile_search_param_type", -1);
        localObject2 = this.aY.getString("qfile_search_param_uin", "");
        localObject1 = this.aY.getIntegerArrayList("qfile_search_param_others");
        if ((i != -1) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          if (i == 11) {
            if (((List)localObject1).contains(Integer.valueOf(3)))
            {
              ((List)localObject1).add(Integer.valueOf(6));
              ((List)localObject1).add(Integer.valueOf(7));
              ((List)localObject1).add(Integer.valueOf(9));
            }
          }
          for (localObject1 = this.mApp.a().e((List)localObject1, (String)localObject2); localObject1 != null; localObject1 = this.mApp.a().d(ae(i), (String)localObject2))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (FileManagerEntity)((Iterator)localObject1).next();
              localagnp = new agnp();
              localArrayList2 = new ArrayList(1);
              localArrayList2.add(localObject3);
              localagnp.Br.addAll(localArrayList2);
              localagnp.keyword = paramamwt.keyword;
              localagnp.fromType = this.mFromType;
              localagnp.mUin = ((String)localObject2);
              localArrayList1.add(localagnp);
            }
          }
        }
      }
    }
    else if ((this.cdG == 3) && (this.aY != null))
    {
      localObject1 = this.aY.getString("qfile_search_param_uin", "");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = this.mApp.a().a(paramamwt.keyword, (String)localObject1, false).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
          localagnp = new agnp();
          localArrayList2 = new ArrayList(1);
          localArrayList2.add(localObject3);
          localagnp.Br.addAll(localArrayList2);
          localagnp.keyword = paramamwt.keyword;
          localagnp.fromType = this.mFromType;
          localagnp.mUin = ((String)localObject1);
          localArrayList1.add(localagnp);
        }
      }
    }
    return localArrayList1;
  }
  
  public void a(amwt paramamwt, amwe<agnp> paramamwe)
  {
    if ((paramamwt == null) || (paramamwt.keyword == null) || (TextUtils.isEmpty(paramamwt.keyword.trim()))) {
      return;
    }
    synchronized (this.a)
    {
      this.a.a = paramamwt;
      this.a.b = paramamwe;
      ThreadManager.removeJobFromThreadPool(this.a, 64);
      ThreadManager.executeOnFileThread(this.a);
      return;
    }
  }
  
  public void cancel()
  {
    synchronized (this.a)
    {
      this.a.a = null;
      this.a.b = null;
      ThreadManager.removeJobFromThreadPool(this.a, 64);
      return;
    }
  }
  
  public void destroy() {}
  
  public void init()
  {
    this.mApp.a().init();
  }
  
  public void pause() {}
  
  public void resume() {}
  
  class SearchRunnable
    implements Runnable
  {
    amwt a;
    amwe<agnp> b;
    
    private SearchRunnable() {}
    
    public void run()
    {
      try
      {
        if (this.a == null)
        {
          this.b.s(new ArrayList(), 6);
          return;
        }
        amwt localamwt = this.a;
        String str = this.a.keyword;
        List localList = ChatFileManagerSearchEngine.this.a(localamwt);
        try
        {
          if ((this.b != null) && (localamwt == this.a) && (str.equals(this.a.keyword))) {
            this.b.s(localList, 1);
          }
          return;
        }
        finally {}
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.ChatFileManagerSearchEngine
 * JD-Core Version:    0.7.0.1
 */