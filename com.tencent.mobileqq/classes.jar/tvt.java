import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class tvt
  implements san
{
  public tvt(BridgeModule paramBridgeModule) {}
  
  public void a(UgcVideo paramUgcVideo)
  {
    QQAppInterface localQQAppInterface = pnn.a();
    QLog.i(BridgeModule.TAG, 1, "onPublish, title =" + paramUgcVideo.title);
    if (localQQAppInterface == null) {}
    String str;
    do
    {
      return;
      str = (String)BridgeModule.access$1500(this.a).get(Long.valueOf(0L));
      if ((str != null) && (!str.isEmpty())) {
        sad.a(localQQAppInterface).a(0L, new tvu(this, str));
      }
      str = (String)BridgeModule.access$1500(this.a).get(Long.valueOf(paramUgcVideo.columnId));
    } while ((str == null) || (str.isEmpty()));
    sad.a(localQQAppInterface).a(paramUgcVideo.columnId, new tvv(this, paramUgcVideo, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tvt
 * JD-Core Version:    0.7.0.1
 */