import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class nvo
  implements mnw.a
{
  public nvo(BridgeModule paramBridgeModule, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2) {}
  
  public void bl(@NotNull List<UgcVideo> paramList)
  {
    Iterator localIterator = paramList.iterator();
    UgcVideo localUgcVideo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localUgcVideo = (UgcVideo)localIterator.next();
    } while (!TextUtils.equals(localUgcVideo.seqId, this.val$vid));
    for (;;)
    {
      if (localUgcVideo != null)
      {
        kbp.bp("0X800AC61", mix.a(this.val$app, this.val$pageType, localUgcVideo.publicType).build());
        mnw.a(this.val$app).d(localUgcVideo);
        BridgeModule.access$1300(this.this$0, this.aTI, paramList, this.val$callbackId, 0, "");
        return;
      }
      BridgeModule.access$1300(this.this$0, this.aTI, paramList, this.val$callbackId, -1, "ugcVideo not exist");
      return;
      localUgcVideo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvo
 * JD-Core Version:    0.7.0.1
 */