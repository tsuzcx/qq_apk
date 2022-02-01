import android.content.Context;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ihf
  implements igp
{
  public ihf(VideoController paramVideoController, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, Context paramContext, igs paramigs) {}
  
  public void hz(boolean paramBoolean)
  {
    QLog.d(VideoController.TAG, 2, "onScreenShareRecv onAuthResult auth:" + paramBoolean);
    if (paramBoolean) {
      VideoController.a(this.this$0, this.kU, this.gg, true, this.alP, false, this.kV, this.alQ);
    }
    for (;;)
    {
      this.b.a(null);
      return;
      QLog.e(VideoController.TAG, 2, "onScreenShareRecv fail to auth");
      QQToast.a(this.val$context, 1, 2131698071, 1).show();
    }
  }
  
  public void onCancel()
  {
    QLog.d(VideoController.TAG, 2, "onScreenShareRecv onCancel");
    this.b.a(null);
    QQToast.a(this.val$context, 1, 2131698071, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihf
 * JD-Core Version:    0.7.0.1
 */