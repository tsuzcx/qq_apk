import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class ngd
  implements View.OnClickListener
{
  public ngd(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyListViewGroup.b(this.this$0);
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)kxm.getAppRuntime().getManager(162)).a();
    if ((localKandianMsgBoxRedPntInfo != null) && (localKandianMsgBoxRedPntInfo.isFromNotification)) {
      kxm.a(this.this$0.getContext(), 5, false, localKandianMsgBoxRedPntInfo.mMsgId);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      kxm.O(this.this$0.getContext(), 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ngd
 * JD-Core Version:    0.7.0.1
 */