import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class dwv
  implements AdapterView.OnItemClickListener
{
  public dwv(TroopMemberListActivity paramTroopMemberListActivity, Dialog paramDialog) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a(paramAdapterView, paramView, paramInt);
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dwv
 * JD-Core Version:    0.7.0.1
 */