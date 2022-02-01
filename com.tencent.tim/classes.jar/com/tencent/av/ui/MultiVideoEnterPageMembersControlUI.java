package com.tencent.av.ui;

import acfp;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.BaseActivity;

public class MultiVideoEnterPageMembersControlUI
  extends MultiMembersVideoUI
{
  public static int awK = 1;
  public static int awL = 2;
  Button bk = null;
  Button bm = null;
  View gk;
  TextView mM = null;
  int mMode = awL;
  TextView mP = null;
  ProgressBar mProgressBar = null;
  TextView mQ = null;
  
  public MultiVideoEnterPageMembersControlUI(Context paramContext)
  {
    super(paramContext);
    initUI(paramContext);
  }
  
  @TargetApi(9)
  public MultiVideoEnterPageMembersControlUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext);
    initUI(paramContext);
  }
  
  public void bC(ArrayList<VideoController.b> paramArrayList)
  {
    super.bC(paramArrayList);
    refreshUI();
  }
  
  @TargetApi(9)
  void initUI(Context paramContext)
  {
    this.mContext = new WeakReference(paramContext);
    BaseActivity localBaseActivity = (BaseActivity)this.mContext.get();
    if (localBaseActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get activity");
      }
      return;
    }
    this.mApp = ((VideoAppInterface)localBaseActivity.getAppRuntime());
    if (this.mApp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get AppRuntime");
      }
      localBaseActivity.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get videoControl");
      }
      localBaseActivity.finish();
      return;
    }
    this.jdField_d_of_type_AndroidViewLayoutInflater = LayoutInflater.from((Context)this.mContext.get());
    LayoutInflater.from(paramContext).inflate(2131559938, this);
    this.mRootView = this;
    this.jdField_d_of_type_AndroidWidgetGridView = ((GridView)super.findViewById(2131372146));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)super.findViewById(2131372144));
    this.mP = ((TextView)super.findViewById(2131374005));
    this.mQ = ((TextView)super.findViewById(2131374004));
    this.gk = super.findViewById(2131373999);
    this.bk = ((Button)super.findViewById(2131374003));
    this.bm = ((Button)super.findViewById(2131373996));
    this.jdField_d_of_type_AndroidWidgetGridView.setNumColumns(-1);
    this.jdField_d_of_type_AndroidWidgetGridView.setGravity(17);
    this.jdField_d_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_d_of_type_AndroidWidgetGridView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI$a = new MultiMembersVideoUI.a(this);
    this.jdField_d_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI$a);
    this.jdField_d_of_type_AndroidWidgetGridView.setOnItemClickListener(this.mItemClickListener);
    this.jdField_d_of_type_AndroidWidgetGridView.setOnTouchListener(this.f);
    this.mM = ((TextView)super.findViewById(2131374002));
    this.mProgressBar = ((ProgressBar)super.findViewById(2131374000));
    this.mProgressBar.setVisibility(0);
  }
  
  void refreshUI()
  {
    if (this.mMode == awK)
    {
      i = this.iG.size();
      if (i > 0)
      {
        this.mP.setText(String.format(acfp.m(2131708592), new Object[] { Integer.valueOf(i) }));
        this.mQ.setText(acfp.m(2131708594));
        this.bk.setText(acfp.m(2131708591));
      }
    }
    while (this.mMode != awL) {
      for (;;)
      {
        return;
        this.mP.setText(acfp.m(2131708589));
      }
    }
    int i = this.iG.size();
    if (i > 0) {
      this.mP.setText(String.format(getResources().getString(2131697870), new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      this.mQ.setText(2131697867);
      this.bk.setText(2131697865);
      return;
      this.mP.setText(2131697560);
    }
  }
  
  public void setLowHeightMode()
  {
    float f = super.getResources().getDisplayMetrics().density;
    if (super.getResources().getDisplayMetrics().heightPixels / f < 600.0F)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mP.getLayoutParams();
      localLayoutParams.setMargins(0, (int)(10.0F * f), 0, 0);
      this.mP.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.mQ.getLayoutParams();
      localLayoutParams.setMargins(0, (int)(4.0F * f), 0, 0);
      this.mQ.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getLayoutParams();
      localLayoutParams.setMargins(0, (int)(10.0F * f), 0, 0);
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.bk.getLayoutParams();
      localLayoutParams.setMargins(0, (int)(10.0F * f), 0, (int)(20.0F * f));
      this.bk.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.bm.getLayoutParams();
      localLayoutParams.setMargins(0, (int)(10.0F * f), 0, (int)(f * 20.0F));
      this.bm.setLayoutParams(localLayoutParams);
    }
  }
  
  void setMode(int paramInt)
  {
    this.mMode = paramInt;
    refreshUI();
    if (this.mMode == awK)
    {
      localDrawable = super.getResources().getDrawable(2130843031);
      paramInt = (int)(super.getResources().getDisplayMetrics().density * 20.0F);
      localDrawable.setBounds(0, 0, paramInt, paramInt);
      this.mP.setCompoundDrawables(localDrawable, null, null, null);
    }
    while (this.mMode != awL) {
      return;
    }
    Drawable localDrawable = super.getResources().getDrawable(2130843032);
    paramInt = (int)(super.getResources().getDisplayMetrics().density * 20.0F);
    localDrawable.setBounds(0, 0, paramInt, paramInt);
    this.mP.setCompoundDrawables(localDrawable, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageMembersControlUI
 * JD-Core Version:    0.7.0.1
 */