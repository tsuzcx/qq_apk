import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public class vhh
  implements vgw<Object, SuperPlayerVideoInfo>
{
  public vgu<Object, SuperPlayerVideoInfo> a()
  {
    return new vhj();
  }
  
  public vgv a(Context paramContext, vhc paramvhc)
  {
    paramvhc = null;
    if (bapt.a()) {
      paramvhc = SuperPlayerFactory.createMediaPlayer(paramContext, 112, null);
    }
    return new vhi(paramvhc);
  }
  
  public vgy a(Context paramContext)
  {
    if (bapt.a()) {}
    for (paramContext = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getContext(), 112);; paramContext = null) {
      return new vhk(paramContext);
    }
  }
  
  public vhc a(Context paramContext, boolean paramBoolean)
  {
    if (bapt.a()) {}
    for (paramContext = SuperPlayerFactory.createPlayerVideoView(paramContext);; paramContext = null) {
      return new vhm(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhh
 * JD-Core Version:    0.7.0.1
 */