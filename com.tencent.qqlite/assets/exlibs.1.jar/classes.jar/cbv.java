import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.tips.ReaderTipsBar;

public class cbv
  implements View.OnClickListener
{
  public cbv(ReaderTipsBar paramReaderTipsBar) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setAction("com.qqreader.aioback2reader");
    paramView.putExtra("bookid", ReaderTipsBar.a(this.a));
    ReaderTipsBar.a(this.a).sendBroadcast(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbv
 * JD-Core Version:    0.7.0.1
 */