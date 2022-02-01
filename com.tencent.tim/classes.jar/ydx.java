import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.a;

class ydx
  implements RobotPanelLayoutBase.a
{
  ydx(ydw paramydw) {}
  
  public void af(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(this.this$0.sessionInfo.aTl)) && (this.this$0.sessionInfo.aTl.equals(paramString)))
    {
      paramString = (wxk)this.this$0.a(23);
      if (paramString != null) {
        paramString.l(true);
      }
    }
    do
    {
      return;
      paramString = (wxk)this.this$0.a(23);
    } while (paramString == null);
    paramString.l(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ydx
 * JD-Core Version:    0.7.0.1
 */