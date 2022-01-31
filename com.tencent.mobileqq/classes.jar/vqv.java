import android.view.View;
import android.view.View.OnClickListener;

class vqv
  implements View.OnClickListener
{
  vqv(vqu paramvqu) {}
  
  public void onClick(View paramView)
  {
    if ((vqu.a(this.a) != null) && (vqu.a(this.a).a()))
    {
      vqu.a(this.a).c();
      int i;
      if (vqu.a(this.a) != null)
      {
        i = wxj.a(vqu.a(this.a).a);
        if (!this.a.a()) {
          break label121;
        }
      }
      label121:
      for (paramView = "1";; paramView = "2")
      {
        wxj.a("home_page", "cancel_reply", i, 0, new String[] { paramView, wxj.a(vqu.a(this.a)), "5", vqu.a(this.a) });
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
      wxj.a("play_video", "close_reply", 0, 3, new String[] { paramView, str });
      return;
      paramView = "1";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqv
 * JD-Core Version:    0.7.0.1
 */