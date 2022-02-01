package com.tencent.qqlive.module.videoreport.utils;

import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

public class ViewCompatUtils
{
  private static final ViewCompatBaseImpl IMPL = new ViewCompatBaseImpl(null);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      IMPL = new ViewCompatApi21Impl(null);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new ViewCompatApi19Impl(null);
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      IMPL = new ViewCompatApi18Impl(null);
      return;
    }
  }
  
  public static boolean getClipChildren(ViewGroup paramViewGroup)
  {
    return IMPL.getClipChildren(paramViewGroup);
  }
  
  public static boolean getClipToPadding(ViewGroup paramViewGroup)
  {
    return IMPL.getClipToPadding(paramViewGroup);
  }
  
  public static boolean isAttachedToWindow(View paramView)
  {
    return IMPL.isAttachedToWindow(paramView);
  }
  
  @RequiresApi(api=18)
  static class ViewCompatApi18Impl
    extends ViewCompatUtils.ViewCompatBaseImpl
  {
    private ViewCompatApi18Impl()
    {
      super();
    }
    
    public boolean getClipChildren(ViewGroup paramViewGroup)
    {
      return paramViewGroup.getClipChildren();
    }
  }
  
  @RequiresApi(api=19)
  static class ViewCompatApi19Impl
    extends ViewCompatUtils.ViewCompatApi18Impl
  {
    private ViewCompatApi19Impl()
    {
      super();
    }
    
    public boolean isAttachedToWindow(View paramView)
    {
      return paramView.isAttachedToWindow();
    }
  }
  
  @RequiresApi(api=21)
  static class ViewCompatApi21Impl
    extends ViewCompatUtils.ViewCompatApi19Impl
  {
    private ViewCompatApi21Impl()
    {
      super();
    }
    
    public boolean getClipToPadding(ViewGroup paramViewGroup)
    {
      return paramViewGroup.getClipToPadding();
    }
  }
  
  static class ViewCompatBaseImpl
  {
    private static final Integer FLAG_CLIP_CHILDREN = (Integer)ReflectUtils.getField(ViewGroup.class, "FLAG_CLIP_CHILDREN");
    private static final Integer FLAG_CLIP_TO_PADDING = (Integer)ReflectUtils.getField(ViewGroup.class, "FLAG_CLIP_TO_PADDING");
    private static final String TAG = "ViewCompatBaseImpl";
    
    private boolean hasBooleanFlag(ViewGroup paramViewGroup, Integer paramInteger)
    {
      Integer localInteger = (Integer)ReflectUtils.getField(ViewGroup.class, "mGroupFlags", paramViewGroup);
      StringBuilder localStringBuilder;
      if (VideoReportInner.getInstance().isDebugMode())
      {
        localStringBuilder = new StringBuilder().append("hasBooleanFlag: groupFlags = ");
        if (localInteger != null) {
          break label86;
        }
        paramViewGroup = "null";
        localStringBuilder = localStringBuilder.append(paramViewGroup).append(", flag = ");
        if (paramInteger != null) {
          break label94;
        }
      }
      label86:
      label94:
      for (paramViewGroup = "null";; paramViewGroup = paramInteger.toString())
      {
        Log.d("ViewCompatBaseImpl", paramViewGroup);
        if ((localInteger != null) && (paramInteger != null)) {
          break label102;
        }
        return false;
        paramViewGroup = localInteger.toString();
        break;
      }
      label102:
      return (localInteger.intValue() & paramInteger.intValue()) == paramInteger.intValue();
    }
    
    public boolean getClipChildren(ViewGroup paramViewGroup)
    {
      return hasBooleanFlag(paramViewGroup, FLAG_CLIP_CHILDREN);
    }
    
    public boolean getClipToPadding(ViewGroup paramViewGroup)
    {
      return hasBooleanFlag(paramViewGroup, FLAG_CLIP_TO_PADDING);
    }
    
    public boolean isAttachedToWindow(View paramView)
    {
      return ReflectUtils.getField(View.class, "mAttachInfo", paramView) != null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils
 * JD-Core Version:    0.7.0.1
 */