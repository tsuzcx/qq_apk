import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import cooperation.plugin.IPluginManager;

public final class fmf
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if ((IPluginManager.a() != null) && (IPluginManager.a().isShowing())) {
      IPluginManager.a().dismiss();
    }
    IPluginManager.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fmf
 * JD-Core Version:    0.7.0.1
 */