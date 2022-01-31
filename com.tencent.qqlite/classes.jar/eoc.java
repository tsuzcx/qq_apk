import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;

public class eoc
  implements View.OnClickListener
{
  public eoc(VideoPlayLogic paramVideoPlayLogic) {}
  
  public void onClick(View paramView)
  {
    if ((VideoPlayLogic.a(this.a) instanceof ChatActivity)) {
      ((ChatActivity)VideoPlayLogic.a(this.a)).a().S();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eoc
 * JD-Core Version:    0.7.0.1
 */