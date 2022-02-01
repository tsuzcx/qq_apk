import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rwn
  implements View.OnClickListener
{
  rwn(rwk paramrwk, rwo paramrwo) {}
  
  public void onClick(View paramView)
  {
    if (rwk.a(this.jdField_b_of_type_Rwk) != null) {
      rwk.a(this.jdField_b_of_type_Rwk).c(this.jdField_b_of_type_Rwo);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rwn
 * JD-Core Version:    0.7.0.1
 */