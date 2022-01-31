import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;

class yvy
  implements yxz
{
  yvy(yvs paramyvs) {}
  
  public void reportImpression(View paramView)
  {
    paramView = paramView.getTag(2131379211);
    if ((paramView != null) && ((paramView instanceof GdtAd))) {
      yyb.a(((GdtAd)paramView).getUrlForImpression());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yvy
 * JD-Core Version:    0.7.0.1
 */