import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;

public class hbj
  implements View.OnClickListener
{
  public hbj(VideoPlayLogic paramVideoPlayLogic) {}
  
  public void onClick(View paramView)
  {
    if ((VideoPlayLogic.a(this.a) instanceof ChatActivity)) {
      ((ChatActivity)VideoPlayLogic.a(this.a)).t();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hbj
 * JD-Core Version:    0.7.0.1
 */