package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;
import com.tencent.token.er;

class sv
  implements DialogInterface.OnClickListener
{
  sv(OpreateMsgActivity paramOpreateMsgActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = do.a().e();
    if ((this.a.mIsSelectAll) && (paramDialogInterface != null))
    {
      OpreateMsgActivity.access$200(this.a).a(paramDialogInterface.mUin);
      this.a.hideListEdit();
      if (OpreateMsgActivity.access$200(this.a).g() > 0) {
        break label102;
      }
      this.a.mAdapter.a(null);
      this.a.mTitleButton.setVisibility(4);
    }
    for (;;)
    {
      this.a.mAdapter.a(false);
      return;
      OpreateMsgActivity.access$200(this.a).f();
      break;
      label102:
      this.a.mTitleButton.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sv
 * JD-Core Version:    0.7.0.1
 */