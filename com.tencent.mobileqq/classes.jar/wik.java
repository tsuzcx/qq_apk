import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.tips.MovieTicketTipsBar;

public class wik
  implements View.OnClickListener
{
  public wik(MovieTicketTipsBar paramMovieTicketTipsBar) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(MovieTicketTipsBar.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", MovieTicketTipsBar.a(this.a));
    MovieTicketTipsBar.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wik
 * JD-Core Version:    0.7.0.1
 */