package com.tencent.mobileqq.activity;

import akwp;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import vsg;

public class RegisterVerifyCodeActivity$5
  implements Runnable
{
  public void run()
  {
    if (this.val$data == null) {}
    boolean bool1;
    boolean bool2;
    String str1;
    String str2;
    do
    {
      return;
      bool1 = this.val$data.getBoolean("visibility", false);
      localObject = this.val$data.getString("enableVersion");
      bool2 = this.val$data.getBoolean("checked", false);
      str1 = this.val$data.getString("openDevLockText");
      str2 = this.val$data.getString("openDevLockHelpText");
      RegisterVerifyCodeActivity.e(this.this$0, this.val$data.getString("openDevLockHelpURL"));
    } while ((!bool1) || (TextUtils.isEmpty(str1)) || (RegisterVerifyCodeActivity.a(this.this$0, "3.4.4", (String)localObject) < 0));
    if (QLog.isColorLevel()) {
      QLog.d("RegisterVerifyCodeActivity", 2, "update ui.");
    }
    if ((bool2) && (RegisterVerifyCodeActivity.a(this.this$0) != null)) {
      RegisterVerifyCodeActivity.a(this.this$0).setChecked(bool2);
    }
    Object localObject = SpannableString.valueOf(str1);
    if (!TextUtils.isEmpty(str2))
    {
      vsg localvsg = new vsg(this, str1);
      int i = str1.indexOf(str2);
      ((SpannableString)localObject).setSpan(localvsg, i, str2.length() + i, 33);
    }
    RegisterVerifyCodeActivity.b(this.this$0).setText((CharSequence)localObject);
    RegisterVerifyCodeActivity.a(this.this$0).setContentDescription((CharSequence)localObject);
    RegisterVerifyCodeActivity.b(this.this$0).setMovementMethod(LinkMovementMethod.getInstance());
    if (RegisterVerifyCodeActivity.a(this.this$0) != null) {
      RegisterVerifyCodeActivity.a(this.this$0).setVisibility(0);
    }
    if (this.this$0.getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false))
    {
      RegisterVerifyCodeActivity.a(this.this$0).setChecked(akwp.a().cuJ);
      RegisterVerifyCodeActivity.a(this.this$0).setEnabled(false);
      return;
    }
    akwp.a().cuJ = bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity.5
 * JD-Core Version:    0.7.0.1
 */