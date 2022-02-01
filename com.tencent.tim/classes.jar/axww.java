import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView.a;

public class axww
  implements axrk
{
  public axww(MusicProviderView paramMusicProviderView) {}
  
  public void d(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "requestMusicSuccess mListener= " + this.this$0.c);
    }
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
  
  public void e(int paramInt, MusicItemInfo paramMusicItemInfo) {}
  
  public void e(MusicItemInfo paramMusicItemInfo) {}
  
  public void f(int paramInt, MusicItemInfo paramMusicItemInfo)
  {
    if ((paramInt != -1) && (MusicProviderView.a(this.this$0) != null)) {
      MusicProviderView.a(this.this$0).eOr();
    }
  }
  
  public void g(int paramInt, MusicItemInfo paramMusicItemInfo) {}
  
  public void h(int paramInt, MusicItemInfo paramMusicItemInfo) {}
  
  public void stopMusic()
  {
    this.this$0.b.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axww
 * JD-Core Version:    0.7.0.1
 */