import com.tencent.av.VideoController.a;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;

public class jfg
  implements VideoController.a
{
  public jfg(VideoLayerUI paramVideoLayerUI, int paramInt, boolean paramBoolean) {}
  
  public void amh()
  {
    if ((this.this$0.a != null) && (this.this$0.a.length > this.val$index))
    {
      jjb.a("switch_camera", "switchCameraFristData", 3, new Object[0]);
      VideoLayerUI.b(this.this$0, this.this$0.a[this.val$index], this.YC);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.this$0.TAG, 2, "switchCameraFristData Error : Index = " + this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfg
 * JD-Core Version:    0.7.0.1
 */