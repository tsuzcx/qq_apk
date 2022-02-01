import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class avgb
  implements avfw.b
{
  public void a(boolean paramBoolean, Context paramContext, avfw.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginService onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      avfw.f(paramContext, paramd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgb
 * JD-Core Version:    0.7.0.1
 */