package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import auwc;

public abstract class OnRecyclerItemClickListener
  implements RecyclerView.OnItemTouchListener
{
  private auwc mGestureDetector;
  private DragRecyclerView recyclerView;
  
  public OnRecyclerItemClickListener(DragRecyclerView paramDragRecyclerView)
  {
    this.recyclerView = paramDragRecyclerView;
    this.mGestureDetector = new auwc(paramDragRecyclerView.getContext(), new ItemTouchHelperGestureListener(null));
  }
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    boolean bool = this.mGestureDetector.onTouchEvent(paramMotionEvent);
    if ((this.recyclerView.isDragging) && (paramMotionEvent.getAction() == 1)) {
      this.recyclerView.onTouchEvent(paramMotionEvent);
    }
    return bool;
  }
  
  public abstract void onItemClick(RecyclerView.ViewHolder paramViewHolder);
  
  public abstract void onItemLongPress(RecyclerView.ViewHolder paramViewHolder);
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  class ItemTouchHelperGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    private ItemTouchHelperGestureListener() {}
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      paramMotionEvent = OnRecyclerItemClickListener.this.recyclerView.findChildViewUnder(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (paramMotionEvent != null)
      {
        paramMotionEvent = OnRecyclerItemClickListener.this.recyclerView.getChildViewHolder(paramMotionEvent);
        OnRecyclerItemClickListener.this.onItemLongPress(paramMotionEvent);
      }
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      paramMotionEvent = OnRecyclerItemClickListener.this.recyclerView.findChildViewUnder(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (paramMotionEvent != null)
      {
        paramMotionEvent = OnRecyclerItemClickListener.this.recyclerView.getChildViewHolder(paramMotionEvent);
        OnRecyclerItemClickListener.this.onItemClick(paramMotionEvent);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.OnRecyclerItemClickListener
 * JD-Core Version:    0.7.0.1
 */