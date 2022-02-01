import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.3.1;
import com.tencent.qphone.base.util.QLog;

public class zso
  implements znv
{
  zso(zsl paramzsl) {}
  
  public void a(boolean paramBoolean, Drawable paramDrawable)
  {
    if ((paramBoolean) && ((paramDrawable instanceof AnimationDrawable)))
    {
      paramDrawable = (AnimationDrawable)paramDrawable;
      if (zsl.a(this.a) != null) {
        zsl.f(this.a).runOnUiThread(new DetailBaseBlock.3.1(this, paramDrawable));
      }
      return;
    }
    QLog.d(zsl.a, 2, "showFollowTipView error, create animationDrawable error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zso
 * JD-Core Version:    0.7.0.1
 */