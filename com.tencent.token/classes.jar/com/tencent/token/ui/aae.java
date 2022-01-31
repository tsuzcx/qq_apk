package com.tencent.token.ui;

import com.tencent.token.cy;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.LockPatternSmallView;
import com.tencent.token.ui.base.LockPatternView;
import com.tencent.token.ui.base.LockPatternView.DisplayMode;
import com.tencent.token.ui.base.bu;
import java.util.List;

class aae
  implements bu
{
  aae(StartPwdGestureModifyActivity paramStartPwdGestureModifyActivity) {}
  
  public void a()
  {
    h.b("RESULT_START");
    StartPwdGestureModifyActivity.access$300(this.a).removeCallbacks(this.a.mClearView);
  }
  
  public void a(List paramList)
  {
    h.b("CellAdded");
  }
  
  public void b()
  {
    h.b("CLEARED");
  }
  
  public void b(List paramList)
  {
    h.b("Detected: " + StartPwdGestureModifyActivity.access$300(this.a).getPatternString());
    if (StartPwdGestureModifyActivity.access$600(this.a) == 1)
    {
      if (paramList.size() < 3)
      {
        StartPwdGestureModifyActivity.access$300(this.a).setDisplayMode(LockPatternView.DisplayMode.Wrong);
        StartPwdGestureModifyActivity.access$700(this.a).setDisplayMode(LockPatternView.DisplayMode.Wrong);
        StartPwdGestureModifyActivity.access$800(this.a, 2131231111, true);
        StartPwdGestureModifyActivity.access$300(this.a).b();
        StartPwdGestureModifyActivity.access$300(this.a).postDelayed(this.a.mClearView, 1000L);
        return;
      }
      StartPwdGestureModifyActivity.access$800(this.a, 2131231105, false);
      StartPwdGestureModifyActivity.access$300(this.a).b();
      StartPwdGestureModifyActivity.access$602(this.a, 2);
      StartPwdGestureModifyActivity.access$902(this.a, StartPwdGestureModifyActivity.access$300(this.a).getPatternString());
      StartPwdGestureModifyActivity.access$700(this.a).b = 2;
      StartPwdGestureModifyActivity.access$300(this.a).postDelayed(this.a.mClearView, 1000L);
      return;
    }
    if (!StartPwdGestureModifyActivity.access$300(this.a).getPatternString().equals(StartPwdGestureModifyActivity.access$900(this.a)))
    {
      StartPwdGestureModifyActivity.access$300(this.a).setDisplayMode(LockPatternView.DisplayMode.Wrong);
      StartPwdGestureModifyActivity.access$800(this.a, 2131231109, true);
      StartPwdGestureModifyActivity.access$300(this.a).b();
      StartPwdGestureModifyActivity.access$300(this.a).postDelayed(this.a.mClearView, 1000L);
      return;
    }
    StartPwdGestureModifyActivity.access$800(this.a, 2131231108, false);
    StartPwdGestureModifyActivity.access$300(this.a).b();
    StartPwdGestureModifyActivity.access$700(this.a).b = 3;
    StartPwdGestureModifyActivity.access$700(this.a).b(paramList);
    cy.a().b(this.a, StartPwdGestureModifyActivity.access$900(this.a));
    StartPwdGestureModifyActivity.access$300(this.a).postDelayed(this.a.mFinishTask, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aae
 * JD-Core Version:    0.7.0.1
 */