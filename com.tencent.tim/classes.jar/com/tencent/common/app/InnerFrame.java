package com.tencent.common.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class InnerFrame
  extends FrameLayout
{
  private InnerFrameManager a;
  private QQAppInterface e;
  private Activity mActivity;
  
  public InnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public InnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public InnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public InnerFrameManager a()
  {
    return this.a;
  }
  
  public QQAppInterface b()
  {
    return this.e;
  }
  
  protected void bBy() {}
  
  public void be(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "onStart");
    }
  }
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "onCreate");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "onDestroy");
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "onPause");
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "onResume");
    }
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "onStop");
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "setActivity");
    }
    this.mActivity = paramActivity;
  }
  
  public void setAppIntf(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerFrame", 2, "setAppIntf");
    }
    this.e = paramQQAppInterface;
    bBy();
  }
  
  public void setContentView(int paramInt)
  {
    setContentView(LayoutInflater.from(this.mActivity).inflate(paramInt, this, false));
  }
  
  public void setContentView(View paramView)
  {
    if (getChildCount() > 0) {
      removeAllViews();
    }
    addView(paramView);
  }
  
  public void setInnerFrameManager(InnerFrameManager paramInnerFrameManager)
  {
    this.a = paramInnerFrameManager;
  }
  
  public void startActivity(Intent paramIntent)
  {
    startActivityForResult(paramIntent, 0);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.mActivity.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.common.app.InnerFrame
 * JD-Core Version:    0.7.0.1
 */