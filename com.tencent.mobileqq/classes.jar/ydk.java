import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;

public class ydk
  implements View.OnClickListener
{
  public ydk(BaseWidgetView paramBaseWidgetView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a() != null) && (!this.a.a(paramView)))
    {
      this.a.b(this.a.a());
      this.a.a().onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ydk
 * JD-Core Version:    0.7.0.1
 */