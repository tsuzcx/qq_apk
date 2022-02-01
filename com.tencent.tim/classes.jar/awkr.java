import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ad.TianshuBigInsertPage.4.1;

public class awkr
  implements PreloadManager.d
{
  awkr(awkn paramawkn) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TianshuBigInsertPage", 2, "onResult: " + paramInt + ", path: " + paramPathResult.filePath);
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.filePath))) {
      awkn.a(this.b).a().runOnUiThread(new TianshuBigInsertPage.4.1(this, paramPathResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awkr
 * JD-Core Version:    0.7.0.1
 */