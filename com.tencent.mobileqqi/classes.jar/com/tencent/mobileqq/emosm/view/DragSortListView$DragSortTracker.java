package com.tencent.mobileqq.emosm.view;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class DragSortListView$DragSortTracker
{
  StringBuilder mBuilder = new StringBuilder();
  File mFile = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
  private int mNumFlushes = 0;
  private int mNumInBuffer = 0;
  private boolean mTracking = false;
  
  public DragSortListView$DragSortTracker(DragSortListView paramDragSortListView)
  {
    if (!this.mFile.exists()) {}
    try
    {
      this.mFile.createNewFile();
      Log.d("mobeta", "file created");
      return;
    }
    catch (IOException paramDragSortListView)
    {
      Log.w("mobeta", "Could not create dslv_state.txt");
      Log.d("mobeta", paramDragSortListView.getMessage());
    }
  }
  
  public void appendState()
  {
    if (!this.mTracking) {}
    do
    {
      return;
      this.mBuilder.append("<DSLVState>\n");
      int j = this.this$0.getChildCount();
      int k = this.this$0.getFirstVisiblePosition();
      this.mBuilder.append("    <Positions>");
      int i = 0;
      while (i < j)
      {
        this.mBuilder.append(k + i).append(",");
        i += 1;
      }
      this.mBuilder.append("</Positions>\n");
      this.mBuilder.append("    <Tops>");
      i = 0;
      while (i < j)
      {
        this.mBuilder.append(this.this$0.getChildAt(i).getTop()).append(",");
        i += 1;
      }
      this.mBuilder.append("</Tops>\n");
      this.mBuilder.append("    <Bottoms>");
      i = 0;
      while (i < j)
      {
        this.mBuilder.append(this.this$0.getChildAt(i).getBottom()).append(",");
        i += 1;
      }
      this.mBuilder.append("</Bottoms>\n");
      this.mBuilder.append("    <FirstExpPos>").append(this.this$0.mFirstExpPos).append("</FirstExpPos>\n");
      this.mBuilder.append("    <FirstExpBlankHeight>").append(DragSortListView.access$900(this.this$0, this.this$0.mFirstExpPos) - DragSortListView.access$1000(this.this$0, this.this$0.mFirstExpPos)).append("</FirstExpBlankHeight>\n");
      this.mBuilder.append("    <SecondExpPos>").append(this.this$0.mSecondExpPos).append("</SecondExpPos>\n");
      this.mBuilder.append("    <SecondExpBlankHeight>").append(DragSortListView.access$900(this.this$0, this.this$0.mSecondExpPos) - DragSortListView.access$1000(this.this$0, this.this$0.mSecondExpPos)).append("</SecondExpBlankHeight>\n");
      this.mBuilder.append("    <SrcPos>").append(this.this$0.mSrcPos).append("</SrcPos>\n");
      this.mBuilder.append("    <SrcHeight>").append(this.this$0.mFloatViewHeight + this.this$0.getDividerHeight()).append("</SrcHeight>\n");
      this.mBuilder.append("    <ViewHeight>").append(this.this$0.getHeight()).append("</ViewHeight>\n");
      this.mBuilder.append("    <LastY>").append(this.this$0.mLastY).append("</LastY>\n");
      this.mBuilder.append("    <FloatY>").append(this.this$0.mFloatViewMid).append("</FloatY>\n");
      this.mBuilder.append("    <ShuffleEdges>");
      i = 0;
      while (i < j)
      {
        this.mBuilder.append(DragSortListView.access$1100(this.this$0, k + i, this.this$0.getChildAt(i).getTop())).append(",");
        i += 1;
      }
      this.mBuilder.append("</ShuffleEdges>\n");
      this.mBuilder.append("</DSLVState>\n");
      this.mNumInBuffer += 1;
    } while (this.mNumInBuffer <= 1000);
    flush();
    this.mNumInBuffer = 0;
  }
  
  public void flush()
  {
    boolean bool = false;
    if (!this.mTracking) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.mNumFlushes == 0)
        {
          FileWriter localFileWriter = new FileWriter(this.mFile, bool);
          localFileWriter.write(this.mBuilder.toString());
          this.mBuilder.delete(0, this.mBuilder.length());
          localFileWriter.flush();
          localFileWriter.close();
          this.mNumFlushes += 1;
          return;
        }
      }
      catch (IOException localIOException)
      {
        return;
      }
      bool = true;
    }
  }
  
  public void startTracking()
  {
    this.mBuilder.append("<DSLVStates>\n");
    this.mNumFlushes = 0;
    this.mTracking = true;
  }
  
  public void stopTracking()
  {
    if (this.mTracking)
    {
      this.mBuilder.append("</DSLVStates>\n");
      flush();
      this.mTracking = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.DragSortTracker
 * JD-Core Version:    0.7.0.1
 */