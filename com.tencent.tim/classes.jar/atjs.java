import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atjs
  implements View.OnClickListener
{
  atjs(atjr paramatjr) {}
  
  public void onClick(View paramView)
  {
    atiu localatiu;
    if (aqft.equalsWithNullCheck("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localatiu = (atiu)paramView.getTag(-10);
      if (paramView.getId() != 2131364769) {
        break label47;
      }
      atjr.a(this.a, localatiu);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label47:
      if (atjr.a(this.a) != null) {
        atjr.a(this.a).a(paramView.getId(), localatiu);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjs
 * JD-Core Version:    0.7.0.1
 */