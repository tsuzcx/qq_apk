import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ztp
  implements View.OnClickListener
{
  ztp(ztn paramztn) {}
  
  public void onClick(View paramView)
  {
    if (!zsl.e())
    {
      CertifiedAccountMeta.StFeed localStFeed = ztn.a(this.a);
      if (localStFeed != null)
      {
        this.a.d(localStFeed);
        if (this.a.a() != null) {
          this.a.a().c(localStFeed);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ztp
 * JD-Core Version:    0.7.0.1
 */