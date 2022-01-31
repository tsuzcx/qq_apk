import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.p2veffect.main.P2VEffectConvertor;
import com.tencent.qphone.base.util.QLog;

public class xto
  implements Runnable
{
  public xto(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity) {}
  
  public void run()
  {
    QLog.d("QzDynamicVideoPreviewActivity", 2, "[run] in resumeRunnable, mIsMusicEnabled = " + QzDynamicVideoPreviewActivity.c(this.a));
    QzDynamicVideoPreviewActivity.a(this.a).requestDraw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xto
 * JD-Core Version:    0.7.0.1
 */