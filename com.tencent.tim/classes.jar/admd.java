import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class admd
  implements View.OnClickListener
{
  public admd(QRScanEntryView paramQRScanEntryView) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = false;
    boolean bool1;
    if (QRScanEntryView.a(this.this$0))
    {
      Object localObject = adkt.a();
      if (!QRScanEntryView.b(this.this$0))
      {
        bool1 = true;
        if (((adkt)localObject).ba(bool1))
        {
          localObject = this.this$0;
          if (QRScanEntryView.b(this.this$0)) {
            break label131;
          }
          bool1 = true;
          label56:
          QRScanEntryView.a((QRScanEntryView)localObject, bool1);
          localObject = (adkv)this.this$0.a;
          bool1 = bool2;
          if (!QRScanEntryView.b(this.this$0)) {
            bool1 = true;
          }
          ((adkv)localObject).I(bool1, 0L);
          QRScanEntryView.a(this.this$0, true);
          QRScanEntryView.b(this.this$0, QRScanEntryView.b(this.this$0));
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool1 = false;
      break;
      label131:
      bool1 = false;
      break label56;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_QRScanEntryView", 2, "initView click mFlashLightTips when view invisble.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     admd
 * JD-Core Version:    0.7.0.1
 */