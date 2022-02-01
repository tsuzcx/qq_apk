package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;

public class StoryListLoadMoreView
  extends LoadMoreLayout
{
  public StoryListLoadMoreView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public StoryListLoadMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public StoryListLoadMoreView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mTextView.setTextColor(getResources().getColor(2131167304));
  }
  
  public int getState()
  {
    return this.mState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryListLoadMoreView
 * JD-Core Version:    0.7.0.1
 */