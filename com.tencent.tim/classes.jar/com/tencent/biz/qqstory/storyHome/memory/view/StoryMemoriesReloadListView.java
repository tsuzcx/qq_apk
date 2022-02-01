package com.tencent.biz.qqstory.storyHome.memory.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import qui;

public class StoryMemoriesReloadListView
  extends SegmentList
{
  private Activity l;
  
  public StoryMemoriesReloadListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StoryMemoriesReloadListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StoryMemoriesReloadListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void bd(Activity paramActivity)
  {
    this.l = paramActivity;
  }
  
  public void box()
  {
    a(new qui(this.l));
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesReloadListView
 * JD-Core Version:    0.7.0.1
 */