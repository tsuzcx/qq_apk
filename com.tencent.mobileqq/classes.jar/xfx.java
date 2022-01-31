import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog.6.1;

public class xfx
  implements uqr<uqm>
{
  public xfx(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void a(boolean paramBoolean, uqm paramuqm)
  {
    wsv.b("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate.");
    if ((paramBoolean) && (paramuqm != null))
    {
      wsv.a("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate success, address=%s", paramuqm);
      this.a.a.post(new EditVideoMusicDialog.6.1(this, paramuqm));
      return;
    }
    wsv.e("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xfx
 * JD-Core Version:    0.7.0.1
 */