import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.utils.NetworkUtil;

public class xyf
  extends BroadcastReceiver
{
  public xyf(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((NetworkUtil.d(this.a.jdField_a_of_type_AndroidContentContext)) && (this.a.c) && (this.a.isResume()))
    {
      if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xyf
 * JD-Core Version:    0.7.0.1
 */