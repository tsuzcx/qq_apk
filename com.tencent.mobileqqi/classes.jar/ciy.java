import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.DoodleActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ciy
  implements View.OnClickListener
{
  public ciy(DoodleActivity paramDoodleActivity) {}
  
  public void onClick(View paramView)
  {
    DialogUtil.a(this.a, 230, this.a.getString(2131561832), this.a.getString(2131561823), 2131561746, 2131561915, new ciz(this), new cja(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ciy
 * JD-Core Version:    0.7.0.1
 */