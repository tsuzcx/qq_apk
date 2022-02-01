package com.tencent.qqmail.account.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;

public class LoginLockFragment
  extends LoginBaseFragment
{
  private static final String TAG = "LoginLockFragment";
  private QMBaseView baseView;
  private final String lockPhone;
  private TextView phoneText;
  private final int seq;
  private QMTopBar topBar;
  private Button verifyBtn;
  
  public LoginLockFragment(String paramString, int paramInt)
  {
    this.lockPhone = paramString;
    this.seq = paramInt;
  }
  
  private void initPhoneView()
  {
    this.phoneText = ((TextView)this.baseView.findViewById(2131373057));
    this.phoneText.setText(String.format(getString(2131689628), new Object[] { this.lockPhone }));
  }
  
  private void initTopBar()
  {
    this.topBar = getTopBar();
    this.topBar.setTitle(2131689622);
    this.topBar.setButtonLeftNormal(2131691246);
    this.topBar.setButtonLeftOnclickListener(new LoginLockFragment.1(this));
  }
  
  private void initVerifyView()
  {
    this.verifyBtn = ((Button)this.baseView.findViewById(2131363388));
    this.verifyBtn.setOnClickListener(new LoginLockFragment.2(this));
  }
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    initPhoneView();
    initVerifyView();
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.baseView = super.initUI(paramViewHolder);
    this.baseView.initScrollView();
    this.baseView.setBackgroundColor(getResources().getColor(2131167681));
    this.baseView.addContentView(View.inflate(getActivity(), 2131559507, null));
    return this.baseView;
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public int refreshData()
  {
    return 0;
  }
  
  public void render(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginLockFragment
 * JD-Core Version:    0.7.0.1
 */