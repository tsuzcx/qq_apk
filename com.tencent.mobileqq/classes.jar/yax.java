import android.os.Handler;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.model.DataProvider.DataUpdateListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;

public class yax
  implements DataProvider.DataUpdateListener
{
  public yax(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void a(boolean paramBoolean, AddressDataProvider.AddressInfo paramAddressInfo)
  {
    SLog.b("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate.");
    if ((paramBoolean) && (paramAddressInfo != null))
    {
      SLog.a("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate success, address=%s", paramAddressInfo);
      this.a.a.post(new yay(this, paramAddressInfo));
      return;
    }
    SLog.e("Q.qqstory.publish.edit.EditVideoMusicDialog", "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yax
 * JD-Core Version:    0.7.0.1
 */