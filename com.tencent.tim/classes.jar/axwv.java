import android.os.SystemClock;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.MusicProviderView;

public class axwv
  extends axrh
{
  public axwv(MusicProviderView paramMusicProviderView) {}
  
  public void ax(String paramString, boolean paramBoolean)
  {
    this.this$0.b.sendEmptyMessage(2);
  }
  
  public void c(String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, new Object[] { "onFinish, succ:", Boolean.valueOf(paramBoolean), ", failcode:", Integer.valueOf(paramInt) });
    }
    this.this$0.b.sendEmptyMessage(2);
    if ((paramBoolean) && (this.this$0.e != null) && (this.this$0.e.getLocalPath().equals(paramString))) {
      this.this$0.b.sendEmptyMessage(1);
    }
    if ((!paramBoolean) && (paramInt == -104)) {
      this.this$0.b.sendEmptyMessage(5);
    }
  }
  
  public void onCancel(String paramString) {}
  
  public void onProgress(String paramString, int paramInt)
  {
    long l = SystemClock.uptimeMillis();
    if ((this.this$0.mLastUpdateTime == 0L) || (l - this.this$0.mLastUpdateTime > 16L))
    {
      this.this$0.b.sendEmptyMessage(2);
      this.this$0.mLastUpdateTime = l;
    }
  }
  
  public void vS(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axwv
 * JD-Core Version:    0.7.0.1
 */