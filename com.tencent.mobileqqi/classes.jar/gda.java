import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;

public class gda
  extends IQQPlayerCallback.Stub
{
  public gda(MusicGeneWebViewPlugin paramMusicGeneWebViewPlugin) {}
  
  public void a(int paramInt)
  {
    MusicGeneWebViewPlugin.a(this.a, paramInt);
    if (paramInt == 2) {
      MusicGeneWebViewPlugin.a(this.a, MusicGeneWebViewPlugin.a(this.a).c());
    }
  }
  
  public void a(SongInfo paramSongInfo)
  {
    if (MusicGeneWebViewPlugin.a(this.a) != null) {
      MusicGeneWebViewPlugin.a(this.a, MusicGeneWebViewPlugin.a(this.a).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gda
 * JD-Core Version:    0.7.0.1
 */