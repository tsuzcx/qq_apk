import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import java.util.ArrayList;

public class jan
  implements jcr.e
{
  public jan(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, long paramLong) {}
  
  public void aoD()
  {
    this.this$0.Yc = true;
    this.this$0.auW();
  }
  
  public void aoE()
  {
    iiv localiiv = this.this$0.a.b();
    if (localiiv != null)
    {
      igd.aK(this.this$0.TAG, " TYPE_NOTIFY_CAMERA_CLOSE 2: " + localiiv.PY + "|" + localiiv.amI);
      if (localiiv.PY) {
        this.this$0.c.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(this.kQ) });
      }
    }
    MultiVideoCtrlLayerUI4Discussion.a(this.this$0, this.kQ);
    this.this$0.jg(true);
    if (this.this$0.a.OB)
    {
      this.this$0.a.b(this.this$0.a.alr, this.this$0.a.kJ, 100);
      anot.a(null, "CliOper", "", "", "0X8004CF2", "0X8004CF2", 0, 0, "", "", "", "");
      if (((this.this$0.mLastRotation != 90) && (this.this$0.mLastRotation != 270)) || (this.this$0.a.b().kK() == -1) || (((ioa)this.this$0.a.b().jdField_if.get(0)).videoSrcType != 1)) {
        break label318;
      }
      anot.a(null, "CliOper", "", "", "0X8004CFB", "0X8004CFB", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.this$0.Yc = false;
      return;
      this.this$0.a.b(this.this$0.aqx, this.this$0.md, 101);
      break;
      label318:
      if (((this.this$0.mLastRotation == 90) || (this.this$0.mLastRotation == 270)) && (this.this$0.a.b().kK() != -1) && (((ioa)this.this$0.a.b().jdField_if.get(0)).videoSrcType == 2)) {
        anot.a(null, "CliOper", "", "", "0X8004CFC", "0X8004CFC", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jan
 * JD-Core Version:    0.7.0.1
 */