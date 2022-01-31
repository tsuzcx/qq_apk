import android.content.Context;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;

public final class fkw
  extends Thread
{
  public fkw(Context paramContext, OnPluginInstallListener paramOnPluginInstallListener) {}
  
  public void run()
  {
    PluginManagerHelper.getPluginInterface(this.jdField_a_of_type_AndroidContentContext, new fkx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fkw
 * JD-Core Version:    0.7.0.1
 */