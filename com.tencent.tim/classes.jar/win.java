import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.BaseActivity;

public class win
{
  public static boolean QZ()
  {
    boolean bool = false;
    BaseChatPie localBaseChatPie = b();
    if (localBaseChatPie != null) {
      bool = ((AIOLongShotHelper)localBaseChatPie.a(15)).RS();
    }
    return bool;
  }
  
  public static boolean Ra()
  {
    return QZ();
  }
  
  public static BaseChatPie b()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)localObject).getChatFragment();
      if (localObject != null) {
        return ((ChatFragment)localObject).a();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     win
 * JD-Core Version:    0.7.0.1
 */