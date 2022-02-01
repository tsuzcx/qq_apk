import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yxm
  implements View.OnClickListener
{
  yxm(yxl paramyxl, yxo paramyxo) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Yxo.a()) {
      this.jdField_a_of_type_Yxo.b();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Yxl.a != null) {
        this.jdField_a_of_type_Yxl.a.a(this.jdField_a_of_type_Yxl);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Yxo.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxm
 * JD-Core Version:    0.7.0.1
 */