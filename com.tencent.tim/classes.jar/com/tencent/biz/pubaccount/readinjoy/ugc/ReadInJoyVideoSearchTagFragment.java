package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import lcc;
import lce;
import mki;
import mkj;
import mkk;
import mkl;
import mkm;
import mkn;
import mkt;

public class ReadInJoyVideoSearchTagFragment
  extends PublicBaseFragment
{
  private EditText I;
  private ArrayAdapter<TagInfo> a;
  lce g = new mki(this);
  private TextWatcher h = new mkj(this);
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void aPC()
  {
    this.I = ((EditText)getView().findViewById(2131379228));
    this.I.setOnTouchListener(new mkn(this));
    this.I.addTextChangedListener(this.h);
    this.I.requestFocus();
  }
  
  private void aPE()
  {
    this.I.setText("");
  }
  
  private void aPF()
  {
    getView().setOnClickListener(new mkk(this));
  }
  
  private void initCancelButton()
  {
    getView().findViewById(2131364098).setOnClickListener(new mkl(this));
  }
  
  private void initListView()
  {
    ListView localListView = (ListView)getView().findViewById(2131370593);
    View localView = new View(getActivity());
    localView.setBackgroundColor(Color.argb(102, 0, 0, 0));
    localListView.setEmptyView(localView);
    this.a = new ArrayAdapter(getActivity(), 2131560496, new ArrayList());
    localListView.setAdapter(this.a);
    localListView.setOnItemClickListener(new mkm(this, getActivity().getIntent().getBooleanExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", false)));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.getWindow().requestFeature(1);
    paramActivity.getWindow().setSoftInputMode(4);
    paramActivity.overridePendingTransition(2130772077, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560495, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    lcc.a().c(this.g);
  }
  
  public void onFinish()
  {
    getActivity().overridePendingTransition(0, 2130772079);
    super.onFinish();
  }
  
  public void onResume()
  {
    super.onResume();
    mkt.a(this);
    aPC();
    initListView();
    initCancelButton();
    aPF();
    lcc.a().b(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoSearchTagFragment
 * JD-Core Version:    0.7.0.1
 */