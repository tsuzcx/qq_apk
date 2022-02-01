import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abzr
  implements View.OnClickListener
{
  abzr(abzq paramabzq) {}
  
  public void onClick(View paramView)
  {
    if (abzq.a(this.a) != null)
    {
      if (abzq.a(this.a).cZ != 1036) {
        break label69;
      }
      ((abhh)abzq.a(this.a).app.getManager(153)).a().Cc(abzq.a(this.a).getCurrentUin());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label69:
      abhe localabhe = (abhe)abzq.a(this.a).getManager(211);
      if (localabhe != null) {
        localabhe.cBE();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abzr
 * JD-Core Version:    0.7.0.1
 */