import android.os.Message;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager.a;
import dov.com.qq.im.capture.view.MusicProviderView;

public class axwx
  implements QIMMusicConfigManager.a
{
  public axwx(MusicProviderView paramMusicProviderView) {}
  
  public void bI(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "onStep:" + paramInt + " done:" + paramBoolean);
    }
    if ((paramInt == 6) || (paramInt == 5) || (paramInt == 4)) {
      this.this$0.b.sendEmptyMessage(3);
    }
  }
  
  public void f(MusicItemInfo paramMusicItemInfo)
  {
    Message localMessage = this.this$0.b.obtainMessage();
    localMessage.obj = paramMusicItemInfo;
    localMessage.what = 4;
    this.this$0.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axwx
 * JD-Core Version:    0.7.0.1
 */