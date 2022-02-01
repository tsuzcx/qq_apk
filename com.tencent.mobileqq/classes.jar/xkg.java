import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xkg
  implements View.OnClickListener
{
  xkg(xkf paramxkf) {}
  
  public void onClick(View paramView)
  {
    String str1;
    if ((xkf.a(this.a) != null) && (xkf.a(this.a).a()))
    {
      xkf.a(this.a).c();
      int i;
      if (xkf.a(this.a) != null)
      {
        i = yqu.a(xkf.a(this.a).a);
        if (!this.a.a()) {
          break label128;
        }
      }
      label128:
      for (str1 = "1";; str1 = "2")
      {
        yqu.a("home_page", "cancel_reply", i, 0, new String[] { str1, yqu.a(xkf.a(this.a)), "5", xkf.a(this.a) });
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
      yqu.a("play_video", "close_reply", 0, 3, new String[] { str1, str2 });
      break;
      str1 = "1";
      break label154;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkg
 * JD-Core Version:    0.7.0.1
 */