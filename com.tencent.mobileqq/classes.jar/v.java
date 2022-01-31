import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.util.ItemHolder;

public class v
  implements View.OnClickListener
{
  public v(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.m = true;
    paramView = (ItemHolder)paramView.getTag();
    this.a.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     v
 * JD-Core Version:    0.7.0.1
 */