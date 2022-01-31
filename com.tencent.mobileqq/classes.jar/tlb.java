import android.view.View;
import android.view.View.OnClickListener;

class tlb
  implements View.OnClickListener
{
  tlb(tla paramtla) {}
  
  public void onClick(View paramView)
  {
    if ((tla.a(this.a) != null) && (tla.a(this.a).a()))
    {
      tla.a(this.a).c();
      int i;
      if (tla.a(this.a) != null)
      {
        i = urp.a(tla.a(this.a).a);
        if (!this.a.a()) {
          break label121;
        }
      }
      label121:
      for (paramView = "1";; paramView = "2")
      {
        urp.a("home_page", "cancel_reply", i, 0, new String[] { paramView, urp.a(tla.a(this.a)), "5", tla.a(this.a) });
        return;
        i = 0;
        break;
      }
    }
    this.a.a();
    if (this.a.a())
    {
      paramView = "2";
      if (!this.a.b()) {
        break label188;
      }
    }
    label188:
    for (String str = "2";; str = "1")
    {
      urp.a("play_video", "close_reply", 0, 3, new String[] { paramView, str });
      return;
      paramView = "1";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlb
 * JD-Core Version:    0.7.0.1
 */