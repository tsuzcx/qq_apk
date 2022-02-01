import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class niu
  implements View.OnClickListener
{
  public niu(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyTabFrame.a(this.this$0, this.this$0.a(), (ViewGroup)ReadinjoyTabFrame.a(this.this$0));
    if (BaseApplicationImpl.sProcessId != 9) {
      awsw.gC(BaseApplicationImpl.getContext());
    }
    kxm.mG("1");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     niu
 * JD-Core Version:    0.7.0.1
 */