import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;

public class ahig
  extends ahgq
{
  public ahig(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private void cx(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("miniAppShareIsComplete", true);
    localBundle.putInt("uintype", paramInt);
    localBundle.putString("uin", paramString);
    localBundle.putString("miniAppShareAppid", this.bf.getString("miniAppShareAppid"));
    localBundle.putString("miniAppShareTemplateId", this.bf.getString("miniAppShareTemplateId"));
    localBundle.putInt("miniAppShareAppType", this.bf.getInt("miniAppShareAppType"));
    localBundle.putString("miniAppShareEvent", this.bf.getString("miniAppShareEvent"));
    localBundle.putInt("miniAppShareCallbackId", this.bf.getInt("miniAppShareCallbackId"));
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_create_updatable_msg_callback", localBundle, null);
  }
  
  private void cy(int paramInt, String paramString)
  {
    paramString = wja.a(new Intent(this.mActivity, SplashActivity.class), new int[] { 2 }).putExtra("uintype", paramInt).putExtra("uin", paramString);
    this.mActivity.startActivity(paramString);
  }
  
  public void H(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e("ForwardMiniAppUpdatableMsgOption", 2, "buildForwardDialog, error, extra is null");
      this.mActivity.finish();
      return;
    }
    paramInt = paramBundle.getInt("uintype");
    String str = paramBundle.getString("uin");
    paramBundle = paramBundle.getString("uinname");
    QLog.d("ForwardMiniAppUpdatableMsgOption", 2, "buildForwardDialog, name:" + paramBundle + ", uinType:" + paramInt + ", uin:" + str);
    cx(paramInt, str);
    cy(paramInt, str);
    this.mActivity.finish();
  }
  
  public void Kp(boolean paramBoolean)
  {
    QLog.d("ForwardMiniAppUpdatableMsgOption", 2, "endForwardCallback, isCompleted:" + paramBoolean);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("miniAppShareIsComplete", false);
    localBundle.putString("miniAppShareAppid", this.bf.getString("miniAppShareAppid"));
    localBundle.putString("miniAppShareTemplateId", this.bf.getString("miniAppShareTemplateId"));
    localBundle.putInt("miniAppShareAppType", this.bf.getInt("miniAppShareAppType"));
    localBundle.putString("miniAppShareEvent", this.bf.getString("miniAppShareEvent"));
    localBundle.putInt("miniAppShareCallbackId", this.bf.getInt("miniAppShareCallbackId"));
    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_create_updatable_msg_callback", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahig
 * JD-Core Version:    0.7.0.1
 */