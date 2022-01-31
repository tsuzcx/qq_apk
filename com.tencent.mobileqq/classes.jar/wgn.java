import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import java.util.ArrayList;

class wgn
  implements View.OnClickListener
{
  wgn(wgm paramwgm, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int < wgm.a(this.jdField_a_of_type_Wgm).size())
    {
      wgm.b(this.jdField_a_of_type_Wgm).remove(this.jdField_a_of_type_Int);
      ((ArrayList)this.jdField_a_of_type_Wgm.a.a()).remove(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Wgm.notifyDataSetChanged();
      if (CommodityListView.a(this.jdField_a_of_type_Wgm.a) != null) {
        CommodityListView.a(this.jdField_a_of_type_Wgm.a).a(wgm.c(this.jdField_a_of_type_Wgm).size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wgn
 * JD-Core Version:    0.7.0.1
 */