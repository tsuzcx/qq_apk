package com.tencent.qqlive.module.videoreport.traversal;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

public class ViewTraverser
  implements IViewTraverser
{
  private static final String TAG = "ViewTraverser";
  private OnViewTraverseListener mOnTraverseListener;
  
  private ViewTraverser()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ViewTraverser", "ViewTraverser.<init>: ");
    }
  }
  
  public static ViewTraverser getInstance()
  {
    return InstanceHolder.INSTANCE;
  }
  
  private void performInternal(@NonNull View paramView, int paramInt, @NonNull IViewTraverseCallback paramIViewTraverseCallback)
  {
    if (this.mOnTraverseListener != null) {
      this.mOnTraverseListener.onViewVisited(paramView);
    }
    if ((paramIViewTraverseCallback.onEnter(paramView, paramInt)) && ((paramView instanceof ViewGroup)))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = localViewGroup.getChildCount();
      if (i != 0)
      {
        i -= 1;
        while (i >= 0)
        {
          performInternal(localViewGroup.getChildAt(i), paramInt + 1, paramIViewTraverseCallback);
          i -= 1;
        }
      }
    }
    paramIViewTraverseCallback.onLeave(paramView, paramInt);
  }
  
  public void perform(View paramView, IViewTraverseCallback paramIViewTraverseCallback)
  {
    if ((paramView == null) || (paramIViewTraverseCallback == null)) {
      return;
    }
    performInternal(paramView, 1, paramIViewTraverseCallback);
  }
  
  public void setListener(OnViewTraverseListener paramOnViewTraverseListener)
  {
    this.mOnTraverseListener = paramOnViewTraverseListener;
  }
  
  static class InstanceHolder
  {
    static final ViewTraverser INSTANCE = new ViewTraverser(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.traversal.ViewTraverser
 * JD-Core Version:    0.7.0.1
 */