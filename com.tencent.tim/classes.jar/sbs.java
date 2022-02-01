import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sbs
  implements View.OnClickListener
{
  sbs(sbq paramsbq) {}
  
  public void onClick(View paramView)
  {
    if (!sat.qH())
    {
      CertifiedAccountMeta.StFeed localStFeed = sbq.a(this.a);
      if (localStFeed != null)
      {
        this.a.e(localStFeed);
        if (this.a.a() != null) {
          this.a.a().i(localStFeed);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbs
 * JD-Core Version:    0.7.0.1
 */