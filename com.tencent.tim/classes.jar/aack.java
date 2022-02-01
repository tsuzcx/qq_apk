import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.c;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.e;
import java.util.HashMap;
import java.util.List;

public class aack
  implements PreloadManager.d
{
  public aack(PreloadManager.c paramc) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    int i = 1;
    PreloadManager.c localc = this.a;
    localc.cgf += 1;
    if (paramInt == 0)
    {
      this.a.hO.put(paramPathResult.url, paramPathResult);
      if ((this.a.cgf >= this.a.params.size()) && (this.a.a != null))
      {
        paramPathResult = this.a.a;
        if (!this.a.isFailed) {
          break label118;
        }
      }
    }
    label118:
    for (paramInt = i;; paramInt = 0)
    {
      paramPathResult.b(paramInt, this.a.hO);
      return;
      this.a.isFailed = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aack
 * JD-Core Version:    0.7.0.1
 */