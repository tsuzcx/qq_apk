import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.util.ItemHolder;

public class m
  implements View.OnClickListener
{
  public m(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (ItemHolder)paramView.getTag();
    LiteActivity.b(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     m
 * JD-Core Version:    0.7.0.1
 */