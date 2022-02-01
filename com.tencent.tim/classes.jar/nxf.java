import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.16.1;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.a;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.c;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class nxf
  implements ViolaBaseView.a
{
  public nxf(ViolaBaseView paramViolaBaseView, boolean paramBoolean) {}
  
  public void bbs()
  {
    if (ViolaBaseView.a(this.this$0) != null) {
      ViolaBaseView.a(this.this$0).bce();
    }
    ViolaBaseView.a(this.this$0, 2, this.avr);
  }
  
  public void oD(String paramString)
  {
    if (TextUtils.isEmpty(ViolaBaseView.b(this.this$0))) {
      ViolaBaseView.a(this.this$0, paramString, this.avr);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        ThreadManager.post(new ViolaBaseView.16.1(this, paramString), 8, null, true);
      }
      return;
      if (!this.avr) {
        ViolaBaseView.a(this.this$0, paramString, this.avr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxf
 * JD-Core Version:    0.7.0.1
 */