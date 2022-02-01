package com.tencent.viola.ui.view.refresh;

import android.view.View;

public class VRefreshContentView
{
  private ContentViewProvider mContentViewProvider;
  
  private boolean hasChildOnBottom()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mContentViewProvider != null)
    {
      bool1 = bool2;
      if (!this.mContentViewProvider.canChildPullUp()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean hasChildOnTop()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mContentViewProvider != null)
    {
      bool1 = bool2;
      if (!this.mContentViewProvider.canChildPullDown()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public ContentViewProvider getContentViewProvider()
  {
    return this.mContentViewProvider;
  }
  
  public boolean isBottom()
  {
    return hasChildOnBottom();
  }
  
  public boolean isTop()
  {
    return hasChildOnTop();
  }
  
  public void offsetTopAndBottom(int paramInt)
  {
    if ((this.mContentViewProvider != null) && (this.mContentViewProvider.getContentView() != null)) {
      this.mContentViewProvider.getContentView().offsetTopAndBottom(paramInt);
    }
  }
  
  public void scrollToTop(boolean paramBoolean)
  {
    if (this.mContentViewProvider != null) {
      this.mContentViewProvider.scrollToTop(paramBoolean);
    }
  }
  
  public void setContentViewProvider(ContentViewProvider paramContentViewProvider)
  {
    if (paramContentViewProvider == null) {
      return;
    }
    this.mContentViewProvider = paramContentViewProvider;
  }
  
  public static abstract interface ContentViewProvider<T extends View>
  {
    public abstract boolean canChildPullDown();
    
    public abstract boolean canChildPullUp();
    
    public abstract T getContentView();
    
    public abstract void onHeaderRebounded();
    
    public abstract void scrollToTop(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.refresh.VRefreshContentView
 * JD-Core Version:    0.7.0.1
 */