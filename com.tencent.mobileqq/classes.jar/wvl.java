import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import java.util.ArrayList;

class wvl
  implements View.OnClickListener
{
  wvl(wvk paramwvk, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int < wvk.a(this.jdField_a_of_type_Wvk).size())
    {
      wvk.b(this.jdField_a_of_type_Wvk).remove(this.jdField_a_of_type_Int);
      ((ArrayList)this.jdField_a_of_type_Wvk.a.a()).remove(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Wvk.notifyDataSetChanged();
      if (CommodityListView.a(this.jdField_a_of_type_Wvk.a) != null) {
        CommodityListView.a(this.jdField_a_of_type_Wvk.a).a(wvk.c(this.jdField_a_of_type_Wvk).size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wvl
 * JD-Core Version:    0.7.0.1
 */