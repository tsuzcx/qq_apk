import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.qphone.base.util.QLog;

public class ahuy
  implements PreloadManager.d
{
  public ahuy(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath))) {
      QLog.d("GameWebPage", 1, "loading apng download succ!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahuy
 * JD-Core Version:    0.7.0.1
 */