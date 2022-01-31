import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopCreateAvatarActivity;

public class elv
  implements View.OnClickListener
{
  public elv(TroopCreateAvatarActivity paramTroopCreateAvatarActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.putExtra("isBack", 1);
    this.a.setResult(-1, this.a.a);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     elv
 * JD-Core Version:    0.7.0.1
 */