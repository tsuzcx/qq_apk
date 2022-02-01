package com.tencent.qqlive.module.videoreport.utils;

import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.notifier.ListScrollNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.RecyclerViewScrollPositionNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.RecyclerViewSetAdapterNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewClickNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewPagerSetAdapterNotifier;
import com.tencent.qqlive.module.videoreport.collect.notifier.ViewReuseNotifier;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReusablePool
{
  private static final int MAX_LIST_SIZE = 30;
  private static final SparseArray<List<Object>> POOL = new SparseArray();
  private static final String TAG = "ReusablePool";
  public static final int TYPE_FINAL_DATA_REUSE = 6;
  public static final int TYPE_LIST_SCROLL = 1;
  public static final int TYPE_RECYCLER_VIEW_SCROLL_POSITION = 7;
  public static final int TYPE_RECYCLER_VIEW_SET_ADAPTER = 2;
  public static final int TYPE_REPORT_DATA = 8;
  public static final int TYPE_VIEW_CLICK = 3;
  public static final int TYPE_VIEW_PAGER_SET_ADAPTER = 4;
  public static final int TYPE_VIEW_REUSE = 5;
  
  private static Object createObject(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new ListScrollNotifier();
    case 2: 
      return new RecyclerViewSetAdapterNotifier();
    case 3: 
      return new ViewClickNotifier();
    case 4: 
      return new ViewPagerSetAdapterNotifier();
    case 5: 
      return new ViewReuseNotifier();
    case 6: 
      return new FinalData();
    case 7: 
      return new RecyclerViewScrollPositionNotifier();
    }
    return new ReportData();
  }
  
  public static Object obtain(int paramInt)
  {
    synchronized (POOL)
    {
      List localList = (List)POOL.get(paramInt);
      while ((localList != null) && (!localList.isEmpty()))
      {
        Object localObject3 = localList.remove(0);
        if (localObject3 != null)
        {
          if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d("ReusablePool", "obtain: reuse, reuseType = " + paramInt);
          }
          return localObject3;
        }
      }
      ??? = createObject(paramInt);
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("ReusablePool", "obtain: create, reuseType = " + paramInt + ", reusable=" + ???);
      }
      if (??? == null) {
        throw new IllegalArgumentException("Reusable reuseType illegal, reuseType = " + paramInt);
      }
    }
    return ???;
  }
  
  public static void recycle(Object paramObject, int paramInt)
  {
    synchronized (POOL)
    {
      List localList2 = (List)POOL.get(paramInt);
      List localList1 = localList2;
      if (localList2 == null)
      {
        localList1 = Collections.synchronizedList(new ArrayList());
        POOL.put(paramInt, localList1);
      }
      if (localList1.size() < 30) {
        localList1.add(paramObject);
      }
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("ReusablePool", "recycle: reuseType = " + paramInt + " list size=" + localList1.size() + "， reusable=" + paramObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ReusablePool
 * JD-Core Version:    0.7.0.1
 */