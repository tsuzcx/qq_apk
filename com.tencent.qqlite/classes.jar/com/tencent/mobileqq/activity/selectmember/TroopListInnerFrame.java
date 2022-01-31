package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cnb;
import cne;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.ArrayList;
import java.util.List;

public class TroopListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private TroopListInnerFrame.TroopListAdapter jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame$TroopListAdapter;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public TroopListInnerFrame(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TroopListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TroopListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131493090);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0) != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0).getBottom() == this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame$TroopListAdapter.getItem(paramInt);
    } while (!(localObject1 instanceof TroopListInnerFrame.TroopListAdapter.TroopListItem));
    Object localObject2 = (TroopListInnerFrame.TroopListAdapter.TroopListItem)localObject1;
    Object localObject1 = null;
    switch (((TroopListInnerFrame.TroopListAdapter.TroopListItem)localObject2).i)
    {
    default: 
      label124:
      if (paramInt + 1 < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame$TroopListAdapter.getCount())
      {
        localObject2 = (TroopListInnerFrame.TroopListAdapter.TroopListItem)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame$TroopListAdapter.getItem(paramInt + 1);
        if ((((TroopListInnerFrame.TroopListAdapter.TroopListItem)localObject2).i != 6) && (((TroopListInnerFrame.TroopListAdapter.TroopListItem)localObject2).i != 4) && (((TroopListInnerFrame.TroopListAdapter.TroopListItem)localObject2).i != 2)) {
          break label390;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
        if (localObject2 != null)
        {
          paramInt = ((View)localObject2).getBottom();
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          if (paramInt >= this.jdField_a_of_type_Int) {
            break label382;
          }
          ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        }
      }
      label223:
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131362303, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame$TroopListAdapter.d) });
      break label124;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131362306, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame$TroopListAdapter.c) });
      break label124;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131362304, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame$TroopListAdapter.jdField_a_of_type_Int) });
      break label124;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131362305, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame$TroopListAdapter.b) });
      break label124;
      label382:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      break label223;
      label390:
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
  }
  
  private void g()
  {
    ContactFacade localContactFacade = (ContactFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
    if (localContactFacade != null) {
      this.jdField_a_of_type_JavaUtilArrayList = localContactFacade.a("-1003");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
  }
  
  public String a()
  {
    return null;
  }
  
  public List a()
  {
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903362);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131297776));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297672));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelector(2131427345);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame$TroopListAdapter = new TroopListInnerFrame.TroopListAdapter(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, 4, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame$TroopListAdapter);
    TroopListInnerFrame.TroopListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame$TroopListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(new cnb(this));
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131363994), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131363988));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame$TroopListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame$TroopListAdapter.b();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame$TroopListAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    paramView = (cne)paramView.getTag();
    TroopInfo localTroopInfo;
    int i;
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null))
    {
      localTroopInfo = paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
      if (localTroopInfo != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("group_uin", localTroopInfo.troopuin);
        localBundle.putString("group_name", localTroopInfo.troopname);
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(8, localBundle);
        switch (paramView.jdField_a_of_type_Int)
        {
        case 2: 
        case 4: 
        case 6: 
        default: 
          i = 0;
        }
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, localTroopInfo.troopuin + "", String.valueOf(i), "", "");
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListInnerFrame
 * JD-Core Version:    0.7.0.1
 */