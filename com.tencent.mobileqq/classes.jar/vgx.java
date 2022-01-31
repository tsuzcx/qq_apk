import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.MedalNewsItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;

public class vgx
  implements View.OnClickListener
{
  public vgx(MedalNewsItemBuilder paramMedalNewsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    MedalNewsItemBuilder.a(this.a, true, this.a.a.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vgx
 * JD-Core Version:    0.7.0.1
 */