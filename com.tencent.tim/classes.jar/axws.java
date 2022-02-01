import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import dov.com.qq.im.capture.view.MusicFragmentProviderView;
import dov.com.qq.im.capture.view.ProviderView.a;
import java.util.concurrent.atomic.AtomicInteger;

public class axws
  implements axrk
{
  public axws(MusicFragmentProviderView paramMusicFragmentProviderView) {}
  
  public void d(MusicItemInfo paramMusicItemInfo)
  {
    if (this.this$0.c != null)
    {
      if (paramMusicItemInfo.mType == 2) {
        this.this$0.c.onMusicOriginalChange(true);
      }
    }
    else {
      return;
    }
    this.this$0.c.onMusicOriginalChange(false);
  }
  
  public void e(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (paramInt != -1)
    {
      this.this$0.aeN(paramInt);
      MusicFragmentProviderView.a(this.this$0).set(-1);
      this.this$0.bve();
      return;
    }
    this.this$0.bvf();
  }
  
  public void e(MusicItemInfo paramMusicItemInfo) {}
  
  public void f(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    this.this$0.aeN(paramInt);
    if (paramInt != -1)
    {
      MusicFragmentProviderView.a(this.this$0).set(-1);
      this.this$0.bve();
    }
    for (;;)
    {
      if (MusicFragmentProviderView.a(this.this$0) != null) {
        MusicFragmentProviderView.a(this.this$0).eOr();
      }
      return;
      this.this$0.bvf();
    }
  }
  
  public void g(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if (paramInt != -1)
    {
      this.this$0.bve();
      return;
    }
    this.this$0.bvf();
  }
  
  public void h(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    this.this$0.bvf();
  }
  
  public void stopMusic()
  {
    this.this$0.bvf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axws
 * JD-Core Version:    0.7.0.1
 */