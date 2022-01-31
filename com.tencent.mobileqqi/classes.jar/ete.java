import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.LocalSearchBar;

public class ete
  implements View.OnClickListener
{
  public ete(LocalSearchBar paramLocalSearchBar) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.a.a > 1000L)
    {
      this.a.a = l;
      Conversation.d(false);
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ete
 * JD-Core Version:    0.7.0.1
 */