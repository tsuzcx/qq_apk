import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

class adgz
  implements adgp.b
{
  adgz(adgy paramadgy) {}
  
  public void a(adhf paramadhf)
  {
    adgy.f(this.this$0, false);
    if (adgy.a(this.this$0)) {
      return;
    }
    if (adgy.a(this.this$0) != null) {
      adgy.a(this.this$0).removeMessages(2);
    }
    QLog.i("AREngine_ARCloudControl", 1, "onARCloudLBSLocationCheckComplete. retCode = " + paramadhf.retCode + ", imageId = " + paramadhf.imageId);
    if (adgy.a(this.this$0) != null)
    {
      adhr.a(this.this$0.b.recognitions, adgy.a(this.this$0), paramadhf);
      adgy.a(this.this$0).b(0, adgy.a(this.this$0));
    }
    adgy.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adgz
 * JD-Core Version:    0.7.0.1
 */