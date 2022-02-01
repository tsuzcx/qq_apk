import android.os.Bundle;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;

public class ztn
{
  public long Lx;
  public long ap;
  public boolean btf;
  public boolean btg;
  public boolean bth;
  public String[] cJ;
  public long fileSize;
  public int fileType;
  public long id = -1L;
  public boolean isMute;
  public boolean isPlayed;
  public MessageForShortVideo l;
  public Bundle mBundle;
  public ArrayList<String> mCookies;
  public String mDomain;
  public String playUrl;
  public long progress;
  public int subid = -1;
  
  public String pY()
  {
    if (this.l == null) {
      return this.playUrl;
    }
    this.playUrl = null;
    this.playUrl = ShortVideoUtils.a(this.l, "mp4");
    return this.playUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ztn
 * JD-Core Version:    0.7.0.1
 */