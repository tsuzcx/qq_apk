import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.plugin.PluginIntent.a;

class avyn
  implements PluginIntent.a
{
  avyn(avym paramavym) {}
  
  public void S(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = false;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = avxi.a(paramFromServiceMsg.getWupBuffer());
      avym.a(this.b, paramIntent);
      avym.a(this.b, paramIntent, null);
      avwe.a().a(paramIntent);
      if (this.b.a != null)
      {
        paramFromServiceMsg = this.b.a;
        if (paramIntent != null) {
          bool = true;
        }
        paramFromServiceMsg.WT(bool);
      }
    }
    do
    {
      return;
      avym.a(this.b, null, null);
    } while (this.b.a == null);
    this.b.a.WT(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avyn
 * JD-Core Version:    0.7.0.1
 */