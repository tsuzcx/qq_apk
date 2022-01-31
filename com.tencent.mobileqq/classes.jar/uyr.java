import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.MedalNewsItemBuilder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForMedalNews;

public class uyr
  implements View.OnClickListener
{
  public uyr(MedalNewsItemBuilder paramMedalNewsItemBuilder, MessageForMedalNews paramMessageForMedalNews) {}
  
  public void onClick(View paramView)
  {
    if ((uyv)paramView.getTag() == null) {
      return;
    }
    ThreadManager.postImmediately(new uys(this), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uyr
 * JD-Core Version:    0.7.0.1
 */