import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.MusicFragmentProviderView;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class axwr
  extends axrh
{
  public axwr(MusicFragmentProviderView paramMusicFragmentProviderView) {}
  
  public void ax(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.this$0.aeO(-115);
      MusicFragmentProviderView.a(this.this$0).set(false);
    }
  }
  
  public void c(String paramString, boolean paramBoolean, int paramInt)
  {
    this.this$0.aeO(paramInt);
    if ((paramBoolean) && (MusicFragmentProviderView.a(this.this$0) != null) && (MusicFragmentProviderView.a(this.this$0).getLocalPath().equals(paramString)))
    {
      MusicFragmentProviderView.a(this.this$0).musicStart = 0;
      MusicFragmentProviderView.a(this.this$0).musicEnd = (MusicFragmentProviderView.a(this.this$0).musicStart + MusicFragmentProviderView.a(this.this$0));
      MusicFragmentProviderView.a(this.this$0).musicDuration = ((int)ShortVideoUtils.getDuration(MusicFragmentProviderView.a(this.this$0).getLocalPath()));
      if (MusicFragmentProviderView.a(this.this$0).musicEnd > MusicFragmentProviderView.a(this.this$0).musicDuration) {
        MusicFragmentProviderView.a(this.this$0).musicEnd = MusicFragmentProviderView.a(this.this$0).musicDuration;
      }
      MusicFragmentProviderView.a(this.this$0, MusicFragmentProviderView.a(this.this$0).musicStart);
      MusicFragmentProviderView.b(this.this$0, MusicFragmentProviderView.a(this.this$0).musicEnd);
      paramString = (QIMMusicConfigManager)axov.a(2);
      MusicItemInfo localMusicItemInfo = paramString.b(MusicFragmentProviderView.a(this.this$0).mItemId);
      if (localMusicItemInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MusicFragmentProviderView", 2, "music exist name =" + localMusicItemInfo.mMusicName);
        }
        paramString.a(MusicFragmentProviderView.a(this.this$0), false);
      }
      if (this.this$0.b != null) {
        this.this$0.b.sendEmptyMessage(2);
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder("onFinish musicStart=").append(MusicFragmentProviderView.a(this.this$0).musicStart);
        paramString.append(" musicEnd=").append(MusicFragmentProviderView.a(this.this$0).musicEnd);
        paramString.append(" musicDuration").append(MusicFragmentProviderView.a(this.this$0).musicDuration);
        paramString.append(" premusicStart").append(MusicFragmentProviderView.b(this.this$0));
        paramString.append(" premusicEnd").append(MusicFragmentProviderView.c(this.this$0));
        paramString.append(" musicName").append(MusicFragmentProviderView.a(this.this$0).mMusicName);
        QLog.d("MusicFragmentProviderView", 2, paramString.toString());
      }
    }
    MusicFragmentProviderView.a(this.this$0).set(false);
  }
  
  public void onCancel(String paramString)
  {
    if ((MusicFragmentProviderView.a(this.this$0) != null) && (MusicFragmentProviderView.a(this.this$0).getLocalPath().equals(paramString)))
    {
      MusicFragmentProviderView.a(this.this$0).mProgress = -1;
      if (this.this$0.b != null) {
        this.this$0.b.sendEmptyMessage(3);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicFragmentProviderView", 2, "download onCancel");
    }
    MusicFragmentProviderView.a(this.this$0).set(false);
  }
  
  public void onProgress(String paramString, int paramInt)
  {
    this.this$0.hl(paramString, paramInt);
    MusicFragmentProviderView.a(this.this$0).set(true);
  }
  
  public void vS(int paramInt)
  {
    this.this$0.aeP(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axwr
 * JD-Core Version:    0.7.0.1
 */