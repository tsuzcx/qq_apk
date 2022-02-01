import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class nvn
  implements mnw.a
{
  public nvn(BridgeModule paramBridgeModule, long paramLong, String paramString) {}
  
  public void bl(@NotNull List<UgcVideo> paramList)
  {
    if (!paramList.isEmpty()) {
      BridgeModule.access$1300(this.this$0, this.wh, paramList, this.val$callbackId, 0, "");
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(BridgeModule.TAG, 2, "getUploadingVideoList,ugcVideoList.isEmpty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvn
 * JD-Core Version:    0.7.0.1
 */