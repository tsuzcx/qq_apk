import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import java.util.ArrayList;

class yor
  implements View.OnClickListener
{
  yor(yoq paramyoq, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int < yoq.a(this.jdField_a_of_type_Yoq).size())
    {
      yoq.b(this.jdField_a_of_type_Yoq).remove(this.jdField_a_of_type_Int);
      ((ArrayList)this.jdField_a_of_type_Yoq.a.a()).remove(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Yoq.notifyDataSetChanged();
      if (CommodityListView.a(this.jdField_a_of_type_Yoq.a) != null) {
        CommodityListView.a(this.jdField_a_of_type_Yoq.a).a(yoq.c(this.jdField_a_of_type_Yoq).size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yor
 * JD-Core Version:    0.7.0.1
 */