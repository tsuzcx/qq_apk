package com.tencent.mobileqq.search.activity;

import amlc;
import ampx;
import android.content.Context;
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
import com.tencent.mobileqq.search.fragment.AddFilesSearchFragment;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class AddFilesSearchActivity
  extends BaseSearchActivity
  implements GestureDetector.OnGestureListener, View.OnClickListener
{
  static List<ampx> Bs;
  protected static int mFromType = 34;
  List<ampx> Bt;
  protected View GQ;
  private TextView YA;
  private TextView YB;
  private TextView YC;
  private TextView YD;
  String avs;
  byte[] fo;
  
  public static void a(Context paramContext, String paramString, List<ampx> paramList, int paramInt, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent(paramContext, AddFilesSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt);
    localIntent.putExtra("dirKey", paramArrayOfByte);
    Bs = paramList;
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    AddFilesSearchFragment localAddFilesSearchFragment = new AddFilesSearchFragment();
    localAddFilesSearchFragment.a(mFromType, this.fo, this.avs, Bs);
    return localAddFilesSearchFragment;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    paramEditable = this.b.getText().toString().trim();
    if (this.GQ != null)
    {
      if ((TextUtils.isEmpty(paramEditable)) && (mFromType == 34)) {
        this.GQ.setVisibility(0);
      }
    }
    else {
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
    Intent localIntent = getIntent();
    mFromType = localIntent.getIntExtra("fromType", 34);
    this.fo = ((byte[])localIntent.getByteArrayExtra("dirKey"));
    this.avs = getIntent().getStringExtra("keyword");
    this.Bt = new ArrayList();
    if (Bs != null) {
      this.Bt.addAll(Bs);
    }
    Bs = null;
    if ((mFromType == 36) || (mFromType == 46) || (mFromType == 47) || (mFromType == 48)) {
      this.cDh = true;
    }
    super.doOnCreate(paramBundle);
    initView();
    return true;
  }
  
  protected int getLayoutId()
  {
    return 2131558535;
  }
  
  void initView()
  {
    this.GQ = findViewById(2131368280);
    GestureDetector localGestureDetector = new GestureDetector(this, this);
    this.GQ.setOnTouchListener(new amlc(this, localGestureDetector));
    if ((mFromType == 34) && ((this.Bt == null) || (this.Bt.isEmpty()))) {
      this.GQ.setVisibility(0);
    }
    for (;;)
    {
      this.YA = ((TextView)findViewById(2131368243));
      this.YB = ((TextView)findViewById(2131368279));
      this.YC = ((TextView)findViewById(2131368263));
      this.YD = ((TextView)findViewById(2131368283));
      this.YA.setOnClickListener(this);
      this.YB.setOnClickListener(this);
      this.YC.setOnClickListener(this);
      this.YD.setOnClickListener(this);
      this.Dt.setVisibility(8);
      return;
      this.GQ.setVisibility(8);
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
      AddFilesByTypeSearchActivity.a(this, null, 38, this.fo);
      QLog.i("AddFilesSearchActivity", 2, "guide_file");
      continue;
      QLog.i("AddFilesSearchActivity", 2, "guide_file");
      AddFilesByTypeSearchActivity.a(this, null, 39, this.fo);
      continue;
      AddFilesByTypeSearchActivity.a(this, null, 40, this.fo);
      QLog.i("AddFilesSearchActivity", 2, "guide_pic");
      continue;
      QLog.i("AddFilesSearchActivity", 2, "guide_zip");
      AddFilesByTypeSearchActivity.a(this, null, 41, this.fo);
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
    return "搜索文件";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.AddFilesSearchActivity
 * JD-Core Version:    0.7.0.1
 */