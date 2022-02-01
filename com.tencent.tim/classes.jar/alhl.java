import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.view.VipProfileWZRYView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alhl
  implements View.OnClickListener
{
  public alhl(VipProfileWZRYView paramVipProfileWZRYView, alcn paramalcn) {}
  
  public void onClick(View paramView)
  {
    String str = aqqj.getUrl("gameHonourAddHonour");
    VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.mActivity, str, -1L, null, false, -1);
    VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_into", "0", 1, 0, 0, jqc.hS(), String.valueOf(this.b.d.lCurrentBgId), String.valueOf(this.b.d.lCurrentStyleId));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alhl
 * JD-Core Version:    0.7.0.1
 */