package com.tencent.token;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;

public final class gm
  extends gc
{
  private final ListView f;
  
  public gm(ListView paramListView)
  {
    super(paramListView);
    this.f = paramListView;
  }
  
  public final void a(int paramInt)
  {
    ListView localListView = this.f;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localListView.scrollListBy(paramInt);
      return;
    }
    int i = localListView.getFirstVisiblePosition();
    if (i != -1)
    {
      View localView = localListView.getChildAt(0);
      if (localView != null) {
        localListView.setSelectionFromTop(i, localView.getTop() - paramInt);
      }
    }
  }
  
  public final boolean b(int paramInt)
  {
    ListView localListView = this.f;
    int i = localListView.getCount();
    if (i == 0) {
      return false;
    }
    int j = localListView.getChildCount();
    int k = localListView.getFirstVisiblePosition();
    if (paramInt > 0)
    {
      if ((k + j >= i) && (localListView.getChildAt(j - 1).getBottom() <= localListView.getHeight())) {
        return false;
      }
    }
    else
    {
      if (paramInt >= 0) {
        break label89;
      }
      if ((k <= 0) && (localListView.getChildAt(0).getTop() >= 0)) {
        return false;
      }
    }
    return true;
    label89:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gm
 * JD-Core Version:    0.7.0.1
 */