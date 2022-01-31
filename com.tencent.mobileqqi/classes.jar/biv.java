import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;

public class biv
  implements View.OnClickListener
{
  public biv(AVActivity paramAVActivity) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a;
    if ((i == 1) || (i == 2)) {
      this.a.a(this.a.b, this.a.i, this.a.j);
    }
    while ((i != 3) && (i != 4)) {
      return;
    }
    paramView = this.a.jdField_a_of_type_ComTencentAvVideoController.a().j;
    String str = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, paramView, null);
    this.a.a(paramView, 3000, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     biv
 * JD-Core Version:    0.7.0.1
 */