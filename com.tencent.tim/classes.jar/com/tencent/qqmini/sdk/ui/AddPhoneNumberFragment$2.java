package com.tencent.qqmini.sdk.ui;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.id;

class AddPhoneNumberFragment$2
  implements View.OnClickListener
{
  AddPhoneNumberFragment$2(AddPhoneNumberFragment paramAddPhoneNumberFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == R.id.mini_app_phone_number_manager_title_back) && (this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()))
    {
      this.this$0.getActivity().setResult(0);
      this.this$0.getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.AddPhoneNumberFragment.2
 * JD-Core Version:    0.7.0.1
 */