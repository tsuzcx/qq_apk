package com.tencent.token.utils.bugscanuitl;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.av;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.DualMsgShowDialog;

final class g
  extends Handler
{
  g(DetectActivity paramDetectActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    e.a("dualmsg,what=" + paramMessage.what + ", ret=" + paramMessage.arg1);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((paramMessage.arg1 != 0) || (av.a().b() <= 0));
    try
    {
      new DualMsgShowDialog(this.a, false, 0L).show();
      return;
    }
    catch (Exception paramMessage) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.bugscanuitl.g
 * JD-Core Version:    0.7.0.1
 */