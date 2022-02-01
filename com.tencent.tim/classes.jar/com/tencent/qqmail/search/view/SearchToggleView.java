package com.tencent.qqmail.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class SearchToggleView
  extends LinearLayout
{
  private static final String TAG = "SearchToggleView";
  private boolean hidden;
  public List<View.OnClickListener> mClickChain = new ArrayList();
  private SearchToggleViewCallback toggleViewCallback;
  
  public SearchToggleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SearchToggleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void initEvents()
  {
    setOnClickListener(new SearchToggleView.1(this));
  }
  
  public void addClickChain(View.OnClickListener paramOnClickListener)
  {
    this.mClickChain.add(paramOnClickListener);
  }
  
  public SearchToggleViewCallback getToggleViewCallback()
  {
    return this.toggleViewCallback;
  }
  
  public void hide()
  {
    if (this.hidden) {
      return;
    }
    this.hidden = true;
    setVisibility(8);
  }
  
  public void init()
  {
    this.hidden = true;
    setVisibility(8);
    initEvents();
  }
  
  public boolean isHidden()
  {
    return this.hidden;
  }
  
  public void removeClickChain(View.OnClickListener paramOnClickListener)
  {
    this.mClickChain.remove(paramOnClickListener);
  }
  
  public void setHidden(boolean paramBoolean)
  {
    this.hidden = paramBoolean;
  }
  
  public void setToggleViewCallback(SearchToggleViewCallback paramSearchToggleViewCallback)
  {
    this.toggleViewCallback = paramSearchToggleViewCallback;
  }
  
  public void show()
  {
    if (!this.hidden) {
      return;
    }
    this.hidden = false;
    setVisibility(0);
  }
  
  public static abstract interface SearchToggleViewCallback
  {
    public abstract void didDismiss(SearchToggleView paramSearchToggleView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.view.SearchToggleView
 * JD-Core Version:    0.7.0.1
 */