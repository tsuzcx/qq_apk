import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aodd
  implements View.OnClickListener
{
  aodd(aodc paramaodc) {}
  
  public void onClick(View paramView)
  {
    aoef localaoef;
    if (aqft.equalsWithNullCheck("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localaoef = (aoef)paramView.getTag(-10);
      if (paramView.getId() != 2131364769) {
        break label47;
      }
      aodc.a(this.a, localaoef);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label47:
      if (aodc.a(this.a) != null) {
        aodc.a(this.a).a(paramView.getId(), localaoef);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aodd
 * JD-Core Version:    0.7.0.1
 */