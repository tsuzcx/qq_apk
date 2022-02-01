import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class uya
{
  public static void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Intent paramIntent, String paramString, boolean paramBoolean)
  {
    if ((!"msg_tab_camera".equals(paramString)) || (paramIntent == null)) {
      return;
    }
    avpw.a(paramFragmentActivity, paramQQAppInterface, paramIntent, 20005, paramBoolean);
  }
  
  public static void bOl()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), JumpActivity.class);
    localIntent.addFlags(268435456);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    localIntent.addFlags(131072);
    localIntent.setData(Uri.parse("mqqapi://qzone/to_friend_feeds"));
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uya
 * JD-Core Version:    0.7.0.1
 */