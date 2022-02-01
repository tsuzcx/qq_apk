import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agxl
  implements View.OnClickListener
{
  agxl(agxi paramagxi) {}
  
  public void onClick(View paramView)
  {
    agxi.a(this.this$0, true);
    this.this$0.jdField_a_of_type_Agyh.Ka(true);
    this.this$0.jdField_a_of_type_Agyh.JZ(false);
    agxi.a(this.this$0);
    this.this$0.jdField_a_of_type_Aguk.iC();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxl
 * JD-Core Version:    0.7.0.1
 */