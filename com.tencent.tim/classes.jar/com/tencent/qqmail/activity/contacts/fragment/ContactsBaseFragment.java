package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.qqmail.activity.contacts.ContactsFragmentActivity;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentManager.BackStackEntry;
import moai.fragment.base.BaseFragment.TransitionConfig;
import moai.fragment.base.BaseFragmentActivity;

public abstract class ContactsBaseFragment
  extends QMBaseFragment
{
  public static final int FROM_BLACK_WHITE_LIST = 4;
  public static final int FROM_COMPOSE_MAIL = 3;
  public static final int FROM_LIST = 0;
  public static final int FROM_READ_MAIL = 2;
  public static final int FROM_UPDATE_LIST = 1;
  private FrameLayout baseView;
  private long beginTime;
  private long endTime;
  protected int from = 0;
  private QMTopBar mTopBar;
  
  protected ContactsBaseFragment(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public void backToContactDetail()
  {
    if ((getBaseFragmentActivity().getSupportFragmentManager().findFragmentByTag(ContactDetailFragment.TAG) == null) && ((getBaseFragmentActivity() instanceof ContactsFragmentActivity)))
    {
      getBaseFragmentActivity().finish();
      return;
    }
    int k = getBaseFragmentActivity().getSupportFragmentManager().getBackStackEntryCount();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      if (getBaseFragmentActivity().getSupportFragmentManager().getBackStackEntryAt(i).getName().equals(ContactDetailFragment.TAG)) {
        j = i;
      }
      i += 1;
    }
    FragmentManager localFragmentManager = getBaseFragmentActivity().getSupportFragmentManager();
    if (j == 0) {}
    for (i = 1;; i = 0)
    {
      localFragmentManager.popBackStack(j, i);
      overridePendingTransition(2130772430, 2130772430);
      return;
    }
  }
  
  public void backToContactList()
  {
    popBackStack();
  }
  
  protected void endTrace(String paramString)
  {
    if (this.endTime == 0L)
    {
      this.endTime = System.currentTimeMillis();
      QMLog.log(4, paramString, "#render " + paramString + " begintime : " + this.beginTime + " endtime : " + this.endTime + " totaltime : " + (this.endTime - this.beginTime));
    }
  }
  
  public QMTopBar getTopBar()
  {
    return this.mTopBar;
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    startTrace();
    this.mTopBar = new QMTopBar(getActivity());
    this.baseView = new QMBaseView(getActivity());
    this.baseView.addView(this.mTopBar);
    return this.baseView;
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SLIDE_TRANSITION_CONFIG;
  }
  
  protected void startTrace()
  {
    this.beginTime = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsBaseFragment
 * JD-Core Version:    0.7.0.1
 */