import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.b;
import com.tencent.widget.AbsListView;

public class zpk
  extends AvatarPendantActivity.b
{
  public zpk(AvatarPendantActivity paramAvatarPendantActivity)
  {
    super(paramAvatarPendantActivity);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.this$0.cee == AvatarPendantActivity.ced) {}
    while (Build.VERSION.SDK_INT < 14) {
      return;
    }
    this.this$0.cqJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpk
 * JD-Core Version:    0.7.0.1
 */