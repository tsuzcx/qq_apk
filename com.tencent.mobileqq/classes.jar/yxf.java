import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog.6.1;

public class yxf
  implements wis<win>
{
  public yxf(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void a(boolean paramBoolean, win paramwin)
  {
    ykq.b("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate.");
    if ((paramBoolean) && (paramwin != null))
    {
      ykq.a("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate success, address=%s", paramwin);
      this.a.a.post(new EditVideoMusicDialog.6.1(this, paramwin));
      return;
    }
    ykq.e("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxf
 * JD-Core Version:    0.7.0.1
 */