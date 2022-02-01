import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import java.util.List;
import java.util.Map;

class zxv
  implements PreloadManager.d
{
  zxv(zxt paramzxt, AppInterface paramAppInterface) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    List localList = (List)zxt.a(this.this$0).get(paramPathResult.url);
    if (paramPathResult.url.endsWith(".zip")) {
      zxt.a(this.this$0, this.b, paramPathResult.url, paramPathResult.folderPath, localList);
    }
    while (!paramPathResult.url.endsWith(".png")) {
      return;
    }
    zxt.a(this.this$0, this.b, paramPathResult.url, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxv
 * JD-Core Version:    0.7.0.1
 */