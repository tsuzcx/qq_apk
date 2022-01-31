import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.util.MqqWeakReferenceHandler;

public class wcl
  implements View.OnClickListener
{
  public wcl(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (BlessSelectMemberActivity.a() != null) {
      BlessSelectMemberActivity.a().sendEmptyMessage(1);
    }
    if (this.a.a.isShowing()) {
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wcl
 * JD-Core Version:    0.7.0.1
 */