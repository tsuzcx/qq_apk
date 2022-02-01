import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class ldg
  implements View.OnClickListener
{
  public ldg(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (arbt)this.a.a.q(4);
    if ((localObject != null) && (((arbt)localObject).a != null) && (((arbt)localObject).a.isShowing())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReadInJoyAdIMAXBrowserFragment.a(this.a);
      localObject = new HashMap();
      ((HashMap)localObject).put("stat_src", "5");
      jzk.a(new kku.a().a((AppInterface)ReadInJoyAdIMAXBrowserFragment.a(this.a)).a(this.a.getActivity()).a(jzk.aFe).b(jzk.aFP).a(ReadInJoyAdIMAXBrowserFragment.a(this.a)).d(jzk.a((HashMap)localObject)).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ldg
 * JD-Core Version:    0.7.0.1
 */