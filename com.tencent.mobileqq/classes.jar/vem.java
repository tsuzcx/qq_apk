import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog.6.1;

public class vem
  implements spg<spb>
{
  public vem(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void a(boolean paramBoolean, spb paramspb)
  {
    urk.b("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate.");
    if ((paramBoolean) && (paramspb != null))
    {
      urk.a("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate success, address=%s", paramspb);
      this.a.a.post(new EditVideoMusicDialog.6.1(this, paramspb));
      return;
    }
    urk.e("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vem
 * JD-Core Version:    0.7.0.1
 */