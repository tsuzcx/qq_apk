package com.tencent.mobileqq.activity.voip;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;

public class VoipDetailActivity$VoipPhoneListItem
  extends LinearLayout
  implements View.OnClickListener
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public VoipDetailActivity$VoipPhoneListItem(VoipDetailActivity paramVoipDetailActivity, Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130904057, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234676));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131234674));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  public VoipDetailActivity$VoipPhoneListItem(VoipDetailActivity paramVoipDetailActivity, Context paramContext, String paramString)
  {
    this(paramVoipDetailActivity, paramContext, null, paramString);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Intent();
    paramView.setClass(getContext(), VoipDialInterfaceActivity.class);
    VoipPhoneNumber localVoipPhoneNumber = new VoipPhoneNumber(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), getContext());
    int i = VoipHistoryActivity.a(getContext());
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.b.getManager(10)).a();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipDetailActivity.b, "CliOper", "", "", "CallTab_external", "qqout_start", 2, 1, 0, String.valueOf(i), localRespondQueryQQBindingStat.nationCode, localVoipPhoneNumber.b, "");
    paramView.putExtra("dialData", new VoipDialData(localVoipPhoneNumber.b, localVoipPhoneNumber.a));
    paramView.putExtra("callNow", 0);
    getContext().startActivity(paramView);
  }
  
  public void setTextViewText(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipDetailActivity.VoipPhoneListItem
 * JD-Core Version:    0.7.0.1
 */