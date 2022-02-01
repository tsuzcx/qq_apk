import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import mqq.app.QQPermissionCallback;

public class vbe
  implements QQPermissionCallback
{
  public vbe(FriendProfileImageActivity paramFriendProfileImageActivity, String paramString) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(this.this$0, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    FriendProfileImageActivity.b(this.this$0, this.val$filePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vbe
 * JD-Core Version:    0.7.0.1
 */