import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel.a;
import dov.com.qq.im.ae.mode.AECaptureMode;

class awtw
  implements AEMaterialPanel.a
{
  awtw(awtq paramawtq) {}
  
  public void a(axbu paramaxbu)
  {
    if (awtq.b(this.this$0) == AECaptureMode.NORMAL)
    {
      awtq.a(this.this$0).b(paramaxbu);
      return;
    }
    axiy.e("AEPituCameraUnit", "onMaterialSelected---but current capture mode is not normal");
  }
  
  public void eGk()
  {
    awtq.a(this.this$0).b(null);
  }
  
  public void eGl() {}
  
  public void eGm() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awtw
 * JD-Core Version:    0.7.0.1
 */