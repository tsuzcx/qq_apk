import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public class usw
  implements usl<Object, SuperPlayerVideoInfo>
{
  public usj<Object, SuperPlayerVideoInfo> a()
  {
    return new usy();
  }
  
  public usk a(Context paramContext, usr paramusr)
  {
    paramusr = null;
    if (azjl.a()) {
      paramusr = SuperPlayerFactory.createMediaPlayer(paramContext, 112, null);
    }
    return new usx(paramusr);
  }
  
  public usn a(Context paramContext)
  {
    if (azjl.a()) {}
    for (paramContext = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getContext(), 112);; paramContext = null) {
      return new usz(paramContext);
    }
  }
  
  public usr a(Context paramContext, boolean paramBoolean)
  {
    if (azjl.a()) {}
    for (paramContext = SuperPlayerFactory.createPlayerVideoView(paramContext);; paramContext = null) {
      return new utb(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usw
 * JD-Core Version:    0.7.0.1
 */