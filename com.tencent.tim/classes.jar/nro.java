import android.view.animation.Animation;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;

class nro
  extends auqs.a
{
  nro(nrm paramnrm) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (nrl.a(this.a.this$0) != null)
    {
      paramAnimation = new ArrayList();
      paramAnimation.add(nrl.a(this.a.this$0));
      nrl.a(this.a.this$0).t(paramAnimation, nrl.a(this.a.this$0));
      QQToast.a(this.a.this$0.mActivity, 2, 2131718417, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nro
 * JD-Core Version:    0.7.0.1
 */