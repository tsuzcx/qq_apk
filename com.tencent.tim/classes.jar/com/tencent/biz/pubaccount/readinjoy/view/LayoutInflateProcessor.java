package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ArrayBlockingQueue;

public class LayoutInflateProcessor
{
  private SparseArray<ArrayBlockingQueue<View>> at;
  private LayoutInflater e;
  
  public LayoutInflateProcessor(Context paramContext)
  {
    this.e = LayoutInflater.from(paramContext);
    this.at = new SparseArray();
  }
  
  private void a(a parama)
  {
    if (parama == null) {
      return;
    }
    ArrayBlockingQueue localArrayBlockingQueue2 = (ArrayBlockingQueue)this.at.get(a.a(parama));
    ArrayBlockingQueue localArrayBlockingQueue1;
    if (localArrayBlockingQueue2 == null)
    {
      localArrayBlockingQueue1 = new ArrayBlockingQueue(9);
      this.at.put(a.a(parama), localArrayBlockingQueue1);
    }
    do
    {
      parama.d = localArrayBlockingQueue1;
      return;
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
    } while (localArrayBlockingQueue2.size() != 9);
  }
  
  @NonNull
  public View a(int paramInt, boolean paramBoolean, ViewGroup.LayoutParams paramLayoutParams)
  {
    Object localObject = (ArrayBlockingQueue)this.at.get(paramInt);
    if (localObject != null)
    {
      localObject = (View)((ArrayBlockingQueue)localObject).poll();
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LayoutPreloadInflater", 2, "inflate: hit cache! resid=" + this.e.getContext().getResources().getResourceEntryName(paramInt));
        }
        ((View)localObject).setLayoutParams(paramLayoutParams);
        return localObject;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LayoutPreloadInflater", 2, "inflate: miss cache, resid=" + this.e.getContext().getResources().getResourceEntryName(paramInt) + " faultTolerant=" + paramBoolean);
    }
    if (paramBoolean)
    {
      localObject = this.e.inflate(paramInt, null, false);
      ((View)localObject).setLayoutParams(paramLayoutParams);
      return localObject;
    }
    return null;
  }
  
  @UiThread
  public void a(a[] paramArrayOfa)
  {
    int j = paramArrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a(paramArrayOfa[i]);
      i += 1;
    }
    ThreadManager.excute(new InflateTask(paramArrayOfa, this.e), 16, null, true);
  }
  
  @UiThread
  public void clearCache()
  {
    this.at.clear();
  }
  
  static class InflateTask
    implements Runnable
  {
    private LayoutInflateProcessor.a[] a;
    private LayoutInflater layoutInflater;
    
    public InflateTask(LayoutInflateProcessor.a[] paramArrayOfa, LayoutInflater paramLayoutInflater)
    {
      this.a = paramArrayOfa;
      this.layoutInflater = paramLayoutInflater;
    }
    
    private boolean a(LayoutInflateProcessor.a parama)
    {
      if ((parama.d == null) || (parama.d.size() >= 9)) {}
      for (;;)
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("LayoutPreloadInflater", 2, "preload start: resid=" + this.layoutInflater.getContext().getResources().getResourceEntryName(LayoutInflateProcessor.a.a(parama)));
        }
        try
        {
          View localView = this.layoutInflater.inflate(LayoutInflateProcessor.a.a(parama), LayoutInflateProcessor.a.a(parama), false);
          if (localView == null) {
            continue;
          }
          if (LayoutInflateProcessor.a.a(parama) != null) {
            LayoutInflateProcessor.a.a(parama).cV(localView);
          }
          if ((parama.d == null) || (parama.d.size() >= 9)) {
            continue;
          }
          parama.d.add(localView);
          return true;
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("LayoutPreloadInflater", 2, "Failed to inflate resource in the background! Retrying on the UI thread", localRuntimeException);
            }
            Object localObject = null;
          }
        }
      }
    }
    
    public void run()
    {
      LayoutInflateProcessor.a[] arrayOfa = this.a;
      int k = arrayOfa.length;
      int i = 0;
      if (i < k)
      {
        LayoutInflateProcessor.a locala = arrayOfa[i];
        if (locala == null) {}
        for (;;)
        {
          i += 1;
          break;
          int j = 0;
          while ((j < LayoutInflateProcessor.a.b(locala)) && (a(locala))) {
            j += 1;
          }
        }
      }
    }
  }
  
  public static class a
  {
    private LayoutInflateProcessor.b a;
    private ViewGroup ba;
    private int count;
    ArrayBlockingQueue d;
    private int resid;
    
    public a(int paramInt1, int paramInt2, ViewGroup paramViewGroup, LayoutInflateProcessor.b paramb)
    {
      this.resid = paramInt1;
      this.count = paramInt2;
      this.ba = paramViewGroup;
      this.a = paramb;
    }
    
    public a(int paramInt, ViewGroup paramViewGroup, LayoutInflateProcessor.b paramb)
    {
      this(paramInt, 1, paramViewGroup, paramb);
    }
  }
  
  public static abstract interface b
  {
    public abstract void cV(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor
 * JD-Core Version:    0.7.0.1
 */