import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zlm
  implements View.OnClickListener
{
  zlm(zll paramzll) {}
  
  public void onClick(View paramView)
  {
    zlh localzlh = this.a.jdField_a_of_type_Zlh;
    if (localzlh != null) {
      localzlh.a(this.a.jdField_a_of_type_Zln, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlm
 * JD-Core Version:    0.7.0.1
 */