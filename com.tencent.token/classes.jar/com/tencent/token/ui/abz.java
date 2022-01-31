package com.tencent.token.ui;

import com.tencent.token.ah;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.LockPatternSmallView;
import com.tencent.token.ui.base.LockPatternView;
import com.tencent.token.ui.base.LockPatternView.DisplayMode;
import com.tencent.token.ui.base.cb;
import java.util.List;

final class abz
  implements cb
{
  abz(StartPwdGestureModifyActivity paramStartPwdGestureModifyActivity) {}
  
  public final void a()
  {
    e.b("RESULT_START");
    StartPwdGestureModifyActivity.access$100(this.a).removeCallbacks(this.a.mClearView);
  }
  
  public final void a(List paramList)
  {
    e.b("Detected: " + StartPwdGestureModifyActivity.access$100(this.a).h());
    if (StartPwdGestureModifyActivity.access$300(this.a) == 1)
    {
      if (paramList.size() < 3)
      {
        StartPwdGestureModifyActivity.access$100(this.a).a(LockPatternView.DisplayMode.Wrong);
        StartPwdGestureModifyActivity.access$400(this.a).a(LockPatternView.DisplayMode.Wrong);
        StartPwdGestureModifyActivity.access$500(this.a, 2131362138, true);
        StartPwdGestureModifyActivity.access$100(this.a).e();
        StartPwdGestureModifyActivity.access$100(this.a).postDelayed(this.a.mClearView, 1000L);
        return;
      }
      StartPwdGestureModifyActivity.access$500(this.a, 2131362137, false);
      StartPwdGestureModifyActivity.access$100(this.a).e();
      StartPwdGestureModifyActivity.access$302(this.a, 2);
      StartPwdGestureModifyActivity.access$602(this.a, StartPwdGestureModifyActivity.access$100(this.a).h());
      StartPwdGestureModifyActivity.access$400(this.a).b = 2;
      StartPwdGestureModifyActivity.access$100(this.a).postDelayed(this.a.mClearView, 1000L);
      return;
    }
    if (!StartPwdGestureModifyActivity.access$100(this.a).h().equals(StartPwdGestureModifyActivity.access$600(this.a)))
    {
      StartPwdGestureModifyActivity.access$100(this.a).a(LockPatternView.DisplayMode.Wrong);
      StartPwdGestureModifyActivity.access$500(this.a, 2131362140, true);
      StartPwdGestureModifyActivity.access$100(this.a).e();
      StartPwdGestureModifyActivity.access$100(this.a).postDelayed(this.a.mClearView, 1000L);
      return;
    }
    StartPwdGestureModifyActivity.access$500(this.a, 2131362141, false);
    StartPwdGestureModifyActivity.access$100(this.a).e();
    StartPwdGestureModifyActivity.access$400(this.a).b = 3;
    StartPwdGestureModifyActivity.access$400(this.a).a(paramList);
    ah.a().c(StartPwdGestureModifyActivity.access$600(this.a));
    StartPwdGestureModifyActivity.access$100(this.a).postDelayed(this.a.mFinishTask, 1000L);
  }
  
  public final void b()
  {
    e.b("CLEARED");
  }
  
  public final void c()
  {
    e.b("CellAdded");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abz
 * JD-Core Version:    0.7.0.1
 */