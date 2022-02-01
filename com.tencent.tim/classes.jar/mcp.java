import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentJump;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;

public class mcp
  implements View.OnClickListener
{
  public mcp(ComponentJump paramComponentJump, articlesummary.PackJumpInfo paramPackJumpInfo) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.str_url.get();
    kxm.aJ(this.b.getContext(), str);
    lkg.av(2, this.a.str_wording.get());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mcp
 * JD-Core Version:    0.7.0.1
 */