import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sbt
  implements View.OnClickListener
{
  sbt(sbq paramsbq) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a() != null)
    {
      CertifiedAccountMeta.StFeed localStFeed = this.a.a().c();
      if (localStFeed == null) {
        break label41;
      }
      this.a.e(localStFeed);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label41:
      QQToast.a(sbq.a(this.a), 1, acfp.m(2131715069), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbt
 * JD-Core Version:    0.7.0.1
 */