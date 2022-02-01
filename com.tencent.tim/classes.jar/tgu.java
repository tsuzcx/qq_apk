import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtReporter;

class tgu
  implements tld.a
{
  tgu(tgq paramtgq) {}
  
  public void reportImpression(View paramView)
  {
    paramView = paramView.getTag(2131381958);
    if ((paramView != null) && ((paramView instanceof GdtAd))) {
      GdtReporter.doCgiReport(((GdtAd)paramView).getUrlForImpression());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tgu
 * JD-Core Version:    0.7.0.1
 */