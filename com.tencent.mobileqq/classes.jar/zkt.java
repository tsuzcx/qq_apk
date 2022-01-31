import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.qphone.base.util.QLog;

public class zkt
  implements Runnable
{
  public zkt(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void run()
  {
    Object localObject1 = this.a.getActivity();
    if ((FrameHelperActivity.a(this.a)) || (localObject1 == null) || (((FragmentActivity)localObject1).app == null)) {
      return;
    }
    Object localObject2 = this.a.getActivity().app.getCurrentAccountUin();
    Drawable localDrawable = FaceDrawable.a(1, 3);
    localObject1 = FaceDrawable.a(((FragmentActivity)localObject1).app, 1, (String)localObject2, 3, localDrawable, localDrawable, null);
    this.a.a.obtainMessage(12, localObject1).sendToTarget();
    localObject2 = new StringBuilder().append("FrameHelperActivity, updateSelfFace:");
    if (localObject1 != null) {}
    for (localObject1 = ((FaceDrawable)localObject1).a();; localObject1 = "")
    {
      QLog.i("Q.qqhead.freq", 1, localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zkt
 * JD-Core Version:    0.7.0.1
 */