import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import mqq.app.QQPermissionCallback;

public class aawv
  implements QQPermissionCallback
{
  public aawv(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity, int paramInt) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = this.this$0.mHandler.obtainMessage(2);
    paramArrayOfString.arg1 = 1;
    paramArrayOfString.arg2 = 2131701274;
    paramArrayOfString.sendToTarget();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    CreateFaceToFaceDiscussionActivity.b(this.this$0, this.PJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aawv
 * JD-Core Version:    0.7.0.1
 */