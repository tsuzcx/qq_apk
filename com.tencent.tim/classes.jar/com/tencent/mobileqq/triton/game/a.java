package com.tencent.mobileqq.triton.game;

import android.content.Context;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
  implements GameLifecycle
{
  private List<GameLifecycle> a = new CopyOnWriteArrayList();
  private TTEngine b;
  
  private void a()
  {
    try
    {
      this.a.clear();
      return;
    }
    catch (Exception localException)
    {
      TTLog.b("LifecycleManager", "clearGameLifeCucle error:" + localException.getMessage());
    }
  }
  
  private void a(Context paramContext, ITTEngine paramITTEngine)
  {
    try
    {
      this.b.getJsEngine().onCreate(paramContext, paramITTEngine);
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((GameLifecycle)localIterator.next()).onCreate(paramContext, paramITTEngine);
      }
      return;
    }
    catch (Exception paramContext)
    {
      TTLog.b("LifecycleManager", "notifyOnCreate error:" + paramContext.getMessage());
    }
  }
  
  private void b()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((GameLifecycle)localIterator.next()).onDestroy();
      }
      this.b.getJsEngine().onDestroy();
    }
    catch (Exception localException)
    {
      TTLog.b("LifecycleManager", "notifyOnDestroy error:" + localException.getMessage());
      return;
    }
  }
  
  private void c()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((GameLifecycle)localIterator.next()).onGameLaunched();
      }
      return;
    }
    catch (Exception localException)
    {
      TTLog.b("LifecycleManager", "notifyOnLaunched error:" + localException.getMessage());
    }
  }
  
  private void d()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((GameLifecycle)localIterator.next()).onPause();
      }
      return;
    }
    catch (Exception localException)
    {
      TTLog.b("LifecycleManager", "notifyOnPause error:" + localException.getMessage());
    }
  }
  
  private void e()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((GameLifecycle)localIterator.next()).onResume();
      }
      return;
    }
    catch (Exception localException)
    {
      TTLog.b("LifecycleManager", "notifyOnResume error:" + localException.getMessage());
    }
  }
  
  public void a(GameLifecycle paramGameLifecycle)
  {
    try
    {
      this.a.add(paramGameLifecycle);
      return;
    }
    catch (Exception paramGameLifecycle)
    {
      TTLog.b("LifecycleManager", "addGameLifeCycle error:" + paramGameLifecycle.getMessage());
    }
  }
  
  public void onCreate(Context paramContext, ITTEngine paramITTEngine)
  {
    this.b = ((TTEngine)paramITTEngine);
    a(paramContext, paramITTEngine);
  }
  
  public void onDestroy()
  {
    b();
    a();
  }
  
  public void onGameLaunched()
  {
    c();
  }
  
  public void onPause()
  {
    d();
  }
  
  public void onResume()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.a
 * JD-Core Version:    0.7.0.1
 */