import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.tips.ReaderTipsBar;

public class wab
  implements View.OnClickListener
{
  public wab(ReaderTipsBar paramReaderTipsBar) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("bookid", ReaderTipsBar.a(this.a));
    paramView.putExtra("is_from_conversation", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramView);
    localIntent.putExtra("readtype", "15");
    localIntent.setClassName(ReaderTipsBar.a(this.a), "cooperation.qqreader.QRBridgeActivity");
    localIntent.addFlags(268435456);
    ReaderTipsBar.a(this.a).startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wab
 * JD-Core Version:    0.7.0.1
 */