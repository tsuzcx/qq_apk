import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class qht
  implements View.OnClickListener
{
  qht(qhr paramqhr) {}
  
  public void onClick(View paramView)
  {
    String str1;
    if ((qhr.a(this.a) != null) && (qhr.a(this.a).Ks()))
    {
      qhr.a(this.a).bqb();
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialog.2.1(this), 200L);
      if (!this.a.JD()) {
        break label116;
      }
      str1 = "2";
      label64:
      if (!this.a.JE()) {
        break label122;
      }
    }
    label116:
    label122:
    for (String str2 = "2";; str2 = "1")
    {
      rar.a("play_video", "close_reply", 0, 1, new String[] { str1, str2 });
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.close();
      break;
      str1 = "1";
      break label64;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qht
 * JD-Core Version:    0.7.0.1
 */