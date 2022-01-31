import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;

class ytk
  implements yyc
{
  ytk(ytg paramytg) {}
  
  public void reportImpression(View paramView)
  {
    paramView = paramView.getTag(2131379206);
    if ((paramView != null) && ((paramView instanceof GdtAd))) {
      yye.a(((GdtAd)paramView).getUrlForImpression());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ytk
 * JD-Core Version:    0.7.0.1
 */