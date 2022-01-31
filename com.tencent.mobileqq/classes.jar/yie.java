import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;

public final class yie
  implements Runnable
{
  public yie(View paramView, int paramInt) {}
  
  public void run()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidViewView.getContext();
    if (this.jdField_a_of_type_Int == 1) {
      localActivity.getWindow().addFlags(128);
    }
    for (;;)
    {
      QLog.e("ApolloRender", 2, "SetKeepScreenOn :" + this.jdField_a_of_type_Int);
      return;
      localActivity.getWindow().clearFlags(128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yie
 * JD-Core Version:    0.7.0.1
 */