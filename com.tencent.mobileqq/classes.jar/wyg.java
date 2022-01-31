import android.app.Activity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;

public class wyg
  extends UniPayHandler.UniPayUpdateListener
{
  public wyg(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void a()
  {
    this.a.runOnUiThread(new wyh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyg
 * JD-Core Version:    0.7.0.1
 */