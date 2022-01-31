package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import eqn;
import eqo;
import java.util.ArrayList;
import java.util.List;

public class RenMaiQuanTeamListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnTouchListener
{
  EditText jdField_a_of_type_AndroidWidgetEditText;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public CircleManager a;
  IGroupObserver jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver = new eqn(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private eqo jdField_a_of_type_Eqo;
  public ArrayList a;
  
  public RenMaiQuanTeamListInnerFrame(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public RenMaiQuanTeamListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public RenMaiQuanTeamListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public String a()
  {
    return "-1";
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(-1000, 1);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903975);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232612));
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131361815);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2130903944, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233087));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131234398)).setText(2131562831);
    ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233086)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager = ((CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33));
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver);
      i = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_JavaUtilArrayList);
      if (i != 0)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.c(i);
        if (i != 0) {
          break label210;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.j();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Eqo = new eqo(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Eqo);
      return;
      label210:
      if (i == -2) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131562452), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.getHeight());
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131561693), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131561816));
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.b(this.jdField_a_of_type_ComTencentMobileqqServiceCircleIGroupObserver);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Eqo.notifyDataSetChanged();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Mutichat_circle_search", 0, 0, "0", "", "", "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.RenMaiQuanTeamListInnerFrame
 * JD-Core Version:    0.7.0.1
 */