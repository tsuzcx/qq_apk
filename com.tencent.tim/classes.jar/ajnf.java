import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;

public class ajnf
  implements ajmq.a
{
  public ajnf(MusicPlayerActivity paramMusicPlayerActivity) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, Object paramObject)
  {
    paramString = Message.obtain(MusicPlayerActivity.a(this.a), 49);
    Bundle localBundle = new Bundle();
    localBundle.putIntArray("KEY_COLOR_LIST", new int[] { paramInt1, paramInt2 });
    localBundle.putBoolean("KEY_MATCH_SONG", ((Boolean)paramObject).booleanValue());
    paramString.setData(localBundle);
    paramString.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajnf
 * JD-Core Version:    0.7.0.1
 */