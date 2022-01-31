import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.util.ItemHolder;

public class k
  implements View.OnClickListener
{
  public k(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (ItemHolder)((ItemHolder)paramView.getTag()).clone();
    LiteActivity.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     k
 * JD-Core Version:    0.7.0.1
 */