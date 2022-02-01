package com.tencent.mobileqq.search.searchengine;

import ampf;
import ampw;
import ampx;
import amuz;
import amva;
import amvb;
import amvc;
import amwd;
import amwe;
import amwt;
import android.text.TextUtils;
import atwp;
import atwq;
import atwr;
import atws;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CloudFileGroupSearchEngine
  implements amwd<ampw>
{
  private SearchRunnable a;
  final a b = new amuz(this);
  final a c = new amva(this);
  private boolean cEm;
  public amwt d;
  final a d;
  int dDI = 0;
  int dDJ = 0;
  amwe<ampw> jdField_e_of_type_Amwe;
  final a jdField_e_of_type_ComTencentMobileqqSearchSearchengineCloudFileGroupSearchEngine$a = new amvc(this);
  ConcurrentHashMap<String, List<ampx>> gU = new ConcurrentHashMap();
  private Future j;
  QQAppInterface mApp;
  private int mFromType = 27;
  ArrayList<amwd> zD;
  
  public CloudFileGroupSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_d_of_type_ComTencentMobileqqSearchSearchengineCloudFileGroupSearchEngine$a = new amvb(this);
    this.mFromType = paramInt;
    this.mApp = paramQQAppInterface;
    switch (this.mFromType)
    {
    }
    for (;;)
    {
      dOw();
      return;
      this.cEm = true;
    }
  }
  
  private void a(List<ampx> paramList, amwt paramamwt, String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        if (a(paramamwt))
        {
          this.dDI += 1;
          if (QLog.isColorLevel()) {
            QLog.i("CloudFileSearchEngine", 2, "mCallbackCount : " + this.dDI);
          }
          this.gU.put(paramString, paramList);
          paramString = this.gU;
          paramList = new ArrayList();
          Object localObject = (List)paramString.get("online_file_result_list");
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            localObject = new atws((List)localObject, paramamwt.keyword);
            paramList.add(new ampf((ampw)localObject));
            paramList.add(localObject);
          }
          localObject = (List)paramString.get("aio_transfer_result_list");
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            localObject = new atwp((List)localObject, paramamwt.keyword, this.mFromType);
            paramList.add(new ampf((ampw)localObject));
            paramList.add(localObject);
          }
          localObject = (List)paramString.get("add_files_result_list");
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            localObject = new atwq((List)localObject, paramamwt.keyword, this.mFromType);
            paramList.add(new ampf((ampw)localObject));
            paramList.add(localObject);
          }
          paramString = (List)paramString.get("folder_result_list");
          if ((paramString != null) && (!paramString.isEmpty()))
          {
            paramamwt = new atwr(paramString, paramamwt.keyword);
            paramList.add(new ampf(paramamwt));
            paramList.add(paramamwt);
          }
          if (this.dDI < this.dDJ) {
            this.jdField_e_of_type_Amwe.cR(paramList);
          } else {
            this.jdField_e_of_type_Amwe.s(paramList, 1);
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  private boolean a(amwt paramamwt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 195	com/tencent/mobileqq/search/searchengine/CloudFileGroupSearchEngine:jdField_d_of_type_Amwt	Lamwt;
    //   6: ifnull +37 -> 43
    //   9: aload_0
    //   10: getfield 195	com/tencent/mobileqq/search/searchengine/CloudFileGroupSearchEngine:jdField_d_of_type_Amwt	Lamwt;
    //   13: getfield 150	amwt:keyword	Ljava/lang/String;
    //   16: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +24 -> 43
    //   22: aload_1
    //   23: ifnull +20 -> 43
    //   26: aload_0
    //   27: getfield 195	com/tencent/mobileqq/search/searchengine/CloudFileGroupSearchEngine:jdField_d_of_type_Amwt	Lamwt;
    //   30: getfield 150	amwt:keyword	Ljava/lang/String;
    //   33: aload_1
    //   34: getfield 150	amwt:keyword	Ljava/lang/String;
    //   37: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifne +12 -> 52
    //   43: aload_0
    //   44: getfield 83	com/tencent/mobileqq/search/searchengine/CloudFileGroupSearchEngine:cEm	Z
    //   47: istore_2
    //   48: iload_2
    //   49: ifeq +9 -> 58
    //   52: iconst_1
    //   53: istore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: iload_2
    //   57: ireturn
    //   58: iconst_0
    //   59: istore_2
    //   60: goto -6 -> 54
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	CloudFileGroupSearchEngine
    //   0	68	1	paramamwt	amwt
    //   47	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	22	63	finally
    //   26	43	63	finally
    //   43	48	63	finally
  }
  
  private void stopTask()
  {
    if (this.j != null)
    {
      this.j.cancel(true);
      if ((this.j instanceof Runnable)) {
        GroupSearchEngine.m.remove((Runnable)this.j);
      }
    }
    if (this.a != null) {
      this.a.cancel();
    }
  }
  
  public List<ampw> a(amwt paramamwt)
  {
    return null;
  }
  
  public void a(amwt paramamwt, amwe<ampw> paramamwe)
  {
    this.dDI = 0;
    this.gU.clear();
    stopTask();
    this.jdField_d_of_type_Amwt = paramamwt;
    this.jdField_e_of_type_Amwe = paramamwe;
    this.a = new SearchRunnable(paramamwt);
    this.j = GroupSearchEngine.m.submit(this.a);
  }
  
  public void cancel()
  {
    if (this.zD != null)
    {
      Iterator localIterator = this.zD.iterator();
      while (localIterator.hasNext()) {
        ((amwd)localIterator.next()).cancel();
      }
    }
  }
  
  void dOw()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new AIOTransferSearchEngine(this.mApp, this.mFromType, this.cEm));
    localArrayList.add(new AddFilesSearchEngine(this.mApp, this.mFromType, this.cEm));
    if (this.mFromType == 27)
    {
      localArrayList.add(new OnlineFileSearchEngine(this.mApp, this.mFromType, false));
      localArrayList.add(new FolderSearchEngine(this.mApp, this.mFromType));
    }
    this.dDJ = localArrayList.size();
    this.zD = localArrayList;
  }
  
  public void destroy()
  {
    if (this.zD != null)
    {
      Iterator localIterator = this.zD.iterator();
      while (localIterator.hasNext()) {
        ((amwd)localIterator.next()).destroy();
      }
    }
  }
  
  public void init()
  {
    if (this.zD != null)
    {
      Iterator localIterator = this.zD.iterator();
      while (localIterator.hasNext()) {
        ((amwd)localIterator.next()).init();
      }
    }
  }
  
  public void pause()
  {
    if (this.zD != null)
    {
      Iterator localIterator = this.zD.iterator();
      while (localIterator.hasNext()) {
        ((amwd)localIterator.next()).pause();
      }
    }
  }
  
  public void resume()
  {
    if (this.zD != null)
    {
      Iterator localIterator = this.zD.iterator();
      while (localIterator.hasNext()) {
        ((amwd)localIterator.next()).resume();
      }
    }
  }
  
  class SearchRunnable
    implements Runnable
  {
    boolean cancel;
    amwt e;
    
    public SearchRunnable(amwt paramamwt)
    {
      this.e = paramamwt;
    }
    
    public void cancel()
    {
      this.cancel = true;
    }
    
    public void run()
    {
      if (this.cancel) {}
      for (;;)
      {
        return;
        if (CloudFileGroupSearchEngine.this.zD != null)
        {
          Iterator localIterator = CloudFileGroupSearchEngine.this.zD.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (amwd)localIterator.next();
            if ((localObject instanceof AIOTransferSearchEngine))
            {
              localObject = (AIOTransferSearchEngine)localObject;
              ((AIOTransferSearchEngine)localObject).a(CloudFileGroupSearchEngine.this.b);
              ((AIOTransferSearchEngine)localObject).a(this.e);
            }
            else if ((localObject instanceof OnlineFileSearchEngine))
            {
              localObject = (OnlineFileSearchEngine)localObject;
              ((OnlineFileSearchEngine)localObject).a(CloudFileGroupSearchEngine.this.jdField_d_of_type_Amwt);
              ((OnlineFileSearchEngine)localObject).a(CloudFileGroupSearchEngine.this.e);
            }
            else if ((localObject instanceof AddFilesSearchEngine))
            {
              localObject = (AddFilesSearchEngine)localObject;
              ((AddFilesSearchEngine)localObject).a(CloudFileGroupSearchEngine.this.c);
              ((AddFilesSearchEngine)localObject).a(this.e);
            }
            else if ((localObject instanceof FolderSearchEngine))
            {
              localObject = (FolderSearchEngine)localObject;
              ((FolderSearchEngine)localObject).a(CloudFileGroupSearchEngine.this.jdField_d_of_type_ComTencentMobileqqSearchSearchengineCloudFileGroupSearchEngine$a);
              ((FolderSearchEngine)localObject).a(this.e);
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a<T extends ampx>
  {
    public abstract void a(List<T> paramList, amwt paramamwt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.CloudFileGroupSearchEngine
 * JD-Core Version:    0.7.0.1
 */