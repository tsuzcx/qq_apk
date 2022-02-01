package com.tencent.biz.qqstory.storyHome.memory.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import java.util.Iterator;
import java.util.List;
import pqj;
import ptq;
import qub;
import quh;
import qye;
import qyk.e;
import ram;
import rar;
import rsd;

public class StoryMemoriesListView
  extends SegmentList
  implements View.OnTouchListener, qyk.e
{
  private qub a;
  
  public StoryMemoriesListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StoryMemoriesListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StoryMemoriesListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void b(String paramString, CommentEntry paramCommentEntry) {}
  
  public void box()
  {
    Iterator localIterator = this.a.getSegmentList().iterator();
    while (localIterator.hasNext()) {
      a((rsd)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setOnTouchListener(this);
    if (this.a.a != null) {
      this.a.a.a().setInputViewHideListener(this);
    }
  }
  
  public void bqJ()
  {
    if (this.a.a != null) {
      this.a.a.bpJ();
    }
  }
  
  public void bqK()
  {
    if (this.a.a != null) {
      this.a.a.bpI();
    }
  }
  
  public void bqL() {}
  
  public void bqM() {}
  
  public void layoutChildren()
  {
    try
    {
      super.layoutChildren();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      ram.e("SwipListView", "error:%s", new Object[] { localIllegalStateException.toString() });
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a == null) {
      return false;
    }
    paramView = this.a.a.a();
    if (paramView.getVisibility() == 0)
    {
      ((InputMethodManager)this.a.y.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      paramView.clearFocus();
      paramView.setVisibility(8);
      bqJ();
      paramView = paramView.c.a;
      int i = rar.a(paramView.getOwner());
      if (paramView.getOwner().isMe()) {}
      for (paramView = "1";; paramView = "2")
      {
        rar.a("home_page", "cancel_reply", i, 0, new String[] { paramView, "3", "", "" });
        return true;
      }
    }
    return false;
  }
  
  public void setConfig(@NonNull qub paramqub)
  {
    this.a = paramqub;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    quh localquh = (quh)a("FeedSegment");
    if ((localquh == null) || (localquh.getCount() == 0) || (!localquh.isDisplay())) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    localquh.wF(1);
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    localquh.wF(0);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView
 * JD-Core Version:    0.7.0.1
 */