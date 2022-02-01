package com.tencent.mobileqq.apollo.process.data;

import abml;
import abmt;
import abos;
import aboz;
import abpu;
import abyv;
import accg;
import acci;
import android.content.Intent;
import aolm;
import aomf;
import aqva;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import mqq.app.IToolProcEventListener;
import mqq.manager.Manager;

public class CmGameAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  private aomf a;
  private accg[] b = new accg[1];
  List<acci> bgObservers = new Vector();
  List<acci> defaultObservers = new Vector();
  Map<Integer, Manager> iX = new HashMap(20);
  private EntityManagerFactory mFactory;
  List<acci> uiObservers = new Vector();
  
  public CmGameAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    QLog.i("cmgame_process.CmGameAppInterface", 1, "new CmGameAppInterface obj.");
    abml.registerModule();
  }
  
  private accg a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new abpu(this);
  }
  
  private void cDv()
  {
    abos localabos = abmt.b();
    if (localabos != null) {
      abmt.Hw(localabos.getGameId());
    }
  }
  
  public void addObserver(acci paramacci)
  {
    addObserver(paramacci, false);
  }
  
  public void addObserver(acci paramacci, boolean paramBoolean)
  {
    if (paramacci == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.bgObservers)
      {
        if (!this.bgObservers.contains(paramacci)) {
          this.bgObservers.add(paramacci);
        }
        return;
      }
    }
    synchronized (this.uiObservers)
    {
      if (!this.uiObservers.contains(paramacci)) {
        this.uiObservers.add(paramacci);
      }
      return;
    }
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.getAppId();
  }
  
  public accg getBusinessHandler(int paramInt)
  {
    Object localObject1 = this.b[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.b)
    {
      accg localaccg = this.b[paramInt];
      localObject1 = localaccg;
      if (localaccg == null)
      {
        localaccg = a(paramInt);
        localObject1 = localaccg;
        if (localaccg != null)
        {
          this.b[paramInt] = localaccg;
          localObject1 = localaccg;
        }
      }
      return localObject1;
    }
  }
  
  public List<acci> getBusinessObserver(int paramInt)
  {
    if (paramInt == 1) {
      return this.uiObservers;
    }
    if (paramInt == 2) {
      return this.bgObservers;
    }
    if (paramInt == 0) {
      return this.defaultObservers;
    }
    return this.defaultObservers;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.mFactory == null) {
      this.mFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.mFactory;
  }
  
  public Manager getManager(int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (Manager)this.iX.get(Integer.valueOf(paramInt));
        localObject5 = localObject1;
        Map localMap;
        if (localObject1 == null) {
          localMap = this.iX;
        }
        switch (paramInt)
        {
        default: 
        case 255: 
          try
          {
            if (this.iX.get(Integer.valueOf(paramInt)) == null) {
              break;
            }
            localObject5 = (Manager)this.iX.get(Integer.valueOf(paramInt));
            localObject1 = localObject5;
            if (localObject5 == null) {
              localObject1 = super.getManager(paramInt);
            }
            return localObject1;
          }
          finally {}
          localObject1 = new aboz(this);
          break;
        case 256: 
          localObject4 = new aomf();
        }
      }
      finally {}
      this.a = ((aomf)localObject4);
      continue;
      Object localObject4 = new aqva(this);
      continue;
      Object localObject5 = localObject4;
      if (localObject4 != null)
      {
        this.iX.put(Integer.valueOf(paramInt), localObject4);
        localObject5 = localObject4;
      }
    }
  }
  
  public String getModuleId()
  {
    return "cmshowgame_module";
  }
  
  public aolm getNetEngine(int paramInt)
  {
    if (this.a == null) {
      this.a = ((aomf)getManager(256));
    }
    return this.a.a(this, paramInt);
  }
  
  public void onBeforeExitProc()
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onBeforeExitProc]");
    cDv();
  }
  
  public void onDestroy()
  {
    synchronized (this.iX)
    {
      Object localObject1 = this.iX.keySet();
      if ((localObject1 != null) && (((Set)localObject1).size() > 0))
      {
        localObject1 = ((Set)localObject1).iterator();
        do
        {
          for (;;)
          {
            boolean bool = ((Iterator)localObject1).hasNext();
            if (!bool) {
              break label114;
            }
            try
            {
              Manager localManager = (Manager)this.iX.get(((Iterator)localObject1).next());
              if (localManager != null) {
                localManager.onDestroy();
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("cmgame_process.CmGameAppInterface", 2, "onDesotry", localException);
      }
    }
    label114:
    this.iX.clear();
    abyv.cGo();
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onReceiveAccountAction]");
    cDv();
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    QLog.i("cmgame_process.CmGameAppInterface", 1, "[onReceiveLegalExitProcAction]");
    if (abmt.b() != null)
    {
      QLog.i("cmgame_process.CmGameAppInterface", 1, "NOT kill tool process");
      return true;
    }
    return false;
  }
  
  public void removeObserver(acci paramacci)
  {
    synchronized (this.uiObservers)
    {
      this.uiObservers.remove(paramacci);
      synchronized (this.bgObservers)
      {
        this.bgObservers.remove(paramacci);
      }
    }
    synchronized (this.defaultObservers)
    {
      this.defaultObservers.remove(paramacci);
      return;
      paramacci = finally;
      throw paramacci;
      paramacci = finally;
      throw paramacci;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameAppInterface
 * JD-Core Version:    0.7.0.1
 */