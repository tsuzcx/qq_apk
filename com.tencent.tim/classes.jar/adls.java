import android.os.Handler;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.qphone.base.util.QLog;

public class adls
  implements adkw.b
{
  public adls(ARScanEntryView paramARScanEntryView) {}
  
  public void Lj(int paramInt)
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onAsyncFaceResUpdateProgress " + paramInt + ";" + this.this$0.uA);
    if (!this.this$0.uA) {
      return;
    }
    ARScanEntryView.b(this.this$0, paramInt);
    ARScanEntryView.a(this.this$0);
  }
  
  public void cSM()
  {
    QLog.d("AREngine_ARScanEntryView", 1, "onAsyncFaceResDownLoadComplete " + this.this$0.uA);
    if (!this.this$0.uA) {
      return;
    }
    ARScanEntryView.b(this.this$0, 100);
    if ((ARScanEntryView.a(this.this$0).a != null) && (ARScanEntryView.a(this.this$0).a.a != null)) {
      ARScanEntryView.a(this.this$0).a.a.cRS();
    }
    if (ARScanEntryView.a(this.this$0) != null)
    {
      ARScanEntryView.a(this.this$0).removeMessages(324);
      ARScanEntryView.a(this.this$0).sendEmptyMessage(324);
    }
    if ((ARScanEntryView.b(this.this$0)) && (this.this$0.a.a().aeY()))
    {
      ARScanEntryView.b(this.this$0);
      QLog.d("AREngine_ARScanEntryView", 1, "everything is ready,so quit update resources");
      return;
    }
    this.this$0.cSI();
  }
  
  public void cSN()
  {
    this.this$0.cSI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adls
 * JD-Core Version:    0.7.0.1
 */