import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zcj
  implements View.OnClickListener
{
  public zcj(ContactsTroopAdapter paramContactsTroopAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.this$0.iY[this.Ju] = 2;
    this.this$0.notifyDataSetChanged();
    int i = ContactsTroopAdapter.a(this.this$0, this.Ju);
    new anov(this.this$0.mApp).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_inactive").a(new String[] { "", String.valueOf(i) }).report();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zcj
 * JD-Core Version:    0.7.0.1
 */