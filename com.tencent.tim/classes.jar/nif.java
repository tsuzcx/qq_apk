import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nif
  implements View.OnClickListener
{
  public nif(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyTabFrame.a(this.this$0).setText("");
    ReadinjoyTabFrame.a(this.this$0).setVisibility(8);
    odv.l(this.this$0.app, true);
    ((KandianMergeManager)this.this$0.app.getManager(162)).mU(true);
    kxm.O(this.this$0.a(), 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nif
 * JD-Core Version:    0.7.0.1
 */