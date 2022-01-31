import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;

class ywb
  implements yyc
{
  ywb(yvv paramyvv) {}
  
  public void reportImpression(View paramView)
  {
    paramView = paramView.getTag(2131379206);
    if ((paramView != null) && ((paramView instanceof GdtAd))) {
      yye.a(((GdtAd)paramView).getUrlForImpression());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywb
 * JD-Core Version:    0.7.0.1
 */