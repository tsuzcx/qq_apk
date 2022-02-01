import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayps
  implements View.OnClickListener
{
  ayps(aypr paramaypr, aypr.b paramb) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Aypr$b.LF()) {
      this.jdField_a_of_type_Aypr$b.selectAll();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aypr.a != null) {
        this.jdField_a_of_type_Aypr.a.a(this.jdField_a_of_type_Aypr);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Aypr$b.bvi();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayps
 * JD-Core Version:    0.7.0.1
 */