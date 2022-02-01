import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class zmj
  implements View.OnClickListener
{
  zmj(zmi paramzmi, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int < zmi.a(this.jdField_a_of_type_Zmi).size())
    {
      zmi.b(this.jdField_a_of_type_Zmi).remove(this.jdField_a_of_type_Int);
      ((ArrayList)this.jdField_a_of_type_Zmi.a.a()).remove(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Zmi.notifyDataSetChanged();
      if (CommodityListView.a(this.jdField_a_of_type_Zmi.a) != null) {
        CommodityListView.a(this.jdField_a_of_type_Zmi.a).a(zmi.c(this.jdField_a_of_type_Zmi).size());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmj
 * JD-Core Version:    0.7.0.1
 */