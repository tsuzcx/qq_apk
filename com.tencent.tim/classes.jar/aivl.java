import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class aivl
{
  private aivl.a a;
  private final QQAppInterface app;
  private BroadcastReceiver bt = new aivm(this);
  
  public aivl(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    BaseApplicationImpl.getContext().registerReceiver(this.bt, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.tim.msg.permission.pushnotify", null);
  }
  
  public void a(aivl.a parama)
  {
    this.a = parama;
  }
  
  public void destroy()
  {
    BaseApplicationImpl.getContext().unregisterReceiver(this.bt);
  }
  
  public static abstract interface a
  {
    public abstract void onThemeChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aivl
 * JD-Core Version:    0.7.0.1
 */