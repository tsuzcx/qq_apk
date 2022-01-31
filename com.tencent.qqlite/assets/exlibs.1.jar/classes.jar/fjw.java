import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.widget.QFavDownloadProgressDialog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;

class fjw
  extends OnPluginInstallListener.Stub
{
  fjw(fjv paramfjv) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if ((IPluginManager.a() != null) && (IPluginManager.a().isShowing()))
    {
      IPluginManager.a().c(paramInt2);
      IPluginManager.a().b(paramInt1);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (this.a.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null) {
      this.a.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener.a(false, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
    }
    if (IPluginManager.a() != null) {
      IPluginManager.a().dismiss();
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (this.a.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener != null)
    {
      this.a.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener.a(true, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
      if (!this.a.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.e.equals("com.qqfav.activity.FavoritesListActivity")) {
        new fjx(this, this.a.jdField_a_of_type_AndroidContentContext.getMainLooper()).sendEmptyMessage(1);
      }
    }
    if (IPluginManager.a() != null) {
      IPluginManager.a().dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fjw
 * JD-Core Version:    0.7.0.1
 */