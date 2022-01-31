import android.content.res.Resources;
import android.os.Handler;
import android.widget.Button;
import com.tencent.open.agent.AuthorityActivity;

public class hmz
  implements Runnable
{
  public hmz(AuthorityActivity paramAuthorityActivity) {}
  
  public void run()
  {
    Object localObject = this.a;
    int i = ((AuthorityActivity)localObject).y;
    ((AuthorityActivity)localObject).y = (i - 1);
    if (i > 0)
    {
      localObject = (String)this.a.getResources().getText(2131561488);
      AuthorityActivity localAuthorityActivity = this.a;
      i = localAuthorityActivity.z;
      localAuthorityActivity.z = (i + 1);
      switch (i % 3)
      {
      }
      for (;;)
      {
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.b, 500L);
        return;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "·  ");
        continue;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "·· ");
        continue;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "···");
      }
    }
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.a.g = true;
    this.a.h = false;
    this.a.p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hmz
 * JD-Core Version:    0.7.0.1
 */