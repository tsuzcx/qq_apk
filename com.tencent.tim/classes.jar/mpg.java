import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.BaseSelectView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "BEAN", "HOLDER", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
public final class mpg
  implements View.OnClickListener
{
  public mpg(BaseSelectView paramBaseSelectView) {}
  
  public final void onClick(View paramView)
  {
    BaseSelectView.a(this.a).aMF();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mpg
 * JD-Core Version:    0.7.0.1
 */