package com.tencent.mobileqq.search.activity;

import amlg;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.CloudFileGroupSearchFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class CloudFileGroupSearchActivity
  extends BaseSearchActivity
  implements GestureDetector.OnGestureListener, View.OnClickListener
{
  protected static int dCG = 27;
  protected View GQ;
  private TextView YA;
  private TextView YB;
  private TextView YC;
  private TextView YE;
  
  public static void p(Activity paramActivity, String paramString, int paramInt)
  {
    dCG = paramInt;
    Intent localIntent = new Intent(paramActivity, CloudFileGroupSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  protected BaseSearchFragment a()
  {
    getIntent();
    return CloudFileGroupSearchFragment.a(dCG);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    if (TextUtils.isEmpty(this.b.getText().toString().trim()))
    {
      this.GQ.setVisibility(0);
      return;
    }
    this.GQ.setVisibility(8);
  }
  
  protected void diu()
  {
    gR();
    super.diu();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    initView();
    return true;
  }
  
  protected int getLayoutId()
  {
    return 2131558974;
  }
  
  void initView()
  {
    this.Dt.setVisibility(8);
    this.GQ = findViewById(2131368280);
    GestureDetector localGestureDetector = new GestureDetector(this, this);
    this.GQ.setOnTouchListener(new amlg(this, localGestureDetector));
    this.YE = ((TextView)findViewById(2131368261));
    if (this.app.isLoginByWx())
    {
      findViewById(2131368262).setVisibility(8);
      this.YE.setVisibility(8);
    }
    for (;;)
    {
      this.YA = ((TextView)findViewById(2131368243));
      this.YB = ((TextView)findViewById(2131368279));
      this.YC = ((TextView)findViewById(2131368278));
      this.YA.setOnClickListener(this);
      this.YB.setOnClickListener(this);
      this.YC.setOnClickListener(this);
      return;
      this.YE.setOnClickListener(this);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      OnlineFilesSearchActivity.a(this, null, null, 27);
      continue;
      CloudFileByTypeGroupSearchActivity.p(this, null, 28);
      continue;
      CloudFileByTypeGroupSearchActivity.p(this, null, 29);
      continue;
      CloudFileByTypeGroupSearchActivity.p(this, null, 30);
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.b.getWindowToken(), 0);
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    gR();
    return false;
  }
  
  protected String vm()
  {
    return "搜索";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.CloudFileGroupSearchActivity
 * JD-Core Version:    0.7.0.1
 */