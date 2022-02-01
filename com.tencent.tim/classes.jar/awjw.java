import android.app.Activity;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import mqq.app.QQPermissionCallback;

public class awjw
  implements QQPermissionCallback
{
  public awjw(TroopHWJsPlugin paramTroopHWJsPlugin, Activity paramActivity, int paramInt) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(this.val$activity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.this$0.aFT = TroopHWJsPlugin.c(this.val$activity, this.val$requestCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjw
 * JD-Core Version:    0.7.0.1
 */