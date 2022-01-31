import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import java.util.ArrayList;

class wvo
  implements View.OnClickListener
{
  wvo(wvn paramwvn, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int < wvn.a(this.jdField_a_of_type_Wvn).size())
    {
      wvn.b(this.jdField_a_of_type_Wvn).remove(this.jdField_a_of_type_Int);
      ((ArrayList)this.jdField_a_of_type_Wvn.a.a()).remove(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Wvn.notifyDataSetChanged();
      if (CommodityListView.a(this.jdField_a_of_type_Wvn.a) != null) {
        CommodityListView.a(this.jdField_a_of_type_Wvn.a).a(wvn.c(this.jdField_a_of_type_Wvn).size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wvo
 * JD-Core Version:    0.7.0.1
 */