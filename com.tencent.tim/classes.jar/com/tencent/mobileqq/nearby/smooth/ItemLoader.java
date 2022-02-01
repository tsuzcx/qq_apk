package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.view.View;
import android.widget.Adapter;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ItemLoader<Params, Result>
{
  ThreadPoolExecutor mExecutorService;
  Handler mHandler;
  Map<View, b<Params>> mk;
  Map<String, a<Params, Result>> ml;
  
  static String O(int paramInt1, int paramInt2)
  {
    return String.valueOf(paramInt1) + String.valueOf(paramInt2);
  }
  
  b<Params> a(View paramView)
  {
    b localb2 = (b)this.mk.get(paramView);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      localb1.ej = null;
      localb1.csw = false;
      localb1.position = -1;
      this.mk.put(paramView, localb1);
    }
    return localb1;
  }
  
  public abstract Params a(Adapter paramAdapter, int paramInt);
  
  public abstract Result a(Params paramParams, int paramInt);
  
  public void a(View paramView1, View paramView2, Adapter paramAdapter, int paramInt, boolean paramBoolean)
  {
    Object localObject = a(paramAdapter, paramInt);
    if (localObject == null) {}
    for (;;)
    {
      return;
      b localb = a(paramView2);
      localb.ej = localObject;
      localb.position = paramInt;
      localb.csw = true;
      int i = b(paramAdapter, paramInt);
      paramInt = 0;
      while (paramInt < i)
      {
        if ((paramBoolean) || (b(localObject, paramInt))) {
          a(paramView1, paramView2, localb, paramInt, SystemClock.uptimeMillis());
        }
        paramInt += 1;
      }
    }
  }
  
  void a(View paramView1, View paramView2, b<Params> paramb, int paramInt, long paramLong)
  {
    int i = paramb.position;
    Object localObject = paramb.ej;
    String str = O(i, paramInt);
    a locala = (a)this.ml.get(str);
    if (locala == null)
    {
      paramView1 = new a(str, paramView1, paramView2, localObject, i, paramInt, paramLong);
      this.ml.put(str, paramView1);
    }
    for (;;)
    {
      paramb.csw = false;
      paramView2 = b(localObject, paramInt);
      if (paramView2 == null) {
        break;
      }
      iX(i, paramInt);
      paramView1.x = new SoftReference(paramView2);
      this.mHandler.post(new DisplayItemRunnable(this, paramView1, true));
      return;
      locala.timestamp = Long.valueOf(paramLong);
      locala.w = new SoftReference(paramView2);
      paramView1 = locala;
    }
    paramView1.i = this.mExecutorService.submit(new LoadItemRunnable(this, paramView1));
  }
  
  public abstract void a(View paramView, Result paramResult, int paramInt, boolean paramBoolean);
  
  boolean a(a<Params, Result> parama)
  {
    if (parama.w == null) {
      return false;
    }
    View localView = (View)parama.w.get();
    if (localView == null) {
      return true;
    }
    int i = a(localView).position;
    return (i == -1) || (parama.position != i);
  }
  
  public int b(Adapter paramAdapter, int paramInt)
  {
    return 1;
  }
  
  public abstract Result b(Params paramParams, int paramInt);
  
  boolean b(Params paramParams, int paramInt)
  {
    return b(paramParams, paramInt) != null;
  }
  
  public void hw(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("Null itemContainer in cancelRequestsForContainer");
    }
    Iterator localIterator = this.ml.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((View)locala.v.get() == paramView)
      {
        if (locala.i != null) {
          locala.i.cancel(true);
        }
        localIterator.remove();
      }
    }
  }
  
  void iX(int paramInt1, int paramInt2)
  {
    String str = O(paramInt1, paramInt2);
    a locala = (a)this.ml.get(str);
    if (locala == null) {}
    do
    {
      return;
      this.ml.remove(str);
    } while (locala.i == null);
    locala.i.cancel(true);
  }
  
  static final class DisplayItemRunnable<Params, Result>
    implements Runnable
  {
    private final ItemLoader.a<Params, Result> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a;
    private final ItemLoader<Params, Result> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
    private final boolean csv;
    
    public DisplayItemRunnable(ItemLoader<Params, Result> paramItemLoader, ItemLoader.a<Params, Result> parama, boolean paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a = parama;
      this.csv = paramBoolean;
    }
    
    public void run()
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a)) {}
      View localView;
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a.x == null) {
          throw new IllegalStateException("Result should not be null when displaying an item part");
        }
        localView = (View)this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a.w.get();
      } while (localView == null);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a.x.get();
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localView, localObject, this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a.ah.intValue(), this.csv);
    }
  }
  
  static final class LoadItemFutureTask<Params, Result>
    extends FutureTask<ItemLoader.LoadItemRunnable<Params, Result>>
    implements Comparable<LoadItemFutureTask<Params, Result>>
  {
    private final ItemLoader.LoadItemRunnable<Params, Result> a;
    
    public int a(LoadItemFutureTask<Params, Result> paramLoadItemFutureTask)
    {
      ItemLoader.a locala = this.a.a();
      paramLoadItemFutureTask = paramLoadItemFutureTask.a.a();
      if ((locala.w != null) && (paramLoadItemFutureTask.w == null)) {
        return -1;
      }
      if ((locala.w == null) && (paramLoadItemFutureTask.w != null)) {
        return 1;
      }
      if (!locala.ah.equals(paramLoadItemFutureTask.ah)) {
        return locala.ah.compareTo(paramLoadItemFutureTask.ah);
      }
      return locala.timestamp.compareTo(paramLoadItemFutureTask.timestamp);
    }
  }
  
  static final class LoadItemRunnable<Params, Result>
    implements Runnable
  {
    private final ItemLoader.a<Params, Result> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a;
    private final ItemLoader<Params, Result> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
    
    public LoadItemRunnable(ItemLoader<Params, Result> paramItemLoader, ItemLoader.a<Params, Result> parama)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader = paramItemLoader;
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a = parama;
    }
    
    public ItemLoader.a<Params, Result> a()
    {
      return this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a;
    }
    
    public void run()
    {
      Process.setThreadPriority(10);
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.ml.remove(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a.id);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a)) {}
      do
      {
        return;
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a.ej, this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a.ah.intValue());
        this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a.x = new SoftReference(localObject);
      } while ((this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a.w == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a)));
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.mHandler.post(new ItemLoader.DisplayItemRunnable(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader, this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader$a, false));
    }
  }
  
  static final class a<Params, Result>
  {
    public final Integer ah;
    public final Params ej;
    public Future<?> i;
    public final String id;
    public final int position;
    public Long timestamp;
    public SoftReference<View> v;
    public SoftReference<View> w;
    public SoftReference<Result> x;
    
    public a(String paramString, View paramView1, View paramView2, Params paramParams, int paramInt1, int paramInt2, long paramLong)
    {
      this.id = paramString;
      this.v = new SoftReference(paramView1);
      if (paramView2 != null) {}
      for (paramString = new SoftReference(paramView2);; paramString = null)
      {
        this.w = paramString;
        this.ej = paramParams;
        this.position = paramInt1;
        this.ah = Integer.valueOf(paramInt2);
        this.x = null;
        this.timestamp = Long.valueOf(paramLong);
        this.i = null;
        return;
      }
    }
  }
  
  static final class b<Params>
  {
    public boolean csw;
    public Params ej;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader
 * JD-Core Version:    0.7.0.1
 */