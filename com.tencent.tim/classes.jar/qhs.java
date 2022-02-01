import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qhs
  implements View.OnClickListener
{
  qhs(qhr paramqhr) {}
  
  public void onClick(View paramView)
  {
    String str1;
    if ((qhr.a(this.a) != null) && (qhr.a(this.a).Ks()))
    {
      qhr.a(this.a).bqb();
      int i;
      if (qhr.a(this.a) != null)
      {
        i = rar.a(qhr.a(this.a).d);
        if (!this.a.JD()) {
          break label128;
        }
      }
      label128:
      for (str1 = "1";; str1 = "2")
      {
        rar.a("home_page", "cancel_reply", i, 0, new String[] { str1, rar.bX(qhr.a(this.a)), "5", qhr.a(this.a) });
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        i = 0;
        break;
      }
    }
    this.a.close();
    if (this.a.JD())
    {
      str1 = "2";
      label154:
      if (!this.a.JE()) {
        break label199;
      }
    }
    label199:
    for (String str2 = "2";; str2 = "1")
    {
      rar.a("play_video", "close_reply", 0, 3, new String[] { str1, str2 });
      break;
      str1 = "1";
      break label154;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qhs
 * JD-Core Version:    0.7.0.1
 */