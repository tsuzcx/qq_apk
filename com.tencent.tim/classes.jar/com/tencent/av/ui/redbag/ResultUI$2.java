package com.tencent.av.ui.redbag;

import com.tencent.av.ui.AVActivity;
import com.tencent.qphone.base.util.QLog;
import iwu;
import jil;
import jim;

public class ResultUI$2
  implements Runnable
{
  public ResultUI$2(jim paramjim) {}
  
  public void run()
  {
    if (this.this$0.Zy)
    {
      QLog.w(this.this$0.TAG, 1, "innerShow 已经显示了");
      return;
    }
    this.this$0.awC();
    AVActivity localAVActivity = this.this$0.getAVActivity();
    if (localAVActivity == null)
    {
      QLog.w(this.this$0.TAG, 1, "innerShow avActivity为空");
      return;
    }
    if (!localAVActivity.vY())
    {
      QLog.w(this.this$0.TAG, 1, "innerShow avActivity不在top, avActivity[" + localAVActivity + "]");
      return;
    }
    QLog.w(this.this$0.TAG, 1, "innerShow, avActivity[" + localAVActivity + "]");
    this.this$0.Zy = true;
    if (this.this$0.b.xw())
    {
      if (this.this$0.b.Zx)
      {
        this.this$0.e(localAVActivity);
        return;
      }
      this.this$0.f(localAVActivity);
      return;
    }
    if (this.this$0.b.xv())
    {
      if (this.this$0.b.Zx)
      {
        this.this$0.e(localAVActivity);
        return;
      }
      this.this$0.d(localAVActivity);
      return;
    }
    if (this.this$0.b.aAk == 3)
    {
      if (this.this$0.b.Zx) {
        iwu.b(this.this$0.mApp, 1045, 2131698034);
      }
      for (;;)
      {
        this.this$0.cH("EXCEPTION_BEFORE_GAME");
        return;
        iwu.b(this.this$0.mApp, 1045, 2131698032);
      }
    }
    if (this.this$0.b.aAk == 4)
    {
      if (this.this$0.b.Zx)
      {
        this.this$0.e(localAVActivity);
        return;
      }
      this.this$0.f(localAVActivity);
      this.this$0.b(localAVActivity, this.this$0.b);
      return;
    }
    if (this.this$0.b.aAk == 6)
    {
      if (this.this$0.b.Zx) {
        iwu.b(this.this$0.mApp, 1045, 2131698035);
      }
      this.this$0.cH("EXCEPTION_NOT_RECEIVE_REDBAG");
      return;
    }
    if (this.this$0.b.aAk == 7)
    {
      if (this.this$0.b.Zx) {
        iwu.b(this.this$0.mApp, 1045, 2131698033);
      }
      this.this$0.cH("EXCEPTION_GAME_TIMEOUT");
      return;
    }
    QLog.w(this.this$0.TAG, 1, "innerShow, 不展示, mHitScore[" + this.this$0.b.aAf + "], mExceptionType[" + this.this$0.b.aAk + "]");
    this.this$0.cH("other");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.redbag.ResultUI.2
 * JD-Core Version:    0.7.0.1
 */