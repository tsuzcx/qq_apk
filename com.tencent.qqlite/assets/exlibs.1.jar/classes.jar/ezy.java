import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.qphone.base.util.QLog;

public class ezy
  implements Runnable
{
  public ezy(AuthorityActivity paramAuthorityActivity) {}
  
  public void run()
  {
    Object localObject = this.a;
    int i = ((AuthorityActivity)localObject).y;
    ((AuthorityActivity)localObject).y = (i - 1);
    if (i > 0)
    {
      localObject = (String)this.a.getResources().getText(2131363842);
      AuthorityActivity localAuthorityActivity = this.a;
      i = localAuthorityActivity.z;
      localAuthorityActivity.z = (i + 1);
      switch (i % 3)
      {
      }
      for (;;)
      {
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.b, 500L);
        return;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "·  ");
        continue;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "·· ");
        continue;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "···");
      }
    }
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.a.g = true;
    this.a.h = false;
    if (this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKQQAgentPref", 2, "AutoAuth:" + SystemClock.elapsedRealtime());
      }
      localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPref", 2, "AutoAuth -- doAuthorize(): " + SystemClock.elapsedRealtime());
    }
    this.a.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ezy
 * JD-Core Version:    0.7.0.1
 */