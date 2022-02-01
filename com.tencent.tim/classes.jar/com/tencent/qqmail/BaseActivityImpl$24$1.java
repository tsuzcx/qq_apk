package com.tencent.qqmail;

import android.content.Context;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

class BaseActivityImpl$24$1
  implements Runnable
{
  BaseActivityImpl$24$1(BaseActivityImpl.24 param24, Object paramObject) {}
  
  public void run()
  {
    Object localObject;
    if ((BaseActivityImpl.access$000(this.this$1.this$0) instanceof BaseActivity)) {
      localObject = (BaseActivity)BaseActivityImpl.access$000(this.this$1.this$0);
    }
    for (;;)
    {
      String str = (String)this.val$data;
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder((Context)localObject).setTitle(2131689590)).setMessage("邮件\"" + str + "\"已发送").addAction(2131696547, new BaseActivityImpl.24.1.1(this))).create().show();
      return;
      if ((BaseActivityImpl.access$000(this.this$1.this$0) instanceof QMBaseFragment)) {
        localObject = ((QMBaseFragment)BaseActivityImpl.access$000(this.this$1.this$0)).getActivity();
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.24.1
 * JD-Core Version:    0.7.0.1
 */