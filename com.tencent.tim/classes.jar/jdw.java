import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jdw
  extends iya
{
  public jdw(VideoControlUI paramVideoControlUI, long paramLong1, long paramLong2) {}
  
  protected void a(long paramLong, boolean paramBoolean, String paramString)
  {
    if (this.this$0.isDestroyed()) {
      if (this.this$0.mApp != null) {
        this.this$0.mApp.deleteObserver(this);
      }
    }
    do
    {
      do
      {
        return;
        QLog.w(this.this$0.TAG, 1, "onNotify_ScreenShot_Finish, flag[" + this.oV + "], _flag[" + paramLong + "], path[" + paramString + "], ret[" + paramBoolean + "], seq[" + this.kQ + "]");
      } while (this.oV != paramLong);
      if (paramBoolean) {
        amiw.bP((Context)this.this$0.mContext.get(), paramString);
      }
    } while (this.this$0.mApp == null);
    this.this$0.mApp.deleteObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdw
 * JD-Core Version:    0.7.0.1
 */