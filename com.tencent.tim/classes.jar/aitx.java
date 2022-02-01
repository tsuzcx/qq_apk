import android.app.Dialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import mqq.app.QQPermissionCallback;

public class aitx
  implements QQPermissionCallback
{
  public aitx(LocationShareFragment paramLocationShareFragment, BaseActivity paramBaseActivity, int paramInt1, String paramString, int paramInt2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = aqha.a(this.val$activity);
    if (paramArrayOfString != null) {
      paramArrayOfString.setOnDismissListener(new aity(this));
    }
    aiqs.a(this.val$activity.app).f(this.deX, this.bfK, this.val$from, 1);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LocationShareFragment.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aitx
 * JD-Core Version:    0.7.0.1
 */