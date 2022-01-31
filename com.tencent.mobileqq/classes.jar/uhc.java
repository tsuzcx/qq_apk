import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.BaseApplication;

class uhc
  implements View.OnClickListener
{
  uhc(uhb paramuhb) {}
  
  public void onClick(View paramView)
  {
    paramView = uhb.a(this.a);
    if (paramView != null)
    {
      Intent localIntent = new Intent();
      tzv.a("", 17, 3L);
      tqs.a(BaseApplication.getContext(), paramView, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhc
 * JD-Core Version:    0.7.0.1
 */