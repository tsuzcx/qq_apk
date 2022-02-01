package com.tencent.viola.ui.view.overscroll;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

public class RecyclerViewOverScrollDecorAdapter
  implements AbsOverScrollDecorator.IOverScrollDecoratorAdapter
{
  protected final Impl mImpl;
  protected boolean mIsItemTouchInEffect = false;
  protected final RecyclerView mRecyclerView;
  
  public RecyclerViewOverScrollDecorAdapter(RecyclerView paramRecyclerView)
  {
    this.mRecyclerView = paramRecyclerView;
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (((paramRecyclerView instanceof LinearLayoutManager)) || ((paramRecyclerView instanceof StaggeredGridLayoutManager)))
    {
      if ((paramRecyclerView instanceof LinearLayoutManager)) {}
      for (int i = ((LinearLayoutManager)paramRecyclerView).getOrientation(); i == 0; i = ((StaggeredGridLayoutManager)paramRecyclerView).getOrientation())
      {
        this.mImpl = new ImplHorizLayout();
        return;
      }
      this.mImpl = new ImplVerticalLayout();
      return;
    }
    throw new IllegalArgumentException("Recycler views with custom layout managers are not supported by this adapter out of the box.Try implementing and providing an explicit 'impl' parameter to the other c'tors, or otherwise create a custom adapter subclass of your own.");
  }
  
  public View getView()
  {
    return this.mRecyclerView;
  }
  
  public boolean isInAbsoluteEnd()
  {
    return (!this.mIsItemTouchInEffect) && (this.mImpl.isInAbsoluteEnd());
  }
  
  public boolean isInAbsoluteStart()
  {
    return this.mImpl.isInAbsoluteStart();
  }
  
  public static abstract interface Impl
  {
    public abstract boolean isInAbsoluteEnd();
    
    public abstract boolean isInAbsoluteStart();
  }
  
  public class ImplHorizLayout
    implements RecyclerViewOverScrollDecorAdapter.Impl
  {
    protected ImplHorizLayout() {}
    
    public boolean isInAbsoluteEnd()
    {
      return !RecyclerViewOverScrollDecorAdapter.this.mRecyclerView.canScrollHorizontally(1);
    }
    
    public boolean isInAbsoluteStart()
    {
      return !RecyclerViewOverScrollDecorAdapter.this.mRecyclerView.canScrollHorizontally(-1);
    }
  }
  
  public class ImplVerticalLayout
    implements RecyclerViewOverScrollDecorAdapter.Impl
  {
    protected ImplVerticalLayout() {}
    
    public boolean isInAbsoluteEnd()
    {
      return !RecyclerViewOverScrollDecorAdapter.this.mRecyclerView.canScrollVertically(1);
    }
    
    public boolean isInAbsoluteStart()
    {
      return !RecyclerViewOverScrollDecorAdapter.this.mRecyclerView.canScrollVertically(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.RecyclerViewOverScrollDecorAdapter
 * JD-Core Version:    0.7.0.1
 */