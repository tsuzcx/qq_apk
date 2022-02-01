import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

public class mct
  implements View.OnClickListener
{
  public mct(ComponentLastRead paramComponentLastRead) {}
  
  public void onClick(View paramView)
  {
    odv.qx(false);
    kxm.b localb = new kxm.b();
    localb.i().c().f().a(this.this$0.a.a.nh()).g().h().e();
    if (this.this$0.a.a.nh() == 0) {}
    for (;;)
    {
      try
      {
        RefreshData localRefreshData = mfo.b(this.this$0.getContext(), 0);
        if ((localRefreshData == null) || (!localRefreshData.isAD)) {
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
      if (this.this$0.a.b != null) {
        this.this$0.a.b.a(this.this$0, null);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mct
 * JD-Core Version:    0.7.0.1
 */