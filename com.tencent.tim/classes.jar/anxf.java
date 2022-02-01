import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studyroom.utils.PluginUtils.1;
import com.tencent.shadow.dynamic.host.EnterCallback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class anxf
{
  public static Future<?> a(Context paramContext, Bundle paramBundle, boolean paramBoolean, anxf.a parama)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramBundle.putString("qqVersion", "3.4.4");
    paramBundle.putString("bizType", "StudyRoom");
    paramBundle.putString("plugin_id", "StudyRoom");
    paramBundle.putString("appid", "101854111");
    paramBundle.putInt("authtype", 1);
    paramBundle.putInt("isGroupCode", 1);
    paramBundle.putInt("roomCodeType", 1);
    paramBundle.putString("uin", localQQAppInterface.getCurrentUin());
    paramBundle.putBoolean("preload", paramBoolean);
    paramBundle.putString("fromId", "1");
    paramBundle.putLong("ts_click_millisecond", System.currentTimeMillis());
    paramBundle.putBoolean("show_status_bar", true);
    return acmo.a(192).submit(new PluginUtils.1(paramContext, paramBundle, parama));
  }
  
  public static abstract interface a
    extends EnterCallback
  {
    public abstract void onError(Throwable paramThrowable);
  }
  
  public static class b
    implements anxf.a
  {
    public void onCloseLoadingView() {}
    
    public void onEnterComplete() {}
    
    public void onError(Throwable paramThrowable) {}
    
    public void onShowLoadingView(View paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anxf
 * JD-Core Version:    0.7.0.1
 */