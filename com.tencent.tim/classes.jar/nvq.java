import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class nvq
  implements mnw.a
{
  public nvq(BridgeModule paramBridgeModule, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2) {}
  
  public void bl(@NotNull List<UgcVideo> paramList)
  {
    Object localObject = paramList.iterator();
    UgcVideo localUgcVideo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localUgcVideo = (UgcVideo)((Iterator)localObject).next();
    } while (!TextUtils.equals(localUgcVideo.seqId, this.val$vid));
    for (;;)
    {
      if (localUgcVideo != null)
      {
        localObject = mix.a(this.val$app, this.val$pageType, localUgcVideo.publicType).build();
        if (localUgcVideo.status == UgcVideo.STATUS_PAUSE) {
          kbp.bp("0X800AC62", (String)localObject);
        }
        while ((aqiw.isMobileNetWork(BaseApplicationImpl.getContext())) && (BaseActivity.sTopActivity != null))
        {
          long l = mix.a(localUgcVideo);
          if (l > 0L)
          {
            mix.a(BaseActivity.sTopActivity, l, new nvr(this, localUgcVideo, paramList), null);
            return;
            if (localUgcVideo.status == UgcVideo.STATUS_FAILED) {
              kbp.bp("0X800AC63", (String)localObject);
            }
          }
          else
          {
            mnw.a(this.val$app).a(localUgcVideo, true);
            BridgeModule.access$1300(this.this$0, this.aTI, paramList, this.val$callbackId, 0, "");
            return;
          }
        }
        mnw.a(this.val$app).a(localUgcVideo, true);
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
 * Qualified Name:     nvq
 * JD-Core Version:    0.7.0.1
 */