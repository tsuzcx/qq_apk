import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zdy
  implements View.OnClickListener
{
  zdy(zdx paramzdx, zea paramzea) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Zea.a()) {
      this.jdField_a_of_type_Zea.b();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Zdx.a != null) {
        this.jdField_a_of_type_Zdx.a.a(this.jdField_a_of_type_Zdx);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Zea.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdy
 * JD-Core Version:    0.7.0.1
 */