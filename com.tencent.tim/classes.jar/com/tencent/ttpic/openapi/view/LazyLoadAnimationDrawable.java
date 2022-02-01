package com.tencent.ttpic.openapi.view;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;
import java.util.ArrayList;

public class LazyLoadAnimationDrawable
  extends AnimationDrawable
{
  private int cur = 0;
  private BitmapDrawable currentDrawable;
  private int[] durations = null;
  private String[] filenames = null;
  private BitmapDrawable nextDrawable;
  private Resources res;
  private int totalDuration = 0;
  
  public LazyLoadAnimationDrawable(Info paramInfo)
  {
    this.res = paramInfo.res;
    this.filenames = paramInfo.filenames;
    this.durations = paramInfo.durations;
    this.totalDuration = paramInfo.totalDuration;
    if (this.cur < this.filenames.length)
    {
      this.nextDrawable = new BitmapDrawable(this.res, this.filenames[this.cur]);
      addFrame(this.nextDrawable, this.durations[this.cur]);
    }
  }
  
  public void clear()
  {
    this.res = null;
    if (this.currentDrawable != null) {
      BitmapUtils.recycle(this.currentDrawable.getBitmap());
    }
    if (this.nextDrawable != null) {
      BitmapUtils.recycle(this.nextDrawable.getBitmap());
    }
  }
  
  public int getTotalDuration()
  {
    return this.totalDuration;
  }
  
  public void run()
  {
    LogUtils.d("111", "test animation running");
    this.cur += 1;
    if (this.currentDrawable != null) {
      BitmapUtils.recycle(this.currentDrawable.getBitmap());
    }
    this.currentDrawable = this.nextDrawable;
    if (this.cur < this.filenames.length)
    {
      this.nextDrawable = new BitmapDrawable(this.res, this.filenames[this.cur]);
      addFrame(this.nextDrawable, this.durations[this.cur]);
      super.run();
    }
  }
  
  public static class Info
  {
    public int[] durations = null;
    public String[] filenames = null;
    public Resources res;
    public int totalDuration = 0;
    
    public Info(Resources paramResources, ArrayList<File> paramArrayList, int[] paramArrayOfInt, Integer[] paramArrayOfInteger)
    {
      this.res = paramResources;
      this.filenames = new String[paramArrayList.size()];
      this.durations = new int[paramArrayList.size()];
      int i = 0;
      while (i < paramArrayList.size())
      {
        this.filenames[i] = ((File)paramArrayList.get(paramArrayOfInteger[i].intValue())).getAbsolutePath();
        this.durations[i] = paramArrayOfInt[paramArrayOfInteger[i].intValue()];
        this.totalDuration += this.durations[i];
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */