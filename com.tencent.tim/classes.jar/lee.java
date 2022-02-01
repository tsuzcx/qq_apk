import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.c;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.d;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class lee
  implements View.OnClickListener
{
  public lee(ReadInJoyPicWaterFallFragment.d paramd) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    this.a.this$0.C(paramView, i);
    kvp.c(this.a.this$0.getActivity(), "0X8009A71", this.a.this$0.nh(), ((ReadInJoyPicWaterFallFragment.c)this.a.this$0.kz.get(i)).e.mChannelCoverId);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lee
 * JD-Core Version:    0.7.0.1
 */