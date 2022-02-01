import android.view.animation.Animation;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;

class thq
  extends bkfi
{
  thq(tho paramtho) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (thn.a(this.a.a) != null)
    {
      paramAnimation = new ArrayList();
      paramAnimation.add(thn.a(this.a.a));
      thn.a(this.a.a).a(paramAnimation, thn.a(this.a.a));
      QQToast.a(this.a.a.a, 2, 2131717030, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     thq
 * JD-Core Version:    0.7.0.1
 */