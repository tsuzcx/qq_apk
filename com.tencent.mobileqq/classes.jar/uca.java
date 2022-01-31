import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

public class uca
  implements View.OnClickListener
{
  public uca(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.setResult(0, this.a.getIntent());
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uca
 * JD-Core Version:    0.7.0.1
 */