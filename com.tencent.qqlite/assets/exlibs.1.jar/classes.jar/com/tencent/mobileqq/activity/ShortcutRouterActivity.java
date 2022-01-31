package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import bjq;
import bjr;
import bjs;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;

public class ShortcutRouterActivity
  extends BaseActivity
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int b = 1;
  private static final int c = 2;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new bjs(this);
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback;
  
  private int a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uintype", -1);
    String str = paramIntent.getStringExtra("uin");
    if ((i == -1) || (str == null)) {
      return 1;
    }
    if (paramIntent.getBooleanExtra("isTroopCard", false)) {
      return 0;
    }
    if (!((FriendManager)this.app.getManager(8)).b(str)) {
      return 2;
    }
    return 0;
  }
  
  private void c()
  {
    String str = getAppRuntime().getAccount();
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setGravity(17);
    localTextView.setTextSize(getResources().getInteger(2131558400));
    localTextView.setTextColor(getResources().getColor(2131427332));
    if (TextUtils.isEmpty(str)) {
      localTextView.setText("当前帐号没有添加该联系人，无法与他聊天。");
    }
    for (;;)
    {
      localQQCustomDialog.setNegativeButton(2131363666, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      localQQCustomDialog.addView(localTextView);
      localQQCustomDialog.setOnDismissListener(new bjr(this));
      if (!isFinishing()) {
        localQQCustomDialog.show();
      }
      return;
      localTextView.setText("当前帐号（" + str + "）没有添加该联系人，无法与他聊天。");
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(67371008);
      paramBundle.putExtra("shortcut_jump_key", getIntent());
      startActivity(paramBundle);
      finish();
      return false;
    }
    String str1 = paramBundle.getStringExtra("shotcut_forward");
    String str2 = paramBundle.getStringExtra("forward");
    if (!TextUtils.isEmpty(str1))
    {
      if ((!TextUtils.isEmpty(str2)) && (str2.equals("starClub")) && (str1.equals(ChatActivity.class.getName())))
      {
        QQToast.a(this, getString(2131362928), 0).b(getTitleBarHeight());
        finish();
        return true;
      }
      switch (a(paramBundle))
      {
      default: 
        if (str1.equals(ChatActivity.class.getName()))
        {
          paramBundle.setClassName(this, str1);
          paramBundle.putExtra("entrance", 4);
          startActivity(paramBundle);
          finish();
        }
        break;
      }
    }
    for (;;)
    {
      return true;
      QQToast.a(this, getString(2131362928), 0).b(getTitleBarHeight());
      finish();
      return true;
      c();
      return true;
      paramBundle.getStringExtra("uin");
      paramBundle.getStringExtra("uinname");
      paramBundle.getIntExtra("uintype", 0);
      paramBundle.getStringExtra("extraUin");
      if (this.jdField_a_of_type_AndroidOsHandler$Callback == null) {
        this.jdField_a_of_type_AndroidOsHandler$Callback = new bjq(this);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  protected void onStop()
  {
    super.onStop();
    finish();
  }
  
  public boolean showPreview()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShortcutRouterActivity
 * JD-Core Version:    0.7.0.1
 */