import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.util.QLog;

class ucg
  extends GestureDetector.SimpleOnGestureListener
{
  ucg(ucf paramucf) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if ((paramFloat1 > 0.0F) && (Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (Math.abs(paramFloat1) > 20.0F) && (!this.a.this$0.aQV) && (this.a.rk != null))
    {
      paramMotionEvent1 = this.a.rk.findViewById(2131378161);
      if (paramMotionEvent1 != null)
      {
        if (paramMotionEvent1.getVisibility() == 0) {
          break label446;
        }
        if (AccountManageActivity.a(this.a.this$0) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("AccountManage", 2, "hide previous selectedAccountView");
          }
          paramMotionEvent2 = AccountManageActivity.a(this.a.this$0, AccountManageActivity.a(this.a.this$0));
          if ((paramMotionEvent2 instanceof ShaderAnimLayout)) {
            ((ShaderAnimLayout)paramMotionEvent2).eiX();
          }
          AccountManageActivity.a(this.a.this$0).eiK();
          paramMotionEvent2 = AccountManageActivity.b(this.a.this$0, AccountManageActivity.a(this.a.this$0));
          localLayoutParams = paramMotionEvent2.getLayoutParams();
          if (!this.a.this$0.fk) {
            break label395;
          }
          localLayoutParams.width = ((int)(AccountManageActivity.a(this.a.this$0) - AccountManageActivity.c(this.a.this$0) * 40.0F));
          paramMotionEvent2.setLayoutParams(localLayoutParams);
        }
        if (QLog.isColorLevel()) {
          QLog.i("AccountManage", 2, "show current selectedAccountView");
        }
        ((ShaderAnimLayout)paramMotionEvent1).eiU();
        AccountManageActivity.a(this.a.this$0, (RotateSwitchImageView)this.a.rk.findViewById(2131365700));
        AccountManageActivity.a(this.a.this$0).eiL();
        paramMotionEvent1 = AccountManageActivity.b(this.a.this$0, AccountManageActivity.a(this.a.this$0));
        paramMotionEvent2 = paramMotionEvent1.getLayoutParams();
        if (!this.a.this$0.fk) {
          break label414;
        }
      }
    }
    label395:
    label414:
    for (paramMotionEvent2.width = ((int)(AccountManageActivity.a(this.a.this$0) - 75.0F * AccountManageActivity.d(this.a.this$0)));; paramMotionEvent2.width = ((int)(AccountManageActivity.a(this.a.this$0) - 35.0F * AccountManageActivity.e(this.a.this$0))))
    {
      paramMotionEvent1.setLayoutParams(paramMotionEvent2);
      this.a.this$0.vG(true);
      this.a.this$0.aQV = true;
      this.a.rk.setPressed(false);
      return true;
      localLayoutParams.width = ((int)AccountManageActivity.a(this.a.this$0));
      break;
    }
    label446:
    if (QLog.isColorLevel()) {
      QLog.i("AccountManage", 2, "hide current selectedAccountView");
    }
    ((ShaderAnimLayout)paramMotionEvent1).eiX();
    if (AccountManageActivity.a(this.a.this$0) != null)
    {
      AccountManageActivity.a(this.a.this$0).eiK();
      paramMotionEvent1 = AccountManageActivity.b(this.a.this$0, AccountManageActivity.a(this.a.this$0));
      paramMotionEvent2 = paramMotionEvent1.getLayoutParams();
      if (!this.a.this$0.fk) {
        break label626;
      }
    }
    label626:
    for (paramMotionEvent2.width = ((int)(AccountManageActivity.a(this.a.this$0) - AccountManageActivity.f(this.a.this$0) * 40.0F));; paramMotionEvent2.width = ((int)AccountManageActivity.a(this.a.this$0)))
    {
      paramMotionEvent1.setLayoutParams(paramMotionEvent2);
      AccountManageActivity.a(this.a.this$0, null);
      if (!this.a.this$0.fk) {
        this.a.this$0.vG(false);
      }
      this.a.this$0.aQV = true;
      this.a.rk.setPressed(false);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ucg
 * JD-Core Version:    0.7.0.1
 */