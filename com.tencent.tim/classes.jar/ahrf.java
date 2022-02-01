import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class ahrf
  implements View.OnClickListener
{
  ahrf(ahrb paramahrb, String paramString) {}
  
  public void onClick(View paramView)
  {
    HashMap localHashMap = new HashMap();
    tbb.b(localHashMap, this.val$msgId);
    localHashMap.put(Integer.valueOf(2), this.val$msgId);
    localHashMap.put(Integer.valueOf(10), "0");
    tbb.a(abmt.getAppInterface(), "769", "205711", this.a.a().gameAppId, "76905", "1", "160", localHashMap);
    ahrb.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahrf
 * JD-Core Version:    0.7.0.1
 */