import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.d;

class zne
  implements AdapterView.d
{
  zne(zmw paramzmw) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onLongClick, position = " + paramInt);
    }
    if ((this.c.jdField_a_of_type_Zjk.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return true;
      paramAdapterView = (zmc)this.c.jdField_a_of_type_Zjk.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.c.jdField_a_of_type_Zmc = paramAdapterView;
    paramView.setSelected(true);
    paramAdapterView = new aqoa();
    paramAdapterView.Z(2131365509, acfp.m(2131715539), 2130839077);
    paramAdapterView.Z(2131367523, this.c.mContext.getString(2131721067), 2130839086);
    this.c.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = aqgq.a(paramView, paramAdapterView, zmw.a(this.c), new znf(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zne
 * JD-Core Version:    0.7.0.1
 */