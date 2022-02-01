package com.tencent.mobileqq.activity.phone;

import acfp;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import anot;
import aqha;
import aqju;
import arhz;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;
import zqp;
import zqq;
import zqr;
import zqs;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  private a a;
  public PhoneContactManagerImp f;
  private View mContentView;
  public arhz progressDialog;
  
  void BS(boolean paramBoolean)
  {
    String str3;
    String str1;
    if (!isFinishing())
    {
      anot.a(this.app, "dc00898", "", "", "0X8006AA4", "0X8006AA4", 0, 0, "", "", "", "");
      str3 = getResources().getString(2131696790);
      if (!paramBoolean) {
        break label103;
      }
      str1 = acfp.m(2131705041);
      if (!paramBoolean) {
        break label112;
      }
    }
    label103:
    label112:
    for (String str2 = acfp.m(2131705044);; str2 = acfp.m(2131705042))
    {
      aqha.a(this, 230, str1, str3, acfp.m(2131705043), str2, new zqq(this, paramBoolean), new zqr(this, paramBoolean)).show();
      return;
      str1 = acfp.m(2131705040);
      break;
    }
  }
  
  public boolean VI()
  {
    boolean bool = false;
    if (this.a.hasMessages(1))
    {
      this.a.removeMessages(1);
      bool = true;
    }
    if (this.progressDialog != null)
    {
      this.progressDialog.cancel();
      this.progressDialog.setOnDismissListener(null);
      this.progressDialog = null;
      return true;
    }
    return bool;
  }
  
  public void aL(int paramInt, String paramString)
  {
    if (!isFinishing()) {
      QQToast.a(this, paramInt, paramString, 0).show(getTitleBarHeight());
    }
  }
  
  void aZ(int paramInt, boolean paramBoolean)
  {
    if ((!isFinishing()) && (this.progressDialog == null))
    {
      this.progressDialog = new arhz(this, getTitleBarHeight());
      this.progressDialog.setOnDismissListener(new zqs(this));
      this.progressDialog.setMessage(paramInt);
      this.progressDialog.setCancelable(paramBoolean);
      this.progressDialog.setCanceledOnTouchOutside(false);
      this.progressDialog.show();
    }
  }
  
  public void dV(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      aqha.a(this, 231, paramString1, paramString2, new zqp(this), null).show();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = new a(this);
    this.f = ((PhoneContactManagerImp)this.app.getManager(11));
    return true;
  }
  
  public View findViewById(int paramInt)
  {
    View localView1 = null;
    if (this.mContentView != null) {
      localView1 = this.mContentView.findViewById(paramInt);
    }
    View localView2 = localView1;
    if (localView1 == null) {
      localView2 = super.findViewById(paramInt);
    }
    return localView2;
  }
  
  public void j(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject = ((a)localObject).obtainMessage(1, paramInt, i);
      this.a.sendMessageDelayed((Message)localObject, paramLong);
      return;
    }
  }
  
  public void setContentView(int paramInt)
  {
    this.mContentView = setContentViewB(paramInt);
  }
  
  public String setLastActivityName()
  {
    return null;
  }
  
  public void showToast(int paramInt)
  {
    showToast(getResources().getString(paramInt));
  }
  
  public void showToast(String paramString)
  {
    aL(0, paramString);
  }
  
  static class a
    extends Handler
  {
    private WeakReference<DialogBaseActivity> r;
    
    public a(DialogBaseActivity paramDialogBaseActivity)
    {
      this.r = new WeakReference(paramDialogBaseActivity);
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      DialogBaseActivity localDialogBaseActivity = (DialogBaseActivity)this.r.get();
      if (localDialogBaseActivity == null) {
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
          localDialogBaseActivity.aZ(i, bool);
          return;
          bool = false;
        }
      }
      localDialogBaseActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity
 * JD-Core Version:    0.7.0.1
 */