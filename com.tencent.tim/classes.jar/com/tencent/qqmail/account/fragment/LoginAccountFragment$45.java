package com.tencent.qqmail.account.fragment;

import android.content.Intent;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import moai.fragment.app.FragmentActivity;
import org.apache.commons.lang3.StringUtils;

class LoginAccountFragment$45
  implements Runnable
{
  LoginAccountFragment$45(LoginAccountFragment paramLoginAccountFragment, String paramString, AccountType paramAccountType) {}
  
  public void run()
  {
    Object localObject = (Intent)this.this$0.getActivity().getIntent().getParcelableExtra("arg_goto_intent");
    if ((localObject != null) && (StringUtils.equals(((Intent)localObject).getStringExtra("arg_from"), "from_launch_compose")))
    {
      ((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setMessage(2131720174).addAction(2131696547, new LoginAccountFragment.45.1(this))).create().show();
      return;
    }
    localObject = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0.getActivity()).setTitle(2131696424)).setMessage(this.val$msg).addAction(2131691246, new LoginAccountFragment.45.3(this))).addAction(2131721664, new LoginAccountFragment.45.2(this))).create();
    ((QMUIDialog)localObject).setOnDismissListener(new LoginAccountFragment.45.4(this));
    ((QMUIDialog)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment.45
 * JD-Core Version:    0.7.0.1
 */