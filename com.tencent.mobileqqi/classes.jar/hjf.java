import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.mobileqq.widget.WorkSpaceView.OnScreenChangeListener;

public class hjf
  implements WorkSpaceView.OnScreenChangeListener
{
  public hjf(ADView paramADView, LinearLayout paramLinearLayout) {}
  
  public void a(int paramInt)
  {
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setEnabled(false);
      i += 1;
    }
    if (paramInt == -1) {
      i = j - 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setEnabled(true);
      return;
      i = paramInt;
      if (paramInt == j) {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hjf
 * JD-Core Version:    0.7.0.1
 */