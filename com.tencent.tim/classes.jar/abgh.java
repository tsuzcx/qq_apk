import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abgh
  implements View.OnClickListener
{
  abgh(abge paramabge) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof abge.f)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (abge.f)localObject;
      if ((((abge.f)localObject).b != null) && (((abge.f)localObject).b.troopInfo != null)) {
        this.this$0.a.a(((abge.f)localObject).b.troopInfo, ((abge.f)localObject).b.itemType);
      }
      if ((((abge.f)localObject).b != null) && (((abge.f)localObject).b.d != null)) {
        this.this$0.a.a(((abge.f)localObject).b.d);
      }
      new anov(this.this$0.app).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "1" }).report();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgh
 * JD-Core Version:    0.7.0.1
 */