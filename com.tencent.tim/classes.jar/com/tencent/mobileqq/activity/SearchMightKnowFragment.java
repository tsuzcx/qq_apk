package com.tencent.mobileqq.activity;

import abex.c;
import abfm;
import acfp;
import achg;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import anot;
import anwa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.a;
import java.util.ArrayList;
import vsz;
import vta;
import vtb;
import vtc;
import vtd;
import vte;

public class SearchMightKnowFragment
  extends PublicBaseFragment
  implements TextWatcher, TextView.OnEditorActionListener
{
  abex.c jdField_a_of_type_Abex$c = new vtd(this);
  private abfm jdField_a_of_type_Abfm;
  private achg jdField_a_of_type_Achg;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private ImageButton ah;
  public QQAppInterface app;
  public QuickPinyinEditText b;
  SwipListView.a b;
  private TextView bI;
  private SwipListView e;
  private LinearLayout gx;
  private ImageView rd;
  
  public SearchMightKnowFragment()
  {
    this.jdField_b_of_type_ComTencentWidgetSwipListView$a = new vte(this);
  }
  
  private void L(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void cM(View paramView)
  {
    View localView = paramView.findViewById(2131363801);
    this.rd = ((ImageView)paramView.findViewById(2131369671));
    this.rd.setVisibility(0);
    this.rd.setOnClickListener(new vtb(this));
    localView.setOnClickListener(new vtc(this));
  }
  
  private void u(View paramView)
  {
    this.app = getActivity().app;
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)paramView.findViewById(2131366542));
    this.e = ((SwipListView)paramView.findViewById(2131379033));
    this.gx = ((LinearLayout)paramView.findViewById(2131370770));
    this.bI = ((TextView)paramView.findViewById(2131366438));
    this.ah = ((ImageButton)paramView.findViewById(2131368696));
    paramView.findViewById(2131377858).setFocusable(true);
    paramView.findViewById(2131377858).setFocusableInTouchMode(true);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(true);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusableInTouchMode(true);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(acfp.m(2131714122));
    this.e.setDragEnable(true);
    this.e.setRightIconMenuListener(this.jdField_b_of_type_ComTencentWidgetSwipListView$a);
    this.e.setOnTouchListener(new vsz(this));
    this.jdField_a_of_type_Abfm = new abfm(getActivity(), this.app, this.e, 10, this.jdField_a_of_type_Abex$c);
    int i = getResources().getDimensionPixelSize(2131297808);
    this.jdField_a_of_type_Abfm.GY(i);
    this.jdField_a_of_type_Achg = ((achg)this.app.getManager(159));
    ArrayList localArrayList = this.jdField_a_of_type_Achg.cw();
    if (!anwa.aze()) {
      if (localArrayList.size() > 0)
      {
        this.jdField_a_of_type_Abfm.gJ(localArrayList);
        this.bI.setVisibility(8);
      }
    }
    for (;;)
    {
      this.ah.setOnClickListener(new vta(this));
      if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
        paramView.findViewById(2131381455).setBackgroundColor(Color.parseColor("#292929"));
      }
      return;
      this.bI.setVisibility(0);
      this.jdField_a_of_type_Achg.iu(4);
      continue;
      this.bI.setVisibility(0);
      QLog.d("SearchMightKnowFragment", 2, " STUDY MODE NO RECOMMEND FRIEND");
    }
  }
  
  private void ww(String paramString)
  {
    anot.a(null, "dc00898", "", "", "0X800A338", "0X800A338", 0, 0, "", "", "", "");
    ActiveEntitySearchActivity.a(getActivity(), paramString, acfp.m(2131714121), new long[] { 1001L, 1002L });
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.length() == 0)
    {
      this.ah.setVisibility(4);
      return;
    }
    this.ah.setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void gR()
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
    this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131563295, paramViewGroup, false);
    cM(paramLayoutInflater);
    u(paramLayoutInflater);
    anot.a(null, "dc00898", "", "", "0X800A337", "0X800A337", 0, 0, "", "", "", "");
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Abfm != null) {
      this.jdField_a_of_type_Abfm.destroy();
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 3)
    {
      paramTextView = this.jdField_b_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
      gR();
      if ((paramTextView != null) && (!paramTextView.equals(""))) {
        ww(paramTextView);
      }
      return true;
    }
    return false;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Abfm != null) {
      this.jdField_a_of_type_Abfm.cli();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Abfm != null) {
      this.jdField_a_of_type_Abfm.onResume();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchMightKnowFragment
 * JD-Core Version:    0.7.0.1
 */