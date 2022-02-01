import android.content.Context;
import com.tencent.qphone.base.util.QLog;

final class avfx
  implements avfw.b
{
  avfx(avfw.a parama) {}
  
  public void a(boolean paramBoolean, Context paramContext, avfw.d paramd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "openActivityForResult onPluginReady." + paramBoolean);
    }
    if (paramBoolean) {
      avfw.d(paramContext, paramd);
    }
    if (this.a != null) {
      this.a.Wz(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfx
 * JD-Core Version:    0.7.0.1
 */