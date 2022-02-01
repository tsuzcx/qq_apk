import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Set;

class axds
  implements View.OnClickListener
{
  axds(axdr paramaxdr, axdj paramaxdj, int paramInt, axdr.b paramb) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (this.jdField_a_of_type_Axdj.state == 13)
    {
      if (this.jdField_a_of_type_Axdj.aOv()) {
        break label80;
      }
      bool = true;
      if (!bool) {
        break label85;
      }
      axdr.a(this.jdField_a_of_type_Axdr).add(Integer.valueOf(this.val$position));
      axdr.a(this.jdField_a_of_type_Axdr, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Axdj.setSelected(bool);
      this.jdField_a_of_type_Axdr$b.setSelected(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label80:
      bool = false;
      break;
      label85:
      axdr.a(this.jdField_a_of_type_Axdr).remove(Integer.valueOf(this.val$position));
      if (axdr.a(this.jdField_a_of_type_Axdr).size() < 1) {
        axdr.a(this.jdField_a_of_type_Axdr, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axds
 * JD-Core Version:    0.7.0.1
 */