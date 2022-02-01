package com.tencent.av.doodle;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.BaseToolbar.a;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import imp;
import imq;
import imr;
import java.lang.ref.WeakReference;

public class DoodleToolbar
  extends BaseToolbar
{
  private imp mDoodleLogic = imp.a();
  BaseToolbar.a mUIInfo = null;
  
  public DoodleToolbar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramVideoAppInterface, paramAVActivity);
  }
  
  private ColorPickerView addColorPickerView(ViewGroup paramViewGroup)
  {
    Object localObject2 = (ColorPickerView)paramViewGroup.findViewById(2131373963);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ColorPickerView(paramViewGroup.getContext());
      localObject2 = paramViewGroup.getResources();
      int i = ((Resources)localObject2).getDimensionPixelOffset(2131298087);
      int j = ((Resources)localObject2).getDimensionPixelOffset(2131298076);
      int k = ((Resources)localObject2).getDimensionPixelOffset(2131298077);
      localObject2 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, k, 0, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    return localObject1;
  }
  
  private void removeColorPickerView(ViewGroup paramViewGroup)
  {
    View localView = paramViewGroup.findViewById(2131373963);
    if (localView != null) {
      paramViewGroup.removeView(localView);
    }
  }
  
  public BaseToolbar.a getUIInfo()
  {
    if (this.mUIInfo == null)
    {
      this.mUIInfo = new BaseToolbar.a();
      this.mUIInfo.avw = 3;
      this.mUIInfo.avy = 2131559978;
      this.mUIInfo.avx = 2130842861;
      this.mUIInfo.QZ = this.mApp.getApp().getString(2131698141);
    }
    return this.mUIInfo;
  }
  
  public String getUnableInfo()
  {
    if (this.mActivity.get() != null)
    {
      AVActivity localAVActivity = (AVActivity)this.mActivity.get();
      int i = 0;
      imp localimp = imp.a();
      if (!imr.ub()) {
        i = 2131697644;
      }
      while (i != 0)
      {
        return localAVActivity.getString(i);
        if (!localimp.ua()) {
          i = 2131697643;
        } else if (!localimp.SB) {
          i = 2131697642;
        }
      }
    }
    return "";
  }
  
  public boolean isEffectBtnEnable()
  {
    imp localimp = imp.a();
    return (imr.ub()) && (localimp.SB) && (localimp.ua());
  }
  
  public void onDestroy(long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    onHide(paramLong);
  }
  
  public void onHide(long paramLong)
  {
    AVActivity localAVActivity = getAVActivity();
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder().append("onHide, avActivity[");
    if (localAVActivity != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject1, 1, bool + "], seq[" + paramLong + "]");
      if (localAVActivity != null)
      {
        localObject1 = (ViewGroup)localAVActivity.findViewById(2131363166);
        if (localObject1 != null)
        {
          localObject2 = (DoodleSurfaceView)((ViewGroup)localObject1).findViewById(2131373974);
          if (localObject2 != null)
          {
            ((DoodleSurfaceView)localObject2).setClickable(false);
            if (!((DoodleSurfaceView)localObject2).ud()) {
              imr.c((ViewGroup)localObject1);
            }
          }
          localObject2 = (ColorPickerView)((ViewGroup)localObject1).findViewById(2131373963);
          if (localObject2 != null)
          {
            ((ColorPickerView)localObject2).clearAnimation();
            ((ColorPickerView)localObject2).setVisibility(8);
            removeColorPickerView((ViewGroup)localObject1);
          }
          this.mDoodleLogic.a.setIsShow(false);
          localAVActivity.mControlUI.dE(paramLong);
        }
      }
      return;
    }
  }
  
  public void onShow(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (this.mActivity.get() != null)
    {
      AVActivity localAVActivity = (AVActivity)this.mActivity.get();
      Object localObject = (ViewGroup)localAVActivity.findViewById(2131363166);
      if (localObject != null)
      {
        DoodleSurfaceView localDoodleSurfaceView = imr.a((ViewGroup)localObject);
        if (localDoodleSurfaceView != null) {
          localDoodleSurfaceView.setClickable(true);
        }
        localObject = addColorPickerView((ViewGroup)localObject);
        if (localObject != null)
        {
          ((ColorPickerView)localObject).clearAnimation();
          ((ColorPickerView)localObject).setVisibility(0);
        }
        this.mDoodleLogic.a.setIsShow(true);
        localAVActivity.mControlUI.auV();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleToolbar
 * JD-Core Version:    0.7.0.1
 */