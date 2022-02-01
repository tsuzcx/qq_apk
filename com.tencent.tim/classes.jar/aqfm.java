import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.SystemDragUtils.1.1;

public final class aqfm
  implements View.OnDragListener
{
  aqfm(ImageView paramImageView, ColorDrawable paramColorDrawable1, ViewGroup paramViewGroup, ColorDrawable paramColorDrawable2, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    paramView = Looper.getMainLooper();
    if (Thread.currentThread() != paramView.getThread())
    {
      aurs.runOnUiThread(new SystemDragUtils.1.1(this, paramDragEvent));
      return true;
    }
    return aqfl.b(paramDragEvent, this.val$imageView, this.q, this.eI, this.r, this.val$context, this.val$app, this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfm
 * JD-Core Version:    0.7.0.1
 */