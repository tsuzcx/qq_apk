import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.widget.QQToast;

class nrm
  implements nrl.a
{
  nrm(nrl paramnrl) {}
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (paramBoolean)
    {
      nrl.a(this.this$0).a(nrl.a(this.this$0), nrl.a(this.this$0, paramInt), this.this$0.mActivity, "", "", paramString2, "", 0, "");
      return;
    }
    QQToast.a(this.this$0.mActivity, 1, 2131718413, 0).show();
  }
  
  public void w(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (nrl.a(this.this$0) != null)
      {
        paramString = (Animation)nrl.a(this.this$0).getTag(2131370016);
        paramString.setAnimationListener(new nrn(this));
        nrl.a(this.this$0).startAnimation(paramString);
      }
      return;
    }
    QQToast.a(this.this$0.mActivity, 1, 2131718409, 0).show();
  }
  
  public void x(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (nrl.a(this.this$0) != null)
      {
        paramString = (Animation)nrl.a(this.this$0).getTag(2131370016);
        paramString.setAnimationListener(new nro(this));
        nrl.a(this.this$0).startAnimation(paramString);
      }
      return;
    }
    QQToast.a(this.this$0.mActivity, 1, 2131718416, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nrm
 * JD-Core Version:    0.7.0.1
 */