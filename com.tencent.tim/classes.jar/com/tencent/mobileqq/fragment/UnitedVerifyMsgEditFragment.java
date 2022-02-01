package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class UnitedVerifyMsgEditFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  TextView BK;
  AddFriendVerifyActivity.a a;
  EditText aq;
  int dar = 100;
  BaseActivity mContext;
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.dar = getArguments().getInt("VERIFY_MSG_BYTES_LIMIT", 100);
    setTitle(getString(2131689787));
    setLeftButton(2131721058, null);
    setRightButton(2131691441, this);
    this.aq = ((EditText)this.mContentView.findViewById(2131377168));
    this.BK = ((TextView)this.mContentView.findViewById(2131377169));
    this.a = new AddFriendVerifyActivity.a(this.dar, this.aq);
    this.aq.addTextChangedListener(this.a);
    ThreadManager.post(new UnitedVerifyMsgEditFragment.1(this), 8, null, true);
  }
  
  protected int getContentLayoutId()
  {
    return 2131561782;
  }
  
  public boolean onBackEvent()
  {
    this.mContext.setResult(0);
    boolean bool = super.onBackEvent();
    this.mContext.overridePendingTransition(2130772002, 2130772013);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText)
    {
      String str = this.aq.getText().toString();
      Intent localIntent = new Intent();
      localIntent.putExtra("VERIFY_MSG", str);
      this.mContext.setResult(-1, localIntent);
      this.mContext.finish();
      this.mContext.overridePendingTransition(2130772002, 2130772013);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mContext = getActivity();
  }
  
  public void onDestroyView()
  {
    this.aq.removeTextChangedListener(this.a);
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment
 * JD-Core Version:    0.7.0.1
 */