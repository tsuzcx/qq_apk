import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog.6.1;

public class zhm
  implements wsh<wsc>
{
  public zhm(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void a(boolean paramBoolean, wsc paramwsc)
  {
    yuk.b("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate.");
    if ((paramBoolean) && (paramwsc != null))
    {
      yuk.a("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate success, address=%s", paramwsc);
      this.a.a.post(new EditVideoMusicDialog.6.1(this, paramwsc));
      return;
    }
    yuk.e("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhm
 * JD-Core Version:    0.7.0.1
 */