package com.tencent.biz.ui;

import aeay;
import android.annotation.TargetApi;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import auup;
import com.tencent.biz.pubaccount.util.PublicAccountCompactSwipeBackLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;

@TargetApi(9)
public class CustomScrollView
  extends RelativeLayout
  implements TouchWebView.OnOverScrollHandler
{
  private auup jdField_a_of_type_Auup;
  private PublicAccountCompactSwipeBackLayout jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout;
  DisplayMetrics displayMetrics;
  private boolean isEnabled = true;
  public MutableLiveData<Integer> z = new MutableLiveData();
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
  }
  
  public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext, paramAttributeSet);
  }
  
  protected boolean Nd()
  {
    return true;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout.a(paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(0);
    }
    this.jdField_a_of_type_Auup = new auup(getContext());
    try
    {
      this.displayMetrics = new DisplayMetrics();
      ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.displayMetrics);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public void cD(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomScrollView", 2, " springBack y:" + paramInt);
    }
    if (this.jdField_a_of_type_Auup.springBack(getScrollX(), getScrollY(), 0, 0, -paramInt, 0)) {
      invalidate();
    }
  }
  
  public void computeScroll()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomScrollView", 2, " computeScroll:");
    }
    if ((this.jdField_a_of_type_Auup != null) && (this.jdField_a_of_type_Auup.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.jdField_a_of_type_Auup.getCurrX();
      int m = this.jdField_a_of_type_Auup.getCurrY();
      if (((i != k) || (j != m)) && (Build.VERSION.SDK_INT >= 9)) {
        overScrollBy(k - i, m - j, i, j, 0, 0, 0, 5000, false);
      }
      postInvalidate();
    }
  }
  
  public void onBack()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomScrollView", 2, "onBack:");
    }
    if (this.jdField_a_of_type_Auup.springBack(getScrollX(), getScrollY(), 0, 0, 0, 0)) {
      invalidate();
    }
  }
  
  public void onOverScroll(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomScrollView", 2, " onOverScroll y:" + paramInt);
    }
    if ((this.isEnabled) && (Build.VERSION.SDK_INT >= 9))
    {
      if (getScrollY() + paramInt <= 0) {
        break label91;
      }
      paramInt = -getScrollY();
    }
    label91:
    for (;;)
    {
      if (Nd()) {
        overScrollBy(0, paramInt, getScrollX(), getScrollY(), 0, 0, 0, 5000, true);
      }
      return;
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomScrollView", 2, " onOverScrolled");
    }
    this.z.postValue(Integer.valueOf(paramInt2));
    if (!this.jdField_a_of_type_Auup.isFinished())
    {
      super.scrollTo(paramInt1, paramInt2);
      if ((paramBoolean1) || (paramBoolean2)) {
        this.jdField_a_of_type_Auup.springBack(getScrollX(), getScrollY(), 0, 0, 0, 0);
      }
    }
    for (;;)
    {
      awakenScrollBars();
      return;
      super.scrollTo(paramInt1, paramInt2);
    }
  }
  
  public void pa(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout.pa(paramString);
    }
  }
  
  public void qu(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout.qu(paramBoolean);
    }
  }
  
  public void qv(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout.qv(paramBoolean);
    }
  }
  
  public void setOnFlingGesture(a parama)
  {
    if ((parama instanceof WebViewFragment))
    {
      Object localObject = ((WebViewFragment)parama).getActivity();
      if ((localObject != null) && ((localObject instanceof QQBrowserActivity)))
      {
        localObject = ((QQBrowserActivity)localObject).getColorNoteController();
        if (localObject != null)
        {
          localObject = ((aeay)localObject).a();
          if ((localObject instanceof PublicAccountCompactSwipeBackLayout)) {
            this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout = ((PublicAccountCompactSwipeBackLayout)localObject);
          }
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountCompactSwipeBackLayout.setWebViewFragment((WebViewFragment)parama);
        }
      }
    }
  }
  
  public void uW(boolean paramBoolean)
  {
    this.isEnabled = paramBoolean;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.ui.CustomScrollView
 * JD-Core Version:    0.7.0.1
 */