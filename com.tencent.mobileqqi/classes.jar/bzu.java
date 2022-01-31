import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.qlink.QQProxyForQlink.Listener;

public class bzu
  extends QQProxyForQlink.Listener
{
  private bzu(ChatActivity paramChatActivity) {}
  
  protected void a(String paramString)
  {
    if (paramString == null) {}
    while (!this.a.a.a.equalsIgnoreCase(paramString)) {
      return;
    }
    Object localObject = new bzv(this);
    paramString = new bzw(this);
    localObject = DialogUtil.a(this.a, 230, null, this.a.getString(2131560936), 2131563227, 2131560937, (DialogInterface.OnClickListener)localObject, null);
    ((QQCustomDialog)localObject).setOnDismissListener(paramString);
    ((QQCustomDialog)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bzu
 * JD-Core Version:    0.7.0.1
 */