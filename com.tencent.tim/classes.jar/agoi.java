import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agoi
  implements View.OnClickListener
{
  agoi(agoh paramagoh, ampx paramampx) {}
  
  public void onClick(View paramView)
  {
    ((agog)this.jdField_a_of_type_Ampx).cR(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agoi
 * JD-Core Version:    0.7.0.1
 */