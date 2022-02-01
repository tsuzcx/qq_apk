import com.tencent.mobileqq.activity.NearbyActivity;
import mqq.app.QQPermissionCallback;

public class vhu
  implements QQPermissionCallback
{
  public vhu(NearbyActivity paramNearbyActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(this.this$0, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.this$0.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhu
 * JD-Core Version:    0.7.0.1
 */