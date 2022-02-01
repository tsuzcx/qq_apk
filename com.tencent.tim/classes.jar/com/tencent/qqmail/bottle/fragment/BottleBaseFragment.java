package com.tencent.qqmail.bottle.fragment;

import android.view.MotionEvent;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import moai.fragment.base.BaseFragment.TransitionConfig;

public abstract class BottleBaseFragment
  extends QMBaseFragment
{
  protected BottleBaseFragment(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SLIDE_TRANSITION_CONFIG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBaseFragment
 * JD-Core Version:    0.7.0.1
 */