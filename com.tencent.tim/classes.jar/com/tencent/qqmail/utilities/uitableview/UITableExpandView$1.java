package com.tencent.qqmail.utilities.uitableview;

class UITableExpandView$1
  implements UITableView.ClickListener
{
  UITableExpandView$1(UITableExpandView paramUITableExpandView, UITableView.ClickListener paramClickListener) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == UITableExpandView.access$000(this.this$0))
    {
      this.this$0.setIsExpand(true);
      this.this$0.commit();
    }
    while (this.val$listener == null) {
      return;
    }
    this.val$listener.onClick(paramInt, paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.uitableview.UITableExpandView.1
 * JD-Core Version:    0.7.0.1
 */