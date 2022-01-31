import android.content.Context;
import android.widget.ScrollView;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class wgm
  extends ScrollView
{
  public wgm(TroopChatPie paramTroopChatPie, Context paramContext)
  {
    super(paramContext);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgm
 * JD-Core Version:    0.7.0.1
 */