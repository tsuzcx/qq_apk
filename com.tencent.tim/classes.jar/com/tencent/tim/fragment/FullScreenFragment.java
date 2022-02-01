package com.tencent.tim.fragment;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentEx;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.view.KeyEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import arhz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class FullScreenFragment
  extends FragmentEx
{
  protected FragmentManager.BackStackEntry a;
  public QQAppInterface app;
  protected arhz d;
  public int eru = -1;
  
  protected void Ai()
  {
    try
    {
      if ((this.d != null) && (this.d.isShowing())) {
        this.d.dismiss();
      }
      this.d = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected boolean aJo()
  {
    return true;
  }
  
  protected void dX(Bundle paramBundle) {}
  
  protected int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299627);
  }
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(aJo());
    this.app = getActivity().app;
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.eru != -1)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(getActivity(), this.eru);
      this.eru = -1;
      return localAnimation;
    }
    return null;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Ai();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  protected boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  protected boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  protected boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  protected boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("FullScreenFragment", 2, getClass().getName() + ".onResume");
    }
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  @TargetApi(16)
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    Bundle localBundle;
    if (paramBundle != null)
    {
      localBundle = getArguments();
      if (localBundle != null) {
        break label19;
      }
      super.setArguments(paramBundle);
    }
    label19:
    do
    {
      return;
      localBundle.clear();
      localBundle.putAll(paramBundle);
    } while (!isVisible());
    dX(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.fragment.FullScreenFragment
 * JD-Core Version:    0.7.0.1
 */