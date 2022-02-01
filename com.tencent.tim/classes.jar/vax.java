import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vax
  implements View.OnClickListener
{
  public vax(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365679)
    {
      vbi.b localb = this.this$0.a.a();
      if ((!this.this$0.Av) && (this.this$0.aWG) && (localb != null))
      {
        ausj localausj = (ausj)auss.a(this.this$0, null);
        localausj.addButton(2131694749, 3);
        localausj.addCancelButton(2131721058);
        localausj.a(new vay(this, localb, localausj));
        localausj.show();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vax
 * JD-Core Version:    0.7.0.1
 */