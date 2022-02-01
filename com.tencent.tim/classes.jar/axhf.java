import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;

public class axhf
  implements View.OnClickListener
{
  public axhf(AETemplateInfoFragment paramAETemplateInfoFragment) {}
  
  public void onClick(View paramView)
  {
    axcj.a(this.this$0.getActivity(), 1024, axcg.B.getId(), null);
    AETemplateInfoFragment.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhf
 * JD-Core Version:    0.7.0.1
 */