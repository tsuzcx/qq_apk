package com.tencent.qqmail.utilities.ui;

class ItemScrollListView$6
  implements HorizontalScrollItemView.OnItemScrollListener
{
  ItemScrollListView$6(ItemScrollListView paramItemScrollListView, HorizontalScrollItemView.OnItemScrollListener paramOnItemScrollListener) {}
  
  public void onExpandBegin(int paramInt)
  {
    this.val$mOnItemScrollListener.onExpandBegin(paramInt);
  }
  
  public void onExpandEnd(int paramInt)
  {
    this.val$mOnItemScrollListener.onExpandEnd(paramInt);
  }
  
  public void onFoldBegin(int paramInt)
  {
    this.val$mOnItemScrollListener.onFoldBegin(paramInt);
  }
  
  public void onFoldEnd(int paramInt)
  {
    this.val$mOnItemScrollListener.onFoldEnd(paramInt);
    if (ItemScrollListView.access$1100(this.this$0) != null) {
      ItemScrollListView.access$1100(this.this$0).onFoldEnd(paramInt);
    }
    ItemScrollListView.access$1002(this.this$0, false);
  }
  
  public void onScrollBegin(int paramInt)
  {
    this.val$mOnItemScrollListener.onScrollBegin(paramInt);
    ItemScrollListView.access$1002(this.this$0, true);
  }
  
  public void onScrollEnd(int paramInt)
  {
    this.val$mOnItemScrollListener.onScrollEnd(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.ItemScrollListView.6
 * JD-Core Version:    0.7.0.1
 */