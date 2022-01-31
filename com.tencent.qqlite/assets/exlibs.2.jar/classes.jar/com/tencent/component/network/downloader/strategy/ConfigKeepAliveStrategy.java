package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.module.base.a;
import com.tencent.component.network.utils.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.apache.http.HttpRequest;

public class ConfigKeepAliveStrategy
  implements KeepAliveStrategy
{
  private String a;
  private List<String> b = new ArrayList();
  private List<String> c = new ArrayList();
  private Map<String, Pattern> d = new HashMap();
  private ReadWriteLock e = new ReentrantReadWriteLock();
  
  public final KeepAliveStrategy.KeepAlive keepAlive(String paramString, HttpRequest paramHttpRequest)
  {
    if (TextUtils.isEmpty(paramString)) {
      return KeepAliveStrategy.KeepAlive.DISABLE;
    }
    if (!supportKeepAlive(paramString)) {
      return KeepAliveStrategy.KeepAlive.DISABLE;
    }
    boolean bool = e.a(paramHttpRequest);
    int j = a.h();
    int i = j;
    if (bool)
    {
      int k = a.i();
      i = j;
      if (k != -1) {
        i = k;
      }
    }
    switch (i)
    {
    default: 
      return null;
    case 0: 
      return KeepAliveStrategy.KeepAlive.ENABLE;
    case 1: 
      return KeepAliveStrategy.KeepAlive.DISABLE;
    }
    return KeepAliveStrategy.KeepAlive.IGNORE;
  }
  
  public void setConfig(String paramString)
  {
    if ((paramString == null) || (paramString.equals(this.a))) {
      return;
    }
    Const.c("ConfigKeepAliveStrategy", "keep alive domain:" + paramString);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        arrayOfString = paramString.split(",");
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          i = 0;
          if (i < j) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        String[] arrayOfString;
        int i;
        String str;
        localThrowable.printStackTrace();
        continue;
      }
      try
      {
        this.e.writeLock().lock();
        this.a = paramString;
        this.b.clear();
        this.b.addAll(localArrayList);
        this.c.clear();
        this.d.clear();
        this.d.putAll(localHashMap);
        return;
      }
      finally
      {
        this.e.writeLock().unlock();
      }
      str = arrayOfString[i];
      if (!TextUtils.isEmpty(str))
      {
        localArrayList.add(str);
        localHashMap.put(str, Pattern.compile(str, 2));
      }
      i += 1;
    }
  }
  
  public final boolean supportKeepAlive(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    for (;;)
    {
      try
      {
        this.e.readLock().lock();
        bool = this.c.contains(paramString);
        if (bool) {
          return true;
        }
        localIterator = this.d.entrySet().iterator();
        bool = localIterator.hasNext();
        if (!bool)
        {
          bool = false;
          this.e.readLock().unlock();
          if (!bool) {}
        }
      }
      finally
      {
        boolean bool;
        Iterator localIterator;
        String str;
        this.e.readLock().unlock();
      }
      try
      {
        this.e.writeLock().lock();
        this.c.add(paramString);
        this.e.writeLock().unlock();
        return bool;
      }
      finally
      {
        this.e.writeLock().unlock();
      }
      str = (String)((Map.Entry)localIterator.next()).getKey();
      bool = Const.a((Pattern)this.d.get(str), paramString);
      if (bool) {
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.ConfigKeepAliveStrategy
 * JD-Core Version:    0.7.0.1
 */