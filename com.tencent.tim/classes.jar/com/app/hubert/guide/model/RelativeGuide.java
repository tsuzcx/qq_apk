package com.app.hubert.guide.model;

import android.graphics.RectF;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.app.hubert.guide.core.Controller;
import com.app.hubert.guide.util.LogUtil;

public class RelativeGuide
{
  public int gravity;
  public HighLight highLight;
  @LayoutRes
  public int layout;
  public int padding;
  
  public RelativeGuide(@LayoutRes int paramInt1, int paramInt2)
  {
    this.layout = paramInt1;
    this.gravity = paramInt2;
  }
  
  public RelativeGuide(@LayoutRes int paramInt1, int paramInt2, int paramInt3)
  {
    this.layout = paramInt1;
    this.gravity = paramInt2;
    this.padding = paramInt3;
  }
  
  private MarginInfo getMarginInfo(int paramInt, ViewGroup paramViewGroup, View paramView)
  {
    paramView = new MarginInfo();
    RectF localRectF = this.highLight.getRectF(paramViewGroup);
    switch (paramInt)
    {
    default: 
      return paramView;
    case 3: 
      paramView.gravity = 5;
      paramView.rightMargin = ((int)(paramViewGroup.getWidth() - localRectF.left + this.padding));
      paramView.topMargin = ((int)localRectF.top);
      return paramView;
    case 48: 
      paramView.gravity = 80;
      paramView.bottomMargin = ((int)(paramViewGroup.getHeight() - localRectF.top + this.padding));
      paramView.leftMargin = ((int)localRectF.left);
      return paramView;
    case 5: 
      paramView.leftMargin = ((int)(localRectF.right + this.padding));
      paramView.topMargin = ((int)localRectF.top);
      return paramView;
    }
    paramView.topMargin = ((int)(localRectF.bottom + this.padding));
    paramView.leftMargin = ((int)localRectF.left);
    return paramView;
  }
  
  public final View getGuideLayout(ViewGroup paramViewGroup, Controller paramController)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(this.layout, paramViewGroup, false);
    onLayoutInflated(localView);
    onLayoutInflated(localView, paramController);
    paramController = (FrameLayout.LayoutParams)localView.getLayoutParams();
    MarginInfo localMarginInfo = getMarginInfo(this.gravity, paramViewGroup, localView);
    LogUtil.e(localMarginInfo.toString());
    offsetMargin(localMarginInfo, paramViewGroup, localView);
    paramController.gravity = localMarginInfo.gravity;
    paramController.leftMargin += localMarginInfo.leftMargin;
    paramController.topMargin += localMarginInfo.topMargin;
    paramController.rightMargin += localMarginInfo.rightMargin;
    int i = paramController.bottomMargin;
    paramController.bottomMargin = (localMarginInfo.bottomMargin + i);
    localView.setLayoutParams(paramController);
    return localView;
  }
  
  protected void offsetMargin(MarginInfo paramMarginInfo, ViewGroup paramViewGroup, View paramView) {}
  
  @Deprecated
  protected void onLayoutInflated(View paramView) {}
  
  protected void onLayoutInflated(View paramView, Controller paramController) {}
  
  public static class MarginInfo
  {
    public int bottomMargin;
    public int gravity;
    public int leftMargin;
    public int rightMargin;
    public int topMargin;
    
    public String toString()
    {
      return "MarginInfo{leftMargin=" + this.leftMargin + ", topMargin=" + this.topMargin + ", rightMargin=" + this.rightMargin + ", bottomMargin=" + this.bottomMargin + ", gravity=" + this.gravity + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.app.hubert.guide.model.RelativeGuide
 * JD-Core Version:    0.7.0.1
 */