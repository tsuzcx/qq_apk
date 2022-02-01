package com.tencent.qqmail.card.fragment;

import android.os.Bundle;
import android.view.View;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.view.QMTopBar;
import moai.fragment.base.BaseFragment.TransitionConfig;

public abstract class CardBaseFragment
  extends QMBaseFragment
{
  protected CardBaseFragment()
  {
    super(false);
  }
  
  @Deprecated
  public QMTopBar getTopBar()
  {
    throw new UnsupportedOperationException();
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle) {}
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SLIDE_TRANSITION_CONFIG;
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBaseFragment
 * JD-Core Version:    0.7.0.1
 */