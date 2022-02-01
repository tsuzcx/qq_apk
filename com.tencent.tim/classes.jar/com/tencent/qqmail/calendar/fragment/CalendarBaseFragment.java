package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import moai.fragment.base.BaseFragment.TransitionConfig;

public abstract class CalendarBaseFragment
  extends QMBaseFragment
{
  private QMTopBar mTopBar;
  
  protected CalendarBaseFragment(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public void finish()
  {
    popBackStack();
  }
  
  public QMTopBar getTopBar()
  {
    return this.mTopBar;
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    paramViewHolder = new QMBaseView(getActivity());
    this.mTopBar = new QMTopBar(getActivity());
    paramViewHolder.addView(this.mTopBar);
    return paramViewHolder;
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SLIDE_TRANSITION_CONFIG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarBaseFragment
 * JD-Core Version:    0.7.0.1
 */