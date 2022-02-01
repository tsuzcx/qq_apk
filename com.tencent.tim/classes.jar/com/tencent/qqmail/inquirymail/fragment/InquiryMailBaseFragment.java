package com.tencent.qqmail.inquirymail.fragment;

import android.view.MotionEvent;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import moai.fragment.base.BaseFragment.TransitionConfig;

public abstract class InquiryMailBaseFragment
  extends QMBaseFragment
{
  protected InquiryMailBaseFragment(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public QMTopBar getTopBar()
  {
    return ((QMBaseView)getBaseView()).getTopBar();
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
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
 * Qualified Name:     com.tencent.qqmail.inquirymail.fragment.InquiryMailBaseFragment
 * JD-Core Version:    0.7.0.1
 */