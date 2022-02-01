import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class nvp
  implements mnw.a
{
  public nvp(BridgeModule paramBridgeModule, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2) {}
  
  public void bl(@NotNull List<UgcVideo> paramList)
  {
    kxm.b localb = null;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    do
    {
      localObject = localb;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (UgcVideo)localIterator.next();
    } while (!TextUtils.equals(((UgcVideo)localObject).seqId, this.val$vid));
    if (localObject != null)
    {
      paramList.remove(localObject);
      localb = mix.a(this.val$app, this.val$pageType, ((UgcVideo)localObject).publicType).a(mix.a(this.val$app, (UgcVideo)localObject).x());
      if (((UgcVideo)localObject).reprintDisable) {}
      for (int i = 0;; i = 1)
      {
        kbp.bp("0X800AC64", localb.a("reprint_flag", Integer.valueOf(i)).a("compress_time", Long.valueOf(((UgcVideo)localObject).compressTime)).a("upload_time", Long.valueOf(((UgcVideo)localObject).uploadTotalCostTime)).a("wait_time", Long.valueOf(((UgcVideo)localObject).userWaitingTotalCostTime)).build());
        mnw.a(this.val$app).c((UgcVideo)localObject);
        BridgeModule.access$1300(this.this$0, this.aTI, paramList, this.val$callbackId, 0, "");
        return;
      }
    }
    BridgeModule.access$1300(this.this$0, this.aTI, paramList, this.val$callbackId, -1, "ugcVideo not exist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvp
 * JD-Core Version:    0.7.0.1
 */