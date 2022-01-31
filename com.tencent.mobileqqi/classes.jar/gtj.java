import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopCreateAvatarActivity;

public class gtj
  implements View.OnClickListener
{
  public gtj(TroopCreateAvatarActivity paramTroopCreateAvatarActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.putExtra("isBack", 1);
    this.a.setResult(-1, this.a.a);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gtj
 * JD-Core Version:    0.7.0.1
 */