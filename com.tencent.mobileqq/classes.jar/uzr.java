import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uzr
  implements View.OnClickListener
{
  uzr(uzq paramuzq, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (uzq.a(this.jdField_a_of_type_Uzq) != null)
    {
      String str = uzq.a(this.jdField_a_of_type_Uzq);
      if (uzq.a(this.jdField_a_of_type_Uzq) != null) {
        str = uzq.a(this.jdField_a_of_type_Uzq).id;
      }
      uzq.a(this.jdField_a_of_type_Uzq).a(paramView, 12, this.jdField_a_of_type_Int, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzr
 * JD-Core Version:    0.7.0.1
 */