import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rke
  implements View.OnClickListener
{
  rke(rkd paramrkd, rkd.b paramb) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Rkd$b.LF()) {
      this.jdField_a_of_type_Rkd$b.selectAll();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Rkd.a != null) {
        this.jdField_a_of_type_Rkd.a.a(this.jdField_a_of_type_Rkd);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Rkd$b.bvi();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rke
 * JD-Core Version:    0.7.0.1
 */