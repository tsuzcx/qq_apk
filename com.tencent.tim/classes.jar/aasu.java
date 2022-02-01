import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.4.1;

public class aasu
  implements psc.a<prw.a>
{
  public aasu(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void a(boolean paramBoolean, prw.a parama)
  {
    ram.d(P2VEditMusicDialog.access$000(), "onAddressUpdate.");
    if ((paramBoolean) && (parama != null))
    {
      ram.b(P2VEditMusicDialog.access$000(), "onAddressUpdate success, address=%s", parama);
      this.this$0.mUIHandler.post(new P2VEditMusicDialog.4.1(this, parama));
      return;
    }
    ram.e(P2VEditMusicDialog.access$000(), "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aasu
 * JD-Core Version:    0.7.0.1
 */