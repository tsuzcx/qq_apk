package com.tencent.qqmail.account.fragment;

import android.view.MotionEvent;
import com.tencent.qqmail.BaseActivityImpl;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentManager.BackStackEntry;
import moai.fragment.app.FragmentTransaction;
import moai.fragment.base.BaseFragment.TransitionConfig;
import moai.fragment.base.BaseFragmentActivity;

public abstract class LoginBaseFragment
  extends QMBaseFragment
{
  protected LoginBaseFragment()
  {
    super(true);
  }
  
  protected void backToLoginAccountFragment()
  {
    if ((getBaseFragmentActivity().getSupportFragmentManager().findFragmentByTag(LoginAccountFragment.class.getSimpleName()) == null) && ((getBaseFragmentActivity() instanceof LoginFragmentActivity)))
    {
      getBaseFragmentActivity().finish();
      return;
    }
    int k = getBaseFragmentActivity().getSupportFragmentManager().getBackStackEntryCount();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      if (getBaseFragmentActivity().getSupportFragmentManager().getBackStackEntryAt(i).getName().equals(LoginAccountFragment.class.getSimpleName())) {
        j = i;
      }
      i += 1;
    }
    FragmentManager localFragmentManager = getBaseFragmentActivity().getSupportFragmentManager();
    if (j == 0) {}
    for (i = 1;; i = 0)
    {
      localFragmentManager.popBackStack(j, i);
      return;
    }
  }
  
  public QMTopBar getTopBar()
  {
    return ((QMBaseView)getBaseView()).getTopBar();
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    return new QMBaseView(getActivity());
  }
  
  protected boolean isActivityResumed()
  {
    return (getBaseActivityImpl() != null) && (getBaseActivityImpl().isActivityResumed());
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SCALE_TRANSITION_CONFIG;
  }
  
  protected void replaceFragment(LoginBaseFragment paramLoginBaseFragment1, LoginBaseFragment paramLoginBaseFragment2)
  {
    FragmentManager localFragmentManager = getFragmentManager();
    if (localFragmentManager != null) {
      localFragmentManager.beginTransaction().hide(paramLoginBaseFragment1).replace(2131367566, paramLoginBaseFragment2, paramLoginBaseFragment2.getClass().getSimpleName()).commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginBaseFragment
 * JD-Core Version:    0.7.0.1
 */