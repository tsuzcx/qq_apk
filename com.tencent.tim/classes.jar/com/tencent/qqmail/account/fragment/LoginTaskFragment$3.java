package com.tencent.qqmail.account.fragment;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

class LoginTaskFragment$3
  implements Runnable
{
  LoginTaskFragment$3(LoginTaskFragment paramLoginTaskFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setTitle(2131695566)).setMessage(this.val$email + "不存在或密码错误，请检查想登录的是否为" + this.val$autoCorrectEmail).addAction(2131696547, new LoginTaskFragment.3.2(this))).addAction("前往QQ登录", new LoginTaskFragment.3.1(this))).create().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginTaskFragment.3
 * JD-Core Version:    0.7.0.1
 */