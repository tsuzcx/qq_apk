import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.todo.data.TodoInfo;

class auph
  implements View.OnClickListener
{
  auph(aupf paramaupf) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (aqft.equalsWithNullCheck("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localObject = paramView.getTag(-10);
      if (aupf.a(this.a) != null)
      {
        if (paramView.getId() != 2131364767) {
          break label64;
        }
        this.a.a((ViewGroup)paramView.getParent(), (TodoInfo)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label64:
      aupf.a(this.a).b(paramView.getId(), (TodoInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auph
 * JD-Core Version:    0.7.0.1
 */