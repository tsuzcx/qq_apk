import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class tmw
  implements View.OnLongClickListener
{
  tmw(tmv paramtmv, long paramLong) {}
  
  public boolean onLongClick(View paramView)
  {
    DialogUtil.a(this.jdField_a_of_type_Tmv.a, 230).setTitle(this.jdField_a_of_type_Tmv.a.getString(2131434957)).setItems(2131296268, new tmx(this)).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tmw
 * JD-Core Version:    0.7.0.1
 */