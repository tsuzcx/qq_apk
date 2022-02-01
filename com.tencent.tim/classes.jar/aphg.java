import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import mqq.app.QQPermissionCallback;

public class aphg
  implements QQPermissionCallback
{
  public aphg(PublishHomeWorkFragment paramPublishHomeWorkFragment, int paramInt) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.b(this.this$0.getActivity());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = TroopHWJsPlugin.a(10 - this.val$num, this.this$0.getActivity(), this.this$0.mApp.getCurrentAccountUin());
    paramArrayOfString.putExtra("HomeWorkConstants:homework_request_code_key", 259);
    this.this$0.startActivityForResult(paramArrayOfString, 259);
    aurd.cE(this.this$0.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aphg
 * JD-Core Version:    0.7.0.1
 */