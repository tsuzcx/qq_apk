package com.tencent.mobileqq.activity.phone;

import acfp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import aqha;
import aqju;
import arhz;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;
import zpp;
import zpq;
import zpr;
import zps;

@SuppressLint({"ViewConstructor"})
public class BaseActivityView
  extends FrameLayout
{
  private TextView MY;
  protected TextView MZ;
  private b jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$b;
  private PhoneInnerFrame jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame;
  private Drawable ad;
  public QQAppInterface app;
  protected TextView centerView;
  public PhoneContactManagerImp f;
  private boolean isFinishing;
  protected TextView leftView;
  public BaseActivity mActivity;
  private View mContentView;
  public arhz progressDialog;
  protected int reqType;
  protected View rootView;
  protected ImageView vv;
  protected View yg;
  
  public BaseActivityView(Context paramContext, int paramInt)
  {
    super(paramContext);
    if ((paramContext instanceof BaseActivity)) {
      this.mActivity = ((BaseActivity)paramContext);
    }
    this.reqType = paramInt;
  }
  
  private void a(a parama)
  {
    this.leftView = parama.f();
    this.MY = parama.M();
    this.yg = parama.aT();
    this.rootView = parama.getRootView();
    this.vv = parama.s();
    this.MZ = parama.L();
    this.centerView = parama.h();
  }
  
  private int getTitleBarHeight()
  {
    return this.yg.getHeight();
  }
  
  protected View E(int paramInt)
  {
    if (this.mContentView != null) {
      return this.mContentView.findViewById(paramInt);
    }
    return findViewById(paramInt);
  }
  
  protected void X(int paramInt, long paramLong)
  {
    if (!isFinishing())
    {
      showToast(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$b.sendEmptyMessageDelayed(2, paramLong);
    }
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$b = new b(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame = paramPhoneInnerFrame;
    paramIntent = paramPhoneInnerFrame.b();
    this.app = paramIntent.getApp();
    this.f = ((PhoneContactManagerImp)this.app.getManager(11));
    a(paramIntent);
  }
  
  protected final void aY(int paramInt, boolean paramBoolean)
  {
    LayoutInflater localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
    if (paramBoolean)
    {
      BounceScrollView localBounceScrollView = (BounceScrollView)localLayoutInflater.inflate(2131558789, null);
      this.mContentView = localLayoutInflater.inflate(paramInt, null);
      localBounceScrollView.addView(this.mContentView);
      addView(localBounceScrollView);
      return;
    }
    localLayoutInflater.inflate(paramInt, this, true);
  }
  
  void aZ(int paramInt, boolean paramBoolean)
  {
    if ((!isFinishing()) && (this.progressDialog == null))
    {
      this.progressDialog = new arhz(getContext(), getTitleBarHeight());
      this.progressDialog.setOnDismissListener(new zpr(this));
      if (paramBoolean) {
        this.progressDialog.setOnKeyListener(new zps(this));
      }
      this.progressDialog.setMessage(paramInt);
      this.progressDialog.setCanceledOnTouchOutside(false);
      this.progressDialog.show();
    }
  }
  
  protected void dV(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      aqha.a(getContext(), 231, paramString1, paramString2, new zpq(this), null).show();
    }
  }
  
  protected void dismissProgressDialog()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$b.removeMessages(1);
    if (this.progressDialog != null)
    {
      this.progressDialog.cancel();
      this.progressDialog = null;
    }
  }
  
  public void finish()
  {
    this.isFinishing = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame.finish();
  }
  
  protected void hf()
  {
    if ((this.centerView != null) && (this.ad == null))
    {
      this.ad = getResources().getDrawable(2130839657);
      this.centerView.setCompoundDrawablePadding(10);
      this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.ad, null, null, null);
      ((Animatable)this.ad).start();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$b.removeMessages(3);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$b.sendEmptyMessageDelayed(3, 120000L);
    }
  }
  
  protected void hg()
  {
    if ((this.centerView != null) && (this.ad != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$b.removeMessages(3);
      ((Animatable)this.ad).stop();
      this.ad = null;
      this.centerView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  protected boolean isFinishing()
  {
    return this.isFinishing;
  }
  
  protected void j(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$b;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localObject = ((b)localObject).obtainMessage(1, paramInt, i);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$b.sendMessageDelayed((Message)localObject, paramLong);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void onDestroy() {}
  
  protected void onPause() {}
  
  protected void onResume() {}
  
  protected void onStart()
  {
    this.leftView.setVisibility(8);
    this.MY.setVisibility(0);
    if (this.reqType == 2)
    {
      this.MZ.setVisibility(0);
      this.MZ.setText(2131721058);
      this.MZ.setContentDescription(acfp.m(2131703046));
      this.vv.setVisibility(8);
    }
    for (;;)
    {
      this.MY.setOnClickListener(new zpp(this));
      this.isFinishing = false;
      return;
      if (this.reqType != 1) {
        if (this.reqType == 0)
        {
          this.MZ.setVisibility(0);
          this.vv.setVisibility(8);
          this.vv.setImageResource(2130841051);
        }
        else if (this.reqType == 5)
        {
          this.MZ.setVisibility(8);
          this.vv.setVisibility(8);
        }
        else
        {
          this.vv.setVisibility(8);
          this.MZ.setVisibility(8);
        }
      }
    }
  }
  
  protected void onStop()
  {
    this.isFinishing = true;
    dismissProgressDialog();
  }
  
  protected final void overridePendingTransition(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame.overridePendingTransition(paramInt1, paramInt2);
  }
  
  protected final void setContentView(int paramInt)
  {
    aY(paramInt, false);
  }
  
  protected void showToast(int paramInt)
  {
    showToast(getResources().getString(paramInt));
  }
  
  protected void showToast(String paramString)
  {
    if (!isFinishing()) {
      QQToast.a(getContext(), 0, paramString, 0).show(getTitleBarHeight());
    }
  }
  
  protected final void startActivity(Intent paramIntent)
  {
    startActivityForResult(paramIntent, 0);
  }
  
  protected final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneInnerFrame.startActivityForResult(paramIntent, paramInt);
  }
  
  public static abstract interface a
  {
    public abstract TextView L();
    
    public abstract TextView M();
    
    public abstract View aT();
    
    public abstract TextView f();
    
    public abstract QQAppInterface getApp();
    
    public abstract View getRootView();
    
    public abstract TextView h();
    
    public abstract ImageView s();
  }
  
  static class b
    extends Handler
  {
    private WeakReference<BaseActivityView> r;
    
    public b(BaseActivityView paramBaseActivityView)
    {
      this.r = new WeakReference(paramBaseActivityView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      BaseActivityView localBaseActivityView = (BaseActivityView)this.r.get();
      if (localBaseActivityView == null) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        throw new RuntimeException("Unknown message: " + paramMessage.what);
      case 1: 
        int i = paramMessage.arg1;
        if (paramMessage.arg2 == 1) {}
        for (;;)
        {
          localBaseActivityView.aZ(i, bool);
          return;
          bool = false;
        }
      case 2: 
        localBaseActivityView.finish();
        return;
      }
      localBaseActivityView.hg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BaseActivityView
 * JD-Core Version:    0.7.0.1
 */