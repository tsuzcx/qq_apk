import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class gxa
  implements TroopMemberApiClient.Callback
{
  public gxa(VideoPlayLogic paramVideoPlayLogic) {}
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("ret"))
    {
      VideoPlayLogic.b(this.a);
      return;
    }
    if ((VideoPlayLogic.a(this.a) != null) && (VideoPlayLogic.a(this.a).isShowing() == true)) {
      VideoPlayLogic.a(this.a).dismiss();
    }
    this.a.a(VideoPlayLogic.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gxa
 * JD-Core Version:    0.7.0.1
 */