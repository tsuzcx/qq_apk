import android.app.Dialog;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.ui.LocationPickFragment;
import mqq.app.QQPermissionCallback;

public class aisq
  implements QQPermissionCallback
{
  public aisq(LocationPickFragment paramLocationPickFragment, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = aqha.a(this.val$activity);
    if (paramArrayOfString != null) {
      paramArrayOfString.setOnDismissListener(new aisr(this));
    }
    paramArrayOfInt = this.val$activity.getIntent();
    paramArrayOfString = paramArrayOfInt.getStringExtra("uin");
    paramInt = paramArrayOfInt.getIntExtra("uintype", -1);
    paramArrayOfInt = aiqs.a(this.val$activity.app);
    paramArrayOfInt.f(paramInt, paramArrayOfString, paramArrayOfInt.getFrom(), 1);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    LocationPickFragment.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aisq
 * JD-Core Version:    0.7.0.1
 */