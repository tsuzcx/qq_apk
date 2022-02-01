import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.d;
import com.tencent.widget.XListView;

class zmm
  implements AdapterView.d
{
  zmm(zme paramzme) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(zme.TAG, 2, "onLongClick, position = " + paramInt);
    }
    paramAdapterView = this.b.F.getAdapter();
    if (paramAdapterView == this.b.b)
    {
      this.b.jdField_a_of_type_Zmc = ((zmc)this.b.b.getItem(paramInt));
      paramView.setSelected(true);
      paramAdapterView = new aqoa();
      paramAdapterView.Z(2131365509, acfp.m(2131708239), 2130839077);
      paramAdapterView.Z(2131367523, this.b.mContext.getString(2131721067), 2130839086);
      this.b.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = aqgq.a(paramView, paramAdapterView, zme.a(this.b), new zmn(this, paramView));
    }
    while (paramAdapterView != this.b.jdField_a_of_type_Zmo) {
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zmm
 * JD-Core Version:    0.7.0.1
 */