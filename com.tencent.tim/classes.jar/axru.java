import android.content.Intent;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import dov.com.qq.im.capture.music.humrecognition.HummingActivity;

public class axru
  extends axrh
{
  public axru(HummingActivity paramHummingActivity) {}
  
  public void ax(String paramString, boolean paramBoolean)
  {
    arxa.a().showToast(acfp.m(2131707324) + HummingActivity.a(this.this$0), 0);
  }
  
  public void c(String paramString, boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramString != null) && (HummingActivity.a(this.this$0).getLocalPath().equals(paramString)))
    {
      paramString = new Intent();
      paramString.putExtra("EXTRA_HUM_RECOGNITION_RESULT", HummingActivity.a(this.this$0));
      this.this$0.setResult(-1, paramString);
      this.this$0.finish();
    }
  }
  
  public void onCancel(String paramString) {}
  
  public void onProgress(String paramString, int paramInt) {}
  
  public void vS(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axru
 * JD-Core Version:    0.7.0.1
 */