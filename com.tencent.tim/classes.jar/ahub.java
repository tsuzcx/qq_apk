import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.qphone.base.util.QLog;

final class ahub
  implements PreloadManager.d
{
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameHelper", 1, "dowloadFullPopRes complete! rescpde=" + paramInt);
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)) && (QLog.isColorLevel())) {
      QLog.d("QQGameHelper", 1, "dowloadFullPopRes fileUrl=" + paramPathResult.url + " unzipPath=" + paramPathResult.folderPath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahub
 * JD-Core Version:    0.7.0.1
 */