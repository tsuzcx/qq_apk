import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class avxo
  implements avxl.a
{
  public void a(boolean paramBoolean, Context paramContext, avxl.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "launchPluginBroadcast onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      avxl.c(paramContext, paramb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxo
 * JD-Core Version:    0.7.0.1
 */