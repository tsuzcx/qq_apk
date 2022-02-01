import android.os.Bundle;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.QLog;

public class adxw
  extends aquy
{
  public adxw(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onCancel(aquz paramaquz)
  {
    String str = paramaquz.getParams().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onCancel pkgName = " + str);
    }
    this.this$0.a("Bubble_download_cancel", paramaquz.getId(), str, 0L);
  }
  
  public void onDone(aquz paramaquz)
  {
    long l = paramaquz.aua - paramaquz.atZ;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onDone downloadTime = " + l);
    }
    this.this$0.a("Bubble_download_succ", paramaquz.getId(), "pkgName", l);
  }
  
  public boolean onStart(aquz paramaquz)
  {
    String str = paramaquz.getParams().getString("name");
    if (QLog.isColorLevel()) {
      QLog.i("BubbleManager", 2, "bubbleDownloadListener onStart pkgName = " + str);
    }
    this.this$0.a("Bubble_download", paramaquz.getId(), str, 0L);
    super.onStart(paramaquz);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxw
 * JD-Core Version:    0.7.0.1
 */