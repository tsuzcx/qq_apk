import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView;

public class axsh
  extends axrh
{
  public axsh(BgmRecognitionProviderView paramBgmRecognitionProviderView) {}
  
  public void ax(String paramString, boolean paramBoolean)
  {
    arxa.a().showToast(acfp.m(2131703178) + this.this$0.f);
  }
  
  public void c(String paramString, boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (this.this$0.f.getLocalPath().equals(paramString))) {
      BgmRecognitionProviderView.a(this.this$0).sendEmptyMessage(1003);
    }
  }
  
  public void onCancel(String paramString) {}
  
  public void onProgress(String paramString, int paramInt) {}
  
  public void vS(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axsh
 * JD-Core Version:    0.7.0.1
 */