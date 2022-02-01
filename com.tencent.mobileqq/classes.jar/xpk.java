import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

class xpk
  extends xgs
{
  xpk(xpj paramxpj) {}
  
  public void d()
  {
    super.d();
    if (LiuHaiUtils.b(this.a.b()))
    {
      LinearLayout localLinearLayout = (LinearLayout)this.a.a().a.findViewById(2131363726);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLayoutParams.height = xpj.a(this.a);
      if (!ScreenUtil.checkDeviceHasNavigationBar(this.a.a.getContext())) {
        localLinearLayout.setBackgroundColor(Color.parseColor("#181818"));
      }
      localLinearLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public void g()
  {
    super.g();
    xpj.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpk
 * JD-Core Version:    0.7.0.1
 */