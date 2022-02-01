import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zph
  implements View.OnClickListener
{
  zph(zpg paramzpg) {}
  
  public void onClick(View paramView)
  {
    zpc localzpc = this.a.jdField_a_of_type_Zpc;
    if (localzpc != null) {
      localzpc.a(this.a.jdField_a_of_type_Zpi, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zph
 * JD-Core Version:    0.7.0.1
 */