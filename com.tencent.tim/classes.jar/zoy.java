import com.tencent.mobileqq.activity.ProfileActivity;
import mqq.app.QQPermissionCallback;

class zoy
  implements QQPermissionCallback
{
  zoy(zow paramzow) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(this.a.this$0, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.this$0.x = ProfileActivity.a(this.a.this$0, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zoy
 * JD-Core Version:    0.7.0.1
 */