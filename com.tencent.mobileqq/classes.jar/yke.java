import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import java.util.ArrayList;

class yke
  implements View.OnClickListener
{
  yke(ykd paramykd, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int < ykd.a(this.jdField_a_of_type_Ykd).size())
    {
      ykd.b(this.jdField_a_of_type_Ykd).remove(this.jdField_a_of_type_Int);
      ((ArrayList)this.jdField_a_of_type_Ykd.a.a()).remove(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Ykd.notifyDataSetChanged();
      if (CommodityListView.a(this.jdField_a_of_type_Ykd.a) != null) {
        CommodityListView.a(this.jdField_a_of_type_Ykd.a).a(ykd.c(this.jdField_a_of_type_Ykd).size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yke
 * JD-Core Version:    0.7.0.1
 */