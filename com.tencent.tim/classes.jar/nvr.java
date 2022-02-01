import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class nvr
  implements mix.a
{
  nvr(nvq paramnvq, UgcVideo paramUgcVideo, List paramList) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      mnw.a(this.a.val$app).a(this.d, true);
      BridgeModule.access$1300(this.a.this$0, this.a.aTI, this.jq, this.a.val$callbackId, 0, "");
    }
    for (;;)
    {
      QLog.i(BridgeModule.TAG, 1, "showMobileNetworkDialog, isContinue=" + paramBoolean);
      return;
      BridgeModule.access$1300(this.a.this$0, this.a.aTI, this.jq, this.a.val$callbackId, -2, "cancel upload by user on mobile net");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvr
 * JD-Core Version:    0.7.0.1
 */