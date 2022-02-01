import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ulr
  implements View.OnClickListener
{
  ulr(ulq paramulq, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (ulq.a(this.jdField_a_of_type_Ulq) != null)
    {
      String str = ulq.a(this.jdField_a_of_type_Ulq);
      if (ulq.a(this.jdField_a_of_type_Ulq) != null) {
        str = ulq.a(this.jdField_a_of_type_Ulq).id;
      }
      ulq.a(this.jdField_a_of_type_Ulq).a(paramView, 12, this.jdField_a_of_type_Int, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulr
 * JD-Core Version:    0.7.0.1
 */