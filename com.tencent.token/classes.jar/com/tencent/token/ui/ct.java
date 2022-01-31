package com.tencent.token.ui;

import android.os.Message;
import com.tencent.token.do;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.CopyFaceDialog;

class ct
  extends cb
{
  ct(CopyFaceToOtherUinActivity paramCopyFaceToOtherUinActivity)
  {
    super(paramCopyFaceToOtherUinActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    h.a("facepwd msg.what=" + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      do.a().a(CopyFaceToOtherUinActivity.access$000(this.a));
      new CopyFaceDialog(this.a, 2131362182, CopyFaceToOtherUinActivity.access$100(this.a)).show();
      return;
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, new cu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ct
 * JD-Core Version:    0.7.0.1
 */