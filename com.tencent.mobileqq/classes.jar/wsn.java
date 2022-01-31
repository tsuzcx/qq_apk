import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.AnimationScrollListener;
import com.tencent.widget.AbsListView;

public class wsn
  extends AvatarPendantActivity.AnimationScrollListener
{
  public wsn(AvatarPendantActivity paramAvatarPendantActivity)
  {
    super(paramAvatarPendantActivity);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.e == AvatarPendantActivity.d) {}
    while (Build.VERSION.SDK_INT < 14) {
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsn
 * JD-Core Version:    0.7.0.1
 */