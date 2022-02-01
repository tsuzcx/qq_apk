package com.tencent.mobileqq.filemanager.data.search;

import agkf;
import agne;
import agns;
import amwd;
import amwe;
import amwt;
import android.text.TextUtils;
import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileManagerSearchEngine
  implements amwd<agns>
{
  private SearchRunnable a = new SearchRunnable(null);
  QQAppInterface mApp;
  int mFromType = -1;
  
  public FileManagerSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.mApp = paramQQAppInterface;
    this.mFromType = paramInt;
  }
  
  public List<agns> a(amwt paramamwt)
  {
    Map localMap = this.mApp.a().p(paramamwt.keyword);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = localMap.keySet().iterator();
    Object localObject;
    agns localagns;
    if (localIterator1.hasNext())
    {
      localObject = (String)localIterator1.next();
      localagns = new agns();
      localObject = (List)localMap.get(localObject);
      Iterator localIterator2 = ((List)localObject).iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
      } while (((FileManagerEntity)localIterator2.next()).nFileType != 13);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (this.mFromType != 1) {
          break label203;
        }
        anot.a(this.mApp, "dc00898", "", "", "0X800A083", "0X800A083", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        localagns.Br.addAll((Collection)localObject);
        localagns.keyword = paramamwt.keyword;
        localagns.fromType = this.mFromType;
        localArrayList.add(localagns);
        break;
        label203:
        if (this.mFromType == 8) {
          anot.a(this.mApp, "dc00898", "", "", "0X800A085", "0X800A085", 0, 0, "", "", "", "");
        }
      }
      return localArrayList;
    }
  }
  
  public void a(amwt paramamwt, amwe<agns> paramamwe)
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
    amwe<agns> b;
    
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
        List localList = FileManagerSearchEngine.this.a(localamwt);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine
 * JD-Core Version:    0.7.0.1
 */