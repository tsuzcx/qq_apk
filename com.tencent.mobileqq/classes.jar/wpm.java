import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wpm
  implements View.OnClickListener
{
  wpm(wpl paramwpl) {}
  
  public void onClick(View paramView)
  {
    String str1;
    if ((wpl.a(this.a) != null) && (wpl.a(this.a).a()))
    {
      wpl.a(this.a).c();
      int i;
      if (wpl.a(this.a) != null)
      {
        i = xwa.a(wpl.a(this.a).a);
        if (!this.a.a()) {
          break label128;
        }
      }
      label128:
      for (str1 = "1";; str1 = "2")
      {
        xwa.a("home_page", "cancel_reply", i, 0, new String[] { str1, xwa.a(wpl.a(this.a)), "5", wpl.a(this.a) });
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        i = 0;
        break;
      }
    }
    this.a.a();
    if (this.a.a())
    {
      str1 = "2";
      label154:
      if (!this.a.b()) {
        break label199;
      }
    }
    label199:
    for (String str2 = "2";; str2 = "1")
    {
      xwa.a("play_video", "close_reply", 0, 3, new String[] { str1, str2 });
      break;
      str1 = "1";
      break label154;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpm
 * JD-Core Version:    0.7.0.1
 */