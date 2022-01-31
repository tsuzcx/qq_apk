import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter.ItemHolder;

public class af
  implements View.OnClickListener
{
  public af(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (DatalineSessionAdapter.ItemHolder)((DatalineSessionAdapter.ItemHolder)paramView.getTag()).clone();
    LiteActivity.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     af
 * JD-Core Version:    0.7.0.1
 */