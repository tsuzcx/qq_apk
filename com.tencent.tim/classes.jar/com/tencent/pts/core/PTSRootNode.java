package com.tencent.pts.core;

import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.pts.core.itemview.PTSRootNodeItemViewDelegate;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSAnimationUtil.AnimationInfo;
import com.tencent.pts.utils.PTSLog;
import java.util.List;

public class PTSRootNode
{
  public static final int ROOT_NODE_TYPE_ITEM_VIEW = 1;
  public static final int ROOT_NODE_TYPE_RECYCLER_VIEW = 0;
  private final String TAG = getClass().getSimpleName();
  private IPTSRootNodeDelegate mDelegate;
  
  PTSRootNode(PTSAppInstance paramPTSAppInstance, ViewGroup paramViewGroup, int paramInt)
  {
    initDelegate(paramPTSAppInstance, paramInt);
    init(paramViewGroup, paramInt);
  }
  
  private void init(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0)
    {
      localView = this.mDelegate.onCreateNativeView();
      if (paramViewGroup == null) {
        PTSLog.i(this.TAG, "[init], rootView is null.");
      }
    }
    while (paramInt != 1)
    {
      View localView;
      return;
      if (localView == null)
      {
        PTSLog.i(this.TAG, "[init], nativeRootView is null.");
        return;
      }
      paramViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    this.mDelegate.setRootView(paramViewGroup);
  }
  
  private void initDelegate(PTSAppInstance paramPTSAppInstance, int paramInt)
  {
    if (paramInt == 0) {
      this.mDelegate = new PTSRootNodeRecyclerViewDelegate(paramPTSAppInstance);
    }
    while (paramInt != 1) {
      return;
    }
    this.mDelegate = new PTSRootNodeItemViewDelegate(paramPTSAppInstance);
  }
  
  void addOnRecyclerViewScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    if ((this.mDelegate instanceof PTSRootNodeRecyclerViewDelegate)) {
      ((PTSRootNodeRecyclerViewDelegate)this.mDelegate).addOnScrollListener(paramOnScrollListener);
    }
  }
  
  boolean animation(PTSNodeInfo paramPTSNodeInfo, PTSAnimationUtil.AnimationInfo paramAnimationInfo)
  {
    return this.mDelegate.animation(paramPTSNodeInfo, paramAnimationInfo);
  }
  
  public PTSNodeInfo getRootNodeInfo()
  {
    if ((this.mDelegate instanceof PTSRootNodeItemViewDelegate)) {
      return ((PTSRootNodeItemViewDelegate)this.mDelegate).getRootNodeInfo();
    }
    return null;
  }
  
  boolean insert(PTSNodeInfo paramPTSNodeInfo, int paramInt)
  {
    return this.mDelegate.insert(paramPTSNodeInfo, paramInt);
  }
  
  boolean modify(PTSNodeInfo paramPTSNodeInfo)
  {
    return this.mDelegate.modify(paramPTSNodeInfo);
  }
  
  void onLayoutTempPatchFinished()
  {
    this.mDelegate.onLayoutTempPatchFinished();
  }
  
  boolean refreshNodeList(List<PTSNodeInfo> paramList)
  {
    return this.mDelegate.refreshNodeList(paramList);
  }
  
  boolean remove(int paramInt)
  {
    return this.mDelegate.remove(paramInt);
  }
  
  public void setRootView(ViewGroup paramViewGroup)
  {
    this.mDelegate.setRootView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.core.PTSRootNode
 * JD-Core Version:    0.7.0.1
 */