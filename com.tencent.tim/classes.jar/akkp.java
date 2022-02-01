import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akkp
  implements View.OnClickListener
{
  akkp(akkn paramakkn, akki paramakki) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Akkn.dismiss();
    if (this.jdField_a_of_type_Akki.a != null) {
      this.jdField_a_of_type_Akki.a.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkp
 * JD-Core Version:    0.7.0.1
 */