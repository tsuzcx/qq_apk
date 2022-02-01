package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import yzo.a;
import yzt;

public abstract class ContactsBaseFragment
  extends ReportV4Fragment
  implements AbsListView.e, yzo.a
{
  public static Rect bq;
  protected a a;
  public b b;
  public boolean bqb;
  private int cbX;
  public BaseActivity mActivity;
  public QQAppInterface mApp;
  protected View mContentView;
  private int mPos;
  public boolean mk;
  
  public abstract void Av(boolean paramBoolean);
  
  public abstract void Aw(boolean paramBoolean);
  
  public void Bi(boolean paramBoolean) {}
  
  public void EQ(int paramInt)
  {
    this.cbX = paramInt;
  }
  
  protected abstract View a(LayoutInflater paramLayoutInflater, Bundle paramBundle);
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void a(b paramb)
  {
    this.b = paramb;
  }
  
  public void bMe()
  {
    bpN();
  }
  
  public void bMf() {}
  
  protected abstract void bpM();
  
  protected abstract void bpN();
  
  public abstract void doOnDestroy();
  
  public View e()
  {
    return this.mContentView;
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + xZ() + " onAttach");
    }
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + xZ() + " onCreate");
    }
    super.onCreate(paramBundle);
  }
  
  @TargetApi(16)
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + xZ() + " onCreateView");
    }
    this.mContentView = a(paramLayoutInflater, paramBundle);
    paramLayoutInflater = e();
    if ((paramLayoutInflater != null) && (Build.VERSION.SDK_INT >= 14)) {
      paramLayoutInflater.setAccessibilityDelegate(new yzt(this));
    }
    if ((this.mContentView != null) && (this.bqb))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Contacts.BaseFragment", 2, "onCreateView->doOnResume");
      }
      this.bqb = false;
      Av(true);
    }
    paramLayoutInflater = this.mContentView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + xZ() + " onDestroy");
    }
    super.onDestroy();
    this.mContentView = null;
    this.bqb = false;
    if (this.a != null) {
      this.a.ER(this.cbX);
    }
  }
  
  public void onDestroyView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + xZ() + " onDestroyView");
    }
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.BaseFragment", 2, "pos:" + xZ() + " onDetach");
    }
    super.onDetach();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      return;
      if (paramInt != 0) {
        ApngImage.pauseByTag(3);
      }
    } while (paramInt != 0);
    ApngImage.playByTag(3);
  }
  
  public void pH(boolean paramBoolean)
  {
    this.mk = paramBoolean;
    this.bqb = paramBoolean;
    if (this.mContentView != null)
    {
      if (paramBoolean) {
        Av(true);
      }
    }
    else {
      return;
    }
    Aw(true);
  }
  
  public abstract void refresh();
  
  public abstract void resetData();
  
  public void setActivity(BaseActivity paramBaseActivity)
  {
    this.mActivity = paramBaseActivity;
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    bpM();
  }
  
  public void setPos(int paramInt)
  {
    this.mPos = paramInt;
  }
  
  public int xY()
  {
    return this.cbX;
  }
  
  public int xZ()
  {
    return this.mPos;
  }
  
  public static abstract interface a
  {
    public abstract void ER(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void ckJ();
    
    public abstract void d(int paramInt, boolean paramBoolean, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
 * JD-Core Version:    0.7.0.1
 */