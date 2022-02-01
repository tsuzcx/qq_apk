import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zht
  implements View.OnClickListener
{
  zht(zhs paramzhs, zhv paramzhv) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Zhv.a()) {
      this.jdField_a_of_type_Zhv.b();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Zhs.a != null) {
        this.jdField_a_of_type_Zhs.a.a(this.jdField_a_of_type_Zhs);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Zhv.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zht
 * JD-Core Version:    0.7.0.1
 */