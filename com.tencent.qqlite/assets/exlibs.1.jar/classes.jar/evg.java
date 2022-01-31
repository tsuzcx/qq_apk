import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.utils.QQCustomSingleChoiceDialog;

public class evg
  implements AdapterView.OnItemClickListener
{
  public evg(QQCustomSingleChoiceDialog paramQQCustomSingleChoiceDialog) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.jdField_a_of_type_Int = paramInt;
    QQCustomSingleChoiceDialog.a(this.a).notifyDataSetChanged();
    this.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     evg
 * JD-Core Version:    0.7.0.1
 */