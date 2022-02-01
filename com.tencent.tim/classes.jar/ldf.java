import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class ldf
  implements View.OnClickListener
{
  public ldf(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.biT();
    if (ReadInJoyAdIMAXBrowserFragment.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReadInJoyAdIMAXBrowserFragment.a(this.a, true);
      HashMap localHashMap = new HashMap();
      localHashMap.put("stat_src", "5");
      jzk.a(new kku.a().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(jzk.aFd).b(jzk.aFP).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(jzk.a(localHashMap)).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ldf
 * JD-Core Version:    0.7.0.1
 */