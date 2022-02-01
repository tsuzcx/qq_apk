package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkyBitmapUtil
{
  public static final String BACK = "back";
  public static final String BOTTOM = "bottom";
  public static final String FRONT = "front";
  public static final String LEFT = "left";
  private static final int MAX = 2;
  public static final String RIGHT = "right";
  public static final String TOP = "top";
  private ConcurrentLinkedQueue<Integer> countQueue = new ConcurrentLinkedQueue();
  private String dir;
  private ExecutorService mExecutor;
  private Map<Integer, HashMap<String, Bitmap>> map = new HashMap();
  private final String suffix = ".png";
  
  public SkyBitmapUtil(String paramString)
  {
    this.dir = paramString;
    this.mExecutor = Executors.newScheduledThreadPool(6);
  }
  
  private void releaseOne()
  {
    int i = ((Integer)this.countQueue.poll()).intValue();
    Iterator localIterator = ((HashMap)this.map.get(Integer.valueOf(i))).values().iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (BitmapUtils.isLegal(localBitmap)) {
        localBitmap.recycle();
      }
    }
    this.map.remove(Integer.valueOf(i));
  }
  
  public void clear()
  {
    this.mExecutor.shutdownNow();
    while (!this.map.isEmpty()) {
      releaseOne();
    }
  }
  
  public void decode(int paramInt, List<String> paramList)
  {
    HashMap localHashMap = (HashMap)this.map.get(Integer.valueOf(paramInt));
    if (localHashMap == null)
    {
      localHashMap = new HashMap(6);
      this.map.put(Integer.valueOf(paramInt), localHashMap);
      this.countQueue.add(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str1 = (String)paramList.next();
        if (!localHashMap.containsKey(str1))
        {
          String str2 = this.dir + paramInt + "_" + str1 + ".png";
          this.mExecutor.execute(new SkyBitmapUtil.1(this, str2, str1, localHashMap));
        }
      }
      return;
    }
  }
  
  public HashMap<String, Bitmap> getBitmap(int paramInt)
  {
    while (this.map.size() > 2) {
      releaseOne();
    }
    return (HashMap)this.map.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.SkyBitmapUtil
 * JD-Core Version:    0.7.0.1
 */