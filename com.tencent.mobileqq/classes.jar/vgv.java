import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.MedalNewsItemBuilder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForMedalNews;

public class vgv
  implements View.OnClickListener
{
  public vgv(MedalNewsItemBuilder paramMedalNewsItemBuilder, MessageForMedalNews paramMessageForMedalNews) {}
  
  public void onClick(View paramView)
  {
    if ((vgz)paramView.getTag() == null) {
      return;
    }
    ThreadManager.postImmediately(new vgw(this), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vgv
 * JD-Core Version:    0.7.0.1
 */