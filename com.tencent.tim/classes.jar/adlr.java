import android.os.Handler;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.qphone.base.util.QLog;

public class adlr
  implements adkw.a
{
  public adlr(ARScanEntryView paramARScanEntryView) {}
  
  public void Li(int paramInt)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onARBaseResUpdateProgress " + paramInt + ";" + this.this$0.uA);
    if (!this.this$0.uA) {
      return;
    }
    ARScanEntryView.a(this.this$0, paramInt);
    ARScanEntryView.a(this.this$0);
  }
  
  public void cSK()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onARBaseResDownloadComplete ;" + this.this$0.uA);
    if (!this.this$0.uA) {
      return;
    }
    ARScanEntryView.a(this.this$0, 100);
    ARScanEntryView.a(this.this$0).removeMessages(324);
    ARScanEntryView.a(this.this$0).sendEmptyMessage(324);
    this.this$0.cSI();
  }
  
  public void cSL()
  {
    this.this$0.cSI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adlr
 * JD-Core Version:    0.7.0.1
 */