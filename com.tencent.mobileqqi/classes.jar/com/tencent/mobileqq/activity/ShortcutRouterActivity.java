package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import doa;
import dob;
import doc;
import mqq.app.AppRuntime;

public class ShortcutRouterActivity
  extends BaseActivity
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int b = 1;
  private static final int c = 2;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new doc(this);
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
    if (!((FriendManager)this.b.getManager(8)).b(str)) {
      return 2;
    }
    return 0;
  }
  
  private void d()
  {
    String str = getAppRuntime().getAccount();
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setGravity(17);
    localTextView.setTextSize(getResources().getInteger(2131492867));
    localTextView.setTextColor(getResources().getColor(2131361800));
    if (TextUtils.isEmpty(str)) {
      localTextView.setText(getString(2131559119));
    }
    for (;;)
    {
      localQQCustomDialog.setNegativeButton(2131562549, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      localQQCustomDialog.addView(localTextView);
      localQQCustomDialog.setOnDismissListener(new dob(this));
      if (!isFinishing()) {
        localQQCustomDialog.show();
      }
      return;
      localTextView.setText(getString(2131559120, new Object[] { str }));
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    super.doOnCreate(paramBundle);
    boolean bool1;
    if (!this.b.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(67371008);
      paramBundle.putExtra("shortcut_jump_key", getIntent());
      startActivity(paramBundle);
      finish();
      bool1 = false;
    }
    String str1;
    String str2;
    int i;
    do
    {
      do
      {
        return bool1;
        paramBundle = getIntent();
        switch (a(paramBundle))
        {
        default: 
          str1 = paramBundle.getStringExtra("shotcut_forward");
          bool1 = bool2;
        }
      } while (TextUtils.isEmpty(str1));
      if (str1.equals(ChatActivity.class.getName()))
      {
        paramBundle.setClassName(this, str1);
        paramBundle.putExtra("entrance", 4);
        startActivity(paramBundle);
        finish();
        return true;
        QQToast.a(this, getString(2131562949), 0).b(d());
        finish();
        return true;
        d();
        return true;
      }
      str1 = paramBundle.getStringExtra("uin");
      str2 = paramBundle.getStringExtra("uinname");
      i = paramBundle.getIntExtra("uintype", 0);
      paramBundle = paramBundle.getStringExtra("extraUin");
      if (this.jdField_a_of_type_AndroidOsHandler$Callback == null) {
        this.jdField_a_of_type_AndroidOsHandler$Callback = new doa(this);
      }
      bool1 = bool2;
    } while (!ChatActivityUtils.a(this.b, this, i, str1, str2, null, true, paramBundle, true, true, this.jdField_a_of_type_AndroidOsHandler$Callback, "from_internal"));
    finish();
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShortcutRouterActivity
 * JD-Core Version:    0.7.0.1
 */