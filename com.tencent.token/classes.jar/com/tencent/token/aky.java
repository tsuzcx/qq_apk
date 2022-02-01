package com.tencent.token;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class aky
{
  private int a = 64;
  private int b = 5;
  @Nullable
  private Runnable c;
  @Nullable
  private ExecutorService d;
  private final Deque<ali.a> e = new ArrayDeque();
  private final Deque<ali.a> f = new ArrayDeque();
  private final Deque<ali> g = new ArrayDeque();
  
  private ExecutorService a()
  {
    try
    {
      if (this.d == null) {
        this.d = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), alr.a("OkHttp Dispatcher", false));
      }
      ExecutorService localExecutorService = this.d;
      return localExecutorService;
    }
    finally {}
  }
  
  private void b()
  {
    if (this.f.size() >= this.a) {
      return;
    }
    if (this.e.isEmpty()) {
      return;
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      ali.a locala = (ali.a)localIterator.next();
      if (c(locala) < this.b)
      {
        localIterator.remove();
        this.f.add(locala);
        a().execute(locala);
      }
      if (this.f.size() >= this.a) {}
    }
  }
  
  private int c()
  {
    try
    {
      int i = this.f.size();
      int j = this.g.size();
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int c(ali.a parama)
  {
    Iterator localIterator = this.f.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ali.a locala = (ali.a)localIterator.next();
      if ((!locala.a.e) && (locala.a().equals(parama.a()))) {
        i += 1;
      }
    }
    return i;
  }
  
  final void a(ali.a parama)
  {
    try
    {
      if ((this.f.size() < this.a) && (c(parama) < this.b))
      {
        this.f.add(parama);
        a().execute(parama);
        return;
      }
      this.e.add(parama);
      return;
    }
    finally {}
  }
  
  final void b(ali.a parama)
  {
    Deque localDeque = this.f;
    try
    {
      if (localDeque.remove(parama))
      {
        b();
        int i = c();
        parama = this.c;
        if ((i == 0) && (parama != null)) {
          parama.run();
        }
        return;
      }
      throw new AssertionError("Call wasn't in-flight!");
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aky
 * JD-Core Version:    0.7.0.1
 */