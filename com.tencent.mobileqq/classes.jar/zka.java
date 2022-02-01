import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zka
  implements View.OnClickListener
{
  zka(zjy paramzjy, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (zjy.a(this.jdField_a_of_type_Zjy) != null) {
      zjy.a(this.jdField_a_of_type_Zjy).a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zka
 * JD-Core Version:    0.7.0.1
 */