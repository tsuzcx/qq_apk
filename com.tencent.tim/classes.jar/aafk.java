import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyRedPacketAnimMsg.3.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aafk
  implements PreloadManager.d
{
  aafk(aafi paramaafi, WeakReference paramWeakReference1, anyo.a parama, WeakReference paramWeakReference2) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      ThreadManager.getUIHandler().post(new SpecifyRedPacketAnimMsg.3.1(this, paramPathResult));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SpecifyRedPacketAnimMsg", 2, "showAnim start playVideo err: download fail");
    }
    this.c.byj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aafk
 * JD-Core Version:    0.7.0.1
 */