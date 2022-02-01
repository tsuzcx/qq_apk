import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.share.GameShareUtil.2.1;
import cooperation.qwallet.plugin.QWalletPicHelper.OnDecodeListener;
import mqq.util.WeakReference;

public final class ahtt
  implements QWalletPicHelper.OnDecodeListener
{
  ahtt(WeakReference paramWeakReference1, WeakReference paramWeakReference2, WeakReference paramWeakReference3, long paramLong1, long paramLong2) {}
  
  public void onDecodeFinished(boolean paramBoolean, Drawable paramDrawable)
  {
    ThreadManager.getUIHandlerV2().post(new GameShareUtil.2.1(this, paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahtt
 * JD-Core Version:    0.7.0.1
 */