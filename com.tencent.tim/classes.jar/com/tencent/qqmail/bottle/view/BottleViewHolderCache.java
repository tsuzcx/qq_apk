package com.tencent.qqmail.bottle.view;

import android.view.View;
import java.util.Stack;

public class BottleViewHolderCache
{
  private Stack<View> mNotUsingView = new Stack();
  private Stack<View> mUsingView = new Stack();
  
  public BottleViewHolderCache()
  {
    this.mUsingView.clear();
    this.mNotUsingView.clear();
  }
  
  public void clearUsingView()
  {
    while (!this.mUsingView.empty()) {
      this.mNotUsingView.push(this.mUsingView.pop());
    }
  }
  
  public int getTotalCount()
  {
    return this.mUsingView.size() + this.mNotUsingView.size();
  }
  
  public View getUnUsingView()
  {
    if (!this.mNotUsingView.empty())
    {
      View localView = (View)this.mNotUsingView.pop();
      this.mUsingView.push(localView);
      return localView;
    }
    return null;
  }
  
  public boolean hasUnUsedView()
  {
    return !this.mNotUsingView.empty();
  }
  
  public void setUsingView(View paramView)
  {
    if (paramView != null) {
      this.mUsingView.push(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.view.BottleViewHolderCache
 * JD-Core Version:    0.7.0.1
 */