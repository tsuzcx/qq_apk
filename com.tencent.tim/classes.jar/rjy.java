import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog.6.1;

public class rjy
  implements psc.a<prw.a>
{
  public rjy(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void a(boolean paramBoolean, prw.a parama)
  {
    ram.d("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate.");
    if ((paramBoolean) && (parama != null))
    {
      ram.b("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate success, address=%s", parama);
      this.this$0.mUIHandler.post(new EditVideoMusicDialog.6.1(this, parama));
      return;
    }
    ram.e("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rjy
 * JD-Core Version:    0.7.0.1
 */