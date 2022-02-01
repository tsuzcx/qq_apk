package com.tencent.qqmail.view.sectionlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class SectionListView
  extends ListView
  implements AbsListView.OnScrollListener
{
  private SectionListAdapter myadapter = null;
  private View transparentView;
  private ArrayList<Integer> viewheight = new ArrayList();
  
  public SectionListView(Context paramContext)
  {
    super(paramContext);
    commonInitialisation();
  }
  
  public SectionListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    commonInitialisation();
  }
  
  public SectionListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    commonInitialisation();
  }
  
  protected final void commonInitialisation() {}
  
  public int computeListViewVerticalScrollOffset()
  {
    return computeHorizontalScrollOffset();
  }
  
  protected void layoutChildren()
  {
    super.layoutChildren();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = (SectionListAdapter)getAdapter();
    if (paramAbsListView != null) {
      paramAbsListView.makeSectionInvisibleIfFirstInList(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (!(paramListAdapter instanceof SectionListAdapter)) {
      throw new IllegalArgumentException("The adapter needds to be of type " + SectionListAdapter.class + " and is " + paramListAdapter.getClass());
    }
    super.setAdapter(paramListAdapter);
    this.myadapter = ((SectionListAdapter)paramListAdapter);
    paramListAdapter = getParent();
    if (!(paramListAdapter instanceof FrameLayout)) {
      throw new IllegalStateException("Section List should have FrameLayout as parent!");
    }
    if (this.transparentView != null) {
      ((FrameLayout)paramListAdapter).removeView(this.transparentView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.sectionlist.SectionListView
 * JD-Core Version:    0.7.0.1
 */