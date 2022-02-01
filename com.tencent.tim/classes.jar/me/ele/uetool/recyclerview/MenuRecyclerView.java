package me.ele.uetool.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;

public class MenuRecyclerView
  extends RecyclerView
{
  private RvContextMenuInfo contextMenuInfo;
  
  public MenuRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MenuRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MenuRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.contextMenuInfo;
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    if (indexOfChild(paramView) == -1) {}
    int i;
    do
    {
      return false;
      i = getChildAdapterPosition(paramView);
    } while (i < 0);
    this.contextMenuInfo = new RvContextMenuInfo(paramView, i, getAdapter().getItemId(i));
    return super.showContextMenuForChild(paramView);
  }
  
  public class RvContextMenuInfo
    implements ContextMenu.ContextMenuInfo
  {
    public long id;
    public int position;
    public View targetView;
    
    public RvContextMenuInfo(View paramView, int paramInt, long paramLong)
    {
      this.targetView = paramView;
      this.position = paramInt;
      this.id = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.recyclerview.MenuRecyclerView
 * JD-Core Version:    0.7.0.1
 */