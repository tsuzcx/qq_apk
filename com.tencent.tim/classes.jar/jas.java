import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import java.util.ArrayList;

public class jas
  implements jcr.e
{
  public jas(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat, long paramLong) {}
  
  public void aoD()
  {
    this.this$0.Yc = true;
    this.this$0.auW();
  }
  
  public void aoE()
  {
    anot.a(null, "CliOper", "", "", "0X800592D", "0X800592D", 0, 0, "", "", "", "");
    if (((this.this$0.mLastRotation == 90) || (this.this$0.mLastRotation == 270)) && (this.this$0.a.b().kK() != -1) && (((ioa)this.this$0.a.b().jdField_if.get(0)).videoSrcType == 1))
    {
      anot.a(null, "CliOper", "", "", "0X800594D", "0X800594D", 0, 0, "", "", "", "");
      iiv localiiv = this.this$0.a.b();
      if (localiiv != null)
      {
        igd.aK(this.this$0.TAG, " TYPE_NOTIFY_CAMERA_CLOSE: " + localiiv.PY + "|" + localiiv.amI);
        if (localiiv.PY) {
          this.this$0.c.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(this.kQ) });
        }
      }
      MultiVideoCtrlLayerUI4NewGroupChat.a(this.this$0, this.kQ);
      MultiVideoCtrlLayerUI4NewGroupChat.a(this.this$0, true);
      if (!this.this$0.a.OB) {
        break label385;
      }
      this.this$0.a.b(this.this$0.a.alr, this.this$0.a.kJ, 100);
    }
    for (;;)
    {
      this.this$0.Yc = false;
      return;
      if (((this.this$0.mLastRotation != 90) && (this.this$0.mLastRotation != 270)) || (this.this$0.a.b().kK() == -1) || (((ioa)this.this$0.a.b().jdField_if.get(0)).videoSrcType != 2)) {
        break;
      }
      anot.a(null, "CliOper", "", "", "0X800594E", "0X800594E", 0, 0, "", "", "", "");
      break;
      label385:
      this.this$0.a.b(this.this$0.aqx, this.this$0.md, 101);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jas
 * JD-Core Version:    0.7.0.1
 */