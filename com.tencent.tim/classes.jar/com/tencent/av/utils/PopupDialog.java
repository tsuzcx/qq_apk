package com.tencent.av.utils;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import aqha;
import aqju;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import ivv;
import jkh;
import jki;
import mqq.app.BaseActivity;

public class PopupDialog
  extends BaseActivity
{
  public static a a = new a();
  boolean ZM = true;
  aqju mDialog = null;
  
  public static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    boolean bool2 = false;
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt1);
    localBundle.putString("titleText", paramString1);
    localBundle.putString("contentText", paramString2);
    localBundle.putInt("leftBtnText", paramInt2);
    localBundle.putInt("rightBtnText", paramInt3);
    if (paramOnClickListener2 != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localBundle.putBoolean("leftBtnVisiable", bool1);
      bool1 = bool2;
      if (paramOnClickListener1 != null) {
        bool1 = true;
      }
      localBundle.putBoolean("rightBtnVisiable", bool1);
      if ((paramOnClickListener1 != null) || (paramOnClickListener2 != null)) {
        localBundle.putParcelable("resultReceiver", new PopupDialog.1(new Handler(), paramOnClickListener2, paramOnClickListener1));
      }
      paramString1 = new Intent();
      paramString1.putExtra("public_fragment_window_feature", 1);
      paramString1.putExtra("request", localBundle);
      paramString1.addFlags(268435456);
      PublicFragmentActivity.b.start(paramContext, paramString1, PublicTransFragmentActivity.class, PopupDialogQQSide.class);
      return;
    }
  }
  
  public static void axr()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "hideCustomDialog");
    }
    a.isShowing = false;
    a locala = a;
    if (a.b != null)
    {
      locala = a;
      a.b.finish();
      locala = a;
      a.b = null;
    }
  }
  
  public static aqju b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    aqju localaqju2;
    try
    {
      if (paramContext != BaseApplicationImpl.getApplication()) {
        localaqju1 = aqha.a(paramContext, 230, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
      }
    }
    catch (Exception localException1)
    {
      aqju localaqju1;
      localaqju2 = null;
    }
    try
    {
      localaqju1.show();
      return localaqju1;
    }
    catch (Exception localException2)
    {
      break label56;
    }
    a(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return null;
    label56:
    a(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return localaqju2;
  }
  
  public static void b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    axr();
    Intent localIntent = new Intent(paramContext, PopupDialog.class);
    localIntent.putExtra("invoke_type", "init");
    localIntent.addFlags(268435456);
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "showCustomDialog");
    }
    a.isShowing = true;
    a.type = paramInt1;
    a.titleText = paramString1;
    a.contentText = paramString2;
    a.aAu = paramInt2;
    a.aAv = paramInt3;
    a.q = paramOnClickListener2;
    a.r = paramOnClickListener1;
    paramContext.startActivity(localIntent);
  }
  
  public static aqju c(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    aqju localaqju2;
    try
    {
      if (paramContext != BaseApplicationImpl.getApplication()) {
        localaqju1 = aqha.a(paramContext, 230, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
      }
    }
    catch (Exception localException1)
    {
      aqju localaqju1;
      localaqju2 = null;
    }
    try
    {
      localaqju1.show();
      return localaqju1;
    }
    catch (Exception localException2)
    {
      break label56;
    }
    b(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return null;
    label56:
    b(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return localaqju2;
  }
  
  private void iA(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    if (this.ZM) {
      ivv.o(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  public static void m(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "changeDialogText");
    }
    Object localObject = a;
    if (a.b != null)
    {
      paramContext = a;
      a.b.bi(paramString1, paramString2);
      return;
    }
    localObject = new Intent(paramContext, PopupDialog.class);
    ((Intent)localObject).putExtra("invoke_type", "changeText");
    ((Intent)localObject).addFlags(268435456);
    a.titleText = paramString1;
    a.contentText = paramString2;
    paramContext.startActivity((Intent)localObject);
  }
  
  void axs()
  {
    Object localObject1 = super.getIntent().getStringExtra("invoke_type");
    if ((TextUtils.equals((CharSequence)localObject1, "reshow")) && (this.mDialog != null)) {
      if (!this.mDialog.isShowing()) {
        this.mDialog.show();
      }
    }
    do
    {
      return;
      if ((!TextUtils.equals((CharSequence)localObject1, "changeText")) || (this.mDialog == null)) {
        break;
      }
      localObject1 = a.titleText;
      localObject2 = a.contentText;
      this.mDialog.setTitle((String)localObject1);
      this.mDialog.setMessage((CharSequence)localObject2);
    } while (this.mDialog.isShowing());
    this.mDialog.show();
    return;
    int k = a.type;
    String str1 = a.titleText;
    String str2 = a.contentText;
    int i = a.aAu;
    int j = a.aAv;
    if (this.mDialog != null)
    {
      this.mDialog.dismiss();
      this.mDialog = null;
    }
    localObject1 = new jkh(this);
    Object localObject2 = new jki(this);
    if ((i == 0) || (a.q == null))
    {
      localObject1 = null;
      i = 2131721737;
    }
    if ((j == 0) || (a.r == null))
    {
      localObject2 = null;
      j = 2131721737;
    }
    this.mDialog = aqha.a(this, k, str1, str2, i, j, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject1);
    this.mDialog.setCancelable(false);
    this.mDialog.show();
  }
  
  void bi(String paramString1, String paramString2)
  {
    a.titleText = paramString1;
    a.contentText = paramString2;
    this.mDialog.setTitle(paramString1);
    this.mDialog.setMessage(paramString2);
    if (!this.mDialog.isShowing()) {
      this.mDialog.show();
    }
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "onCreate");
    }
    getWindow().setBackgroundDrawableResource(2130851773);
    paramBundle = a;
    if (a.b != null)
    {
      paramBundle = a;
      if (a.b != this)
      {
        paramBundle = a;
        a.b.finish();
      }
    }
    paramBundle = a;
    a.b = this;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "onDestroy");
    }
    if (this.mDialog != null)
    {
      this.mDialog.dismiss();
      this.mDialog = null;
    }
    a locala = a;
    a.b = null;
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    super.setIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "onNewIntent");
    }
    paramIntent = a;
    if (a.b != null)
    {
      paramIntent = a;
      if (a.b != this)
      {
        paramIntent = a;
        a.b.finish();
      }
    }
    paramIntent = a;
    a.b = this;
  }
  
  public void onPause()
  {
    super.onPause();
    iA(false);
  }
  
  public void onResume()
  {
    super.onResume();
    axs();
    a locala = a;
    if (a.b != null)
    {
      locala = a;
      if (a.b != this)
      {
        locala = a;
        a.b.finish();
      }
    }
    locala = a;
    if (a.b != this)
    {
      locala = a;
      a.b = this;
    }
    iA(true);
  }
  
  public static class a
  {
    static PopupDialog b;
    int aAu;
    int aAv;
    String contentText;
    boolean isShowing = false;
    public DialogInterface.OnClickListener q;
    public DialogInterface.OnClickListener r;
    String titleText;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialog
 * JD-Core Version:    0.7.0.1
 */