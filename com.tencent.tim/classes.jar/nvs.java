import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class nvs
  implements mnw.c
{
  public nvs(BridgeModule paramBridgeModule) {}
  
  public void i(UgcVideo paramUgcVideo)
  {
    QQAppInterface localQQAppInterface = kxm.a();
    QLog.i(BridgeModule.TAG, 1, "onPublish, title =" + paramUgcVideo.title);
    if (localQQAppInterface == null) {}
    String str;
    do
    {
      return;
      str = (String)BridgeModule.access$1400(this.this$0).get(Long.valueOf(0L));
      if ((str != null) && (!str.isEmpty())) {
        mnw.a(localQQAppInterface).a(0L, new nvt(this, str));
      }
      str = (String)BridgeModule.access$1400(this.this$0).get(Long.valueOf(paramUgcVideo.columnId));
    } while ((str == null) || (str.isEmpty()));
    mnw.a(localQQAppInterface).a(paramUgcVideo.columnId, new nvu(this, paramUgcVideo, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvs
 * JD-Core Version:    0.7.0.1
 */