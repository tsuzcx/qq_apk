import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.widget.QFavDownloadProgressDialog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;

public final class fmg
  implements View.OnClickListener
{
  public fmg(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener) {}
  
  public void onClick(View paramView)
  {
    IPluginManager.a(IPluginManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b));
    IPluginManager.a().show();
    IPluginManager.a().installPlugin(this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.b, new fmh(this));
    if ((IPluginManager.a() != null) && (IPluginManager.a().isShowing()))
    {
      IPluginManager.a().dismiss();
      IPluginManager.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fmg
 * JD-Core Version:    0.7.0.1
 */