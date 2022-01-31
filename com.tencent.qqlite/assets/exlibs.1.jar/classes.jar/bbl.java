import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class bbl
  implements View.OnLongClickListener
{
  bbl(bbk parambbk, long paramLong) {}
  
  public boolean onLongClick(View paramView)
  {
    DialogUtil.a(this.jdField_a_of_type_Bbk.a, 230).setTitle(this.jdField_a_of_type_Bbk.a.getString(2131363524)).setItems(2131230724, new bbm(this)).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bbl
 * JD-Core Version:    0.7.0.1
 */