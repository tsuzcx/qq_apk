import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter.ItemHolder;

public class ag
  implements View.OnClickListener
{
  public ag(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (DatalineSessionAdapter.ItemHolder)paramView.getTag();
    LiteActivity.b(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ag
 * JD-Core Version:    0.7.0.1
 */