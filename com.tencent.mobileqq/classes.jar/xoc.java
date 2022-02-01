import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class xoc
  implements View.OnClickListener
{
  xoc(xoa paramxoa) {}
  
  public void onClick(View paramView)
  {
    String str1;
    if ((xoa.a(this.a) != null) && (xoa.a(this.a).a()))
    {
      xoa.a(this.a).c();
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.2.1(this), 200L);
      if (!this.a.a()) {
        break label116;
      }
      str1 = "2";
      label64:
      if (!this.a.b()) {
        break label122;
      }
    }
    label116:
    label122:
    for (String str2 = "2";; str2 = "1")
    {
      yup.a("play_video", "close_reply", 0, 1, new String[] { str1, str2 });
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a();
      break;
      str1 = "1";
      break label64;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoc
 * JD-Core Version:    0.7.0.1
 */