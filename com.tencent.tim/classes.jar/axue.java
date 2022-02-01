import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.b;

class axue
  implements DynamicTextConfigManager.b
{
  axue(axud paramaxud) {}
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText onUpdateProgress, progress is : " + paramFloat);
    }
    axud.a(this.this$0, paramFloat);
  }
  
  public void bd(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText onDownloadFinish, success: " + paramBoolean);
    }
    if (paramBoolean)
    {
      axud.a(this.this$0, 3);
      this.this$0.eNJ();
      return;
    }
    axud.a(this.this$0, 2);
    this.this$0.aeD(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axue
 * JD-Core Version:    0.7.0.1
 */