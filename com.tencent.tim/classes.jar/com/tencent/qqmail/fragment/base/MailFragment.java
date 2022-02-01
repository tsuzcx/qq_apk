package com.tencent.qqmail.fragment.base;

import android.view.View;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import moai.fragment.base.BaseFragment.TransitionConfig;

public abstract class MailFragment
  extends QMBaseFragment
{
  private static final String TAG = "MailFragment";
  
  protected MailFragment(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public QMTopBar getTopBar()
  {
    View localView = getBaseView();
    if ((localView instanceof QMBaseView)) {
      return ((QMBaseView)getBaseView()).getTopBar();
    }
    ValidateHelper.assertInDebug("getTopBar, baseView: " + localView, false);
    QMLog.log(5, "MailFragment", "getTopBar, baseView is not QMBaseView: " + localView);
    popBackStack();
    return new QMBaseView(getActivity()).getTopBar();
  }
  
  protected void initTopbar(View paramView)
  {
    paramView = (QMBaseView)paramView;
    paramView.getTopBar().setButtonLeftOnclickListener(new MailFragment.1(this));
    paramView.getTopBar().setCenterOnclickListener(new MailFragment.2(this));
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    return new QMBaseView(getActivity());
  }
  
  public void onButtonBackClick()
  {
    if (getBaseFragmentActivity() != null)
    {
      popBackStack();
      return;
    }
    QMLog.log(6, "MailFragment", "getBaseFragmentActivity() return null.");
  }
  
  protected BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SLIDE_TRANSITION_CONFIG;
  }
  
  protected void onTopBarCenterClick()
  {
    ((QMBaseView)getBaseView()).scrollToTop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.fragment.base.MailFragment
 * JD-Core Version:    0.7.0.1
 */