import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

class lkj
  implements View.OnClickListener
{
  lkj(lkg paramlkg) {}
  
  public void onClick(View paramView)
  {
    RefreshData localRefreshData = mfo.b(lkg.a(this.a), 0);
    odv.qx(false);
    kxm.b localb = new kxm.b();
    localb.i().c().f().a(lkg.a(this.a).nh()).g().h().e();
    if ((lkg.a(this.a).nh() != 0) || (localRefreshData != null)) {}
    for (;;)
    {
      try
      {
        if (!localRefreshData.isAD) {
          continue;
        }
        i = 1;
        localb.a("ad_page", i);
      }
      catch (JSONException localJSONException)
      {
        int i;
        localJSONException.printStackTrace();
        continue;
      }
      kbp.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, awit.sn("default_feeds_proteus_offline_bid"), "", "", localb.build(), false);
      if (lkg.a(this.a) != null) {
        lkg.a(this.a).onRefresh();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lkj
 * JD-Core Version:    0.7.0.1
 */