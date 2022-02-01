import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.d;

class zlq
  implements AdapterView.d
{
  zlq(zli paramzli) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.c.jdField_a_of_type_Zlg.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (zmc)this.c.jdField_a_of_type_Zlg.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.c.jdField_a_of_type_Zmc = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new aqoa();
    paramAdapterView.Z(2131365509, acfp.m(2131703333), 2130839077);
    paramAdapterView.Z(2131367523, this.c.mContext.getString(2131721067), 2130839086);
    this.c.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = aqgq.a(paramView, paramAdapterView, zli.a(this.c), new zlr(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zlq
 * JD-Core Version:    0.7.0.1
 */