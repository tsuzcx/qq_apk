import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog.6.1;

public class vrf
  implements tbz<tbu>
{
  public vrf(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void a(boolean paramBoolean, tbu paramtbu)
  {
    ved.b("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate.");
    if ((paramBoolean) && (paramtbu != null))
    {
      ved.a("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate success, address=%s", paramtbu);
      this.a.a.post(new EditVideoMusicDialog.6.1(this, paramtbu));
      return;
    }
    ved.e("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vrf
 * JD-Core Version:    0.7.0.1
 */