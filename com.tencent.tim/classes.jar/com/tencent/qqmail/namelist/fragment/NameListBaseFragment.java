package com.tencent.qqmail.namelist.fragment;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import moai.fragment.base.BaseFragment.TransitionConfig;

public abstract class NameListBaseFragment
  extends QMBaseFragment
{
  protected NameListBaseFragment(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public QMTopBar getTopBar()
  {
    return ((QMBaseView)getBaseView()).getTopBar();
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    return new QMBaseView(getActivity());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListBaseFragment
 * JD-Core Version:    0.7.0.1
 */