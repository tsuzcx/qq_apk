import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class ybu
  extends acfd
{
  ybu(ybt paramybt) {}
  
  protected void onAddFriend(String paramString)
  {
    if (this.this$0.sessionInfo.aTl.equals(paramString))
    {
      Intent localIntent = this.this$0.mActivity.getIntent();
      localIntent.putExtra("uintype", 0);
      ybt.b(this.this$0, localIntent);
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG + "Q.nearby.follow", 2, "onAddFriend, addUin:" + paramString + "|updateSession");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybu
 * JD-Core Version:    0.7.0.1
 */