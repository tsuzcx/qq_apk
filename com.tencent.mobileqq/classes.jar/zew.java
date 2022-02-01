import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zew
  implements View.OnClickListener
{
  zew(zev paramzev) {}
  
  public void onClick(View paramView)
  {
    zer localzer = this.a.jdField_a_of_type_Zer;
    if (localzer != null) {
      localzer.a(this.a.jdField_a_of_type_Zex, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zew
 * JD-Core Version:    0.7.0.1
 */