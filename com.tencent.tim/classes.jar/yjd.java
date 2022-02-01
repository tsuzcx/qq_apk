import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yjd
  implements View.OnClickListener
{
  yjd(yjc paramyjc) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent1 = new Intent();
    localIntent1.putExtra("is_from_conversation", true);
    localIntent1.putExtra("bookid", yjc.a(this.a));
    localIntent1.putExtra("book_new_id", yjc.b(this.a));
    Intent localIntent2 = new Intent();
    localIntent2.putExtras(localIntent1);
    localIntent2.putExtra("readtype", "15");
    localIntent2.setClassName(yjc.a(this.a), "cooperation.qqreader.QRBridgeActivity");
    localIntent2.addFlags(268435456);
    yjc.a(this.a).startActivity(localIntent2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjd
 * JD-Core Version:    0.7.0.1
 */