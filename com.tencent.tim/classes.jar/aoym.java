import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aoym
  implements View.OnClickListener
{
  aoym(aoyk.b paramb) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (aozp.a)paramView.getTag();
    String str;
    if (((aozp.a)localObject).type == 1)
    {
      this.a.a.a.hS(((aozp.a)localObject).id, null);
      if (((aozp.a)localObject).id == null) {}
      for (str = "";; str = ((aozp.a)localObject).id)
      {
        anot.a(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str, "", "", "");
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    this.a.a.a.hS(((aozp.a)localObject).parentId, ((aozp.a)localObject).id);
    if (((aozp.a)localObject).parentId == null)
    {
      str = "";
      label114:
      if (((aozp.a)localObject).id != null) {
        break label157;
      }
    }
    label157:
    for (localObject = "";; localObject = ((aozp.a)localObject).id)
    {
      anot.a(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, str, (String)localObject, "", "");
      break;
      str = ((aozp.a)localObject).parentId;
      break label114;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoym
 * JD-Core Version:    0.7.0.1
 */