import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class dbg
  implements View.OnLongClickListener
{
  dbg(dbf paramdbf, long paramLong) {}
  
  public boolean onLongClick(View paramView)
  {
    DialogUtil.a(this.jdField_a_of_type_Dbf.a, 230).setTitle(this.jdField_a_of_type_Dbf.a.getString(2131562677)).setItems(2131689484, new dbh(this)).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dbg
 * JD-Core Version:    0.7.0.1
 */