import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zkq
  implements View.OnClickListener
{
  zkq(zkp paramzkp, afxp paramafxp) {}
  
  public void onClick(View paramView)
  {
    zkp.a(this.jdField_a_of_type_Zkp).removeCallbacks(zkp.a(this.jdField_a_of_type_Zkp));
    zkp.a(this.jdField_a_of_type_Zkp, true);
    zkp.a(this.jdField_a_of_type_Zkp, this.jdField_a_of_type_Afxp, this.jdField_a_of_type_Afxp.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zkq
 * JD-Core Version:    0.7.0.1
 */