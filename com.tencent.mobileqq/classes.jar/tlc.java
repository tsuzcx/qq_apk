import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class tlc
  implements View.OnClickListener
{
  tlc(tla paramtla) {}
  
  public void onClick(View paramView)
  {
    if ((tla.a(this.a) != null) && (tla.a(this.a).a()))
    {
      tla.a(this.a).c();
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.2.1(this), 200L);
      if (!this.a.a()) {
        break label109;
      }
      paramView = "2";
      label64:
      if (!this.a.b()) {
        break label115;
      }
    }
    label109:
    label115:
    for (String str = "2";; str = "1")
    {
      urp.a("play_video", "close_reply", 0, 1, new String[] { paramView, str });
      return;
      this.a.a();
      break;
      paramView = "1";
      break label64;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlc
 * JD-Core Version:    0.7.0.1
 */